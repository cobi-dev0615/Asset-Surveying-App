package com.devexpress.editors.dataForm.layout;

import com.devexpress.editors.layout.Element;
import com.devexpress.editors.layout.SpannedElement;
import com.devexpress.editors.layout.ZStack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataFormItemLabelContainer.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0010\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/devexpress/editors/dataForm/layout/DataFormItemLabelContainer;", "Lcom/devexpress/editors/layout/ZStack;", "Lcom/devexpress/editors/layout/SpannedElement;", "label", "Lcom/devexpress/editors/layout/Element;", "(Lcom/devexpress/editors/layout/Element;)V", "itemOrderInRow", "", "getItemOrderInRow", "()I", "setItemOrderInRow", "(I)V", "value", "getLabel", "()Lcom/devexpress/editors/layout/Element;", "setLabel", "rowIndex", "getRowIndex", "setRowIndex", "rowOrder", "getRowOrder", "setRowOrder", "rowSpan", "getRowSpan", "setRowSpan", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DataFormItemLabelContainer extends ZStack implements SpannedElement {
    private int itemOrderInRow;
    private Element label;
    private int rowIndex;
    private int rowOrder;
    private int rowSpan;

    @Override // com.devexpress.editors.layout.SpannedElement
    public int getBottomRowIndex() {
        return SpannedElement.DefaultImpls.getBottomRowIndex(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataFormItemLabelContainer(Element label) {
        super(null, null, 0, null, 15, null);
        Intrinsics.checkNotNullParameter(label, "label");
        this.label = label;
        addChild(label);
        this.rowIndex = -1;
        this.rowOrder = -1;
        this.rowSpan = 1;
        this.itemOrderInRow = -1;
    }

    public final Element getLabel() {
        return this.label;
    }

    public final void setLabel(Element value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, this.label)) {
            return;
        }
        this.label = value;
        removeAllChildren();
        addChild(this.label);
    }

    @Override // com.devexpress.editors.layout.SpannedElement
    public int getRowIndex() {
        return this.rowIndex;
    }

    @Override // com.devexpress.editors.layout.SpannedElement
    public void setRowIndex(int i) {
        this.rowIndex = i;
    }

    @Override // com.devexpress.editors.layout.SpannedElement
    public int getRowOrder() {
        return this.rowOrder;
    }

    public void setRowOrder(int i) {
        this.rowOrder = i;
    }

    @Override // com.devexpress.editors.layout.SpannedElement
    public int getRowSpan() {
        return this.rowSpan;
    }

    public void setRowSpan(int i) {
        this.rowSpan = i;
    }

    @Override // com.devexpress.editors.layout.SpannedElement
    public int getItemOrderInRow() {
        return this.itemOrderInRow;
    }

    public void setItemOrderInRow(int i) {
        this.itemOrderInRow = i;
    }
}
