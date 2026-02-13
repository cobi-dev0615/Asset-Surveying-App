package com.devexpress.dxcharts;

import com.devexpress.dxcharts.SegmentBasedStackedFillColorizer;

/* compiled from: FillColorizerHolderBase.java */
/* loaded from: classes.dex */
class StackedFillColorizerHolder extends FillColorizerHolderBase<StackedFillColorizer> {
    native long nativeCreateSegmentBasedStackedFillColorizer(long j);

    native void nativeSetSegmentColorizer(long j, long j2);

    StackedFillColorizerHolder() {
    }

    @Override // com.devexpress.dxcharts.FillColorizerHolderBase
    protected NativeObjectWrapper createNativeColorizer() {
        if (getColorizer() instanceof SegmentBasedStackedFillColorizer) {
            return new NativeObjectWrapper(nativeCreateSegmentBasedStackedFillColorizer(((SegmentBasedStackedFillColorizer) getColorizer()).getNativeSegmentColorizer()));
        }
        return null;
    }

    /* compiled from: FillColorizerHolderBase.java */
    /* renamed from: com.devexpress.dxcharts.StackedFillColorizerHolder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$SegmentBasedStackedFillColorizer$Property;

        static {
            int[] iArr = new int[SegmentBasedStackedFillColorizer.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$SegmentBasedStackedFillColorizer$Property = iArr;
            try {
                iArr[SegmentBasedStackedFillColorizer.Property.SEGMENT_COLORIZER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @Override // com.devexpress.dxcharts.ChartElement
    void onChartElementPropertyChanged(Object obj, PropertyChangedArgs propertyChangedArgs) {
        if (obj instanceof SegmentBasedStackedFillColorizer) {
            if (AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$SegmentBasedStackedFillColorizer$Property[((SegmentBasedStackedFillColorizer.Property) propertyChangedArgs.getProperty()).ordinal()] != 1) {
                return;
            }
            nativeSetSegmentColorizer(getNativeColorizer(), ((SegmentBasedStackedFillColorizer) obj).getNativeSegmentColorizer());
            return;
        }
        super.onChartElementPropertyChanged(obj, propertyChangedArgs);
    }
}
