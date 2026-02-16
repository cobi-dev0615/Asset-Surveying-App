package com.devexpress.dxgrid.layout;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.devexpress.dxgrid.layout.GridRowsAdapter;
import com.devexpress.dxgrid.views.GridRowViewBase;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleViewCacheExtension.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ&\u0010\f\u001a\u0004\u0018\u00010\r2\n\u0010\u000e\u001a\u00060\u000fR\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/devexpress/dxgrid/layout/SimpleViewCacheExtension;", "Landroidx/recyclerview/widget/RecyclerView$ViewCacheExtension;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "scrap", "Landroid/util/SparseArray;", "Ljava/util/ArrayList;", "Lcom/devexpress/dxgrid/views/GridRowViewBase;", "Lkotlin/collections/ArrayList;", "clear", "", "getViewForPositionAndType", "Landroid/view/View;", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "position", "", "type", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SimpleViewCacheExtension extends RecyclerView.ViewCacheExtension {
    private final RecyclerView recyclerView;
    private final SparseArray<ArrayList<GridRowViewBase>> scrap;

    public SimpleViewCacheExtension(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
        this.scrap = new SparseArray<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ViewCacheExtension
    public View getViewForPositionAndType(RecyclerView.Recycler recycler, int position, int type) {
        Object obj;
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        if (this.scrap.indexOfKey(type) >= 0) {
            ArrayList<GridRowViewBase> arrayList = this.scrap.get(type);
            Intrinsics.checkNotNullExpressionValue(arrayList, "get(...)");
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((GridRowViewBase) obj).getRowIndex() == position) {
                    break;
                }
            }
            GridRowViewBase gridRowViewBase = (GridRowViewBase) obj;
            if (gridRowViewBase != null) {
                this.scrap.get(type).remove(gridRowViewBase);
                return gridRowViewBase;
            }
        }
        while (this.recyclerView.getRecycledViewPool().getRecycledViewCount(type) > 0) {
            RecyclerView.ViewHolder recycledView = this.recyclerView.getRecycledViewPool().getRecycledView(type);
            Intrinsics.checkNotNull(recycledView, "null cannot be cast to non-null type com.devexpress.dxgrid.layout.GridRowsAdapter.ViewHolder");
            GridRowsAdapter.ViewHolder viewHolder = (GridRowsAdapter.ViewHolder) recycledView;
            if (viewHolder.getRowView().getRowIndex() == position) {
                return viewHolder.getRowView();
            }
            if (this.scrap.indexOfKey(type) < 0) {
                this.scrap.append(type, new ArrayList<>());
            }
            this.scrap.get(type).add(viewHolder.getRowView());
        }
        return null;
    }

    public final void clear() {
        this.scrap.clear();
    }
}
