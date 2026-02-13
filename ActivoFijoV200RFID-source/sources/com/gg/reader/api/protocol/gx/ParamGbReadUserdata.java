package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class ParamGbReadUserdata extends Parameter {
    private int childArea;
    private int len;
    private int start;

    public ParamGbReadUserdata() {
    }

    public ParamGbReadUserdata(int i, int i2, int i3) {
        this.childArea = i;
        this.start = i2;
        this.len = i3;
    }

    public ParamGbReadUserdata(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        BitBuffer wrap = BitBuffer.wrap(bArr);
        wrap.position(0);
        this.childArea = wrap.getIntUnsigned(8);
        this.start = wrap.getIntUnsigned(16);
        this.len = wrap.getIntUnsigned(8);
    }

    public int getChildArea() {
        return this.childArea;
    }

    public void setChildArea(int i) {
        this.childArea = i;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int i) {
        this.start = i;
    }

    public int getLen() {
        return this.len;
    }

    public void setLen(int i) {
        this.len = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Parameter
    public byte[] toBytes() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putInt(this.childArea, 8);
        allocateDynamic.putInt(this.start, 16);
        allocateDynamic.putInt(this.len, 8);
        return allocateDynamic.asByteArray();
    }
}
