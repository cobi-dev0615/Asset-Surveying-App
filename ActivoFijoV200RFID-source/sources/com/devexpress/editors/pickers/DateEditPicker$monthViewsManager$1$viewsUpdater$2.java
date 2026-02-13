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
final class DateEditPicker$monthViewsManager$1$viewsUpdater$2 extends Lambda implements Function3<View, Integer, Function1<? super Integer, ? extends Integer>, Unit> {
    final /* synthetic */ DateEditPicker this$0;
    final /* synthetic */ DateEditPicker$monthViewsManager$1 this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DateEditPicker$monthViewsManager$1$viewsUpdater$2(DateEditPicker dateEditPicker, DateEditPicker$monthViewsManager$1 dateEditPicker$monthViewsManager$1) {
        super(3);
        this.this$0 = dateEditPicker;
        this.this$1 = dateEditPicker$monthViewsManager$1;
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
        final DateEditPicker$monthViewsManager$1 dateEditPicker$monthViewsManager$1 = this.this$1;
        final DateEditPicker dateEditPicker = this.this$0;
        v.setOnClickListener(new View.OnClickListener() { // from class: com.devexpress.editors.pickers.DateEditPicker$monthViewsManager$1$viewsUpdater$2$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DateEditPicker$monthViewsManager$1$viewsUpdater$2.invoke$lambda$0(Function1.this, i, dateEditPicker$monthViewsManager$1, dateEditPicker, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(Function1 c, int i, DateEditPicker$monthViewsManager$1 this$0, DateEditPicker this$1, View view) {
        Intrinsics.checkNotNullParameter(c, "$c");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        int intValue = ((Number) c.invoke(Integer.valueOf(i))).intValue();
        int indexOnPage = this$0.getLayoutProvider().indexOnPage(intValue);
        if (indexOnPage >= 7) {
            int yearMonth = this$1.getYearMonth() + this$0.getLayoutProvider().page(intValue);
            this$1.onDayOfMonthClick(yearMonth / 12, yearMonth % 12, indexOnPage - 7);
        }
    }
}
