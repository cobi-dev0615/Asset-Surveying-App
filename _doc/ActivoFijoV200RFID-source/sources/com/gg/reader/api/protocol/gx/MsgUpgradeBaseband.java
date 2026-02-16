package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgUpgradeBaseband extends Message {
    private byte[] packetContent;
    private Long packetNumber;

    public MsgUpgradeBaseband() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_UPDATE;
            this.msgType.msgId = (byte) 1;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgUpgradeBaseband(byte[] bArr) {
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
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgUpgradeBaseband.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Fail.");
            }
        };
        if (this.cData == null || this.cData.length <= 0) {
            return;
        }
        BitBuffer wrap = BitBuffer.wrap(this.cData);
        wrap.position(0);
        this.packetNumber = Long.valueOf(wrap.getLong(32));
        byte byteUnsigned = wrap.getByteUnsigned(8);
        setRtCode(byteUnsigned);
        if (hashtable.containsKey(Byte.valueOf(byteUnsigned))) {
            setRtMsg(hashtable.get(Byte.valueOf(byteUnsigned)));
        }
    }
}
