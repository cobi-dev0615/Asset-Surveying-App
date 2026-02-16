package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgAppSetWifiIp extends Message {
    private int autoIp;
    private String dns1;
    private String dns2;
    private String gateway;
    private Long hotId;
    private String iP;
    private String mask;

    public MsgAppSetWifiIp() {
        this.iP = "0.0.0.0";
        this.mask = "0.0.0.0";
        this.gateway = "0.0.0.0";
        this.dns1 = "0.0.0.0";
        this.dns2 = "0.0.0.0";
        this.hotId = Long.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 53;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppSetWifiIp(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.autoIp = wrap.getIntUnsigned(8);
                while (wrap.position() / 8 < bArr.length) {
                    switch (wrap.getByte()) {
                        case 1:
                            this.iP = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
                            break;
                        case 2:
                            this.mask = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
                            break;
                        case 3:
                            this.gateway = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
                            break;
                        case 4:
                            this.dns1 = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
                            break;
                        case 5:
                            this.dns2 = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
                            break;
                        case 6:
                            this.hotId = Long.valueOf(wrap.getLongUnsigned(32));
                            break;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public int getAutoIp() {
        return this.autoIp;
    }

    public void setAutoIp(int i) {
        this.autoIp = i;
    }

    public String getiP() {
        return this.iP;
    }

    public void setiP(String str) {
        this.iP = str;
    }

    public String getMask() {
        return this.mask;
    }

    public void setMask(String str) {
        this.mask = str;
    }

    public String getGateway() {
        return this.gateway;
    }

    public void setGateway(String str) {
        this.gateway = str;
    }

    public String getDns1() {
        return this.dns1;
    }

    public void setDns1(String str) {
        this.dns1 = str;
    }

    public String getDns2() {
        return this.dns2;
    }

    public void setDns2(String str) {
        this.dns2 = str;
    }

    public Long getHotId() {
        return this.hotId;
    }

    public void setHotId(Long l) {
        this.hotId = l;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putLong(this.autoIp, 8);
        if (1 == this.autoIp) {
            allocateDynamic.putInt(1, 8);
            for (String str : this.iP.split("\\.")) {
                allocateDynamic.putInt(Integer.parseInt(str), 8);
            }
            allocateDynamic.putInt(2, 8);
            for (String str2 : this.mask.split("\\.")) {
                allocateDynamic.putInt(Integer.parseInt(str2), 8);
            }
            allocateDynamic.putInt(3, 8);
            for (String str3 : this.gateway.split("\\.")) {
                allocateDynamic.putInt(Integer.parseInt(str3), 8);
            }
            allocateDynamic.putInt(4, 8);
            for (String str4 : this.dns1.split("\\.")) {
                allocateDynamic.putInt(Integer.parseInt(str4), 8);
            }
            allocateDynamic.putInt(5, 8);
            for (String str5 : this.dns2.split("\\.")) {
                allocateDynamic.putInt(Integer.parseInt(str5), 8);
            }
        }
        if (Long.MAX_VALUE != this.hotId.longValue()) {
            allocateDynamic.putInt(6, 8);
            allocateDynamic.putLong(this.hotId.longValue(), 32);
        } else {
            allocateDynamic.put(6, 8);
            allocateDynamic.putLong(0L, 32);
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgAppSetWifiIp.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "ReaderIp parameter error .");
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
