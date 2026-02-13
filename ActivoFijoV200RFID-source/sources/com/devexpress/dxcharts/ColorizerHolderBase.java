package com.devexpress.dxcharts;

import com.devexpress.dxcharts.BandPointColorizerBase;
import com.devexpress.dxcharts.ColorEachPointColorizer;
import com.devexpress.dxcharts.CustomValueBandPointColorizer;

/* loaded from: classes.dex */
abstract class ColorizerHolderBase<C> extends ChartElement {
    private C colorizer;
    protected NativeObjectWrapper nativeColorizer = null;

    protected abstract NativeObjectWrapper createNativeColorizer();

    abstract void nativeSetColorDataAdapter(long j, CustomColorizerNumericValueProvider customColorizerNumericValueProvider);

    abstract void nativeSetColorStopValues(long j, int[] iArr, double[] dArr, double[] dArr2);

    abstract void nativeSetPalette(long j, int[] iArr);

    ColorizerHolderBase() {
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
        if (obj instanceof BandPointColorizerBase) {
            if (propertyChangedArgs.getProperty() instanceof CustomValueBandPointColorizer.Property) {
                if (AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$CustomValueBandPointColorizer$Property[((CustomValueBandPointColorizer.Property) propertyChangedArgs.getProperty()).ordinal()] == 1) {
                    nativeSetColorDataAdapter(getNativeColorizer(), ((CustomValueBandPointColorizer) obj).getValueProvider());
                }
            } else if (AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$BandPointColorizerBase$Property[((BandPointColorizerBase.Property) propertyChangedArgs.getProperty()).ordinal()] == 1) {
                BandPointColorizerBase.BandPointColorizerBasePrimitives createBandColorizerBasePrimitives = ((BandPointColorizerBase) obj).createBandColorizerBasePrimitives();
                nativeSetColorStopValues(getNativeColorizer(), createBandColorizerBasePrimitives.getColors(), createBandColorizerBasePrimitives.getValues1(), createBandColorizerBasePrimitives.getValues2());
            }
        }
        if ((obj instanceof ColorEachPointColorizer) && AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$ColorEachPointColorizer$Property[((ColorEachPointColorizer.Property) propertyChangedArgs.getProperty()).ordinal()] == 1) {
            nativeSetPalette(getNativeColorizer(), ((ColorEachPointColorizer) obj).getPalette());
        }
    }

    /* renamed from: com.devexpress.dxcharts.ColorizerHolderBase$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$BandPointColorizerBase$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$ColorEachPointColorizer$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$CustomValueBandPointColorizer$Property;

        static {
            int[] iArr = new int[ColorEachPointColorizer.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$ColorEachPointColorizer$Property = iArr;
            try {
                iArr[ColorEachPointColorizer.Property.PALETTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[BandPointColorizerBase.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$BandPointColorizerBase$Property = iArr2;
            try {
                iArr2[BandPointColorizerBase.Property.COLOR_STOP_VALUES.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr3 = new int[CustomValueBandPointColorizer.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$CustomValueBandPointColorizer$Property = iArr3;
            try {
                iArr3[CustomValueBandPointColorizer.Property.VALUE_PROVIDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
