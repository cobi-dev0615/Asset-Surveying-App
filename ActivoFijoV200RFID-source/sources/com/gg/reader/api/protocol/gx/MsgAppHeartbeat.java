package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgAppHeartbeat extends Message {
    private long param;

    public MsgAppHeartbeat() {
        this.param = 0L;
        this.msgType = new MsgType();
        this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
        this.msgType.msgId = (byte) 18;
        this.dataLen = 0;
    }

    public MsgAppHeartbeat(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.param = wrap.getLongUnsigned(32);
            } catch (Exception unused) {
            }
        }
    }

    public long getParam() {
        return this.param;
    }

    public void setParam(long j) {
        this.param = j;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.put(this.param, 32);
            this.cData = allocateDynamic.asByteArray();
            this.dataLen = this.cData.length;
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.put(this.param, 32);
            this.cData = allocateDynamic.asByteArray();
            this.dataLen = this.cData.length;
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        BitBuffer wrap = BitBuffer.wrap(this.cData);
        wrap.position(0);
        this.param = wrap.getLongUnsigned(32);
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgAppHeartbeat{param=" + this.param + '}';
    }
}
