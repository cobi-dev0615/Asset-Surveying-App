package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgAppGetWhiteList extends Message {
    private byte[] packetContent;
    private Long packetNumber;

    public MsgAppGetWhiteList() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 32;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppGetWhiteList(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.packetNumber = Long.valueOf(wrap.getLongUnsigned(32));
                int intUnsigned = wrap.getIntUnsigned(16);
                byte[] bArr2 = new byte[intUnsigned];
                if (intUnsigned > 0) {
                    this.packetContent = wrap.get(bArr2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public Long getPacketNumber() {
        return this.packetNumber;
    }

    public void setPacketNumber(Long l) {
        this.packetNumber = l;
    }

    public byte[] getPacketContent() {
        return this.packetContent;
    }

    public void setPacketContent(byte[] bArr) {
        this.packetContent = bArr;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.put(this.packetNumber.longValue(), 32);
            this.cData = allocateDynamic.asByteArray();
            this.dataLen = this.cData.length;
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.put(this.packetNumber.longValue(), 32);
            byte[] bArr = this.packetContent;
            if (bArr != null && bArr.length > 0) {
                allocateDynamic.putInt(bArr.length, 16);
                allocateDynamic.put(this.packetContent, 8);
            } else {
                allocateDynamic.putInt(0, 16);
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
        this.packetNumber = Long.valueOf(wrap.getLongUnsigned(32));
        int intUnsigned = wrap.getIntUnsigned(16);
        byte[] bArr = new byte[intUnsigned];
        if (intUnsigned > 0) {
            this.packetContent = wrap.get(bArr);
        }
        setRtCode((byte) 0);
    }
}
