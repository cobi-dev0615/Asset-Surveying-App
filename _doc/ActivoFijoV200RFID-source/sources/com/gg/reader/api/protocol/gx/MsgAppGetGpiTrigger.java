package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.HexUtils;
import com.gg.reader.api.utils.StringUtils;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class MsgAppGetGpiTrigger extends Message {
    private int gpiPort;
    private String hexTriggerCommand;
    private int levelUploadSwitch;
    private int overDelayTime;
    private byte[] triggerCommand;
    private int triggerOver;
    private int triggerStart;

    public MsgAppGetGpiTrigger() {
        this.overDelayTime = Integer.MAX_VALUE;
        this.levelUploadSwitch = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 12;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppGetGpiTrigger(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.triggerStart = wrap.getIntUnsigned(8);
                int intUnsigned = wrap.getIntUnsigned(16);
                if (intUnsigned > 0) {
                    byte[] bArr2 = wrap.get(new byte[intUnsigned]);
                    this.triggerCommand = bArr2;
                    this.hexTriggerCommand = HexUtils.bytes2HexString(bArr2);
                }
                this.triggerOver = wrap.getIntUnsigned(8);
                this.overDelayTime = wrap.getIntUnsigned(16);
                this.levelUploadSwitch = wrap.getIntUnsigned(8);
            } catch (Exception unused) {
            }
        }
    }

    public int getGpiPort() {
        return this.gpiPort;
    }

    public void setGpiPort(int i) {
        this.gpiPort = i;
    }

    public int getTriggerStart() {
        return this.triggerStart;
    }

    public void setTriggerStart(int i) {
        this.triggerStart = i;
    }

    public byte[] getTriggerCommand() {
        return this.triggerCommand;
    }

    public void setTriggerCommand(byte[] bArr) {
        this.triggerCommand = bArr;
    }

    public String getHexTriggerCommand() {
        return this.hexTriggerCommand;
    }

    public void setHexTriggerCommand(String str) {
        if (StringUtils.isNullOfEmpty(str)) {
            return;
        }
        this.hexTriggerCommand = str;
        this.triggerCommand = HexUtils.hexString2Bytes(str);
    }

    public int getTriggerOver() {
        return this.triggerOver;
    }

    public void setTriggerOver(int i) {
        this.triggerOver = i;
    }

    public int getOverDelayTime() {
        return this.overDelayTime;
    }

    public void setOverDelayTime(int i) {
        this.overDelayTime = i;
    }

    public int getLevelUploadSwitch() {
        return this.levelUploadSwitch;
    }

    public void setLevelUploadSwitch(int i) {
        this.levelUploadSwitch = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.putLong(this.gpiPort, 8);
            this.cData = allocateDynamic.asByteArray();
            this.dataLen = this.cData.length;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.putLong(this.triggerStart, 8);
            byte[] bArr = this.triggerCommand;
            if (bArr != null && bArr.length >= 0) {
                allocateDynamic.putInt(bArr.length, 16);
                allocateDynamic.put(this.triggerCommand);
            } else {
                allocateDynamic.putInt(0, 16);
            }
            allocateDynamic.putLong(this.triggerOver, 8);
            int i = this.overDelayTime;
            if (Integer.MAX_VALUE != i) {
                allocateDynamic.put(i, 16);
            }
            int i2 = this.levelUploadSwitch;
            if (Integer.MAX_VALUE != i2) {
                allocateDynamic.putLong(i2, 8);
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
        this.triggerStart = wrap.getIntUnsigned(8);
        int intUnsigned = wrap.getIntUnsigned(16);
        if (intUnsigned > 0) {
            byte[] bArr = wrap.get(new byte[intUnsigned]);
            this.triggerCommand = bArr;
            this.hexTriggerCommand = HexUtils.bytes2HexString(bArr);
        }
        this.triggerOver = wrap.getIntUnsigned(8);
        this.overDelayTime = wrap.getIntUnsigned(16);
        this.levelUploadSwitch = wrap.getIntUnsigned(8);
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgAppGetGpiTrigger{gpiPort=" + this.gpiPort + ", triggerStart=" + this.triggerStart + ", triggerCommand=" + Arrays.toString(this.triggerCommand) + ", hexTriggerCommand='" + this.hexTriggerCommand + "', triggerOver=" + this.triggerOver + ", overDelayTime=" + this.overDelayTime + ", levelUploadSwitch=" + this.levelUploadSwitch + '}';
    }
}
