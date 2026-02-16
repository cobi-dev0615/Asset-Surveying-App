package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class MsgTestSetEpcEncryption extends Message {
    private int password;

    public MsgTestSetEpcEncryption() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_TEST;
            this.msgType.msgId = (byte) 19;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgTestSetEpcEncryption(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.password = wrap.getInt(16);
            } catch (Exception unused) {
            }
        }
    }

    public int getPassword() {
        return this.password;
    }

    public void setPassword(int i) {
        this.password = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putInt(this.password, 16);
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        HashMap<Byte, String> hashMap = new HashMap<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgTestSetEpcEncryption.1
            {
                put((byte) 0, "Set success.");
                put((byte) 1, "Save failure.");
            }
        };
        if (this.cData == null || this.cData.length <= 0) {
            return;
        }
        setRtCode(this.cData[0]);
        if (hashMap.containsKey(Byte.valueOf(this.cData[0]))) {
            setRtMsg(hashMap.get(Byte.valueOf(this.cData[0])));
        }
    }
}
