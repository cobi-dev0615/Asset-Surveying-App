package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.HexUtils;
import com.gg.reader.api.utils.StringUtils;

/* loaded from: classes2.dex */
public class ParamEpcFilter extends Parameter {
    private int area;
    private byte[] bData;
    private int bitLength;
    private int bitStart;
    private String hexData;

    public ParamEpcFilter() {
    }

    public ParamEpcFilter(int i, int i2, int i3, String str) {
        this.area = i;
        this.bitStart = i2;
        this.bitLength = i3;
        this.hexData = str;
        if (StringUtils.isNullOfEmpty(str)) {
            return;
        }
        this.bData = HexUtils.hexString2Bytes(this.hexData);
    }

    public int getArea() {
        return this.area;
    }

    public void setArea(int i) {
        this.area = i;
    }

    public int getBitStart() {
        return this.bitStart;
    }

    public void setBitStart(int i) {
        this.bitStart = i;
    }

    public int getBitLength() {
        return this.bitLength;
    }

    public void setBitLength(int i) {
        this.bitLength = i;
    }

    public String getHexData() {
        return this.hexData;
    }

    public void setHexData(String str) {
        if (StringUtils.isNullOfEmpty(str)) {
            return;
        }
        this.hexData = str;
        this.bData = HexUtils.hexString2Bytes(str);
    }

    public byte[] getbData() {
        return this.bData;
    }

    public void setbData(byte[] bArr) {
        this.bData = bArr;
    }

    public ParamEpcFilter(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        try {
            BitBuffer wrap = BitBuffer.wrap(bArr);
            wrap.position(0);
            this.area = wrap.getIntUnsigned(8);
            this.bitStart = wrap.getIntUnsigned(16);
            int intUnsigned = wrap.getIntUnsigned(8);
            this.bitLength = intUnsigned;
            int i = intUnsigned / 8;
            byte[] bArr2 = new byte[i];
            this.bData = bArr2;
            if (i > 0) {
                byte[] bArr3 = wrap.get(bArr2);
                this.bData = bArr3;
                this.hexData = HexUtils.bytes2HexString(bArr3);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Parameter
    public byte[] toBytes() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putLong(this.area, 8);
        allocateDynamic.putLong(this.bitStart, 16);
        allocateDynamic.putLong(this.bitLength, 8);
        allocateDynamic.put(this.bData);
        return allocateDynamic.asByteArray();
    }
}
