package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class SeriesCrosshairOptions extends SeriesHintOptions {
    static final boolean DEFAULT_AXIS_LABEL_VISIBLE = true;
    static final boolean DEFAULT_AXIS_LINE_VISIBLE = true;
    static final boolean DEFAULT_SHOW_IN_LABEL = true;
    private boolean mAxisLabelVisible = true;
    private boolean mAxisLineVisible = true;
    private boolean mShowInLabel = true;

    enum Property {
        AXIS_LABEL_VISIBLE,
        AXIS_LINE_VISIBLE,
        SHOW_IN_LABEL
    }

    public boolean isAxisLabelVisible() {
        return this.mAxisLabelVisible;
    }

    public void setAxisLabelVisible(boolean z) {
        if (this.mAxisLabelVisible != z) {
            this.mAxisLabelVisible = z;
            notifyListeners(Property.AXIS_LABEL_VISIBLE);
        }
    }

    public boolean isAxisLineVisible() {
        return this.mAxisLineVisible;
    }

    public void setAxisLineVisible(boolean z) {
        if (this.mAxisLineVisible != z) {
            this.mAxisLineVisible = z;
            notifyListeners(Property.AXIS_LINE_VISIBLE);
        }
    }

    public boolean isShowInLabel() {
        return this.mShowInLabel;
    }

    public void setShowInLabel(boolean z) {
        if (this.mShowInLabel != z) {
            this.mShowInLabel = z;
            notifyListeners(Property.SHOW_IN_LABEL);
        }
    }
}
