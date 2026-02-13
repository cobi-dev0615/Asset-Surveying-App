package com.gg.reader.api.dal;

import com.gg.reader.api.entity.GMulticast;
import com.gg.reader.api.utils.ThreadPoolUtils;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/* loaded from: classes2.dex */
public class GUdpMulticast {
    private String _GroupIP;
    private int _GroupPort;
    private InetAddress address;
    public HandlerDebugLog debugLog;
    public HandlerUdpMulticast handlerUdpMulticast;
    private MulticastSocket ms;
    private DatagramPacket dataPacket = null;
    private Boolean keepReceive = false;
    private int index = 0;

    static /* synthetic */ int access$208(GUdpMulticast gUdpMulticast) {
        int i = gUdpMulticast.index;
        gUdpMulticast.index = i + 1;
        return i;
    }

    public GUdpMulticast(String str, int i, int i2) {
        this.ms = null;
        try {
            this._GroupIP = str;
            this._GroupPort = i;
            MulticastSocket multicastSocket = new MulticastSocket(this._GroupPort);
            this.ms = multicastSocket;
            multicastSocket.setSoTimeout(i2);
            this.address = InetAddress.getByName(this._GroupIP);
        } catch (IOException unused) {
        }
    }

    public void triggerOnUdpMulticast(GMulticast gMulticast) {
        try {
            HandlerUdpMulticast handlerUdpMulticast = this.handlerUdpMulticast;
            if (handlerUdpMulticast != null) {
                handlerUdpMulticast.log(gMulticast);
            }
        } catch (Exception unused) {
        }
    }

    public void start() {
        if (this.keepReceive.booleanValue()) {
            return;
        }
        this.keepReceive = true;
        final List<String> allNif = getAllNif();
        ThreadPoolUtils.run(new Runnable() { // from class: com.gg.reader.api.dal.GUdpMulticast.1
            @Override // java.lang.Runnable
            public void run() {
                while (GUdpMulticast.this.keepReceive.booleanValue()) {
                    try {
                        try {
                            GUdpMulticast.this.ms.joinGroup(new InetSocketAddress(GUdpMulticast.this.address, 8161), NetworkInterface.getByName((String) allNif.get(GUdpMulticast.this.index % allNif.size())));
                            GUdpMulticast.this.dataPacket = new DatagramPacket(new byte[1024], 1024);
                            if (GUdpMulticast.this.debugLog != null) {
                                GUdpMulticast.this.debugLog.receiveDebugLog("[Udp]-->" + ((String) allNif.get(GUdpMulticast.this.index % allNif.size())) + ":Receive");
                            }
                            GUdpMulticast.this.ms.receive(GUdpMulticast.this.dataPacket);
                            if (GUdpMulticast.this.dataPacket.getLength() > 0 && GUdpMulticast.this.debugLog != null) {
                                GUdpMulticast.this.debugLog.receiveDebugLog("[Udp]-->[" + new String(GUdpMulticast.this.dataPacket.getData(), "ASCII") + "]");
                            }
                            GUdpMulticast.this.triggerOnUdpMulticast(new GMulticast(new String(GUdpMulticast.this.dataPacket.getData(), "ASCII").trim()));
                            GUdpMulticast.this.ms.leaveGroup(GUdpMulticast.this.address);
                        } catch (Exception unused) {
                            GUdpMulticast.this.ms.leaveGroup(GUdpMulticast.this.address);
                            if (GUdpMulticast.this.debugLog != null) {
                                GUdpMulticast.this.debugLog.receiveDebugLog("[Udp]-->Next network adapter");
                            }
                        }
                    } catch (IOException unused2) {
                    }
                    GUdpMulticast.access$208(GUdpMulticast.this);
                }
            }
        });
    }

    public void close() {
        this.keepReceive = false;
        this.ms.close();
    }

    private List<String> getAllNif() {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    if ((nextElement2 instanceof Inet4Address) && !nextElement2.getHostAddress().equals("127.0.0.1")) {
                        arrayList.add(nextElement.getName());
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
