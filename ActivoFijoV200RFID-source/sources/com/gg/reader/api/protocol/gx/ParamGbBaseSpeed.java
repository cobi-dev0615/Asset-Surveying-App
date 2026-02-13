package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class ParamGbBaseSpeed extends Parameter {
    int LS;
    int RLC;
    int RLF;
    int Tc;

    public ParamGbBaseSpeed() {
    }

    public ParamGbBaseSpeed(int i, int i2, int i3, int i4) {
        this.Tc = i;
        this.LS = i2;
        this.RLF = i3;
        this.RLC = i4;
    }

    public int getTc() {
        return this.Tc;
    }

    public void setTc(int i) {
        this.Tc = i;
    }

    public int getLS() {
        return this.LS;
    }

    public void setLS(int i) {
        this.LS = i;
    }

    public int getRLF() {
        return this.RLF;
    }

    public void setRLF(int i) {
        this.RLF = i;
    }

    public int getRLC() {
        return this.RLC;
    }

    public void setRLC(int i) {
        this.RLC = i;
    }

    public ParamGbBaseSpeed(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        try {
            BitBuffer wrap = BitBuffer.wrap(bArr);
            wrap.position(0);
            this.Tc = wrap.getIntUnsigned(1);
            this.LS = wrap.getIntUnsigned(1);
            this.RLF = wrap.getIntUnsigned(4);
            this.RLC = wrap.getIntUnsigned(2);
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Parameter
    public byte[] toBytes() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putLong(this.Tc, 1);
        allocateDynamic.putLong(this.LS, 1);
        allocateDynamic.putLong(this.RLF, 4);
        allocateDynamic.putLong(this.RLC, 2);
        return allocateDynamic.asByteArray();
    }

    public String toString() {
        return "ParamGbBaseSpeed{Tc=" + this.Tc + ", LS=" + this.LS + ", RLF=" + this.RLF + ", RLC=" + this.RLC + '}';
    }
}
