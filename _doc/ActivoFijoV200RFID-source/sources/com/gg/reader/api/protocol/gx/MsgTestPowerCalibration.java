package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class MsgTestPowerCalibration extends Message {
    private int childFreqRange;
    private int optionType;
    private int power;
    private int powerParam;

    public MsgTestPowerCalibration() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_TEST;
            this.msgType.msgId = (byte) 3;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgTestPowerCalibration(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.childFreqRange = wrap.getIntUnsigned(8);
                this.power = wrap.getIntUnsigned(8);
                this.powerParam = wrap.getIntUnsigned(8);
                this.optionType = wrap.getIntUnsigned(8);
            } catch (Exception unused) {
            }
        }
    }

    public int getChildFreqRange() {
        return this.childFreqRange;
    }

    public void setChildFreqRange(int i) {
        this.childFreqRange = i;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int i) {
        this.power = i;
    }

    public int getPowerParam() {
        return this.powerParam;
    }

    public void setPowerParam(int i) {
        this.powerParam = i;
    }

    public int getOptionType() {
        return this.optionType;
    }

    public void setOptionType(int i) {
        this.optionType = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putLong(this.childFreqRange, 8);
        allocateDynamic.putLong(this.power, 8);
        allocateDynamic.putLong(this.powerParam, 8);
        allocateDynamic.putLong(this.optionType, 8);
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        HashMap<Byte, String> hashMap = new HashMap<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgTestPowerCalibration.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Save failure.");
                put((byte) 2, "Other error.");
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
