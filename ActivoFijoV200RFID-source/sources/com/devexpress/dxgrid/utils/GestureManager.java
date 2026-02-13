package com.devexpress.dxgrid.utils;

import android.view.MotionEvent;

/* loaded from: classes2.dex */
public class GestureManager {
    private boolean canScrollHorizontally;
    private ScrollChecker horizontalScrollChecker;
    private boolean isLeftSwipeEnabled;
    private boolean isRightSwipeEnabled;
    private int lastMotionX;
    private int lastMotionY;
    private boolean pullToRefreshEnabled;
    private int touchSlop;
    private ScrollChecker verticalScrollChecker;
    private int xDiff;
    private GestureType currentGesture = GestureType.None;
    private MotionDirection motionDirection = MotionDirection.None;

    public enum MotionDirection {
        None,
        LeftToRight,
        RightToLeft,
        TopToBottom,
        BottomToTop
    }

    public GestureManager(int i) {
        this.touchSlop = i;
    }

    public int getTouchSlop() {
        return this.touchSlop;
    }

    public GestureType getState() {
        return this.currentGesture;
    }

    public void setHorizontalScrollChecker(ScrollChecker scrollChecker) {
        this.horizontalScrollChecker = scrollChecker;
    }

    public void setVerticalScrollChecker(ScrollChecker scrollChecker) {
        this.verticalScrollChecker = scrollChecker;
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.pullToRefreshEnabled = z;
    }

    public void setLeftSwipeEnabled(boolean z) {
        this.isLeftSwipeEnabled = z;
    }

    public void setRightSwipeEnabled(boolean z) {
        this.isRightSwipeEnabled = z;
    }

    public MotionDirection getMotionDirection() {
        return this.motionDirection;
    }

    private boolean tryDetectGesture(int i, int i2) {
        if (this.currentGesture != GestureType.None) {
            return false;
        }
        int i3 = -1;
        boolean z = true;
        int i4 = Math.abs(i) <= this.touchSlop ? 0 : i > 0 ? -1 : 1;
        if (Math.abs(i2) <= this.touchSlop) {
            i3 = 0;
        } else if (i2 <= 0) {
            i3 = 1;
        }
        this.canScrollHorizontally = canScrollHorizontally(i4);
        boolean canScrollVertically = canScrollVertically(i3);
        boolean canSwipeLeft = canSwipeLeft(i4);
        boolean canSwipeRight = canSwipeRight(i4);
        boolean canPullToRefresh = canPullToRefresh(i3);
        boolean z2 = Math.abs(i) > Math.abs(i2);
        boolean z3 = canSwipeLeft || canSwipeRight || this.canScrollHorizontally;
        if (!canScrollVertically && !canPullToRefresh) {
            z = false;
        }
        if (z3 && (!z || z2)) {
            if (i4 < 0) {
                this.motionDirection = MotionDirection.LeftToRight;
            } else {
                this.motionDirection = MotionDirection.RightToLeft;
            }
            if (canSwipeLeft || canSwipeRight) {
                return tryCaptureGesture(GestureType.Swipe);
            }
            return tryCaptureGesture(GestureType.HorizontalScroll);
        }
        if (!z || (z3 && z2)) {
            return false;
        }
        this.motionDirection = i3 < 0 ? MotionDirection.TopToBottom : MotionDirection.BottomToTop;
        if (canScrollVertically) {
            return tryCaptureGesture(GestureType.VerticalScroll);
        }
        return tryCaptureGesture(GestureType.PullToRefresh);
    }

    public void processEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            tryCaptureGesture(GestureType.None);
            this.lastMotionX = x;
            this.lastMotionY = y;
            return;
        }
        if (action != 1) {
            if (action == 2) {
                int x2 = (int) motionEvent.getX();
                int y2 = (int) motionEvent.getY();
                int i = x2 - this.lastMotionX;
                this.xDiff = i;
                tryDetectGesture(i, y2 - this.lastMotionY);
                if (this.currentGesture != GestureType.None) {
                    this.lastMotionX = x2;
                    this.lastMotionY = y2;
                    return;
                }
                return;
            }
            if (action != 3) {
                if (action == 5) {
                    this.lastMotionX = (int) motionEvent.getX();
                    this.lastMotionY = (int) motionEvent.getY();
                    return;
                } else {
                    if (action != 6) {
                        return;
                    }
                    this.lastMotionX = (int) motionEvent.getX();
                    this.lastMotionY = (int) motionEvent.getY();
                    return;
                }
            }
        }
        tryCaptureGesture(GestureType.None);
    }

    public boolean tryCaptureGesture(GestureType gestureType) {
        if (gestureType == GestureType.HorizontalScroll && !this.canScrollHorizontally) {
            return false;
        }
        if (this.currentGesture == gestureType || gestureType == GestureType.None) {
            this.currentGesture = gestureType;
            return true;
        }
        if (this.currentGesture == GestureType.HorizontalScroll || this.currentGesture == GestureType.Swipe || ((this.currentGesture == GestureType.PullToRefresh && gestureType != GestureType.VerticalScroll) || (this.currentGesture == GestureType.VerticalScroll && gestureType != GestureType.PullToRefresh))) {
            return false;
        }
        this.currentGesture = gestureType;
        return true;
    }

    private boolean canScrollHorizontally(int i) {
        return i != 0 && this.horizontalScrollChecker.canScroll(i);
    }

    private boolean canScrollVertically(int i) {
        return i != 0 && this.verticalScrollChecker.canScroll(i);
    }

    private boolean canPullToRefresh(int i) {
        return this.pullToRefreshEnabled && i == -1 && !this.verticalScrollChecker.canScroll(i);
    }

    private boolean canSwipeLeft(int i) {
        return this.isLeftSwipeEnabled && i == -1 && !this.horizontalScrollChecker.canScroll(i);
    }

    private boolean canSwipeRight(int i) {
        return this.isRightSwipeEnabled && i == 1 && !this.horizontalScrollChecker.canScroll(i);
    }

    public int getDeltaX() {
        return this.xDiff;
    }
}
