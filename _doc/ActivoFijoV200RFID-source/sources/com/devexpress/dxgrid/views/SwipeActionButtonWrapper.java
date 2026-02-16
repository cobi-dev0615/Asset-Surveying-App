package com.devexpress.dxgrid.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.devexpress.dxgrid.models.SwipeButtonModel;

/* loaded from: classes2.dex */
public class SwipeActionButtonWrapper extends ViewGroup implements ISupportAutoActionProgress {
    private float autoActionProgress;
    private final View content;
    private final boolean isSingleMode;
    private final SwipeButtonModel.Location location;

    public SwipeActionButtonWrapper(Context context, View view, SwipeButtonModel.Location location, int i, boolean z, int i2) {
        super(context);
        this.autoActionProgress = 0.0f;
        addView(view);
        this.content = view;
        this.isSingleMode = z;
        this.location = location;
        setBackgroundColor(i);
    }

    @Override // com.devexpress.dxgrid.views.ISupportAutoActionProgress
    public void setAutoActionProgress(float f) {
        if (this.isSingleMode) {
            this.autoActionProgress = f;
            layout();
        }
    }

    private void layout() {
        int i;
        int measuredWidth = this.content.getMeasuredWidth();
        int max = (int) (Math.max(0, getWidth() - measuredWidth) * this.autoActionProgress);
        if (!(this.isSingleMode && this.location == SwipeButtonModel.Location.Start) && (this.isSingleMode || this.location != SwipeButtonModel.Location.End)) {
            int width = getWidth() - max;
            max = width - measuredWidth;
            i = width;
        } else {
            i = measuredWidth + max;
        }
        this.content.layout(max, 0, i, getHeight());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.content.measure(i, i2);
        setMeasuredDimension(this.content.getMeasuredWidth(), View.MeasureSpec.getSize(i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layout();
    }
}
