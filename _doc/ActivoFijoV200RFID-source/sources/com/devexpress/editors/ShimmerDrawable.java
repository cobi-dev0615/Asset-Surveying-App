package com.devexpress.editors;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShimmerDrawable.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 <2\u00020\u0001:\u0001<B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\nH\u0016J\u0010\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u0011H\u0014J\u0010\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020\nH\u0016J\u0012\u00104\u001a\u00020+2\b\u00103\u001a\u0004\u0018\u000105H\u0016J\u0006\u00106\u001a\u00020+J\u0006\u00107\u001a\u00020+J\u0012\u00108\u001a\u00020+2\b\b\u0002\u00109\u001a\u00020:H\u0002J\u0012\u0010;\u001a\u00020+2\b\b\u0002\u00109\u001a\u00020:H\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u001e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000fR$\u0010'\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\t¨\u0006="}, d2 = {"Lcom/devexpress/editors/ShimmerDrawable;", "Landroid/graphics/drawable/Drawable;", "()V", "value", "", "angle", "getAngle", "()F", "setAngle", "(F)V", "", "backgroundColor", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "boundsRect", "Landroid/graphics/Rect;", "calculatedAngle", "paint", "Landroid/graphics/Paint;", "shader", "Landroid/graphics/Shader;", "shaderMatrix", "Landroid/graphics/Matrix;", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "waveDirection", "Lcom/devexpress/editors/WaveDirection;", "", "waveDuration", "getWaveDuration", "()J", "setWaveDuration", "(J)V", "waveOpacity", "getWaveOpacity", "setWaveOpacity", "waveWidth", "getWaveWidth", "setWaveWidth", "createShader", "", "draw", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "onBoundsChange", "bounds", "setAlpha", "p0", "setColorFilter", "Landroid/graphics/ColorFilter;", "start", "stop", "updateSettings", "needStart", "", "updateValueAnimator", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ShimmerDrawable extends Drawable {
    public static final String TAG = "TAG_TAG";
    private float angle;
    private int backgroundColor;
    private Rect boundsRect;
    private float calculatedAngle;
    private final Paint paint;
    private Shader shader;
    private Matrix shaderMatrix;
    private ValueAnimator valueAnimator;
    private WaveDirection waveDirection;
    private long waveDuration;
    private int waveOpacity;
    private float waveWidth;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public ShimmerDrawable() {
        Paint paint = new Paint();
        this.paint = paint;
        this.boundsRect = new Rect();
        this.shaderMatrix = new Matrix();
        this.valueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.waveDirection = WaveDirection.LEFT_TO_RIGHT;
        this.backgroundColor = 1291845631;
        this.waveOpacity = -16777216;
        this.angle = 45.0f;
        this.waveDuration = 1000L;
        this.waveWidth = 0.5f;
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.valueAnimator.setInterpolator(new LinearInterpolator());
        this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.devexpress.editors.ShimmerDrawable$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ShimmerDrawable._init_$lambda$0(ShimmerDrawable.this, valueAnimator);
            }
        });
        this.valueAnimator.setRepeatMode(1);
        this.valueAnimator.setRepeatCount(-1);
        this.valueAnimator.setStartDelay(0L);
        updateSettings$default(this, false, 1, null);
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
        updateSettings$default(this, false, 1, null);
    }

    public final int getWaveOpacity() {
        return this.waveOpacity;
    }

    public final void setWaveOpacity(int i) {
        this.waveOpacity = i;
        updateSettings$default(this, false, 1, null);
    }

    public final float getAngle() {
        return this.angle;
    }

    public final void setAngle(float f) {
        this.angle = f;
        if (45.0f < f && f <= 135.0f) {
            this.calculatedAngle = f - 90;
        } else if (135.0f < f && f <= 225.0f) {
            this.calculatedAngle = f - 180;
        } else if (225.0f < f && f <= 315.0f) {
            this.calculatedAngle = f - 270;
        } else {
            this.calculatedAngle = f;
        }
        updateSettings$default(this, false, 1, null);
    }

    public final long getWaveDuration() {
        return this.waveDuration;
    }

    public final void setWaveDuration(long j) {
        this.waveDuration = j;
        updateValueAnimator$default(this, false, 1, null);
    }

    public final float getWaveWidth() {
        return this.waveWidth;
    }

    public final void setWaveWidth(float f) {
        this.waveWidth = f;
        updateSettings$default(this, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(ShimmerDrawable this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.invalidateSelf();
    }

    public final void start() {
        updateValueAnimator(true);
    }

    public final void stop() {
        this.valueAnimator.cancel();
    }

    static /* synthetic */ void updateSettings$default(ShimmerDrawable shimmerDrawable, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        shimmerDrawable.updateSettings(z);
    }

    private final void updateSettings(boolean needStart) {
        createShader();
        updateValueAnimator(needStart);
    }

    static /* synthetic */ void updateValueAnimator$default(ShimmerDrawable shimmerDrawable, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        shimmerDrawable.updateValueAnimator(z);
    }

    private final void updateValueAnimator(boolean needStart) {
        boolean z = this.valueAnimator.isStarted() || needStart;
        this.valueAnimator.cancel();
        this.valueAnimator.setDuration(this.waveDuration);
        if (z) {
            this.valueAnimator.start();
        }
    }

    private final void createShader() {
        LinearGradient linearGradient;
        float f = this.waveWidth;
        float[] fArr = {0.5f - (f / 2.0f), 0.495f, 0.505f, (f / 2.0f) + 0.5f};
        int i = this.backgroundColor;
        int i2 = this.waveOpacity;
        int[] iArr = {i, i2, i2, i};
        if (this.waveDirection == WaveDirection.LEFT_TO_RIGHT || this.waveDirection == WaveDirection.RIGHT_TO_LEFT) {
            linearGradient = new LinearGradient(0.0f, 0.0f, this.boundsRect.width(), 0.0f, iArr, fArr, Shader.TileMode.CLAMP);
        } else {
            linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, this.boundsRect.height(), iArr, fArr, Shader.TileMode.CLAMP);
        }
        this.shader = linearGradient;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        this.boundsRect = bounds;
        updateSettings$default(this, false, 1, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Object animatedValue = this.valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        float width = (float) (this.boundsRect.width() + (2 * ((Math.abs(Math.tan(Math.toRadians(this.calculatedAngle))) * this.boundsRect.height()) / 2.0f)) + (this.boundsRect.width() * this.waveWidth));
        float f = (floatValue * width) - (width / 2.0f);
        this.shaderMatrix.reset();
        this.shaderMatrix.setRotate(this.angle, this.boundsRect.width() / 2.0f, this.boundsRect.height() / 2.0f);
        this.shaderMatrix.preTranslate(f, f);
        Shader shader = this.shader;
        if (shader != null) {
            shader.setLocalMatrix(this.shaderMatrix);
        }
        this.paint.setShader(this.shader);
        canvas.drawRect(this.boundsRect, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int p0) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter p0) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
