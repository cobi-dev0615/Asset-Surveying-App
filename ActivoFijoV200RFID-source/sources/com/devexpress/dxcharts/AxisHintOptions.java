package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class AxisHintOptions extends ChartElement {
    static final boolean DEFAULT_LABEL_VISIBLE = true;
    static final boolean DEFAULT_LINE_VISIBLE = true;
    private boolean mLabelVisible = true;
    private boolean mLineVisible = true;

    enum Property {
        LABEL_VISIBLE,
        LINE_VISIBLE
    }

    public boolean isLabelVisible() {
        return this.mLabelVisible;
    }

    public void setLabelVisible(boolean z) {
        if (this.mLabelVisible != z) {
            this.mLabelVisible = z;
            notifyListeners(Property.LABEL_VISIBLE);
        }
    }

    public boolean isLineVisible() {
        return this.mLineVisible;
    }

    public void setLineVisible(boolean z) {
        if (this.mLineVisible != z) {
            this.mLineVisible = z;
            notifyListeners(Property.LINE_VISIBLE);
        }
    }
}
