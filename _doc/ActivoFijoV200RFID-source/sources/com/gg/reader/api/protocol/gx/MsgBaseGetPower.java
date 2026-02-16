package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgBaseGetPower extends Message {
    private Hashtable<Integer, Integer> dicPower;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgBaseGetPower() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_BASE;
            this.msgType.msgId = (byte) 2;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgBaseGetPower(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                for (int i = 0; i < bArr.length / 2; i++) {
                    int intUnsigned = wrap.getIntUnsigned(8);
                    int intUnsigned2 = wrap.getIntUnsigned(8);
                    if (this.dicPower == null) {
                        this.dicPower = new Hashtable<>();
                    }
                    this.dicPower.put(Integer.valueOf(intUnsigned), Integer.valueOf(intUnsigned2));
                }
            } catch (Exception unused) {
            }
        }
    }

    public Hashtable<Integer, Integer> getDicPower() {
        return this.dicPower;
    }

    public void setDicPower(Hashtable<Integer, Integer> hashtable) {
        this.dicPower = hashtable;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            Hashtable<Integer, Integer> hashtable = this.dicPower;
            if (hashtable == null || hashtable.size() <= 0) {
                return;
            }
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            for (Integer num : this.dicPower.keySet()) {
                allocateDynamic.putLong(num.intValue(), 8);
                allocateDynamic.putLong(this.dicPower.get(num).intValue(), 8);
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
        for (int i = 0; i < this.cData.length / 2; i++) {
            int intUnsigned = wrap.getIntUnsigned(8);
            int intUnsigned2 = wrap.getIntUnsigned(8);
            if (this.dicPower == null) {
                this.dicPower = new Hashtable<>();
            }
            this.dicPower.put(Integer.valueOf(intUnsigned), Integer.valueOf(intUnsigned2));
        }
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgBaseGetPower{dicPower=" + this.dicPower + '}';
    }
}
