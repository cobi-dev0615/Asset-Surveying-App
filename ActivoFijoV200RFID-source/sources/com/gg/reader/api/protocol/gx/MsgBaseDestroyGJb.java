package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.HexUtils;
import com.gg.reader.api.utils.StringUtils;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgBaseDestroyGJb extends Message {
    private Long antennaEnable;
    private ParamEpcFilter filter;
    private String hexPassword;
    private int safeCertificationFlag;

    public MsgBaseDestroyGJb() {
        this.safeCertificationFlag = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_BASE;
            this.msgType.msgId = (byte) 99;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgBaseDestroyGJb(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.antennaEnable = Long.valueOf(wrap.getLongUnsigned(32));
                while (wrap.position() / 8 < bArr.length) {
                    byte b = wrap.getByte();
                    if (b == 1) {
                        int intUnsigned = wrap.getIntUnsigned(16);
                        byte[] bArr2 = new byte[intUnsigned];
                        if (intUnsigned > 0) {
                            wrap.get(bArr2);
                            this.filter = new ParamEpcFilter(bArr2);
                        }
                    } else if (b == 2) {
                        this.hexPassword = HexUtils.int2Hex(wrap.getIntUnsigned(32));
                    } else if (b == 3) {
                        this.safeCertificationFlag = wrap.getIntUnsigned(8);
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

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putLong(this.antennaEnable.longValue(), 32);
        if (this.filter != null) {
            allocateDynamic.putInt(1, 8);
            byte[] bytes = this.filter.toBytes();
            allocateDynamic.putInt(bytes.length, 16);
            allocateDynamic.put(bytes);
        }
        if (!StringUtils.isNullOfEmpty(this.hexPassword)) {
            allocateDynamic.put(2, 8);
            allocateDynamic.put(HexUtils.hexString2Bytes(this.hexPassword));
        }
        if (Integer.MAX_VALUE != this.safeCertificationFlag) {
            allocateDynamic.put(3, 8);
            allocateDynamic.put(this.safeCertificationFlag, 8);
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgBaseDestroyGJb.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Antenna port parameter error.");
                put((byte) 2, "Filter parameter error.");
                put((byte) 3, "CRC check error.");
                put((byte) 4, "Underpower error.");
                put((byte) 5, "Destroy password error.");
                put((byte) 6, "Permission denied.");
                put((byte) 7, "Identify failure.");
                put((byte) 8, "Other error.");
                put((byte) 9, "Label is missing.");
                put((byte) 10, "Command error.");
            }
        };
        if (this.cData == null || this.cData.length != 1) {
            return;
        }
        setRtCode(this.cData[0]);
        if (hashtable.containsKey(Byte.valueOf(this.cData[0]))) {
            setRtMsg(hashtable.get(Byte.valueOf(this.cData[0])));
        }
    }
}
