package com.devexpress.dxgrid.appearance.visitors;

import com.devexpress.dxgrid.appearance.GridCellContainerAppearance;
import com.devexpress.dxgrid.appearance.ImageCellContainerAppearance;
import com.devexpress.dxgrid.appearance.SwitchCellContainerAppearance;
import com.devexpress.dxgrid.appearance.TemplateCellContainerAppearance;
import com.devexpress.dxgrid.interfaces.IColumnVisitor;
import com.devexpress.dxgrid.models.appearance.CellAppearance;
import com.devexpress.dxgrid.models.columns.CheckBoxColumnModel;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.models.columns.ImageColumnModel;
import com.devexpress.dxgrid.models.columns.TemplateColumnModel;
import com.devexpress.dxgrid.models.columns.TextColumnModelBase;

/* loaded from: classes.dex */
public class GridCellContainerAppearanceVisitor implements IColumnVisitor {
    private GridCellContainerAppearance appearanceBase;
    private GridCellContainerAppearance resultAppearance;
    private final SwitchCellContainerAppearance switchCellContainerAppearance = new SwitchCellContainerAppearance();
    private final ImageCellContainerAppearance imageCellContainerAppearance = new ImageCellContainerAppearance();
    private final TemplateCellContainerAppearance templateCellContainerAppearance = new TemplateCellContainerAppearance();

    public GridCellContainerAppearance getAppearance() {
        return this.resultAppearance;
    }

    public void setAppearanceBase(GridCellContainerAppearance gridCellContainerAppearance) {
        if (this.appearanceBase != gridCellContainerAppearance) {
            this.appearanceBase = gridCellContainerAppearance;
        }
    }

    @Override // com.devexpress.dxgrid.interfaces.IColumnVisitor
    public void visit(CheckBoxColumnModel checkBoxColumnModel) {
        this.switchCellContainerAppearance.setCellAppearance((CellAppearance) this.appearanceBase);
        this.resultAppearance = this.switchCellContainerAppearance;
    }

    @Override // com.devexpress.dxgrid.interfaces.IColumnVisitor
    public void visit(ImageColumnModel imageColumnModel) {
        this.imageCellContainerAppearance.setCellAppearance((CellAppearance) this.appearanceBase);
        this.resultAppearance = this.imageCellContainerAppearance;
    }

    @Override // com.devexpress.dxgrid.interfaces.IColumnVisitor
    public void visit(TemplateColumnModel templateColumnModel) {
        if (templateColumnModel.isHasDisplayTemplate()) {
            this.templateCellContainerAppearance.setCellAppearance((CellAppearance) this.appearanceBase);
            this.resultAppearance = this.templateCellContainerAppearance;
        } else {
            this.resultAppearance = this.appearanceBase;
        }
    }

    @Override // com.devexpress.dxgrid.interfaces.IColumnVisitor
    public void visit(GridColumnModel gridColumnModel) {
        this.resultAppearance = this.appearanceBase;
    }

    @Override // com.devexpress.dxgrid.interfaces.IColumnVisitor
    public void visit(TextColumnModelBase textColumnModelBase) {
        this.resultAppearance = this.appearanceBase;
    }
}
