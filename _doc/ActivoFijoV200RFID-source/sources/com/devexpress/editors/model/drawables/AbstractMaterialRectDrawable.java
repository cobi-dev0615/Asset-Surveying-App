package com.devexpress.editors.model.drawables;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import com.devexpress.editors.model.BorderRounds;
import com.devexpress.editors.model.MathUtilsKt;
import com.devexpress.editors.model.drawables.AbstractMaterialRectDrawable.MaterialRectDrawableState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbstractMaterialRectDrawable.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 \u008a\u0001*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\n\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\b\u0010e\u001a\u00020fH\u0014J\b\u0010g\u001a\u00020fH\u0014J\b\u0010h\u001a\u00020fH\u0014J\u0010\u0010i\u001a\u00020f2\u0006\u0010j\u001a\u00020kH\u0016J\u0010\u0010l\u001a\u00020f2\u0006\u0010j\u001a\u00020kH\u0014J\u0010\u0010m\u001a\u00020f2\u0006\u0010j\u001a\u00020kH\u0014J\b\u0010n\u001a\u00020oH\u0016J\b\u0010p\u001a\u00020\rH\u0014J\b\u0010q\u001a\u00020\u001fH\u0016J\u0010\u0010r\u001a\u00020f2\u0006\u0010s\u001a\u00020tH\u0016J\u0010\u0010u\u001a\u00020,2\u0006\u0010v\u001a\u00020wH\u0016J\b\u0010x\u001a\u00020\rH\u0014J\b\u0010y\u001a\u00020\rH\u0014J\b\u0010z\u001a\u00020fH\u0016J\u0010\u0010{\u001a\u00020f2\u0006\u0010|\u001a\u00020wH\u0014J\u0010\u0010}\u001a\u00020f2\u0006\u0010~\u001a\u00020\u001fH\u0016J\u0014\u0010\u007f\u001a\u00020f2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0016J\u0010\u0010\u0082\u0001\u001a\u00020f2\u0007\u0010\u0083\u0001\u001a\u00020wJ+\u0010\u0082\u0001\u001a\u00020f2\u0007\u0010\u0084\u0001\u001a\u00020\u001f2\u0007\u0010\u0085\u0001\u001a\u00020\u001f2\u0007\u0010\u0086\u0001\u001a\u00020\u001f2\u0007\u0010\u0087\u0001\u001a\u00020\u001fJ\t\u0010\u0088\u0001\u001a\u00020fH\u0002J\t\u0010\u0089\u0001\u001a\u00020fH\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\rX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u00028\u0000X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u0005R$\u0010 \u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020(X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R$\u0010/\u001a\u00020,2\u0006\u0010\u0010\u001a\u00020,8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010.\"\u0004\b1\u00102R\u0014\u00103\u001a\u00020,8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b4\u0010.R\u0014\u00105\u001a\u00020\rX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u000fR$\u00108\u001a\u0002072\u0006\u0010\u0010\u001a\u0002078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020,X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010.\"\u0004\bB\u00102R\u0014\u0010C\u001a\u00020D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0014\u0010G\u001a\u00020\rX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u000fR$\u0010I\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bJ\u0010\"\"\u0004\bK\u0010$R$\u0010L\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bM\u0010\"\"\u0004\bN\u0010$R$\u0010O\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bP\u0010\"\"\u0004\bQ\u0010$R\u0014\u0010R\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\"R\u0014\u0010T\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bU\u0010\"R\u000e\u0010V\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\u00020(X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010*R\u0014\u0010Y\u001a\u00020D8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010FR$\u0010[\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\\\u0010\"\"\u0004\b]\u0010$R\u000e\u0010^\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010_\u001a\u00020(X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010*R$\u0010a\u001a\u00020D2\u0006\u0010\u0010\u001a\u00020D8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bb\u0010F\"\u0004\bc\u0010d¨\u0006\u008f\u0001"}, d2 = {"Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable$MaterialRectDrawableState;", "Landroid/graphics/drawable/Drawable;", "drawableState", "(Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable$MaterialRectDrawableState;)V", "adjustedCornerSize", "Lcom/devexpress/editors/model/BorderRounds;", "getAdjustedCornerSize", "()Lcom/devexpress/editors/model/BorderRounds;", "adjustedShadowCornerSize", "getAdjustedShadowCornerSize", "boundsF", "Landroid/graphics/RectF;", "getBoundsF", "()Landroid/graphics/RectF;", "value", "cornerSize", "getCornerSize", "setCornerSize", "(Lcom/devexpress/editors/model/BorderRounds;)V", "Lcom/devexpress/editors/model/drawables/CornerTreatment;", "cornerTreatment", "getCornerTreatment", "()Lcom/devexpress/editors/model/drawables/CornerTreatment;", "setCornerTreatment", "(Lcom/devexpress/editors/model/drawables/CornerTreatment;)V", "getDrawableState", "()Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable$MaterialRectDrawableState;", "setDrawableState", "Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable$MaterialRectDrawableState;", "", "fillColor", "getFillColor", "()I", "setFillColor", "(I)V", "fillPaint", "Landroid/graphics/Paint;", "fillPath", "Landroid/graphics/Path;", "getFillPath", "()Landroid/graphics/Path;", "hasFill", "", "getHasFill", "()Z", "hasShadow", "getHasShadow", "setHasShadow", "(Z)V", "hasStroke", "getHasStroke", "insetBoundsF", "getInsetBoundsF", "Landroid/graphics/Paint$Style;", "paintStyle", "getPaintStyle", "()Landroid/graphics/Paint$Style;", "setPaintStyle", "(Landroid/graphics/Paint$Style;)V", "pathBounds", "pathBuilder", "Lcom/devexpress/editors/model/drawables/PathBuilder;", "pathsNeedUpdate", "getPathsNeedUpdate", "setPathsNeedUpdate", "shadowAdjustment", "", "getShadowAdjustment", "()F", "shadowBounds", "getShadowBounds", "shadowCompatOffset", "getShadowCompatOffset", "setShadowCompatOffset", "shadowCompatRadius", "getShadowCompatRadius", "setShadowCompatRadius", "shadowCompatRotation", "getShadowCompatRotation", "setShadowCompatRotation", "shadowOffsetX", "getShadowOffsetX", "shadowOffsetY", "getShadowOffsetY", "shadowPaint", "shadowPath", "getShadowPath", "strokeAdjustment", "getStrokeAdjustment", "strokeColor", "getStrokeColor", "setStrokeColor", "strokePaint", "strokePath", "getStrokePath", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "(F)V", "calculateFillPath", "", "calculateShadowPath", "calculateStrokePath", "draw", "canvas", "Landroid/graphics/Canvas;", "drawShadow", "drawStroke", "getConstantState", "Landroid/graphics/drawable/Drawable$ConstantState;", "getFillBounds", "getOpacity", "getOutline", "outline", "Landroid/graphics/Outline;", "getPadding", "padding", "Landroid/graphics/Rect;", "getShadowBoundsAsRectF", "getStrokeBounds", "invalidateSelf", "onBoundsChange", "bounds", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setPadding", "rect", "left", "top", "right", "bottom", "updatePathsIfNeeded", "updateShadowPaint", "Companion", "FillColorProperty", "MaterialRectDrawableState", "StrokeColorProperty", "StrokeWidthProperty", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AbstractMaterialRectDrawable<T extends MaterialRectDrawableState> extends Drawable {
    public static final Paint clearPaint;
    private final BorderRounds adjustedCornerSize;
    private final BorderRounds adjustedShadowCornerSize;
    private final RectF boundsF;
    private T drawableState;
    private final Paint fillPaint;
    private final Path fillPath;
    private final RectF insetBoundsF;
    private final RectF pathBounds;
    private final PathBuilder pathBuilder;
    private boolean pathsNeedUpdate;
    private final RectF shadowBounds;
    private final Paint shadowPaint;
    private final Path shadowPath;
    private final Paint strokePaint;
    private final Path strokePath;
    public static final Property<AbstractMaterialRectDrawable<?>, Float> STROKE_WIDTH = new StrokeWidthProperty();
    public static final Property<AbstractMaterialRectDrawable<?>, Integer> STROKE_COLOR = new StrokeColorProperty();
    public static final Property<AbstractMaterialRectDrawable<?>, Integer> FILL_COLOR = new FillColorProperty();
    public static final int shadowColor = ColorUtils.setAlphaComponent(-16777216, 66);

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    protected AbstractMaterialRectDrawable(T drawableState) {
        Intrinsics.checkNotNullParameter(drawableState, "drawableState");
        this.drawableState = drawableState;
        this.pathBuilder = new PathBuilder();
        Paint paint = new Paint(1);
        this.fillPaint = paint;
        Paint paint2 = new Paint(1);
        this.strokePaint = paint2;
        Paint paint3 = new Paint();
        this.shadowPaint = paint3;
        this.pathsNeedUpdate = true;
        this.fillPath = new Path();
        this.strokePath = new Path();
        this.shadowPath = new Path();
        this.boundsF = new RectF();
        this.shadowBounds = new RectF();
        this.insetBoundsF = new RectF();
        this.adjustedCornerSize = new BorderRounds();
        this.adjustedShadowCornerSize = new BorderRounds();
        this.pathBounds = new RectF();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(-16777216);
        paint2.setStrokeWidth(12.0f);
        paint2.setStrokeCap(Paint.Cap.SQUARE);
        paint3.setStyle(Paint.Style.FILL);
    }

    protected final T getDrawableState() {
        return this.drawableState;
    }

    protected final void setDrawableState(T t) {
        Intrinsics.checkNotNullParameter(t, "<set-?>");
        this.drawableState = t;
    }

    static {
        Paint paint = new Paint();
        clearPaint = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    protected final boolean getPathsNeedUpdate() {
        return this.pathsNeedUpdate;
    }

    protected final void setPathsNeedUpdate(boolean z) {
        this.pathsNeedUpdate = z;
    }

    protected final Path getFillPath() {
        return this.fillPath;
    }

    protected final Path getStrokePath() {
        return this.strokePath;
    }

    protected final Path getShadowPath() {
        return this.shadowPath;
    }

    protected final RectF getBoundsF() {
        return this.boundsF;
    }

    protected final RectF getShadowBounds() {
        return this.shadowBounds;
    }

    protected final RectF getInsetBoundsF() {
        return this.insetBoundsF;
    }

    protected final BorderRounds getAdjustedCornerSize() {
        return this.adjustedCornerSize;
    }

    protected final BorderRounds getAdjustedShadowCornerSize() {
        return this.adjustedShadowCornerSize;
    }

    private final int getShadowOffsetX() {
        return (int) (this.drawableState.shadowOffset * Math.sin(Math.toRadians(this.drawableState.shadowRotation)));
    }

    private final int getShadowOffsetY() {
        return (int) (this.drawableState.shadowOffset * Math.cos(Math.toRadians(this.drawableState.shadowRotation)));
    }

    private final boolean getHasFill() {
        return this.drawableState.paintStyle == Paint.Style.FILL_AND_STROKE || this.drawableState.paintStyle == Paint.Style.FILL;
    }

    protected final boolean getHasStroke() {
        return (this.drawableState.paintStyle == Paint.Style.FILL_AND_STROKE || this.drawableState.paintStyle == Paint.Style.STROKE) && this.strokePaint.getStrokeWidth() > 0.0f;
    }

    protected final float getStrokeAdjustment() {
        return this.strokePaint.getStrokeWidth() / 2;
    }

    private final float getShadowAdjustment() {
        return this.drawableState.shadowRadius / 2.0f;
    }

    public final float getStrokeWidth() {
        return this.strokePaint.getStrokeWidth();
    }

    public final void setStrokeWidth(float f) {
        if (this.strokePaint.getStrokeWidth() == f) {
            return;
        }
        this.strokePaint.setStrokeWidth(f);
        invalidateSelf();
    }

    public final int getStrokeColor() {
        return this.strokePaint.getColor();
    }

    public final void setStrokeColor(int i) {
        if (this.strokePaint.getColor() == i) {
            return;
        }
        this.strokePaint.setColor(i);
        invalidateSelf();
    }

    public final int getFillColor() {
        return this.fillPaint.getColor();
    }

    public final void setFillColor(int i) {
        if (this.fillPaint.getColor() == i) {
            return;
        }
        this.fillPaint.setColor(i);
        invalidateSelf();
    }

    public final CornerTreatment getCornerTreatment() {
        return this.drawableState.cornerTreatment;
    }

    public final void setCornerTreatment(CornerTreatment value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.drawableState.cornerTreatment, value)) {
            return;
        }
        this.drawableState.cornerTreatment = value;
        invalidateSelf();
    }

    public BorderRounds getCornerSize() {
        return this.drawableState.cornerSize;
    }

    public void setCornerSize(BorderRounds value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.drawableState.cornerSize, value)) {
            return;
        }
        this.drawableState.cornerSize.set(value);
        invalidateSelf();
    }

    public final Paint.Style getPaintStyle() {
        return this.drawableState.paintStyle;
    }

    public final void setPaintStyle(Paint.Style value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.drawableState.paintStyle == value) {
            return;
        }
        this.drawableState.paintStyle = value;
        this.pathsNeedUpdate = true;
        invalidateSelf();
    }

    public final boolean getHasShadow() {
        return this.drawableState.hasShadow;
    }

    public final void setHasShadow(boolean z) {
        if (this.drawableState.hasShadow == z) {
            return;
        }
        this.drawableState.hasShadow = z;
        invalidateSelf();
    }

    public final int getShadowCompatRadius() {
        return this.drawableState.shadowRadius;
    }

    public final void setShadowCompatRadius(int i) {
        if (this.drawableState.shadowRadius == i) {
            return;
        }
        this.drawableState.shadowRadius = i;
        updateShadowPaint();
        invalidateSelf();
    }

    public final int getShadowCompatOffset() {
        return this.drawableState.shadowOffset;
    }

    public final void setShadowCompatOffset(int i) {
        if (this.drawableState.shadowOffset == i) {
            return;
        }
        this.drawableState.shadowOffset = i;
        updateShadowPaint();
        invalidateSelf();
    }

    public final int getShadowCompatRotation() {
        return this.drawableState.shadowRotation;
    }

    public final void setShadowCompatRotation(int i) {
        if (this.drawableState.shadowRotation == i) {
            return;
        }
        this.drawableState.shadowRotation = i;
        updateShadowPaint();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        padding.set(this.drawableState.padding);
        return MathUtilsKt.isZero(padding);
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        this.drawableState.padding.set(left, top, right, bottom);
        invalidateSelf();
    }

    public final void setPadding(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.drawableState.padding.set(rect);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.pathsNeedUpdate = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        this.pathsNeedUpdate = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getBounds().width() <= 0 || getBounds().height() <= 0) {
            return;
        }
        updatePathsIfNeeded();
        canvas.save();
        canvas.translate(getBounds().left, getBounds().top);
        if (this.drawableState.hasShadow) {
            canvas.save();
            Bitmap createBitmap = Bitmap.createBitmap(getBounds().width() + (this.drawableState.shadowRadius * 4), getBounds().height() + (this.drawableState.shadowRadius * 4), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
            Canvas canvas2 = new Canvas(createBitmap);
            float shadowOffsetX = (getBounds().left - (this.drawableState.shadowRadius * 2)) + getShadowOffsetX();
            float shadowOffsetY = (getBounds().top - (this.drawableState.shadowRadius * 2)) + getShadowOffsetY();
            canvas2.translate(-shadowOffsetX, -shadowOffsetY);
            drawShadow(canvas2);
            canvas.drawBitmap(createBitmap, shadowOffsetX, shadowOffsetY, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
        }
        if (getHasFill()) {
            canvas.drawPath(this.fillPath, this.fillPaint);
        }
        if (getHasStroke()) {
            Bitmap createBitmap2 = Bitmap.createBitmap(getBounds().width(), getBounds().height(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap2, "createBitmap(...)");
            drawStroke(new Canvas(createBitmap2));
            canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            createBitmap2.recycle();
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        this.drawableState.changingConfigurationsValue = getChangingConfigurations();
        return this.drawableState;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Intrinsics.checkNotNullParameter(outline, "outline");
        if (this.drawableState.hasShadow) {
            return;
        }
        updatePathsIfNeeded();
        if (Build.VERSION.SDK_INT >= 30) {
            outline.setPath(this.shadowPath);
        }
    }

    protected void drawStroke(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.drawPath(this.strokePath, this.strokePaint);
    }

    protected void drawShadow(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.drawPath(this.shadowPath, this.shadowPaint);
        canvas.drawPath(this.strokePath, clearPaint);
    }

    protected void calculateFillPath() {
        RectF fillBounds;
        if (getHasStroke()) {
            fillBounds = getStrokeBounds();
        } else {
            fillBounds = getFillBounds();
        }
        this.pathBuilder.buildPath(fillBounds, this.drawableState.cornerTreatment, this.drawableState.cornerSize, this.fillPath);
        this.fillPath.computeBounds(this.pathBounds, true);
    }

    protected void calculateStrokePath() {
        this.adjustedCornerSize.setAdjusted(this.drawableState.cornerSize, -getStrokeAdjustment());
        this.pathBuilder.buildPath(getStrokeBounds(), this.drawableState.cornerTreatment, this.adjustedCornerSize, this.strokePath);
    }

    protected void calculateShadowPath() {
        this.pathBuilder.buildPath(getFillBounds(), this.drawableState.cornerTreatment, this.drawableState.cornerSize, this.shadowPath);
    }

    protected RectF getFillBounds() {
        this.boundsF.set(getBounds());
        this.boundsF.offsetTo(0.0f, 0.0f);
        return this.boundsF;
    }

    protected RectF getStrokeBounds() {
        float strokeAdjustment = getStrokeAdjustment();
        this.insetBoundsF.set(getFillBounds());
        this.insetBoundsF.offsetTo(0.0f, 0.0f);
        this.insetBoundsF.inset(strokeAdjustment, strokeAdjustment);
        return this.insetBoundsF;
    }

    protected RectF getShadowBoundsAsRectF() {
        float shadowAdjustment = getShadowAdjustment();
        this.shadowBounds.set(getFillBounds());
        float f = -shadowAdjustment;
        this.shadowBounds.inset(f, f);
        return this.shadowBounds;
    }

    private final void updatePathsIfNeeded() {
        if (this.pathsNeedUpdate) {
            calculateShadowPath();
            calculateFillPath();
            calculateStrokePath();
            this.pathsNeedUpdate = false;
        }
    }

    private final void updateShadowPaint() {
        this.shadowPaint.setShadowLayer(this.drawableState.shadowRadius, getShadowOffsetX(), getShadowOffsetY(), shadowColor);
    }

    /* compiled from: AbstractMaterialRectDrawable.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0002\u0010\u0003BE\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r¢\u0006\u0002\u0010\u0010J\b\u0010\u0014\u001a\u00020\rH\u0016R\u0012\u0010\u0011\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable$MaterialRectDrawableState;", "Landroid/graphics/drawable/Drawable$ConstantState;", "other", "(Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable$MaterialRectDrawableState;)V", "cornerTreatment", "Lcom/devexpress/editors/model/drawables/CornerTreatment;", "cornerSize", "Lcom/devexpress/editors/model/BorderRounds;", "paintStyle", "Landroid/graphics/Paint$Style;", "hasShadow", "", "shadowRadius", "", "shadowOffset", "shadowRotation", "(Lcom/devexpress/editors/model/drawables/CornerTreatment;Lcom/devexpress/editors/model/BorderRounds;Landroid/graphics/Paint$Style;ZIII)V", "changingConfigurationsValue", "padding", "Landroid/graphics/Rect;", "getChangingConfigurations", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class MaterialRectDrawableState extends Drawable.ConstantState {
        public int changingConfigurationsValue;
        public BorderRounds cornerSize;
        public CornerTreatment cornerTreatment;
        public boolean hasShadow;
        public Rect padding;
        public Paint.Style paintStyle;
        public int shadowOffset;
        public int shadowRadius;
        public int shadowRotation;

        public /* synthetic */ MaterialRectDrawableState(CornerTreatment cornerTreatment, BorderRounds borderRounds, Paint.Style style, boolean z, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(cornerTreatment, borderRounds, style, (i4 & 8) != 0 ? false : z, (i4 & 16) != 0 ? 0 : i, (i4 & 32) != 0 ? 0 : i2, (i4 & 64) != 0 ? 0 : i3);
        }

        public MaterialRectDrawableState(CornerTreatment cornerTreatment, BorderRounds cornerSize, Paint.Style paintStyle, boolean z, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
            Intrinsics.checkNotNullParameter(cornerSize, "cornerSize");
            Intrinsics.checkNotNullParameter(paintStyle, "paintStyle");
            this.cornerTreatment = cornerTreatment;
            this.cornerSize = cornerSize;
            this.paintStyle = paintStyle;
            this.hasShadow = z;
            this.shadowRadius = i;
            this.shadowOffset = i2;
            this.shadowRotation = i3;
            this.padding = new Rect(0, 0, 0, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MaterialRectDrawableState(MaterialRectDrawableState other) {
            this(other.cornerTreatment, other.cornerSize, other.paintStyle, other.hasShadow, other.shadowRadius, other.shadowOffset, other.shadowRotation);
            Intrinsics.checkNotNullParameter(other, "other");
            this.changingConfigurationsValue = other.changingConfigurationsValue;
            this.padding.set(other.padding);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.changingConfigurationsValue;
        }
    }

    /* compiled from: AbstractMaterialRectDrawable.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0007J\u001d\u0010\b\u001a\u00020\t2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002¨\u0006\u000b"}, d2 = {"Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable$StrokeWidthProperty;", "Landroid/util/Property;", "Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable;", "", "()V", "get", "obj", "(Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable;)Ljava/lang/Float;", "set", "", "value", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class StrokeWidthProperty extends Property<AbstractMaterialRectDrawable<?>, Float> {
        public StrokeWidthProperty() {
            super(Float.TYPE, "strokeWidth");
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(AbstractMaterialRectDrawable<?> abstractMaterialRectDrawable, Float f) {
            set(abstractMaterialRectDrawable, f.floatValue());
        }

        @Override // android.util.Property
        public Float get(AbstractMaterialRectDrawable<?> obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            return Float.valueOf(obj.getStrokeWidth());
        }

        public void set(AbstractMaterialRectDrawable<?> obj, float value) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            obj.setStrokeWidth(value);
        }
    }

    /* compiled from: AbstractMaterialRectDrawable.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0007J\u001d\u0010\b\u001a\u00020\t2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002¨\u0006\u000b"}, d2 = {"Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable$StrokeColorProperty;", "Landroid/util/Property;", "Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable;", "", "()V", "get", "obj", "(Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable;)Ljava/lang/Integer;", "set", "", "value", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class StrokeColorProperty extends Property<AbstractMaterialRectDrawable<?>, Integer> {
        public StrokeColorProperty() {
            super(Integer.TYPE, "strokeColor");
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(AbstractMaterialRectDrawable<?> abstractMaterialRectDrawable, Integer num) {
            set(abstractMaterialRectDrawable, num.intValue());
        }

        @Override // android.util.Property
        public Integer get(AbstractMaterialRectDrawable<?> obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            return Integer.valueOf(obj.getStrokeColor());
        }

        public void set(AbstractMaterialRectDrawable<?> obj, int value) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            obj.setStrokeColor(value);
        }
    }

    /* compiled from: AbstractMaterialRectDrawable.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0007J\u001d\u0010\b\u001a\u00020\t2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002¨\u0006\u000b"}, d2 = {"Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable$FillColorProperty;", "Landroid/util/Property;", "Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable;", "", "()V", "get", "obj", "(Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable;)Ljava/lang/Integer;", "set", "", "value", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class FillColorProperty extends Property<AbstractMaterialRectDrawable<?>, Integer> {
        public FillColorProperty() {
            super(Integer.TYPE, "fillColor");
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(AbstractMaterialRectDrawable<?> abstractMaterialRectDrawable, Integer num) {
            set(abstractMaterialRectDrawable, num.intValue());
        }

        @Override // android.util.Property
        public Integer get(AbstractMaterialRectDrawable<?> obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            return Integer.valueOf(obj.getFillColor());
        }

        public void set(AbstractMaterialRectDrawable<?> obj, int value) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            obj.setFillColor(value);
        }
    }
}
