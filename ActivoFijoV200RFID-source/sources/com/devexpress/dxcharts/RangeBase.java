package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public abstract class RangeBase extends ChartElement {
    private double sideMargin;
    private boolean isDefaultMin = true;
    private boolean isDefaultMax = true;
    private boolean isDefaultVisualMin = true;
    private boolean isDefaultVisualMax = true;

    enum Property {
        WHOLE_RANGE,
        VISUAL_RANGE,
        SIDE_MARGIN
    }

    abstract void resetVisualMinMaxValues();

    abstract void resetWholeMinMaxValues();

    public RangeBase() {
        resetVisualMinMaxValues();
        resetWholeMinMaxValues();
        resetSideMargin();
    }

    boolean canUpdateWholeMin() {
        this.isDefaultMin = false;
        return !this.isDefaultMax;
    }

    boolean isDefaultWholeMin() {
        return this.isDefaultMin;
    }

    boolean canUpdateWholeMax() {
        this.isDefaultMax = false;
        return !this.isDefaultMin;
    }

    boolean isDefaultWholeMax() {
        return this.isDefaultMax;
    }

    boolean canUpdateVisualMin() {
        this.isDefaultVisualMin = false;
        return !this.isDefaultVisualMax;
    }

    boolean isDefaultVisualMin() {
        return this.isDefaultVisualMin;
    }

    boolean canUpdateVisualMax() {
        this.isDefaultVisualMax = false;
        return !this.isDefaultVisualMin;
    }

    boolean isDefaultVisualMax() {
        return this.isDefaultVisualMax;
    }

    boolean isDefaultVisualRange() {
        return this.isDefaultVisualMax || this.isDefaultVisualMin;
    }

    boolean isDefaultWholeRange() {
        return this.isDefaultMax || this.isDefaultMin;
    }

    void resetSideMargin() {
        this.sideMargin = -1.0d;
        notifyListeners(Property.SIDE_MARGIN);
    }

    public double getSideMargin() {
        return this.sideMargin;
    }

    public void setSideMargin(double d) {
        if (this.sideMargin != d) {
            this.sideMargin = d;
            notifyListeners(Property.SIDE_MARGIN);
        }
    }

    public void resetRange() {
        this.isDefaultMax = true;
        this.isDefaultMin = true;
        resetWholeMinMaxValues();
        notifyListeners(Property.WHOLE_RANGE);
    }

    public void resetVisualRange() {
        this.isDefaultVisualMax = true;
        this.isDefaultVisualMin = true;
        resetVisualMinMaxValues();
        notifyListeners(Property.VISUAL_RANGE);
    }
}
