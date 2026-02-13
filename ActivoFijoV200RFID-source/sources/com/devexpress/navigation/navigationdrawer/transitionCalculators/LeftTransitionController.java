package com.devexpress.navigation.navigationdrawer.transitionCalculators;

import android.graphics.Rect;
import android.view.View;

/* loaded from: classes2.dex */
public class LeftTransitionController extends BaseTransitionController {
    @Override // com.devexpress.navigation.navigationdrawer.transitionCalculators.BaseTransitionController
    public boolean isHorizontal() {
        return true;
    }

    public LeftTransitionController(View view, int i, int i2, Rect rect) {
        super(view, i, i2, rect);
        this.openedViewBounds = new Rect(0, 0, this.mViewSize, this.mViewPort.bottom - this.mViewPort.top);
        this.closedViewBounds = new Rect(this.openedViewBounds.left + this.mDraggableDistance, this.openedViewBounds.top, this.openedViewBounds.right + this.mDraggableDistance, this.openedViewBounds.bottom);
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionCalculators.BaseTransitionController
    public boolean isOpened(float f, float f2) {
        if (f < (-f2)) {
            return false;
        }
        if (f > f2) {
            return true;
        }
        return Math.abs(this.mDraggableDistance / 2) > Math.abs(Math.max(this.openedViewBounds.left, this.closedViewBounds.left) - Math.abs(this.mView.getLeft()));
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionCalculators.BaseTransitionController
    public float getVisiblePercents() {
        return Math.abs(Math.abs(this.closedViewBounds.left) - Math.abs(this.mView.getLeft())) / Math.abs(this.mDraggableDistance);
    }
}
