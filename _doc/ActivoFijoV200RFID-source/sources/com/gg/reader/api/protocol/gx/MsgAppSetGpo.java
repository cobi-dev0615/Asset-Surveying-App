package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgAppSetGpo extends Message {
    private int gpo1;
    private int gpo2;
    private int gpo3;
    private int gpo4;
    private int gpo5;
    private int gpo6;
    private int gpo7;
    private int gpo8;

    public MsgAppSetGpo() {
        this.gpo1 = Integer.MAX_VALUE;
        this.gpo2 = Integer.MAX_VALUE;
        this.gpo3 = Integer.MAX_VALUE;
        this.gpo4 = Integer.MAX_VALUE;
        this.gpo5 = Integer.MAX_VALUE;
        this.gpo6 = Integer.MAX_VALUE;
        this.gpo7 = Integer.MAX_VALUE;
        this.gpo8 = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 9;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppSetGpo(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                while (wrap.position() / 8 < bArr.length) {
                    switch (wrap.getIntUnsigned(8)) {
                        case 1:
                            this.gpo1 = wrap.getIntUnsigned(8);
                            break;
                        case 2:
                            this.gpo2 = wrap.getIntUnsigned(8);
                            break;
                        case 3:
                            this.gpo3 = wrap.getIntUnsigned(8);
                            break;
                        case 4:
                            this.gpo4 = wrap.getIntUnsigned(8);
                            break;
                        case 5:
                            this.gpo5 = wrap.getIntUnsigned(8);
                            break;
                        case 6:
                            this.gpo6 = wrap.getIntUnsigned(8);
                            break;
                        case 7:
                            this.gpo7 = wrap.getIntUnsigned(8);
                            break;
                        case 8:
                            this.gpo8 = wrap.getIntUnsigned(8);
                            break;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public int getGpo1() {
        return this.gpo1;
    }

    public void setGpo1(int i) {
        this.gpo1 = i;
    }

    public int getGpo2() {
        return this.gpo2;
    }

    public void setGpo2(int i) {
        this.gpo2 = i;
    }

    public int getGpo3() {
        return this.gpo3;
    }

    public void setGpo3(int i) {
        this.gpo3 = i;
    }

    public int getGpo4() {
        return this.gpo4;
    }

    public void setGpo4(int i) {
        this.gpo4 = i;
    }

    public int getGpo5() {
        return this.gpo5;
    }

    public void setGpo5(int i) {
        this.gpo5 = i;
    }

    public int getGpo6() {
        return this.gpo6;
    }

    public void setGpo6(int i) {
        this.gpo6 = i;
    }

    public int getGpo7() {
        return this.gpo7;
    }

    public void setGpo7(int i) {
        this.gpo7 = i;
    }

    public int getGpo8() {
        return this.gpo8;
    }

    public void setGpo8(int i) {
        this.gpo8 = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        if (Integer.MAX_VALUE != this.gpo1) {
            allocateDynamic.putInt(1, 8);
            allocateDynamic.putLong(this.gpo1, 8);
        }
        if (Integer.MAX_VALUE != this.gpo2) {
            allocateDynamic.putInt(2, 8);
            allocateDynamic.putLong(this.gpo2, 8);
        }
        if (Integer.MAX_VALUE != this.gpo3) {
            allocateDynamic.putInt(3, 8);
            allocateDynamic.putLong(this.gpo3, 8);
        }
        if (Integer.MAX_VALUE != this.gpo4) {
            allocateDynamic.putInt(4, 8);
            allocateDynamic.putLong(this.gpo4, 8);
        }
        if (Integer.MAX_VALUE != this.gpo5) {
            allocateDynamic.putInt(5, 8);
            allocateDynamic.putLong(this.gpo5, 8);
        }
        if (Integer.MAX_VALUE != this.gpo6) {
            allocateDynamic.putInt(6, 8);
            allocateDynamic.putLong(this.gpo6, 8);
        }
        if (Integer.MAX_VALUE != this.gpo7) {
            allocateDynamic.putInt(7, 8);
            allocateDynamic.putLong(this.gpo7, 8);
        }
        if (Integer.MAX_VALUE != this.gpo8) {
            allocateDynamic.putInt(8, 8);
            allocateDynamic.putLong(this.gpo8, 8);
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgAppSetGpo.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Port parameter reader hardware is not supported .");
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
