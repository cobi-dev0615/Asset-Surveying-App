package com.devexpress.dxlistview.core;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.devexpress.dxlistview.IVirtualScrollView;
import com.devexpress.dxlistview.helpers.MathHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScrollingHelper.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\nJ\b\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0014J\u0006\u0010\u0019\u001a\u00020\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/devexpress/dxlistview/core/ScrollingHelper;", "Ljava/lang/Runnable;", "context", "Landroid/content/Context;", "scrollView", "Lcom/devexpress/dxlistview/IVirtualScrollView;", "(Landroid/content/Context;Lcom/devexpress/dxlistview/IVirtualScrollView;)V", "_autoScrolling", "", "_panLocation", "Landroid/graphics/Point;", "isPanOutOfBounds", "()Z", "scrollingGap", "", "timerHandler", "Landroid/os/Handler;", "autoScroll", "", "farEdge", "nearEdge", "onPan", "panLocation", "run", "startAutoScroll", "stopAutoScroll", "Companion", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class ScrollingHelper implements Runnable {
    public static final int SCROLLING_GAP = 80;
    public static final float VELOCITY_MULTIPLIER = 0.5f;
    private boolean _autoScrolling;
    private Point _panLocation;
    private final IVirtualScrollView scrollView;
    private final int scrollingGap;
    private final Handler timerHandler;

    public ScrollingHelper(Context context, IVirtualScrollView scrollView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        this.scrollView = scrollView;
        this.scrollingGap = MathHelper.round(80 * context.getResources().getDisplayMetrics().density);
        this._panLocation = new Point();
        this.timerHandler = new Handler(Looper.getMainLooper());
    }

    private final boolean isPanOutOfBounds() {
        int i = this.scrollView.isVertical() ? this._panLocation.y : this._panLocation.x;
        return i > farEdge() - this.scrollingGap || i < nearEdge() + this.scrollingGap;
    }

    public final void onPan(Point panLocation) {
        Intrinsics.checkNotNullParameter(panLocation, "panLocation");
        this._panLocation = panLocation;
        if (this._autoScrolling) {
            return;
        }
        boolean isPanOutOfBounds = isPanOutOfBounds();
        this._autoScrolling = isPanOutOfBounds;
        if (isPanOutOfBounds) {
            startAutoScroll();
        }
    }

    protected void startAutoScroll() {
        this.timerHandler.postDelayed(this, 0L);
    }

    public final void stopAutoScroll() {
        this._autoScrolling = false;
        this.timerHandler.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        autoScroll();
    }

    private final int nearEdge() {
        Rect viewport = this.scrollView.getViewport();
        return this.scrollView.isVertical() ? viewport.top : viewport.left;
    }

    private final int farEdge() {
        Rect viewport = this.scrollView.getViewport();
        return this.scrollView.isVertical() ? viewport.bottom : viewport.right;
    }

    private final void autoScroll() {
        int round;
        if (!isPanOutOfBounds()) {
            stopAutoScroll();
            return;
        }
        int i = this.scrollView.isVertical() ? this._panLocation.y : this._panLocation.x;
        Rect viewport = this.scrollView.getViewport();
        int i2 = this.scrollView.isVertical() ? viewport.top : viewport.left;
        int nearEdge = nearEdge() + this.scrollingGap;
        if (i > farEdge() - this.scrollingGap) {
            round = MathHelper.round(Math.min(i - r4, r5) * 0.5f);
        } else {
            round = i < nearEdge ? MathHelper.round((-Math.min(nearEdge - i, r5)) * 0.5f) : 0;
        }
        if (round == 0) {
            stopAutoScroll();
            return;
        }
        int i3 = i2 + round;
        Point point = this.scrollView.isVertical() ? new Point(viewport.left, i3) : new Point(i3, viewport.top);
        this.scrollView.scrollTo(point.x, point.y);
        this.scrollView.onAutoScroll();
        if (this._autoScrolling) {
            this.timerHandler.postDelayed(this, 20L);
        }
    }
}
