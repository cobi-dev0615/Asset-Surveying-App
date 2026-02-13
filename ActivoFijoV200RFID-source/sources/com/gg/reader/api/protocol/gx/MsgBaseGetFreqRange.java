package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgBaseGetFreqRange extends Message {
    private int freqRangeIndex;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgBaseGetFreqRange() {
        this.freqRangeIndex = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_BASE;
            this.msgType.msgId = (byte) 4;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgBaseGetFreqRange(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.freqRangeIndex = wrap.getIntUnsigned(8);
            } catch (Exception unused) {
            }
        }
    }

    public int getFreqRangeIndex() {
        return this.freqRangeIndex;
    }

    public void setFreqRangeIndex(int i) {
        this.freqRangeIndex = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.putLong(this.freqRangeIndex, 8);
            this.cData = allocateDynamic.asByteArray();
            this.dataLen = this.cData.length;
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        if (this.cData == null || this.cData.length != 1) {
            return;
        }
        this.freqRangeIndex = this.cData[0];
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgBaseGetFreqRange{freqRangeIndex=" + this.freqRangeIndex + '}';
    }
}
