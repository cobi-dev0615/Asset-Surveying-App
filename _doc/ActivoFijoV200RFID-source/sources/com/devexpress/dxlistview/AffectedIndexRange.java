package com.devexpress.dxlistview;

import android.util.SparseIntArray;
import kotlin.Metadata;

/* compiled from: AffectedIndexRange.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/devexpress/dxlistview/AffectedIndexRange;", "", "anchorIndex", "", "(I)V", "end", "getEnd", "()I", "indexes", "Landroid/util/SparseIntArray;", "size", "getSize", "start", "getStart", "affect", "", "newAffectedIndex", "clear", "isAffected", "", "value", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AffectedIndexRange {
    private final int anchorIndex;
    private final SparseIntArray indexes = new SparseIntArray();

    public AffectedIndexRange(int i) {
        this.anchorIndex = i;
    }

    public final int getStart() {
        if (this.indexes.size() == 0) {
            return Integer.MAX_VALUE;
        }
        int valueAt = this.indexes.valueAt(0);
        int i = this.anchorIndex;
        return valueAt > i ? i + 1 : valueAt;
    }

    public final int getEnd() {
        if (this.indexes.size() == 0) {
            return Integer.MIN_VALUE;
        }
        int valueAt = this.indexes.valueAt(r0.size() - 1);
        int i = this.anchorIndex;
        return valueAt < i ? i - 1 : valueAt;
    }

    public final boolean isAffected(int value) {
        return value <= getEnd() && getStart() <= value;
    }

    public final int getSize() {
        return this.indexes.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0056, code lost:
    
        if (r1 < r4) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void affect(int r4) {
        /*
            r3 = this;
            int r0 = r3.anchorIndex
            if (r4 != r0) goto L5
            return
        L5:
            android.util.SparseIntArray r0 = r3.indexes
            int r0 = r0.size()
            if (r0 != 0) goto L13
            android.util.SparseIntArray r0 = r3.indexes
            r0.put(r4, r4)
            return
        L13:
            boolean r0 = r3.isAffected(r4)
            if (r0 == 0) goto L3f
            int r0 = r3.anchorIndex
            if (r4 >= r0) goto L2e
            int r0 = r3.getStart()
            if (r0 > r4) goto L2d
        L23:
            android.util.SparseIntArray r1 = r3.indexes
            r1.delete(r0)
            if (r0 == r4) goto L2d
            int r0 = r0 + 1
            goto L23
        L2d:
            return
        L2e:
            int r0 = r3.getEnd()
            if (r4 > r0) goto L3e
        L34:
            android.util.SparseIntArray r1 = r3.indexes
            r1.delete(r4)
            if (r4 == r0) goto L3e
            int r4 = r4 + 1
            goto L34
        L3e:
            return
        L3f:
            int r0 = r4 + 1
            int r1 = r3.getStart()
            int r2 = r3.anchorIndex
            if (r0 > r2) goto L4c
            if (r2 >= r1) goto L4c
            goto L58
        L4c:
            int r0 = r3.getStart()
            int r0 = r0 + 1
            int r1 = r3.anchorIndex
            if (r0 > r1) goto L5b
            if (r1 >= r4) goto L5b
        L58:
            r3.clear()
        L5b:
            android.util.SparseIntArray r0 = r3.indexes
            r0.put(r4, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.dxlistview.AffectedIndexRange.affect(int):void");
    }

    public final void clear() {
        this.indexes.clear();
    }
}
