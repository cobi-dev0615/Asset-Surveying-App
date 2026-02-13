package com.devexpress.editors.dataForm;

import com.devexpress.editors.dataForm.layout.DataFormHStack;
import com.devexpress.editors.layout.RowSeparatedContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataFormRowManager.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/devexpress/editors/dataForm/DataFormSimpleRowManager;", "Lcom/devexpress/editors/dataForm/DataFormRowManager;", "editorManagers", "", "Lcom/devexpress/editors/dataForm/DataFormEditorManager;", "(Ljava/util/List;)V", "getEditorManagers", "()Ljava/util/List;", "element", "Lcom/devexpress/editors/layout/RowSeparatedContainer;", "getElement", "()Lcom/devexpress/editors/layout/RowSeparatedContainer;", "hStack", "Lcom/devexpress/editors/dataForm/layout/DataFormHStack;", "applyItemSpacing", "", "itemSpacing", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DataFormSimpleRowManager implements DataFormRowManager {
    private final List<DataFormEditorManager> editorManagers;
    private final DataFormHStack hStack;

    public DataFormSimpleRowManager(List<DataFormEditorManager> editorManagers) {
        Intrinsics.checkNotNullParameter(editorManagers, "editorManagers");
        this.editorManagers = editorManagers;
        List<DataFormEditorManager> editorManagers2 = getEditorManagers();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = editorManagers2.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((DataFormEditorManager) it.next()).getElements());
        }
        this.hStack = new DataFormHStack("row", arrayList);
    }

    @Override // com.devexpress.editors.dataForm.DataFormRowManager
    public List<DataFormEditorManager> getEditorManagers() {
        return this.editorManagers;
    }

    @Override // com.devexpress.editors.dataForm.DataFormRowManager
    public RowSeparatedContainer getElement() {
        return this.hStack;
    }

    @Override // com.devexpress.editors.dataForm.DataFormRowManager
    public void applyItemSpacing(int itemSpacing) {
        for (int lastIndex = CollectionsKt.getLastIndex(getEditorManagers()); -1 < lastIndex; lastIndex--) {
            DataFormEditorManager dataFormEditorManager = getEditorManagers().get(lastIndex);
            if (dataFormEditorManager.getEditorInfo().getIsVisible()) {
                if (lastIndex == CollectionsKt.getLastIndex(getEditorManagers())) {
                    dataFormEditorManager.applyItemSpacing(0);
                } else {
                    dataFormEditorManager.applyItemSpacing(itemSpacing);
                }
            }
        }
    }
}
