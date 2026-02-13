package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public abstract class SeriesHintOptionsBase extends ChartElement {
    static final boolean DEFAULT_ENABLED = true;
    static final String DEFAULT_POINT_TEXT_PATTERN = null;
    private boolean mEnabled = true;
    private String mPointTextPattern = DEFAULT_POINT_TEXT_PATTERN;
    private PointTextProvider mPointTextProvider;

    enum Property {
        ENABLED,
        POINT_TEXT_PATTERN,
        POINT_TEXT_PROVIDER
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean z) {
        if (this.mEnabled != z) {
            this.mEnabled = z;
            notifyListeners(Property.ENABLED);
        }
    }

    public String getPointTextPattern() {
        return this.mPointTextPattern;
    }

    public void setPointTextPattern(String str) {
        if (CompareHelper.areNotEquals(this.mPointTextPattern, str)) {
            this.mPointTextPattern = str;
            notifyListeners(Property.POINT_TEXT_PATTERN);
        }
    }

    public PointTextProvider getPointTextProvider() {
        return this.mPointTextProvider;
    }

    public void setPointTextProvider(PointTextProvider pointTextProvider) {
        if (this.mPointTextProvider != pointTextProvider) {
            this.mPointTextProvider = pointTextProvider;
            notifyListeners(Property.POINT_TEXT_PROVIDER);
        }
    }
}
