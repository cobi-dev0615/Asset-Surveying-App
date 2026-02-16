package com.devexpress.dxgrid.appearance.visitors;

import com.devexpress.dxgrid.appearance.GridTextAppearance;
import com.devexpress.dxgrid.appearance.GridTextColumnTextAppearance;
import com.devexpress.dxgrid.interfaces.IColumnVisitor;
import com.devexpress.dxgrid.models.columns.CheckBoxColumnModel;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.models.columns.ImageColumnModel;
import com.devexpress.dxgrid.models.columns.TemplateColumnModel;
import com.devexpress.dxgrid.models.columns.TextColumnModelBase;

/* loaded from: classes.dex */
public class GridTextAppearanceVisitor implements IColumnVisitor {
    private GridTextAppearance gridTextAppearance;
    private final GridTextColumnTextAppearance gridTextColumnTextAppearance = new GridTextColumnTextAppearance();
    private GridTextAppearance resultTextAppearance;

    public GridTextAppearance getTextAppearance() {
        return this.resultTextAppearance;
    }

    public void setTextAppearance(GridTextAppearance gridTextAppearance) {
        this.gridTextAppearance = gridTextAppearance;
    }

    @Override // com.devexpress.dxgrid.interfaces.IColumnVisitor
    public void visit(CheckBoxColumnModel checkBoxColumnModel) {
        this.resultTextAppearance = this.gridTextAppearance;
    }

    @Override // com.devexpress.dxgrid.interfaces.IColumnVisitor
    public void visit(ImageColumnModel imageColumnModel) {
        this.resultTextAppearance = this.gridTextAppearance;
    }

    @Override // com.devexpress.dxgrid.interfaces.IColumnVisitor
    public void visit(TemplateColumnModel templateColumnModel) {
        this.resultTextAppearance = this.gridTextAppearance;
    }

    @Override // com.devexpress.dxgrid.interfaces.IColumnVisitor
    public void visit(GridColumnModel gridColumnModel) {
        this.resultTextAppearance = this.gridTextAppearance;
    }

    @Override // com.devexpress.dxgrid.interfaces.IColumnVisitor
    public void visit(TextColumnModelBase textColumnModelBase) {
        this.gridTextColumnTextAppearance.initialize(this.gridTextAppearance, textColumnModelBase);
        this.resultTextAppearance = this.gridTextColumnTextAppearance;
    }
}
