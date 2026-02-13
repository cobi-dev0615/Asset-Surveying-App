package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class MsgTestDCbias extends Message {
    private int optionType;
    private int param;

    public MsgTestDCbias() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_TEST;
            this.msgType.msgId = (byte) 1;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgTestDCbias(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.param = wrap.getInt(8);
                this.optionType = wrap.getIntUnsigned(8);
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

    public int getOptionType() {
        return this.optionType;
    }

    public void setOptionType(int i) {
        this.optionType = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putLong(this.param, 8);
        allocateDynamic.putLong(this.optionType, 8);
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        HashMap<Byte, String> hashMap = new HashMap<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgTestDCbias.1
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
