package com.devexpress.editors.layout;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import com.devexpress.editors.DXBorderMode;
import com.devexpress.editors.LayoutElementsFactory;
import com.devexpress.editors.model.Thickness;
import com.devexpress.editors.style.TextEditStyle;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutManager.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 e2\u00020\u0001:\u0001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TJ&\u0010U\u001a\u00020M2\u0006\u0010V\u001a\u00020'2\u0006\u0010W\u001a\u00020'2\u0006\u0010X\u001a\u00020'2\u0006\u0010Y\u001a\u00020'J&\u0010Z\u001a\u00020M2\u0006\u0010[\u001a\u00020'2\u0006\u0010\\\u001a\u00020'2\u0006\u0010]\u001a\u00020'2\u0006\u0010^\u001a\u00020'J\u0006\u0010_\u001a\u00020RJ\u0006\u0010`\u001a\u00020RJ\b\u0010a\u001a\u00020RH\u0002J\b\u0010b\u001a\u00020RH\u0002J \u0010c\u001a\u00020R2\u0006\u0010[\u001a\u00020'2\u0006\u0010\\\u001a\u00020'2\u0006\u0010d\u001a\u00020'H\u0002R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001e\u0010#\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\"@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010-\u001a\u00020,2\u0006\u0010\r\u001a\u00020,@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001e\u00100\u001a\u00020,2\u0006\u0010\r\u001a\u00020,@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u001e\u00102\u001a\u00020,2\u0006\u0010\r\u001a\u00020,@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u0011\u00104\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\nR\u000e\u00106\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010)\"\u0004\b:\u0010+R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010=\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\b>\u0010)R\u0011\u0010?\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\b@\u0010)R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010G\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\"@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bH\u0010%R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001e\u0010N\u001a\u00020M2\u0006\u0010\r\u001a\u00020M@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bO\u0010P¨\u0006f"}, d2 = {"Lcom/devexpress/editors/layout/LayoutManager;", "", "elementsFactory", "Lcom/devexpress/editors/LayoutElementsFactory;", "style", "Lcom/devexpress/editors/style/TextEditStyle;", "(Lcom/devexpress/editors/LayoutElementsFactory;Lcom/devexpress/editors/style/TextEditStyle;)V", "borderBounds", "Landroid/graphics/Rect;", "getBorderBounds", "()Landroid/graphics/Rect;", "bottomRow", "Lcom/devexpress/editors/layout/EditorContainer;", "<set-?>", "Lcom/devexpress/editors/layout/BottomTextContainer;", "bottomRowTextContainer", "getBottomRowTextContainer", "()Lcom/devexpress/editors/layout/BottomTextContainer;", "boxMode", "Lcom/devexpress/editors/DXBorderMode;", "editBoxHeightRequestTmp", "Lcom/devexpress/editors/layout/SizeDefinition;", "editContainer", "getEditContainer", "()Lcom/devexpress/editors/layout/EditorContainer;", "editElement", "Lcom/devexpress/editors/layout/TextViewHolder;", "getEditElement", "()Lcom/devexpress/editors/layout/TextViewHolder;", "setEditElement", "(Lcom/devexpress/editors/layout/TextViewHolder;)V", "editHeightSRequestTmp", "getElementsFactory", "()Lcom/devexpress/editors/LayoutElementsFactory;", "Lcom/devexpress/editors/layout/HStack;", "endContainer", "getEndContainer", "()Lcom/devexpress/editors/layout/HStack;", "expandedLabelMaxWidth", "", "getExpandedLabelMaxWidth", "()I", "setExpandedLabelMaxWidth", "(I)V", "", "expandedLabelScale", "getExpandedLabelScale", "()F", "expandedLabelTranslateX", "getExpandedLabelTranslateX", "expandedLabelTranslateY", "getExpandedLabelTranslateY", "labelBounds", "getLabelBounds", "labelElement", "labelPaddingTop", "layoutDirection", "getLayoutDirection", "setLayoutDirection", "mainColumn", "Lcom/devexpress/editors/layout/Element;", "measuredHeight", "getMeasuredHeight", "measuredWidth", "getMeasuredWidth", "onBoxMarginChangedListener", "Lcom/devexpress/editors/layout/OnBoxMarginChangedListener;", "getOnBoxMarginChangedListener", "()Lcom/devexpress/editors/layout/OnBoxMarginChangedListener;", "setOnBoxMarginChangedListener", "(Lcom/devexpress/editors/layout/OnBoxMarginChangedListener;)V", "startContainer", "getStartContainer", "getStyle", "()Lcom/devexpress/editors/style/TextEditStyle;", "setStyle", "(Lcom/devexpress/editors/style/TextEditStyle;)V", "", "useAlphaCollapseAnimation", "getUseAlphaCollapseAnimation", "()Z", "draw", "", "canvas", "Landroid/graphics/Canvas;", "layout", "left", "top", "right", "bottom", "measure", "widthMeasureSpec", "heightMeasureSpec", "minWidth", "minHeight", "reInit", "reapplyStyle", "updateEndContainer", "updateStartContainer", "updateVerticalPaddingOfAllElementsIfNeeded", "labelHeight", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LayoutManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private EditorContainer bottomRow;
    private BottomTextContainer bottomRowTextContainer;
    private DXBorderMode boxMode;
    private SizeDefinition editBoxHeightRequestTmp;
    private EditorContainer editContainer;
    private TextViewHolder editElement;
    private SizeDefinition editHeightSRequestTmp;
    private final LayoutElementsFactory elementsFactory;
    private HStack endContainer;
    private int expandedLabelMaxWidth;
    private float expandedLabelScale;
    private float expandedLabelTranslateX;
    private float expandedLabelTranslateY;
    private final Rect labelBounds;
    private TextViewHolder labelElement;
    private int labelPaddingTop;
    private int layoutDirection;
    private Element mainColumn;
    private OnBoxMarginChangedListener onBoxMarginChangedListener;
    private HStack startContainer;
    private TextEditStyle style;
    private boolean useAlphaCollapseAnimation;

    /* compiled from: LayoutManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DXBorderMode.values().length];
            try {
                iArr[DXBorderMode.Outlined.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DXBorderMode.Filled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LayoutManager(LayoutElementsFactory elementsFactory, TextEditStyle style) {
        Intrinsics.checkNotNullParameter(elementsFactory, "elementsFactory");
        Intrinsics.checkNotNullParameter(style, "style");
        this.elementsFactory = elementsFactory;
        this.style = style;
        this.labelBounds = new Rect();
        this.expandedLabelScale = 1.0f;
        this.expandedLabelTranslateX = 1.0f;
        this.expandedLabelTranslateY = 1.0f;
        this.labelElement = elementsFactory.getLabelElement();
        this.boxMode = DXBorderMode.Filled;
        this.editHeightSRequestTmp = new SizeDefinition(0.0f, 0, 0, 0, 15, null);
        this.editBoxHeightRequestTmp = new SizeDefinition(0.0f, 0, 0, 0, 15, null);
        this.startContainer = HStackKt.HStack(new Function1<HStack, Unit>() { // from class: com.devexpress.editors.layout.LayoutManager.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HStack hStack) {
                invoke2(hStack);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HStack HStack) {
                Intrinsics.checkNotNullParameter(HStack, "$this$HStack");
                HStack.setGravity(8388723);
            }
        });
        this.editElement = elementsFactory.getEditorElement();
        this.endContainer = HStackKt.HStack(new Function1<HStack, Unit>() { // from class: com.devexpress.editors.layout.LayoutManager.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HStack hStack) {
                invoke2(hStack);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HStack HStack) {
                Intrinsics.checkNotNullParameter(HStack, "$this$HStack");
                HStack.setGravity(8388725);
            }
        });
        this.bottomRowTextContainer = new BottomTextContainer(elementsFactory.getHelpTextElement(), elementsFactory.getErrorTextElement());
        Element counterElement = elementsFactory.getCounterElement();
        if (counterElement != null) {
            counterElement.setGravity(48);
        }
        this.mainColumn = VStackKt.VStack(new Function1<VStack, Unit>() { // from class: com.devexpress.editors.layout.LayoutManager.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VStack vStack) {
                invoke2(vStack);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(VStack VStack) {
                Intrinsics.checkNotNullParameter(VStack, "$this$VStack");
                LayoutManager layoutManager = LayoutManager.this;
                layoutManager.editContainer = (EditorContainer) VStack.unaryPlus(EditorContainerKt.EditorBox(layoutManager.getEditElement(), LayoutManager.this.getStartContainer(), LayoutManager.this.getEndContainer(), new Function1<EditorContainer, Unit>() { // from class: com.devexpress.editors.layout.LayoutManager.3.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(EditorContainer editorContainer) {
                        invoke2(editorContainer);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(EditorContainer EditorBox) {
                        Intrinsics.checkNotNullParameter(EditorBox, "$this$EditorBox");
                        EditorBox.setGravity(55);
                    }
                }));
                LayoutManager layoutManager2 = LayoutManager.this;
                layoutManager2.bottomRow = (EditorContainer) VStack.unaryPlus(EditorContainerKt.EditorBox(layoutManager2.getBottomRowTextContainer(), null, LayoutManager.this.getElementsFactory().getCounterElement(), new Function1<EditorContainer, Unit>() { // from class: com.devexpress.editors.layout.LayoutManager.3.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(EditorContainer editorContainer) {
                        invoke2(editorContainer);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(EditorContainer EditorBox) {
                        Intrinsics.checkNotNullParameter(EditorBox, "$this$EditorBox");
                        EditorBox.setGravity(55);
                    }
                }));
            }
        });
        updateStartContainer();
        updateEndContainer();
        reapplyStyle();
    }

    public final LayoutElementsFactory getElementsFactory() {
        return this.elementsFactory;
    }

    public final TextEditStyle getStyle() {
        return this.style;
    }

    public final void setStyle(TextEditStyle textEditStyle) {
        Intrinsics.checkNotNullParameter(textEditStyle, "<set-?>");
        this.style = textEditStyle;
    }

    public final int getMeasuredWidth() {
        return this.mainColumn.getMeasuredSize().getWidth();
    }

    public final int getMeasuredHeight() {
        return this.mainColumn.getMeasuredSize().getHeight();
    }

    public final Rect getLabelBounds() {
        return this.labelBounds;
    }

    public final Rect getBorderBounds() {
        return getEditContainer().getBounds();
    }

    public final EditorContainer getEditContainer() {
        EditorContainer editorContainer = this.editContainer;
        if (editorContainer != null) {
            return editorContainer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("editContainer");
        return null;
    }

    public final HStack getStartContainer() {
        return this.startContainer;
    }

    public final HStack getEndContainer() {
        return this.endContainer;
    }

    public final BottomTextContainer getBottomRowTextContainer() {
        return this.bottomRowTextContainer;
    }

    public final OnBoxMarginChangedListener getOnBoxMarginChangedListener() {
        return this.onBoxMarginChangedListener;
    }

    public final void setOnBoxMarginChangedListener(OnBoxMarginChangedListener onBoxMarginChangedListener) {
        this.onBoxMarginChangedListener = onBoxMarginChangedListener;
    }

    public final TextViewHolder getEditElement() {
        return this.editElement;
    }

    public final void setEditElement(TextViewHolder textViewHolder) {
        Intrinsics.checkNotNullParameter(textViewHolder, "<set-?>");
        this.editElement = textViewHolder;
    }

    public final int getLayoutDirection() {
        return this.layoutDirection;
    }

    public final void setLayoutDirection(int i) {
        this.layoutDirection = i;
    }

    public final boolean getUseAlphaCollapseAnimation() {
        return this.useAlphaCollapseAnimation;
    }

    public final float getExpandedLabelScale() {
        return this.expandedLabelScale;
    }

    public final float getExpandedLabelTranslateX() {
        return this.expandedLabelTranslateX;
    }

    public final float getExpandedLabelTranslateY() {
        return this.expandedLabelTranslateY;
    }

    public final int getExpandedLabelMaxWidth() {
        return this.expandedLabelMaxWidth;
    }

    public final void setExpandedLabelMaxWidth(int i) {
        this.expandedLabelMaxWidth = i;
    }

    public final void reapplyStyle() {
        Thickness boxPadding = this.labelElement.isVisible() ? this.style.getBoxPadding() : this.style.getNoLabelBoxPadding();
        this.labelElement.getMargin().set(boxPadding.getStart(), 0, boxPadding.getEnd(), 0);
        this.editElement.getPadding().set(boxPadding);
        Thickness padding = this.elementsFactory.getPrefixElement().getPadding();
        padding.set(padding.getStart(), boxPadding.getTop(), padding.getEnd(), boxPadding.getBottom());
        Thickness padding2 = this.elementsFactory.getSuffixElement().getPadding();
        padding2.set(padding2.getStart(), boxPadding.getTop(), padding2.getEnd(), boxPadding.getBottom());
        Companion companion = INSTANCE;
        companion.applyBoxHeight(this.style, this.elementsFactory.getStartImageElements());
        companion.applyBoxHeight(this.style, this.elementsFactory.getEndImageElements());
        companion.applyHorizontalPaddingInStartContainer(this.style, this.startContainer, this.elementsFactory.getPrefixElement(), this.elementsFactory.getStartImageElements());
        companion.applyHorizontalPaddingInEndContainer(this.style, this.endContainer, this.elementsFactory.getSuffixElement(), this.elementsFactory.getEndImageElements());
        this.boxMode = this.style.getBorderMode();
        getEditContainer().setMinEditHeight(this.style.getMinBoxHeight());
        getEditContainer().setMinEditWidth(this.style.getMinBoxWidth());
        EditorContainer editorContainer = this.bottomRow;
        if (editorContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomRow");
            editorContainer = null;
        }
        editorContainer.getPadding().set(this.style.getBoxPadding().getStart(), this.style.getBottomTextTopIndent(), this.style.getBoxPadding().getEnd(), 0);
        Element counterElement = this.elementsFactory.getCounterElement();
        if (counterElement != null) {
            counterElement.getPadding().setStart(this.style.getCharacterCounterStartIndent());
        }
    }

    public final void reInit() {
        updateStartContainer();
        updateEndContainer();
    }

    public final boolean measure(int widthMeasureSpec, int heightMeasureSpec, int minWidth, int minHeight) {
        int makeChildMeasureSpec = AbstractContainer.INSTANCE.makeChildMeasureSpec(widthMeasureSpec, this.mainColumn.getPadding().getHorizontal() + this.labelElement.getMargin().getHorizontal(), this.labelElement.getWidthRequest());
        int makeChildMeasureSpec2 = AbstractContainer.INSTANCE.makeChildMeasureSpec(heightMeasureSpec, this.mainColumn.getPadding().getVertical() + this.labelElement.getMargin().getVertical(), this.labelElement.getHeightRequest());
        if (this.labelElement.isVisible()) {
            this.labelElement.measure(makeChildMeasureSpec, makeChildMeasureSpec2);
            int i = WhenMappings.$EnumSwitchMapping$0[this.boxMode.ordinal()];
            if (i == 1) {
                getEditContainer().getMargin().setTop(this.labelElement.getMeasuredSize().getHeight() / 2);
                updateVerticalPaddingOfAllElementsIfNeeded(widthMeasureSpec, heightMeasureSpec, 0);
            } else if (i == 2) {
                this.editElement.getPadding().setTop(this.style.getBoxPadding().getTop() + this.labelElement.getMeasuredSize().getHeight());
                updateVerticalPaddingOfAllElementsIfNeeded(widthMeasureSpec, heightMeasureSpec, this.labelElement.getMeasuredSize().getHeight());
            }
            float textSize = this.labelElement.getTextSize();
            this.expandedLabelScale = textSize > 0.0f ? this.editElement.getTextSize() / textSize : 1.0f;
        } else {
            updateVerticalPaddingOfAllElementsIfNeeded(widthMeasureSpec, heightMeasureSpec, 0);
            this.expandedLabelScale = 1.0f;
        }
        this.mainColumn.measure(widthMeasureSpec, heightMeasureSpec);
        return true;
    }

    public final boolean layout(int left, int top, int right, int bottom) {
        int i;
        int top2;
        int left2;
        this.mainColumn.layout(left, top, right, bottom);
        this.labelElement.getPadding().resolve(this.layoutDirection);
        this.labelElement.getMargin().resolve(this.layoutDirection);
        TextViewHolder prefixElement = this.elementsFactory.getPrefixElement();
        if (prefixElement.isVisible()) {
            i = prefixElement.getBounds().left;
        } else {
            i = this.startContainer.getBounds().right;
        }
        if (this.labelElement.getMeasuredSize().getWidth() + this.labelElement.getMargin().getHorizontal() <= this.mainColumn.getMeasuredSize().getWidth()) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.boxMode.ordinal()];
            if (i2 == 1) {
                top2 = top + this.mainColumn.getPadding().getTop();
                left2 = left + this.mainColumn.getPadding().getLeft() + this.labelElement.getMargin().getLeft();
            } else if (i2 != 2) {
                left2 = 0;
                top2 = 0;
            } else {
                top2 = top + this.labelPaddingTop;
                left2 = i;
            }
            TextViewHolder textViewHolder = this.labelElement;
            textViewHolder.layout(left2, top2, textViewHolder.getMeasuredSize().getWidth() + left2, this.labelElement.getMeasuredSize().getHeight() + top2);
            this.labelBounds.set(this.labelElement.getBounds());
            if (this.labelBounds.width() > 0) {
                this.labelBounds.inset(-this.style.getLabelTextBorderIndent(), 0);
            }
            Rect bounds = getEditContainer().getBounds();
            Rect bounds2 = this.labelElement.getBounds();
            this.expandedLabelTranslateY = (bounds.top - bounds2.top) + ((bounds.height() - (this.expandedLabelScale * bounds2.height())) / 2);
            this.expandedLabelTranslateX = i - bounds2.left;
            this.expandedLabelMaxWidth = (int) ((this.editElement.getMeasuredSize().getWidth() - this.editElement.getPadding().getHorizontal()) / this.expandedLabelScale);
        } else {
            this.labelElement.layout(0, 0, 0, 0);
            this.labelBounds.set(0, 0, 0, 0);
            this.expandedLabelTranslateX = 0.0f;
            this.expandedLabelTranslateY = 0.0f;
            this.expandedLabelMaxWidth = 0;
        }
        return true;
    }

    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.mainColumn.draw(canvas);
    }

    private final void updateStartContainer() {
        this.startContainer.removeAllChildren();
        Iterator<Element> it = this.elementsFactory.getStartImageElements().iterator();
        while (it.hasNext()) {
            this.startContainer.addChild(it.next());
        }
        this.startContainer.addChild(this.elementsFactory.getPrefixElement());
    }

    private final void updateEndContainer() {
        this.endContainer.removeAllChildren();
        this.endContainer.addChild(this.elementsFactory.getSuffixElement());
        Iterator<Element> it = this.elementsFactory.getEndImageElements().iterator();
        while (it.hasNext()) {
            this.endContainer.addChild(it.next());
        }
    }

    private final void updateVerticalPaddingOfAllElementsIfNeeded(int widthMeasureSpec, int heightMeasureSpec, int labelHeight) {
        int i;
        Pair pair;
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int boxHeight = this.style.getBoxHeight();
        Thickness padding = this.editElement.getPadding();
        Thickness padding2 = this.elementsFactory.getPrefixElement().getPadding();
        Thickness padding3 = this.elementsFactory.getSuffixElement().getPadding();
        padding.setTop(this.style.getBoxPadding().getTop() + labelHeight);
        padding.setBottom(this.style.getBoxPadding().getBottom());
        padding2.setTop(this.style.getBoxPadding().getTop() + labelHeight);
        padding2.setBottom(this.style.getBoxPadding().getBottom());
        padding3.setTop(this.style.getBoxPadding().getTop() + labelHeight);
        padding3.setBottom(this.style.getBoxPadding().getBottom());
        this.editBoxHeightRequestTmp.from(getEditContainer().getHeightRequest());
        this.editHeightSRequestTmp.from(this.editElement.getHeightRequest());
        getEditContainer().getHeightRequest().toAuto();
        this.editElement.getHeightRequest().toAuto();
        this.mainColumn.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
        getEditContainer().getHeightRequest().from(this.editBoxHeightRequestTmp);
        this.editElement.getHeightRequest().from(this.editHeightSRequestTmp);
        int height = this.editElement.getMeasuredSize().getHeight();
        EditorContainer editorContainer = this.bottomRow;
        EditorContainer editorContainer2 = null;
        if (editorContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomRow");
            editorContainer = null;
        }
        if (editorContainer.isVisible()) {
            EditorContainer editorContainer3 = this.bottomRow;
            if (editorContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomRow");
                editorContainer3 = null;
            }
            i = editorContainer3.getMeasuredSize().getHeight();
        } else {
            i = 0;
        }
        int i2 = size - i;
        EditorContainer editorContainer4 = this.bottomRow;
        if (editorContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomRow");
        } else {
            editorContainer2 = editorContainer4;
        }
        int vertical = (i2 - editorContainer2.getMargin().getVertical()) - getEditContainer().getMargin().getVertical();
        if (boxHeight > 0 && height > boxHeight) {
            pair = TuplesKt.to(true, Integer.valueOf(boxHeight));
        } else if (mode != 0 && height > vertical) {
            pair = TuplesKt.to(true, Integer.valueOf(vertical));
        } else {
            pair = TuplesKt.to(false, 0);
        }
        boolean booleanValue = ((Boolean) pair.component1()).booleanValue();
        int intValue = ((Number) pair.component2()).intValue();
        if (booleanValue) {
            Companion companion = INSTANCE;
            Pair updateElementVerticalPaddingIfNeeded = companion.updateElementVerticalPaddingIfNeeded(padding, height, intValue, labelHeight);
            boolean booleanValue2 = ((Boolean) updateElementVerticalPaddingIfNeeded.component1()).booleanValue();
            int intValue2 = ((Number) updateElementVerticalPaddingIfNeeded.component2()).intValue();
            int height2 = this.elementsFactory.getPrefixElement().getMeasuredSize().getHeight();
            if (height2 < height) {
                padding2.setTop(padding.getTop());
                padding2.setBottom(padding.getBottom());
            } else {
                companion.updateElementVerticalPaddingIfNeeded(padding2, height2, intValue, labelHeight);
            }
            int height3 = this.elementsFactory.getSuffixElement().getMeasuredSize().getHeight();
            if (height3 < height) {
                padding3.setTop(padding.getTop());
                padding3.setBottom(padding.getBottom());
            } else {
                companion.updateElementVerticalPaddingIfNeeded(padding3, height3, intValue, labelHeight);
            }
            this.useAlphaCollapseAnimation = booleanValue2;
            this.labelPaddingTop = intValue2;
            return;
        }
        this.useAlphaCollapseAnimation = false;
        this.labelPaddingTop = this.style.getBoxPadding().getTop();
    }

    /* compiled from: LayoutManager.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J.\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J.\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\t2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J \u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J4\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000b0\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0002¨\u0006\""}, d2 = {"Lcom/devexpress/editors/layout/LayoutManager$Companion;", "", "()V", "applyBoxHeight", "", "style", "Lcom/devexpress/editors/style/TextEditStyle;", "images", "", "Lcom/devexpress/editors/layout/Element;", "applyFirstImagePaddingStart", "", "image", "freeSpace", "targetPadding", "applyHorizontalPaddingInEndContainer", "container", "Lcom/devexpress/editors/layout/AbstractContainer;", "suffix", "applyHorizontalPaddingInStartContainer", "prefix", "applyImagePaddingEnd", "halfSpacing", "applyImagePaddingStart", "applyLastImagePaddingEnd", "endPadding", "updateElementVerticalPaddingIfNeeded", "Lkotlin/Pair;", "", "padding", "Lcom/devexpress/editors/model/Thickness;", "actualHeight", "targetHeight", "reservedPaddingTop", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final int applyFirstImagePaddingStart(Element image, int freeSpace, int targetPadding) {
            int max = Math.max(freeSpace - targetPadding, 0);
            image.getPadding().setStart(freeSpace - max);
            return max;
        }

        private final void applyImagePaddingStart(Element image, int halfSpacing) {
            image.getPadding().setStart(halfSpacing);
        }

        private final int applyLastImagePaddingEnd(Element image, int endPadding, int halfSpacing) {
            int max = Math.max(endPadding - halfSpacing, 0);
            image.getPadding().setEnd(endPadding - max);
            return max;
        }

        private final void applyImagePaddingEnd(Element image, int halfSpacing) {
            image.getPadding().setEnd(halfSpacing);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void applyHorizontalPaddingInStartContainer(TextEditStyle style, AbstractContainer container, Element prefix, List<? extends Element> images) {
            int i;
            int i2;
            Thickness boxPadding = style.getBoxPadding();
            int iconSpacing = style.getIconSpacing() / 2;
            int start = boxPadding.getStart();
            Iterator<? extends Element> it = images.iterator();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i4 = -1;
                    break;
                } else if (it.next().isVisible()) {
                    break;
                } else {
                    i4++;
                }
            }
            ListIterator<? extends Element> listIterator = images.listIterator(images.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    i = -1;
                    break;
                } else if (listIterator.previous().isVisible()) {
                    i = listIterator.nextIndex();
                    break;
                }
            }
            if (i4 == -1 || i == -1) {
                i2 = 0;
            } else {
                start = applyFirstImagePaddingStart(images.get(i4), boxPadding.getStart(), iconSpacing);
                while (i4 < i) {
                    applyImagePaddingEnd(images.get(i4), iconSpacing);
                    i4++;
                    applyImagePaddingStart(images.get(i4), iconSpacing);
                }
                i2 = applyLastImagePaddingEnd(images.get(i), style.getIconIndent(), iconSpacing);
            }
            if (prefix.isVisible()) {
                prefix.getPadding().setStart(i2);
                prefix.getPadding().setEnd(style.getAffixIndent());
            } else {
                i3 = i2;
            }
            container.getPadding().setStart(start);
            container.getPadding().setEnd(i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void applyHorizontalPaddingInEndContainer(TextEditStyle style, AbstractContainer container, Element suffix, List<? extends Element> images) {
            int i;
            int i2;
            int i3;
            Thickness boxPadding = style.getBoxPadding();
            int iconSpacing = style.getIconSpacing() / 2;
            int end = boxPadding.getEnd();
            Iterator<? extends Element> it = images.iterator();
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i5 = -1;
                    break;
                } else if (it.next().isVisible()) {
                    break;
                } else {
                    i5++;
                }
            }
            ListIterator<? extends Element> listIterator = images.listIterator(images.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    i = -1;
                    break;
                } else if (listIterator.previous().isVisible()) {
                    i = listIterator.nextIndex();
                    break;
                }
            }
            if (i5 == -1 || i == -1) {
                i2 = end;
                i3 = 0;
            } else {
                i3 = applyFirstImagePaddingStart(images.get(i5), style.getIconIndent(), iconSpacing);
                while (i5 < i) {
                    applyImagePaddingEnd(images.get(i5), iconSpacing);
                    i5++;
                    applyImagePaddingStart(images.get(i5), iconSpacing);
                }
                i2 = applyLastImagePaddingEnd(images.get(i), boxPadding.getEnd(), iconSpacing);
            }
            if (suffix.isVisible()) {
                suffix.getPadding().setStart(style.getAffixIndent());
                suffix.getPadding().setEnd(i3);
            } else {
                i4 = i3;
            }
            container.getPadding().setStart(i4);
            container.getPadding().setEnd(i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void applyBoxHeight(TextEditStyle style, List<? extends Element> images) {
            int boxHeight = style.getBoxHeight();
            if (boxHeight > 0) {
                Iterator<? extends Element> it = images.iterator();
                while (it.hasNext()) {
                    it.next().getHeightRequest().toFixed(boxHeight);
                }
            } else {
                Iterator<? extends Element> it2 = images.iterator();
                while (it2.hasNext()) {
                    it2.next().getHeightRequest().toAuto();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Pair<Boolean, Integer> updateElementVerticalPaddingIfNeeded(Thickness padding, int actualHeight, int targetHeight, int reservedPaddingTop) {
            boolean z;
            int i;
            int i2 = actualHeight - targetHeight;
            int i3 = i2 / 2;
            if (padding.getVertical() - i2 >= reservedPaddingTop) {
                i = reservedPaddingTop;
                z = false;
            } else {
                i3 = (i2 - reservedPaddingTop) / 2;
                z = true;
                i = 0;
            }
            int top = (padding.getTop() - reservedPaddingTop) - i3;
            int bottom = (padding.getBottom() - i3) - Math.max(-top, 0);
            int max = Math.max(-bottom, 0);
            if (max > 0 && top > 0) {
                top = Math.max(0, top - max);
            }
            padding.setTop(Math.max(top + i, 0));
            padding.setBottom(Math.max(bottom, 0));
            return TuplesKt.to(Boolean.valueOf(z), Integer.valueOf(Math.max(padding.getTop() - reservedPaddingTop, 0)));
        }
    }
}
