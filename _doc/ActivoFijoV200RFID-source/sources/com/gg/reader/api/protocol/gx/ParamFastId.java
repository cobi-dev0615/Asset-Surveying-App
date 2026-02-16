package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class ParamFastId extends Parameter {
    private int fastId;
    private int tagFoucs;

    public ParamFastId() {
    }

    public ParamFastId(int i, int i2) {
        this.fastId = i;
        this.tagFoucs = i2;
    }

    public ParamFastId(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        this.fastId = bArr[0];
        this.tagFoucs = bArr[1];
    }

    public int getFastId() {
        return this.fastId;
    }

    public void setFastId(int i) {
        this.fastId = i;
    }

    public int getTagFoucs() {
        return this.tagFoucs;
    }

    public void setTagFoucs(int i) {
        this.tagFoucs = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Parameter
    public byte[] toBytes() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putInt(this.fastId, 8);
        allocateDynamic.putInt(this.tagFoucs, 8);
        return allocateDynamic.asByteArray();
    }
}
