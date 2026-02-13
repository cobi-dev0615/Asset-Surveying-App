package com.devexpress.dxlistview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.camera.video.AudioStats;
import androidx.core.widget.NestedScrollView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DXVerticalScrollView.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J0\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0014J(\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u001fH\u0014J(\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/devexpress/dxlistview/DXVerticalScrollView;", "Landroidx/core/widget/NestedScrollView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastX", "", "lastY", "pendingScrollY", "getPendingScrollY", "()I", "setPendingScrollY", "(I)V", "scrollView", "Lcom/devexpress/dxlistview/IVirtualScrollView;", "getScrollView", "()Lcom/devexpress/dxlistview/IVirtualScrollView;", "setScrollView", "(Lcom/devexpress/dxlistview/IVirtualScrollView;)V", "xDistance", "yDistance", "fling", "", "velocityY", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onLayout", "changed", "l", "t", "r", "b", "onOverScrolled", "scrollX", "scrollY", "clampedX", "clampedY", "onScrollChanged", "x", "y", "oldX", "oldY", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXVerticalScrollView extends NestedScrollView {
    private float lastX;
    private float lastY;
    private int pendingScrollY;
    private IVirtualScrollView scrollView;
    private float xDistance;
    private float yDistance;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DXVerticalScrollView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pendingScrollY = -1;
        setVerticalScrollBarEnabled(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DXVerticalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pendingScrollY = -1;
        setVerticalScrollBarEnabled(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DXVerticalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pendingScrollY = -1;
        setVerticalScrollBarEnabled(true);
    }

    public final int getPendingScrollY() {
        return this.pendingScrollY;
    }

    public final void setPendingScrollY(int i) {
        this.pendingScrollY = i;
    }

    public final IVirtualScrollView getScrollView() {
        return this.scrollView;
    }

    public final void setScrollView(IVirtualScrollView iVirtualScrollView) {
        this.scrollView = iVirtualScrollView;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    protected void onScrollChanged(int x, int y, int oldX, int oldY) {
        super.onScrollChanged(x, y, oldX, oldY);
        IVirtualScrollView iVirtualScrollView = this.scrollView;
        if (iVirtualScrollView != null) {
            iVirtualScrollView.setContentOffsetY(y);
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        IVirtualScrollView iVirtualScrollView;
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        if (!clampedY || (iVirtualScrollView = this.scrollView) == null) {
            return;
        }
        iVirtualScrollView.overScrolledY(scrollY);
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int i = this.pendingScrollY;
        if (i != -1) {
            setScrollY(i);
            this.pendingScrollY = -1;
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getAction() == 0) {
            this.lastY = ev.getY();
            this.yDistance = 0.0f;
            this.lastX = ev.getX();
            this.xDistance = 0.0f;
        }
        IVirtualScrollView iVirtualScrollView = this.scrollView;
        Intrinsics.checkNotNull(iVirtualScrollView);
        if (iVirtualScrollView.canIntercept(ev) || !super.onInterceptTouchEvent(ev)) {
            return false;
        }
        if (ev.getAction() == 2) {
            this.yDistance = this.lastY - ev.getY();
            this.lastY = ev.getY();
            this.xDistance = this.lastX - ev.getX();
            this.lastX = ev.getX();
        }
        return Math.abs(this.xDistance) <= Math.abs(this.yDistance);
    }

    @Override // androidx.core.widget.NestedScrollView
    public void fling(int velocityY) {
        if (Build.VERSION.SDK_INT != 28) {
            super.fling(velocityY);
            return;
        }
        double signum = Math.signum(this.yDistance);
        if (signum == AudioStats.AUDIO_AMPLITUDE_NONE) {
            signum = Math.signum(velocityY);
        }
        super.fling((int) (Math.abs(velocityY) * signum));
    }
}
