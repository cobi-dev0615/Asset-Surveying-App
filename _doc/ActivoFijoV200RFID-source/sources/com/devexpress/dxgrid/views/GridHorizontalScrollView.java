package com.devexpress.dxgrid.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import com.devexpress.dxgrid.utils.GestureManager;
import com.devexpress.dxgrid.utils.GestureType;
import com.devexpress.dxgrid.utils.OnGridScrollChangeListener;
import com.devexpress.dxgrid.utils.ScrollChecker;

/* loaded from: classes2.dex */
public class GridHorizontalScrollView extends HorizontalScrollView implements ScrollChecker {
    private GestureManager gestureRecognizer;
    private boolean isMotionInsideSwipedItem;
    private OnGridScrollChangeListener onScrollChangeListener;
    private GestureType previousState;
    private SwipeArea swipeArea;

    private enum SwipeArea {
        None,
        Left,
        Right
    }

    public GridHorizontalScrollView(Context context) {
        this(context, null);
    }

    public GridHorizontalScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.swipeArea = SwipeArea.None;
        this.isMotionInsideSwipedItem = false;
    }

    private boolean hasSwipedRow() {
        return this.onScrollChangeListener.getSwipeOffset() != 0;
    }

    public void setOnScrollChangeListener(OnGridScrollChangeListener onGridScrollChangeListener) {
        this.onScrollChangeListener = onGridScrollChangeListener;
    }

    public void setGestureRecognizer(GestureManager gestureManager) {
        this.gestureRecognizer = gestureManager;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.onScrollChangeListener.onHorizontalScrollChange(getScrollX());
    }

    private void processSwipeEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        boolean z = false;
        if (action != 1) {
            if (action == 2) {
                if (this.previousState != GestureType.Swipe && this.swipeArea == SwipeArea.None) {
                    if (hasSwipedRow() && this.onScrollChangeListener.isMotionInsideSwipedContainer(motionEvent)) {
                        z = true;
                    }
                    this.isMotionInsideSwipedItem = z;
                    if (z && Math.abs(this.gestureRecognizer.getDeltaX()) > this.gestureRecognizer.getTouchSlop()) {
                        if (this.gestureRecognizer.tryCaptureGesture(GestureType.Swipe)) {
                            this.swipeArea = this.onScrollChangeListener.getSwipeOffset() > 0 ? SwipeArea.Left : SwipeArea.Right;
                        }
                    } else if (this.gestureRecognizer.getState() == GestureType.Swipe) {
                        this.swipeArea = this.gestureRecognizer.getMotionDirection() == GestureManager.MotionDirection.LeftToRight ? SwipeArea.Left : SwipeArea.Right;
                    }
                }
                if (this.gestureRecognizer.getState() == GestureType.Swipe) {
                    int deltaX = this.gestureRecognizer.getDeltaX();
                    if ((this.swipeArea == SwipeArea.Left && this.onScrollChangeListener.getSwipeOffset() + deltaX < 0) || (this.swipeArea == SwipeArea.Right && this.onScrollChangeListener.getSwipeOffset() + deltaX > 0)) {
                        deltaX = -this.onScrollChangeListener.getSwipeOffset();
                    }
                    this.onScrollChangeListener.onHorizontalOverScroll(deltaX);
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        return;
                    }
                    return;
                }
                return;
            }
            if (action != 3) {
                return;
            }
        }
        this.isMotionInsideSwipedItem = false;
        if (this.previousState == GestureType.Swipe) {
            this.swipeArea = SwipeArea.None;
        }
        this.onScrollChangeListener.onActionUp();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.previousState = this.gestureRecognizer.getState();
        this.gestureRecognizer.processEvent(motionEvent);
        processSwipeEvent(motionEvent);
        if (this.gestureRecognizer.getState() == GestureType.Swipe || this.previousState == GestureType.Swipe) {
            return true;
        }
        if (this.gestureRecognizer.getState() == GestureType.HorizontalScroll || this.previousState == GestureType.HorizontalScroll) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.previousState = this.gestureRecognizer.getState();
        this.gestureRecognizer.processEvent(motionEvent);
        processSwipeEvent(motionEvent);
        if (this.gestureRecognizer.getState() != GestureType.HorizontalScroll && this.gestureRecognizer.getState() != GestureType.None) {
            super.onInterceptTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
        }
        if (this.gestureRecognizer.getState() == GestureType.Swipe || this.previousState == GestureType.Swipe) {
            return true;
        }
        if ((this.gestureRecognizer.getState() == GestureType.HorizontalScroll || this.previousState == GestureType.HorizontalScroll || this.gestureRecognizer.getState() == GestureType.None) && super.onInterceptTouchEvent(motionEvent)) {
            return this.gestureRecognizer.tryCaptureGesture(GestureType.HorizontalScroll);
        }
        return false;
    }

    @Override // com.devexpress.dxgrid.utils.ScrollChecker
    public boolean canScroll(int i) {
        return canScrollHorizontally(i) && !this.isMotionInsideSwipedItem;
    }
}
