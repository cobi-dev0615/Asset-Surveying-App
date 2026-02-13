package com.devexpress.navigation.navigationdrawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes2.dex */
public class ContentView extends ViewGroup {
    private View mContent;

    public ContentView(Context context) {
        super(context);
        setId(View.generateViewId());
    }

    public ContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ContentView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setContent(View view) {
        View view2 = this.mContent;
        if (view2 == view) {
            return;
        }
        if (view2 != null) {
            removeView(view2);
        }
        this.mContent = view;
        if (view != null) {
            addView(view, -1, -1);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0) {
            measureChild(getChildAt(0), i, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() > 0) {
            getChildAt(0).layout(0, 0, i3 - i, i4 - i2);
        }
    }
}
