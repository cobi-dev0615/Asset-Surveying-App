package com.devexpress.editors.dataForm.protocols;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataFormPickerItem.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/devexpress/editors/dataForm/protocols/DataFormPickerItem;", "", "setPickerDataProvider", "", "pickerItemProvider", "Lcom/devexpress/editors/dataForm/protocols/DataFormPickerItemDataProvider;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DataFormPickerItem {

    /* compiled from: DataFormPickerItem.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void setPickerDataProvider(DataFormPickerItem dataFormPickerItem, DataFormPickerItemDataProvider pickerItemProvider) {
            Intrinsics.checkNotNullParameter(pickerItemProvider, "pickerItemProvider");
        }
    }

    void setPickerDataProvider(DataFormPickerItemDataProvider pickerItemProvider);
}
