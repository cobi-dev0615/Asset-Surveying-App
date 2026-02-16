package com.devexpress.editors;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayTextProvider.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/devexpress/editors/DisplayTextProvider;", "", "()V", "displayFormat", "", "getDisplayFormat", "()Ljava/lang/String;", "setDisplayFormat", "(Ljava/lang/String;)V", "formattedText", "getFormattedText", "<set-?>", "text", "getText", "setText", "", "value", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DisplayTextProvider {
    private String displayFormat = "";
    private String text = "";

    public abstract String getFormattedText();

    public final String getDisplayFormat() {
        return this.displayFormat;
    }

    public final void setDisplayFormat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.displayFormat = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(CharSequence value) {
        String str;
        if (value == null || (str = value.toString()) == null) {
            str = "";
        }
        this.text = str;
    }
}
