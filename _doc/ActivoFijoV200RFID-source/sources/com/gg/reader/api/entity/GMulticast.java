package com.gg.reader.api.entity;

/* loaded from: classes2.dex */
public class GMulticast {
    private String connectMode;
    private String deviceType;
    private String dhcp;
    private String gateway;
    private String ip;
    private String mac;
    private String mask;
    private String remoteIP;
    private String remotePort;
    private String serverPort;
    private String workingMode;

    public String getMac() {
        return this.mac;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public String getServerPort() {
        return this.serverPort;
    }

    public void setServerPort(String str) {
        this.serverPort = str;
    }

    public String getRemoteIP() {
        return this.remoteIP;
    }

    public void setRemoteIP(String str) {
        this.remoteIP = str;
    }

    public String getRemotePort() {
        return this.remotePort;
    }

    public void setRemotePort(String str) {
        this.remotePort = str;
    }

    public String getWorkingMode() {
        return this.workingMode;
    }

    public void setWorkingMode(String str) {
        this.workingMode = str;
    }

    public String getConnectMode() {
        return this.connectMode;
    }

    public void setConnectMode(String str) {
        this.connectMode = str;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public String getDhcp() {
        return this.dhcp;
    }

    public void setDhcp(String str) {
        this.dhcp = str;
    }

    public String getMask() {
        return this.mask;
    }

    public void setMask(String str) {
        this.mask = str;
    }

    public String getGateway() {
        return this.gateway;
    }

    public void setGateway(String str) {
        this.gateway = str;
    }

    public GMulticast() {
        this.mac = "";
        this.ip = "";
        this.serverPort = "";
        this.remoteIP = "";
        this.remotePort = "";
        this.workingMode = "";
        this.connectMode = "";
        this.deviceType = "";
        this.dhcp = "";
        this.mask = "";
        this.gateway = "";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c9, code lost:
    
        if (r6.equals("HOST_SERVER_PORT") == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public GMulticast(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gg.reader.api.entity.GMulticast.<init>(java.lang.String):void");
    }

    public String toString() {
        return "GMulticast{mac='" + this.mac + "', ip='" + this.ip + "', serverPort='" + this.serverPort + "', remoteIP='" + this.remoteIP + "', remotePort='" + this.remotePort + "', workingMode='" + this.workingMode + "', connectMode='" + this.connectMode + "', deviceType='" + this.deviceType + "', dhcp='" + this.dhcp + "', mask='" + this.mask + "', gateway='" + this.gateway + "'}";
    }
}
