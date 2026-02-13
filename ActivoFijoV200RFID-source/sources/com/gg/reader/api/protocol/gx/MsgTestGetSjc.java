package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgTestGetSjc extends Message {
    private int cap_i;
    private int cap_q;
    private int cap_s;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgTestGetSjc() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_TEST;
            this.msgType.msgId = (byte) 23;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgTestGetSjc(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.cap_i = wrap.getIntUnsigned(8);
                this.cap_q = wrap.getIntUnsigned(8);
                this.cap_s = wrap.getIntUnsigned(8);
            } catch (Exception unused) {
            }
        }
    }

    public int getCap_i() {
        return this.cap_i;
    }

    public void setCap_i(int i) {
        this.cap_i = i;
    }

    public int getCap_q() {
        return this.cap_q;
    }

    public void setCap_q(int i) {
        this.cap_q = i;
    }

    public int getCap_s() {
        return this.cap_s;
    }

    public void setCap_s(int i) {
        this.cap_s = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.putInt(this.cap_i, 8);
            allocateDynamic.putInt(this.cap_q, 8);
            allocateDynamic.putInt(this.cap_s, 8);
            this.cData = allocateDynamic.asByteArray();
            this.dataLen = this.cData.length;
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        if (this.cData == null || this.cData.length != 3) {
            return;
        }
        BitBuffer wrap = BitBuffer.wrap(this.cData);
        wrap.position(0);
        this.cap_i = wrap.getIntUnsigned(8);
        this.cap_q = wrap.getIntUnsigned(8);
        this.cap_s = wrap.getIntUnsigned(8);
        setRtCode((byte) 0);
    }
}
