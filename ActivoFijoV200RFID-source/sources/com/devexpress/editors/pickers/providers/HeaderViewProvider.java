package com.devexpress.editors.pickers.providers;

import android.view.View;
import com.devexpress.editors.pickers.CalendarViewStates;
import kotlin.Metadata;

/* compiled from: HeaderViewProvider.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J0\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u0010"}, d2 = {"Lcom/devexpress/editors/pickers/providers/HeaderViewProvider;", "", "check", "", "view", "Landroid/view/View;", "decade", "", "year", "month", "states", "Lcom/devexpress/editors/pickers/CalendarViewStates;", "recycle", "", "request", "update", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface HeaderViewProvider {
    boolean check(View view, int decade, int year, int month, CalendarViewStates states);

    void recycle(View view, CalendarViewStates states);

    View request(int decade, int year, int month, CalendarViewStates states);

    void update(View view, int decade, int year, int month, CalendarViewStates states);
}
