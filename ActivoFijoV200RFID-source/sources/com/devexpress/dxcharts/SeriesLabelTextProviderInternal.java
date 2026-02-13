package com.devexpress.dxcharts;

/* compiled from: SeriesLabel.java */
/* loaded from: classes.dex */
class SeriesLabelTextProviderInternal {
    private SeriesBase mSeries;
    private SeriesLabelTextProvider mTextFormatter;

    SeriesLabelTextProviderInternal() {
    }

    SeriesLabelTextProvider getProvider() {
        return this.mTextFormatter;
    }

    void setProvider(SeriesLabelTextProvider seriesLabelTextProvider) {
        this.mTextFormatter = seriesLabelTextProvider;
    }

    void setOwner(SeriesBase seriesBase) {
        this.mSeries = seriesBase;
    }

    String getLabelText(PointLabelInfo pointLabelInfo) {
        SeriesBase seriesBase = this.mSeries;
        String text = (seriesBase == null || this.mTextFormatter == null) ? null : this.mTextFormatter.getText(seriesBase.createLabelValues(pointLabelInfo));
        return text != null ? text : "";
    }

    String[] getLabelTexts(PointLabelInfo[] pointLabelInfoArr) {
        String[] strArr = new String[pointLabelInfoArr.length];
        for (int i = 0; i < pointLabelInfoArr.length; i++) {
            strArr[i] = getLabelText(pointLabelInfoArr[i]);
        }
        return strArr;
    }
}
