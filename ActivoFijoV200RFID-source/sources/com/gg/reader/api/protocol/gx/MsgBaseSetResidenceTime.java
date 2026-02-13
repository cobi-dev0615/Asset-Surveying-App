package com.gg.reader.api.protocol.gx;

import androidx.collection.SieveCacheKt;
import com.gg.reader.api.utils.BitBuffer;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgBaseSetResidenceTime extends Message {
    private Long antResidenceTime;
    private Long frqResidenceTime;

    public MsgBaseSetResidenceTime() {
        this.antResidenceTime = Long.MAX_VALUE;
        this.frqResidenceTime = Long.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_BASE;
            this.msgType.msgId = (byte) -32;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgBaseSetResidenceTime(byte[] bArr) {
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
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        if (SieveCacheKt.NodeLinkMask != this.antResidenceTime.longValue()) {
            allocateDynamic.putInt(1, 8);
            allocateDynamic.putLong(this.antResidenceTime.longValue(), 16);
        }
        if (SieveCacheKt.NodeLinkMask != this.frqResidenceTime.longValue()) {
            allocateDynamic.putInt(2, 8);
            allocateDynamic.putLong(this.frqResidenceTime.longValue(), 16);
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgBaseSetResidenceTime.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Mode parameter error.");
                put((byte) 2, "Other parameter error.");
                put((byte) 3, "Save Failure.");
            }
        };
        if (this.cData == null || this.cData.length != 1) {
            return;
        }
        setRtCode(this.cData[0]);
        if (hashtable.containsKey(Byte.valueOf(this.cData[0]))) {
            setRtMsg(hashtable.get(Byte.valueOf(this.cData[0])));
        }
    }
}
