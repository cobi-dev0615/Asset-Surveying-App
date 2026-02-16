package com.devexpress.dxcharts;

import android.view.MotionEvent;

/* compiled from: ChartBase.java */
/* loaded from: classes.dex */
interface OnTouchEventListener {
    boolean onInterceptTouchEvent(MotionEvent motionEvent);

    boolean onTouchEvent(MotionEvent motionEvent);
}
