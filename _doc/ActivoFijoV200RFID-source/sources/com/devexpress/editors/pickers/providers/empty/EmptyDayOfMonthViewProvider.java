package com.devexpress.editors.pickers.providers.empty;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.devexpress.editors.pickers.CalendarCellView;
import com.devexpress.editors.pickers.InernalLinkedListExtensionKt;
import com.devexpress.editors.pickers.providers.DayOfMonthViewProvider;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmptyDayOfMonthViewProvider.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0007H\u0016J \u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J(\u0010\u0012\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/devexpress/editors/pickers/providers/empty/EmptyDayOfMonthViewProvider;", "Lcom/devexpress/editors/pickers/providers/DayOfMonthViewProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cache", "Ljava/util/LinkedList;", "Landroid/view/View;", "check", "", "view", "year", "", "month", "cellIndex", "recycle", "", "request", "update", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EmptyDayOfMonthViewProvider implements DayOfMonthViewProvider {
    private final LinkedList<View> cache;
    private final Context context;

    @Override // com.devexpress.editors.pickers.providers.DayOfMonthViewProvider
    public boolean check(View view, int year, int month, int cellIndex) {
        Intrinsics.checkNotNullParameter(view, "view");
        return true;
    }

    public EmptyDayOfMonthViewProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.cache = new LinkedList<>();
    }

    @Override // com.devexpress.editors.pickers.providers.DayOfMonthViewProvider
    public View request(int year, int month, int cellIndex) {
        View view = (View) InernalLinkedListExtensionKt.dxRemoveFirstOrNull(this.cache);
        if (view != null) {
            return view;
        }
        CalendarCellView calendarCellView = new CalendarCellView(this.context, null, 0, 6, null);
        update(calendarCellView, year, month, cellIndex);
        return calendarCellView;
    }

    @Override // com.devexpress.editors.pickers.providers.DayOfMonthViewProvider
    public void update(View view, int year, int month, int cellIndex) {
        Intrinsics.checkNotNullParameter(view, "view");
        CalendarCellView calendarCellView = view instanceof CalendarCellView ? (CalendarCellView) view : null;
        if (calendarCellView != null) {
            calendarCellView.setText(String.valueOf(cellIndex));
            calendarCellView.setMarkColor(0);
            if (cellIndex == 4) {
                calendarCellView.setMarkColor(InputDeviceCompat.SOURCE_ANY);
            }
            if (cellIndex == 6) {
                calendarCellView.setMarkColor(-3355444);
            }
        }
    }

    @Override // com.devexpress.editors.pickers.providers.DayOfMonthViewProvider
    public void recycle(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.cache.add(view);
    }
}
