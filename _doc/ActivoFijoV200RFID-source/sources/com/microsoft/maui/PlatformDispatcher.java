package com.microsoft.maui;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes3.dex */
public class PlatformDispatcher extends Handler {
    private PlatformDispatcher(Looper looper) {
        super(looper);
    }

    public static PlatformDispatcher create() {
        Looper myLooper = Looper.myLooper();
        if (myLooper == null || myLooper != Looper.getMainLooper()) {
            return null;
        }
        return new PlatformDispatcher(myLooper);
    }

    public boolean isDispatchRequired() {
        return Looper.myLooper() != getLooper();
    }
}
