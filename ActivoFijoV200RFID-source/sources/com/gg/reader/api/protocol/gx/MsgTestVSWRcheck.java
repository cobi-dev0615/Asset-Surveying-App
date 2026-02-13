package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgTestVSWRcheck extends Message {
    private int preValue;
    private int sufValue;

    public MsgTestVSWRcheck() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_TEST;
            this.msgType.msgId = (byte) 5;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgTestVSWRcheck(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.preValue = wrap.getIntUnsigned(8);
                this.sufValue = wrap.getIntUnsigned(8);
            } catch (Exception unused) {
            }
        }
    }

    public int getPreValue() {
        return this.preValue;
    }

    public void setPreValue(int i) {
        this.preValue = i;
    }

    public int getSufValue() {
        return this.sufValue;
    }

    public void setSufValue(int i) {
        this.sufValue = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        super.pack();
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        if (this.cData == null || this.cData.length <= 0) {
            return;
        }
        BitBuffer wrap = BitBuffer.wrap(this.cData);
        wrap.position(0);
        this.preValue = wrap.getIntUnsigned(8);
        this.sufValue = wrap.getIntUnsigned(8);
        setRtCode((byte) 0);
    }
}
