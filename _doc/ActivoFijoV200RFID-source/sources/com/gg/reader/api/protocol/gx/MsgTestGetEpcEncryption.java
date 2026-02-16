package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgTestGetEpcEncryption extends Message {
    private int password;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgTestGetEpcEncryption() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_TEST;
            this.msgType.msgId = (byte) 20;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgTestGetEpcEncryption(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.password = wrap.getInt(16);
            } catch (Exception unused) {
            }
        }
    }

    public int getPassword() {
        return this.password;
    }

    public void setPassword(int i) {
        this.password = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.put(this.password, 16);
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
        this.password = wrap.getInt(16);
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgTestGetEpcEncryption{password=" + this.password + '}';
    }
}
