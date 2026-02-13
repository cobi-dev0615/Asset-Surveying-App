package com.devexpress.dxcharts;

/* compiled from: Legend.java */
/* loaded from: classes.dex */
class LegendItemInfo {
    private LegendItem item;
    private int offsetX;
    private int offsetY;
    private TextSize textSize;

    LegendItemInfo(TextSize textSize, LegendItem legendItem) {
        this.textSize = textSize;
        this.item = legendItem;
    }

    LegendItem getItem() {
        return this.item;
    }

    TextSize getTextSize() {
        return this.textSize;
    }

    public int getOffsetX() {
        return this.offsetX;
    }

    public int getOffsetY() {
        return this.offsetY;
    }

    public void setOffsetX(int i) {
        this.offsetX = i;
    }

    public void setOffsetY(int i) {
        this.offsetY = i;
    }
}
