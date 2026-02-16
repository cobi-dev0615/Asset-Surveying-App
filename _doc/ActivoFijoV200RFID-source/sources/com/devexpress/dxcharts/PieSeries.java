package com.devexpress.dxcharts;

import com.devexpress.dxcharts.PieSeriesStyle;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class PieSeries extends SeriesBase {
    private PieCenterLabel centerLabel;
    private PieSeriesData data;

    private enum Property {
        CENTER_LABEL
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    native long nativeCreateSeries(long j);

    @Override // com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    native float nativeGetHoleRadius();

    native float nativeGetStartAngle();

    native int nativeGetSweepDirection();

    native void nativeSetExplodedDistance(float f);

    native void nativeSetHoleRadius(float f);

    native void nativeSetStartAngle(float f);

    native void nativeSetStrokeColor(int i);

    native void nativeSetStrokeThickness(float f);

    native void nativeSetSweepDirection(int i);

    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(PieSeriesStyle.class);
    }

    @Override // com.devexpress.dxcharts.StyledElement
    void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r4) {
        super.applyStyleAttribute(contextProvider, styleContainer, r4);
        PieSeriesStyle pieSeriesStyle = (PieSeriesStyle) styleContainer.getActualStyle(contextProvider, new Object[0]);
        PieSeriesStyle pieSeriesStyle2 = (PieSeriesStyle) styleContainer.getDefaultStyle();
        if (r4 instanceof PieSeriesStyle.Property) {
            int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$PieSeriesStyle$Property[((PieSeriesStyle.Property) r4).ordinal()];
            if (i == 1) {
                if (pieSeriesStyle.getExplodedDistance() == null) {
                    pieSeriesStyle = pieSeriesStyle2;
                }
                nativeSetExplodedDistance(pieSeriesStyle.getExplodedDistance().floatValue());
            } else if (i == 2) {
                if (pieSeriesStyle.getStroke() == null) {
                    pieSeriesStyle = pieSeriesStyle2;
                }
                nativeSetStrokeColor(ColorHelper.convertToNativeColor(pieSeriesStyle.getStroke()));
            } else {
                if (i != 3) {
                    return;
                }
                if (pieSeriesStyle.getStrokeThickness() == null) {
                    pieSeriesStyle = pieSeriesStyle2;
                }
                nativeSetStrokeThickness(pieSeriesStyle.getStrokeThickness().floatValue());
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.PieSeries$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$PieSeriesStyle$Property;

        static {
            int[] iArr = new int[PieSeriesStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$PieSeriesStyle$Property = iArr;
            try {
                iArr[PieSeriesStyle.Property.EXPLODED_DISTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$PieSeriesStyle$Property[PieSeriesStyle.Property.STROKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$PieSeriesStyle$Property[PieSeriesStyle.Property.STROKE_THICKNESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    SeriesLabel getDefaultLabel() {
        return new PieSeriesLabel();
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    SeriesLabelValuesBase createLabelValues(PointLabelInfo pointLabelInfo) {
        return new PieSeriesLabelValues(pointLabelInfo.seriesName, pointLabelInfo.indexes, (String) pointLabelInfo.argument, pointLabelInfo.value, pointLabelInfo.valueInPercent);
    }

    @Override // com.devexpress.dxcharts.StyledElement
    List<Enum<?>> getListenPropertiesNames() {
        List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
        Collections.addAll(listenPropertiesNames, PieSeriesStyle.Property.values());
        return listenPropertiesNames;
    }

    @Override // com.devexpress.dxcharts.SeriesBase, com.devexpress.dxcharts.StyledElement
    List<StyledElement> getInnerStyledElements(ContextProvider contextProvider) {
        List<StyledElement> innerStyledElements = super.getInnerStyledElements(contextProvider);
        PieCenterLabel pieCenterLabel = this.centerLabel;
        if (pieCenterLabel != null) {
            innerStyledElements.add(pieCenterLabel);
        }
        return innerStyledElements;
    }

    @Override // com.devexpress.dxcharts.SeriesBase, com.devexpress.dxcharts.StyledElement, com.devexpress.dxcharts.ChartElement
    void onChartElementPropertyChanged(Object obj, PropertyChangedArgs propertyChangedArgs) {
        if (obj instanceof PieCenterLabel) {
            notifyListeners(Property.CENTER_LABEL);
        } else {
            super.onChartElementPropertyChanged(obj, propertyChangedArgs);
        }
    }

    public PieSeriesData getData() {
        return this.data;
    }

    public void setData(PieSeriesData pieSeriesData) {
        synchronized (ChartBase.syncObject) {
            if (this.data != pieSeriesData) {
                this.data = pieSeriesData;
                setAdapterInternal(PieSeriesDataAdapterBase.create(pieSeriesData, getNativeSeries(), getSyncObject()));
            }
        }
    }

    public float getStartAngle() {
        return (float) Math.toDegrees(nativeGetStartAngle());
    }

    public void setStartAngle(float f) {
        synchronized (ChartBase.syncObject) {
            nativeSetStartAngle((float) Math.toRadians(f));
        }
    }

    public SweepDirection getSweepDirection() {
        return SweepDirection.values()[nativeGetSweepDirection()];
    }

    public void setSweepDirection(SweepDirection sweepDirection) {
        if (sweepDirection != null) {
            synchronized (ChartBase.syncObject) {
                nativeSetSweepDirection(sweepDirection.ordinal());
            }
        }
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    public PieSeriesLabel getLabel() {
        return (PieSeriesLabel) super.getLabel();
    }

    public void setLabel(PieSeriesLabel pieSeriesLabel) {
        super.setLabel((SeriesLabel) pieSeriesLabel);
    }

    public PieSeriesStyle getStyle() {
        return (PieSeriesStyle) getUserStyleFromContainer(PieSeriesStyle.class);
    }

    public void setStyle(PieSeriesStyle pieSeriesStyle) {
        trySetStyle(pieSeriesStyle);
    }

    public PieSeriesHintOptions getHintOptions() {
        return (PieSeriesHintOptions) getHintOptionsInternal();
    }

    public void setHintOptions(PieSeriesHintOptions pieSeriesHintOptions) {
        setHintOptionsInternal(pieSeriesHintOptions);
    }

    public PieCenterLabel getCenterLabel() {
        return this.centerLabel;
    }

    public void setCenterLabel(PieCenterLabel pieCenterLabel) {
        PieCenterLabel pieCenterLabel2 = this.centerLabel;
        if (pieCenterLabel2 != pieCenterLabel) {
            if (pieCenterLabel2 != null) {
                pieCenterLabel2.removeListener(getSelfListener());
            }
            this.centerLabel = pieCenterLabel;
            if (pieCenterLabel != null) {
                pieCenterLabel.addListener(getSelfListener());
                this.centerLabel.applyCurrentTheme(getContext(), new Object[0]);
            }
            notifyListeners(Property.CENTER_LABEL);
        }
    }
}
