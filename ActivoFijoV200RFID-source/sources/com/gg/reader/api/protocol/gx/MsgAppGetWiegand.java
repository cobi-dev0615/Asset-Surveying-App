package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.HexUtils;

/* loaded from: classes2.dex */
public class MsgAppGetWiegand extends Message {
    private int negativePulseWidth;
    private int pulseInterval;
    private int wiegandContent;
    private int wiegandFormat;
    private int wiegandSwitch;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgAppGetWiegand() {
        this.negativePulseWidth = Integer.MAX_VALUE;
        this.pulseInterval = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 14;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppGetWiegand(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.wiegandSwitch = wrap.getIntUnsigned(8);
                this.wiegandFormat = wrap.getIntUnsigned(8);
                this.wiegandContent = wrap.getIntUnsigned(8);
                while (wrap.position() / 8 < bArr.length) {
                    int intUnsigned = wrap.getIntUnsigned(8);
                    if (intUnsigned == 1) {
                        byte[] bArr2 = new byte[2];
                        wrap.get(bArr2);
                        this.negativePulseWidth = HexUtils.bytes2Int(bArr2);
                    } else if (intUnsigned == 2) {
                        byte[] bArr3 = new byte[2];
                        wrap.get(bArr3);
                        this.pulseInterval = HexUtils.bytes2Int(bArr3);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public int getWiegandSwitch() {
        return this.wiegandSwitch;
    }

    public void setWiegandSwitch(int i) {
        this.wiegandSwitch = i;
    }

    public int getWiegandFormat() {
        return this.wiegandFormat;
    }

    public void setWiegandFormat(int i) {
        this.wiegandFormat = i;
    }

    public int getWiegandContent() {
        return this.wiegandContent;
    }

    public void setWiegandContent(int i) {
        this.wiegandContent = i;
    }

    public int getNegativePulseWidth() {
        return this.negativePulseWidth;
    }

    public void setNegativePulseWidth(int i) {
        this.negativePulseWidth = i;
    }

    public int getPulseInterval() {
        return this.pulseInterval;
    }

    public void setPulseInterval(int i) {
        this.pulseInterval = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.putLong(this.wiegandSwitch, 8);
            allocateDynamic.putLong(this.wiegandFormat, 8);
            allocateDynamic.putLong(this.wiegandContent, 8);
            if (Integer.MAX_VALUE != this.negativePulseWidth) {
                allocateDynamic.putLong(1L);
                allocateDynamic.putLong(this.negativePulseWidth);
            }
            if (Integer.MAX_VALUE != this.pulseInterval) {
                allocateDynamic.putLong(2L);
                allocateDynamic.putLong(this.pulseInterval);
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
        this.wiegandSwitch = wrap.getIntUnsigned(8);
        this.wiegandFormat = wrap.getIntUnsigned(8);
        this.wiegandContent = wrap.getIntUnsigned(8);
        while (wrap.position() / 8 < this.cData.length) {
            int intUnsigned = wrap.getIntUnsigned(8);
            if (intUnsigned == 1) {
                byte[] bArr = new byte[2];
                wrap.get(bArr);
                this.negativePulseWidth = HexUtils.bytes2Int(bArr);
            } else if (intUnsigned == 2) {
                byte[] bArr2 = new byte[2];
                wrap.get(bArr2);
                this.pulseInterval = HexUtils.bytes2Int(bArr2);
            }
        }
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgAppGetWiegand{wiegandSwitch=" + this.wiegandSwitch + ", wiegandFormat=" + this.wiegandFormat + ", wiegandContent=" + this.wiegandContent + ", negativePulseWidth=" + this.negativePulseWidth + ", pulseInterval=" + this.pulseInterval + '}';
    }
}
