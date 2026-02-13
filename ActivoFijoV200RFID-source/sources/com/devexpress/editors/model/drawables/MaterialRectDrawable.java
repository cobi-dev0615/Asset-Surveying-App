package com.devexpress.editors.model.drawables;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.devexpress.editors.model.BorderRounds;
import com.devexpress.editors.model.drawables.AbstractMaterialRectDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: MaterialRectDrawable.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014BM\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f¢\u0006\u0002\u0010\u000fB\u000f\b\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0015"}, d2 = {"Lcom/devexpress/editors/model/drawables/MaterialRectDrawable;", "Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable;", "Lcom/devexpress/editors/model/drawables/MaterialRectDrawable$State;", "cornerTreatment", "Lcom/devexpress/editors/model/drawables/CornerTreatment;", "cornerSize", "Lcom/devexpress/editors/model/BorderRounds;", "paintStyle", "Landroid/graphics/Paint$Style;", "hasShadow", "", "shadowRadius", "", "shadowOffset", "shadowRotation", "(Lcom/devexpress/editors/model/drawables/CornerTreatment;Lcom/devexpress/editors/model/BorderRounds;Landroid/graphics/Paint$Style;ZIII)V", "drawableState", "(Lcom/devexpress/editors/model/drawables/MaterialRectDrawable$State;)V", "mutate", "Landroid/graphics/drawable/Drawable;", "State", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class MaterialRectDrawable extends AbstractMaterialRectDrawable<State> {
    public MaterialRectDrawable() {
        this(null, null, null, false, 0, 0, 0, WorkQueueKt.MASK, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialRectDrawable(CornerTreatment cornerTreatment) {
        this(cornerTreatment, null, null, false, 0, 0, 0, 126, null);
        Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialRectDrawable(CornerTreatment cornerTreatment, BorderRounds cornerSize) {
        this(cornerTreatment, cornerSize, null, false, 0, 0, 0, 124, null);
        Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
        Intrinsics.checkNotNullParameter(cornerSize, "cornerSize");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialRectDrawable(CornerTreatment cornerTreatment, BorderRounds cornerSize, Paint.Style paintStyle) {
        this(cornerTreatment, cornerSize, paintStyle, false, 0, 0, 0, 120, null);
        Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
        Intrinsics.checkNotNullParameter(cornerSize, "cornerSize");
        Intrinsics.checkNotNullParameter(paintStyle, "paintStyle");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialRectDrawable(CornerTreatment cornerTreatment, BorderRounds cornerSize, Paint.Style paintStyle, boolean z) {
        this(cornerTreatment, cornerSize, paintStyle, z, 0, 0, 0, 112, null);
        Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
        Intrinsics.checkNotNullParameter(cornerSize, "cornerSize");
        Intrinsics.checkNotNullParameter(paintStyle, "paintStyle");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialRectDrawable(CornerTreatment cornerTreatment, BorderRounds cornerSize, Paint.Style paintStyle, boolean z, int i) {
        this(cornerTreatment, cornerSize, paintStyle, z, i, 0, 0, 96, null);
        Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
        Intrinsics.checkNotNullParameter(cornerSize, "cornerSize");
        Intrinsics.checkNotNullParameter(paintStyle, "paintStyle");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialRectDrawable(CornerTreatment cornerTreatment, BorderRounds cornerSize, Paint.Style paintStyle, boolean z, int i, int i2) {
        this(cornerTreatment, cornerSize, paintStyle, z, i, i2, 0, 64, null);
        Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
        Intrinsics.checkNotNullParameter(cornerSize, "cornerSize");
        Intrinsics.checkNotNullParameter(paintStyle, "paintStyle");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected MaterialRectDrawable(State drawableState) {
        super(drawableState);
        Intrinsics.checkNotNullParameter(drawableState, "drawableState");
    }

    public /* synthetic */ MaterialRectDrawable(RoundCornerTreatment roundCornerTreatment, BorderRounds borderRounds, Paint.Style style, boolean z, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? new RoundCornerTreatment() : roundCornerTreatment, (i4 & 2) != 0 ? new BorderRounds(0) : borderRounds, (i4 & 4) != 0 ? Paint.Style.FILL_AND_STROKE : style, (i4 & 8) != 0 ? false : z, (i4 & 16) != 0 ? 0 : i, (i4 & 32) != 0 ? 0 : i2, (i4 & 64) == 0 ? i3 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialRectDrawable(CornerTreatment cornerTreatment, BorderRounds cornerSize, Paint.Style paintStyle, boolean z, int i, int i2, int i3) {
        this(new State(cornerTreatment, cornerSize, paintStyle, z, i, i2, i3));
        Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
        Intrinsics.checkNotNullParameter(cornerSize, "cornerSize");
        Intrinsics.checkNotNullParameter(paintStyle, "paintStyle");
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        setDrawableState(new State(getDrawableState()));
        return this;
    }

    /* compiled from: MaterialRectDrawable.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0002\u0010\u0003B=\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/devexpress/editors/model/drawables/MaterialRectDrawable$State;", "Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable$MaterialRectDrawableState;", "other", "(Lcom/devexpress/editors/model/drawables/MaterialRectDrawable$State;)V", "cornerTreatment", "Lcom/devexpress/editors/model/drawables/CornerTreatment;", "cornerSize", "Lcom/devexpress/editors/model/BorderRounds;", "paintStyle", "Landroid/graphics/Paint$Style;", "hasShadow", "", "shadowRadius", "", "shadowOffset", "shadowRotation", "(Lcom/devexpress/editors/model/drawables/CornerTreatment;Lcom/devexpress/editors/model/BorderRounds;Landroid/graphics/Paint$Style;ZIII)V", "newDrawable", "Landroid/graphics/drawable/Drawable;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class State extends AbstractMaterialRectDrawable.MaterialRectDrawableState {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public State(CornerTreatment cornerTreatment, BorderRounds cornerSize, Paint.Style paintStyle, boolean z, int i, int i2, int i3) {
            super(cornerTreatment, cornerSize, paintStyle, z, i, i2, i3);
            Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
            Intrinsics.checkNotNullParameter(cornerSize, "cornerSize");
            Intrinsics.checkNotNullParameter(paintStyle, "paintStyle");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public State(State other) {
            this(other.cornerTreatment, other.cornerSize, other.paintStyle, other.hasShadow, other.shadowRadius, other.shadowOffset, other.shadowRotation);
            Intrinsics.checkNotNullParameter(other, "other");
            this.changingConfigurationsValue = other.changingConfigurationsValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new MaterialRectDrawable(this);
        }
    }
}
