package com.devexpress.dxlistview.layouts;

/* loaded from: classes2.dex */
public class LayoutSpanContainer {
    private int desiredSize;
    private final LayoutElement[] elements = new LayoutElement[getElementCount()];
    private final int endIndex;
    private boolean isLast;
    private boolean isLastInGroup;
    private int itemSpacing;
    private final int position;
    private int start;
    private final int startIndex;
    private final int viewType;

    public LayoutSpanContainer(int i, int i2, int i3, int i4, int i5) {
        this.position = i;
        this.startIndex = i2;
        this.endIndex = i3;
        this.viewType = i4;
        this.desiredSize = i5;
    }

    public LayoutElement getFirstElement() {
        return this.elements[0];
    }

    public LayoutElement getLastElement() {
        return this.elements[this.endIndex - this.startIndex];
    }

    public int getElementCount() {
        return (this.endIndex - this.startIndex) + 1;
    }

    public int getPosition() {
        return this.position;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public int getViewType() {
        return this.viewType;
    }

    public LayoutElement getElement(int i) {
        return this.elements[i];
    }

    public void addElement(int i, LayoutElement layoutElement) {
        this.elements[i] = layoutElement;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int i) {
        this.start = i;
    }

    public int getItemSpacing() {
        return this.itemSpacing;
    }

    public void setItemSpacing(int i) {
        this.itemSpacing = i;
    }

    public int getDesiredSize() {
        return this.desiredSize;
    }

    public void setDesiredSize(int i) {
        this.desiredSize = i;
    }

    public int getEnd() {
        return this.start + this.desiredSize + this.itemSpacing;
    }

    public int getSize() {
        return this.desiredSize + this.itemSpacing;
    }

    public boolean getIsLast() {
        return this.isLast;
    }

    public void setIsLast(boolean z) {
        this.isLast = z;
    }

    public boolean getIsLastInGroup() {
        return this.isLastInGroup;
    }

    public void setIsLastInGroup(boolean z) {
        this.isLastInGroup = z;
    }

    public void setZIndex(int i) {
        for (int i2 = 0; i2 < getElementCount(); i2++) {
            getElement(i2).getView().setZ(i);
        }
    }

    public void move(int i, int i2) {
        int i3 = this.start;
        if (Math.abs(i2) > Math.abs(i)) {
            i = i2;
        }
        this.start = i3 + i;
    }
}
