package com.devexpress.editors.dataForm;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.devexpress.editors.CheckEdit;
import com.devexpress.editors.DXCheckBoxPosition;
import com.devexpress.editors.ExpanderListener;
import com.devexpress.editors.R;
import com.devexpress.editors.dataForm.ExpanderView;
import com.devexpress.editors.dataForm.protocols.ExpanderInfo;
import com.devexpress.editors.layout.Element;
import com.devexpress.editors.layout.SizeDefinition;
import com.devexpress.editors.layout.VStack;
import com.devexpress.editors.layout.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExpanderView.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0002;<B5\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0006\u0010'\u001a\u00020(J\b\u0010)\u001a\u00020\u0014H\u0002J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020(H\u0016J0\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\fH\u0014J\u0018\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\fH\u0014J\b\u00107\u001a\u00020\u0011H\u0002J\u0012\u00108\u001a\u00020(2\b\u00109\u001a\u0004\u0018\u00010:H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006="}, d2 = {"Lcom/devexpress/editors/dataForm/ExpanderView;", "Landroid/view/ViewGroup;", "Lcom/devexpress/editors/dataForm/ExpanderHeaderClickListener;", "context", "Landroid/content/Context;", "groupInfo", "Lcom/devexpress/editors/dataForm/protocols/ExpanderInfo;", "content", "Landroid/view/View;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Lcom/devexpress/editors/dataForm/protocols/ExpanderInfo;Landroid/view/View;Landroid/util/AttributeSet;I)V", "getContent", "()Landroid/view/View;", "contentElement", "Lcom/devexpress/editors/layout/Element;", "customHeaderView", "defaultHeaderView", "Lcom/devexpress/editors/CheckEdit;", "expanderElement", "Lcom/devexpress/editors/layout/VStack;", "value", "getGroupInfo", "()Lcom/devexpress/editors/dataForm/protocols/ExpanderInfo;", "setGroupInfo", "(Lcom/devexpress/editors/dataForm/protocols/ExpanderInfo;)V", "headerElement", "headerHolder", "Lcom/devexpress/editors/dataForm/ExpanderView$ExpanderHeaderHolder;", "isCollapsed", "", "onExpanderListener", "Lcom/devexpress/editors/ExpanderListener;", "getOnExpanderListener", "()Lcom/devexpress/editors/ExpanderListener;", "setOnExpanderListener", "(Lcom/devexpress/editors/ExpanderListener;)V", "applySettings", "", "createDefaultHeader", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onHeaderClicked", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "recreateHeaderElement", "setLayoutParams", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "ExpanderHeaderHolder", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExpanderView extends ViewGroup implements ExpanderHeaderClickListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final View content;
    private final Element contentElement;
    private View customHeaderView;
    private CheckEdit defaultHeaderView;
    private final VStack expanderElement;
    private ExpanderInfo groupInfo;
    private Element headerElement;
    private ExpanderHeaderHolder headerHolder;
    private boolean isCollapsed;
    private ExpanderListener onExpanderListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderView(Context context, ExpanderInfo groupInfo, View content) {
        this(context, groupInfo, content, null, 0, 24, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(groupInfo, "groupInfo");
        Intrinsics.checkNotNullParameter(content, "content");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderView(Context context, ExpanderInfo groupInfo, View content, AttributeSet attributeSet) {
        this(context, groupInfo, content, attributeSet, 0, 16, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(groupInfo, "groupInfo");
        Intrinsics.checkNotNullParameter(content, "content");
    }

    public /* synthetic */ ExpanderView(Context context, ExpanderInfo expanderInfo, View view, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, expanderInfo, view, (i2 & 8) != 0 ? null : attributeSet, (i2 & 16) != 0 ? 0 : i);
    }

    public final View getContent() {
        return this.content;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpanderView(Context context, ExpanderInfo groupInfo, View content, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(groupInfo, "groupInfo");
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        VStack vStack = new VStack("group_expander", null, 0, null, 14, null);
        this.expanderElement = vStack;
        this.groupInfo = groupInfo;
        setWillNotDraw(false);
        this.isCollapsed = groupInfo.getIsCollapsed();
        addView(content);
        ViewHolder viewHolder = new ViewHolder("expander_content", content, null, null, false, 28, null);
        this.contentElement = viewHolder;
        viewHolder.setVisible(this.isCollapsed);
        Element recreateHeaderElement = recreateHeaderElement();
        this.headerElement = recreateHeaderElement;
        vStack.addChild(recreateHeaderElement);
        vStack.addChild(viewHolder);
        applySettings();
    }

    public final ExpanderListener getOnExpanderListener() {
        return this.onExpanderListener;
    }

    public final void setOnExpanderListener(ExpanderListener expanderListener) {
        this.onExpanderListener = expanderListener;
    }

    public final ExpanderInfo getGroupInfo() {
        return this.groupInfo;
    }

    public final void setGroupInfo(ExpanderInfo value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.groupInfo, value)) {
            return;
        }
        this.groupInfo = value;
        applySettings();
        requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void applySettings() {
        /*
            r4 = this;
            boolean r0 = r4.isCollapsed
            com.devexpress.editors.dataForm.protocols.ExpanderInfo r1 = r4.groupInfo
            boolean r1 = r1.getIsCollapsed()
            if (r0 == r1) goto L19
            com.devexpress.editors.dataForm.protocols.ExpanderInfo r0 = r4.groupInfo
            boolean r0 = r0.getIsCollapsed()
            r4.isCollapsed = r0
            com.devexpress.editors.ExpanderListener r1 = r4.onExpanderListener
            if (r1 == 0) goto L19
            r1.isExpanderCollapsed(r4, r0)
        L19:
            android.view.View r0 = r4.customHeaderView
            if (r0 == 0) goto L2b
            com.devexpress.editors.dataForm.protocols.ExpanderInfo r0 = r4.groupInfo
            android.view.View r0 = r0.getCustomHeader()
            if (r0 != 0) goto L2b
            android.view.View r0 = r4.customHeaderView
            r4.removeView(r0)
            goto L52
        L2b:
            android.view.View r0 = r4.customHeaderView
            if (r0 != 0) goto L3f
            com.devexpress.editors.dataForm.protocols.ExpanderInfo r0 = r4.groupInfo
            android.view.View r0 = r0.getCustomHeader()
            if (r0 == 0) goto L3f
            com.devexpress.editors.CheckEdit r0 = r4.defaultHeaderView
            android.view.View r0 = (android.view.View) r0
            r4.removeView(r0)
            goto L52
        L3f:
            android.view.View r0 = r4.customHeaderView
            com.devexpress.editors.dataForm.protocols.ExpanderInfo r1 = r4.groupInfo
            android.view.View r1 = r1.getCustomHeader()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 != 0) goto L6b
            android.view.View r0 = r4.customHeaderView
            r4.removeView(r0)
        L52:
            com.devexpress.editors.layout.Element r0 = r4.recreateHeaderElement()
            r4.headerElement = r0
            com.devexpress.editors.layout.VStack r0 = r4.expanderElement
            r0.removeAllChildren()
            com.devexpress.editors.layout.VStack r0 = r4.expanderElement
            com.devexpress.editors.layout.Element r1 = r4.headerElement
            r0.addChild(r1)
            com.devexpress.editors.layout.VStack r0 = r4.expanderElement
            com.devexpress.editors.layout.Element r1 = r4.contentElement
            r0.addChild(r1)
        L6b:
            com.devexpress.editors.layout.Element r0 = r4.headerElement
            com.devexpress.editors.model.Thickness r0 = r0.getPadding()
            com.devexpress.editors.dataForm.protocols.ExpanderInfo r1 = r4.groupInfo
            com.devexpress.editors.model.Thickness r1 = r1.getHeaderPadding()
            r0.set(r1)
            com.devexpress.editors.layout.Element r0 = r4.headerElement
            r1 = 55
            r0.setGravity(r1)
            com.devexpress.editors.dataForm.protocols.ExpanderInfo r0 = r4.groupInfo
            int r0 = r0.getHeaderBackgroundColor()
            com.devexpress.editors.layout.Element r1 = r4.headerElement
            if (r0 == 0) goto L93
            android.graphics.drawable.ColorDrawable r2 = new android.graphics.drawable.ColorDrawable
            r2.<init>(r0)
            android.graphics.drawable.Drawable r2 = (android.graphics.drawable.Drawable) r2
            goto L94
        L93:
            r2 = 0
        L94:
            r1.setBackgroundDrawable(r2)
            com.devexpress.editors.dataForm.protocols.ExpanderInfo r0 = r4.groupInfo
            boolean r0 = r0.getIsVisible()
            r1 = 0
            r2 = 8
            if (r0 == 0) goto La4
            r0 = r1
            goto La5
        La4:
            r0 = r2
        La5:
            r4.setVisibility(r0)
            android.view.View r0 = r4.content
            boolean r3 = r4.isCollapsed
            if (r3 == 0) goto Laf
            r1 = r2
        Laf:
            r0.setVisibility(r1)
            com.devexpress.editors.dataForm.ExpanderView$ExpanderHeaderHolder r0 = r4.headerHolder
            if (r0 == 0) goto Lbb
            com.devexpress.editors.dataForm.protocols.ExpanderInfo r1 = r4.groupInfo
            r0.applySettings(r1)
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.editors.dataForm.ExpanderView.applySettings():void");
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        this.content.setLayoutParams(params);
        super.setLayoutParams(params);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.expanderElement.measure(widthMeasureSpec, heightMeasureSpec);
        Size measuredSize = this.expanderElement.getMeasuredSize();
        setMeasuredDimension(measuredSize.getWidth(), measuredSize.getHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.expanderElement.layout(0, 0, r - l, b - t);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.expanderElement.draw(canvas);
        super.onDraw(canvas);
    }

    @Override // com.devexpress.editors.dataForm.ExpanderHeaderClickListener
    public void onHeaderClicked() {
        if (this.groupInfo.getIsCollapsable()) {
            boolean z = this.isCollapsed;
            this.isCollapsed = !z;
            this.contentElement.setVisible(z);
            ExpanderListener expanderListener = this.onExpanderListener;
            if (expanderListener != null) {
                Intrinsics.checkNotNull(expanderListener);
                expanderListener.isExpanderCollapsed(this, this.isCollapsed);
            }
        }
    }

    private final Element recreateHeaderElement() {
        CheckEdit createDefaultHeader;
        ViewHolder viewHolder;
        this.defaultHeaderView = null;
        this.customHeaderView = null;
        View customHeader = this.groupInfo.getCustomHeader();
        if (customHeader != null) {
            this.customHeaderView = customHeader;
            addView(customHeader);
            viewHolder = new ViewHolder(null, customHeader, null, null, false, 29, null);
            createDefaultHeader = null;
        } else {
            createDefaultHeader = createDefaultHeader();
            this.defaultHeaderView = createDefaultHeader;
            CheckEdit checkEdit = createDefaultHeader;
            addView(checkEdit);
            viewHolder = new ViewHolder(null, checkEdit, null, null, false, 29, null);
        }
        SizeDefinition.toStar$default(viewHolder.getWidthRequest(), 0.0f, 1, null);
        this.headerHolder = new ExpanderHeaderHolder(customHeader, createDefaultHeader, viewHolder, this);
        return viewHolder;
    }

    private final CheckEdit createDefaultHeader() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        CheckEdit checkEdit = new CheckEdit(context, null, 0, 6, null);
        checkEdit.beginInit();
        Companion companion = INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        checkEdit.setCheckboxDrawable(companion.getDefaultExpandCollapseIcon(context2));
        int color = ContextCompat.getColor(getContext(), R.color.dataForm_chevronColor);
        checkEdit.setCheckBoxColor(color);
        checkEdit.setCheckedCheckBoxColor(color);
        checkEdit.setDisabledCheckBoxColor(color);
        checkEdit.setDisabledCheckedCheckBoxColor(color);
        checkEdit.setCheckboxPosition(DXCheckBoxPosition.Start);
        checkEdit.setCheckboxIndent(getContext().getResources().getDimensionPixelSize(R.dimen.dataForm_chevronIndent));
        checkEdit.setLabelGravity(8388627);
        checkEdit.setShouldHandleClick(false);
        checkEdit.setLabelTextSize(this.groupInfo.getHeaderFontSize());
        checkEdit.setLabelTypeface(this.groupInfo.getHeaderFont());
        checkEdit.setLabelTextColor(this.groupInfo.getHeaderFontColor());
        checkEdit.endInit();
        return checkEdit;
    }

    /* compiled from: ExpanderView.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010$\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0002R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Lcom/devexpress/editors/dataForm/ExpanderView$ExpanderHeaderHolder;", "", "customHeader", "Landroid/view/View;", "defaultHeader", "Lcom/devexpress/editors/CheckEdit;", "defaultHeaderElement", "Lcom/devexpress/editors/layout/Element;", "onHeaderClickListener", "Lcom/devexpress/editors/dataForm/ExpanderHeaderClickListener;", "(Landroid/view/View;Lcom/devexpress/editors/CheckEdit;Lcom/devexpress/editors/layout/Element;Lcom/devexpress/editors/dataForm/ExpanderHeaderClickListener;)V", "getCustomHeader", "()Landroid/view/View;", "setCustomHeader", "(Landroid/view/View;)V", "defaultFontSize", "", "getDefaultHeader", "()Lcom/devexpress/editors/CheckEdit;", "setDefaultHeader", "(Lcom/devexpress/editors/CheckEdit;)V", "getDefaultHeaderElement", "()Lcom/devexpress/editors/layout/Element;", "setDefaultHeaderElement", "(Lcom/devexpress/editors/layout/Element;)V", "isCustomHeader", "", "getOnHeaderClickListener", "()Lcom/devexpress/editors/dataForm/ExpanderHeaderClickListener;", "setOnHeaderClickListener", "(Lcom/devexpress/editors/dataForm/ExpanderHeaderClickListener;)V", "applySettings", "", "settings", "Lcom/devexpress/editors/dataForm/protocols/ExpanderInfo;", "applySettingsToCustomHeader", "applySettingsToDefaultHeader", "configureCheckEditFromSettings", "checkEdit", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ExpanderHeaderHolder {
        private View customHeader;
        private float defaultFontSize;
        private CheckEdit defaultHeader;
        private Element defaultHeaderElement;
        private boolean isCustomHeader;
        private ExpanderHeaderClickListener onHeaderClickListener;

        public ExpanderHeaderHolder(View view, CheckEdit checkEdit, Element element, ExpanderHeaderClickListener onHeaderClickListener) {
            Intrinsics.checkNotNullParameter(onHeaderClickListener, "onHeaderClickListener");
            this.customHeader = view;
            this.defaultHeader = checkEdit;
            this.defaultHeaderElement = element;
            this.onHeaderClickListener = onHeaderClickListener;
            this.defaultFontSize = -1.0f;
            if (checkEdit != null) {
                this.defaultFontSize = checkEdit.getLabelTextSize();
            }
        }

        public final View getCustomHeader() {
            return this.customHeader;
        }

        public final void setCustomHeader(View view) {
            this.customHeader = view;
        }

        public final CheckEdit getDefaultHeader() {
            return this.defaultHeader;
        }

        public final void setDefaultHeader(CheckEdit checkEdit) {
            this.defaultHeader = checkEdit;
        }

        public final Element getDefaultHeaderElement() {
            return this.defaultHeaderElement;
        }

        public final void setDefaultHeaderElement(Element element) {
            this.defaultHeaderElement = element;
        }

        public final ExpanderHeaderClickListener getOnHeaderClickListener() {
            return this.onHeaderClickListener;
        }

        public final void setOnHeaderClickListener(ExpanderHeaderClickListener expanderHeaderClickListener) {
            Intrinsics.checkNotNullParameter(expanderHeaderClickListener, "<set-?>");
            this.onHeaderClickListener = expanderHeaderClickListener;
        }

        public final void applySettings(ExpanderInfo settings) {
            Intrinsics.checkNotNullParameter(settings, "settings");
            if (this.customHeader != null) {
                this.isCustomHeader = true;
                applySettingsToCustomHeader(settings);
            } else {
                this.isCustomHeader = false;
                applySettingsToDefaultHeader(settings);
            }
        }

        private final void applySettingsToCustomHeader(ExpanderInfo settings) {
            View view = this.customHeader;
            Intrinsics.checkNotNull(view);
            view.setVisibility(settings.getIsVisible() ? 0 : 8);
            View view2 = this.customHeader;
            Intrinsics.checkNotNull(view2);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.devexpress.editors.dataForm.ExpanderView$ExpanderHeaderHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    ExpanderView.ExpanderHeaderHolder.applySettingsToCustomHeader$lambda$0(ExpanderView.ExpanderHeaderHolder.this, view3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void applySettingsToCustomHeader$lambda$0(ExpanderHeaderHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onHeaderClickListener.onHeaderClicked();
        }

        private final void applySettingsToDefaultHeader(ExpanderInfo settings) {
            CheckEdit checkEdit = this.defaultHeader;
            if (checkEdit == null) {
                return;
            }
            configureCheckEditFromSettings(checkEdit, settings);
            Element element = this.defaultHeaderElement;
            if (element == null) {
                return;
            }
            element.setVisible(settings.getIsHeaderVisible());
        }

        private final void configureCheckEditFromSettings(final CheckEdit checkEdit, final ExpanderInfo settings) {
            checkEdit.beginInit();
            checkEdit.setLabel(settings.getHeaderText());
            checkEdit.setChecked(settings.getIsCollapsed());
            checkEdit.setLabelTextSize(settings.getHeaderFontSize());
            checkEdit.setLabelTypeface(settings.getHeaderFont());
            checkEdit.setLabelTextColor(settings.getHeaderFontColor());
            checkEdit.setOnClickListener(new View.OnClickListener() { // from class: com.devexpress.editors.dataForm.ExpanderView$ExpanderHeaderHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExpanderView.ExpanderHeaderHolder.configureCheckEditFromSettings$lambda$1(ExpanderInfo.this, checkEdit, this, view);
                }
            });
            checkEdit.endInit();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void configureCheckEditFromSettings$lambda$1(ExpanderInfo settings, CheckEdit checkEdit, ExpanderHeaderHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(settings, "$settings");
            Intrinsics.checkNotNullParameter(checkEdit, "$checkEdit");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (settings.getIsCollapsable()) {
                checkEdit.toggle();
            }
            this$0.onHeaderClickListener.onHeaderClicked();
        }
    }

    /* compiled from: ExpanderView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/dataForm/ExpanderView$Companion;", "", "()V", "getDefaultExpandCollapseIcon", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Drawable getDefaultExpandCollapseIcon(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return ContextCompat.getDrawable(context, R.drawable.dxe_chevron);
        }
    }
}
