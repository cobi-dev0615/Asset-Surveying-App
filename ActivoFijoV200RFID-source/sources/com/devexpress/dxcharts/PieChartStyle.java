package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class PieChartStyle extends ChartStyleBase {
    private Integer seriesIndent;

    enum Property {
        SERIES_INDENT
    }

    @Override // com.devexpress.dxcharts.ChartStyleBase, com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        super.initDefaultStyle(contextProvider, objArr);
        this.seriesIndent = Integer.valueOf((int) ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxPieChartSeriesIndent));
    }

    public Integer getSeriesIndent() {
        return this.seriesIndent;
    }

    public void setSeriesIndent(Integer num) {
        if (CompareHelper.areNotEquals(this.seriesIndent, num)) {
            this.seriesIndent = num;
            notifyListeners(Property.SERIES_INDENT);
        }
    }
}
