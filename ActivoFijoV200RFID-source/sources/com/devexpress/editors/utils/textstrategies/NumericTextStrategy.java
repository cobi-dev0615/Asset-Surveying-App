package com.devexpress.editors.utils.textstrategies;

import android.text.Editable;
import android.widget.EditText;
import com.devexpress.editors.DisplayTextFormatter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Facades.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, d2 = {"Lcom/devexpress/editors/utils/textstrategies/NumericTextStrategy;", "Lcom/devexpress/editors/utils/textstrategies/ProcessorTextStrategy;", "decimalSeparator", "", "minusSign", "maxDecimalDigitCount", "", "editor", "Landroid/widget/EditText;", "textChangedCallback", "Lkotlin/Function1;", "", "", "format", "displayFormatter", "Lcom/devexpress/editors/DisplayTextFormatter;", "(CCILandroid/widget/EditText;Lkotlin/jvm/functions/Function1;Ljava/lang/CharSequence;Lcom/devexpress/editors/DisplayTextFormatter;)V", "onFocusChanged", "hasFocus", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NumericTextStrategy extends ProcessorTextStrategy {
    public /* synthetic */ NumericTextStrategy(char c, char c2, int i, EditText editText, Function1 function1, CharSequence charSequence, DisplayTextFormatter displayTextFormatter, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(c, c2, i, editText, (i2 & 16) != 0 ? null : function1, charSequence, displayTextFormatter);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NumericTextStrategy(char r4, char r5, int r6, android.widget.EditText r7, kotlin.jvm.functions.Function1<? super java.lang.CharSequence, kotlin.Unit> r8, java.lang.CharSequence r9, com.devexpress.editors.DisplayTextFormatter r10) {
        /*
            r3 = this;
            java.lang.String r0 = "editor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            if (r10 == 0) goto L1d
            com.devexpress.editors.utils.textstrategies.DisplayFormatTextProcessor r0 = new com.devexpress.editors.utils.textstrategies.DisplayFormatTextProcessor
            com.devexpress.editors.utils.textstrategies.NumericTextProcessor r1 = new com.devexpress.editors.utils.textstrategies.NumericTextProcessor
            com.devexpress.editors.utils.textstrategies.DefaultTextProcessor r2 = new com.devexpress.editors.utils.textstrategies.DefaultTextProcessor
            r2.<init>()
            com.devexpress.editors.utils.textstrategies.TextProcessor r2 = (com.devexpress.editors.utils.textstrategies.TextProcessor) r2
            r1.<init>(r4, r5, r6, r2)
            com.devexpress.editors.utils.textstrategies.TextProcessor r1 = (com.devexpress.editors.utils.textstrategies.TextProcessor) r1
            r0.<init>(r9, r10, r1)
            com.devexpress.editors.utils.textstrategies.DecoratorTextProcessor r0 = (com.devexpress.editors.utils.textstrategies.DecoratorTextProcessor) r0
            goto L2c
        L1d:
            com.devexpress.editors.utils.textstrategies.NumericTextProcessor r9 = new com.devexpress.editors.utils.textstrategies.NumericTextProcessor
            com.devexpress.editors.utils.textstrategies.DefaultTextProcessor r10 = new com.devexpress.editors.utils.textstrategies.DefaultTextProcessor
            r10.<init>()
            com.devexpress.editors.utils.textstrategies.TextProcessor r10 = (com.devexpress.editors.utils.textstrategies.TextProcessor) r10
            r9.<init>(r4, r5, r6, r10)
            r0 = r9
            com.devexpress.editors.utils.textstrategies.DecoratorTextProcessor r0 = (com.devexpress.editors.utils.textstrategies.DecoratorTextProcessor) r0
        L2c:
            com.devexpress.editors.utils.textstrategies.TextProcessor r0 = (com.devexpress.editors.utils.textstrategies.TextProcessor) r0
            r3.<init>(r0, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.editors.utils.textstrategies.NumericTextStrategy.<init>(char, char, int, android.widget.EditText, kotlin.jvm.functions.Function1, java.lang.CharSequence, com.devexpress.editors.DisplayTextFormatter):void");
    }

    @Override // com.devexpress.editors.utils.textstrategies.ProcessorTextStrategy, com.devexpress.editors.utils.textstrategies.TextStrategy
    public void onFocusChanged(boolean hasFocus) {
        super.onFocusChanged(hasFocus);
        Editable text = getEditor().getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        applyActualText(text, true);
        raiseTextChanged();
    }
}
