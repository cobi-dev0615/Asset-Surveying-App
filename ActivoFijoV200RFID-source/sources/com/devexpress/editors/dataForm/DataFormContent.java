package com.devexpress.editors.dataForm;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import com.devexpress.editors.ExpanderListener;
import com.devexpress.editors.dataForm.protocols.DXDataFormDataProvider;
import com.devexpress.editors.dataForm.protocols.DataFormEditorFactory;
import com.devexpress.editors.dataForm.protocols.ExpanderInfo;
import com.devexpress.editors.layout.VStack;
import com.devexpress.editors.layout.ViewHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataFormContent.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001cH\u0002J\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\rJ0\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001cH\u0014J\u0018\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001cH\u0014J\u0006\u0010-\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\fj\b\u0012\u0004\u0012\u00020\u0010`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R*\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/devexpress/editors/dataForm/DataFormContent;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "dataProvider", "Lcom/devexpress/editors/dataForm/protocols/DXDataFormDataProvider;", "factory", "Lcom/devexpress/editors/dataForm/protocols/DataFormEditorFactory;", "expanderListener", "Lcom/devexpress/editors/ExpanderListener;", "(Landroid/content/Context;Lcom/devexpress/editors/dataForm/protocols/DXDataFormDataProvider;Lcom/devexpress/editors/dataForm/protocols/DataFormEditorFactory;Lcom/devexpress/editors/ExpanderListener;)V", "expanders", "Ljava/util/ArrayList;", "Lcom/devexpress/editors/dataForm/ExpanderView;", "Lkotlin/collections/ArrayList;", "groups", "Lcom/devexpress/editors/dataForm/GroupContent;", "getGroups", "()Ljava/util/ArrayList;", "groupsByName", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "vStack", "Lcom/devexpress/editors/layout/VStack;", "applySettingsToGroup", "", "groupId", "", "createExpander", "info", "Lcom/devexpress/editors/dataForm/protocols/ExpanderInfo;", "index", "getExpanderIndex", "expander", "onLayout", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "recreateGroups", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DataFormContent extends ViewGroup {
    private final DXDataFormDataProvider dataProvider;
    private final ExpanderListener expanderListener;
    private final ArrayList<ExpanderView> expanders;
    private final DataFormEditorFactory factory;
    private final ArrayList<GroupContent> groups;
    private final HashMap<String, ExpanderView> groupsByName;
    private final VStack vStack;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataFormContent(Context context, DXDataFormDataProvider dataProvider, DataFormEditorFactory factory, ExpanderListener expanderListener) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataProvider, "dataProvider");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.dataProvider = dataProvider;
        this.factory = factory;
        this.expanderListener = expanderListener;
        this.groups = new ArrayList<>();
        this.expanders = new ArrayList<>();
        this.vStack = new VStack("data_form_content", null, 0, null, 14, null);
        this.groupsByName = new HashMap<>();
        recreateGroups();
    }

    public final ArrayList<GroupContent> getGroups() {
        return this.groups;
    }

    public final void recreateGroups() {
        ExpanderView createExpander;
        this.vStack.removeAllChildren();
        HashSet hashSet = new HashSet(this.expanders);
        this.expanders.clear();
        this.groups.clear();
        HashSet hashSet2 = new HashSet();
        int i = 0;
        for (ExpanderInfo expanderInfo : this.dataProvider.getGroups()) {
            if (this.groupsByName.containsKey(expanderInfo.getGroupName())) {
                ExpanderView expanderView = this.groupsByName.get(expanderInfo.getGroupName());
                Intrinsics.checkNotNull(expanderView);
                createExpander = expanderView;
                this.expanders.add(createExpander);
            } else {
                createExpander = createExpander(expanderInfo, i);
                this.expanders.add(createExpander);
                addView(createExpander);
                this.groupsByName.put(expanderInfo.getGroupName(), createExpander);
            }
            hashSet.remove(createExpander);
            ArrayList<GroupContent> arrayList = this.groups;
            View content = createExpander.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type com.devexpress.editors.dataForm.GroupContent");
            arrayList.add((GroupContent) content);
            hashSet2.add(expanderInfo.getGroupName());
            i++;
            ViewHolder viewHolder = new ViewHolder(null, createExpander, null, null, false, 29, null);
            viewHolder.setGravity(55);
            this.vStack.addChild(viewHolder);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<String, ExpanderView> entry : this.groupsByName.entrySet()) {
            if (!hashSet2.contains(entry.getKey())) {
                arrayList2.add(entry.getKey());
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            this.groupsByName.remove((String) it.next());
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            removeView((ExpanderView) it2.next());
        }
        requestLayout();
    }

    private final ExpanderView createExpander(ExpanderInfo info, int index) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        GroupContent groupContent = new GroupContent(context, this.factory, this.dataProvider, index, info);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        ExpanderView expanderView = new ExpanderView(context2, info, groupContent, null, 0, 24, null);
        expanderView.setOnExpanderListener(this.expanderListener);
        return expanderView;
    }

    public final void applySettingsToGroup(int groupId) {
        if (groupId < 0 || groupId >= this.expanders.size()) {
            return;
        }
        ExpanderInfo group = this.dataProvider.getGroup(groupId);
        this.expanders.get(groupId).setGroupInfo(group);
        View content = this.expanders.get(groupId).getContent();
        Intrinsics.checkNotNull(content, "null cannot be cast to non-null type com.devexpress.editors.dataForm.GroupContent");
        ((GroupContent) content).applySettings(group);
        this.expanders.get(groupId).applySettings();
    }

    public final int getExpanderIndex(ExpanderView expander) {
        Intrinsics.checkNotNullParameter(expander, "expander");
        return this.expanders.indexOf(expander);
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
    }
}
