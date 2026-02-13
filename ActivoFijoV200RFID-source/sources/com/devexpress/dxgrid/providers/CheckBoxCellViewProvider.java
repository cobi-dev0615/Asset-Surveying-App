package com.devexpress.dxgrid.providers;

import android.content.Context;
import android.view.View;
import com.devexpress.dxgrid.models.appearance.AppearanceBase;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.editors.CheckEdit;
import com.devexpress.editors.DXCheckEditValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckBoxCellViewProvider.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J*\u0010\u0010\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u0015"}, d2 = {"Lcom/devexpress/dxgrid/providers/CheckBoxCellViewProvider;", "Lcom/devexpress/dxgrid/providers/NativeViewProviderBase;", "()V", "requestView", "Landroid/view/View;", "context", "Landroid/content/Context;", "rowIndex", "", "updateAppearance", "", "view", "columnModel", "Lcom/devexpress/dxgrid/models/columns/GridColumnModel;", "customAppearance", "Lcom/devexpress/dxgrid/models/appearance/AppearanceBase;", "updateContent", "dataProvider", "Lcom/devexpress/dxgrid/providers/DataProvider;", "fieldName", "", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CheckBoxCellViewProvider extends NativeViewProviderBase {
    @Override // com.devexpress.dxgrid.providers.ViewProvider
    public View requestView(Context context, int rowIndex) {
        Intrinsics.checkNotNullParameter(context, "context");
        CheckEdit checkEdit = new CheckEdit(context, null, 0, 6, null);
        checkEdit.setClickable(false);
        return checkEdit;
    }

    @Override // com.devexpress.dxgrid.providers.ViewProvider
    public void updateContent(View view, DataProvider dataProvider, String fieldName, int rowIndex) {
        DXCheckEditValue dXCheckEditValue;
        Intrinsics.checkNotNullParameter(dataProvider, "dataProvider");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Object value = dataProvider.getValue(fieldName, rowIndex);
        if (value == null) {
            dXCheckEditValue = DXCheckEditValue.Indeterminate;
        } else {
            dXCheckEditValue = Intrinsics.areEqual(value, (Object) false) ? DXCheckEditValue.Unchecked : DXCheckEditValue.Checked;
        }
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.devexpress.editors.CheckEdit");
        ((CheckEdit) view).setValue(dXCheckEditValue, false);
    }

    @Override // com.devexpress.dxgrid.providers.ViewProvider
    public void updateAppearance(View view, GridColumnModel columnModel, AppearanceBase customAppearance, int rowIndex) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(columnModel, "columnModel");
        if (view instanceof CheckEdit) {
            CheckEdit checkEdit = (CheckEdit) view;
            checkEdit.setCheckBoxColor(columnModel.getCellAppearance().getCheckBoxColor());
            checkEdit.setCheckedCheckBoxColor(columnModel.getCellAppearance().getCheckedCheckBoxColor());
            checkEdit.setCheckboxGravity(columnModel.getGravity());
            checkEdit.setLabelGravity(columnModel.getGravity());
            if (rowIndex == -2147483647) {
                checkEdit.setIntermediateValueUserInputted(true);
            }
        }
    }
}
