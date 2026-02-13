package com.devexpress.editors.style;

import com.devexpress.editors.Constants;
import kotlin.Metadata;

/* compiled from: NumericEditStyle.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/devexpress/editors/style/NumericEditStyle;", "Lcom/devexpress/editors/style/TextEditStyle;", "()V", "disabledDownIconColor", "", "getDisabledDownIconColor", "()I", "setDisabledDownIconColor", "(I)V", "disabledUpIconColor", "getDisabledUpIconColor", "setDisabledUpIconColor", "downIconColor", "getDownIconColor", "setDownIconColor", "upIconColor", "getUpIconColor", "setUpIconColor", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NumericEditStyle extends TextEditStyle {
    private int downIconColor = Constants.getEMPTY_COLOR();
    private int disabledDownIconColor = Constants.getEMPTY_COLOR();
    private int upIconColor = Constants.getEMPTY_COLOR();
    private int disabledUpIconColor = Constants.getEMPTY_COLOR();

    public final int getDownIconColor() {
        return this.downIconColor;
    }

    public final void setDownIconColor(int i) {
        this.downIconColor = i;
    }

    public final int getDisabledDownIconColor() {
        return this.disabledDownIconColor;
    }

    public final void setDisabledDownIconColor(int i) {
        this.disabledDownIconColor = i;
    }

    public final int getUpIconColor() {
        return this.upIconColor;
    }

    public final void setUpIconColor(int i) {
        this.upIconColor = i;
    }

    public final int getDisabledUpIconColor() {
        return this.disabledUpIconColor;
    }

    public final void setDisabledUpIconColor(int i) {
        this.disabledUpIconColor = i;
    }
}
