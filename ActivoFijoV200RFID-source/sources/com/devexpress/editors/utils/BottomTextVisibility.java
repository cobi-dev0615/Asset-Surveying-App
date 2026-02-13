package com.devexpress.editors.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomTextVisibility.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0003\u001f !B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J*\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u001a\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0019\u001a\u00020\u0014H\u0002J0\u0010\u001a\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\fH\u0016J0\u0010\u001e\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\""}, d2 = {"Lcom/devexpress/editors/utils/BottomTextVisibility;", "Landroid/transition/Visibility;", "mode", "", "yTranslation", "(II)V", "(I)V", "getYTranslation", "()I", "captureEndValues", "", "transitionValues", "Landroid/transition/TransitionValues;", "captureStartValues", "captureValues", "createAnimation", "Landroid/animation/Animator;", "view", "Landroid/view/View;", "startAlpha", "", "endAlpha", "startTranslationY", "getStartAlpha", "startValues", "fallbackValue", "onAppear", "sceneRoot", "Landroid/view/ViewGroup;", "endValues", "onDisappear", "AlphaAnimatorListener", "Companion", "TransitionFinalizationListener", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BottomTextVisibility extends Visibility {
    private static String PROPNAME_ALPHA;
    private final int yTranslation;

    public BottomTextVisibility() {
        this(0, 1, null);
    }

    public BottomTextVisibility(int i) {
        this.yTranslation = i;
    }

    public /* synthetic */ BottomTextVisibility(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getYTranslation() {
        return this.yTranslation;
    }

    static {
        String str;
        if (Build.VERSION.SDK_INT >= 29) {
            str = "com.devexpress.editors:BottomTextVisibility:transitionAlpha";
        } else {
            str = "com.devexpress.editors:BottomTextVisibility:alpha";
        }
        PROPNAME_ALPHA = str;
    }

    public BottomTextVisibility(int i, int i2) {
        this(i2);
        setMode(i);
    }

    public /* synthetic */ BottomTextVisibility(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 0 : i2);
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        Intrinsics.checkNotNullParameter(transitionValues, "transitionValues");
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        Intrinsics.checkNotNullParameter(transitionValues, "transitionValues");
        super.captureEndValues(transitionValues);
        captureValues(transitionValues);
    }

    private final void captureValues(TransitionValues transitionValues) {
        if (Build.VERSION.SDK_INT >= 29) {
            Map values = transitionValues.values;
            Intrinsics.checkNotNullExpressionValue(values, "values");
            values.put(PROPNAME_ALPHA, Float.valueOf(transitionValues.view.getTransitionAlpha()));
        } else {
            Map values2 = transitionValues.values;
            Intrinsics.checkNotNullExpressionValue(values2, "values");
            values2.put(PROPNAME_ALPHA, Float.valueOf(transitionValues.view.getAlpha()));
        }
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
        Intrinsics.checkNotNullParameter(view, "view");
        float startAlpha = getStartAlpha(startValues, 0.0f);
        return createAnimation(view, startAlpha != 1.0f ? startAlpha : 0.0f, 1.0f, this.yTranslation);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
        Intrinsics.checkNotNullParameter(view, "view");
        return createAnimation(view, getStartAlpha(startValues, 1.0f), 0.0f, 0.0f);
    }

    private final Animator createAnimation(View view, float startAlpha, float endAlpha, float startTranslationY) {
        ObjectAnimator ofFloat;
        if (startAlpha == endAlpha) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            view.setTransitionAlpha(startAlpha);
            ofFloat = ObjectAnimator.ofFloat(view, "transitionAlpha", endAlpha);
        } else {
            view.setAlpha(startAlpha);
            ofFloat = ObjectAnimator.ofFloat(view, "alpha", endAlpha);
        }
        ofFloat.addListener(new AlphaAnimatorListener(view));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, startTranslationY, 0.0f);
        addListener(new TransitionFinalizationListener(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat2).with(ofFloat);
        return animatorSet;
    }

    private final float getStartAlpha(TransitionValues startValues, float fallbackValue) {
        if (startValues == null) {
            return fallbackValue;
        }
        Object obj = startValues.values.get(PROPNAME_ALPHA);
        Float f = obj instanceof Float ? (Float) obj : null;
        return f != null ? f.floatValue() : fallbackValue;
    }

    /* compiled from: BottomTextVisibility.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/devexpress/editors/utils/BottomTextVisibility$AlphaAnimatorListener;", "Landroid/animation/AnimatorListenerAdapter;", "mView", "Landroid/view/View;", "(Landroid/view/View;)V", "mLayerTypeChanged", "", "onAnimationEnd", "", "animator", "Landroid/animation/Animator;", "onAnimationStart", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class AlphaAnimatorListener extends AnimatorListenerAdapter {
        private boolean mLayerTypeChanged;
        private final View mView;

        public AlphaAnimatorListener(View mView) {
            Intrinsics.checkNotNullParameter(mView, "mView");
            this.mView = mView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            if (this.mView.hasOverlappingRendering() && this.mView.getLayerType() == 0) {
                this.mLayerTypeChanged = true;
                this.mView.setLayerType(2, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            if (Build.VERSION.SDK_INT > 29) {
                this.mView.setTransitionAlpha(1.0f);
            } else {
                this.mView.setAlpha(1.0f);
            }
            if (this.mLayerTypeChanged) {
                this.mView.setLayerType(0, null);
            }
        }
    }

    /* compiled from: BottomTextVisibility.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/devexpress/editors/utils/BottomTextVisibility$TransitionFinalizationListener;", "Landroid/transition/Transition$TransitionListener;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "onTransitionCancel", "", "transition", "Landroid/transition/Transition;", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class TransitionFinalizationListener implements Transition.TransitionListener {
        private final View view;

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }

        public TransitionFinalizationListener(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
        }

        public final View getView() {
            return this.view;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            Intrinsics.checkNotNullParameter(transition, "transition");
            if (Build.VERSION.SDK_INT > 29) {
                this.view.setTransitionAlpha(1.0f);
            } else {
                this.view.setAlpha(1.0f);
            }
            transition.removeListener(this);
        }
    }
}
