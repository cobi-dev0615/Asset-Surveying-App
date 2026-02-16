package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.HexUtils;
import com.gg.reader.api.utils.StringUtils;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class MsgAppGetEasAlarm extends Message {
    private int alarmSwitch;
    private byte[] byteContent;
    private byte[] byteMask;
    private ActionParamFail fail;
    private int filterData;
    private String hexContent;
    private String hexMask;
    private int start;
    private ActionParamSuccess success;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgAppGetEasAlarm() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 64;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppGetEasAlarm(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.alarmSwitch = wrap.getIntUnsigned(8);
                this.filterData = wrap.getIntUnsigned(8);
                this.start = wrap.getIntUnsigned(16);
                int intUnsigned = wrap.getIntUnsigned(16);
                if (intUnsigned > 0) {
                    byte[] bArr2 = wrap.get(new byte[intUnsigned]);
                    this.byteContent = bArr2;
                    this.hexContent = HexUtils.bytes2HexString(bArr2);
                }
                int intUnsigned2 = wrap.getIntUnsigned(16);
                if (intUnsigned2 > 0) {
                    byte[] bArr3 = wrap.get(new byte[intUnsigned2]);
                    this.byteMask = bArr3;
                    this.hexMask = HexUtils.bytes2HexString(bArr3);
                }
                while (wrap.position() / 8 < bArr.length) {
                    int intUnsigned3 = wrap.getIntUnsigned(8);
                    if (intUnsigned3 == 1) {
                        byte[] bArr4 = new byte[wrap.getIntUnsigned(16)];
                        wrap.get(bArr4);
                        this.success = new ActionParamSuccess(bArr4);
                    } else if (intUnsigned3 == 2) {
                        byte[] bArr5 = new byte[wrap.getIntUnsigned(16)];
                        wrap.get(bArr5);
                        this.fail = new ActionParamFail(bArr5);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public int getAlarmSwitch() {
        return this.alarmSwitch;
    }

    public void setAlarmSwitch(int i) {
        this.alarmSwitch = i;
    }

    public int getFilterData() {
        return this.filterData;
    }

    public void setFilterData(int i) {
        this.filterData = i;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int i) {
        this.start = i;
    }

    public String getHexContent() {
        return this.hexContent;
    }

    public void setHexContent(String str) {
        this.hexContent = str;
        if (StringUtils.isNullOfEmpty(str)) {
            return;
        }
        this.byteContent = HexUtils.hexString2Bytes(this.hexContent);
    }

    public byte[] getByteContent() {
        return this.byteContent;
    }

    public void setByteContent(byte[] bArr) {
        this.byteContent = bArr;
    }

    public String getHexMask() {
        return this.hexMask;
    }

    public void setHexMask(String str) {
        this.hexMask = str;
        if (StringUtils.isNullOfEmpty(str)) {
            return;
        }
        this.byteMask = HexUtils.hexString2Bytes(this.hexMask);
    }

    public byte[] getByteMask() {
        return this.byteMask;
    }

    public void setByteMask(byte[] bArr) {
        this.byteMask = bArr;
    }

    public ActionParamSuccess getSuccess() {
        return this.success;
    }

    public void setSuccess(ActionParamSuccess actionParamSuccess) {
        this.success = actionParamSuccess;
    }

    public ActionParamFail getFail() {
        return this.fail;
    }

    public void setFail(ActionParamFail actionParamFail) {
        this.fail = actionParamFail;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.putInt(this.alarmSwitch, 8);
            allocateDynamic.putInt(this.filterData, 8);
            allocateDynamic.putInt(this.start, 16);
            String str = this.hexContent;
            if (str != null) {
                allocateDynamic.putInt(str.length(), 16);
                allocateDynamic.put(this.hexContent);
            }
            String str2 = this.hexMask;
            if (str2 != null) {
                allocateDynamic.putInt(str2.length(), 16);
                allocateDynamic.put(this.hexMask);
            }
            if (this.success != null) {
                allocateDynamic.putInt(1, 8);
                byte[] bytes = this.success.toBytes();
                allocateDynamic.putInt(bytes.length, 16);
                allocateDynamic.put(bytes);
            }
            if (this.fail != null) {
                allocateDynamic.putInt(2, 8);
                byte[] bytes2 = this.fail.toBytes();
                allocateDynamic.putInt(bytes2.length, 16);
                allocateDynamic.put(bytes2);
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
        this.alarmSwitch = wrap.getIntUnsigned(8);
        this.filterData = wrap.getIntUnsigned(8);
        this.start = wrap.getIntUnsigned(16);
        int intUnsigned = wrap.getIntUnsigned(16);
        if (intUnsigned > 0) {
            byte[] bArr = wrap.get(new byte[intUnsigned]);
            this.byteContent = bArr;
            this.hexContent = HexUtils.bytes2HexString(bArr);
        }
        int intUnsigned2 = wrap.getIntUnsigned(16);
        if (intUnsigned2 > 0) {
            byte[] bArr2 = wrap.get(new byte[intUnsigned2]);
            this.byteMask = bArr2;
            this.hexMask = HexUtils.bytes2HexString(bArr2);
        }
        while (wrap.position() / 8 < this.cData.length) {
            int intUnsigned3 = wrap.getIntUnsigned(8);
            if (intUnsigned3 == 1) {
                byte[] bArr3 = new byte[wrap.getIntUnsigned(16)];
                wrap.get(bArr3);
                this.success = new ActionParamSuccess(bArr3);
            } else if (intUnsigned3 == 2) {
                byte[] bArr4 = new byte[wrap.getIntUnsigned(16)];
                wrap.get(bArr4);
                this.fail = new ActionParamFail(bArr4);
            }
        }
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgAppGetEasAlarm{alarmSwitch=" + this.alarmSwitch + ", filterData=" + this.filterData + ", start=" + this.start + ", hexContent='" + this.hexContent + "', byteContent=" + Arrays.toString(this.byteContent) + ", hexMask='" + this.hexMask + "', byteMask=" + Arrays.toString(this.byteMask) + ", success=" + this.success + ", fail=" + this.fail + '}';
    }
}
