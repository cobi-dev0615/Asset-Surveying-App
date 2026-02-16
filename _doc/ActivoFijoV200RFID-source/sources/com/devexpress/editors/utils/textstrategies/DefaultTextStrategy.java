package com.devexpress.editors.utils.textstrategies;

import android.widget.EditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Facades.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/devexpress/editors/utils/textstrategies/DefaultTextStrategy;", "Lcom/devexpress/editors/utils/textstrategies/ProcessorTextStrategy;", "editor", "Landroid/widget/EditText;", "textChangedCallback", "Lkotlin/Function1;", "", "", "(Landroid/widget/EditText;Lkotlin/jvm/functions/Function1;)V", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultTextStrategy extends ProcessorTextStrategy {
    public /* synthetic */ DefaultTextStrategy(EditText editText, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(editText, (i & 2) != 0 ? null : function1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultTextStrategy(EditText editor, Function1<? super CharSequence, Unit> function1) {
        super(new DefaultTextProcessor(), editor, function1);
        Intrinsics.checkNotNullParameter(editor, "editor");
    }
}
