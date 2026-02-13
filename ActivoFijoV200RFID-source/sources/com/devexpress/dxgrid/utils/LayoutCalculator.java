package com.devexpress.dxgrid.utils;

import com.devexpress.dxgrid.utils.providers.ColumnsProvider;
import com.devexpress.dxgrid.utils.providers.ItemHeightProvider;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutCalculator.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/devexpress/dxgrid/utils/LayoutCalculator;", "", "()V", "Companion", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LayoutCalculator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: LayoutCalculator.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/devexpress/dxgrid/utils/LayoutCalculator$Companion;", "", "()V", "calculate", "", "Lcom/devexpress/dxgrid/utils/LayoutInfo;", "heights", "", "columnsProvider", "Lcom/devexpress/dxgrid/utils/providers/ColumnsProvider;", "itemHeightProvider", "Lcom/devexpress/dxgrid/utils/providers/ItemHeightProvider;", "([ILcom/devexpress/dxgrid/utils/providers/ColumnsProvider;Lcom/devexpress/dxgrid/utils/providers/ItemHeightProvider;)[Lcom/devexpress/dxgrid/utils/LayoutInfo;", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LayoutInfo[] calculate(int[] heights, ColumnsProvider columnsProvider, ItemHeightProvider itemHeightProvider) {
            Intrinsics.checkNotNullParameter(heights, "heights");
            Intrinsics.checkNotNullParameter(columnsProvider, "columnsProvider");
            Intrinsics.checkNotNullParameter(itemHeightProvider, "itemHeightProvider");
            Pair<Integer, Integer>[] heights2 = columnsProvider.getHeights(heights, itemHeightProvider);
            ArrayList arrayList = new ArrayList();
            int columnCount = columnsProvider.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                ColumnInfo column = columnsProvider.getColumn(i);
                column.getWidth();
                arrayList.add(new LayoutInfo(column.getLeft(), heights2[i].getFirst().intValue(), column.getRight(), heights2[i].getSecond().intValue()));
            }
            return (LayoutInfo[]) arrayList.toArray(new LayoutInfo[0]);
        }
    }
}
