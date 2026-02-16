package com.microsoft.maui;

import android.util.Log;

/* loaded from: classes3.dex */
public class PlatformLogger {
    public final boolean isVerboseLoggable;
    private final String tag;

    public PlatformLogger(String str) {
        this.tag = str;
        this.isVerboseLoggable = Log.isLoggable(str, 2);
    }

    public void v(String str) {
        Log.v(this.tag, str);
    }
}
