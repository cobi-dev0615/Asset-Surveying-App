package com.devexpress.dxgrid.views;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GridRecyclerViewScrollListener.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/devexpress/dxgrid/views/GridRecyclerViewScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateListener", "Lcom/devexpress/dxgrid/views/GridRecyclerViewScrollListener$OnScrollStateListener;", "(Lcom/devexpress/dxgrid/views/GridRecyclerViewScrollListener$OnScrollStateListener;)V", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "OnScrollStateListener", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GridRecyclerViewScrollListener extends RecyclerView.OnScrollListener {
    private final OnScrollStateListener onScrollStateListener;

    /* compiled from: GridRecyclerViewScrollListener.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/devexpress/dxgrid/views/GridRecyclerViewScrollListener$OnScrollStateListener;", "", "onScrolled", "", "dx", "", "dy", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnScrollStateListener {
        void onScrolled(int dx, int dy);
    }

    public GridRecyclerViewScrollListener(OnScrollStateListener onScrollStateListener) {
        Intrinsics.checkNotNullParameter(onScrollStateListener, "onScrollStateListener");
        this.onScrollStateListener = onScrollStateListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        this.onScrollStateListener.onScrolled(dx, dy);
    }
}
