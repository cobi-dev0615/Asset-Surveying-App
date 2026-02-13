package com.megster.cordova;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: classes.dex */
public class BluetoothSerialService {
    private static final boolean D = true;
    private static final String NAME_INSECURE = "PhoneGapBluetoothSerialServiceInSecure";
    private static final String NAME_SECURE = "PhoneGapBluetoothSerialServiceSecure";
    public static final int STATE_CONNECTED = 3;
    public static final int STATE_CONNECTING = 2;
    public static final int STATE_LISTEN = 1;
    public static final int STATE_NONE = 0;
    private static final String TAG = "BluetoothSerialService";
    private ConnectThread mConnectThread;
    private ConnectedThread mConnectedThread;
    private final Handler mHandler;
    private AcceptThread mInsecureAcceptThread;
    private AcceptThread mSecureAcceptThread;
    private static final UUID MY_UUID_SECURE = UUID.fromString("7A9C3B55-78D0-44A7-A94E-A93E3FE118CE");
    private static final UUID MY_UUID_INSECURE = UUID.fromString("23F18142-B389-4772-93BD-52BDBB2C03E9");
    private static final UUID UUID_SPP = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private final BluetoothAdapter mAdapter = BluetoothAdapter.getDefaultAdapter();
    private int mState = 0;

    public BluetoothSerialService(Handler handler) {
        this.mHandler = handler;
    }

    private synchronized void setState(int state) {
        Log.d(TAG, "setState() " + this.mState + " -> " + state);
        this.mState = state;
        this.mHandler.obtainMessage(1, state, -1).sendToTarget();
    }

    public synchronized int getState() {
        return this.mState;
    }

    public synchronized void start() {
        Log.d(TAG, "start");
        ConnectThread connectThread = this.mConnectThread;
        if (connectThread != null) {
            connectThread.cancel();
            this.mConnectThread = null;
        }
        ConnectedThread connectedThread = this.mConnectedThread;
        if (connectedThread != null) {
            connectedThread.cancel();
            this.mConnectedThread = null;
        }
        setState(0);
    }

    public synchronized void connect(BluetoothDevice device, boolean secure) {
        ConnectThread connectThread;
        Log.d(TAG, "connect to: " + device);
        if (this.mState == 2 && (connectThread = this.mConnectThread) != null) {
            connectThread.cancel();
            this.mConnectThread = null;
        }
        ConnectedThread connectedThread = this.mConnectedThread;
        if (connectedThread != null) {
            connectedThread.cancel();
            this.mConnectedThread = null;
        }
        ConnectThread connectThread2 = new ConnectThread(device, secure);
        this.mConnectThread = connectThread2;
        connectThread2.start();
        setState(2);
    }

    public synchronized void connected(BluetoothSocket socket, BluetoothDevice device, final String socketType) {
        Log.d(TAG, "connected, Socket Type:" + socketType);
        ConnectThread connectThread = this.mConnectThread;
        if (connectThread != null) {
            connectThread.cancel();
            this.mConnectThread = null;
        }
        ConnectedThread connectedThread = this.mConnectedThread;
        if (connectedThread != null) {
            connectedThread.cancel();
            this.mConnectedThread = null;
        }
        AcceptThread acceptThread = this.mSecureAcceptThread;
        if (acceptThread != null) {
            acceptThread.cancel();
            this.mSecureAcceptThread = null;
        }
        AcceptThread acceptThread2 = this.mInsecureAcceptThread;
        if (acceptThread2 != null) {
            acceptThread2.cancel();
            this.mInsecureAcceptThread = null;
        }
        ConnectedThread connectedThread2 = new ConnectedThread(socket, socketType);
        this.mConnectedThread = connectedThread2;
        connectedThread2.start();
        Message obtainMessage = this.mHandler.obtainMessage(4);
        Bundle bundle = new Bundle();
        bundle.putString(BluetoothSerial.DEVICE_NAME, device.getName());
        obtainMessage.setData(bundle);
        this.mHandler.sendMessage(obtainMessage);
        setState(3);
    }

    public synchronized void stop() {
        Log.d(TAG, "stop");
        ConnectThread connectThread = this.mConnectThread;
        if (connectThread != null) {
            connectThread.cancel();
            this.mConnectThread = null;
        }
        ConnectedThread connectedThread = this.mConnectedThread;
        if (connectedThread != null) {
            connectedThread.cancel();
            this.mConnectedThread = null;
        }
        AcceptThread acceptThread = this.mSecureAcceptThread;
        if (acceptThread != null) {
            acceptThread.cancel();
            this.mSecureAcceptThread = null;
        }
        AcceptThread acceptThread2 = this.mInsecureAcceptThread;
        if (acceptThread2 != null) {
            acceptThread2.cancel();
            this.mInsecureAcceptThread = null;
        }
        setState(0);
    }

