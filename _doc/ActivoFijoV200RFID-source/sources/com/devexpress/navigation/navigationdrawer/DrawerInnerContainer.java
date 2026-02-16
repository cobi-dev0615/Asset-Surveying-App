package com.devexpress.navigation.navigationdrawer;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* loaded from: classes2.dex */
public class DrawerInnerContainer extends LinearLayout {
    IOnDrawListener mListener;

    public interface IOnDrawListener {
        void drawChild(Canvas canvas, View view, long j);
    }

    public DrawerInnerContainer(Context context) {
        super(context);
    }

    public DrawerInnerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DrawerInnerContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnNativeDrawListener(IOnDrawListener iOnDrawListener) {
        this.mListener = iOnDrawListener;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        IOnDrawListener iOnDrawListener = this.mListener;
        if (iOnDrawListener != null) {
            iOnDrawListener.drawChild(canvas, view, j);
        }
        return drawChild;
    }
}
