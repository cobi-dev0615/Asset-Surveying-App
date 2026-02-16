package com.devexpress.editors;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.widget.NestedScrollView;
import com.devexpress.dxcore.DXNativeView;
import com.devexpress.editors.dataForm.DataFormContent;
import com.devexpress.editors.dataForm.DataFormEditorManager;
import com.devexpress.editors.dataForm.ExpanderView;
import com.devexpress.editors.dataForm.GroupContent;
import com.devexpress.editors.dataForm.protocols.DXDataFormDataProvider;
import com.devexpress.editors.dataForm.protocols.DataFormEditorFactory;
import com.devexpress.editors.dataForm.protocols.DataFormValuesValidationErrors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: DataFormView.kt */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010*\u001a\u00020+J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\bJ\u0010\u0010.\u001a\u00020+2\u0006\u0010\u0010\u001a\u00020/H\u0016J\u0018\u00100\u001a\u0002012\u0006\u00102\u001a\u00020/2\u0006\u00103\u001a\u00020/H\u0002J\u0018\u00104\u001a\u0004\u0018\u0001052\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\bJ\u0018\u00106\u001a\u0004\u0018\u0001072\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\bJ\u0012\u00108\u001a\u0004\u0018\u0001092\u0006\u0010,\u001a\u00020\bH\u0002J\u000e\u0010:\u001a\u00020+2\u0006\u0010,\u001a\u00020\bJ\u0006\u0010;\u001a\u00020+J\b\u0010<\u001a\u00020+H\u0002J\u0016\u0010=\u001a\u00020+2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010>\u001a\u00020?J\u0016\u0010@\u001a\u00020+2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\bJ\u000e\u0010A\u001a\u00020+2\u0006\u0010,\u001a\u00020\bJ\u0018\u0010B\u001a\u00020+2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u001dH\u0016J\u0018\u0010F\u001a\u00020+2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bH\u0002J0\u0010I\u001a\u00020+2\u0006\u0010J\u001a\u00020\u001d2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\bH\u0014J\u0018\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\bH\u0014J\u0010\u0010S\u001a\u00020\u001d2\u0006\u0010T\u001a\u00020UH\u0016J\u0016\u0010V\u001a\u00020+2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\bJ\u0012\u0010W\u001a\u00020+2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\u0010\u0010Z\u001a\u00020+2\u0006\u0010T\u001a\u00020UH\u0002J\u0006\u0010[\u001a\u00020\u001dJ\u0016\u0010[\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\bJ,\u0010\\\u001a\u00020\u001d2\"\u0010]\u001a\u001e\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u0002050^j\u000e\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u000205``H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/devexpress/editors/DataFormView;", "Lcom/devexpress/dxcore/DXNativeView;", "Lcom/devexpress/editors/ExpanderListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "changedListener", "Lcom/devexpress/editors/OnDataFromChangedListener;", "getChangedListener", "()Lcom/devexpress/editors/OnDataFromChangedListener;", "setChangedListener", "(Lcom/devexpress/editors/OnDataFromChangedListener;)V", "content", "Lcom/devexpress/editors/dataForm/DataFormContent;", "getContent", "()Lcom/devexpress/editors/dataForm/DataFormContent;", "setContent", "(Lcom/devexpress/editors/dataForm/DataFormContent;)V", "dataProvider", "Lcom/devexpress/editors/dataForm/protocols/DXDataFormDataProvider;", "getDataProvider", "()Lcom/devexpress/editors/dataForm/protocols/DXDataFormDataProvider;", "setDataProvider", "(Lcom/devexpress/editors/dataForm/protocols/DXDataFormDataProvider;)V", "inMove", "", "getInMove", "()Z", "setInMove", "(Z)V", "scrollView", "Landroidx/core/widget/NestedScrollView;", "getScrollView", "()Landroidx/core/widget/NestedScrollView;", "setScrollView", "(Landroidx/core/widget/NestedScrollView;)V", "watermarkImageView", "Landroid/widget/ImageView;", "commit", "", "groupId", "editorId", "contentSizeChanged", "Landroid/view/View;", "getAbsolutePoint", "Landroid/graphics/Rect;", "child", "parent", "getEditor", "Lcom/devexpress/editors/dataForm/DataFormEditorManager;", "getEditorValue", "", "getGroup", "Lcom/devexpress/editors/dataForm/GroupContent;", "groupStructureChanged", "groupsStructureChanged", "initWatermark", "initialize", "factory", "Lcom/devexpress/editors/dataForm/protocols/DataFormEditorFactory;", "invalidateEditor", "invalidateGroup", "isExpanderCollapsed", "expander", "Lcom/devexpress/editors/dataForm/ExpanderView;", "isCollapsed", "layoutWatermark", "width", "height", "onLayout", "changed", "l", "t", "r", "b", "onMeasureCore", "Landroid/util/Size;", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "resetEditorValue", "setLayoutParams", "params", "Landroid/view/ViewGroup$LayoutParams;", "updateActiveEditorByEvent", "validate", "validateValues", "editorsMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DataFormView extends DXNativeView implements ExpanderListener {
    private OnDataFromChangedListener changedListener;
    private DataFormContent content;
    private DXDataFormDataProvider dataProvider;
    private boolean inMove;
    private NestedScrollView scrollView;
    private ImageView watermarkImageView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DataFormView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataFormView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.scrollView = new NestedScrollView(context);
    }

    public final NestedScrollView getScrollView() {
        return this.scrollView;
    }

    public final void setScrollView(NestedScrollView nestedScrollView) {
        Intrinsics.checkNotNullParameter(nestedScrollView, "<set-?>");
        this.scrollView = nestedScrollView;
    }

    public final DataFormContent getContent() {
        return this.content;
    }

    public final void setContent(DataFormContent dataFormContent) {
        this.content = dataFormContent;
    }

    public final DXDataFormDataProvider getDataProvider() {
        return this.dataProvider;
    }

    public final void setDataProvider(DXDataFormDataProvider dXDataFormDataProvider) {
        this.dataProvider = dXDataFormDataProvider;
    }

    public final OnDataFromChangedListener getChangedListener() {
        return this.changedListener;
    }

    public final void setChangedListener(OnDataFromChangedListener onDataFromChangedListener) {
        this.changedListener = onDataFromChangedListener;
    }

    public final boolean getInMove() {
        return this.inMove;
    }

    public final void setInMove(boolean z) {
        this.inMove = z;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getActionMasked() == 2) {
            this.inMove = true;
        }
        if (ev.getActionMasked() == 1 && !this.inMove) {
            updateActiveEditorByEvent(ev);
        }
        if (ev.getActionMasked() == 1 || ev.getActionMasked() == 3) {
            this.inMove = false;
        }
        return super.onTouchEvent(ev);
    }

    private final void layoutWatermark(int width, int height) {
        ImageView imageView = this.watermarkImageView;
        if (imageView == null) {
            return;
        }
        Intrinsics.checkNotNull(imageView);
        int maxWidth = imageView.getMaxWidth();
        ImageView imageView2 = this.watermarkImageView;
        Intrinsics.checkNotNull(imageView2);
        int maxHeight = imageView2.getMaxHeight();
        int i = (width / 2) - (maxWidth / 2);
        int i2 = (height / 2) - (maxHeight / 2);
        ImageView imageView3 = this.watermarkImageView;
        Intrinsics.checkNotNull(imageView3);
        imageView3.layout(i, i2, maxWidth + i, maxHeight + i2);
    }

    private final void updateActiveEditorByEvent(MotionEvent ev) {
        int round = Math.round(ev.getX());
        int round2 = Math.round(ev.getY());
        DataFormContent dataFormContent = this.content;
        Intrinsics.checkNotNull(dataFormContent);
        Iterator<GroupContent> it = dataFormContent.getGroups().iterator();
        while (it.hasNext()) {
            for (DataFormEditorManager dataFormEditorManager : it.next().getEditorManagers()) {
                Rect absolutePoint = getAbsolutePoint(dataFormEditorManager.getEditorView(), this);
                absolutePoint.offset(-this.scrollView.getScrollX(), -this.scrollView.getScrollY());
                if (absolutePoint.contains(round, round2)) {
                    dataFormEditorManager.getEditorView().requestFocus();
                }
            }
        }
    }

    private final Rect getAbsolutePoint(View child, View parent) {
        int i = 0;
        View view = child;
        int i2 = 0;
        while (!Intrinsics.areEqual(view, parent) && view.getParent() != null) {
            i += view.getLeft();
            i2 += view.getTop();
            Object parent2 = view.getParent();
            Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
            view = (View) parent2;
        }
        return new Rect(i, i2, child.getWidth() + i, child.getHeight() + i2);
    }

    private final GroupContent getGroup(int groupId) {
        ArrayList<GroupContent> groups;
        DataFormContent dataFormContent = this.content;
        Object obj = null;
        if ((dataFormContent != null ? dataFormContent.getGroups() : null) == null) {
            return null;
        }
        DataFormContent dataFormContent2 = this.content;
        Integer valueOf = (dataFormContent2 == null || (groups = dataFormContent2.getGroups()) == null) ? null : Integer.valueOf(groups.size());
        Intrinsics.checkNotNull(valueOf);
        int intValue = valueOf.intValue();
        if (groupId >= 0 && groupId < intValue) {
            DataFormContent dataFormContent3 = this.content;
            Intrinsics.checkNotNull(dataFormContent3);
            return dataFormContent3.getGroups().get(groupId);
        }
        if (groupId != -1) {
            return null;
        }
        DataFormContent dataFormContent4 = this.content;
        Intrinsics.checkNotNull(dataFormContent4);
        Iterator<T> it = dataFormContent4.getGroups().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((GroupContent) next).getGroupId() == groupId) {
                obj = next;
                break;
            }
        }
        return (GroupContent) obj;
    }

    public final DataFormEditorManager getEditor(int groupId, int editorId) {
        GroupContent group = getGroup(groupId);
        if (group == null) {
            return null;
        }
        return group.getEditorManager(editorId);
    }

    public final Object getEditorValue(int groupId, int editorId) {
        DataFormEditorManager editor = getEditor(groupId, editorId);
        if (editor != null) {
            return editor.getValue();
        }
        return null;
    }

    public final void resetEditorValue(int groupId, int editorId) {
        DataFormEditorManager editor = getEditor(groupId, editorId);
        if (editor != null) {
            editor.resetValue();
        }
    }

    public final boolean validate(int groupId, int editorId) {
        DataFormEditorManager editor = getEditor(groupId, editorId);
        Boolean valueOf = editor != null ? Boolean.valueOf(editor.validate()) : null;
        Intrinsics.checkNotNull(valueOf);
        return valueOf.booleanValue();
    }

    public final boolean validate() {
        HashMap<String, DataFormEditorManager> hashMap = new HashMap<>();
        DataFormContent dataFormContent = this.content;
        ArrayList<GroupContent> groups = dataFormContent != null ? dataFormContent.getGroups() : null;
        if (groups == null) {
            return true;
        }
        Iterator<GroupContent> it = groups.iterator();
        boolean z = true;
        while (it.hasNext()) {
            for (DataFormEditorManager dataFormEditorManager : it.next().getEditorManagers()) {
                z = dataFormEditorManager.validate() && z;
                hashMap.put(dataFormEditorManager.getEditorInfo().getFieldName(), dataFormEditorManager);
            }
        }
        return validateValues(hashMap) && z;
    }

    private final boolean validateValues(HashMap<String, DataFormEditorManager> editorsMap) {
        HashMap<String, DataFormEditorManager> hashMap = editorsMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(hashMap.size()));
        Iterator<T> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((DataFormEditorManager) entry.getValue()).getValue());
        }
        DXDataFormDataProvider dXDataFormDataProvider = this.dataProvider;
        DataFormValuesValidationErrors validateValues = dXDataFormDataProvider != null ? dXDataFormDataProvider.validateValues(linkedHashMap) : null;
        if (validateValues == null || !validateValues.getHasErrors()) {
            return true;
        }
        for (Map.Entry<String, String> entry2 : validateValues.getErrors().entrySet()) {
            DataFormEditorManager dataFormEditorManager = editorsMap.get(entry2.getKey());
            if (dataFormEditorManager != null) {
                dataFormEditorManager.updateError(true, entry2.getValue());
            }
        }
        return false;
    }

    public final void commit(int groupId, int editorId) {
        DataFormEditorManager editor = getEditor(groupId, editorId);
        if (editor != null) {
            editor.commit();
        }
    }

    public final void commit() {
        DataFormContent dataFormContent = this.content;
        ArrayList<GroupContent> groups = dataFormContent != null ? dataFormContent.getGroups() : null;
        Intrinsics.checkNotNull(groups);
        Iterator<GroupContent> it = groups.iterator();
        while (it.hasNext()) {
            Iterator<DataFormEditorManager> it2 = it.next().getEditorManagers().iterator();
            while (it2.hasNext()) {
                it2.next().commit();
            }
        }
    }

    public final void invalidateGroup(int groupId) {
        Collection<DataFormEditorManager> editorManagers;
        DataFormContent dataFormContent = this.content;
        if (dataFormContent != null) {
            dataFormContent.applySettingsToGroup(groupId);
        }
        GroupContent group = getGroup(groupId);
        if (group == null || (editorManagers = group.getEditorManagers()) == null) {
            return;
        }
        Iterator<T> it = editorManagers.iterator();
        while (it.hasNext()) {
            ((DataFormEditorManager) it.next()).applySettings();
        }
    }

    public final void groupsStructureChanged() {
        DataFormContent dataFormContent = this.content;
        if (dataFormContent != null) {
            dataFormContent.recreateGroups();
            Iterator<GroupContent> it = dataFormContent.getGroups().iterator();
            while (it.hasNext()) {
                groupStructureChanged(it.next().getGroupId());
            }
        }
    }

    public final void groupStructureChanged(int groupId) {
        DataFormContent dataFormContent = this.content;
        if (dataFormContent != null) {
            Intrinsics.checkNotNull(dataFormContent);
            dataFormContent.getGroups();
            DataFormContent dataFormContent2 = this.content;
            Intrinsics.checkNotNull(dataFormContent2);
            if (dataFormContent2.getGroups().size() == 0) {
                groupsStructureChanged();
                return;
            }
        }
        GroupContent group = getGroup(groupId);
        if (group == null) {
            return;
        }
        group.recreate();
    }

    public final void invalidateEditor(int groupId, int editorId) {
        GroupContent group = getGroup(groupId);
        if (group != null) {
            group.invalidateEditor(editorId);
        }
    }

    @Override // com.devexpress.editors.ExpanderListener
    public void isExpanderCollapsed(ExpanderView expander, boolean isCollapsed) {
        Intrinsics.checkNotNullParameter(expander, "expander");
        DataFormContent dataFormContent = this.content;
        Intrinsics.checkNotNull(dataFormContent);
        int expanderIndex = dataFormContent.getExpanderIndex(expander);
        OnDataFromChangedListener onDataFromChangedListener = this.changedListener;
        if (onDataFromChangedListener != null) {
            onDataFromChangedListener.groupCollapseChanged(expanderIndex, isCollapsed);
        }
    }

    public final void initialize(DXDataFormDataProvider dataProvider, DataFormEditorFactory factory) {
        Intrinsics.checkNotNullParameter(dataProvider, "dataProvider");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.dataProvider = dataProvider;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        DataFormContent dataFormContent = new DataFormContent(context, dataProvider, factory, this);
        this.content = dataFormContent;
        this.scrollView.addView(dataFormContent, -1, -2);
        addView(this.scrollView, -1, -1);
    }

    private final void initWatermark() {
        ImageView imageView = new ImageView(getContext());
        this.watermarkImageView = imageView;
        Intrinsics.checkNotNull(imageView);
        imageView.setImageResource(R.drawable.dxe_watermark);
        ImageView imageView2 = this.watermarkImageView;
        Intrinsics.checkNotNull(imageView2);
        imageView2.setAdjustViewBounds(true);
        float f = getResources().getDisplayMetrics().density;
        Intrinsics.checkNotNull(this.watermarkImageView);
        int intrinsicWidth = (int) ((r1.getDrawable().getIntrinsicWidth() / f) + 0.5f);
        Intrinsics.checkNotNull(this.watermarkImageView);
        ImageView imageView3 = this.watermarkImageView;
        Intrinsics.checkNotNull(imageView3);
        imageView3.setMaxWidth(intrinsicWidth);
        ImageView imageView4 = this.watermarkImageView;
        Intrinsics.checkNotNull(imageView4);
        imageView4.setMaxHeight((int) ((r3.getDrawable().getIntrinsicHeight() / f) + 0.5f));
        ImageView imageView5 = this.watermarkImageView;
        Intrinsics.checkNotNull(imageView5);
        imageView5.setImageAlpha(WorkQueueKt.MASK);
        addView(this.watermarkImageView);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int i = r - l;
        int i2 = b - t;
        this.scrollView.layout(0, 0, i, i2);
        layoutWatermark(i, i2);
    }

    @Override // com.devexpress.editors.ExpanderListener
    public void contentSizeChanged(View content) {
        Intrinsics.checkNotNullParameter(content, "content");
        OnDataFromChangedListener onDataFromChangedListener = this.changedListener;
        if (onDataFromChangedListener != null) {
            onDataFromChangedListener.sizeChanged(this);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        DataFormContent dataFormContent;
        if (params != null && (dataFormContent = this.content) != null) {
            dataFormContent.setLayoutParams(new FrameLayout.LayoutParams(params.width, params.height));
        }
        super.setLayoutParams(params);
    }

    @Override // com.devexpress.dxcore.DXNativeView
    protected Size onMeasureCore(int widthMeasureSpec, int heightMeasureSpec) {
        if (View.MeasureSpec.getMode(widthMeasureSpec) == 0) {
            Rect rect = new Rect();
            getWindowVisibleDisplayFrame(rect);
            widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(rect.width(), Integer.MIN_VALUE);
        }
        this.scrollView.measure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        if (mode == 1073741824) {
            DataFormContent dataFormContent = this.content;
            Intrinsics.checkNotNull(dataFormContent);
            return new Size(dataFormContent.getMeasuredWidth(), size);
        }
        if (mode == Integer.MIN_VALUE) {
            DataFormContent dataFormContent2 = this.content;
            Intrinsics.checkNotNull(dataFormContent2);
            int measuredWidth = dataFormContent2.getMeasuredWidth();
            DataFormContent dataFormContent3 = this.content;
            Intrinsics.checkNotNull(dataFormContent3);
            return new Size(measuredWidth, RangesKt.coerceAtMost(dataFormContent3.getMeasuredHeight(), size));
        }
        DataFormContent dataFormContent4 = this.content;
        Intrinsics.checkNotNull(dataFormContent4);
        int measuredWidth2 = dataFormContent4.getMeasuredWidth();
        DataFormContent dataFormContent5 = this.content;
        Intrinsics.checkNotNull(dataFormContent5);
        return new Size(measuredWidth2, dataFormContent5.getMeasuredHeight());
    }
}
