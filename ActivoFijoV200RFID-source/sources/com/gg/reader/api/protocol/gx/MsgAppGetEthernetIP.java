package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgAppGetEthernetIP extends Message {
    private int autoIp;
    private String dns1;
    private String dns2;
    private String gateway;
    private String iP;
    private String mask;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgAppGetEthernetIP() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 5;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppGetEthernetIP(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.autoIp = wrap.getIntUnsigned(8);
                this.iP = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
                this.mask = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
                this.gateway = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
                this.dns1 = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
                this.dns2 = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
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

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.putLong(this.autoIp, 8);
            String str = this.iP;
            if (str != null) {
                for (String str2 : str.split("\\.")) {
                    allocateDynamic.putInt(Integer.parseInt(str2), 8);
                }
            }
            String str3 = this.mask;
            if (str3 != null) {
                for (String str4 : str3.split("\\.")) {
                    allocateDynamic.putInt(Integer.parseInt(str4), 8);
                }
            }
            String str5 = this.gateway;
            if (str5 != null) {
                for (String str6 : str5.split("\\.")) {
                    allocateDynamic.putInt(Integer.parseInt(str6), 8);
                }
            }
            String str7 = this.dns1;
            if (str7 != null) {
                for (String str8 : str7.split("\\.")) {
                    allocateDynamic.putInt(Integer.parseInt(str8), 8);
                }
            }
            String str9 = this.dns2;
            if (str9 != null) {
                for (String str10 : str9.split("\\.")) {
                    allocateDynamic.putInt(Integer.parseInt(str10), 8);
                }
            }
            this.cData = allocateDynamic.asByteArray();
            this.dataLen = this.cData.length;
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        if (this.cData == null || this.cData.length <= 0) {
            return;
        }
        BitBuffer wrap = BitBuffer.wrap(this.cData);
        wrap.position(0);
        this.autoIp = wrap.getIntUnsigned(8);
        this.iP = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
        this.mask = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
        this.gateway = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
        this.dns1 = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
        this.dns2 = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgAppGetEthernetIP{autoIp=" + this.autoIp + ", iP='" + this.iP + "', mask='" + this.mask + "', gateway='" + this.gateway + "', dns1='" + this.dns1 + "', dns2='" + this.dns2 + "'}";
    }
}
