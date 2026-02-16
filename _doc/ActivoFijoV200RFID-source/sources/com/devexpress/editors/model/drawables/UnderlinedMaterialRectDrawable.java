package com.devexpress.editors.model.drawables;

import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.devexpress.editors.model.BorderRounds;
import com.devexpress.editors.model.drawables.AbstractMaterialRectDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnderlinedMaterialRectDrawable.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB%\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u000f\b\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0002\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0016R$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/devexpress/editors/model/drawables/UnderlinedMaterialRectDrawable;", "Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable;", "Lcom/devexpress/editors/model/drawables/UnderlinedMaterialRectDrawable$State;", "cornerTreatment", "Lcom/devexpress/editors/model/drawables/CornerTreatment;", "cornerSize", "Lcom/devexpress/editors/model/BorderRounds;", "paintStyle", "Landroid/graphics/Paint$Style;", "(Lcom/devexpress/editors/model/drawables/CornerTreatment;Lcom/devexpress/editors/model/BorderRounds;Landroid/graphics/Paint$Style;)V", "drawableState", "(Lcom/devexpress/editors/model/drawables/UnderlinedMaterialRectDrawable$State;)V", "value", "getCornerSize", "()Lcom/devexpress/editors/model/BorderRounds;", "setCornerSize", "(Lcom/devexpress/editors/model/BorderRounds;)V", "underlinePathBuilder", "Lcom/devexpress/editors/model/drawables/UnderlinePathBuilder;", "calculateStrokePath", "", "getFillBounds", "Landroid/graphics/RectF;", "getStrokeBounds", "mutate", "Landroid/graphics/drawable/Drawable;", "State", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UnderlinedMaterialRectDrawable extends AbstractMaterialRectDrawable<State> {
    private final UnderlinePathBuilder underlinePathBuilder;

    public UnderlinedMaterialRectDrawable() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnderlinedMaterialRectDrawable(CornerTreatment cornerTreatment) {
        this(cornerTreatment, null, null, 6, null);
        Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnderlinedMaterialRectDrawable(CornerTreatment cornerTreatment, BorderRounds cornerSize) {
        this(cornerTreatment, cornerSize, null, 4, null);
        Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
        Intrinsics.checkNotNullParameter(cornerSize, "cornerSize");
    }

    public /* synthetic */ UnderlinedMaterialRectDrawable(State state, DefaultConstructorMarker defaultConstructorMarker) {
        this(state);
    }

    private UnderlinedMaterialRectDrawable(State state) {
        super(state);
        this.underlinePathBuilder = new UnderlinePathBuilder();
    }

    public /* synthetic */ UnderlinedMaterialRectDrawable(RoundCornerTreatment roundCornerTreatment, BorderRounds borderRounds, Paint.Style style, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new RoundCornerTreatment() : roundCornerTreatment, (i & 2) != 0 ? new BorderRounds(0) : borderRounds, (i & 4) != 0 ? Paint.Style.FILL_AND_STROKE : style);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public UnderlinedMaterialRectDrawable(com.devexpress.editors.model.drawables.CornerTreatment r5, com.devexpress.editors.model.BorderRounds r6, android.graphics.Paint.Style r7) {
        /*
            r4 = this;
            java.lang.String r0 = "cornerTreatment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "cornerSize"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "paintStyle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.devexpress.editors.model.drawables.UnderlinedMaterialRectDrawable$State r0 = new com.devexpress.editors.model.drawables.UnderlinedMaterialRectDrawable$State
            float r1 = r6.topLeft
            float r2 = r6.topRight
            r3 = 0
            com.devexpress.editors.model.BorderRounds r6 = r6.set(r1, r2, r3, r3)
            java.lang.String r1 = "set(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            r0.<init>(r5, r6, r7)
            r4.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.editors.model.drawables.UnderlinedMaterialRectDrawable.<init>(com.devexpress.editors.model.drawables.CornerTreatment, com.devexpress.editors.model.BorderRounds, android.graphics.Paint$Style):void");
    }

    @Override // com.devexpress.editors.model.drawables.AbstractMaterialRectDrawable
    public BorderRounds getCornerSize() {
        return super.getCornerSize();
    }

    @Override // com.devexpress.editors.model.drawables.AbstractMaterialRectDrawable
    public void setCornerSize(BorderRounds value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.topLeft == getDrawableState().cornerSize.topLeft && value.topRight == getDrawableState().cornerSize.topRight) {
            return;
        }
        getDrawableState().cornerSize.set(value.topLeft, value.topRight, 0.0f, 0.0f);
        setPathsNeedUpdate(true);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        setDrawableState(new State(getDrawableState()));
        return this;
    }

    @Override // com.devexpress.editors.model.drawables.AbstractMaterialRectDrawable
    protected void calculateStrokePath() {
        getAdjustedCornerSize().setAdjusted(getDrawableState().cornerSize, -getStrokeAdjustment());
        this.underlinePathBuilder.buildPath(getStrokeBounds(), getDrawableState().cornerTreatment, getAdjustedCornerSize(), getStrokePath());
    }

    @Override // com.devexpress.editors.model.drawables.AbstractMaterialRectDrawable
    protected RectF getFillBounds() {
        getBoundsF().set(getBounds());
        getBoundsF().offsetTo(0.0f, 0.0f);
        return getBoundsF();
    }

    @Override // com.devexpress.editors.model.drawables.AbstractMaterialRectDrawable
    protected RectF getStrokeBounds() {
        RectF fillBounds = getFillBounds();
        getInsetBoundsF().set(fillBounds.left, fillBounds.top, fillBounds.right, fillBounds.bottom - getStrokeAdjustment());
        return getInsetBoundsF();
    }

    /* compiled from: UnderlinedMaterialRectDrawable.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0002\u0010\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/devexpress/editors/model/drawables/UnderlinedMaterialRectDrawable$State;", "Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable$MaterialRectDrawableState;", "other", "(Lcom/devexpress/editors/model/drawables/UnderlinedMaterialRectDrawable$State;)V", "cornerTreatment", "Lcom/devexpress/editors/model/drawables/CornerTreatment;", "cornerSize", "Lcom/devexpress/editors/model/BorderRounds;", "paintStyle", "Landroid/graphics/Paint$Style;", "(Lcom/devexpress/editors/model/drawables/CornerTreatment;Lcom/devexpress/editors/model/BorderRounds;Landroid/graphics/Paint$Style;)V", "newDrawable", "Landroid/graphics/drawable/Drawable;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class State extends AbstractMaterialRectDrawable.MaterialRectDrawableState {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public State(CornerTreatment cornerTreatment, BorderRounds cornerSize, Paint.Style paintStyle) {
            super(cornerTreatment, cornerSize, paintStyle, false, 0, 0, 0, 120, null);
            Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
            Intrinsics.checkNotNullParameter(cornerSize, "cornerSize");
            Intrinsics.checkNotNullParameter(paintStyle, "paintStyle");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public State(State other) {
            this(other.cornerTreatment, other.cornerSize, other.paintStyle);
            Intrinsics.checkNotNullParameter(other, "other");
            this.changingConfigurationsValue = other.changingConfigurationsValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new UnderlinedMaterialRectDrawable(this, (DefaultConstructorMarker) null);
        }
    }
}
