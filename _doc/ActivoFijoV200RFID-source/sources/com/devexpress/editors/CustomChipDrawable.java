package com.devexpress.editors;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.Size;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import com.devexpress.editors.style.ChipStyle;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChipDrawable.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0016J\u0010\u0010\\\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0002J\u0010\u0010]\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0002J\u0010\u0010^\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0002J\u0010\u0010_\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0002J\u0010\u0010`\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0002J\u0010\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u0006H\u0002J\b\u0010d\u001a\u00020HH\u0016J\n\u0010e\u001a\u0004\u0018\u00010fH\u0002J\b\u0010g\u001a\u00020<H\u0016J\u0012\u0010g\u001a\u00020<2\b\u0010h\u001a\u0004\u0018\u00010iH\u0002J\u0012\u0010g\u001a\u00020<2\b\u0010j\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010k\u001a\u00020YJ\u0010\u0010l\u001a\u00020<2\u0006\u0010m\u001a\u000203H\u0014J\u0010\u0010n\u001a\u00020Y2\u0006\u0010o\u001a\u00020HH\u0016J-\u0010p\u001a\u00020Y2\u0006\u0010q\u001a\u00020H2\u0006\u0010r\u001a\u00020H2\u0006\u0010s\u001a\u00020H2\u0006\u0010t\u001a\u00020HH\u0000¢\u0006\u0002\buJ-\u0010v\u001a\u00020Y2\u0006\u0010q\u001a\u00020H2\u0006\u0010r\u001a\u00020H2\u0006\u0010s\u001a\u00020H2\u0006\u0010t\u001a\u00020HH\u0000¢\u0006\u0002\bwJ\u000e\u0010x\u001a\u00020<2\u0006\u0010y\u001a\u000203J\u0012\u0010z\u001a\u00020Y2\b\u0010{\u001a\u0004\u0018\u00010fH\u0016J\u000e\u0010|\u001a\u00020Y2\u0006\u0010}\u001a\u00020:J\u0006\u0010~\u001a\u00020YJ\u0006\u0010\u007f\u001a\u00020YJ\u000f\u0010\u0080\u0001\u001a\u00020YH\u0000¢\u0006\u0003\b\u0081\u0001J\u001b\u0010\u0082\u0001\u001a\u00020Y2\u0006\u0010j\u001a\u00020\u00012\b\u0010h\u001a\u0004\u0018\u00010iH\u0002J\u0007\u0010\u0083\u0001\u001a\u00020YR\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000eR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001f\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R\u001a\u0010\"\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\u001a\u0010%\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\b\"\u0004\b'\u0010\nR\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010*\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010\u001aR\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u000e\u00106\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020:09X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u00020<X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u00020<8@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\u001a\u0010D\u001a\u00020<X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010>\"\u0004\bF\u0010@R\u001a\u0010G\u001a\u00020HX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010M\u001a\u00020<2\u0006\u0010\u000f\u001a\u00020<@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010>\"\u0004\bO\u0010@R\u001a\u0010P\u001a\u00020QX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0010\u0010V\u001a\u0004\u0018\u00010WX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0084\u0001"}, d2 = {"Lcom/devexpress/editors/CustomChipDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkIconAlpha", "", "getCheckIconAlpha$dxeditors_release", "()F", "setCheckIconAlpha$dxeditors_release", "(F)V", "checkIconBounds", "Landroid/graphics/Rect;", "getCheckIconBounds$dxeditors_release", "()Landroid/graphics/Rect;", "value", "checkIconDrawable", "getCheckIconDrawable$dxeditors_release", "()Landroid/graphics/drawable/Drawable;", "setCheckIconDrawable$dxeditors_release", "(Landroid/graphics/drawable/Drawable;)V", "checkIconSize", "Landroid/util/Size;", "getCheckIconSize$dxeditors_release", "()Landroid/util/Size;", "setCheckIconSize$dxeditors_release", "(Landroid/util/Size;)V", "chipIconBounds", "getChipIconBounds$dxeditors_release", "chipIconClipPath", "Landroid/graphics/Path;", "chipIconDrawable", "getChipIconDrawable$dxeditors_release", "setChipIconDrawable$dxeditors_release", "chipIconSize", "getChipIconSize$dxeditors_release", "setChipIconSize$dxeditors_release", "chipIconTranslation", "getChipIconTranslation$dxeditors_release", "setChipIconTranslation$dxeditors_release", "chipPaint", "Landroid/graphics/Paint;", "closeIconDrawable", "getCloseIconDrawable$dxeditors_release", "setCloseIconDrawable$dxeditors_release", "closeIconRippleMask", "Landroid/graphics/drawable/ShapeDrawable;", "closeIconSize", "getCloseIconSize$dxeditors_release", "setCloseIconSize$dxeditors_release", "closeIconStateSet", "", "getContext", "()Landroid/content/Context;", "defaultCheckIconDrawable", "defaultCloseIconDrawable", "delegate", "Ljava/lang/ref/WeakReference;", "Lcom/devexpress/editors/ChipDrawableDelegate;", "isCheckIconVisible", "", "isCheckIconVisible$dxeditors_release", "()Z", "setCheckIconVisible$dxeditors_release", "(Z)V", "isChipIconVisible", "isChipIconVisible$dxeditors_release", "setChipIconVisible$dxeditors_release", "isCloseIconVisible", "isCloseIconVisible$dxeditors_release", "setCloseIconVisible$dxeditors_release", "rightBound", "", "getRightBound$dxeditors_release", "()I", "setRightBound$dxeditors_release", "(I)V", "roundedIcon", "getRoundedIcon$dxeditors_release", "setRoundedIcon$dxeditors_release", "style", "Lcom/devexpress/editors/style/ChipStyle;", "getStyle$dxeditors_release", "()Lcom/devexpress/editors/style/ChipStyle;", "setStyle$dxeditors_release", "(Lcom/devexpress/editors/style/ChipStyle;)V", "tintFilter", "Landroid/graphics/PorterDuffColorFilter;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "drawCheckIcon", "drawChipBackground", "drawChipBorder", "drawChipIcon", "drawCloseIcon", "getChipCornerRadius", "", "halfBorderThickness", "getOpacity", "getTintColorFilter", "Landroid/graphics/ColorFilter;", "isStateful", "colorStateList", "Landroid/content/res/ColorStateList;", "drawable", "onColorChanged", "onStateChange", "state", "setAlpha", "alpha", "setCheckIconBounds", "left", "top", "right", "bottom", "setCheckIconBounds$dxeditors_release", "setChipIconBounds", "setChipIconBounds$dxeditors_release", "setCloseIconState", "stateSet", "setColorFilter", "colorFilter", "setDelegate", "drawableDelegate", "updateCheckIconColorStateList", "updateCloseIconColorStateList", "updateCloseIconRippleColor", "updateCloseIconRippleColor$dxeditors_release", "updateDrawableTintMode", "updateIconColorStateList", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CustomChipDrawable extends Drawable {
    private float checkIconAlpha;
    private final Rect checkIconBounds;
    private Drawable checkIconDrawable;
    private Size checkIconSize;
    private final Rect chipIconBounds;
    private final Path chipIconClipPath;
    private Drawable chipIconDrawable;
    private Size chipIconSize;
    private float chipIconTranslation;
    private final Paint chipPaint;
    private Drawable closeIconDrawable;
    private final ShapeDrawable closeIconRippleMask;
    private Size closeIconSize;
    private int[] closeIconStateSet;
    private final Context context;
    private final Drawable defaultCheckIconDrawable;
    private final Drawable defaultCloseIconDrawable;
    private WeakReference<ChipDrawableDelegate> delegate;
    private boolean isCheckIconVisible;
    private boolean isChipIconVisible;
    private boolean isCloseIconVisible;
    private int rightBound;
    private boolean roundedIcon;
    private ChipStyle style;
    private PorterDuffColorFilter tintFilter;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public CustomChipDrawable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.style = new ChipStyle(context);
        Drawable drawable = AppCompatResources.getDrawable(context, R.drawable.dxe_chip_check);
        Intrinsics.checkNotNull(drawable);
        this.defaultCheckIconDrawable = drawable;
        Drawable drawable2 = AppCompatResources.getDrawable(context, R.drawable.dxe_chip_close);
        Intrinsics.checkNotNull(drawable2);
        this.defaultCloseIconDrawable = drawable2;
        this.chipPaint = new Paint(1);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        this.closeIconRippleMask = shapeDrawable;
        this.chipIconClipPath = new Path();
        this.chipIconBounds = new Rect();
        this.checkIconBounds = new Rect();
        this.isCheckIconVisible = true;
        this.checkIconSize = new Size(0, 0);
        this.closeIconSize = new Size(0, 0);
        this.chipIconSize = new Size(0, 0);
        this.delegate = new WeakReference<>(null);
        setCloseIconState(Constants.ENABLED_STATE);
        shapeDrawable.setTint(-1);
        setCheckIconDrawable$dxeditors_release(drawable);
        setCloseIconDrawable$dxeditors_release(drawable2);
    }

    public final Context getContext() {
        return this.context;
    }

    /* renamed from: getStyle$dxeditors_release, reason: from getter */
    public final ChipStyle getStyle() {
        return this.style;
    }

    public final void setStyle$dxeditors_release(ChipStyle chipStyle) {
        Intrinsics.checkNotNullParameter(chipStyle, "<set-?>");
        this.style = chipStyle;
    }

    public final void setChipIconVisible$dxeditors_release(boolean z) {
        this.isChipIconVisible = z;
    }

    public final boolean isChipIconVisible$dxeditors_release() {
        return this.isChipIconVisible && this.chipIconDrawable != null;
    }

    /* renamed from: getCheckIconAlpha$dxeditors_release, reason: from getter */
    public final float getCheckIconAlpha() {
        return this.checkIconAlpha;
    }

    public final void setCheckIconAlpha$dxeditors_release(float f) {
        this.checkIconAlpha = f;
    }

    /* renamed from: getRoundedIcon$dxeditors_release, reason: from getter */
    public final boolean getRoundedIcon() {
        return this.roundedIcon;
    }

    public final void setRoundedIcon$dxeditors_release(boolean z) {
        this.roundedIcon = z;
        this.chipIconClipPath.reset();
    }

    /* renamed from: getChipIconBounds$dxeditors_release, reason: from getter */
    public final Rect getChipIconBounds() {
        return this.chipIconBounds;
    }

    /* renamed from: getCheckIconBounds$dxeditors_release, reason: from getter */
    public final Rect getCheckIconBounds() {
        return this.checkIconBounds;
    }

    /* renamed from: isCheckIconVisible$dxeditors_release, reason: from getter */
    public final boolean getIsCheckIconVisible() {
        return this.isCheckIconVisible;
    }

    public final void setCheckIconVisible$dxeditors_release(boolean z) {
        this.isCheckIconVisible = z;
    }

    /* renamed from: isCloseIconVisible$dxeditors_release, reason: from getter */
    public final boolean getIsCloseIconVisible() {
        return this.isCloseIconVisible;
    }

    public final void setCloseIconVisible$dxeditors_release(boolean z) {
        this.isCloseIconVisible = z;
    }

    /* renamed from: getChipIconDrawable$dxeditors_release, reason: from getter */
    public final Drawable getChipIconDrawable() {
        return this.chipIconDrawable;
    }

    public final void setChipIconDrawable$dxeditors_release(Drawable drawable) {
        this.chipIconDrawable = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
        Drawable drawable2 = this.chipIconDrawable;
        int intrinsicWidth = drawable2 != null ? drawable2.getIntrinsicWidth() : 0;
        Drawable drawable3 = this.chipIconDrawable;
        this.chipIconSize = new Size(intrinsicWidth, drawable3 != null ? drawable3.getIntrinsicHeight() : 0);
        updateIconColorStateList();
        invalidateSelf();
    }

    /* renamed from: getCheckIconDrawable$dxeditors_release, reason: from getter */
    public final Drawable getCheckIconDrawable() {
        return this.checkIconDrawable;
    }

    public final void setCheckIconDrawable$dxeditors_release(Drawable drawable) {
        if (drawable == null) {
            drawable = this.defaultCheckIconDrawable;
        }
        this.checkIconDrawable = DrawableCompat.wrap(drawable).mutate();
        Drawable drawable2 = this.checkIconDrawable;
        int intrinsicWidth = drawable2 != null ? drawable2.getIntrinsicWidth() : 0;
        Drawable drawable3 = this.checkIconDrawable;
        this.checkIconSize = new Size(intrinsicWidth, drawable3 != null ? drawable3.getIntrinsicHeight() : 0);
        updateCheckIconColorStateList();
        invalidateSelf();
    }

    /* renamed from: getCloseIconDrawable$dxeditors_release, reason: from getter */
    public final Drawable getCloseIconDrawable() {
        return this.closeIconDrawable;
    }

    public final void setCloseIconDrawable$dxeditors_release(Drawable drawable) {
        if (drawable == null) {
            drawable = this.defaultCloseIconDrawable;
        }
        RippleDrawable mutate = DrawableCompat.wrap(drawable).mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "mutate(...)");
        if (this.style.getUseRippleEffect()) {
            ColorStateList rippleColor$dxeditors_release = this.style.getRippleColor$dxeditors_release();
            Intrinsics.checkNotNull(rippleColor$dxeditors_release);
            mutate = new RippleDrawable(rippleColor$dxeditors_release, mutate, this.closeIconRippleMask);
        }
        this.closeIconDrawable = mutate;
        Drawable drawable2 = this.closeIconDrawable;
        int intrinsicWidth = drawable2 != null ? drawable2.getIntrinsicWidth() : 0;
        Drawable drawable3 = this.closeIconDrawable;
        this.closeIconSize = new Size(intrinsicWidth, drawable3 != null ? drawable3.getIntrinsicHeight() : 0);
        updateCloseIconColorStateList();
        invalidateSelf();
    }

    /* renamed from: getCheckIconSize$dxeditors_release, reason: from getter */
    public final Size getCheckIconSize() {
        return this.checkIconSize;
    }

    public final void setCheckIconSize$dxeditors_release(Size size) {
        Intrinsics.checkNotNullParameter(size, "<set-?>");
        this.checkIconSize = size;
    }

    /* renamed from: getCloseIconSize$dxeditors_release, reason: from getter */
    public final Size getCloseIconSize() {
        return this.closeIconSize;
    }

    public final void setCloseIconSize$dxeditors_release(Size size) {
        Intrinsics.checkNotNullParameter(size, "<set-?>");
        this.closeIconSize = size;
    }

    /* renamed from: getChipIconSize$dxeditors_release, reason: from getter */
    public final Size getChipIconSize() {
        return this.chipIconSize;
    }

    public final void setChipIconSize$dxeditors_release(Size size) {
        Intrinsics.checkNotNullParameter(size, "<set-?>");
        this.chipIconSize = size;
    }

    public final void setDelegate(ChipDrawableDelegate drawableDelegate) {
        Intrinsics.checkNotNullParameter(drawableDelegate, "drawableDelegate");
        this.delegate = new WeakReference<>(drawableDelegate);
    }

    private final boolean isStateful(ColorStateList colorStateList) {
        if (colorStateList != null) {
            return colorStateList.isStateful();
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return isStateful(this.style.getBackgroundColor()) || isStateful(this.checkIconDrawable) || isStateful(this.chipIconDrawable) || isStateful(this.checkIconDrawable);
    }

    public final void onColorChanged() {
        int[] state = getState();
        Intrinsics.checkNotNullExpressionValue(state, "getState(...)");
        onStateChange(state);
        invalidateSelf();
    }

    public final void updateCloseIconRippleColor$dxeditors_release() {
        Drawable drawable;
        if (!this.style.getUseRippleEffect() || (drawable = this.closeIconDrawable) == null) {
            return;
        }
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.RippleDrawable");
        ColorStateList rippleColor$dxeditors_release = this.style.getRippleColor$dxeditors_release();
        Intrinsics.checkNotNull(rippleColor$dxeditors_release);
        ((RippleDrawable) drawable).setColor(rippleColor$dxeditors_release);
    }

    private final float[] getChipCornerRadius(float halfBorderThickness) {
        float f;
        float f2;
        float f3;
        float min = Math.min(this.rightBound - getBounds().left, getBounds().bottom - getBounds().top) / 2.0f;
        if (this.style.getCornerRadii().topLeft < 0.0f || this.style.getCornerRadii().topRight < 0.0f || this.style.getCornerRadii().bottomRight < 0.0f || this.style.getCornerRadii().bottomLeft < 0.0f) {
            f = min;
            f2 = f;
            f3 = f2;
        } else {
            min = this.style.getCornerRadii().topLeft;
            f = this.style.getCornerRadii().topRight;
            f2 = this.style.getCornerRadii().bottomRight;
            f3 = this.style.getCornerRadii().bottomLeft;
        }
        float f4 = min - halfBorderThickness;
        float f5 = f - halfBorderThickness;
        float f6 = f2 - halfBorderThickness;
        float f7 = f3 - halfBorderThickness;
        return new float[]{f4, f4, f5, f5, f6, f6, f7, f7};
    }

    private final ColorFilter getTintColorFilter() {
        return getColorFilter() != null ? getColorFilter() : this.tintFilter;
    }

    private final void drawChipBackground(Canvas canvas) {
        Paint paint = this.chipPaint;
        ColorStateList backgroundColor = this.style.getBackgroundColor();
        Intrinsics.checkNotNull(backgroundColor);
        paint.setColor(backgroundColor.getColorForState(getState(), -3355444));
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.chipPaint.setColorFilter(getTintColorFilter());
        Path path = new Path();
        path.addRoundRect(new RectF(getBounds().left, getBounds().top, this.rightBound, getBounds().bottom), getChipCornerRadius(0.0f), Path.Direction.CW);
        canvas.drawPath(path, this.chipPaint);
    }

    private final void drawChipBorder(Canvas canvas) {
        if (this.style.getBorderThickness() > 0.0f) {
            Paint paint = this.chipPaint;
            ColorStateList borderColor = this.style.getBorderColor();
            Intrinsics.checkNotNull(borderColor);
            paint.setColor(borderColor.getColorForState(getState(), 0));
            this.chipPaint.setStyle(Paint.Style.STROKE);
            this.chipPaint.setStrokeWidth(this.style.getBorderThickness());
            this.chipPaint.setColorFilter(getTintColorFilter());
            RectF rectF = new RectF(getBounds().left + (this.style.getBorderThickness() / 2.0f), getBounds().top + (this.style.getBorderThickness() / 2.0f), this.rightBound - (this.style.getBorderThickness() / 2.0f), getBounds().bottom - (this.style.getBorderThickness() / 2.0f));
            Path path = new Path();
            path.addRoundRect(rectF, getChipCornerRadius(this.style.getBorderThickness() / 2.0f), Path.Direction.CW);
            canvas.drawPath(path, this.chipPaint);
        }
    }

    public final void setChipIconBounds$dxeditors_release(int left, int top, int right, int bottom) {
        if (this.chipIconBounds.left == left && this.chipIconBounds.top == top && this.chipIconBounds.right == right && this.chipIconBounds.bottom == bottom) {
            return;
        }
        this.chipIconBounds.set(left, top, right, bottom);
        if (this.roundedIcon) {
            this.chipIconClipPath.reset();
        }
    }

    public final void setCheckIconBounds$dxeditors_release(int left, int top, int right, int bottom) {
        this.checkIconBounds.set(left, top, right, bottom);
    }

    /* renamed from: getChipIconTranslation$dxeditors_release, reason: from getter */
    public final float getChipIconTranslation() {
        return this.chipIconTranslation;
    }

    public final void setChipIconTranslation$dxeditors_release(float f) {
        this.chipIconTranslation = f;
    }

    private final void drawChipIcon(Canvas canvas) {
        Drawable drawable;
        if (!isChipIconVisible$dxeditors_release() || (drawable = this.chipIconDrawable) == null) {
            return;
        }
        drawable.setState(getState());
        updateDrawableTintMode(drawable, this.style.getIconColor());
        drawable.setBounds(this.chipIconBounds);
        if (this.roundedIcon) {
            canvas.save();
            if (this.chipIconClipPath.isEmpty()) {
                this.chipIconClipPath.addCircle(drawable.getBounds().exactCenterX(), drawable.getBounds().exactCenterY(), Math.min(drawable.getBounds().width(), drawable.getBounds().height()) * 0.5f, Path.Direction.CW);
            }
            canvas.clipPath(this.chipIconClipPath);
        }
        canvas.translate(-this.chipIconTranslation, 0.0f);
        drawable.draw(canvas);
        canvas.translate(this.chipIconTranslation, 0.0f);
        if (this.roundedIcon) {
            canvas.restore();
        }
    }

    private final void drawCloseIcon(Canvas canvas) {
        Drawable drawable;
        if (!this.isCloseIconVisible || (drawable = this.closeIconDrawable) == null) {
            return;
        }
        int[] iArr = this.closeIconStateSet;
        Intrinsics.checkNotNull(iArr);
        drawable.setState(iArr);
        updateDrawableTintMode(drawable, this.style.getCloseIconColor());
        drawable.setBounds((this.rightBound - this.style.getPadding().getEnd()) - drawable.getIntrinsicWidth(), (getBounds().height() / 2) - (drawable.getIntrinsicHeight() / 2), this.rightBound - this.style.getPadding().getEnd(), (getBounds().height() / 2) + (drawable.getIntrinsicHeight() / 2));
        drawable.jumpToCurrentState();
        drawable.draw(canvas);
    }

    private final void drawCheckIcon(Canvas canvas) {
        Drawable drawable;
        if (!this.isCheckIconVisible || (drawable = this.checkIconDrawable) == null) {
            return;
        }
        drawable.setState(getState());
        updateDrawableTintMode(drawable, this.style.getCheckIconColor());
        drawable.setBounds(this.checkIconBounds);
        drawable.setAlpha((int) (this.checkIconAlpha * 255.0f));
        drawable.draw(canvas);
    }

    private final boolean isStateful(Drawable drawable) {
        if (drawable != null) {
            return drawable.isStateful();
        }
        return false;
    }

    public final boolean setCloseIconState(int[] stateSet) {
        Intrinsics.checkNotNullParameter(stateSet, "stateSet");
        if (Arrays.equals(this.closeIconStateSet, stateSet)) {
            return false;
        }
        this.closeIconStateSet = stateSet;
        return this.isCloseIconVisible;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] state) {
        Intrinsics.checkNotNullParameter(state, "state");
        ChipDrawableDelegate chipDrawableDelegate = this.delegate.get();
        if (chipDrawableDelegate == null) {
            return true;
        }
        ColorStateList textColor = this.style.getTextColor();
        Intrinsics.checkNotNull(textColor);
        chipDrawableDelegate.onChipTextColorChange(textColor.getColorForState(state, 0));
        return true;
    }

    private final void updateDrawableTintMode(Drawable drawable, ColorStateList colorStateList) {
        PorterDuff.Mode mode;
        if (colorStateList != null && colorStateList.getColorForState(drawable.getState(), Constants.getEMPTY_COLOR()) != Constants.getEMPTY_COLOR()) {
            mode = PorterDuff.Mode.SRC_IN;
        } else {
            mode = PorterDuff.Mode.DST;
        }
        DrawableCompat.setTintMode(drawable, mode);
    }

    /* renamed from: getRightBound$dxeditors_release, reason: from getter */
    public final int getRightBound() {
        return this.rightBound;
    }

    public final void setRightBound$dxeditors_release(int i) {
        this.rightBound = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getBounds().isEmpty() || getAlpha() == 0) {
            return;
        }
        drawChipBackground(canvas);
        drawChipBorder(canvas);
        drawChipIcon(canvas);
        drawCloseIcon(canvas);
        drawCheckIcon(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public final void updateIconColorStateList() {
        Drawable drawable = this.chipIconDrawable;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, this.style.getIconColor());
        }
        invalidateSelf();
    }

    public final void updateCheckIconColorStateList() {
        Drawable drawable = this.checkIconDrawable;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, this.style.getCheckIconColor());
        }
        invalidateSelf();
    }

    public final void updateCloseIconColorStateList() {
        Drawable drawable = this.closeIconDrawable;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, this.style.getCloseIconColor());
        }
        invalidateSelf();
    }
}
