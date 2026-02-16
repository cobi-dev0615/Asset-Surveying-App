package com.devexpress.editors.style;

import com.devexpress.editors.Constants;
import kotlin.Metadata;

/* compiled from: TimeEditStyle.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/devexpress/editors/style/TimeEditStyle;", "Lcom/devexpress/editors/style/TextEditStyle;", "()V", "disabledTimeIconColor", "", "getDisabledTimeIconColor", "()I", "setDisabledTimeIconColor", "(I)V", "timeIconColor", "getTimeIconColor", "setTimeIconColor", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TimeEditStyle extends TextEditStyle {
    private int timeIconColor = Constants.getEMPTY_COLOR();
    private int disabledTimeIconColor = Constants.getEMPTY_COLOR();

    public final int getTimeIconColor() {
        return this.timeIconColor;
    }

    public final void setTimeIconColor(int i) {
        this.timeIconColor = i;
    }

    public final int getDisabledTimeIconColor() {
        return this.disabledTimeIconColor;
    }

    public final void setDisabledTimeIconColor(int i) {
        this.disabledTimeIconColor = i;
    }
}
