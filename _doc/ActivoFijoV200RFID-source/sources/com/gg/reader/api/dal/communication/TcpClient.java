package com.gg.reader.api.dal.communication;

import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.gg.reader.api.protocol.gx.Message;
import com.gg.reader.api.protocol.gx.MsgAppHeartbeat;
import com.gg.reader.api.utils.ThreadPoolUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Date;

/* loaded from: classes2.dex */
public class TcpClient extends CommunicationInterface {
    public Socket sConn = null;
    public String serverIp = "192.168.1.168";
    public int serverPort = 8160;
    public InputStream inputStream = null;
    public OutputStream outputStream = null;
    boolean _isOpen = false;
    private Date lastUrgentData = new Date();
    private int count = 1;

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
    public int receive(byte[] bArr) {
        return 0;
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public boolean setBufferSize(int i) {
        return false;
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public boolean open(Socket socket) {
        try {
            Socket socket2 = this.sConn;
            if (socket2 != null && socket2.isConnected()) {
                return false;
            }
            this.sConn = socket;
            this.keepReceived = true;
            socket.setSoTimeout(1000);
            socket.setKeepAlive(true);
            this.inputStream = socket.getInputStream();
            this.outputStream = socket.getOutputStream();
            startReceive();
            startProcess();
            return true;
        } catch (Exception unused) {
            close();
            return false;
        }
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public boolean open(String str) {
        try {
            String[] split = str.split(":");
            if (split.length == 2) {
                this.serverIp = split[0];
                this.serverPort = Integer.parseInt(split[1]);
                Socket socket = new Socket();
                this.sConn = socket;
                socket.connect(new InetSocketAddress(this.serverIp, this.serverPort), 5000);
                this.sConn.setSoTimeout(1000);
                this.sConn.setKeepAlive(true);
                this.inputStream = this.sConn.getInputStream();
                this.outputStream = this.sConn.getOutputStream();
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
            this.keepReceived = false;
            this._isOpen = false;
            Socket socket = this.sConn;
            if (socket != null) {
                socket.close();
                this.inputStream = null;
                this.outputStream = null;
                this.sConn = null;
            }
            synchronized (this.lockRingBuffer) {
                this.lockRingBuffer.notifyAll();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void send(byte[] bArr) {
        synchronized (this) {
            try {
                this.outputStream.write(bArr);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.gg.reader.api.dal.communication.CommunicationInterface
    public void send(Message message) {
        try {
            message.pack();
            send(message.toBytes(this.isRs485));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRemoteClosed() {
        if (this.sConn == null) {
            return true;
        }
        Date date = new Date();
        long time = date.getTime() - this.lastUrgentData.getTime();
        int i = this.count;
        if (time > i * PathInterpolatorCompat.MAX_NUM_POINTS) {
            try {
                this.count = i + 1;
                send(new MsgAppHeartbeat());
            } catch (Exception unused) {
            }
        }
        return date.getTime() - this.lastUrgentData.getTime() > 15000;
    }

    public void startReceive() {
        ThreadPoolUtils.run(new Runnable() { // from class: com.gg.reader.api.dal.communication.TcpClient.1
            @Override // java.lang.Runnable
            public void run() {
                while (TcpClient.this.keepReceived) {
                    try {
                        int available = TcpClient.this.inputStream.available();
                        if (available <= 0) {
                            Thread.sleep(100L);
                        }
                        if (available > 0) {
                            available = TcpClient.this.inputStream.read(TcpClient.this.rcvBuff, 0, TcpClient.this.rcvBuff.length);
                            synchronized (TcpClient.this.lockRingBuffer) {
                                while (TcpClient.this.ringBuffer.getDataCount() + available > 1048576) {
                                    try {
                                        TcpClient.this.lockRingBuffer.wait(10000L);
                                    } catch (InterruptedException unused) {
                                        continue;
                                    }
                                }
                                TcpClient.this.ringBuffer.WriteBuffer(TcpClient.this.rcvBuff, 0, available);
                                TcpClient.this.lockRingBuffer.notify();
                            }
                        }
                        if (!TcpClient.this._isSendHeartbeat) {
                            continue;
                        } else if (available <= 0) {
                            if (TcpClient.this.isRemoteClosed()) {
                                throw new Exception("remote closed.");
                            }
                        } else {
                            TcpClient.this.lastUrgentData = new Date();
                            TcpClient.this.count = 1;
                        }
                    } catch (Exception unused2) {
                        TcpClient.this.triggerDisconnected();
                        Thread.sleep(3000L);
                    }
                }
            }
        });
    }
}
