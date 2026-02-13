package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.HexUtils;
import com.gg.reader.api.utils.StringUtils;

/* loaded from: classes2.dex */
public class ParamEncipheredData extends Parameter {
    private byte[] bData;
    private int bitLength;
    private String hexData;

    public ParamEncipheredData() {
    }

    public ParamEncipheredData(int i, String str) {
        this.bitLength = i;
        this.hexData = str;
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

    public ParamEncipheredData(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        try {
            BitBuffer wrap = BitBuffer.wrap(bArr);
            wrap.position(0);
            int intUnsigned = wrap.getIntUnsigned(16);
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
        allocateDynamic.putLong(this.bitLength, 16);
        allocateDynamic.put(this.bData);
        return allocateDynamic.asByteArray();
    }
}
