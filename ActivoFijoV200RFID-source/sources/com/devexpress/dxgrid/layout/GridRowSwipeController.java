package com.devexpress.dxgrid.layout;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.dxgrid.providers.SwipeButtonAction;
import com.devexpress.dxgrid.utils.SwipeActionsContainerCache;
import com.devexpress.dxgrid.utils.providers.SwipeProvider;
import com.devexpress.dxgrid.utils.providers.ViewPortWidthProvider;
import com.devexpress.dxgrid.views.GridRowViewBase;
import com.devexpress.dxgrid.views.SwipeActionButton;
import com.devexpress.dxgrid.views.SwipeActionsContainer;

/* loaded from: classes.dex */
public class GridRowSwipeController implements SwipeActionButton.OnTapListener {
    private OnLayoutListener layoutListener;
    private final GridRowViewBase rowView;
    private SwipeActionsContainer swipeActionsContainer;
    private final ValueAnimator swipeAnimator;
    private final SwipeActionsContainerCache swipeCache;
    private int swipeDirection;
    private int swipeOffset;
    private final SwipeProvider swipeProvider;
    private final ViewPortWidthProvider viewPortWidthProvider;
    private boolean isAutoSwipe = false;
    private final int overscrollOnNonFullSwipe = 24;

    public interface OnLayoutListener {
        void layoutViews();
    }

