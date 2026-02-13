package com.devexpress.dxlistview.swipes;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.dxlistview.layouts.LayoutElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HorizontalSwipeItemsLayout.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0014J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0014R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/devexpress/dxlistview/swipes/HorizontalSwipeItemsLayout;", "Lcom/devexpress/dxlistview/swipes/SwipeItemsLayout;", "owner", "Landroid/view/ViewGroup;", "viewAdapter", "Lcom/devexpress/dxlistview/swipes/DXSwipeItemsViewAdapter;", "swipeGroup", "Lcom/devexpress/dxlistview/swipes/DXSwipeGroup;", "(Landroid/view/ViewGroup;Lcom/devexpress/dxlistview/swipes/DXSwipeItemsViewAdapter;Lcom/devexpress/dxlistview/swipes/DXSwipeGroup;)V", "isVertical", "", "()Z", "getSize", "", TypedValues.AttributesType.S_FRAME, "Landroid/graphics/Rect;", "layoutFromEndToStart", "", "viewPort", "layoutFromStartToEnd", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HorizontalSwipeItemsLayout extends SwipeItemsLayout {
    @Override // com.devexpress.dxlistview.swipes.SwipeItemsLayout
    public boolean isVertical() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalSwipeItemsLayout(ViewGroup owner, DXSwipeItemsViewAdapter viewAdapter, DXSwipeGroup swipeGroup) {
        super(owner, viewAdapter, swipeGroup);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(viewAdapter, "viewAdapter");
        Intrinsics.checkNotNullParameter(swipeGroup, "swipeGroup");
    }

    @Override // com.devexpress.dxlistview.swipes.SwipeItemsLayout
    protected void layoutFromStartToEnd(Rect viewPort) {
        Intrinsics.checkNotNullParameter(viewPort, "viewPort");
        int i = viewPort.left;
        int width = viewPort.width();
        int size = getLayouts().size();
        for (int i2 = 0; i2 < size; i2++) {
            LayoutElement layoutElement = getLayouts().get(i2);
            layoutElement.measure(View.MeasureSpec.makeMeasureSpec(calculateItemSize(i2, width), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(viewPort.height(), 0));
            layoutElement.setBounds(i, viewPort.top, layoutElement.getDesiredWidth() + i, viewPort.bottom);
            i += layoutElement.getDesiredWidth();
        }
    }

    @Override // com.devexpress.dxlistview.swipes.SwipeItemsLayout
    protected void layoutFromEndToStart(Rect viewPort) {
        Intrinsics.checkNotNullParameter(viewPort, "viewPort");
        int width = viewPort.width();
        int i = width;
        for (int size = getLayouts().size() - 1; -1 < size; size--) {
            LayoutElement layoutElement = getLayouts().get(size);
            layoutElement.measure(View.MeasureSpec.makeMeasureSpec(calculateItemSize(size, width), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(viewPort.height(), 0));
            layoutElement.setBounds(i - layoutElement.getDesiredWidth(), viewPort.top, i, viewPort.bottom);
            i -= layoutElement.getDesiredWidth();
        }
    }

    @Override // com.devexpress.dxlistview.swipes.SwipeItemsLayout
    protected int getSize(Rect frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        return frame.width();
    }
}
