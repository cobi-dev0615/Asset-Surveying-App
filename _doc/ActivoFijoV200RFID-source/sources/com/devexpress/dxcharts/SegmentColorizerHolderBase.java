package com.devexpress.dxcharts;

import com.devexpress.dxcharts.GradientPointBasedSegmentColorizer;
import com.devexpress.dxcharts.GradientPointBasedStackedSegmentColorizer;

/* loaded from: classes.dex */
abstract class SegmentColorizerHolderBase<C> extends ChartElement {
    private C colorizer;
    protected NativeObjectWrapper nativeColorizer = null;

    protected abstract NativeObjectWrapper createNativeColorizer();

    abstract void nativeSetPointColorizer(long j, long j2);

    SegmentColorizerHolderBase() {
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

    @Override // com.devexpress.dxcharts.ChartElement
    void onChartElementPropertyChanged(Object obj, PropertyChangedArgs propertyChangedArgs) {
        if ((obj instanceof GradientPointBasedSegmentColorizer) && AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$GradientPointBasedSegmentColorizer$Property[((GradientPointBasedSegmentColorizer.Property) propertyChangedArgs.getProperty()).ordinal()] == 1) {
            nativeSetPointColorizer(getNativeColorizer(), ((GradientPointBasedSegmentColorizer) obj).getNativePointColorizer());
        }
        if ((obj instanceof GradientPointBasedStackedSegmentColorizer) && AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$GradientPointBasedStackedSegmentColorizer$Property[((GradientPointBasedStackedSegmentColorizer.Property) propertyChangedArgs.getProperty()).ordinal()] == 1) {
            nativeSetPointColorizer(getNativeColorizer(), ((GradientPointBasedStackedSegmentColorizer) obj).getNativeColorizer());
        }
    }

    /* renamed from: com.devexpress.dxcharts.SegmentColorizerHolderBase$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$GradientPointBasedSegmentColorizer$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$GradientPointBasedStackedSegmentColorizer$Property;

        static {
            int[] iArr = new int[GradientPointBasedStackedSegmentColorizer.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$GradientPointBasedStackedSegmentColorizer$Property = iArr;
            try {
                iArr[GradientPointBasedStackedSegmentColorizer.Property.POINT_COLORIZER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[GradientPointBasedSegmentColorizer.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$GradientPointBasedSegmentColorizer$Property = iArr2;
            try {
                iArr2[GradientPointBasedSegmentColorizer.Property.POINT_COLORIZER.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
