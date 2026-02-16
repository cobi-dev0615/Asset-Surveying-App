package com.devexpress.dxgrid.models.appearance;

import com.devexpress.dxgrid.models.ContentAlignment;

/* loaded from: classes.dex */
public class SwipeAppearance extends AppearanceBase {
    private int width = 100;
    private ContentAlignment contentAlignment = ContentAlignment.Center;

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public ContentAlignment getContentAlignment() {
        return this.contentAlignment;
    }

    public void setContentAlignment(ContentAlignment contentAlignment) {
        this.contentAlignment = contentAlignment;
    }
}
