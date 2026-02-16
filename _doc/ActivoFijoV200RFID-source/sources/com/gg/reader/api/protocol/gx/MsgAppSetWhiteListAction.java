package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgAppSetWhiteListAction extends Message {
    private int relay;
    private int relayCloseTime;

    public MsgAppSetWhiteListAction() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 35;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppSetWhiteListAction(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.relay = wrap.getIntUnsigned(8);
                this.relayCloseTime = wrap.getIntUnsigned(16);
            } catch (Exception unused) {
            }
        }
    }

    public int getRelay() {
        return this.relay;
    }

    public void setRelay(int i) {
        this.relay = i;
    }

    public int getRelayCloseTime() {
        return this.relayCloseTime;
    }

    public void setRelayCloseTime(int i) {
        this.relayCloseTime = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putInt(this.relay, 8);
        allocateDynamic.putInt(this.relayCloseTime, 16);
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgAppSetWhiteListAction.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Set Fail.");
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
