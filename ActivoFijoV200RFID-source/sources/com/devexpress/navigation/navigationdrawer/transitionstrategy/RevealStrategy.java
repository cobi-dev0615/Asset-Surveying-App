package com.devexpress.navigation.navigationdrawer.transitionstrategy;

import android.graphics.Rect;
import android.view.View;
import androidx.customview.widget.ViewDragHelper;
import com.devexpress.navigation.DrawerView;
import com.devexpress.navigation.common.Position;
import com.devexpress.navigation.navigationdrawer.DrawerSizeCalculator;
import com.devexpress.navigation.navigationdrawer.transitionCalculators.BaseTransitionController;
import java.util.List;

/* loaded from: classes2.dex */
public class RevealStrategy extends BaseTransitionStrategy {
    public RevealStrategy(View view, View view2, View view3, ViewDragHelper viewDragHelper, DrawerSizeCalculator drawerSizeCalculator, Position position, boolean z, List<DrawerView.OnDrawerStateChangedListener> list) {
        super(view, view2, view3, viewDragHelper, drawerSizeCalculator, position, z, list);
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy
    public View getDraggableView() {
        return this.mParentView;
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy
    protected BaseTransitionController createSidePanelRect(Rect rect, int i) {
        return createSlider(this.mSidePanel, i, 0, rect);
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy
    protected BaseTransitionController createParentContentRect(Rect rect, int i) {
        int i2;
        int i3;
        if (this.mSidePanelPosition == Position.Left || this.mSidePanelPosition == Position.Right) {
            i2 = rect.right;
            i3 = rect.left;
        } else {
            i2 = rect.bottom;
            i3 = rect.top;
        }
        return createSlider(this.mParentView, i2 - i3, i, rect);
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy
    protected Rect getOpenedRect() {
        if (this.mParentViewRect == null) {
            return null;
        }
        return this.mParentViewRect.getClosedRect();
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy
    protected Rect getClosedRect() {
        if (this.mParentViewRect == null) {
            return null;
        }
        return this.mParentViewRect.getOpenedRect();
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy
    public float getDrawerVisibleRegion() {
        return 1.0f - getDraggableViewRect().getVisiblePercents();
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy
    public void layout(boolean z, int i, int i2, int i3, int i4) {
        super.layout(z, i, i2, i3, i4);
        Rect openedRect = !this.mIsOpen ? this.mParentViewRect.getOpenedRect() : this.mParentViewRect.getClosedRect();
        this.mParentView.layout(openedRect.left, openedRect.top, openedRect.right, openedRect.bottom);
        Rect openedRect2 = !this.mIsOpen ? this.mSidePanelRect.getOpenedRect() : this.mSidePanelRect.getClosedRect();
        this.mSidePanel.layout(openedRect2.left, openedRect2.top, openedRect2.right, openedRect2.bottom);
    }
}
