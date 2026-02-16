package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.HexUtils;
import com.gg.reader.api.utils.StringUtils;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgBaseInventoryMonzaQT extends Message {
    private Long antennaEnable;
    private ParamEpcFilter filter;
    private String hexPassword;
    private int inventoryMode;
    private int qtParameter;

    public MsgBaseInventoryMonzaQT() {
        this.qtParameter = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_BASE;
            this.msgType.msgId = (byte) 20;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgBaseInventoryMonzaQT(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.antennaEnable = Long.valueOf(wrap.getLongUnsigned(32));
                this.inventoryMode = wrap.getIntUnsigned(8);
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
                        byte[] bArr3 = new byte[4];
                        wrap.get(bArr3);
                        this.hexPassword = HexUtils.bytes2HexString(bArr3);
                    } else if (b == 3) {
                        this.qtParameter = wrap.getIntUnsigned(16);
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

    public int getInventoryMode() {
        return this.inventoryMode;
    }

    public void setInventoryMode(int i) {
        this.inventoryMode = i;
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

    public int getQtParameter() {
        return this.qtParameter;
    }

    public void setQtParameter(int i) {
        this.qtParameter = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.putLong(this.antennaEnable.longValue(), 32);
            allocateDynamic.putLong(this.inventoryMode, 8);
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
            if (Integer.MAX_VALUE != this.qtParameter) {
                allocateDynamic.putInt(3, 8);
                allocateDynamic.put(this.qtParameter, 16);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgBaseInventoryMonzaQT.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Antenna port parameter error.");
                put((byte) 2, "Filter parameter error.");
                put((byte) 3, "QT parameter error.");
                put((byte) 4, "CRC verify parameter error.");
                put((byte) 5, "Underpower error.");
                put((byte) 6, "Access password error.");
                put((byte) 7, "Other tag errors.");
                put((byte) 8, "Tag missing.");
                put((byte) 9, "Send command error.");
            }
        };
        if (this.cData != null && this.cData.length > 0) {
            setRtCode(this.cData[0]);
            if (hashtable.containsKey(Byte.valueOf(this.cData[0]))) {
                setRtMsg(hashtable.get(Byte.valueOf(this.cData[0])));
            }
        }
        BitBuffer wrap = BitBuffer.wrap(this.cData);
        wrap.position(8);
        if (wrap.getIntUnsigned(8) == 1) {
            this.qtParameter = wrap.getIntUnsigned(16);
        }
    }
}
