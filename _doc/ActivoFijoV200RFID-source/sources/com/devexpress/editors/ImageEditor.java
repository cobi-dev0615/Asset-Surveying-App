package com.devexpress.editors;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NotificationCompat;
import com.devexpress.editors.dropdown.utils.Rectangle;
import com.devexpress.editors.interaction.CompatScroller;
import com.devexpress.editors.interaction.ScaleGestureListener;
import com.devexpress.editors.interaction.TranslationGestureListener;
import com.devexpress.editors.utils.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageEditor.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002fgB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0002J\b\u0010H\u001a\u0004\u0018\u00010,J\b\u0010I\u001a\u00020EH\u0002J\b\u0010J\u001a\u00020EH\u0002J\b\u0010K\u001a\u00020EH\u0002J\b\u0010L\u001a\u00020EH\u0002J\b\u0010M\u001a\u00020EH\u0002J\u0010\u0010N\u001a\u00020E2\u0006\u0010O\u001a\u00020PH\u0002J\b\u0010Q\u001a\u0004\u0018\u00010RJ\b\u0010S\u001a\u0004\u0018\u00010RJ\u0006\u0010T\u001a\u00020EJ(\u0010U\u001a\u00020E2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u0007H\u0016J\u0006\u0010Z\u001a\u00020EJ\u0010\u0010[\u001a\u00020E2\u0006\u0010\\\u001a\u00020]H\u0014J\u0012\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0017J\u0006\u0010b\u001a\u00020EJ\u0012\u0010c\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0006\u0010d\u001a\u00020EJ\f\u0010e\u001a\u00020R*\u00020GH\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R$\u0010!\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010(\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010#\"\u0004\b*\u0010%R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010-\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R$\u00104\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b5\u0010#\"\u0004\b6\u0010%R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R$\u00109\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b:\u0010\u0016\"\u0004\b;\u0010\u0018R\u000e\u0010<\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/devexpress/editors/ImageEditor;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_aspectHeight", "_aspectWidth", "_frameColor", "_frameOffset", "", "_frameThickness", "_frameType", "Lcom/devexpress/editors/FrameType;", "_maxScaleFactor", "_scrimColor", "value", "aspectHeight", "getAspectHeight", "()I", "setAspectHeight", "(I)V", "aspectWidth", "getAspectWidth", "setAspectWidth", "commonGestureDetector", "Landroid/view/GestureDetector;", "frameColor", "getFrameColor", "setFrameColor", "frameOffset", "getFrameOffset", "()F", "setFrameOffset", "(F)V", "framePaint", "Landroid/graphics/Paint;", "frameThickness", "getFrameThickness", "setFrameThickness", "frameTransformation", "Lcom/devexpress/editors/utils/RectF;", "frameType", "getFrameType", "()Lcom/devexpress/editors/FrameType;", "setFrameType", "(Lcom/devexpress/editors/FrameType;)V", "imageTransformation", "maxImageTransformation", "maxScaleFactor", "getMaxScaleFactor", "setMaxScaleFactor", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "scrimColor", "getScrimColor", "setScrimColor", "scrimPaint", "scrimPath", "Landroid/graphics/Path;", "transformationAngle", "transformationScaleX", "transformationScaleY", "translationGestureDetector", "Lcom/devexpress/editors/interaction/TranslationGestureListener;", "applyBitmapTransformations", "", "drawable", "Landroid/graphics/drawable/Drawable;", "calculateCropTransformation", "calculateFrameTransformation", "calculateImageTransformation", "calculateScrimPath", "calculateTranslations", "coerceImageTranslation", "compatPostOnAnimation", "runnable", "Ljava/lang/Runnable;", "crop", "Landroid/graphics/Bitmap;", "export", "horizontalFlip", "layout", "l", "t", "r", "b", "leftRotation", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "rightRotation", "setImageDrawable", "verticalFlip", "toBitmap", "CommonGestureListener", "Fling", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ImageEditor extends AppCompatImageView {
    private int _aspectHeight;
    private int _aspectWidth;
    private int _frameColor;
    private float _frameOffset;
    private float _frameThickness;
    private FrameType _frameType;
    private float _maxScaleFactor;
    private int _scrimColor;
    private final GestureDetector commonGestureDetector;
    private final Paint framePaint;
    private final RectF frameTransformation;
    private final RectF imageTransformation;
    private final RectF maxImageTransformation;
    private final ScaleGestureDetector scaleGestureDetector;
    private final Paint scrimPaint;
    private final Path scrimPath;
    private int transformationAngle;
    private int transformationScaleX;
    private int transformationScaleY;
    private final TranslationGestureListener translationGestureDetector;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageEditor(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageEditor(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageEditor(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.transformationScaleX = 1;
        this.transformationScaleY = 1;
        setClickable(true);
        setClipToOutline(true);
        RectF rectF = new RectF();
        this.frameTransformation = rectF;
        RectF rectF2 = new RectF();
        this.imageTransformation = rectF2;
        RectF rectF3 = new RectF();
        this.maxImageTransformation = rectF3;
        Paint paint = new Paint();
        this.framePaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setFlags(1);
        this._frameColor = -1;
        this._frameType = FrameType.Ellipse;
        Paint paint2 = new Paint();
        this.scrimPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setFlags(1);
        this._scrimColor = -16777216;
        Path path = new Path();
        this.scrimPath = path;
        path.setFillType(Path.FillType.WINDING);
        this._frameThickness = 1.0f;
        this._frameOffset = 0.0f;
        this._aspectWidth = 1;
        this._aspectHeight = 1;
        this._maxScaleFactor = 2.0f;
        this.translationGestureDetector = new TranslationGestureListener(rectF2);
        this.scaleGestureDetector = new ScaleGestureDetector(context, new ScaleGestureListener(rectF, rectF2, rectF3));
        this.commonGestureDetector = new GestureDetector(context, new CommonGestureListener());
        setWillNotDraw(false);
    }

    public /* synthetic */ ImageEditor(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* renamed from: getFrameColor, reason: from getter */
    public final int get_frameColor() {
        return this._frameColor;
    }

    public final void setFrameColor(int i) {
        this.framePaint.setColor(i);
        this._frameColor = i;
        invalidate();
    }

    /* renamed from: getScrimColor, reason: from getter */
    public final int get_scrimColor() {
        return this._scrimColor;
    }

    public final void setScrimColor(int i) {
        this.scrimPaint.setColor(i);
        this._scrimColor = i;
        invalidate();
    }

    /* renamed from: getFrameThickness, reason: from getter */
    public final float get_frameThickness() {
        return this._frameThickness;
    }

    public final void setFrameThickness(float f) {
        this.framePaint.setStrokeWidth(f);
        this._frameThickness = f;
        invalidate();
    }

    /* renamed from: getFrameOffset, reason: from getter */
    public final float get_frameOffset() {
        return this._frameOffset;
    }

    public final void setFrameOffset(float f) {
        this._frameOffset = f;
        calculateTranslations();
        invalidate();
    }

    /* renamed from: getFrameType, reason: from getter */
    public final FrameType get_frameType() {
        return this._frameType;
    }

    public final void setFrameType(FrameType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._frameType = value;
        calculateScrimPath();
        invalidate();
    }

    /* renamed from: getAspectWidth, reason: from getter */
    public final int get_aspectWidth() {
        return this._aspectWidth;
    }

    public final void setAspectWidth(int i) {
        this._aspectWidth = i;
        calculateTranslations();
        invalidate();
    }

    /* renamed from: getAspectHeight, reason: from getter */
    public final int get_aspectHeight() {
        return this._aspectHeight;
    }

    public final void setAspectHeight(int i) {
        this._aspectHeight = i;
        calculateTranslations();
        invalidate();
    }

    /* renamed from: getMaxScaleFactor, reason: from getter */
    public final float get_maxScaleFactor() {
        return this._maxScaleFactor;
    }

    public final void setMaxScaleFactor(float f) {
        this._maxScaleFactor = f;
        coerceImageTranslation();
        invalidate();
    }

    public final void verticalFlip() {
        this.transformationScaleX = 1;
        this.transformationScaleY = -1;
        this.transformationAngle = 0;
        applyBitmapTransformations(getDrawable());
        this.imageTransformation.flipHorizontal(this.frameTransformation);
        this.maxImageTransformation.flipHorizontal(this.frameTransformation);
    }

    public final void horizontalFlip() {
        this.transformationScaleX = -1;
        this.transformationScaleY = 1;
        this.transformationAngle = 0;
        applyBitmapTransformations(getDrawable());
        this.imageTransformation.flipVertical(this.frameTransformation);
        this.maxImageTransformation.flipVertical(this.frameTransformation);
    }

    public final void rightRotation() {
        this.transformationScaleX = 1;
        this.transformationScaleY = 1;
        this.transformationAngle = 90;
        applyBitmapTransformations(getDrawable());
        this.imageTransformation.rotateRight(this.frameTransformation);
        this.maxImageTransformation.rotateRight(this.frameTransformation);
    }

    public final void leftRotation() {
        this.transformationScaleX = 1;
        this.transformationScaleY = 1;
        this.transformationAngle = -90;
        applyBitmapTransformations(getDrawable());
        this.imageTransformation.rotateLeft(this.frameTransformation);
        this.maxImageTransformation.rotateLeft(this.frameTransformation);
    }

    public final Bitmap crop() {
        Bitmap export = export();
        if (export == null) {
            return null;
        }
        RectF calculateCropTransformation = calculateCropTransformation();
        Intrinsics.checkNotNull(calculateCropTransformation);
        Rectangle rectangle = calculateCropTransformation.toInt();
        return Bitmap.createBitmap(export, rectangle.getLeft(), rectangle.getTop(), rectangle.getWidth(), rectangle.getHeight());
    }

    public final RectF calculateCropTransformation() {
        Drawable drawable = getDrawable();
        if ((drawable != null ? toBitmap(drawable) : null) == null) {
            return null;
        }
        float width = this.imageTransformation.getWidth() / r0.getWidth();
        RectF rectF = new RectF();
        rectF.setX((this.frameTransformation.getX() - this.imageTransformation.getX()) / width);
        rectF.setY((this.frameTransformation.getY() - this.imageTransformation.getY()) / width);
        rectF.setWidth(this.frameTransformation.getWidth() / width);
        rectF.setHeight(this.frameTransformation.getHeight() / width);
        return rectF;
    }

    public final Bitmap export() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            return toBitmap(drawable);
        }
        return null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        TranslationGestureListener translationGestureListener = this.translationGestureDetector;
        Intrinsics.checkNotNull(event);
        translationGestureListener.onTouchEvent(event);
        this.commonGestureDetector.onTouchEvent(event);
        this.scaleGestureDetector.onTouchEvent(event);
        coerceImageTranslation();
        invalidate();
        return super.onTouchEvent(event);
    }

    @Override // android.view.View
    public void layout(int l, int t, int r, int b) {
        if (getWidth() == r - l && getHeight() == b - t) {
            return;
        }
        super.layout(l, t, r, b);
        calculateTranslations();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        calculateTranslations();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setBounds((int) this.imageTransformation.getX(), (int) this.imageTransformation.getY(), (int) (this.imageTransformation.getX() + this.imageTransformation.getWidth()), (int) (this.imageTransformation.getY() + this.imageTransformation.getHeight()));
        }
        Drawable drawable2 = getDrawable();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        canvas.drawPath(this.scrimPath, this.scrimPaint);
        if (this._frameType == FrameType.Rectangle) {
            canvas.drawRect(this.frameTransformation.getX(), this.frameTransformation.getY(), this.frameTransformation.getX() + this.frameTransformation.getWidth(), this.frameTransformation.getY() + this.frameTransformation.getHeight(), this.framePaint);
        } else {
            canvas.drawOval(this.frameTransformation.getX(), this.frameTransformation.getY(), this.frameTransformation.getX() + this.frameTransformation.getWidth(), this.frameTransformation.getY() + this.frameTransformation.getHeight(), this.framePaint);
        }
    }

    private final void applyBitmapTransformations(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null || (bitmap = toBitmap(drawable)) == null) {
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(this.transformationScaleX, this.transformationScaleY);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        matrix.setRotate(this.transformationAngle, width / 2.0f, height / 2.0f);
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, width, height, matrix, false);
        Intrinsics.checkNotNullExpressionValue(createBitmap2, "createBitmap(...)");
        super.setImageDrawable(new BitmapDrawable(getResources(), createBitmap2));
    }

    private final void calculateTranslations() {
        calculateFrameTransformation();
        calculateImageTransformation();
        coerceImageTranslation();
        calculateScrimPath();
        invalidate();
    }

    private final void calculateFrameTransformation() {
        float f = 2;
        float width = (getWidth() - (this._frameOffset * f)) / this._aspectWidth;
        float height = (getHeight() - (this._frameOffset * f)) / this._aspectHeight;
        if (this._aspectWidth * width <= getWidth() && this._aspectHeight * width <= getHeight()) {
            this.frameTransformation.setWidth(this._aspectWidth * width);
            this.frameTransformation.setHeight(this._aspectHeight * width);
        } else {
            this.frameTransformation.setWidth(this._aspectWidth * height);
            this.frameTransformation.setHeight(this._aspectHeight * height);
        }
        this.frameTransformation.setX((getWidth() - this.frameTransformation.getWidth()) / f);
        this.frameTransformation.setY((getHeight() - this.frameTransformation.getHeight()) / f);
    }

    private final void calculateImageTransformation() {
        if (getDrawable() == null) {
            return;
        }
        float width = this.frameTransformation.getWidth() / getDrawable().getMinimumWidth();
        float height = this.frameTransformation.getHeight() / getDrawable().getMinimumHeight();
        if (getDrawable().getMinimumHeight() * width >= this.frameTransformation.getHeight()) {
            this.imageTransformation.setWidth(this.frameTransformation.getWidth());
            this.imageTransformation.setHeight(getDrawable().getMinimumHeight() * width);
        } else {
            this.imageTransformation.setWidth(getDrawable().getMinimumWidth() * height);
            this.imageTransformation.setHeight(this.frameTransformation.getHeight());
        }
        float f = 2;
        this.imageTransformation.setX(this.frameTransformation.getX() - ((this.imageTransformation.getWidth() - this.frameTransformation.getWidth()) / f));
        this.imageTransformation.setY(this.frameTransformation.getY() - ((this.imageTransformation.getHeight() - this.frameTransformation.getHeight()) / f));
        this.maxImageTransformation.setWidth(this.imageTransformation.getWidth() * this._maxScaleFactor);
        this.maxImageTransformation.setHeight(this.imageTransformation.getHeight() * this._maxScaleFactor);
    }

    private final void coerceImageTranslation() {
        if (getDrawable() == null) {
            return;
        }
        this.maxImageTransformation.setX((this.imageTransformation.getWidth() - this.frameTransformation.getWidth()) - this.frameTransformation.getX());
        this.maxImageTransformation.setY((this.imageTransformation.getHeight() - this.frameTransformation.getHeight()) - this.frameTransformation.getY());
        if (this.imageTransformation.getX() > this.frameTransformation.getX()) {
            this.imageTransformation.setX(this.frameTransformation.getX());
        }
        if (this.imageTransformation.getX() < (-this.maxImageTransformation.getX())) {
            this.imageTransformation.setX(-this.maxImageTransformation.getX());
        }
        if (this.imageTransformation.getY() > this.frameTransformation.getY()) {
            this.imageTransformation.setY(this.frameTransformation.getY());
        }
        if (this.imageTransformation.getY() < (-this.maxImageTransformation.getY())) {
            this.imageTransformation.setY(-this.maxImageTransformation.getY());
        }
        if (this.maxImageTransformation.getWidth() < this.imageTransformation.getWidth()) {
            this.imageTransformation.setWidth(this.maxImageTransformation.getWidth());
        }
        if (this.maxImageTransformation.getHeight() < this.imageTransformation.getHeight()) {
            this.imageTransformation.setHeight(this.maxImageTransformation.getHeight());
        }
    }

    private final void calculateScrimPath() {
        this.scrimPath.reset();
        this.scrimPath.addRect(0.0f, 0.0f, getWidth(), getHeight(), Path.Direction.CW);
        if (this._frameType == FrameType.Rectangle) {
            this.scrimPath.addRect(this.frameTransformation.getX(), this.frameTransformation.getY(), this.frameTransformation.getX() + this.frameTransformation.getWidth(), this.frameTransformation.getY() + this.frameTransformation.getHeight(), Path.Direction.CCW);
        } else {
            this.scrimPath.addOval(this.frameTransformation.getX(), this.frameTransformation.getY(), this.frameTransformation.getX() + this.frameTransformation.getWidth(), this.frameTransformation.getY() + this.frameTransformation.getHeight(), Path.Direction.CCW);
        }
        this.scrimPath.close();
    }

    private final Bitmap toBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void compatPostOnAnimation(Runnable runnable) {
        postOnAnimation(runnable);
    }

    /* compiled from: ImageEditor.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0018\u00010\u0004R\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/devexpress/editors/ImageEditor$CommonGestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "(Lcom/devexpress/editors/ImageEditor;)V", "fling", "Lcom/devexpress/editors/ImageEditor$Fling;", "Lcom/devexpress/editors/ImageEditor;", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class CommonGestureListener extends GestureDetector.SimpleOnGestureListener {
        private Fling fling;

        public CommonGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Intrinsics.checkNotNullParameter(e2, "e2");
            Fling fling = this.fling;
            if (fling != null) {
                fling.cancelFling();
            }
            Fling fling2 = ImageEditor.this.new Fling((int) velocityX, (int) velocityY);
            ImageEditor.this.compatPostOnAnimation(fling2);
            this.fling = fling2;
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

    /* compiled from: ImageEditor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/devexpress/editors/ImageEditor$Fling;", "Ljava/lang/Runnable;", "velocityX", "", "velocityY", "(Lcom/devexpress/editors/ImageEditor;II)V", "currX", "getCurrX", "()I", "setCurrX", "(I)V", "currY", "getCurrY", "setCurrY", "scroller", "Lcom/devexpress/editors/interaction/CompatScroller;", "getScroller", "()Lcom/devexpress/editors/interaction/CompatScroller;", "setScroller", "(Lcom/devexpress/editors/interaction/CompatScroller;)V", "cancelFling", "", "run", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class Fling implements Runnable {
        private int currX;
        private int currY;
        private CompatScroller scroller;

        public Fling(int i, int i2) {
            this.scroller = new CompatScroller(ImageEditor.this.getContext());
            int x = (int) ImageEditor.this.imageTransformation.getX();
            int y = (int) ImageEditor.this.imageTransformation.getY();
            this.scroller.fling(x, y, i, i2, -((int) ((ImageEditor.this.imageTransformation.getWidth() - ImageEditor.this.frameTransformation.getWidth()) - ImageEditor.this.frameTransformation.getX())), (int) ImageEditor.this.frameTransformation.getX(), -((int) ((ImageEditor.this.imageTransformation.getHeight() - ImageEditor.this.frameTransformation.getHeight()) - ImageEditor.this.frameTransformation.getY())), (int) ImageEditor.this.frameTransformation.getY());
            this.currX = x;
            this.currY = y;
        }

        public final CompatScroller getScroller() {
            return this.scroller;
        }

        public final void setScroller(CompatScroller compatScroller) {
            Intrinsics.checkNotNullParameter(compatScroller, "<set-?>");
            this.scroller = compatScroller;
        }

        public final int getCurrX() {
            return this.currX;
        }

        public final void setCurrX(int i) {
            this.currX = i;
        }

        public final int getCurrY() {
            return this.currY;
        }

        public final void setCurrY(int i) {
            this.currY = i;
        }

        public final void cancelFling() {
            this.scroller.forceFinished(true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.scroller.isFinished() && this.scroller.computeScrollOffset()) {
                int currX = this.scroller.getCurrX();
                int currY = this.scroller.getCurrY();
                int i = currX - this.currX;
                int i2 = currY - this.currY;
                this.currX = currX;
                this.currY = currY;
                RectF rectF = ImageEditor.this.imageTransformation;
                rectF.setX(rectF.getX() + i);
                RectF rectF2 = ImageEditor.this.imageTransformation;
                rectF2.setY(rectF2.getY() + i2);
                ImageEditor.this.compatPostOnAnimation(this);
            }
        }
    }
}
