package com.devexpress.dxgrid.views;

import android.content.Context;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.dxgrid.models.SwipeButtonModel;
import com.devexpress.dxgrid.providers.SwipeButtonViewProvider;

/* loaded from: classes2.dex */
public class SwipeActionButton extends ViewGroup {
    private final GestureDetector gestureDetector;
    private final boolean isSingleButton;
    private final SwipeButtonModel model;
    private int rowIndex;
    private final TapGestureListener tapGestureListener;

    public interface OnTapListener {
        void onSwipeButtonTap(SwipeActionButton swipeActionButton);
    }

    class TapGestureListener extends GestureDetector.SimpleOnGestureListener {
        private OnTapListener listener;
        private final SwipeActionButton swipeActionButton;

        public TapGestureListener(SwipeActionButton swipeActionButton) {
            this.swipeActionButton = swipeActionButton;
        }

        public void setTapListener(OnTapListener onTapListener) {
            this.listener = onTapListener;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            OnTapListener onTapListener = this.listener;
            if (onTapListener != null) {
                onTapListener.onSwipeButtonTap(this.swipeActionButton);
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    public SwipeActionButton(Context context, SwipeButtonModel swipeButtonModel, boolean z) {
        super(context);
        this.rowIndex = -1;
        this.model = swipeButtonModel;
        this.isSingleButton = z;
        setClickable(true);
        TapGestureListener tapGestureListener = new TapGestureListener(this);
        this.tapGestureListener = tapGestureListener;
        this.gestureDetector = new GestureDetector(context, tapGestureListener);
    }

    public void update(OnTapListener onTapListener, int i) {
        this.rowIndex = i;
        this.tapGestureListener.setTapListener(onTapListener);
    }

    public void reset() {
        removeAllViews();
    }

    public void setAutoActionProgress(float f) {
        KeyEvent.Callback contentView = getContentView();
        if (contentView instanceof ISupportAutoActionProgress) {
            ((ISupportAutoActionProgress) contentView).setAutoActionProgress(f);
        }
    }

    private View getContentView() {
        return getChildAt(0);
    }

    private void updateContentView() {
        View view;
        if (getChildCount() == 0) {
            SwipeButtonViewProvider viewProvider = this.model.getViewProvider();
            if (viewProvider != null) {
                view = viewProvider.getView(getContext(), this.rowIndex);
                if (view != null) {
                    view = new SwipeActionButtonWrapper(getContext(), view, this.model.getLocation(), this.model.getAppearance().getBackgroundColor(), this.isSingleButton, this.rowIndex);
                }
            } else {
                view = null;
            }
            if (view == null) {
                view = new SwipeActionButtonView(getContext(), this.model, this.isSingleButton);
            }
            addView(view);
        }
    }

    public SwipeButtonModel getModel() {
        return this.model;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec;
        updateContentView();
        View contentView = getContentView();
        int width = this.model.getAppearance().getWidth();
        if (width > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, BasicMeasure.EXACTLY);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        contentView.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
        setMeasuredDimension(contentView.getMeasuredWidth(), contentView.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        getContentView().layout(0, 0, i3 - i, i4 - i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.gestureDetector.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.gestureDetector.onTouchEvent(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }
}
