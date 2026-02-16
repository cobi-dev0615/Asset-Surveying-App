package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgBaseSetGbBaseband extends Message {
    private int inventoryFlag;
    private ParamGbAntiCollision paramGbAntiCollision;
    private ParamGbBaseSpeed paramGbBaseSpeed;
    private int session;

    public MsgBaseSetGbBaseband() {
        this.session = Integer.MAX_VALUE;
        this.inventoryFlag = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_BASE;
            this.msgType.msgId = (byte) -30;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgBaseSetGbBaseband(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                while (wrap.position() / 8 < bArr.length) {
                    byte b = wrap.getByte();
                    if (b == 1) {
                        byte[] bArr2 = new byte[wrap.getIntUnsigned(8)];
                        wrap.get(bArr2);
                        this.paramGbBaseSpeed = new ParamGbBaseSpeed(bArr2);
                    } else if (b == 2) {
                        byte[] bArr3 = new byte[wrap.getIntUnsigned(8)];
                        wrap.get(bArr3);
                        this.paramGbAntiCollision = new ParamGbAntiCollision(bArr3);
                    } else if (b == 3) {
                        this.session = wrap.getIntUnsigned(8);
                    } else if (b == 4) {
                        this.inventoryFlag = wrap.getIntUnsigned(8);
                    }
                }
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
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        if (this.paramGbBaseSpeed != null) {
            allocateDynamic.putInt(1, 8);
            allocateDynamic.put(this.paramGbBaseSpeed.toBytes());
        }
        if (this.paramGbAntiCollision != null) {
            allocateDynamic.putInt(2, 8);
            allocateDynamic.put(this.paramGbAntiCollision.toBytes());
        }
        if (Integer.MAX_VALUE != this.session) {
            allocateDynamic.putInt(3, 8);
            allocateDynamic.putInt(this.session, 8);
        }
        if (Integer.MAX_VALUE != this.inventoryFlag) {
            allocateDynamic.putInt(4, 8);
            allocateDynamic.putInt(this.inventoryFlag, 8);
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgBaseSetGbBaseband.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Baseband rate not support.");
                put((byte) 2, "Session parameter error.");
                put((byte) 3, "Inventory parameter error.");
                put((byte) 4, "Other error.");
                put((byte) 5, "Save failure.");
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
