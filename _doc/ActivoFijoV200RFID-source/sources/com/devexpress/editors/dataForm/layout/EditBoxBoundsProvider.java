package com.devexpress.editors.dataForm.layout;

import com.devexpress.editors.EditBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoxBoundsProvider.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/devexpress/editors/dataForm/layout/EditBoxBoundsProvider;", "Lcom/devexpress/editors/dataForm/layout/BoxBoundsProvider;", "edit", "Lcom/devexpress/editors/EditBase;", "(Lcom/devexpress/editors/EditBase;)V", "centerY", "", "getCenterY", "()I", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EditBoxBoundsProvider implements BoxBoundsProvider {
    private final EditBase edit;

    public EditBoxBoundsProvider(EditBase edit) {
        Intrinsics.checkNotNullParameter(edit, "edit");
        this.edit = edit;
    }

    @Override // com.devexpress.editors.dataForm.layout.BoxBoundsProvider
    public int getCenterY() {
        return this.edit.getBoxRect().centerY();
    }
}
