package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class MsgTestEnvRssiDetection extends Message {
    private Long antennaEnable;
    private int currentRssi;
    private int frequencyPoint;
    private Long rssiFrequency;

    public MsgTestEnvRssiDetection() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_TEST;
            this.msgType.msgId = (byte) 7;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgTestEnvRssiDetection(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.antennaEnable = Long.valueOf(wrap.getLongUnsigned(32));
                this.frequencyPoint = wrap.getIntUnsigned(8);
            } catch (Exception unused) {
            }
        }
    }

    public Long getAntennaEnable() {
        return this.antennaEnable;
    }

    public void setAntennaEnable(Long l) {
        this.antennaEnable = l;
    }

    public int getFrequencyPoint() {
        return this.frequencyPoint;
    }

    public void setFrequencyPoint(int i) {
        this.frequencyPoint = i;
    }

    public Long getRssiFrequency() {
        return this.rssiFrequency;
    }

    public void setRssiFrequency(Long l) {
        this.rssiFrequency = l;
    }

    public int getCurrentRssi() {
        return this.currentRssi;
    }

    public void setCurrentRssi(int i) {
        this.currentRssi = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.putLong(this.antennaEnable.longValue(), 32);
            allocateDynamic.putInt(this.frequencyPoint, 8);
            this.cData = allocateDynamic.asByteArray();
            this.dataLen = this.cData.length;
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.putLong(this.rssiFrequency.longValue(), 32);
            allocateDynamic.putInt(this.currentRssi, 8);
            this.cData = allocateDynamic.asByteArray();
            this.dataLen = this.cData.length;
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        HashMap<Byte, String> hashMap = new HashMap<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgTestEnvRssiDetection.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "FrequencyPoint Param Reader Not Support.");
                put((byte) 2, "Port Param Reader Not Support.");
                put((byte) 3, "Phase-locked loop locking failed");
                put((byte) 4, "Other error");
            }
        };
        if (this.cData == null || this.cData.length <= 0) {
            return;
        }
        setRtCode(this.cData[0]);
        if (hashMap.containsKey(Byte.valueOf(this.cData[0]))) {
            setRtMsg(hashMap.get(Byte.valueOf(this.cData[0])));
        }
        BitBuffer wrap = BitBuffer.wrap(this.cData);
        wrap.position(8);
        this.rssiFrequency = Long.valueOf(wrap.getLongUnsigned(32));
        this.currentRssi = wrap.getIntUnsigned(8);
    }

    public String toString() {
        return "MsgTestEnvRssiDetection{antennaEnable=" + this.antennaEnable + ", frequencyPoint=" + this.frequencyPoint + ", rssiFrequency=" + this.rssiFrequency + ", currentRssi=" + this.currentRssi + '}';
    }
}
