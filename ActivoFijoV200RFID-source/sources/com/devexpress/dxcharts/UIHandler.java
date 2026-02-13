package com.devexpress.dxcharts;

import android.content.Context;
import android.os.Handler;

/* loaded from: classes.dex */
class UIHandler {
    private static UIHandler HANDLER;
    Handler handler;

    private UIHandler(Context context) {
        this.handler = new Handler(context.getMainLooper());
    }

    private void reThrowInternal(final Error error) {
        this.handler.post(new Runnable() { // from class: com.devexpress.dxcharts.UIHandler.1
            @Override // java.lang.Runnable
            public void run() {
                throw error;
            }
        });
    }

    public static synchronized void init(Context context) {
        synchronized (UIHandler.class) {
            if (HANDLER == null && context != null) {
                HANDLER = new UIHandler(context);
            }
        }
    }

    public static void reThrow(Error error) {
        UIHandler uIHandler = HANDLER;
        if (uIHandler != null) {
            uIHandler.reThrowInternal(error);
        }
    }
}
