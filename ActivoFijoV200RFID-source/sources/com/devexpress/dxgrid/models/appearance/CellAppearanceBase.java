package com.devexpress.dxgrid.models.appearance;

/* loaded from: classes.dex */
public class CellAppearanceBase extends AppearanceBase {
    private int verticalLineThickness = 2;
    private int fixedColumnSeparatorWidth = 3;

    @Override // com.devexpress.dxgrid.models.appearance.AppearanceBase, com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getVerticalLineThickness() {
        return this.verticalLineThickness;
    }

    public void setVerticalLineThickness(int i) {
        this.verticalLineThickness = i;
    }

    @Override // com.devexpress.dxgrid.models.appearance.AppearanceBase, com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getFixedColumnSeparatorWidth() {
        return this.fixedColumnSeparatorWidth;
    }

    public void setFixedColumnSeparatorWidth(int i) {
        this.fixedColumnSeparatorWidth = i;
    }
}
