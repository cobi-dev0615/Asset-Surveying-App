package com.devexpress.dxgrid.views;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.devexpress.dxgrid.interfaces.InplaceEditingService;
import com.devexpress.dxgrid.models.GridElement;
import com.devexpress.dxgrid.providers.GridAction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnTouchListener.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/devexpress/dxgrid/views/OnTouchListener;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "gridAction", "Lcom/devexpress/dxgrid/providers/GridAction;", "gridRowView", "Lcom/devexpress/dxgrid/views/GridRowViewBase;", "editingService", "Lcom/devexpress/dxgrid/interfaces/InplaceEditingService;", "columnIndex", "", "runnableGetter", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "(Landroid/content/Context;Lcom/devexpress/dxgrid/providers/GridAction;Lcom/devexpress/dxgrid/views/GridRowViewBase;Lcom/devexpress/dxgrid/interfaces/InplaceEditingService;ILkotlin/jvm/functions/Function0;)V", "gestureDetector", "Landroid/view/GestureDetector;", "tapX", "", "tapY", "onTouch", "", "v", "Landroid/view/View;", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OnTouchListener implements View.OnTouchListener {
    private final GestureDetector gestureDetector;
    private float tapX;
    private float tapY;

    public OnTouchListener(Context context, final GridAction gridAction, final GridRowViewBase gridRowView, final InplaceEditingService editingService, final int i, final Function0<? extends Runnable> runnableGetter) {
        Intrinsics.checkNotNullParameter(gridAction, "gridAction");
        Intrinsics.checkNotNullParameter(gridRowView, "gridRowView");
        Intrinsics.checkNotNullParameter(editingService, "editingService");
        Intrinsics.checkNotNullParameter(runnableGetter, "runnableGetter");
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.devexpress.dxgrid.views.OnTouchListener.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                InplaceEditingService.this.tap(gridRowView.getRowIndex(), i, this.tapX, this.tapY);
                gridAction.cellDoubleTap(GridElement.Row, gridRowView.getRowIndex(), i);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                if (gridRowView.onSingleTapUp()) {
                    return true;
                }
                InplaceEditingService.this.tap(gridRowView.getRowIndex(), i, this.tapX, this.tapY);
                gridAction.cellTap(GridElement.Row, gridRowView.getRowIndex(), i);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                InplaceEditingService.this.tap(gridRowView.getRowIndex(), i, this.tapX, this.tapY);
                gridAction.cellLongPress(GridElement.Row, gridRowView.getRowIndex(), i);
                Runnable invoke = runnableGetter.invoke();
                if (invoke != null) {
                    invoke.run();
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                gridAction.cellTapConfirmed(GridElement.Row, gridRowView.getRowIndex(), i);
                return true;
            }
        });
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        this.tapX = event.getX();
        this.tapY = event.getY();
        if (v.onTouchEvent(event)) {
            return true;
        }
        return this.gestureDetector.onTouchEvent(event);
    }
}
