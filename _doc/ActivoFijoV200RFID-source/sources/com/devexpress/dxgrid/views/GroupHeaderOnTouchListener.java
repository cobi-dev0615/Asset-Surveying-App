package com.devexpress.dxgrid.views;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.devexpress.dxgrid.models.GridElement;
import com.devexpress.dxgrid.providers.GridAction;

/* compiled from: GridGroupHeaderView.java */
/* loaded from: classes2.dex */
class GroupHeaderOnTouchListener implements View.OnTouchListener {
    private GestureDetector gestureDetector;
    private int rowIndex = -1;

    public GroupHeaderOnTouchListener(Context context, final GridAction gridAction) {
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.devexpress.dxgrid.views.GroupHeaderOnTouchListener.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                gridAction.cellDoubleTap(GridElement.GroupRow, GroupHeaderOnTouchListener.this.rowIndex, -1);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                gridAction.cellTap(GridElement.GroupRow, GroupHeaderOnTouchListener.this.rowIndex, -1);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                gridAction.cellLongPress(GridElement.GroupRow, GroupHeaderOnTouchListener.this.rowIndex, -1);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                gridAction.cellTapConfirmed(GridElement.GroupRow, GroupHeaderOnTouchListener.this.rowIndex, -1);
                return true;
            }
        });
    }

    public void setRowIndex(int i) {
        this.rowIndex = i;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.onTouchEvent(motionEvent)) {
            return true;
        }
        return this.gestureDetector.onTouchEvent(motionEvent);
    }
}
