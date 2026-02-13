package com.gg.reader.api.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public class ShellExecute {
    private static ShellExecute instance;
    Process exeEcho = null;
    DataOutputStream os = null;
    DataInputStream dis = null;

    public static ShellExecute getInstance() {
        if (instance == null) {
            instance = new ShellExecute();
        }
        return instance;
    }

    private void initCmdExe() {
        if (this.exeEcho != null) {
            return;
        }
        try {
            this.exeEcho = Runtime.getRuntime().exec("sh");
            this.os = new DataOutputStream(this.exeEcho.getOutputStream());
            this.dis = new DataInputStream(this.exeEcho.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void disposeCmdExe() {
        if (this.exeEcho == null) {
            return;
        }
        try {
            DataInputStream dataInputStream = this.dis;
            if (dataInputStream != null) {
                dataInputStream.close();
                this.dis = null;
            }
            DataOutputStream dataOutputStream = this.os;
            if (dataOutputStream != null) {
                dataOutputStream.close();
                this.os = null;
            }
            Process process = this.exeEcho;
            if (process != null) {
                process.waitFor();
                this.exeEcho = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int exeCmd(String str) {
        DataOutputStream dataOutputStream;
        initCmdExe();
        int i = -1;
        try {
            if (this.exeEcho != null && (dataOutputStream = this.os) != null) {
                dataOutputStream.writeBytes(str + "\n");
                this.os.flush();
                this.os.writeBytes("exit\n");
                this.os.flush();
                this.exeEcho.waitFor();
                i = this.exeEcho.exitValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disposeCmdExe();
        return i;
    }

    public String exeCmdRt(String str) {
        DataOutputStream dataOutputStream;
        String str2 = "";
        initCmdExe();
        try {
            if (this.exeEcho != null && (dataOutputStream = this.os) != null) {
                dataOutputStream.writeBytes(str + "\n");
                this.os.flush();
                this.os.writeBytes("exit\n");
                this.os.flush();
                while (true) {
                    String readUTF = this.dis.readUTF();
                    if (readUTF == null) {
                        break;
                    }
                    str2 = str2 + readUTF;
                }
                this.exeEcho.waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disposeCmdExe();
        return str2;
    }
}
