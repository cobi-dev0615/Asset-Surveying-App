package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class ColorStop {
    private int color;
    private double value1;
    private double value2;

    public ColorStop(int i, double d, double d2) {
        this.color = i;
        this.value1 = d;
        this.value2 = d2;
    }

    int getColor() {
        return this.color;
    }

    double getValue1() {
        return this.value1;
    }

    double getValue2() {
        return this.value2;
    }
}
