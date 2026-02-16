package com.devexpress.dxgrid.models.columns;

import com.devexpress.dxgrid.interfaces.IColumnVisitor;
import com.devexpress.dxgrid.models.ColumnSortOrder;
import com.devexpress.dxgrid.models.FixedStyle;
import com.devexpress.dxgrid.models.GridLength;
import com.devexpress.dxgrid.models.LineBreakMode;

/* loaded from: classes.dex */
public abstract class TextColumnModelBase extends GridColumnModel {
    private LineBreakMode lineBreakMode;

    protected TextColumnModelBase(String str, String str2) {
        super(str, str2);
        this.lineBreakMode = LineBreakMode.WordWrap;
    }

    protected TextColumnModelBase(String str, String str2, GridLength gridLength) {
        super(str, str2, gridLength);
        this.lineBreakMode = LineBreakMode.WordWrap;
    }

    protected TextColumnModelBase(String str, String str2, GridLength gridLength, ColumnSortOrder columnSortOrder) {
        super(str, str2, gridLength, columnSortOrder);
        this.lineBreakMode = LineBreakMode.WordWrap;
    }

    protected TextColumnModelBase(String str, String str2, GridLength gridLength, ColumnSortOrder columnSortOrder, FixedStyle fixedStyle, LineBreakMode lineBreakMode) {
        super(str, str2, gridLength, columnSortOrder, fixedStyle);
        LineBreakMode lineBreakMode2 = LineBreakMode.WordWrap;
        this.lineBreakMode = lineBreakMode;
    }

    public LineBreakMode getLineBreakMode() {
        return this.lineBreakMode;
    }

    public void setLineBreakMode(LineBreakMode lineBreakMode) {
        this.lineBreakMode = lineBreakMode;
    }

    @Override // com.devexpress.dxgrid.models.columns.GridColumnModel
    public void accept(IColumnVisitor iColumnVisitor) {
        iColumnVisitor.visit(this);
    }
}
