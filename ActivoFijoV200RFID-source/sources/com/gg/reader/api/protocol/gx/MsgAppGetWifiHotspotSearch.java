package com.gg.reader.api.protocol.gx;

import com.bumptech.glide.load.Key;
import com.gg.reader.api.entity.WifiHotspotInfo;
import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.JsonReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class MsgAppGetWifiHotspotSearch extends Message {
    private JsonReader jsonReader;
    private byte[] packetContent;
    private Long searchResultPacketNumber;

    public MsgAppGetWifiHotspotSearch() {
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 50;
            this.jsonReader = new JsonReader();
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppGetWifiHotspotSearch(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                this.searchResultPacketNumber = Long.valueOf(wrap.getLongUnsigned(32));
                int intUnsigned = wrap.getIntUnsigned(16);
                byte[] bArr2 = new byte[intUnsigned];
                if (intUnsigned > 0) {
                    this.packetContent = wrap.get(bArr2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public Long getSearchResultPacketNumber() {
        return this.searchResultPacketNumber;
    }

    public void setSearchResultPacketNumber(Long l) {
        this.searchResultPacketNumber = l;
    }

    public byte[] getPacketContent() {
        return this.packetContent;
    }

    public void setPacketContent(byte[] bArr) {
        this.packetContent = bArr;
    }

    public WifiHotspotInfo getWifiFormatterParam(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            if (bArr.length > 0) {
                return (WifiHotspotInfo) this.jsonReader.jsonToClass(new String(bArr, Key.STRING_CHARSET_NAME), WifiHotspotInfo.class);
            }
            return null;
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.putLong(this.searchResultPacketNumber.longValue(), 32);
            this.cData = allocateDynamic.asByteArray();
            this.dataLen = this.cData.length;
        } catch (Exception unused) {
        }
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackPack() {
        try {
            BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
            allocateDynamic.putLong(this.searchResultPacketNumber.longValue(), 32);
            byte[] bArr = this.packetContent;
            if (bArr != null && bArr.length > 0) {
                allocateDynamic.putInt(bArr.length, 16);
                allocateDynamic.put(this.packetContent, 8);
            } else {
                allocateDynamic.putInt(0, 16);
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
        this.searchResultPacketNumber = Long.valueOf(wrap.getLongUnsigned(32));
        int intUnsigned = wrap.getIntUnsigned(16);
        byte[] bArr = new byte[intUnsigned];
        if (intUnsigned > 0) {
            this.packetContent = wrap.get(bArr);
        }
        setRtCode((byte) 0);
    }

    public String toString() {
        return "MsgAppGetWifiHotspotSearch{searchResultPacketNumber=" + this.searchResultPacketNumber + ", packetContent=" + Arrays.toString(this.packetContent) + '}';
    }
}
