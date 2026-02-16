package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class ActionParamSuccess extends Parameter {
    private int gpo1;
    private int gpo2;
    private int gpo3;
    private int gpo4;
    private int keepTime;

    public ActionParamSuccess() {
        this.keepTime = 0;
        this.gpo1 = Integer.MAX_VALUE;
        this.gpo2 = Integer.MAX_VALUE;
        this.gpo3 = Integer.MAX_VALUE;
        this.gpo4 = Integer.MAX_VALUE;
    }

    public ActionParamSuccess(byte[] bArr) {
        this.keepTime = 0;
        this.gpo1 = Integer.MAX_VALUE;
        this.gpo2 = Integer.MAX_VALUE;
        this.gpo3 = Integer.MAX_VALUE;
        this.gpo4 = Integer.MAX_VALUE;
        if (bArr == null || bArr.length == 0) {
            return;
        }
        BitBuffer wrap = BitBuffer.wrap(bArr);
        wrap.position(0);
        this.keepTime = wrap.getIntUnsigned(16);
        while (wrap.position() / 8 < bArr.length) {
            int intUnsigned = wrap.getIntUnsigned(8);
            if (intUnsigned == 1) {
                this.gpo1 = wrap.getIntUnsigned(8);
            } else if (intUnsigned == 2) {
                this.gpo2 = wrap.getIntUnsigned(8);
            } else if (intUnsigned == 3) {
                this.gpo3 = wrap.getIntUnsigned(8);
            } else if (intUnsigned == 4) {
                this.gpo4 = wrap.getIntUnsigned(8);
            }
        }
    }

    public int getKeepTime() {
        return this.keepTime;
    }

    public void setKeepTime(int i) {
        this.keepTime = i;
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

    @Override // com.gg.reader.api.protocol.gx.Parameter
    public byte[] toBytes() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putLong(this.keepTime, 16);
        if (Integer.MAX_VALUE != this.gpo1) {
            allocateDynamic.putInt(1, 8);
            allocateDynamic.putInt(this.gpo1, 8);
        }
        if (Integer.MAX_VALUE != this.gpo2) {
            allocateDynamic.putInt(2, 8);
            allocateDynamic.putInt(this.gpo2, 8);
        }
        if (Integer.MAX_VALUE != this.gpo3) {
            allocateDynamic.putInt(3, 8);
            allocateDynamic.putInt(this.gpo3, 8);
        }
        if (Integer.MAX_VALUE != this.gpo4) {
            allocateDynamic.putInt(4, 8);
            allocateDynamic.putInt(this.gpo4, 8);
        }
        return allocateDynamic.asByteArray();
    }

    public String toString() {
        return "ActionParamSuccess{keepTime=" + this.keepTime + ", gpo1=" + this.gpo1 + ", gpo2=" + this.gpo2 + ", gpo3=" + this.gpo3 + ", gpo4=" + this.gpo4 + '}';
    }
}
