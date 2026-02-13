package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.HexUtils;
import com.gg.reader.api.utils.StringUtils;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgBaseLock6b extends Message {
    private Long antennaEnable;
    private byte[] bMatchTid;
    private int errorIndex;
    private String hexMatchTid;
    private int lockIndex;

    public MsgBaseLock6b() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_BASE;
            this.msgType.msgId = (byte) 66;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgBaseLock6b(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.antennaEnable = Long.valueOf(wrap.getLongUnsigned(32));
                byte[] bArr2 = wrap.get(new byte[8]);
                this.bMatchTid = bArr2;
                this.hexMatchTid = HexUtils.bytes2HexString(bArr2);
                this.lockIndex = wrap.getIntUnsigned(8);
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

    public String getHexMatchTid() {
        return this.hexMatchTid;
    }

    public void setHexMatchTid(String str) {
        if (StringUtils.isNullOfEmpty(str)) {
            return;
        }
        this.hexMatchTid = str;
        this.bMatchTid = HexUtils.hexString2Bytes(str);
    }

    public byte[] getbMatchTid() {
        return this.bMatchTid;
    }

    public void setbMatchTid(byte[] bArr) {
        this.bMatchTid = bArr;
    }

    public int getLockIndex() {
        return this.lockIndex;
    }

    public void setLockIndex(int i) {
        this.lockIndex = i;
    }

    public int getErrorIndex() {
        return this.errorIndex;
    }

    public void setErrorIndex(int i) {
        this.errorIndex = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putLong(this.antennaEnable.longValue(), 32);
        byte[] bArr = this.bMatchTid;
        if (bArr != null && bArr.length > 0) {
            allocateDynamic.put(bArr);
        }
        allocateDynamic.putLong(this.lockIndex, 8);
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgBaseLock6b.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Other error.");
            }
        };
        if (this.cData == null || this.cData.length <= 0) {
            return;
        }
        setRtCode(this.cData[0]);
        if (hashtable.containsKey(Byte.valueOf(this.cData[0]))) {
            setRtMsg(hashtable.get(Byte.valueOf(this.cData[0])));
        }
        if (this.cData.length > 1) {
            BitBuffer wrap = BitBuffer.wrap(this.cData);
            wrap.position(8);
            if (wrap.getIntUnsigned(8) == 1) {
                this.errorIndex = wrap.getIntUnsigned(8);
            }
        }
    }
}
