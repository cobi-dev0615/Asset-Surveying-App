package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.HexUtils;
import com.gg.reader.api.utils.StringUtils;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgBaseWriteGb extends Message {
    private Long antennaEnable;
    private int area;
    private byte[] bwriteData;
    private int errorIndex;
    private int fdMicrochipInitMode;
    private ParamEpcFilter filter;
    private String hexPassword;
    private String hexWriteData;
    private int safeCertificationFlag;
    private int start;
    private int stayCarrierWave;

    public MsgBaseWriteGb() {
        this.safeCertificationFlag = Integer.MAX_VALUE;
        this.fdMicrochipInitMode = Integer.MAX_VALUE;
        this.stayCarrierWave = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_BASE;
            this.msgType.msgId = (byte) 81;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgBaseWriteGb(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.antennaEnable = Long.valueOf(wrap.getLongUnsigned(32));
                this.area = wrap.getIntUnsigned(8);
                this.start = wrap.getIntUnsigned(16);
                int intUnsigned = wrap.getIntUnsigned(16);
                if (intUnsigned > 0) {
                    byte[] bArr2 = wrap.get(new byte[intUnsigned]);
                    this.bwriteData = bArr2;
                    this.hexWriteData = HexUtils.bytes2HexString(bArr2);
                }
                while (wrap.position() / 8 < bArr.length) {
                    byte b = wrap.getByte();
                    if (b == 1) {
                        int intUnsigned2 = wrap.getIntUnsigned(16);
                        byte[] bArr3 = new byte[intUnsigned2];
                        if (intUnsigned2 > 0) {
                            wrap.get(bArr3);
                            this.filter = new ParamEpcFilter(bArr3);
                        }
                    } else if (b == 2) {
                        byte[] bArr4 = new byte[4];
                        wrap.get(bArr4);
                        this.hexPassword = HexUtils.bytes2HexString(bArr4);
                    } else if (b == 3) {
                        this.safeCertificationFlag = wrap.getIntUnsigned(8);
                    } else if (b == 4) {
                        this.fdMicrochipInitMode = wrap.getIntUnsigned(8);
                    } else if (b == 5) {
                        this.stayCarrierWave = wrap.getIntUnsigned(8);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public Long getAntennaEnable() {
        return this.antennaEnable;
    }

    public void setAntennaEnable(Long l) {
        this.antennaEnable = l;
    }

    public int getArea() {
        return this.area;
    }

    public void setArea(int i) {
        this.area = i;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int i) {
        this.start = i;
    }

    public String getHexWriteData() {
        return this.hexWriteData;
    }

    public void setHexWriteData(String str) {
        if (StringUtils.isNullOfEmpty(str)) {
            return;
        }
        this.hexWriteData = str;
        this.bwriteData = HexUtils.hexString2Bytes(str);
    }

    public byte[] getBwriteData() {
        return this.bwriteData;
    }

    public void setBwriteData(byte[] bArr) {
        this.bwriteData = bArr;
    }

    public ParamEpcFilter getFilter() {
        return this.filter;
    }

    public void setFilter(ParamEpcFilter paramEpcFilter) {
        this.filter = paramEpcFilter;
    }

    public String getHexPassword() {
        return this.hexPassword;
    }

    public void setHexPassword(String str) {
        this.hexPassword = str;
    }

    public int getSafeCertificationFlag() {
        return this.safeCertificationFlag;
    }

    public void setSafeCertificationFlag(int i) {
        this.safeCertificationFlag = i;
    }

    public int getFdMicrochipInitMode() {
        return this.fdMicrochipInitMode;
    }

    public void setFdMicrochipInitMode(int i) {
        this.fdMicrochipInitMode = i;
    }

    public int getStayCarrierWave() {
        return this.stayCarrierWave;
    }

    public void setStayCarrierWave(int i) {
        this.stayCarrierWave = i;
    }

    public int getErrorIndex() {
        return this.errorIndex;
    }

    public void setErrorIndex(int i) {
        this.errorIndex = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putLong(this.antennaEnable.longValue(), 32);
        allocateDynamic.putLong(this.area, 8);
        allocateDynamic.putLong(this.start, 16);
        byte[] bArr = this.bwriteData;
        if (bArr != null && bArr.length > 0) {
            allocateDynamic.putInt(bArr.length, 16);
            allocateDynamic.put(this.bwriteData);
        }
        if (this.filter != null) {
            allocateDynamic.putInt(1, 8);
            byte[] bytes = this.filter.toBytes();
            allocateDynamic.putInt(bytes.length, 16);
            allocateDynamic.put(bytes);
        }
        if (!StringUtils.isNullOfEmpty(this.hexPassword)) {
            allocateDynamic.putInt(2, 8);
            allocateDynamic.put(HexUtils.hexString2Bytes(this.hexPassword));
        }
        if (Integer.MAX_VALUE != this.safeCertificationFlag) {
            allocateDynamic.putInt(3, 8);
            allocateDynamic.putInt(this.safeCertificationFlag, 8);
        }
        if (Integer.MAX_VALUE != this.fdMicrochipInitMode) {
            allocateDynamic.putInt(4, 8);
            allocateDynamic.putInt(this.fdMicrochipInitMode, 8);
        }
        if (Integer.MAX_VALUE != this.stayCarrierWave) {
            allocateDynamic.putInt(5, 8);
            allocateDynamic.putInt(this.stayCarrierWave, 8);
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgBaseWriteGb.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Antenna port parameter error.");
                put((byte) 2, "Filter parameter error.");
                put((byte) 3, "Write parameter error.");
                put((byte) 4, "CRC check error.");
                put((byte) 5, "Underpower error.");
                put((byte) 6, "Data area overflow.");
                put((byte) 7, "Data area locked.");
                put((byte) 8, "Access password error.");
                put((byte) 9, "Permission denied.");
                put((byte) 10, "Identify failure.");
                put((byte) 11, "Other error.");
                put((byte) 12, "Label is missing.");
                put((byte) 13, "Send command error.");
            }
        };
        if (this.cData != null && this.cData.length >= 1) {
            setRtCode(this.cData[0]);
            if (hashtable.containsKey(Byte.valueOf(this.cData[0]))) {
                setRtMsg(hashtable.get(Byte.valueOf(this.cData[0])));
            }
        }
        if (this.cData == null || this.cData.length <= 1) {
            return;
        }
        BitBuffer wrap = BitBuffer.wrap(this.cData);
        wrap.position(8);
        if (wrap.getIntUnsigned(8) == 1) {
            this.errorIndex = wrap.getIntUnsigned(16);
        }
    }
}
