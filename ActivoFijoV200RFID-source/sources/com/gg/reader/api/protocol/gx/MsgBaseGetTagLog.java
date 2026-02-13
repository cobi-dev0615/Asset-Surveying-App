package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgBaseGetTagLog extends Message {
    private int repeatedTime;
    private int rssiTV;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgBaseGetTagLog() {
        this.repeatedTime = Integer.MAX_VALUE;
        this.rssiTV = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_BASE;
            this.msgType.msgId = (byte) 10;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgBaseGetTagLog(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.repeatedTime = wrap.getIntUnsigned(16);
                this.rssiTV = wrap.getIntUnsigned(8);
            } catch (Exception unused) {
            }
        }
    }

    public int getRepeatedTime() {
        return this.repeatedTime;
    }

    public void setRepeatedTime(int i) {
        this.repeatedTime = i;
    }

    public int getRssiTV() {
        return this.rssiTV;
    }

    public void setRssiTV(int i) {
        this.rssiTV = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            int i = this.repeatedTime;
            if (Integer.MAX_VALUE != i) {
                allocateDynamic.putLong(i, 16);
            }
            int i2 = this.rssiTV;
            if (Integer.MAX_VALUE != i2) {
                allocateDynamic.putLong(i2, 8);
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
        this.repeatedTime = wrap.getIntUnsigned(16);
        this.rssiTV = wrap.getIntUnsigned(8);
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgBaseGetTagLog{repeatedTime=" + this.repeatedTime + ", rssiTV=" + this.rssiTV + '}';
    }
}
