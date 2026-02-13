package com.devexpress.navigation.navigationdrawer.transitionCalculators;

import android.graphics.Rect;
import android.view.View;

/* loaded from: classes2.dex */
public class BottomTransitionController extends BaseTransitionController {
    @Override // com.devexpress.navigation.navigationdrawer.transitionCalculators.BaseTransitionController
    public boolean isHorizontal() {
        return false;
    }

    public BottomTransitionController(View view, int i, int i2, Rect rect) {
        super(view, i, i2, rect);
        int i3 = this.mViewPort.bottom - this.mViewPort.top;
        this.openedViewBounds = new Rect(0, i3 - this.mViewSize, this.mViewPort.right - this.mViewPort.left, i3);
        this.closedViewBounds = new Rect(this.openedViewBounds.left, this.openedViewBounds.top - this.mDraggableDistance, this.openedViewBounds.right, this.openedViewBounds.bottom - this.mDraggableDistance);
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionCalculators.BaseTransitionController
    public boolean isOpened(float f, float f2) {
        if (f < (-f2)) {
            return true;
        }
        if (f > f2) {
            return false;
        }
        return Math.abs(this.mDraggableDistance / 2) < Math.abs(Math.max(this.openedViewBounds.top, this.closedViewBounds.top) - Math.abs(this.mView.getTop()));
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionCalculators.BaseTransitionController
    public float getVisiblePercents() {
        return Math.abs(Math.abs(this.closedViewBounds.top) - Math.abs(this.mView.getTop())) / Math.abs(this.mDraggableDistance);
    }
}
