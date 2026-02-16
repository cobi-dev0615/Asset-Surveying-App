package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class MsgAppGetGpiState extends Message {
    private HashMap<Integer, Integer> hpGpiState;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgAppGetGpiState() {
        this.hpGpiState = new HashMap<>();
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 10;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppGetGpiState(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                for (int i = 0; i < bArr.length / 2; i++) {
                    this.hpGpiState.put(Integer.valueOf(wrap.getIntUnsigned(8)), Integer.valueOf(wrap.getIntUnsigned(8)));
                }
            } catch (Exception unused) {
            }
        }
    }

    public HashMap<Integer, Integer> getHpGpiState() {
        return this.hpGpiState;
    }

    public void setHpGpiState(HashMap<Integer, Integer> hashMap) {
        this.hpGpiState = hashMap;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        HashMap<Integer, Integer> hashMap = this.hpGpiState;
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        for (Integer num : this.hpGpiState.keySet()) {
            allocateDynamic.putInt(num.intValue(), 8);
            allocateDynamic.putInt(this.hpGpiState.get(num).intValue(), 8);
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        if (this.cData == null || this.cData.length <= 0) {
            return;
        }
        BitBuffer wrap = BitBuffer.wrap(this.cData);
        wrap.position(0);
        for (int i = 0; i < this.cData.length / 2; i++) {
            this.hpGpiState.put(Integer.valueOf(wrap.getIntUnsigned(8)), Integer.valueOf(wrap.getIntUnsigned(8)));
        }
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgAppGetGpiState{hpGpiState=" + this.hpGpiState + '}';
    }
}
