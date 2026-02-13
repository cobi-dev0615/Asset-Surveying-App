package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.HexUtils;
import com.gg.reader.api.utils.StringUtils;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgBaseInventoryGJb extends Message {
    private Long antennaEnable;
    private ParamEpcFilter filter;
    private String hexPassword;
    private int inventoryMode;
    private ParamEpcReadTid readTid;
    private ParamEpcReadUserdata readUserdata;
    private int safeCertificationFlag;

    public MsgBaseInventoryGJb() {
        this.safeCertificationFlag = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_BASE;
            this.msgType.msgId = (byte) 96;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgBaseInventoryGJb(byte[] bArr) {
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
                        byte[] bArr3 = new byte[2];
                        wrap.get(bArr3);
                        this.readTid = new ParamEpcReadTid(bArr3);
                    } else if (b == 3) {
                        byte[] bArr4 = new byte[3];
                        wrap.get(bArr4);
                        this.readUserdata = new ParamEpcReadUserdata(bArr4);
                    } else if (b == 5) {
                        byte[] bArr5 = new byte[4];
                        wrap.get(bArr5);
                        this.hexPassword = HexUtils.bytes2HexString(bArr5);
                    } else if (b == 6) {
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

    public ParamEpcReadTid getReadTid() {
        return this.readTid;
    }

    public void setReadTid(ParamEpcReadTid paramEpcReadTid) {
        this.readTid = paramEpcReadTid;
    }

    public ParamEpcReadUserdata getReadUserdata() {
        return this.readUserdata;
    }

    public void setReadUserdata(ParamEpcReadUserdata paramEpcReadUserdata) {
        this.readUserdata = paramEpcReadUserdata;
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
        allocateDynamic.putLong(this.inventoryMode, 8);
        if (this.filter != null) {
            allocateDynamic.putInt(1, 8);
            byte[] bytes = this.filter.toBytes();
            allocateDynamic.putInt(bytes.length, 16);
            allocateDynamic.put(bytes);
        }
        if (this.readTid != null) {
            allocateDynamic.putInt(2, 8);
            allocateDynamic.put(this.readTid.toBytes());
        }
        if (this.readUserdata != null) {
            allocateDynamic.putInt(3, 8);
            allocateDynamic.put(this.readUserdata.toBytes());
        }
        if (!StringUtils.isNullOfEmpty(this.hexPassword)) {
            allocateDynamic.putInt(5, 8);
            allocateDynamic.put(HexUtils.hexString2Bytes(this.hexPassword));
        }
        if (Integer.MAX_VALUE != this.safeCertificationFlag) {
            allocateDynamic.put(6, 8);
            allocateDynamic.put(this.safeCertificationFlag, 8);
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgBaseInventoryGJb.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Antenna port parameter error.");
                put((byte) 2, "Filter parameter error.");
                put((byte) 3, "Tid parameter error.");
                put((byte) 4, "Userdata parameter error.");
                put((byte) 5, "Other error.");
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

    public String toString() {
        return "MsgBaseInventoryGb{antennaEnable=" + this.antennaEnable + ", inventoryMode=" + this.inventoryMode + ", filter=" + this.filter + ", readTid=" + this.readTid + ", readUserdata=" + this.readUserdata + ", hexPassword='" + this.hexPassword + "', safeCertificationFlag=" + this.safeCertificationFlag + '}';
    }
}
