package com.devexpress.dxgrid.appearance;

import android.graphics.Rect;
import com.devexpress.dxgrid.models.appearance.CellAppearance;

/* loaded from: classes.dex */
public class ImageCellContainerAppearance extends PaddingCellContainerAppearance {
    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    /* renamed from: getPadding */
    public Rect getNoPadding() {
        return ((CellAppearance) this.appearanceBase).getImagePadding();
    }
}
