package com.devexpress.editors.dataForm.protocols;

import java.util.List;
import kotlin.Metadata;

/* compiled from: DataFormPickerItemDataProvider.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/devexpress/editors/dataForm/protocols/DataFormPickerItemDataProvider;", "", "getPickerDataSource", "", "sourceUpdated", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DataFormPickerItemDataProvider {
    List<Object> getPickerDataSource();

    boolean sourceUpdated();
}
