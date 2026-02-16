package com.devexpress.editors.layout2;

import com.devexpress.editors.ItemsEditBase;
import com.devexpress.editors.dropdown.utils.Rectangle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FilledLayoutWithCustomInternalEditor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/layout2/FilledLayoutWithCustomInternalEditor;", "Lcom/devexpress/editors/layout2/FilledLayout;", "edit", "Lcom/devexpress/editors/ItemsEditBase;", "(Lcom/devexpress/editors/ItemsEditBase;)V", "calcInternalEditorFrame", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class FilledLayoutWithCustomInternalEditor extends FilledLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilledLayoutWithCustomInternalEditor(ItemsEditBase edit) {
        super(edit);
        Intrinsics.checkNotNullParameter(edit, "edit");
    }

    @Override // com.devexpress.editors.layout2.FilledLayout, com.devexpress.editors.layout2.Layout
    protected void calcInternalEditorFrame() {
        CharSequence labelText = getEdit().getLabelText();
        setInternalEditorFrame(new Rectangle(getContentFrame().getLeft() + getLeadingIconOffset() + getPrefixOffset(), (labelText == null || labelText.length() == 0) ? getContentFrame().getTop() : getContentFrame().getTop() + getLabelTextSize().getHeight(), getInternalEditorFrame().getWidth(), getContentFrame().getHeight()));
    }
}
