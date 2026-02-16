package com.devexpress.editors;

import kotlin.Metadata;

/* compiled from: OnDataFromChangedListener.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/devexpress/editors/OnDataFromChangedListener;", "", "groupCollapseChanged", "", "groupId", "", "isCollapsed", "", "sizeChanged", "dataFormView", "Lcom/devexpress/editors/DataFormView;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface OnDataFromChangedListener {
    void groupCollapseChanged(int groupId, boolean isCollapsed);

    void sizeChanged(DataFormView dataFormView);
}
