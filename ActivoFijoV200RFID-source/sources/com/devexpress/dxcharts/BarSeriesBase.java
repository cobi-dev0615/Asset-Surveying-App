package com.devexpress.dxcharts;

import com.devexpress.dxcharts.BarSeriesStyle;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BarSeriesBase extends Series {
    private LegendItemsBehavior legendItemsBehavior = LegendItemsBehavior.SERIES;

    native double nativeGetBarWidth();

    native boolean nativeGetColorEach();

    native void nativeSetBarWidth(double d);

    native void nativeSetColorEach(boolean z);

    native void nativeSetLegendItemsBehavior(long j, int i);

    native void nativeSetStrokeColor(int i);

    native void nativeSetStrokeThickness(float f);

    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(BarSeriesStyle.class);
    }

    @Override // com.devexpress.dxcharts.StyledElement
    void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r4) {
        super.applyStyleAttribute(contextProvider, styleContainer, r4);
        BarSeriesStyle barSeriesStyle = (BarSeriesStyle) styleContainer.getActualStyle(contextProvider, new Object[0]);
        BarSeriesStyle barSeriesStyle2 = (BarSeriesStyle) styleContainer.getDefaultStyle();
        if (r4 instanceof BarSeriesStyle.Property) {
            int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$BarSeriesStyle$Property[((BarSeriesStyle.Property) r4).ordinal()];
            if (i == 1) {
                if (barSeriesStyle.getFill() == null) {
                    barSeriesStyle = barSeriesStyle2;
                }
                nativeSetColor(ColorHelper.convertToNativeColor(barSeriesStyle.getFill()));
            } else if (i == 2) {
                if (barSeriesStyle.getStroke() == null) {
                    barSeriesStyle = barSeriesStyle2;
                }
                nativeSetStrokeColor(ColorHelper.convertToNativeColor(barSeriesStyle.getStroke()));
            } else {
                if (i != 3) {
                    return;
                }
                if (barSeriesStyle.getStrokeThickness() == null) {
                    barSeriesStyle = barSeriesStyle2;
                }
                nativeSetStrokeThickness(barSeriesStyle.getStrokeThickness().floatValue());
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.BarSeriesBase$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$BarSeriesStyle$Property;

        static {
            int[] iArr = new int[BarSeriesStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$BarSeriesStyle$Property = iArr;
            try {
                iArr[BarSeriesStyle.Property.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$BarSeriesStyle$Property[BarSeriesStyle.Property.STROKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$BarSeriesStyle$Property[BarSeriesStyle.Property.STROKE_THICKNESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.devexpress.dxcharts.StyledElement
    List<Enum<?>> getListenPropertiesNames() {
        List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
        Collections.addAll(listenPropertiesNames, BarSeriesStyle.Property.values());
        return listenPropertiesNames;
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    SeriesLabel getDefaultLabel() {
        return new BarSeriesLabel();
    }

    public void setStyle(BarSeriesStyle barSeriesStyle) {
        trySetStyle(barSeriesStyle);
    }

    public BarSeriesStyle getStyle() {
        return (BarSeriesStyle) getUserStyleFromContainer(BarSeriesStyle.class);
    }

    public double getBarWidth() {
        return nativeGetBarWidth();
    }

    public void setBarWidth(double d) {
        nativeSetBarWidth(d);
    }

    public LegendItemsBehavior getLegendItemsBehavior() {
        return this.legendItemsBehavior;
    }

    public void setLegendItemsBehavior(LegendItemsBehavior legendItemsBehavior) {
        if (this.legendItemsBehavior != legendItemsBehavior) {
            this.legendItemsBehavior = legendItemsBehavior;
            nativeSetLegendItemsBehavior(getNativeSeries(), this.legendItemsBehavior.ordinal());
        }
    }

    public boolean isColorEach() {
        return nativeGetColorEach();
    }

    public void setColorEach(boolean z) {
        nativeSetColorEach(z);
        nativeSetLegendItemsBehavior(getNativeSeries(), LegendItemsBehavior.EACH_POINT.ordinal());
    }
}
