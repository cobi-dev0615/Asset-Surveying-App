package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class ParamEpcReadEpc extends Parameter {
    private int len;
    private int start;

    public ParamEpcReadEpc() {
    }

    public ParamEpcReadEpc(int i, int i2) {
        this.start = i;
        this.len = i2;
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

    public ParamEpcReadEpc(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        BitBuffer wrap = BitBuffer.wrap(bArr);
        wrap.position(0);
        this.start = wrap.getIntUnsigned(16);
        this.len = wrap.getIntUnsigned(8);
    }

    @Override // com.gg.reader.api.protocol.gx.Parameter
    public byte[] toBytes() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putLong(this.start, 16);
        allocateDynamic.putLong(this.len, 8);
        return allocateDynamic.asByteArray();
    }
}
