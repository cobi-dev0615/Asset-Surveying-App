package com.devexpress.editors.utils.textstrategies;

import android.text.Editable;
import android.widget.EditText;
import com.devexpress.editors.DisplayTextFormatter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Facades.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/devexpress/editors/utils/textstrategies/DisplayFormatTextStrategy;", "Lcom/devexpress/editors/utils/textstrategies/ProcessorTextStrategy;", "format", "", "provider", "Lcom/devexpress/editors/DisplayTextFormatter;", "editor", "Landroid/widget/EditText;", "textChangedCallback", "Lkotlin/Function1;", "", "(Ljava/lang/CharSequence;Lcom/devexpress/editors/DisplayTextFormatter;Landroid/widget/EditText;Lkotlin/jvm/functions/Function1;)V", "onFocusChanged", "hasFocus", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DisplayFormatTextStrategy extends ProcessorTextStrategy {
    public /* synthetic */ DisplayFormatTextStrategy(CharSequence charSequence, DisplayTextFormatter displayTextFormatter, EditText editText, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, displayTextFormatter, editText, (i & 8) != 0 ? null : function1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayFormatTextStrategy(CharSequence format, DisplayTextFormatter provider, EditText editor, Function1<? super CharSequence, Unit> function1) {
        super(new DisplayFormatTextProcessor(format, provider, new DefaultTextProcessor()), editor, function1);
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(editor, "editor");
    }

    @Override // com.devexpress.editors.utils.textstrategies.ProcessorTextStrategy, com.devexpress.editors.utils.textstrategies.TextStrategy
    public void onFocusChanged(boolean hasFocus) {
        super.onFocusChanged(hasFocus);
        Editable text = getEditor().getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        applyActualText(text, true);
    }
}
