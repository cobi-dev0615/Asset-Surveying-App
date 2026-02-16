package com.devexpress.dxgrid.appearance;

import android.graphics.Rect;

/* loaded from: classes.dex */
public class TemplateCellContainerAppearance extends PaddingCellContainerAppearance {
    private final Rect rect = new Rect();

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    /* renamed from: getPadding */
    public Rect getNoPadding() {
        return this.rect;
    }
}
