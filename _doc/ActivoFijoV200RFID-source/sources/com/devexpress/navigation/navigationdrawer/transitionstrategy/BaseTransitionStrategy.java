package com.devexpress.navigation.navigationdrawer.transitionstrategy;

import android.graphics.Rect;
import android.view.View;
import androidx.customview.widget.ViewDragHelper;
import com.devexpress.navigation.DrawerView;
import com.devexpress.navigation.common.Position;
import com.devexpress.navigation.navigationdrawer.DrawerSizeCalculator;
import com.devexpress.navigation.navigationdrawer.transitionCalculators.BaseTransitionController;
import com.devexpress.navigation.navigationdrawer.transitionCalculators.BottomTransitionController;
import com.devexpress.navigation.navigationdrawer.transitionCalculators.LeftTransitionController;
import com.devexpress.navigation.navigationdrawer.transitionCalculators.RightTransitionController;
import com.devexpress.navigation.navigationdrawer.transitionCalculators.TopTransitionController;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseTransitionStrategy {
    private ViewDragHelper mDragHelper;
    private View mDrawerView;
    protected boolean mIsOpen;
    protected List<DrawerView.OnDrawerStateChangedListener> mOnDrawerStateChangedListeners;
    protected View mParentView;
    protected BaseTransitionController mParentViewRect;
    protected View mSidePanel;
    protected Position mSidePanelPosition;
    protected BaseTransitionController mSidePanelRect;
    protected DrawerSizeCalculator mSizeCalculator;
    protected boolean mAnimationEnabled = true;
    boolean mPrevIsOpenedState = false;
    Rect mCurrentDraggableRect = new Rect();

    protected abstract BaseTransitionController createParentContentRect(Rect rect, int i);

    protected abstract BaseTransitionController createSidePanelRect(Rect rect, int i);

    protected abstract Rect getClosedRect();

    public abstract View getDraggableView();

    public abstract float getDrawerVisibleRegion();

    protected abstract Rect getOpenedRect();

    public void onViewPositionChanged() {
    }

    public boolean getIsOpened() {
        return this.mIsOpen;
    }

    public boolean getAnimationEnabled() {
        return this.mAnimationEnabled;
    }

    public void setIsOpened(boolean z) {
        changeDrawerState(z, this.mAnimationEnabled);
    }

    public void setAnimationEnabled(boolean z) {
        this.mAnimationEnabled = z;
    }

    protected BaseTransitionController getDraggableViewRect() {
        return getDraggableView() == this.mSidePanel ? this.mSidePanelRect : this.mParentViewRect;
    }

    /* renamed from: com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$navigation$common$Position;

        static {
            int[] iArr = new int[Position.values().length];
            $SwitchMap$com$devexpress$navigation$common$Position = iArr;
            try {
                iArr[Position.Left.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Top.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Right.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Bottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private int getEdgeFlags(Position position) {
        int i = AnonymousClass1.$SwitchMap$com$devexpress$navigation$common$Position[position.ordinal()];
        if (i == 2) {
            return 4;
        }
        if (i != 3) {
            return i != 4 ? 1 : 8;
        }
        return 2;
    }

    BaseTransitionStrategy(View view, View view2, View view3, ViewDragHelper viewDragHelper, DrawerSizeCalculator drawerSizeCalculator, Position position, boolean z, List<DrawerView.OnDrawerStateChangedListener> list) {
        this.mIsOpen = false;
        this.mSidePanel = view;
        this.mParentView = view2;
        this.mDrawerView = view3;
        this.mDragHelper = viewDragHelper;
        this.mSizeCalculator = drawerSizeCalculator;
        this.mSidePanelPosition = position;
        viewDragHelper.setEdgeTrackingEnabled(getEdgeFlags(position));
        getDraggableView().bringToFront();
        this.mIsOpen = z;
        this.mOnDrawerStateChangedListeners = list;
    }

    public void layout(boolean z, int i, int i2, int i3, int i4) {
        int calculateSize;
        if (this.mSidePanelPosition == Position.Left || this.mSidePanelPosition == Position.Right) {
            calculateSize = this.mSizeCalculator.calculateSize(this.mSidePanel.getMeasuredWidth(), this.mParentView.getMeasuredWidth());
        } else {
            calculateSize = this.mSizeCalculator.calculateSize(this.mSidePanel.getMeasuredHeight(), this.mParentView.getMeasuredHeight());
        }
        Rect rect = new Rect(i, i2, i3, i4);
        this.mSidePanelRect = createSidePanelRect(rect, calculateSize);
        this.mParentViewRect = createParentContentRect(rect, calculateSize);
    }

    public int clampViewPositionHorizontal(int i) {
        return getDraggableViewRect().clampViewPositionHorizontal(i);
    }

    public int clampViewPositionVertical(int i) {
        return getDraggableViewRect().clampViewPositionVertical(i);
    }

    public void onViewReleased(float f, float f2) {
        View draggableView = getDraggableView();
        if (!this.mParentViewRect.isHorizontal()) {
            f = f2;
        }
        this.mPrevIsOpenedState = this.mIsOpen;
        boolean isOpened = getDraggableViewRect().isOpened(f, 2000.0f);
        this.mIsOpen = isOpened;
        Rect openedRect = isOpened ? getOpenedRect() : getClosedRect();
        if (openedRect != null && this.mDragHelper.smoothSlideViewTo(draggableView, openedRect.left, openedRect.top)) {
            forceRedraw();
        }
        RaiseDrawerStateChanged();
    }

    public void updatePosition(Position position) {
        this.mSidePanelPosition = position;
        this.mDragHelper.setEdgeTrackingEnabled(getEdgeFlags(position));
    }

    protected BaseTransitionController createSlider(View view, int i, int i2, Rect rect) {
        int i3 = AnonymousClass1.$SwitchMap$com$devexpress$navigation$common$Position[this.mSidePanelPosition.ordinal()];
        if (i3 == 1) {
            return new LeftTransitionController(view, i, i2, rect);
        }
        if (i3 == 2) {
            return new TopTransitionController(view, i, i2, rect);
        }
        if (i3 == 3) {
            return new RightTransitionController(view, i, i2, rect);
        }
        if (i3 != 4) {
            return null;
        }
        return new BottomTransitionController(view, i, i2, rect);
    }

    public void RaiseDrawerStateChanged() {
        if (isStateChanged()) {
            boolean z = this.mPrevIsOpenedState;
            boolean z2 = this.mIsOpen;
            if (z != z2) {
                this.mPrevIsOpenedState = z2;
                Iterator<DrawerView.OnDrawerStateChangedListener> it = this.mOnDrawerStateChangedListeners.iterator();
                while (it.hasNext()) {
                    it.next().OnDrawerStateChanged(this.mIsOpen);
                }
            }
        }
    }

    private void forceRedraw() {
        this.mDrawerView.invalidate();
    }

    protected void changeDrawerState(boolean z, boolean z2) {
        boolean z3;
        View draggableView = getDraggableView();
        if (draggableView == null || (z3 = this.mIsOpen) == z) {
            return;
        }
        this.mPrevIsOpenedState = z3;
        this.mIsOpen = z;
        Rect openedRect = z ? getOpenedRect() : getClosedRect();
        if (openedRect == null) {
            return;
        }
        if (z2) {
            if (this.mDragHelper.smoothSlideViewTo(draggableView, openedRect.left, openedRect.top)) {
                forceRedraw();
            }
            RaiseDrawerStateChanged();
        } else {
            draggableView.layout(openedRect.left, openedRect.top, openedRect.right, openedRect.bottom);
            RaiseDrawerStateChanged();
        }
    }

    public boolean isStateChanged() {
        View draggableView = getDraggableView();
        this.mCurrentDraggableRect.left = draggableView.getLeft();
        this.mCurrentDraggableRect.top = draggableView.getTop();
        this.mCurrentDraggableRect.right = draggableView.getRight();
        this.mCurrentDraggableRect.bottom = draggableView.getBottom();
        if (this.mIsOpen) {
            return this.mCurrentDraggableRect.equals(getOpenedRect());
        }
        return this.mCurrentDraggableRect.equals(getClosedRect());
    }
}
