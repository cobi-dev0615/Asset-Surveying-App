package com.devexpress.dxgrid.providers;

import kotlin.Metadata;

/* compiled from: UpdateProvider.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/devexpress/dxgrid/providers/UpdateProvider;", "", "beginUpdate", "", "endUpdate", "isLocked", "", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface UpdateProvider {
    void beginUpdate();

    void endUpdate();

    boolean isLocked();
}
