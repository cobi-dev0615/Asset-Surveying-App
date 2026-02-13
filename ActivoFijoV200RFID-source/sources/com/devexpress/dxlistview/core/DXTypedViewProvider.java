package com.devexpress.dxlistview.core;

import android.view.View;

/* loaded from: classes2.dex */
public class DXTypedViewProvider {
    private final DXViewCache viewCache;

    public DXTypedViewProvider(DXViewCache dXViewCache) {
        this.viewCache = dXViewCache;
    }

    public View popViewFromCacheByViewType(int i) {
        return this.viewCache.getViewByType(i);
    }

    public void pushViewToCache(View view, int i) {
        this.viewCache.recycleView(view, i);
    }
}
