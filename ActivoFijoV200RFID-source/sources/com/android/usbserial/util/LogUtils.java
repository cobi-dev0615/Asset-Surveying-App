package com.android.usbserial.util;

import android.util.Log;

/* loaded from: classes.dex */
public class LogUtils {
    static String className;
    static int lineNumber;
    static String methodName;

    public static boolean isDebuggable() {
        return BuildConfig.DEBUG;
    }

    private static String createLog(String str) {
        StringBuffer stringBuffer = new StringBuffer("================");
        stringBuffer.append(methodName);
        stringBuffer.append("(").append(className).append(":").append(lineNumber).append(")================:");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    private static void getMethodNames(StackTraceElement[] stackTraceElementArr) {
        className = stackTraceElementArr[1].getFileName();
        methodName = stackTraceElementArr[1].getMethodName();
        lineNumber = stackTraceElementArr[1].getLineNumber();
    }

    public static void e(String str) {
        if (isDebuggable()) {
            getMethodNames(new Throwable().getStackTrace());
            Log.e(className, createLog(str));
        }
    }

    public static void i(String str) {
        if (isDebuggable()) {
            getMethodNames(new Throwable().getStackTrace());
            Log.i(className, createLog(str));
        }
    }

    public static void d(String str) {
        if (isDebuggable()) {
            getMethodNames(new Throwable().getStackTrace());
            Log.d(className, createLog(str));
        }
    }

    public static void v(String str) {
        if (isDebuggable()) {
            getMethodNames(new Throwable().getStackTrace());
            Log.v(className, createLog(str));
        }
    }

    public static void w(String str) {
        if (isDebuggable()) {
            getMethodNames(new Throwable().getStackTrace());
            Log.w(className, createLog(str));
        }
    }
}
