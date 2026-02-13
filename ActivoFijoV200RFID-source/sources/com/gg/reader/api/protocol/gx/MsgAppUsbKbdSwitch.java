package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgAppUsbKbdSwitch extends Message {
    private int kbdSwitch;
    private int operate;

    public MsgAppUsbKbdSwitch() {
        this.operate = Integer.MAX_VALUE;
        this.kbdSwitch = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 43;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppUsbKbdSwitch(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.operate = wrap.getIntUnsigned(8);
                while (wrap.position() / 8 < bArr.length) {
                    if (wrap.getIntUnsigned(8) == 1) {
                        this.kbdSwitch = wrap.getIntUnsigned(8);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public int getOperate() {
        return this.operate;
    }

    public void setOperate(int i) {
        this.operate = i;
    }

    public int getKbdSwitch() {
        return this.kbdSwitch;
    }

    public void setKbdSwitch(int i) {
        this.kbdSwitch = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putLong(this.operate, 8);
        if (Integer.MAX_VALUE != this.kbdSwitch) {
            allocateDynamic.putInt(1, 8);
            allocateDynamic.putLong(this.kbdSwitch, 8);
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgAppUsbKbdSwitch.1
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
                this.kbdSwitch = wrap.getIntUnsigned(8);
            }
        }
    }
}
