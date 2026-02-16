package com.devexpress.editors.pickers;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: DateEditPicker.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "i", "", "c", "Lkotlin/Function1;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
final class DateEditPicker$yearViewsManager$1$viewsUpdater$2 extends Lambda implements Function3<View, Integer, Function1<? super Integer, ? extends Integer>, Unit> {
    final /* synthetic */ DateEditPicker this$0;
    final /* synthetic */ DateEditPicker$yearViewsManager$1 this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DateEditPicker$yearViewsManager$1$viewsUpdater$2(DateEditPicker dateEditPicker, DateEditPicker$yearViewsManager$1 dateEditPicker$yearViewsManager$1) {
        super(3);
        this.this$0 = dateEditPicker;
        this.this$1 = dateEditPicker$yearViewsManager$1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(DateEditPicker this$0, Function1 c, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(c, "$c");
        this$0.onMonthClick(((Number) c.invoke(Integer.valueOf(i))).intValue());
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Function1<? super Integer, ? extends Integer> function1) {
        invoke(view, num.intValue(), (Function1<? super Integer, Integer>) function1);
        return Unit.INSTANCE;
    }

    public final void invoke(View v, final int i, final Function1<? super Integer, Integer> c) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(c, "c");
        this.this$0.addOrAttachView(v);
        getLayoutProvider().measureCell(v);
        final DateEditPicker dateEditPicker = this.this$0;
        v.setOnClickListener(new View.OnClickListener() { // from class: com.devexpress.editors.pickers.DateEditPicker$yearViewsManager$1$viewsUpdater$2$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DateEditPicker$yearViewsManager$1$viewsUpdater$2.invoke$lambda$0(DateEditPicker.this, c, i, view);
            }
        });
    }
}
