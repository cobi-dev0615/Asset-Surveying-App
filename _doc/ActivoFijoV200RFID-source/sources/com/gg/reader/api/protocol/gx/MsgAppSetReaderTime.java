package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.DateTimeUtils;
import java.util.Date;
import java.util.Formatter;
import java.util.Hashtable;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class MsgAppSetReaderTime extends Message {
    private Date systemTime;

    public MsgAppSetReaderTime() {
        this.systemTime = new Date();
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 16;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppSetReaderTime(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.systemTime = DateTimeUtils.fromUtcToTimeZone((wrap.getLong(32) * 1000) + (wrap.getLong(32) / 1000), TimeZone.getDefault());
            } catch (Exception unused) {
            }
        }
    }

    public Date getSystemTime() {
        return this.systemTime;
    }

    public void setSystemTime(Date date) {
        this.systemTime = date;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        String[] split = new Formatter().format("%.3f", Double.valueOf(DateTimeUtils.UtcFromTimeZone(this.systemTime, TimeZone.getDefault()) / 1000.0d)).toString().split("\\.");
        allocateDynamic.putLong(Integer.parseInt(split[0]), 32);
        allocateDynamic.putLong(Integer.parseInt(split[1]) * 1000, 32);
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgAppSetReaderTime.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "RTC setup failed.");
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
