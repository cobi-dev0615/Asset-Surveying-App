package com.devexpress.editors.style;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.devexpress.editors.Constants;
import com.devexpress.editors.R;
import com.devexpress.editors.utils.drawablemanager.CheckBoxBackgroundFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckEditStyle.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u00100\u001a\u000201J\b\u00102\u001a\u0004\u0018\u000103J\u0006\u00104\u001a\u000203J\u0006\u00105\u001a\u000206R\u0011\u0010\u0005\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u00068F@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\u0014R\u001e\u0010\u001e\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010\u0014R\u001e\u0010!\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\b\"\u0004\b#\u0010\u0014R\u001e\u0010$\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\b\"\u0004\b&\u0010\u0014R\u001e\u0010'\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\b\"\u0004\b)\u0010\u0014R\u001e\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010\u0014R\u001e\u0010-\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\b\"\u0004\b/\u0010\u0014¨\u00067"}, d2 = {"Lcom/devexpress/editors/style/CheckEditStyle;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actualCheckedPressedBackgroundColor", "", "getActualCheckedPressedBackgroundColor", "()I", "actualFocusedBackgroundColor", "getActualFocusedBackgroundColor", "actualPressedBackgroundColor", "getActualPressedBackgroundColor", "areAllColorsEmpty", "", "getAreAllColorsEmpty", "()Z", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "(I)V", "checkedForegroundColor", "getCheckedForegroundColor", "setCheckedForegroundColor", "checkedPressedBackgroundColor", "getCheckedPressedBackgroundColor", "setCheckedPressedBackgroundColor", "disabledBackgroundColor", "getDisabledBackgroundColor", "setDisabledBackgroundColor", "disabledCheckedForegroundColor", "getDisabledCheckedForegroundColor", "setDisabledCheckedForegroundColor", "disabledForegroundColor", "getDisabledForegroundColor", "setDisabledForegroundColor", "disabledLabelColor", "getDisabledLabelColor", "setDisabledLabelColor", "foregroundColor", "getForegroundColor", "setForegroundColor", "labelColor", "getLabelColor", "setLabelColor", "pressedBackgroundColor", "getPressedBackgroundColor", "setPressedBackgroundColor", "createCheckBoxBackground", "Landroid/graphics/drawable/Drawable;", "createCheckBoxTint", "Landroid/content/res/ColorStateList;", "createLabelTint", "resetToDefaults", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckEditStyle {
    private int backgroundColor;
    private int checkedForegroundColor;
    private int checkedPressedBackgroundColor;
    private final Context context;
    private int disabledBackgroundColor;
    private int disabledCheckedForegroundColor;
    private int disabledForegroundColor;
    private int disabledLabelColor;
    private int foregroundColor;
    private int labelColor;
    private int pressedBackgroundColor;

    public CheckEditStyle(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.pressedBackgroundColor = Constants.getEMPTY_COLOR();
        this.checkedPressedBackgroundColor = Constants.getEMPTY_COLOR();
        this.disabledBackgroundColor = Constants.getEMPTY_COLOR();
        this.foregroundColor = Constants.getEMPTY_COLOR();
        this.checkedForegroundColor = Constants.getEMPTY_COLOR();
        this.disabledForegroundColor = Constants.getEMPTY_COLOR();
        this.disabledCheckedForegroundColor = Constants.getEMPTY_COLOR();
        this.labelColor = Constants.getEMPTY_COLOR();
        resetToDefaults();
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final int getPressedBackgroundColor() {
        return this.pressedBackgroundColor;
    }

    public final void setPressedBackgroundColor(int i) {
        this.pressedBackgroundColor = i;
    }

    public final int getCheckedPressedBackgroundColor() {
        return this.checkedPressedBackgroundColor;
    }

    public final void setCheckedPressedBackgroundColor(int i) {
        this.checkedPressedBackgroundColor = i;
    }

    public final void setDisabledBackgroundColor(int i) {
        this.disabledBackgroundColor = i;
    }

    public final int getDisabledBackgroundColor() {
        if (this.disabledBackgroundColor != Constants.getEMPTY_COLOR()) {
            return this.disabledBackgroundColor;
        }
        return this.backgroundColor;
    }

    public final int getActualPressedBackgroundColor() {
        if (this.pressedBackgroundColor != Constants.getEMPTY_COLOR()) {
            return this.pressedBackgroundColor;
        }
        return ColorUtils.setAlphaComponent(this.foregroundColor, (int) (Color.alpha(this.foregroundColor) * 0.1f));
    }

    public final int getActualCheckedPressedBackgroundColor() {
        if (this.checkedPressedBackgroundColor != Constants.getEMPTY_COLOR()) {
            return this.checkedPressedBackgroundColor;
        }
        return ColorUtils.setAlphaComponent(this.checkedForegroundColor, (int) (Color.alpha(this.checkedForegroundColor) * 0.1f));
    }

    public final int getActualFocusedBackgroundColor() {
        return ColorUtils.setAlphaComponent(this.pressedBackgroundColor, (int) (Color.alpha(this.pressedBackgroundColor) * 0.6f));
    }

    public final int getForegroundColor() {
        return this.foregroundColor;
    }

    public final void setForegroundColor(int i) {
        this.foregroundColor = i;
    }

    public final int getCheckedForegroundColor() {
        return this.checkedForegroundColor;
    }

    public final void setCheckedForegroundColor(int i) {
        this.checkedForegroundColor = i;
    }

    public final int getDisabledForegroundColor() {
        return this.disabledForegroundColor;
    }

    public final void setDisabledForegroundColor(int i) {
        this.disabledForegroundColor = i;
    }

    public final int getDisabledCheckedForegroundColor() {
        return this.disabledCheckedForegroundColor;
    }

    public final void setDisabledCheckedForegroundColor(int i) {
        this.disabledCheckedForegroundColor = i;
    }

    public final int getLabelColor() {
        return this.labelColor;
    }

    public final void setLabelColor(int i) {
        this.labelColor = i;
    }

    public final int getDisabledLabelColor() {
        return this.disabledLabelColor;
    }

    public final void setDisabledLabelColor(int i) {
        this.disabledLabelColor = i;
    }

    public final void resetToDefaults() {
        this.foregroundColor = ContextCompat.getColor(this.context, R.color.checkbox_foregroundColor);
        this.checkedForegroundColor = ContextCompat.getColor(this.context, R.color.checkbox_selectedForegroundColor);
        this.disabledForegroundColor = ContextCompat.getColor(this.context, R.color.checkbox_disabledForegroundColor);
        this.disabledCheckedForegroundColor = ContextCompat.getColor(this.context, R.color.checkbox_disabledSelectedForegroundColor);
        this.backgroundColor = 0;
        this.disabledBackgroundColor = Constants.getEMPTY_COLOR();
        this.pressedBackgroundColor = Constants.getEMPTY_COLOR();
        this.checkedPressedBackgroundColor = Constants.getEMPTY_COLOR();
        this.labelColor = ContextCompat.getColor(this.context, R.color.checkbox_labelColor);
        this.disabledLabelColor = ContextCompat.getColor(this.context, R.color.checkbox_disabledLabelColor);
    }

    public final Drawable createCheckBoxBackground() {
        return CheckBoxBackgroundFactory.INSTANCE.create(this);
    }

    public final ColorStateList createCheckBoxTint() {
        if (getAreAllColorsEmpty()) {
            return null;
        }
        return new ColorStateList(new int[][]{Constants.DISABLED_CHECKED_STATE, Constants.DISABLED_STATE, Constants.CHECKED_STATE, Constants.DEFAULT_STATE}, new int[]{this.disabledCheckedForegroundColor, this.disabledForegroundColor, this.checkedForegroundColor, this.foregroundColor});
    }

    public final ColorStateList createLabelTint() {
        return new ColorStateList(new int[][]{Constants.DISABLED_STATE, Constants.DEFAULT_STATE}, new int[]{this.disabledLabelColor, this.labelColor});
    }

    private final boolean getAreAllColorsEmpty() {
        return this.disabledCheckedForegroundColor == Constants.getEMPTY_COLOR() && this.disabledForegroundColor == Constants.getEMPTY_COLOR() && this.checkedForegroundColor == Constants.getEMPTY_COLOR() && this.foregroundColor == Constants.getEMPTY_COLOR();
    }
}
