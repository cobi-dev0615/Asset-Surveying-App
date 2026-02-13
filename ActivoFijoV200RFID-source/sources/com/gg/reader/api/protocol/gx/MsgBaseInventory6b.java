package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.HexUtils;
import com.gg.reader.api.utils.StringUtils;
import java.util.Arrays;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgBaseInventory6b extends Message {
    private Long antennaEnable;
    private int area;
    private byte[] bMatchTid;
    private String hexMatchTid;
    private int inventoryMode;
    private Param6bReadUserdata readUserdata;

    public MsgBaseInventory6b() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_BASE;
            this.msgType.msgId = (byte) 64;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgBaseInventory6b(byte[] bArr) {
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
                this.area = wrap.getIntUnsigned(8);
                while (wrap.position() / 8 < bArr.length) {
                    byte b = wrap.getByte();
                    if (b == 1) {
                        byte[] bArr2 = new byte[2];
                        wrap.get(bArr2);
                        this.readUserdata = new Param6bReadUserdata(bArr2);
                    } else if (b == 2) {
                        byte[] bArr3 = wrap.get(new byte[8]);
                        this.bMatchTid = bArr3;
                        this.hexMatchTid = HexUtils.bytes2HexString(bArr3);
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

    public int getArea() {
        return this.area;
    }

    public void setArea(int i) {
        this.area = i;
    }

    public Param6bReadUserdata getReadUserdata() {
        return this.readUserdata;
    }

    public void setReadUserdata(Param6bReadUserdata param6bReadUserdata) {
        this.readUserdata = param6bReadUserdata;
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

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putLong(this.antennaEnable.longValue(), 32);
        allocateDynamic.putLong(this.inventoryMode, 8);
        allocateDynamic.putLong(this.area, 8);
        if (this.readUserdata != null) {
            allocateDynamic.putInt(1, 8);
            allocateDynamic.put(this.readUserdata.toBytes());
        }
        byte[] bArr = this.bMatchTid;
        if (bArr != null && bArr.length > 0) {
            allocateDynamic.putInt(2, 8);
            allocateDynamic.put(this.bMatchTid);
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgBaseInventory6b.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Antenna port parameter error.");
                put((byte) 2, "Read parameter error.");
                put((byte) 3, "Userdata parameter error.");
                put((byte) 4, "Other error.");
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
        return "MsgBaseInventory6b{antennaEnable=" + this.antennaEnable + ", inventoryMode=" + this.inventoryMode + ", area=" + this.area + ", readUserdata=" + this.readUserdata + ", hexMatchTid='" + this.hexMatchTid + "', bMatchTid=" + Arrays.toString(this.bMatchTid) + '}';
    }
}
