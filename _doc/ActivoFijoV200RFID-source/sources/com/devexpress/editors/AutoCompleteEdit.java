package com.devexpress.editors;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.devexpress.editors.ComboBoxEdit;
import com.devexpress.editors.helpers.MathHelper;
import com.devexpress.editors.layout.factories.AutoCompleteLayoutElementsFactory;
import com.devexpress.editors.popupmanagers.AutoCompletePopupManager;
import com.devexpress.editors.popupmanagers.CollectionViewOwner;
import com.devexpress.editors.popupmanagers.CollectionViewPopupManagerDelegate;
import com.devexpress.editors.popupmanagers.PopupManagerBase;
import com.devexpress.editors.style.AutoCompleteEditStyle;
import com.devexpress.editors.utils.textstrategies.ProcessorTextStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AutoCompleteEdit.kt */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0015\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\bª\u0001«\u0001¬\u0001\u00ad\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010x\u001a\u00020yH\u0014J\u0010\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u000200H\u0016J*\u0010}\u001a\u00020{2\u0006\u0010~\u001a\u00020\u00142\u0006\u0010\u007f\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u00072\u0007\u0010\u0081\u0001\u001a\u00020\u0007H\u0014J\u001b\u0010\u0082\u0001\u001a\u00020{2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\t\u0010\u0083\u0001\u001a\u00020{H\u0002J\t\u0010\u0084\u0001\u001a\u00020{H\u0016J\u0012\u0010\u0085\u0001\u001a\u00020{2\u0007\u0010\u0086\u0001\u001a\u000200H\u0002J\t\u0010\u0087\u0001\u001a\u00020{H\u0014J\t\u0010\u0088\u0001\u001a\u00020{H\u0014J\t\u0010\u0089\u0001\u001a\u00020{H\u0014J\t\u0010\u008a\u0001\u001a\u00020{H\u0014J\t\u0010\u008b\u0001\u001a\u00020{H\u0014J\u0012\u0010\u008c\u0001\u001a\u00020{2\u0007\u0010\u008d\u0001\u001a\u00020\u0007H\u0014J\u0012\u0010\u008e\u0001\u001a\u0002002\u0007\u0010\u008f\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u0090\u0001\u001a\u00020{H\u0002J\u0012\u0010\u0091\u0001\u001a\u00020{2\u0007\u0010\u0092\u0001\u001a\u000200H\u0016J\t\u0010\u0093\u0001\u001a\u00020{H\u0002J\u0007\u0010\u0094\u0001\u001a\u00020{J\u0012\u0010\u0095\u0001\u001a\u00020{2\u0007\u0010\u0096\u0001\u001a\u000200H\u0014J\u0014\u0010\u0097\u0001\u001a\u00020{2\t\u0010\r\u001a\u0005\u0018\u00010\u0098\u0001H\u0016J3\u0010\u0099\u0001\u001a\u00020{2\u0007\u0010\u009a\u0001\u001a\u00020\u00072\u0006\u0010\u007f\u001a\u00020D2\u0007\u0010\u009b\u0001\u001a\u00020D2\u0007\u0010\u009c\u0001\u001a\u00020D2\u0007\u0010\u009d\u0001\u001a\u00020DJ*\u0010\u0099\u0001\u001a\u00020{2\u0006\u0010\u007f\u001a\u00020\u00072\u0007\u0010\u009b\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0007\u0010\u009d\u0001\u001a\u00020\u0007J\u0017\u0010H\u001a\u00020{2\u0007\u0010\u009a\u0001\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020DJ\u0012\u0010\u009e\u0001\u001a\u00020{2\u0007\u0010\u009f\u0001\u001a\u00020\u0007H\u0016J\t\u0010 \u0001\u001a\u00020{H\u0002J\t\u0010¡\u0001\u001a\u00020{H\u0002J\u0007\u0010¢\u0001\u001a\u00020{J\t\u0010£\u0001\u001a\u00020{H\u0014J\u0013\u0010¤\u0001\u001a\u00020{2\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0014J\t\u0010§\u0001\u001a\u00020{H\u0002J\t\u0010¨\u0001\u001a\u00020{H\u0002J\t\u0010©\u0001\u001a\u00020{H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R&\u0010\u0017\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u0004\u0018\u00010!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\r\u001a\u0004\u0018\u00010*@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00101\u001a\u0002002\u0006\u0010\r\u001a\u0002008F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010;\u001a\u0002002\u0006\u0010\r\u001a\u0002008F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u00102\"\u0004\b=\u00104R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010@\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bA\u0010\u0016\"\u0004\bB\u0010CR(\u0010E\u001a\u0004\u0018\u00010D2\b\u0010\r\u001a\u0004\u0018\u00010D8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR(\u0010K\u001a\u0004\u0018\u00010J2\b\u0010\r\u001a\u0004\u0018\u00010J8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR(\u0010Q\u001a\u0004\u0018\u00010P2\b\u0010\r\u001a\u0004\u0018\u00010P8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u000e\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010X\u001a\u0004\u0018\u00010YX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0014\u0010^\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R(\u0010b\u001a\u0004\u0018\u00010a2\b\u0010\r\u001a\u0004\u0018\u00010a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR$\u0010g\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bh\u0010\u0010\"\u0004\bi\u0010\u0012R$\u0010k\u001a\u00020j2\u0006\u0010\r\u001a\u00020j@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u0010\u0010p\u001a\u00020q8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010r\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bs\u0010\u0016\"\u0004\bt\u0010CR$\u0010u\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bv\u0010\u0010\"\u0004\bw\u0010\u0012¨\u0006®\u0001"}, d2 = {"Lcom/devexpress/editors/AutoCompleteEdit;", "Lcom/devexpress/editors/ItemsEditBase;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autoCompleteStyle", "Lcom/devexpress/editors/style/AutoCompleteEditStyle;", "defaultOnClickListener", "Landroid/view/View$OnClickListener;", "value", "disabledSubmitIconColor", "getDisabledSubmitIconColor", "()I", "setDisabledSubmitIconColor", "(I)V", "displayText", "", "getDisplayText", "()Ljava/lang/CharSequence;", "dropDownBackgroundColor", "getDropDownBackgroundColor", "setDropDownBackgroundColor", "dropDownStateChangedListener", "Lcom/devexpress/editors/DropDownStateChangedListener;", "getDropDownStateChangedListener", "()Lcom/devexpress/editors/DropDownStateChangedListener;", "setDropDownStateChangedListener", "(Lcom/devexpress/editors/DropDownStateChangedListener;)V", "dropdownPlacementTarget", "Landroid/view/View;", "getDropdownPlacementTarget", "()Landroid/view/View;", "filterTextChangedListener", "Lcom/devexpress/editors/AutoCompleteEdit$TextChangedListener;", "getFilterTextChangedListener", "()Lcom/devexpress/editors/AutoCompleteEdit$TextChangedListener;", "setFilterTextChangedListener", "(Lcom/devexpress/editors/AutoCompleteEdit$TextChangedListener;)V", "Lcom/devexpress/editors/ComboBoxEdit$Formatter;", "formatter", "getFormatter", "()Lcom/devexpress/editors/ComboBoxEdit$Formatter;", "setFormatter", "(Lcom/devexpress/editors/ComboBoxEdit$Formatter;)V", "", "isLoadingInProcess", "()Z", "setLoadingInProcess", "(Z)V", "itemSelectedListener", "Lcom/devexpress/editors/AutoCompleteEdit$ItemSelectedListener;", "getItemSelectedListener", "()Lcom/devexpress/editors/AutoCompleteEdit$ItemSelectedListener;", "setItemSelectedListener", "(Lcom/devexpress/editors/AutoCompleteEdit$ItemSelectedListener;)V", "manageLoadingAutomatically", "getManageLoadingAutomatically", "setManageLoadingAutomatically", "nextTextChangeReason", "Lcom/devexpress/editors/DXAutoCompleteTextChangeReason;", "noResultsFoundText", "getNoResultsFoundText", "setNoResultsFoundText", "(Ljava/lang/CharSequence;)V", "", "noResultsFoundTextSize", "getNoResultsFoundTextSize", "()Ljava/lang/Float;", "setNoResultsFoundTextSize", "(Ljava/lang/Float;)V", "Landroid/content/res/ColorStateList;", "noResultsFoundTextTint", "getNoResultsFoundTextTint", "()Landroid/content/res/ColorStateList;", "setNoResultsFoundTextTint", "(Landroid/content/res/ColorStateList;)V", "Landroid/graphics/Typeface;", "noResultsFoundTextTypeface", "getNoResultsFoundTextTypeface", "()Landroid/graphics/Typeface;", "setNoResultsFoundTextTypeface", "(Landroid/graphics/Typeface;)V", "popupManager", "Lcom/devexpress/editors/popupmanagers/AutoCompletePopupManager;", "querySubmittedListener", "Lcom/devexpress/editors/AutoCompleteEdit$QuerySubmittedListener;", "getQuerySubmittedListener", "()Lcom/devexpress/editors/AutoCompleteEdit$QuerySubmittedListener;", "setQuerySubmittedListener", "(Lcom/devexpress/editors/AutoCompleteEdit$QuerySubmittedListener;)V", "style", "getStyle", "()Lcom/devexpress/editors/style/AutoCompleteEditStyle;", "Landroid/graphics/drawable/Drawable;", "submitIcon", "getSubmitIcon", "()Landroid/graphics/drawable/Drawable;", "setSubmitIcon", "(Landroid/graphics/drawable/Drawable;)V", "submitIconColor", "getSubmitIconColor", "setSubmitIconColor", "Lcom/devexpress/editors/DXIconVisibility;", "submitIconVisibility", "getSubmitIconVisibility", "()Lcom/devexpress/editors/DXIconVisibility;", "setSubmitIconVisibility", "(Lcom/devexpress/editors/DXIconVisibility;)V", "submitImage", "Landroidx/appcompat/widget/AppCompatImageButton;", "text", "getText", "setText", "waitIndicatorColor", "getWaitIndicatorColor", "setWaitIndicatorColor", "createLayoutElementsFactory", "Lcom/devexpress/editors/LayoutElementsFactory;", "dismissDropDown", "", "onLostFocus", "doOnTextChanged", "s", "start", "before", "count", "finishInitialization", "handleInputFinish", "handleSelectionChanged", "notifyDropDownStateChanged", "isOpened", "onBorderModeChanged", "onContainsFocusChange", "onCornerModeChanged", "onCornerRadiusChanged", "onDetachedFromWindow", "onDisplayHint", "hint", "onEditorAction", "actionId", "onSubmitIconColorsChanged", "onWindowFocusChanged", "hasWindowFocus", "resetNoResultsFoundSettings", "resetNoResultsFoundTextPadding", "setChildrenEnabled", "enabled", "setClearIconClickedListener", "Lcom/devexpress/editors/OnClickHandledListener;", "setNoResultsFoundTextPaddingRelative", "unit", "top", "end", "bottom", "setTextAlignment", "textAlignment", "setupEdit", "setupSubmitIcon", "showDropDown", "updateAll", "updateDrawablesTintMode", "state", "", "updateDropDownDrawable", "updateSubmitImageVisibility", "updateText", "ItemSelectedListener", "PopupManagerDelegate", "QuerySubmittedListener", "TextChangedListener", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class AutoCompleteEdit extends ItemsEditBase {
    private final AutoCompleteEditStyle autoCompleteStyle;
    private final View.OnClickListener defaultOnClickListener;
    private DropDownStateChangedListener dropDownStateChangedListener;
    private TextChangedListener filterTextChangedListener;
    private ComboBoxEdit.Formatter formatter;
    private ItemSelectedListener itemSelectedListener;
    private DXAutoCompleteTextChangeReason nextTextChangeReason;
    private final AutoCompletePopupManager popupManager;
    private QuerySubmittedListener querySubmittedListener;
    private DXIconVisibility submitIconVisibility;
    public final AppCompatImageButton submitImage;

    /* compiled from: AutoCompleteEdit.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/AutoCompleteEdit$ItemSelectedListener;", "", "onItemSelected", "", "edit", "Lcom/devexpress/editors/AutoCompleteEdit;", "selectedItem", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface ItemSelectedListener {
        void onItemSelected(AutoCompleteEdit edit, Object selectedItem);
    }

    /* compiled from: AutoCompleteEdit.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/devexpress/editors/AutoCompleteEdit$QuerySubmittedListener;", "", "onQuerySubmitted", "", "edit", "Lcom/devexpress/editors/AutoCompleteEdit;", "queryText", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface QuerySubmittedListener {
        void onQuerySubmitted(AutoCompleteEdit edit, CharSequence queryText);
    }

    /* compiled from: AutoCompleteEdit.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/devexpress/editors/AutoCompleteEdit$TextChangedListener;", "", "onTextChanged", "", "edit", "Lcom/devexpress/editors/AutoCompleteEdit;", "reason", "Lcom/devexpress/editors/DXAutoCompleteTextChangeReason;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface TextChangedListener {
        void onTextChanged(AutoCompleteEdit edit, DXAutoCompleteTextChangeReason reason);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AutoCompleteEdit(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AutoCompleteEdit(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoCompleteEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.defaultOnClickListener = new View.OnClickListener() { // from class: com.devexpress.editors.AutoCompleteEdit$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AutoCompleteEdit.defaultOnClickListener$lambda$0(AutoCompleteEdit.this, view);
            }
        };
        this.popupManager = new AutoCompletePopupManager(context, new PopupManagerDelegate(this));
        this.autoCompleteStyle = new AutoCompleteEditStyle();
        this.nextTextChangeReason = DXAutoCompleteTextChangeReason.UserInput;
        this.submitImage = new AppCompatImageButton(context);
        this.submitIconVisibility = DXIconVisibility.Always;
        finishInitialization(attributeSet, i);
    }

    public /* synthetic */ AutoCompleteEdit(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void defaultOnClickListener$lambda$0(AutoCompleteEdit this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CollectionViewOwner collectionViewOwner = this$0.getCollectionViewOwner();
        if (collectionViewOwner != null) {
            collectionViewOwner.clearValue();
        }
        this$0.setText("");
    }

    @Override // com.devexpress.editors.ItemsEditBase
    public View getDropdownPlacementTarget() {
        return this.popupManager.getPlacementTarget();
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    public CharSequence getDisplayText() {
        return getTextStrategy$dxeditors_release().getDisplayText();
    }

    @Override // com.devexpress.editors.EditBase
    /* renamed from: getStyle, reason: from getter */
    public AutoCompleteEditStyle getAutoCompleteStyle() {
        return this.autoCompleteStyle;
    }

    @Override // com.devexpress.editors.TextEditBase
    public CharSequence getText() {
        return super.getText();
    }

    @Override // com.devexpress.editors.TextEditBase
    public void setText(CharSequence charSequence) {
        if (Intrinsics.areEqual(super.getText(), charSequence)) {
            return;
        }
        this.nextTextChangeReason = DXAutoCompleteTextChangeReason.ProgrammaticChange;
        super.setText(charSequence);
        onValueChanged();
        getEditText().applyTextAlignment();
    }

    public final CharSequence getNoResultsFoundText() {
        return this.popupManager.getNoResultsFoundText();
    }

    public final void setNoResultsFoundText(CharSequence charSequence) {
        if (charSequence == null) {
            String string = getContext().getString(R.string.autoComplete_noResultsFoundText);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            charSequence = string;
        }
        this.popupManager.setNoResultsFoundText(charSequence);
    }

    public final Float getNoResultsFoundTextSize() {
        return Float.valueOf(this.popupManager.getNoResultsFoundTextSize());
    }

    public final void setNoResultsFoundTextSize(Float f) {
        this.popupManager.setNoResultsFoundTextSize(f != null ? f.floatValue() : getContext().getResources().getDimension(R.dimen.editor_dropDownItem_fontSize));
    }

    public final Typeface getNoResultsFoundTextTypeface() {
        return this.popupManager.getNoResultsFoundTextTypeface();
    }

    public final void setNoResultsFoundTextTypeface(Typeface typeface) {
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        AutoCompletePopupManager autoCompletePopupManager = this.popupManager;
        Intrinsics.checkNotNull(typeface);
        autoCompletePopupManager.setNoResultsFoundTextTypeface(typeface);
    }

    public final ColorStateList getNoResultsFoundTextTint() {
        return this.popupManager.getNoResultsFoundTextTint();
    }

    public final void setNoResultsFoundTextTint(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
            Intrinsics.checkNotNullExpressionValue(colorStateList, "valueOf(...)");
        }
        this.popupManager.setNoResultsFoundTextTint(colorStateList);
    }

    public final Drawable getSubmitIcon() {
        return this.submitImage.getDrawable();
    }

    public final void setSubmitIcon(Drawable drawable) {
        if (drawable == null) {
            drawable = AppCompatResources.getDrawable(getContext(), R.drawable.dxe_search);
        }
        if (Intrinsics.areEqual(this.submitImage.getDrawable(), drawable)) {
            return;
        }
        this.submitImage.setImageDrawable(drawable);
    }

    public final DXIconVisibility getSubmitIconVisibility() {
        return this.submitIconVisibility;
    }

    public final void setSubmitIconVisibility(DXIconVisibility value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.submitIconVisibility == value) {
            return;
        }
        this.submitIconVisibility = value;
        updateSubmitImageVisibility();
        requestLayout();
    }

    public final int getSubmitIconColor() {
        return getAutoCompleteStyle().getSubmitIconColor();
    }

    public final void setSubmitIconColor(int i) {
        if (getAutoCompleteStyle().getSubmitIconColor() == i) {
            return;
        }
        getAutoCompleteStyle().setSubmitIconColor(i);
        onSubmitIconColorsChanged();
    }

    public final int getDisabledSubmitIconColor() {
        return getAutoCompleteStyle().getDisabledSubmitIconColor();
    }

    public final void setDisabledSubmitIconColor(int i) {
        if (getAutoCompleteStyle().getDisabledSubmitIconColor() == i) {
            return;
        }
        getAutoCompleteStyle().setDisabledSubmitIconColor(i);
        onSubmitIconColorsChanged();
    }

    public final QuerySubmittedListener getQuerySubmittedListener() {
        return this.querySubmittedListener;
    }

    public final void setQuerySubmittedListener(QuerySubmittedListener querySubmittedListener) {
        this.querySubmittedListener = querySubmittedListener;
    }

    public final DropDownStateChangedListener getDropDownStateChangedListener() {
        return this.dropDownStateChangedListener;
    }

    public final void setDropDownStateChangedListener(DropDownStateChangedListener dropDownStateChangedListener) {
        this.dropDownStateChangedListener = dropDownStateChangedListener;
    }

    public final ComboBoxEdit.Formatter getFormatter() {
        return this.formatter;
    }

    public final void setFormatter(ComboBoxEdit.Formatter formatter) {
        if (Intrinsics.areEqual(this.formatter, formatter)) {
            return;
        }
        this.formatter = formatter;
    }

    public final TextChangedListener getFilterTextChangedListener() {
        return this.filterTextChangedListener;
    }

    public final void setFilterTextChangedListener(TextChangedListener textChangedListener) {
        this.filterTextChangedListener = textChangedListener;
    }

    public final ItemSelectedListener getItemSelectedListener() {
        return this.itemSelectedListener;
    }

    public final void setItemSelectedListener(ItemSelectedListener itemSelectedListener) {
        this.itemSelectedListener = itemSelectedListener;
    }

    public final boolean isLoadingInProcess() {
        return this.popupManager.getShowWaitIndicator();
    }

    public final void setLoadingInProcess(boolean z) {
        this.popupManager.setShowWaitIndicator(z);
    }

    public final int getWaitIndicatorColor() {
        return this.popupManager.getWaitIndicatorColor();
    }

    public final void setWaitIndicatorColor(int i) {
        this.popupManager.setWaitIndicatorColor(i);
    }

    public final boolean getManageLoadingAutomatically() {
        return this.popupManager.getManageWaitIndicatorAutomatically();
    }

    public final void setManageLoadingAutomatically(boolean z) {
        this.popupManager.setManageWaitIndicatorAutomatically(z);
    }

    public final int getDropDownBackgroundColor() {
        return this.autoCompleteStyle.getDropDownBackgroundColor();
    }

    public final void setDropDownBackgroundColor(int i) {
        if (this.autoCompleteStyle.getDropDownBackgroundColor() == i) {
            return;
        }
        this.autoCompleteStyle.setDropDownBackgroundColor(i);
        updateDropDownDrawable();
    }

    public final void showDropDown() {
        if (getIsReadOnly() || !isEnabled()) {
            return;
        }
        this.popupManager.showPopup();
    }

    @Override // com.devexpress.editors.ItemsEditBase
    public void dismissDropDown(boolean onLostFocus) {
        this.popupManager.dismissPopup();
    }

    public final void setNoResultsFoundTextSize(int unit, float value) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setNoResultsFoundTextSize(Float.valueOf(companion.applyDimension(context, value, unit)));
    }

    public final void setNoResultsFoundTextPaddingRelative(int start, int top, int end, int bottom) {
        this.popupManager.setPaddingRelative(start, top, end, bottom);
    }

    public final void setNoResultsFoundTextPaddingRelative(int unit, float start, float top, float end, float bottom) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int applyDimensionToInt = companion.applyDimensionToInt(context, start, unit);
        MathHelper.Companion companion2 = MathHelper.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        int applyDimensionToInt2 = companion2.applyDimensionToInt(context2, top, unit);
        MathHelper.Companion companion3 = MathHelper.INSTANCE;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        int applyDimensionToInt3 = companion3.applyDimensionToInt(context3, end, unit);
        MathHelper.Companion companion4 = MathHelper.INSTANCE;
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
        this.popupManager.setPaddingRelative(applyDimensionToInt, applyDimensionToInt2, applyDimensionToInt3, companion4.applyDimensionToInt(context4, bottom, unit));
    }

    public final void resetNoResultsFoundTextPadding() {
        this.popupManager.resetPadding();
    }

    @Override // com.devexpress.editors.EditBase, android.view.View
    public void setTextAlignment(int textAlignment) {
        super.setTextAlignment(textAlignment);
        if (isFocused()) {
            return;
        }
        getEditText().applyTextAlignment();
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    protected LayoutElementsFactory createLayoutElementsFactory() {
        TextView internalEditor = getInternalEditor();
        TextView textView = this.labelTextView;
        AppCompatImageButton appCompatImageButton = this.startImage;
        AppCompatImageButton appCompatImageButton2 = this.endImage;
        AppCompatImageButton appCompatImageButton3 = this.clearImage;
        AppCompatImageButton appCompatImageButton4 = this.submitImage;
        AppCompatImageButton appCompatImageButton5 = this.errorImage;
        TextView textView2 = this.errorTextView;
        return new AutoCompleteLayoutElementsFactory(internalEditor, textView, appCompatImageButton, appCompatImageButton2, appCompatImageButton5, textView2, this.helpTextView, this.suffixView, this.prefixView, appCompatImageButton3, appCompatImageButton4);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus) {
            return;
        }
        this.popupManager.dismissPopup();
    }

    @Override // android.view.View
    protected void onDisplayHint(int hint) {
        super.onDisplayHint(hint);
        if (hint == 4) {
            this.popupManager.dismissPopup();
        }
    }

    @Override // com.devexpress.editors.EditBase, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.popupManager.dismissPopup();
        super.onDetachedFromWindow();
    }

    @Override // com.devexpress.editors.EditBase
    protected void onBorderModeChanged() {
        super.onBorderModeChanged();
        updateDropDownDrawable();
    }

    @Override // com.devexpress.editors.EditBase
    protected void onCornerModeChanged() {
        super.onCornerModeChanged();
        updateDropDownDrawable();
    }

    @Override // com.devexpress.editors.EditBase
    protected void onCornerRadiusChanged() {
        super.onCornerRadiusChanged();
        updateDropDownDrawable();
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    protected void finishInitialization(AttributeSet attrs, int defStyleAttr) {
        super.finishInitialization(attrs, defStyleAttr);
        addView(this.submitImage);
        setupEdit();
        setupSubmitIcon();
        setInputType(540673);
        resetNoResultsFoundSettings();
        getEditText().applyTextAlignment();
    }

    @Override // com.devexpress.editors.EditBase
    protected void updateAll() {
        super.updateAll();
        updateDropDownDrawable();
        onSubmitIconColorsChanged();
    }

    @Override // com.devexpress.editors.EditBase
    protected void updateDrawablesTintMode(int[] state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.updateDrawablesTintMode(state);
        updateDrawableTintMode(this.submitImage, state);
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    protected void setChildrenEnabled(boolean enabled) {
        super.setChildrenEnabled(enabled);
        this.submitImage.setEnabled(enabled && !getIsReadOnly());
    }

    private final void setupEdit() {
        getEditText().setKeyDelegate(this.popupManager);
    }

    private final void setupSubmitIcon() {
        this.submitImage.setBackgroundColor(0);
        this.submitImage.setPadding(0, 0, 0, 0);
        this.submitImage.setOnClickListener(new View.OnClickListener() { // from class: com.devexpress.editors.AutoCompleteEdit$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AutoCompleteEdit.setupSubmitIcon$lambda$1(AutoCompleteEdit.this, view);
            }
        });
        this.submitImage.setClickable(true);
        setSubmitIcon(null);
        updateSubmitImageVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSubmitIcon$lambda$1(AutoCompleteEdit this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleInputFinish();
        this$0.clearFocus();
    }

    private final void updateDropDownDrawable() {
        this.popupManager.setBackgroundColor(this.autoCompleteStyle.getDropDownBackgroundColor());
        this.popupManager.setBorderRounds(this.autoCompleteStyle.getBorderRounds());
    }

    private final void onSubmitIconColorsChanged() {
        updateIconTintList(this.submitImage, getAutoCompleteStyle().getSubmitIconColor(), getAutoCompleteStyle().getDisabledSubmitIconColor());
    }

    private final void updateText() {
        CharSequence charSequence;
        CollectionViewOwner collectionViewOwner = getCollectionViewOwner();
        if (collectionViewOwner == null || (charSequence = collectionViewOwner.getSelectedItemText()) == null) {
        }
        CharSequence applyCharacterCasing = ProcessorTextStrategy.INSTANCE.applyCharacterCasing(charSequence, getCharacterCasing(), 0, charSequence.length());
        getEditText().setText(applyCharacterCasing);
        getEditText().setSelection(applyCharacterCasing.length());
        onValueChanged();
    }

    @Override // com.devexpress.editors.ItemsEditBase, com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    protected void onContainsFocusChange() {
        super.onContainsFocusChange();
        if (getContainsFocus()) {
            getEditText().applyTextAlignment();
        }
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    public void setClearIconClickedListener(OnClickHandledListener value) {
        if (value != null) {
            value.setClickListener(this.defaultOnClickListener);
        }
        this.clearImage.setOnClickListener(value != null ? value : this.defaultOnClickListener);
    }

    @Override // com.devexpress.editors.EditBase
    protected boolean onEditorAction(int actionId) {
        handleInputFinish();
        return super.onEditorAction(actionId);
    }

    @Override // com.devexpress.editors.TextEditBase
    protected void doOnTextChanged(CharSequence s, int start, int before, int count) {
        TextChangedListener textChangedListener;
        CollectionViewOwner collectionViewOwner;
        Intrinsics.checkNotNullParameter(s, "s");
        super.doOnTextChanged(s, start, before, count);
        if (this.nextTextChangeReason == DXAutoCompleteTextChangeReason.ProgrammaticChange && (isFocused() || getInternalEditor().isFocused())) {
            this.nextTextChangeReason = DXAutoCompleteTextChangeReason.UserInput;
        }
        if (this.nextTextChangeReason != DXAutoCompleteTextChangeReason.ItemSelected && (collectionViewOwner = getCollectionViewOwner()) != null) {
            collectionViewOwner.clearValue();
        }
        updateClearImageVisibility();
        updateSubmitImageVisibility();
        this.popupManager.handleTextChanged(this.nextTextChangeReason);
        if (!getTextStrategy$dxeditors_release().getShouldReapplyEditorText() && (textChangedListener = this.filterTextChangedListener) != null) {
            textChangedListener.onTextChanged(this, this.nextTextChangeReason);
        }
        this.nextTextChangeReason = DXAutoCompleteTextChangeReason.UserInput;
    }

    private final void updateSubmitImageVisibility() {
        CharSequence text;
        CharSequence text2;
        boolean z = false;
        updateIconVisibility(this.submitImage, this.submitIconVisibility == DXIconVisibility.Always || !(this.submitIconVisibility != DXIconVisibility.Auto || (text2 = getText()) == null || text2.length() == 0));
        AppCompatImageButton appCompatImageButton = this.submitImage;
        if (isEnabled() && (text = getText()) != null && text.length() != 0) {
            z = true;
        }
        appCompatImageButton.setEnabled(z);
    }

    @Override // com.devexpress.editors.ItemsEditBase
    public void handleSelectionChanged() {
        this.nextTextChangeReason = DXAutoCompleteTextChangeReason.ItemSelected;
        updateText();
        this.popupManager.dismissPopup();
        super.handleSelectionChanged();
    }

    private final void handleInputFinish() {
        this.popupManager.dismissPopup();
        QuerySubmittedListener querySubmittedListener = this.querySubmittedListener;
        if (querySubmittedListener != null) {
            querySubmittedListener.onQuerySubmitted(this, getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyDropDownStateChanged(boolean isOpened) {
        DropDownStateChangedListener dropDownStateChangedListener = this.dropDownStateChangedListener;
        if (dropDownStateChangedListener != null) {
            dropDownStateChangedListener.onDropDownStateChanged(this, isOpened);
        }
    }

    private final void resetNoResultsFoundSettings() {
        setNoResultsFoundText(null);
        setNoResultsFoundTextSize(null);
        setNoResultsFoundTextTint(null);
        setNoResultsFoundTextTypeface(null);
    }

    /* compiled from: AutoCompleteEdit.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0014\u0010\r\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/devexpress/editors/AutoCompleteEdit$PopupManagerDelegate;", "Lcom/devexpress/editors/WeakHolder;", "Lcom/devexpress/editors/AutoCompleteEdit;", "Lcom/devexpress/editors/popupmanagers/CollectionViewPopupManagerDelegate;", "edit", "(Lcom/devexpress/editors/AutoCompleteEdit;)V", "filterString", "", "getFilterString", "()Ljava/lang/CharSequence;", "isDataSourceEmpty", "", "()Z", "isFilterEnabled", "isVisible", TypedValues.AttributesType.S_TARGET, "Landroid/view/View;", "getTarget", "()Landroid/view/View;", "onDismissPopup", "", "manager", "Lcom/devexpress/editors/popupmanagers/PopupManagerBase;", "onDropdownRecalculated", "onFilterChanged", "onQueryListView", "onShowPopup", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PopupManagerDelegate extends WeakHolder<AutoCompleteEdit> implements CollectionViewPopupManagerDelegate {
        @Override // com.devexpress.editors.popupmanagers.CollectionViewPopupManagerDelegate
        public boolean isFilterEnabled() {
            return true;
        }

        @Override // com.devexpress.editors.popupmanagers.CollectionViewPopupManagerDelegate
        public void onFilterChanged() {
        }

        public PopupManagerDelegate(AutoCompleteEdit autoCompleteEdit) {
            super(autoCompleteEdit);
        }

        @Override // com.devexpress.editors.popupmanagers.PopupManagerBaseDelegate
        public View getTarget() {
            AutoCompleteEdit edit = getEdit();
            if (edit != null) {
                return edit;
            }
            throw new IllegalStateException("Edit must exist.");
        }

        @Override // com.devexpress.editors.popupmanagers.CollectionViewPopupManagerDelegate
        public boolean isDataSourceEmpty() {
            CollectionViewOwner collectionViewOwner;
            AutoCompleteEdit edit = getEdit();
            if (edit == null || (collectionViewOwner = edit.getCollectionViewOwner()) == null) {
                return true;
            }
            return collectionViewOwner.isDataSourceEmpty();
        }

        @Override // com.devexpress.editors.popupmanagers.PopupManagerBaseDelegate
        public boolean isVisible() {
            AutoCompleteEdit edit = getEdit();
            return (edit == null || edit.getWindowVisibility() == 8) ? false : true;
        }

        @Override // com.devexpress.editors.popupmanagers.CollectionViewPopupManagerDelegate
        public CharSequence getFilterString() {
            return "";
        }

        @Override // com.devexpress.editors.popupmanagers.PopupManagerBaseDelegate
        public void onShowPopup(PopupManagerBase manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            AutoCompleteEdit edit = getEdit();
            if (edit != null) {
                edit.notifyDropDownStateChanged(true);
            }
        }

        @Override // com.devexpress.editors.popupmanagers.PopupManagerBaseDelegate
        public void onDismissPopup(PopupManagerBase manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            AutoCompleteEdit edit = getEdit();
            if (edit != null) {
                edit.notifyDropDownStateChanged(false);
            }
        }

        @Override // com.devexpress.editors.popupmanagers.CollectionViewPopupManagerDelegate
        public View onQueryListView() {
            CollectionViewOwner collectionViewOwner;
            AutoCompleteEdit edit = getEdit();
            if (edit == null || (collectionViewOwner = edit.getCollectionViewOwner()) == null) {
                return null;
            }
            return collectionViewOwner.getCollectionView();
        }

        @Override // com.devexpress.editors.popupmanagers.CollectionViewPopupManagerDelegate
        public void onDropdownRecalculated() {
            CollectionViewOwner collectionViewOwner;
            AutoCompleteEdit edit = getEdit();
            if (edit == null || (collectionViewOwner = edit.getCollectionViewOwner()) == null) {
                return;
            }
            collectionViewOwner.ensureSelectionVisible();
        }
    }
}
