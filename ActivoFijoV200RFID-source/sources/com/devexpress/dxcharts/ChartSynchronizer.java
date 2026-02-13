package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class ChartSynchronizer {
    private NativeObjectWrapper mAxisSynchronizerNative = null;

    native long nativeCreateAxisSynchronizer();

    long getNativeAxisSynchronizer() {
        if (this.mAxisSynchronizerNative == null) {
            this.mAxisSynchronizerNative = new NativeObjectWrapper(nativeCreateAxisSynchronizer());
        }
        return this.mAxisSynchronizerNative.getObject();
    }
}
