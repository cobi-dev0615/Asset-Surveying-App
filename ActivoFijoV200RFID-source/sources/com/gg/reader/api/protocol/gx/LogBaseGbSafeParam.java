package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class LogBaseGbSafeParam extends Message {
    private int antId;
    private ParamEncipheredData encipheredData;
    private int random;
    private String readerSerialNumber;
    private int safeParam;
    private int tagIdentifier;
    private int token2;

    public int getAntId() {
        return this.antId;
    }

    public void setAntId(int i) {
        this.antId = i;
    }

    public int getSafeParam() {
        return this.safeParam;
    }

    public void setSafeParam(int i) {
        this.safeParam = i;
    }

    public int getTagIdentifier() {
        return this.tagIdentifier;
    }

    public void setTagIdentifier(int i) {
        this.tagIdentifier = i;
    }

    public int getRandom() {
        return this.random;
    }

    public void setRandom(int i) {
        this.random = i;
    }

    public int getToken2() {
        return this.token2;
    }

    public void setToken2(int i) {
        this.token2 = i;
    }

    public ParamEncipheredData getEncipheredData() {
        return this.encipheredData;
    }

    public void setEncipheredData(ParamEncipheredData paramEncipheredData) {
        this.encipheredData = paramEncipheredData;
    }

    public String getReaderSerialNumber() {
        return this.readerSerialNumber;
    }

    public void setReaderSerialNumber(String str) {
        this.readerSerialNumber = str;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        if (this.cData == null || this.cData.length <= 0) {
            return;
        }
        BitBuffer wrap = BitBuffer.wrap(this.cData);
        wrap.position(0);
        this.antId = wrap.getIntUnsigned(8);
        while (wrap.position() / 8 < this.cData.length) {
            int intUnsigned = wrap.getIntUnsigned(8);
            if (intUnsigned == 1) {
                this.safeParam = wrap.getIntUnsigned(48);
            } else if (intUnsigned == 2) {
                this.tagIdentifier = wrap.getIntUnsigned(64);
            } else if (intUnsigned == 3) {
                this.random = wrap.getIntUnsigned(32);
            } else if (intUnsigned == 4) {
                this.token2 = wrap.getIntUnsigned(64);
            } else if (intUnsigned == 5) {
                int intUnsigned2 = wrap.getIntUnsigned(16);
                byte[] bArr = new byte[intUnsigned2];
                if (intUnsigned2 > 0) {
                    wrap.get(bArr);
                    this.encipheredData = new ParamEncipheredData(bArr);
                }
            }
        }
    }

    public String toString() {
        return "LogBaseGbSafeParam{antId=" + this.antId + ", safeParam=" + this.safeParam + ", tagIdentifier=" + this.tagIdentifier + ", random=" + this.random + ", token2=" + this.token2 + ", encipheredData=" + this.encipheredData + ", readerSerialNumber='" + this.readerSerialNumber + "'}";
    }
}
