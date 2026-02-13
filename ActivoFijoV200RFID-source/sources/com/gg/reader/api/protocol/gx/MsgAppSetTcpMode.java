package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgAppSetTcpMode extends Message {
    private String clientIp;
    private int clientPort;
    private int serverPort;
    private int tcpMode;

    public MsgAppSetTcpMode() {
        this.serverPort = Integer.MAX_VALUE;
        this.clientPort = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 7;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppSetTcpMode(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.tcpMode = wrap.getIntUnsigned(8);
                while (wrap.position() / 8 < bArr.length) {
                    byte b = wrap.getByte();
                    if (b == 1) {
                        this.serverPort = wrap.getIntUnsigned(16);
                    } else if (b == 2) {
                        this.clientIp = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
                    } else if (b == 3) {
                        this.clientPort = wrap.getIntUnsigned(16);
                    }
                }
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
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putLong(this.tcpMode, 8);
        if (Integer.MAX_VALUE != this.serverPort) {
            allocateDynamic.putInt(1, 8);
            allocateDynamic.putInt(this.serverPort, 16);
        }
        String str = this.clientIp;
        if (str != null) {
            String[] split = str.split("\\.");
            allocateDynamic.putInt(2, 8);
            for (String str2 : split) {
                allocateDynamic.putInt(Integer.parseInt(str2), 8);
            }
        }
        if (Integer.MAX_VALUE != this.clientPort) {
            allocateDynamic.putInt(3, 8);
            allocateDynamic.putInt(this.clientPort, 16);
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgAppSetTcpMode.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Server IP parameter error .");
            }
        };
        if (this.cData == null || this.cData.length != 1) {
            return;
        }
        setRtCode(this.cData[0]);
        if (hashtable.containsKey(Byte.valueOf(this.cData[0]))) {
            setRtMsg(hashtable.get(Byte.valueOf(this.cData[0])));
        }
    }
}
