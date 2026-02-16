package com.devexpress.dxcharts;

import com.devexpress.dxcharts.SegmentBasedRangeFillColorizer;

/* compiled from: FillColorizerHolderBase.java */
/* loaded from: classes.dex */
class RangeFillColorizerHolder extends FillColorizerHolderBase<RangeFillColorizer> {
    native long nativeCreateSegmentBasedRangeFillColorizer(long j, long j2);

    native void nativeSetSegmentColorizer1(long j, long j2);

    native void nativeSetSegmentColorizer2(long j, long j2);

    RangeFillColorizerHolder() {
    }

    @Override // com.devexpress.dxcharts.FillColorizerHolderBase
    protected NativeObjectWrapper createNativeColorizer() {
        if (!(getColorizer() instanceof SegmentBasedRangeFillColorizer)) {
            return null;
        }
        SegmentBasedRangeFillColorizer segmentBasedRangeFillColorizer = (SegmentBasedRangeFillColorizer) getColorizer();
        return new NativeObjectWrapper(nativeCreateSegmentBasedRangeFillColorizer(segmentBasedRangeFillColorizer.getNativeSegmentColorizer1(), segmentBasedRangeFillColorizer.getNativeSegmentColorizer2()));
    }

    /* compiled from: FillColorizerHolderBase.java */
    /* renamed from: com.devexpress.dxcharts.RangeFillColorizerHolder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$SegmentBasedRangeFillColorizer$Property;

        static {
            int[] iArr = new int[SegmentBasedRangeFillColorizer.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$SegmentBasedRangeFillColorizer$Property = iArr;
            try {
                iArr[SegmentBasedRangeFillColorizer.Property.SEGMENT_COLORIZER1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$SegmentBasedRangeFillColorizer$Property[SegmentBasedRangeFillColorizer.Property.SEGMENT_COLORIZER2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.devexpress.dxcharts.ChartElement
    void onChartElementPropertyChanged(Object obj, PropertyChangedArgs propertyChangedArgs) {
        if (obj instanceof SegmentBasedRangeFillColorizer) {
            int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$SegmentBasedRangeFillColorizer$Property[((SegmentBasedRangeFillColorizer.Property) propertyChangedArgs.getProperty()).ordinal()];
            if (i == 1) {
                nativeSetSegmentColorizer1(getNativeColorizer(), ((SegmentBasedRangeFillColorizer) obj).getNativeSegmentColorizer1());
                return;
            } else {
                if (i != 2) {
                    return;
                }
                nativeSetSegmentColorizer2(getNativeColorizer(), ((SegmentBasedRangeFillColorizer) obj).getNativeSegmentColorizer2());
                return;
            }
        }
        super.onChartElementPropertyChanged(obj, propertyChangedArgs);
    }
}
