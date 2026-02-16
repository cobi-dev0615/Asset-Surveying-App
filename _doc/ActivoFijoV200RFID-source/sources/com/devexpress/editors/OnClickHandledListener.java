package com.devexpress.editors;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnClickHandledListener.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&R(\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/devexpress/editors/OnClickHandledListener;", "Landroid/view/View$OnClickListener;", "()V", "value", "clickListener", "getClickListener", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "onClick", "", "v", "Landroid/view/View;", "onHandledClick", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class OnClickHandledListener implements View.OnClickListener {
    private View.OnClickListener clickListener;

    public abstract boolean onHandledClick(View v);

    @Override // android.view.View.OnClickListener
    public final void onClick(View v) {
        View.OnClickListener onClickListener;
        if (onHandledClick(v) || (onClickListener = this.clickListener) == null) {
            return;
        }
        onClickListener.onClick(v);
    }

    public final View.OnClickListener getClickListener() {
        return this.clickListener;
    }

    public final void setClickListener(View.OnClickListener onClickListener) {
        if (Intrinsics.areEqual(this.clickListener, onClickListener)) {
            return;
        }
        this.clickListener = onClickListener;
    }
}
