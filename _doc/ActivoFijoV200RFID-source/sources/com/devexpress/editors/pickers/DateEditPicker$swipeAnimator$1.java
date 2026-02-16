package com.devexpress.editors.pickers;

import android.animation.ValueAnimator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DateEditPicker.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\n2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0014"}, d2 = {"com/devexpress/editors/pickers/DateEditPicker$swipeAnimator$1", "Landroid/animation/ValueAnimator;", "endAnimationAction", "Lkotlin/Function0;", "", "getEndAnimationAction", "()Lkotlin/jvm/functions/Function0;", "setEndAnimationAction", "(Lkotlin/jvm/functions/Function0;)V", "endOffset", "", "getEndOffset", "()I", "setEndOffset", "(I)V", "startOffset", "getStartOffset", "setStartOffset", "startTo", TypedValues.CycleType.S_WAVE_OFFSET, "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DateEditPicker$swipeAnimator$1 extends ValueAnimator {
    private Function0<Unit> endAnimationAction = new Function0<Unit>() { // from class: com.devexpress.editors.pickers.DateEditPicker$swipeAnimator$1$endAnimationAction$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    };
    private int endOffset;
    private int startOffset;
    final /* synthetic */ DateEditPicker this$0;

    DateEditPicker$swipeAnimator$1(DateEditPicker dateEditPicker) {
        this.this$0 = dateEditPicker;
    }

    public final int getStartOffset() {
        return this.startOffset;
    }

    public final void setStartOffset(int i) {
        this.startOffset = i;
    }

    public final int getEndOffset() {
        return this.endOffset;
    }

    public final void setEndOffset(int i) {
        this.endOffset = i;
    }

    public final Function0<Unit> getEndAnimationAction() {
        return this.endAnimationAction;
    }

    public final void setEndAnimationAction(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.endAnimationAction = function0;
    }

    public final void startTo(int offset, Function0<Unit> endAnimationAction) {
        int i;
        Intrinsics.checkNotNullParameter(endAnimationAction, "endAnimationAction");
        if (isRunning()) {
            end();
        }
        i = this.this$0.currentOffset;
        this.startOffset = i;
        this.endOffset = offset;
        this.endAnimationAction = endAnimationAction;
        start();
    }
}
