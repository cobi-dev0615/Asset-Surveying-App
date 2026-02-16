package com.devexpress.dxlistview.swipes;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.devexpress.dxlistview.core.DXSize;
import com.devexpress.dxlistview.helpers.MathHelper;
import com.devexpress.dxlistview.layouts.LayoutElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwipeItemsLayout.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 A2\u00020\u0001:\u0001AB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\nH\u0002J\u0018\u0010/\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0006\u00100\u001a\u00020\nH\u0004J\u0006\u00101\u001a\u00020+J\u0010\u00102\u001a\u0004\u0018\u00010\u001c2\u0006\u00103\u001a\u000204J\u0010\u00105\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0002J\u0010\u00106\u001a\u00020\n2\u0006\u00107\u001a\u000208H$J\u0010\u00109\u001a\u00020+2\u0006\u0010:\u001a\u000208H$J\u0010\u0010;\u001a\u00020+2\u0006\u0010:\u001a\u000208H$J\u0006\u0010<\u001a\u00020+J\u000e\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>J\u0018\u0010@\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\nH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R$\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/devexpress/dxlistview/swipes/SwipeItemsLayout;", "", "owner", "Landroid/view/ViewGroup;", "viewAdapter", "Lcom/devexpress/dxlistview/swipes/DXSwipeItemsViewAdapter;", "swipeGroup", "Lcom/devexpress/dxlistview/swipes/DXSwipeGroup;", "(Landroid/view/ViewGroup;Lcom/devexpress/dxlistview/swipes/DXSwipeItemsViewAdapter;Lcom/devexpress/dxlistview/swipes/DXSwipeGroup;)V", "_containerSize", "", "_defaultActionItemIndex", "_halfMediumItemSize", "_swipeItemsInfo", "Lcom/devexpress/dxlistview/swipes/SwipeItemsInfo;", "containerSize", "getContainerSize", "()I", "defaultActionItemIndex", "getDefaultActionItemIndex", "halfMediumItemSize", "getHalfMediumItemSize", "isSingleItem", "", "()Z", "isVertical", "layouts", "Landroid/util/SparseArray;", "Lcom/devexpress/dxlistview/layouts/LayoutElement;", "getLayouts", "()Landroid/util/SparseArray;", "getOwner", "()Landroid/view/ViewGroup;", "value", "", "scaleDefaultItemSizeProgress", "getScaleDefaultItemSizeProgress", "()F", "setScaleDefaultItemSizeProgress", "(F)V", "getSwipeGroup", "()Lcom/devexpress/dxlistview/swipes/DXSwipeGroup;", "addElement", "", "view", "Landroid/view/View;", "index", "calculateItemSize", "currentOffset", "clear", "findElementBy", "point", "Landroid/graphics/Point;", "getItemSize", "getSize", TypedValues.AttributesType.S_FRAME, "Landroid/graphics/Rect;", "layoutFromEndToStart", "viewPort", "layoutFromStartToEnd", "layoutSubviews", "measureSubviews", "Lcom/devexpress/dxlistview/core/DXSize;", "availableSize", "removeElement", "Companion", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SwipeItemsLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final float MAX_SCALE_DEFAULT_ITEM_SIZE = 1.0f;
    public static final float MIN_SCALE_DEFAULT_ITEM_SIZE = 0.0f;
    private int _containerSize;
    private int _defaultActionItemIndex;
    private int _halfMediumItemSize;
    private SwipeItemsInfo _swipeItemsInfo;
    private final SparseArray<LayoutElement> layouts;
    private final ViewGroup owner;
    private float scaleDefaultItemSizeProgress;
    private final DXSwipeGroup swipeGroup;
    private final DXSwipeItemsViewAdapter viewAdapter;

    protected abstract int getSize(Rect frame);

    public abstract boolean isVertical();

    protected abstract void layoutFromEndToStart(Rect viewPort);

    protected abstract void layoutFromStartToEnd(Rect viewPort);

    public SwipeItemsLayout(ViewGroup owner, DXSwipeItemsViewAdapter viewAdapter, DXSwipeGroup swipeGroup) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(viewAdapter, "viewAdapter");
        Intrinsics.checkNotNullParameter(swipeGroup, "swipeGroup");
        this.owner = owner;
        this.viewAdapter = viewAdapter;
        this.swipeGroup = swipeGroup;
        this.layouts = new SparseArray<>();
        SwipeItemsInfo swipeItemsInfo = viewAdapter.getSwipeItemsInfo(swipeGroup);
        this._swipeItemsInfo = swipeItemsInfo;
        if (swipeItemsInfo != null) {
            Intrinsics.checkNotNull(swipeItemsInfo);
            List<SwipeItemContainerView> views = swipeItemsInfo.getViews();
            int size = views.size();
            for (int i = 0; i < size; i++) {
                addElement(views.get(i), i);
                this._containerSize += getItemSize(i);
                this._halfMediumItemSize = (get_containerSize() / views.size()) / 2;
                this._defaultActionItemIndex = this.swipeGroup == DXSwipeGroup.Start ? 0 : views.size() - 1;
            }
        }
    }

    public final ViewGroup getOwner() {
        return this.owner;
    }

    /* compiled from: SwipeItemsLayout.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/devexpress/dxlistview/swipes/SwipeItemsLayout$Companion;", "", "()V", "MAX_SCALE_DEFAULT_ITEM_SIZE", "", "MIN_SCALE_DEFAULT_ITEM_SIZE", "create", "Lcom/devexpress/dxlistview/swipes/SwipeItemsLayout;", "owner", "Landroid/view/ViewGroup;", "viewAdapter", "Lcom/devexpress/dxlistview/swipes/DXSwipeItemsViewAdapter;", "swipeGroup", "Lcom/devexpress/dxlistview/swipes/DXSwipeGroup;", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SwipeItemsLayout create(ViewGroup owner, DXSwipeItemsViewAdapter viewAdapter, DXSwipeGroup swipeGroup) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(viewAdapter, "viewAdapter");
            Intrinsics.checkNotNullParameter(swipeGroup, "swipeGroup");
            return viewAdapter.getIsListViewVertical() ? new HorizontalSwipeItemsLayout(owner, viewAdapter, swipeGroup) : new VerticalSwipeItemsLayout(owner, viewAdapter, swipeGroup);
        }
    }

    public final DXSwipeGroup getSwipeGroup() {
        return this.swipeGroup;
    }

    public final SparseArray<LayoutElement> getLayouts() {
        return this.layouts;
    }

    /* renamed from: getContainerSize, reason: from getter */
    public final int get_containerSize() {
        return this._containerSize;
    }

    /* renamed from: getDefaultActionItemIndex, reason: from getter */
    public final int get_defaultActionItemIndex() {
        return this._defaultActionItemIndex;
    }

    /* renamed from: getHalfMediumItemSize, reason: from getter */
    public final int get_halfMediumItemSize() {
        return this._halfMediumItemSize;
    }

    public final float getScaleDefaultItemSizeProgress() {
        return this.scaleDefaultItemSizeProgress;
    }

    public final void setScaleDefaultItemSizeProgress(float f) {
        if (this.scaleDefaultItemSizeProgress == f) {
            return;
        }
        this.scaleDefaultItemSizeProgress = f;
        if (isSingleItem()) {
            SwipeItemsInfo swipeItemsInfo = this._swipeItemsInfo;
            Intrinsics.checkNotNull(swipeItemsInfo);
            swipeItemsInfo.getViews().get(get_defaultActionItemIndex()).setTranslationContentProgress(this.scaleDefaultItemSizeProgress);
            return;
        }
        this.owner.requestLayout();
    }

    private final boolean isSingleItem() {
        return this.layouts.size() == 1;
    }

    public final void clear() {
        while (this.layouts.size() > 0) {
            LayoutElement valueAt = this.layouts.valueAt(0);
            View view = valueAt.getView();
            Intrinsics.checkNotNullExpressionValue(view, "getView(...)");
            removeElement(view, valueAt.getIndex());
        }
        DXSwipeItemsViewAdapter dXSwipeItemsViewAdapter = this.viewAdapter;
        DXSwipeGroup dXSwipeGroup = this.swipeGroup;
        SwipeItemsInfo swipeItemsInfo = this._swipeItemsInfo;
        Intrinsics.checkNotNull(swipeItemsInfo);
        dXSwipeItemsViewAdapter.recycleViews(dXSwipeGroup, swipeItemsInfo.getViews());
    }

    public final LayoutElement findElementBy(Point point) {
        Intrinsics.checkNotNullParameter(point, "point");
        int size = this.layouts.size();
        for (int i = 0; i < size; i++) {
            LayoutElement valueAt = this.layouts.valueAt(i);
            if (valueAt.contains(point.x, point.y)) {
                return valueAt;
            }
        }
        return null;
    }

    public final DXSize measureSubviews(DXSize availableSize) {
        Intrinsics.checkNotNullParameter(availableSize, "availableSize");
        if (this.layouts.size() == 0) {
            return new DXSize(0, 0);
        }
        Rect rect = new Rect(0, 0, availableSize.width, availableSize.height);
        if (this.swipeGroup == DXSwipeGroup.Start) {
            layoutFromStartToEnd(rect);
        } else {
            layoutFromEndToStart(rect);
        }
        return availableSize;
    }

    public final void layoutSubviews() {
        int size = this.layouts.size();
        for (int i = 0; i < size; i++) {
            this.layouts.get(i).layout();
        }
    }

    protected final int calculateItemSize(int index, int currentOffset) {
        int itemSize = getItemSize(index);
        if (!this.viewAdapter.isFullSwipeAllowed(this.swipeGroup)) {
            return itemSize + (currentOffset > get_containerSize() ? (currentOffset - get_containerSize()) / this.layouts.size() : 0);
        }
        if (index == get_defaultActionItemIndex()) {
            if (!isSingleItem()) {
                float f = this.scaleDefaultItemSizeProgress;
                if (f >= 0.0f && f < 1.0f) {
                    int i = get_containerSize() - itemSize;
                    int round = MathHelper.round((currentOffset - itemSize) * this.scaleDefaultItemSizeProgress) + itemSize;
                    return round + Math.max(0, currentOffset - (i + round));
                }
                if (f == 1.0f) {
                    return currentOffset;
                }
            } else {
                return Math.max(currentOffset, itemSize);
            }
        }
        return itemSize;
    }

    private final void addElement(View view, int index) {
        this.layouts.put(index, new LayoutElement(view, index, 0, -1, -1));
        this.owner.addView(view);
    }

    private final void removeElement(View view, int index) {
        this.layouts.remove(index);
        this.owner.removeView(view);
    }

    private final int getItemSize(int index) {
        SwipeItemsInfo swipeItemsInfo = this._swipeItemsInfo;
        Intrinsics.checkNotNull(swipeItemsInfo);
        return swipeItemsInfo.getSizes().get(index).intValue();
    }
}
