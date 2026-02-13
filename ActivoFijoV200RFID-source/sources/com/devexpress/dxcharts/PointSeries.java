package com.devexpress.dxcharts;

import com.devexpress.dxcharts.MarkerStyle;
import com.devexpress.dxcharts.PointSeriesStyle;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class PointSeries extends Series {
    private LegendItemsBehavior legendItemsBehavior = LegendItemsBehavior.SERIES;
    private PointColorizerHolder colorizerHolder = new PointColorizerHolder();

    @Override // com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    native boolean nativeGetColorEach();

    native void nativeSetColorEach(boolean z);

    native void nativeSetColorizer(long j);

    native void nativeSetLegendItemsBehavior(long j, int i);

    native void nativeSetMarkerSize(int i);

    native void nativeSetStrokeColor(int i);

    native void nativeSetStrokeThickness(float f);

    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(PointSeriesStyle.class);
    }

    @Override // com.devexpress.dxcharts.StyledElement
    void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r7) {
        super.applyStyleAttribute(contextProvider, styleContainer, r7);
        PointSeriesStyle pointSeriesStyle = (PointSeriesStyle) styleContainer.getActualStyle(contextProvider, new Object[0]);
        PointSeriesStyle pointSeriesStyle2 = (PointSeriesStyle) styleContainer.getDefaultStyle();
        if ((r7 instanceof PointSeriesStyle.Property) && AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$PointSeriesStyle$Property[((PointSeriesStyle.Property) r7).ordinal()] == 1) {
            nativeSetMarkerSize((pointSeriesStyle.getMarkerSize() != null ? pointSeriesStyle : pointSeriesStyle2).getMarkerSize().intValue());
        }
        if (r7 instanceof MarkerStyle.Property) {
            int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$MarkerStyle$Property[((MarkerStyle.Property) r7).ordinal()];
            if (i == 1) {
                if (pointSeriesStyle.getActualMarkerStyle(contextProvider).getFill() == null) {
                    pointSeriesStyle = pointSeriesStyle2;
                }
                nativeSetColor(ColorHelper.convertToNativeColor(pointSeriesStyle.getActualMarkerStyle(contextProvider).getFill()));
            } else if (i == 2) {
                if (pointSeriesStyle.getActualMarkerStyle(contextProvider).getStroke() == null) {
                    pointSeriesStyle = pointSeriesStyle2;
                }
                nativeSetStrokeColor(ColorHelper.convertToNativeColor(pointSeriesStyle.getActualMarkerStyle(contextProvider).getStroke()));
            } else {
                if (i != 3) {
                    return;
                }
                if (pointSeriesStyle.getActualMarkerStyle(contextProvider).getStrokeThickness() == null) {
                    pointSeriesStyle = pointSeriesStyle2;
                }
                nativeSetStrokeThickness(pointSeriesStyle.getActualMarkerStyle(contextProvider).getStrokeThickness().floatValue());
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.PointSeries$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
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
            int[] iArr2 = new int[PointSeriesStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$PointSeriesStyle$Property = iArr2;
            try {
                iArr2[PointSeriesStyle.Property.SIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.devexpress.dxcharts.StyledElement
    List<Enum<?>> getListenPropertiesNames() {
        List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
        Collections.addAll(listenPropertiesNames, PointSeriesStyle.Property.values());
        Collections.addAll(listenPropertiesNames, MarkerStyle.Property.values());
        return listenPropertiesNames;
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    SeriesLabel getDefaultLabel() {
        return new MarkerSeriesLabel();
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    public MarkerSeriesLabel getLabel() {
        return (MarkerSeriesLabel) super.getLabel();
    }

    public void setLabel(MarkerSeriesLabel markerSeriesLabel) {
        super.setLabel((SeriesLabel) markerSeriesLabel);
    }

    public void setStyle(PointSeriesStyle pointSeriesStyle) {
        trySetStyle(pointSeriesStyle);
    }

    public PointSeriesStyle getStyle() {
        return (PointSeriesStyle) getUserStyleFromContainer(PointSeriesStyle.class);
    }

    public PointColorizer getPointColorizer() {
        return this.colorizerHolder.getColorizer();
    }

    public void setPointColorizer(PointColorizer pointColorizer) {
        this.colorizerHolder.setColorizer(pointColorizer);
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
