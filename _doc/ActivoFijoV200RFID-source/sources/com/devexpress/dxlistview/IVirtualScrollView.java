package com.devexpress.dxlistview;

import android.graphics.Rect;
import android.view.MotionEvent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.devexpress.dxlistview.core.DXSize;
import com.devexpress.dxlistview.core.MotionDirection;
import kotlin.Metadata;

/* compiled from: IVirtualScrollView.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0007H&J\b\u0010\u0015\u001a\u00020\u0007H&J\b\u0010\u0016\u001a\u00020\u0007H&J\b\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0018H&J\b\u0010\u001a\u001a\u00020\u0018H&J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001dH&J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H&J\b\u0010)\u001a\u00020\u0018H&J\u0018\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u001dH&J\u0018\u0010-\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u001dH&J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u001dH&J\u0010\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u001dH&J\u0010\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u001dH&J\b\u00104\u001a\u00020\u0018H&J\b\u00105\u001a\u00020\u0018H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u00066"}, d2 = {"Lcom/devexpress/dxlistview/IVirtualScrollView;", "", "extentContentSize", "Lcom/devexpress/dxlistview/core/DXSize;", "getExtentContentSize", "()Lcom/devexpress/dxlistview/core/DXSize;", "isVertical", "", "()Z", "motionDirection", "Lcom/devexpress/dxlistview/core/MotionDirection;", "getMotionDirection", "()Lcom/devexpress/dxlistview/core/MotionDirection;", "viewport", "Landroid/graphics/Rect;", "getViewport", "()Landroid/graphics/Rect;", "canIntercept", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "canLoadMore", "canPullToRefresh", "canScrollUp", "layoutSubviews", "", "measureSubviews", "onAutoScroll", "overScrolledX", "scrollX", "", "overScrolledY", "scrollY", "processTouchEvent", "raiseItemDoubleTap", "raiseItemLongPress", "raiseItemTap", "raiseItemTapConfirmed", "raisePressed", "x", "", "y", "raiseReleased", "scrollBy", "dx", "dy", "scrollTo", "setContentOffsetX", "offsetX", "setContentOffsetY", "offsetY", "smoothScrollBy", TypedValues.CycleType.S_WAVE_OFFSET, "startLoadMore", "startPullToRefresh", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IVirtualScrollView {
    boolean canIntercept(MotionEvent event);

    boolean canLoadMore();

    boolean canPullToRefresh();

    boolean canScrollUp();

    DXSize getExtentContentSize();

    MotionDirection getMotionDirection();

    Rect getViewport();

    boolean isVertical();

    void layoutSubviews();

    void measureSubviews();

    void onAutoScroll();

    void overScrolledX(int scrollX);

    void overScrolledY(int scrollY);

    boolean processTouchEvent(MotionEvent event);

    void raiseItemDoubleTap(MotionEvent event);

    void raiseItemLongPress(MotionEvent event);

    void raiseItemTap(MotionEvent event);

    void raiseItemTapConfirmed(MotionEvent event);

    void raisePressed(float x, float y);

    void raiseReleased();

    void scrollBy(int dx, int dy);

    void scrollTo(int x, int y);

    void setContentOffsetX(int offsetX);

    void setContentOffsetY(int offsetY);

    void smoothScrollBy(int offset);

    void startLoadMore();

    void startPullToRefresh();
}
