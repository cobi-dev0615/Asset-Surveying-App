package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgAppGetReaderInfo extends Message {
    private String appCompileTime;
    private String appVersions;
    private String baseCompileTime;
    private long powerOnTime;
    private String readerSerialNumber;
    private String systemVersions;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgAppGetReaderInfo() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 0;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppGetReaderInfo(byte[] bArr) {
        this();
        int intUnsigned;
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                int intUnsigned2 = wrap.getIntUnsigned(16);
                if (intUnsigned2 > 0) {
                    this.readerSerialNumber = new String(wrap.get(new byte[intUnsigned2]), "ASCII");
                }
                this.powerOnTime = wrap.getLongUnsigned(32);
                int intUnsigned3 = wrap.getIntUnsigned(16);
                if (intUnsigned3 > 0) {
                    this.baseCompileTime = new String(wrap.get(new byte[intUnsigned3]), "ASCII");
                }
                while (wrap.position() / 8 < bArr.length) {
                    byte b = wrap.getByte();
                    if (b == 1) {
                        this.appVersions = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
                    } else if (b == 2) {
                        int intUnsigned4 = wrap.getIntUnsigned(16);
                        if (intUnsigned4 > 0) {
                            this.systemVersions = new String(wrap.get(new byte[intUnsigned4]), "ASCII");
                        }
                    } else if (b == 3 && (intUnsigned = wrap.getIntUnsigned(16)) > 0) {
                        this.appCompileTime = new String(wrap.get(new byte[intUnsigned]), "ASCII");
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public String getAppVersions() {
        return this.appVersions;
    }

    public void setAppVersions(String str) {
        this.appVersions = str;
    }

    public String getSystemVersions() {
        return this.systemVersions;
    }

    public void setSystemVersions(String str) {
        this.systemVersions = str;
    }

    public String getReaderSerialNumber() {
        return this.readerSerialNumber;
    }

    public void setReaderSerialNumber(String str) {
        this.readerSerialNumber = str;
    }

    public long getPowerOnTime() {
        return this.powerOnTime;
    }

    public void setPowerOnTime(long j) {
        this.powerOnTime = j;
    }

    public String getBaseCompileTime() {
        return this.baseCompileTime;
    }

    public void setBaseCompileTime(String str) {
        this.baseCompileTime = str;
    }

    public String getAppCompileTime() {
        return this.appCompileTime;
    }

    public void setAppCompileTime(String str) {
        this.appCompileTime = str;
    }

    public String getFormatPowerOnTime() {
        long powerOnTime = getPowerOnTime() * 1000;
        return (powerOnTime / 86400000) + " days " + ((powerOnTime % 86400000) / 3600000) + " hours " + ((powerOnTime % 3600000) / 60000) + " minutes " + ((powerOnTime % 60000) / 1000) + " seconds ";
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            String str = this.readerSerialNumber;
            if (str != null) {
                allocateDynamic.putInt(str.length(), 16);
                allocateDynamic.put(this.readerSerialNumber);
            }
            allocateDynamic.put(this.powerOnTime, 32);
            String str2 = this.baseCompileTime;
            if (str2 != null) {
                allocateDynamic.putInt(str2.length(), 16);
                allocateDynamic.put(this.baseCompileTime);
            }
            if (this.appVersions != null) {
                allocateDynamic.putInt(1, 8);
                for (String str3 : this.appVersions.split("\\.")) {
                    allocateDynamic.putInt(Integer.parseInt(str3), 8);
                }
            }
            if (this.systemVersions != null) {
                allocateDynamic.putInt(2, 8);
                allocateDynamic.putInt(this.systemVersions.length(), 16);
                allocateDynamic.put(this.systemVersions);
            }
            if (this.appCompileTime != null) {
                allocateDynamic.putInt(3, 8);
                allocateDynamic.putInt(this.appCompileTime.length(), 16);
                allocateDynamic.put(this.appCompileTime);
            }
            this.cData = allocateDynamic.asByteArray();
            this.dataLen = this.cData.length;
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        int intUnsigned;
        if (this.cData == null || this.cData.length <= 0) {
            return;
        }
        BitBuffer wrap = BitBuffer.wrap(this.cData);
        wrap.position(0);
        try {
            int intUnsigned2 = wrap.getIntUnsigned(16);
            if (intUnsigned2 > 0) {
                this.readerSerialNumber = new String(wrap.get(new byte[intUnsigned2]), "ASCII");
            }
            this.powerOnTime = wrap.getLongUnsigned(32);
            int intUnsigned3 = wrap.getIntUnsigned(16);
            if (intUnsigned3 > 0) {
                this.baseCompileTime = new String(wrap.get(new byte[intUnsigned3]), "ASCII");
            }
            while (wrap.position() / 8 < this.cData.length) {
                byte b = wrap.getByte();
                if (b == 1) {
                    this.appVersions = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
                } else if (b == 2) {
                    int intUnsigned4 = wrap.getIntUnsigned(16);
                    if (intUnsigned4 > 0) {
                        this.systemVersions = new String(wrap.get(new byte[intUnsigned4]), "ASCII");
                    }
                } else if (b == 3 && (intUnsigned = wrap.getIntUnsigned(16)) > 0) {
                    this.appCompileTime = new String(wrap.get(new byte[intUnsigned]), "ASCII");
                }
            }
        } catch (Exception unused) {
        }
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgAppGetReaderInfo{readerSerialNumber='" + this.readerSerialNumber + "', powerOnTime=" + this.powerOnTime + ", baseCompileTime='" + this.baseCompileTime + "', appVersions='" + this.appVersions + "', systemVersions='" + this.systemVersions + "', appCompileTime='" + this.appCompileTime + "'}";
    }
}
