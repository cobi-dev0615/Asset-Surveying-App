package com.devexpress.dxgrid.utils.providers;

import com.devexpress.dxgrid.utils.ColumnInfo;
import kotlin.Metadata;
import kotlin.Pair;

/* compiled from: ColumnsProvider.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&J/\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&¢\u0006\u0002\u0010\u0014R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\u0015"}, d2 = {"Lcom/devexpress/dxgrid/utils/providers/ColumnsProvider;", "", "columnCount", "", "getColumnCount", "()I", "rowWidth", "getRowWidth", "rowsDefinitionsCount", "getRowsDefinitionsCount", "getColumn", "Lcom/devexpress/dxgrid/utils/ColumnInfo;", "i", "getHeights", "", "Lkotlin/Pair;", "cellHeights", "", "itemHeightProvider", "Lcom/devexpress/dxgrid/utils/providers/ItemHeightProvider;", "([ILcom/devexpress/dxgrid/utils/providers/ItemHeightProvider;)[Lkotlin/Pair;", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ColumnsProvider {
    ColumnInfo getColumn(int i);

    int getColumnCount();

    Pair<Integer, Integer>[] getHeights(int[] cellHeights, ItemHeightProvider itemHeightProvider);

    int getRowWidth();

    int getRowsDefinitionsCount();
}
