package com.devexpress.dxcharts;

import com.devexpress.dxcharts.SegmentBasedFillColorizer;

/* compiled from: FillColorizerHolderBase.java */
/* loaded from: classes.dex */
class FillColorizerHolder extends FillColorizerHolderBase<FillColorizer> {
    native long nativeCreateSegmentBasedFillColorizer(long j);

    native void nativeSetSegmentColorizer(long j, long j2);

    FillColorizerHolder() {
    }

    @Override // com.devexpress.dxcharts.FillColorizerHolderBase
    protected NativeObjectWrapper createNativeColorizer() {
        if (getColorizer() instanceof SegmentBasedFillColorizer) {
            return new NativeObjectWrapper(nativeCreateSegmentBasedFillColorizer(((SegmentBasedFillColorizer) getColorizer()).getNativeSegmentColorizer()));
        }
        return null;
    }

    /* compiled from: FillColorizerHolderBase.java */
    /* renamed from: com.devexpress.dxcharts.FillColorizerHolder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$SegmentBasedFillColorizer$Property;

        static {
            int[] iArr = new int[SegmentBasedFillColorizer.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$SegmentBasedFillColorizer$Property = iArr;
            try {
                iArr[SegmentBasedFillColorizer.Property.SEGMENT_COLORIZER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @Override // com.devexpress.dxcharts.ChartElement
    void onChartElementPropertyChanged(Object obj, PropertyChangedArgs propertyChangedArgs) {
        if ((obj instanceof SegmentBasedFillColorizer) && AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$SegmentBasedFillColorizer$Property[((SegmentBasedFillColorizer.Property) propertyChangedArgs.getProperty()).ordinal()] == 1) {
            nativeSetSegmentColorizer(getNativeColorizer(), ((SegmentBasedFillColorizer) obj).getNativeSegmentColorizer());
        }
    }
}
