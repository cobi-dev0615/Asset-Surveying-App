package com.devexpress.editors.style;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.core.internal.view.SupportMenu;
import com.devexpress.editors.Constants;
import com.devexpress.editors.R;
import com.devexpress.editors.model.BorderRounds;
import com.devexpress.editors.model.Thickness;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChipStyle.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J6\u0010\u0098\u0001\u001a\u00020\u00062\u0007\u0010\u0099\u0001\u001a\u00020&2\u0007\u0010\u009a\u0001\u001a\u00020&2\u0007\u0010\u009b\u0001\u001a\u00020&2\u0007\u0010\u009c\u0001\u001a\u00020&2\u0007\u0010\u009d\u0001\u001a\u00020&H\u0002R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR\u001a\u0010\u001e\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001a\u0010!\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010$R&\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R&\u0010,\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R&\u0010/\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R&\u00102\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010)\"\u0004\b4\u0010+R&\u00105\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010)\"\u0004\b7\u0010+R&\u00108\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010)\"\u0004\b:\u0010+R&\u0010;\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010)\"\u0004\b=\u0010+R&\u0010>\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010)\"\u0004\b@\u0010+R&\u0010A\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010)\"\u0004\bC\u0010+R&\u0010D\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010)\"\u0004\bF\u0010+R&\u0010G\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010)\"\u0004\bI\u0010+R&\u0010J\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010)\"\u0004\bL\u0010+R\u001e\u0010M\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\b\"\u0004\bO\u0010\nR\u001a\u0010P\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0015\"\u0004\bR\u0010\u0017R\u001a\u0010S\u001a\u00020TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR&\u0010Y\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010)\"\u0004\b[\u0010+R&\u0010\\\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010)\"\u0004\b^\u0010+R&\u0010_\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010)\"\u0004\ba\u0010+R&\u0010b\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010)\"\u0004\bd\u0010+R&\u0010e\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010)\"\u0004\bg\u0010+R&\u0010h\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010)\"\u0004\bj\u0010+R\u001e\u0010k\u001a\u0004\u0018\u00010\u00068@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\b\"\u0004\bm\u0010\nR&\u0010n\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010)\"\u0004\bp\u0010+R&\u0010q\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010)\"\u0004\bs\u0010+R&\u0010t\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010)\"\u0004\bv\u0010+R&\u0010w\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010)\"\u0004\by\u0010+R&\u0010z\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010)\"\u0004\b|\u0010+R&\u0010}\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010)\"\u0004\b\u007f\u0010+R)\u0010\u0080\u0001\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010)\"\u0005\b\u0082\u0001\u0010+R)\u0010\u0083\u0001\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010)\"\u0005\b\u0085\u0001\u0010+R)\u0010\u0086\u0001\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010)\"\u0005\b\u0088\u0001\u0010+R)\u0010\u0089\u0001\u001a\u00020&2\u0006\u0010%\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010)\"\u0005\b\u008b\u0001\u0010+R!\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010\b\"\u0005\b\u008e\u0001\u0010\nR\u001d\u0010\u008f\u0001\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u0015\"\u0005\b\u0091\u0001\u0010\u0017R \u0010\u0092\u0001\u001a\u00030\u0093\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001¨\u0006\u009e\u0001"}, d2 = {"Lcom/devexpress/editors/style/ChipStyle;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "backgroundColor", "Landroid/content/res/ColorStateList;", "getBackgroundColor", "()Landroid/content/res/ColorStateList;", "setBackgroundColor", "(Landroid/content/res/ColorStateList;)V", "borderColor", "getBorderColor", "setBorderColor", "borderRounds", "Lcom/devexpress/editors/model/BorderRounds;", "getBorderRounds", "()Lcom/devexpress/editors/model/BorderRounds;", "borderThickness", "", "getBorderThickness", "()F", "setBorderThickness", "(F)V", "checkIconColor", "getCheckIconColor", "setCheckIconColor", "closeIconColor", "getCloseIconColor", "setCloseIconColor", "closeIconIndent", "getCloseIconIndent", "setCloseIconIndent", "cornerRadii", "getCornerRadii", "setCornerRadii", "(Lcom/devexpress/editors/model/BorderRounds;)V", "value", "", "disabledBackgroundColor", "getDisabledBackgroundColor", "()I", "setDisabledBackgroundColor", "(I)V", "disabledBorderColor", "getDisabledBorderColor", "setDisabledBorderColor", "disabledCheckIconColor", "getDisabledCheckIconColor", "setDisabledCheckIconColor", "disabledCloseIconColor", "getDisabledCloseIconColor", "setDisabledCloseIconColor", "disabledIconColor", "getDisabledIconColor", "setDisabledIconColor", "disabledTextColor", "getDisabledTextColor", "setDisabledTextColor", "enabledBackgroundColor", "getEnabledBackgroundColor", "setEnabledBackgroundColor", "enabledBorderColor", "getEnabledBorderColor", "setEnabledBorderColor", "enabledCheckIconColor", "getEnabledCheckIconColor", "setEnabledCheckIconColor", "enabledCloseIconColor", "getEnabledCloseIconColor", "setEnabledCloseIconColor", "enabledIconColor", "getEnabledIconColor", "setEnabledIconColor", "enabledTextColor", "getEnabledTextColor", "setEnabledTextColor", "iconColor", "getIconColor", "setIconColor", "iconIndent", "getIconIndent", "setIconIndent", "padding", "Lcom/devexpress/editors/model/Thickness;", "getPadding", "()Lcom/devexpress/editors/model/Thickness;", "setPadding", "(Lcom/devexpress/editors/model/Thickness;)V", "pressedBackgroundColor", "getPressedBackgroundColor", "setPressedBackgroundColor", "pressedBorderColor", "getPressedBorderColor", "setPressedBorderColor", "pressedCheckIconColor", "getPressedCheckIconColor", "setPressedCheckIconColor", "pressedCloseIconColor", "getPressedCloseIconColor", "setPressedCloseIconColor", "pressedIconColor", "getPressedIconColor", "setPressedIconColor", "pressedTextColor", "getPressedTextColor", "setPressedTextColor", "rippleColor", "getRippleColor$dxeditors_release", "setRippleColor$dxeditors_release", "selectedBackgroundColor", "getSelectedBackgroundColor", "setSelectedBackgroundColor", "selectedBorderColor", "getSelectedBorderColor", "setSelectedBorderColor", "selectedCloseIconColor", "getSelectedCloseIconColor", "setSelectedCloseIconColor", "selectedDisabledBackgroundColor", "getSelectedDisabledBackgroundColor", "setSelectedDisabledBackgroundColor", "selectedDisabledBorderColor", "getSelectedDisabledBorderColor", "setSelectedDisabledBorderColor", "selectedDisabledCloseIconColor", "getSelectedDisabledCloseIconColor", "setSelectedDisabledCloseIconColor", "selectedDisabledIconColor", "getSelectedDisabledIconColor", "setSelectedDisabledIconColor", "selectedDisabledTextColor", "getSelectedDisabledTextColor", "setSelectedDisabledTextColor", "selectedIconColor", "getSelectedIconColor", "setSelectedIconColor", "selectedTextColor", "getSelectedTextColor", "setSelectedTextColor", "textColor", "getTextColor", "setTextColor", "textSize", "getTextSize", "setTextSize", "useRippleEffect", "", "getUseRippleEffect", "()Z", "setUseRippleEffect", "(Z)V", "createColorList", "enabledColor", "disabledColor", "pressedColor", "selectedColor", "selectedDisabledColor", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChipStyle {
    private ColorStateList backgroundColor;
    private ColorStateList borderColor;
    private final BorderRounds borderRounds;
    private float borderThickness;
    private ColorStateList checkIconColor;
    private ColorStateList closeIconColor;
    private float closeIconIndent;
    private BorderRounds cornerRadii;
    private int disabledBackgroundColor;
    private int disabledBorderColor;
    private int disabledCheckIconColor;
    private int disabledCloseIconColor;
    private int disabledIconColor;
    private int disabledTextColor;
    private int enabledBackgroundColor;
    private int enabledBorderColor;
    private int enabledCheckIconColor;
    private int enabledCloseIconColor;
    private int enabledIconColor;
    private int enabledTextColor;
    private ColorStateList iconColor;
    private float iconIndent;
    private Thickness padding;
    private int pressedBackgroundColor;
    private int pressedBorderColor;
    private int pressedCheckIconColor;
    private int pressedCloseIconColor;
    private int pressedIconColor;
    private int pressedTextColor;
    private ColorStateList rippleColor;
    private int selectedBackgroundColor;
    private int selectedBorderColor;
    private int selectedCloseIconColor;
    private int selectedDisabledBackgroundColor;
    private int selectedDisabledBorderColor;
    private int selectedDisabledCloseIconColor;
    private int selectedDisabledIconColor;
    private int selectedDisabledTextColor;
    private int selectedIconColor;
    private int selectedTextColor;
    private ColorStateList textColor;
    private float textSize;
    private boolean useRippleEffect;

    public ChipStyle(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.borderRounds = new BorderRounds(0);
        this.textSize = context.getResources().getDimension(R.dimen.chip_textSize);
        this.padding = new Thickness(10);
        this.iconIndent = 10.0f;
        this.closeIconIndent = 10.0f;
        this.cornerRadii = new BorderRounds(-1);
        this.enabledIconColor = Constants.getEMPTY_COLOR();
        this.disabledIconColor = Constants.getEMPTY_COLOR();
        this.pressedIconColor = Constants.getEMPTY_COLOR();
        this.selectedIconColor = Constants.getEMPTY_COLOR();
        this.selectedDisabledIconColor = Constants.getEMPTY_COLOR();
        this.enabledCheckIconColor = Constants.getEMPTY_COLOR();
        this.disabledCheckIconColor = Constants.getEMPTY_COLOR();
        this.enabledCloseIconColor = -16777216;
        this.disabledCloseIconColor = SupportMenu.CATEGORY_MASK;
        this.pressedCheckIconColor = Constants.getEMPTY_COLOR();
        this.pressedCloseIconColor = -16711936;
        this.selectedCloseIconColor = -16776961;
        this.selectedDisabledCloseIconColor = -16711681;
        this.useRippleEffect = true;
    }

    public final BorderRounds getBorderRounds() {
        return this.borderRounds;
    }

    public final float getBorderThickness() {
        return this.borderThickness;
    }

    public final void setBorderThickness(float f) {
        this.borderThickness = f;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public final void setTextSize(float f) {
        this.textSize = f;
    }

    public final Thickness getPadding() {
        return this.padding;
    }

    public final void setPadding(Thickness thickness) {
        Intrinsics.checkNotNullParameter(thickness, "<set-?>");
        this.padding = thickness;
    }

    public final float getIconIndent() {
        return this.iconIndent;
    }

    public final void setIconIndent(float f) {
        this.iconIndent = f;
    }

    public final float getCloseIconIndent() {
        return this.closeIconIndent;
    }

    public final void setCloseIconIndent(float f) {
        this.closeIconIndent = f;
    }

    public final BorderRounds getCornerRadii() {
        return this.cornerRadii;
    }

    public final void setCornerRadii(BorderRounds borderRounds) {
        Intrinsics.checkNotNullParameter(borderRounds, "<set-?>");
        this.cornerRadii = borderRounds;
    }

    public final void setRippleColor$dxeditors_release(ColorStateList colorStateList) {
        this.rippleColor = colorStateList;
    }

    public final ColorStateList getRippleColor$dxeditors_release() {
        if (this.rippleColor == null) {
            this.rippleColor = new ColorStateList(new int[][]{Constants.PRESSED_STATE, Constants.DEFAULT_STATE}, new int[]{520093696, 520093696});
        }
        return this.rippleColor;
    }

    public final int getEnabledBackgroundColor() {
        return this.enabledBackgroundColor;
    }

    public final void setEnabledBackgroundColor(int i) {
        if (this.enabledBackgroundColor != i) {
            this.enabledBackgroundColor = i;
            this.backgroundColor = null;
        }
    }

    public final int getDisabledBackgroundColor() {
        return this.disabledBackgroundColor;
    }

    public final void setDisabledBackgroundColor(int i) {
        if (this.disabledBackgroundColor != i) {
            this.disabledBackgroundColor = i;
            this.backgroundColor = null;
        }
    }

    public final int getPressedBackgroundColor() {
        return this.pressedBackgroundColor;
    }

    public final void setPressedBackgroundColor(int i) {
        if (this.pressedBackgroundColor != i) {
            this.pressedBackgroundColor = i;
            this.backgroundColor = null;
            this.rippleColor = null;
        }
    }

    public final int getSelectedBackgroundColor() {
        return this.selectedBackgroundColor;
    }

    public final void setSelectedBackgroundColor(int i) {
        if (this.selectedBackgroundColor != i) {
            this.selectedBackgroundColor = i;
            this.backgroundColor = null;
        }
    }

    public final int getSelectedDisabledBackgroundColor() {
        return this.selectedDisabledBackgroundColor;
    }

    public final void setSelectedDisabledBackgroundColor(int i) {
        if (this.selectedDisabledBackgroundColor != i) {
            this.selectedDisabledBackgroundColor = i;
            this.backgroundColor = null;
        }
    }

    public final int getEnabledTextColor() {
        return this.enabledTextColor;
    }

    public final void setEnabledTextColor(int i) {
        if (this.enabledTextColor != i) {
            this.enabledTextColor = i;
            this.textColor = null;
        }
    }

    public final int getDisabledTextColor() {
        return this.disabledTextColor;
    }

    public final void setDisabledTextColor(int i) {
        if (this.disabledTextColor != i) {
            this.disabledTextColor = i;
            this.textColor = null;
        }
    }

    public final int getPressedTextColor() {
        return this.pressedTextColor;
    }

    public final void setPressedTextColor(int i) {
        if (this.pressedTextColor != i) {
            this.pressedTextColor = i;
            this.textColor = null;
        }
    }

    public final int getSelectedTextColor() {
        return this.selectedTextColor;
    }

    public final void setSelectedTextColor(int i) {
        if (this.selectedTextColor != i) {
            this.selectedTextColor = i;
            this.textColor = null;
        }
    }

    public final int getSelectedDisabledTextColor() {
        return this.selectedDisabledTextColor;
    }

    public final void setSelectedDisabledTextColor(int i) {
        if (this.selectedDisabledTextColor != i) {
            this.selectedDisabledTextColor = i;
            this.textColor = null;
        }
    }

    public final int getEnabledBorderColor() {
        return this.enabledBorderColor;
    }

    public final void setEnabledBorderColor(int i) {
        if (this.enabledBorderColor != i) {
            this.enabledBorderColor = i;
            this.borderColor = null;
        }
    }

    public final int getDisabledBorderColor() {
        return this.disabledBorderColor;
    }

    public final void setDisabledBorderColor(int i) {
        if (this.disabledBorderColor != i) {
            this.disabledBorderColor = i;
            this.borderColor = null;
        }
    }

    public final int getPressedBorderColor() {
        return this.pressedBorderColor;
    }

    public final void setPressedBorderColor(int i) {
        if (this.pressedBorderColor != i) {
            this.pressedBorderColor = i;
            this.borderColor = null;
        }
    }

    public final int getSelectedBorderColor() {
        return this.selectedBorderColor;
    }

    public final void setSelectedBorderColor(int i) {
        if (this.selectedBorderColor != i) {
            this.selectedBorderColor = i;
            this.borderColor = null;
        }
    }

    public final int getSelectedDisabledBorderColor() {
        return this.selectedDisabledBorderColor;
    }

    public final void setSelectedDisabledBorderColor(int i) {
        if (this.selectedDisabledBorderColor != i) {
            this.selectedDisabledBorderColor = i;
            this.borderColor = null;
        }
    }

    public final int getEnabledIconColor() {
        return this.enabledIconColor;
    }

    public final void setEnabledIconColor(int i) {
        if (this.enabledIconColor != i) {
            this.enabledIconColor = i;
            this.iconColor = null;
        }
    }

    public final int getDisabledIconColor() {
        return this.disabledIconColor;
    }

    public final void setDisabledIconColor(int i) {
        if (this.disabledIconColor != i) {
            this.disabledIconColor = i;
            this.iconColor = null;
        }
    }

    public final int getPressedIconColor() {
        return this.pressedIconColor;
    }

    public final void setPressedIconColor(int i) {
        if (this.pressedIconColor != i) {
            this.pressedIconColor = i;
            this.iconColor = null;
        }
    }

    public final int getSelectedIconColor() {
        return this.selectedIconColor;
    }

    public final void setSelectedIconColor(int i) {
        if (this.selectedIconColor != i) {
            this.selectedIconColor = i;
            this.iconColor = null;
        }
    }

    public final int getSelectedDisabledIconColor() {
        return this.selectedDisabledIconColor;
    }

    public final void setSelectedDisabledIconColor(int i) {
        if (this.selectedDisabledIconColor != i) {
            this.selectedDisabledIconColor = i;
            this.iconColor = null;
        }
    }

    public final int getEnabledCheckIconColor() {
        return this.enabledCheckIconColor;
    }

    public final void setEnabledCheckIconColor(int i) {
        if (this.enabledCheckIconColor != i) {
            this.enabledCheckIconColor = i;
            this.checkIconColor = null;
        }
    }

    public final int getDisabledCheckIconColor() {
        return this.disabledCheckIconColor;
    }

    public final void setDisabledCheckIconColor(int i) {
        if (this.disabledCheckIconColor != i) {
            this.disabledCheckIconColor = i;
            this.checkIconColor = null;
        }
    }

    public final int getEnabledCloseIconColor() {
        return this.enabledCloseIconColor;
    }

    public final void setEnabledCloseIconColor(int i) {
        if (this.enabledCloseIconColor != i) {
            this.enabledCloseIconColor = i;
            this.closeIconColor = null;
        }
    }

    public final int getDisabledCloseIconColor() {
        return this.disabledCloseIconColor;
    }

    public final void setDisabledCloseIconColor(int i) {
        if (this.disabledCloseIconColor != i) {
            this.disabledCloseIconColor = i;
            this.closeIconColor = null;
        }
    }

    public final int getPressedCheckIconColor() {
        return this.pressedCheckIconColor;
    }

    public final void setPressedCheckIconColor(int i) {
        if (this.pressedCheckIconColor != i) {
            this.pressedCheckIconColor = i;
            this.checkIconColor = null;
        }
    }

    public final int getPressedCloseIconColor() {
        return this.pressedCloseIconColor;
    }

    public final void setPressedCloseIconColor(int i) {
        if (this.pressedCloseIconColor != i) {
            this.pressedCloseIconColor = i;
            this.closeIconColor = null;
        }
    }

    public final int getSelectedCloseIconColor() {
        return this.selectedCloseIconColor;
    }

    public final void setSelectedCloseIconColor(int i) {
        if (this.selectedCloseIconColor != i) {
            this.selectedCloseIconColor = i;
            this.closeIconColor = null;
        }
    }

    public final int getSelectedDisabledCloseIconColor() {
        return this.selectedDisabledCloseIconColor;
    }

    public final void setSelectedDisabledCloseIconColor(int i) {
        if (this.selectedDisabledCloseIconColor != i) {
            this.selectedDisabledCloseIconColor = i;
            this.closeIconColor = null;
        }
    }

    public final boolean getUseRippleEffect() {
        return this.useRippleEffect;
    }

    public final void setUseRippleEffect(boolean z) {
        this.useRippleEffect = z;
    }

    public final void setBackgroundColor(ColorStateList colorStateList) {
        this.backgroundColor = colorStateList;
    }

    public final ColorStateList getBackgroundColor() {
        if (this.backgroundColor == null) {
            this.backgroundColor = createColorList(this.enabledBackgroundColor, this.disabledBackgroundColor, this.pressedBackgroundColor, this.selectedBackgroundColor, this.selectedDisabledBackgroundColor);
        }
        return this.backgroundColor;
    }

    public final void setTextColor(ColorStateList colorStateList) {
        this.textColor = colorStateList;
    }

    public final ColorStateList getTextColor() {
        if (this.textColor == null) {
            this.textColor = createColorList(this.enabledTextColor, this.disabledTextColor, this.pressedTextColor, this.selectedTextColor, this.selectedDisabledTextColor);
        }
        return this.textColor;
    }

    public final void setBorderColor(ColorStateList colorStateList) {
        this.borderColor = colorStateList;
    }

    public final ColorStateList getBorderColor() {
        if (this.borderColor == null) {
            this.borderColor = createColorList(this.enabledBorderColor, this.disabledBorderColor, this.pressedBorderColor, this.selectedBorderColor, this.selectedDisabledBorderColor);
        }
        return this.borderColor;
    }

    public final void setIconColor(ColorStateList colorStateList) {
        this.iconColor = colorStateList;
    }

    public final ColorStateList getIconColor() {
        if (this.iconColor == null) {
            this.iconColor = createColorList(this.enabledIconColor, this.disabledIconColor, this.pressedIconColor, this.selectedIconColor, this.selectedDisabledIconColor);
        }
        return this.iconColor;
    }

    public final void setCloseIconColor(ColorStateList colorStateList) {
        this.closeIconColor = colorStateList;
    }

    public final ColorStateList getCloseIconColor() {
        if (this.closeIconColor == null) {
            this.closeIconColor = createColorList(this.enabledCloseIconColor, this.disabledCloseIconColor, this.pressedCloseIconColor, this.selectedCloseIconColor, this.selectedDisabledCloseIconColor);
        }
        return this.closeIconColor;
    }

    public final void setCheckIconColor(ColorStateList colorStateList) {
        this.checkIconColor = colorStateList;
    }

    public final ColorStateList getCheckIconColor() {
        if (this.checkIconColor == null) {
            this.checkIconColor = new ColorStateList(new int[][]{Constants.DISABLED_STATE, Constants.PRESSED_STATE, Constants.DEFAULT_STATE}, new int[]{this.disabledCheckIconColor, this.pressedCheckIconColor, this.enabledCheckIconColor});
        }
        return this.checkIconColor;
    }

    private final ColorStateList createColorList(int enabledColor, int disabledColor, int pressedColor, int selectedColor, int selectedDisabledColor) {
        return new ColorStateList(new int[][]{Constants.ENABLED_CHECKED_NOT_PRESSED_STATE, Constants.DISABLED_CHECKED_STATE, Constants.PRESSED_STATE, Constants.DISABLED_STATE, Constants.ENABLED_STATE, Constants.DEFAULT_STATE}, new int[]{selectedColor, selectedDisabledColor, pressedColor, disabledColor, enabledColor, SupportMenu.CATEGORY_MASK});
    }
}
