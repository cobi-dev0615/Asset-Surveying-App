package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgAppGetWifiOnOff extends Message {
    private int wifiSwitch;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgAppGetWifiOnOff() {
        this.wifiSwitch = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 56;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppGetWifiOnOff(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.wifiSwitch = wrap.getIntUnsigned(8);
            } catch (Exception unused) {
            }
        }
    }

    public int getWifiSwitch() {
        return this.wifiSwitch;
    }

    public void setWifiSwitch(int i) {
        this.wifiSwitch = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            int i = this.wifiSwitch;
            if (Integer.MAX_VALUE != i) {
                allocateDynamic.putInt(i, 8);
            }
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
        this.wifiSwitch = wrap.getIntUnsigned(8);
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgAppGetWifiOnOff{wifiSwitch=" + this.wifiSwitch + '}';
    }
}
