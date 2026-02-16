package com.devexpress.editors.dataForm.layout;

import com.devexpress.editors.layout.Element;
import com.devexpress.editors.layout.SpannedElement;
import com.devexpress.editors.layout.VStack;
import com.devexpress.editors.layout.ZStack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataFormItemEditorContainer.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020&H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR(\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\u0015X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u0015X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0019R\u001a\u0010\u001f\u001a\u00020\u0015X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001a\u0010\"\u001a\u00020\u0015X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0017\"\u0004\b$\u0010\u0019¨\u0006("}, d2 = {"Lcom/devexpress/editors/dataForm/layout/DataFormItemEditorContainer;", "Lcom/devexpress/editors/layout/VStack;", "Lcom/devexpress/editors/layout/SpannedElement;", "editorElement", "Lcom/devexpress/editors/layout/Element;", "labelContainer", "helpElement", "errorElement", "(Lcom/devexpress/editors/layout/Element;Lcom/devexpress/editors/layout/Element;Lcom/devexpress/editors/layout/Element;Lcom/devexpress/editors/layout/Element;)V", "bottomTextContainer", "Lcom/devexpress/editors/layout/ZStack;", "value", "getEditorElement", "()Lcom/devexpress/editors/layout/Element;", "setEditorElement", "(Lcom/devexpress/editors/layout/Element;)V", "getErrorElement", "setErrorElement", "getHelpElement", "setHelpElement", "itemOrderInRow", "", "getItemOrderInRow", "()I", "setItemOrderInRow", "(I)V", "getLabelContainer", "setLabelContainer", "rowIndex", "getRowIndex", "setRowIndex", "rowOrder", "getRowOrder", "setRowOrder", "rowSpan", "getRowSpan", "setRowSpan", "updateBottomContainer", "", "updateStructureContainers", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DataFormItemEditorContainer extends VStack implements SpannedElement {
    private final ZStack bottomTextContainer;
    private Element editorElement;
    private Element errorElement;
    private Element helpElement;
    private int itemOrderInRow;
    private Element labelContainer;
    private int rowIndex;
    private int rowOrder;
    private int rowSpan;

    @Override // com.devexpress.editors.layout.SpannedElement
    public int getBottomRowIndex() {
        return SpannedElement.DefaultImpls.getBottomRowIndex(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataFormItemEditorContainer(Element editorElement, Element element, Element element2, Element element3) {
        super(null, null, 0, null, 15, null);
        Intrinsics.checkNotNullParameter(editorElement, "editorElement");
        this.bottomTextContainer = new ZStack(null, null, 0, null, 15, null);
        this.editorElement = editorElement;
        this.helpElement = element2;
        this.errorElement = element3;
        this.labelContainer = element;
        this.rowIndex = -1;
        this.rowOrder = -1;
        this.rowSpan = 1;
        this.itemOrderInRow = -1;
        updateBottomContainer();
        updateStructureContainers();
    }

    public final Element getEditorElement() {
        return this.editorElement;
    }

    public final void setEditorElement(Element value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, this.editorElement)) {
            return;
        }
        this.editorElement = value;
        updateStructureContainers();
    }

    public final Element getHelpElement() {
        return this.helpElement;
    }

    public final void setHelpElement(Element element) {
        if (Intrinsics.areEqual(element, this.helpElement)) {
            return;
        }
        this.helpElement = element;
        updateBottomContainer();
    }

    public final Element getErrorElement() {
        return this.errorElement;
    }

    public final void setErrorElement(Element element) {
        if (Intrinsics.areEqual(element, this.errorElement)) {
            return;
        }
        this.errorElement = element;
        updateBottomContainer();
    }

    public final Element getLabelContainer() {
        return this.labelContainer;
    }

    public final void setLabelContainer(Element element) {
        if (Intrinsics.areEqual(element, this.labelContainer)) {
            return;
        }
        this.labelContainer = element;
        updateStructureContainers();
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

    private final void updateStructureContainers() {
        removeAllChildren();
        Element element = this.labelContainer;
        if (element != null) {
            addChild(element);
        }
        addChild(this.editorElement);
        addChild(this.bottomTextContainer);
    }

    private final void updateBottomContainer() {
        Element element = this.helpElement;
        if (element != null) {
            this.bottomTextContainer.addChild(element);
        }
        Element element2 = this.errorElement;
        if (element2 != null) {
            this.bottomTextContainer.addChild(element2);
        }
    }
}
