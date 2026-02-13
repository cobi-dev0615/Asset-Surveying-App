package com.devexpress.dxcharts;

import com.devexpress.dxcharts.AreaSeriesStyle;
import com.devexpress.dxcharts.LineSeriesStyle;
import com.devexpress.dxcharts.MarkerStyle;
import com.devexpress.dxcharts.PointSeriesStyle;
import com.devexpress.dxcharts.TransparencyGradient;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AreaSeriesBase extends Series {
    private LegendItemsBehavior legendItemsBehavior = LegendItemsBehavior.SERIES;

    @Override // com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    native boolean nativeGetColorEach();

    native boolean nativeGetShowMarkers();

    native void nativeSetAlpha(float f);

    native void nativeSetBaselineAlpha(float f);

    native void nativeSetColorEach(boolean z);

    native void nativeSetLegendItemsBehavior(long j, int i);

    native void nativeSetMarkerColor(int i);

    native void nativeSetMarkerSize(int i);

    native void nativeSetMarkerStrokeColor(int i);

    native void nativeSetMarkerStrokeThickness(float f);

    native void nativeSetShowMarkers(boolean z);

    native void nativeSetStrokeColor(int i);

    native void nativeSetStrokeThickness(float f);

    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(AreaSeriesStyle.class);
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    SeriesLabel getDefaultLabel() {
        return new MarkerSeriesLabel();
    }

    @Override // com.devexpress.dxcharts.StyledElement
    void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r9) {
        super.applyStyleAttribute(contextProvider, styleContainer, r9);
        AreaSeriesStyle areaSeriesStyle = (AreaSeriesStyle) styleContainer.getActualStyle(contextProvider, new Object[0]);
        AreaSeriesStyle areaSeriesStyle2 = (AreaSeriesStyle) styleContainer.getDefaultStyle();
        if ((r9 instanceof PointSeriesStyle.Property) && AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$PointSeriesStyle$Property[((PointSeriesStyle.Property) r9).ordinal()] == 1) {
            nativeSetMarkerSize((areaSeriesStyle.getMarkerSize() != null ? areaSeriesStyle : areaSeriesStyle2).getMarkerSize().intValue());
        }
        if (r9 instanceof AreaSeriesStyle.Property) {
            int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$AreaSeriesStyle$Property[((AreaSeriesStyle.Property) r9).ordinal()];
            if (i != 1) {
                if (i == 2) {
                    nativeSetColor(ColorHelper.convertToNativeColor((areaSeriesStyle.getFill() != null ? areaSeriesStyle : areaSeriesStyle2).getFill()));
                } else if (i == 3) {
                    nativeSetAlpha((areaSeriesStyle.getAlpha() != null ? areaSeriesStyle : areaSeriesStyle2).getAlpha().floatValue());
                }
            } else if (areaSeriesStyle.getFillEffect() == null) {
                nativeSetBaselineAlpha(-1.0f);
                nativeSetAlpha((areaSeriesStyle.getAlpha() != null ? areaSeriesStyle : areaSeriesStyle2).getAlpha().floatValue());
            } else {
                nativeSetBaselineAlpha((areaSeriesStyle.getActualFillEffectStyle(contextProvider).getBaselineAlpha() != null ? areaSeriesStyle : areaSeriesStyle2).getActualFillEffectStyle(contextProvider).getBaselineAlpha().floatValue());
                nativeSetAlpha((areaSeriesStyle.getActualFillEffectStyle(contextProvider).getSeriesLineAlpha() != null ? areaSeriesStyle : areaSeriesStyle2).getActualFillEffectStyle(contextProvider).getSeriesLineAlpha().floatValue());
            }
        }
        if (r9 instanceof TransparencyGradient.Property) {
            areaSeriesStyle.getActualFillEffectStyle(contextProvider);
            int i2 = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$TransparencyGradient$Property[((TransparencyGradient.Property) r9).ordinal()];
            if (i2 == 1) {
                nativeSetBaselineAlpha((areaSeriesStyle.getActualFillEffectStyle(contextProvider).getBaselineAlpha() != null ? areaSeriesStyle : areaSeriesStyle2).getActualFillEffectStyle(contextProvider).getBaselineAlpha().floatValue());
            } else if (i2 == 2) {
                nativeSetAlpha((areaSeriesStyle.getActualFillEffectStyle(contextProvider).getSeriesLineAlpha() != null ? areaSeriesStyle : areaSeriesStyle2).getActualFillEffectStyle(contextProvider).getSeriesLineAlpha().floatValue());
            }
        }
        if (r9 instanceof LineSeriesStyle.Property) {
            int i3 = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$LineSeriesStyle$Property[((LineSeriesStyle.Property) r9).ordinal()];
            if (i3 == 1) {
                nativeSetStrokeColor(ColorHelper.convertToNativeColor((areaSeriesStyle.getStroke() != null ? areaSeriesStyle : areaSeriesStyle2).getStroke()));
            } else if (i3 == 2) {
                nativeSetStrokeThickness((areaSeriesStyle.getStrokeThickness() != null ? areaSeriesStyle : areaSeriesStyle2).getStrokeThickness().floatValue());
            }
        }
        if (r9 instanceof MarkerStyle.Property) {
            int i4 = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$MarkerStyle$Property[((MarkerStyle.Property) r9).ordinal()];
            if (i4 == 1) {
                if (areaSeriesStyle.getActualMarkerStyle(contextProvider).getFill() == null) {
                    areaSeriesStyle = areaSeriesStyle2;
                }
                nativeSetMarkerColor(areaSeriesStyle.getActualMarkerStyle(contextProvider).getFill().intValue());
            } else if (i4 == 2) {
                if (areaSeriesStyle.getActualMarkerStyle(contextProvider).getStroke() == null) {
                    areaSeriesStyle = areaSeriesStyle2;
                }
                nativeSetMarkerStrokeColor(ColorHelper.convertToNativeColor(areaSeriesStyle.getActualMarkerStyle(contextProvider).getStroke()));
            } else {
                if (i4 != 3) {
                    return;
                }
                if (areaSeriesStyle.getActualMarkerStyle(contextProvider).getStrokeThickness() == null) {
                    areaSeriesStyle = areaSeriesStyle2;
                }
                nativeSetMarkerStrokeThickness(areaSeriesStyle.getActualMarkerStyle(contextProvider).getStrokeThickness().floatValue());
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.AreaSeriesBase$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$AreaSeriesStyle$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$LineSeriesStyle$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$MarkerStyle$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$PointSeriesStyle$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$TransparencyGradient$Property;

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
            int[] iArr3 = new int[TransparencyGradient.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$TransparencyGradient$Property = iArr3;
            try {
                iArr3[TransparencyGradient.Property.BASELINE_ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$TransparencyGradient$Property[TransparencyGradient.Property.SERIESLINE_ALPHA.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr4 = new int[AreaSeriesStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$AreaSeriesStyle$Property = iArr4;
            try {
                iArr4[AreaSeriesStyle.Property.FILL_EFFECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AreaSeriesStyle$Property[AreaSeriesStyle.Property.FILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AreaSeriesStyle$Property[AreaSeriesStyle.Property.ALPHA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr5 = new int[PointSeriesStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$PointSeriesStyle$Property = iArr5;
            try {
                iArr5[PointSeriesStyle.Property.SIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    @Override // com.devexpress.dxcharts.StyledElement
    List<Enum<?>> getListenPropertiesNames() {
        List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
        Collections.addAll(listenPropertiesNames, AreaSeriesStyle.Property.values());
        Collections.addAll(listenPropertiesNames, LineSeriesStyle.Property.values());
        Collections.addAll(listenPropertiesNames, PointSeriesStyle.Property.values());
        Collections.addAll(listenPropertiesNames, MarkerStyle.Property.values());
        return listenPropertiesNames;
    }

    public void setStyle(AreaSeriesStyle areaSeriesStyle) {
        trySetStyle(areaSeriesStyle);
    }

    public AreaSeriesStyle getStyle() {
        return (AreaSeriesStyle) getUserStyleFromContainer(AreaSeriesStyle.class);
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

    public LegendItemsBehavior getLegendItemsBehavior() {
        return this.legendItemsBehavior;
    }

    public void setLegendItemsBehavior(LegendItemsBehavior legendItemsBehavior) {
        if (this.legendItemsBehavior != legendItemsBehavior) {
            this.legendItemsBehavior = legendItemsBehavior;
            nativeSetLegendItemsBehavior(getNativeSeries(), this.legendItemsBehavior.ordinal());
        }
    }
}
