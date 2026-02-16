package com.devexpress.editors.dataForm;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.util.Size;
import android.view.ViewGroup;
import com.devexpress.editors.dataForm.protocols.DXDataFormDataProvider;
import com.devexpress.editors.dataForm.protocols.DXDataFormEditorItem;
import com.devexpress.editors.dataForm.protocols.DataFormEditorFactory;
import com.devexpress.editors.dataForm.protocols.DataFormEditorInfo;
import com.devexpress.editors.dataForm.protocols.DataFormItemDataProvider;
import com.devexpress.editors.dataForm.protocols.EditorType;
import com.devexpress.editors.dataForm.protocols.ExpanderInfo;
import com.devexpress.editors.layout.Element;
import com.devexpress.editors.layout.RowSeparatedContainer;
import com.devexpress.editors.layout.VStack;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataFormGroup.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bJ\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\u0016\u0010\u001f\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120!H\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\tH\u0002J\u0018\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*2\u0006\u0010'\u001a\u00020\tH\u0002J$\u0010+\u001a\u00020\u00172\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020*0-H\u0002J$\u0010/\u001a\u00020\u00172\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020*0-H\u0002J\u0010\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u000202H\u0016J\u000e\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\tJ\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000f06J\u0018\u00107\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*2\u0006\u0010'\u001a\u00020\tH\u0002J\b\u00108\u001a\u00020\u001bH\u0002J\u000e\u00109\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\tJ\u0018\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020\tH\u0002J0\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020;2\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\t2\u0006\u0010C\u001a\u00020\tH\u0014J\u0018\u0010D\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\tH\u0014J4\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020\t2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020*0-2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010J\u001a\u00020\tH\u0002J\u0016\u0010K\u001a\u00020\u001b2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020*0-H\u0002J\u0006\u0010L\u001a\u00020\u001bJ\b\u0010M\u001a\u00020\u001bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/devexpress/editors/dataForm/GroupContent;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "factory", "Lcom/devexpress/editors/dataForm/protocols/DataFormEditorFactory;", "dataProvider", "Lcom/devexpress/editors/dataForm/protocols/DXDataFormDataProvider;", "groupId", "", "groupInfo", "Lcom/devexpress/editors/dataForm/protocols/ExpanderInfo;", "(Landroid/content/Context;Lcom/devexpress/editors/dataForm/protocols/DataFormEditorFactory;Lcom/devexpress/editors/dataForm/protocols/DXDataFormDataProvider;ILcom/devexpress/editors/dataForm/protocols/ExpanderInfo;)V", "editorManagers", "", "Lcom/devexpress/editors/dataForm/DataFormEditorManager;", "editorManagersByUniqueId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getGroupId", "()I", "rowManagers", "Lcom/devexpress/editors/dataForm/DataFormRowManager;", "vStack", "Lcom/devexpress/editors/layout/VStack;", "applySettings", "", "settings", "applySettingsToRow", "row", "cleanupUnusedCachedItems", "actualFieldNames", "", "create", "createEditorItem", "Lcom/devexpress/editors/dataForm/protocols/DXDataFormEditorItem;", "editorType", "Lcom/devexpress/editors/dataForm/protocols/EditorType;", "editorIndex", "createEditorManager", "editorInfo", "Lcom/devexpress/editors/dataForm/protocols/DataFormEditorInfo;", "createSimpleRow", "editorIndices", "", "editorInfos", "createSpannedRow", "draw", "canvas", "Landroid/graphics/Canvas;", "getEditorManager", "editorId", "getEditorManagers", "", "getOrCreateEditorManager", "initViews", "invalidateEditor", "isInSpannedRow", "", "item", "lastSpannedRowIndex", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "populateRowElementsWithItemsInSpan", "spannedItemIndexInRow", "rowItemIndices", "startSearchIndex", "populateVStackWithElements", "recreate", "setLastSeparatorVisibility", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GroupContent extends ViewGroup {
    private final DXDataFormDataProvider dataProvider;
    private final List<DataFormEditorManager> editorManagers;
    private final HashMap<String, DataFormEditorManager> editorManagersByUniqueId;
    private final DataFormEditorFactory factory;
    private final int groupId;
    private ExpanderInfo groupInfo;
    private final List<DataFormRowManager> rowManagers;
    private VStack vStack;

    public final int getGroupId() {
        return this.groupId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupContent(Context context, DataFormEditorFactory factory, DXDataFormDataProvider dataProvider, int i, ExpanderInfo groupInfo) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(dataProvider, "dataProvider");
        Intrinsics.checkNotNullParameter(groupInfo, "groupInfo");
        this.factory = factory;
        this.dataProvider = dataProvider;
        this.groupId = i;
        this.groupInfo = groupInfo;
        this.editorManagers = new ArrayList();
        this.rowManagers = new ArrayList();
        this.vStack = new VStack(null, null, 0, null, 15, null);
        this.editorManagersByUniqueId = new HashMap<>();
        initViews();
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setWillNotDraw(false);
        applySettings(this.groupInfo);
    }

    private final void initViews() {
        create();
    }

    public final void recreate() {
        this.editorManagers.clear();
        this.rowManagers.clear();
        initViews();
        requestLayout();
    }

    public final void applySettings(ExpanderInfo settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.groupInfo = settings;
        int separatorColor = settings.getSeparatorColor();
        ColorDrawable colorDrawable = separatorColor != 0 ? new ColorDrawable(separatorColor) : null;
        int separatorThickness = settings.getSeparatorThickness();
        boolean isLastRowSeparatorVisible = settings.getIsLastRowSeparatorVisible();
        int editorSpacing = settings.getEditorSpacing();
        int i = 0;
        for (DataFormRowManager dataFormRowManager : this.rowManagers) {
            RowSeparatedContainer element = dataFormRowManager.getElement();
            element.setSeparatorDrawable(colorDrawable);
            element.setSeparatorHeight(separatorThickness);
            element.setLastRowSeparatorVisible(isLastRowSeparatorVisible);
            boolean z = true;
            if (i != this.rowManagers.size() - 1) {
                z = false;
            }
            element.setLastRow(z);
            dataFormRowManager.applyItemSpacing(editorSpacing);
            i++;
        }
        if (settings.getContentBackgroundColor() != 0) {
            setBackgroundColor(settings.getContentBackgroundColor());
        } else {
            setBackground(null);
        }
        this.vStack.getPadding().set(settings.getContentPadding());
    }

    private final void applySettingsToRow(DataFormRowManager row) {
        RowSeparatedContainer element = row.getElement();
        element.setSeparatorDrawable(this.groupInfo.getSeparatorColor() != 0 ? new ColorDrawable(this.groupInfo.getSeparatorColor()) : null);
        element.setSeparatorHeight(this.groupInfo.getSeparatorThickness());
        element.setLastRowSeparatorVisible(this.groupInfo.getIsLastRowSeparatorVisible());
        row.applyItemSpacing(this.groupInfo.getEditorSpacing());
    }

    public final void invalidateEditor(int editorId) {
        if (this.editorManagers.size() > editorId) {
            DataFormEditorManager dataFormEditorManager = this.editorManagers.get(editorId);
            dataFormEditorManager.invalidateSettings();
            for (DataFormRowManager dataFormRowManager : this.rowManagers) {
                if (dataFormRowManager.getEditorManagers().contains(dataFormEditorManager)) {
                    applySettingsToRow(dataFormRowManager);
                    requestLayout();
                    return;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
    }

    private final void setLastSeparatorVisibility() {
        Iterator<DataFormRowManager> it = this.rowManagers.iterator();
        while (it.hasNext()) {
            it.next().getElement().setLastRowSeparatorVisible(true);
        }
        if (this.groupInfo.getIsLastRowSeparatorVisible()) {
            return;
        }
        for (int lastIndex = CollectionsKt.getLastIndex(this.rowManagers); -1 < lastIndex; lastIndex--) {
            RowSeparatedContainer element = this.rowManagers.get(lastIndex).getElement();
            List<Element> children = element.getChildren();
            if (!(children instanceof Collection) || !children.isEmpty()) {
                Iterator<T> it2 = children.iterator();
                while (it2.hasNext()) {
                    if (((Element) it2.next()).isVisible()) {
                        element.setLastRowSeparatorVisible(this.groupInfo.getIsLastRowSeparatorVisible());
                        return;
                    }
                }
            }
        }
    }

    public final Collection<DataFormEditorManager> getEditorManagers() {
        return this.editorManagers;
    }

    public final DataFormEditorManager getEditorManager(int editorId) {
        return this.editorManagers.get(editorId);
    }

    private final void create() {
        List<DataFormEditorInfo> editors = this.dataProvider.getEditors(this.groupId);
        if (editors != null) {
            populateVStackWithElements(editors);
            setLastSeparatorVisibility();
            List<DataFormEditorInfo> list = editors;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((DataFormEditorInfo) it.next()).getUniqueId());
            }
            cleanupUnusedCachedItems(new HashSet(arrayList));
            return;
        }
        cleanupUnusedCachedItems();
    }

    private final void populateVStackWithElements(List<? extends DataFormEditorInfo> editorInfos) {
        DataFormRowManager createSpannedRow;
        this.vStack.removeAllChildren();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < editorInfos.size()) {
            DataFormEditorInfo dataFormEditorInfo = editorInfos.get(i);
            if (i2 < dataFormEditorInfo.getRowSpan()) {
                i2 = dataFormEditorInfo.getRowSpan();
                i3 = arrayList.size();
            }
            arrayList.add(Integer.valueOf(i));
            boolean isLastElementInLine = this.dataProvider.isLastElementInLine(this.groupId, i);
            if (CollectionsKt.getLastIndex(editorInfos) == i || isLastElementInLine) {
                if (i2 <= 1) {
                    createSpannedRow = createSimpleRow(arrayList, editorInfos);
                } else {
                    i = populateRowElementsWithItemsInSpan(i3, editorInfos, arrayList, i);
                    createSpannedRow = createSpannedRow(arrayList, editorInfos);
                }
                this.rowManagers.add(createSpannedRow);
                applySettingsToRow(createSpannedRow);
                this.vStack.addChild(createSpannedRow.getElement());
                arrayList.clear();
                i3 = -1;
                i2 = 0;
            }
            i++;
        }
    }

    private final DataFormRowManager createSimpleRow(List<Integer> editorIndices, List<? extends DataFormEditorInfo> editorInfos) {
        List<Integer> list = editorIndices;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            arrayList.add(getOrCreateEditorManager(editorInfos.get(intValue), intValue));
        }
        return new DataFormSimpleRowManager(arrayList);
    }

    private final DataFormRowManager createSpannedRow(List<Integer> editorIndices, List<? extends DataFormEditorInfo> editorInfos) {
        List<Integer> list = editorIndices;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            arrayList.add(getOrCreateEditorManager(editorInfos.get(intValue), intValue));
        }
        return new DataFormSpannableRowManager(arrayList);
    }

    private final int populateRowElementsWithItemsInSpan(int spannedItemIndexInRow, List<? extends DataFormEditorInfo> editorInfos, List<Integer> rowItemIndices, int startSearchIndex) {
        DataFormEditorInfo dataFormEditorInfo;
        DataFormEditorInfo dataFormEditorInfo2 = editorInfos.get(rowItemIndices.get(spannedItemIndexInRow).intValue());
        int i = startSearchIndex + 1;
        if (i >= editorInfos.size()) {
            return startSearchIndex;
        }
        int rowIndex = (dataFormEditorInfo2.getRowIndex() + dataFormEditorInfo2.getRowSpan()) - 1;
        DataFormEditorInfo dataFormEditorInfo3 = editorInfos.get(i);
        while (true) {
            dataFormEditorInfo = dataFormEditorInfo3;
            if (i >= CollectionsKt.getLastIndex(editorInfos) || !isInSpannedRow(dataFormEditorInfo, rowIndex)) {
                break;
            }
            int rowIndex2 = (dataFormEditorInfo.getRowIndex() + dataFormEditorInfo.getRowSpan()) - 1;
            if (rowIndex2 > rowIndex) {
                rowIndex = rowIndex2;
            }
            rowItemIndices.add(Integer.valueOf(i));
            i++;
            dataFormEditorInfo3 = editorInfos.get(i);
        }
        if (isInSpannedRow(dataFormEditorInfo, rowIndex)) {
            rowItemIndices.add(Integer.valueOf(i));
            i++;
        }
        return i - 1;
    }

    private final boolean isInSpannedRow(DataFormEditorInfo item, int lastSpannedRowIndex) {
        return item.getRowIndex() <= lastSpannedRowIndex && item.getRowIndex() >= 0;
    }

    private final void cleanupUnusedCachedItems(Set<String> actualFieldNames) {
        Set<String> keySet = this.editorManagersByUniqueId.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : keySet) {
            if (!actualFieldNames.contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        for (String str : arrayList) {
            DataFormEditorManager dataFormEditorManager = this.editorManagersByUniqueId.get(str);
            Intrinsics.checkNotNull(dataFormEditorManager);
            dataFormEditorManager.removeViewsFrom(this);
            this.editorManagersByUniqueId.remove(str);
        }
    }

    private final void cleanupUnusedCachedItems() {
        Iterator<Map.Entry<String, DataFormEditorManager>> it = this.editorManagersByUniqueId.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().removeViewsFrom(this);
        }
        this.editorManagersByUniqueId.clear();
    }

    private final DataFormEditorManager getOrCreateEditorManager(DataFormEditorInfo editorInfo, int editorIndex) {
        DataFormEditorManager dataFormEditorManager = this.editorManagersByUniqueId.get(editorInfo.getUniqueId());
        if (dataFormEditorManager == null) {
            dataFormEditorManager = createEditorManager(editorInfo, editorIndex);
            this.editorManagersByUniqueId.put(editorInfo.getUniqueId(), dataFormEditorManager);
        } else {
            DataFormItemDataProvider dataSource = dataFormEditorManager.getDataSource();
            DataFormItemDataProviderImpl dataFormItemDataProviderImpl = dataSource instanceof DataFormItemDataProviderImpl ? (DataFormItemDataProviderImpl) dataSource : null;
            if (dataFormItemDataProviderImpl != null) {
                dataFormItemDataProviderImpl.setEditorId(editorIndex);
                dataFormEditorManager.invalidateSettings();
            }
        }
        this.editorManagers.add(dataFormEditorManager);
        return dataFormEditorManager;
    }

    private final DataFormEditorManager createEditorManager(DataFormEditorInfo editorInfo, int editorIndex) {
        DXDataFormEditorItem createEditorItem = createEditorItem(editorInfo.getType(), editorIndex);
        DataFormItemDataProviderImpl dataFormItemDataProviderImpl = new DataFormItemDataProviderImpl(this.dataProvider, this.groupId, editorIndex);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        DataFormEditorManager dataFormEditorManager = new DataFormEditorManager(context, dataFormItemDataProviderImpl, createEditorItem, editorInfo);
        dataFormEditorManager.addViewsTo(this);
        return dataFormEditorManager;
    }

    private final DXDataFormEditorItem createEditorItem(EditorType editorType, int editorIndex) {
        DataFormEditorFactory dataFormEditorFactory = this.factory;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        DXDataFormEditorItem create = dataFormEditorFactory.create(context, editorType, this.groupId, editorIndex);
        create.configure();
        return create;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.vStack.measure(widthMeasureSpec, heightMeasureSpec);
        Size measuredSize = this.vStack.getMeasuredSize();
        setMeasuredDimension(measuredSize.getWidth(), measuredSize.getHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.vStack.layout(0, 0, r - l, b - t);
        Iterator<DataFormEditorManager> it = this.editorManagers.iterator();
        while (it.hasNext()) {
            it.next().adjustLabelLayout();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.vStack.draw(canvas);
        super.draw(canvas);
    }
}
