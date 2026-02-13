package com.gg.reader.api.protocol.gx;

import com.gg.reader.api.utils.BitBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class MsgBaseGetFrequency extends Message {
    private Boolean automatically;
    private List<Integer> listFreqCursor;

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
    }

    public MsgBaseGetFrequency() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_BASE;
            this.msgType.msgId = (byte) 6;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgBaseGetFrequency(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                boolean z = true;
                if (wrap.getIntUnsigned(8) != 1) {
                    z = false;
                }
                this.automatically = Boolean.valueOf(z);
                if (this.listFreqCursor == null) {
                    this.listFreqCursor = new ArrayList();
                }
                int intUnsigned = wrap.getIntUnsigned(16);
                for (int i = 0; i < intUnsigned; i++) {
                    this.listFreqCursor.add(Integer.valueOf(wrap.getIntUnsigned(8)));
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

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.putInt(this.automatically.booleanValue() ? 1 : 0, 8);
            List<Integer> list = this.listFreqCursor;
            if (list != null && list.size() > 0) {
                allocateDynamic.putInt(this.listFreqCursor.size(), 16);
                Iterator<Integer> it = this.listFreqCursor.iterator();
                while (it.hasNext()) {
                    allocateDynamic.putLong(it.next().intValue(), 8);
                }
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
        this.automatically = Boolean.valueOf(wrap.getIntUnsigned(8) == 1);
        if (this.listFreqCursor == null) {
            this.listFreqCursor = new ArrayList();
        }
        int intUnsigned = wrap.getIntUnsigned(16);
        for (int i = 0; i < intUnsigned; i++) {
            this.listFreqCursor.add(Integer.valueOf(wrap.getIntUnsigned(8)));
        }
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgBaseGetFrequency{automatically=" + this.automatically + ", listFreqCursor=" + this.listFreqCursor + '}';
    }
}
