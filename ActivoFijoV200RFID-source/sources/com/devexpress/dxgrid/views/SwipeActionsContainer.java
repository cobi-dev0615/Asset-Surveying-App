package com.devexpress.dxgrid.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import com.devexpress.dxgrid.models.SwipeButtonModel;
import com.devexpress.dxgrid.providers.SwipeButtonAction;
import com.devexpress.dxgrid.views.SwipeActionButton;
import java.util.List;

/* loaded from: classes2.dex */
public class SwipeActionsContainer extends ViewGroup {
    private final ValueAnimator animator;
    private float autoActionProgress;
    private boolean isAutoAction;
    private int itemsMaxWidth;
    private int lineThickness;
    private final Paint paint;
    private final Position position;
    private final int swipeItemsCount;

    public enum Position {
        Left,
        Right
    }

    public SwipeActionsContainer(Context context, Position position, List<SwipeButtonModel> list) {
        super(context);
        this.lineThickness = 0;
        this.isAutoAction = false;
        this.autoActionProgress = 0.0f;
        this.itemsMaxWidth = 0;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.position = position;
        this.swipeItemsCount = list.size();
        for (SwipeButtonModel swipeButtonModel : list) {
            boolean z = true;
            if (list.size() != 1) {
                z = false;
            }
            addView(new SwipeActionButton(context, swipeButtonModel, z), 0);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        this.animator = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.devexpress.dxgrid.views.SwipeActionsContainer.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                SwipeActionsContainer.this.autoActionProgress = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                if (SwipeActionsContainer.this.getChildCount() == 1) {
                    ((SwipeActionButton) SwipeActionsContainer.this.getChildAt(0)).setAutoActionProgress(SwipeActionsContainer.this.autoActionProgress);
                }
                SwipeActionsContainer.this.layout();
            }
        });
        setWillNotDraw(false);
    }

    private SwipeActionButton getDefaultButton() {
        int indexOfLastVisible = getIndexOfLastVisible();
        if (indexOfLastVisible >= 0) {
            return (SwipeActionButton) getChildAt(indexOfLastVisible);
        }
        return null;
    }

    public void processDefaultAction(int i) {
        SwipeButtonAction action;
        SwipeActionButton defaultButton = getDefaultButton();
        if (defaultButton == null || (action = defaultButton.getModel().getAction()) == null) {
            return;
        }
        action.onTap(i);
    }

    public Position getPosition() {
        return this.position;
    }

    public int getItemsMinWidth() {
        return this.itemsMaxWidth;
    }

    public int getMinVisibleWidth() {
        if (getChildCount() > 0) {
            return (this.itemsMaxWidth / getChildCount()) / 2;
        }
        return 0;
    }

    public int getSwipeItemsCount() {
        return this.swipeItemsCount;
    }

    public void setAutoAction(boolean z) {
        if (this.isAutoAction != z) {
            this.animator.cancel();
            this.isAutoAction = z;
            this.animator.setFloatValues(this.autoActionProgress, z ? 1.0f : 0.0f);
            this.animator.start();
        }
    }

    public void update(SwipeActionButton.OnTapListener onTapListener, int i, int i2, int i3) {
        this.lineThickness = i2;
        this.paint.setColor(i3);
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            ((SwipeActionButton) getChildAt(i4)).update(onTapListener, i);
        }
    }

    public void reset() {
        this.animator.cancel();
        this.autoActionProgress = 0.0f;
        this.lineThickness = 0;
        this.paint.setColor(0);
        for (int i = 0; i < getChildCount(); i++) {
            ((SwipeActionButton) getChildAt(i)).reset();
        }
    }

    private int getIndexOfLastVisible() {
        if (getChildCount() == 0) {
            return -1;
        }
        int childCount = getChildCount() - 1;
        while (childCount >= 0 && getChildAt(childCount).getMeasuredWidth() == 0) {
            childCount--;
        }
        return childCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void layout() {
        int indexOfLastVisible;
        int childCount = getChildCount();
        int width = getWidth();
        int max = Math.max(getHeight() - this.lineThickness, 0);
        if (childCount <= 0 || this.itemsMaxWidth <= 0 || (indexOfLastVisible = getIndexOfLastVisible()) < 0) {
            return;
        }
        int max2 = Math.max(0, width - this.itemsMaxWidth) + (childCount > 1 ? (int) ((this.itemsMaxWidth - getChildAt(indexOfLastVisible).getMeasuredWidth()) * this.autoActionProgress) : 0);
        int i = indexOfLastVisible;
        while (i >= 0) {
            int measuredWidth = getChildAt(i).getMeasuredWidth();
            if (measuredWidth != 0) {
                int i2 = i == indexOfLastVisible ? 0 : max2;
                max2 += measuredWidth;
                if (this.position == Position.Left) {
                    getChildAt(i).layout(i2, 0, max2, max);
                } else {
                    getChildAt(i).layout(width - max2, 0, width - i2, max);
                }
            }
            i--;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.itemsMaxWidth = 0;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int makeMeasureSpec = (mode == 0 || size <= 0) ? i2 : View.MeasureSpec.makeMeasureSpec(Math.max(size - this.lineThickness, 0), mode);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            childAt.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
            this.itemsMaxWidth += childAt.getMeasuredWidth();
        }
        setMeasuredDimension(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layout();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0.0f, getHeight() - this.lineThickness, getWidth(), getHeight(), this.paint);
    }
}
