package com.devexpress.editors;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.drawable.DrawableCompat;
import com.devexpress.dxcore.DXNativeView;
import com.devexpress.editors.helpers.MathHelper;
import com.devexpress.editors.style.SimpleButtonStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: SimpleButton.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0002´\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001J\b\u0010\u0085\u0001\u001a\u00030\u0084\u0001J\t\u0010\u0086\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0087\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0088\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0089\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u008a\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u008b\u0001\u001a\u00020\u0007H\u0016J7\u0010\u008c\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u008d\u0001\u001a\u00020[2\u0007\u0010\u008e\u0001\u001a\u00020\u00072\u0007\u0010\u008f\u0001\u001a\u00020\u00072\u0007\u0010\u0090\u0001\u001a\u00020\u00072\u0007\u0010\u0091\u0001\u001a\u00020\u0007H\u0014J\u001c\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0007\u0010\u0094\u0001\u001a\u00020\u00072\u0007\u0010\u0095\u0001\u001a\u00020\u0007H\u0014J\u0013\u0010\u0096\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0097\u0001\u001a\u00020;H\u0016J\u0013\u0010\u0098\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0099\u0001\u001a\u00020\u0007H\u0016J\u0018\u0010\u0015\u001a\u00030\u0084\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0011J\u0018\u0010\u0019\u001a\u00030\u0084\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0011J\u0018\u0010\u001c\u001a\u00030\u0084\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0011J,\u0010\u009b\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u00112\u0007\u0010\u009d\u0001\u001a\u00020\u00112\u0007\u0010\u009e\u0001\u001a\u00020\u00112\u0007\u0010\u009f\u0001\u001a\u00020\u0011J5\u0010\u009b\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u00112\u0007\u0010\u009d\u0001\u001a\u00020\u00112\u0007\u0010\u009e\u0001\u001a\u00020\u00112\u0007\u0010\u009f\u0001\u001a\u00020\u0011J\u0013\u0010 \u0001\u001a\u00030\u0084\u00012\u0007\u0010¡\u0001\u001a\u00020[H\u0016J\u0018\u0010F\u001a\u00030\u0084\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0011J\u0013\u0010¢\u0001\u001a\u00030\u0084\u00012\u0007\u0010£\u0001\u001a\u00020\u0007H\u0016J\u0013\u0010¤\u0001\u001a\u00030\u0084\u00012\u0007\u0010¥\u0001\u001a\u00020\u0007H\u0016J\u0016\u0010¦\u0001\u001a\u00030\u0084\u00012\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010§\u0001H\u0016J\u0016\u0010¨\u0001\u001a\u00030\u0084\u00012\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010©\u0001H\u0016J5\u0010ª\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u00072\u0007\u0010«\u0001\u001a\u00020\u00112\u0007\u0010¬\u0001\u001a\u00020\u00112\u0007\u0010\u00ad\u0001\u001a\u00020\u00112\u0007\u0010®\u0001\u001a\u00020\u0011J5\u0010¯\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u00072\u0007\u0010°\u0001\u001a\u00020\u00112\u0007\u0010¬\u0001\u001a\u00020\u00112\u0007\u0010±\u0001\u001a\u00020\u00112\u0007\u0010®\u0001\u001a\u00020\u0011J\u0019\u0010l\u001a\u00030\u0084\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u00072\u0007\u0010²\u0001\u001a\u00020\u0011J\u0018\u0010s\u001a\u00030\u0084\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0011J\u0018\u0010v\u001a\u00030\u0084\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0011J\u001a\u0010{\u001a\u00030\u0084\u00012\b\u0010x\u001a\u0004\u0018\u00010w2\u0007\u0010³\u0001\u001a\u00020\u0007R\u0011\u0010\t\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R(\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\f\u001a\u0004\u0018\u00010\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u00020#2\u0006\u0010\f\u001a\u00020#8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010\u000b\"\u0004\b+\u0010\u0010R$\u0010,\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010\u0010R$\u0010/\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010\u000b\"\u0004\b1\u0010\u0010R$\u00102\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u0010\u000b\"\u0004\b4\u0010\u0010R$\u00106\u001a\u0002052\u0006\u0010\f\u001a\u0002058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R(\u0010<\u001a\u0004\u0018\u00010;2\b\u0010\f\u001a\u0004\u0018\u00010;8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010A\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010\u000b\"\u0004\bC\u0010\u0010R$\u0010D\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010\u000b\"\u0004\bF\u0010\u0010R$\u0010H\u001a\u00020G2\u0006\u0010\f\u001a\u00020G8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010O\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bP\u0010\u000b\"\u0004\bQ\u0010\u0010R$\u0010R\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bS\u0010\u000b\"\u0004\bT\u0010\u0010R$\u0010U\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bV\u0010\u000b\"\u0004\bW\u0010\u0010R$\u0010X\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bY\u0010\u000b\"\u0004\bZ\u0010\u0010R$\u0010\\\u001a\u00020[2\u0006\u0010\f\u001a\u00020[8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R(\u0010b\u001a\u0004\u0018\u00010a2\b\u0010\f\u001a\u0004\u0018\u00010a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR$\u0010g\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bh\u0010\u000b\"\u0004\bi\u0010\u0010R$\u0010j\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bk\u0010\u0014\"\u0004\bl\u0010\u0016R\u0011\u0010m\u001a\u00020n8F¢\u0006\u0006\u001a\u0004\bo\u0010pR$\u0010q\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\br\u0010\u0014\"\u0004\bs\u0010\u0016R$\u0010t\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bu\u0010\u0014\"\u0004\bv\u0010\u0016R(\u0010x\u001a\u0004\u0018\u00010w2\b\u0010\f\u001a\u0004\u0018\u00010w8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R$\u0010}\u001a\u00020[2\u0006\u0010\f\u001a\u00020[8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b~\u0010^\"\u0004\b\u007f\u0010`R'\u0010\u0080\u0001\u001a\u0002052\u0006\u0010\f\u001a\u0002058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0081\u0001\u00108\"\u0005\b\u0082\u0001\u0010:¨\u0006µ\u0001"}, d2 = {"Lcom/devexpress/editors/SimpleButton;", "Lcom/devexpress/dxcore/DXNativeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundColor", "getBackgroundColor", "()I", "value", "borderColor", "getBorderColor", "setBorderColor", "(I)V", "", "borderThickness", "getBorderThickness", "()F", "setBorderThickness", "(F)V", "bottomLeftCornerRadius", "getBottomLeftCornerRadius", "setBottomLeftCornerRadius", "bottomRightCornerRadius", "getBottomRightCornerRadius", "setBottomRightCornerRadius", "Landroid/view/View;", "contentView", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "Lcom/devexpress/editors/DXCornerMode;", "cornerMode", "getCornerMode", "()Lcom/devexpress/editors/DXCornerMode;", "setCornerMode", "(Lcom/devexpress/editors/DXCornerMode;)V", "disabledBackgroundColor", "getDisabledBackgroundColor", "setDisabledBackgroundColor", "disabledBorderColor", "getDisabledBorderColor", "setDisabledBorderColor", "disabledIconColor", "getDisabledIconColor", "setDisabledIconColor", "disabledTextColor", "getDisabledTextColor", "setDisabledTextColor", "Lcom/devexpress/editors/DXSimpleButtonContentAlignment;", "horizontalContentAlignment", "getHorizontalContentAlignment", "()Lcom/devexpress/editors/DXSimpleButtonContentAlignment;", "setHorizontalContentAlignment", "(Lcom/devexpress/editors/DXSimpleButtonContentAlignment;)V", "Landroid/graphics/drawable/Drawable;", "icon", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "iconColor", "getIconColor", "setIconColor", "iconIndent", "getIconIndent", "setIconIndent", "Lcom/devexpress/editors/DXSimpleButtonIconPosition;", "iconPosition", "getIconPosition", "()Lcom/devexpress/editors/DXSimpleButtonIconPosition;", "setIconPosition", "(Lcom/devexpress/editors/DXSimpleButtonIconPosition;)V", "innerButton", "Lcom/devexpress/editors/SimpleButton$SimpleButtonLayout;", "pressedBackgroundColor", "getPressedBackgroundColor", "setPressedBackgroundColor", "pressedBorderColor", "getPressedBorderColor", "setPressedBorderColor", "pressedIconColor", "getPressedIconColor", "setPressedIconColor", "pressedTextColor", "getPressedTextColor", "setPressedTextColor", "", "showShadow", "getShowShadow", "()Z", "setShowShadow", "(Z)V", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textColor", "getTextColor", "setTextColor", "textSize", "getTextSize", "setTextSize", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "getTextView", "()Landroidx/appcompat/widget/AppCompatTextView;", "topLeftCornerRadius", "getTopLeftCornerRadius", "setTopLeftCornerRadius", "topRightCornerRadius", "getTopRightCornerRadius", "setTopRightCornerRadius", "Landroid/graphics/Typeface;", "typeface", "getTypeface", "()Landroid/graphics/Typeface;", "setTypeface", "(Landroid/graphics/Typeface;)V", "useRippleEffect", "getUseRippleEffect", "setUseRippleEffect", "verticalContentAlignment", "getVerticalContentAlignment", "setVerticalContentAlignment", "beginInit", "", "endInit", "getMinimumHeight", "getMinimumWidth", "getPaddingBottom", "getPaddingLeft", "getPaddingRight", "getPaddingTop", "onLayout", "changed", "l", "t", "r", "b", "onMeasureCore", "Landroid/util/Size;", "widthMeasureSpec", "heightMeasureSpec", "setBackground", "background", "setBackgroundColor", TypedValues.Custom.S_COLOR, "unit", "setCornerRadii", "topLeft", "topRight", "bottomLeft", "bottomRight", "setEnabled", "enabled", "setMinimumHeight", "minHeight", "setMinimumWidth", "minWidth", "setOnClickListener", "Landroid/view/View$OnClickListener;", "setOnTouchListener", "Landroid/view/View$OnTouchListener;", "setPadding", "left", "top", "right", "bottom", "setPaddingRelative", "start", "end", "size", "style", "SimpleButtonLayout", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SimpleButton extends DXNativeView {
    private final SimpleButtonLayout innerButton;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleButton(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        SimpleButtonLayout simpleButtonLayout = new SimpleButtonLayout(context, null, 0, 6, null);
        this.innerButton = simpleButtonLayout;
        addView(simpleButtonLayout, new FrameLayout.LayoutParams(-2, -2, 119));
    }

    public /* synthetic */ SimpleButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? android.R.attr.buttonStyle : i);
    }

    public final AppCompatTextView getTextView() {
        return this.innerButton.getTextView$dxeditors_release();
    }

    public final CharSequence getText() {
        return this.innerButton.getText();
    }

    public final void setText(CharSequence charSequence) {
        this.innerButton.setText(charSequence);
    }

    public final float getTextSize() {
        return this.innerButton.getTextSize();
    }

    public final void setTextSize(float f) {
        this.innerButton.setTextSize(f);
    }

    public final Typeface getTypeface() {
        return this.innerButton.getTypeface();
    }

    public final void setTypeface(Typeface typeface) {
        this.innerButton.setTypeface(typeface);
    }

    public final Drawable getIcon() {
        return this.innerButton.getIcon();
    }

    public final void setIcon(Drawable drawable) {
        this.innerButton.setIcon(drawable);
    }

    public final DXSimpleButtonIconPosition getIconPosition() {
        return this.innerButton.getIconPosition();
    }

    public final void setIconPosition(DXSimpleButtonIconPosition value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.innerButton.setIconPosition(value);
    }

    public final int getIconIndent() {
        return this.innerButton.getIconIndent();
    }

    public final void setIconIndent(int i) {
        this.innerButton.setIconIndent(i);
    }

    public final View getContentView() {
        return this.innerButton.getContentView();
    }

    public final void setContentView(View view) {
        this.innerButton.setContentView(view);
    }

    public final DXCornerMode getCornerMode() {
        return this.innerButton.getCornerMode();
    }

    public final void setCornerMode(DXCornerMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.innerButton.setCornerMode(value);
    }

    public final float getTopLeftCornerRadius() {
        return this.innerButton.getTopLeftCornerRadius();
    }

    public final void setTopLeftCornerRadius(float f) {
        this.innerButton.setTopLeftCornerRadius(f);
    }

    public final float getTopRightCornerRadius() {
        return this.innerButton.getTopRightCornerRadius();
    }

    public final void setTopRightCornerRadius(float f) {
        this.innerButton.setTopRightCornerRadius(f);
    }

    public final float getBottomLeftCornerRadius() {
        return this.innerButton.getBottomLeftCornerRadius();
    }

    public final void setBottomLeftCornerRadius(float f) {
        this.innerButton.setBottomLeftCornerRadius(f);
    }

    public final float getBottomRightCornerRadius() {
        return this.innerButton.getBottomRightCornerRadius();
    }

    public final void setBottomRightCornerRadius(float f) {
        this.innerButton.setBottomRightCornerRadius(f);
    }

    public final float getBorderThickness() {
        return this.innerButton.getBorderThickness();
    }

    public final void setBorderThickness(float f) {
        this.innerButton.setBorderThickness(f);
    }

    public final int getBorderColor() {
        return this.innerButton.getBorderColor();
    }

    public final void setBorderColor(int i) {
        this.innerButton.setBorderColor(i);
    }

    public final int getPressedBorderColor() {
        return this.innerButton.getPressedBorderColor();
    }

    public final void setPressedBorderColor(int i) {
        this.innerButton.setPressedBorderColor(i);
    }

    public final int getDisabledBorderColor() {
        return this.innerButton.getDisabledBorderColor();
    }

    public final void setDisabledBorderColor(int i) {
        this.innerButton.setDisabledBorderColor(i);
    }

    public final int getBackgroundColor() {
        return this.innerButton.getBackgroundColor();
    }

    public final int getPressedBackgroundColor() {
        return this.innerButton.getPressedBackgroundColor();
    }

    public final void setPressedBackgroundColor(int i) {
        this.innerButton.setPressedBackgroundColor(i);
    }

    public final int getDisabledBackgroundColor() {
        return this.innerButton.getDisabledBackgroundColor();
    }

    public final void setDisabledBackgroundColor(int i) {
        this.innerButton.setDisabledBackgroundColor(i);
    }

    public final int getTextColor() {
        return this.innerButton.getTextColor();
    }

    public final void setTextColor(int i) {
        this.innerButton.setTextColor(i);
    }

    public final int getPressedTextColor() {
        return this.innerButton.getPressedTextColor();
    }

    public final void setPressedTextColor(int i) {
        this.innerButton.setPressedTextColor(i);
    }

    public final int getDisabledTextColor() {
        return this.innerButton.getDisabledTextColor();
    }

    public final void setDisabledTextColor(int i) {
        this.innerButton.setDisabledTextColor(i);
    }

    public final int getIconColor() {
        return this.innerButton.getIconColor();
    }

    public final void setIconColor(int i) {
        this.innerButton.setIconColor(i);
    }

    public final int getPressedIconColor() {
        return this.innerButton.getPressedIconColor();
    }

    public final void setPressedIconColor(int i) {
        this.innerButton.setPressedIconColor(i);
    }

    public final int getDisabledIconColor() {
        return this.innerButton.getDisabledIconColor();
    }

    public final void setDisabledIconColor(int i) {
        this.innerButton.setDisabledIconColor(i);
    }

    public final boolean getShowShadow() {
        return this.innerButton.getShowShadow();
    }

    public final void setShowShadow(boolean z) {
        this.innerButton.setShowShadow(z);
    }

    public final boolean getUseRippleEffect() {
        return this.innerButton.getUseRippleEffect();
    }

    public final void setUseRippleEffect(boolean z) {
        this.innerButton.setUseRippleEffect(z);
    }

    public final DXSimpleButtonContentAlignment getHorizontalContentAlignment() {
        return this.innerButton.getHorizontalContentAlignment();
    }

    public final void setHorizontalContentAlignment(DXSimpleButtonContentAlignment value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.innerButton.setHorizontalContentAlignment(value);
    }

    public final DXSimpleButtonContentAlignment getVerticalContentAlignment() {
        return this.innerButton.getVerticalContentAlignment();
    }

    public final void setVerticalContentAlignment(DXSimpleButtonContentAlignment value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.innerButton.setVerticalContentAlignment(value);
    }

    public final void beginInit() {
        this.innerButton.beginInit();
    }

    public final void endInit() {
        this.innerButton.endInit();
    }

    public final void setIconIndent(int unit, float value) {
        this.innerButton.setIconIndent(unit, value);
    }

    public final void setTopLeftCornerRadius(int unit, float value) {
        this.innerButton.setTopLeftCornerRadius(unit, value);
    }

    public final void setTopRightCornerRadius(int unit, float value) {
        this.innerButton.setTopRightCornerRadius(unit, value);
    }

    public final void setBottomLeftCornerRadius(int unit, float value) {
        this.innerButton.setBottomLeftCornerRadius(unit, value);
    }

    public final void setBottomRightCornerRadius(int unit, float value) {
        this.innerButton.setBottomRightCornerRadius(unit, value);
    }

    public final void setCornerRadii(int unit, float topLeft, float topRight, float bottomLeft, float bottomRight) {
        this.innerButton.setCornerRadii(unit, topLeft, topRight, bottomLeft, bottomRight);
    }

    public final void setCornerRadii(float topLeft, float topRight, float bottomLeft, float bottomRight) {
        this.innerButton.setCornerRadii(topLeft, topRight, bottomLeft, bottomRight);
    }

    public final void setBorderThickness(int unit, float value) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setBorderThickness(companion.applyDimension(context, value, unit));
    }

    public final void setTextSize(int unit, float size) {
        this.innerButton.setTextSize(unit, size);
    }

    public final void setTypeface(Typeface typeface, int style) {
        this.innerButton.setTypeface(typeface, style);
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return this.innerButton.getMinimumHeight();
    }

    @Override // android.view.View
    public void setMinimumHeight(int minHeight) {
        super.setMinimumHeight(minHeight);
        this.innerButton.setMinimumHeight(minHeight);
    }

    @Override // android.view.View
    public int getMinimumWidth() {
        return this.innerButton.getMinimumWidth();
    }

    @Override // android.view.View
    public void setMinimumWidth(int minWidth) {
        super.setMinimumWidth(minWidth);
        this.innerButton.setMinimumWidth(minWidth);
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return this.innerButton.getPaddingLeft();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return this.innerButton.getPaddingTop();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return this.innerButton.getPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return this.innerButton.getPaddingBottom();
    }

    public final void setPadding(int unit, float left, float top, float right, float bottom) {
        this.innerButton.setPadding(unit, left, top, right, bottom);
    }

    public final void setPaddingRelative(int unit, float start, float top, float end, float bottom) {
        this.innerButton.setPaddingRelative(unit, start, top, end, bottom);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener l) {
        this.innerButton.setOnTouchListener(l);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l) {
        this.innerButton.setOnClickListener(l);
    }

    @Override // com.devexpress.dxcore.DXNativeView
    protected Size onMeasureCore(int widthMeasureSpec, int heightMeasureSpec) {
        this.innerButton.measure(widthMeasureSpec, heightMeasureSpec);
        return new Size(this.innerButton.getMeasuredWidth(), this.innerButton.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.innerButton.layout(0, 0, r - l, b - t);
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
        Intrinsics.checkNotNullParameter(background, "background");
        SimpleButtonLayout simpleButtonLayout = this.innerButton;
        if (simpleButtonLayout == null) {
            return;
        }
        simpleButtonLayout.setBackground(background);
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        SimpleButtonLayout simpleButtonLayout = this.innerButton;
        if (simpleButtonLayout != null) {
            simpleButtonLayout.setBackgroundColor(color);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        SimpleButtonLayout simpleButtonLayout = this.innerButton;
        if (simpleButtonLayout == null) {
            return;
        }
        simpleButtonLayout.setEnabled(enabled);
    }

    /* compiled from: SimpleButton.kt */
    @Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001J\n\u0010\u008a\u0001\u001a\u00030\u0089\u0001H\u0002J\u0012\u0010\u008b\u0001\u001a\u00020\u00112\u0007\u0010\u008c\u0001\u001a\u00020\u0011H\u0002J\n\u0010\u008d\u0001\u001a\u00030\u0089\u0001H\u0014J\b\u0010\u008e\u0001\u001a\u00030\u0089\u0001J\n\u0010\u008f\u0001\u001a\u00030\u0089\u0001H\u0002J\u0014\u0010\u0090\u0001\u001a\u00030\u0089\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\n\u0010\u0093\u0001\u001a\u00030\u0089\u0001H\u0002J\n\u0010\u0094\u0001\u001a\u00030\u0089\u0001H\u0002J\n\u0010\u0095\u0001\u001a\u00030\u0089\u0001H\u0016J\n\u0010\u0096\u0001\u001a\u00030\u0089\u0001H\u0002J\n\u0010\u0097\u0001\u001a\u00030\u0089\u0001H\u0002J\n\u0010\u0098\u0001\u001a\u00030\u0089\u0001H\u0002J\n\u0010\u0099\u0001\u001a\u00030\u0089\u0001H\u0002J7\u0010\u009a\u0001\u001a\u00030\u0089\u00012\u0007\u0010\u009b\u0001\u001a\u00020P2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0007\u0010\u009d\u0001\u001a\u00020\u00072\u0007\u0010\u009e\u0001\u001a\u00020\u00072\u0007\u0010\u009f\u0001\u001a\u00020\u0007H\u0014J\u001c\u0010 \u0001\u001a\u00030\u0089\u00012\u0007\u0010¡\u0001\u001a\u00020\u00072\u0007\u0010¢\u0001\u001a\u00020\u0007H\u0014J\n\u0010£\u0001\u001a\u00030\u0089\u0001H\u0002J\n\u0010¤\u0001\u001a\u00030\u0089\u0001H\u0002J\n\u0010¥\u0001\u001a\u00030\u0089\u0001H\u0002J\u0015\u0010¦\u0001\u001a\u00030\u0089\u00012\t\b\u0001\u0010§\u0001\u001a\u00020\u0007H\u0016J\u0018\u0010\u0015\u001a\u00030\u0089\u00012\u0007\u0010¨\u0001\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0011J\u0018\u0010\u0019\u001a\u00030\u0089\u00012\u0007\u0010¨\u0001\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0011J\u0018\u0010\u001c\u001a\u00030\u0089\u00012\u0007\u0010¨\u0001\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0011J,\u0010©\u0001\u001a\u00030\u0089\u00012\u0007\u0010ª\u0001\u001a\u00020\u00112\u0007\u0010«\u0001\u001a\u00020\u00112\u0007\u0010¬\u0001\u001a\u00020\u00112\u0007\u0010\u00ad\u0001\u001a\u00020\u0011J5\u0010©\u0001\u001a\u00030\u0089\u00012\u0007\u0010¨\u0001\u001a\u00020\u00072\u0007\u0010ª\u0001\u001a\u00020\u00112\u0007\u0010«\u0001\u001a\u00020\u00112\u0007\u0010¬\u0001\u001a\u00020\u00112\u0007\u0010\u00ad\u0001\u001a\u00020\u0011J\u0013\u0010®\u0001\u001a\u00030\u0089\u00012\u0007\u0010¯\u0001\u001a\u00020PH\u0016J\u0012\u0010?\u001a\u00030\u0089\u00012\t\b\u0001\u0010°\u0001\u001a\u00020\u0007J\u0018\u0010F\u001a\u00030\u0089\u00012\u0007\u0010¨\u0001\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0011J5\u0010±\u0001\u001a\u00030\u0089\u00012\u0007\u0010¨\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u00112\u0007\u0010\u009d\u0001\u001a\u00020\u00112\u0007\u0010\u009e\u0001\u001a\u00020\u00112\u0007\u0010\u009f\u0001\u001a\u00020\u0011J5\u0010²\u0001\u001a\u00030\u0089\u00012\u0007\u0010¨\u0001\u001a\u00020\u00072\u0007\u0010³\u0001\u001a\u00020\u00112\u0007\u0010\u009d\u0001\u001a\u00020\u00112\u0007\u0010´\u0001\u001a\u00020\u00112\u0007\u0010\u009f\u0001\u001a\u00020\u0011J\u001b\u0010h\u001a\u00030\u0089\u00012\b\u0010\f\u001a\u0004\u0018\u00010d2\b\u0010µ\u0001\u001a\u00030¶\u0001J \u0010h\u001a\u00030\u0089\u00012\t\b\u0001\u0010°\u0001\u001a\u00020\u00072\n\b\u0002\u0010µ\u0001\u001a\u00030¶\u0001H\u0007J\u0019\u0010o\u001a\u00030\u0089\u00012\u0007\u0010¨\u0001\u001a\u00020\u00072\u0007\u0010·\u0001\u001a\u00020\u0011J\u0018\u0010x\u001a\u00030\u0089\u00012\u0007\u0010¨\u0001\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0011J\u0018\u0010{\u001a\u00030\u0089\u00012\u0007\u0010¨\u0001\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0011J\u001a\u0010\u0080\u0001\u001a\u00030\u0089\u00012\b\u0010}\u001a\u0004\u0018\u00010|2\u0006\u0010b\u001a\u00020\u0007J\b\u0010¸\u0001\u001a\u00030\u0089\u0001J\b\u0010¹\u0001\u001a\u00030\u0089\u0001J\b\u0010º\u0001\u001a\u00030\u0089\u0001J\n\u0010»\u0001\u001a\u00030\u0089\u0001H\u0002J\n\u0010¼\u0001\u001a\u00030\u0089\u0001H\u0002J\n\u0010½\u0001\u001a\u00030\u0089\u0001H\u0002R\u0011\u0010\t\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R(\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\f\u001a\u0004\u0018\u00010\u001d@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u00020#2\u0006\u0010\f\u001a\u00020#8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R&\u0010)\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010\u000b\"\u0004\b+\u0010\u0010R&\u0010,\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010\u0010R&\u0010/\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010\u000b\"\u0004\b1\u0010\u0010R&\u00102\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u0010\u000b\"\u0004\b4\u0010\u0010R$\u00106\u001a\u0002052\u0006\u0010\f\u001a\u000205@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R(\u0010<\u001a\u0004\u0018\u00010;2\b\u0010\f\u001a\u0004\u0018\u00010;@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R&\u0010A\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010\u000b\"\u0004\bC\u0010\u0010R$\u0010D\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u000b\"\u0004\bF\u0010\u0010R$\u0010H\u001a\u00020G2\u0006\u0010\f\u001a\u00020G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010Q\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\f\u001a\u0004\bR\u0010\u000b\"\u0004\bS\u0010\u0010R&\u0010T\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\f\u001a\u0004\bU\u0010\u000b\"\u0004\bV\u0010\u0010R&\u0010W\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\f\u001a\u0004\bX\u0010\u000b\"\u0004\bY\u0010\u0010R&\u0010Z\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u0010\u000b\"\u0004\b\\\u0010\u0010R$\u0010]\u001a\u00020P2\u0006\u0010\f\u001a\u00020P@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u000e\u0010b\u001a\u00020cX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010e\u001a\u0004\u0018\u00010d2\b\u0010\f\u001a\u0004\u0018\u00010d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR&\u0010j\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\f\u001a\u0004\bk\u0010\u000b\"\u0004\bl\u0010\u0010R$\u0010m\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bn\u0010\u0014\"\u0004\bo\u0010\u0016R\u001a\u0010p\u001a\u00020qX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR$\u0010v\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bw\u0010\u0014\"\u0004\bx\u0010\u0016R$\u0010y\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bz\u0010\u0014\"\u0004\b{\u0010\u0016R*\u0010}\u001a\u0004\u0018\u00010|2\b\u0010\f\u001a\u0004\u0018\u00010|8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R'\u0010\u0082\u0001\u001a\u00020P2\u0006\u0010\f\u001a\u00020P@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010_\"\u0005\b\u0084\u0001\u0010aR'\u0010\u0085\u0001\u001a\u0002052\u0006\u0010\f\u001a\u000205@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u00108\"\u0005\b\u0087\u0001\u0010:¨\u0006¾\u0001"}, d2 = {"Lcom/devexpress/editors/SimpleButton$SimpleButtonLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundColor", "getBackgroundColor", "()I", "value", "borderColor", "getBorderColor", "setBorderColor", "(I)V", "", "borderThickness", "getBorderThickness", "()F", "setBorderThickness", "(F)V", "bottomLeftCornerRadius", "getBottomLeftCornerRadius", "setBottomLeftCornerRadius", "bottomRightCornerRadius", "getBottomRightCornerRadius", "setBottomRightCornerRadius", "Landroid/view/View;", "contentView", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "Lcom/devexpress/editors/DXCornerMode;", "cornerMode", "getCornerMode", "()Lcom/devexpress/editors/DXCornerMode;", "setCornerMode", "(Lcom/devexpress/editors/DXCornerMode;)V", "disabledBackgroundColor", "getDisabledBackgroundColor", "setDisabledBackgroundColor", "disabledBorderColor", "getDisabledBorderColor", "setDisabledBorderColor", "disabledIconColor", "getDisabledIconColor", "setDisabledIconColor", "disabledTextColor", "getDisabledTextColor", "setDisabledTextColor", "Lcom/devexpress/editors/DXSimpleButtonContentAlignment;", "horizontalContentAlignment", "getHorizontalContentAlignment", "()Lcom/devexpress/editors/DXSimpleButtonContentAlignment;", "setHorizontalContentAlignment", "(Lcom/devexpress/editors/DXSimpleButtonContentAlignment;)V", "Landroid/graphics/drawable/Drawable;", "icon", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "iconColor", "getIconColor", "setIconColor", "iconIndent", "getIconIndent", "setIconIndent", "Lcom/devexpress/editors/DXSimpleButtonIconPosition;", "iconPosition", "getIconPosition", "()Lcom/devexpress/editors/DXSimpleButtonIconPosition;", "setIconPosition", "(Lcom/devexpress/editors/DXSimpleButtonIconPosition;)V", "iconTint", "Landroid/content/res/ColorStateList;", "isInitializing", "", "pressedBackgroundColor", "getPressedBackgroundColor", "setPressedBackgroundColor", "pressedBorderColor", "getPressedBorderColor", "setPressedBorderColor", "pressedIconColor", "getPressedIconColor", "setPressedIconColor", "pressedTextColor", "getPressedTextColor", "setPressedTextColor", "showShadow", "getShowShadow", "()Z", "setShowShadow", "(Z)V", "style", "Lcom/devexpress/editors/style/SimpleButtonStyle;", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textColor", "getTextColor", "setTextColor", "textSize", "getTextSize", "setTextSize", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "getTextView$dxeditors_release", "()Landroidx/appcompat/widget/AppCompatTextView;", "setTextView$dxeditors_release", "(Landroidx/appcompat/widget/AppCompatTextView;)V", "topLeftCornerRadius", "getTopLeftCornerRadius", "setTopLeftCornerRadius", "topRightCornerRadius", "getTopRightCornerRadius", "setTopRightCornerRadius", "Landroid/graphics/Typeface;", "typeface", "getTypeface", "()Landroid/graphics/Typeface;", "setTypeface", "(Landroid/graphics/Typeface;)V", "useRippleEffect", "getUseRippleEffect", "setUseRippleEffect", "verticalContentAlignment", "getVerticalContentAlignment", "setVerticalContentAlignment", "beginInit", "", "coerceCornerRadius", "coerceCornerRadiusValue", "radiusValue", "drawableStateChanged", "endInit", "initDefaultStyle", "initGeneralParameters", "res", "Landroid/content/res/Resources;", "initStyle", "initTextView", "jumpDrawablesToCurrentState", "onBackgroundSettingsChanged", "onContentAlignmentChanged", "onContentViewChanged", "onIconSettingsChanged", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onShowShadowChanged", "onTextSettingsChanged", "onUseRippleEffectChanged", "setBackgroundColor", TypedValues.Custom.S_COLOR, "unit", "setCornerRadii", "topLeft", "topRight", "bottomLeft", "bottomRight", "setEnabled", "enabled", "resId", "setPadding", "setPaddingRelative", "start", "end", "bufferType", "Landroid/widget/TextView$BufferType;", "size", "setupContainedAppearance", "setupOutlinedAppearance", "setupTextAppearance", "updateCompoundPadding", "updateDrawableTintMode", "updateIconDrawablePosition", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SimpleButtonLayout extends FrameLayout {
        private View contentView;
        private DXSimpleButtonContentAlignment horizontalContentAlignment;
        private Drawable icon;
        private int iconIndent;
        private DXSimpleButtonIconPosition iconPosition;
        private ColorStateList iconTint;
        private boolean isInitializing;
        private boolean showShadow;
        private SimpleButtonStyle style;
        public AppCompatTextView textView;
        private boolean useRippleEffect;
        private DXSimpleButtonContentAlignment verticalContentAlignment;

        /* compiled from: SimpleButton.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[DXSimpleButtonContentAlignment.values().length];
                try {
                    iArr[DXSimpleButtonContentAlignment.Start.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DXSimpleButtonContentAlignment.Center.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[DXSimpleButtonContentAlignment.End.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[DXSimpleButtonIconPosition.values().length];
                try {
                    iArr2[DXSimpleButtonIconPosition.Start.ordinal()] = 1;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr2[DXSimpleButtonIconPosition.Top.ordinal()] = 2;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr2[DXSimpleButtonIconPosition.End.ordinal()] = 3;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr2[DXSimpleButtonIconPosition.Bottom.ordinal()] = 4;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public SimpleButtonLayout(Context context) {
            this(context, null, 0, 6, null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public SimpleButtonLayout(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0, 4, null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        public final void setText(int i) {
            setText$default(this, i, null, 2, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SimpleButtonLayout(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            Intrinsics.checkNotNullParameter(context, "context");
            this.style = new SimpleButtonStyle(context);
            this.iconPosition = DXSimpleButtonIconPosition.Start;
            this.useRippleEffect = true;
            this.horizontalContentAlignment = DXSimpleButtonContentAlignment.Center;
            this.verticalContentAlignment = DXSimpleButtonContentAlignment.Center;
            initTextView();
            if (attributeSet != null) {
                initStyle();
            } else {
                initDefaultStyle();
            }
            onContentViewChanged();
        }

        public /* synthetic */ SimpleButtonLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? android.R.attr.buttonStyle : i);
        }

        public final AppCompatTextView getTextView$dxeditors_release() {
            AppCompatTextView appCompatTextView = this.textView;
            if (appCompatTextView != null) {
                return appCompatTextView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            return null;
        }

        public final void setTextView$dxeditors_release(AppCompatTextView appCompatTextView) {
            Intrinsics.checkNotNullParameter(appCompatTextView, "<set-?>");
            this.textView = appCompatTextView;
        }

        public final CharSequence getText() {
            return getTextView$dxeditors_release().getText();
        }

        public final void setText(CharSequence charSequence) {
            setText(charSequence, TextView.BufferType.NORMAL);
            updateCompoundPadding();
        }

        public final float getTextSize() {
            return getTextView$dxeditors_release().getTextSize();
        }

        public final void setTextSize(float f) {
            getTextView$dxeditors_release().setTextSize(f);
        }

        public final Typeface getTypeface() {
            return getTextView$dxeditors_release().getTypeface();
        }

        public final void setTypeface(Typeface typeface) {
            getTextView$dxeditors_release().setTypeface(typeface);
        }

        public final Drawable getIcon() {
            return this.icon;
        }

        public final void setIcon(Drawable drawable) {
            if (Intrinsics.areEqual(this.icon, drawable)) {
                return;
            }
            this.icon = drawable;
            updateIconDrawablePosition();
            onIconSettingsChanged();
        }

        public final DXSimpleButtonIconPosition getIconPosition() {
            return this.iconPosition;
        }

        public final void setIconPosition(DXSimpleButtonIconPosition value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (this.iconPosition == value) {
                return;
            }
            this.iconPosition = value;
            updateIconDrawablePosition();
            onIconSettingsChanged();
        }

        public final int getIconIndent() {
            return this.iconIndent;
        }

        public final void setIconIndent(int i) {
            if (this.iconIndent == i) {
                return;
            }
            this.iconIndent = i;
            updateCompoundPadding();
        }

        public final View getContentView() {
            return this.contentView;
        }

        public final void setContentView(View view) {
            if (Intrinsics.areEqual(this.contentView, view)) {
                return;
            }
            this.contentView = view;
            onContentViewChanged();
        }

        public final DXCornerMode getCornerMode() {
            return this.style.getCornerMode();
        }

        public final void setCornerMode(DXCornerMode value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (this.style.getCornerMode() == value) {
                return;
            }
            this.style.setCornerMode(value);
            onBackgroundSettingsChanged();
        }

        public final float getTopLeftCornerRadius() {
            return this.style.getBorderRounds().topLeft;
        }

        public final void setTopLeftCornerRadius(float f) {
            if (this.style.getBorderRounds().topLeft == f) {
                return;
            }
            this.style.getBorderRounds().topLeft = f;
            onBackgroundSettingsChanged();
        }

        public final float getTopRightCornerRadius() {
            return this.style.getBorderRounds().topRight;
        }

        public final void setTopRightCornerRadius(float f) {
            if (this.style.getBorderRounds().topRight == f) {
                return;
            }
            this.style.getBorderRounds().topRight = f;
            onBackgroundSettingsChanged();
        }

        public final float getBottomLeftCornerRadius() {
            return this.style.getBorderRounds().bottomLeft;
        }

        public final void setBottomLeftCornerRadius(float f) {
            if (this.style.getBorderRounds().bottomLeft == f) {
                return;
            }
            this.style.getBorderRounds().bottomLeft = f;
            onBackgroundSettingsChanged();
        }

        public final float getBottomRightCornerRadius() {
            return this.style.getBorderRounds().bottomRight;
        }

        public final void setBottomRightCornerRadius(float f) {
            if (this.style.getBorderRounds().bottomRight == f) {
                return;
            }
            this.style.getBorderRounds().bottomRight = f;
            onBackgroundSettingsChanged();
        }

        public final float getBorderThickness() {
            return this.style.getBorderThickness();
        }

        public final void setBorderThickness(float f) {
            if (this.style.getBorderThickness() == f) {
                return;
            }
            this.style.setBorderThickness(f);
            onBackgroundSettingsChanged();
        }

        public final int getBorderColor() {
            return this.style.getBorderColor();
        }

        public final void setBorderColor(int i) {
            if (this.style.getBorderColor() == i) {
                return;
            }
            this.style.setBorderColor(i);
            onBackgroundSettingsChanged();
        }

        public final int getPressedBorderColor() {
            return this.style.getPressedBorderColor();
        }

        public final void setPressedBorderColor(int i) {
            if (this.style.getPressedBorderColor() == i) {
                return;
            }
            this.style.setPressedBorderColor(i);
            onBackgroundSettingsChanged();
        }

        public final int getDisabledBorderColor() {
            return this.style.getDisabledBorderColor();
        }

        public final void setDisabledBorderColor(int i) {
            if (this.style.getDisabledBorderColor() == i) {
                return;
            }
            this.style.setDisabledBorderColor(i);
            onBackgroundSettingsChanged();
        }

        public final int getBackgroundColor() {
            return this.style.getBackgroundColor();
        }

        public final int getPressedBackgroundColor() {
            return this.style.getPressedBackgroundColor();
        }

        public final void setPressedBackgroundColor(int i) {
            if (this.style.getPressedBackgroundColor() == i) {
                return;
            }
            this.style.setPressedBackgroundColor(i);
            onBackgroundSettingsChanged();
        }

        public final int getDisabledBackgroundColor() {
            return this.style.getDisabledBackgroundColor();
        }

        public final void setDisabledBackgroundColor(int i) {
            if (this.style.getDisabledBackgroundColor() == i) {
                return;
            }
            this.style.setDisabledBackgroundColor(i);
            onBackgroundSettingsChanged();
        }

        public final int getTextColor() {
            return this.style.getTextColor();
        }

        public final void setTextColor(int i) {
            if (this.style.getTextColor() == i) {
                return;
            }
            this.style.setTextColor(i);
            onTextSettingsChanged();
        }

        public final int getPressedTextColor() {
            return this.style.getPressedTextColor();
        }

        public final void setPressedTextColor(int i) {
            if (this.style.getPressedTextColor() == i) {
                return;
            }
            this.style.setPressedTextColor(i);
            onTextSettingsChanged();
        }

        public final int getDisabledTextColor() {
            return this.style.getDisabledTextColor();
        }

        public final void setDisabledTextColor(int i) {
            if (this.style.getDisabledTextColor() == i) {
                return;
            }
            this.style.setDisabledTextColor(i);
            onTextSettingsChanged();
        }

        public final int getIconColor() {
            return this.style.getIconColor();
        }

        public final void setIconColor(int i) {
            if (this.style.getIconColor() == i) {
                return;
            }
            this.style.setIconColor(i);
            onIconSettingsChanged();
        }

        public final int getPressedIconColor() {
            return this.style.getPressedIconColor();
        }

        public final void setPressedIconColor(int i) {
            if (this.style.getPressedIconColor() == i) {
                return;
            }
            this.style.setPressedIconColor(i);
            onIconSettingsChanged();
        }

        public final int getDisabledIconColor() {
            return this.style.getDisabledIconColor();
        }

        public final void setDisabledIconColor(int i) {
            if (this.style.getDisabledIconColor() == i) {
                return;
            }
            this.style.setDisabledIconColor(i);
            onIconSettingsChanged();
        }

        public final boolean getShowShadow() {
            return this.showShadow;
        }

        public final void setShowShadow(boolean z) {
            if (this.showShadow == z) {
                return;
            }
            this.showShadow = z;
            onShowShadowChanged();
        }

        public final boolean getUseRippleEffect() {
            return this.useRippleEffect;
        }

        public final void setUseRippleEffect(boolean z) {
            if (this.useRippleEffect == z) {
                return;
            }
            this.useRippleEffect = z;
            onUseRippleEffectChanged();
        }

        public final DXSimpleButtonContentAlignment getHorizontalContentAlignment() {
            return this.horizontalContentAlignment;
        }

        public final void setHorizontalContentAlignment(DXSimpleButtonContentAlignment value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (this.horizontalContentAlignment == value) {
                return;
            }
            this.horizontalContentAlignment = value;
            onContentAlignmentChanged();
        }

        public final DXSimpleButtonContentAlignment getVerticalContentAlignment() {
            return this.verticalContentAlignment;
        }

        public final void setVerticalContentAlignment(DXSimpleButtonContentAlignment value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (this.verticalContentAlignment == value) {
                return;
            }
            this.verticalContentAlignment = value;
            onContentAlignmentChanged();
        }

        public final void setText(CharSequence value, TextView.BufferType bufferType) {
            Intrinsics.checkNotNullParameter(bufferType, "bufferType");
            getTextView$dxeditors_release().setText(value, bufferType);
        }

        public static /* synthetic */ void setText$default(SimpleButtonLayout simpleButtonLayout, int i, TextView.BufferType bufferType, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                bufferType = TextView.BufferType.NORMAL;
            }
            simpleButtonLayout.setText(i, bufferType);
        }

        public final void setText(int resId, TextView.BufferType bufferType) {
            Intrinsics.checkNotNullParameter(bufferType, "bufferType");
            getTextView$dxeditors_release().setText(resId, bufferType);
        }

        public final void setIcon(int resId) {
            setIcon(AppCompatResources.getDrawable(getContext(), resId));
        }

        @Override // android.view.View
        public void setBackgroundColor(int color) {
            if (this.style.getBackgroundColor() == color) {
                return;
            }
            this.style.setBackgroundColor(color);
            onBackgroundSettingsChanged();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            updateDrawableTintMode();
        }

        @Override // android.view.ViewGroup, android.view.View
        public void jumpDrawablesToCurrentState() {
            super.jumpDrawablesToCurrentState();
            updateDrawableTintMode();
        }

        public final void setIconIndent(int unit, float value) {
            MathHelper.Companion companion = MathHelper.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            setIconIndent(companion.applyDimensionToInt(context, value, unit));
        }

        public final void setTopLeftCornerRadius(int unit, float value) {
            MathHelper.Companion companion = MathHelper.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            setTopLeftCornerRadius(companion.applyDimension(context, value, unit));
        }

        public final void setTopRightCornerRadius(int unit, float value) {
            MathHelper.Companion companion = MathHelper.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            setTopRightCornerRadius(companion.applyDimension(context, value, unit));
        }

        public final void setBottomLeftCornerRadius(int unit, float value) {
            MathHelper.Companion companion = MathHelper.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            setBottomLeftCornerRadius(companion.applyDimension(context, value, unit));
        }

        public final void setBottomRightCornerRadius(int unit, float value) {
            MathHelper.Companion companion = MathHelper.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            setBottomRightCornerRadius(companion.applyDimension(context, value, unit));
        }

        public final void setCornerRadii(int unit, float topLeft, float topRight, float bottomLeft, float bottomRight) {
            MathHelper.Companion companion = MathHelper.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            float applyDimension = companion.applyDimension(context, topLeft, unit);
            MathHelper.Companion companion2 = MathHelper.INSTANCE;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            float applyDimension2 = companion2.applyDimension(context2, topRight, unit);
            MathHelper.Companion companion3 = MathHelper.INSTANCE;
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            float applyDimension3 = companion3.applyDimension(context3, bottomLeft, unit);
            MathHelper.Companion companion4 = MathHelper.INSTANCE;
            Context context4 = getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            setCornerRadii(applyDimension, applyDimension2, applyDimension3, companion4.applyDimension(context4, bottomRight, unit));
        }

        public final void setCornerRadii(float topLeft, float topRight, float bottomLeft, float bottomRight) {
            beginInit();
            setTopLeftCornerRadius(topLeft);
            setTopRightCornerRadius(topRight);
            setBottomLeftCornerRadius(bottomLeft);
            setBottomRightCornerRadius(bottomRight);
            endInit();
        }

        public final void setBorderThickness(int unit, float value) {
            MathHelper.Companion companion = MathHelper.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            setBorderThickness(companion.applyDimension(context, value, unit));
        }

        public final void setTextSize(int unit, float size) {
            getTextView$dxeditors_release().setTextSize(unit, size);
        }

        public final void setTypeface(Typeface typeface, int style) {
            getTextView$dxeditors_release().setTypeface(typeface, style);
        }

        public final void setPadding(int unit, float left, float top, float right, float bottom) {
            MathHelper.Companion companion = MathHelper.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            int applyDimensionToInt = companion.applyDimensionToInt(context, left, unit);
            MathHelper.Companion companion2 = MathHelper.INSTANCE;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            int applyDimensionToInt2 = companion2.applyDimensionToInt(context2, top, unit);
            MathHelper.Companion companion3 = MathHelper.INSTANCE;
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            int applyDimensionToInt3 = companion3.applyDimensionToInt(context3, right, unit);
            MathHelper.Companion companion4 = MathHelper.INSTANCE;
            Context context4 = getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            setPaddingRelative(applyDimensionToInt, applyDimensionToInt2, applyDimensionToInt3, companion4.applyDimensionToInt(context4, bottom, unit));
        }

        public final void setPaddingRelative(int unit, float start, float top, float end, float bottom) {
            MathHelper.Companion companion = MathHelper.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            int applyDimensionToInt = companion.applyDimensionToInt(context, start, unit);
            MathHelper.Companion companion2 = MathHelper.INSTANCE;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            int applyDimensionToInt2 = companion2.applyDimensionToInt(context2, top, unit);
            MathHelper.Companion companion3 = MathHelper.INSTANCE;
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            int applyDimensionToInt3 = companion3.applyDimensionToInt(context3, end, unit);
            MathHelper.Companion companion4 = MathHelper.INSTANCE;
            Context context4 = getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            setPaddingRelative(applyDimensionToInt, applyDimensionToInt2, applyDimensionToInt3, companion4.applyDimensionToInt(context4, bottom, unit));
        }

        @Override // android.view.View
        public void setEnabled(boolean enabled) {
            View view = this.contentView;
            if (view != null) {
                view.setEnabled(enabled);
            }
            getTextView$dxeditors_release().setEnabled(enabled);
            super.setEnabled(enabled);
        }

        public final void setupContainedAppearance() {
            beginInit();
            this.style.resetToContainedAppearance();
            setShowShadow(true);
            endInit();
        }

        public final void setupOutlinedAppearance() {
            beginInit();
            this.style.resetToOutlinedAppearance();
            endInit();
        }

        public final void setupTextAppearance() {
            beginInit();
            this.style.resetToTextAppearance();
            endInit();
        }

        public final void beginInit() {
            this.isInitializing = true;
        }

        public final void endInit() {
            this.isInitializing = false;
            onBackgroundSettingsChanged();
            onShowShadowChanged();
            onTextSettingsChanged();
            onIconSettingsChanged();
            requestLayout();
            invalidate();
        }

        private final void initStyle() {
            initDefaultStyle();
        }

        private final void initDefaultStyle() {
            Resources resources = getContext().getResources();
            Intrinsics.checkNotNull(resources);
            initGeneralParameters(resources);
            setupOutlinedAppearance();
        }

        private final void initGeneralParameters(Resources res) {
            setMinimumWidth((int) res.getDimension(R.dimen.button_minWidth));
            setMinimumHeight((int) res.getDimension(R.dimen.button_minHeight));
            setIconIndent((int) res.getDimension(R.dimen.button_iconIndent));
            this.style.setShadowOffset((int) res.getDimension(R.dimen.button_shadowOffset));
            this.style.setShadowRotation(res.getInteger(R.integer.button_shadowRotation));
            this.style.setShadowRadius((int) res.getDimension(R.dimen.button_shadowElevation));
            this.style.setDisabledShadowRadius((int) res.getDimension(R.dimen.button_shadowElevation_disabled));
            this.style.setPressedShadowRadius((int) res.getDimension(R.dimen.button_shadowElevation_pressed));
            int dimension = (int) res.getDimension(R.dimen.button_paddingHorizontal);
            int dimension2 = (int) res.getDimension(R.dimen.button_paddingVertical);
            setPadding(dimension, dimension2, dimension, dimension2);
        }

        private final void initTextView() {
            setTextView$dxeditors_release(new AppCompatTextView(getContext()));
            getTextView$dxeditors_release().setGravity(17);
            getTextView$dxeditors_release().setHyphenationFrequency(0);
            if (Build.VERSION.SDK_INT >= 29) {
                getTextView$dxeditors_release().setBreakStrategy(0);
            } else {
                getTextView$dxeditors_release().setBreakStrategy(0);
            }
        }

        private final void onContentViewChanged() {
            int i;
            removeAllViewsInLayout();
            AppCompatTextView appCompatTextView = this.contentView;
            if (appCompatTextView != null) {
                i = 119;
            } else {
                appCompatTextView = getTextView$dxeditors_release();
                i = 17;
            }
            addView(appCompatTextView, new FrameLayout.LayoutParams(-2, -2, i));
            if (this.isInitializing) {
                return;
            }
            requestLayout();
            invalidate();
        }

        private final void onBackgroundSettingsChanged() {
            if (this.isInitializing) {
                return;
            }
            setBackground(this.style.createBackgroundDrawable());
        }

        private final void onTextSettingsChanged() {
            if (this.isInitializing) {
                return;
            }
            getTextView$dxeditors_release().setTextColor(this.style.createTextTintList());
            requestLayout();
        }

        private final void onIconSettingsChanged() {
            if (this.isInitializing) {
                return;
            }
            ColorStateList createIconTintList = this.style.createIconTintList();
            this.iconTint = createIconTintList;
            Drawable drawable = this.icon;
            if (drawable != null) {
                DrawableCompat.setTintList(drawable, createIconTintList);
            }
            jumpDrawablesToCurrentState();
            requestLayout();
        }

        private final void onShowShadowChanged() {
            this.style.setHasShadow(false);
            setStateListAnimator(this.showShadow ? AnimatorInflater.loadStateListAnimator(getContext(), R.animator.btn_state_list_anim) : null);
        }

        private final void onUseRippleEffectChanged() {
            this.style.setUseRippleEffect(this.useRippleEffect);
            onBackgroundSettingsChanged();
        }

        private final void onContentAlignmentChanged() {
            int i;
            ViewGroup.LayoutParams layoutParams = getChildAt(0).getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.verticalContentAlignment.ordinal()];
            int i3 = 3;
            if (i2 == 1) {
                i = 48;
            } else if (i2 == 2) {
                i = 16;
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                i = 80;
            }
            int i4 = WhenMappings.$EnumSwitchMapping$0[this.horizontalContentAlignment.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    i3 = 1;
                } else {
                    if (i4 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i3 = 5;
                }
            }
            layoutParams2.gravity = i | i3;
            requestLayout();
        }

        private final void updateCompoundPadding() {
            AppCompatTextView textView$dxeditors_release = getTextView$dxeditors_release();
            CharSequence text = getTextView$dxeditors_release().getText();
            textView$dxeditors_release.setCompoundDrawablePadding((text == null || text.length() == 0) ? 0 : this.iconIndent);
            requestLayout();
        }

        private final void updateIconDrawablePosition() {
            Drawable drawable;
            Drawable drawable2;
            Drawable drawable3;
            int i = WhenMappings.$EnumSwitchMapping$1[this.iconPosition.ordinal()];
            Drawable drawable4 = null;
            if (i != 1) {
                if (i == 2) {
                    Drawable drawable5 = this.icon;
                    drawable3 = drawable5 != null ? drawable5.mutate() : null;
                    drawable = null;
                } else if (i == 3) {
                    Drawable drawable6 = this.icon;
                    drawable = drawable6 != null ? drawable6.mutate() : null;
                    drawable3 = null;
                    drawable2 = null;
                } else if (i != 4) {
                    drawable3 = null;
                    drawable = null;
                } else {
                    Drawable drawable7 = this.icon;
                    drawable2 = drawable7 != null ? drawable7.mutate() : null;
                    drawable3 = null;
                    drawable = null;
                }
                drawable2 = drawable;
            } else {
                Drawable drawable8 = this.icon;
                drawable = null;
                drawable2 = null;
                drawable4 = drawable8 != null ? drawable8.mutate() : null;
                drawable3 = null;
            }
            getTextView$dxeditors_release().setCompoundDrawablesRelativeWithIntrinsicBounds(drawable4, drawable3, drawable, drawable2);
        }

        private final void updateDrawableTintMode() {
            PorterDuff.Mode mode;
            ColorStateList colorStateList = this.iconTint;
            if (colorStateList != null && colorStateList.getColorForState(getDrawableState(), Constants.getEMPTY_COLOR()) != Constants.getEMPTY_COLOR()) {
                mode = PorterDuff.Mode.SRC_IN;
            } else {
                mode = PorterDuff.Mode.DST;
            }
            Drawable drawable = this.icon;
            if (drawable != null) {
                DrawableCompat.setTintMode(drawable, mode);
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int mode = View.MeasureSpec.getMode(widthMeasureSpec);
            if (size == 0) {
                mode = 0;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), heightMeasureSpec);
        }

        private final float coerceCornerRadiusValue(float radiusValue) {
            float coerceAtMost = radiusValue > ((float) (getHeight() / 2)) ? RangesKt.coerceAtMost(getHeight() / 2, radiusValue) : radiusValue;
            return radiusValue > ((float) (getWidth() / 2)) ? RangesKt.coerceAtMost(getWidth() / 2, coerceAtMost) : coerceAtMost;
        }

        private final void coerceCornerRadius() {
            setTopLeftCornerRadius(coerceCornerRadiusValue(getTopLeftCornerRadius()));
            setTopRightCornerRadius(coerceCornerRadiusValue(getTopRightCornerRadius()));
            setBottomLeftCornerRadius(coerceCornerRadiusValue(getBottomLeftCornerRadius()));
            setBottomRightCornerRadius(coerceCornerRadiusValue(getBottomRightCornerRadius()));
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a3  */
        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
            /*
                r7 = this;
                r7.coerceCornerRadius()
                int r8 = r7.getChildCount()
                r0 = 1
                if (r8 == r0) goto Lb
                return
            Lb:
                r8 = 0
                android.view.View r1 = r7.getChildAt(r8)
                int r2 = r1.getVisibility()
                r3 = 8
                if (r2 == r3) goto Lbd
                int r2 = r7.getPaddingLeft()
                int r11 = r11 - r9
                int r9 = r7.getPaddingRight()
                int r11 = r11 - r9
                int r9 = r7.getPaddingTop()
                int r12 = r12 - r10
                int r10 = r7.getPaddingBottom()
                int r12 = r12 - r10
                android.view.ViewGroup$LayoutParams r10 = r1.getLayoutParams()
                java.lang.String r3 = "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r3)
                android.widget.FrameLayout$LayoutParams r10 = (android.widget.FrameLayout.LayoutParams) r10
                int r3 = r1.getMeasuredWidth()
                int r4 = r1.getMeasuredHeight()
                int r5 = r10.gravity
                r6 = -1
                if (r5 != r6) goto L46
                r5 = 17
            L46:
                int r6 = r7.getLayoutDirection()
                int r6 = android.view.Gravity.getAbsoluteGravity(r5, r6)
                r6 = r6 & 7
                if (r6 == r0) goto L6c
                r0 = 3
                if (r6 == r0) goto L64
                r0 = 5
                if (r6 == r0) goto L5e
                int r0 = r10.leftMargin
                int r2 = r2 + r0
                int r0 = r10.rightMargin
                goto L82
            L5e:
                int r0 = r10.rightMargin
                int r11 = r11 - r0
                int r2 = r11 - r3
                goto L83
            L64:
                int r11 = r10.leftMargin
                int r11 = r11 + r2
                int r0 = r2 + r3
                r2 = r11
                r11 = r0
                goto L83
            L6c:
                int r0 = r11 - r2
                int r6 = r10.leftMargin
                int r3 = r3 + r6
                int r6 = r10.rightMargin
                int r3 = r3 + r6
                int r0 = r0 - r3
                int r0 = r0 / 2
                int r0 = java.lang.Math.max(r8, r0)
                int r3 = r10.leftMargin
                int r2 = r2 + r3
                int r2 = r2 + r0
                int r3 = r10.rightMargin
                int r11 = r11 - r3
            L82:
                int r11 = r11 - r0
            L83:
                r0 = r5 & 112(0x70, float:1.57E-43)
                r3 = 16
                if (r0 == r3) goto La3
                r8 = 48
                if (r0 == r8) goto L9d
                r8 = 80
                if (r0 == r8) goto L97
                int r8 = r10.topMargin
                int r9 = r9 + r8
                int r8 = r10.bottomMargin
                goto Lb9
            L97:
                int r8 = r10.bottomMargin
                int r12 = r12 - r8
                int r9 = r12 - r4
                goto Lba
            L9d:
                int r8 = r10.topMargin
                int r9 = r9 + r8
                int r12 = r9 + r4
                goto Lba
            La3:
                int r0 = r12 - r9
                int r3 = r10.topMargin
                int r4 = r4 + r3
                int r3 = r10.bottomMargin
                int r4 = r4 + r3
                int r0 = r0 - r4
                int r0 = r0 / 2
                int r8 = java.lang.Math.max(r8, r0)
                int r0 = r10.topMargin
                int r9 = r9 + r0
                int r9 = r9 + r8
                int r10 = r10.bottomMargin
                int r12 = r12 - r10
            Lb9:
                int r12 = r12 - r8
            Lba:
                r1.layout(r2, r9, r11, r12)
            Lbd:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.devexpress.editors.SimpleButton.SimpleButtonLayout.onLayout(boolean, int, int, int, int):void");
        }
    }
}
