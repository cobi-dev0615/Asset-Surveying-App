package com.gg.reader.api.dal;

import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.gg.reader.api.dal.communication.TcpClient;
import com.gg.reader.api.dal.communication.TcpServer;
import com.gg.reader.api.protocol.gx.MsgAppGetReaderInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class GServer {
    private int MSG_TIME_OUT = PathInterpolatorCompat.MAX_NUM_POINTS;
    private HashMap<String, GClient> hpClient = new HashMap<>();
    public HandlerGClientConnected onGClientConnected;
    private TcpServer ts;

    public boolean isListend() {
        TcpServer tcpServer = this.ts;
        if (tcpServer == null) {
            return false;
        }
        return tcpServer.keepListen.booleanValue();
    }

    protected void triggerGClientConnectedEvent(GClient gClient, String str) {
        try {
            HandlerGClientConnected handlerGClientConnected = this.onGClientConnected;
            if (handlerGClientConnected != null) {
                synchronized (handlerGClientConnected) {
                    this.onGClientConnected.log(gClient, str);
                }
            }
        } catch (Exception unused) {
        }
    }

    public boolean open(int i) {
        if (this.ts != null) {
            return false;
        }
        TcpServer tcpServer = new TcpServer();
        this.ts = tcpServer;
        tcpServer.onRemoteConnected = new HandlerRemoteConnected() { // from class: com.gg.reader.api.dal.GServer.1
            @Override // com.gg.reader.api.dal.HandlerRemoteConnected
            public void log(TcpClient tcpClient) {
                GServer.this.processConnect(tcpClient);
            }
        };
        if (this.ts.open(i)) {
            return true;
        }
        close();
        return false;
    }

    public void close() {
        TcpServer tcpServer = this.ts;
        if (tcpServer != null) {
            tcpServer.close();
            this.ts = null;
        }
    }

    public void closeClient(String str) {
        String[] split;
        if (str == null || str == "" || (split = str.split(":")) == null || split.length != 2) {
            return;
        }
        synchronized (this.hpClient) {
            if (this.hpClient.containsKey(str)) {
                this.hpClient.get(str).close();
                this.hpClient.remove(str);
            }
        }
    }

    public void closeAllClient() {
        synchronized (this.hpClient) {
            Iterator<Map.Entry<String, GClient>> it = this.hpClient.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().close();
            }
            this.hpClient.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processConnect(TcpClient tcpClient) {
        if (tcpClient == null) {
            return;
        }
        GClient gClient = new GClient();
        String str = tcpClient.serverIp + ":" + tcpClient.serverPort;
        if (gClient.open(str, tcpClient, this.MSG_TIME_OUT)) {
            gClient.setName(str);
            MsgAppGetReaderInfo msgAppGetReaderInfo = new MsgAppGetReaderInfo();
            gClient.sendSynMsg(msgAppGetReaderInfo);
            String readerSerialNumber = msgAppGetReaderInfo.getRtCode() == 0 ? msgAppGetReaderInfo.getReaderSerialNumber() : null;
            gClient.setSerialNumber(readerSerialNumber);
            triggerGClientConnectedEvent(gClient, readerSerialNumber);
            synchronized (this.hpClient) {
                if (this.hpClient.containsKey(str)) {
                    this.hpClient.get(str).close();
                }
                this.hpClient.put(str, gClient);
            }
            return;
        }
        gClient.close();
        tcpClient.close();
    }
}
