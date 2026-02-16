package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgBaseGetResidenceTime extends Message {
    private Long antResidenceTime;
    private Long frqResidenceTime;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgBaseGetResidenceTime() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_BASE;
            this.msgType.msgId = (byte) -31;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgBaseGetResidenceTime(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                while (wrap.position() / 8 < bArr.length) {
                    byte b = wrap.getByte();
                    if (b == 1) {
                        this.antResidenceTime = Long.valueOf(wrap.getLongUnsigned(16));
                    } else if (b == 2) {
                        this.frqResidenceTime = Long.valueOf(wrap.getLongUnsigned(16));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public Long getAntResidenceTime() {
        return this.antResidenceTime;
    }

    public void setAntResidenceTime(Long l) {
        this.antResidenceTime = l;
    }

    public Long getFrqResidenceTime() {
        return this.frqResidenceTime;
    }

    public void setFrqResidenceTime(Long l) {
        this.frqResidenceTime = l;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.put(1, 8);
            allocateDynamic.putLong(this.antResidenceTime.longValue(), 16);
            allocateDynamic.put(2, 8);
            allocateDynamic.putLong(this.frqResidenceTime.longValue(), 16);
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
        while (wrap.position() / 8 < this.cData.length) {
            int intUnsigned = wrap.getIntUnsigned(8);
            if (intUnsigned == 1) {
                this.antResidenceTime = Long.valueOf(wrap.getLongUnsigned(16));
            } else if (intUnsigned == 2) {
                this.frqResidenceTime = Long.valueOf(wrap.getLongUnsigned(16));
            }
        }
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgBaseGetResidenceTime{antResidenceTime=" + this.antResidenceTime + ", frqResidenceTime=" + this.frqResidenceTime + '}';
    }
}
