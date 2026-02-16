package com.devexpress.dxlistview.layouts;

import android.view.View;

/* loaded from: classes2.dex */
public class LayoutElement {
    private int bottom;
    private int desiredHeight;
    private int desiredWidth;
    private final int index;
    private int left;
    private int right;
    private int top;
    private final View view;
    private final int viewType;

    public LayoutElement(View view, int i, int i2, int i3, int i4) {
        this.view = view;
        this.index = i;
        this.viewType = i2;
        this.desiredWidth = i3;
        this.desiredHeight = i4;
    }

    public boolean getIsVisible() {
        return this.view.getAlpha() > 0.0f;
    }

    public int getLeft() {
        return this.left;
    }

    public int getTop() {
        return this.top;
    }

    public int getRight() {
        return this.right;
    }

    public int getBottom() {
        return this.bottom;
    }

    public int getWidth() {
        return this.right - this.left;
    }

    public int getHeight() {
        return this.bottom - this.top;
    }

    public int getIndex() {
        return this.index;
    }

    public int getViewType() {
        return this.viewType;
    }

    public View getView() {
        return this.view;
    }

    public int getDesiredWidth() {
        return this.desiredWidth;
    }

    public int getDesiredHeight() {
        return this.desiredHeight;
    }

    public boolean contains(int i, int i2) {
        return i >= this.left && i2 >= this.top && i <= this.right && i2 <= this.bottom;
    }

    public void measure(int i, int i2) {
        this.view.measure(i, i2);
        this.desiredWidth = this.view.getMeasuredWidth();
        this.desiredHeight = this.view.getMeasuredHeight();
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
    }

    public void layout(int i, int i2, int i3, int i4, boolean z) {
        setBounds(i, i2, i3, i4);
        if (z) {
            layout();
        }
    }

    public void layout() {
        this.view.layout(this.left, this.top, this.right, this.bottom);
    }
}
