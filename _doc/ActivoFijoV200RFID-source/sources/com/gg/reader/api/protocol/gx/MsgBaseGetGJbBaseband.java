package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgBaseGetGJbBaseband extends Message {
    private int inventoryFlag;
    private ParamGbAntiCollision paramGbAntiCollision;
    private ParamGbBaseSpeed paramGbBaseSpeed;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgBaseGetGJbBaseband() {
        this.inventoryFlag = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_BASE;
            this.msgType.msgId = (byte) -27;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgBaseGetGJbBaseband(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(this.cData);
                wrap.position(0);
                byte[] bArr2 = new byte[1];
                wrap.get(bArr2);
                this.paramGbBaseSpeed = new ParamGbBaseSpeed(bArr2);
                byte[] bArr3 = new byte[1];
                wrap.get(bArr3);
                this.paramGbAntiCollision = new ParamGbAntiCollision(bArr3);
                this.inventoryFlag = wrap.getIntUnsigned(8);
            } catch (Exception unused) {
            }
        }
    }

    public ParamGbBaseSpeed getParamGbBaseSpeed() {
        return this.paramGbBaseSpeed;
    }

    public void setParamGbBaseSpeed(ParamGbBaseSpeed paramGbBaseSpeed) {
        this.paramGbBaseSpeed = paramGbBaseSpeed;
    }

    public ParamGbAntiCollision getParamGbAntiCollision() {
        return this.paramGbAntiCollision;
    }

    public void setParamGbAntiCollision(ParamGbAntiCollision paramGbAntiCollision) {
        this.paramGbAntiCollision = paramGbAntiCollision;
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
            ParamGbBaseSpeed paramGbBaseSpeed = this.paramGbBaseSpeed;
            if (paramGbBaseSpeed != null) {
                allocateDynamic.put(paramGbBaseSpeed.toBytes());
            }
            ParamGbAntiCollision paramGbAntiCollision = this.paramGbAntiCollision;
            if (paramGbAntiCollision != null) {
                allocateDynamic.put(paramGbAntiCollision.toBytes());
            }
            int i = this.inventoryFlag;
            if (Integer.MAX_VALUE != i) {
                allocateDynamic.putLong(i, 8);
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
        byte[] bArr = new byte[1];
        wrap.get(bArr);
        this.paramGbBaseSpeed = new ParamGbBaseSpeed(bArr);
        byte[] bArr2 = new byte[1];
        wrap.get(bArr2);
        this.paramGbAntiCollision = new ParamGbAntiCollision(bArr2);
        this.inventoryFlag = wrap.getIntUnsigned(8);
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgBaseGetGbBaseband{paramGbBaseSpeed=" + this.paramGbBaseSpeed + ", paramGbAntiCollision=" + this.paramGbAntiCollision + ", inventoryFlag=" + this.inventoryFlag + '}';
    }
}
