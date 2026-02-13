package com.devexpress.dxgrid.models.columns;

import com.devexpress.dxgrid.interfaces.IColumnVisitor;
import com.devexpress.dxgrid.models.ColumnSortOrder;
import com.devexpress.dxgrid.models.ContentAlignment;
import com.devexpress.dxgrid.models.FixedStyle;
import com.devexpress.dxgrid.models.GridLength;
import com.devexpress.dxgrid.models.LineBreakMode;
import com.devexpress.dxgrid.providers.EditViewProvider;
import com.devexpress.dxgrid.providers.TextCellViewProvider;
import com.devexpress.dxgrid.providers.ViewProvider;

/* loaded from: classes.dex */
public class TemplateColumnModel extends TextColumnModelBase {
    private EditViewProvider editViewProvider;
    private boolean hasDisplayTemplate;
    private ViewProvider viewProvider;

    public boolean isHasDisplayTemplate() {
        return this.hasDisplayTemplate;
    }

    public TemplateColumnModel(String str, String str2, GridLength gridLength, ColumnSortOrder columnSortOrder, FixedStyle fixedStyle, LineBreakMode lineBreakMode, ViewProvider viewProvider, EditViewProvider editViewProvider) {
        super(str, str2, gridLength, columnSortOrder, fixedStyle, lineBreakMode);
        this.hasDisplayTemplate = false;
        if (viewProvider != null) {
            this.hasDisplayTemplate = true;
            this.viewProvider = viewProvider;
        } else {
            this.hasDisplayTemplate = false;
            this.viewProvider = new TextCellViewProvider();
        }
        this.editViewProvider = editViewProvider;
    }

    public TemplateColumnModel(String str, String str2, GridLength gridLength, ViewProvider viewProvider, EditViewProvider editViewProvider) {
        super(str, str2, gridLength);
        this.hasDisplayTemplate = false;
        this.viewProvider = viewProvider;
        this.editViewProvider = editViewProvider;
    }

    public TemplateColumnModel(String str, String str2, ViewProvider viewProvider, EditViewProvider editViewProvider) {
        this(str, str2, new GridLength(), viewProvider, editViewProvider);
        this.viewProvider = viewProvider;
    }

    @Override // com.devexpress.dxgrid.models.columns.GridColumnModel
    protected ViewProvider createViewProvider() {
        return this.viewProvider;
    }

    @Override // com.devexpress.dxgrid.models.columns.GridColumnModel
    protected EditViewProvider createEditViewProvider() {
        return this.editViewProvider;
    }

    @Override // com.devexpress.dxgrid.models.columns.TextColumnModelBase, com.devexpress.dxgrid.models.columns.GridColumnModel
    public void accept(IColumnVisitor iColumnVisitor) {
        iColumnVisitor.visit(this);
    }

    @Override // com.devexpress.dxgrid.models.columns.GridColumnModel
    public ContentAlignment getVerticalContentAlignment() {
        return this.hasDisplayTemplate ? ContentAlignment.Stretch : super.getVerticalContentAlignment();
    }

    @Override // com.devexpress.dxgrid.models.columns.GridColumnModel
    public ContentAlignment getHorizontalContentAlignment() {
        return this.hasDisplayTemplate ? ContentAlignment.Stretch : super.getHorizontalContentAlignment();
    }
}
