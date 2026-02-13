package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class MsgTestGJbCommands extends Message {
    private Long antennaNum;
    private int freqCursor;

    public MsgTestGJbCommands(int i) {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_TEST;
            this.msgType.msgId = (byte) i;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgTestGJbCommands(byte[] bArr, int i) {
        this(i);
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.antennaNum = Long.valueOf(wrap.getLongUnsigned(32));
                this.freqCursor = wrap.getIntUnsigned(8);
            } catch (Exception unused) {
            }
        }
    }

    public Long getAntennaNum() {
        return this.antennaNum;
    }

    public void setAntennaNum(Long l) {
        this.antennaNum = l;
    }

    public int getFreqCursor() {
        return this.freqCursor;
    }

    public void setFreqCursor(int i) {
        this.freqCursor = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putLong(this.antennaNum.longValue(), 32);
        allocateDynamic.putLong(this.freqCursor, 8);
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        HashMap<Byte, String> hashMap = new HashMap<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgTestGJbCommands.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Frequency parameter reader is not supported.");
                put((byte) 2, "Port parameter reader is not supported.");
                put((byte) 3, "Lock failure.");
                put((byte) 4, "Other error.");
            }
        };
        if (this.cData == null || this.cData.length <= 0) {
            return;
        }
        setRtCode(this.cData[0]);
        if (hashMap.containsKey(Byte.valueOf(this.cData[0]))) {
            setRtMsg(hashMap.get(Byte.valueOf(this.cData[0])));
        }
    }
}