    public GridRowSwipeController(final GridRowViewBase gridRowViewBase, ViewPortWidthProvider viewPortWidthProvider, SwipeProvider swipeProvider, SwipeActionsContainerCache swipeActionsContainerCache) {
        this.rowView = gridRowViewBase;
        this.viewPortWidthProvider = viewPortWidthProvider;
        this.swipeProvider = swipeProvider;
        this.swipeCache = swipeActionsContainerCache;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.swipeAnimator = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.devexpress.dxgrid.layout.GridRowSwipeController.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                if (GridRowSwipeController.this.canSwipe()) {
                    GridRowSwipeController.this.setSwipeOffset(((Float) valueAnimator2.getAnimatedValue()).floatValue());
                }
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() { // from class: com.devexpress.dxgrid.layout.GridRowSwipeController.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                GridRowSwipeController.this.isAutoSwipe = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (GridRowSwipeController.this.isAutoSwipe) {
                    GridRowSwipeController.this.isAutoSwipe = false;
                    if (GridRowSwipeController.this.swipeActionsContainer != null) {
                        GridRowSwipeController.this.swipeActionsContainer.processDefaultAction(gridRowViewBase.getRowIndex());
                        GridRowSwipeController.this.setSwipeOffset(0.0f);
                    }
                }
            }
        });
    }

    private void cancelAnimations() {
        cancelSwipeAnimator();
    }

    private void cancelSwipeAnimator() {
        if (this.swipeAnimator.isRunning()) {
            this.swipeAnimator.cancel();
        }
    }

    private boolean isSupportSwipes() {
        return this.swipeProvider.getSwipeEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canSwipe() {
        return isSupportSwipes() && this.swipeActionsContainer != null;
    }

    private void updateSwipeContainer() {
        SwipeActionsContainer swipeActionsContainer;
        int i = this.swipeOffset;
        if (i == 0 || this.swipeActionsContainer != null) {
            if (i != 0 || (swipeActionsContainer = this.swipeActionsContainer) == null) {
                return;
            }
            this.rowView.removeView(swipeActionsContainer);
            this.swipeCache.recycle(this.swipeActionsContainer);
            this.swipeActionsContainer = null;
            return;
        }
        if (isRightArea()) {
            this.swipeActionsContainer = this.swipeCache.getRightSwipeActionsContainer(this, this.rowView.getRowIndex());
        } else {
            this.swipeActionsContainer = this.swipeCache.getLeftSwipeActionsContainer(this, this.rowView.getRowIndex());
        }
        SwipeActionsContainer swipeActionsContainer2 = this.swipeActionsContainer;
        if (swipeActionsContainer2 != null) {
            this.rowView.addView(swipeActionsContainer2);
        }
    }

    private void startSwipeAnimator(float f, float f2) {
        cancelAnimations();
        if (f != f2) {
            this.swipeAnimator.setFloatValues(f, f2);
            this.swipeAnimator.start();
        }
    }

    private boolean isLeftArea() {
        return this.swipeOffset > 0;
    }

    private boolean isRightArea() {
        return this.swipeOffset < 0;
    }

    public void relayout() {
        if (this.swipeActionsContainer != null) {
            if (isLeftArea()) {
                int offset = this.rowView.getOffset();
                this.swipeActionsContainer.measure(View.MeasureSpec.makeMeasureSpec(this.swipeOffset, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(this.rowView.getHeight(), BasicMeasure.EXACTLY));
                this.swipeActionsContainer.layout(offset, 0, this.swipeOffset + offset, this.rowView.getHeight());
            } else if (isRightArea()) {
                this.swipeActionsContainer.measure(View.MeasureSpec.makeMeasureSpec(-this.swipeOffset, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(this.rowView.getHeight(), BasicMeasure.EXACTLY));
                int offset2 = this.rowView.getOffset() + this.viewPortWidthProvider.getViewPortWidth();
                this.swipeActionsContainer.layout(this.swipeOffset + offset2, 0, offset2, this.rowView.getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSwipeOffset(float f) {
        this.swipeOffset = getActualSwipeOffset((int) f);
        updateSwipeContainer();
        if (this.swipeActionsContainer != null) {
            if (isLeftArea()) {
                int offset = this.rowView.getOffset();
                this.swipeActionsContainer.measure(View.MeasureSpec.makeMeasureSpec(this.swipeOffset, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(this.rowView.getHeight(), BasicMeasure.EXACTLY));
                if (this.swipeActionsContainer.getItemsMinWidth() == 0) {
                    this.swipeOffset = 0;
                    updateSwipeContainer();
                    return;
                } else {
                    this.swipeActionsContainer.layout(offset, 0, this.swipeOffset + offset, this.rowView.getHeight());
                    if (this.swipeProvider.getAllowStartFullSwipe()) {
                        this.swipeActionsContainer.setAutoAction(Math.abs(this.swipeOffset) > getAutoActionWidth());
                    }
                }
            } else if (isRightArea()) {
                this.swipeActionsContainer.measure(View.MeasureSpec.makeMeasureSpec(-this.swipeOffset, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(this.rowView.getHeight(), BasicMeasure.EXACTLY));
                if (this.swipeActionsContainer.getItemsMinWidth() == 0) {
                    this.swipeOffset = 0;
                    updateSwipeContainer();
                    return;
                } else {
                    int offset2 = this.rowView.getOffset() + this.viewPortWidthProvider.getViewPortWidth();
                    this.swipeActionsContainer.layout(this.swipeOffset + offset2, 0, offset2, this.rowView.getHeight());
                    if (this.swipeProvider.getAllowEndFullSwipe()) {
                        this.swipeActionsContainer.setAutoAction(Math.abs(this.swipeOffset) > getAutoActionWidth());
                    }
                }
            }
        } else {
            this.swipeOffset = 0;
        }
        OnLayoutListener onLayoutListener = this.layoutListener;
        if (onLayoutListener != null) {
            onLayoutListener.layoutViews();
        }
    }

    private int getActualSwipeOffset(int i) {
        SwipeActionsContainer swipeActionsContainer = this.swipeActionsContainer;
        if (swipeActionsContainer == null) {
            return i;
        }
        int itemsMinWidth = swipeActionsContainer.getItemsMinWidth() + getOverscrollOnNonFullSwipePixels();
        return isLeftArea() ? this.swipeProvider.getAllowStartFullSwipe() ? i : Math.min(i, itemsMinWidth) : (!isRightArea() || this.swipeProvider.getAllowEndFullSwipe()) ? i : Math.max(i, -itemsMinWidth);
    }

    private int getOverscrollOnNonFullSwipePixels() {
        return (int) (Resources.getSystem().getDisplayMetrics().density * 24.0f);
    }

    private int getAutoActionWidth() {
        return Math.min(Math.max(this.viewPortWidthProvider.getViewPortWidth() / 2, (this.swipeActionsContainer.getItemsMinWidth() * 11) / 10), (this.viewPortWidthProvider.getViewPortWidth() * 9) / 10);
    }

    public void resetSwipe() {
        cancelAnimations();
        this.swipeOffset = 0;
        updateSwipeContainer();
    }

    public void onActionDown() {
        if (canSwipe()) {
            cancelAnimations();
        }
        int i = this.swipeOffset;
        this.swipeDirection = i != 0 ? (int) Math.signum(i) : 0;
    }

    public void onActionUp() {
        int i;
        if (!canSwipe() || (i = this.swipeOffset) == 0) {
            return;
        }
        if (Math.abs(i) < this.swipeActionsContainer.getItemsMinWidth()) {
            int minVisibleWidth = this.swipeActionsContainer.getMinVisibleWidth();
            if (this.swipeDirection != 0) {
                minVisibleWidth = this.swipeActionsContainer.getItemsMinWidth() - minVisibleWidth;
            }
            startSwipeAnimator(this.swipeOffset, Math.abs(this.swipeOffset) > minVisibleWidth ? Math.signum(this.swipeOffset) * this.swipeActionsContainer.getItemsMinWidth() : 0.0f);
            return;
        }
        this.isAutoSwipe = false;
        if (Math.abs(this.swipeOffset) > getAutoActionWidth() && ((isRightArea() && this.swipeProvider.getAllowEndFullSwipe()) || (isLeftArea() && this.swipeProvider.getAllowStartFullSwipe()))) {
            int i2 = this.swipeOffset;
            startSwipeAnimator(i2, Math.signum(i2) * this.viewPortWidthProvider.getViewPortWidth());
            this.isAutoSwipe = true;
        }
        if (this.isAutoSwipe) {
            return;
        }
        int i3 = this.swipeOffset;
        startSwipeAnimator(i3, Math.signum(i3) * this.swipeActionsContainer.getItemsMinWidth());
    }

    public void onHorizontalOverScroll(int i) {
        if (isSupportSwipes()) {
            cancelAnimations();
            int i2 = this.swipeOffset + i;
            if (isLeftArea()) {
                setSwipeOffset(Math.max(0, i2));
                return;
            }
            if (isRightArea()) {
                setSwipeOffset(Math.min(0, i2));
                return;
            }
            if ((i2 <= 0 || this.swipeProvider.getLeftSwipeButtons().length <= 0) && ((i2 >= 0 || this.swipeProvider.getRightSwipeButtons().length <= 0) && i2 != 0)) {
                return;
            }
            setSwipeOffset(i2);
        }
    }

    public boolean closeSwipeContainer() {
        if (!canSwipe()) {
            return false;
        }
        startSwipeAnimator(this.swipeOffset, 0.0f);
        return true;
    }

    public int getSwipeOffset() {
        return this.swipeOffset;
    }

    public boolean isAdditionalView() {
        return this.swipeActionsContainer != null;
    }

    public void setOnLayoutListener(OnLayoutListener onLayoutListener) {
        this.layoutListener = onLayoutListener;
    }

    @Override // com.devexpress.dxgrid.views.SwipeActionButton.OnTapListener
    public void onSwipeButtonTap(SwipeActionButton swipeActionButton) {
        startSwipeAnimator(this.swipeOffset, 0.0f);
        SwipeButtonAction action = swipeActionButton.getModel().getAction();
        if (action != null) {
            action.onTap(this.rowView.getRowIndex());
        }
    }
}
