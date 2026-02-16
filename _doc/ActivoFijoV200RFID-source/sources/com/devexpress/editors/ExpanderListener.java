package com.devexpress.editors;

import android.view.View;
import com.devexpress.editors.dataForm.ExpanderView;
import kotlin.Metadata;

/* compiled from: OnDataFromChangedListener.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/devexpress/editors/ExpanderListener;", "", "contentSizeChanged", "", "content", "Landroid/view/View;", "isExpanderCollapsed", "expander", "Lcom/devexpress/editors/dataForm/ExpanderView;", "isCollapsed", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ExpanderListener {
    void contentSizeChanged(View content);

    void isExpanderCollapsed(ExpanderView expander, boolean isCollapsed);
}
