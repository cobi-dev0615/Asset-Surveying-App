package com.devexpress.editors.pickers;

import android.content.Context;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import com.devexpress.editors.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DateEditPicker.kt */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"com/devexpress/editors/pickers/DateEditPicker$scrollGestureDetector$1", "", "scrollThreshold", "", "scrolling", "", "startX", "", "startY", "processActionDown", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "processActionMove", "processActionUp", "processEvent", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DateEditPicker$scrollGestureDetector$1 {
    private final int scrollThreshold;
    private boolean scrolling;
    private float startX;
    private float startY;
    final /* synthetic */ DateEditPicker this$0;

    DateEditPicker$scrollGestureDetector$1(Context context, DateEditPicker dateEditPicker) {
        this.this$0 = dateEditPicker;
        this.scrollThreshold = context.getResources().getDimensionPixelSize(R.dimen.date_edit_picker_scroll_threshold);
    }

    private final boolean processActionDown(MotionEvent event) {
        DateEditPicker$velocityTracker$1 dateEditPicker$velocityTracker$1;
        this.startX = event.getX();
        this.startY = event.getY();
        dateEditPicker$velocityTracker$1 = this.this$0.velocityTracker;
        dateEditPicker$velocityTracker$1.startTracking(event.getX());
        return false;
    }

    private final boolean processActionMove(MotionEvent event) {
        DateEditPicker$velocityTracker$1 dateEditPicker$velocityTracker$1;
        float x = event.getX() - this.startX;
        float y = event.getY() - this.startY;
        dateEditPicker$velocityTracker$1 = this.this$0.velocityTracker;
        dateEditPicker$velocityTracker$1.updatePosition(event.getX());
        if (this.scrolling) {
            this.this$0.offsetViews((int) x);
            return true;
        }
        if (Math.abs(x) <= Math.abs(y) || Math.abs(x) <= this.scrollThreshold) {
            return false;
        }
        this.startX = event.getX();
        this.this$0.getParent().requestDisallowInterceptTouchEvent(true);
        this.scrolling = true;
        event.setAction(3);
        return false;
    }

    private final boolean processActionUp(MotionEvent event) {
        DateEditPicker$velocityTracker$1 dateEditPicker$velocityTracker$1;
        DateEditPicker$velocityTracker$1 dateEditPicker$velocityTracker$12;
        DateEditPicker$velocityTracker$1 dateEditPicker$velocityTracker$13;
        DateEditPicker$swipeAnimator$1 dateEditPicker$swipeAnimator$1;
        this.this$0.getParent().requestDisallowInterceptTouchEvent(false);
        dateEditPicker$velocityTracker$1 = this.this$0.velocityTracker;
        dateEditPicker$velocityTracker$1.updatePosition(event.getX());
        if (!this.scrolling) {
            return false;
        }
        this.scrolling = false;
        float x = event.getX() - this.startX;
        float width = this.this$0.getWidth() * 0.33f;
        this.this$0.currentOffset = (int) x;
        if (x >= (-width)) {
            dateEditPicker$velocityTracker$12 = this.this$0.velocityTracker;
            if (dateEditPicker$velocityTracker$12.getAverageVelocity() >= -0.5d) {
                if (x <= width) {
                    dateEditPicker$velocityTracker$13 = this.this$0.velocityTracker;
                    if (dateEditPicker$velocityTracker$13.getAverageVelocity() <= 0.5d) {
                        dateEditPicker$swipeAnimator$1 = this.this$0.swipeAnimator;
                        dateEditPicker$swipeAnimator$1.startTo(0, new Function0<Unit>() { // from class: com.devexpress.editors.pickers.DateEditPicker$scrollGestureDetector$1$processActionUp$1
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }
                        });
                        return true;
                    }
                }
                this.this$0.backward(true);
                return true;
            }
        }
        this.this$0.forward(true);
        return true;
    }

    public final boolean processEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction() & 255;
        if (action == 0) {
            return processActionDown(event);
        }
        if (action != 1) {
            if (action == 2) {
                return processActionMove(event);
            }
            if (action != 3) {
                return false;
            }
        }
        return processActionUp(event);
    }
}
