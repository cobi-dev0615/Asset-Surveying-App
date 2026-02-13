package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.StringUtils;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgAppSetReaderMac extends Message {
    private String mac;

    public MsgAppSetReaderMac() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 19;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppSetReaderMac(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.mac = String.format("%02x", Integer.valueOf(wrap.getIntUnsigned(8))).toUpperCase() + "-" + String.format("%02x", Integer.valueOf(wrap.getIntUnsigned(8))).toUpperCase() + "-" + String.format("%02x", Integer.valueOf(wrap.getIntUnsigned(8))).toUpperCase() + "-" + String.format("%02x", Integer.valueOf(wrap.getIntUnsigned(8))).toUpperCase() + "-" + String.format("%02x", Integer.valueOf(wrap.getIntUnsigned(8))).toUpperCase() + "-" + String.format("%02x", Integer.valueOf(wrap.getIntUnsigned(8))).toUpperCase();
            } catch (Exception unused) {
            }
        }
    }

    public String getMac() {
        return this.mac;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        if (!StringUtils.isNullOfEmpty(this.mac)) {
            for (String str : this.mac.split("-")) {
                allocateDynamic.putInt(Integer.parseInt(str, 16), 8);
            }
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgAppSetReaderMac.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Reader MAC parameter error.");
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
