package com.devexpress.dxgrid.models.columns;

import com.devexpress.dxgrid.interfaces.IColumnVisitor;
import com.devexpress.dxgrid.models.ColumnSortOrder;
import com.devexpress.dxgrid.models.FixedStyle;
import com.devexpress.dxgrid.models.GridLength;
import com.devexpress.dxgrid.providers.CheckBoxCellViewProvider;
import com.devexpress.dxgrid.providers.EditViewProvider;
import com.devexpress.dxgrid.providers.ViewProvider;

/* loaded from: classes.dex */
public class CheckBoxColumnModel extends GridColumnModel {
    public CheckBoxColumnModel(String str, String str2) {
        super(str, str2);
    }

    public CheckBoxColumnModel(String str, String str2, GridLength gridLength) {
        super(str, str2, gridLength);
    }

    public CheckBoxColumnModel(String str, String str2, GridLength gridLength, ColumnSortOrder columnSortOrder) {
        super(str, str2, gridLength, columnSortOrder);
    }

    public CheckBoxColumnModel(String str, String str2, GridLength gridLength, ColumnSortOrder columnSortOrder, FixedStyle fixedStyle) {
        super(str, str2, gridLength, columnSortOrder, fixedStyle);
    }

    @Override // com.devexpress.dxgrid.models.columns.GridColumnModel
    protected ViewProvider createViewProvider() {
        return new CheckBoxCellViewProvider();
    }

    @Override // com.devexpress.dxgrid.models.columns.GridColumnModel
    protected EditViewProvider createEditViewProvider() {
        throw new IllegalStateException();
    }

    @Override // com.devexpress.dxgrid.models.columns.GridColumnModel
    public void accept(IColumnVisitor iColumnVisitor) {
        iColumnVisitor.visit(this);
    }
}
