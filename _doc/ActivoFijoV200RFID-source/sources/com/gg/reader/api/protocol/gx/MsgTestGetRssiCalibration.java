package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgTestGetRssiCalibration extends Message {
    private int rssiBaseValue;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgTestGetRssiCalibration() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_TEST;
            this.msgType.msgId = (byte) 9;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgTestGetRssiCalibration(byte[] bArr) {
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
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.putInt(this.rssiBaseValue, 16);
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
        this.rssiBaseValue = wrap.getInt(16);
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgTestRssiCalibrationGet{rssiBaseValue=" + this.rssiBaseValue + '}';
    }
}
