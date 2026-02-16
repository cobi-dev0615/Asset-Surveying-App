package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class AxisLayout extends ChartElement {
    static final double DEFAULT_ANCHOR_1 = 0.0d;
    static final double DEFAULT_ANCHOR_2 = 1.0d;
    private double mAnchor1 = 0.0d;
    private double mAnchor2 = 1.0d;

    enum Property {
        ANCHOR_1,
        ANCHOR_2
    }

    public double getAnchor1() {
        return this.mAnchor1;
    }

    public void setAnchor1(double d) {
        if (this.mAnchor1 != d) {
            this.mAnchor1 = d;
            notifyListeners(Property.ANCHOR_1);
        }
    }

    public double getAnchor2() {
        return this.mAnchor2;
    }

    public void setAnchor2(double d) {
        if (this.mAnchor2 != d) {
            this.mAnchor2 = d;
            notifyListeners(Property.ANCHOR_2);
        }
    }
}
