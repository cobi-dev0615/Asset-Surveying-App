package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class LogarithmicOptions extends ChartElement {
    private boolean enabled = true;
    private double base = 10.0d;

    enum Property {
        ENABLED,
        BASE
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
        notifyListeners(Property.ENABLED);
    }

    public double getBase() {
        return this.base;
    }

    public void setBase(double d) {
        this.base = d;
        notifyListeners(Property.BASE);
    }
}
