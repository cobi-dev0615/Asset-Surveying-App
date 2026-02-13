package com.devexpress.dxcharts;

/* loaded from: classes.dex */
abstract class FillColorizerHolderBase<C> extends ChartElement {
    private C colorizer;
    protected NativeObjectWrapper nativeColorizer = null;

    protected abstract NativeObjectWrapper createNativeColorizer();

    FillColorizerHolderBase() {
    }

    long getNativeColorizer() {
        if (this.nativeColorizer == null) {
            this.nativeColorizer = createNativeColorizer();
        }
        return this.nativeColorizer.getObject();
    }

    public C getColorizer() {
        return this.colorizer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setColorizer(C c) {
        C c2 = this.colorizer;
        if (c2 != c) {
            if (c2 != null) {
                this.nativeColorizer = null;
                if (c instanceof ChartElement) {
                    ((ChartElement) c2).removeListener(getSelfListener());
                }
            }
            this.colorizer = c;
            if (c == 0 || !(c instanceof ChartElement)) {
                return;
            }
            ((ChartElement) c).addListener(getSelfListener());
        }
    }
}
