package com.devexpress.editors.dataForm.layout;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.devexpress.editors.layout.Element;
import com.devexpress.editors.layout.HStack;
import com.devexpress.editors.layout.RowSeparatedContainer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataFormHStack.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J(\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0017H\u0016J\u0018\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0017H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/devexpress/editors/dataForm/layout/DataFormHStack;", "Lcom/devexpress/editors/layout/HStack;", "Lcom/devexpress/editors/layout/RowSeparatedContainer;", "id", "", "children", "", "Lcom/devexpress/editors/layout/Element;", "(Ljava/lang/String;Ljava/util/List;)V", "isLastRow", "", "()Z", "setLastRow", "(Z)V", "isLastRowSeparatorVisible", "setLastRowSeparatorVisible", "separatorDrawable", "Landroid/graphics/drawable/Drawable;", "getSeparatorDrawable", "()Landroid/graphics/drawable/Drawable;", "setSeparatorDrawable", "(Landroid/graphics/drawable/Drawable;)V", "separatorHeight", "", "getSeparatorHeight", "()I", "setSeparatorHeight", "(I)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "layout", "left", "top", "right", "bottom", "measure", "widthSpec", "heightSpec", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DataFormHStack extends HStack implements RowSeparatedContainer {
    private boolean isLastRow;
    private boolean isLastRowSeparatorVisible;
    private Drawable separatorDrawable;
    private int separatorHeight;

    /* JADX WARN: Multi-variable type inference failed */
    public DataFormHStack() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ DataFormHStack(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataFormHStack(String id, List<? extends Element> list) {
        super(id, list, 0, null, 12, null);
        Intrinsics.checkNotNullParameter(id, "id");
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

    @Override // com.devexpress.editors.layout.HStack, com.devexpress.editors.layout.Element
    public void measure(int widthSpec, int heightSpec) {
        if ((!getIsLastRow() || getIsLastRowSeparatorVisible()) && getSeparatorHeight() != 0 && getSeparatorDrawable() != null) {
            setMeasuredSize(measure(getChildren(), widthSpec, heightSpec, getPadding().getHorizontal(), getPadding().getVertical() + getSeparatorHeight()));
        } else {
            super.measure(widthSpec, heightSpec);
        }
    }

    @Override // com.devexpress.editors.layout.HStack, com.devexpress.editors.layout.Element
    public void layout(int left, int top, int right, int bottom) {
        if ((!getIsLastRow() || getIsLastRowSeparatorVisible()) && getSeparatorHeight() != 0 && getSeparatorDrawable() != null) {
            getPadding().resolve(getLayoutDirection());
            int top2 = getPadding().getTop() + top;
            layout(getChildren(), getPadding().getLeft() + left, top2, (bottom - getPadding().getBottom()) - getSeparatorHeight());
            getBounds().set(left, top, right, bottom);
            return;
        }
        super.layout(left, top, right, bottom);
    }

    @Override // com.devexpress.editors.layout.AbstractContainer, com.devexpress.editors.layout.Element
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        Drawable separatorDrawable = getSeparatorDrawable();
        if ((getIsLastRow() && !getIsLastRowSeparatorVisible()) || getSeparatorHeight() == 0 || separatorDrawable == null) {
            return;
        }
        separatorDrawable.setBounds(getBounds().left, getBounds().bottom - getSeparatorHeight(), getBounds().right, getBounds().bottom);
        separatorDrawable.draw(canvas);
    }
}
