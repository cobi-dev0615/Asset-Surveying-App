package com.gg.reader.api.dal.communication;

import com.gg.reader.api.protocol.gx.Message;
import com.gg.reader.api.utils.GLog;
import com.gg.reader.api.utils.ThreadPoolUtils;
import com.gxwl.device.reader.dal.SerialPortJNI;
import java.net.Socket;

/* loaded from: classes2.dex */
public class AndroidSerialCusClient extends CommunicationInterface {
    private int freeWait;
    private int packageSize;

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

    public AndroidSerialCusClient(int i, int i2) {
        this.packageSize = i;
        this.freeWait = i2;
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public boolean open(String str) {
        try {
            String[] split = str.split(":");
            if (split.length == 2 && 1 == SerialPortJNI.openPort(split[0], Integer.parseInt(split[1]), 8, 1, 'N')) {
                this.keepReceived = true;
                startReceive();
                startProcess();
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void startReceive() {
        ThreadPoolUtils.run(new Runnable() { // from class: com.gg.reader.api.dal.communication.AndroidSerialCusClient.1
            @Override // java.lang.Runnable
            public void run() {
                while (AndroidSerialCusClient.this.keepReceived) {
                    try {
                        byte[] readPort = SerialPortJNI.readPort(AndroidSerialCusClient.this.packageSize);
                        if (readPort == null || readPort.length <= 0) {
                            Thread.sleep(AndroidSerialCusClient.this.freeWait);
                        } else {
                            synchronized (AndroidSerialCusClient.this.lockRingBuffer) {
                                while (readPort.length + AndroidSerialCusClient.this.ringBuffer.getDataCount() > 1048576) {
                                    AndroidSerialCusClient.this.lockRingBuffer.wait(10000L);
                                }
                                AndroidSerialCusClient.this.ringBuffer.WriteBuffer(readPort, 0, readPort.length);
                                AndroidSerialCusClient.this.lockRingBuffer.notify();
                            }
                        }
                    } catch (Exception unused) {
                        GLog.e("[AndroidSerialCusClient]startReceive error.");
                    }
                }
            }
        });
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void close() {
        try {
            this.keepReceived = false;
            SerialPortJNI.closePort();
            synchronized (this.lockRingBuffer) {
                this.lockRingBuffer.notifyAll();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void send(byte[] bArr) {
        synchronized (AndroidSerialCusClient.class) {
            try {
                SerialPortJNI.writePort(bArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void send(Message message) {
        synchronized (AndroidSerialCusClient.class) {
            try {
                if (this.isRs485) {
                    message.msgType.mt_13 = "1";
                    message.rs485Address = getRs485Address();
                }
                message.pack();
                send(message.toBytes(this.isRs485));
            } catch (Exception e) {
                GLog.e("[AndroidSerialCusClient]base serial send error:" + e.getMessage());
            }
        }
    }
}
