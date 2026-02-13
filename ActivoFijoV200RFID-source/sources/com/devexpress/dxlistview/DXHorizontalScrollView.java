package com.devexpress.dxlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DXHorizontalScrollView.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u000fH\u0003J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J0\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0014J(\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\"H\u0014J(\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/devexpress/dxlistview/DXHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastX", "", "lastY", "mScroller", "Landroid/widget/OverScroller;", "pendingScrollX", "getPendingScrollX", "()I", "setPendingScrollX", "(I)V", "scrollView", "Lcom/devexpress/dxlistview/IVirtualScrollView;", "getScrollView", "()Lcom/devexpress/dxlistview/IVirtualScrollView;", "setScrollView", "(Lcom/devexpress/dxlistview/IVirtualScrollView;)V", "xDistance", "yDistance", "fling", "", "velocityX", "getOverScroller", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onLayout", "changed", "l", "t", "r", "b", "onOverScrolled", "scrollX", "scrollY", "clampedX", "clampedY", "onScrollChanged", "x", "y", "oldX", "oldY", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXHorizontalScrollView extends HorizontalScrollView {
    private float lastX;
    private float lastY;
    private OverScroller mScroller;
    private int pendingScrollX;
    private IVirtualScrollView scrollView;
    private float xDistance;
    private float yDistance;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DXHorizontalScrollView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pendingScrollX = -1;
        setHorizontalScrollBarEnabled(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DXHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pendingScrollX = -1;
        setHorizontalScrollBarEnabled(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DXHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pendingScrollX = -1;
        setHorizontalScrollBarEnabled(true);
    }

    public final IVirtualScrollView getScrollView() {
        return this.scrollView;
    }

    public final void setScrollView(IVirtualScrollView iVirtualScrollView) {
        this.scrollView = iVirtualScrollView;
    }

    public final int getPendingScrollX() {
        return this.pendingScrollX;
    }

    public final void setPendingScrollX(int i) {
        this.pendingScrollX = i;
    }

    @Override // android.view.View
    protected void onScrollChanged(int x, int y, int oldX, int oldY) {
        super.onScrollChanged(x, y, oldX, oldY);
        IVirtualScrollView iVirtualScrollView = this.scrollView;
        if (iVirtualScrollView != null) {
            iVirtualScrollView.setContentOffsetX(x);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        IVirtualScrollView iVirtualScrollView;
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        if (!clampedX || (iVirtualScrollView = this.scrollView) == null) {
            return;
        }
        iVirtualScrollView.overScrolledX(scrollX);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int i = this.pendingScrollX;
        if (i != -1) {
            setScrollX(i);
            this.pendingScrollX = -1;
        }
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int velocityX) {
        if (this.mScroller == null) {
            this.mScroller = getOverScroller();
        }
        if (this.mScroller == null) {
            super.fling(velocityX);
            return;
        }
        if (getChildCount() > 0) {
            int width = getWidth();
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.view.View");
            DXHorizontalScrollView dXHorizontalScrollView = this;
            int paddingRight = (width - dXHorizontalScrollView.getPaddingRight()) - dXHorizontalScrollView.getPaddingLeft();
            OverScroller overScroller = this.mScroller;
            Intrinsics.checkNotNull(overScroller);
            overScroller.fling(getScrollX(), getScrollY(), velocityX, 0, 0, Integer.MAX_VALUE, 0, 0, paddingRight / 2, 0);
            postInvalidateOnAnimation();
        }
    }

    private final OverScroller getOverScroller() {
        Field declaredField = HorizontalScrollView.class.getDeclaredField("mScroller");
        declaredField.setAccessible(true);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.widget.HorizontalScrollView");
        return (OverScroller) declaredField.get(this);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getAction() == 0) {
            this.lastX = ev.getX();
            this.lastY = ev.getY();
            this.xDistance = 0.0f;
            this.yDistance = 0.0f;
        }
        if (!super.onInterceptTouchEvent(ev)) {
            return false;
        }
        if (ev.getAction() == 2) {
            this.xDistance = this.lastX - ev.getX();
            this.lastX = ev.getX();
            this.yDistance = this.lastY - ev.getY();
            this.lastY = ev.getY();
        }
        return Math.abs(this.yDistance) <= Math.abs(this.xDistance) && canScrollHorizontally((int) Math.signum(this.xDistance));
    }
}
