package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;

/* loaded from: classes2.dex */
public class MsgAppGetBaseVersion extends Message {
    private String baseVersions;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgAppGetBaseVersion() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 1;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppGetBaseVersion(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.baseVersions = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
            } catch (Exception unused) {
            }
        }
    }

    public String getBaseVersions() {
        return this.baseVersions;
    }

    public void setBaseVersions(String str) {
        this.baseVersions = str;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            String str = this.baseVersions;
            if (str != null) {
                for (String str2 : str.split("\\.")) {
                    allocateDynamic.putInt(Integer.parseInt(str2), 8);
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
        this.baseVersions = wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8) + "." + wrap.getIntUnsigned(8);
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgAppGetBaseVersion{baseVersions='" + this.baseVersions + "'}";
    }
}
