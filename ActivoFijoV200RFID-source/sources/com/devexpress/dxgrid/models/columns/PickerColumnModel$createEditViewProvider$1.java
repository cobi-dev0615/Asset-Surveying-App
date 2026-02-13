package com.devexpress.dxgrid.models.columns;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.NumberPicker;
import androidx.appcompat.app.AlertDialog;
import com.devexpress.dxgrid.appearance.wrappers.CustomGridTextAppearanceWrapper;
import com.devexpress.dxgrid.models.appearance.AppearanceBase;
import com.devexpress.dxgrid.models.appearance.CellAppearance;
import com.devexpress.dxgrid.providers.EditViewProvider;
import com.devexpress.dxgrid.providers.PickerDataProvider;
import com.devexpress.dxgrid.providers.TextCellViewProvider;
import com.devexpress.editors.DisplayEdit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PickerColumnModel.kt */
@Metadata(d1 = {"\u0000Y\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u001a\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u000f\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u001a\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"com/devexpress/dxgrid/models/columns/PickerColumnModel$createEditViewProvider$1", "Lcom/devexpress/dxgrid/providers/EditViewProvider;", "alertDialog", "Landroidx/appcompat/app/AlertDialog;", "autoFilterAlertDialog", "autoFilterNumberPicker", "Landroid/widget/NumberPicker;", "autoFilterValue", "", "autoFilterView", "Lcom/devexpress/editors/DisplayEdit;", "hasChanges", "", "numberPicker", "value", "view", "getEditableView", "Landroid/view/View;", "context", "Landroid/content/Context;", "rowIndex", "isPaddingInEditor", "open", "", "tapInCell", "setRequestUpdateRunnable", "requestUpdateRunnable", "Ljava/lang/Runnable;", "submitEditValue", "", "updateAppearance", "appearance", "Lcom/devexpress/dxgrid/models/appearance/AppearanceBase;", "updateContent", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PickerColumnModel$createEditViewProvider$1 implements EditViewProvider {
    private AlertDialog alertDialog;
    private AlertDialog autoFilterAlertDialog;
    private NumberPicker autoFilterNumberPicker;
    private int autoFilterValue;
    private DisplayEdit autoFilterView;
    private boolean hasChanges;
    private NumberPicker numberPicker;
    final /* synthetic */ PickerColumnModel this$0;
    private int value;
    private DisplayEdit view;

    @Override // com.devexpress.dxgrid.providers.EditViewProvider
    public boolean isPaddingInEditor() {
        return false;
    }

    @Override // com.devexpress.dxgrid.providers.EditViewProvider
    public void setRequestUpdateRunnable(Runnable requestUpdateRunnable, int rowIndex) {
    }

    PickerColumnModel$createEditViewProvider$1(PickerColumnModel pickerColumnModel) {
        this.this$0 = pickerColumnModel;
    }

    @Override // com.devexpress.dxgrid.providers.EditViewProvider
    public View getEditableView(Context context, final int rowIndex) {
        PickerDataProvider pickerDataProvider;
        PickerDataProvider pickerDataProvider2;
        Intrinsics.checkNotNullParameter(context, "context");
        pickerDataProvider = this.this$0.pickerDataProvider;
        int itemCount = pickerDataProvider.getItemCount(rowIndex);
        final String[] strArr = new String[itemCount];
        for (int i = 0; i < itemCount; i++) {
            pickerDataProvider2 = this.this$0.pickerDataProvider;
            strArr[i] = pickerDataProvider2.getText(i, rowIndex);
        }
        DisplayEdit displayEdit = new DisplayEdit(context, null, 0, 6, null);
        final AlertDialog create = new AlertDialog.Builder(context).create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        final NumberPicker numberPicker = new NumberPicker(context);
        if (rowIndex == -2147483647) {
            this.autoFilterView = displayEdit;
            displayEdit.setOnClickListener(new View.OnClickListener() { // from class: com.devexpress.dxgrid.models.columns.PickerColumnModel$createEditViewProvider$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PickerColumnModel$createEditViewProvider$1.getEditableView$lambda$0(PickerColumnModel$createEditViewProvider$1.this, view);
                }
            });
            this.autoFilterAlertDialog = create;
            this.autoFilterNumberPicker = numberPicker;
            this.this$0.autoFilterDisplayValues = strArr;
        } else {
            this.view = displayEdit;
            this.alertDialog = create;
            this.numberPicker = numberPicker;
            this.this$0.displayValues = strArr;
        }
        create.setTitle(this.this$0.getCaption());
        create.setView(numberPicker);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(itemCount - 1);
        numberPicker.setDisplayedValues(strArr);
        numberPicker.setDescendantFocusability(393216);
        numberPicker.setWrapSelectorWheel(false);
        if (rowIndex == -2147483647) {
            CharSequence text = context.getText(R.string.ok);
            final PickerColumnModel pickerColumnModel = this.this$0;
            create.setButton(-1, text, new DialogInterface.OnClickListener() { // from class: com.devexpress.dxgrid.models.columns.PickerColumnModel$createEditViewProvider$1$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    PickerColumnModel$createEditViewProvider$1.getEditableView$lambda$1(PickerColumnModel$createEditViewProvider$1.this, pickerColumnModel, rowIndex, dialogInterface, i2);
                }
            });
        } else {
            CharSequence text2 = context.getText(R.string.ok);
            final PickerColumnModel pickerColumnModel2 = this.this$0;
            create.setButton(-1, text2, new DialogInterface.OnClickListener() { // from class: com.devexpress.dxgrid.models.columns.PickerColumnModel$createEditViewProvider$1$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    PickerColumnModel$createEditViewProvider$1.getEditableView$lambda$2(PickerColumnModel$createEditViewProvider$1.this, numberPicker, strArr, pickerColumnModel2, dialogInterface, i2);
                }
            });
        }
        create.setButton(-2, context.getText(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.devexpress.dxgrid.models.columns.PickerColumnModel$createEditViewProvider$1$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                PickerColumnModel$createEditViewProvider$1.getEditableView$lambda$3(AlertDialog.this, dialogInterface, i2);
            }
        });
        return displayEdit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getEditableView$lambda$0(PickerColumnModel$createEditViewProvider$1 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AlertDialog alertDialog = this$0.autoFilterAlertDialog;
        if (alertDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoFilterAlertDialog");
            alertDialog = null;
        }
        alertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getEditableView$lambda$1(PickerColumnModel$createEditViewProvider$1 this$0, PickerColumnModel this$1, int i, DialogInterface dialogInterface, int i2) {
        String[] strArr;
        PickerDataProvider pickerDataProvider;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        NumberPicker numberPicker = this$0.autoFilterNumberPicker;
        String[] strArr2 = null;
        if (numberPicker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoFilterNumberPicker");
            numberPicker = null;
        }
        this$0.autoFilterValue = numberPicker.getValue();
        DisplayEdit displayEdit = this$0.autoFilterView;
        if (displayEdit == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoFilterView");
            displayEdit = null;
        }
        strArr = this$1.autoFilterDisplayValues;
        if (strArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoFilterDisplayValues");
        } else {
            strArr2 = strArr;
        }
        displayEdit.setText(String.valueOf(strArr2[this$0.autoFilterValue]));
        pickerDataProvider = this$1.pickerDataProvider;
        pickerDataProvider.setItemIndex(this$0.autoFilterValue, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getEditableView$lambda$2(PickerColumnModel$createEditViewProvider$1 this$0, NumberPicker numberPicker, String[] displayValues, PickerColumnModel this$1, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(numberPicker, "$numberPicker");
        Intrinsics.checkNotNullParameter(displayValues, "$displayValues");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        this$0.hasChanges = true;
        this$0.value = numberPicker.getValue();
        DisplayEdit displayEdit = this$0.view;
        if (displayEdit == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            displayEdit = null;
        }
        displayEdit.setText(String.valueOf(displayValues[this$0.value]));
        this$1.getInplaceEditor().requestUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getEditableView$lambda$3(AlertDialog alertDialog, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(alertDialog, "$alertDialog");
        alertDialog.dismiss();
    }

    @Override // com.devexpress.dxgrid.providers.EditViewProvider
    public void updateAppearance(AppearanceBase appearance, int rowIndex) {
        TextCellViewProvider.Companion companion = TextCellViewProvider.INSTANCE;
        DisplayEdit displayEdit = this.view;
        DisplayEdit displayEdit2 = null;
        if (displayEdit == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            displayEdit = null;
        }
        Intrinsics.checkNotNull(appearance);
        companion.updateAppearance(displayEdit, appearance);
        DisplayEdit displayEdit3 = this.view;
        if (displayEdit3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
        } else {
            displayEdit2 = displayEdit3;
        }
        displayEdit2.setTextGravity(3);
    }

    @Override // com.devexpress.dxgrid.providers.EditViewProvider
    public String submitEditValue(View view, int rowIndex) {
        PickerDataProvider pickerDataProvider;
        Intrinsics.checkNotNullParameter(view, "view");
        if (rowIndex == -2147483647 || !this.hasChanges) {
            return null;
        }
        pickerDataProvider = this.this$0.pickerDataProvider;
        return pickerDataProvider.setItemIndex(this.value, rowIndex);
    }

    @Override // com.devexpress.dxgrid.providers.EditViewProvider
    public void updateAppearance(int rowIndex) {
        DisplayEdit displayEdit;
        String str;
        DisplayEdit displayEdit2 = null;
        if (rowIndex == -2147483647) {
            displayEdit = this.autoFilterView;
            if (displayEdit == null) {
                str = "autoFilterView";
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            displayEdit2 = displayEdit;
        } else {
            displayEdit = this.view;
            if (displayEdit == null) {
                str = "view";
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            displayEdit2 = displayEdit;
        }
        CellAppearance cellAppearance = this.this$0.getCellAppearance();
        Intrinsics.checkNotNullExpressionValue(cellAppearance, "getCellAppearance(...)");
        TextCellViewProvider.INSTANCE.updateAppearance(displayEdit2, new CustomGridTextAppearanceWrapper(cellAppearance, this.this$0.getCustomAppearanceProvider().getCustomAppearance(rowIndex)));
        displayEdit2.setTextGravity(this.this$0.getGravity());
    }

    @Override // com.devexpress.dxgrid.providers.EditViewProvider
    public void updateContent(int rowIndex) {
        PickerDataProvider pickerDataProvider;
        String[] strArr;
        PickerDataProvider pickerDataProvider2;
        String[] strArr2;
        String[] strArr3 = null;
        if (rowIndex == -2147483647) {
            pickerDataProvider2 = this.this$0.pickerDataProvider;
            this.autoFilterValue = pickerDataProvider2.getItemIndex(rowIndex);
            DisplayEdit displayEdit = this.autoFilterView;
            if (displayEdit == null) {
                Intrinsics.throwUninitializedPropertyAccessException("autoFilterView");
                displayEdit = null;
            }
            strArr2 = this.this$0.autoFilterDisplayValues;
            if (strArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("autoFilterDisplayValues");
            } else {
                strArr3 = strArr2;
            }
            displayEdit.setText(String.valueOf(strArr3[this.autoFilterValue]));
            return;
        }
        pickerDataProvider = this.this$0.pickerDataProvider;
        this.value = pickerDataProvider.getItemIndex(rowIndex);
        DisplayEdit displayEdit2 = this.view;
        if (displayEdit2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            displayEdit2 = null;
        }
        strArr = this.this$0.displayValues;
        if (strArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("displayValues");
        } else {
            strArr3 = strArr;
        }
        displayEdit2.setText(String.valueOf(strArr3[this.value]));
    }

    @Override // com.devexpress.dxgrid.providers.EditViewProvider
    public void open(boolean tapInCell, int rowIndex) {
        View cell = this.this$0.getInplaceEditor().getInplaceEditorContainer().getCell();
        Intrinsics.checkNotNull(cell, "null cannot be cast to non-null type com.devexpress.editors.DisplayEdit");
        ((DisplayEdit) cell).setTextGravity(this.this$0.getGravity());
        AlertDialog alertDialog = null;
        if (rowIndex == -2147483647) {
            NumberPicker numberPicker = this.autoFilterNumberPicker;
            if (numberPicker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("autoFilterNumberPicker");
                numberPicker = null;
            }
            numberPicker.setValue(this.autoFilterValue);
            AlertDialog alertDialog2 = this.autoFilterAlertDialog;
            if (alertDialog2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("autoFilterAlertDialog");
            } else {
                alertDialog = alertDialog2;
            }
            alertDialog.show();
            return;
        }
        NumberPicker numberPicker2 = this.numberPicker;
        if (numberPicker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numberPicker");
            numberPicker2 = null;
        }
        numberPicker2.setValue(this.value);
        AlertDialog alertDialog3 = this.alertDialog;
        if (alertDialog3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("alertDialog");
        } else {
            alertDialog = alertDialog3;
        }
        alertDialog.show();
    }
}
