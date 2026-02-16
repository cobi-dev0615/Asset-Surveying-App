package com.devexpress.editors;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006\u001d"}, d2 = {"com/devexpress/editors/Chip$chipAnimator$1", "Landroid/animation/ValueAnimator;", "checkIconAlphaFrom", "", "getCheckIconAlphaFrom", "()F", "setCheckIconAlphaFrom", "(F)V", "checkIconAlphaTo", "getCheckIconAlphaTo", "setCheckIconAlphaTo", "chipIconTranslationDelta", "getChipIconTranslationDelta", "setChipIconTranslationDelta", "contentViewTranslationDelta", "Landroid/graphics/PointF;", "getContentViewTranslationDelta", "()Landroid/graphics/PointF;", "setContentViewTranslationDelta", "(Landroid/graphics/PointF;)V", "rightBoundFrom", "", "getRightBoundFrom", "()I", "setRightBoundFrom", "(I)V", "rightBoundTo", "getRightBoundTo", "setRightBoundTo", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Chip$chipAnimator$1 extends ValueAnimator {
    private float checkIconAlphaFrom;
    private float checkIconAlphaTo;
    private float chipIconTranslationDelta;
    private PointF contentViewTranslationDelta = new PointF();
    private int rightBoundFrom;
    private int rightBoundTo;

    Chip$chipAnimator$1() {
    }

    public final PointF getContentViewTranslationDelta() {
        return this.contentViewTranslationDelta;
    }

    public final void setContentViewTranslationDelta(PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<set-?>");
        this.contentViewTranslationDelta = pointF;
    }

    public final int getRightBoundFrom() {
        return this.rightBoundFrom;
    }

    public final void setRightBoundFrom(int i) {
        this.rightBoundFrom = i;
    }

    public final int getRightBoundTo() {
        return this.rightBoundTo;
    }

    public final void setRightBoundTo(int i) {
        this.rightBoundTo = i;
    }

    public final float getCheckIconAlphaFrom() {
        return this.checkIconAlphaFrom;
    }

    public final void setCheckIconAlphaFrom(float f) {
        this.checkIconAlphaFrom = f;
    }

    public final float getCheckIconAlphaTo() {
        return this.checkIconAlphaTo;
    }

    public final void setCheckIconAlphaTo(float f) {
        this.checkIconAlphaTo = f;
    }

    public final float getChipIconTranslationDelta() {
        return this.chipIconTranslationDelta;
    }

    public final void setChipIconTranslationDelta(float f) {
        this.chipIconTranslationDelta = f;
    }
}
