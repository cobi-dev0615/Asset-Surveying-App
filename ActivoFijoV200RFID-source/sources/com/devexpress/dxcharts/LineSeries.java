package com.devexpress.dxcharts;

import com.devexpress.dxcharts.LineSeriesStyle;
import com.devexpress.dxcharts.MarkerStyle;
import com.devexpress.dxcharts.PointSeriesStyle;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class LineSeries extends Series {
    private LegendItemsBehavior legendItemsBehavior = LegendItemsBehavior.SERIES;
    private PointColorizerHolder colorizerHolder = new PointColorizerHolder();
    private SegmentColorizerHolder segmentColorizerHolder = new SegmentColorizerHolder();

    @Override // com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    native boolean nativeGetColorEach();

    native boolean nativeGetShowMarkers();

    native void nativeSetColorEach(boolean z);

    native void nativeSetColorizer(long j);

    native void nativeSetLegendItemsBehavior(long j, int i);

    native void nativeSetMarkerColor(int i);

    native void nativeSetMarkerSize(int i);

    native void nativeSetMarkerStrokeColor(int i);

    native void nativeSetMarkerStrokeThickness(float f);

    native void nativeSetSegmentColorizer(long j);

    native void nativeSetShowMarkers(boolean z);

    native void nativeSetStrokeThickness(float f);

    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(LineSeriesStyle.class);
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    SeriesLabel getDefaultLabel() {
        return new MarkerSeriesLabel();
    }

    @Override // com.devexpress.dxcharts.StyledElement
    void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r8) {
        super.applyStyleAttribute(contextProvider, styleContainer, r8);
        LineSeriesStyle lineSeriesStyle = (LineSeriesStyle) styleContainer.getActualStyle(contextProvider, new Object[0]);
        LineSeriesStyle lineSeriesStyle2 = (LineSeriesStyle) styleContainer.getDefaultStyle();
        if ((r8 instanceof PointSeriesStyle.Property) && AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$PointSeriesStyle$Property[((PointSeriesStyle.Property) r8).ordinal()] == 1) {
            nativeSetMarkerSize((lineSeriesStyle.getMarkerSize() != null ? lineSeriesStyle : lineSeriesStyle2).getMarkerSize().intValue());
        }
        if (r8 instanceof LineSeriesStyle.Property) {
            int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$LineSeriesStyle$Property[((LineSeriesStyle.Property) r8).ordinal()];
            if (i == 1) {
                nativeSetColor(ColorHelper.convertToNativeColor((lineSeriesStyle.getStroke() != null ? lineSeriesStyle : lineSeriesStyle2).getStroke()));
            } else if (i == 2) {
                nativeSetStrokeThickness((lineSeriesStyle.getStrokeThickness() != null ? lineSeriesStyle : lineSeriesStyle2).getStrokeThickness().floatValue());
            }
        }
        if (r8 instanceof MarkerStyle.Property) {
            int i2 = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$MarkerStyle$Property[((MarkerStyle.Property) r8).ordinal()];
            if (i2 == 1) {
                if (lineSeriesStyle.getActualMarkerStyle(contextProvider).getFill() == null) {
                    lineSeriesStyle = lineSeriesStyle2;
                }
                nativeSetMarkerColor(lineSeriesStyle.getActualMarkerStyle(contextProvider).getFill().intValue());
            } else if (i2 == 2) {
                if (lineSeriesStyle.getActualMarkerStyle(contextProvider).getStroke() == null) {
                    lineSeriesStyle = lineSeriesStyle2;
                }
                nativeSetMarkerStrokeColor(ColorHelper.convertToNativeColor(lineSeriesStyle.getActualMarkerStyle(contextProvider).getStroke()));
            } else {
                if (i2 != 3) {
                    return;
                }
                if (lineSeriesStyle.getActualMarkerStyle(contextProvider).getStrokeThickness() == null) {
                    lineSeriesStyle = lineSeriesStyle2;
                }
                nativeSetMarkerStrokeThickness(lineSeriesStyle.getActualMarkerStyle(contextProvider).getStrokeThickness().floatValue());
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.LineSeries$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$LineSeriesStyle$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$MarkerStyle$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$PointSeriesStyle$Property;

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
            int[] iArr2 = new int[LineSeriesStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$LineSeriesStyle$Property = iArr2;
            try {
                iArr2[LineSeriesStyle.Property.STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$LineSeriesStyle$Property[LineSeriesStyle.Property.STROKE_THICKNESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[PointSeriesStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$PointSeriesStyle$Property = iArr3;
            try {
                iArr3[PointSeriesStyle.Property.SIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // com.devexpress.dxcharts.StyledElement
    List<Enum<?>> getListenPropertiesNames() {
        List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
        Collections.addAll(listenPropertiesNames, LineSeriesStyle.Property.values());
        Collections.addAll(listenPropertiesNames, PointSeriesStyle.Property.values());
        Collections.addAll(listenPropertiesNames, MarkerStyle.Property.values());
        return listenPropertiesNames;
    }

    public void setStyle(LineSeriesStyle lineSeriesStyle) {
        trySetStyle(lineSeriesStyle);
    }

    public LineSeriesStyle getStyle() {
        return (LineSeriesStyle) getUserStyleFromContainer(LineSeriesStyle.class);
    }

    public boolean isMarkersVisible() {
        return nativeGetShowMarkers();
    }

    public void setMarkersVisible(boolean z) {
        nativeSetShowMarkers(z);
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    public MarkerSeriesLabel getLabel() {
        return (MarkerSeriesLabel) super.getLabel();
    }

    public void setLabel(MarkerSeriesLabel markerSeriesLabel) {
        super.setLabel((SeriesLabel) markerSeriesLabel);
    }

    public PointColorizer getPointColorizer() {
        return this.colorizerHolder.getColorizer();
    }

    public void setPointColorizer(PointColorizer pointColorizer) {
        this.colorizerHolder.setColorizer(pointColorizer);
        nativeSetColorizer(this.colorizerHolder.getNativeColorizer());
    }

    public void setSegmentColorizer(SegmentColorizer segmentColorizer) {
        this.segmentColorizerHolder.setColorizer(segmentColorizer);
        nativeSetSegmentColorizer(this.segmentColorizerHolder.getNativeColorizer());
    }

    public SegmentColorizer getSegmentColorizer() {
        return this.segmentColorizerHolder.getColorizer();
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
