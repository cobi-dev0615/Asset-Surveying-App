package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.HexUtils;
import com.gg.reader.api.utils.StringUtils;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgBaseInventoryEpc extends Message {
    private Long antennaEnable;
    private int ctesius;
    private int emSensor;
    private ParamEpcFilter filter;
    private String hexPassword;
    private int inventoryMode;
    private int monzaQtPeek;
    private ParamFastId paramFastId;
    private int quanray;
    private ParamEpcReadEpc readEpc;
    private ParamEpcReadReserved readReserved;
    private ParamEpcReadTid readTid;
    private ParamEpcReadUserdata readUserdata;
    private int rfmicron;
    private int seed;

    public MsgBaseInventoryEpc() {
        this.monzaQtPeek = Integer.MAX_VALUE;
        this.rfmicron = Integer.MAX_VALUE;
        this.emSensor = Integer.MAX_VALUE;
        this.ctesius = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_BASE;
            this.msgType.msgId = (byte) 16;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgBaseInventoryEpc(byte[] bArr) {
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
                    if (b == 18) {
                        this.ctesius = wrap.getIntUnsigned(8);
                    } else if (b == 19) {
                        this.seed = wrap.getIntUnsigned(8);
                    } else if (b != 22) {
                        switch (b) {
                            case 1:
                                byte[] bArr2 = new byte[wrap.getIntUnsigned(16)];
                                wrap.get(bArr2);
                                this.filter = new ParamEpcFilter(bArr2);
                                break;
                            case 2:
                                byte[] bArr3 = new byte[2];
                                wrap.get(bArr3);
                                this.readTid = new ParamEpcReadTid(bArr3);
                                break;
                            case 3:
                                byte[] bArr4 = new byte[3];
                                wrap.get(bArr4);
                                this.readUserdata = new ParamEpcReadUserdata(bArr4);
                                break;
                            case 4:
                                byte[] bArr5 = new byte[3];
                                wrap.get(bArr5);
                                this.readReserved = new ParamEpcReadReserved(bArr5);
                                break;
                            case 5:
                                byte[] bArr6 = new byte[4];
                                wrap.get(bArr6);
                                this.hexPassword = HexUtils.bytes2HexString(bArr6);
                                break;
                            case 6:
                                this.monzaQtPeek = wrap.getIntUnsigned(8);
                                break;
                            case 7:
                                this.rfmicron = wrap.getIntUnsigned(8);
                                break;
                            case 8:
                                this.emSensor = wrap.getIntUnsigned(8);
                                break;
                            case 9:
                                byte[] bArr7 = new byte[3];
                                wrap.get(bArr7);
                                this.readEpc = new ParamEpcReadEpc(bArr7);
                                break;
                            case 10:
                                byte[] bArr8 = new byte[2];
                                wrap.get(bArr8);
                                this.paramFastId = new ParamFastId(bArr8);
                                break;
                        }
                    } else {
                        this.quanray = wrap.getIntUnsigned(8);
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

    public ParamEpcReadReserved getReadReserved() {
        return this.readReserved;
    }

    public void setReadReserved(ParamEpcReadReserved paramEpcReadReserved) {
        this.readReserved = paramEpcReadReserved;
    }

    public String getHexPassword() {
        return this.hexPassword;
    }

    public void setHexPassword(String str) {
        this.hexPassword = str;
    }

    public int getMonzaQtPeek() {
        return this.monzaQtPeek;
    }

    public void setMonzaQtPeek(int i) {
        this.monzaQtPeek = i;
    }

    public int getRfmicron() {
        return this.rfmicron;
    }

    public void setRfmicron(int i) {
        this.rfmicron = i;
    }

    public int getEmSensor() {
        return this.emSensor;
    }

    public void setEmSensor(int i) {
        this.emSensor = i;
    }

    public int getCtesius() {
        return this.ctesius;
    }

    public void setCtesius(int i) {
        this.ctesius = i;
    }

    public ParamEpcReadEpc getReadEpc() {
        return this.readEpc;
    }

    public void setReadEpc(ParamEpcReadEpc paramEpcReadEpc) {
        this.readEpc = paramEpcReadEpc;
    }

    public int getSeed() {
        return this.seed;
    }

    public void setSeed(int i) {
        this.seed = i;
    }

    public ParamFastId getParamFastId() {
        return this.paramFastId;
    }

    public void setParamFastId(ParamFastId paramFastId) {
        this.paramFastId = paramFastId;
    }

    public int getQuanray() {
        return this.quanray;
    }

    public void setQuanray(int i) {
        this.quanray = i;
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
            if (this.readTid != null) {
                allocateDynamic.putInt(2, 8);
                allocateDynamic.put(this.readTid.toBytes());
            }
            if (this.readUserdata != null) {
                allocateDynamic.putInt(3, 8);
                allocateDynamic.put(this.readUserdata.toBytes());
            }
            if (this.readReserved != null) {
                allocateDynamic.putInt(4, 8);
                allocateDynamic.put(this.readReserved.toBytes());
            }
            if (!StringUtils.isNullOfEmpty(this.hexPassword)) {
                allocateDynamic.putInt(5, 8);
                allocateDynamic.put(HexUtils.hexString2Bytes(this.hexPassword));
            }
            if (this.monzaQtPeek != Integer.MAX_VALUE) {
                allocateDynamic.putInt(6, 8);
                allocateDynamic.putLong(this.monzaQtPeek, 8);
            }
            if (this.rfmicron != Integer.MAX_VALUE) {
                allocateDynamic.putInt(7, 8);
                allocateDynamic.putLong(this.rfmicron, 8);
            }
            if (this.emSensor != Integer.MAX_VALUE) {
                allocateDynamic.putInt(8, 8);
                allocateDynamic.putLong(this.emSensor, 8);
            }
            if (this.readEpc != null) {
                allocateDynamic.putInt(9, 8);
                allocateDynamic.put(this.readEpc.toBytes());
            }
            if (this.paramFastId != null) {
                allocateDynamic.putInt(10, 8);
                allocateDynamic.put(this.paramFastId.toBytes());
            }
            if (this.ctesius != Integer.MAX_VALUE) {
                allocateDynamic.putInt(18, 8);
                allocateDynamic.putInt(this.ctesius, 8);
            }
            if (this.seed != 0) {
                allocateDynamic.putInt(19, 8);
                allocateDynamic.putInt(this.seed, 8);
            }
            if (this.quanray != 0) {
                allocateDynamic.putInt(22, 8);
                allocateDynamic.putInt(this.quanray, 8);
            }
            this.cData = allocateDynamic.asByteArray();
            this.dataLen = this.cData.length;
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgBaseInventoryEpc.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Antenna port parameter error.");
                put((byte) 2, "Filter parameter error.");
                put((byte) 3, "TID parameter error.");
                put((byte) 4, "User parameter error.");
                put((byte) 5, "Reserve parameter error.");
                put((byte) 6, "Other error.");
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
        return "MsgBaseInventoryEpc{antennaEnable=" + this.antennaEnable + ", inventoryMode=" + this.inventoryMode + ", filter=" + this.filter + ", readTid=" + this.readTid + ", readUserdata=" + this.readUserdata + ", readReserved=" + this.readReserved + ", hexPassword='" + this.hexPassword + "', monzaQtPeek=" + this.monzaQtPeek + ", rfmicron=" + this.rfmicron + ", emSensor=" + this.emSensor + ", readEpc=" + this.readEpc + ", paramFastId=" + this.paramFastId + ", ctesius=" + this.ctesius + ", seed=" + this.seed + ", quanray=" + this.quanray + '}';
    }
}
