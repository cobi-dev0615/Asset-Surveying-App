package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.DateTimeUtils;
import com.gg.reader.api.utils.HexUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class LogBaseEpcInfo extends Message {
    private int antId;
    private byte[] bEpc;
    private byte[] bEpcData;
    private byte[] bRes;
    private byte[] bTid;
    private byte[] bUser;
    private int childAntId;
    private int ctesiusLtu27;
    private int ctesiusLtu31;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String epc;
    private String epcData;
    private Long frequencyPoint;
    private int pc;
    private int phase;
    private String readerSerialNumber;
    private Long replySerialNumber;
    private String reserved;
    private int result;
    private int rssi;
    private String strUtc;
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

    public String getReserved() {
        return this.reserved;
    }

    public void setReserved(String str) {
        this.reserved = str;
    }

    public byte[] getbRes() {
        return this.bRes;
    }

    public void setbRes(byte[] bArr) {
        this.bRes = bArr;
    }

    public int getChildAntId() {
        return this.childAntId;
    }

    public void setChildAntId(int i) {
        this.childAntId = i;
    }

    public String getStrUtc() {
        return this.strUtc;
    }

    public void setStrUtc(String str) {
        this.strUtc = str;
    }

    public Long getFrequencyPoint() {
        return this.frequencyPoint;
    }

    public void setFrequencyPoint(Long l) {
        this.frequencyPoint = l;
    }

    public int getPhase() {
        return this.phase;
    }

    public void setPhase(int i) {
        this.phase = i;
    }

    public String getEpcData() {
        return this.epcData;
    }

    public void setEpcData(String str) {
        this.epcData = str;
    }

    public byte[] getbEpcData() {
        return this.bEpcData;
    }

    public void setbEpcData(byte[] bArr) {
        this.bEpcData = bArr;
    }

    public int getCtesiusLtu27() {
        return this.ctesiusLtu27;
    }

    public void setCtesiusLtu27(int i) {
        this.ctesiusLtu27 = i;
    }

    public int getCtesiusLtu31() {
        return this.ctesiusLtu31;
    }

    public void setCtesiusLtu31(int i) {
        this.ctesiusLtu31 = i;
    }

    public String getReaderSerialNumber() {
        return this.readerSerialNumber;
    }

    public void setReaderSerialNumber(String str) {
        this.readerSerialNumber = str;
    }

    public Long getReplySerialNumber() {
        return this.replySerialNumber;
    }

    public void setReplySerialNumber(Long l) {
        this.replySerialNumber = l;
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
            if (intUnsigned == 17) {
                this.ctesiusLtu27 = wrap.getIntUnsigned(16);
            } else if (intUnsigned == 18) {
                this.ctesiusLtu31 = wrap.getInt(16);
            } else if (intUnsigned == 32) {
                int intUnsigned2 = wrap.getIntUnsigned(16);
                if (intUnsigned2 > 0) {
                    this.readerSerialNumber = new String(wrap.get(new byte[intUnsigned2]), "ASCII");
                }
            } else if (intUnsigned != 34) {
                switch (intUnsigned) {
                    case 1:
                        this.rssi = wrap.getIntUnsigned(8);
                        break;
                    case 2:
                        this.result = wrap.getIntUnsigned(8);
                        break;
                    case 3:
                        int intUnsigned3 = wrap.getIntUnsigned(16);
                        if (intUnsigned3 <= 0) {
                            break;
                        } else {
                            byte[] bArr3 = new byte[intUnsigned3];
                            this.bTid = bArr3;
                            byte[] bArr4 = wrap.get(bArr3);
                            this.bTid = bArr4;
                            this.tid = HexUtils.bytes2HexString(bArr4);
                            break;
                        }
                    case 4:
                        int intUnsigned4 = wrap.getIntUnsigned(16);
                        if (intUnsigned4 <= 0) {
                            break;
                        } else {
                            byte[] bArr5 = new byte[intUnsigned4];
                            this.bUser = bArr5;
                            byte[] bArr6 = wrap.get(bArr5);
                            this.bUser = bArr6;
                            this.userdata = HexUtils.bytes2HexString(bArr6);
                            break;
                        }
                    case 5:
                        int intUnsigned5 = wrap.getIntUnsigned(16);
                        if (intUnsigned5 <= 0) {
                            break;
                        } else {
                            byte[] bArr7 = new byte[intUnsigned5];
                            this.bRes = bArr7;
                            byte[] bArr8 = wrap.get(bArr7);
                            this.bRes = bArr8;
                            this.reserved = HexUtils.bytes2HexString(bArr8);
                            break;
                        }
                    case 6:
                        this.childAntId = wrap.getIntUnsigned(8);
                        break;
                    case 7:
                        this.strUtc = this.dateFormat.format(DateTimeUtils.fromUtcToTimeZone((wrap.getLong(32) * 1000) + (wrap.getLong(32) / 1000), TimeZone.getDefault()));
                        break;
                    case 8:
                        this.frequencyPoint = Long.valueOf(wrap.getLongUnsigned(32));
                        break;
                    case 9:
                        this.phase = wrap.getIntUnsigned(8);
                        break;
                    case 10:
                        try {
                            int intUnsigned6 = wrap.getIntUnsigned(16);
                            if (intUnsigned6 <= 0) {
                                break;
                            } else {
                                byte[] bArr9 = new byte[intUnsigned6];
                                this.bEpcData = bArr9;
                                byte[] bArr10 = wrap.get(bArr9);
                                this.bEpcData = bArr10;
                                this.epcData = HexUtils.bytes2HexString(bArr10);
                                break;
                            }
                        } catch (Exception unused) {
                            break;
                        }
                }
            } else {
                this.replySerialNumber = Long.valueOf(wrap.getLongUnsigned(32));
            }
        }
    }

    public String toString() {
        return "LogBaseEpcInfo{epc='" + this.epc + "', bEpc=" + Arrays.toString(this.bEpc) + ", pc=" + this.pc + ", antId=" + this.antId + ", rssi=" + this.rssi + ", result=" + this.result + ", tid='" + this.tid + "', bTid=" + Arrays.toString(this.bTid) + ", userdata='" + this.userdata + "', bUser=" + Arrays.toString(this.bUser) + ", reserved='" + this.reserved + "', bRes=" + Arrays.toString(this.bRes) + ", childAntId=" + this.childAntId + ", strUtc='" + this.strUtc + "', frequencyPoint=" + this.frequencyPoint + ", phase=" + this.phase + ", epcData='" + this.epcData + "', bEpcData=" + Arrays.toString(this.bEpcData) + ", ctesiusLtu27=" + this.ctesiusLtu27 + ", ctesiusLtu31=" + this.ctesiusLtu31 + ", readerSerialNumber='" + this.readerSerialNumber + "', replySerialNumber=" + this.replySerialNumber + '}';
    }

    public String toHexString() {
        return "HexString{" + HexUtils.bytes2HexString(this.cData) + '}';
    }
}
