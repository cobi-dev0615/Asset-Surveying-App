package com.devexpress.dxgrid.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.devexpress.dxgrid.utils.GestureManager;
import com.devexpress.dxgrid.utils.GestureType;
import com.devexpress.dxgrid.utils.ScrollChecker;

/* loaded from: classes2.dex */
public class GridRecyclerView extends RecyclerView implements ScrollChecker {
    private GestureManager gestureRecognizer;
    private Runnable onScrollChangeRunnable;

    public GridRecyclerView(Context context) {
        this(context, null);
    }

    public GridRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean tryCaptureGesture;
        if (this.gestureRecognizer.getState() != GestureType.VerticalScroll && this.gestureRecognizer.getState() != GestureType.PullToRefresh && this.gestureRecognizer.getState() != GestureType.None) {
            return false;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (!onInterceptTouchEvent) {
            return onInterceptTouchEvent;
        }
        if (this.gestureRecognizer.getMotionDirection() == GestureManager.MotionDirection.TopToBottom && !canScrollVertically(-1)) {
            tryCaptureGesture = this.gestureRecognizer.tryCaptureGesture(GestureType.PullToRefresh);
        } else {
            tryCaptureGesture = this.gestureRecognizer.tryCaptureGesture(GestureType.VerticalScroll);
        }
        return onInterceptTouchEvent & tryCaptureGesture;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gestureRecognizer.getState() == GestureType.VerticalScroll || this.gestureRecognizer.getState() == GestureType.PullToRefresh || this.gestureRecognizer.getState() == GestureType.None) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setGestureRecognizer(GestureManager gestureManager) {
        this.gestureRecognizer = gestureManager;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        Runnable runnable = this.onScrollChangeRunnable;
        if (runnable == null || i != i3) {
            return;
        }
        runnable.run();
    }

    @Override // com.devexpress.dxgrid.utils.ScrollChecker
    public boolean canScroll(int i) {
        return canScrollVertically(i);
    }

    public void setOnScrollChangeRunnable(Runnable runnable) {
        this.onScrollChangeRunnable = runnable;
    }
}
