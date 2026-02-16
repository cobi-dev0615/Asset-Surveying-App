package com.devexpress.dxcharts;

/* loaded from: classes.dex */
final class TextSize {
    private double mOverline;
    private double mUnderline;
    private double mWidth;

    public TextSize(double d, double d2, double d3) {
        this.mWidth = d;
        this.mOverline = d2;
        this.mUnderline = d3;
    }

    public double getOverline() {
        return this.mOverline;
    }

    public double getWidth() {
        return this.mWidth;
    }

    public double getUnderline() {
        return this.mUnderline;
    }

    public double getHeight() {
        return Math.abs(this.mOverline) + Math.abs(this.mUnderline * 2.0d);
    }
}
