package com.devexpress.dxlistview.core;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.devexpress.dxlistview.layouts.LayoutElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DragDropManager.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u001a\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u001a\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u001a\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/devexpress/dxlistview/core/ElementHolder;", "", "element", "Lcom/devexpress/dxlistview/layouts/LayoutElement;", "(Lcom/devexpress/dxlistview/layouts/LayoutElement;)V", "animator", "Landroid/animation/AnimatorSet;", TypedValues.AttributesType.S_FRAME, "Landroid/graphics/Rect;", "getFrame", "()Landroid/graphics/Rect;", "index", "", "getIndex", "()I", "renderContentBounds", "getRenderContentBounds", "translation", "Landroid/graphics/Point;", "resetTranslation", "", "animation", "Lcom/devexpress/dxlistview/core/AnimationOptions;", "translateTo", TypedValues.CycleType.S_WAVE_OFFSET, "translateX", "x", "translateY", "y", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ElementHolder {
    private AnimatorSet animator;
    private final LayoutElement element;
    private Point translation;

    public ElementHolder(LayoutElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        this.element = element;
        this.translation = new Point(0, 0);
    }

    public final Rect getRenderContentBounds() {
        Rect rect = new Rect(this.element.getLeft(), this.element.getTop(), this.element.getRight(), this.element.getBottom());
        rect.offset(this.translation.x, this.translation.y);
        return rect;
    }

    public final Rect getFrame() {
        return new Rect(this.element.getLeft(), this.element.getTop(), this.element.getRight(), this.element.getBottom());
    }

    public final int getIndex() {
        return this.element.getIndex();
    }

    public static /* synthetic */ void resetTranslation$default(ElementHolder elementHolder, AnimationOptions animationOptions, int i, Object obj) {
        if ((i & 1) != 0) {
            animationOptions = null;
        }
        elementHolder.resetTranslation(animationOptions);
    }

    public final void resetTranslation(AnimationOptions animation) {
        translateTo(new Point(0, 0), animation);
    }

    public static /* synthetic */ void translateX$default(ElementHolder elementHolder, int i, AnimationOptions animationOptions, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            animationOptions = null;
        }
        elementHolder.translateX(i, animationOptions);
    }

    public final void translateX(int x, AnimationOptions animation) {
        translateTo(new Point(x, 0), animation);
    }

    public static /* synthetic */ void translateY$default(ElementHolder elementHolder, int i, AnimationOptions animationOptions, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            animationOptions = null;
        }
        elementHolder.translateY(i, animationOptions);
    }

    public final void translateY(int y, AnimationOptions animation) {
        translateTo(new Point(0, y), animation);
    }

    private final void translateTo(Point offset, AnimationOptions animation) {
        if (Intrinsics.areEqual(this.translation, offset)) {
            return;
        }
        this.translation = offset;
        AnimatorSet animatorSet = this.animator;
        if (animatorSet != null) {
            Intrinsics.checkNotNull(animatorSet);
            if (animatorSet.isRunning()) {
                AnimatorSet animatorSet2 = this.animator;
                Intrinsics.checkNotNull(animatorSet2);
                animatorSet2.cancel();
            }
        }
        if (animation != null) {
            AnimatorSet animatorSet3 = new AnimatorSet();
            this.animator = animatorSet3;
            Intrinsics.checkNotNull(animatorSet3);
            animatorSet3.setDuration(animation.getDuration());
            if (animation.getInterpolator() != null) {
                AnimatorSet animatorSet4 = this.animator;
                Intrinsics.checkNotNull(animatorSet4);
                animatorSet4.setInterpolator(animation.getInterpolator());
            }
            AnimatorSet animatorSet5 = this.animator;
            Intrinsics.checkNotNull(animatorSet5);
            animatorSet5.play(ObjectAnimator.ofFloat(this.element.getView(), (Property<View, Float>) View.TRANSLATION_Y, offset.y)).with(ObjectAnimator.ofFloat(this.element.getView(), (Property<View, Float>) View.TRANSLATION_X, offset.x));
            AnimatorSet animatorSet6 = this.animator;
            Intrinsics.checkNotNull(animatorSet6);
            animatorSet6.start();
            return;
        }
        this.element.getView().setTranslationY(offset.y);
        this.element.getView().setTranslationX(offset.x);
    }
}
