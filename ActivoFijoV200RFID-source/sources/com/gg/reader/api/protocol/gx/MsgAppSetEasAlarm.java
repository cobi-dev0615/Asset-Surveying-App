package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.HexUtils;
import com.gg.reader.api.utils.StringUtils;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgAppSetEasAlarm extends Message {
    private int alarmSwitch;
    private byte[] byteContent;
    private byte[] byteMask;
    private ActionParamFail fail;
    private int filterData;
    private String hexContent;
    private String hexMask;
    private int start;
    private ActionParamSuccess success;

    public MsgAppSetEasAlarm() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 63;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppSetEasAlarm(byte[] bArr) {
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
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putInt(this.alarmSwitch, 8);
        allocateDynamic.putInt(this.filterData, 8);
        allocateDynamic.putInt(this.start, 16);
        byte[] bArr = this.byteContent;
        if (bArr != null && bArr.length > 0) {
            allocateDynamic.putInt(bArr.length, 16);
            allocateDynamic.put(this.byteContent);
        }
        byte[] bArr2 = this.byteMask;
        if (bArr2 != null && bArr2.length > 0) {
            allocateDynamic.putInt(bArr2.length, 16);
            allocateDynamic.put(this.byteMask);
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
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgAppSetEasAlarm.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Set failure.");
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
