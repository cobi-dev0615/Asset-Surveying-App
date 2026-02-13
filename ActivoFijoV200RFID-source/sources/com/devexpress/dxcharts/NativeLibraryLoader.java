package com.devexpress.dxcharts;

import android.content.res.Resources;

/* compiled from: ChartBase.java */
/* loaded from: classes.dex */
class NativeLibraryLoader {
    NativeLibraryLoader() {
    }

    static {
        System.loadLibrary("DXChartsNative");
        ChartBase.nativeCreateScreenMapping(Resources.getSystem().getDisplayMetrics().density);
    }
}
