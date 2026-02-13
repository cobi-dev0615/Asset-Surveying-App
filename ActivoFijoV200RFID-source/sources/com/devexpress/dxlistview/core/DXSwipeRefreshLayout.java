package com.devexpress.dxlistview.core;

import android.content.Context;
import android.util.AttributeSet;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.devexpress.dxlistview.IVirtualScrollView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DXSwipeRefreshLayout.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/devexpress/dxlistview/core/DXSwipeRefreshLayout;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_scrollView", "Lcom/devexpress/dxlistview/IVirtualScrollView;", "initialize", "", "scrollView", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXSwipeRefreshLayout extends SwipeRefreshLayout {
    private IVirtualScrollView _scrollView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DXSwipeRefreshLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DXSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void initialize(IVirtualScrollView scrollView) {
        this._scrollView = scrollView;
        setEnabled(false);
        setProgressViewOffset(false, ((-getProgressCircleDiameter()) * 11) / 10, getProgressViewEndOffset());
        setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.devexpress.dxlistview.core.DXSwipeRefreshLayout$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                DXSwipeRefreshLayout.initialize$lambda$0(DXSwipeRefreshLayout.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$0(DXSwipeRefreshLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IVirtualScrollView iVirtualScrollView = this$0._scrollView;
        if (iVirtualScrollView != null) {
            iVirtualScrollView.startPullToRefresh();
        }
    }
}
