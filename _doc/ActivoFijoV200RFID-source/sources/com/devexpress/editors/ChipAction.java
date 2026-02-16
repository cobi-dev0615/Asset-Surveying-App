package com.devexpress.editors;

import kotlin.Metadata;

/* compiled from: ChipAction.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/ChipAction;", "Lcom/devexpress/editors/BaseGestureListener;", "onCloseIconTap", "", "onLayoutChanged", "", "onSingleTapConfirmed", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ChipAction extends BaseGestureListener {
    boolean onCloseIconTap();

    void onLayoutChanged();

    boolean onSingleTapConfirmed();
}
