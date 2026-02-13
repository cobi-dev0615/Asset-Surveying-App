package com.devexpress.dxcharts;

/* compiled from: SegmentColorizerHolderBase.java */
/* loaded from: classes.dex */
class SegmentColorizerHolder extends SegmentColorizerHolderBase<SegmentColorizer> {
    native long nativeCreateGradientPointBasedSegmentColorizer(long j);

    @Override // com.devexpress.dxcharts.SegmentColorizerHolderBase
    native void nativeSetPointColorizer(long j, long j2);

    SegmentColorizerHolder() {
    }

    @Override // com.devexpress.dxcharts.SegmentColorizerHolderBase
    protected NativeObjectWrapper createNativeColorizer() {
        if (getColorizer() instanceof GradientPointBasedSegmentColorizer) {
            return new NativeObjectWrapper(nativeCreateGradientPointBasedSegmentColorizer(((GradientPointBasedSegmentColorizer) getColorizer()).getNativePointColorizer()));
        }
        return null;
    }
}
