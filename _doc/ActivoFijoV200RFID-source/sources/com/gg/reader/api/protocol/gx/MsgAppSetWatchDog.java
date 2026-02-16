package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgAppSetWatchDog extends Message {
    private int onOff;
    private int operationType;

    public MsgAppSetWatchDog() {
        this.onOff = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 75;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppSetWatchDog(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.operationType = wrap.getIntUnsigned(8);
                while (wrap.position() / 8 < bArr.length) {
                    if (wrap.getIntUnsigned(8) == 1) {
                        this.onOff = wrap.getIntUnsigned(8);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public int getOperationType() {
        return this.operationType;
    }

    public void setOperationType(int i) {
        this.operationType = i;
    }

    public int getOnOff() {
        return this.onOff;
    }

    public void setOnOff(int i) {
        this.onOff = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putLong(this.operationType, 8);
        if (Integer.MAX_VALUE != this.onOff) {
            allocateDynamic.putInt(1, 8);
            allocateDynamic.putLong(this.onOff, 8);
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgAppSetWatchDog.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Failed.");
            }
        };
        if (this.cData == null || this.cData.length < 1) {
            return;
        }
        setRtCode(this.cData[0]);
        if (hashtable.containsKey(Byte.valueOf(this.cData[0]))) {
            setRtMsg(hashtable.get(Byte.valueOf(this.cData[0])));
        }
        if (this.cData.length > 1) {
            BitBuffer wrap = BitBuffer.wrap(this.cData);
            wrap.position(8);
            if (wrap.getIntUnsigned(8) == 1) {
                this.onOff = wrap.getIntUnsigned(8);
            }
        }
    }
}
