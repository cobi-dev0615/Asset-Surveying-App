package com.devexpress.dxgrid.utils.providers;

import kotlin.Metadata;

/* compiled from: ItemHeightProvider.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/devexpress/dxgrid/utils/providers/ItemHeightProvider;", "", "isFixedHeight", "", "()Z", "getDefaultHeight", "", "getFixedHeight", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ItemHeightProvider {
    int getDefaultHeight();

    int getFixedHeight();

    boolean isFixedHeight();
}
