package com.devexpress.dxlistview.swipes;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.devexpress.dxlistview.core.DXSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwipeItemsPanel.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0014J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0014R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/devexpress/dxlistview/swipes/SwipeItemsPanel;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "Lcom/devexpress/dxlistview/swipes/SwipeItemsLayout;", "containerLayout", "getContainerLayout", "()Lcom/devexpress/dxlistview/swipes/SwipeItemsLayout;", "setContainerLayout", "(Lcom/devexpress/dxlistview/swipes/SwipeItemsLayout;)V", "onLayout", "", "changed", "", "l", "", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SwipeItemsPanel extends ViewGroup {
    private SwipeItemsLayout containerLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeItemsPanel(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final SwipeItemsLayout getContainerLayout() {
        return this.containerLayout;
    }

    public final void setContainerLayout(SwipeItemsLayout swipeItemsLayout) {
        if (Intrinsics.areEqual(this.containerLayout, swipeItemsLayout)) {
            return;
        }
        this.containerLayout = swipeItemsLayout;
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        SwipeItemsLayout swipeItemsLayout = this.containerLayout;
        if (swipeItemsLayout != null) {
            Intrinsics.checkNotNull(swipeItemsLayout);
            DXSize measureSubviews = swipeItemsLayout.measureSubviews(new DXSize(size, size2));
            int i = measureSubviews.width;
            size2 = measureSubviews.height;
            size = i;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        SwipeItemsLayout swipeItemsLayout = this.containerLayout;
        if (swipeItemsLayout != null) {
            Intrinsics.checkNotNull(swipeItemsLayout);
            swipeItemsLayout.layoutSubviews();
        }
    }
}
