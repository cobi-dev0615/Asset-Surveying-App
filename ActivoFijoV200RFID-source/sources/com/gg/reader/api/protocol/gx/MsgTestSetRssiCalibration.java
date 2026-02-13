package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgTestSetRssiCalibration extends Message {
    private int rssiBaseValue;

    public MsgTestSetRssiCalibration() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_TEST;
            this.msgType.msgId = (byte) 8;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgTestSetRssiCalibration(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.rssiBaseValue = wrap.getInt(16);
            } catch (Exception unused) {
            }
        }
    }

    public int getRssiBaseValue() {
        return this.rssiBaseValue;
    }

    public void setRssiBaseValue(int i) {
        this.rssiBaseValue = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putInt(this.rssiBaseValue, 16);
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgTestSetRssiCalibration.1
            {
                put((byte) 0, "Set success.");
                put((byte) 1, "Other error.");
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
