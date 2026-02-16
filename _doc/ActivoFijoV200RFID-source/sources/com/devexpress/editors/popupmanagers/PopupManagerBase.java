package com.devexpress.editors.popupmanagers;

import android.content.Context;
import android.view.KeyEvent;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import com.devexpress.editors.DXEditText;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopupManagerBase.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0014JP\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u001526\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\f0\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0014JX\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f26\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\f0\u0019H\u0016JP\u0010 \u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u001526\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\f0\u0019H\u0016J\b\u0010!\u001a\u00020\u0011H\u0014J\u0006\u0010\"\u001a\u00020\u0011J\u0012\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020\fH$R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/devexpress/editors/popupmanagers/PopupManagerBase;", "Lcom/devexpress/editors/DXEditText$KeyDelegate;", "context", "Landroid/content/Context;", "delegate", "Lcom/devexpress/editors/popupmanagers/PopupManagerBaseDelegate;", "(Landroid/content/Context;Lcom/devexpress/editors/popupmanagers/PopupManagerBaseDelegate;)V", "getContext", "()Landroid/content/Context;", "getDelegate", "()Lcom/devexpress/editors/popupmanagers/PopupManagerBaseDelegate;", "isPopupShowing", "", "()Z", "lastKeyCode", "", "dismissPopup", "", "onContentKeyDown", "keyCode", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "onContentKeyUp", "onKeyDown", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "onKeyDownHandled", "onKeyPreIme", "state", "Landroid/view/KeyEvent$DispatcherState;", "onKeyUp", "performCompletion", "showPopup", "checkCanShow", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PopupManagerBase implements DXEditText.KeyDelegate {
    private final Context context;
    private final PopupManagerBaseDelegate delegate;
    private int lastKeyCode;

    public void dismissPopup() {
    }

    public abstract boolean isPopupShowing();

    protected boolean onContentKeyDown(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    protected boolean onContentKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return true;
    }

    protected void onKeyDownHandled() {
    }

    protected abstract void showPopup(boolean checkCanShow);

    public PopupManagerBase(Context context, PopupManagerBaseDelegate delegate) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.context = context;
        this.delegate = delegate;
    }

    protected final Context getContext() {
        return this.context;
    }

    protected PopupManagerBaseDelegate getDelegate() {
        return this.delegate;
    }

    public final void showPopup() {
        showPopup(true);
    }

    public static /* synthetic */ void showPopup$default(PopupManagerBase popupManagerBase, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPopup");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        popupManagerBase.showPopup(z);
    }

    @Override // com.devexpress.editors.DXEditText.KeyDelegate
    public boolean onKeyPreIme(int keyCode, KeyEvent event, KeyEvent.DispatcherState state, Function2<? super Integer, ? super KeyEvent, Boolean> callback) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (keyCode == 4 && isPopupShowing()) {
            if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                state.startTracking(event, this);
                return true;
            }
            if (event.getAction() == 1) {
                state.handleUpEvent(event);
                if (event.isTracking() && !event.isCanceled()) {
                    dismissPopup();
                    return true;
                }
            }
        }
        return callback.invoke(Integer.valueOf(keyCode), event).booleanValue();
    }

    @Override // com.devexpress.editors.DXEditText.KeyDelegate
    public boolean onKeyDown(int keyCode, KeyEvent event, Function2<? super Integer, ? super KeyEvent, Boolean> callback) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (onContentKeyDown(keyCode, event)) {
            return true;
        }
        if (isPopupShowing() && keyCode == 61 && event.hasNoModifiers()) {
            return true;
        }
        this.lastKeyCode = keyCode;
        boolean booleanValue = callback.invoke(Integer.valueOf(keyCode), event).booleanValue();
        this.lastKeyCode = 0;
        if (booleanValue && isPopupShowing()) {
            onKeyDownHandled();
        }
        return booleanValue;
    }

    @Override // com.devexpress.editors.DXEditText.KeyDelegate
    public boolean onKeyUp(int keyCode, KeyEvent event, Function2<? super Integer, ? super KeyEvent, Boolean> callback) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (onContentKeyUp(keyCode, event) && (keyCode == 23 || keyCode == 61 || keyCode == 66)) {
            if (event.hasNoModifiers()) {
                performCompletion();
            }
            return true;
        }
        if (isPopupShowing() && keyCode == 61 && event.hasNoModifiers()) {
            performCompletion();
            return true;
        }
        return callback.invoke(Integer.valueOf(keyCode), event).booleanValue();
    }

    protected void performCompletion() {
        if (isPopupShowing()) {
            dismissPopup();
        }
    }
}
