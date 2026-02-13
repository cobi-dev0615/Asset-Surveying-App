package com.devexpress.editors.popupmanagers;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopupManagerBaseDelegate.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/devexpress/editors/popupmanagers/PopupManagerBaseDelegate;", "", "isVisible", "", "()Z", TypedValues.AttributesType.S_TARGET, "Landroid/view/View;", "getTarget", "()Landroid/view/View;", "onDismissPopup", "", "manager", "Lcom/devexpress/editors/popupmanagers/PopupManagerBase;", "onShowPopup", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PopupManagerBaseDelegate {

    /* compiled from: PopupManagerBaseDelegate.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onDismissPopup(PopupManagerBaseDelegate popupManagerBaseDelegate, PopupManagerBase manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
        }

        public static void onShowPopup(PopupManagerBaseDelegate popupManagerBaseDelegate, PopupManagerBase manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
        }
    }

    View getTarget();

    boolean isVisible();

    void onDismissPopup(PopupManagerBase manager);

    void onShowPopup(PopupManagerBase manager);
}
