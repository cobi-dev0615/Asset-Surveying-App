package com.devexpress.editors.utils.textstrategies;

import android.text.Editable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.devexpress.editors.DisplayTextFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayFormatTextProcessor.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/devexpress/editors/utils/textstrategies/DisplayFormatTextProcessor;", "Lcom/devexpress/editors/utils/textstrategies/DecoratorTextProcessor;", "format", "", "textFormatter", "Lcom/devexpress/editors/DisplayTextFormatter;", "wrappee", "Lcom/devexpress/editors/utils/textstrategies/TextProcessor;", "(Ljava/lang/CharSequence;Lcom/devexpress/editors/DisplayTextFormatter;Lcom/devexpress/editors/utils/textstrategies/TextProcessor;)V", "displayText", "getDisplayText", "()Ljava/lang/CharSequence;", "applyDisplayText", "", TypedValues.AttributesType.S_TARGET, "Landroid/text/Editable;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DisplayFormatTextProcessor extends DecoratorTextProcessor {
    private final CharSequence format;
    private final DisplayTextFormatter textFormatter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayFormatTextProcessor(CharSequence charSequence, DisplayTextFormatter textFormatter, TextProcessor wrappee) {
        super(wrappee);
        Intrinsics.checkNotNullParameter(textFormatter, "textFormatter");
        Intrinsics.checkNotNullParameter(wrappee, "wrappee");
        this.format = charSequence;
        this.textFormatter = textFormatter;
    }

    public final CharSequence getDisplayText() {
        CharSequence charSequence;
        if (getTextInternal().length() == 0) {
            return getTextInternal();
        }
        if (!getHasFocus() && (charSequence = this.format) != null) {
            return this.textFormatter.format(charSequence, getTextInternal());
        }
        return getTextInternal();
    }

    @Override // com.devexpress.editors.utils.textstrategies.DecoratorTextProcessor, com.devexpress.editors.utils.textstrategies.TextProcessor
    public void applyDisplayText(Editable target) {
        Intrinsics.checkNotNullParameter(target, "target");
        target.replace(0, target.length(), getDisplayText());
    }
}
