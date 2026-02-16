package com.devexpress.dxcharts;

/* compiled from: Legend.java */
/* loaded from: classes.dex */
class LegendItem {
    private int color;
    private int color2;
    private int pointIndex;
    private int seriesIndex;
    private String text;

    LegendItem(String str, int i, int i2, int i3, int i4) {
        this.text = str;
        this.color = i;
        this.color2 = i2;
        this.seriesIndex = i3;
        this.pointIndex = i4;
    }

    int getColor() {
        return this.color;
    }

    int getColor2() {
        return this.color2;
    }

    int getPointIndex() {
        return this.pointIndex;
    }

    int getSeriesIndex() {
        return this.seriesIndex;
    }

    String getText() {
        return this.text;
    }
}
