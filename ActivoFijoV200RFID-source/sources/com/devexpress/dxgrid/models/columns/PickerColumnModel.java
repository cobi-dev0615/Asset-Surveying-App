package com.devexpress.dxgrid.models.columns;

import com.devexpress.dxgrid.models.ColumnSortOrder;
import com.devexpress.dxgrid.models.FixedStyle;
import com.devexpress.dxgrid.models.GridLength;
import com.devexpress.dxgrid.models.LineBreakMode;
import com.devexpress.dxgrid.providers.EditViewProvider;
import com.devexpress.dxgrid.providers.PickerDataProvider;
import com.devexpress.dxgrid.providers.TextCellViewProvider;
import com.devexpress.dxgrid.providers.ViewProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PickerColumnModel.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0011X\u0082.¢\u0006\u0004\n\u0002\u0010\u0012R\u0018\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0011X\u0082.¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/devexpress/dxgrid/models/columns/PickerColumnModel;", "Lcom/devexpress/dxgrid/models/columns/TextColumnModelBase;", "fieldName", "", "caption", "gridColumnWidth", "Lcom/devexpress/dxgrid/models/GridLength;", "sortOrder", "Lcom/devexpress/dxgrid/models/ColumnSortOrder;", "fixedStyle", "Lcom/devexpress/dxgrid/models/FixedStyle;", "pickerDataProvider", "Lcom/devexpress/dxgrid/providers/PickerDataProvider;", "lineBreakMode", "Lcom/devexpress/dxgrid/models/LineBreakMode;", "(Ljava/lang/String;Ljava/lang/String;Lcom/devexpress/dxgrid/models/GridLength;Lcom/devexpress/dxgrid/models/ColumnSortOrder;Lcom/devexpress/dxgrid/models/FixedStyle;Lcom/devexpress/dxgrid/providers/PickerDataProvider;Lcom/devexpress/dxgrid/models/LineBreakMode;)V", "autoFilterDisplayValues", "", "[Ljava/lang/String;", "displayValues", "createEditViewProvider", "Lcom/devexpress/dxgrid/providers/EditViewProvider;", "createViewProvider", "Lcom/devexpress/dxgrid/providers/ViewProvider;", "getHandleGesturesInternally", "", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PickerColumnModel extends TextColumnModelBase {
    private String[] autoFilterDisplayValues;
    private String[] displayValues;
    private final PickerDataProvider pickerDataProvider;

    @Override // com.devexpress.dxgrid.models.columns.GridColumnModel
    public boolean getHandleGesturesInternally() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickerColumnModel(String fieldName, String caption, GridLength gridColumnWidth, ColumnSortOrder sortOrder, FixedStyle fixedStyle, PickerDataProvider pickerDataProvider, LineBreakMode lineBreakMode) {
        super(fieldName, caption, gridColumnWidth, sortOrder, fixedStyle, lineBreakMode);
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(gridColumnWidth, "gridColumnWidth");
        Intrinsics.checkNotNullParameter(sortOrder, "sortOrder");
        Intrinsics.checkNotNullParameter(fixedStyle, "fixedStyle");
        Intrinsics.checkNotNullParameter(pickerDataProvider, "pickerDataProvider");
        Intrinsics.checkNotNullParameter(lineBreakMode, "lineBreakMode");
        this.pickerDataProvider = pickerDataProvider;
    }

    @Override // com.devexpress.dxgrid.models.columns.GridColumnModel
    protected ViewProvider createViewProvider() {
        return new TextCellViewProvider();
    }

    @Override // com.devexpress.dxgrid.models.columns.GridColumnModel
    protected EditViewProvider createEditViewProvider() {
        return new PickerColumnModel$createEditViewProvider$1(this);
    }
}
