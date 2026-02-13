package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class StockSeries extends FinancialSeries {
    public void setStyle(StockSeriesStyle stockSeriesStyle) {
        trySetStyle(stockSeriesStyle);
    }

    public StockSeriesStyle getStyle() {
        return (StockSeriesStyle) getUserStyleFromContainer(StockSeriesStyle.class);
    }
}
