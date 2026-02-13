package com.devexpress.editors.pickers;

import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* compiled from: CalendarCellView.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007¨\u0006\u0010"}, d2 = {"com/devexpress/editors/pickers/CalendarCellView$markColorAnimator$1", "Landroid/animation/ValueAnimator;", "current", "", "getCurrent", "()I", "setCurrent", "(I)V", TypedValues.TransitionType.S_FROM, "getFrom", "setFrom", TypedValues.TransitionType.S_TO, "getTo", "setTo", "animateTo", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CalendarCellView$markColorAnimator$1 extends ValueAnimator {
    private int current;
    private int from;
    final /* synthetic */ CalendarCellView this$0;
    private int to;

    CalendarCellView$markColorAnimator$1(CalendarCellView calendarCellView) {
        this.this$0 = calendarCellView;
    }

    public final int getFrom() {
        return this.from;
    }

    public final void setFrom(int i) {
        this.from = i;
    }

    public final int getTo() {
        return this.to;
    }

    public final void setTo(int i) {
        this.to = i;
    }

    public final int getCurrent() {
        return this.current;
    }

    public final void setCurrent(int i) {
        this.current = i;
    }

    public final void animateTo(int to) {
        boolean z;
        GradientDrawable gradientDrawable;
        if (to != this.current) {
            z = this.this$0.isRecycled;
            if (z) {
                cancel();
                this.current = to;
                gradientDrawable = this.this$0.cellMarkDrawable;
                gradientDrawable.setColor(to);
                return;
            }
            this.from = this.current;
            this.to = to;
            start();
            return;
        }
        cancel();
    }
}
