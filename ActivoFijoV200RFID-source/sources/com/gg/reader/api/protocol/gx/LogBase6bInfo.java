package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.HexUtils;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class LogBase6bInfo extends Message {
    private int antId;
    private byte[] bTid;
    private byte[] bUser;
    private String readerSerialNumber;
    private int result;
    private int rssi;
    private String tid;
    private String userdata;

    public String getTid() {
        return this.tid;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public byte[] getbTid() {
        return this.bTid;
    }

    public void setbTid(byte[] bArr) {
        this.bTid = bArr;
    }

    public int getAntId() {
        return this.antId;
    }

    public void setAntId(int i) {
        this.antId = i;
    }

    public int getRssi() {
        return this.rssi;
    }

    public void setRssi(int i) {
        this.rssi = i;
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public String getUserdata() {
        return this.userdata;
    }

    public void setUserdata(String str) {
        this.userdata = str;
    }

    public byte[] getbUser() {
        return this.bUser;
    }

    public void setbUser(byte[] bArr) {
        this.bUser = bArr;
    }

    public String getReaderSerialNumber() {
        return this.readerSerialNumber;
    }

    public void setReaderSerialNumber(String str) {
        this.readerSerialNumber = str;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        super.pack();
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        if (this.cData == null || this.cData.length <= 0) {
            return;
        }
        BitBuffer wrap = BitBuffer.wrap(this.cData);
        wrap.position(0);
        byte[] bArr = new byte[8];
        this.bTid = bArr;
        byte[] bArr2 = wrap.get(bArr);
        this.bTid = bArr2;
        if (bArr2.length > 0) {
            this.tid = HexUtils.bytes2HexString(bArr2);
        }
        this.antId = wrap.getIntUnsigned(8);
        while (wrap.position() / 8 < this.cData.length) {
            int intUnsigned = wrap.getIntUnsigned(8);
            if (intUnsigned == 1) {
                this.rssi = wrap.getIntUnsigned(8);
            } else if (intUnsigned == 2) {
                this.result = wrap.getIntUnsigned(8);
            } else if (intUnsigned == 3) {
                int intUnsigned2 = wrap.getIntUnsigned(16);
                byte[] bArr3 = new byte[intUnsigned2];
                this.bUser = bArr3;
                if (intUnsigned2 > 0) {
                    byte[] bArr4 = wrap.get(bArr3);
                    this.bUser = bArr4;
                    this.userdata = HexUtils.bytes2HexString(bArr4);
                }
            }
        }
    }

    public String toString() {
        return "LogBase6bInfo{tid='" + this.tid + "', bTid=" + Arrays.toString(this.bTid) + ", antId=" + this.antId + ", rssi=" + this.rssi + ", result=" + this.result + ", userdata='" + this.userdata + "', bUser=" + Arrays.toString(this.bUser) + ", readerSerialNumber='" + this.readerSerialNumber + "'}";
    }

    public String toHexString() {
        return "HexString{" + HexUtils.bytes2HexString(this.cData) + '}';
    }
}
