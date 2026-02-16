package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.HexUtils;
import com.gg.reader.api.utils.StringUtils;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgBaseWrite6b extends Message {
    private Long antennaEnable;
    private byte[] bMatchTid;
    private byte[] bwriteData;
    private int errorIndex;
    private String hexMatchTid;
    private String hexWriteData;
    private int start;

    public MsgBaseWrite6b() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_BASE;
            this.msgType.msgId = (byte) 65;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgBaseWrite6b(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.antennaEnable = Long.valueOf(wrap.getLongUnsigned(32));
                byte[] bArr2 = wrap.get(new byte[8]);
                this.bMatchTid = bArr2;
                this.hexMatchTid = HexUtils.bytes2HexString(bArr2);
                this.start = wrap.getIntUnsigned(8);
                int intUnsigned = wrap.getIntUnsigned(16);
                if (intUnsigned > 0) {
                    byte[] bArr3 = wrap.get(new byte[intUnsigned]);
                    this.bwriteData = bArr3;
                    this.hexWriteData = HexUtils.bytes2HexString(bArr3);
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

    public String getHexMatchTid() {
        return this.hexMatchTid;
    }

    public void setHexMatchTid(String str) {
        if (StringUtils.isNullOfEmpty(str)) {
            return;
        }
        this.hexMatchTid = str;
        this.bMatchTid = HexUtils.hexString2Bytes(str);
    }

    public byte[] getbMatchTid() {
        return this.bMatchTid;
    }

    public void setbMatchTid(byte[] bArr) {
        this.bMatchTid = bArr;
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
        allocateDynamic.put(this.bMatchTid);
        allocateDynamic.putLong(this.start, 8);
        byte[] bArr = this.bwriteData;
        if (bArr != null && bArr.length > 0) {
            allocateDynamic.putInt(bArr.length, 16);
            allocateDynamic.put(this.bwriteData);
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgBaseWrite6b.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Antenna port parameter error.");
                put((byte) 2, "Write parameter error.");
                put((byte) 3, "Other error.");
            }
        };
        if (this.cData == null || this.cData.length < 1) {
            return;
        }
        setRtCode(this.cData[0]);
        if (hashtable.containsKey(Byte.valueOf(this.cData[0]))) {
            setRtMsg(hashtable.get(Byte.valueOf(this.cData[0])));
        }
        if (this.cData.length > 1) {
            BitBuffer wrap = BitBuffer.wrap(this.cData);
            wrap.position(8);
            if (wrap.getIntUnsigned(8) == 1) {
                this.errorIndex = wrap.getIntUnsigned(8);
            }
        }
    }
}
