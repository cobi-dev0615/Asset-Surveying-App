package com.devexpress.dxgrid.models.appearance;

import android.graphics.Rect;

/* loaded from: classes.dex */
public class CellAppearance extends CellAppearanceBase {
    private Rect imagePadding = new Rect();
    private Rect switchPadding = new Rect();

    public Rect getImagePadding() {
        return this.imagePadding;
    }

    public void setImagePadding(Rect rect) {
        this.imagePadding = rect;
    }

    public Rect getSwitchPadding() {
        return this.switchPadding;
    }

    public void setSwitchPadding(Rect rect) {
        this.switchPadding = rect;
    }
}
