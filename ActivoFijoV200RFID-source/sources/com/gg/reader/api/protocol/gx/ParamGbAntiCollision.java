package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class ParamGbAntiCollision extends Parameter {
    int CCN;
    int CIN;

    public ParamGbAntiCollision() {
    }

    public ParamGbAntiCollision(int i, int i2) {
        this.CIN = i;
        this.CCN = i2;
    }

    public int getCIN() {
        return this.CIN;
    }

    public void setCIN(int i) {
        this.CIN = i;
    }

    public int getCCN() {
        return this.CCN;
    }

    public void setCCN(int i) {
        this.CCN = i;
    }

    public ParamGbAntiCollision(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        try {
            BitBuffer wrap = BitBuffer.wrap(bArr);
            wrap.position(0);
            this.CIN = wrap.getIntUnsigned(4);
            this.CCN = wrap.getIntUnsigned(4);
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Parameter
    public byte[] toBytes() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putLong(this.CIN, 4);
        allocateDynamic.putLong(this.CCN, 4);
        return allocateDynamic.asByteArray();
    }

    public String toString() {
        return "ParamGbAntiCollision{CIN=" + this.CIN + ", CCN=" + this.CCN + '}';
    }
}
