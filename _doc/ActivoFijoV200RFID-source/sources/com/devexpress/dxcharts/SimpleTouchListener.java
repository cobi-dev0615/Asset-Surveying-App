package com.devexpress.dxcharts;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: ChartBase.java */
/* loaded from: classes.dex */
class SimpleTouchListener implements View.OnTouchListener {
    private final OnTouchEventFunction touchEventFunction;

    public SimpleTouchListener(OnTouchEventFunction onTouchEventFunction) {
        this.touchEventFunction = onTouchEventFunction;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.touchEventFunction.onTouch(motionEvent)) {
            return false;
        }
        view.performClick();
        return true;
    }
}
