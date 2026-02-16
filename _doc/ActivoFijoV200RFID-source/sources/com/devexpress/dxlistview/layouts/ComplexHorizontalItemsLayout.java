package com.devexpress.dxlistview.layouts;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;

/* loaded from: classes2.dex */
public class ComplexHorizontalItemsLayout extends ComplexItemsLayout {
    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    public int getMeasureHeight(int i, int i2) {
        return i;
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected LayoutElement createElementByIndex(int i, int i2, int i3, int i4) {
        return new LayoutElement(getAdapter().getViewByIndex(i, i2), i, i2, i4, i3);
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected void updateExtentSize(int i, int i2, int i3, Rect rect) {
        this.extentSize.set(i + (i2 * i3), rect.height());
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected Point calcContentOffsetCorrection(int i) {
        return new Point(i, 0);
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected int measureElement(LayoutElement layoutElement, int i) {
        layoutElement.measure(getSizeMeasureSpec(layoutElement.getViewType()), View.MeasureSpec.makeMeasureSpec(i, BasicMeasure.EXACTLY));
        return layoutElement.getDesiredWidth();
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected void layoutElement(LayoutElement layoutElement, int i, int i2, int i3, int i4, boolean z) {
        layoutElement.layout(i2, i, i2 + i4, i + i3, z);
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected int getStartBound(Rect rect) {
        return rect.left;
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected int getEndBound(Rect rect) {
        return rect.right;
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected int getSize(Rect rect) {
        return rect.width();
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected int getKnownSize(Rect rect) {
        return rect.height();
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected int getDesiredSize(LayoutElement layoutElement) {
        return layoutElement.getDesiredWidth();
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected void updateTempViewPort(Rect rect) {
        if (Math.abs(getAdditionalAreaSizeFromStart()) == 0 && Math.abs(getAdditionalAreaSizeFromEnd()) == 0) {
            super.updateTempViewPort(rect);
        } else {
            this.tempViewport.set(rect.left - getAdditionalAreaSizeFromStart(), rect.top, rect.right + getAdditionalAreaSizeFromEnd(), rect.bottom);
        }
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected void resetExtentSize(Rect rect) {
        this.extentSize.set(0, rect.height());
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    public int getMeasureWidth(int i, int i2) {
        return Math.min(i, i2);
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected int obtainExtentSize() {
        return this.extentSize.width;
    }
}
