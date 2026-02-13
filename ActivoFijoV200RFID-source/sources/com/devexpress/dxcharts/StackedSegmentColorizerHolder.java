package com.devexpress.dxcharts;

/* compiled from: SegmentColorizerHolderBase.java */
/* loaded from: classes.dex */
class StackedSegmentColorizerHolder extends SegmentColorizerHolderBase<StackedSegmentColorizer> {
    native long nativeCreateGradientPointBasedStackedSegmentColorizer(long j);

    @Override // com.devexpress.dxcharts.SegmentColorizerHolderBase
    native void nativeSetPointColorizer(long j, long j2);

    StackedSegmentColorizerHolder() {
    }

    @Override // com.devexpress.dxcharts.SegmentColorizerHolderBase
    protected NativeObjectWrapper createNativeColorizer() {
        if (getColorizer() instanceof GradientPointBasedStackedSegmentColorizer) {
            return new NativeObjectWrapper(nativeCreateGradientPointBasedStackedSegmentColorizer(((GradientPointBasedStackedSegmentColorizer) getColorizer()).getNativeColorizer()));
        }
        return null;
    }
}