    public void write(byte[] out) {
        synchronized (this) {
            if (this.mState != 3) {
                return;
            }
            this.mConnectedThread.write(out);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectionFailed() {
        Message obtainMessage = this.mHandler.obtainMessage(5);
        Bundle bundle = new Bundle();
        bundle.putString(BluetoothSerial.TOAST, "Unable to connect to device");
        obtainMessage.setData(bundle);
        this.mHandler.sendMessage(obtainMessage);
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectionLost() {
        Message obtainMessage = this.mHandler.obtainMessage(5);
        Bundle bundle = new Bundle();
        bundle.putString(BluetoothSerial.TOAST, "Device connection was lost");
        obtainMessage.setData(bundle);
        this.mHandler.sendMessage(obtainMessage);
        start();
    }

    private class AcceptThread extends Thread {
        private String mSocketType;
        private final BluetoothServerSocket mmServerSocket;

        public AcceptThread(boolean secure) {
            BluetoothServerSocket bluetoothServerSocket;
            this.mSocketType = secure ? "Secure" : "Insecure";
            try {
                bluetoothServerSocket = secure ? BluetoothSerialService.this.mAdapter.listenUsingRfcommWithServiceRecord(BluetoothSerialService.NAME_SECURE, BluetoothSerialService.MY_UUID_SECURE) : BluetoothSerialService.this.mAdapter.listenUsingInsecureRfcommWithServiceRecord(BluetoothSerialService.NAME_INSECURE, BluetoothSerialService.MY_UUID_INSECURE);
            } catch (IOException e) {
                Log.e(BluetoothSerialService.TAG, "Socket Type: " + this.mSocketType + "listen() failed", e);
                bluetoothServerSocket = null;
            }
            this.mmServerSocket = bluetoothServerSocket;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(6:10|11|(3:13|(1:23)(1:(1:18))|19)|24|25|19) */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x006b, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x006c, code lost:
        
            android.util.Log.e(com.megster.cordova.BluetoothSerialService.TAG, "Could not close unwanted socket", r0);
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r5 = this;
                java.lang.String r0 = "BluetoothSerialService"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Socket Type: "
                r1.append(r2)
                java.lang.String r2 = r5.mSocketType
                r1.append(r2)
                java.lang.String r2 = "BEGIN mAcceptThread"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r1 = r1.toString()
                android.util.Log.d(r0, r1)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "AcceptThread"
                r0.append(r1)
                java.lang.String r1 = r5.mSocketType
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r5.setName(r0)
            L36:
                com.megster.cordova.BluetoothSerialService r0 = com.megster.cordova.BluetoothSerialService.this
                int r0 = com.megster.cordova.BluetoothSerialService.access$300(r0)
                r1 = 3
                if (r0 == r1) goto L96
                android.bluetooth.BluetoothServerSocket r0 = r5.mmServerSocket     // Catch: java.io.IOException -> L78
                android.bluetooth.BluetoothSocket r0 = r0.accept()     // Catch: java.io.IOException -> L78
                if (r0 == 0) goto L36
                com.megster.cordova.BluetoothSerialService r2 = com.megster.cordova.BluetoothSerialService.this
                monitor-enter(r2)
                com.megster.cordova.BluetoothSerialService r3 = com.megster.cordova.BluetoothSerialService.this     // Catch: java.lang.Throwable -> L75
                int r3 = com.megster.cordova.BluetoothSerialService.access$300(r3)     // Catch: java.lang.Throwable -> L75
                if (r3 == 0) goto L67
                r4 = 1
                if (r3 == r4) goto L5b
                r4 = 2
                if (r3 == r4) goto L5b
                if (r3 == r1) goto L67
                goto L73
            L5b:
                com.megster.cordova.BluetoothSerialService r1 = com.megster.cordova.BluetoothSerialService.this     // Catch: java.lang.Throwable -> L75
                android.bluetooth.BluetoothDevice r3 = r0.getRemoteDevice()     // Catch: java.lang.Throwable -> L75
                java.lang.String r4 = r5.mSocketType     // Catch: java.lang.Throwable -> L75
                r1.connected(r0, r3, r4)     // Catch: java.lang.Throwable -> L75
                goto L73
            L67:
                r0.close()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L75
                goto L73
            L6b:
                r0 = move-exception
                java.lang.String r1 = "BluetoothSerialService"
                java.lang.String r3 = "Could not close unwanted socket"
                android.util.Log.e(r1, r3, r0)     // Catch: java.lang.Throwable -> L75
            L73:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L75
                goto L36
            L75:
                r0 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L75
                throw r0
            L78:
                r0 = move-exception
                java.lang.String r1 = "BluetoothSerialService"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Socket Type: "
                r2.append(r3)
                java.lang.String r3 = r5.mSocketType
                r2.append(r3)
                java.lang.String r3 = "accept() failed"
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                android.util.Log.e(r1, r2, r0)
            L96:
                java.lang.String r0 = "BluetoothSerialService"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "END mAcceptThread, socket Type: "
                r1.append(r2)
                java.lang.String r2 = r5.mSocketType
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                android.util.Log.i(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.megster.cordova.BluetoothSerialService.AcceptThread.run():void");
        }

        public void cancel() {
            Log.d(BluetoothSerialService.TAG, "Socket Type" + this.mSocketType + "cancel " + this);
            try {
                this.mmServerSocket.close();
            } catch (IOException e) {
                Log.e(BluetoothSerialService.TAG, "Socket Type" + this.mSocketType + "close() of server failed", e);
            }
        }
    }

    private class ConnectThread extends Thread {
        private String mSocketType;
        private final BluetoothDevice mmDevice;
        private BluetoothSocket mmSocket;

        public ConnectThread(BluetoothDevice device, boolean secure) {
            BluetoothSocket bluetoothSocket;
            this.mmDevice = device;
            this.mSocketType = secure ? "Secure" : "Insecure";
            try {
                bluetoothSocket = secure ? device.createRfcommSocketToServiceRecord(BluetoothSerialService.UUID_SPP) : device.createInsecureRfcommSocketToServiceRecord(BluetoothSerialService.UUID_SPP);
            } catch (IOException e) {
                Log.e(BluetoothSerialService.TAG, "Socket Type: " + this.mSocketType + "create() failed", e);
                bluetoothSocket = null;
            }
            this.mmSocket = bluetoothSocket;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Log.i(BluetoothSerialService.TAG, "BEGIN mConnectThread SocketType:" + this.mSocketType);
            setName("ConnectThread" + this.mSocketType);
            BluetoothSerialService.this.mAdapter.cancelDiscovery();
            try {
                Log.i(BluetoothSerialService.TAG, "Connecting to socket...");
                this.mmSocket.connect();
                Log.i(BluetoothSerialService.TAG, "Connected");
            } catch (IOException e) {
                Log.e(BluetoothSerialService.TAG, e.toString());
                try {
                    Log.i(BluetoothSerialService.TAG, "Trying fallback...");
                    BluetoothSocket bluetoothSocket = (BluetoothSocket) this.mmDevice.getClass().getMethod("createRfcommSocket", Integer.TYPE).invoke(this.mmDevice, 1);
                    this.mmSocket = bluetoothSocket;
                    bluetoothSocket.connect();
                    Log.i(BluetoothSerialService.TAG, "Connected");
                } catch (Exception unused) {
                    Log.e(BluetoothSerialService.TAG, "Couldn't establish a Bluetooth connection.");
                    try {
                        this.mmSocket.close();
                    } catch (IOException e2) {
                        Log.e(BluetoothSerialService.TAG, "unable to close() " + this.mSocketType + " socket during connection failure", e2);
                    }
                    BluetoothSerialService.this.connectionFailed();
                    return;
                }
            }
            synchronized (BluetoothSerialService.this) {
                BluetoothSerialService.this.mConnectThread = null;
            }
            BluetoothSerialService.this.connected(this.mmSocket, this.mmDevice, this.mSocketType);
        }

        public void cancel() {
            try {
                this.mmSocket.close();
            } catch (IOException e) {
                Log.e(BluetoothSerialService.TAG, "close() of connect " + this.mSocketType + " socket failed", e);
            }
        }
    }

    private class ConnectedThread extends Thread {
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;
        private final BluetoothSocket mmSocket;

        public ConnectedThread(BluetoothSocket socket, String socketType) {
            InputStream inputStream;
            Log.d(BluetoothSerialService.TAG, "create ConnectedThread: " + socketType);
            this.mmSocket = socket;
            OutputStream outputStream = null;
            try {
                inputStream = socket.getInputStream();
            } catch (IOException e) {
                e = e;
                inputStream = null;
            }
            try {
                outputStream = socket.getOutputStream();
            } catch (IOException e2) {
                e = e2;
                Log.e(BluetoothSerialService.TAG, "temp sockets not created", e);
                this.mmInStream = inputStream;
                this.mmOutStream = outputStream;
            }
            this.mmInStream = inputStream;
            this.mmOutStream = outputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Log.i(BluetoothSerialService.TAG, "BEGIN mConnectedThread");
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int read = this.mmInStream.read(bArr);
                    BluetoothSerialService.this.mHandler.obtainMessage(2, new String(bArr, 0, read)).sendToTarget();
                    if (read > 0) {
                        BluetoothSerialService.this.mHandler.obtainMessage(6, Arrays.copyOf(bArr, read)).sendToTarget();
                    }
                } catch (IOException e) {
                    Log.e(BluetoothSerialService.TAG, "disconnected", e);
                    BluetoothSerialService.this.connectionLost();
                    BluetoothSerialService.this.start();
                    return;
                }
            }
        }

        public void write(byte[] buffer) {
            try {
                this.mmOutStream.write(buffer);
                BluetoothSerialService.this.mHandler.obtainMessage(3, -1, -1, buffer).sendToTarget();
            } catch (IOException e) {
                Log.e(BluetoothSerialService.TAG, "Exception during write", e);
            }
        }

        public void cancel() {
            try {
                this.mmSocket.close();
            } catch (IOException e) {
                Log.e(BluetoothSerialService.TAG, "close() of connect socket failed", e);
            }
        }
    }
}
