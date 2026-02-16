package com.devexpress.dxcharts;

import android.view.MotionEvent;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ChartBase.java */
/* loaded from: classes.dex */
class TouchListenersCombiner implements View.OnTouchListener {
    private final List<View.OnTouchListener> listeners = new LinkedList();

    TouchListenersCombiner() {
    }

    public void addListener(View.OnTouchListener onTouchListener) {
        this.listeners.add(onTouchListener);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Iterator<View.OnTouchListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            if (it.next().onTouch(view, motionEvent)) {
                view.performClick();
                return true;
            }
        }
        return false;
    }
}
