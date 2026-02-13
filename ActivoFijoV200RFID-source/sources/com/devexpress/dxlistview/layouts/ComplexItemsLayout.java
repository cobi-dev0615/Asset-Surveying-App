package com.devexpress.dxlistview.layouts;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.dxlistview.IAppearanceOwner;
import com.devexpress.dxlistview.IVirtualScrollLayoutOwner;
import com.devexpress.dxlistview.core.DXAsyncViewAdapter;
import com.devexpress.dxlistview.core.DXSize;
import com.devexpress.dxlistview.core.ItemsViewAdapterListener;
import com.devexpress.dxlistview.swipes.RecycleListener;

/* loaded from: classes2.dex */
public abstract class ComplexItemsLayout implements ItemsViewAdapterListener {
    private DXAsyncViewAdapter adapter;
    private int additionalAreaSizeFromEnd;
    private int additionalAreaSizeFromStart;
    private IAppearanceOwner appearanceOwner;
    private boolean forceRemoveAllContainers;
    public boolean isUpdateLocked;
    private int lastOffset;
    private LayoutAnchor layoutAnchor;
    private IVirtualScrollLayoutOwner owner;
    private RecycleListener recycleListener;
    protected int[] spanSizes;
    private int spanCount = 1;
    private boolean shouldLayoutFromStartToEnd = true;
    private boolean allowCalculateLayoutDirection = true;
    private final SparseArray<LayoutSpanContainer> layouts = new SparseArray<>();
    private final SparseArray<LayoutElement> updatedLayoutsByIndex = new SparseArray<>();
    private final ItemSizeProvider itemSizeProvider = new ItemSizeProvider(100);
    private final SparseArray<LayoutSpanContainer> tempLayouts = new SparseArray<>();
    public final Rect currentViewport = new Rect();
    protected final Rect tempViewport = new Rect();
    private int itemSpacing = 0;
    private int spanSpacing = 0;
    private Boolean allowFixedGroupHeaders = false;
    private LayoutSpanContainer fixedGroupHeader = null;
    private boolean isForceSyncLayoutRequested = true;
    public final DXSize extentSize = new DXSize(0, 0);

    protected abstract Point calcContentOffsetCorrection(int i);

    protected abstract LayoutElement createElementByIndex(int i, int i2, int i3, int i4);

    protected abstract int getDesiredSize(LayoutElement layoutElement);

    protected abstract int getEndBound(Rect rect);

    protected abstract int getKnownSize(Rect rect);

    public abstract int getMeasureHeight(int i, int i2);

    public abstract int getMeasureWidth(int i, int i2);

    protected abstract int getSize(Rect rect);

    protected abstract int getStartBound(Rect rect);

    protected abstract void layoutElement(LayoutElement layoutElement, int i, int i2, int i3, int i4, boolean z);

    protected abstract int measureElement(LayoutElement layoutElement, int i);

    protected abstract int obtainExtentSize();

    protected abstract void resetExtentSize(Rect rect);

    protected abstract void updateExtentSize(int i, int i2, int i3, Rect rect);

    protected ComplexItemsLayout() {
    }

    public int getSpanCount() {
        return this.spanCount;
    }

    public void setSpanCount(int i) {
        this.spanCount = i;
        this.spanSizes = calculateSpanSizes(this.tempViewport);
    }

    public LayoutSpanContainer getFirstVisibleContainer() {
        if (this.layouts.size() == 0) {
            return null;
        }
        return this.layouts.valueAt(0);
    }

    public LayoutSpanContainer getLastVisibleContainer() {
        if (this.layouts.size() == 0) {
            return null;
        }
        return this.layouts.valueAt(r0.size() - 1);
    }

    public LayoutElement getFirstVisibleItem() {
        LayoutSpanContainer firstVisibleContainer = getFirstVisibleContainer();
        if (firstVisibleContainer == null) {
            return null;
        }
        return firstVisibleContainer.getFirstElement();
    }

    public LayoutElement getLastVisibleItem() {
        LayoutSpanContainer lastVisibleContainer = getLastVisibleContainer();
        if (lastVisibleContainer == null) {
            return null;
        }
        return lastVisibleContainer.getLastElement();
    }

    public boolean getIsForceSyncLayoutRequested() {
        return this.isForceSyncLayoutRequested;
    }

    public IVirtualScrollLayoutOwner getOwner() {
        return this.owner;
    }

    public void setOwner(IVirtualScrollLayoutOwner iVirtualScrollLayoutOwner) {
        this.owner = iVirtualScrollLayoutOwner;
        requestLayout();
    }

    public void setAppearanceOwner(IAppearanceOwner iAppearanceOwner) {
        this.appearanceOwner = iAppearanceOwner;
        requestLayout();
    }

    public DXAsyncViewAdapter getAdapter() {
        return this.adapter;
    }

