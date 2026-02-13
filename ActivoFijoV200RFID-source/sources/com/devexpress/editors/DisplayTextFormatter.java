package com.devexpress.editors;

import com.devexpress.editors.utils.DefaultDisplayTextFormatter;
import kotlin.Metadata;

/* compiled from: DisplayTextFormatter.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\bf\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/devexpress/editors/DisplayTextFormatter;", "", "format", "", "text", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DisplayTextFormatter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    CharSequence format(CharSequence format, CharSequence text);

    /* compiled from: DisplayTextFormatter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/devexpress/editors/DisplayTextFormatter$Companion;", "", "()V", "default", "Lcom/devexpress/editors/DisplayTextFormatter;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* renamed from: default, reason: not valid java name */
        public final DisplayTextFormatter m468default() {
            return new DefaultDisplayTextFormatter();
        }
    }
}
