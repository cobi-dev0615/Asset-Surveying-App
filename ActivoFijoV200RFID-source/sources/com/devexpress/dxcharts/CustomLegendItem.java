package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class CustomLegendItem extends CustomLegendItemBase {
    private int color1;
    private int color2;
    private String text;

    public CustomLegendItem(String str, int i, int i2) {
        this.text = str;
        this.color1 = i;
        this.color2 = i2;
    }

    public CustomLegendItem(String str, int i) {
        this.text = str;
        this.color1 = i;
        this.color2 = i;
    }

    public String getText() {
        return this.text;
    }

    public int getColor1() {
        return this.color1;
    }

    public int getColor2() {
        return this.color2;
    }
}
