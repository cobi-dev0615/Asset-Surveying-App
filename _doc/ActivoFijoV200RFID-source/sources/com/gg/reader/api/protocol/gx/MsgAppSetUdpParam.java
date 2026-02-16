package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.StringUtils;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgAppSetUdpParam extends Message {
    private String ip;
    private int onOrOff;
    private int period;
    private int port;

    public MsgAppSetUdpParam() {
        this.ip = "0.0.0.0";
        this.port = Integer.MAX_VALUE;
        this.period = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 39;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppSetUdpParam(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.onOrOff = wrap.getIntUnsigned(8);
                while (wrap.position() / 8 < bArr.length) {
                    byte b = wrap.getByte();
                    if (b == 1) {
                        this.ip = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
                    } else if (b == 2) {
                        this.port = wrap.getIntUnsigned(16);
                    } else if (b == 3) {
                        this.period = wrap.getIntUnsigned(16);
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

    public String getIp() {
        return this.ip;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public int getPeriod() {
        return this.period;
    }

    public void setPeriod(int i) {
        this.period = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putInt(this.onOrOff, 8);
        if (1 == this.onOrOff) {
            if (!StringUtils.isNullOfEmpty(this.ip)) {
                allocateDynamic.putInt(1, 8);
                for (String str : this.ip.split("\\.")) {
                    allocateDynamic.putInt(Integer.parseInt(str), 8);
                }
            }
            if (Integer.MAX_VALUE != this.port) {
                allocateDynamic.putInt(2, 8);
                allocateDynamic.put(this.port, 16);
            }
            if (Integer.MAX_VALUE != this.period) {
                allocateDynamic.putInt(3, 8);
                allocateDynamic.put(this.period, 16);
            }
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgAppSetUdpParam.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Fail");
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
