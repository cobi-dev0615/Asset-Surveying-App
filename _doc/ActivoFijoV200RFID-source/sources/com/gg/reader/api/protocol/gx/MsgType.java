package com.gg.reader.api.protocol.gx;

import com.devexpress.editors.model.mask.Mask;
import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.StringUtils;

/* loaded from: classes2.dex */
public class MsgType {
    public byte msgId;
    public String mt_12;
    public String mt_13;
    public String mt_14;
    public String mt_15;
    public String mt_8_11;
    public byte pType;
    public byte pVersion;

    public MsgType() {
        this.msgId = (byte) -1;
        this.mt_8_11 = EnumG.MSG_TYPE_BIT_ERROR;
        this.mt_12 = "0";
        this.mt_13 = "0";
        this.mt_14 = "0";
        this.mt_15 = "0";
        this.pVersion = (byte) 1;
        this.pType = (byte) 0;
    }

    public MsgType(byte b, String str, String str2, String str3) {
        this.mt_14 = "0";
        this.mt_15 = "0";
        this.pVersion = (byte) 1;
        this.pType = (byte) 0;
        this.msgId = b;
        this.mt_8_11 = str;
        this.mt_12 = str2;
        this.mt_13 = str3;
    }

    public MsgType(byte[] bArr) {
        this.msgId = (byte) -1;
        this.mt_8_11 = EnumG.MSG_TYPE_BIT_ERROR;
        this.mt_12 = "0";
        this.mt_13 = "0";
        this.mt_14 = "0";
        this.mt_15 = "0";
        this.pVersion = (byte) 1;
        this.pType = (byte) 0;
        try {
            this.msgId = bArr[3];
            String padRight = StringUtils.padRight(byte2bits(bArr[2]), Mask.DIGIT_SYMBOL, 8);
            this.mt_8_11 = padRight.substring(4, 8);
            this.mt_12 = padRight.substring(3, 4);
            this.mt_13 = padRight.substring(2, 3);
            this.mt_14 = padRight.substring(1, 2);
            this.mt_15 = padRight.substring(0, 1);
            this.pVersion = bArr[1];
            this.pType = bArr[0];
        } catch (Exception unused) {
        }
    }

    public byte[] toBytes() {
        byte[] bArr = new byte[4];
        try {
            byte bit2byte = bit2byte(this.mt_15 + this.mt_14 + this.mt_13 + this.mt_12 + this.mt_8_11);
            bArr[3] = this.msgId;
            bArr[2] = bit2byte;
            bArr[1] = this.pVersion;
            bArr[0] = this.pType;
        } catch (Exception unused) {
        }
        return bArr;
    }

    public int toInt() {
        BitBuffer wrap = BitBuffer.wrap(toBytes());
        wrap.position(0);
        return wrap.getIntUnsigned(32);
    }

    private String byte2bits(byte b) {
        String binaryString = Integer.toBinaryString(b | 256);
        int length = binaryString.length();
        return binaryString.substring(length - 8, length);
    }

    public static byte bit2byte(String str) {
        int length = str.length() - 1;
        byte b = 0;
        int i = 0;
        while (length >= 0) {
            double d = b;
            b = (byte) (d + (Byte.parseByte(str.charAt(length) + "") * Math.pow(2.0d, i)));
            length += -1;
            i++;
        }
        return b;
    }
}
