package com.devexpress.editors.layout;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.editors.model.Thickness;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: SpannableHStack.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002:\u0003defB!\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J!\u0010.\u001a\u00020+2\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020-00\"\u00020-H\u0016¢\u0006\u0002\u00101J\u0016\u0010.\u001a\u00020+2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020-02H\u0016J \u00103\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u0013H\u0002J6\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020\u00132\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020\u0013H\u0002J\b\u0010;\u001a\u00020+H\u0002J\u0010\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020>H\u0016J\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010@\u001a\u00020\u0013J\u0018\u0010A\u001a\u00020+2\u0006\u00107\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-H\u0016J(\u0010B\u001a\u00020+2\u0006\u0010C\u001a\u00020\u00132\u0006\u0010D\u001a\u00020\u00132\u0006\u0010E\u001a\u00020\u00132\u0006\u0010F\u001a\u00020\u0013H\u0016J(\u0010G\u001a\u00020\u00132\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u00132\u0006\u0010K\u001a\u00020\u00132\u0006\u0010L\u001a\u00020\u0013H\u0002J6\u0010M\u001a\u00020+2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010J\u001a\u00020\u00132\u0006\u0010K\u001a\u00020\u00132\u0006\u0010L\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\u0013H\u0002J\u0018\u0010O\u001a\u00020+2\u0006\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u0013H\u0016J8\u0010R\u001a\u00020S2\u0006\u0010@\u001a\u00020\u00132\u0006\u0010H\u001a\u00020I2\u0006\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u00132\u0006\u0010T\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\u0013H\u0002JN\u0010V\u001a\u00020S2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u00132\u0006\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020\u00132\u0006\u0010T\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u0013H\u0002J\u0010\u0010W\u001a\u00020+2\u0006\u0010X\u001a\u00020\u0007H\u0002J\u0010\u0010Y\u001a\u00020+2\u0006\u0010@\u001a\u00020\u0013H\u0002J&\u0010Z\u001a\u00020+2\u0006\u0010@\u001a\u00020\u00132\u0006\u0010[\u001a\u00020\\2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010^\u001a\u00020+H\u0016J\u0010\u0010_\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010`\u001a\u00020+2\u0006\u00107\u001a\u00020\u0013H\u0016J\u0018\u0010a\u001a\u00020\u00132\u0006\u0010b\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u0013H\u0002J\u0010\u0010c\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010&R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/devexpress/editors/layout/SpannableHStack;", "Lcom/devexpress/editors/layout/HStack;", "Lcom/devexpress/editors/layout/RowSeparatedContainer;", "id", "", "spannedChildren", "", "Lcom/devexpress/editors/layout/SpannedElement;", "(Ljava/lang/String;Ljava/util/List;)V", "canDrawSeparator", "", "getCanDrawSeparator", "()Z", "isLastRow", "setLastRow", "(Z)V", "isLastRowSeparatorVisible", "setLastRowSeparatorVisible", "lastRowIndex", "", "getLastRowIndex", "()I", "rowCount", "getRowCount", "rowElements", "", "rowLayout", "Lcom/devexpress/editors/layout/SpannableHStack$RowLayout;", "rowSegmentElements", "separatorDrawable", "Landroid/graphics/drawable/Drawable;", "getSeparatorDrawable", "()Landroid/graphics/drawable/Drawable;", "setSeparatorDrawable", "(Landroid/graphics/drawable/Drawable;)V", "separatorHeight", "getSeparatorHeight", "setSeparatorHeight", "(I)V", "getSpannedChildren", "()Ljava/util/List;", "spannedChildrenInternal", "addChild", "", "element", "Lcom/devexpress/editors/layout/Element;", "addChildren", "elements", "", "([Lcom/devexpress/editors/layout/Element;)V", "", "addLayoutData", "minLeft", "maxRight", "addMeasureData", "index", "maxWidth", "usedWidthBefore", "usedWidthAfter", "calculateRows", "draw", "canvas", "Landroid/graphics/Canvas;", "getElementsInRowAt", "rowIndex", "insertChild", "layout", "left", "top", "right", "bottom", "layoutRow", "rowData", "Lcom/devexpress/editors/layout/SpannableHStack$RowData;", "l", "t", "r", "layoutSegment", "b", "measure", "widthSpec", "heightSpec", "measureRow", "Landroid/util/Size;", "paddingH", "paddingV", "measureSegment", "measureSpannedChild", "child", "populateRowData", "populateSegment", "segment", "Lcom/devexpress/editors/layout/SpannableHStack$RowSegmentData;", "segmentElements", "removeAllChildren", "removeChild", "removeChildAt", "selectRowElements", "startIndex", "tryAddSpannedElement", "RowData", "RowLayout", "RowSegmentData", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SpannableHStack extends HStack implements RowSeparatedContainer {
    private boolean isLastRow;
    private boolean isLastRowSeparatorVisible;
    private final List<SpannedElement> rowElements;
    private final RowLayout rowLayout;
    private final List<SpannedElement> rowSegmentElements;
    private Drawable separatorDrawable;
    private int separatorHeight;
    private final List<SpannedElement> spannedChildrenInternal;

    /* JADX WARN: Multi-variable type inference failed */
    public SpannableHStack() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ SpannableHStack(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpannableHStack(String id, List<? extends SpannedElement> list) {
        super(id, null, 0, null, 14, null);
        Intrinsics.checkNotNullParameter(id, "id");
        this.spannedChildrenInternal = new ArrayList();
        this.rowLayout = new RowLayout();
        this.rowElements = new ArrayList();
        this.rowSegmentElements = new ArrayList();
        if (list != null) {
            addChildren(list);
        }
    }

    public final List<SpannedElement> getSpannedChildren() {
        return this.spannedChildrenInternal;
    }

    public final int getRowCount() {
        return this.rowLayout.getIndices().size();
    }

    public final int getLastRowIndex() {
        return ((Number) CollectionsKt.last((List) this.rowLayout.getIndices())).intValue();
    }

    @Override // com.devexpress.editors.layout.RowSeparatedContainer
    /* renamed from: isLastRowSeparatorVisible, reason: from getter */
    public boolean getIsLastRowSeparatorVisible() {
        return this.isLastRowSeparatorVisible;
    }

    @Override // com.devexpress.editors.layout.RowSeparatedContainer
    public void setLastRowSeparatorVisible(boolean z) {
        this.isLastRowSeparatorVisible = z;
    }

    @Override // com.devexpress.editors.layout.RowSeparatedContainer
    /* renamed from: isLastRow, reason: from getter */
    public boolean getIsLastRow() {
        return this.isLastRow;
    }

    @Override // com.devexpress.editors.layout.RowSeparatedContainer
    public void setLastRow(boolean z) {
        this.isLastRow = z;
    }

    @Override // com.devexpress.editors.layout.RowSeparatedContainer
    public int getSeparatorHeight() {
        return this.separatorHeight;
    }

    @Override // com.devexpress.editors.layout.RowSeparatedContainer
    public void setSeparatorHeight(int i) {
        this.separatorHeight = i;
    }

    @Override // com.devexpress.editors.layout.RowSeparatedContainer
    public Drawable getSeparatorDrawable() {
        return this.separatorDrawable;
    }

    @Override // com.devexpress.editors.layout.RowSeparatedContainer
    public void setSeparatorDrawable(Drawable drawable) {
        this.separatorDrawable = drawable;
    }

    private final boolean getCanDrawSeparator() {
        return (getSeparatorHeight() == 0 || getSeparatorDrawable() == null) ? false : true;
    }

    @Override // com.devexpress.editors.layout.HStack, com.devexpress.editors.layout.Element
    public void measure(int widthSpec, int heightSpec) {
        int i;
        int i2;
        int size = View.MeasureSpec.getSize(widthSpec);
        int mode = View.MeasureSpec.getMode(widthSpec);
        int size2 = View.MeasureSpec.getSize(heightSpec);
        int mode2 = View.MeasureSpec.getMode(heightSpec);
        int horizontal = getPadding().getHorizontal();
        int vertical = getPadding().getVertical();
        boolean canDrawSeparator = getCanDrawSeparator();
        int i3 = 0;
        if (getRowCount() > 0) {
            int lastIndex = CollectionsKt.getLastIndex(this.rowLayout.getIndices());
            int i4 = vertical;
            int i5 = 0;
            int i6 = 0;
            while (i6 < lastIndex) {
                int intValue = this.rowLayout.getIndices().get(i6).intValue();
                RowData rowData = this.rowLayout.get(intValue);
                rowData.setHeight(i3);
                int i7 = i6;
                Size measureRow = measureRow(intValue, rowData, widthSpec, heightSpec, horizontal, i4);
                i5 = Math.max(measureRow.getWidth(), i5);
                int height = measureRow.getHeight();
                if (rowData.getHeight() > 0) {
                    height += getSeparatorHeight() * (canDrawSeparator ? 1 : 0);
                }
                i4 = height;
                i6 = i7 + 1;
                i3 = 0;
            }
            int intValue2 = ((Number) CollectionsKt.last((List) this.rowLayout.getIndices())).intValue();
            RowData rowData2 = this.rowLayout.get(intValue2);
            rowData2.setHeight(0);
            i = 0;
            Size measureRow2 = measureRow(intValue2, rowData2, widthSpec, heightSpec, horizontal, i4);
            i2 = Math.max(measureRow2.getWidth(), i5);
            vertical = measureRow2.getHeight();
            if (rowData2.getHeight() > 0 && getIsLastRowSeparatorVisible()) {
                vertical += (canDrawSeparator ? 1 : 0) * getSeparatorHeight();
            }
            for (SpannedElement spannedElement : this.rowLayout.getSpannedElements()) {
                if (spannedElement.isVisible()) {
                    measureSpannedChild(spannedElement);
                }
            }
        } else {
            i = 0;
            i2 = 0;
        }
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(Math.max(i2, getWidthRequest().getMinSize()), size);
        } else if (mode == 0) {
            size = Math.max(i2, getWidthRequest().getMinSize());
        } else if (mode != 1073741824) {
            size = i;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(Math.max(vertical, getHeightRequest().getMinSize()), size2);
        } else if (mode2 == 0) {
            size2 = Math.max(vertical, getHeightRequest().getMinSize());
        } else if (mode2 != 1073741824) {
            size2 = i;
        }
        setMeasuredSize(new Size(size, size2));
    }

    @Override // com.devexpress.editors.layout.HStack, com.devexpress.editors.layout.Element
    public void layout(int left, int top, int right, int bottom) {
        int i;
        getPadding().resolve(getLayoutDirection());
        int left2 = getPadding().getLeft() + left;
        int top2 = getPadding().getTop() + top;
        int right2 = right - getPadding().getRight();
        boolean canDrawSeparator = getCanDrawSeparator();
        Iterator<Map.Entry<Integer, RowData>> it = this.rowLayout.getRows().entrySet().iterator();
        while (it.hasNext()) {
            RowData value = it.next().getValue();
            int layoutRow = layoutRow(value, left2, top2, right2);
            if (value.getHeight() > 0) {
                i = getSeparatorHeight() * (canDrawSeparator ? 1 : 0);
            } else {
                i = 0;
            }
            top2 = layoutRow + i;
        }
        getBounds().set(left, top, right, bottom);
    }

    @Override // com.devexpress.editors.layout.AbstractContainer, com.devexpress.editors.layout.Element
    public void draw(Canvas canvas) {
        int separatorHeight;
        List<Integer> list;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        Drawable separatorDrawable = getSeparatorDrawable();
        if (separatorDrawable == null || getSeparatorHeight() == 0) {
            return;
        }
        Rect bounds = getBounds();
        Thickness padding = getPadding();
        int left = bounds.left + padding.getLeft();
        int right = bounds.right - padding.getRight();
        int top = bounds.top + padding.getTop();
        List<Integer> indices = this.rowLayout.getIndices();
        if (indices.isEmpty()) {
            return;
        }
        int i = 0;
        RowData rowData = this.rowLayout.get(indices.get(0).intValue());
        int lastIndex = CollectionsKt.getLastIndex(indices);
        int i2 = 1;
        if (1 <= lastIndex) {
            int i3 = 1;
            while (true) {
                RowData rowData2 = this.rowLayout.get(indices.get(i3).intValue());
                int height = top + rowData.getHeight();
                List<Integer> orderStops = rowData2.getOrderStops();
                separatorHeight = getSeparatorHeight() + height;
                RowSegmentData rowSegmentData = rowData2.get(orderStops.get(i).intValue());
                int lastIndex2 = CollectionsKt.getLastIndex(orderStops);
                if (i2 <= lastIndex2) {
                    int i4 = i2;
                    while (true) {
                        RowSegmentData rowSegmentData2 = rowData2.get(orderStops.get(i4).intValue());
                        list = indices;
                        separatorDrawable.setBounds(rowSegmentData.getRight(), height, rowSegmentData2.getLeft() - (!rowSegmentData.getElements().isEmpty() ? ((SpannedElement) CollectionsKt.last((List) rowSegmentData.getElements())).getMargin().getRight() : 0), separatorHeight);
                        separatorDrawable.draw(canvas);
                        if (i4 == lastIndex2) {
                            break;
                        }
                        i4++;
                        rowSegmentData = rowSegmentData2;
                        indices = list;
                    }
                } else {
                    list = indices;
                }
                separatorDrawable.setBounds(rowData2.get(((Number) CollectionsKt.last((List) orderStops)).intValue()).getRight(), height, right, separatorHeight);
                separatorDrawable.draw(canvas);
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
                rowData = rowData2;
                top = separatorHeight;
                indices = list;
                i = 0;
                i2 = 1;
            }
            top = separatorHeight;
        }
        if (getIsLastRowSeparatorVisible()) {
            int height2 = top + this.rowLayout.get(((Number) CollectionsKt.last((List) this.rowLayout.getIndices())).intValue()).getHeight();
            separatorDrawable.setBounds(left, height2, right, getSeparatorHeight() + height2);
            separatorDrawable.draw(canvas);
        }
    }

    @Override // com.devexpress.editors.layout.AbstractContainer, com.devexpress.editors.layout.Container
    public void addChild(Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        tryAddSpannedElement(element);
        super.addChild(element);
        calculateRows();
    }

    @Override // com.devexpress.editors.layout.AbstractContainer, com.devexpress.editors.layout.Container
    public void addChildren(Element... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        for (Element element : elements) {
            tryAddSpannedElement(element);
        }
        calculateRows();
        super.addChildren((Element[]) Arrays.copyOf(elements, elements.length));
    }

    @Override // com.devexpress.editors.layout.AbstractContainer, com.devexpress.editors.layout.Container
    public void addChildren(Iterable<? extends Element> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends Element> it = elements.iterator();
        while (it.hasNext()) {
            tryAddSpannedElement(it.next());
        }
        super.addChildren(elements);
        calculateRows();
    }

    @Override // com.devexpress.editors.layout.AbstractContainer, com.devexpress.editors.layout.Container
    public void insertChild(int index, Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        SpannedElement spannedElement = element instanceof SpannedElement ? (SpannedElement) element : null;
        if (spannedElement != null) {
            this.spannedChildrenInternal.add(index, spannedElement);
        }
        super.insertChild(index, element);
        calculateRows();
    }

    @Override // com.devexpress.editors.layout.AbstractContainer, com.devexpress.editors.layout.Container
    public void removeChild(Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        TypeIntrinsics.asMutableCollection(this.spannedChildrenInternal).remove(element);
        super.removeChild(element);
        calculateRows();
    }

    @Override // com.devexpress.editors.layout.AbstractContainer, com.devexpress.editors.layout.Container
    public void removeChildAt(int index) {
        Element element = getChildrenInternal().get(index);
        super.removeChildAt(index);
        TypeIntrinsics.asMutableCollection(this.spannedChildrenInternal).remove(element);
        calculateRows();
    }

    @Override // com.devexpress.editors.layout.AbstractContainer, com.devexpress.editors.layout.Container
    public void removeAllChildren() {
        this.spannedChildrenInternal.clear();
        super.removeAllChildren();
        this.rowLayout.clear();
    }

    public final List<SpannedElement> getElementsInRowAt(int rowIndex) {
        ArrayList arrayList = new ArrayList();
        for (SpannedElement spannedElement : this.rowLayout.getSpannedElements()) {
            if (rowIndex > spannedElement.getRowIndex() && rowIndex <= spannedElement.getBottomRowIndex()) {
                arrayList.add(spannedElement);
            }
        }
        Iterator<Map.Entry<Integer, RowSegmentData>> it = this.rowLayout.get(rowIndex).getSegments().entrySet().iterator();
        while (it.hasNext()) {
            Iterator<SpannedElement> it2 = it.next().getValue().getElements().iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next());
            }
        }
        return arrayList;
    }

    private final int selectRowElements(int startIndex, int rowIndex) {
        int rowOrder = getSpannedChildren().get(startIndex).getRowOrder();
        this.rowElements.clear();
        while (startIndex < getSpannedChildren().size() && getSpannedChildren().get(startIndex).getRowOrder() == rowOrder) {
            getSpannedChildren().get(startIndex).setRowIndex(rowIndex);
            this.rowElements.add(getSpannedChildren().get(startIndex));
            startIndex++;
        }
        return startIndex - 1;
    }

    private final Size measureRow(int rowIndex, RowData rowData, int widthSpec, int heightSpec, int paddingH, int paddingV) {
        List<Integer> orderStops = rowData.getOrderStops();
        int lastIndex = CollectionsKt.getLastIndex(orderStops);
        int i = 0;
        while (i < lastIndex) {
            RowSegmentData rowSegmentData = rowData.get(orderStops.get(i).intValue());
            i++;
            measureSegment(rowSegmentData.getElements(), widthSpec, heightSpec, rowSegmentData.getUsedWidthBefore(), rowData.get(orderStops.get(i).intValue()).getUsedWidthAfter(), paddingH, paddingV, rowIndex);
        }
        RowSegmentData rowSegmentData2 = rowData.get(orderStops.get(CollectionsKt.getLastIndex(orderStops)).intValue());
        return measureSegment(rowSegmentData2.getElements(), widthSpec, heightSpec, rowSegmentData2.getUsedWidthBefore(), 0, paddingH, paddingV, rowIndex);
    }

    private final Size measureSegment(List<? extends SpannedElement> elements, int widthSpec, int heightSpec, int usedWidthBefore, int usedWidthAfter, int paddingH, int paddingV, int rowIndex) {
        SpannableHStack spannableHStack;
        int i = usedWidthBefore + usedWidthAfter + paddingH;
        Size measure = measure(elements, widthSpec, heightSpec, i, paddingV);
        int size = View.MeasureSpec.getSize(widthSpec);
        int lastIndex = CollectionsKt.getLastIndex(elements);
        int i2 = 0;
        if (lastIndex >= 0) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                SpannedElement spannedElement = elements.get(i3);
                if (spannedElement.getRowSpan() > 1) {
                    addMeasureData(i3, elements, size - i, usedWidthBefore, usedWidthAfter);
                } else {
                    i4 = Math.max(i4, spannedElement.getMeasuredSize().getHeight() + spannedElement.getMargin().getVertical());
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
            spannableHStack = this;
            i2 = i4;
        } else {
            spannableHStack = this;
        }
        RowData rowData = spannableHStack.rowLayout.get(rowIndex);
        rowData.setHeight(Math.max(i2, rowData.getHeight()));
        return new Size(measure.getWidth(), rowData.getHeight() + paddingV);
    }

    private final void measureSpannedChild(SpannedElement child) {
        int height = this.rowLayout.get(child.getRowIndex()).getHeight();
        boolean canDrawSeparator = getCanDrawSeparator();
        int rowIndex = child.getRowIndex() + 1;
        int min = Math.min(child.getBottomRowIndex(), ((Number) CollectionsKt.last((List) this.rowLayout.getIndices())).intValue());
        if (rowIndex <= min) {
            while (true) {
                int height2 = this.rowLayout.get(rowIndex).getHeight();
                if (height2 > 0) {
                    height += height2 + (getSeparatorHeight() * (canDrawSeparator ? 1 : 0));
                }
                if (rowIndex == min) {
                    break;
                } else {
                    rowIndex++;
                }
            }
        }
        child.measure(View.MeasureSpec.makeMeasureSpec(child.getMeasuredSize().getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(height - child.getMargin().getVertical(), BasicMeasure.EXACTLY));
    }

    private final int layoutRow(RowData rowData, int l, int t, int r) {
        List<Integer> orderStops = rowData.getOrderStops();
        int height = rowData.getHeight() + t;
        int i = 0;
        rowData.get(orderStops.get(0).intValue()).setRight(l);
        int lastIndex = CollectionsKt.getLastIndex(orderStops);
        while (i < lastIndex) {
            RowSegmentData rowSegmentData = rowData.get(orderStops.get(i).intValue());
            int i2 = i + 1;
            layoutSegment(rowSegmentData.getElements(), rowSegmentData.getRight(), t, rowData.get(orderStops.get(i2).intValue()).getLeft(), height);
            i = i2;
        }
        RowSegmentData rowSegmentData2 = rowData.get(orderStops.get(CollectionsKt.getLastIndex(orderStops)).intValue());
        layoutSegment(rowSegmentData2.getElements(), rowSegmentData2.getRight(), t, r, height);
        return height;
    }

    private final void layoutSegment(List<? extends SpannedElement> elements, int l, int t, int r, int b) {
        layout(elements, l, t, b);
        for (SpannedElement spannedElement : elements) {
            if (spannedElement.getRowSpan() > 1 && spannedElement.isVisible()) {
                Rect bounds = spannedElement.getBounds();
                spannedElement.layout(bounds.left, t, bounds.right, spannedElement.getMeasuredSize().getHeight() + t);
                addLayoutData(spannedElement, l, r);
            }
        }
    }

    private final void tryAddSpannedElement(Element element) {
        SpannedElement spannedElement = element instanceof SpannedElement ? (SpannedElement) element : null;
        if (spannedElement != null) {
            this.spannedChildrenInternal.add(spannedElement);
        }
    }

    private final void addMeasureData(int index, List<? extends SpannedElement> elements, int maxWidth, int usedWidthBefore, int usedWidthAfter) {
        SpannedElement spannedElement = elements.get(index);
        if (!spannedElement.isVisible()) {
            return;
        }
        if (index >= 0) {
            int i = 0;
            while (true) {
                SpannedElement spannedElement2 = elements.get(i);
                if (spannedElement2.isVisible()) {
                    usedWidthBefore += spannedElement2.getMeasuredSize().getWidth() + spannedElement2.getMargin().getHorizontal() + getItemSpacing();
                }
                if (i == index) {
                    break;
                } else {
                    i++;
                }
            }
        }
        int lastIndex = CollectionsKt.getLastIndex(elements);
        if (index <= lastIndex) {
            while (true) {
                SpannedElement spannedElement3 = elements.get(index);
                if (spannedElement3.isVisible()) {
                    usedWidthAfter += spannedElement3.getMeasuredSize().getWidth() + spannedElement3.getMargin().getHorizontal() + getItemSpacing();
                }
                if (index == lastIndex) {
                    break;
                } else {
                    index++;
                }
            }
        }
        int max = Math.max(((maxWidth - usedWidthAfter) - usedWidthBefore) + spannedElement.getMeasuredSize().getWidth(), 0);
        int rowIndex = spannedElement.getRowIndex() + 1;
        int bottomRowIndex = spannedElement.getBottomRowIndex();
        if (rowIndex > bottomRowIndex) {
            return;
        }
        while (true) {
            RowSegmentData rowSegmentData = this.rowLayout.get(rowIndex).get(spannedElement.getItemOrderInRow());
            rowSegmentData.setUsedWidthBefore(Math.max(rowSegmentData.getUsedWidthBefore(), usedWidthBefore));
            rowSegmentData.setUsedWidthAfter(Math.max(rowSegmentData.getUsedWidthAfter(), usedWidthAfter + max));
            if (rowIndex == bottomRowIndex) {
                return;
            } else {
                rowIndex++;
            }
        }
    }

    private final void addLayoutData(SpannedElement element, int minLeft, int maxRight) {
        Rect bounds = element.getBounds();
        Thickness margin = element.getMargin();
        int max = Math.max((bounds.left - getItemSpacing()) - margin.getLeft(), minLeft);
        int min = Math.min(bounds.right + getItemSpacing() + margin.getRight(), maxRight);
        int rowIndex = element.getRowIndex() + 1;
        int bottomRowIndex = element.getBottomRowIndex();
        if (rowIndex > bottomRowIndex) {
            return;
        }
        while (true) {
            RowSegmentData rowSegmentData = this.rowLayout.get(rowIndex).get(element.getItemOrderInRow());
            rowSegmentData.setLeft(Math.min(max, rowSegmentData.getLeft()));
            rowSegmentData.setRight(Math.max(min, rowSegmentData.getRight()));
            if (rowIndex == bottomRowIndex) {
                return;
            } else {
                rowIndex++;
            }
        }
    }

    private final void calculateRows() {
        this.rowLayout.clear();
        int i = 0;
        int i2 = 0;
        while (i < getSpannedChildren().size()) {
            int selectRowElements = selectRowElements(i, i2);
            populateRowData(i2);
            i2++;
            i = selectRowElements + 1;
        }
        this.rowElements.clear();
        this.rowSegmentElements.clear();
    }

    private final void populateRowData(int rowIndex) {
        RowData rowData = this.rowLayout.get(rowIndex);
        List<Integer> orderStops = rowData.getOrderStops();
        int intValue = orderStops.get(0).intValue();
        int i = 1;
        int intValue2 = orderStops.size() > 1 ? orderStops.get(1).intValue() : Integer.MAX_VALUE;
        this.rowSegmentElements.clear();
        for (SpannedElement spannedElement : this.rowElements) {
            int itemOrderInRow = spannedElement.getItemOrderInRow();
            if (itemOrderInRow >= intValue && itemOrderInRow < intValue2) {
                this.rowSegmentElements.add(spannedElement);
            } else if (itemOrderInRow >= intValue2) {
                populateSegment(rowIndex, rowData.get(intValue), this.rowSegmentElements);
                this.rowSegmentElements.clear();
                this.rowSegmentElements.add(spannedElement);
                while (orderStops.size() > i && orderStops.get(i).intValue() <= itemOrderInRow) {
                    i++;
                }
                if (i >= orderStops.size()) {
                    intValue = ((Number) CollectionsKt.last((List) orderStops)).intValue();
                    intValue2 = Integer.MAX_VALUE;
                } else {
                    intValue = orderStops.get(i - 1).intValue();
                    intValue2 = orderStops.get(i).intValue();
                }
            }
        }
        populateSegment(rowIndex, rowData.get(intValue), this.rowSegmentElements);
    }

    private final void populateSegment(int rowIndex, RowSegmentData segment, List<? extends SpannedElement> segmentElements) {
        for (SpannedElement spannedElement : segmentElements) {
            spannedElement.setRowIndex(rowIndex);
            segment.getElements().add(spannedElement);
            if (spannedElement.getRowSpan() > 1) {
                this.rowLayout.getSpannedElements().add(spannedElement);
                int rowIndex2 = spannedElement.getRowIndex() + 1;
                int bottomRowIndex = spannedElement.getBottomRowIndex();
                if (rowIndex2 <= bottomRowIndex) {
                    while (true) {
                        this.rowLayout.get(rowIndex2).addSegmentStop(spannedElement.getItemOrderInRow());
                        if (rowIndex2 != bottomRowIndex) {
                            rowIndex2++;
                        }
                    }
                }
            }
        }
    }

    /* compiled from: SpannableHStack.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\u0011\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\u0002R*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/devexpress/editors/layout/SpannableHStack$RowLayout;", "", "()V", "<set-?>", "", "", "indices", "getIndices", "()Ljava/util/List;", "rows", "", "Lcom/devexpress/editors/layout/SpannableHStack$RowData;", "getRows", "()Ljava/util/Map;", "rowsInternal", "", "spannedElements", "", "Lcom/devexpress/editors/layout/SpannedElement;", "getSpannedElements", "addRow", "rowIndex", "clear", "", "get", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RowLayout {
        private List<Integer> indices;
        private final Map<Integer, RowData> rowsInternal = new LinkedHashMap();
        private final List<SpannedElement> spannedElements = new ArrayList();

        public final Map<Integer, RowData> getRows() {
            return this.rowsInternal;
        }

        public final List<SpannedElement> getSpannedElements() {
            return this.spannedElements;
        }

        public final List<Integer> getIndices() {
            List<Integer> list = this.indices;
            if (list != null) {
                return list;
            }
            Intrinsics.throwUninitializedPropertyAccessException("indices");
            return null;
        }

        public final RowData get(int rowIndex) {
            RowData rowData = this.rowsInternal.get(Integer.valueOf(rowIndex));
            return rowData == null ? addRow(rowIndex) : rowData;
        }

        public final void clear() {
            this.rowsInternal.clear();
        }

        private final RowData addRow(int rowIndex) {
            RowData rowData = new RowData();
            rowData.addSegmentStop(Integer.MIN_VALUE);
            this.rowsInternal.put(Integer.valueOf(rowIndex), rowData);
            this.indices = CollectionsKt.sorted(this.rowsInternal.keySet());
            return rowData;
        }
    }

    /* compiled from: SpannableHStack.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\bJ\u0011\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\bH\u0086\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR*\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/devexpress/editors/layout/SpannableHStack$RowData;", "", "()V", "defaultSegment", "Lcom/devexpress/editors/layout/SpannableHStack$RowSegmentData;", "getDefaultSegment", "()Lcom/devexpress/editors/layout/SpannableHStack$RowSegmentData;", "height", "", "getHeight", "()I", "setHeight", "(I)V", "<set-?>", "", "orderStops", "getOrderStops", "()Ljava/util/List;", "segments", "", "getSegments", "()Ljava/util/Map;", "segmentsInternal", "", "addSegmentStop", "orderStop", "get", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RowData {
        private int height;
        private List<Integer> orderStops;
        private final Map<Integer, RowSegmentData> segmentsInternal = new LinkedHashMap();

        public final Map<Integer, RowSegmentData> getSegments() {
            return this.segmentsInternal;
        }

        public final RowSegmentData getDefaultSegment() {
            RowSegmentData rowSegmentData = this.segmentsInternal.get(Integer.MIN_VALUE);
            Intrinsics.checkNotNull(rowSegmentData);
            return rowSegmentData;
        }

        public final List<Integer> getOrderStops() {
            List<Integer> list = this.orderStops;
            if (list != null) {
                return list;
            }
            Intrinsics.throwUninitializedPropertyAccessException("orderStops");
            return null;
        }

        public final int getHeight() {
            return this.height;
        }

        public final void setHeight(int i) {
            this.height = i;
        }

        public final RowSegmentData get(int orderStop) {
            RowSegmentData rowSegmentData = this.segmentsInternal.get(Integer.valueOf(orderStop));
            return rowSegmentData == null ? addSegmentStop(orderStop) : rowSegmentData;
        }

        public final RowSegmentData addSegmentStop(int orderStop) {
            RowSegmentData rowSegmentData = new RowSegmentData();
            this.segmentsInternal.put(Integer.valueOf(orderStop), rowSegmentData);
            this.orderStops = CollectionsKt.sorted(this.segmentsInternal.keySet());
            return rowSegmentData;
        }
    }

    /* compiled from: SpannableHStack.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/devexpress/editors/layout/SpannableHStack$RowSegmentData;", "", "()V", "elements", "", "Lcom/devexpress/editors/layout/SpannedElement;", "getElements", "()Ljava/util/List;", "left", "", "getLeft", "()I", "setLeft", "(I)V", "right", "getRight", "setRight", "usedWidthAfter", "getUsedWidthAfter", "setUsedWidthAfter", "usedWidthBefore", "getUsedWidthBefore", "setUsedWidthBefore", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RowSegmentData {
        private int usedWidthAfter;
        private int usedWidthBefore;
        private int left = Integer.MAX_VALUE;
        private int right = Integer.MIN_VALUE;
        private final List<SpannedElement> elements = new ArrayList();

        public final int getUsedWidthBefore() {
            return this.usedWidthBefore;
        }

        public final void setUsedWidthBefore(int i) {
            this.usedWidthBefore = i;
        }

        public final int getUsedWidthAfter() {
            return this.usedWidthAfter;
        }

        public final void setUsedWidthAfter(int i) {
            this.usedWidthAfter = i;
        }

        public final int getLeft() {
            return this.left;
        }

        public final void setLeft(int i) {
            this.left = i;
        }

        public final int getRight() {
            return this.right;
        }

        public final void setRight(int i) {
            this.right = i;
        }

        public final List<SpannedElement> getElements() {
            return this.elements;
        }
    }
}
