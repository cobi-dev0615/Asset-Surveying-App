package com.devexpress.dxlistview.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.devexpress.dxlistview.IVirtualScrollView;
import com.devexpress.dxlistview.swipes.SwipesManager;

/* loaded from: classes2.dex */
public class GestureListener extends GestureDetector.SimpleOnGestureListener {
    private long _downTime;
    private float _downX;
    private float _downY;
    private final DragDropManager _dragDropManager;
    private final GestureDetector _gestureDetector;
    private final IVirtualScrollView _scrollView;
    private final SwipesManager _swipesManager;
    private boolean _useRippleEffect;
    private final long PRESSED_DELAY = 100;
    private final long RIPPLE_ANIMATION_DURATION = 300;
    private final Handler _timerHandler = new Handler(Looper.getMainLooper());
    private final Runnable _pressedAction = new Runnable() { // from class: com.devexpress.dxlistview.core.GestureListener$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            GestureListener.this.m454lambda$new$0$comdevexpressdxlistviewcoreGestureListener();
        }
    };
    private final Runnable _releasedAction = new Runnable() { // from class: com.devexpress.dxlistview.core.GestureListener$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            GestureListener.this.m455lambda$new$1$comdevexpressdxlistviewcoreGestureListener();
        }
    };

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    public GestureListener(Context context, IVirtualScrollView iVirtualScrollView, DragDropManager dragDropManager, SwipesManager swipesManager) {
        this._dragDropManager = dragDropManager;
        this._swipesManager = swipesManager;
        this._gestureDetector = new GestureDetector(context, this);
        this._scrollView = iVirtualScrollView;
    }

    /* renamed from: lambda$new$0$com-devexpress-dxlistview-core-GestureListener, reason: not valid java name */
    /* synthetic */ void m454lambda$new$0$comdevexpressdxlistviewcoreGestureListener() {
        this._scrollView.raisePressed(this._downX, this._downY);
    }

    /* renamed from: lambda$new$1$com-devexpress-dxlistview-core-GestureListener, reason: not valid java name */
    /* synthetic */ void m455lambda$new$1$comdevexpressdxlistviewcoreGestureListener() {
        this._scrollView.raiseReleased();
    }

    public boolean getUseRippleEffect() {
        return this._useRippleEffect;
    }

    public void setUseRippleEffect(boolean z) {
        this._useRippleEffect = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        if (r1 != 3) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r13) {
        /*
            r12 = this;
            android.view.GestureDetector r0 = r12._gestureDetector
            boolean r0 = r0.onTouchEvent(r13)
            int r1 = r13.getActionMasked()
            r2 = 100
            r4 = 1
            r5 = 0
            r7 = 0
            if (r1 == 0) goto L89
            r8 = 3
            if (r1 == r4) goto L3f
            r9 = 2
            if (r1 == r9) goto L1c
            if (r1 == r8) goto L3f
            goto La9
        L1c:
            com.devexpress.dxlistview.core.DragDropManager r1 = r12._dragDropManager
            boolean r1 = r1.isInDraggingProcess()
            if (r1 != 0) goto L2b
            com.devexpress.dxlistview.swipes.SwipesManager r1 = r12._swipesManager
            boolean r1 = r1.move(r13)
            goto L2c
        L2b:
            r1 = r7
        L2c:
            if (r1 != 0) goto L34
            com.devexpress.dxlistview.core.DragDropManager r1 = r12._dragDropManager
            boolean r1 = r1.move(r13)
        L34:
            if (r1 == 0) goto Laa
            boolean r13 = r12._useRippleEffect
            if (r13 == 0) goto Laa
            r12.release(r5)
            goto Laa
        L3f:
            com.devexpress.dxlistview.core.DragDropManager r1 = r12._dragDropManager
            boolean r1 = r1.isInDraggingProcess()
            if (r1 != 0) goto L4e
            com.devexpress.dxlistview.swipes.SwipesManager r1 = r12._swipesManager
            boolean r1 = r1.up(r13)
            goto L4f
        L4e:
            r1 = r7
        L4f:
            if (r1 != 0) goto L57
            com.devexpress.dxlistview.core.DragDropManager r1 = r12._dragDropManager
            boolean r1 = r1.up(r13)
        L57:
            boolean r9 = r12._useRippleEffect
            if (r9 != 0) goto L5c
            goto Laa
        L5c:
            int r13 = r13.getActionMasked()
            if (r13 != r8) goto L66
            r12.release(r5)
            goto Laa
        L66:
            long r8 = java.lang.System.currentTimeMillis()
            long r10 = r12._downTime
            long r8 = r8 - r10
            int r13 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r13 >= 0) goto L7c
            java.lang.Runnable r13 = r12._pressedAction
            r13.run()
            r2 = 300(0x12c, double:1.48E-321)
            r12.release(r2)
            goto Laa
        L7c:
            r2 = 400(0x190, double:1.976E-321)
            int r13 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r13 <= 0) goto L83
            goto L85
        L83:
            long r5 = r2 - r8
        L85:
            r12.release(r5)
            goto Laa
        L89:
            float r1 = r13.getX()
            r12._downX = r1
            float r13 = r13.getY()
            r12._downY = r13
            long r8 = java.lang.System.currentTimeMillis()
            r12._downTime = r8
            boolean r13 = r12._useRippleEffect
            if (r13 == 0) goto La9
            r12.release(r5)
            android.os.Handler r13 = r12._timerHandler
            java.lang.Runnable r1 = r12._pressedAction
            r13.postDelayed(r1, r2)
        La9:
            r1 = r7
        Laa:
            if (r1 != 0) goto Lb0
            if (r0 == 0) goto Laf
            goto Lb0
        Laf:
            r4 = r7
        Lb0:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.dxlistview.core.GestureListener.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void cancel() {
        this._swipesManager.cancel();
        this._dragDropManager.cancel();
    }

    void release(long j) {
        this._timerHandler.removeCallbacksAndMessages(null);
        this._timerHandler.postDelayed(this._releasedAction, j);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this._swipesManager.down(motionEvent);
        this._dragDropManager.down(motionEvent);
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        boolean onSingleTapUp = this._swipesManager.onSingleTapUp(motionEvent);
        return !onSingleTapUp ? this._dragDropManager.onSingleTapUp(motionEvent) : onSingleTapUp;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        boolean onSingleTapConfirmed = this._swipesManager.onSingleTapConfirmed(motionEvent);
        return !onSingleTapConfirmed ? this._dragDropManager.onSingleTapConfirmed(motionEvent) : onSingleTapConfirmed;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        boolean onDoubleTap = this._swipesManager.onDoubleTap(motionEvent);
        return !onDoubleTap ? this._dragDropManager.onDoubleTap(motionEvent) : onDoubleTap;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this._swipesManager.onLongPress(motionEvent);
        this._dragDropManager.onLongPress(motionEvent);
        this._scrollView.raiseItemLongPress(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this._swipesManager.onParentScroll(f, f2);
        return false;
    }
}
