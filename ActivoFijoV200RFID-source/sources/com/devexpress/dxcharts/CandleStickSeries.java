package com.devexpress.dxcharts;

import com.devexpress.dxcharts.CandleStickSeriesStyle;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class CandleStickSeries extends FinancialSeries {
    @Override // com.devexpress.dxcharts.FinancialSeries, com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    native void nativeSetFallingFill(int i);

    native void nativeSetRisingFill(int i);

    @Override // com.devexpress.dxcharts.FinancialSeries, com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(CandleStickSeriesStyle.class);
    }

    @Override // com.devexpress.dxcharts.FinancialSeries, com.devexpress.dxcharts.StyledElement
    List<Enum<?>> getListenPropertiesNames() {
        List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
        Collections.addAll(listenPropertiesNames, CandleStickSeriesStyle.Property.values());
        return listenPropertiesNames;
    }

    @Override // com.devexpress.dxcharts.FinancialSeries, com.devexpress.dxcharts.StyledElement
    void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r4) {
        super.applyStyleAttribute(contextProvider, styleContainer, r4);
        CandleStickSeriesStyle candleStickSeriesStyle = (CandleStickSeriesStyle) styleContainer.getActualStyle(contextProvider, new Object[0]);
        CandleStickSeriesStyle candleStickSeriesStyle2 = (CandleStickSeriesStyle) styleContainer.getDefaultStyle();
        if (r4 instanceof CandleStickSeriesStyle.Property) {
            int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$CandleStickSeriesStyle$Property[((CandleStickSeriesStyle.Property) r4).ordinal()];
            if (i == 1) {
                if (candleStickSeriesStyle.getRisingFill() == null) {
                    candleStickSeriesStyle = candleStickSeriesStyle2;
                }
                nativeSetRisingFill(ColorHelper.convertToNativeColor(candleStickSeriesStyle.getRisingFill()));
            } else {
                if (i != 2) {
                    return;
                }
                if (candleStickSeriesStyle.getFallingFill() == null) {
                    candleStickSeriesStyle = candleStickSeriesStyle2;
                }
                nativeSetFallingFill(ColorHelper.convertToNativeColor(candleStickSeriesStyle.getFallingFill()));
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.CandleStickSeries$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$CandleStickSeriesStyle$Property;

        static {
            int[] iArr = new int[CandleStickSeriesStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$CandleStickSeriesStyle$Property = iArr;
            try {
                iArr[CandleStickSeriesStyle.Property.RISING_FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$CandleStickSeriesStyle$Property[CandleStickSeriesStyle.Property.FALLING_FILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void setStyle(CandleStickSeriesStyle candleStickSeriesStyle) {
        trySetStyle(candleStickSeriesStyle);
    }

    public CandleStickSeriesStyle getStyle() {
        return (CandleStickSeriesStyle) getUserStyleFromContainer(CandleStickSeriesStyle.class);
    }
}
