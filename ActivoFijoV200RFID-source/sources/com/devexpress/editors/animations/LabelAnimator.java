package com.devexpress.editors.animations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.devexpress.editors.Constants;
import com.devexpress.editors.animations.LabelAnimator;
import com.devexpress.editors.model.MathUtilsKt;
import com.devexpress.editors.style.TextEditStyle;
import com.devexpress.editors.utils.LabelPosition;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: LabelAnimator.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 R2\u00020\u0001:\u0002RSBE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n¢\u0006\u0002\u0010\rJ\b\u0010C\u001a\u00020\fH\u0002J\b\u0010D\u001a\u00020\fH\u0002J\b\u0010E\u001a\u00020\fH\u0002J\u0006\u0010F\u001a\u00020\fJ\u0006\u0010G\u001a\u00020\fJ\u000e\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\u0014J\u0018\u0010J\u001a\u00020\f2\u0006\u00102\u001a\u00020\u00142\b\b\u0002\u0010I\u001a\u00020\u0014J\u0018\u0010K\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00142\b\b\u0002\u0010I\u001a\u00020\u0014J\u0018\u0010L\u001a\u00020\f2\u0006\u00103\u001a\u00020\u00142\b\b\u0002\u0010I\u001a\u00020\u0014J\u0018\u00108\u001a\u00020\f2\u0006\u0010M\u001a\u00020\u000b2\b\b\u0002\u0010I\u001a\u00020\u0014JE\u0010N\u001a\u00020\f2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010I\u001a\u00020\u0014¢\u0006\u0002\u0010OJ\b\u0010P\u001a\u00020\u0014H\u0002J\b\u0010Q\u001a\u00020\fH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u001a\u0010(\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010+\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R\u001e\u0010/\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0016R\u0011\u00101\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b1\u0010\u0016R\u001e\u00102\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0016R\u001e\u00103\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0016R\u000e\u00104\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R+\u00105\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0016\"\u0004\bB\u0010\u0018¨\u0006T"}, d2 = {"Lcom/devexpress/editors/animations/LabelAnimator;", "", "label", "Landroid/widget/TextView;", "content", "prefix", "suffix", "style", "Lcom/devexpress/editors/style/TextEditStyle;", "labelChangedCallback", "Lkotlin/Function1;", "Lcom/devexpress/editors/utils/LabelPosition;", "", "(Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Lcom/devexpress/editors/style/TextEditStyle;Lkotlin/jvm/functions/Function1;)V", "actualLabelClipBounds", "Landroid/graphics/Rect;", "animationsList", "", "Landroid/animation/Animator;", "canAnimate", "", "getCanAnimate", "()Z", "setCanAnimate", "(Z)V", "expandedLabelMaxWidth", "", "getExpandedLabelMaxWidth", "()I", "setExpandedLabelMaxWidth", "(I)V", "expandedLabelScaleX", "", "getExpandedLabelScaleX", "()F", "setExpandedLabelScaleX", "(F)V", "expandedLabelScaleY", "getExpandedLabelScaleY", "setExpandedLabelScaleY", "expandedLabelTranslateX", "getExpandedLabelTranslateX", "setExpandedLabelTranslateX", "expandedLabelTranslateY", "getExpandedLabelTranslateY", "setExpandedLabelTranslateY", "<set-?>", "hasError", "getHasError", "isAnimationInProcess", "isEnabled", "isFocused", "isShakeAnimationRequired", "labelPosition", "getLabelPosition", "()Lcom/devexpress/editors/utils/LabelPosition;", "setLabelPosition", "(Lcom/devexpress/editors/utils/LabelPosition;)V", "labelPosition$delegate", "Lkotlin/properties/ReadWriteProperty;", "state", "Lcom/devexpress/editors/animations/LabelAnimator$LabelState;", "stateAnimation", "Landroid/animation/AnimatorSet;", "useOnlyAlphaCollapseAnimationForLabel", "getUseOnlyAlphaCollapseAnimationForLabel", "setUseOnlyAlphaCollapseAnimationForLabel", "applyLabelState", "applyLabelStateAnimated", "cancelAnimation", "jumpToCurrentState", "onLayoutChanged", "onStateChanged", "animated", "setEnabled", "setHasError", "setIsFocused", "position", "setState", "(Lcom/devexpress/editors/utils/LabelPosition;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Z)V", "updateBounds", "updateLabelState", "Companion", "LabelState", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LabelAnimator {
    private final Rect actualLabelClipBounds;
    private final List<Animator> animationsList;
    private boolean canAnimate;
    private final TextView content;
    private int expandedLabelMaxWidth;
    private float expandedLabelScaleX;
    private float expandedLabelScaleY;
    private float expandedLabelTranslateX;
    private float expandedLabelTranslateY;
    private boolean hasError;
    private boolean isEnabled;
    private boolean isFocused;
    private boolean isShakeAnimationRequired;
    private final TextView label;
    private final Function1<LabelPosition, Unit> labelChangedCallback;

    /* renamed from: labelPosition$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty labelPosition;
    private final TextView prefix;
    private final LabelState state;
    private AnimatorSet stateAnimation;
    private final TextEditStyle style;
    private final TextView suffix;
    private boolean useOnlyAlphaCollapseAnimationForLabel;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(LabelAnimator.class, "labelPosition", "getLabelPosition()Lcom/devexpress/editors/utils/LabelPosition;", 0))};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ArgbEvaluator ARGB_EVALUATOR = new ArgbEvaluator();
    private static final TimeInterpolator ACCELERATE_DECELERATE_INTERPOLATOR = new AccelerateDecelerateInterpolator();
    private static final TimeInterpolator ACCELERATE_INTERPOLATOR = new AccelerateInterpolator();
    private static final TimeInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    private static final TimeInterpolator CYCLE_INTERPOLATOR = new CycleInterpolator(1.0f);
    private static final float MIN_ZINDEX = -10000.0f;

    private final boolean updateBounds() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LabelAnimator(TextView label, TextView content, TextView prefix, TextView suffix, TextEditStyle style, Function1<? super LabelPosition, Unit> function1) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        Intrinsics.checkNotNullParameter(style, "style");
        this.label = label;
        this.content = content;
        this.prefix = prefix;
        this.suffix = suffix;
        this.style = style;
        this.labelChangedCallback = function1;
        this.actualLabelClipBounds = new Rect(0, 0, 0, 0);
        this.animationsList = new ArrayList();
        this.state = new LabelState();
        this.expandedLabelScaleX = 1.0f;
        this.expandedLabelScaleY = 1.0f;
        Delegates delegates = Delegates.INSTANCE;
        final LabelPosition labelPosition = LabelPosition.ON_TOP;
        this.labelPosition = new ObservableProperty<LabelPosition>(labelPosition) { // from class: com.devexpress.editors.animations.LabelAnimator$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, LabelPosition oldValue, LabelPosition newValue) {
                Function1 function12;
                Intrinsics.checkNotNullParameter(property, "property");
                LabelPosition labelPosition2 = newValue;
                function12 = this.labelChangedCallback;
                if (function12 != null) {
                    function12.invoke(labelPosition2);
                }
            }
        };
        this.isEnabled = true;
    }

    public /* synthetic */ LabelAnimator(TextView textView, TextView textView2, TextView textView3, TextView textView4, TextEditStyle textEditStyle, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textView, textView2, textView3, textView4, textEditStyle, (i & 32) != 0 ? null : function1);
    }

    /* compiled from: LabelAnimator.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/devexpress/editors/animations/LabelAnimator$Companion;", "", "()V", "ACCELERATE_DECELERATE_INTERPOLATOR", "Landroid/animation/TimeInterpolator;", "getACCELERATE_DECELERATE_INTERPOLATOR", "()Landroid/animation/TimeInterpolator;", "ACCELERATE_INTERPOLATOR", "getACCELERATE_INTERPOLATOR", "ARGB_EVALUATOR", "Landroid/animation/ArgbEvaluator;", "getARGB_EVALUATOR", "()Landroid/animation/ArgbEvaluator;", "CYCLE_INTERPOLATOR", "getCYCLE_INTERPOLATOR", "DECELERATE_INTERPOLATOR", "getDECELERATE_INTERPOLATOR", "MIN_ZINDEX", "", "getMIN_ZINDEX", "()F", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArgbEvaluator getARGB_EVALUATOR() {
            return LabelAnimator.ARGB_EVALUATOR;
        }

        public final TimeInterpolator getACCELERATE_DECELERATE_INTERPOLATOR() {
            return LabelAnimator.ACCELERATE_DECELERATE_INTERPOLATOR;
        }

        public final TimeInterpolator getACCELERATE_INTERPOLATOR() {
            return LabelAnimator.ACCELERATE_INTERPOLATOR;
        }

        public final TimeInterpolator getDECELERATE_INTERPOLATOR() {
            return LabelAnimator.DECELERATE_INTERPOLATOR;
        }

        public final TimeInterpolator getCYCLE_INTERPOLATOR() {
            return LabelAnimator.CYCLE_INTERPOLATOR;
        }

        public final float getMIN_ZINDEX() {
            return LabelAnimator.MIN_ZINDEX;
        }
    }

    public final boolean getUseOnlyAlphaCollapseAnimationForLabel() {
        return this.useOnlyAlphaCollapseAnimationForLabel;
    }

    public final void setUseOnlyAlphaCollapseAnimationForLabel(boolean z) {
        this.useOnlyAlphaCollapseAnimationForLabel = z;
    }

    public final float getExpandedLabelTranslateX() {
        return this.expandedLabelTranslateX;
    }

    public final void setExpandedLabelTranslateX(float f) {
        this.expandedLabelTranslateX = f;
    }

    public final float getExpandedLabelTranslateY() {
        return this.expandedLabelTranslateY;
    }

    public final void setExpandedLabelTranslateY(float f) {
        this.expandedLabelTranslateY = f;
    }

    public final float getExpandedLabelScaleX() {
        return this.expandedLabelScaleX;
    }

    public final void setExpandedLabelScaleX(float f) {
        this.expandedLabelScaleX = f;
    }

    public final float getExpandedLabelScaleY() {
        return this.expandedLabelScaleY;
    }

    public final void setExpandedLabelScaleY(float f) {
        this.expandedLabelScaleY = f;
    }

    public final int getExpandedLabelMaxWidth() {
        return this.expandedLabelMaxWidth;
    }

    public final void setExpandedLabelMaxWidth(int i) {
        this.expandedLabelMaxWidth = i;
    }

    private final void setLabelPosition(LabelPosition labelPosition) {
        this.labelPosition.setValue(this, $$delegatedProperties[0], labelPosition);
    }

    public final LabelPosition getLabelPosition() {
        return (LabelPosition) this.labelPosition.getValue(this, $$delegatedProperties[0]);
    }

    public final boolean getHasError() {
        return this.hasError;
    }

    /* renamed from: isFocused, reason: from getter */
    public final boolean getIsFocused() {
        return this.isFocused;
    }

    /* renamed from: isEnabled, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final boolean isAnimationInProcess() {
        AnimatorSet animatorSet = this.stateAnimation;
        if (animatorSet != null) {
            return animatorSet.isRunning();
        }
        return false;
    }

    public final boolean getCanAnimate() {
        return this.canAnimate;
    }

    public final void setCanAnimate(boolean z) {
        this.canAnimate = z;
    }

    public static /* synthetic */ void setLabelPosition$default(LabelAnimator labelAnimator, LabelPosition labelPosition, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        labelAnimator.setLabelPosition(labelPosition, z);
    }

    public final void setLabelPosition(LabelPosition position, boolean animated) {
        Intrinsics.checkNotNullParameter(position, "position");
        if (getLabelPosition() == position) {
            return;
        }
        setLabelPosition(position);
        cancelAnimation();
        onLayoutChanged();
        if (getLabelPosition() == LabelPosition.NONE) {
            return;
        }
        updateLabelState();
        if (this.canAnimate && animated) {
            applyLabelStateAnimated();
        } else {
            applyLabelState();
        }
    }

    public static /* synthetic */ void setHasError$default(LabelAnimator labelAnimator, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        labelAnimator.setHasError(z, z2);
    }

    public final void setHasError(boolean hasError, boolean animated) {
        if (this.hasError == hasError) {
            return;
        }
        this.hasError = hasError;
        cancelAnimation();
        onLayoutChanged();
        updateLabelState();
        this.isShakeAnimationRequired = hasError && getLabelPosition() == LabelPosition.ON_TOP;
        if (this.canAnimate && animated) {
            applyLabelStateAnimated();
        } else {
            applyLabelState();
        }
    }

    public static /* synthetic */ void setIsFocused$default(LabelAnimator labelAnimator, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        labelAnimator.setIsFocused(z, z2);
    }

    public final void setIsFocused(boolean isFocused, boolean animated) {
        if (this.isFocused == isFocused) {
            return;
        }
        this.isFocused = isFocused;
        cancelAnimation();
        updateLabelState();
        if (this.canAnimate && animated) {
            applyLabelStateAnimated();
        } else {
            applyLabelState();
        }
    }

    public static /* synthetic */ void setEnabled$default(LabelAnimator labelAnimator, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        labelAnimator.setEnabled(z, z2);
    }

    public final void setEnabled(boolean isEnabled, boolean animated) {
        if (this.isEnabled == isEnabled) {
            return;
        }
        this.isEnabled = isEnabled;
        cancelAnimation();
        updateLabelState();
        if (this.canAnimate && animated) {
            applyLabelStateAnimated();
        } else {
            applyLabelState();
        }
    }

    public static /* synthetic */ void setState$default(LabelAnimator labelAnimator, LabelPosition labelPosition, Boolean bool, Boolean bool2, Boolean bool3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            labelPosition = null;
        }
        if ((i & 2) != 0) {
            bool = null;
        }
        if ((i & 4) != 0) {
            bool2 = null;
        }
        if ((i & 8) != 0) {
            bool3 = null;
        }
        if ((i & 16) != 0) {
            z = false;
        }
        labelAnimator.setState(labelPosition, bool, bool2, bool3, z);
    }

    public final void setState(LabelPosition position, Boolean isFocused, Boolean hasError, Boolean isEnabled, boolean animated) {
        boolean z = true;
        boolean z2 = false;
        if (position != null && getLabelPosition() != position) {
            setLabelPosition(position);
            cancelAnimation();
            if (getLabelPosition() != LabelPosition.NONE) {
                z2 = true;
            }
        }
        boolean z3 = z2;
        if (isFocused != null && !Intrinsics.areEqual(Boolean.valueOf(this.isFocused), isFocused)) {
            this.isFocused = isFocused.booleanValue();
            cancelAnimation();
            z2 = true;
        }
        if (hasError != null && !Intrinsics.areEqual(Boolean.valueOf(this.hasError), hasError)) {
            this.hasError = hasError.booleanValue();
            cancelAnimation();
            this.isShakeAnimationRequired = hasError.booleanValue();
            z3 = true;
            z2 = true;
        }
        if (isEnabled == null || Intrinsics.areEqual(Boolean.valueOf(this.isEnabled), isEnabled)) {
            z = z2;
        } else {
            this.isEnabled = isEnabled.booleanValue();
            cancelAnimation();
        }
        if (z3) {
            onLayoutChanged();
        }
        if (z) {
            updateLabelState();
            if (this.canAnimate && animated) {
                applyLabelStateAnimated();
            } else {
                applyLabelState();
            }
        }
    }

    public final void onLayoutChanged() {
        if (updateBounds()) {
            AnimatorSet animatorSet = this.stateAnimation;
            boolean isRunning = animatorSet != null ? animatorSet.isRunning() : false;
            cancelAnimation();
            onStateChanged(isRunning);
        }
    }

    public final void jumpToCurrentState() {
        updateLabelState();
        applyLabelState();
    }

    public final void onStateChanged(boolean animated) {
        updateLabelState();
        if (animated) {
            applyLabelStateAnimated();
        } else {
            applyLabelState();
        }
    }

    private final void cancelAnimation() {
        AnimatorSet animatorSet = this.stateAnimation;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
    }

    private final void updateLabelState() {
        int focusedLabelColor;
        if (getLabelPosition() == LabelPosition.DEFAULT) {
            this.state.setLabelTranslateX(this.expandedLabelTranslateX);
            this.state.setLabelTranslateY(this.expandedLabelTranslateY);
            this.state.setLabelScaleX(this.expandedLabelScaleX);
            this.state.setLabelScaleY(this.expandedLabelScaleY);
            this.state.setContentAlpha(0.0f);
            this.state.setLabelAlpha(1.0f);
            this.state.setLabelMaxWidth(this.expandedLabelMaxWidth);
        } else {
            if (this.useOnlyAlphaCollapseAnimationForLabel) {
                this.state.setLabelTranslateX(this.expandedLabelTranslateX);
                this.state.setLabelTranslateY(this.expandedLabelTranslateY);
                this.state.setLabelScaleX(this.expandedLabelScaleX);
                this.state.setLabelScaleY(this.expandedLabelScaleY);
                this.state.setLabelAlpha(0.0f);
            } else {
                this.state.setLabelTranslateX(0.0f);
                this.state.setLabelTranslateY(0.0f);
                this.state.setLabelScaleX(1.0f);
                this.state.setLabelScaleY(1.0f);
                this.state.setLabelAlpha(1.0f);
                this.state.setLabelMaxWidth(this.label.getMeasuredWidth());
            }
            this.state.setContentAlpha(1.0f);
        }
        LabelState labelState = this.state;
        if (!this.isEnabled) {
            focusedLabelColor = this.style.getDisabledLabelColor();
        } else if (this.hasError) {
            focusedLabelColor = this.style.getErrorColor();
        } else {
            focusedLabelColor = this.isFocused ? this.style.getFocusedLabelColor() : this.style.getLabelColor();
        }
        labelState.setLabelColor(focusedLabelColor);
    }

    private final void applyLabelState() {
        this.actualLabelClipBounds.set(0, 0, this.state.getLabelMaxWidth(), this.label.getMeasuredHeight());
        this.label.setScaleX(this.state.getLabelScaleX());
        this.label.setScaleY(this.state.getLabelScaleY());
        this.label.setTranslationX(this.state.getLabelTranslateX());
        this.label.setTranslationY(this.state.getLabelTranslateY());
        this.label.setTextColor(this.state.getLabelColor());
        this.label.setAlpha(this.state.getLabelAlpha());
        this.label.setClipBounds(this.actualLabelClipBounds);
        this.prefix.setAlpha(this.state.getContentAlpha());
        this.suffix.setAlpha(this.state.getContentAlpha());
        this.content.setAlpha(this.state.getContentAlpha());
        this.content.setZ(this.state.getContentAlpha() <= 0.0f ? MIN_ZINDEX : 0.0f);
    }

    private final void applyLabelStateAnimated() {
        TimeInterpolator timeInterpolator;
        this.animationsList.clear();
        long j = Constants.ANIMATION_DURATION;
        if (MathUtilsKt.isNotZero(this.label.getTranslationX() - this.state.getLabelTranslateX())) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.label, (Property<TextView, Float>) View.TRANSLATION_X, this.state.getLabelTranslateX());
            ofFloat.setDuration(j);
            ofFloat.setInterpolator(ACCELERATE_DECELERATE_INTERPOLATOR);
            List<Animator> list = this.animationsList;
            Intrinsics.checkNotNull(ofFloat);
            list.add(ofFloat);
        } else if (this.isShakeAnimationRequired) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.label, (Property<TextView, Float>) View.TRANSLATION_X, this.style.getLabelShakeAmplitude());
            ofFloat2.setInterpolator(CYCLE_INTERPOLATOR);
            ofFloat2.setDuration(j);
            ofFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.devexpress.editors.animations.LabelAnimator$applyLabelStateAnimated$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    TextView textView;
                    LabelAnimator.LabelState labelState;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    textView = LabelAnimator.this.label;
                    labelState = LabelAnimator.this.state;
                    textView.setTranslationX(labelState.getLabelTranslateX());
                    LabelAnimator.this.isShakeAnimationRequired = true;
                }
            });
            List<Animator> list2 = this.animationsList;
            Intrinsics.checkNotNull(ofFloat2);
            list2.add(ofFloat2);
            this.isShakeAnimationRequired = false;
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.label, (Property<TextView, Float>) View.ALPHA, this.state.getLabelAlpha());
        ofFloat3.setDuration(j);
        TimeInterpolator timeInterpolator2 = ACCELERATE_DECELERATE_INTERPOLATOR;
        ofFloat3.setInterpolator(timeInterpolator2);
        List<Animator> list3 = this.animationsList;
        Intrinsics.checkNotNull(ofFloat3);
        list3.add(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.label, (Property<TextView, Float>) View.TRANSLATION_Y, this.state.getLabelTranslateY());
        ofFloat4.setDuration(j);
        ofFloat4.setInterpolator(timeInterpolator2);
        List<Animator> list4 = this.animationsList;
        Intrinsics.checkNotNull(ofFloat4);
        list4.add(ofFloat4);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.label, (Property<TextView, Float>) View.SCALE_X, this.state.getLabelScaleX());
        ofFloat4.setDuration(j);
        ofFloat4.setInterpolator(timeInterpolator2);
        List<Animator> list5 = this.animationsList;
        Intrinsics.checkNotNull(ofFloat5);
        list5.add(ofFloat5);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.label, (Property<TextView, Float>) View.SCALE_Y, this.state.getLabelScaleY());
        ofFloat4.setDuration(j);
        ofFloat4.setInterpolator(timeInterpolator2);
        List<Animator> list6 = this.animationsList;
        Intrinsics.checkNotNull(ofFloat6);
        list6.add(ofFloat6);
        int defaultColor = this.label.getTextColors().getDefaultColor();
        if (defaultColor != this.state.getLabelColor()) {
            ValueAnimator ofObject = ObjectAnimator.ofObject(ARGB_EVALUATOR, Integer.valueOf(defaultColor), Integer.valueOf(this.state.getLabelColor()));
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.devexpress.editors.animations.LabelAnimator$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LabelAnimator.applyLabelStateAnimated$lambda$2(LabelAnimator.this, valueAnimator);
                }
            });
            ofObject.setDuration(j);
            ofObject.setInterpolator(timeInterpolator2);
            List<Animator> list7 = this.animationsList;
            Intrinsics.checkNotNull(ofObject);
            list7.add(ofObject);
        }
        Rect clipBounds = this.label.getClipBounds();
        this.actualLabelClipBounds.set(0, 0, 0, this.label.getMeasuredHeight());
        ValueAnimator ofInt = ObjectAnimator.ofInt(clipBounds.right, this.state.getLabelMaxWidth());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.devexpress.editors.animations.LabelAnimator$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LabelAnimator.applyLabelStateAnimated$lambda$3(LabelAnimator.this, valueAnimator);
            }
        });
        ofInt.setDuration(j);
        ofInt.setInterpolator(timeInterpolator2);
        List<Animator> list8 = this.animationsList;
        Intrinsics.checkNotNull(ofInt);
        list8.add(ofInt);
        if (MathUtilsKt.isZero(this.state.getContentAlpha())) {
            timeInterpolator = ACCELERATE_INTERPOLATOR;
        } else {
            timeInterpolator = DECELERATE_INTERPOLATOR;
        }
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.prefix, (Property<TextView, Float>) View.ALPHA, this.state.getContentAlpha());
        ofFloat7.setDuration(j);
        ofFloat7.setInterpolator(timeInterpolator);
        List<Animator> list9 = this.animationsList;
        Intrinsics.checkNotNull(ofFloat7);
        list9.add(ofFloat7);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.suffix, (Property<TextView, Float>) View.ALPHA, this.state.getContentAlpha());
        ofFloat8.setDuration(j);
        ofFloat8.setInterpolator(timeInterpolator);
        List<Animator> list10 = this.animationsList;
        Intrinsics.checkNotNull(ofFloat8);
        list10.add(ofFloat8);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.content, (Property<TextView, Float>) View.ALPHA, this.state.getContentAlpha());
        ofFloat9.setDuration(j);
        ofFloat9.setInterpolator(timeInterpolator);
        List<Animator> list11 = this.animationsList;
        Intrinsics.checkNotNull(ofFloat9);
        list11.add(ofFloat9);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(this.animationsList);
        animatorSet.start();
        this.stateAnimation = animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyLabelStateAnimated$lambda$2(LabelAnimator this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.label.setTextColor(((Integer) animatedValue).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyLabelStateAnimated$lambda$3(LabelAnimator this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.actualLabelClipBounds.right = ((Integer) animatedValue).intValue();
        this$0.label.setClipBounds(this$0.actualLabelClipBounds);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LabelAnimator.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0014\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006!"}, d2 = {"Lcom/devexpress/editors/animations/LabelAnimator$LabelState;", "", "()V", "contentAlpha", "", "getContentAlpha", "()F", "setContentAlpha", "(F)V", "labelAlpha", "getLabelAlpha", "setLabelAlpha", "labelColor", "", "getLabelColor", "()I", "setLabelColor", "(I)V", "labelMaxWidth", "getLabelMaxWidth", "setLabelMaxWidth", "labelScaleX", "getLabelScaleX", "setLabelScaleX", "labelScaleY", "getLabelScaleY", "setLabelScaleY", "labelTranslateX", "getLabelTranslateX", "setLabelTranslateX", "labelTranslateY", "getLabelTranslateY", "setLabelTranslateY", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    static final class LabelState {
        private float contentAlpha;
        private int labelColor;
        private int labelMaxWidth;
        private float labelTranslateX;
        private float labelTranslateY;
        private float labelAlpha = 1.0f;
        private float labelScaleX = 1.0f;
        private float labelScaleY = 1.0f;

        public final float getLabelAlpha() {
            return this.labelAlpha;
        }

        public final void setLabelAlpha(float f) {
            this.labelAlpha = f;
        }

        public final float getLabelTranslateX() {
            return this.labelTranslateX;
        }

        public final void setLabelTranslateX(float f) {
            this.labelTranslateX = f;
        }

        public final float getLabelTranslateY() {
            return this.labelTranslateY;
        }

        public final void setLabelTranslateY(float f) {
            this.labelTranslateY = f;
        }

        public final float getLabelScaleX() {
            return this.labelScaleX;
        }

        public final void setLabelScaleX(float f) {
            this.labelScaleX = f;
        }

        public final float getLabelScaleY() {
            return this.labelScaleY;
        }

        public final void setLabelScaleY(float f) {
            this.labelScaleY = f;
        }

        public final int getLabelMaxWidth() {
            return this.labelMaxWidth;
        }

        public final void setLabelMaxWidth(int i) {
            this.labelMaxWidth = i;
        }

        public final int getLabelColor() {
            return this.labelColor;
        }

        public final void setLabelColor(int i) {
            this.labelColor = i;
        }

        public final float getContentAlpha() {
            return this.contentAlpha;
        }

        public final void setContentAlpha(float f) {
            this.contentAlpha = f;
        }
    }
}
