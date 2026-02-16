package com.gg.reader.api.dal.communication;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.gg.reader.api.dal.communication.BleClientCallback;
import com.gg.reader.api.protocol.gx.Message;
import com.gg.reader.api.utils.HexUtils;
import com.gg.reader.api.utils.StringUtils;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;

/* loaded from: classes2.dex */
public class BleBluetoothClient extends CommunicationInterface {
    private static final UUID DESCRIPTOR = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    private BluetoothAdapter adapter;
    private BluetoothGatt bluetoothGatt;
    public BleClientCallback.OnBlueConnectCallBack connectCallBack;
    private Context context;
    private BluetoothDevice device;
    private BluetoothGattCharacteristic mNotifyCharacteristic;
    private BluetoothGattCharacteristic mWriteCharacteristic;
    private BluetoothManager manager;
    public BleClientCallback.OnBlueScanCallBack scanCallBack;
    private final String TAG = BleBluetoothClient.class.getName();
    private UUID SERVER_UUID = UUID.fromString("0000fff0-0000-1000-8000-00805F9B34FB");
    private UUID NOTIFY_UUID = UUID.fromString("0000fff1-0000-1000-8000-00805F9B34FB");
    private UUID WRITE_UUID = UUID.fromString("0000fff2-0000-1000-8000-00805F9B34FB");
    private Queue<byte[]> dataInfoQueue = new LinkedList();
    private Map<String, BluetoothDevice> deviceMap = new HashMap();
    private Handler scanHandler = new Handler();
    private long writeTime = 50;
    private int mtu = 512;
    private boolean isPackage = false;
    BluetoothAdapter.LeScanCallback leScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: com.gg.reader.api.dal.communication.BleBluetoothClient.1
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            BleBluetoothClient.this.deviceMap.put(bluetoothDevice.getAddress(), bluetoothDevice);
            BleBluetoothClient.this.scanCallBack.onBlueFind(bluetoothDevice);
        }
    };
    private final Runnable mScanRunnable = new Runnable() { // from class: com.gg.reader.api.dal.communication.BleBluetoothClient.2
        @Override // java.lang.Runnable
        public void run() {
            BleBluetoothClient.this.scanBluetooth(false, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        }
    };
    BluetoothGattCallback mBluetoothGattCallback = new BluetoothGattCallback() { // from class: com.gg.reader.api.dal.communication.BleBluetoothClient.3
        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 != 2) {
                if (i2 == 0) {
                    Log.e(BleBluetoothClient.this.TAG, "STATE_DISCONNECTED");
                    BleBluetoothClient.this.connectCallBack.onDisconnect();
                    return;
                } else {
                    if (i2 == 3) {
                        Log.e(BleBluetoothClient.this.TAG, "STATE_DISCONNECTING");
                        return;
                    }
                    return;
                }
            }
            Log.e(BleBluetoothClient.this.TAG, "STATE_CONNECTED");
            BleBluetoothClient.this.bluetoothGatt.discoverServices();
            Log.e("requestMtu-->", BleBluetoothClient.this.requestMtu(bluetoothGatt) + "");
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i == 0) {
                BleBluetoothClient.this.connectCallBack.onConnectSuccess();
                BleBluetoothClient.this.enableTxNotification();
            } else {
                BleBluetoothClient.this.connectCallBack.onConnectFailure();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i != 0 || bluetoothGattCharacteristic.getValue().length <= 0) {
                return;
            }
            Log.e(BleBluetoothClient.this.TAG, "onCharacteristicRead" + Arrays.toString(bluetoothGattCharacteristic.getValue()));
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i != 0 || bluetoothGattCharacteristic.getValue().length <= 0) {
                return;
            }
            Log.e(BleBluetoothClient.this.TAG, "onCharacteristicWrite" + Arrays.toString(bluetoothGattCharacteristic.getValue()));
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (bluetoothGattCharacteristic.getValue().length <= 0) {
                Log.e(BleBluetoothClient.this.TAG, "receive data is null");
                return;
            }
            Log.e("ble receive--->", HexUtils.bytes2HexString(bluetoothGattCharacteristic.getValue()));
            try {
                byte[] value = bluetoothGattCharacteristic.getValue();
                synchronized (BleBluetoothClient.this.lockRingBuffer) {
                    while (value.length + BleBluetoothClient.this.ringBuffer.getDataCount() > 1048576) {
                        BleBluetoothClient.this.lockRingBuffer.wait(10000L);
                    }
                    BleBluetoothClient.this.ringBuffer.WriteBuffer(value, 0, value.length);
                    BleBluetoothClient.this.lockRingBuffer.notify();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        }
    };

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void dispose() {
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public boolean open(String str) {
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

    public BleBluetoothClient(Context context) {
        this.context = context;
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        this.manager = bluetoothManager;
        this.adapter = bluetoothManager.getAdapter();
    }

    public void setWriteTime(long j) {
        this.writeTime = j;
    }

    public boolean isSupportBle(Context context) {
        return (context == null || !context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") || this.adapter == null) ? false : true;
    }

    public boolean isBleEnable(Context context) {
        if (isSupportBle(context)) {
            return this.adapter.isEnabled();
        }
        return false;
    }

    public BluetoothAdapter getAdapter() {
        return this.adapter;
    }

    public UUID getSERVER_UUID() {
        return this.SERVER_UUID;
    }

    public void setSERVER_UUID(UUID uuid) {
        this.SERVER_UUID = uuid;
    }

    public UUID getNOTIFY_UUID() {
        return this.NOTIFY_UUID;
    }

    public void setNOTIFY_UUID(UUID uuid) {
        this.NOTIFY_UUID = uuid;
    }

    public UUID getWRITE_UUID() {
        return this.WRITE_UUID;
    }

    public void setWRITE_UUID(UUID uuid) {
        this.WRITE_UUID = uuid;
    }

    public void enableBluetooth() {
        this.adapter.enable();
    }

    public BluetoothGatt getBluetoothGatt() {
        return this.bluetoothGatt;
    }

    public void openBluetoothSetting() {
        Intent intent = new Intent();
        intent.setAction("android.settings.BLUETOOTH_SETTINGS");
        intent.setFlags(268435456);
        this.context.startActivity(intent);
    }

    public void scanBluetooth(boolean z, long j) {
        if (z) {
            if (this.adapter.isEnabled()) {
                this.scanHandler.postDelayed(this.mScanRunnable, j);
                this.adapter.startLeScan(this.leScanCallback);
                return;
            }
            return;
        }
        this.adapter.stopLeScan(this.leScanCallback);
        this.scanHandler.removeCallbacks(this.mScanRunnable);
    }

    public void stopScanBluetooth() {
        this.adapter.stopLeScan(this.leScanCallback);
    }

    public void enableTxNotification() {
        BluetoothGattService service = this.bluetoothGatt.getService(this.SERVER_UUID);
        this.mWriteCharacteristic = service.getCharacteristic(this.WRITE_UUID);
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(this.NOTIFY_UUID);
        this.mNotifyCharacteristic = characteristic;
        this.bluetoothGatt.setCharacteristicNotification(characteristic, true);
        BluetoothGattDescriptor descriptor = this.mNotifyCharacteristic.getDescriptor(DESCRIPTOR);
        if (descriptor != null) {
            if ((this.mNotifyCharacteristic.getProperties() & 16) > 0) {
                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            } else if ((this.mNotifyCharacteristic.getProperties() & 32) > 0) {
                descriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
            }
        }
        this.bluetoothGatt.writeDescriptor(descriptor);
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public boolean open(String str, int i) {
        if (StringUtils.isNullOfEmpty(str)) {
            return false;
        }
        if (this.adapter.isDiscovering()) {
            this.adapter.cancelDiscovery();
        }
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
            this.bluetoothGatt.discoverServices();
        }
        if (this.deviceMap.containsKey(str)) {
            this.device = this.deviceMap.get(str);
        } else {
            this.device = this.adapter.getRemoteDevice(str);
        }
        BluetoothDevice bluetoothDevice = this.device;
        if (bluetoothDevice == null) {
            return false;
        }
        this.bluetoothGatt = bluetoothDevice.connectGatt(this.context, i != 0, this.mBluetoothGattCallback);
        this.keepReceived = true;
        startProcess();
        return true;
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void close() {
        this.keepReceived = false;
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
            this.bluetoothGatt.close();
            this.mWriteCharacteristic = null;
            this.mNotifyCharacteristic = null;
            this.bluetoothGatt = null;
        }
        this.device = null;
        synchronized (this.lockRingBuffer) {
            this.lockRingBuffer.notifyAll();
        }
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void send(byte[] bArr) {
        byte[] bArr2;
        synchronized (BleBluetoothClient.class) {
            try {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = this.mWriteCharacteristic;
                if (bluetoothGattCharacteristic != null) {
                    if (this.isPackage) {
                        int length = bArr.length / 20;
                        if (bArr.length % 20 != 0) {
                            length++;
                        }
                        int length2 = bArr.length;
                        for (int i = 0; i < length; i++) {
                            if (length2 <= 20) {
                                bArr2 = new byte[length2];
                                System.arraycopy(bArr, i * 20, bArr2, 0, length2);
                            } else {
                                bArr2 = new byte[20];
                                length2 -= 20;
                                System.arraycopy(bArr, i * 20, bArr2, 0, 20);
                            }
                            this.mWriteCharacteristic.setValue(bArr2);
                            this.bluetoothGatt.writeCharacteristic(this.mWriteCharacteristic);
                            Thread.sleep(this.writeTime);
                        }
                    } else {
                        bluetoothGattCharacteristic.setValue(bArr);
                        this.bluetoothGatt.writeCharacteristic(this.mWriteCharacteristic);
                        Thread.sleep(this.writeTime);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void send(Message message) {
        synchronized (BleBluetoothClient.class) {
            try {
                message.pack();
                send(message.toBytes(this.isRs485));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean requestMtu(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt != null) {
            return bluetoothGatt.requestMtu(this.mtu);
        }
        return false;
    }

    public void setMtu(int i) {
        this.mtu = i;
    }

    public void setPartPackage(boolean z) {
        this.isPackage = z;
    }

    private void queueSend(byte[] bArr) {
        Queue<byte[]> queue = this.dataInfoQueue;
        if (queue != null) {
            queue.clear();
            Queue<byte[]> splitPacketFor20Byte = splitPacketFor20Byte(bArr);
            this.dataInfoQueue = splitPacketFor20Byte;
            if (splitPacketFor20Byte.peek() != null) {
                this.mWriteCharacteristic.setValue(this.dataInfoQueue.poll());
            }
        }
    }

    private Queue<byte[]> splitPacketFor20Byte(byte[] bArr) {
        byte[] bArr2;
        LinkedList linkedList = new LinkedList();
        if (bArr != null) {
            int i = 0;
            do {
                int length = bArr.length - i;
                byte[] bArr3 = new byte[length];
                System.arraycopy(bArr, i, bArr3, 0, bArr.length - i);
                if (length <= 20) {
                    bArr2 = new byte[length];
                    System.arraycopy(bArr3, 0, bArr2, 0, length);
                    i += length;
                } else {
                    byte[] bArr4 = new byte[20];
                    System.arraycopy(bArr, i, bArr4, 0, 20);
                    i += 20;
                    bArr2 = bArr4;
                }
                linkedList.offer(bArr2);
            } while (i < bArr.length);
        }
        return linkedList;
    }
}
