package com.devexpress.dxcharts;

/* compiled from: ChartTextStyleProvider.java */
/* loaded from: classes.dex */
class PieTextStyleProvider extends TextStyleProvider {
    private static final long INVALID_ID = -1;
    private static final long Series_InitialID = 100;
    private PieChart pieChart;

    @Override // com.devexpress.dxcharts.TextStyleProvider
    native long nativeCreateTextStyleProvider();

    PieTextStyleProvider(PieChart pieChart) {
        this.pieChart = pieChart;
    }

    private long tryGetSeriesID(long j) {
        for (int i = 0; i < this.pieChart.getSeries().length; i++) {
            if (this.pieChart.getSeries()[i].compareNativeSeries(j)) {
                return i + Series_InitialID;
            }
        }
        return -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    @Override // com.devexpress.dxcharts.TextStyleProviderInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Paint getTextStylePaint(long r4) {
        /*
            r3 = this;
            r0 = 100
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 < 0) goto L33
            long r4 = r4 - r0
            com.devexpress.dxcharts.PieChart r0 = r3.pieChart
            com.devexpress.dxcharts.PieSeries[] r0 = r0.getSeries()
            int r0 = r0.length
            long r0 = (long) r0
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 > 0) goto L33
            com.devexpress.dxcharts.PieChart r0 = r3.pieChart
            com.devexpress.dxcharts.SeriesBase r4 = r0.getSeriesAt(r4)
            com.devexpress.dxcharts.SeriesLabel r4 = r4.getLabel()
            if (r4 == 0) goto L33
            com.devexpress.dxcharts.SeriesLabelStyle r4 = r4.getStyleInternal()
            if (r4 == 0) goto L33
            com.devexpress.dxcharts.PieChart r5 = r3.pieChart
            com.devexpress.dxcharts.ContextProvider r5 = r5.getContextProvider()
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            android.graphics.Paint r4 = r4.getActualTextStylePaint(r5, r0)
            goto L34
        L33:
            r4 = 0
        L34:
            if (r4 != 0) goto L3c
            com.devexpress.dxcharts.PieChart r4 = r3.pieChart
            android.graphics.Paint r4 = r4.getTextStylePaintInternal()
        L3c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.dxcharts.PieTextStyleProvider.getTextStylePaint(long):android.graphics.Paint");
    }
}
