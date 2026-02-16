package com.devexpress.dxgrid.models.columns;

import com.devexpress.dxgrid.models.ColumnSortOrder;
import com.devexpress.dxgrid.models.FixedStyle;
import com.devexpress.dxgrid.models.GridLength;
import com.devexpress.dxgrid.models.LineBreakMode;
import kotlin.Metadata;

/* compiled from: DateTimeColumnModel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001BC\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/devexpress/dxgrid/models/columns/DateTimeColumnModel;", "Lcom/devexpress/dxgrid/models/columns/TextColumnModel;", "filedName", "", "caption", "gridColumnWidth", "Lcom/devexpress/dxgrid/models/GridLength;", "sortOrder", "Lcom/devexpress/dxgrid/models/ColumnSortOrder;", "fixedStyle", "Lcom/devexpress/dxgrid/models/FixedStyle;", "lineBreakMode", "Lcom/devexpress/dxgrid/models/LineBreakMode;", "(Ljava/lang/String;Ljava/lang/String;Lcom/devexpress/dxgrid/models/GridLength;Lcom/devexpress/dxgrid/models/ColumnSortOrder;Lcom/devexpress/dxgrid/models/FixedStyle;Lcom/devexpress/dxgrid/models/LineBreakMode;)V", "getHandleGesturesInternally", "", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DateTimeColumnModel extends TextColumnModel {
    @Override // com.devexpress.dxgrid.models.columns.GridColumnModel
    public boolean getHandleGesturesInternally() {
        return true;
    }

    public DateTimeColumnModel(String str, String str2, GridLength gridLength, ColumnSortOrder columnSortOrder, FixedStyle fixedStyle, LineBreakMode lineBreakMode) {
        super(str, str2, gridLength, columnSortOrder, fixedStyle, lineBreakMode);
    }
}
