package com.gg.reader.api.dal.communication;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.os.Handler;
import com.gg.reader.api.protocol.gx.Message;
import com.gg.reader.api.protocol.gx.MsgAppGetBaseVersion;
import com.gg.reader.api.utils.GLog;
import com.gg.reader.api.utils.ThreadPoolUtils;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class AndroidUsbHidClient extends CommunicationInterface {
    private static final String ACTION_USB_PERMISSION = "com.android.gx.USB_PERMISSION";
    public OnUsbHidDeviceListener deviceListener;
    private UsbDeviceConnection mConnection;
    private Context mContext;
    private Handler mHandler;
    private UsbEndpoint mInUsbEndpoint;
    private UsbEndpoint mOutUsbEndpoint;
    private UsbDevice mUsbDevice;
    private UsbInterface mUsbInterface;
    private UsbManager mUsbManager;
    private String mUsbName;
    public OnUsbHidStateListener stateListener;
    private int readTimeout = 1000;
    private int writeTimeout = 1000;
    private final BroadcastReceiver mUsbReceiver = new BroadcastReceiver() { // from class: com.gg.reader.api.dal.communication.AndroidUsbHidClient.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AndroidUsbHidClient.ACTION_USB_PERMISSION.equals(intent.getAction())) {
                context.unregisterReceiver(this);
                synchronized (this) {
                    UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                    if (!intent.getBooleanExtra("permission", false) || usbDevice == null) {
                        AndroidUsbHidClient.this.onConnectFailed();
                    } else {
                        AndroidUsbHidClient.this.openDevice();
                    }
                }
            }
        }
    };
    private final BroadcastReceiver mUsbStateChange = new BroadcastReceiver() { // from class: com.gg.reader.api.dal.communication.AndroidUsbHidClient.5
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
                if (AndroidUsbHidClient.this.stateListener != null) {
                    AndroidUsbHidClient.this.stateListener.onDeviceAttached();
                }
            } else {
                if (!"android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action) || AndroidUsbHidClient.this.stateListener == null) {
                    return;
                }
                AndroidUsbHidClient.this.stateListener.onDeviceDetached();
            }
        }
    };

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void dispose() {
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public boolean open(String str, int i) {
        return false;
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public boolean open(String str, int i, int i2) {
        return false;
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public boolean open(Socket socket) {
        return false;
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public int receive(byte[] bArr) {
        return 0;
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public boolean setBufferSize(int i) {
        return false;
    }

    public static Map<String, AndroidUsbHidClient> enumerate(Context context, int i, int i2) {
        UsbManager usbManager = (UsbManager) context.getApplicationContext().getSystemService("usb");
        if (usbManager == null) {
            return null;
        }
        HashMap<String, UsbDevice> deviceList = usbManager.getDeviceList();
        HashMap hashMap = new HashMap();
        for (String str : deviceList.keySet()) {
            UsbDevice usbDevice = deviceList.get(str);
            if (usbDevice != null && usbDevice.getVendorId() == i) {
                if (usbDevice.getProductId() == i2) {
                    for (int i3 = 0; i3 < usbDevice.getInterfaceCount(); i3++) {
                        UsbInterface usbInterface = usbDevice.getInterface(i3);
                        if (usbInterface.getInterfaceClass() == 3 && usbInterface.getInterfaceProtocol() == 0) {
                            hashMap.put(str, new AndroidUsbHidClient(usbDevice, usbInterface, usbManager, context, str));
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public static Map<String, AndroidUsbHidClient> enumerate(Context context) {
        UsbManager usbManager = (UsbManager) context.getApplicationContext().getSystemService("usb");
        if (usbManager == null) {
            return null;
        }
        HashMap<String, UsbDevice> deviceList = usbManager.getDeviceList();
        HashMap hashMap = new HashMap();
        for (String str : deviceList.keySet()) {
            UsbDevice usbDevice = deviceList.get(str);
            if (usbDevice != null && usbDevice.getVendorId() == 1003 && usbDevice.getProductId() == 9249) {
                for (int i = 0; i < usbDevice.getInterfaceCount(); i++) {
                    UsbInterface usbInterface = usbDevice.getInterface(i);
                    if (usbInterface.getInterfaceClass() == 3 && usbInterface.getInterfaceProtocol() == 0) {
                        hashMap.put(str, new AndroidUsbHidClient(usbDevice, usbInterface, usbManager, context, str));
                    }
                }
            }
        }
        return hashMap;
    }

    public static List<AndroidUsbHidClient> getUsbHidList(Context context) {
        Map<String, AndroidUsbHidClient> enumerate = enumerate(context);
        if (enumerate == null) {
            return null;
        }
        return new ArrayList(enumerate.values());
    }

    public static List<AndroidUsbHidClient> getUsbHidList(Context context, int i, int i2) {
        Map<String, AndroidUsbHidClient> enumerate = enumerate(context, i, i2);
        if (enumerate == null) {
            return null;
        }
        return new ArrayList(enumerate.values());
    }

    private AndroidUsbHidClient(UsbDevice usbDevice, UsbInterface usbInterface, UsbManager usbManager, Context context, String str) {
        this.mUsbDevice = usbDevice;
        this.mUsbInterface = usbInterface;
        this.mUsbManager = usbManager;
        this.mContext = context;
        this.mUsbName = str;
        for (int i = 0; i < this.mUsbInterface.getEndpointCount(); i++) {
            UsbEndpoint endpoint = this.mUsbInterface.getEndpoint(i);
            int direction = endpoint.getDirection();
            int type = endpoint.getType();
            if (this.mInUsbEndpoint == null && direction == 128 && type == 3) {
                this.mInUsbEndpoint = endpoint;
            }
            if (this.mOutUsbEndpoint == null && direction == 0 && type == 3) {
                this.mOutUsbEndpoint = endpoint;
            }
        }
    }

    public UsbDevice getUsbDevice() {
        return this.mUsbDevice;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public int getWriteTimeout() {
        return this.writeTimeout;
    }

    public void setWriteTimeout(int i) {
        this.writeTimeout = i;
    }

    public String getUsbName() {
        return this.mUsbName;
    }

    public void hasPermission() {
        this.mHandler = new Handler(this.mContext.getMainLooper());
        if (!this.mUsbManager.hasPermission(this.mUsbDevice)) {
            PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 0, new Intent(ACTION_USB_PERMISSION), 0);
            this.mContext.registerReceiver(this.mUsbReceiver, new IntentFilter(ACTION_USB_PERMISSION));
            this.mUsbManager.requestPermission(this.mUsbDevice, broadcast);
            return;
        }
        openDevice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openDevice() {
        UsbDeviceConnection openDevice = this.mUsbManager.openDevice(this.mUsbDevice);
        this.mConnection = openDevice;
        if (openDevice == null) {
            onConnectFailed();
            return;
        }
        if (!openDevice.claimInterface(this.mUsbInterface, true)) {
            onConnectFailed();
            return;
        }
        this.mConnection.setInterface(this.mUsbInterface);
        this.keepReceived = true;
        startReceive();
        startProcess();
        this.mHandler.post(new Runnable() { // from class: com.gg.reader.api.dal.communication.AndroidUsbHidClient.2
            @Override // java.lang.Runnable
            public void run() {
                if (AndroidUsbHidClient.this.deviceListener != null) {
                    AndroidUsbHidClient.this.send(new MsgAppGetBaseVersion());
                    AndroidUsbHidClient.this.send(new MsgAppGetBaseVersion());
                    AndroidUsbHidClient.this.deviceListener.onDeviceConnected(AndroidUsbHidClient.this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnectFailed() {
        this.mHandler.post(new Runnable() { // from class: com.gg.reader.api.dal.communication.AndroidUsbHidClient.3
            @Override // java.lang.Runnable
            public void run() {
                if (AndroidUsbHidClient.this.deviceListener != null) {
                    AndroidUsbHidClient.this.deviceListener.onDeviceConnectFailed(AndroidUsbHidClient.this);
                }
            }
        });
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public boolean open(String str) {
        hasPermission();
        return true;
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void close() {
        try {
            this.keepReceived = false;
            UsbDeviceConnection usbDeviceConnection = this.mConnection;
            if (usbDeviceConnection != null) {
                UsbInterface usbInterface = this.mUsbInterface;
                if (usbInterface != null) {
                    usbDeviceConnection.releaseInterface(usbInterface);
                }
                this.mConnection.close();
                this.mConnection = null;
            }
            synchronized (this.lockRingBuffer) {
                this.lockRingBuffer.notifyAll();
                this.ringBuffer.Clear();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void send(byte[] bArr) {
        synchronized (AndroidUsbHidClient.class) {
            try {
                int maxPacketSize = this.mOutUsbEndpoint.getMaxPacketSize();
                int length = bArr.length / maxPacketSize;
                if (bArr.length % maxPacketSize > 0) {
                    length++;
                }
                for (int i = 0; i < length; i++) {
                    int i2 = i * maxPacketSize;
                    byte[] copyOfRange = Arrays.copyOfRange(bArr, i2, maxPacketSize + i2);
                    this.mConnection.bulkTransfer(this.mOutUsbEndpoint, copyOfRange, copyOfRange.length, 0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void send(Message message) {
        synchronized (AndroidUsbHidClient.class) {
            try {
                if (this.isRs485) {
                    message.msgType.mt_13 = "1";
                    message.rs485Address = getRs485Address();
                }
                message.pack();
                send(message.toBytes(this.isRs485));
            } catch (Exception e) {
                GLog.e("[AndroidUsbHidClient]send error:" + e.getMessage());
            }
        }
    }

    public void startReceive() {
        ThreadPoolUtils.run(new Runnable() { // from class: com.gg.reader.api.dal.communication.AndroidUsbHidClient.4
            @Override // java.lang.Runnable
            public void run() {
                while (AndroidUsbHidClient.this.keepReceived) {
                    try {
                        int maxPacketSize = AndroidUsbHidClient.this.mInUsbEndpoint.getMaxPacketSize();
                        byte[] bArr = new byte[maxPacketSize];
                        int bulkTransfer = AndroidUsbHidClient.this.mConnection.bulkTransfer(AndroidUsbHidClient.this.mInUsbEndpoint, bArr, maxPacketSize, AndroidUsbHidClient.this.readTimeout);
                        if (bulkTransfer <= 0) {
                            Thread.sleep(50L);
                        } else {
                            synchronized (AndroidUsbHidClient.this.lockRingBuffer) {
                                while (AndroidUsbHidClient.this.ringBuffer.getDataCount() + bulkTransfer > 1048576) {
                                    AndroidUsbHidClient.this.lockRingBuffer.wait(10000L);
                                }
                                AndroidUsbHidClient.this.ringBuffer.WriteBuffer(bArr, 0, bulkTransfer);
                                AndroidUsbHidClient.this.lockRingBuffer.notify();
                            }
                        }
                    } catch (Exception unused) {
                        try {
                            Thread.sleep(3000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public void registerUsbState(Context context) {
        this.mUsbManager = (UsbManager) context.getSystemService("usb");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        context.registerReceiver(this.mUsbStateChange, intentFilter);
    }

    public void unregisterState(Context context) {
        context.unregisterReceiver(this.mUsbStateChange);
    }
}
