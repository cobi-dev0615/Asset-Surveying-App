package com.devexpress.editors.utils;

import com.devexpress.editors.DisplayTextFormatter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: DefaultDisplayTextFormatter.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/devexpress/editors/utils/DefaultDisplayTextFormatter;", "Lcom/devexpress/editors/DisplayTextFormatter;", "()V", "format", "", "text", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultDisplayTextFormatter implements DisplayTextFormatter {
    @Override // com.devexpress.editors.DisplayTextFormatter
    public CharSequence format(CharSequence format, CharSequence text) {
        if (format == null) {
            return text == null ? "" : text;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format2 = String.format(format.toString(), Arrays.copyOf(new Object[]{text}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        return format2;
    }
}
