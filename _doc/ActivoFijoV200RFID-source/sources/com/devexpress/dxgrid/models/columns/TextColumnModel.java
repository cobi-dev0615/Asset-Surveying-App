package com.devexpress.dxgrid.models.columns;

import com.devexpress.dxgrid.models.ColumnSortOrder;
import com.devexpress.dxgrid.models.FixedStyle;
import com.devexpress.dxgrid.models.GridLength;
import com.devexpress.dxgrid.models.LineBreakMode;
import com.devexpress.dxgrid.providers.EditViewProvider;
import com.devexpress.dxgrid.providers.TextCellViewProvider;
import com.devexpress.dxgrid.providers.ViewProvider;

/* loaded from: classes.dex */
public class TextColumnModel extends TextColumnModelBase {
    public TextColumnModel(String str, String str2) {
        super(str, str2);
    }

    public TextColumnModel(String str, String str2, GridLength gridLength) {
        super(str, str2, gridLength);
    }

    public TextColumnModel(String str, String str2, GridLength gridLength, ColumnSortOrder columnSortOrder) {
        super(str, str2, gridLength, columnSortOrder);
    }

    @Override // com.devexpress.dxgrid.models.columns.GridColumnModel
    protected ViewProvider createViewProvider() {
        return new TextCellViewProvider();
    }

    @Override // com.devexpress.dxgrid.models.columns.GridColumnModel
    protected EditViewProvider createEditViewProvider() {
        throw new IllegalStateException();
    }

    public TextColumnModel(String str, String str2, GridLength gridLength, ColumnSortOrder columnSortOrder, FixedStyle fixedStyle, LineBreakMode lineBreakMode) {
        super(str, str2, gridLength, columnSortOrder, fixedStyle, lineBreakMode);
    }
}
