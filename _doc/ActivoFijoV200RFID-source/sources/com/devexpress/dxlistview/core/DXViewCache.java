package com.devexpress.dxlistview.core;

import android.util.SparseArray;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class DXViewCache {
    private final SparseArray<ArrayList<View>> cacheByTypeID = new SparseArray<>();

    public ArrayList<View> getViewsForTypeId(int i) {
        return this.cacheByTypeID.get(i);
    }

    public void recycleView(View view, int i) {
        ArrayList<View> viewsForTypeId = getViewsForTypeId(i);
        if (viewsForTypeId == null) {
            viewsForTypeId = new ArrayList<>();
            this.cacheByTypeID.put(i, viewsForTypeId);
        }
        viewsForTypeId.add(view);
    }

    public View getViewByType(int i) {
        ArrayList<View> viewsForTypeId = getViewsForTypeId(i);
        if (viewsForTypeId == null || viewsForTypeId.size() <= 0) {
            return null;
        }
        View view = viewsForTypeId.get(viewsForTypeId.size() - 1);
        viewsForTypeId.remove(view);
        return view;
    }

    public int getTotalViewsInCache() {
        int i = 0;
        for (int i2 = 0; i2 < this.cacheByTypeID.size(); i2++) {
            i += getViewsForTypeId(this.cacheByTypeID.keyAt(i2)).size();
        }
        return i;
    }
}
