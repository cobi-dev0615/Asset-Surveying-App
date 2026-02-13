package com.devexpress.editors.model.drawables;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.devexpress.editors.model.BorderRounds;
import com.devexpress.editors.model.MathUtilsKt;
import com.devexpress.editors.model.drawables.AbstractMaterialRectDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CutOutMaterialRectDrawable.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003)*+B1\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0002\u0010\rJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0014J\b\u0010#\u001a\u00020$H\u0016J&\u0010\u001d\u001a\u00020 2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u0015R\u001c\u0010\u000e\u001a\u00020\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006,"}, d2 = {"Lcom/devexpress/editors/model/drawables/CutOutMaterialRectDrawable;", "Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable;", "Lcom/devexpress/editors/model/drawables/CutOutMaterialRectDrawable$State;", "cornerTreatment", "Lcom/devexpress/editors/model/drawables/CornerTreatment;", "cornerSize", "Lcom/devexpress/editors/model/BorderRounds;", "paintStyle", "Landroid/graphics/Paint$Style;", "cutOutRect", "Landroid/graphics/RectF;", "(Lcom/devexpress/editors/model/drawables/CornerTreatment;Lcom/devexpress/editors/model/BorderRounds;Landroid/graphics/Paint$Style;Landroid/graphics/RectF;)V", "drawableState", "(Lcom/devexpress/editors/model/drawables/CutOutMaterialRectDrawable$State;)V", "actualCutOutRect", "Landroid/graphics/Rect;", "getActualCutOutRect", "()Landroid/graphics/Rect;", "setActualCutOutRect", "(Landroid/graphics/Rect;)V", "value", "", "cutOutProgress", "getCutOutProgress", "()F", "setCutOutProgress", "(F)V", "getCutOutRect", "()Landroid/graphics/RectF;", "setCutOutRect", "(Landroid/graphics/RectF;)V", "drawStroke", "", "canvas", "Landroid/graphics/Canvas;", "mutate", "Landroid/graphics/drawable/Drawable;", "left", "top", "right", "bottom", "Companion", "CutOutProgressProperty", "State", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CutOutMaterialRectDrawable extends AbstractMaterialRectDrawable<State> {
    private Rect actualCutOutRect;
    public static final Property<CutOutMaterialRectDrawable, Float> CUT_OUT_PROGRESS = new CutOutProgressProperty();

    public CutOutMaterialRectDrawable() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CutOutMaterialRectDrawable(CornerTreatment cornerTreatment) {
        this(cornerTreatment, null, null, null, 14, null);
        Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CutOutMaterialRectDrawable(CornerTreatment cornerTreatment, BorderRounds cornerSize) {
        this(cornerTreatment, cornerSize, null, null, 12, null);
        Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
        Intrinsics.checkNotNullParameter(cornerSize, "cornerSize");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CutOutMaterialRectDrawable(CornerTreatment cornerTreatment, BorderRounds cornerSize, Paint.Style paintStyle) {
        this(cornerTreatment, cornerSize, paintStyle, null, 8, null);
        Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
        Intrinsics.checkNotNullParameter(cornerSize, "cornerSize");
        Intrinsics.checkNotNullParameter(paintStyle, "paintStyle");
    }

    public /* synthetic */ CutOutMaterialRectDrawable(State state, DefaultConstructorMarker defaultConstructorMarker) {
        this(state);
    }

    private CutOutMaterialRectDrawable(State state) {
        super(state);
        this.actualCutOutRect = new Rect();
    }

    public final RectF getCutOutRect() {
        return getDrawableState().getCutOutRect();
    }

    public final void setCutOutRect(RectF value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(getDrawableState().getCutOutRect(), value)) {
            return;
        }
        getDrawableState().getCutOutRect().set(value);
        setPathsNeedUpdate(true);
        invalidateSelf();
    }

    public final float getCutOutProgress() {
        return getDrawableState().getCutOutProgress();
    }

    public final void setCutOutProgress(float f) {
        if (getDrawableState().getCutOutProgress() == f) {
            return;
        }
        getDrawableState().setCutOutProgress(f);
        setPathsNeedUpdate(!getCutOutRect().isEmpty());
        invalidateSelf();
    }

    public final void setActualCutOutRect(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<set-?>");
        this.actualCutOutRect = rect;
    }

    public final Rect getActualCutOutRect() {
        float cutOutProgress = (getCutOutProgress() * getCutOutRect().width()) / 2;
        float centerX = getCutOutRect().centerX();
        this.actualCutOutRect.set((int) (centerX - cutOutProgress), (int) getCutOutRect().top, (int) (centerX + cutOutProgress), (int) getCutOutRect().bottom);
        this.actualCutOutRect.offset(0, -getBounds().top);
        return this.actualCutOutRect;
    }

    public /* synthetic */ CutOutMaterialRectDrawable(RoundCornerTreatment roundCornerTreatment, BorderRounds borderRounds, Paint.Style style, RectF rectF, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new RoundCornerTreatment() : roundCornerTreatment, (i & 2) != 0 ? new BorderRounds(0) : borderRounds, (i & 4) != 0 ? Paint.Style.FILL_AND_STROKE : style, (i & 8) != 0 ? null : rectF);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CutOutMaterialRectDrawable(CornerTreatment cornerTreatment, BorderRounds cornerSize, Paint.Style paintStyle, RectF rectF) {
        this(new State(cornerTreatment, cornerSize, paintStyle));
        Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
        Intrinsics.checkNotNullParameter(cornerSize, "cornerSize");
        Intrinsics.checkNotNullParameter(paintStyle, "paintStyle");
        if (rectF != null) {
            getDrawableState().getCutOutRect().set(rectF);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        setDrawableState(new State(getDrawableState()));
        return this;
    }

    @Override // com.devexpress.editors.model.drawables.AbstractMaterialRectDrawable
    protected void drawStroke(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.drawStroke(canvas);
        canvas.drawRect(getActualCutOutRect(), AbstractMaterialRectDrawable.clearPaint);
    }

    public final void setCutOutRect(float left, float top, float right, float bottom) {
        if (MathUtilsKt.isZero(getCutOutRect().left - left) && MathUtilsKt.isZero(getCutOutRect().top - top) && MathUtilsKt.isZero(getCutOutRect().right - right) && MathUtilsKt.isZero(getCutOutRect().bottom - bottom)) {
            return;
        }
        getCutOutRect().set(left, top, right, bottom);
        setPathsNeedUpdate(true);
        invalidateSelf();
    }

    /* compiled from: CutOutMaterialRectDrawable.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0002\u0010\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/devexpress/editors/model/drawables/CutOutMaterialRectDrawable$State;", "Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable$MaterialRectDrawableState;", "other", "(Lcom/devexpress/editors/model/drawables/CutOutMaterialRectDrawable$State;)V", "cornerTreatment", "Lcom/devexpress/editors/model/drawables/CornerTreatment;", "cornerSize", "Lcom/devexpress/editors/model/BorderRounds;", "paintStyle", "Landroid/graphics/Paint$Style;", "(Lcom/devexpress/editors/model/drawables/CornerTreatment;Lcom/devexpress/editors/model/BorderRounds;Landroid/graphics/Paint$Style;)V", "cutOutProgress", "", "getCutOutProgress", "()F", "setCutOutProgress", "(F)V", "cutOutRect", "Landroid/graphics/RectF;", "getCutOutRect", "()Landroid/graphics/RectF;", "newDrawable", "Landroid/graphics/drawable/Drawable;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class State extends AbstractMaterialRectDrawable.MaterialRectDrawableState {
        private float cutOutProgress;
        private final RectF cutOutRect;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public State(CornerTreatment cornerTreatment, BorderRounds cornerSize, Paint.Style paintStyle) {
            super(cornerTreatment, cornerSize, paintStyle, false, 0, 0, 0, 120, null);
            Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
            Intrinsics.checkNotNullParameter(cornerSize, "cornerSize");
            Intrinsics.checkNotNullParameter(paintStyle, "paintStyle");
            this.cutOutRect = new RectF();
        }

        public final RectF getCutOutRect() {
            return this.cutOutRect;
        }

        public final float getCutOutProgress() {
            return this.cutOutProgress;
        }

        public final void setCutOutProgress(float f) {
            this.cutOutProgress = f;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public State(State other) {
            this(other.cornerTreatment, other.cornerSize, other.paintStyle);
            Intrinsics.checkNotNullParameter(other, "other");
            this.cutOutRect.set(other.cutOutRect);
            this.cutOutProgress = other.cutOutProgress;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new CutOutMaterialRectDrawable(this, (DefaultConstructorMarker) null);
        }
    }

    /* compiled from: CutOutMaterialRectDrawable.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002¨\u0006\u000b"}, d2 = {"Lcom/devexpress/editors/model/drawables/CutOutMaterialRectDrawable$CutOutProgressProperty;", "Landroid/util/Property;", "Lcom/devexpress/editors/model/drawables/CutOutMaterialRectDrawable;", "", "()V", "get", "obj", "(Lcom/devexpress/editors/model/drawables/CutOutMaterialRectDrawable;)Ljava/lang/Float;", "set", "", "value", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class CutOutProgressProperty extends Property<CutOutMaterialRectDrawable, Float> {
        public CutOutProgressProperty() {
            super(Float.TYPE, "cutOutProgress");
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(CutOutMaterialRectDrawable cutOutMaterialRectDrawable, Float f) {
            set(cutOutMaterialRectDrawable, f.floatValue());
        }

        @Override // android.util.Property
        public Float get(CutOutMaterialRectDrawable obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            return Float.valueOf(obj.getCutOutProgress());
        }

        public void set(CutOutMaterialRectDrawable obj, float value) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            obj.setCutOutProgress(value);
        }
    }
}
