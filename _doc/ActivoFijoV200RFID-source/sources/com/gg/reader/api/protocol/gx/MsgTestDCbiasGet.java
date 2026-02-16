package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgTestDCbiasGet extends Message {
    private int param;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgTestDCbiasGet() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_TEST;
            this.msgType.msgId = (byte) 2;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgTestDCbiasGet(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.param = wrap.getInt(8);
            } catch (Exception unused) {
            }
        }
    }

    public int getParam() {
        return this.param;
    }

    public void setParam(int i) {
        this.param = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.put(this.param, 8);
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
        this.param = wrap.getInt(8);
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgTestDCbiasGet{param=" + this.param + '}';
    }
}
