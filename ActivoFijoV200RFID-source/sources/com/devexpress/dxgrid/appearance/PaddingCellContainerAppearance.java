package com.devexpress.dxgrid.appearance;

import com.devexpress.dxgrid.models.appearance.AppearanceBase;

/* loaded from: classes.dex */
public abstract class PaddingCellContainerAppearance implements GridCellContainerAppearance {
    protected AppearanceBase appearanceBase;

    public void setCellAppearance(AppearanceBase appearanceBase) {
        this.appearanceBase = appearanceBase;
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getBackgroundColor() {
        return this.appearanceBase.getBackgroundColor();
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getSelectionColor() {
        return this.appearanceBase.getSelectionColor();
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getBorderColor() {
        return this.appearanceBase.getBorderColor();
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getBottomBorderColor() {
        return this.appearanceBase.getBottomBorderColor();
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getHorizontalLineThickness() {
        return this.appearanceBase.getHorizontalLineThickness();
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getVerticalLineThickness() {
        return this.appearanceBase.getVerticalLineThickness();
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getFixedColumnSeparatorWidth() {
        return this.appearanceBase.getFixedColumnSeparatorWidth();
    }
}
