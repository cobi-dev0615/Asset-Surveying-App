package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgAppWifiRoaming extends Message {
    private int operate;
    private int roamingSwitch;

    public MsgAppWifiRoaming() {
        this.operate = Integer.MAX_VALUE;
        this.roamingSwitch = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 74;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppWifiRoaming(byte[] bArr) {
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
                        this.roamingSwitch = wrap.getIntUnsigned(8);
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

    public int getRoamingSwitch() {
        return this.roamingSwitch;
    }

    public void setRoamingSwitch(int i) {
        this.roamingSwitch = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putLong(this.operate, 8);
        if (Integer.MAX_VALUE != this.roamingSwitch) {
            allocateDynamic.putInt(1, 8);
            allocateDynamic.putLong(this.roamingSwitch, 8);
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgAppWifiRoaming.1
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
                this.roamingSwitch = wrap.getIntUnsigned(8);
            }
        }
    }
}
