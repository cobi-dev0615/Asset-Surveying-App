package com.devexpress.dxcharts;

import com.devexpress.dxcharts.MarkerStyle;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class BubbleSeries extends Series {
    private Double minValue = null;
    private Double maxValue = null;
    private LegendItemsBehavior legendItemsBehavior = LegendItemsBehavior.SERIES;
    private WeightedPointColorizerHolder colorizerHolder = new WeightedPointColorizerHolder();

    @Override // com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    native boolean nativeGetColorEach();

    native double nativeGetMaxSize();

    native double nativeGetMinSize();

    native void nativeSetColorEach(boolean z);

    native void nativeSetColorizer(long j);

    native void nativeSetLegendItemsBehavior(long j, int i);

    native void nativeSetMinMaxSizes(double[] dArr);

    native void nativeSetStrokeColor(int i);

    native void nativeSetStrokeThickness(float f);

    private void applyMinMaxValues() {
        Double d = this.minValue;
        nativeSetMinMaxSizes((d == null || this.maxValue == null) ? null : new double[]{d.doubleValue(), this.maxValue.doubleValue()});
    }

    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(BubbleSeriesStyle.class);
    }

    @Override // com.devexpress.dxcharts.StyledElement
    void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r5) {
        super.applyStyleAttribute(contextProvider, styleContainer, r5);
        BubbleSeriesStyle bubbleSeriesStyle = (BubbleSeriesStyle) styleContainer.getActualStyle(contextProvider, new Object[0]);
        BubbleSeriesStyle bubbleSeriesStyle2 = (BubbleSeriesStyle) styleContainer.getDefaultStyle();
        if (r5 instanceof MarkerStyle.Property) {
            int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$MarkerStyle$Property[((MarkerStyle.Property) r5).ordinal()];
            if (i == 1) {
                if (bubbleSeriesStyle.getActualMarkerStyle(contextProvider).getFill() == null) {
                    bubbleSeriesStyle = bubbleSeriesStyle2;
                }
                nativeSetColor(ColorHelper.convertToNativeColor(bubbleSeriesStyle.getActualMarkerStyle(contextProvider).getFill()));
            } else if (i == 2) {
                if (bubbleSeriesStyle.getActualMarkerStyle(contextProvider).getStroke() == null) {
                    bubbleSeriesStyle = bubbleSeriesStyle2;
                }
                nativeSetStrokeColor(ColorHelper.convertToNativeColor(bubbleSeriesStyle.getActualMarkerStyle(contextProvider).getStroke()));
            } else {
                if (i != 3) {
                    return;
                }
                if (bubbleSeriesStyle.getActualMarkerStyle(contextProvider).getStrokeThickness() == null) {
                    bubbleSeriesStyle = bubbleSeriesStyle2;
                }
                nativeSetStrokeThickness(bubbleSeriesStyle.getActualMarkerStyle(contextProvider).getStrokeThickness().floatValue());
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.BubbleSeries$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$MarkerStyle$Property;

        static {
            int[] iArr = new int[MarkerStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$MarkerStyle$Property = iArr;
            try {
                iArr[MarkerStyle.Property.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$MarkerStyle$Property[MarkerStyle.Property.STROKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$MarkerStyle$Property[MarkerStyle.Property.STROKE_THICKNESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.devexpress.dxcharts.StyledElement
    List<Enum<?>> getListenPropertiesNames() {
        List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
        Collections.addAll(listenPropertiesNames, MarkerStyle.Property.values());
        return listenPropertiesNames;
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    SeriesLabel getDefaultLabel() {
        return new BubbleSeriesLabel();
    }

    public double getMinSize() {
        return nativeGetMinSize();
    }

    public void setMinSize(double d) {
        this.minValue = Double.valueOf(d);
        applyMinMaxValues();
    }

    public double getMaxSize() {
        return nativeGetMaxSize();
    }

    public void setMaxSize(double d) {
        this.maxValue = Double.valueOf(d);
        applyMinMaxValues();
    }

    public void resetMinMaxSizes() {
        this.minValue = null;
        this.maxValue = null;
        applyMinMaxValues();
    }

    public void setStyle(BubbleSeriesStyle bubbleSeriesStyle) {
        trySetStyle(bubbleSeriesStyle);
    }

    public BubbleSeriesStyle getStyle() {
        return (BubbleSeriesStyle) getUserStyleFromContainer(BubbleSeriesStyle.class);
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    public BubbleSeriesLabel getLabel() {
        return (BubbleSeriesLabel) super.getLabel();
    }

    public void setLabel(BubbleSeriesLabel bubbleSeriesLabel) {
        super.setLabel((SeriesLabel) bubbleSeriesLabel);
    }

    public WeightedPointColorizer getPointColorizer() {
        return this.colorizerHolder.getColorizer();
    }

    public void setPointColorizer(WeightedPointColorizer weightedPointColorizer) {
        this.colorizerHolder.setColorizer(weightedPointColorizer);
        nativeSetColorizer(this.colorizerHolder.getNativeColorizer());
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

    @Deprecated
    public boolean isColorEach() {
        return nativeGetColorEach();
    }

    @Deprecated
    public void setColorEach(boolean z) {
        nativeSetColorEach(z);
        nativeSetLegendItemsBehavior(getNativeSeries(), LegendItemsBehavior.EACH_POINT.ordinal());
    }
}
