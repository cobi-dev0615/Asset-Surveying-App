package com.lckj.lcrrgxmodule.factory;

import android.media.SoundPool;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import com.devexpress.editors.model.mask.Mask;
import com.gg.reader.api.dal.GClient;
import com.gg.reader.api.dal.HandlerTagEpcLog;
import com.gg.reader.api.dal.HandlerTagEpcOver;
import com.gg.reader.api.protocol.gx.LogBaseEpcInfo;
import com.gg.reader.api.protocol.gx.LogBaseEpcOver;
import com.gg.reader.api.protocol.gx.MsgAppGetBaseVersion;
import com.gg.reader.api.protocol.gx.MsgBaseDestroyEpc;
import com.gg.reader.api.protocol.gx.MsgBaseGetBaseband;
import com.gg.reader.api.protocol.gx.MsgBaseGetFreqRange;
import com.gg.reader.api.protocol.gx.MsgBaseGetFrequency;
import com.gg.reader.api.protocol.gx.MsgBaseGetPower;
import com.gg.reader.api.protocol.gx.MsgBaseInventoryEpc;
import com.gg.reader.api.protocol.gx.MsgBaseLockEpc;
import com.gg.reader.api.protocol.gx.MsgBaseSetBaseband;
import com.gg.reader.api.protocol.gx.MsgBaseSetFreqRange;
import com.gg.reader.api.protocol.gx.MsgBaseSetPower;
import com.gg.reader.api.protocol.gx.MsgBaseStop;
import com.gg.reader.api.protocol.gx.MsgBaseWriteEpc;
import com.gg.reader.api.protocol.gx.MsgTestCarrierWave;
import com.gg.reader.api.protocol.gx.MsgTestVSWRcheck;
import com.gg.reader.api.protocol.gx.ParamEpcFilter;
import com.gg.reader.api.protocol.gx.ParamEpcReadEpc;
import com.gg.reader.api.protocol.gx.ParamEpcReadReserved;
import com.gg.reader.api.protocol.gx.ParamEpcReadTid;
import com.gg.reader.api.protocol.gx.ParamEpcReadUserdata;
import com.gg.reader.api.utils.HexUtils;
import com.rfid.InventoryTagMap;
import com.rfid.InventoryTagResult;
import com.rfid.trans.PcUtils;
import com.rfid.trans.ReadTag;
import com.rfid.trans.ReaderParameter;
import com.rfid.trans.TagCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes3.dex */
public class GxUhfProduct implements ILcUhfProduct {
    private TagCallback callback;
    public static List<InventoryTagMap> lsTagList = new ArrayList();
    public static List<InventoryTagResult> lsList = new ArrayList();
    private static String devport = "/dev/ttyS3";
    private static String devport2 = "/dev/ttyS2";
    private final String TAG = "bldAdd#GxUhfProduct";
    private GClient client = new GClient();
    private volatile boolean isSound = false;
    private Integer soundid = null;
    private SoundPool soundPool = null;
    public String devName = "";
    private volatile boolean soundworking = true;
    private volatile Thread sThread = null;
    private ReaderParameter param = new ReaderParameter();
    private final Object[] lock = new Object[0];
    private volatile Thread tagThread = null;
    private ConcurrentLinkedQueue<ReadTag> queue = new ConcurrentLinkedQueue<>();
    private String singleData = "";
    private int singleArea = -1;

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int GetModuleVersion() {
        return 1;
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int MeasureTemperature(byte[] bArr) {
        return 0;
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int RfOutput(byte b) {
        return 0;
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int SetAntenna(byte b) {
        return 0;
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int SetBaudRate(byte b) {
        return 0;
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int SetBeepNotification(int i) {
        return 0;
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int SetPowerMode(int i) {
        return 0;
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int SetWorkMode(byte b) {
        return 0;
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public void beginSound(boolean z) {
        this.isSound = z;
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public void setsoundid(int i, SoundPool soundPool) {
        this.soundid = Integer.valueOf(i);
        this.soundPool = soundPool;
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public void playSound() {
        SoundPool soundPool;
        Integer num = this.soundid;
        if (num == null || (soundPool = this.soundPool) == null) {
            return;
        }
        try {
            soundPool.play(num.intValue(), 1.0f, 1.0f, 1, 0, 1.0f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int Connect() {
        String str;
        if (Build.VERSION.SDK_INT == 28) {
            str = devport2;
        } else {
            str = devport;
        }
        return Connect(str, 115200);
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int Connect(String str, int i) {
        if (!this.client.openAndroidSerial(str + ":" + i, 0)) {
            return -1;
        }
        Log.e(this.TAG, "Connect Successfully ComPort-BaudRate(" + str + ":" + i + ")");
        MsgBaseStop msgBaseStop = new MsgBaseStop();
        this.client.sendSynMsg(msgBaseStop);
        if (msgBaseStop.getRtCode() != 0) {
            this.client.close();
            return msgBaseStop.getRtCode();
        }
        this.devName = str;
        this.isSound = false;
        this.soundworking = true;
        this.sThread = new Thread(new Runnable() { // from class: com.lckj.lcrrgxmodule.factory.GxUhfProduct$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                GxUhfProduct.this.m651lambda$Connect$0$comlckjlcrrgxmodulefactoryGxUhfProduct();
            }
        });
        this.sThread.start();
        this.tagThread = new Thread(new Runnable() { // from class: com.lckj.lcrrgxmodule.factory.GxUhfProduct$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                GxUhfProduct.this.m652lambda$Connect$1$comlckjlcrrgxmodulefactoryGxUhfProduct();
            }
        });
        this.tagThread.start();
        return 0;
    }

    /* renamed from: lambda$Connect$0$com-lckj-lcrrgxmodule-factory-GxUhfProduct, reason: not valid java name */
    /* synthetic */ void m651lambda$Connect$0$comlckjlcrrgxmodulefactoryGxUhfProduct() {
        while (this.soundworking) {
            if (this.isSound) {
                playSound();
                SystemClock.sleep(50L);
            }
        }
    }

    /* renamed from: lambda$Connect$1$com-lckj-lcrrgxmodule-factory-GxUhfProduct, reason: not valid java name */
    /* synthetic */ void m652lambda$Connect$1$comlckjlcrrgxmodulefactoryGxUhfProduct() {
        while (this.soundworking) {
            ReadTag poll = this.queue.poll();
            TagCallback tagCallback = this.callback;
            if (tagCallback != null) {
                tagCallback.tagCallback(poll);
            }
        }
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int DisConnect() {
        try {
            this.isSound = false;
            this.soundworking = false;
            this.sThread.interrupt();
            this.sThread = null;
            this.tagThread.interrupt();
            this.tagThread = null;
            this.queue.clear();
            SoundPool soundPool = this.soundPool;
            if (soundPool != null) {
                soundPool.release();
                this.soundPool = null;
            }
            List<InventoryTagMap> list = lsTagList;
            if (list != null) {
                list.clear();
            }
            List<InventoryTagResult> list2 = lsList;
            if (list2 != null) {
                list2.clear();
            }
        } catch (Exception e) {
            Log.e(this.TAG, "DisConnect Exception=" + e.getMessage());
        }
        return this.client.close() ? 0 : -1;
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public void SetInventoryParameter(ReaderParameter readerParameter) {
        this.param = readerParameter;
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public ReaderParameter GetInventoryParameter() {
        return this.param;
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int GetUHFInformation(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7) {
        MsgAppGetBaseVersion msgAppGetBaseVersion = new MsgAppGetBaseVersion();
        this.client.sendSynMsg(msgAppGetBaseVersion);
        if (msgAppGetBaseVersion.getRtCode() != 0) {
            return msgAppGetBaseVersion.getRtCode();
        }
        String[] split = msgAppGetBaseVersion.getBaseVersions().split("\\.");
        bArr[0] = Byte.parseByte(split[0]);
        bArr[1] = Byte.parseByte(split[1]);
        bArr[2] = Byte.parseByte(split[2]);
        bArr[3] = Byte.parseByte(split[3]);
        MsgBaseGetPower msgBaseGetPower = new MsgBaseGetPower();
        this.client.sendSynMsg(msgBaseGetPower);
        if (msgBaseGetPower.getRtCode() != 0) {
            return msgBaseGetPower.getRtCode();
        }
        bArr2[0] = msgBaseGetPower.getDicPower().get(1).byteValue();
        MsgBaseGetFreqRange msgBaseGetFreqRange = new MsgBaseGetFreqRange();
        this.client.sendSynMsg(msgBaseGetFreqRange);
        if (msgBaseGetFreqRange.getRtCode() != 0) {
            return msgBaseGetFreqRange.getRtCode();
        }
        int freqRangeIndex = msgBaseGetFreqRange.getFreqRangeIndex();
        if (freqRangeIndex == 0) {
            bArr3[0] = 1;
        } else if (freqRangeIndex == 1) {
            bArr3[0] = 8;
        } else if (freqRangeIndex == 2) {
            bArr3[0] = 3;
        } else if (freqRangeIndex == 3) {
            bArr3[0] = 2;
        } else if (freqRangeIndex == 4) {
            bArr3[0] = 4;
        }
        MsgBaseGetFrequency msgBaseGetFrequency = new MsgBaseGetFrequency();
        this.client.sendSynMsg(msgBaseGetFrequency);
        if (msgBaseGetFreqRange.getRtCode() != 0) {
            return msgBaseGetFreqRange.getRtCode();
        }
        List<Integer> listFreqCursor = msgBaseGetFrequency.getListFreqCursor();
        Collections.sort(listFreqCursor);
        bArr4[0] = listFreqCursor.get(0).byteValue();
        bArr5[0] = listFreqCursor.get(listFreqCursor.size() - 1).byteValue();
        bArr6[0] = 0;
        return 0;
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int SetRfPower(int i) {
        MsgBaseSetPower msgBaseSetPower = new MsgBaseSetPower();
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        hashtable.put(1, Integer.valueOf(i));
        msgBaseSetPower.setDicPower(hashtable);
        this.client.sendSynMsg(msgBaseSetPower);
        return msgBaseSetPower.getRtCode();
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int SetRegion(int i, int i2, int i3) {
        MsgBaseSetFreqRange msgBaseSetFreqRange = new MsgBaseSetFreqRange();
        if (i == 1) {
            msgBaseSetFreqRange.setFreqRangeIndex(0);
        } else if (i == 2) {
            msgBaseSetFreqRange.setFreqRangeIndex(3);
        } else if (i == 3) {
            msgBaseSetFreqRange.setFreqRangeIndex(2);
        } else if (i == 4) {
            msgBaseSetFreqRange.setFreqRangeIndex(4);
        } else if (i == 8) {
            msgBaseSetFreqRange.setFreqRangeIndex(1);
        }
        MsgBaseGetFreqRange msgBaseGetFreqRange = new MsgBaseGetFreqRange();
        this.client.sendSynMsg(msgBaseGetFreqRange);
        if (msgBaseGetFreqRange.getRtCode() != 0) {
            return msgBaseGetFreqRange.getRtCode();
        }
        if (msgBaseGetFreqRange.getFreqRangeIndex() == msgBaseSetFreqRange.getFreqRangeIndex()) {
            return 0;
        }
        this.client.sendSynMsg(msgBaseSetFreqRange);
        return msgBaseSetFreqRange.getRtCode();
    }

    public void onSingleCallback() {
        this.client.onTagEpcLog = null;
        this.client.onTagEpcOver = null;
        this.client.onTagEpcLog = new HandlerTagEpcLog() { // from class: com.lckj.lcrrgxmodule.factory.GxUhfProduct.1
            @Override // com.gg.reader.api.dal.HandlerTagEpcLog
            public void log(String str, LogBaseEpcInfo logBaseEpcInfo) {
                if (logBaseEpcInfo.getResult() == 0 && GxUhfProduct.this.singleData.equals("")) {
                    int i = GxUhfProduct.this.singleArea;
                    if (i == 0) {
                        GxUhfProduct.this.singleData = logBaseEpcInfo.getReserved();
                    } else if (i == 1) {
                        GxUhfProduct.this.singleData = logBaseEpcInfo.getEpcData();
                    } else if (i == 2) {
                        GxUhfProduct.this.singleData = logBaseEpcInfo.getTid();
                    } else if (i == 3) {
                        GxUhfProduct.this.singleData = logBaseEpcInfo.getUserdata();
                    }
                    synchronized (GxUhfProduct.this.lock) {
                        GxUhfProduct.this.lock.notify();
                    }
                }
            }
        };
        this.client.onTagEpcOver = new HandlerTagEpcOver() { // from class: com.lckj.lcrrgxmodule.factory.GxUhfProduct.2
            @Override // com.gg.reader.api.dal.HandlerTagEpcOver
            public void log(String str, LogBaseEpcOver logBaseEpcOver) {
            }
        };
    }

    public void onLoopCallback() {
        this.queue.clear();
        this.client.onTagEpcLog = null;
        this.client.onTagEpcOver = null;
        this.client.onTagEpcLog = new HandlerTagEpcLog() { // from class: com.lckj.lcrrgxmodule.factory.GxUhfProduct.3
            @Override // com.gg.reader.api.dal.HandlerTagEpcLog
            public void log(String str, LogBaseEpcInfo logBaseEpcInfo) {
                Log.d(GxUhfProduct.this.TAG, "log: logBaseEpcInfo -->" + logBaseEpcInfo);
                if (logBaseEpcInfo.getResult() == 0) {
                    ReadTag readTag = new ReadTag();
                    readTag.antId = logBaseEpcInfo.getAntId();
                    readTag.epcId = logBaseEpcInfo.getEpc();
                    Log.d(GxUhfProduct.this.TAG, "log: logBaseEpcInfo.getEpc() --> " + logBaseEpcInfo.getEpc().isEmpty());
                    if (logBaseEpcInfo.getTid() != null) {
                        readTag.epcId = logBaseEpcInfo.getTid();
                    }
                    readTag.rssi = logBaseEpcInfo.getRssi();
                    String str2 = GxUhfProduct.this.TAG;
                    StringBuilder sb = new StringBuilder("log: callback -->");
                    sb.append(GxUhfProduct.this.callback != null);
                    Log.d(str2, sb.toString());
                    Log.d(GxUhfProduct.this.TAG, "log: test");
                    GxUhfProduct.this.queue.offer(readTag);
                }
            }
        };
        this.client.onTagEpcOver = new HandlerTagEpcOver() { // from class: com.lckj.lcrrgxmodule.factory.GxUhfProduct.4
            @Override // com.gg.reader.api.dal.HandlerTagEpcOver
            public void log(String str, LogBaseEpcOver logBaseEpcOver) {
                GxUhfProduct.this.isSound = false;
                if (GxUhfProduct.this.callback != null) {
                    GxUhfProduct.this.callback.FinishCallBack();
                }
            }
        };
    }

    public String ReadDataFilter(int i, String str, byte b, byte b2, byte b3, byte[] bArr) {
        String str2;
        this.singleData = "";
        this.singleArea = b;
        this.client.sendUnsynMsg(new MsgBaseStop());
        onSingleCallback();
        MsgBaseInventoryEpc msgBaseInventoryEpc = new MsgBaseInventoryEpc();
        msgBaseInventoryEpc.setAntennaEnable(1L);
        msgBaseInventoryEpc.setInventoryMode(1);
        if (b == 0) {
            ParamEpcReadReserved paramEpcReadReserved = new ParamEpcReadReserved();
            paramEpcReadReserved.setStart(b2);
            paramEpcReadReserved.setLen(b3);
            msgBaseInventoryEpc.setReadReserved(paramEpcReadReserved);
        } else if (b == 1) {
            ParamEpcReadEpc paramEpcReadEpc = new ParamEpcReadEpc();
            paramEpcReadEpc.setStart(b2 + 2);
            paramEpcReadEpc.setLen(b3);
            msgBaseInventoryEpc.setReadEpc(paramEpcReadEpc);
        } else if (b == 2) {
            ParamEpcReadTid paramEpcReadTid = new ParamEpcReadTid();
            paramEpcReadTid.setMode(1);
            paramEpcReadTid.setLen(b3);
            msgBaseInventoryEpc.setReadTid(paramEpcReadTid);
        } else if (b == 3) {
            ParamEpcReadUserdata paramEpcReadUserdata = new ParamEpcReadUserdata();
            paramEpcReadUserdata.setStart(b2);
            paramEpcReadUserdata.setLen(b3);
            msgBaseInventoryEpc.setReadUserdata(paramEpcReadUserdata);
        }
        msgBaseInventoryEpc.setHexPassword(HexUtils.bytes2HexString(bArr));
        ParamEpcFilter paramEpcFilter = new ParamEpcFilter();
        paramEpcFilter.setArea(i);
        paramEpcFilter.setHexData(str);
        paramEpcFilter.setBitStart(i == 1 ? 32 : 0);
        paramEpcFilter.setBitLength(str.length() * 4);
        msgBaseInventoryEpc.setFilter(paramEpcFilter);
        this.client.sendSynMsg(msgBaseInventoryEpc);
        if (msgBaseInventoryEpc.getRtCode() != 0) {
            return String.format("%2X", Byte.valueOf(msgBaseInventoryEpc.getRtCode()));
        }
        synchronized (this.lock) {
            try {
                try {
                    this.lock.wait(2000L);
                    this.client.sendSynMsg(new MsgBaseStop());
                    str2 = this.singleData;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public String ReadDataByEPC(String str, byte b, byte b2, byte b3, byte[] bArr) {
        return ReadDataFilter(1, str, b, b2, b3, bArr);
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public String ReadDataByTID(String str, byte b, byte b2, byte b3, byte[] bArr) {
        return ReadDataFilter(2, str, b, b2, b3, bArr);
    }

    public int WriteDataFilter(int i, String str, byte b, byte b2, byte[] bArr, String str2) {
        String padLeft;
        MsgBaseWriteEpc msgBaseWriteEpc = new MsgBaseWriteEpc();
        msgBaseWriteEpc.setAntennaEnable(1L);
        msgBaseWriteEpc.setArea(b);
        msgBaseWriteEpc.setStart(b2 == 0 ? (byte) 1 : b2);
        msgBaseWriteEpc.setHexPassword(HexUtils.bytes2HexString(bArr));
        int valueLen = PcUtils.getValueLen(str2);
        if (b == 1 && (b2 == 1 || b2 == 0)) {
            padLeft = PcUtils.getPc(valueLen) + PcUtils.padLeft(str2, valueLen, Mask.DIGIT_SYMBOL);
        } else {
            padLeft = PcUtils.padLeft(str2, valueLen, Mask.DIGIT_SYMBOL);
        }
        msgBaseWriteEpc.setHexWriteData(padLeft);
        ParamEpcFilter paramEpcFilter = new ParamEpcFilter();
        paramEpcFilter.setArea(i);
        paramEpcFilter.setHexData(str);
        paramEpcFilter.setBitStart(i == 1 ? 32 : 0);
        paramEpcFilter.setBitLength(str.length() * 4);
        msgBaseWriteEpc.setFilter(paramEpcFilter);
        this.client.sendSynMsg(msgBaseWriteEpc);
        Log.e("WriteDataFilter", "MsgBaseWriteEpc " + ((int) msgBaseWriteEpc.getRtCode()) + "=" + msgBaseWriteEpc.getRtMsg());
        return msgBaseWriteEpc.getRtCode();
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int WriteDataByEPC(String str, byte b, byte b2, byte[] bArr, String str2) {
        return WriteDataFilter(1, str, b, b2, bArr, str2);
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int WriteDataByTID(String str, byte b, byte b2, byte[] bArr, String str2) {
        return WriteDataFilter(2, str, b, b2, bArr, str2);
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int WriteEPCByTID(String str, String str2, byte[] bArr) {
        return WriteDataFilter(2, str, (byte) 1, (byte) 1, bArr, str2);
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int Lock(String str, byte b, byte b2, String str2) {
        this.client.sendUnsynMsg(new MsgBaseStop());
        MsgBaseWriteEpc msgBaseWriteEpc = new MsgBaseWriteEpc();
        ParamEpcFilter paramEpcFilter = new ParamEpcFilter();
        paramEpcFilter.setArea(1);
        paramEpcFilter.setBitStart(32);
        paramEpcFilter.setBitLength(str.length() * 4);
        paramEpcFilter.setHexData(str);
        msgBaseWriteEpc.setFilter(paramEpcFilter);
        if (b2 != 0 && b2 != 1) {
            msgBaseWriteEpc.setAntennaEnable(1L);
            msgBaseWriteEpc.setArea(0);
            msgBaseWriteEpc.setStart(2);
            msgBaseWriteEpc.setHexWriteData(str2);
            msgBaseWriteEpc.setFilter(paramEpcFilter);
            this.client.sendSynMsg(msgBaseWriteEpc);
            if (msgBaseWriteEpc.getRtCode() != 0) {
                Log.e("Lock", "WritePws Failed " + msgBaseWriteEpc.getRtMsg());
                return msgBaseWriteEpc.getRtCode();
            }
        } else {
            msgBaseWriteEpc.setRtCode((byte) 0);
        }
        MsgBaseLockEpc msgBaseLockEpc = new MsgBaseLockEpc();
        msgBaseLockEpc.setAntennaEnable(1L);
        msgBaseLockEpc.setArea(b);
        if (b2 == 0) {
            msgBaseLockEpc.setMode(0);
        } else if (b2 == 1) {
            msgBaseLockEpc.setMode(2);
        } else if (b2 == 2) {
            msgBaseLockEpc.setMode(1);
        } else if (b2 == 3) {
            msgBaseLockEpc.setMode(3);
        }
        msgBaseLockEpc.setHexPassword(str2);
        msgBaseLockEpc.setFilter(paramEpcFilter);
        this.client.sendSynMsg(msgBaseLockEpc);
        Log.e("Lock", "Lock [" + ((int) msgBaseLockEpc.getRtCode()) + "] [" + msgBaseLockEpc.getRtMsg() + "]");
        return msgBaseLockEpc.getRtCode();
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int Kill(String str, String str2) {
        this.client.sendUnsynMsg(new MsgBaseStop());
        MsgBaseWriteEpc msgBaseWriteEpc = new MsgBaseWriteEpc();
        msgBaseWriteEpc.setAntennaEnable(1L);
        msgBaseWriteEpc.setArea(0);
        msgBaseWriteEpc.setStart(0);
        msgBaseWriteEpc.setHexWriteData(str2);
        ParamEpcFilter paramEpcFilter = new ParamEpcFilter();
        paramEpcFilter.setArea(1);
        paramEpcFilter.setBitStart(32);
        paramEpcFilter.setBitLength(str.length() * 4);
        paramEpcFilter.setHexData(str);
        msgBaseWriteEpc.setFilter(paramEpcFilter);
        this.client.sendSynMsg(msgBaseWriteEpc);
        if (msgBaseWriteEpc.getRtCode() != 0) {
            Log.e("Kill", "WritePws Failed " + msgBaseWriteEpc.getRtMsg());
            return msgBaseWriteEpc.getRtCode();
        }
        MsgBaseDestroyEpc msgBaseDestroyEpc = new MsgBaseDestroyEpc();
        msgBaseDestroyEpc.setAntennaEnable(1L);
        msgBaseDestroyEpc.setHexPassword(str2);
        msgBaseDestroyEpc.setFilter(paramEpcFilter);
        this.client.sendSynMsg(msgBaseDestroyEpc);
        Log.e("Kill", "Destroy [" + ((int) msgBaseDestroyEpc.getRtCode()) + "] [" + msgBaseDestroyEpc.getRtMsg() + "]");
        return msgBaseDestroyEpc.getRtCode();
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public void SetCallBack(TagCallback tagCallback) {
        this.callback = tagCallback;
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int StartRead() {
        this.client.sendUnsynMsg(new MsgBaseStop());
        onLoopCallback();
        MsgBaseGetBaseband msgBaseGetBaseband = new MsgBaseGetBaseband();
        this.client.sendSynMsg(msgBaseGetBaseband);
        if (msgBaseGetBaseband.getRtCode() != 0) {
            Log.e("StartRead", "getBaseBand Failed");
            return msgBaseGetBaseband.getRtCode();
        }
        if (msgBaseGetBaseband.getqValue() != this.param.QValue || msgBaseGetBaseband.getSession() != this.param.Session) {
            MsgBaseSetBaseband msgBaseSetBaseband = new MsgBaseSetBaseband();
            msgBaseSetBaseband.setqValue(this.param.QValue);
            msgBaseSetBaseband.setSession(this.param.Session);
            this.client.sendSynMsg(msgBaseSetBaseband);
            if (msgBaseSetBaseband.getRtCode() != 0) {
                Log.e("StartRead", "SetBaseBand Failed");
                return msgBaseSetBaseband.getRtCode();
            }
        }
        MsgBaseInventoryEpc msgBaseInventoryEpc = new MsgBaseInventoryEpc();
        msgBaseInventoryEpc.setAntennaEnable(1L);
        msgBaseInventoryEpc.setInventoryMode(1);
        if (this.param.TidLen > 0) {
            ParamEpcReadTid paramEpcReadTid = new ParamEpcReadTid();
            paramEpcReadTid.setMode(1);
            paramEpcReadTid.setLen(this.param.TidLen);
            msgBaseInventoryEpc.setReadTid(paramEpcReadTid);
        }
        this.client.sendSynMsg(msgBaseInventoryEpc);
        Log.e("StartRead", "Inventory [" + ((int) msgBaseInventoryEpc.getRtCode()) + "] [" + msgBaseInventoryEpc.getRtMsg() + "]");
        return msgBaseInventoryEpc.getRtCode();
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public void StopRead() {
        this.isSound = false;
        MsgBaseStop msgBaseStop = new MsgBaseStop();
        this.client.sendSynMsg(msgBaseStop);
        Log.d(this.TAG, "StopRead: ===========stop.getRtCode()==" + ((int) msgBaseStop.getRtCode()));
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public List<InventoryTagMap> getInventoryTagMapList() {
        return lsTagList;
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public List<InventoryTagResult> getInventoryTagResultList() {
        return lsList;
    }

    @Override // com.lckj.lcrrgxmodule.factory.ILcUhfProduct
    public int MeasureReturnLoss(byte[] bArr) {
        MsgTestCarrierWave msgTestCarrierWave = new MsgTestCarrierWave();
        msgTestCarrierWave.setAntennaNum(1L);
        msgTestCarrierWave.setFreqCursor(0);
        this.client.sendSynMsg(msgTestCarrierWave);
        if (msgTestCarrierWave.getRtCode() == 0) {
            MsgTestVSWRcheck msgTestVSWRcheck = new MsgTestVSWRcheck();
            this.client.sendSynMsg(msgTestVSWRcheck);
            if (msgTestVSWRcheck.getRtCode() == 0) {
                bArr[0] = (byte) msgTestVSWRcheck.getSufValue();
                return msgTestVSWRcheck.getRtCode();
            }
        }
        return msgTestCarrierWave.getRtCode();
    }
}
