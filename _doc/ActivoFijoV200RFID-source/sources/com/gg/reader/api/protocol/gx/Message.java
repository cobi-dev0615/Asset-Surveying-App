package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.Crc16Utils;
import com.gg.reader.api.utils.GLog;
import com.gg.reader.api.utils.HexUtils;

/* loaded from: classes2.dex */
public class Message {
    public static final byte HEAD = 90;
    public static final int MSG_MAX_LEN = 1024;
    public byte[] cData;
    public byte[] crc;
    public byte[] crcData;
    public int dataLen;
    public byte[] msgData;
    public MsgType msgType;
    public int rs485Address;
    private byte rtCode;
    private String rtMsg;

    public void ackUnpack() {
    }

    public byte getRtCode() {
        return this.rtCode;
    }

    public String getRtMsg() {
        return this.rtMsg;
    }

    public void setRtCode(byte b) {
        this.rtCode = b;
    }

    public void setRtMsg(String str) {
        this.rtMsg = str;
    }

    public Message() {
        this.msgType = null;
        this.rs485Address = 0;
        this.dataLen = 0;
        this.cData = null;
        this.crc = null;
        this.crcData = null;
        this.msgData = null;
        this.rtCode = (byte) -1;
        this.rtMsg = "";
    }

    public Message(byte[] bArr) {
        this.msgType = null;
        this.rs485Address = 0;
        this.dataLen = 0;
        this.cData = null;
        this.crc = null;
        this.crcData = null;
        this.rtCode = (byte) -1;
        this.rtMsg = "";
        try {
            this.msgData = bArr;
            this.crcData = new byte[bArr.length - 3];
            BitBuffer wrap = BitBuffer.wrap(bArr);
            wrap.position(8);
            MsgType msgType = new MsgType(wrap.get(new byte[4]));
            this.msgType = msgType;
            if (msgType.mt_13.equals("1")) {
                this.rs485Address = wrap.getIntUnsigned(8);
            }
            int intUnsigned = wrap.getIntUnsigned(16);
            this.dataLen = intUnsigned;
            if (intUnsigned > 0) {
                byte[] bArr2 = new byte[intUnsigned];
                this.cData = bArr2;
                this.cData = wrap.get(bArr2);
            }
            int position = wrap.position();
            wrap.position(8);
            this.crcData = wrap.get(this.crcData);
            wrap.position(position);
            byte[] bArr3 = new byte[2];
            this.crc = bArr3;
            this.crc = wrap.get(bArr3);
        } catch (Exception e) {
            GLog.e("Message unpacking error :" + e.getStackTrace());
        }
    }

    public byte[] toBytes() {
        return toBytes(false);
    }

    public byte[] toBytes(boolean z) {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.put(HEAD);
        allocateDynamic.put(this.msgType.toBytes());
        if (z) {
            allocateDynamic.putInt(this.rs485Address, 8);
        }
        allocateDynamic.putInt(this.dataLen, 16);
        byte[] bArr = this.cData;
        if (bArr != null && bArr.length > 0 && bArr.length == this.dataLen) {
            allocateDynamic.put(bArr);
        }
        int position = allocateDynamic.position();
        this.crcData = new byte[(allocateDynamic.position() / 8) - 1];
        allocateDynamic.position(8);
        this.crcData = allocateDynamic.get(this.crcData);
        allocateDynamic.position(position);
        byte[] short2Bytes = HexUtils.short2Bytes(Crc16Utils.CRC_XModem(this.crcData));
        this.crc = short2Bytes;
        allocateDynamic.put(short2Bytes);
        byte[] asByteArray = allocateDynamic.asByteArray();
        this.msgData = asByteArray;
        return asByteArray;
    }

    public void pack() {
        this.dataLen = 0;
    }

    public void ackPack() {
        this.crcData = new byte[]{this.rtCode};
        this.dataLen = 1;
    }

    public void ackUnpack(byte[] bArr) {
        this.cData = bArr;
        ackUnpack();
    }

    public boolean checkCrc() {
        try {
            byte[] bArr = this.crcData;
            if (bArr == null || this.crc == null) {
                return false;
            }
            byte[] short2Bytes = HexUtils.short2Bytes(Crc16Utils.CRC_XModem(bArr));
            for (int i = 0; i < short2Bytes.length; i++) {
                if (this.crc[i] != short2Bytes[i]) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
