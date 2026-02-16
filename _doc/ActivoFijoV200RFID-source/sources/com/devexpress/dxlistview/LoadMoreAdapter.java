package com.devexpress.dxlistview;

import android.content.Context;
import android.view.View;
import com.devexpress.dxlistview.core.DXItemViewProvider;
import com.devexpress.dxlistview.views.LoadMoreItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoadMoreAdapter.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\b\u0010 \u001a\u00020!H\u0016J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020\bJ\u0006\u0010$\u001a\u00020!J\b\u0010%\u001a\u00020!H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/devexpress/dxlistview/LoadMoreAdapter;", "Lcom/devexpress/dxlistview/core/DXItemViewProvider;", "context", "Landroid/content/Context;", "actionProvider", "Lcom/devexpress/dxlistview/LoadMoreActionProvider;", "(Landroid/content/Context;Lcom/devexpress/dxlistview/LoadMoreActionProvider;)V", "areMoreItemsLoaded", "", "canViewVisibleInLayout", "getCanViewVisibleInLayout", "()Z", "enabled", "getEnabled", "setEnabled", "(Z)V", "value", "", "indicatorColor", "getIndicatorColor", "()I", "setIndicatorColor", "(I)V", "<set-?>", "isBusy", "itemsCount", "view", "Lcom/devexpress/dxlistview/views/LoadMoreItemView;", "getItemCount", "getView", "Landroid/view/View;", "getViewType", "recycleView", "", "refresh", "startLoadMore", "stopLoadMore", "updateView", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class LoadMoreAdapter implements DXItemViewProvider {
    private final LoadMoreActionProvider actionProvider;
    private boolean areMoreItemsLoaded;
    private boolean enabled;
    private int indicatorColor;
    private boolean isBusy;
    private int itemsCount;
    private final LoadMoreItemView view;

    @Override // com.devexpress.dxlistview.core.DXItemViewProvider
    public int getViewType() {
        return -1;
    }

    @Override // com.devexpress.dxlistview.core.DXItemViewProvider
    public void recycleView() {
    }

    public LoadMoreAdapter(Context context, LoadMoreActionProvider actionProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionProvider, "actionProvider");
        this.actionProvider = actionProvider;
        this.view = new LoadMoreItemView(context);
        this.areMoreItemsLoaded = true;
        this.itemsCount = -1;
    }

    private final boolean getCanViewVisibleInLayout() {
        return this.enabled && this.areMoreItemsLoaded && this.actionProvider.canLoadMore();
    }

    /* renamed from: isBusy, reason: from getter */
    public final boolean getIsBusy() {
        return this.isBusy;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final int getIndicatorColor() {
        return this.indicatorColor;
    }

    public final void setIndicatorColor(int i) {
        this.indicatorColor = i;
        this.view.setIndicatorColor(i);
    }

    public final boolean startLoadMore() {
        if (this.isBusy) {
            return false;
        }
        this.itemsCount = this.actionProvider.getItemsCount();
        this.isBusy = true;
        return true;
    }

    public final void stopLoadMore() {
        if (this.isBusy) {
            this.isBusy = false;
            this.areMoreItemsLoaded = this.itemsCount != this.actionProvider.getItemsCount();
        } else {
            refresh();
        }
    }

    public final void refresh() {
        if (this.isBusy) {
            return;
        }
        this.itemsCount = -1;
        this.areMoreItemsLoaded = true;
    }

    @Override // com.devexpress.dxlistview.core.DXItemViewProvider
    public int getItemCount() {
        return getCanViewVisibleInLayout() ? 1 : 0;
    }

    @Override // com.devexpress.dxlistview.core.DXItemViewProvider
    public View getView() {
        return this.view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$0(LoadMoreAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.actionProvider.startLoadMore();
    }

    @Override // com.devexpress.dxlistview.core.DXItemViewProvider
    public void updateView() {
        this.view.post(new Runnable() { // from class: com.devexpress.dxlistview.LoadMoreAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LoadMoreAdapter.updateView$lambda$0(LoadMoreAdapter.this);
            }
        });
    }
}
