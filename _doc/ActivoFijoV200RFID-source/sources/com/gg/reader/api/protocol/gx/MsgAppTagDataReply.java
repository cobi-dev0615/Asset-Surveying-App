package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgAppTagDataReply extends Message {
    private long serialNumber;

    public MsgAppTagDataReply() {
        this.serialNumber = 0L;
        this.msgType = new MsgType();
        this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
        this.msgType.msgId = (byte) 29;
        this.dataLen = 0;
    }

    public MsgAppTagDataReply(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.serialNumber = wrap.getLongUnsigned(32);
            } catch (Exception unused) {
            }
        }
    }

    public long getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(long j) {
        this.serialNumber = j;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.put(this.serialNumber, 32);
            this.cData = allocateDynamic.asByteArray();
            this.dataLen = this.cData.length;
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.put(this.serialNumber, 32);
            this.cData = allocateDynamic.asByteArray();
            this.dataLen = this.cData.length;
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        BitBuffer wrap = BitBuffer.wrap(this.cData);
        wrap.position(0);
        this.serialNumber = wrap.getLongUnsigned(32);
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgAppTagDataReply{serialNumber=" + this.serialNumber + '}';
    }
}
