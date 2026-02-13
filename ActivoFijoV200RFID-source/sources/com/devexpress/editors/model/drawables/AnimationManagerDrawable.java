package com.devexpress.editors.model.drawables;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.devexpress.editors.utils.WeakProperty;
import com.devexpress.editors.utils.WeakPropertyKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: AnimationManagerDrawable.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00022\u00020\u00032\u00020\u0004:\u0004PQRSB\u001d\b\u0016\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bB\u0015\u0012\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001bH\u0016J\b\u0010!\u001a\u00020\u001bH\u0016J\b\u0010\"\u001a\u00020\u001bH\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\rH\u0016J\b\u0010'\u001a\u00020\rH\u0016J\b\u0010(\u001a\u00020\u0014H\u0016J\b\u0010)\u001a\u00020\u0002H\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,H\u0014J\u0010\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u001bH\u0017J\u0010\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\u001bH\u0014J\u0010\u00101\u001a\u00020\r2\u0006\u00102\u001a\u000203H\u0014J\u0010\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u001bH\u0016J\u0012\u00109\u001a\u00020\u00142\b\u0010:\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=H\u0016J(\u0010?\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001bH\u0016J\u0012\u0010D\u001a\u00020\u00142\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010G\u001a\u00020\u00142\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0018\u0010J\u001a\u00020\r2\u0006\u0010K\u001a\u00020\r2\u0006\u0010L\u001a\u00020\rH\u0016J\b\u0010M\u001a\u00020\u0014H\u0016J\b\u0010N\u001a\u00020\u0014H\u0016J\u0010\u0010O\u001a\u00020\r2\u0006\u00105\u001a\u000206H\u0016R\u0016\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable;", "TDrawable", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Animatable;", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat;", "drawableToAnimate", "delegate", "Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$Delegate;", "(Landroid/graphics/drawable/Drawable;Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$Delegate;)V", "drawableState", "Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$ManagedAnimatedDrawableState;", "(Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$ManagedAnimatedDrawableState;)V", "mMutated", "", "managedDrawable", "getManagedDrawable", "()Landroid/graphics/drawable/Drawable;", "managedDrawableCallback", "Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$Callback;", "applyParams", "", "cancel", "clearAnimationCallbacks", "draw", "canvas", "Landroid/graphics/Canvas;", "getAlpha", "", "getColorFilter", "Landroid/graphics/ColorFilter;", "getConstantState", "Landroid/graphics/drawable/Drawable$ConstantState;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "getOutline", "outline", "Landroid/graphics/Outline;", "isRunning", "isStateful", "jumpToCurrentState", "mutate", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "onLayoutDirectionChanged", "layoutDirection", "onLevelChange", "level", "onStateChange", "state", "", "registerAnimationCallback", "callback", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "setHotspot", "x", "", "y", "setHotspotBounds", "left", "top", "right", "bottom", "setTintList", "tint", "Landroid/content/res/ColorStateList;", "setTintMode", "tintMode", "Landroid/graphics/PorterDuff$Mode;", "setVisible", "visible", "restart", "start", "stop", "unregisterAnimationCallback", "Callback", "Delegate", "DrawableParams", "ManagedAnimatedDrawableState", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AnimationManagerDrawable<TDrawable extends Drawable> extends Drawable implements Animatable, Animatable2Compat {
    private ManagedAnimatedDrawableState<? extends TDrawable> drawableState;
    private boolean mMutated;
    private final Callback managedDrawableCallback;

    /* compiled from: AnimationManagerDrawable.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\tJ%\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00028\u00012\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH&¢\u0006\u0002\u0010\u000eJ \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH&J\u001d\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0012\u001a\u00020\bH&¢\u0006\u0002\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$Delegate;", "D", "Landroid/graphics/drawable/Drawable;", "", "applyParams", "", "managedDrawable", "params", "Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$DrawableParams;", "(Landroid/graphics/drawable/Drawable;Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$DrawableParams;)V", "createAnimator", "Landroid/animation/ValueAnimator;", "startParams", "endParams", "(Landroid/graphics/drawable/Drawable;Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$DrawableParams;Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$DrawableParams;)Landroid/animation/ValueAnimator;", "fillParamsForState", "state", "", "targetParams", "defaultParams", "fillParamsFromDrawable", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Delegate<D extends Drawable> {
        void applyParams(D managedDrawable, DrawableParams params);

        ValueAnimator createAnimator(D managedDrawable, DrawableParams startParams, DrawableParams endParams);

        void fillParamsForState(int[] state, DrawableParams targetParams, DrawableParams defaultParams);

        void fillParamsFromDrawable(D managedDrawable, DrawableParams targetParams);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    public AnimationManagerDrawable(ManagedAnimatedDrawableState<? extends TDrawable> drawableState) {
        Intrinsics.checkNotNullParameter(drawableState, "drawableState");
        this.drawableState = drawableState;
        this.managedDrawableCallback = new Callback(this);
    }

    public final TDrawable getManagedDrawable() {
        return this.drawableState.getManagedDrawable();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnimationManagerDrawable(TDrawable drawableToAnimate, Delegate<TDrawable> delegate) {
        this(new ManagedAnimatedDrawableState(drawableToAnimate, delegate));
        Intrinsics.checkNotNullParameter(drawableToAnimate, "drawableToAnimate");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.drawableState.getManagedDrawable().setCallback(this.managedDrawableCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.drawableState.animator.isStarted()) {
            invalidateSelf();
        }
        this.drawableState.getManagedDrawable().draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.drawableState.getManagedDrawable().setCallback(null);
            ManagedAnimatedDrawableState<? extends TDrawable> managedAnimatedDrawableState = new ManagedAnimatedDrawableState<>(this.drawableState);
            this.drawableState = managedAnimatedDrawableState;
            managedAnimatedDrawableState.getManagedDrawable().setCallback(this.managedDrawableCallback);
            this.mMutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        this.drawableState.getManagedDrawable().setBounds(bounds);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] state) {
        Intrinsics.checkNotNullParameter(state, "state");
        cancel();
        this.drawableState.prepareParams(state);
        start();
        this.drawableState.getManagedDrawable().setState(state);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        cancel();
        ManagedAnimatedDrawableState<? extends TDrawable> managedAnimatedDrawableState = this.drawableState;
        int[] state = getState();
        Intrinsics.checkNotNullExpressionValue(state, "getState(...)");
        managedAnimatedDrawableState.prepareParams(state);
        applyParams();
        this.drawableState.getManagedDrawable().setState(getState());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int level) {
        return this.drawableState.getManagedDrawable().setLevel(level);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int layoutDirection) {
        return this.drawableState.getManagedDrawable().setLayoutDirection(layoutDirection);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.drawableState.getManagedDrawable().getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.drawableState.getManagedDrawable().setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.drawableState.getManagedDrawable().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.drawableState.getManagedDrawable().getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList tint) {
        this.drawableState.getManagedDrawable().setTintList(tint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float x, float y) {
        this.drawableState.getManagedDrawable().setHotspot(x, y);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int left, int top, int right, int bottom) {
        this.drawableState.getManagedDrawable().setHotspotBounds(left, top, right, bottom);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode tintMode) {
        this.drawableState.getManagedDrawable().setTintMode(tintMode);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        if (this.drawableState.animator.isStarted()) {
            if (visible) {
                this.drawableState.animator.resume();
            } else {
                this.drawableState.animator.pause();
            }
        }
        this.drawableState.getManagedDrawable().setVisible(visible, restart);
        return super.setVisible(visible, restart);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.drawableState.getManagedDrawable().getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.drawableState.getManagedDrawable().getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Intrinsics.checkNotNullParameter(outline, "outline");
        this.drawableState.getManagedDrawable().getOutline(outline);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.drawableState.animator.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        ValueAnimator valueAnimator = this.drawableState.animator;
        if (valueAnimator.isStarted()) {
            return;
        }
        valueAnimator.start();
        invalidateSelf();
    }

    private final void applyParams() {
        this.drawableState.applyEndParams();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        ValueAnimator valueAnimator = this.drawableState.animator;
        if (valueAnimator.isStarted()) {
            valueAnimator.end();
        }
    }

    private final void cancel() {
        ValueAnimator valueAnimator = this.drawableState.animator;
        if (valueAnimator.isStarted()) {
            valueAnimator.cancel();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        this.drawableState.changingConfigurations = getChangingConfigurations();
        return this.drawableState;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(Animatable2Compat.AnimationCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.drawableState.callbacks.add(callback);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        this.drawableState.callbacks.clear();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return this.drawableState.callbacks.remove(callback);
    }

    /* compiled from: AnimationManagerDrawable.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003B\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0002\u0010\u0005B\u001b\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u0010H\u0016J\b\u0010 \u001a\u00020\u0002H\u0016J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00028\u0001X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001c\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$ManagedAnimatedDrawableState;", "D", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable$ConstantState;", "other", "(Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$ManagedAnimatedDrawableState;)V", "managedDrawable", "delegate", "Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$Delegate;", "(Landroid/graphics/drawable/Drawable;Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$Delegate;)V", "animator", "Landroid/animation/ValueAnimator;", "callbacks", "", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "changingConfigurations", "", "getDelegate", "()Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$Delegate;", "setDelegate", "(Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$Delegate;)V", "endParams", "Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$DrawableParams;", "getManagedDrawable", "()Landroid/graphics/drawable/Drawable;", "setManagedDrawable", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/graphics/drawable/Drawable;", "startParams", "applyEndParams", "", "getChangingConfigurations", "newDrawable", "prepareParams", "state", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ManagedAnimatedDrawableState<D extends Drawable> extends Drawable.ConstantState {
        public final ValueAnimator animator;
        public final List<Animatable2Compat.AnimationCallback> callbacks;
        public int changingConfigurations;
        private Delegate<D> delegate;
        public final DrawableParams endParams;
        private D managedDrawable;
        public final DrawableParams startParams;

        public final D getManagedDrawable() {
            return this.managedDrawable;
        }

        public final void setManagedDrawable(D d) {
            Intrinsics.checkNotNullParameter(d, "<set-?>");
            this.managedDrawable = d;
        }

        public final Delegate<D> getDelegate() {
            return this.delegate;
        }

        public final void setDelegate(Delegate<D> delegate) {
            Intrinsics.checkNotNullParameter(delegate, "<set-?>");
            this.delegate = delegate;
        }

        public ManagedAnimatedDrawableState(D managedDrawable, Delegate<D> delegate) {
            Intrinsics.checkNotNullParameter(managedDrawable, "managedDrawable");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.managedDrawable = managedDrawable;
            this.delegate = delegate;
            this.callbacks = new ArrayList();
            DrawableParams drawableParams = new DrawableParams();
            this.startParams = drawableParams;
            DrawableParams drawableParams2 = new DrawableParams();
            this.endParams = drawableParams2;
            this.animator = this.delegate.createAnimator(this.managedDrawable, drawableParams, drawableParams2);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ManagedAnimatedDrawableState(com.devexpress.editors.model.drawables.AnimationManagerDrawable.ManagedAnimatedDrawableState<D> r3) {
            /*
                r2 = this;
                java.lang.String r0 = "other"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                D extends android.graphics.drawable.Drawable r0 = r3.managedDrawable
                android.graphics.drawable.Drawable$ConstantState r0 = r0.getConstantState()
                if (r0 == 0) goto L12
                android.graphics.drawable.Drawable r0 = r0.newDrawable()
                goto L13
            L12:
                r0 = 0
            L13:
                java.lang.String r1 = "null cannot be cast to non-null type D of com.devexpress.editors.model.drawables.AnimationManagerDrawable.ManagedAnimatedDrawableState"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
                com.devexpress.editors.model.drawables.AnimationManagerDrawable$Delegate<D extends android.graphics.drawable.Drawable> r1 = r3.delegate
                r2.<init>(r0, r1)
                int r0 = r3.changingConfigurations
                r2.changingConfigurations = r0
                java.util.List<androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback> r0 = r2.callbacks
                java.util.List<androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback> r3 = r3.callbacks
                java.util.Collection r3 = (java.util.Collection) r3
                r0.addAll(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.devexpress.editors.model.drawables.AnimationManagerDrawable.ManagedAnimatedDrawableState.<init>(com.devexpress.editors.model.drawables.AnimationManagerDrawable$ManagedAnimatedDrawableState):void");
        }

        public final void prepareParams(int[] state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.delegate.fillParamsFromDrawable(this.managedDrawable, this.startParams);
            this.delegate.fillParamsForState(state, this.endParams, this.startParams);
        }

        public final void applyEndParams() {
            this.delegate.applyParams(this.managedDrawable, this.endParams);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new AnimationManagerDrawable(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.changingConfigurations;
        }
    }

    /* compiled from: AnimationManagerDrawable.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R!\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$Callback;", "Landroid/graphics/drawable/Drawable$Callback;", "drawable", "Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable;", "(Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable;)V", "weakDrawable", "getWeakDrawable", "()Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable;", "weakDrawable$delegate", "Lcom/devexpress/editors/utils/WeakProperty;", "invalidateDrawable", "", "who", "Landroid/graphics/drawable/Drawable;", "scheduleDrawable", "what", "Ljava/lang/Runnable;", "when", "", "unscheduleDrawable", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Callback implements Drawable.Callback {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Callback.class, "weakDrawable", "getWeakDrawable()Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable;", 0))};

        /* renamed from: weakDrawable$delegate, reason: from kotlin metadata */
        private final WeakProperty weakDrawable;

        public Callback(AnimationManagerDrawable<?> drawable) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            this.weakDrawable = WeakPropertyKt.weak(drawable);
        }

        private final AnimationManagerDrawable<?> getWeakDrawable() {
            return (AnimationManagerDrawable) this.weakDrawable.getValue(this, $$delegatedProperties[0]);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable who, Runnable what) {
            Intrinsics.checkNotNullParameter(who, "who");
            Intrinsics.checkNotNullParameter(what, "what");
            AnimationManagerDrawable<?> weakDrawable = getWeakDrawable();
            if (weakDrawable != null) {
                weakDrawable.unscheduleSelf(what);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable who) {
            Intrinsics.checkNotNullParameter(who, "who");
            AnimationManagerDrawable<?> weakDrawable = getWeakDrawable();
            if (weakDrawable != null) {
                weakDrawable.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable who, Runnable what, long when) {
            Intrinsics.checkNotNullParameter(who, "who");
            Intrinsics.checkNotNullParameter(what, "what");
            AnimationManagerDrawable<?> weakDrawable = getWeakDrawable();
            if (weakDrawable != null) {
                weakDrawable.scheduleSelf(what, when);
            }
        }
    }

    /* compiled from: AnimationManagerDrawable.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$DrawableParams;", "", "()V", "cutOutProgress", "", "fillColor", "", "strokeColor", "strokeWidth", "set", "", "other", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DrawableParams {
        public float cutOutProgress;
        public int fillColor;
        public int strokeColor;
        public float strokeWidth;

        public final void set(DrawableParams other) {
            Intrinsics.checkNotNullParameter(other, "other");
            this.strokeWidth = other.strokeWidth;
            this.strokeColor = other.strokeColor;
            this.fillColor = other.fillColor;
            this.cutOutProgress = other.cutOutProgress;
        }
    }
}
