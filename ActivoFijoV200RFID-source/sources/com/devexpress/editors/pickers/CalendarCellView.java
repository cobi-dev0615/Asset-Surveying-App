package com.devexpress.editors.pickers;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.editors.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: CalendarCellView.kt */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u001a\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ0\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007H\u0014J\u0006\u0010=\u001a\u000207J\u0006\u0010>\u001a\u000207J\u0012\u0010?\u001a\u0002072\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0010\u0010B\u001a\u0002072\u0006\u0010C\u001a\u00020\u0007H\u0016J\u0010\u0010D\u001a\u0002072\u0006\u0010E\u001a\u00020\u000fH\u0016J\u0016\u0010,\u001a\u0002072\u0006\u0010F\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020(R\u0011\u0010\t\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR&\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\u0018R(\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010\u000b\"\u0004\b'\u0010\u0018R$\u0010)\u001a\u00020(2\u0006\u0010\u000e\u001a\u00020(8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R(\u00101\u001a\u0004\u0018\u0001002\b\u0010\u000e\u001a\u0004\u0018\u0001008F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006G"}, d2 = {"Lcom/devexpress/editors/pickers/CalendarCellView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundColor", "getBackgroundColor", "()I", "cellMarkDrawable", "Landroid/graphics/drawable/GradientDrawable;", "value", "", "isCircle", "()Z", "setCircle", "(Z)V", "isRecycled", "markColor", "getMarkColor", "setMarkColor", "(I)V", "markColorAnimator", "com/devexpress/editors/pickers/CalendarCellView$markColorAnimator$1", "Lcom/devexpress/editors/pickers/CalendarCellView$markColorAnimator$1;", "pressedMarkColor", "getPressedMarkColor", "setPressedMarkColor", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textColor", "getTextColor", "setTextColor", "", "textSize", "getTextSize", "()F", "setTextSize", "(F)V", "textView", "Landroid/widget/TextView;", "Landroid/graphics/Typeface;", "typeface", "getTypeface", "()Landroid/graphics/Typeface;", "setTypeface", "(Landroid/graphics/Typeface;)V", "onLayout", "", "changed", "l", "t", "r", "b", "onRecycle", "onUpdate", "setBackground", "background", "Landroid/graphics/drawable/Drawable;", "setBackgroundColor", TypedValues.Custom.S_COLOR, "setPressed", "pressed", "unit", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CalendarCellView extends ViewGroup {
    private final GradientDrawable cellMarkDrawable;
    private boolean isCircle;
    private boolean isRecycled;
    private int markColor;
    private final CalendarCellView$markColorAnimator$1 markColorAnimator;
    private int pressedMarkColor;
    private final TextView textView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CalendarCellView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CalendarCellView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CalendarCellView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalendarCellView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        this.cellMarkDrawable = gradientDrawable;
        TextView textView = new TextView(context);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(17);
        textView.setBackground(gradientDrawable);
        textView.setTextColor(-16777216);
        this.textView = textView;
        addView(textView);
        setWillNotDraw(true);
        setClipToPadding(false);
        setClipChildren(false);
        final CalendarCellView$markColorAnimator$1 calendarCellView$markColorAnimator$1 = new CalendarCellView$markColorAnimator$1(this);
        calendarCellView$markColorAnimator$1.setDuration(Constants.ANIMATION_DURATION);
        calendarCellView$markColorAnimator$1.setFloatValues(0.0f, 1.0f);
        final ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        calendarCellView$markColorAnimator$1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.devexpress.editors.pickers.CalendarCellView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CalendarCellView.markColorAnimator$lambda$3$lambda$2(CalendarCellView$markColorAnimator$1.this, argbEvaluator, this, valueAnimator);
            }
        });
        this.markColorAnimator = calendarCellView$markColorAnimator$1;
        this.isCircle = true;
        this.markColor = -16776961;
        this.pressedMarkColor = -16711936;
        this.isRecycled = true;
    }

    public final int getBackgroundColor() {
        ColorDrawable colorDrawable = (ColorDrawable) super.getBackground();
        if (colorDrawable != null) {
            return colorDrawable.getColor();
        }
        return 0;
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        if (getBackgroundColor() != color) {
            super.setBackgroundColor(color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void markColorAnimator$lambda$3$lambda$2(CalendarCellView$markColorAnimator$1 this_apply, ArgbEvaluator argbEvaluator, CalendarCellView this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(argbEvaluator, "$argbEvaluator");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object evaluate = argbEvaluator.evaluate(it.getAnimatedFraction(), Integer.valueOf(this_apply.getFrom()), Integer.valueOf(this_apply.getTo()));
        Intrinsics.checkNotNull(evaluate, "null cannot be cast to non-null type kotlin.Int");
        this_apply.setCurrent(((Integer) evaluate).intValue());
        this$0.cellMarkDrawable.setColor(this_apply.getCurrent());
    }

    /* renamed from: isCircle, reason: from getter */
    public final boolean getIsCircle() {
        return this.isCircle;
    }

    public final void setCircle(boolean z) {
        if (this.isCircle != z) {
            this.isCircle = z;
            requestLayout();
        }
    }

    public final int getMarkColor() {
        return this.markColor;
    }

    public final void setMarkColor(int i) {
        if (this.markColor != i) {
            this.markColor = i;
            if (isPressed()) {
                return;
            }
            this.markColorAnimator.animateTo(this.markColor);
        }
    }

    public final int getPressedMarkColor() {
        return this.pressedMarkColor;
    }

    public final void setPressedMarkColor(int i) {
        if (this.pressedMarkColor != i) {
            this.pressedMarkColor = i;
            if (isPressed()) {
                this.markColorAnimator.animateTo(this.markColor);
            }
        }
    }

    @Override // android.view.View
    public void setPressed(boolean pressed) {
        if (pressed) {
            if (!isPressed()) {
                this.markColorAnimator.animateTo(this.pressedMarkColor);
            }
        } else if (isPressed()) {
            this.markColorAnimator.animateTo(this.markColor);
        }
        super.setPressed(pressed);
    }

    public final void onRecycle() {
        this.isRecycled = true;
        this.markColorAnimator.cancel();
        this.markColorAnimator.setCurrent(this.markColor);
        this.cellMarkDrawable.setColor(this.markColor);
    }

    public final void onUpdate() {
        if (this.isRecycled) {
            this.isRecycled = false;
        }
    }

    public final int getTextColor() {
        return this.textView.getCurrentTextColor();
    }

    public final void setTextColor(int i) {
        this.textView.setTextColor(i);
    }

    public final CharSequence getText() {
        return this.textView.getText();
    }

    public final void setText(CharSequence charSequence) {
        this.textView.setText(charSequence, TextView.BufferType.NORMAL);
    }

    public final float getTextSize() {
        return this.textView.getTextSize();
    }

    public final void setTextSize(float f) {
        setTextSize(2, f);
    }

    public final Typeface getTypeface() {
        return this.textView.getTypeface();
    }

    public final void setTypeface(Typeface typeface) {
        this.textView.setTypeface(typeface);
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
        super.setBackground(background);
    }

    public final void setTextSize(int unit, float value) {
        this.textView.setTextSize(unit, value);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        double textSize = this.textView.getTextSize() * 2.25d;
        double paddingLeft = this.isCircle ? textSize : ((r - l) - getPaddingLeft()) - getPaddingTop();
        this.textView.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft + 0.5d), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec((int) (textSize + 0.5d), BasicMeasure.EXACTLY));
        int i = (int) ((((r - l) - paddingLeft) / 2.0d) + 0.5d);
        int i2 = (int) ((((b - t) - textSize) / 2.0d) + 0.5d);
        TextView textView = this.textView;
        textView.layout(i, i2, textView.getMeasuredWidth() + i, this.textView.getMeasuredHeight() + i2);
        this.cellMarkDrawable.setCornerRadius(RangesKt.coerceAtMost(this.textView.getMeasuredWidth(), this.textView.getMeasuredHeight()));
    }
}
