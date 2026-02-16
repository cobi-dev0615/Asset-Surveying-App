package com.devexpress.dxlistview.layouts;

/* loaded from: classes2.dex */
public final class LayoutAnchor {
    public int offset;
    public int position;
    public int startVisibleIndex;

    public LayoutAnchor(int i, int i2, int i3) {
        this.offset = i;
        this.position = i2;
        this.startVisibleIndex = i3;
    }

    public void set(int i, int i2, int i3) {
        this.offset = i;
        this.position = i2;
        this.startVisibleIndex = i3;
    }
}
