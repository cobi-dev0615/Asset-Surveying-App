package com.devexpress.dxgrid.interfaces;

import com.devexpress.dxgrid.models.columns.CheckBoxColumnModel;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.models.columns.ImageColumnModel;
import com.devexpress.dxgrid.models.columns.TemplateColumnModel;
import com.devexpress.dxgrid.models.columns.TextColumnModelBase;

/* loaded from: classes.dex */
public interface IColumnVisitor {
    void visit(CheckBoxColumnModel checkBoxColumnModel);

    void visit(GridColumnModel gridColumnModel);

    void visit(ImageColumnModel imageColumnModel);

    void visit(TemplateColumnModel templateColumnModel);

    void visit(TextColumnModelBase textColumnModelBase);
}
