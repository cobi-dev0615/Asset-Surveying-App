package com.devexpress.dxgrid.appearance.wrappers;

import android.graphics.Rect;
import com.devexpress.dxgrid.appearance.GridCellContainerAppearance;
import com.devexpress.dxgrid.models.appearance.AppearanceBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomGridCellContainerAppearanceWrapper.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/devexpress/dxgrid/appearance/wrappers/CustomGridCellContainerAppearanceWrapper;", "Lcom/devexpress/dxgrid/appearance/GridCellContainerAppearance;", "gridCellContainerAppearance", "customAppearanceBase", "Lcom/devexpress/dxgrid/models/appearance/AppearanceBase;", "(Lcom/devexpress/dxgrid/appearance/GridCellContainerAppearance;Lcom/devexpress/dxgrid/models/appearance/AppearanceBase;)V", "getBackgroundColor", "", "getBorderColor", "getBottomBorderColor", "getFixedColumnSeparatorWidth", "getHorizontalLineThickness", "getPadding", "Landroid/graphics/Rect;", "getSelectionColor", "getVerticalLineThickness", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public class CustomGridCellContainerAppearanceWrapper implements GridCellContainerAppearance {
    private final AppearanceBase customAppearanceBase;
    private final GridCellContainerAppearance gridCellContainerAppearance;

    public CustomGridCellContainerAppearanceWrapper(GridCellContainerAppearance gridCellContainerAppearance, AppearanceBase appearanceBase) {
        Intrinsics.checkNotNullParameter(gridCellContainerAppearance, "gridCellContainerAppearance");
        this.gridCellContainerAppearance = gridCellContainerAppearance;
        this.customAppearanceBase = appearanceBase;
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getBackgroundColor() {
        AppearanceBase appearanceBase = this.customAppearanceBase;
        return appearanceBase != null ? appearanceBase.getBackgroundColor() : this.gridCellContainerAppearance.getBackgroundColor();
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getSelectionColor() {
        AppearanceBase appearanceBase = this.customAppearanceBase;
        return appearanceBase != null ? appearanceBase.getBackgroundColor() : this.gridCellContainerAppearance.getSelectionColor();
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getBorderColor() {
        return this.gridCellContainerAppearance.getBorderColor();
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getBottomBorderColor() {
        return this.gridCellContainerAppearance.getBottomBorderColor();
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getHorizontalLineThickness() {
        return this.gridCellContainerAppearance.getHorizontalLineThickness();
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getVerticalLineThickness() {
        return this.gridCellContainerAppearance.getVerticalLineThickness();
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getFixedColumnSeparatorWidth() {
        return this.gridCellContainerAppearance.getFixedColumnSeparatorWidth();
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    /* renamed from: getPadding */
    public Rect getNoPadding() {
        Rect noPadding = this.gridCellContainerAppearance.getNoPadding();
        Intrinsics.checkNotNullExpressionValue(noPadding, "getPadding(...)");
        return noPadding;
    }
}
