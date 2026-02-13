package com.gg.reader.api.dal.communication;

import cn.pda.serialport.SerialPort;
import com.gg.reader.api.protocol.gx.Message;
import com.gg.reader.api.utils.GLog;
import com.gg.reader.api.utils.ThreadPoolUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* loaded from: classes2.dex */
public class AndroidPdaSerialClient extends CommunicationInterface {
    private int baudrate;
    private int iDelay;
    private boolean isOpen;
    private InputStream mInputStream;
    private OutputStream mOutputStream;
    private SerialPort mSerialPort;
    private int port;
    private String sPort;

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

    public AndroidPdaSerialClient() {
        this.isOpen = false;
        this.iDelay = 100;
        this.sPort = "/dev/ttyMT1";
        this.port = 13;
        this.baudrate = 115200;
    }

    public AndroidPdaSerialClient(String str, int i) {
        this.isOpen = false;
        this.iDelay = 100;
        this.port = 13;
        this.sPort = str;
        this.baudrate = i;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void send(byte[] bArr) {
        synchronized (AndroidPdaSerialClient.class) {
            try {
                try {
                    this.mOutputStream.write(bArr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void send(Message message) {
        synchronized (AndroidPdaSerialClient.class) {
            try {
                if (this.isRs485) {
                    message.msgType.mt_13 = "1";
                    message.rs485Address = getRs485Address();
                }
                message.pack();
                send(message.toBytes(this.isRs485));
            } catch (Exception e) {
                GLog.e("[AndroidPdaSerialClient]base serial send error:" + e.getMessage());
            }
        }
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void dispose() {
        close();
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public boolean open(String str) {
        try {
            String[] split = str.split(":");
            if (split.length == 2) {
                this.port = Integer.parseInt(split[0]);
                this.baudrate = Integer.parseInt(split[1]);
                SerialPort serialPort = new SerialPort(this.port, this.baudrate, 0);
                this.mSerialPort = serialPort;
                this.mOutputStream = serialPort.getOutputStream();
                this.mInputStream = this.mSerialPort.getInputStream();
                this.isOpen = true;
                this.keepReceived = true;
                startReceive();
                startProcess();
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void close() {
        try {
            this.isOpen = false;
            this.keepReceived = false;
            SerialPort serialPort = this.mSerialPort;
            if (serialPort != null) {
                serialPort.close(this.port);
                this.mInputStream = null;
                this.mOutputStream = null;
                this.mSerialPort = null;
            }
            synchronized (this.lockRingBuffer) {
                this.lockRingBuffer.notify();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void hdPowerOn() {
        super.hdPowerOn();
        SerialPort serialPort = this.mSerialPort;
        if (serialPort != null) {
            serialPort.power_5Von();
        }
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void hdPowerOff() {
        super.hdPowerOff();
        SerialPort serialPort = this.mSerialPort;
        if (serialPort != null) {
            serialPort.power_5Voff();
        }
    }

    public void startReceive() {
        ThreadPoolUtils.run(new Runnable() { // from class: com.gg.reader.api.dal.communication.AndroidPdaSerialClient.1
            @Override // java.lang.Runnable
            public void run() {
                while (AndroidPdaSerialClient.this.keepReceived) {
                    try {
                    } catch (Exception unused) {
                        GLog.e("[AndroidPdaSerialClient]startReceive error.");
                    }
                    if (AndroidPdaSerialClient.this.mInputStream == null) {
                        return;
                    }
                    int available = AndroidPdaSerialClient.this.mInputStream.available();
                    if (available <= 0) {
                        Thread.sleep(AndroidPdaSerialClient.this.iDelay);
                    }
                    if (available > 0) {
                        int read = AndroidPdaSerialClient.this.mInputStream.read(AndroidPdaSerialClient.this.rcvBuff, 0, AndroidPdaSerialClient.this.rcvBuff.length);
                        synchronized (AndroidPdaSerialClient.this.lockRingBuffer) {
                            while (AndroidPdaSerialClient.this.ringBuffer.getDataCount() + read > 1048576) {
                                AndroidPdaSerialClient.this.lockRingBuffer.wait(10000L);
                            }
                            AndroidPdaSerialClient.this.ringBuffer.WriteBuffer(AndroidPdaSerialClient.this.rcvBuff, 0, read);
                            AndroidPdaSerialClient.this.lockRingBuffer.notify();
                        }
                    } else {
                        continue;
                    }
                }
            }
        });
    }
}
