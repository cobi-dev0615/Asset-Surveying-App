package com.devexpress.dxcharts;

import com.devexpress.dxcharts.LineSeriesStyle;
import com.devexpress.dxcharts.MarkerStyle;
import com.devexpress.dxcharts.PointSeriesStyle;
import com.devexpress.dxcharts.RangeAreaSeriesStyle;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class RangeAreaSeries extends Series {
    private LegendItemsBehavior legendItemsBehavior = LegendItemsBehavior.SERIES;
    private PointColorizerHolder colorizerHolder1 = new PointColorizerHolder();
    private PointColorizerHolder colorizerHolder2 = new PointColorizerHolder();
    private SegmentColorizerHolder segmentColorizerHolder1 = new SegmentColorizerHolder();
    private SegmentColorizerHolder segmentColorizerHolder2 = new SegmentColorizerHolder();
    private RangeFillColorizerHolder fillColorizerHolder = new RangeFillColorizerHolder();

    @Override // com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    native boolean nativeGetColorEach();

    native boolean nativeGetLine1ShowMarkers();

    native boolean nativeGetLine2ShowMarkers();

    native void nativeSetAlpha(float f);

    native void nativeSetColorEach(boolean z);

    native void nativeSetColorizer1(long j);

    native void nativeSetColorizer2(long j);

    native void nativeSetFillColorizer(long j);

    native void nativeSetLegendItemsBehavior(long j, int i);

    native void nativeSetLine1MarkerColor(int i);

    native void nativeSetLine1MarkerSize(int i);

    native void nativeSetLine1MarkerStrokeColor(int i);

    native void nativeSetLine1MarkerStrokeThickness(float f);

    native void nativeSetLine1ShowMarkers(boolean z);

    native void nativeSetLine1StrokeColor(int i);

    native void nativeSetLine1StrokeThickness(float f);

    native void nativeSetLine2MarkerColor(int i);

    native void nativeSetLine2MarkerSize(int i);

    native void nativeSetLine2MarkerStrokeColor(int i);

    native void nativeSetLine2MarkerStrokeThickness(float f);

    native void nativeSetLine2ShowMarkers(boolean z);

    native void nativeSetLine2StrokeColor(int i);

    native void nativeSetLine2StrokeThickness(float f);

    native void nativeSetSegmentColorizer1(long j);

    native void nativeSetSegmentColorizer2(long j);

    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(RangeAreaSeriesStyle.class);
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    SeriesLabel getDefaultLabel() {
        return new RangeAreaSeriesLabel();
    }

    @Override // com.devexpress.dxcharts.StyledElement
    void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r9) {
        super.applyStyleAttribute(contextProvider, styleContainer, r9);
        RangeAreaSeriesStyle rangeAreaSeriesStyle = (RangeAreaSeriesStyle) styleContainer.getActualStyle(contextProvider, new Object[0]);
        RangeAreaSeriesStyle rangeAreaSeriesStyle2 = (RangeAreaSeriesStyle) styleContainer.getDefaultStyle();
        if (r9 instanceof RangeAreaSeriesStyle.Property) {
            int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$RangeAreaSeriesStyle$Property[((RangeAreaSeriesStyle.Property) r9).ordinal()];
            if (i == 1) {
                nativeSetColor(ColorHelper.convertToNativeColor((rangeAreaSeriesStyle.getFill() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getFill()));
            } else if (i == 2) {
                nativeSetAlpha((rangeAreaSeriesStyle.getAlpha() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getAlpha().floatValue());
            } else if (i == 3) {
                nativeSetLine1StrokeColor(ColorHelper.convertToNativeColor((rangeAreaSeriesStyle.getActualLine1Style(contextProvider).getStroke() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine1Style(contextProvider).getStroke()));
                nativeSetLine1StrokeThickness((rangeAreaSeriesStyle.getActualLine1Style(contextProvider).getStrokeThickness() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine1Style(contextProvider).getStrokeThickness().floatValue());
                nativeSetLine1MarkerSize((rangeAreaSeriesStyle.getActualLine1Style(contextProvider).getMarkerSize() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine1Style(contextProvider).getMarkerSize().intValue());
                nativeSetLine1MarkerColor((rangeAreaSeriesStyle.getActualLine1Style(contextProvider).getActualMarkerStyle(contextProvider).getFill() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine1Style(contextProvider).getActualMarkerStyle(contextProvider).getFill().intValue());
                nativeSetLine1MarkerStrokeColor(ColorHelper.convertToNativeColor((rangeAreaSeriesStyle.getActualLine1Style(contextProvider).getActualMarkerStyle(contextProvider).getStroke() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine1Style(contextProvider).getActualMarkerStyle(contextProvider).getStroke()));
                nativeSetLine1MarkerStrokeThickness((rangeAreaSeriesStyle.getActualLine1Style(contextProvider).getActualMarkerStyle(contextProvider).getStrokeThickness() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine1Style(contextProvider).getActualMarkerStyle(contextProvider).getStrokeThickness().floatValue());
            } else if (i == 4) {
                nativeSetLine2StrokeColor(ColorHelper.convertToNativeColor((rangeAreaSeriesStyle.getActualLine2Style(contextProvider).getStroke() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine2Style(contextProvider).getStroke()));
                nativeSetLine2StrokeThickness((rangeAreaSeriesStyle.getActualLine2Style(contextProvider).getStrokeThickness() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine2Style(contextProvider).getStrokeThickness().floatValue());
                nativeSetLine2MarkerSize((rangeAreaSeriesStyle.getActualLine2Style(contextProvider).getMarkerSize() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine2Style(contextProvider).getMarkerSize().intValue());
                nativeSetLine2MarkerColor((rangeAreaSeriesStyle.getActualLine2Style(contextProvider).getActualMarkerStyle(contextProvider).getFill() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine2Style(contextProvider).getActualMarkerStyle(contextProvider).getFill().intValue());
                nativeSetLine2MarkerStrokeColor(ColorHelper.convertToNativeColor((rangeAreaSeriesStyle.getActualLine2Style(contextProvider).getActualMarkerStyle(contextProvider).getStroke() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine2Style(contextProvider).getActualMarkerStyle(contextProvider).getStroke()));
                nativeSetLine2MarkerStrokeThickness((rangeAreaSeriesStyle.getActualLine2Style(contextProvider).getActualMarkerStyle(contextProvider).getStrokeThickness() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine2Style(contextProvider).getActualMarkerStyle(contextProvider).getStrokeThickness().floatValue());
            }
        }
        if (r9 instanceof LineSeriesStyle.Property) {
            int i2 = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$LineSeriesStyle$Property[((LineSeriesStyle.Property) r9).ordinal()];
            if (i2 == 1) {
                nativeSetLine1StrokeColor(ColorHelper.convertToNativeColor((rangeAreaSeriesStyle.getActualLine1Style(contextProvider).getStroke() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine1Style(contextProvider).getStroke()));
                nativeSetLine2StrokeColor(ColorHelper.convertToNativeColor((rangeAreaSeriesStyle.getActualLine2Style(contextProvider).getStroke() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine2Style(contextProvider).getStroke()));
            } else if (i2 == 2) {
                nativeSetLine1StrokeThickness((rangeAreaSeriesStyle.getActualLine1Style(contextProvider).getStrokeThickness() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine1Style(contextProvider).getStrokeThickness().floatValue());
                nativeSetLine2StrokeThickness((rangeAreaSeriesStyle.getActualLine2Style(contextProvider).getStrokeThickness() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine2Style(contextProvider).getStrokeThickness().floatValue());
            }
        }
        if ((r9 instanceof PointSeriesStyle.Property) && AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$PointSeriesStyle$Property[((PointSeriesStyle.Property) r9).ordinal()] == 1) {
            nativeSetLine1MarkerSize((rangeAreaSeriesStyle.getActualLine1Style(contextProvider).getMarkerSize() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine1Style(contextProvider).getMarkerSize().intValue());
            nativeSetLine2MarkerSize((rangeAreaSeriesStyle.getActualLine2Style(contextProvider).getMarkerSize() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine2Style(contextProvider).getMarkerSize().intValue());
        }
        if (r9 instanceof MarkerStyle.Property) {
            int i3 = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$MarkerStyle$Property[((MarkerStyle.Property) r9).ordinal()];
            if (i3 == 1) {
                nativeSetLine1MarkerColor((rangeAreaSeriesStyle.getActualLine1Style(contextProvider).getActualMarkerStyle(contextProvider).getFill() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine1Style(contextProvider).getActualMarkerStyle(contextProvider).getFill().intValue());
                if (rangeAreaSeriesStyle.getActualLine2Style(contextProvider).getActualMarkerStyle(contextProvider).getFill() == null) {
                    rangeAreaSeriesStyle = rangeAreaSeriesStyle2;
                }
                nativeSetLine2MarkerColor(rangeAreaSeriesStyle.getActualLine2Style(contextProvider).getActualMarkerStyle(contextProvider).getFill().intValue());
                return;
            }
            if (i3 == 2) {
                nativeSetLine1MarkerStrokeColor(ColorHelper.convertToNativeColor((rangeAreaSeriesStyle.getActualLine1Style(contextProvider).getActualMarkerStyle(contextProvider).getStroke() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine1Style(contextProvider).getActualMarkerStyle(contextProvider).getStroke()));
                if (rangeAreaSeriesStyle.getActualLine2Style(contextProvider).getActualMarkerStyle(contextProvider).getStroke() == null) {
                    rangeAreaSeriesStyle = rangeAreaSeriesStyle2;
                }
                nativeSetLine2MarkerStrokeColor(ColorHelper.convertToNativeColor(rangeAreaSeriesStyle.getActualLine2Style(contextProvider).getActualMarkerStyle(contextProvider).getStroke()));
                return;
            }
            if (i3 != 3) {
                return;
            }
            nativeSetLine1MarkerStrokeThickness((rangeAreaSeriesStyle.getActualLine1Style(contextProvider).getActualMarkerStyle(contextProvider).getStrokeThickness() != null ? rangeAreaSeriesStyle : rangeAreaSeriesStyle2).getActualLine1Style(contextProvider).getActualMarkerStyle(contextProvider).getStrokeThickness().floatValue());
            if (rangeAreaSeriesStyle.getActualLine2Style(contextProvider).getActualMarkerStyle(contextProvider).getStrokeThickness() == null) {
                rangeAreaSeriesStyle = rangeAreaSeriesStyle2;
            }
            nativeSetLine2MarkerStrokeThickness(rangeAreaSeriesStyle.getActualLine2Style(contextProvider).getActualMarkerStyle(contextProvider).getStrokeThickness().floatValue());
        }
    }

    /* renamed from: com.devexpress.dxcharts.RangeAreaSeries$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$LineSeriesStyle$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$MarkerStyle$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$PointSeriesStyle$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$RangeAreaSeriesStyle$Property;

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
            int[] iArr2 = new int[PointSeriesStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$PointSeriesStyle$Property = iArr2;
            try {
                iArr2[PointSeriesStyle.Property.SIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[LineSeriesStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$LineSeriesStyle$Property = iArr3;
            try {
                iArr3[LineSeriesStyle.Property.STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$LineSeriesStyle$Property[LineSeriesStyle.Property.STROKE_THICKNESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr4 = new int[RangeAreaSeriesStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$RangeAreaSeriesStyle$Property = iArr4;
            try {
                iArr4[RangeAreaSeriesStyle.Property.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$RangeAreaSeriesStyle$Property[RangeAreaSeriesStyle.Property.ALPHA.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$RangeAreaSeriesStyle$Property[RangeAreaSeriesStyle.Property.LINE1_STYLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$RangeAreaSeriesStyle$Property[RangeAreaSeriesStyle.Property.LINE2_STYLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    @Override // com.devexpress.dxcharts.StyledElement
    List<Enum<?>> getListenPropertiesNames() {
        List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
        Collections.addAll(listenPropertiesNames, RangeAreaSeriesStyle.Property.values());
        Collections.addAll(listenPropertiesNames, LineSeriesStyle.Property.values());
        Collections.addAll(listenPropertiesNames, PointSeriesStyle.Property.values());
        Collections.addAll(listenPropertiesNames, MarkerStyle.Property.values());
        return listenPropertiesNames;
    }

    public void setStyle(RangeAreaSeriesStyle rangeAreaSeriesStyle) {
        trySetStyle(rangeAreaSeriesStyle);
    }

    public RangeAreaSeriesStyle getStyle() {
        return (RangeAreaSeriesStyle) getUserStyleFromContainer(RangeAreaSeriesStyle.class);
    }

    public boolean isColorEach() {
        return nativeGetColorEach();
    }

    public void setColorEach(boolean z) {
        nativeSetColorEach(z);
        nativeSetLegendItemsBehavior(getNativeSeries(), LegendItemsBehavior.EACH_POINT.ordinal());
    }

    public boolean isLine1MarkersVisible() {
        return nativeGetLine1ShowMarkers();
    }

    public void setLine1MarkersVisible(boolean z) {
        nativeSetLine1ShowMarkers(z);
    }

    public boolean isLine2MarkersVisible() {
        return nativeGetLine2ShowMarkers();
    }

    public void setLine2MarkersVisible(boolean z) {
        nativeSetLine2ShowMarkers(z);
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    public RangeAreaSeriesLabel getLabel() {
        return (RangeAreaSeriesLabel) super.getLabel();
    }

    public void setLabel(RangeAreaSeriesLabel rangeAreaSeriesLabel) {
        super.setLabel((SeriesLabel) rangeAreaSeriesLabel);
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

    public PointColorizer getLine1PointColorizer() {
        return this.colorizerHolder1.getColorizer();
    }

    public void setLine1PointColorizer(PointColorizer pointColorizer) {
        this.colorizerHolder1.setColorizer(pointColorizer);
        nativeSetColorizer1(this.colorizerHolder1.getNativeColorizer());
    }

    public PointColorizer getLine2PointColorizer() {
        return this.colorizerHolder2.getColorizer();
    }

    public void setLine2PointColorizer(PointColorizer pointColorizer) {
        this.colorizerHolder2.setColorizer(pointColorizer);
        nativeSetColorizer2(this.colorizerHolder2.getNativeColorizer());
    }

    public void setLine1SegmentColorizer(SegmentColorizer segmentColorizer) {
        this.segmentColorizerHolder1.setColorizer(segmentColorizer);
        nativeSetSegmentColorizer1(this.segmentColorizerHolder1.getNativeColorizer());
    }

    public SegmentColorizer getLine1SegmentColorizer() {
        return this.segmentColorizerHolder1.getColorizer();
    }

    public void setLine2SegmentColorizer(SegmentColorizer segmentColorizer) {
        this.segmentColorizerHolder2.setColorizer(segmentColorizer);
        nativeSetSegmentColorizer2(this.segmentColorizerHolder2.getNativeColorizer());
    }

    public SegmentColorizer getLine2SegmentColorizer() {
        return this.segmentColorizerHolder2.getColorizer();
    }

    public void setFillColorizer(RangeFillColorizer rangeFillColorizer) {
        this.fillColorizerHolder.setColorizer(rangeFillColorizer);
        nativeSetFillColorizer(this.fillColorizerHolder.getNativeColorizer());
    }

    public RangeFillColorizer getFillColorizer() {
        return this.fillColorizerHolder.getColorizer();
    }
}
