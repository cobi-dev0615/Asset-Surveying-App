package com.devexpress.dxcharts;

/* compiled from: ChartTextStyleProvider.java */
/* loaded from: classes.dex */
abstract class TextStyleProvider implements TextStyleProviderInterface {
    private NativeObjectWrapper mProviderNative = new NativeObjectWrapper(nativeCreateTextStyleProvider());

    abstract long nativeCreateTextStyleProvider();

    TextStyleProvider() {
    }

    @Override // com.devexpress.dxcharts.TextStyleProviderInterface
    public long getNativeProvider() {
        return this.mProviderNative.getObject();
    }
}
