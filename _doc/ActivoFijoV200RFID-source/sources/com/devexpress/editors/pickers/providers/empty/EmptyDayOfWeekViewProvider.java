package com.devexpress.editors.pickers.providers.empty;

import android.content.Context;
import android.view.View;
import com.devexpress.editors.pickers.InernalLinkedListExtensionKt;
import com.devexpress.editors.pickers.providers.DayOfWeekViewProvider;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmptyDayOfWeekViewProvider.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/devexpress/editors/pickers/providers/empty/EmptyDayOfWeekViewProvider;", "Lcom/devexpress/editors/pickers/providers/DayOfWeekViewProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cache", "Ljava/util/LinkedList;", "Landroid/view/View;", "check", "", "view", "cellIndex", "", "recycle", "", "request", "update", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EmptyDayOfWeekViewProvider implements DayOfWeekViewProvider {
    private final LinkedList<View> cache;
    private final Context context;

    @Override // com.devexpress.editors.pickers.providers.DayOfWeekViewProvider
    public boolean check(View view, int cellIndex) {
        Intrinsics.checkNotNullParameter(view, "view");
        return true;
    }

    @Override // com.devexpress.editors.pickers.providers.DayOfWeekViewProvider
    public void update(View view, int cellIndex) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public EmptyDayOfWeekViewProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.cache = new LinkedList<>();
    }

    @Override // com.devexpress.editors.pickers.providers.DayOfWeekViewProvider
    public View request(int cellIndex) {
        View view = (View) InernalLinkedListExtensionKt.dxRemoveFirstOrNull(this.cache);
        return view == null ? new View(this.context) : view;
    }

    @Override // com.devexpress.editors.pickers.providers.DayOfWeekViewProvider
    public void recycle(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.cache.add(view);
    }
}
