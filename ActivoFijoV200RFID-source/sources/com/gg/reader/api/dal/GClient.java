package com.gg.reader.api.dal;

import com.android.usbserial.client.AndroidUsbSerialClient;
import com.gg.reader.api.dal.communication.AndroidPdaSerialClient;
import com.gg.reader.api.dal.communication.AndroidSerialClient;
import com.gg.reader.api.dal.communication.AndroidSerialCusClient;
import com.gg.reader.api.dal.communication.AndroidUsbHidClient;
import com.gg.reader.api.dal.communication.BleBluetoothClient;
import com.gg.reader.api.dal.communication.BluetoothClient;
import com.gg.reader.api.dal.communication.CWSerialClient;
import com.gg.reader.api.dal.communication.CommunicationInterface;
import com.gg.reader.api.dal.communication.HandlerDisconnected;
import com.gg.reader.api.dal.communication.HandlerMessageReceived;
import com.gg.reader.api.dal.communication.TcpClient;
import com.gg.reader.api.protocol.gx.EnumG;
import com.gg.reader.api.protocol.gx.LogAppGpiOver;
import com.gg.reader.api.protocol.gx.LogAppGpiStart;
import com.gg.reader.api.protocol.gx.LogBase6bInfo;
import com.gg.reader.api.protocol.gx.LogBase6bOver;
import com.gg.reader.api.protocol.gx.LogBaseEpcInfo;
import com.gg.reader.api.protocol.gx.LogBaseEpcOver;
import com.gg.reader.api.protocol.gx.LogBaseGJbInfo;
import com.gg.reader.api.protocol.gx.LogBaseGJbOver;
import com.gg.reader.api.protocol.gx.LogBaseGbInfo;
import com.gg.reader.api.protocol.gx.LogBaseGbOver;
import com.gg.reader.api.protocol.gx.LogBaseGbSafeParam;
import com.gg.reader.api.protocol.gx.Message;
import com.gg.reader.api.protocol.gx.MsgAppGetCacheTagData;
import com.gg.reader.api.protocol.gx.MsgAppHeartbeat;
import com.gg.reader.api.utils.GLog;
import com.gg.reader.api.utils.HexUtils;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class GClient {
    private static final int MSG_TIME_OUT = 3000;
    public HandlerCacheDataOver cacheDataOver;
    private CommunicationInterface ci;
    public HandlerDebugLog debugLog;
    private HashMap<Integer, ClientManualResetEvent> dicMre = new HashMap<>();
    private boolean isPrint = true;
    private String name;
    public HandlerTcpDisconnected onDisconnected;
    public HandlerGpiOver onGpiOver;
    public HandlerGpiStart onGpiStart;
    public HandlerTag6bLog onTag6bLog;
    public HandlerTag6bOver onTag6bOver;
    public HandlerTagEpcLog onTagEpcLog;
    public HandlerTagEpcOver onTagEpcOver;
    public HandlerTagGJbLog onTagGJbLog;
    public HandlerTagGJbOver onTagGJbOver;
    public HandlerTagGbLog onTagGbLog;
    public HandlerTagGbOver onTagGbOver;
    public HandlerTagGbSafeParam onTagGbSafeParam;
    private String serialNumber;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
    }

    public int getConnectType() {
        CommunicationInterface communicationInterface = this.ci;
        if (communicationInterface == null) {
            return 255;
        }
        return communicationInterface.getConnectType();
    }

    public void setSendHeartBeat(boolean z) {
        CommunicationInterface communicationInterface = this.ci;
        if (communicationInterface != null) {
            communicationInterface._isSendHeartbeat = z;
        }
    }

    public void setPrint(boolean z) {
        this.isPrint = z;
    }

    protected void triggerTagEpcLogEvent(LogBaseEpcInfo logBaseEpcInfo) {
        try {
            HandlerTagEpcLog handlerTagEpcLog = this.onTagEpcLog;
            if (handlerTagEpcLog != null) {
                synchronized (handlerTagEpcLog) {
                    String str = this.serialNumber;
                    if (str != null) {
                        logBaseEpcInfo.setReaderSerialNumber(str);
                    }
                    this.onTagEpcLog.log(this.name, logBaseEpcInfo);
                }
            }
        } catch (Exception unused) {
        }
    }

    protected void triggerTagEpcOverEvent(LogBaseEpcOver logBaseEpcOver) {
        try {
            HandlerTagEpcOver handlerTagEpcOver = this.onTagEpcOver;
            if (handlerTagEpcOver != null) {
                synchronized (handlerTagEpcOver) {
                    String str = this.serialNumber;
                    if (str != null) {
                        logBaseEpcOver.setReaderSerialNumber(str);
                    }
                    this.onTagEpcOver.log(this.name, logBaseEpcOver);
                }
            }
        } catch (Exception unused) {
        }
    }

    protected void triggerTag6bLogEvent(LogBase6bInfo logBase6bInfo) {
        try {
            HandlerTag6bLog handlerTag6bLog = this.onTag6bLog;
            if (handlerTag6bLog != null) {
                synchronized (handlerTag6bLog) {
                    String str = this.serialNumber;
                    if (str != null) {
                        logBase6bInfo.setReaderSerialNumber(str);
                    }
                    this.onTag6bLog.log(this.name, logBase6bInfo);
                }
            }
        } catch (Exception unused) {
        }
    }

    protected void triggerTag6bOverEvent(LogBase6bOver logBase6bOver) {
        try {
            HandlerTag6bOver handlerTag6bOver = this.onTag6bOver;
            if (handlerTag6bOver != null) {
                synchronized (handlerTag6bOver) {
                    String str = this.serialNumber;
                    if (str != null) {
                        logBase6bOver.setReaderSerialNumber(str);
                    }
                    this.onTag6bOver.log(this.name, logBase6bOver);
                }
            }
        } catch (Exception unused) {
        }
    }

    protected void triggerTagGbLogEvent(LogBaseGbInfo logBaseGbInfo) {
        try {
            HandlerTagGbLog handlerTagGbLog = this.onTagGbLog;
            if (handlerTagGbLog != null) {
                synchronized (handlerTagGbLog) {
                    String str = this.serialNumber;
                    if (str != null) {
                        logBaseGbInfo.setReaderSerialNumber(str);
                    }
                    this.onTagGbLog.log(this.name, logBaseGbInfo);
                }
            }
        } catch (Exception unused) {
        }
    }

    protected void triggerTagGbOverEvent(LogBaseGbOver logBaseGbOver) {
        try {
            HandlerTagGbOver handlerTagGbOver = this.onTagGbOver;
            if (handlerTagGbOver != null) {
                synchronized (handlerTagGbOver) {
                    String str = this.serialNumber;
                    if (str != null) {
                        logBaseGbOver.setReaderSerialNumber(str);
                    }
                    this.onTagGbOver.log(this.name, logBaseGbOver);
                }
            }
        } catch (Exception unused) {
        }
    }

    protected void triggerTagGJbLogEvent(LogBaseGJbInfo logBaseGJbInfo) {
        try {
            HandlerTagGJbLog handlerTagGJbLog = this.onTagGJbLog;
            if (handlerTagGJbLog != null) {
                synchronized (handlerTagGJbLog) {
                    String str = this.serialNumber;
                    if (str != null) {
                        logBaseGJbInfo.setReaderSerialNumber(str);
                    }
                    this.onTagGJbLog.log(this.name, logBaseGJbInfo);
                }
            }
        } catch (Exception unused) {
        }
    }

    protected void triggerTagGJbOverEvent(LogBaseGJbOver logBaseGJbOver) {
        try {
            HandlerTagGJbOver handlerTagGJbOver = this.onTagGJbOver;
            if (handlerTagGJbOver != null) {
                synchronized (handlerTagGJbOver) {
                    String str = this.serialNumber;
                    if (str != null) {
                        logBaseGJbOver.setReaderSerialNumber(str);
                    }
                    this.onTagGJbOver.log(this.name, logBaseGJbOver);
                }
            }
        } catch (Exception unused) {
        }
    }

    protected void triggerTagGbSafeParamEvent(LogBaseGbSafeParam logBaseGbSafeParam) {
        try {
            HandlerTagGbSafeParam handlerTagGbSafeParam = this.onTagGbSafeParam;
            if (handlerTagGbSafeParam != null) {
                synchronized (handlerTagGbSafeParam) {
                    this.onTagGbSafeParam.log(this.name, logBaseGbSafeParam);
                }
            }
        } catch (Exception unused) {
        }
    }

    protected void triggerGpiStart(LogAppGpiStart logAppGpiStart) {
        try {
            HandlerGpiStart handlerGpiStart = this.onGpiStart;
            if (handlerGpiStart != null) {
                synchronized (handlerGpiStart) {
                    String str = this.serialNumber;
                    if (str != null) {
                        logAppGpiStart.setReaderSerialNumber(str);
                    }
                    this.onGpiStart.log(this.name, logAppGpiStart);
                }
            }
        } catch (Exception unused) {
        }
    }

    protected void triggerGpiOver(LogAppGpiOver logAppGpiOver) {
        try {
            HandlerGpiOver handlerGpiOver = this.onGpiOver;
            if (handlerGpiOver != null) {
                synchronized (handlerGpiOver) {
                    String str = this.serialNumber;
                    if (str != null) {
                        logAppGpiOver.setReaderSerialNumber(str);
                    }
                    this.onGpiOver.log(this.name, logAppGpiOver);
                }
            }
        } catch (Exception unused) {
        }
    }

    protected void triggerCacheDataOver(MsgAppGetCacheTagData msgAppGetCacheTagData) {
        try {
            HandlerCacheDataOver handlerCacheDataOver = this.cacheDataOver;
            if (handlerCacheDataOver != null) {
                synchronized (handlerCacheDataOver) {
                    this.cacheDataOver.log(this.name, msgAppGetCacheTagData);
                }
            }
        } catch (Exception unused) {
        }
    }

    protected void triggerDisconnected() {
        try {
            HandlerTcpDisconnected handlerTcpDisconnected = this.onDisconnected;
            if (handlerTcpDisconnected != null) {
                synchronized (handlerTcpDisconnected) {
                    this.onDisconnected.log(this.name);
                }
            }
        } catch (Exception unused) {
        }
    }

    public boolean open(String str, CommunicationInterface communicationInterface, int i) {
        if (communicationInterface == null) {
            return false;
        }
        this.ci = communicationInterface;
        communicationInterface.onMessageReceived = new HandlerMessageReceived() { // from class: com.gg.reader.api.dal.GClient.1
            @Override // com.gg.reader.api.dal.communication.HandlerMessageReceived
            public void received(Message message) {
                GClient.this.processMessage(message);
            }
        };
        this.ci.onDisconnected = new HandlerDisconnected() { // from class: com.gg.reader.api.dal.GClient.2
            @Override // com.gg.reader.api.dal.communication.HandlerDisconnected
            public void log() {
                GClient.this.triggerDisconnected();
            }
        };
        if (!this.ci.isConnected()) {
            return false;
        }
        this.name = str;
        this.ci.setConnectType(3);
        return true;
    }

    public boolean openAndroidSerial(String str, int i) {
        try {
            AndroidSerialClient androidSerialClient = new AndroidSerialClient();
            this.ci = androidSerialClient;
            androidSerialClient.onMessageReceived = new HandlerMessageReceived() { // from class: com.gg.reader.api.dal.GClient.3
                @Override // com.gg.reader.api.dal.communication.HandlerMessageReceived
                public void received(Message message) {
                    GClient.this.processMessage(message);
                }
            };
            if (this.ci.open(str)) {
                this.name = str;
                this.ci.setConnectType(0);
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public boolean openCusAndroidSerial(String str, int i, int i2) {
        try {
            AndroidSerialCusClient androidSerialCusClient = new AndroidSerialCusClient(i, i2);
            this.ci = androidSerialCusClient;
            androidSerialCusClient.onMessageReceived = new HandlerMessageReceived() { // from class: com.gg.reader.api.dal.GClient.4
                @Override // com.gg.reader.api.dal.communication.HandlerMessageReceived
                public void received(Message message) {
                    GClient.this.processMessage(message);
                }
            };
            if (this.ci.open(str)) {
                this.name = str;
                this.ci.setConnectType(0);
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public boolean openAndroidRs485(String str, int i) {
        try {
            String[] split = str.split(":");
            if (split != null && split.length == 3) {
                AndroidSerialClient androidSerialClient = new AndroidSerialClient();
                this.ci = androidSerialClient;
                androidSerialClient.onMessageReceived = new HandlerMessageReceived() { // from class: com.gg.reader.api.dal.GClient.5
                    @Override // com.gg.reader.api.dal.communication.HandlerMessageReceived
                    public void received(Message message) {
                        GClient.this.processMessage(message);
                    }
                };
                if (this.ci.open(split[0] + ":" + split[1])) {
                    this.name = str;
                    this.ci.setConnectType(1);
                    this.ci.setRs485(true);
                    this.ci.setRs485Address(Integer.parseInt(split[2]));
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public boolean openHdSerial(String str, int i) {
        try {
            AndroidPdaSerialClient androidPdaSerialClient = new AndroidPdaSerialClient();
            this.ci = androidPdaSerialClient;
            androidPdaSerialClient.onMessageReceived = new HandlerMessageReceived() { // from class: com.gg.reader.api.dal.GClient.6
                @Override // com.gg.reader.api.dal.communication.HandlerMessageReceived
                public void received(Message message) {
                    GClient.this.processMessage(message);
                }
            };
            if (this.ci.open(str)) {
                this.name = str;
                this.ci.setConnectType(0);
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void hdPowerOn() {
        CommunicationInterface communicationInterface = this.ci;
        if (communicationInterface == null || !(communicationInterface instanceof AndroidPdaSerialClient)) {
            return;
        }
        communicationInterface.hdPowerOn();
    }

    public void hdPowerOff() {
        CommunicationInterface communicationInterface = this.ci;
        if (communicationInterface == null || !(communicationInterface instanceof AndroidPdaSerialClient)) {
            return;
        }
        communicationInterface.hdPowerOff();
    }

    public boolean openTcp(String str, int i) {
        try {
            TcpClient tcpClient = new TcpClient();
            this.ci = tcpClient;
            tcpClient.onMessageReceived = new HandlerMessageReceived() { // from class: com.gg.reader.api.dal.GClient.7
                @Override // com.gg.reader.api.dal.communication.HandlerMessageReceived
                public void received(Message message) {
                    GClient.this.processMessage(message);
                }
            };
            this.ci.onDisconnected = new HandlerDisconnected() { // from class: com.gg.reader.api.dal.GClient.8
                @Override // com.gg.reader.api.dal.communication.HandlerDisconnected
                public void log() {
                    GClient.this.triggerDisconnected();
                }
            };
            if (!this.ci.open(str)) {
                return false;
            }
            this.name = str;
            this.ci.setConnectType(2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean openAndroidUsbSerial(AndroidUsbSerialClient androidUsbSerialClient) {
        try {
            this.ci = androidUsbSerialClient;
            androidUsbSerialClient.onMessageReceived = new HandlerMessageReceived() { // from class: com.gg.reader.api.dal.GClient.9
                @Override // com.gg.reader.api.dal.communication.HandlerMessageReceived
                public void received(Message message) {
                    GClient.this.processMessage(message);
                }
            };
            this.name = androidUsbSerialClient.getUsbName();
            this.ci.setConnectType(4);
            this.ci.open("");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean openAndroidUsbRs485(AndroidUsbSerialClient androidUsbSerialClient, int i) {
        try {
            this.ci = androidUsbSerialClient;
            androidUsbSerialClient.onMessageReceived = new HandlerMessageReceived() { // from class: com.gg.reader.api.dal.GClient.10
                @Override // com.gg.reader.api.dal.communication.HandlerMessageReceived
                public void received(Message message) {
                    GClient.this.processMessage(message);
                }
            };
            this.name = androidUsbSerialClient.getUsbName();
            this.ci.setRs485(true);
            this.ci.setRs485Address(i);
            this.ci.setConnectType(1);
            this.ci.open("");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean openBluetooth(String str, int i, int i2, BluetoothClient bluetoothClient) {
        try {
            this.ci = bluetoothClient;
            bluetoothClient.onMessageReceived = new HandlerMessageReceived() { // from class: com.gg.reader.api.dal.GClient.11
                @Override // com.gg.reader.api.dal.communication.HandlerMessageReceived
                public void received(Message message) {
                    GClient.this.processMessage(message);
                }
            };
            this.ci.onDisconnected = new HandlerDisconnected() { // from class: com.gg.reader.api.dal.GClient.12
                @Override // com.gg.reader.api.dal.communication.HandlerDisconnected
                public void log() {
                    GClient.this.triggerDisconnected();
                }
            };
            if (!this.ci.open(str, i2)) {
                return false;
            }
            this.name = str;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean openCwSerial(String str, int i, CWSerialClient cWSerialClient) {
        try {
            this.ci = cWSerialClient;
            cWSerialClient.onMessageReceived = new HandlerMessageReceived() { // from class: com.gg.reader.api.dal.GClient.13
                @Override // com.gg.reader.api.dal.communication.HandlerMessageReceived
                public void received(Message message) {
                    GClient.this.processMessage(message);
                }
            };
            if (this.ci.open(str)) {
                this.name = str;
                this.ci.setConnectType(0);
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public boolean openBleBluetooth(String str, int i, BleBluetoothClient bleBluetoothClient) {
        try {
            this.ci = bleBluetoothClient;
            bleBluetoothClient.onMessageReceived = new HandlerMessageReceived() { // from class: com.gg.reader.api.dal.GClient.14
                @Override // com.gg.reader.api.dal.communication.HandlerMessageReceived
                public void received(Message message) {
                    GClient.this.processMessage(message);
                }
            };
            this.ci.onDisconnected = new HandlerDisconnected() { // from class: com.gg.reader.api.dal.GClient.15
                @Override // com.gg.reader.api.dal.communication.HandlerDisconnected
                public void log() {
                    GClient.this.triggerDisconnected();
                }
            };
            if (!this.ci.open(str, i)) {
                return false;
            }
            this.name = str;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean openAndroidUsbHid(AndroidUsbHidClient androidUsbHidClient) {
        try {
            this.ci = androidUsbHidClient;
            androidUsbHidClient.onMessageReceived = new HandlerMessageReceived() { // from class: com.gg.reader.api.dal.GClient.16
                @Override // com.gg.reader.api.dal.communication.HandlerMessageReceived
                public void received(Message message) {
                    GClient.this.processMessage(message);
                }
            };
            this.name = androidUsbHidClient.getUsbName();
            this.ci.setConnectType(0);
            this.ci.open("");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean close() {
        try {
            CommunicationInterface communicationInterface = this.ci;
            if (communicationInterface == null) {
                return false;
            }
            communicationInterface.close();
            this.ci.onMessageReceived = null;
            this.ci.onDisconnected = null;
            this.ci = null;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void sendSynMsg(Message message, int i) {
        HandlerDebugLog handlerDebugLog;
        HandlerDebugLog handlerDebugLog2;
        if (message == null) {
            return;
        }
        if (getConnectType() == 1) {
            message.msgType.mt_13 = "1";
        }
        int i2 = message.msgType.toInt();
        if (this.dicMre == null) {
            this.dicMre = new HashMap<>();
        }
        if (!this.dicMre.containsKey(Integer.valueOf(i2))) {
            ClientManualResetEvent clientManualResetEvent = new ClientManualResetEvent(false);
            clientManualResetEvent.data = null;
            this.dicMre.put(Integer.valueOf(i2), clientManualResetEvent);
        } else {
            this.dicMre.get(Integer.valueOf(i2)).data = null;
            this.dicMre.get(Integer.valueOf(i2)).evt.reset();
        }
        try {
            this.ci.send(message);
            if (this.isPrint && (handlerDebugLog2 = this.debugLog) != null) {
                handlerDebugLog2.sendDebugLog("send-[" + message.getClass().getName() + "]-[" + HexUtils.bytes2HexString(message.msgData) + "]");
            }
            this.dicMre.get(Integer.valueOf(i2)).evt.waitOne(i);
            if (this.dicMre.get(Integer.valueOf(i2)).data != null) {
                message.msgData = this.dicMre.get(Integer.valueOf(i2)).data.msgData;
                message.ackUnpack(this.dicMre.get(Integer.valueOf(i2)).data.cData);
                if (!this.isPrint || (handlerDebugLog = this.debugLog) == null) {
                    return;
                }
                handlerDebugLog.receiveDebugLog("receive-[" + message.getClass().getName() + "]-[" + HexUtils.bytes2HexString(message.msgData) + "]");
            }
        } catch (Exception unused) {
        }
    }

    public void sendSynMsg(Message message) {
        sendSynMsg(message, 3000);
    }

    public void sendSynMsgRetry(Message message, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sendSynMsg(message, i);
            if (message.getRtCode() == 0) {
                return;
            }
        }
    }

    public void sendUnsynMsg(Message message) {
        HandlerDebugLog handlerDebugLog;
        if (message == null) {
            return;
        }
        this.ci.send(message);
        if (!this.isPrint || (handlerDebugLog = this.debugLog) == null) {
            return;
        }
        handlerDebugLog.sendDebugLog("send-[" + message.getClass().getName() + "]-[" + HexUtils.bytes2HexString(message.msgData) + "]");
    }

    public void sendUnsynMsg(byte[] bArr) {
        HandlerDebugLog handlerDebugLog;
        if (bArr == null) {
            return;
        }
        this.ci.send(bArr);
        if (!this.isPrint || (handlerDebugLog = this.debugLog) == null) {
            return;
        }
        handlerDebugLog.sendDebugLog("send-[custom]-[" + HexUtils.bytes2HexString(bArr) + "]");
    }

    public void sendUnsynMsgRetry(Message message, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sendUnsynMsg(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMessage(Message message) {
        if (message == null) {
            return;
        }
        try {
            if (message.msgType.mt_12.equals("0")) {
                int i = message.msgType.toInt();
                if (this.dicMre.containsKey(Integer.valueOf(i))) {
                    this.dicMre.get(Integer.valueOf(i)).data = message;
                    this.dicMre.get(Integer.valueOf(i)).evt.set();
                    return;
                }
                return;
            }
            if (message.msgType.mt_8_11.equals(EnumG.MSG_TYPE_BIT_BASE)) {
                if (message.msgType.msgId == 0) {
                    LogBaseEpcInfo logBaseEpcInfo = new LogBaseEpcInfo();
                    logBaseEpcInfo.ackUnpack(message.cData);
                    triggerTagEpcLogEvent(logBaseEpcInfo);
                    return;
                }
                if (32 == message.msgType.msgId) {
                    LogBase6bInfo logBase6bInfo = new LogBase6bInfo();
                    logBase6bInfo.ackUnpack(message.cData);
                    triggerTag6bLogEvent(logBase6bInfo);
                    return;
                }
                if (48 == message.msgType.msgId) {
                    LogBaseGbInfo logBaseGbInfo = new LogBaseGbInfo();
                    logBaseGbInfo.ackUnpack(message.cData);
                    triggerTagGbLogEvent(logBaseGbInfo);
                    return;
                }
                if (64 == message.msgType.msgId) {
                    LogBaseGJbInfo logBaseGJbInfo = new LogBaseGJbInfo();
                    logBaseGJbInfo.ackUnpack(message.cData);
                    triggerTagGJbLogEvent(logBaseGJbInfo);
                    return;
                }
                if (1 == message.msgType.msgId) {
                    LogBaseEpcOver logBaseEpcOver = new LogBaseEpcOver();
                    logBaseEpcOver.ackUnpack(message.cData);
                    triggerTagEpcOverEvent(logBaseEpcOver);
                    return;
                }
                if (33 == message.msgType.msgId) {
                    LogBase6bOver logBase6bOver = new LogBase6bOver();
                    logBase6bOver.ackUnpack(message.cData);
                    triggerTag6bOverEvent(logBase6bOver);
                    return;
                }
                if (49 == message.msgType.msgId) {
                    LogBaseGbOver logBaseGbOver = new LogBaseGbOver();
                    logBaseGbOver.ackUnpack(message.cData);
                    triggerTagGbOverEvent(logBaseGbOver);
                    return;
                } else if (65 == message.msgType.msgId) {
                    LogBaseGJbOver logBaseGJbOver = new LogBaseGJbOver();
                    logBaseGJbOver.ackUnpack(message.cData);
                    triggerTagGJbOverEvent(logBaseGJbOver);
                    return;
                } else {
                    if (50 == message.msgType.msgId) {
                        LogBaseGbSafeParam logBaseGbSafeParam = new LogBaseGbSafeParam();
                        logBaseGbSafeParam.ackUnpack(message.cData);
                        triggerTagGbSafeParamEvent(logBaseGbSafeParam);
                        return;
                    }
                    return;
                }
            }
            if (message.msgType.mt_8_11.equals(EnumG.MSG_TYPE_BIT_APP)) {
                if (18 == message.msgType.msgId) {
                    if (this.isPrint) {
                        GLog.d("[heartbeat]");
                    }
                    MsgAppHeartbeat msgAppHeartbeat = new MsgAppHeartbeat();
                    msgAppHeartbeat.msgType = message.msgType;
                    msgAppHeartbeat.ackUnpack(message.cData);
                    sendUnsynMsg(msgAppHeartbeat);
                }
                if (message.msgType.msgId == 0) {
                    LogAppGpiStart logAppGpiStart = new LogAppGpiStart();
                    logAppGpiStart.ackUnpack(message.cData);
                    triggerGpiStart(logAppGpiStart);
                } else if (1 == message.msgType.msgId) {
                    LogAppGpiOver logAppGpiOver = new LogAppGpiOver();
                    logAppGpiOver.ackUnpack(message.cData);
                    triggerGpiOver(logAppGpiOver);
                } else if (27 == message.msgType.msgId) {
                    MsgAppGetCacheTagData msgAppGetCacheTagData = new MsgAppGetCacheTagData();
                    msgAppGetCacheTagData.ackUnpack(message.cData);
                    triggerCacheDataOver(msgAppGetCacheTagData);
                }
            }
        } catch (Exception unused) {
        }
    }
}