    public void setAdapter(DXAsyncViewAdapter dXAsyncViewAdapter) {
        if (this.adapter != dXAsyncViewAdapter) {
            clear();
            adapterWillChange();
            this.adapter = dXAsyncViewAdapter;
            adapterDidChange();
            requestLayout();
        }
    }

    public void forceSyncLayout(boolean z) {
        this.isForceSyncLayoutRequested = z;
    }

    private void adapterDidChange() {
        DXAsyncViewAdapter dXAsyncViewAdapter = this.adapter;
        if (dXAsyncViewAdapter != null) {
            dXAsyncViewAdapter.setItemsViewAdapterListener(this);
        }
    }

    private void adapterWillChange() {
        DXAsyncViewAdapter dXAsyncViewAdapter = this.adapter;
        if (dXAsyncViewAdapter != null) {
            dXAsyncViewAdapter.setItemsViewAdapterListener(null);
        }
    }

    @Override // com.devexpress.dxlistview.core.ItemsViewAdapterListener
    public void viewDidUpdate(View view, int i, int i2) {
        LayoutSpanContainer layoutSpanContainer = this.layouts.get(i);
        LayoutElement element = layoutSpanContainer.getElement(i2 - layoutSpanContainer.getStartIndex());
        this.updatedLayoutsByIndex.put(i, element);
        updateItemViewAppearance(element.getView(), layoutSpanContainer);
        view.requestLayout();
    }

    public int getAdditionalAreaSizeFromStart() {
        return this.additionalAreaSizeFromStart;
    }

    public int getAdditionalAreaSizeFromEnd() {
        return this.additionalAreaSizeFromEnd;
    }

    public void resetAdditionalLayoutAreaSize() {
        this.additionalAreaSizeFromStart = 0;
        this.additionalAreaSizeFromEnd = 0;
    }

    public SparseArray<LayoutSpanContainer> getLayouts() {
        return this.layouts;
    }

    protected SparseArray<LayoutElement> getUpdatedLayouts() {
        return this.updatedLayoutsByIndex;
    }

    public LayoutElement findElementBy(Point point, LayoutSpanContainer layoutSpanContainer) {
        int elementCount = layoutSpanContainer.getElementCount();
        for (int i = 0; i < elementCount; i++) {
            LayoutElement element = layoutSpanContainer.getElement(i);
            if (element.contains(point.x, point.y)) {
                return element;
            }
        }
        return null;
    }

