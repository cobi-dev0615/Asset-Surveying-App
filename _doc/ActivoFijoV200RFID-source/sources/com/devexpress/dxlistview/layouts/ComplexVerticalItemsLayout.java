package com.devexpress.dxlistview.layouts;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;

/* loaded from: classes2.dex */
public class ComplexVerticalItemsLayout extends ComplexItemsLayout {
    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    public int getMeasureWidth(int i, int i2) {
        return i;
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected LayoutElement createElementByIndex(int i, int i2, int i3, int i4) {
        return new LayoutElement(getAdapter().getViewByIndex(i, i2), i, i2, i3, i4);
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected void updateExtentSize(int i, int i2, int i3, Rect rect) {
        this.extentSize.set(rect.width(), i + (i2 * i3));
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected Point calcContentOffsetCorrection(int i) {
        return new Point(0, i);
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected int measureElement(LayoutElement layoutElement, int i) {
        layoutElement.measure(View.MeasureSpec.makeMeasureSpec(i, BasicMeasure.EXACTLY), getSizeMeasureSpec(layoutElement.getViewType()));
        return layoutElement.getDesiredHeight();
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected void layoutElement(LayoutElement layoutElement, int i, int i2, int i3, int i4, boolean z) {
        layoutElement.layout(i, i2, i + i3, i2 + i4, z);
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected int getStartBound(Rect rect) {
        return rect.top;
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected int getEndBound(Rect rect) {
        return rect.bottom;
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected int getSize(Rect rect) {
        return rect.height();
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected int getKnownSize(Rect rect) {
        return rect.width();
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected int getDesiredSize(LayoutElement layoutElement) {
        return layoutElement.getDesiredHeight();
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected void updateTempViewPort(Rect rect) {
        if (Math.abs(getAdditionalAreaSizeFromStart()) == 0 && Math.abs(getAdditionalAreaSizeFromEnd()) == 0) {
            super.updateTempViewPort(rect);
        } else {
            this.tempViewport.set(rect.left, rect.top - getAdditionalAreaSizeFromStart(), rect.right, rect.bottom + getAdditionalAreaSizeFromEnd());
        }
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected void resetExtentSize(Rect rect) {
        this.extentSize.set(rect.width(), 0);
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    public int getMeasureHeight(int i, int i2) {
        return Math.min(i, i2);
    }

    @Override // com.devexpress.dxlistview.layouts.ComplexItemsLayout
    protected int obtainExtentSize() {
        return this.extentSize.height;
    }
}
