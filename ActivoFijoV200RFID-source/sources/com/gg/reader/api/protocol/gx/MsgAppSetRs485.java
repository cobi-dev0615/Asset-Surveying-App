package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgAppSetRs485 extends Message {
    private int address;
    private int baudRate;

    public MsgAppSetRs485() {
        this.baudRate = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 21;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppSetRs485(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.address = wrap.getIntUnsigned(8);
                while (wrap.position() / 8 < bArr.length) {
                    if (wrap.getIntUnsigned(8) == 1) {
                        this.baudRate = wrap.getIntUnsigned(8);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public int getAddress() {
        return this.address;
    }

    public void setAddress(int i) {
        this.address = i;
    }

    public int getBaudRate() {
        return this.baudRate;
    }

    public void setBaudRate(int i) {
        this.baudRate = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.put(this.address, 8);
        if (Integer.MAX_VALUE != this.baudRate) {
            allocateDynamic.putInt(1, 8);
            allocateDynamic.putLong(this.baudRate, 8);
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgAppSetRs485.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Other error.");
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
