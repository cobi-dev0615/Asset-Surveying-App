package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class MsgBaseSetFrequency extends Message {
    private Boolean automatically;
    private List<Integer> listFreqCursor;
    private int powerDownSave;

    public MsgBaseSetFrequency() {
        this.powerDownSave = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_BASE;
            this.msgType.msgId = (byte) 5;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgBaseSetFrequency(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.automatically = Boolean.valueOf(wrap.getIntUnsigned(8) == 1);
                while (wrap.position() / 8 < bArr.length) {
                    byte b = wrap.getByte();
                    if (b == 1) {
                        if (this.listFreqCursor == null) {
                            this.listFreqCursor = new ArrayList();
                        }
                        int intUnsigned = wrap.getIntUnsigned(16);
                        for (int i = 0; i < intUnsigned; i++) {
                            this.listFreqCursor.add(Integer.valueOf(wrap.getIntUnsigned(8)));
                        }
                    } else if (b == 2) {
                        this.powerDownSave = wrap.getIntUnsigned(8);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public Boolean getAutomatically() {
        return this.automatically;
    }

    public void setAutomatically(Boolean bool) {
        this.automatically = bool;
    }

    public List<Integer> getListFreqCursor() {
        return this.listFreqCursor;
    }

    public void setListFreqCursor(List<Integer> list) {
        this.listFreqCursor = list;
    }

    public int getPowerDownSave() {
        return this.powerDownSave;
    }

    public void setPowerDownSave(int i) {
        this.powerDownSave = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        allocateDynamic.putInt(this.automatically.booleanValue() ? 1 : 0, 8);
        List<Integer> list = this.listFreqCursor;
        if (list != null && list.size() > 0) {
            allocateDynamic.putInt(1, 8);
            allocateDynamic.putInt(this.listFreqCursor.size(), 16);
            Iterator<Integer> it = this.listFreqCursor.iterator();
            while (it.hasNext()) {
                allocateDynamic.putLong(it.next().intValue(), 8);
            }
        }
        if (Integer.MAX_VALUE != this.powerDownSave) {
            allocateDynamic.putInt(2, 8);
            allocateDynamic.putInt(this.powerDownSave, 8);
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgBaseSetFrequency.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "The channel number is not in the current frequency band.");
                put((byte) 2, "Invalid frequency points.");
                put((byte) 3, "Other error.");
                put((byte) 4, "Save failure.");
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
