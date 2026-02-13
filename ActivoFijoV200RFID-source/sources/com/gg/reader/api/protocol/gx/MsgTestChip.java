package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.HexUtils;
import com.gg.reader.api.utils.StringUtils;
import java.util.Arrays;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgTestChip extends Message {
    private Integer address;
    private byte[] dataContent;
    private String hexDataContent;

    public MsgTestChip() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_TEST;
            this.msgType.msgId = (byte) 49;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public Integer getAddress() {
        return this.address;
    }

    public void setAddress(Integer num) {
        this.address = num;
    }

    public byte[] getDataContent() {
        return this.dataContent;
    }

    public void setDataContent(byte[] bArr) {
        this.dataContent = bArr;
    }

    public String getHexDataContent() {
        return this.hexDataContent;
    }

    public void setHexDataContent(String str) {
        this.hexDataContent = str;
        if (StringUtils.isNullOfEmpty(str)) {
            return;
        }
        this.dataContent = HexUtils.hexString2Bytes(this.hexDataContent);
    }

    public MsgTestChip(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.address = Integer.valueOf(wrap.getIntUnsigned(16));
                byte[] bArr2 = wrap.get(new byte[2]);
                this.dataContent = bArr2;
                if (bArr2 == null || bArr2.length <= 0) {
                    return;
                }
                this.hexDataContent = HexUtils.bytes2HexString(bArr2);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        if (Integer.MAX_VALUE != this.address.intValue()) {
            allocateDynamic.putLong(this.address.intValue(), 16);
        }
        byte[] bArr = this.dataContent;
        if (bArr != null) {
            allocateDynamic.put(bArr);
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgTestChip.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Other Error");
            }
        };
        if (this.cData == null || this.cData.length <= 0) {
            return;
        }
        setRtCode(this.cData[0]);
        if (hashtable.containsKey(Byte.valueOf(this.cData[0]))) {
            setRtMsg(hashtable.get(Byte.valueOf(this.cData[0])));
        }
        if (this.address.intValue() == 770) {
            BitBuffer wrap = BitBuffer.wrap(this.cData);
            wrap.position(0);
            this.hexDataContent = HexUtils.bytes2HexString(wrap.get(new byte[4]));
            setRtCode((byte) 0);
        }
    }

    public String toString() {
        return "MsgTestChip{address=" + this.address + ", dataContent=" + Arrays.toString(this.dataContent) + ", hexDataContent='" + this.hexDataContent + "'}";
    }
}
