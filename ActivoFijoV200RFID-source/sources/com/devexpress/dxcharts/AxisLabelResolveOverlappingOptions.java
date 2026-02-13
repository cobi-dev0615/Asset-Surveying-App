package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class AxisLabelResolveOverlappingOptions extends ChartElement {
    private boolean allowHide = true;

    enum Property {
        ALLOW_HIDE
    }

    public boolean isAllowHide() {
        return this.allowHide;
    }

    public void setAllowHide(boolean z) {
        this.allowHide = z;
        notifyListeners(Property.ALLOW_HIDE);
    }
}
