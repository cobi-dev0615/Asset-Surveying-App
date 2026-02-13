package com.devexpress.editors.dataForm;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.devexpress.editors.EditBase;
import com.devexpress.editors.animations.BottomTextAnimator;
import com.devexpress.editors.dataForm.layout.BoxBoundsProvider;
import com.devexpress.editors.dataForm.layout.DataFormItemEditorContainer;
import com.devexpress.editors.dataForm.layout.DataFormItemLabelContainer;
import com.devexpress.editors.dataForm.layout.DefaultBoxBoundsProvider;
import com.devexpress.editors.dataForm.layout.EditBoxBoundsProvider;
import com.devexpress.editors.dataForm.protocols.AsyncImageInfo;
import com.devexpress.editors.dataForm.protocols.DXDataFormEditorItem;
import com.devexpress.editors.dataForm.protocols.DXDataFormEditorItemErrorProvider;
import com.devexpress.editors.dataForm.protocols.DataFormEditorInfo;
import com.devexpress.editors.dataForm.protocols.DataFormItemDataProvider;
import com.devexpress.editors.dataForm.protocols.DataFormPickerItem;
import com.devexpress.editors.dataForm.protocols.EditorLabelPosition;
import com.devexpress.editors.layout.Element;
import com.devexpress.editors.layout.SizeDefinition;
import com.devexpress.editors.layout.SpannedElement;
import com.devexpress.editors.layout.ViewHolder;
import com.devexpress.editors.model.Thickness;
import com.devexpress.editors.utils.BottomTextState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataFormEditorManager.kt */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0001bB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u000208J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020\nH\u0002J\u0018\u0010@\u001a\u0002082\u0006\u0010?\u001a\u00020\n2\u0006\u0010A\u001a\u00020BH\u0002J\u000e\u0010C\u001a\u0002082\u0006\u0010D\u001a\u00020EJ\u0010\u0010F\u001a\u0002082\u0006\u0010?\u001a\u00020\nH\u0002J\u0006\u0010G\u001a\u000208J\u0018\u0010H\u001a\u0002082\u0006\u0010?\u001a\u00020\n2\u0006\u0010A\u001a\u00020+H\u0002J\u0006\u0010I\u001a\u00020/J\b\u0010J\u001a\u00020+H\u0002J\b\u0010K\u001a\u00020+H\u0002J\u0010\u0010L\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020\nH\u0002J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\bH\u0002J\b\u0010O\u001a\u0004\u0018\u00010PJ\u0006\u0010Q\u001a\u000208J\b\u0010R\u001a\u000208H\u0016J\u000e\u0010S\u001a\u0002082\u0006\u0010;\u001a\u00020<J\u0006\u0010T\u001a\u000208J\b\u0010U\u001a\u000208H\u0002J \u0010V\u001a\u0002082\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020E2\u0006\u0010Z\u001a\u00020[H\u0002J\b\u0010\\\u001a\u000208H\u0002J\u001a\u0010]\u001a\u0002082\u0006\u0010^\u001a\u00020/2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0006\u0010a\u001a\u00020/R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020$0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010.\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b.\u00100R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R&\u00106\u001a\u001a\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020807X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/devexpress/editors/dataForm/DataFormEditorManager;", "Lcom/devexpress/editors/dataForm/protocols/DXDataFormEditorItemErrorProvider;", "Lcom/devexpress/editors/dataForm/protocols/AsyncImageInfo$AsyncImageInfoListener;", "context", "Landroid/content/Context;", "dataSource", "Lcom/devexpress/editors/dataForm/protocols/DataFormItemDataProvider;", "editorHolder", "Lcom/devexpress/editors/dataForm/protocols/DXDataFormEditorItem;", "editorInfo", "Lcom/devexpress/editors/dataForm/protocols/DataFormEditorInfo;", "(Landroid/content/Context;Lcom/devexpress/editors/dataForm/protocols/DataFormItemDataProvider;Lcom/devexpress/editors/dataForm/protocols/DXDataFormEditorItem;Lcom/devexpress/editors/dataForm/protocols/DataFormEditorInfo;)V", "bottomTextAnimator", "Lcom/devexpress/editors/animations/BottomTextAnimator;", "boxBoundsProvider", "Lcom/devexpress/editors/dataForm/layout/BoxBoundsProvider;", "getDataSource", "()Lcom/devexpress/editors/dataForm/protocols/DataFormItemDataProvider;", "defaultFontSize", "", "editorContainer", "Lcom/devexpress/editors/dataForm/layout/DataFormItemEditorContainer;", "editorElement", "Lcom/devexpress/editors/layout/ViewHolder;", "value", "getEditorInfo", "()Lcom/devexpress/editors/dataForm/protocols/DataFormEditorInfo;", "setEditorInfo", "(Lcom/devexpress/editors/dataForm/protocols/DataFormEditorInfo;)V", "<set-?>", "Landroid/view/View;", "editorView", "getEditorView", "()Landroid/view/View;", "elements", "", "Lcom/devexpress/editors/layout/SpannedElement;", "getElements", "()Ljava/util/List;", "elementsInternal", "", "errorElement", "errorView", "Landroid/widget/TextView;", "helperElement", "helperView", "isVisible", "", "()Z", "itemSpacingTarget", "Lcom/devexpress/editors/layout/Element;", "labelContainer", "Lcom/devexpress/editors/dataForm/layout/DataFormItemLabelContainer;", "labelElement", "labelLayoutStrategy", "Lkotlin/Function3;", "", "labelView", "addViewsTo", "viewGroup", "Landroid/view/ViewGroup;", "adjustLabelLayout", "applyBottomTextSettingsIfNeeded", "settings", "applyIconLabelSettings", "label", "Landroid/widget/ImageView;", "applyItemSpacing", "itemSpacing", "", "applyLabelSettingsIfNeeded", "applySettings", "applyTextLabelSettings", "commit", "createErrorView", "createHelperView", "createLabelView", "info", "item", "getValue", "", "invalidateSettings", "onImageLoaded", "removeViewsFrom", "resetValue", "setVisibility", "updateElementContainers", "labelPosition", "Lcom/devexpress/editors/dataForm/protocols/EditorLabelPosition;", "labelIndent", "padding", "Lcom/devexpress/editors/model/Thickness;", "updateElements", "updateError", "hasError", "errorText", "", "validate", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DataFormEditorManager extends DXDataFormEditorItemErrorProvider implements AsyncImageInfo.AsyncImageInfoListener {
    private final BottomTextAnimator bottomTextAnimator;
    private final BoxBoundsProvider boxBoundsProvider;
    private final Context context;
    private final DataFormItemDataProvider dataSource;
    private float defaultFontSize;
    private final DataFormItemEditorContainer editorContainer;
    private final ViewHolder editorElement;
    private final DXDataFormEditorItem editorHolder;
    private DataFormEditorInfo editorInfo;
    private View editorView;
    private final List<SpannedElement> elementsInternal;
    private final ViewHolder errorElement;
    private final TextView errorView;
    private final ViewHolder helperElement;
    private final TextView helperView;
    private Element itemSpacingTarget;
    private final DataFormItemLabelContainer labelContainer;
    private final ViewHolder labelElement;
    private Function3<? super Element, ? super Element, ? super BoxBoundsProvider, Unit> labelLayoutStrategy;
    private final View labelView;
    private static final Function3<Element, Element, BoxBoundsProvider, Unit> doNotChangeLabelLayout = new Function3<Element, Element, BoxBoundsProvider, Unit>() { // from class: com.devexpress.editors.dataForm.DataFormEditorManager$Companion$doNotChangeLabelLayout$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Element element, Element element2, BoxBoundsProvider boxBoundsProvider) {
            Intrinsics.checkNotNullParameter(element, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(element2, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(boxBoundsProvider, "<anonymous parameter 2>");
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Element element, Element element2, BoxBoundsProvider boxBoundsProvider) {
            invoke2(element, element2, boxBoundsProvider);
            return Unit.INSTANCE;
        }
    };
    private static final Function3<Element, Element, BoxBoundsProvider, Unit> centerLabelVertically = new Function3<Element, Element, BoxBoundsProvider, Unit>() { // from class: com.devexpress.editors.dataForm.DataFormEditorManager$Companion$centerLabelVertically$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Element element, Element element2, BoxBoundsProvider boxBoundsProvider) {
            invoke2(element, element2, boxBoundsProvider);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Element label, Element editor, BoxBoundsProvider boxBoundsProvider) {
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(editor, "editor");
            Intrinsics.checkNotNullParameter(boxBoundsProvider, "boxBoundsProvider");
            Rect bounds = label.getBounds();
            int centerY = (editor.getBounds().top + boxBoundsProvider.getCenterY()) - bounds.centerY();
            label.layout(bounds.left, bounds.top + centerY, bounds.right, bounds.bottom + centerY);
        }
    };

    /* compiled from: DataFormEditorManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EditorLabelPosition.values().length];
            try {
                iArr[EditorLabelPosition.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EditorLabelPosition.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EditorLabelPosition.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final DataFormItemDataProvider getDataSource() {
        return this.dataSource;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DataFormEditorManager(Context context, DataFormItemDataProvider dataSource, DXDataFormEditorItem editorHolder, DataFormEditorInfo editorInfo) {
        float textSize;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        Intrinsics.checkNotNullParameter(editorHolder, "editorHolder");
        Intrinsics.checkNotNullParameter(editorInfo, "editorInfo");
        this.context = context;
        this.dataSource = dataSource;
        this.editorHolder = editorHolder;
        this.elementsInternal = new ArrayList();
        this.editorInfo = editorInfo;
        this.editorView = getEditorView(editorHolder);
        AsyncImageInfo labelIconInfo = editorInfo.getLabelIconInfo();
        if (labelIconInfo != null) {
            labelIconInfo.setImageInfoListener(this);
        }
        EditBase edit = editorHolder.getEdit();
        ViewHolder viewHolder = new ViewHolder(null, this.editorView, null, null, false, 29, null);
        this.editorElement = viewHolder;
        if (edit != null) {
            this.boxBoundsProvider = new EditBoxBoundsProvider(edit);
            this.errorView = null;
            this.errorElement = null;
            this.helperView = null;
            this.helperElement = null;
            this.bottomTextAnimator = null;
        } else {
            this.boxBoundsProvider = new DefaultBoxBoundsProvider(this.editorView);
            TextView createErrorView = createErrorView();
            this.errorView = createErrorView;
            this.errorElement = new ViewHolder("error_text", createErrorView, null, null, false, 28, null);
            TextView createHelperView = createHelperView();
            this.helperView = createHelperView;
            this.helperElement = new ViewHolder("bottom_text", createHelperView, null, null, false, 28, null);
            this.bottomTextAnimator = new BottomTextAnimator(createHelperView, createErrorView);
        }
        SizeDefinition.toStar$default(viewHolder.getWidthRequest(), 0.0f, 1, null);
        View createLabelView = createLabelView(editorInfo);
        this.labelView = createLabelView;
        ViewHolder viewHolder2 = new ViewHolder(null, createLabelView, null, null, false, 29, null);
        this.labelElement = viewHolder2;
        this.labelContainer = new DataFormItemLabelContainer(viewHolder2);
        this.editorContainer = new DataFormItemEditorContainer(viewHolder, viewHolder2, this.helperElement, this.errorElement);
        TextView textView = this.errorView;
        if (textView == null || this.helperView == null) {
            textSize = createLabelView instanceof TextView ? ((TextView) createLabelView).getTextSize() : -1.0f;
        } else {
            textSize = textView.getTextSize();
        }
        this.defaultFontSize = textSize;
        editorHolder.setEditorErrorProvider(this);
        if (editorHolder instanceof DataFormPickerItem) {
            ((DataFormPickerItem) editorHolder).setPickerDataProvider(dataSource);
        }
        resetValue();
        setVisibility();
        applySettings();
    }

    public final View getEditorView() {
        return this.editorView;
    }

    public final DataFormEditorInfo getEditorInfo() {
        return this.editorInfo;
    }

    private final void setEditorInfo(DataFormEditorInfo dataFormEditorInfo) {
        AsyncImageInfo labelIconInfo;
        if (Intrinsics.areEqual(this.editorInfo, dataFormEditorInfo)) {
            return;
        }
        this.editorInfo = dataFormEditorInfo;
        if (dataFormEditorInfo.getLabelIconInfo() != null && (labelIconInfo = dataFormEditorInfo.getLabelIconInfo()) != null) {
            labelIconInfo.setImageInfoListener(this);
        }
        applySettings();
    }

    public final List<SpannedElement> getElements() {
        return this.elementsInternal;
    }

    public final boolean isVisible() {
        return this.editorInfo.getIsVisible();
    }

    public final void invalidateSettings() {
        setEditorInfo(this.dataSource.getEditorInfo());
    }

    public final void applySettings() {
        updateElements();
        this.editorHolder.configure();
        setVisibility();
        applyLabelSettingsIfNeeded(this.editorInfo);
        applyBottomTextSettingsIfNeeded(this.editorInfo);
        if (this.editorInfo.getBackgroundColor() != 0) {
            this.labelContainer.setBackgroundDrawable(new ColorDrawable(this.editorInfo.getBackgroundColor()));
            this.editorContainer.setBackgroundDrawable(new ColorDrawable(this.editorInfo.getBackgroundColor()));
        }
    }

    public final void applyItemSpacing(int itemSpacing) {
        Element element = this.itemSpacingTarget;
        if (element == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemSpacingTarget");
            element = null;
        }
        element.getMargin().set(0, 0, itemSpacing, 0);
    }

    public final void addViewsTo(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        viewGroup.addView(this.editorView);
        viewGroup.addView(this.labelView);
        TextView textView = this.helperView;
        if (textView != null) {
            viewGroup.addView(textView);
        }
        TextView textView2 = this.errorView;
        if (textView2 != null) {
            viewGroup.addView(textView2);
        }
    }

    public final void removeViewsFrom(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        viewGroup.removeView(this.editorView);
        viewGroup.removeView(this.labelView);
        viewGroup.removeView(this.helperView);
        viewGroup.removeView(this.errorView);
    }

    public final void adjustLabelLayout() {
        Function3<? super Element, ? super Element, ? super BoxBoundsProvider, Unit> function3 = this.labelLayoutStrategy;
        if (function3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelLayoutStrategy");
            function3 = null;
        }
        function3.invoke(this.labelElement, this.editorElement, this.boxBoundsProvider);
    }

    public final Object getValue() {
        return this.editorHolder.getEditorWrappedValue();
    }

    public final void resetValue() {
        this.editorHolder.resetEditorValue();
    }

    public final boolean validate() {
        return this.editorHolder.validateEditorValue();
    }

    public final boolean commit() {
        return this.editorHolder.commitEditorValue();
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormEditorItemErrorProvider
    public void updateError(boolean hasError, CharSequence errorText) {
        EditBase edit = this.editorHolder.getEdit();
        if (edit != null) {
            edit.setErrorText(errorText);
            edit.setHasError(hasError);
            return;
        }
        if (hasError) {
            TextView textView = this.errorView;
            Intrinsics.checkNotNull(textView);
            textView.setText(errorText);
            BottomTextAnimator bottomTextAnimator = this.bottomTextAnimator;
            Intrinsics.checkNotNull(bottomTextAnimator);
            bottomTextAnimator.setState(BottomTextState.ERROR, true);
            return;
        }
        TextView textView2 = this.helperView;
        CharSequence text = textView2 != null ? textView2.getText() : null;
        if ((text == null || text.length() == 0) && !this.editorInfo.getReserveBottomTextLine()) {
            BottomTextAnimator bottomTextAnimator2 = this.bottomTextAnimator;
            Intrinsics.checkNotNull(bottomTextAnimator2);
            bottomTextAnimator2.setState(BottomTextState.HELPER, false);
            TextView textView3 = this.helperView;
            if (textView3 == null) {
                return;
            }
            textView3.setVisibility(8);
            return;
        }
        BottomTextAnimator bottomTextAnimator3 = this.bottomTextAnimator;
        Intrinsics.checkNotNull(bottomTextAnimator3);
        bottomTextAnimator3.setState(BottomTextState.HELPER, true);
    }

    private final void updateElementContainers(EditorLabelPosition labelPosition, int labelIndent, Thickness padding) {
        this.elementsInternal.clear();
        this.editorContainer.setLabelContainer(null);
        int i = WhenMappings.$EnumSwitchMapping$0[labelPosition.ordinal()];
        if (i == 1) {
            this.labelElement.getMargin().set(0, 0, labelIndent, 0);
            this.elementsInternal.add(this.labelContainer);
            this.elementsInternal.add(this.editorContainer);
            this.labelLayoutStrategy = centerLabelVertically;
            this.itemSpacingTarget = this.editorContainer;
            this.labelContainer.getPadding().set(padding.getStart(), padding.getTop(), 0, padding.getBottom());
            if (this.editorInfo.getIsLabelVisible()) {
                this.editorContainer.getPadding().set(0, padding.getTop(), padding.getEnd(), padding.getBottom());
                return;
            } else {
                this.editorContainer.getPadding().set(padding.getStart(), padding.getTop(), padding.getEnd(), padding.getBottom());
                return;
            }
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            this.labelElement.getMargin().set(0, 0, 0, labelIndent);
            this.editorContainer.setLabelContainer(this.labelContainer);
            this.elementsInternal.add(this.editorContainer);
            this.labelLayoutStrategy = doNotChangeLabelLayout;
            this.itemSpacingTarget = this.editorContainer;
            this.labelContainer.getPadding().set(0);
            this.editorContainer.getPadding().set(padding);
            return;
        }
        this.labelElement.getMargin().set(labelIndent, 0, 0, 0);
        this.elementsInternal.add(this.editorContainer);
        this.elementsInternal.add(this.labelContainer);
        this.labelLayoutStrategy = centerLabelVertically;
        DataFormItemLabelContainer dataFormItemLabelContainer = this.labelContainer;
        this.itemSpacingTarget = dataFormItemLabelContainer;
        dataFormItemLabelContainer.getPadding().set(0, padding.getTop(), padding.getEnd(), padding.getBottom());
        if (this.editorInfo.getIsLabelVisible()) {
            this.editorContainer.getPadding().set(padding.getStart(), padding.getTop(), 0, padding.getBottom());
        } else {
            this.editorContainer.getPadding().set(padding.getStart(), padding.getTop(), padding.getEnd(), padding.getBottom());
        }
    }

    private final void setVisibility() {
        if (this.editorContainer.isVisible() != this.editorInfo.getIsVisible()) {
            this.editorContainer.setVisible(this.editorInfo.getIsVisible());
            ViewParent parent = this.editorView.getParent();
            if (parent != null) {
                parent.requestLayout();
            }
        }
        int i = 8;
        this.editorView.setVisibility(this.editorInfo.getIsVisible() ? 0 : 8);
        View view = this.labelView;
        if (this.editorInfo.getIsVisible() && this.editorInfo.getIsLabelVisible()) {
            i = 0;
        }
        view.setVisibility(i);
        BottomTextAnimator bottomTextAnimator = this.bottomTextAnimator;
        if (bottomTextAnimator != null) {
            bottomTextAnimator.setState(BottomTextState.HELPER, false);
        }
        this.editorView.requestLayout();
    }

    private final void applyLabelSettingsIfNeeded(DataFormEditorInfo settings) {
        AsyncImageInfo labelIconInfo = settings.getLabelIconInfo();
        if ((labelIconInfo != null ? labelIconInfo.getIcon() : null) != null) {
            View view = this.labelView;
            if (view instanceof ImageView) {
                applyIconLabelSettings(settings, (ImageView) view);
                return;
            }
        }
        if (settings.getLabelText().length() > 0) {
            View view2 = this.labelView;
            if (view2 instanceof TextView) {
                applyTextLabelSettings(settings, (TextView) view2);
            }
        }
    }

    private final void applyBottomTextSettingsIfNeeded(DataFormEditorInfo settings) {
        CharSequence text;
        TextView textView;
        EditBase edit = this.editorHolder.getEdit();
        if (edit != null) {
            edit.setHelpText(settings.getHelpText());
            edit.setBottomTextTypeface(settings.getBottomTextTypeface());
            edit.setBottomTextSize(settings.getBottomTextSize());
            edit.setHelpTextColor(settings.getHelperFontColor());
            edit.setErrorColor(settings.getErrorFontColor());
            edit.setReserveBottomTextLine(settings.getReserveBottomTextLine());
            return;
        }
        if (this.helperView != null) {
            if (!Intrinsics.areEqual(settings.getHelpText(), this.helperView.getText())) {
                this.helperView.setText(settings.getHelpText());
            }
            if (settings.getReserveBottomTextLine() && (textView = this.errorView) != null && textView.getVisibility() == 8) {
                this.helperView.setVisibility(0);
            }
            if (!settings.getReserveBottomTextLine() && ((text = this.helperView.getText()) == null || text.length() == 0)) {
                this.helperView.setVisibility(8);
            } else {
                CharSequence text2 = this.helperView.getText();
                if (text2 != null && text2.length() != 0) {
                    this.helperView.setVisibility(0);
                }
            }
            if (!Intrinsics.areEqual(settings.getBottomTextTypeface(), this.helperView.getTypeface())) {
                this.helperView.setTypeface(settings.getBottomTextTypeface());
            }
            if (settings.getBottomTextSize() >= 0.0f) {
                this.helperView.setTextSize(1, settings.getBottomTextSize());
            } else {
                this.helperView.setTextSize(0, this.defaultFontSize);
            }
            this.helperView.setTextColor(settings.getHelperFontColor());
        }
        if (this.errorView != null) {
            if (!Intrinsics.areEqual(settings.getBottomTextTypeface(), this.errorView.getTypeface())) {
                this.errorView.setTypeface(settings.getBottomTextTypeface());
            }
            if (settings.getBottomTextSize() >= 0.0f) {
                this.errorView.setTextSize(1, settings.getBottomTextSize());
            } else {
                this.errorView.setTextSize(0, this.defaultFontSize);
            }
            this.errorView.setTextColor(settings.getErrorFontColor());
        }
    }

    private final void applyTextLabelSettings(DataFormEditorInfo settings, TextView label) {
        label.setTextColor(settings.getLabelFontColor());
        if (!Intrinsics.areEqual(settings.getLabelText(), label.getText())) {
            label.setText(settings.getLabelText());
        }
        if (!Intrinsics.areEqual(settings.getLabelTextTypeface(), label.getTypeface())) {
            label.setTypeface(settings.getLabelTextTypeface());
        }
        if (settings.getLabelTextSize() >= 0.0f) {
            label.setTextSize(1, settings.getLabelTextSize());
        } else {
            label.setTextSize(0, this.defaultFontSize);
        }
    }

    private final void applyIconLabelSettings(DataFormEditorInfo settings, ImageView label) {
        Drawable drawable = label.getDrawable();
        AsyncImageInfo labelIconInfo = settings.getLabelIconInfo();
        if (!Intrinsics.areEqual(drawable, labelIconInfo != null ? labelIconInfo.getIcon() : null)) {
            AsyncImageInfo labelIconInfo2 = settings.getLabelIconInfo();
            label.setImageDrawable(labelIconInfo2 != null ? labelIconInfo2.getIcon() : null);
        }
        label.setColorFilter(settings.getLabelFontColor());
    }

    private final void updateElements() {
        this.editorElement.setGravity(this.editorInfo.getEditorHorizontalAlignment().toGravity());
        this.labelElement.getWidthRequest().toAuto();
        this.labelElement.setGravity(this.editorInfo.getLabelHorizontalAlignment().toGravity());
        this.labelContainer.setWidthRequest(this.editorInfo.getLabelWidth().toSizeDefinition());
        this.labelContainer.setRowOrder(this.editorInfo.getRowIndex());
        this.labelContainer.setItemOrderInRow(this.editorInfo.getRowItemIndex());
        this.labelContainer.setRowSpan(this.editorInfo.getRowSpan());
        this.labelContainer.setGravity(119);
        this.editorContainer.setWidthRequest(this.editorInfo.getEditorWidth().toSizeDefinition());
        this.editorContainer.setRowOrder(this.editorInfo.getRowIndex());
        this.editorContainer.setItemOrderInRow(this.editorInfo.getRowItemIndex());
        this.editorContainer.setRowSpan(this.editorInfo.getRowSpan());
        this.editorContainer.setGravity(8388723);
        updateElementContainers(this.editorInfo.getLabelPosition(), this.editorInfo.getLabelIndent(), this.editorInfo.getPadding());
    }

    private final View getEditorView(DXDataFormEditorItem item) {
        View view = item.getView();
        if (view != null) {
            return view;
        }
        TextView textView = new TextView(this.context);
        textView.setVisibility(8);
        return textView;
    }

    private final View createLabelView(DataFormEditorInfo info) {
        if (info.getLabelIconInfo() != null) {
            ImageView imageView = new ImageView(this.context);
            AsyncImageInfo labelIconInfo = info.getLabelIconInfo();
            if ((labelIconInfo != null ? labelIconInfo.getIcon() : null) != null) {
                AsyncImageInfo labelIconInfo2 = info.getLabelIconInfo();
                imageView.setImageDrawable(labelIconInfo2 != null ? labelIconInfo2.getIcon() : null);
            }
            imageView.setColorFilter(info.getLabelFontColor());
            imageView.setScaleType(ImageView.ScaleType.FIT_END);
            imageView.setAdjustViewBounds(true);
            return imageView;
        }
        if (info.getLabelText().length() > 0) {
            TextView textView = new TextView(this.context);
            textView.setPadding(0, 0, 0, 0);
            textView.setText(info.getLabelText());
            textView.setTextColor(info.getLabelFontColor());
            return textView;
        }
        return new TextView(this.context);
    }

    private final TextView createErrorView() {
        TextView textView = new TextView(this.context);
        textView.setVisibility(8);
        return textView;
    }

    private final TextView createHelperView() {
        TextView textView = new TextView(this.context);
        textView.setVisibility(8);
        return textView;
    }

    @Override // com.devexpress.editors.dataForm.protocols.AsyncImageInfo.AsyncImageInfoListener
    public void onImageLoaded() {
        AsyncImageInfo labelIconInfo = this.editorInfo.getLabelIconInfo();
        if ((labelIconInfo != null ? labelIconInfo.getIcon() : null) == null || !(this.labelView instanceof ImageView)) {
            return;
        }
        applyLabelSettingsIfNeeded(this.editorInfo);
    }
}
