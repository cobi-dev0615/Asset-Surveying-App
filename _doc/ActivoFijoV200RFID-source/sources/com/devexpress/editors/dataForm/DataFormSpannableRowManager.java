package com.devexpress.editors.dataForm;

import com.devexpress.editors.dataForm.protocols.DataFormEditorInfo;
import com.devexpress.editors.layout.RowSeparatedContainer;
import com.devexpress.editors.layout.SpannableHStack;
import com.devexpress.editors.utils.UtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: DataFormRowManager.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001eB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0014H\u0002R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/devexpress/editors/dataForm/DataFormSpannableRowManager;", "Lcom/devexpress/editors/dataForm/DataFormRowManager;", "editorManagers", "", "Lcom/devexpress/editors/dataForm/DataFormEditorManager;", "(Ljava/util/List;)V", "getEditorManagers", "()Ljava/util/List;", "element", "Lcom/devexpress/editors/layout/RowSeparatedContainer;", "getElement", "()Lcom/devexpress/editors/layout/RowSeparatedContainer;", "layoutDescriptionMappings", "", "Lcom/devexpress/editors/dataForm/DataFormSpannableRowManager$SpannedEditorLayout;", "spannableHStack", "Lcom/devexpress/editors/layout/SpannableHStack;", "applyItemSpacing", "", "itemSpacing", "", "collectLayoutDescriptions", "isLastInRow", "", "managerToCheck", "layoutToCheck", "normalizedRowRange", "Lkotlin/ranges/IntRange;", "rowIndex", "rowSpan", "SpannedEditorLayout", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DataFormSpannableRowManager implements DataFormRowManager {
    private final List<DataFormEditorManager> editorManagers;
    private final Map<DataFormEditorManager, SpannedEditorLayout> layoutDescriptionMappings;
    private final SpannableHStack spannableHStack;

    public DataFormSpannableRowManager(List<DataFormEditorManager> editorManagers) {
        Intrinsics.checkNotNullParameter(editorManagers, "editorManagers");
        this.editorManagers = editorManagers;
        List<DataFormEditorManager> editorManagers2 = getEditorManagers();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = editorManagers2.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((DataFormEditorManager) it.next()).getElements());
        }
        this.layoutDescriptionMappings = collectLayoutDescriptions();
        this.spannableHStack = new SpannableHStack("spanned_row", arrayList);
    }

    @Override // com.devexpress.editors.dataForm.DataFormRowManager
    public List<DataFormEditorManager> getEditorManagers() {
        return this.editorManagers;
    }

    @Override // com.devexpress.editors.dataForm.DataFormRowManager
    public RowSeparatedContainer getElement() {
        return this.spannableHStack;
    }

    @Override // com.devexpress.editors.dataForm.DataFormRowManager
    public void applyItemSpacing(int itemSpacing) {
        if (getEditorManagers().isEmpty()) {
            return;
        }
        for (Map.Entry<DataFormEditorManager, SpannedEditorLayout> entry : this.layoutDescriptionMappings.entrySet()) {
            DataFormEditorManager key = entry.getKey();
            SpannedEditorLayout value = entry.getValue();
            if (key.isVisible() && !isLastInRow(key, value)) {
                key.applyItemSpacing(itemSpacing);
            } else if (key.isVisible() && isLastInRow(key, value)) {
                key.applyItemSpacing(0);
            }
        }
    }

    private final Map<DataFormEditorManager, SpannedEditorLayout> collectLayoutDescriptions() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (getEditorManagers().isEmpty()) {
            return linkedHashMap;
        }
        int i = 0;
        int rowIndex = getEditorManagers().get(0).getEditorInfo().getRowIndex();
        for (DataFormEditorManager dataFormEditorManager : getEditorManagers()) {
            DataFormEditorInfo editorInfo = dataFormEditorManager.getEditorInfo();
            if (editorInfo.getRowIndex() > rowIndex) {
                rowIndex = editorInfo.getRowIndex();
                i++;
            }
            linkedHashMap.put(dataFormEditorManager, new SpannedEditorLayout(editorInfo.getRowItemIndex(), normalizedRowRange(i, editorInfo.getRowSpan())));
        }
        return linkedHashMap;
    }

    private final boolean isLastInRow(DataFormEditorManager managerToCheck, SpannedEditorLayout layoutToCheck) {
        for (Map.Entry<DataFormEditorManager, SpannedEditorLayout> entry : this.layoutDescriptionMappings.entrySet()) {
            DataFormEditorManager key = entry.getKey();
            SpannedEditorLayout value = entry.getValue();
            if (key.isVisible() && UtilsKt.intersects(value.getRowRange(), layoutToCheck.getRowRange())) {
                if (value.getColumnOrder() > layoutToCheck.getColumnOrder()) {
                    return false;
                }
                if (value.getColumnOrder() == layoutToCheck.getColumnOrder() && getEditorManagers().indexOf(key) > getEditorManagers().indexOf(managerToCheck)) {
                    return false;
                }
            }
        }
        return true;
    }

    private final IntRange normalizedRowRange(int rowIndex, int rowSpan) {
        return new IntRange(rowIndex, Math.max(0, rowSpan - 1) + rowIndex);
    }

    /* compiled from: DataFormRowManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/devexpress/editors/dataForm/DataFormSpannableRowManager$SpannedEditorLayout;", "", "columnOrder", "", "rowRange", "Lkotlin/ranges/IntRange;", "(ILkotlin/ranges/IntRange;)V", "getColumnOrder", "()I", "getRowRange", "()Lkotlin/ranges/IntRange;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SpannedEditorLayout {
        private final int columnOrder;
        private final IntRange rowRange;

        public SpannedEditorLayout(int i, IntRange rowRange) {
            Intrinsics.checkNotNullParameter(rowRange, "rowRange");
            this.columnOrder = i;
            this.rowRange = rowRange;
        }

        public final int getColumnOrder() {
            return this.columnOrder;
        }

        public final IntRange getRowRange() {
            return this.rowRange;
        }
    }
}