    public LayoutElement findElementBy(Point point) {
        LayoutElement findElementBy;
        LayoutSpanContainer layoutSpanContainer = this.fixedGroupHeader;
        if (layoutSpanContainer != null && (findElementBy = findElementBy(point, layoutSpanContainer)) != null) {
            return findElementBy;
        }
        for (int i = 0; i < this.layouts.size(); i++) {
            LayoutElement findElementBy2 = findElementBy(point, this.layouts.valueAt(i));
            if (findElementBy2 != null) {
                return findElementBy2;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Point updateLayoutAnchor(int r11, android.graphics.Rect r12, int r13) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.dxlistview.layouts.ComplexItemsLayout.updateLayoutAnchor(int, android.graphics.Rect, int):android.graphics.Point");
    }

    private int clampScrollDelta(int i, Rect rect) {
        int startBound = getStartBound(rect) + i;
        int endBound = getEndBound(rect) + i;
        updateExtent(rect, this.itemSizeProvider.getAverageSize(), this.adapter.getItemCount());
        int obtainExtentSize = obtainExtentSize() - endBound;
        return startBound < 0 ? i - startBound : obtainExtentSize < 0 ? i + obtainExtentSize : i;
    }

    public void updateItemSpacing(int i) {
        this.itemSpacing = i;
        this.itemSizeProvider.clear();
        updateItems();
    }

    public void updateSpanSpacing(int i) {
        this.spanSpacing = i;
        this.spanSizes = calculateSpanSizes(this.currentViewport);
        this.itemSizeProvider.clear();
        updateItems();
    }

    public void setItemSizeRangeByViewType(int i, ItemSizeRange itemSizeRange) {
        this.itemSizeProvider.setItemSizeRangeByViewType(i, itemSizeRange);
        this.itemSizeProvider.clear();
        updateItems();
    }

    public ItemSizeRange getItemSizeRangeByViewType(int i) {
        return this.itemSizeProvider.getItemSizeRangeByViewType(i);
    }

    public void updateAllowFixedGroupHeaders(Boolean bool) {
        this.allowFixedGroupHeaders = bool;
        clearFixedGroupHeader();
        updateItems();
    }

    public LayoutSpanContainer addContainerForPositionToCache(int i, boolean z, int i2) {
        int itemCount = this.adapter.getItemCount();
        boolean isItemsSourceGrouped = this.adapter.isItemsSourceGrouped();
        LayoutSpanContainer createContainer = createContainer(i, i, z, this.currentViewport, i2, itemCount, isItemsSourceGrouped, false, false);
        updateContainer(createContainer, this.currentViewport, true, i2, z, itemCount, isItemsSourceGrouped);
        layoutContainer(createContainer, this.currentViewport, false);
        this.tempLayouts.put(i, createContainer);
        return createContainer;
    }

    public void clearCachedContainers() {
        while (this.tempLayouts.size() > 0) {
            LayoutSpanContainer valueAt = this.tempLayouts.valueAt(0);
            int elementCount = valueAt.getElementCount();
            for (int i = 0; i < elementCount; i++) {
                LayoutElement element = valueAt.getElement(i);
                this.adapter.recycleView(element.getView(), element.getIndex(), valueAt.getPosition(), element.getViewType());
            }
            this.tempLayouts.remove(valueAt.getPosition());
        }
    }

    public void applyAdditionalLayoutAreaSize(int i, boolean z) {
        this.shouldLayoutFromStartToEnd = z;
        this.allowCalculateLayoutDirection = false;
        this.additionalAreaSizeFromStart = z ? 0 : i;
        if (!z) {
            i = 0;
        }
        this.additionalAreaSizeFromEnd = i;
        measure(this.currentViewport);
    }

    public void updateItems(boolean z, boolean z2) {
        if (this.isUpdateLocked || this.adapter == null) {
            return;
        }
        this.shouldLayoutFromStartToEnd = z;
        this.allowCalculateLayoutDirection = z2;
        forceSyncLayout(true);
        this.forceRemoveAllContainers = true;
        requestLayout();
    }

    public void updateItems(boolean z) {
        updateItems(z, this.allowCalculateLayoutDirection);
    }

    public void updateItems() {
        updateItems(this.shouldLayoutFromStartToEnd, this.allowCalculateLayoutDirection);
    }

    public void updateVisibleViews() {
        for (int i = 0; i < this.layouts.size(); i++) {
            LayoutSpanContainer valueAt = this.layouts.valueAt(i);
            for (int i2 = 0; i2 < valueAt.getElementCount(); i2++) {
                LayoutElement element = valueAt.getElement(i2);
                this.adapter.updateView(element.getView(), valueAt.getPosition(), element.getIndex(), true, element.getViewType());
            }
        }
    }

    public void measure(Rect rect) {
        if (this.isUpdateLocked) {
            return;
        }
        measureCore(rect);
    }

    public void layout(Rect rect) {
        for (int i = 0; i < this.layouts.size(); i++) {
            layoutContainer(this.layouts.valueAt(i), this.currentViewport, true);
        }
    }

    private void updateItemViewAppearance(View view, LayoutSpanContainer layoutSpanContainer) {
        IAppearanceOwner iAppearanceOwner = this.appearanceOwner;
        if (iAppearanceOwner != null) {
            iAppearanceOwner.updateItemContainerAppearance(view, layoutSpanContainer.getViewType(), layoutSpanContainer.getIsLast(), layoutSpanContainer.getIsLastInGroup());
        }
    }

    private int findTopContainerPosition(Rect rect, int i) {
        LayoutSpanContainer firstVisibleContainer = getFirstVisibleContainer();
        LayoutSpanContainer lastVisibleContainer = getLastVisibleContainer();
        int position = firstVisibleContainer.getPosition();
        while (true) {
            if (position > lastVisibleContainer.getPosition()) {
                position = -1;
                break;
            }
            LayoutSpanContainer layoutSpanContainer = this.layouts.get(position);
            if (layoutSpanContainer != null && layoutSpanContainer.getStart() <= i && layoutSpanContainer.getEnd() > i) {
                break;
            }
            position++;
        }
        return position < 0 ? firstVisibleContainer.getPosition() : position;
    }

    private int findFixedGroupHeaderPosition(int i) {
        int groupItemIndexForItem = this.adapter.getGroupItemIndexForItem(this.adapter.getStartVisibleIndexInNode(i));
        if (groupItemIndexForItem >= 0) {
            return this.adapter.calculateNodePosition(groupItemIndexForItem);
        }
        return -1;
    }

    private LayoutSpanContainer findNextGroupHeader(int i) {
        LayoutSpanContainer lastVisibleContainer = getLastVisibleContainer();
        do {
            i++;
            if (i >= lastVisibleContainer.getPosition()) {
                return null;
            }
        } while (!DXAsyncViewAdapter.IS_GROUP(this.adapter.getViewTypeByIndex(i, this.adapter.getStartVisibleIndexInNode(i))));
        return this.layouts.get(i);
    }

    private void clearFixedGroupHeader() {
        LayoutSpanContainer layoutSpanContainer = this.fixedGroupHeader;
        if (layoutSpanContainer != null) {
            recycleContainer(layoutSpanContainer);
            this.fixedGroupHeader = null;
        }
    }

    public void layoutFixedGroupHeader(Rect rect) {
        if (this.allowFixedGroupHeaders.booleanValue()) {
            if (this.adapter.isItemsSourceGrouped() && this.layouts.size() > 0) {
                int startBound = getStartBound(rect);
                int findTopContainerPosition = findTopContainerPosition(rect, startBound);
                int findFixedGroupHeaderPosition = findTopContainerPosition >= 0 ? findFixedGroupHeaderPosition(findTopContainerPosition) : -1;
                if (findFixedGroupHeaderPosition >= 0) {
                    LayoutSpanContainer layoutSpanContainer = this.fixedGroupHeader;
                    if (layoutSpanContainer != null && layoutSpanContainer.getPosition() != findFixedGroupHeaderPosition) {
                        clearFixedGroupHeader();
                    }
                    if (this.fixedGroupHeader == null) {
                        LayoutSpanContainer createContainer = createContainer(findFixedGroupHeaderPosition, this.adapter.getStartVisibleIndexInNode(findFixedGroupHeaderPosition), true, rect, 0, this.adapter.getItemCount(), true, false, true);
                        this.fixedGroupHeader = createContainer;
                        createContainer.setZIndex(1);
                    }
                    LayoutSpanContainer findNextGroupHeader = findNextGroupHeader(findTopContainerPosition);
                    if (findNextGroupHeader != null && this.fixedGroupHeader.getSize() + startBound > findNextGroupHeader.getStart()) {
                        this.fixedGroupHeader.setStart(findNextGroupHeader.getStart() - this.fixedGroupHeader.getSize());
                    } else {
                        this.fixedGroupHeader.setStart(startBound);
                    }
                    layoutContainer(this.fixedGroupHeader, rect, true);
                    return;
                }
                clearFixedGroupHeader();
                return;
            }
            clearFixedGroupHeader();
        }
    }

    private void measureCore(Rect rect) {
        int layoutFromEndToStart;
        int itemCount = this.adapter.getItemCount();
        if (this.adapter == null || itemCount == 0) {
            this.currentViewport.set(0, 0, 0, 0);
            resetExtentSize(rect);
            this.tempViewport.set(0, 0, 0, 0);
            clear();
            return;
        }
        if (this.forceRemoveAllContainers) {
            clearFixedGroupHeader();
        }
        updateTempViewPort(rect);
        if (this.tempViewport.top < 0) {
            this.tempViewport.top = 0;
        }
        if (this.tempViewport.left < 0) {
            this.tempViewport.left = 0;
        }
        int averageSize = this.itemSizeProvider.getAverageSize();
        int startBound = getStartBound(this.tempViewport);
        removeInvisibleItems(this.tempViewport, itemCount);
        LayoutSpanContainer firstVisibleContainer = getFirstVisibleContainer();
        LayoutSpanContainer lastVisibleContainer = getLastVisibleContainer();
        if (isViewportSizeChanged(this.currentViewport, this.tempViewport)) {
            this.spanSizes = calculateSpanSizes(this.tempViewport);
            if (this.layouts.size() > 0) {
                for (int position = firstVisibleContainer.getPosition(); position <= lastVisibleContainer.getPosition(); position++) {
                    LayoutSpanContainer layoutSpanContainer = this.layouts.get(position);
                    for (int i = 0; i < layoutSpanContainer.getElementCount(); i++) {
                        LayoutElement element = layoutSpanContainer.getElement(i);
                        this.updatedLayoutsByIndex.put(element.getIndex(), element);
                    }
                }
                forceSyncLayout(true);
            }
        }
        boolean z = this.shouldLayoutFromStartToEnd;
        if (this.allowCalculateLayoutDirection) {
            if (startBound > this.lastOffset || startBound < 0 || (firstVisibleContainer != null && firstVisibleContainer.getPosition() == 0)) {
                z = true;
            } else if (startBound < this.lastOffset) {
                z = false;
            }
        }
        this.lastOffset = startBound;
        boolean isItemsSourceGrouped = this.adapter.isItemsSourceGrouped();
        if (z) {
            layoutFromEndToStart = layoutFromStartToEnd(this.tempViewport, averageSize, itemCount, isItemsSourceGrouped);
            LayoutSpanContainer firstVisibleContainer2 = getFirstVisibleContainer();
            if (firstVisibleContainer2 != null && firstVisibleContainer2.getPosition() > 0 && firstVisibleContainer2.getStart() > getStartBound(this.tempViewport)) {
                this.layoutAnchor = new LayoutAnchor(firstVisibleContainer2.getStart(), firstVisibleContainer2.getPosition() - 1, firstVisibleContainer2.getStartIndex() - 1);
                layoutFromEndToStart = Math.min(layoutFromEndToStart, layoutFromEndToStart(this.tempViewport, averageSize, itemCount, isItemsSourceGrouped));
            }
        } else {
            layoutFromEndToStart = layoutFromEndToStart(this.tempViewport, averageSize, itemCount, isItemsSourceGrouped);
            LayoutSpanContainer lastVisibleContainer2 = getLastVisibleContainer();
            if (lastVisibleContainer2 != null && lastVisibleContainer2.getEnd() < getEndBound(this.tempViewport) && lastVisibleContainer2.getPosition() != itemCount) {
                this.layoutAnchor = new LayoutAnchor(lastVisibleContainer2.getEnd(), lastVisibleContainer2.getPosition() + 1, lastVisibleContainer2.getEndIndex() + 1);
                layoutFromEndToStart = Math.min(layoutFromEndToStart, layoutFromStartToEnd(this.tempViewport, averageSize, itemCount, isItemsSourceGrouped));
            }
        }
        layoutFixedGroupHeader(this.tempViewport);
        this.updatedLayoutsByIndex.clear();
        removeInvisibleItems(this.tempViewport, itemCount);
        this.layoutAnchor = null;
        this.allowCalculateLayoutDirection = true;
        int averageSize2 = this.itemSizeProvider.getAverageSize();
        Point calculateCorrection = calculateCorrection(layoutFromEndToStart);
        this.shouldLayoutFromStartToEnd = z;
        if (calculateCorrection.y != 0 || calculateCorrection.x != 0) {
            this.allowCalculateLayoutDirection = false;
            rect.left += calculateCorrection.x;
            rect.top += calculateCorrection.y;
            rect.right += calculateCorrection.x;
            rect.bottom += calculateCorrection.y;
            moveLayoutItems(calculateCorrection, rect);
        }
        updateExtent(rect, averageSize2, itemCount);
        raiseContentOffsetChangedIfNeeded(this.currentViewport, rect);
        this.currentViewport.set(rect);
        this.tempViewport.set(0, 0, 0, 0);
        this.forceRemoveAllContainers = false;
    }

    protected void removeContainer(LayoutSpanContainer layoutSpanContainer) {
        if (layoutSpanContainer == null) {
            return;
        }
        recycleContainer(layoutSpanContainer);
        this.layouts.remove(layoutSpanContainer.getPosition());
    }

    private void recycleContainer(LayoutSpanContainer layoutSpanContainer) {
        int elementCount = layoutSpanContainer.getElementCount();
        for (int i = 0; i < elementCount; i++) {
            LayoutElement element = layoutSpanContainer.getElement(i);
            this.adapter.recycleView(element.getView(), element.getIndex(), layoutSpanContainer.getPosition(), element.getViewType());
            RecycleListener recycleListener = this.recycleListener;
            if (recycleListener != null) {
                recycleListener.recycleItem(element);
            }
        }
        layoutSpanContainer.setZIndex(0);
    }

    protected void moveLayoutItems(Point point, Rect rect) {
        for (int i = 0; i < this.layouts.size(); i++) {
            LayoutSpanContainer valueAt = this.layouts.valueAt(i);
            valueAt.move(point.x, point.y);
            layoutContainer(valueAt, rect, false);
        }
    }

    public void clear() {
        removeAllContainers();
        reset();
    }

    private void removeAllContainers() {
        while (this.layouts.size() > 0) {
            removeContainer(this.layouts.valueAt(0));
        }
        clearFixedGroupHeader();
    }

    public void reset() {
        this.layoutAnchor = null;
        this.lastOffset = 0;
        this.currentViewport.set(0, 0, 0, 0);
        this.allowCalculateLayoutDirection = true;
        clearCachedContainers();
    }

    private void requestLayout() {
        IVirtualScrollLayoutOwner iVirtualScrollLayoutOwner = this.owner;
        if (iVirtualScrollLayoutOwner != null) {
            iVirtualScrollLayoutOwner.requestLayout();
        }
    }

    protected LayoutAnchor calculateAnchor(Rect rect, int i, boolean z, int i2) {
        int ceil;
        int i3;
        int i4;
        int calcStartVisibleIndex;
        LayoutAnchor layoutAnchor = this.layoutAnchor;
        if (layoutAnchor != null) {
            return layoutAnchor;
        }
        if (getLayouts().size() > 0) {
            LayoutSpanContainer firstVisibleContainer = z ? getFirstVisibleContainer() : getLastVisibleContainer();
            i4 = firstVisibleContainer.getPosition();
            i3 = z ? firstVisibleContainer.getStart() : firstVisibleContainer.getEnd();
            calcStartVisibleIndex = z ? firstVisibleContainer.getStartIndex() : firstVisibleContainer.getEndIndex();
        } else {
            int startBound = getStartBound(rect);
            if (z) {
                ceil = (int) Math.floor((startBound * 1.0f) / i);
            } else {
                ceil = ((int) Math.ceil(((startBound * 1.0f) + getSize(rect)) / i)) - 1;
            }
            int min = Math.min(Math.max(0, ceil), i2 - 1);
            i3 = z ? i * min : i * (min + 1);
            i4 = min;
            calcStartVisibleIndex = calcStartVisibleIndex(min, z);
        }
        return new LayoutAnchor(i3, i4, calcStartVisibleIndex);
    }

    int calcStartVisibleIndex(int i, boolean z) {
        int startVisibleIndexInNode = this.adapter.getStartVisibleIndexInNode(i);
        if (z) {
            return startVisibleIndexInNode;
        }
        DXAsyncViewAdapter dXAsyncViewAdapter = this.adapter;
        return dXAsyncViewAdapter.getEndVisibleIndexInNodeByItem(startVisibleIndexInNode, DXAsyncViewAdapter.IS_ITEM(dXAsyncViewAdapter.getViewTypeByIndex(i, startVisibleIndexInNode)));
    }

    protected Point calculateCorrection(int i) {
        int i2;
        LayoutSpanContainer firstVisibleContainer = getFirstVisibleContainer();
        if (firstVisibleContainer != null) {
            int start = firstVisibleContainer.getStart();
            if (firstVisibleContainer.getPosition() == 0) {
                i2 = -start;
            } else {
                int position = firstVisibleContainer.getPosition() * i;
                if (position > start) {
                    i2 = position - start;
                }
            }
            return calcContentOffsetCorrection(i2);
        }
        i2 = 0;
        return calcContentOffsetCorrection(i2);
    }

    void updateExtent(Rect rect, int i, int i2) {
        LayoutSpanContainer lastVisibleContainer = getLastVisibleContainer();
        if (lastVisibleContainer != null) {
            i2 -= lastVisibleContainer.getPosition() + 1;
        }
        updateExtentSize(lastVisibleContainer == null ? 0 : lastVisibleContainer.getEnd(), i, i2, rect);
    }

    protected void removeInvisibleItems(Rect rect, int i) {
        int startBound = getStartBound(rect);
        int endBound = getEndBound(rect);
        SparseArray sparseArray = new SparseArray();
        for (int i2 = 0; i2 < getLayouts().size(); i2++) {
            LayoutSpanContainer valueAt = getLayouts().valueAt(i2);
            if (valueAt.getPosition() >= i || valueAt.getEnd() <= startBound || valueAt.getStart() >= endBound) {
                sparseArray.put(valueAt.getPosition(), valueAt);
            }
        }
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            removeContainer((LayoutSpanContainer) sparseArray.valueAt(i3));
        }
        sparseArray.clear();
    }

    protected int getSizeMeasureSpec(int i) {
        ItemSizeRange itemSizeRangeByViewType = getItemSizeRangeByViewType(i);
        if (itemSizeRangeByViewType == null || itemSizeRangeByViewType.maxValue < 0) {
            return View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        if (itemSizeRangeByViewType.minValue == itemSizeRangeByViewType.maxValue) {
            return View.MeasureSpec.makeMeasureSpec(itemSizeRangeByViewType.minValue, BasicMeasure.EXACTLY);
        }
        return View.MeasureSpec.makeMeasureSpec(itemSizeRangeByViewType.maxValue, Integer.MIN_VALUE);
    }

    private LayoutSpanContainer createContainer(int i, int i2, boolean z, Rect rect, int i3, int i4, boolean z2, boolean z3, boolean z4) {
        int i5;
        int i6;
        LayoutElement layoutElement;
        int desiredSize;
        int i7 = i2;
        int viewTypeByIndex = this.adapter.getViewTypeByIndex(i, i7);
        boolean IS_ITEM = DXAsyncViewAdapter.IS_ITEM(viewTypeByIndex);
        int startVisibleIndexInNodeByItem = z ? i7 : this.adapter.getStartVisibleIndexInNodeByItem(i7, IS_ITEM);
        if (z) {
            i7 = this.adapter.getEndVisibleIndexInNodeByItem(i7, IS_ITEM);
        }
        int i8 = i7;
        boolean isLast = this.adapter.isLast(i, i4);
        IAppearanceOwner iAppearanceOwner = this.appearanceOwner;
        int i9 = 1;
        boolean z5 = iAppearanceOwner != null && (iAppearanceOwner.hasItemSeparator() || this.itemSpacing > 0) && this.adapter.isLastInGroup(i, i8, viewTypeByIndex, i4, z2);
        int i10 = (!IS_ITEM || isLast || z5) ? 0 : this.itemSpacing;
        int sizeBy = this.itemSizeProvider.getSizeBy(i, viewTypeByIndex) - i10;
        int i11 = i10;
        LayoutSpanContainer layoutSpanContainer = new LayoutSpanContainer(i, startVisibleIndexInNodeByItem, i8, viewTypeByIndex, sizeBy);
        layoutSpanContainer.setIsLast(isLast);
        layoutSpanContainer.setIsLastInGroup(z5);
        int i12 = 0;
        int i13 = 0;
        while (startVisibleIndexInNodeByItem <= i8) {
            int i14 = sizeBy;
            int knownSize = (!IS_ITEM || this.spanCount == i9) ? getKnownSize(rect) : this.spanSizes[i13];
            LayoutElement createElementByIndex = createElementByIndex(startVisibleIndexInNodeByItem, viewTypeByIndex, knownSize, i14);
            boolean z6 = IS_ITEM;
            boolean updateView = this.adapter.updateView(createElementByIndex.getView(), i, createElementByIndex.getIndex(), this.isForceSyncLayoutRequested || z4, viewTypeByIndex);
            if (updateView) {
                updateItemViewAppearance(createElementByIndex.getView(), layoutSpanContainer);
            }
            if (updateView) {
                layoutElement = createElementByIndex;
                desiredSize = measureElement(layoutElement, knownSize);
            } else {
                layoutElement = createElementByIndex;
                desiredSize = getDesiredSize(layoutElement);
            }
            i12 = Math.max(i12, desiredSize);
            layoutSpanContainer.addElement(i13, layoutElement);
            startVisibleIndexInNodeByItem++;
            i13++;
            IS_ITEM = z6;
            sizeBy = i14;
            i9 = 1;
        }
        int desiredSize2 = this.itemSizeProvider.getDesiredSize(viewTypeByIndex, i12);
        if (z) {
            i6 = i3;
            i5 = i11;
        } else {
            i5 = i11;
            i6 = (i3 - desiredSize2) - i5;
        }
        layoutSpanContainer.setStart(i6);
        layoutSpanContainer.setDesiredSize(desiredSize2);
        layoutSpanContainer.setItemSpacing(i5);
        this.itemSizeProvider.pushSize(layoutSpanContainer.getSize(), layoutSpanContainer.getPosition(), viewTypeByIndex);
        if (z3) {
            this.layouts.put(i, layoutSpanContainer);
        }
        return layoutSpanContainer;
    }

    private void updateContainer(LayoutSpanContainer layoutSpanContainer, Rect rect, boolean z, int i, boolean z2, int i2, boolean z3) {
        int elementCount = layoutSpanContainer.getElementCount();
        boolean IS_ITEM = DXAsyncViewAdapter.IS_ITEM(layoutSpanContainer.getViewType());
        boolean isLast = this.adapter.isLast(layoutSpanContainer.getPosition(), i2);
        IAppearanceOwner iAppearanceOwner = this.appearanceOwner;
        boolean z4 = iAppearanceOwner != null && (iAppearanceOwner.hasItemSeparator() || this.itemSpacing > 0) && this.adapter.isLastInGroup(layoutSpanContainer.getPosition(), layoutSpanContainer.getEndIndex(), layoutSpanContainer.getViewType(), i2, z3);
        int i3 = (!IS_ITEM || isLast || z4) ? 0 : this.itemSpacing;
        layoutSpanContainer.setIsLast(isLast);
        layoutSpanContainer.setIsLastInGroup(z4);
        int i4 = 0;
        for (int i5 = 0; i5 < elementCount; i5++) {
            int knownSize = (!IS_ITEM || this.spanCount == 1) ? getKnownSize(rect) : this.spanSizes[i5];
            LayoutElement element = layoutSpanContainer.getElement(i5);
            int desiredSize = (this.updatedLayoutsByIndex.get(element.getIndex()) == null && !element.getView().isLayoutRequested()) ? getDesiredSize(element) : measureElement(element, knownSize);
            if (z) {
                this.adapter.updateView(element.getView(), layoutSpanContainer.getPosition(), element.getIndex(), this.isForceSyncLayoutRequested, layoutSpanContainer.getViewType());
                this.updatedLayoutsByIndex.put(element.getIndex(), element);
                updateItemViewAppearance(element.getView(), layoutSpanContainer);
            }
            i4 = Math.max(i4, desiredSize);
        }
        int desiredSize2 = this.itemSizeProvider.getDesiredSize(layoutSpanContainer.getViewType(), i4);
        layoutSpanContainer.setStart(z2 ? i : (i - desiredSize2) - i3);
        layoutSpanContainer.setItemSpacing(i3);
        layoutSpanContainer.setDesiredSize(desiredSize2);
        this.itemSizeProvider.pushSize(layoutSpanContainer.getSize(), layoutSpanContainer.getPosition(), layoutSpanContainer.getViewType());
    }

    protected void layoutContainer(LayoutSpanContainer layoutSpanContainer, Rect rect, boolean z) {
        int elementCount = layoutSpanContainer.getElementCount();
        boolean IS_ITEM = DXAsyncViewAdapter.IS_ITEM(layoutSpanContainer.getViewType());
        int i = 0;
        for (int i2 = 0; i2 < elementCount; i2++) {
            LayoutElement element = layoutSpanContainer.getElement(i2);
            int knownSize = (!IS_ITEM || this.spanCount == 1) ? getKnownSize(rect) : this.spanSizes[i2];
            layoutElement(element, i, layoutSpanContainer.getStart(), knownSize, layoutSpanContainer.getDesiredSize(), z);
            i += knownSize + this.spanSpacing;
        }
    }

    private int layoutFromEndToStart(Rect rect, int i, int i2, boolean z) {
        int i3;
        int i4;
        LayoutSpanContainer createContainer;
        boolean z2;
        LayoutAnchor calculateAnchor = calculateAnchor(rect, i, false, i2);
        int i5 = calculateAnchor.position;
        int calcStartVisibleIndex = this.forceRemoveAllContainers ? calcStartVisibleIndex(i5, false) : calculateAnchor.startVisibleIndex;
        int i6 = calculateAnchor.offset;
        int startBound = getStartBound(rect);
        int i7 = i;
        int i8 = i6;
        int i9 = i5;
        int i10 = calcStartVisibleIndex;
        while (i9 >= 0 && i9 < i2) {
            if (i8 <= startBound) {
                LayoutSpanContainer layoutSpanContainer = getLayouts().get(i9);
                if (layoutSpanContainer == null) {
                    break;
                }
                removeContainer(layoutSpanContainer);
                i9--;
            } else {
                LayoutSpanContainer layoutSpanContainer2 = getLayouts().get(i9);
                if (layoutSpanContainer2 == null || this.forceRemoveAllContainers) {
                    removeContainer(layoutSpanContainer2);
                    i3 = i9;
                    i4 = i8;
                    createContainer = createContainer(i9, i10, false, rect, i8, i2, z, true, false);
                    z2 = false;
                } else {
                    updateContainer(layoutSpanContainer2, rect, false, i8, false, i2, z);
                    i3 = i9;
                    createContainer = layoutSpanContainer2;
                    z2 = false;
                    i4 = i8;
                }
                layoutContainer(createContainer, rect, z2);
                i7 = Math.min(i7, createContainer.getSize());
                i8 = i4 - createContainer.getSize();
                i10 = createContainer.getStartIndex() - 1;
                i9 = i3 - 1;
            }
        }
        return i7;
    }

    private int layoutFromStartToEnd(Rect rect, int i, int i2, boolean z) {
        int i3;
        int i4;
        LayoutSpanContainer createContainer;
        LayoutAnchor calculateAnchor = calculateAnchor(rect, i, true, i2);
        int i5 = calculateAnchor.position;
        int calcStartVisibleIndex = this.forceRemoveAllContainers ? calcStartVisibleIndex(i5, true) : calculateAnchor.startVisibleIndex;
        int i6 = calculateAnchor.offset;
        int endBound = getEndBound(rect);
        int i7 = i;
        int i8 = i6;
        int i9 = i5;
        int i10 = calcStartVisibleIndex;
        while (i9 < i2) {
            if (i8 >= endBound) {
                LayoutSpanContainer layoutSpanContainer = getLayouts().get(i9);
                if (layoutSpanContainer == null) {
                    break;
                }
                removeContainer(layoutSpanContainer);
                i9++;
            } else {
                LayoutSpanContainer layoutSpanContainer2 = getLayouts().get(i9);
                if (layoutSpanContainer2 == null || this.forceRemoveAllContainers) {
                    removeContainer(layoutSpanContainer2);
                    i3 = i9;
                    i4 = i8;
                    createContainer = createContainer(i9, i10, true, rect, i8, i2, z, true, false);
                } else {
                    updateContainer(layoutSpanContainer2, rect, false, i8, true, i2, z);
                    i3 = i9;
                    createContainer = layoutSpanContainer2;
                    i4 = i8;
                }
                layoutContainer(createContainer, rect, false);
                i7 = Math.min(i7, createContainer.getSize());
                i8 = i4 + createContainer.getSize();
                i10 = createContainer.getEndIndex() + 1;
                i9 = i3 + 1;
            }
        }
        return i7;
    }

    public void setRecycleListener(RecycleListener recycleListener) {
        this.recycleListener = recycleListener;
    }

    int[] calculateSpanSizes(Rect rect) {
        int i;
        int knownSize = getKnownSize(rect) - ((getSpanCount() - 1) * this.spanSpacing);
        int i2 = this.spanCount;
        int[] iArr = new int[i2];
        int i3 = knownSize / i2;
        int i4 = knownSize % i2;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = this.spanCount;
            if (i5 >= i7) {
                return iArr;
            }
            i6 += i4;
            if (i6 <= 0 || i7 - i6 >= i4) {
                i = i3;
            } else {
                i = i3 + 1;
                i6 -= i7;
            }
            iArr[i5] = i;
            i5++;
        }
    }

    protected void updateTempViewPort(Rect rect) {
        this.tempViewport.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private boolean isViewportSizeChanged(Rect rect, Rect rect2) {
        return (rect.height() == rect2.height() && rect.width() == rect2.width()) ? false : true;
    }

    private void raiseContentOffsetChangedIfNeeded(Rect rect, Rect rect2) {
        if (getStartBound(rect) != getStartBound(rect2)) {
            this.owner.contentOffsetChanged(rect.left, rect2.left, rect.top, rect2.top);
        }
    }
}
