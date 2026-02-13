package com.devexpress.editors.pickers.providers.empty;

import android.content.Context;
import android.view.View;
import com.devexpress.editors.pickers.CalendarViewStates;
import com.devexpress.editors.pickers.providers.HeaderViewProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmptyHeaderViewProvider.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J(\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J0\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/devexpress/editors/pickers/providers/empty/EmptyHeaderViewProvider;", "Lcom/devexpress/editors/pickers/providers/HeaderViewProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "view", "Landroid/view/View;", "check", "", "decade", "", "year", "month", "states", "Lcom/devexpress/editors/pickers/CalendarViewStates;", "recycle", "", "request", "update", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EmptyHeaderViewProvider implements HeaderViewProvider {
    private final View view;

    @Override // com.devexpress.editors.pickers.providers.HeaderViewProvider
    public boolean check(View view, int decade, int year, int month, CalendarViewStates states) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(states, "states");
        return false;
    }

    @Override // com.devexpress.editors.pickers.providers.HeaderViewProvider
    public void recycle(View view, CalendarViewStates states) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(states, "states");
    }

    @Override // com.devexpress.editors.pickers.providers.HeaderViewProvider
    public void update(View view, int decade, int year, int month, CalendarViewStates states) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(states, "states");
    }

    public EmptyHeaderViewProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.view = new View(context);
    }

    @Override // com.devexpress.editors.pickers.providers.HeaderViewProvider
    public View request(int decade, int year, int month, CalendarViewStates states) {
        Intrinsics.checkNotNullParameter(states, "states");
        return this.view;
    }
}
