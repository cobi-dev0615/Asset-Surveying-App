package com.devexpress.dxlistview.layouts;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.devexpress.dxlistview.helpers.MathHelper;

/* loaded from: classes2.dex */
public class ItemSizeProvider {
    private final int defaultAverageSize;
    private int minSize;
    private final SparseArray<ItemSizeRange> itemSizeRangesByViewType = new SparseArray<>();
    private final SparseArray<SparseIntArray> cacheByType = new SparseArray<>();
    private int totalSize = 0;

    public ItemSizeProvider(int i) {
        this.defaultAverageSize = i;
        this.minSize = i;
    }

    public void setItemSizeRangeByViewType(int i, ItemSizeRange itemSizeRange) {
        this.itemSizeRangesByViewType.put(i, itemSizeRange);
    }

    public int getMinSize() {
        return this.minSize;
    }

    public ItemSizeRange getItemSizeRangeByViewType(int i) {
        return this.itemSizeRangesByViewType.get(i);
    }

    public int getSizeBy(int i, int i2) {
        int tryGetSizeBy = tryGetSizeBy(i, i2);
        return tryGetSizeBy < 0 ? getDesiredSize(i2, getAverageSize()) : tryGetSizeBy;
    }

    private int tryGetSizeBy(int i, int i2) {
        return getOrAddCacheForType(i2).get(i, -1);
    }

    public void pushSize(int i, int i2, int i3) {
        if (i3 == -1) {
            return;
        }
        int tryGetSizeBy = tryGetSizeBy(i2, i3);
        if (tryGetSizeBy > 0) {
            this.totalSize -= tryGetSizeBy;
        }
        getOrAddCacheForType(i3).put(i2, i);
        this.minSize = Math.min(this.minSize, i);
        this.totalSize += i;
    }

    private SparseIntArray getOrAddCacheForType(int i) {
        SparseIntArray sparseIntArray = this.cacheByType.get(i);
        if (sparseIntArray != null) {
            return sparseIntArray;
        }
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        this.cacheByType.put(i, sparseIntArray2);
        return sparseIntArray2;
    }

    public void clear() {
        this.cacheByType.clear();
        this.totalSize = 0;
        this.minSize = this.defaultAverageSize;
    }

    public int getCount() {
        int i = 0;
        for (int i2 = 0; i2 < this.cacheByType.size(); i2++) {
            i += this.cacheByType.valueAt(i2).size();
        }
        return i;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public int getDesiredSize(int i, int i2) {
        ItemSizeRange itemSizeRange = this.itemSizeRangesByViewType.get(i);
        if (itemSizeRange == null) {
            return i2;
        }
        if (itemSizeRange.maxValue >= 0) {
            i2 = Math.min(i2, itemSizeRange.maxValue);
        }
        return Math.max(i2, itemSizeRange.minValue);
    }

    public int getAverageSize() {
        int count = getCount();
        return count > 0 ? MathHelper.round((this.totalSize * 1.0f) / count) : this.defaultAverageSize;
    }
}
