package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgBaseGetBaseband extends Message {
    private int baseSpeed;
    private int inventoryFlag;
    private int qValue;
    private int session;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgBaseGetBaseband() {
        this.baseSpeed = Integer.MAX_VALUE;
        this.qValue = Integer.MAX_VALUE;
        this.session = Integer.MAX_VALUE;
        this.inventoryFlag = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_BASE;
            this.msgType.msgId = (byte) 12;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgBaseGetBaseband(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.baseSpeed = wrap.getIntUnsigned(8);
                this.qValue = wrap.getIntUnsigned(8);
                this.session = wrap.getIntUnsigned(8);
                this.inventoryFlag = wrap.getIntUnsigned(8);
            } catch (Exception unused) {
            }
        }
    }

    public int getBaseSpeed() {
        return this.baseSpeed;
    }

    public void setBaseSpeed(int i) {
        this.baseSpeed = i;
    }

    public int getqValue() {
        return this.qValue;
    }

    public void setqValue(int i) {
        this.qValue = i;
    }

    public int getSession() {
        return this.session;
    }

    public void setSession(int i) {
        this.session = i;
    }

    public int getInventoryFlag() {
        return this.inventoryFlag;
    }

    public void setInventoryFlag(int i) {
        this.inventoryFlag = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            int i = this.baseSpeed;
            if (Integer.MAX_VALUE != i) {
                allocateDynamic.putLong(i, 8);
            }
            int i2 = this.qValue;
            if (Integer.MAX_VALUE != i2) {
                allocateDynamic.putLong(i2, 8);
            }
            int i3 = this.session;
            if (Integer.MAX_VALUE != i3) {
                allocateDynamic.putLong(i3, 8);
            }
            int i4 = this.inventoryFlag;
            if (Integer.MAX_VALUE != i4) {
                allocateDynamic.putLong(i4, 8);
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
        this.baseSpeed = wrap.getIntUnsigned(8);
        this.qValue = wrap.getIntUnsigned(8);
        this.session = wrap.getIntUnsigned(8);
        this.inventoryFlag = wrap.getIntUnsigned(8);
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgBaseGetBaseband{baseSpeed=" + this.baseSpeed + ", qValue=" + this.qValue + ", session=" + this.session + ", inventoryFlag=" + this.inventoryFlag + '}';
    }
}
