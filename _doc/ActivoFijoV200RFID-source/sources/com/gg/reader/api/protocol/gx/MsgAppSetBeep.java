package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgAppSetBeep extends Message {
    private int beepMode;
    private int beepStatus;

    public MsgAppSetBeep() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 31;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppSetBeep(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.beepStatus = wrap.getIntUnsigned(8);
                this.beepMode = wrap.getIntUnsigned(8);
            } catch (Exception unused) {
            }
        }
    }

    public int getBeepStatus() {
        return this.beepStatus;
    }

    public void setBeepStatus(int i) {
        this.beepStatus = i;
    }

    public int getBeepMode() {
        return this.beepMode;
    }

    public void setBeepMode(int i) {
        this.beepMode = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putInt(this.beepStatus, 8);
        allocateDynamic.putInt(this.beepMode, 8);
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgAppSetBeep.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Set Fail.");
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
