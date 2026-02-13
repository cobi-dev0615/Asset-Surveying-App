package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class FinancialSeriesLabel extends SeriesLabel {
    @Override // com.devexpress.dxcharts.SeriesLabel
    native long nativeCreateLabel();

    native int nativeGetPosition(long j);

    native void nativeSetPosition(int i, long j);

    public FinancialSeriesLabelPosition getPosition() {
        return FinancialSeriesLabelPosition.values()[nativeGetPosition(getNativeLabel())];
    }

    public void setPosition(FinancialSeriesLabelPosition financialSeriesLabelPosition) {
        if (financialSeriesLabelPosition != null) {
            nativeSetPosition(financialSeriesLabelPosition.ordinal(), getNativeLabel());
        }
    }

    public SeriesLabelStyle getStyle() {
        return (SeriesLabelStyle) getUserStyleFromContainer(SeriesLabelStyle.class);
    }

    public void setStyle(SeriesLabelStyle seriesLabelStyle) {
        trySetStyle(seriesLabelStyle);
    }
}
