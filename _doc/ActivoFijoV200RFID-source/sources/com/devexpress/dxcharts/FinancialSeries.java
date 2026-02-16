package com.devexpress.dxcharts;

import com.devexpress.dxcharts.StockSeriesStyle;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public abstract class FinancialSeries extends Series {
    @Override // com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    native void nativeSetFallingStroke(int i);

    native void nativeSetRisingStroke(int i);

    native void nativeSetStrokeThickness(float f);

    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(StockSeriesStyle.class);
    }

    @Override // com.devexpress.dxcharts.StyledElement
    void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r4) {
        super.applyStyleAttribute(contextProvider, styleContainer, r4);
        StockSeriesStyle stockSeriesStyle = (StockSeriesStyle) styleContainer.getActualStyle(contextProvider, new Object[0]);
        StockSeriesStyle stockSeriesStyle2 = (StockSeriesStyle) styleContainer.getDefaultStyle();
        if (r4 instanceof StockSeriesStyle.Property) {
            int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$StockSeriesStyle$Property[((StockSeriesStyle.Property) r4).ordinal()];
            if (i == 1) {
                if (stockSeriesStyle.getStrokeThickness() == null) {
                    stockSeriesStyle = stockSeriesStyle2;
                }
                nativeSetStrokeThickness(stockSeriesStyle.getStrokeThickness().floatValue());
            } else if (i == 2) {
                if (stockSeriesStyle.getRisingStroke() == null) {
                    stockSeriesStyle = stockSeriesStyle2;
                }
                nativeSetRisingStroke(ColorHelper.convertToNativeColor(stockSeriesStyle.getRisingStroke()));
            } else {
                if (i != 3) {
                    return;
                }
                if (stockSeriesStyle.getFallingStroke() == null) {
                    stockSeriesStyle = stockSeriesStyle2;
                }
                nativeSetFallingStroke(ColorHelper.convertToNativeColor(stockSeriesStyle.getFallingStroke()));
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.FinancialSeries$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$StockSeriesStyle$Property;

        static {
            int[] iArr = new int[StockSeriesStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$StockSeriesStyle$Property = iArr;
            try {
                iArr[StockSeriesStyle.Property.STROKE_THICKNESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$StockSeriesStyle$Property[StockSeriesStyle.Property.RISING_STROKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$StockSeriesStyle$Property[StockSeriesStyle.Property.FALLING_STROKE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    SeriesLabel getDefaultLabel() {
        return new FinancialSeriesLabel();
    }

    @Override // com.devexpress.dxcharts.Series, com.devexpress.dxcharts.SeriesBase
    SeriesLabelValuesBase createLabelValues(PointLabelInfo pointLabelInfo) {
        return new FinancialSeriesLabelValues(pointLabelInfo.seriesName, pointLabelInfo.indexes, (Date) pointLabelInfo.argument, pointLabelInfo.high, pointLabelInfo.low, pointLabelInfo.open, pointLabelInfo.close);
    }

    @Override // com.devexpress.dxcharts.StyledElement
    List<Enum<?>> getListenPropertiesNames() {
        List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
        Collections.addAll(listenPropertiesNames, StockSeriesStyle.Property.values());
        return listenPropertiesNames;
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    public FinancialSeriesLabel getLabel() {
        return (FinancialSeriesLabel) super.getLabel();
    }

    public void setLabel(FinancialSeriesLabel financialSeriesLabel) {
        super.setLabel((SeriesLabel) financialSeriesLabel);
    }
}
