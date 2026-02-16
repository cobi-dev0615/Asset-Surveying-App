package com.devexpress.editors.utils;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.devexpress.editors.GestureDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GestureHelper.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/devexpress/editors/utils/GestureHandler;", "", "()V", "lastClickTime", "", "longTapHandled", "", "getLongTapHandled", "()Z", "setLongTapHandled", "(Z)V", "touchEventHandled", "getTouchEventHandled", "setTouchEventHandled", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "delegate", "Lcom/devexpress/editors/GestureDelegate;", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GestureHandler {
    private static final long DOUBLE_TAP_DELAY = ViewConfiguration.getDoubleTapTimeout();
    private long lastClickTime;
    private boolean longTapHandled;
    private boolean touchEventHandled;

    public final boolean getTouchEventHandled() {
        return this.touchEventHandled;
    }

    public final void setTouchEventHandled(boolean z) {
        this.touchEventHandled = z;
    }

    public final boolean getLongTapHandled() {
        return this.longTapHandled;
    }

    public final void setLongTapHandled(boolean z) {
        this.longTapHandled = z;
    }

    public final boolean dispatchTouchEvent(MotionEvent ev, GestureDelegate delegate) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getAction() == 1) {
            if (ev.getEventTime() - this.lastClickTime < DOUBLE_TAP_DELAY) {
                if (delegate != null && !delegate.onDoubleTap()) {
                    this.lastClickTime = ev.getEventTime();
                    return false;
                }
                this.touchEventHandled = true;
                this.lastClickTime = 0L;
            } else if (!this.longTapHandled) {
                if (delegate != null && !delegate.onSingleTapUp()) {
                    this.lastClickTime = ev.getEventTime();
                    return false;
                }
                this.touchEventHandled = true;
            }
            this.lastClickTime = ev.getEventTime();
            return true;
        }
        this.touchEventHandled = false;
        this.longTapHandled = false;
        return false;
    }
}
