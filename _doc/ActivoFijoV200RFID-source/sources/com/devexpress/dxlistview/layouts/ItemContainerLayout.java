package com.devexpress.dxlistview.layouts;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.dxlistview.core.DXSize;
import com.devexpress.dxlistview.swipes.DXSwipeGroup;
import com.devexpress.dxlistview.swipes.SwipeItemsLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ItemContainerLayout.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\bJ\u000e\u0010-\u001a\u00020*2\u0006\u0010&\u001a\u00020\nJ\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\bJ\u0010\u00102\u001a\u00020*2\u0006\u0010,\u001a\u00020\bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR(\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u0013\u001a\u0004\u0018\u00010 @FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u00063"}, d2 = {"Lcom/devexpress/dxlistview/layouts/ItemContainerLayout;", "", "owner", "Landroid/view/ViewGroup;", "itemView", "Landroid/view/View;", "(Landroid/view/ViewGroup;Landroid/view/View;)V", "_contentOffset", "", "_prevViewport", "Landroid/graphics/Rect;", "_swipeItemsPanel", "autoActionTargetOffset", "getAutoActionTargetOffset", "()I", "contentElement", "Lcom/devexpress/dxlistview/layouts/LayoutElement;", "getContentElement", "()Lcom/devexpress/dxlistview/layouts/LayoutElement;", "value", "contentOffset", "getContentOffset", "setContentOffset", "(I)V", "expandItemTargetOffset", "getExpandItemTargetOffset", "getItemView", "()Landroid/view/View;", "minimizedOpenStateTargetOffset", "getMinimizedOpenStateTargetOffset", "getOwner", "()Landroid/view/ViewGroup;", "Lcom/devexpress/dxlistview/swipes/SwipeItemsLayout;", "swipeItemsLayout", "getSwipeItemsLayout", "()Lcom/devexpress/dxlistview/swipes/SwipeItemsLayout;", "setSwipeItemsLayout", "(Lcom/devexpress/dxlistview/swipes/SwipeItemsLayout;)V", "viewport", "getViewport", "()Landroid/graphics/Rect;", "clear", "", "forceSetContentOffset", TypedValues.CycleType.S_WAVE_OFFSET, "layoutSubviews", "measure", "Lcom/devexpress/dxlistview/core/DXSize;", "widthMeasureSpec", "heightMeasureSpec", "updateContentOffset", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ItemContainerLayout {
    private int _contentOffset;
    private Rect _prevViewport;
    private View _swipeItemsPanel;
    private final LayoutElement contentElement;
    private final View itemView;
    private final ViewGroup owner;
    private SwipeItemsLayout swipeItemsLayout;

    public ItemContainerLayout(ViewGroup owner, View itemView) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.owner = owner;
        this.itemView = itemView;
        this._prevViewport = new Rect();
        this.contentElement = new LayoutElement(itemView, 0, 0, -1, -1);
    }

    public final View getItemView() {
        return this.itemView;
    }

    public final ViewGroup getOwner() {
        return this.owner;
    }

    public final LayoutElement getContentElement() {
        return this.contentElement;
    }

    /* renamed from: getViewport, reason: from getter */
    public final Rect get_prevViewport() {
        return this._prevViewport;
    }

    public final SwipeItemsLayout getSwipeItemsLayout() {
        return this.swipeItemsLayout;
    }

    public final void setSwipeItemsLayout(SwipeItemsLayout swipeItemsLayout) {
        if (Intrinsics.areEqual(this.swipeItemsLayout, swipeItemsLayout)) {
            return;
        }
        this.swipeItemsLayout = swipeItemsLayout;
        if (swipeItemsLayout != null) {
            Intrinsics.checkNotNull(swipeItemsLayout);
            ViewGroup owner = swipeItemsLayout.getOwner();
            this._swipeItemsPanel = owner;
            this.owner.addView(owner);
            this.itemView.bringToFront();
            this.owner.requestLayout();
        }
    }

    /* renamed from: getContentOffset, reason: from getter */
    public final int get_contentOffset() {
        return this._contentOffset;
    }

    public final void setContentOffset(int i) {
        updateContentOffset(i);
        this.owner.requestLayout();
    }

    public final int getAutoActionTargetOffset() {
        SwipeItemsLayout swipeItemsLayout = this.swipeItemsLayout;
        Intrinsics.checkNotNull(swipeItemsLayout);
        int width = !swipeItemsLayout.isVertical() ? get_prevViewport().width() : get_prevViewport().height();
        SwipeItemsLayout swipeItemsLayout2 = this.swipeItemsLayout;
        Intrinsics.checkNotNull(swipeItemsLayout2);
        return Math.min(Math.max(width / 2, (swipeItemsLayout2.get_containerSize() * 11) / 10), (width * 9) / 10);
    }

    public final int getExpandItemTargetOffset() {
        SwipeItemsLayout swipeItemsLayout = this.swipeItemsLayout;
        Intrinsics.checkNotNull(swipeItemsLayout);
        return swipeItemsLayout.get_containerSize();
    }

    public final int getMinimizedOpenStateTargetOffset() {
        SwipeItemsLayout swipeItemsLayout = this.swipeItemsLayout;
        Intrinsics.checkNotNull(swipeItemsLayout);
        int i = swipeItemsLayout.get_containerSize();
        SwipeItemsLayout swipeItemsLayout2 = this.swipeItemsLayout;
        Intrinsics.checkNotNull(swipeItemsLayout2);
        return i - swipeItemsLayout2.get_halfMediumItemSize();
    }

    public final void forceSetContentOffset(int offset) {
        updateContentOffset(offset);
    }

    public final DXSize measure(int widthMeasureSpec, int heightMeasureSpec) {
        DXSize dXSize;
        this.itemView.measure(widthMeasureSpec, heightMeasureSpec);
        DXSize dXSize2 = new DXSize(this.itemView.getMeasuredWidth(), this.itemView.getMeasuredHeight());
        SwipeItemsLayout swipeItemsLayout = this.swipeItemsLayout;
        if (swipeItemsLayout != null) {
            Intrinsics.checkNotNull(swipeItemsLayout);
            if (swipeItemsLayout.isVertical()) {
                dXSize = new DXSize(dXSize2.width, Math.abs(get_contentOffset()));
            } else {
                dXSize = new DXSize(Math.abs(get_contentOffset()), dXSize2.height);
            }
            View view = this._swipeItemsPanel;
            Intrinsics.checkNotNull(view);
            view.measure(View.MeasureSpec.makeMeasureSpec(dXSize.width, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(dXSize.height, BasicMeasure.EXACTLY));
        }
        return dXSize2;
    }

    public final void layoutSubviews(Rect viewport) {
        Rect rect;
        Intrinsics.checkNotNullParameter(viewport, "viewport");
        this._prevViewport = viewport;
        this.contentElement.layout(viewport.left, viewport.top, viewport.right, viewport.bottom, true);
        SwipeItemsLayout swipeItemsLayout = this.swipeItemsLayout;
        if (swipeItemsLayout != null) {
            Intrinsics.checkNotNull(swipeItemsLayout);
            if (swipeItemsLayout.isVertical()) {
                SwipeItemsLayout swipeItemsLayout2 = this.swipeItemsLayout;
                Intrinsics.checkNotNull(swipeItemsLayout2);
                if (swipeItemsLayout2.getSwipeGroup() == DXSwipeGroup.Start) {
                    rect = new Rect(0, 0, viewport.width(), Math.abs(get_contentOffset()));
                } else {
                    rect = new Rect(0, viewport.height() - Math.abs(get_contentOffset()), viewport.width(), viewport.height());
                }
            } else {
                SwipeItemsLayout swipeItemsLayout3 = this.swipeItemsLayout;
                Intrinsics.checkNotNull(swipeItemsLayout3);
                if (swipeItemsLayout3.getSwipeGroup() == DXSwipeGroup.Start) {
                    rect = new Rect(0, 0, Math.abs(get_contentOffset()), viewport.height());
                } else {
                    rect = new Rect(viewport.width() - Math.abs(get_contentOffset()), 0, viewport.width(), viewport.height());
                }
            }
            View view = this._swipeItemsPanel;
            Intrinsics.checkNotNull(view);
            view.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public final void clear() {
        SwipeItemsLayout swipeItemsLayout = this.swipeItemsLayout;
        if (swipeItemsLayout != null) {
            Intrinsics.checkNotNull(swipeItemsLayout);
            swipeItemsLayout.clear();
            this.owner.removeView(this._swipeItemsPanel);
            setSwipeItemsLayout(null);
            this._swipeItemsPanel = null;
        }
        this.contentElement.getView().setTranslationX(0.0f);
        this.contentElement.getView().setTranslationY(0.0f);
    }

    private final void updateContentOffset(int offset) {
        if (this._contentOffset == offset) {
            return;
        }
        this._contentOffset = offset;
        SwipeItemsLayout swipeItemsLayout = this.swipeItemsLayout;
        Intrinsics.checkNotNull(swipeItemsLayout);
        if (swipeItemsLayout.isVertical()) {
            this.contentElement.getView().setTranslationX(0.0f);
            this.contentElement.getView().setTranslationY(this._contentOffset);
        } else {
            this.contentElement.getView().setTranslationX(this._contentOffset);
            this.contentElement.getView().setTranslationY(0.0f);
        }
    }
}
