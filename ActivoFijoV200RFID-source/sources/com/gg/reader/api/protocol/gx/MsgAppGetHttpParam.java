package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.StringUtils;
import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public class MsgAppGetHttpParam extends Message {
    private int format;
    private int onOrOff;
    private int openCache;
    private int period;
    private String reportAddress;
    private int timeout;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgAppGetHttpParam() {
        this.period = 0;
        this.format = 0;
        this.timeout = 0;
        this.openCache = 0;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 42;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppGetHttpParam(byte[] bArr) {
        this();
        int intUnsigned;
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.onOrOff = wrap.getIntUnsigned(8);
                this.period = wrap.getIntUnsigned(16);
                this.format = wrap.getIntUnsigned(8);
                this.timeout = wrap.getIntUnsigned(16);
                this.openCache = wrap.getIntUnsigned(8);
                while (wrap.position() / 8 < bArr.length) {
                    if (wrap.getByte() == 1 && (intUnsigned = wrap.getIntUnsigned(16)) > 0) {
                        this.reportAddress = new String(wrap.get(new byte[intUnsigned]), "ASCII");
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public int getOnOrOff() {
        return this.onOrOff;
    }

    public void setOnOrOff(int i) {
        this.onOrOff = i;
    }

    public int getPeriod() {
        return this.period;
    }

    public void setPeriod(int i) {
        this.period = i;
    }

    public int getFormat() {
        return this.format;
    }

    public void setFormat(int i) {
        this.format = i;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }

    public int getOpenCache() {
        return this.openCache;
    }

    public void setOpenCache(int i) {
        this.openCache = i;
    }

    public String getReportAddress() {
        return this.reportAddress;
    }

    public void setReportAddress(String str) {
        this.reportAddress = str;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.putInt(this.onOrOff, 8);
            allocateDynamic.putInt(this.period, 16);
            allocateDynamic.put(this.format, 8);
            allocateDynamic.put(this.timeout, 16);
            allocateDynamic.putInt(this.openCache, 8);
            if (!StringUtils.isNullOfEmpty(this.reportAddress)) {
                allocateDynamic.putInt(this.reportAddress.length(), 16);
                allocateDynamic.put(this.reportAddress);
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
        this.onOrOff = wrap.getIntUnsigned(8);
        this.period = wrap.getIntUnsigned(16);
        this.format = wrap.getIntUnsigned(8);
        this.timeout = wrap.getIntUnsigned(16);
        this.openCache = wrap.getIntUnsigned(8);
        while (wrap.position() / 8 < this.cData.length) {
            if (wrap.getIntUnsigned(8) == 1 && (intUnsigned = wrap.getIntUnsigned(16)) > 0) {
                try {
                    this.reportAddress = new String(wrap.get(new byte[intUnsigned]), "ASCII");
                } catch (UnsupportedEncodingException unused) {
                }
            }
        }
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgAppGetHttpParam{onOrOff=" + this.onOrOff + ", period=" + this.period + ", format=" + this.format + ", timeout=" + this.timeout + ", openCache=" + this.openCache + ", reportAddress='" + this.reportAddress + "'}";
    }
}
