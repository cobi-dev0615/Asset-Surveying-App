package com.devexpress.editors;

import android.text.TextWatcher;
import kotlin.Metadata;

/* compiled from: DXEditTextChangedWatcher.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/devexpress/editors/DXEditTextChangedWatcher;", "Landroid/text/TextWatcher;", "onBeginBatchEdit", "", "onSelectionChanged", "selStart", "", "selEnd", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DXEditTextChangedWatcher extends TextWatcher {
    void onBeginBatchEdit();

    void onSelectionChanged(int selStart, int selEnd);
}
