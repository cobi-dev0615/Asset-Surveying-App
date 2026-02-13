package com.gg.reader.api.protocol.gx;

import com.bumptech.glide.load.Key;
import com.gg.reader.api.utils.BitBuffer;
import com.gg.reader.api.utils.StringUtils;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class MsgAppSetWifiHotspot extends Message {
    private int certificationType;
    private String connectPassword;
    private int encryptionAlgorithm;
    private String hotspotName;

    public MsgAppSetWifiHotspot() {
        this.certificationType = Integer.MAX_VALUE;
        this.encryptionAlgorithm = Integer.MAX_VALUE;
        try {
            this.msgType = new MsgType();
            this.msgType.mt_8_11 = EnumG.MSG_TYPE_BIT_APP;
            this.msgType.msgId = (byte) 51;
            this.dataLen = 0;
        } catch (Exception unused) {
        }
    }

    public MsgAppSetWifiHotspot(byte[] bArr) {
        this();
        if (bArr != null) {
            try {
                if (bArr.length <= 0) {
                    return;
                }
                BitBuffer wrap = BitBuffer.wrap(bArr);
                wrap.position(0);
                int intUnsigned = wrap.getIntUnsigned(16);
                if (intUnsigned > 0) {
                    this.hotspotName = new String(wrap.get(new byte[intUnsigned]), Key.STRING_CHARSET_NAME);
                }
                while (wrap.position() / 8 < bArr.length) {
                    byte b = wrap.getByte();
                    if (b == 1) {
                        int intUnsigned2 = wrap.getIntUnsigned(16);
                        if (intUnsigned2 > 0) {
                            this.connectPassword = new String(wrap.get(new byte[intUnsigned2]), "ASCII");
                        }
                    } else if (b == 2) {
                        this.certificationType = wrap.getIntUnsigned(8);
                    } else if (b == 3) {
                        this.encryptionAlgorithm = wrap.getIntUnsigned(8);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public String getHotspotName() {
        return this.hotspotName;
    }

    public void setHotspotName(String str) {
        this.hotspotName = str;
    }

    public String getConnectPassword() {
        return this.connectPassword;
    }

    public void setConnectPassword(String str) {
        this.connectPassword = str;
    }

    public int getCertificationType() {
        return this.certificationType;
    }

    public void setCertificationType(int i) {
        this.certificationType = i;
    }

    public int getEncryptionAlgorithm() {
        return this.encryptionAlgorithm;
    }

    public void setEncryptionAlgorithm(int i) {
        this.encryptionAlgorithm = i;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void pack() {
        BitBuffer allocateDynamic = BitBuffer.allocateDynamic();
        if (!StringUtils.isNullOfEmpty(this.hotspotName)) {
            allocateDynamic.putInt(this.hotspotName.length(), 16);
            allocateDynamic.put(this.hotspotName);
        }
        if (!StringUtils.isNullOfEmpty(this.connectPassword)) {
            allocateDynamic.putInt(1, 8);
            allocateDynamic.putInt(this.connectPassword.length(), 16);
            allocateDynamic.put(this.connectPassword);
        }
        if (Integer.MAX_VALUE != this.certificationType) {
            allocateDynamic.putInt(2, 8);
            allocateDynamic.putInt(this.certificationType, 8);
        }
        if (Integer.MAX_VALUE != this.encryptionAlgorithm) {
            allocateDynamic.putInt(3, 8);
            allocateDynamic.putInt(this.encryptionAlgorithm, 8);
        }
        this.cData = allocateDynamic.asByteArray();
        this.dataLen = this.cData.length;
    }

    @Override // com.gg.reader.api.protocol.gx.Message
    public void ackUnpack() {
        Hashtable<Byte, String> hashtable = new Hashtable<Byte, String>() { // from class: com.gg.reader.api.protocol.gx.MsgAppSetWifiHotspot.1
            {
                put((byte) 0, "Success.");
                put((byte) 1, "Set Fail.");
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
