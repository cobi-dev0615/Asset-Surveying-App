package com.devexpress.dxcharts;

import com.devexpress.dxcharts.BollingerBandsIndicatorStyle;
import com.devexpress.dxcharts.LineIndicatorStyle;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class BollingerBandsIndicator extends CalculatedSeries {
    final double DefaultStandardDeviationMultiplier = 2.0d;
    ValueLevel _valueLevel = ValueLevel.AUTO;
    int _pointsCount = 20;
    double _standardDeviationMultiplier = 2.0d;

    @Override // com.devexpress.dxcharts.CalculatedSeries, com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    native void nativeSetBandsHighStrokeColor(int i);

    native void nativeSetBandsHighStrokeThickness(float f);

    native void nativeSetBandsLowStrokeColor(int i);

    native void nativeSetBandsLowStrokeThickness(float f);

    @Override // com.devexpress.dxcharts.CalculatedSeries, com.devexpress.dxcharts.Series
    native void nativeSetColor(int i);

    @Override // com.devexpress.dxcharts.CalculatedSeries
    native void nativeSetStrokeThickness(float f);

    @Override // com.devexpress.dxcharts.CalculatedSeries, com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(BollingerBandsIndicatorStyle.class);
    }

    @Override // com.devexpress.dxcharts.CalculatedSeries, com.devexpress.dxcharts.StyledElement
    List<Enum<?>> getListenPropertiesNames() {
        List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
        Collections.addAll(listenPropertiesNames, BollingerBandsIndicatorStyle.Property.values());
        return listenPropertiesNames;
    }

    @Override // com.devexpress.dxcharts.Series
    SeriesDataAdapterBase createDataAdapter(XYSeriesData xYSeriesData) {
        if (!(xYSeriesData instanceof CalculatedSeriesData)) {
            return null;
        }
        CalculatedSeriesData calculatedSeriesData = (CalculatedSeriesData) xYSeriesData;
        return BollingerBandsDataAdapter.create(new CalculatedSeriesDataWrapper(calculatedSeriesData), getNativeSeries(), CalculatedSeries.getActualValueLevel(this._valueLevel, calculatedSeriesData), getSyncObject(), this._pointsCount, this._standardDeviationMultiplier);
    }

    @Override // com.devexpress.dxcharts.CalculatedSeries, com.devexpress.dxcharts.StyledElement
    void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r7) {
        super.applyStyleAttribute(contextProvider, styleContainer, r7);
        BollingerBandsIndicatorStyle bollingerBandsIndicatorStyle = (BollingerBandsIndicatorStyle) styleContainer.getActualStyle(contextProvider, new Object[0]);
        BollingerBandsIndicatorStyle bollingerBandsIndicatorStyle2 = (BollingerBandsIndicatorStyle) styleContainer.getDefaultStyle();
        if (r7 instanceof LineIndicatorStyle.Property) {
            int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$LineIndicatorStyle$Property[((LineIndicatorStyle.Property) r7).ordinal()];
            if (i == 1) {
                nativeSetColor(ColorHelper.convertToNativeColor((bollingerBandsIndicatorStyle.getStroke() != null ? bollingerBandsIndicatorStyle : bollingerBandsIndicatorStyle2).getStroke()));
            } else if (i == 2) {
                nativeSetStrokeThickness((bollingerBandsIndicatorStyle.getStrokeThickness() != null ? bollingerBandsIndicatorStyle : bollingerBandsIndicatorStyle2).getStrokeThickness().floatValue());
            }
        }
        if (r7 instanceof BollingerBandsIndicatorStyle.Property) {
            int i2 = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$BollingerBandsIndicatorStyle$Property[((BollingerBandsIndicatorStyle.Property) r7).ordinal()];
            if (i2 == 1) {
                if (bollingerBandsIndicatorStyle.getUpperStroke() == null) {
                    bollingerBandsIndicatorStyle = bollingerBandsIndicatorStyle2;
                }
                nativeSetBandsHighStrokeColor(ColorHelper.convertToNativeColor(bollingerBandsIndicatorStyle.getUpperStroke()));
                return;
            }
            if (i2 == 2) {
                if (bollingerBandsIndicatorStyle.getUpperStrokeThickness() == null) {
                    bollingerBandsIndicatorStyle = bollingerBandsIndicatorStyle2;
                }
                nativeSetBandsHighStrokeThickness(bollingerBandsIndicatorStyle.getUpperStrokeThickness().floatValue());
            } else if (i2 == 3) {
                if (bollingerBandsIndicatorStyle.getLowerStroke() == null) {
                    bollingerBandsIndicatorStyle = bollingerBandsIndicatorStyle2;
                }
                nativeSetBandsLowStrokeColor(ColorHelper.convertToNativeColor(bollingerBandsIndicatorStyle.getLowerStroke()));
            } else {
                if (i2 != 4) {
                    return;
                }
                if (bollingerBandsIndicatorStyle.getLowerStrokeThickness() == null) {
                    bollingerBandsIndicatorStyle = bollingerBandsIndicatorStyle2;
                }
                nativeSetBandsLowStrokeThickness(bollingerBandsIndicatorStyle.getLowerStrokeThickness().floatValue());
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.BollingerBandsIndicator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$BollingerBandsIndicatorStyle$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$LineIndicatorStyle$Property;

        static {
            int[] iArr = new int[BollingerBandsIndicatorStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$BollingerBandsIndicatorStyle$Property = iArr;
            try {
                iArr[BollingerBandsIndicatorStyle.Property.BANDS_HIGH_STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$BollingerBandsIndicatorStyle$Property[BollingerBandsIndicatorStyle.Property.BANDS_HIGH_STROKE_THICKNESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$BollingerBandsIndicatorStyle$Property[BollingerBandsIndicatorStyle.Property.BANDS_LOW_STROKE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$BollingerBandsIndicatorStyle$Property[BollingerBandsIndicatorStyle.Property.BANDS_LOW_STROKE_THICKNESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[LineIndicatorStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$LineIndicatorStyle$Property = iArr2;
            try {
                iArr2[LineIndicatorStyle.Property.STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$LineIndicatorStyle$Property[LineIndicatorStyle.Property.STROKE_THICKNESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
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

    public double getStandardDeviationMultiplier() {
        return this._standardDeviationMultiplier;
    }

    public void setStandardDeviationMultiplier(double d) {
        if (this._standardDeviationMultiplier != d) {
            this._standardDeviationMultiplier = d;
            if (getData() != null) {
                setAdapterInternal(createDataAdapter(getData()));
            }
        }
    }

    public void setStyle(BollingerBandsIndicatorStyle bollingerBandsIndicatorStyle) {
        trySetStyle(bollingerBandsIndicatorStyle);
    }

    public BollingerBandsIndicatorStyle getStyle() {
        return (BollingerBandsIndicatorStyle) getUserStyleFromContainer(BollingerBandsIndicatorStyle.class);
    }
}
