package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgAppGetUdpParam extends Message {
    private String ip;
    private int onOrOff;
    private int period;
    private int port;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgAppGetUdpParam() {
        this.ip = "0.0.0.0";
        this.port = Integer.MAX_VALUE;
        this.period = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 40;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppGetUdpParam(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.onOrOff = wrap.getIntUnsigned(8);
                this.ip = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
                this.port = wrap.getIntUnsigned(16);
                this.period = wrap.getIntUnsigned(16);
            } catch (Exception unused) {
            }
        }
    }

    public int getOnOrOff() {
        return this.onOrOff;
    }

    public void setOnOrOff(int i) {
        this.onOrOff = i;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public int getPeriod() {
        return this.period;
    }

    public void setPeriod(int i) {
        this.period = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.putInt(this.onOrOff, 8);
            String str = this.ip;
            if (str != null) {
                for (String str2 : str.split("\\.")) {
                    allocateDynamic.putInt(Integer.parseInt(str2), 8);
                }
            }
            int i = this.port;
            if (Integer.MAX_VALUE != i) {
                allocateDynamic.put(i, 16);
            }
            int i2 = this.period;
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
        this.onOrOff = wrap.getIntUnsigned(8);
        this.ip = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
        this.port = wrap.getIntUnsigned(16);
        this.period = wrap.getIntUnsigned(16);
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgAppGetUdpParam{onOrOff=" + this.onOrOff + ", ip='" + this.ip + "', port=" + this.port + ", period=" + this.period + '}';
    }
}
