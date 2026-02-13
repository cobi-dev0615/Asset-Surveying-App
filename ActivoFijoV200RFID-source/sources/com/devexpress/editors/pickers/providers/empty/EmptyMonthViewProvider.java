package com.devexpress.editors.pickers.providers.empty;

import android.content.Context;
import android.view.View;
import com.devexpress.editors.pickers.CalendarCellView;
import com.devexpress.editors.pickers.InernalLinkedListExtensionKt;
import com.devexpress.editors.pickers.providers.MonthViewProvider;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmptyMonthViewProvider.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0013\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/devexpress/editors/pickers/providers/empty/EmptyMonthViewProvider;", "Lcom/devexpress/editors/pickers/providers/MonthViewProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cache", "Ljava/util/LinkedList;", "Landroid/view/View;", "getCache", "()Ljava/util/LinkedList;", "check", "", "view", "year", "", "cellIndex", "recycle", "", "request", "update", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EmptyMonthViewProvider implements MonthViewProvider {
    private final LinkedList<View> cache;
    private final Context context;

    @Override // com.devexpress.editors.pickers.providers.MonthViewProvider
    public boolean check(View view, int year, int cellIndex) {
        Intrinsics.checkNotNullParameter(view, "view");
        return true;
    }

    public EmptyMonthViewProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.cache = new LinkedList<>();
    }

    public final LinkedList<View> getCache() {
        return this.cache;
    }

    @Override // com.devexpress.editors.pickers.providers.MonthViewProvider
    public View request(int year, int cellIndex) {
        View view = (View) InernalLinkedListExtensionKt.dxRemoveFirstOrNull(this.cache);
        if (view != null) {
            return view;
        }
        CalendarCellView calendarCellView = new CalendarCellView(this.context, null, 0, 6, null);
        CalendarCellView calendarCellView2 = calendarCellView;
        update(calendarCellView2, year, cellIndex);
        calendarCellView.setMarkColor(0);
        return calendarCellView2;
    }

    @Override // com.devexpress.editors.pickers.providers.MonthViewProvider
    public void update(View view, int year, int cellIndex) {
        Intrinsics.checkNotNullParameter(view, "view");
        CalendarCellView calendarCellView = view instanceof CalendarCellView ? (CalendarCellView) view : null;
        if (calendarCellView != null) {
            calendarCellView.setText(String.valueOf(cellIndex));
        }
    }

    @Override // com.devexpress.editors.pickers.providers.MonthViewProvider
    public void recycle(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.cache.add(view);
    }
}
