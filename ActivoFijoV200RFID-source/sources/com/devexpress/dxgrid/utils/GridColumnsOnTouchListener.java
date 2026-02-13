package com.devexpress.dxgrid.utils;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.devexpress.dxgrid.models.GridElement;
import com.devexpress.dxgrid.providers.GridAction;

/* loaded from: classes2.dex */
public class GridColumnsOnTouchListener implements View.OnTouchListener {
    private GestureDetector gestureDetector;

    public GridColumnsOnTouchListener(Context context, final GridElement gridElement, final GridAction gridAction, final int i) {
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.devexpress.dxgrid.utils.GridColumnsOnTouchListener.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                gridAction.cellDoubleTap(gridElement, -1, i);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                gridAction.cellTap(gridElement, -1, i);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                gridAction.cellLongPress(gridElement, -1, i);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                gridAction.cellTapConfirmed(gridElement, -1, i);
                return true;
            }
        });
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.onTouchEvent(motionEvent)) {
            return true;
        }
        return this.gestureDetector.onTouchEvent(motionEvent);
    }
}
