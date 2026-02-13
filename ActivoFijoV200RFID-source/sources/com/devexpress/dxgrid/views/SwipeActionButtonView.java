package com.devexpress.dxgrid.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.devexpress.dxgrid.R;
import com.devexpress.dxgrid.models.IImageChangedListener;
import com.devexpress.dxgrid.models.SwipeButtonModel;
import com.devexpress.dxgrid.models.appearance.SwipeAppearance;
import com.devexpress.dxgrid.utils.BitMaskHelper;

/* loaded from: classes2.dex */
public class SwipeActionButtonView extends ViewGroup implements ISupportAutoActionProgress, IImageChangedListener {
    private float autoActionProgress;
    private final boolean isSingleMode;
    private final View layout;
    private final SwipeButtonModel model;

    public SwipeActionButtonView(Context context, SwipeButtonModel swipeButtonModel, boolean z) {
        super(context);
        float f = 0.0f;
        this.autoActionProgress = 0.0f;
        this.model = swipeButtonModel;
        swipeButtonModel.setImageListener(this);
        this.isSingleMode = z;
        inflate(getContext(), R.layout.swipe_button, this);
        SwipeAppearance appearance = swipeButtonModel.getAppearance();
        this.layout = findViewById(R.id.swipe_button_layout);
        TextView textView = (TextView) findViewById(R.id.swipe_button_text);
        String text = swipeButtonModel.getText();
        textView.setText(text);
        if (text != null && !text.isEmpty()) {
            f = appearance.getTextSize();
        }
        textView.setTextSize(2, f);
        textView.setTypeface(appearance.getTypeface());
        textView.setTextColor(appearance.getTextColor());
        textView.setPaintFlags(BitMaskHelper.INSTANCE.setFlag(BitMaskHelper.INSTANCE.setFlag(textView.getPaintFlags(), 8, appearance.getTextIsUnderlined()), 16, appearance.getTextIsStrikethrough()));
        UpdateImage();
        setBackgroundColor(appearance.getBackgroundColor());
    }

    @Override // com.devexpress.dxgrid.views.ISupportAutoActionProgress
    public void setAutoActionProgress(float f) {
        if (this.isSingleMode) {
            this.autoActionProgress = f;
            layout();
        }
    }

    @Override // com.devexpress.dxgrid.models.IImageChangedListener
    public void onImageChanged() {
        UpdateImage();
    }

    private void UpdateImage() {
        ((ImageView) findViewById(R.id.swipe_button_image)).setImageDrawable(this.model.getImage());
    }

    private void layout() {
        int i;
        int measuredWidth = this.layout.getMeasuredWidth();
        int max = (int) (Math.max(0, getWidth() - measuredWidth) * this.autoActionProgress);
        SwipeButtonModel.Location location = this.model.getLocation();
        if (!(this.isSingleMode && location == SwipeButtonModel.Location.Start) && (this.isSingleMode || location != SwipeButtonModel.Location.End)) {
            int width = getWidth() - max;
            max = width - measuredWidth;
            i = width;
        } else {
            i = measuredWidth + max;
        }
        this.layout.layout(max, 0, i, getHeight());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.layout.measure(i, i2);
        setMeasuredDimension(this.layout.getMeasuredWidth(), View.MeasureSpec.getSize(i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layout();
    }
}
