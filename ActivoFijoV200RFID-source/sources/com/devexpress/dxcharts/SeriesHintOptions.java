package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class SeriesHintOptions extends SeriesHintOptionsBase {
    static final String DEFAULT_SERIES_TEXT_PATTERN = null;
    private String mSeriesTextPattern = DEFAULT_SERIES_TEXT_PATTERN;

    enum Property {
        SERIES_TEXT_PATTERN
    }

    public String getSeriesTextPattern() {
        return this.mSeriesTextPattern;
    }

    public void setSeriesTextPattern(String str) {
        if (CompareHelper.areNotEquals(this.mSeriesTextPattern, str)) {
            this.mSeriesTextPattern = str;
            notifyListeners(Property.SERIES_TEXT_PATTERN);
        }
    }
}
