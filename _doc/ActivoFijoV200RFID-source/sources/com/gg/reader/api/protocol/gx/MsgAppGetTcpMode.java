package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgAppGetTcpMode extends Message {
    private String clientIp;
    private int clientPort;
    private int serverPort;
    private int tcpMode;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgAppGetTcpMode() {
        this.serverPort = Integer.MAX_VALUE;
        this.clientPort = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 8;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppGetTcpMode(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.tcpMode = wrap.getIntUnsigned(8);
                this.serverPort = wrap.getIntUnsigned(16);
                this.clientIp = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
                this.clientPort = wrap.getIntUnsigned(16);
            } catch (Exception unused) {
            }
        }
    }

    public int getTcpMode() {
        return this.tcpMode;
    }

    public void setTcpMode(int i) {
        this.tcpMode = i;
    }

    public int getServerPort() {
        return this.serverPort;
    }

    public void setServerPort(int i) {
        this.serverPort = i;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public void setClientIp(String str) {
        this.clientIp = str;
    }

    public int getClientPort() {
        return this.clientPort;
    }

    public void setClientPort(int i) {
        this.clientPort = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.putLong(this.tcpMode, 8);
            int i = this.serverPort;
            if (Integer.MAX_VALUE != i) {
                allocateDynamic.put(i, 16);
            }
            String str = this.clientIp;
            if (str != null) {
                for (String str2 : str.split("\\.")) {
                    allocateDynamic.put(Integer.parseInt(str2), 8);
                }
            }
            int i2 = this.clientPort;
            if (Integer.MAX_VALUE != i2) {
                allocateDynamic.put(i2, 16);
            }
            this.cData = allocateDynamic.asByteArray();
            this.dataLen = this.cData.length;
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        if (this.cData == null || this.cData.length <= 0) {
            return;
        }
        BitBuffer wrap = BitBuffer.wrap(this.cData);
        wrap.position(0);
        this.tcpMode = wrap.getIntUnsigned(8);
        this.serverPort = wrap.getIntUnsigned(16);
        this.clientIp = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
        this.clientPort = wrap.getIntUnsigned(16);
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgAppGetTcpMode{tcpMode=" + this.tcpMode + ", serverPort=" + this.serverPort + ", clientIp='" + this.clientIp + "', clientPort=" + this.clientPort + '}';
    }
}
