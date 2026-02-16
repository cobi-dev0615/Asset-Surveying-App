package com.devexpress.editors.style;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.appcompat.R;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.devexpress.editors.Constants;
import com.devexpress.editors.DXCornerMode;
import com.devexpress.editors.model.BorderRounds;
import com.devexpress.editors.utils.drawablemanager.ButtonBackgroundFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleButtonStyle.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 m2\u00020\u0001:\u0001mB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010^\u001a\u00020\u0006H\u0002J\u0006\u0010_\u001a\u00020`J\b\u0010a\u001a\u0004\u0018\u00010bJ\b\u0010c\u001a\u0004\u0018\u00010bJ\"\u0010d\u001a\u0004\u0018\u00010b2\u0006\u0010e\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u00062\u0006\u0010g\u001a\u00020\u0006H\u0002J\u0006\u0010h\u001a\u00020iJ\u0006\u0010j\u001a\u00020iJ\u0006\u0010k\u001a\u00020iJ\b\u0010l\u001a\u00020iH\u0002R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR&\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R&\u0010$\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u0010R&\u0010'\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u0010R\u001e\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u0010R\u001a\u0010-\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\t\"\u0004\b/\u0010\u0010R&\u00100\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u0010R\u0011\u00103\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b4\u0010\tR\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010=\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\t\"\u0004\b?\u0010\u0010R&\u0010@\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\t\"\u0004\bB\u0010\u0010R&\u0010C\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\t\"\u0004\bE\u0010\u0010R\u001e\u0010F\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\t\"\u0004\bH\u0010\u0010R\u001a\u0010I\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\t\"\u0004\bK\u0010\u0010R&\u0010L\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\t\"\u0004\bN\u0010\u0010R\u001a\u0010O\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\t\"\u0004\bQ\u0010\u0010R\u001a\u0010R\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\t\"\u0004\bT\u0010\u0010R\u001a\u0010U\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\t\"\u0004\bW\u0010\u0010R\u001e\u0010X\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\t\"\u0004\bZ\u0010\u0010R\u001a\u0010[\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u00108\"\u0004\b]\u0010:¨\u0006n"}, d2 = {"Lcom/devexpress/editors/style/SimpleButtonStyle;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "<set-?>", "", "accentColor", "getAccentColor", "()I", "actualPressedBackgroundColor", "getActualPressedBackgroundColor", "value", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "(I)V", "borderColor", "getBorderColor", "setBorderColor", "borderRounds", "Lcom/devexpress/editors/model/BorderRounds;", "getBorderRounds", "()Lcom/devexpress/editors/model/BorderRounds;", "borderThickness", "", "getBorderThickness", "()F", "setBorderThickness", "(F)V", "cornerMode", "Lcom/devexpress/editors/DXCornerMode;", "getCornerMode", "()Lcom/devexpress/editors/DXCornerMode;", "setCornerMode", "(Lcom/devexpress/editors/DXCornerMode;)V", "disabledBackgroundColor", "getDisabledBackgroundColor", "setDisabledBackgroundColor", "disabledBorderColor", "getDisabledBorderColor", "setDisabledBorderColor", "disabledIconColor", "getDisabledIconColor", "setDisabledIconColor", "disabledShadowRadius", "getDisabledShadowRadius", "setDisabledShadowRadius", "disabledTextColor", "getDisabledTextColor", "setDisabledTextColor", "focusedBackgroundColor", "getFocusedBackgroundColor", "hasShadow", "", "getHasShadow", "()Z", "setHasShadow", "(Z)V", "hsv", "", "iconColor", "getIconColor", "setIconColor", "pressedBackgroundColor", "getPressedBackgroundColor", "setPressedBackgroundColor", "pressedBorderColor", "getPressedBorderColor", "setPressedBorderColor", "pressedIconColor", "getPressedIconColor", "setPressedIconColor", "pressedShadowRadius", "getPressedShadowRadius", "setPressedShadowRadius", "pressedTextColor", "getPressedTextColor", "setPressedTextColor", "shadowOffset", "getShadowOffset", "setShadowOffset", "shadowRadius", "getShadowRadius", "setShadowRadius", "shadowRotation", "getShadowRotation", "setShadowRotation", "textColor", "getTextColor", "setTextColor", "useRippleEffect", "getUseRippleEffect", "setUseRippleEffect", "calculatePressedColor", "createBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "createIconTintList", "Landroid/content/res/ColorStateList;", "createTextTintList", "createTintList", TypedValues.Custom.S_COLOR, "pressedColor", "disabledColor", "resetToContainedAppearance", "", "resetToOutlinedAppearance", "resetToTextAppearance", "updateActualPressedBackgroundColor", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SimpleButtonStyle {
    private static final int COLOR_COMPONENT_COUNT = 3;
    private static final float DARK_COLOR_MAX_VALUE = 0.5f;
    private static final int VALUE_COMPONENT_INDEX = 2;
    private int accentColor;
    private int actualPressedBackgroundColor;
    private int backgroundColor;
    private int borderColor;
    private final BorderRounds borderRounds;
    private float borderThickness;
    private final Context context;
    private DXCornerMode cornerMode;
    private int disabledBackgroundColor;
    private int disabledBorderColor;
    private int disabledIconColor;
    private int disabledShadowRadius;
    private int disabledTextColor;
    private boolean hasShadow;
    private final float[] hsv;
    private int iconColor;
    private int pressedBackgroundColor;
    private int pressedBorderColor;
    private int pressedIconColor;
    private int pressedShadowRadius;
    private int pressedTextColor;
    private int shadowOffset;
    private int shadowRadius;
    private int shadowRotation;
    private int textColor;
    private boolean useRippleEffect;

    public SimpleButtonStyle(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.hsv = new float[3];
        this.cornerMode = DXCornerMode.Round;
        this.borderRounds = new BorderRounds(0);
        this.iconColor = Constants.getEMPTY_COLOR();
        this.pressedIconColor = Constants.getEMPTY_COLOR();
        this.disabledIconColor = Constants.getEMPTY_COLOR();
        this.useRippleEffect = true;
        try {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorButtonNormal, typedValue, true);
            this.accentColor = ContextCompat.getColor(context, typedValue.resourceId);
        } catch (Exception unused) {
        }
    }

    public final int getActualPressedBackgroundColor() {
        return this.actualPressedBackgroundColor;
    }

    public final int getAccentColor() {
        return this.accentColor;
    }

    public final DXCornerMode getCornerMode() {
        return this.cornerMode;
    }

    public final void setCornerMode(DXCornerMode dXCornerMode) {
        Intrinsics.checkNotNullParameter(dXCornerMode, "<set-?>");
        this.cornerMode = dXCornerMode;
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

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final void setBorderColor(int i) {
        this.borderColor = i;
    }

    public final int getPressedBorderColor() {
        int i = this.pressedBorderColor;
        return i != 0 ? i : this.borderColor;
    }

    public final void setPressedBorderColor(int i) {
        if (this.pressedBorderColor == i) {
            return;
        }
        this.pressedBorderColor = i;
    }

    public final int getDisabledBorderColor() {
        int i = this.disabledBorderColor;
        return i != 0 ? i : this.borderColor;
    }

    public final void setDisabledBorderColor(int i) {
        if (this.disabledBorderColor == i) {
            return;
        }
        this.disabledBorderColor = i;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(int i) {
        if (this.backgroundColor == i) {
            return;
        }
        this.backgroundColor = i;
        updateActualPressedBackgroundColor();
    }

    public final int getFocusedBackgroundColor() {
        return ColorUtils.setAlphaComponent(this.pressedBackgroundColor, (int) (Color.alpha(this.pressedBackgroundColor) * 0.6f));
    }

    public final int getDisabledBackgroundColor() {
        int i = this.disabledBackgroundColor;
        return i != 0 ? i : this.backgroundColor;
    }

    public final void setDisabledBackgroundColor(int i) {
        if (this.disabledBackgroundColor == i) {
            return;
        }
        this.disabledBackgroundColor = i;
    }

    public final int getPressedBackgroundColor() {
        return this.pressedBackgroundColor;
    }

    public final void setPressedBackgroundColor(int i) {
        if (this.pressedBackgroundColor == i) {
            return;
        }
        this.pressedBackgroundColor = i;
        updateActualPressedBackgroundColor();
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(int i) {
        this.textColor = i;
    }

    public final int getPressedTextColor() {
        int i = this.pressedTextColor;
        return i != 0 ? i : this.textColor;
    }

    public final void setPressedTextColor(int i) {
        if (this.pressedTextColor == i) {
            return;
        }
        this.pressedTextColor = i;
    }

    public final int getDisabledTextColor() {
        int i = this.disabledTextColor;
        return i != 0 ? i : this.textColor;
    }

    public final void setDisabledTextColor(int i) {
        if (this.disabledTextColor == i) {
            return;
        }
        this.disabledTextColor = i;
    }

    public final int getIconColor() {
        return this.iconColor;
    }

    public final void setIconColor(int i) {
        this.iconColor = i;
    }

    public final int getPressedIconColor() {
        return this.pressedIconColor;
    }

    public final void setPressedIconColor(int i) {
        this.pressedIconColor = i;
    }

    public final int getDisabledIconColor() {
        return this.disabledIconColor;
    }

    public final void setDisabledIconColor(int i) {
        this.disabledIconColor = i;
    }

    public final int getShadowOffset() {
        return this.shadowOffset;
    }

    public final void setShadowOffset(int i) {
        this.shadowOffset = i;
    }

    public final int getShadowRotation() {
        return this.shadowRotation;
    }

    public final void setShadowRotation(int i) {
        this.shadowRotation = i;
    }

    public final int getShadowRadius() {
        return this.shadowRadius;
    }

    public final void setShadowRadius(int i) {
        this.shadowRadius = i;
    }

    public final int getDisabledShadowRadius() {
        return this.disabledShadowRadius;
    }

    public final void setDisabledShadowRadius(int i) {
        this.disabledShadowRadius = i;
    }

    public final int getPressedShadowRadius() {
        return this.pressedShadowRadius;
    }

    public final void setPressedShadowRadius(int i) {
        this.pressedShadowRadius = i;
    }

    public final boolean getHasShadow() {
        return this.hasShadow;
    }

    public final void setHasShadow(boolean z) {
        this.hasShadow = z;
    }

    public final boolean getUseRippleEffect() {
        return this.useRippleEffect;
    }

    public final void setUseRippleEffect(boolean z) {
        this.useRippleEffect = z;
    }

    public final void resetToTextAppearance() {
        Context context = this.context;
        Resources resources = context.getResources();
        this.borderRounds.set(resources.getDimension(com.devexpress.editors.R.dimen.button_borderRounds));
        this.borderThickness = resources.getDimension(com.devexpress.editors.R.dimen.textButton_borderThickness);
        this.borderColor = ContextCompat.getColor(context, com.devexpress.editors.R.color.textButton_borderColor);
        setPressedBorderColor(ContextCompat.getColor(context, com.devexpress.editors.R.color.textButton_borderColor));
        setDisabledBorderColor(ContextCompat.getColor(context, com.devexpress.editors.R.color.textButton_borderColor));
        setBackgroundColor(ContextCompat.getColor(context, com.devexpress.editors.R.color.textButton_backgroundColor));
        updateActualPressedBackgroundColor();
        setDisabledBackgroundColor(ContextCompat.getColor(context, com.devexpress.editors.R.color.textButton_backgroundColor));
        int color = ContextCompat.getColor(context, com.devexpress.editors.R.color.outlinedButton_foregroundColor_disabled);
        int i = this.accentColor;
        this.textColor = i;
        this.iconColor = i;
        setDisabledTextColor(color);
        this.disabledIconColor = color;
        this.hasShadow = false;
    }

    public final void resetToOutlinedAppearance() {
        Context context = this.context;
        Resources resources = context.getResources();
        this.borderRounds.set(resources.getDimension(com.devexpress.editors.R.dimen.button_borderRounds));
        this.borderThickness = resources.getDimension(com.devexpress.editors.R.dimen.outlinedButton_borderThickness);
        this.borderColor = ContextCompat.getColor(context, com.devexpress.editors.R.color.outlinedButton_borderColor);
        setPressedBorderColor(ContextCompat.getColor(context, com.devexpress.editors.R.color.outlinedButton_borderColor_pressed));
        setDisabledBorderColor(ContextCompat.getColor(context, com.devexpress.editors.R.color.outlinedButton_borderColor_disabled));
        setBackgroundColor(ContextCompat.getColor(context, com.devexpress.editors.R.color.outlinedButton_backgroundColor));
        updateActualPressedBackgroundColor();
        setDisabledBackgroundColor(ContextCompat.getColor(context, com.devexpress.editors.R.color.outlinedButton_backgroundColor_disabled));
        int color = ContextCompat.getColor(context, com.devexpress.editors.R.color.outlinedButton_foregroundColor_disabled);
        int i = this.accentColor;
        this.textColor = i;
        this.iconColor = i;
        setDisabledTextColor(color);
        this.disabledIconColor = color;
        this.hasShadow = false;
    }

    public final void resetToContainedAppearance() {
        Context context = this.context;
        Resources resources = context.getResources();
        this.borderRounds.set(resources.getDimension(com.devexpress.editors.R.dimen.button_borderRounds));
        this.borderThickness = resources.getDimension(com.devexpress.editors.R.dimen.containedButton_borderThickness);
        this.borderColor = ContextCompat.getColor(context, com.devexpress.editors.R.color.containedButton_borderColor);
        setPressedBorderColor(ContextCompat.getColor(context, com.devexpress.editors.R.color.containedButton_borderColor_pressed));
        setDisabledBorderColor(ContextCompat.getColor(context, com.devexpress.editors.R.color.containedButton_borderColor_disabled));
        setBackgroundColor(this.accentColor);
        updateActualPressedBackgroundColor();
        setDisabledBackgroundColor(ContextCompat.getColor(context, com.devexpress.editors.R.color.containedButton_backgroundColor_disabled));
        int color = ContextCompat.getColor(context, com.devexpress.editors.R.color.containedButton_foregroundColor);
        int color2 = ContextCompat.getColor(context, com.devexpress.editors.R.color.containedButton_foregroundColor_disabled);
        this.textColor = color;
        this.iconColor = color;
        setDisabledTextColor(color2);
        this.disabledIconColor = color2;
        this.hasShadow = true;
    }

    public final ColorStateList createTextTintList() {
        return createTintList(this.textColor, getPressedTextColor(), getDisabledTextColor());
    }

    public final ColorStateList createIconTintList() {
        return createTintList(this.iconColor, this.pressedIconColor, this.disabledIconColor);
    }

    public final Drawable createBackgroundDrawable() {
        return ButtonBackgroundFactory.INSTANCE.create(this);
    }

    private final ColorStateList createTintList(int color, int pressedColor, int disabledColor) {
        if (color == Constants.getEMPTY_COLOR() && pressedColor == Constants.getEMPTY_COLOR() && disabledColor == Constants.getEMPTY_COLOR()) {
            return null;
        }
        if (pressedColor == Constants.getEMPTY_COLOR()) {
            pressedColor = color;
        }
        if (disabledColor == Constants.getEMPTY_COLOR()) {
            disabledColor = color;
        }
        return new ColorStateList(new int[][]{Constants.DISABLED_STATE, Constants.PRESSED_STATE, Constants.DEFAULT_STATE}, new int[]{disabledColor, pressedColor, color});
    }

    private final void updateActualPressedBackgroundColor() {
        int i = this.pressedBackgroundColor;
        if (i == 0) {
            if (this.backgroundColor == 0) {
                i = ColorUtils.setAlphaComponent(this.accentColor, 25);
            } else {
                i = calculatePressedColor();
            }
        }
        this.actualPressedBackgroundColor = i;
    }

    private final int calculatePressedColor() {
        Color.colorToHSV(this.backgroundColor, this.hsv);
        return ColorUtils.setAlphaComponent(this.hsv[2] < 0.5f ? -1 : -16777216, 25);
    }
}
