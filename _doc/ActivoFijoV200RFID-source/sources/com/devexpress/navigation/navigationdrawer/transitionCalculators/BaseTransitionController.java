package com.devexpress.navigation.navigationdrawer.transitionCalculators;

import android.graphics.Rect;
import android.view.View;

/* loaded from: classes2.dex */
public abstract class BaseTransitionController {
    protected Rect closedViewBounds;
    protected int mDraggableDistance;
    protected View mView;
    protected Rect mViewPort;
    protected int mViewSize;
    protected Rect openedViewBounds;

    public abstract float getVisiblePercents();

    public abstract boolean isHorizontal();

    public abstract boolean isOpened(float f, float f2);

    public int getViewSize() {
        return this.mViewSize;
    }

    public int clampViewPositionHorizontal(int i) {
        int min = Math.min(this.openedViewBounds.left, this.closedViewBounds.left);
        int max = Math.max(this.openedViewBounds.left, this.closedViewBounds.left);
        return i < min ? min : i > max ? max : i;
    }

    public int clampViewPositionVertical(int i) {
        int min = Math.min(this.openedViewBounds.top, this.closedViewBounds.top);
        int max = Math.max(this.openedViewBounds.top, this.closedViewBounds.top);
        return i < min ? min : i > max ? max : i;
    }

    public Rect getOpenedRect() {
        return this.openedViewBounds;
    }

    public Rect getClosedRect() {
        return this.closedViewBounds;
    }

    BaseTransitionController(View view, int i, int i2, Rect rect) {
        this.mView = view;
        this.mViewSize = i;
        this.mDraggableDistance = i2;
        this.mViewPort = rect;
    }
}
