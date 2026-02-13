package com.devexpress.dxcharts;

import com.devexpress.dxcharts.EnvelopeIndicatorStyle;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class EnvelopeIndicator extends CalculatedSeries {
    private static final double DefaultFactor = 0.1d;
    int _pointsCount = 20;
    double _factor = DefaultFactor;
    ValueLevel _valueLevel = ValueLevel.AUTO;

    @Override // com.devexpress.dxcharts.CalculatedSeries, com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    native void nativeSetAlpha(float f);

    @Override // com.devexpress.dxcharts.CalculatedSeries, com.devexpress.dxcharts.Series
    native void nativeSetColor(int i);

    native void nativeSetStrokeColorHigh(int i);

    native void nativeSetStrokeColorLow(int i);

    native void nativeSetStrokeThicknessHigh(float f);

    native void nativeSetStrokeThicknessLow(float f);

    @Override // com.devexpress.dxcharts.Series
    SeriesDataAdapterBase createDataAdapter(XYSeriesData xYSeriesData) {
        if (!(xYSeriesData instanceof CalculatedSeriesData)) {
            return null;
        }
        CalculatedSeriesData calculatedSeriesData = (CalculatedSeriesData) xYSeriesData;
        return EnvelopeDataAdapter.create(new CalculatedSeriesDataWrapper(calculatedSeriesData), getNativeSeries(), CalculatedSeries.getActualValueLevel(this._valueLevel, calculatedSeriesData), getSyncObject(), this._pointsCount, this._factor);
    }

    @Override // com.devexpress.dxcharts.CalculatedSeries, com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(EnvelopeIndicatorStyle.class);
    }

    @Override // com.devexpress.dxcharts.CalculatedSeries, com.devexpress.dxcharts.StyledElement
    List<Enum<?>> getListenPropertiesNames() {
        List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
        Collections.addAll(listenPropertiesNames, EnvelopeIndicatorStyle.Property.values());
        return listenPropertiesNames;
    }

    @Override // com.devexpress.dxcharts.CalculatedSeries, com.devexpress.dxcharts.StyledElement
    void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r4) {
        EnvelopeIndicatorStyle envelopeIndicatorStyle = (EnvelopeIndicatorStyle) styleContainer.getActualStyle(contextProvider, new Object[0]);
        EnvelopeIndicatorStyle envelopeIndicatorStyle2 = (EnvelopeIndicatorStyle) styleContainer.getDefaultStyle();
        if (r4 instanceof EnvelopeIndicatorStyle.Property) {
            switch (AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$EnvelopeIndicatorStyle$Property[((EnvelopeIndicatorStyle.Property) r4).ordinal()]) {
                case 1:
                    if (envelopeIndicatorStyle.getAlpha() == null) {
                        envelopeIndicatorStyle = envelopeIndicatorStyle2;
                    }
                    nativeSetAlpha(envelopeIndicatorStyle.getAlpha().floatValue());
                    break;
                case 2:
                    if (envelopeIndicatorStyle.getFill() == null) {
                        envelopeIndicatorStyle = envelopeIndicatorStyle2;
                    }
                    nativeSetColor(ColorHelper.convertToNativeColor(envelopeIndicatorStyle.getFill()));
                    break;
                case 3:
                    if (envelopeIndicatorStyle.getUpperStroke() == null) {
                        envelopeIndicatorStyle = envelopeIndicatorStyle2;
                    }
                    nativeSetStrokeColorHigh(envelopeIndicatorStyle.getUpperStroke().intValue());
                    break;
                case 4:
                    if (envelopeIndicatorStyle.getLowerStroke() == null) {
                        envelopeIndicatorStyle = envelopeIndicatorStyle2;
                    }
                    nativeSetStrokeColorLow(envelopeIndicatorStyle.getLowerStroke().intValue());
                    break;
                case 5:
                    if (envelopeIndicatorStyle.getUpperStrokeThickness() == null) {
                        envelopeIndicatorStyle = envelopeIndicatorStyle2;
                    }
                    nativeSetStrokeThicknessHigh(envelopeIndicatorStyle.getUpperStrokeThickness().floatValue());
                    break;
                case 6:
                    if (envelopeIndicatorStyle.getLowerStrokeThickness() == null) {
                        envelopeIndicatorStyle = envelopeIndicatorStyle2;
                    }
                    nativeSetStrokeThicknessLow(envelopeIndicatorStyle.getLowerStrokeThickness().floatValue());
                    break;
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.EnvelopeIndicator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$EnvelopeIndicatorStyle$Property;

        static {
            int[] iArr = new int[EnvelopeIndicatorStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$EnvelopeIndicatorStyle$Property = iArr;
            try {
                iArr[EnvelopeIndicatorStyle.Property.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$EnvelopeIndicatorStyle$Property[EnvelopeIndicatorStyle.Property.FILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$EnvelopeIndicatorStyle$Property[EnvelopeIndicatorStyle.Property.STROKE_HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$EnvelopeIndicatorStyle$Property[EnvelopeIndicatorStyle.Property.STROKE_LOW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$EnvelopeIndicatorStyle$Property[EnvelopeIndicatorStyle.Property.STROKE_THICKNESS_HIGH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$EnvelopeIndicatorStyle$Property[EnvelopeIndicatorStyle.Property.STROKE_THICKNESS_LOW.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public int getPointsCount() {
        return this._pointsCount;
    }

    public void setPointsCount(int i) {
        if (this._pointsCount != i) {
            this._pointsCount = i;
            if (getData() != null) {
                setAdapterInternal(createDataAdapter(getData()));
            }
        }
    }

    public double getFactor() {
        return this._factor;
    }

    public void setFactor(double d) {
        if (this._factor != d) {
            this._factor = d;
            if (getData() != null) {
                setAdapterInternal(createDataAdapter(getData()));
            }
        }
    }

    public ValueLevel getValueLevel() {
        return this._valueLevel;
    }

    public void setValueLevel(ValueLevel valueLevel) {
        if (this._valueLevel != valueLevel) {
            this._valueLevel = valueLevel;
            if (getData() != null) {
                setAdapterInternal(createDataAdapter(getData()));
            }
        }
    }

    public void setStyle(EnvelopeIndicatorStyle envelopeIndicatorStyle) {
        trySetStyle(envelopeIndicatorStyle);
    }

    public EnvelopeIndicatorStyle getStyle() {
        return (EnvelopeIndicatorStyle) getUserStyleFromContainer(EnvelopeIndicatorStyle.class);
    }
}
