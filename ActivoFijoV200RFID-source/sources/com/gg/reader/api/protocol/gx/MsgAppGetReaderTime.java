package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.DateTimeUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class MsgAppGetReaderTime extends Message {
    private Date systemTime;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgAppGetReaderTime() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 17;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppGetReaderTime(byte[] bArr) {
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

    public String getFormatTime() {
        return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(getSystemTime());
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            String[] split = new Formatter().format("%.3f", Double.valueOf(DateTimeUtils.UtcFromTimeZone(this.systemTime, TimeZone.getDefault()) / 1000.0d)).toString().split("\\.");
            allocateDynamic.putLong(Integer.parseInt(split[0]), 32);
            allocateDynamic.putLong(Integer.parseInt(split[1]) * 1000, 32);
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
        this.systemTime = DateTimeUtils.fromUtcToTimeZone((wrap.getLong(32) * 1000) + (wrap.getLong(32) / 1000), TimeZone.getDefault());
        setRtCode((byte) 0);
    }
}
