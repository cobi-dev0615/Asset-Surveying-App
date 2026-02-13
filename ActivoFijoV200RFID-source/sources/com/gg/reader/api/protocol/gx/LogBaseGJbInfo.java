package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.HexUtils;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class LogBaseGJbInfo extends Message {
    private int antId;
    private byte[] bEpc;
    private byte[] bTid;
    private byte[] bUser;
    private String epc;
    private int pc;
    private String readerSerialNumber;
    private int result;
    private int rssi;
    private String tid;
    private String userdata;

    public String getEpc() {
        return this.epc;
    }

    public void setEpc(String str) {
        this.epc = str;
    }

    public byte[] getbEpc() {
        return this.bEpc;
    }

    public void setbEpc(byte[] bArr) {
        this.bEpc = bArr;
    }

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

    public int getPc() {
        return this.pc;
    }

    public void setPc(int i) {
        this.pc = i;
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
    public void ackUnpack() {
        if (this.cData == null || this.cData.length <= 0) {
            return;
        }
        BitBuffer wrap = BitBuffer.wrap(this.cData);
        wrap.position(0);
        byte[] bArr = new byte[wrap.getIntUnsigned(16)];
        this.bEpc = bArr;
        byte[] bArr2 = wrap.get(bArr);
        this.bEpc = bArr2;
        if (bArr2.length > 0) {
            this.epc = HexUtils.bytes2HexString(bArr2);
        }
        this.pc = wrap.getIntUnsigned(16);
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
                this.bTid = bArr3;
                if (intUnsigned2 > 0) {
                    byte[] bArr4 = wrap.get(bArr3);
                    this.bTid = bArr4;
                    this.tid = HexUtils.bytes2HexString(bArr4);
                }
            } else if (intUnsigned == 4) {
                int intUnsigned3 = wrap.getIntUnsigned(16);
                byte[] bArr5 = new byte[intUnsigned3];
                this.bUser = bArr5;
                if (intUnsigned3 > 0) {
                    byte[] bArr6 = wrap.get(bArr5);
                    this.bUser = bArr6;
                    this.userdata = HexUtils.bytes2HexString(bArr6);
                }
            }
        }
    }

    public String toString() {
        return "LogBaseGJbInfo{epc='" + this.epc + "', bEpc=" + Arrays.toString(this.bEpc) + ", tid='" + this.tid + "', bTid=" + Arrays.toString(this.bTid) + ", pc=" + this.pc + ", antId=" + this.antId + ", rssi=" + this.rssi + ", result=" + this.result + ", userdata='" + this.userdata + "', bUser=" + Arrays.toString(this.bUser) + ", readerSerialNumber='" + this.readerSerialNumber + "'}";
    }

    public String toHexString() {
        return "HexString{" + HexUtils.bytes2HexString(this.cData) + '}';
    }
}
