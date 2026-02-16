package com.devexpress.editors.animations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.devexpress.editors.Constants;
import com.devexpress.editors.utils.BottomTextState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomTextAnimator.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J \u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0016\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0010J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/devexpress/editors/animations/BottomTextAnimator;", "", "helperTextView", "Landroid/widget/TextView;", "errorTextView", "(Landroid/widget/TextView;Landroid/widget/TextView;)V", "bottomAnimator", "Landroid/animation/AnimatorSet;", "<set-?>", "Lcom/devexpress/editors/utils/BottomTextState;", "state", "getState", "()Lcom/devexpress/editors/utils/BottomTextState;", "cancel", "", "isAnimationInProcess", "", "replaceBottomEditors", "current", "new", "replaceBottomEditorsAnimated", "previousState", "setState", "newState", "animated", "setStateAnimated", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class BottomTextAnimator {
    private AnimatorSet bottomAnimator;
    private TextView errorTextView;
    private TextView helperTextView;
    private BottomTextState state;

    /* compiled from: BottomTextAnimator.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BottomTextState.values().length];
            try {
                iArr[BottomTextState.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BottomTextState.HELPER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BottomTextAnimator(TextView helperTextView, TextView errorTextView) {
        Intrinsics.checkNotNullParameter(helperTextView, "helperTextView");
        Intrinsics.checkNotNullParameter(errorTextView, "errorTextView");
        this.helperTextView = helperTextView;
        this.errorTextView = errorTextView;
        this.state = BottomTextState.NONE;
        this.bottomAnimator = new AnimatorSet();
    }

    public final BottomTextState getState() {
        return this.state;
    }

    public final boolean isAnimationInProcess() {
        return this.bottomAnimator.isRunning();
    }

    public final void setState(BottomTextState state, boolean animated) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == this.state) {
            return;
        }
        cancel();
        if (animated) {
            setStateAnimated(state, this.state);
        } else {
            setState(state);
        }
        this.state = state;
    }

    public final void cancel() {
        this.bottomAnimator.removeAllListeners();
        this.bottomAnimator.end();
        this.bottomAnimator.cancel();
    }

    protected void setStateAnimated(BottomTextState newState, BottomTextState previousState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        Intrinsics.checkNotNullParameter(previousState, "previousState");
        int i = WhenMappings.$EnumSwitchMapping$0[newState.ordinal()];
        if (i == 1) {
            replaceBottomEditorsAnimated(this.helperTextView, this.errorTextView, previousState);
        } else if (i == 2) {
            replaceBottomEditorsAnimated(this.errorTextView, this.helperTextView, previousState);
        } else {
            this.helperTextView.setVisibility(8);
            this.errorTextView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setState(BottomTextState newState) {
        int i = WhenMappings.$EnumSwitchMapping$0[newState.ordinal()];
        if (i == 1) {
            replaceBottomEditors(this.helperTextView, this.errorTextView);
        } else if (i == 2) {
            replaceBottomEditors(this.errorTextView, this.helperTextView);
        } else {
            this.helperTextView.setVisibility(8);
            this.errorTextView.setVisibility(8);
        }
    }

    private final void replaceBottomEditorsAnimated(final TextView current, final TextView r12, BottomTextState previousState) {
        r12.setAlpha(0.0f);
        current.setAlpha(1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(r12, (Property<TextView, Float>) View.ALPHA, 1.0f);
        long j = 2;
        ofFloat.setDuration(Constants.ANIMATION_DURATION / j);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        this.bottomAnimator = new AnimatorSet();
        if (previousState != BottomTextState.NONE) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(current, (Property<TextView, Float>) View.ALPHA, 0.0f);
            ofFloat2.setDuration(Constants.ANIMATION_DURATION / j);
            ofFloat2.setInterpolator(new DecelerateInterpolator());
            ofFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.devexpress.editors.animations.BottomTextAnimator$replaceBottomEditorsAnimated$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    r12.setVisibility(0);
                    current.setVisibility(8);
                }
            });
            this.bottomAnimator.play(ofFloat).after(ofFloat2);
            this.bottomAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.devexpress.editors.animations.BottomTextAnimator$replaceBottomEditorsAnimated$2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    BottomTextAnimator bottomTextAnimator = BottomTextAnimator.this;
                    bottomTextAnimator.setState(bottomTextAnimator.getState());
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    BottomTextAnimator bottomTextAnimator = BottomTextAnimator.this;
                    bottomTextAnimator.setState(bottomTextAnimator.getState());
                }
            });
        } else {
            r12.setVisibility(0);
            this.bottomAnimator.play(ofFloat);
        }
        this.bottomAnimator.start();
    }

    private final void replaceBottomEditors(TextView current, TextView r3) {
        r3.setAlpha(1.0f);
        r3.setVisibility(0);
        current.setAlpha(0.0f);
        current.setVisibility(8);
    }
}
