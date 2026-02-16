package com.gg.reader.api.dal.communication;

import com.gg.reader.api.dal.HandlerRemoteConnected;
import com.gg.reader.api.utils.ThreadPoolUtils;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/* loaded from: classes2.dex */
public class TcpServer {
    public HandlerRemoteConnected onRemoteConnected;
    private ServerSocket listenSocket = null;
    public Boolean keepListen = false;
    public int listenPort = 8160;

    protected void triggerClientConnectedEvent(TcpClient tcpClient) {
        try {
            HandlerRemoteConnected handlerRemoteConnected = this.onRemoteConnected;
            if (handlerRemoteConnected != null) {
                synchronized (handlerRemoteConnected) {
                    this.onRemoteConnected.log(tcpClient);
                }
            }
        } catch (Exception unused) {
        }
    }

    public boolean open(int i) {
        if (this.listenSocket != null) {
            return false;
        }
        this.keepListen = true;
        try {
            this.listenPort = i;
            ServerSocket serverSocket = new ServerSocket();
            this.listenSocket = serverSocket;
            serverSocket.bind(new InetSocketAddress("0.0.0.0", this.listenPort));
            startListen();
            return true;
        } catch (Exception unused) {
            close();
            return false;
        }
    }

    public void startListen() {
        ThreadPoolUtils.run(new Runnable() { // from class: com.gg.reader.api.dal.communication.TcpServer.1
            @Override // java.lang.Runnable
            public void run() {
                while (TcpServer.this.keepListen.booleanValue()) {
                    try {
                        Socket accept = TcpServer.this.listenSocket.accept();
                        TcpClient tcpClient = new TcpClient();
                        tcpClient.connType = 3;
                        if (tcpClient.open(accept)) {
                            tcpClient.serverIp = accept.getInetAddress().getHostAddress();
                            tcpClient.serverPort = accept.getPort();
                            TcpServer.this.triggerClientConnectedEvent(tcpClient);
                        } else {
                            accept.close();
                            tcpClient.close();
                        }
                    } catch (Exception unused) {
                        return;
                    }
                }
            }
        });
    }

    public void close() {
        this.keepListen = false;
        ServerSocket serverSocket = this.listenSocket;
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (Exception unused) {
            }
        }
    }
}
