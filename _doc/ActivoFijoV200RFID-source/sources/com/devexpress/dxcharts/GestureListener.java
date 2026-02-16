package com.devexpress.dxcharts;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: ChartBase.java */
/* loaded from: classes.dex */
class GestureListener implements GestureDetector.OnGestureListener, OnTouchEventListener {
    private ChartBase chartBase;
    private GestureDetector gestureDetector;

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // com.devexpress.dxcharts.OnTouchEventListener
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    public GestureListener(Context context, ChartBase chartBase) {
        this.chartBase = chartBase;
        this.gestureDetector = new GestureDetector(context, this);
    }

    @Override // com.devexpress.dxcharts.OnTouchEventListener
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.gestureDetector.onTouchEvent(motionEvent);
        if (onTouchEvent || motionEvent.getAction() != 0) {
            return onTouchEvent;
        }
        return true;
    }

    ChartBase getChartBase() {
        return this.chartBase;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.chartBase.singleTap(motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.chartBase.longPress(motionEvent.getX(), motionEvent.getY());
    }
}
