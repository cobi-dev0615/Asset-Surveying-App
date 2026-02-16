package com.devexpress.editors;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.devexpress.editors.dropdown.DXDropdownContainer;
import com.devexpress.editors.layout.factories.PickerEditLayoutElementsFactory;
import com.devexpress.editors.model.BorderRounds;
import com.devexpress.editors.popupmanagers.CollectionViewOwner;
import com.devexpress.editors.popupmanagers.CollectionViewPopupManagerDelegate;
import com.devexpress.editors.popupmanagers.PopupManagerBase;
import com.devexpress.editors.popupmanagers.PopupPresenter;
import com.devexpress.editors.style.ComboBoxEditStyle;
import com.devexpress.editors.utils.CheckableImageButton;
import com.devexpress.editors.utils.ContextMenuDelegate;
import com.devexpress.editors.utils.textstrategies.PopupTextProcessor;
import com.devexpress.editors.utils.textstrategies.ProcessorTextStrategy;
import com.devexpress.editors.utils.textstrategies.TextStrategy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComboBoxEdit.kt */
@Metadata(d1 = {"\u0000Ç\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001C\b\u0016\u0018\u0000  \u00012\u00020\u0001:\u0014\u009e\u0001\u009f\u0001 \u0001¡\u0001¢\u0001£\u0001¤\u0001¥\u0001¦\u0001§\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010s\u001a\u00020tH\u0002J\u0010\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020xH\u0002J\b\u0010y\u001a\u00020zH\u0014J\u0017\u0010{\u001a\u00020|2\b\u0010}\u001a\u0004\u0018\u00010|H\u0010¢\u0006\u0002\b~J\u0011\u0010\u007f\u001a\u00020t2\u0007\u0010\u0080\u0001\u001a\u00020[H\u0016J\t\u0010\u0081\u0001\u001a\u00020tH\u0002J\t\u0010\u0082\u0001\u001a\u00020[H\u0002J\t\u0010\u0083\u0001\u001a\u00020tH\u0014J\t\u0010\u0084\u0001\u001a\u00020tH\u0014J\u0012\u0010\u0085\u0001\u001a\u00020t2\u0007\u0010\u0086\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u0087\u0001\u001a\u00020tH\u0002J\t\u0010\u0088\u0001\u001a\u00020tH\u0002J\t\u0010\u0089\u0001\u001a\u00020tH\u0004J\t\u0010\u008a\u0001\u001a\u00020tH\u0004J\u0012\u0010\u008b\u0001\u001a\u00020[2\u0007\u0010\u008c\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u008d\u0001\u001a\u00020tH\u0002J\t\u0010\u008e\u0001\u001a\u00020tH\u0014J\t\u0010\u008f\u0001\u001a\u00020[H\u0014J\t\u0010\u0090\u0001\u001a\u00020tH\u0014J\u0007\u0010\u0091\u0001\u001a\u00020tJ\u0007\u0010\u0092\u0001\u001a\u00020tJ\u0007\u0010\u0093\u0001\u001a\u00020tJ\u0012\u0010\u0094\u0001\u001a\u00020t2\u0007\u0010\u0095\u0001\u001a\u00020[H\u0014J\u0014\u0010\u0096\u0001\u001a\u00020t2\t\u0010\u0010\u001a\u0005\u0018\u00010\u0097\u0001H\u0016J\u0012\u0010\u0098\u0001\u001a\u00020t2\u0007\u0010\u0099\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u009a\u0001\u001a\u00020tH\u0014J\t\u0010\u009b\u0001\u001a\u00020tH\u0014J\u0007\u0010\u009c\u0001\u001a\u00020[J\t\u0010\u009d\u0001\u001a\u00020tH\u0014R\u0014\u0010\t\u001a\u00020\u00078TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010 R(\u0010\"\u001a\u0004\u0018\u00010\r2\b\u0010!\u001a\u0004\u0018\u00010\r@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010%R&\u0010&\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010\u000b\"\u0004\b(\u0010 R(\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\u0010\u001a\u0004\u0018\u00010)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u0010\u000b\"\u0004\b7\u0010 R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010DR\u0018\u0010E\u001a\u00060FR\u00020\u0000X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0016\u0010I\u001a\u0004\u0018\u00010J8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020NX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010O\u001a\u0004\u0018\u00010PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR(\u0010V\u001a\u0004\u0018\u00010U2\b\u0010\u0010\u001a\u0004\u0018\u00010U@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010\\\u001a\u00020[2\u0006\u0010\u0010\u001a\u00020[@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0014\u0010a\u001a\u00020b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bc\u0010dR$\u0010e\u001a\u00020[2\u0006\u0010\u0010\u001a\u00020[@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010^\"\u0004\bf\u0010`R\u0014\u0010g\u001a\u00020[8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bg\u0010^R$\u0010h\u001a\u00020[2\u0006\u0010\u0010\u001a\u00020[@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010^\"\u0004\bi\u0010`R\u0014\u0010j\u001a\u00020kX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0014\u0010n\u001a\u00020A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bo\u0010pR\u0014\u0010q\u001a\u00020[8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\br\u0010^¨\u0006¨\u0001"}, d2 = {"Lcom/devexpress/editors/ComboBoxEdit;", "Lcom/devexpress/editors/ItemsEditBase;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defaultStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actualEditorInputType", "getActualEditorInputType", "()I", "actualPlaceholder", "", "getActualPlaceholder", "()Ljava/lang/CharSequence;", "value", "Lcom/devexpress/editors/DXCharacterCasing;", "characterCasing", "getCharacterCasing", "()Lcom/devexpress/editors/DXCharacterCasing;", "setCharacterCasing", "(Lcom/devexpress/editors/DXCharacterCasing;)V", "contentContainerController", "Lcom/devexpress/editors/ContentContainerControllerListener;", "getContentContainerController", "()Lcom/devexpress/editors/ContentContainerControllerListener;", "setContentContainerController", "(Lcom/devexpress/editors/ContentContainerControllerListener;)V", "disabledDropDownIconColor", "getDisabledDropDownIconColor", "setDisabledDropDownIconColor", "(I)V", "<set-?>", "displayText", "getDisplayText", "setDisplayText", "(Ljava/lang/CharSequence;)V", "dropDownBackgroundColor", "getDropDownBackgroundColor", "setDropDownBackgroundColor", "Landroid/graphics/drawable/Drawable;", "dropDownIcon", "getDropDownIcon", "()Landroid/graphics/drawable/Drawable;", "setDropDownIcon", "(Landroid/graphics/drawable/Drawable;)V", "dropDownIconClickListener", "Landroid/view/View$OnClickListener;", "getDropDownIconClickListener", "()Landroid/view/View$OnClickListener;", "setDropDownIconClickListener", "(Landroid/view/View$OnClickListener;)V", "dropDownIconColor", "getDropDownIconColor", "setDropDownIconColor", "dropDownImage", "Lcom/devexpress/editors/utils/CheckableImageButton;", "dropDownStateChangeListener", "Lcom/devexpress/editors/DropDownStateChangedListener;", "getDropDownStateChangeListener", "()Lcom/devexpress/editors/DropDownStateChangedListener;", "setDropDownStateChangeListener", "(Lcom/devexpress/editors/DropDownStateChangedListener;)V", "dropDownStyle", "Lcom/devexpress/editors/style/ComboBoxEditStyle;", "dropdownAnimationListener", "com/devexpress/editors/ComboBoxEdit$dropdownAnimationListener$1", "Lcom/devexpress/editors/ComboBoxEdit$dropdownAnimationListener$1;", "dropdownListener", "Lcom/devexpress/editors/ComboBoxEdit$ComboBoxDropdownListener;", "getDropdownListener$dxeditors_release", "()Lcom/devexpress/editors/ComboBoxEdit$ComboBoxDropdownListener;", "dropdownPlacementTarget", "Landroid/view/View;", "getDropdownPlacementTarget", "()Landroid/view/View;", "filterStrategy", "Lcom/devexpress/editors/ComboBoxEdit$EditTextStrategy;", "filterTextChangedListener", "Lcom/devexpress/editors/ComboBoxEdit$OnFilterTextChangedListener;", "getFilterTextChangedListener", "()Lcom/devexpress/editors/ComboBoxEdit$OnFilterTextChangedListener;", "setFilterTextChangedListener", "(Lcom/devexpress/editors/ComboBoxEdit$OnFilterTextChangedListener;)V", "Lcom/devexpress/editors/ComboBoxEdit$Formatter;", "formatter", "getFormatter", "()Lcom/devexpress/editors/ComboBoxEdit$Formatter;", "setFormatter", "(Lcom/devexpress/editors/ComboBoxEdit$Formatter;)V", "", "hasExternContainer", "getHasExternContainer", "()Z", "setHasExternContainer", "(Z)V", "internalEditor", "Landroid/widget/TextView;", "getInternalEditor", "()Landroid/widget/TextView;", "isDropDownIconVisible", "setDropDownIconVisible", "isDropDownOpen", "isFilterEnabled", "setFilterEnabled", "popup", "Lcom/devexpress/editors/dropdown/DXDropdownContainer;", "getPopup", "()Lcom/devexpress/editors/dropdown/DXDropdownContainer;", "style", "getStyle", "()Lcom/devexpress/editors/style/ComboBoxEditStyle;", "useCustomEditorWhenFocused", "getUseCustomEditorWhenFocused", "clearPlacementTarget", "", "convertToFloat", "", "borderRounds", "Lcom/devexpress/editors/model/BorderRounds;", "createLayoutElementsFactory", "Lcom/devexpress/editors/LayoutElementsFactory;", "createTextStrategy", "Lcom/devexpress/editors/utils/textstrategies/TextStrategy;", "oldStrategy", "createTextStrategy$dxeditors_release", "dismissDropDown", "onLostFocus", "initDropDownImage", "isEnoughSpaceForPopup", "onContainsFocusChange", "onDetachedFromWindow", "onDisplayHint", "hint", "onDropDownIconClicked", "onDropDownIconColorsChanged", "onDropdownClosed", "onDropdownOpened", "onEditorAction", "actionId", "onFilterConfigurationChanged", "onReadOnlyChanged", "onSingleTapUp", "onValueChanged", "refreshDisplayText", "releaseResources", "selectedItemUpdated", "setChildrenEnabled", "enabled", "setClearIconClickedListener", "Lcom/devexpress/editors/OnClickHandledListener;", "setTextAlignment", "textAlignment", "setupCommonStyleColors", "setupCommonStyleSizes", "showDropDown", "updateAll", "ComboBoxDropdownListener", "ComboBoxPopupPresenter", "Companion", "EditTextStrategy", "FilterDisabledTextStrategy", "FilterEnabledTextStrategy", "Formatter", "OnFilterTextChangedListener", "PopupManagerDelegate", "TextChangedListener", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class ComboBoxEdit extends ItemsEditBase {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ContentContainerControllerListener contentContainerController;
    private CharSequence displayText;
    private View.OnClickListener dropDownIconClickListener;
    private final CheckableImageButton dropDownImage;
    private DropDownStateChangedListener dropDownStateChangeListener;
    private final ComboBoxEditStyle dropDownStyle;
    private final ComboBoxEdit$dropdownAnimationListener$1 dropdownAnimationListener;
    private final ComboBoxDropdownListener dropdownListener;
    private EditTextStrategy filterStrategy;
    private OnFilterTextChangedListener filterTextChangedListener;
    private Formatter formatter;
    private boolean hasExternContainer;
    private boolean isDropDownIconVisible;
    private boolean isFilterEnabled;
    private final DXDropdownContainer popup;

    /* compiled from: ComboBoxEdit.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/devexpress/editors/ComboBoxEdit$EditTextStrategy;", "", "filterString", "", "getFilterString", "()Ljava/lang/CharSequence;", "clearFilter", "", "notifyFilterChanged", "onClearIconClicked", "onHasFocus", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface EditTextStrategy {
        void clearFilter();

        CharSequence getFilterString();

        void notifyFilterChanged();

        void onClearIconClicked();

        void onHasFocus();
    }

    /* compiled from: ComboBoxEdit.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H&¨\u0006\u0005"}, d2 = {"Lcom/devexpress/editors/ComboBoxEdit$Formatter;", "", "format", "", "obj", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Formatter {
        String format(Object obj);
    }

    /* compiled from: ComboBoxEdit.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/devexpress/editors/ComboBoxEdit$OnFilterTextChangedListener;", "", "onFilterTextChanged", "", "edit", "Lcom/devexpress/editors/ComboBoxEdit;", "filterText", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnFilterTextChangedListener {
        void onFilterTextChanged(ComboBoxEdit edit, CharSequence filterText);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ComboBoxEdit(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ComboBoxEdit(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @JvmStatic
    public static final Drawable getDefaultDropDownDownIcon(Context context) {
        return INSTANCE.getDefaultDropDownDownIcon(context);
    }

    @JvmStatic
    public static final Drawable getDefaultDropDownIcon(Context context) {
        return INSTANCE.getDefaultDropDownIcon(context);
    }

    @JvmStatic
    public static final Drawable getDefaultDropDownUpIcon(Context context) {
        return INSTANCE.getDefaultDropDownUpIcon(context);
    }

    /* compiled from: ComboBoxEdit.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\t"}, d2 = {"Lcom/devexpress/editors/ComboBoxEdit$Companion;", "", "()V", "getDefaultDropDownDownIcon", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "getDefaultDropDownIcon", "getDefaultDropDownUpIcon", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Drawable getDefaultDropDownIcon(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return AppCompatResources.getDrawable(context, R.drawable.dxe_drop_down);
        }

        @JvmStatic
        public final Drawable getDefaultDropDownDownIcon(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return AppCompatResources.getDrawable(context, R.drawable.dxe_drop_down__down);
        }

        @JvmStatic
        public final Drawable getDefaultDropDownUpIcon(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return AppCompatResources.getDrawable(context, R.drawable.dxe_drop_down__up);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.devexpress.editors.ComboBoxEdit$dropdownAnimationListener$1] */
    public ComboBoxEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isDropDownIconVisible = true;
        this.isFilterEnabled = true;
        CheckableImageButton checkableImageButton = new CheckableImageButton(context, null, 0, 6, null);
        this.dropDownImage = checkableImageButton;
        this.dropDownStyle = new ComboBoxEditStyle();
        this.filterStrategy = new FilterEnabledTextStrategy(this);
        DXDropdownContainer dXDropdownContainer = new DXDropdownContainer(context);
        this.popup = dXDropdownContainer;
        ComboBoxDropdownListener comboBoxDropdownListener = new ComboBoxDropdownListener();
        this.dropdownListener = comboBoxDropdownListener;
        ?? r2 = new DXDropdownContainer.DropdownAnimationListener() { // from class: com.devexpress.editors.ComboBoxEdit$dropdownAnimationListener$1
            @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownAnimationListener
            public void closingAnimationWillStart() {
            }

            @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownAnimationListener
            public void openingAnimationComplete() {
            }

            @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownAnimationListener
            public void openingAnimationWillStart() {
            }

            @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownAnimationListener
            public void closingAnimationComplete() {
                ComboBoxEdit.this.clearPlacementTarget();
            }
        };
        this.dropdownAnimationListener = r2;
        boolean z = false;
        dXDropdownContainer.setFocusable(false);
        dXDropdownContainer.setOnActionlistener(comboBoxDropdownListener);
        dXDropdownContainer.setAnimationListener((DXDropdownContainer.DropdownAnimationListener) r2);
        setDropDownIcon(null);
        addView(checkableImageButton);
        initDropDownImage();
        getEditText().setDuplicateParentStateEnabled(true);
        requestTextStrategyChange();
        setInputType(1);
        finishInitialization(attributeSet, i);
        if (this.isFilterEnabled && !this.hasExternContainer && !getIsReadOnly()) {
            z = true;
        }
        setInternalEditorEditable(z);
        getEditText().setSingleLine(true);
    }

    public /* synthetic */ ComboBoxEdit(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final int getDropDownBackgroundColor() {
        return this.dropDownStyle.getDropDownBackgroundColor();
    }

    public final void setDropDownBackgroundColor(int i) {
        if (this.dropDownStyle.getDropDownBackgroundColor() == i) {
            return;
        }
        this.dropDownStyle.setDropDownBackgroundColor(i);
    }

    public final Drawable getDropDownIcon() {
        return this.dropDownImage.getDrawable();
    }

    public final void setDropDownIcon(Drawable drawable) {
        Drawable drawable2;
        if (drawable == null) {
            Companion companion = INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            drawable2 = companion.getDefaultDropDownIcon(context);
        } else {
            drawable2 = drawable;
        }
        if (Intrinsics.areEqual(this.dropDownImage.getDrawable(), drawable)) {
            return;
        }
        this.dropDownImage.setImageDrawable(drawable2);
    }

    /* renamed from: isDropDownIconVisible, reason: from getter */
    public final boolean getIsDropDownIconVisible() {
        return this.isDropDownIconVisible;
    }

    public final void setDropDownIconVisible(boolean z) {
        if (this.isDropDownIconVisible == z) {
            return;
        }
        this.isDropDownIconVisible = z;
        updateIconVisibility(this.dropDownImage, z);
    }

    public final int getDropDownIconColor() {
        return getAutoCompleteStyle().getDropDownIconColor();
    }

    public final void setDropDownIconColor(int i) {
        if (getAutoCompleteStyle().getDropDownIconColor() == i) {
            return;
        }
        getAutoCompleteStyle().setDropDownIconColor(i);
        onDropDownIconColorsChanged();
    }

    public final int getDisabledDropDownIconColor() {
        return getAutoCompleteStyle().getDisabledDropDownIconColor();
    }

    public final void setDisabledDropDownIconColor(int i) {
        if (getAutoCompleteStyle().getDisabledDropDownIconColor() == i) {
            return;
        }
        getAutoCompleteStyle().setDisabledDropDownIconColor(i);
        onDropDownIconColorsChanged();
    }

    public final Formatter getFormatter() {
        return this.formatter;
    }

    public final void setFormatter(Formatter formatter) {
        if (Intrinsics.areEqual(this.formatter, formatter)) {
            return;
        }
        this.formatter = formatter;
        refreshDisplayText();
    }

    /* renamed from: isFilterEnabled, reason: from getter */
    public final boolean getIsFilterEnabled() {
        return this.isFilterEnabled;
    }

    public final void setFilterEnabled(boolean z) {
        if (this.isFilterEnabled == z) {
            return;
        }
        this.isFilterEnabled = z;
        onFilterConfigurationChanged();
    }

    public final boolean getHasExternContainer() {
        return this.hasExternContainer;
    }

    public final void setHasExternContainer(boolean z) {
        if (this.hasExternContainer == z) {
            return;
        }
        this.hasExternContainer = z;
        onFilterConfigurationChanged();
    }

    public final DropDownStateChangedListener getDropDownStateChangeListener() {
        return this.dropDownStateChangeListener;
    }

    public final void setDropDownStateChangeListener(DropDownStateChangedListener dropDownStateChangedListener) {
        this.dropDownStateChangeListener = dropDownStateChangedListener;
    }

    public final OnFilterTextChangedListener getFilterTextChangedListener() {
        return this.filterTextChangedListener;
    }

    public final void setFilterTextChangedListener(OnFilterTextChangedListener onFilterTextChangedListener) {
        this.filterTextChangedListener = onFilterTextChangedListener;
    }

    public final View.OnClickListener getDropDownIconClickListener() {
        return this.dropDownIconClickListener;
    }

    public final void setDropDownIconClickListener(View.OnClickListener onClickListener) {
        this.dropDownIconClickListener = onClickListener;
    }

    public final ContentContainerControllerListener getContentContainerController() {
        return this.contentContainerController;
    }

    public final void setContentContainerController(ContentContainerControllerListener contentContainerControllerListener) {
        this.contentContainerController = contentContainerControllerListener;
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    public TextView getInternalEditor() {
        return getEditText();
    }

    @Override // com.devexpress.editors.EditBase
    /* renamed from: getStyle, reason: from getter */
    public ComboBoxEditStyle getAutoCompleteStyle() {
        return this.dropDownStyle;
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    public CharSequence getDisplayText() {
        return this.displayText;
    }

    protected void setDisplayText(CharSequence charSequence) {
        this.displayText = charSequence;
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    public DXCharacterCasing getCharacterCasing() {
        return getTextStrategy$dxeditors_release().getCharacterCasing();
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    public void setCharacterCasing(DXCharacterCasing value) {
        Intrinsics.checkNotNullParameter(value, "value");
        getTextStrategy$dxeditors_release().setCharacterCasing(value);
        onEditorInputTypeChange();
    }

    @Override // com.devexpress.editors.EditBase
    protected int getActualEditorInputType() {
        if (!this.isFilterEnabled || this.hasExternContainer) {
            return 0;
        }
        return super.getActualEditorInputType();
    }

    @Override // com.devexpress.editors.ItemsEditBase
    protected boolean getUseCustomEditorWhenFocused() {
        return getHasValue() && (!this.isFilterEnabled || this.hasExternContainer);
    }

    @Override // com.devexpress.editors.EditBase
    /* renamed from: getActualPlaceholder */
    public CharSequence getPlaceholder() {
        if (this.isFilterEnabled) {
            return super.getPlaceholder();
        }
        return null;
    }

    @Override // com.devexpress.editors.ItemsEditBase
    public View getDropdownPlacementTarget() {
        return this.popup.getPlacementTarget();
    }

    protected final DXDropdownContainer getPopup() {
        return this.popup;
    }

    /* renamed from: getDropdownListener$dxeditors_release, reason: from getter */
    public final ComboBoxDropdownListener getDropdownListener() {
        return this.dropdownListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDropDownOpen() {
        ContentContainerControllerListener contentContainerControllerListener = this.contentContainerController;
        if (contentContainerControllerListener != null) {
            Intrinsics.checkNotNull(contentContainerControllerListener);
            return contentContainerControllerListener.isOpened();
        }
        return this.popup.getIsDropdownOpen();
    }

    public final boolean showDropDown() {
        if (!getIsReadOnly() && !isDropDownOpen() && isEnabled()) {
            ContentContainerControllerListener contentContainerControllerListener = this.contentContainerController;
            if (contentContainerControllerListener != null) {
                Intrinsics.checkNotNull(contentContainerControllerListener);
                contentContainerControllerListener.show();
                onDropdownOpened();
                return false;
            }
            if (!isDropDownOpen() && !getIsReadOnly()) {
                boolean isEnoughSpaceForPopup = isEnoughSpaceForPopup();
                this.popup.setPlacementTarget(isEnoughSpaceForPopup ? this : getActualInternalEditorView());
                this.popup.setCornerRadius(convertToFloat(this.dropDownStyle.getBorderRounds()));
                this.popup.setBackgroundColor(this.dropDownStyle.getDropDownBackgroundColor());
                DXDropdownContainer dXDropdownContainer = this.popup;
                CollectionViewOwner collectionViewOwner = getCollectionViewOwner();
                dXDropdownContainer.setContentView(collectionViewOwner != null ? collectionViewOwner.getCollectionView() : null);
                if (isEnoughSpaceForPopup) {
                    this.popup.setMargin(new Rect(0, 0, 0, -getContentLayout().getBottomTextAreaFrame().getHeight()));
                } else {
                    this.popup.setMargin(new Rect(0, 0, 0, 0));
                }
                this.popup.setDropdownOpen(true);
            }
        }
        return true;
    }

    private final boolean isEnoughSpaceForPopup() {
        Rect rect = new Rect();
        View rootView = getRootView();
        if (rootView != null) {
            rootView.getWindowVisibleDisplayFrame(rect);
        }
        int top = getTop() - rect.top;
        int bottom = rect.bottom - getBottom();
        float height = rect.height();
        return !(((float) top) / height <= 0.05f && ((float) bottom) / height <= 0.05f);
    }

    private final void onFilterConfigurationChanged() {
        FilterDisabledTextStrategy filterDisabledTextStrategy;
        updatePlaceholderText();
        boolean z = this.isFilterEnabled && !this.hasExternContainer;
        if (z) {
            filterDisabledTextStrategy = new FilterEnabledTextStrategy(this);
        } else {
            filterDisabledTextStrategy = new FilterDisabledTextStrategy(this);
        }
        this.filterStrategy = filterDisabledTextStrategy;
        setInternalEditorEditable(z && !getIsReadOnly());
    }

    public final void releaseResources() {
        this.popup.releaseResources();
    }

    @Override // com.devexpress.editors.ItemsEditBase
    public void dismissDropDown(boolean onLostFocus) {
        ContentContainerControllerListener contentContainerControllerListener = this.contentContainerController;
        if (contentContainerControllerListener != null) {
            Intrinsics.checkNotNull(contentContainerControllerListener);
            if (contentContainerControllerListener.isOpened()) {
                ContentContainerControllerListener contentContainerControllerListener2 = this.contentContainerController;
                Intrinsics.checkNotNull(contentContainerControllerListener2);
                if (contentContainerControllerListener2.close(onLostFocus)) {
                    onDropdownClosed();
                    return;
                }
                return;
            }
            return;
        }
        this.popup.setDropdownOpen(false);
    }

    @Override // com.devexpress.editors.TextEditBase
    public TextStrategy createTextStrategy$dxeditors_release(TextStrategy oldStrategy) {
        return new ProcessorTextStrategy(new PopupTextProcessor(new ComboBoxPopupPresenter()), getEditText(), new Function1<CharSequence, Unit>() { // from class: com.devexpress.editors.ComboBoxEdit$createTextStrategy$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence) {
                invoke2(charSequence);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CharSequence charSequence) {
                ComboBoxEdit.this.updateClearImageVisibility();
            }
        });
    }

    @Override // com.devexpress.editors.EditBase, android.view.View
    public void setTextAlignment(int textAlignment) {
        super.setTextAlignment(textAlignment);
        if (isFocused()) {
            return;
        }
        getEditText().applyTextAlignment();
    }

    public final void selectedItemUpdated() {
        refreshDisplayText();
        onValueChanged();
    }

    public final void refreshDisplayText() {
        CharSequence charSequence;
        CollectionViewOwner collectionViewOwner = getCollectionViewOwner();
        if (collectionViewOwner == null || (charSequence = collectionViewOwner.getSelectedItemText()) == null) {
        }
        CharSequence applyCharacterCasing = ProcessorTextStrategy.INSTANCE.applyCharacterCasing(charSequence, getCharacterCasing(), 0, charSequence.length());
        getTextStrategy$dxeditors_release().setText(applyCharacterCasing);
        setDisplayText(applyCharacterCasing);
        getEditText().applyTextAlignment();
    }

    @Override // com.devexpress.editors.ItemsEditBase, com.devexpress.editors.EditBase
    protected boolean onSingleTapUp() {
        if (super.onSingleTapUp()) {
            return true;
        }
        if (!isDropDownOpen()) {
            showDropDown();
            return false;
        }
        if (getContainsFocus() && ((!this.isFilterEnabled || this.hasExternContainer) && isDropDownOpen())) {
            dismissDropDown(false);
        }
        return false;
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    public void setClearIconClickedListener(OnClickHandledListener value) {
        if (value != null) {
            value.setClickListener(new View.OnClickListener() { // from class: com.devexpress.editors.ComboBoxEdit$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ComboBoxEdit.setClearIconClickedListener$lambda$0(ComboBoxEdit.this, view);
                }
            });
        }
        this.clearImage.setOnClickListener(value != null ? value : new View.OnClickListener() { // from class: com.devexpress.editors.ComboBoxEdit$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ComboBoxEdit.setClearIconClickedListener$lambda$1(ComboBoxEdit.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClearIconClickedListener$lambda$0(ComboBoxEdit this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.filterStrategy.onClearIconClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClearIconClickedListener$lambda$1(ComboBoxEdit this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.filterStrategy.onClearIconClicked();
    }

    @Override // android.view.View
    protected void onDisplayHint(int hint) {
        super.onDisplayHint(hint);
        if (hint == 4) {
            dismissDropDown(false);
        }
    }

    @Override // com.devexpress.editors.EditBase, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        boolean allowAnimation = this.popup.getAllowAnimation();
        this.popup.setAllowAnimation(false);
        dismissDropDown(true);
        super.onDetachedFromWindow();
        this.popup.setAllowAnimation(allowAnimation);
    }

    @Override // com.devexpress.editors.ItemsEditBase, com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    protected void onContainsFocusChange() {
        super.onContainsFocusChange();
        if (getContainsFocus()) {
            this.filterStrategy.onHasFocus();
        } else {
            refreshDisplayText();
        }
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    protected void setChildrenEnabled(boolean enabled) {
        super.setChildrenEnabled(enabled);
        this.dropDownImage.setEnabled(enabled && !getIsReadOnly());
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    protected LayoutElementsFactory createLayoutElementsFactory() {
        return new PickerEditLayoutElementsFactory(getInternalEditor(), this.labelTextView, this.startImage, this.endImage, this.clearImage, this.dropDownImage, this.errorImage, this.errorTextView, this.helpTextView, this.suffixView, this.prefixView);
    }

    @Override // com.devexpress.editors.EditBase
    protected void setupCommonStyleSizes() {
        super.setupCommonStyleSizes();
        this.dropDownStyle.setDropDownBorderThickness(getContext().getResources().getDimension(R.dimen.editor_dropDownBorderWidth));
    }

    @Override // com.devexpress.editors.EditBase
    protected void setupCommonStyleColors() {
        super.setupCommonStyleColors();
        Context context = getContext();
        this.dropDownStyle.setDropDownBackgroundColor(ContextCompat.getColor(context, R.color.editor_dropDownBackgroundColor));
        this.dropDownStyle.setDropDownBorderColor(ContextCompat.getColor(context, R.color.editor_dropDownBorderColor));
    }

    @Override // com.devexpress.editors.EditBase
    protected void onReadOnlyChanged() {
        updateClearImageVisibility();
        setChildrenEnabled(isEnabled());
        setInternalEditorTextSelectable(getIsReadOnly());
        setInternalEditorEditable((getIsReadOnly() || !this.isFilterEnabled || this.hasExternContainer) ? false : true);
        getInternalEditor().setCustomSelectionActionModeCallback(getIsReadOnly() ? new ContextMenuDelegate(this) : null);
    }

    @Override // com.devexpress.editors.EditBase
    protected void updateAll() {
        super.updateAll();
        updateEditorTextSettings();
        onDropDownIconColorsChanged();
    }

    @Override // com.devexpress.editors.ItemsEditBase, com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    protected void onValueChanged() {
        if (this.isFilterEnabled && !this.hasExternContainer && getEditText().isFocused() && getDisplayText() != null) {
            DXEditText editText = getEditText();
            Editable text = getEditText().getText();
            editText.setSelection(text != null ? text.length() : 0);
        }
        super.onValueChanged();
    }

    @Override // com.devexpress.editors.EditBase
    protected boolean onEditorAction(int actionId) {
        dismissDropDown(false);
        return super.onEditorAction(actionId);
    }

    protected final void onDropdownOpened() {
        this.dropDownImage.setChecked(true);
        getEditText().setOnClickListener(null);
        DropDownStateChangedListener dropDownStateChangedListener = this.dropDownStateChangeListener;
        if (dropDownStateChangedListener != null) {
            dropDownStateChangedListener.onDropDownStateChanged(this, true);
        }
    }

    protected final void onDropdownClosed() {
        this.dropDownImage.setChecked(false);
        DropDownStateChangedListener dropDownStateChangedListener = this.dropDownStateChangeListener;
        if (dropDownStateChangedListener != null) {
            dropDownStateChangedListener.onDropDownStateChanged(this, false);
        }
        onValueChanged();
        this.dropDownImage.setOnClickListener(this.dropDownIconClickListener);
        if (getAllowAnimations()) {
            return;
        }
        clearPlacementTarget();
    }

    private final void initDropDownImage() {
        this.dropDownImage.setToggleOnClick(false);
        this.dropDownImage.setImageResource(R.drawable.dxe_drop_down);
        this.dropDownImage.setBackgroundColor(0);
        this.dropDownImage.setClickable(true);
        if (isDropDownOpen()) {
            this.dropDownImage.setChecked(true);
        }
        this.dropDownImage.jumpDrawablesToCurrentState();
        this.dropDownImage.setPadding(0, 0, 0, 0);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.devexpress.editors.ComboBoxEdit$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ComboBoxEdit.initDropDownImage$lambda$2(ComboBoxEdit.this, view);
            }
        };
        this.dropDownIconClickListener = onClickListener;
        this.dropDownImage.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDropDownImage$lambda$2(ComboBoxEdit this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onDropDownIconClicked();
    }

    private final void onDropDownIconColorsChanged() {
        updateIconTintList(this.dropDownImage, getAutoCompleteStyle().getDropDownIconColor(), getAutoCompleteStyle().getDisabledDropDownIconColor());
    }

    private final float convertToFloat(BorderRounds borderRounds) {
        return (((borderRounds.topLeft + borderRounds.topRight) + borderRounds.bottomLeft) + borderRounds.bottomRight) / 4;
    }

    private final void onDropDownIconClicked() {
        if (isDropDownOpen()) {
            dismissDropDown(false);
            return;
        }
        if (!getContainsFocus()) {
            requestFocus();
            if (this.isFilterEnabled && !this.hasExternContainer) {
                showSoftKeyboard();
            }
        }
        showDropDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearPlacementTarget() {
        this.popup.setPlacementTarget(null);
    }

    /* compiled from: ComboBoxEdit.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/devexpress/editors/ComboBoxEdit$ComboBoxDropdownListener;", "Lcom/devexpress/editors/dropdown/DXDropdownContainer$DropdownListener;", "(Lcom/devexpress/editors/ComboBoxEdit;)V", "dropdownClosed", "", "dropdownOpened", "dropdownResized", "dropdownWillClose", "", "dropdownWillOpen", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ComboBoxDropdownListener implements DXDropdownContainer.DropdownListener {
        @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownListener
        public boolean dropdownWillClose() {
            return true;
        }

        @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownListener
        public boolean dropdownWillOpen() {
            return true;
        }

        public ComboBoxDropdownListener() {
        }

        @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownListener
        public void dropdownOpened() {
            CollectionViewOwner collectionViewOwner = ComboBoxEdit.this.getCollectionViewOwner();
            if (collectionViewOwner != null) {
                collectionViewOwner.ensureSelectionVisible();
            }
            ComboBoxEdit.this.onDropdownOpened();
        }

        @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownListener
        public void dropdownClosed() {
            ComboBoxEdit.this.onDropdownClosed();
        }

        @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownListener
        public void dropdownResized() {
            CollectionViewOwner collectionViewOwner = ComboBoxEdit.this.getCollectionViewOwner();
            if (collectionViewOwner != null) {
                collectionViewOwner.ensureSelectionVisible();
            }
        }
    }

    /* compiled from: ComboBoxEdit.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/devexpress/editors/ComboBoxEdit$ComboBoxPopupPresenter;", "Lcom/devexpress/editors/popupmanagers/PopupPresenter;", "(Lcom/devexpress/editors/ComboBoxEdit;)V", "isPopupShowing", "", "()Z", "showPopup", "", "updatePopup", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ComboBoxPopupPresenter implements PopupPresenter {
        public ComboBoxPopupPresenter() {
        }

        @Override // com.devexpress.editors.popupmanagers.PopupPresenter
        public boolean isPopupShowing() {
            return ComboBoxEdit.this.isDropDownOpen();
        }

        @Override // com.devexpress.editors.popupmanagers.PopupPresenter
        public void showPopup() {
            ComboBoxEdit.this.showDropDown();
        }

        @Override // com.devexpress.editors.popupmanagers.PopupPresenter
        public void updatePopup() {
            ComboBoxEdit.this.filterStrategy.notifyFilterChanged();
            if (ComboBoxEdit.this.isDropDownOpen()) {
                ComboBoxEdit.this.getPopup().resizeOpenFrame();
            }
        }
    }

    /* compiled from: ComboBoxEdit.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0014\u0010\r\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/devexpress/editors/ComboBoxEdit$PopupManagerDelegate;", "Lcom/devexpress/editors/WeakHolder;", "Lcom/devexpress/editors/ComboBoxEdit;", "Lcom/devexpress/editors/popupmanagers/CollectionViewPopupManagerDelegate;", "edit", "(Lcom/devexpress/editors/ComboBoxEdit;Lcom/devexpress/editors/ComboBoxEdit;)V", "filterString", "", "getFilterString", "()Ljava/lang/CharSequence;", "isDataSourceEmpty", "", "()Z", "isFilterEnabled", "isVisible", "popupDismissingTime", "", TypedValues.AttributesType.S_TARGET, "Landroid/view/View;", "getTarget", "()Landroid/view/View;", "onDismissPopup", "", "manager", "Lcom/devexpress/editors/popupmanagers/PopupManagerBase;", "onDropdownRecalculated", "onFilterChanged", "onQueryListView", "onShowPopup", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class PopupManagerDelegate extends WeakHolder<ComboBoxEdit> implements CollectionViewPopupManagerDelegate {
        private long popupDismissingTime;

        @Override // com.devexpress.editors.popupmanagers.CollectionViewPopupManagerDelegate
        public boolean isDataSourceEmpty() {
            return false;
        }

        public PopupManagerDelegate(ComboBoxEdit comboBoxEdit) {
            super(comboBoxEdit);
            this.popupDismissingTime = Long.MIN_VALUE;
        }

        @Override // com.devexpress.editors.popupmanagers.PopupManagerBaseDelegate
        public View getTarget() {
            ComboBoxEdit edit = getEdit();
            if (edit != null) {
                return edit;
            }
            throw new IllegalStateException("Edit must exists.");
        }

        @Override // com.devexpress.editors.popupmanagers.PopupManagerBaseDelegate
        public boolean isVisible() {
            ComboBoxEdit edit = getEdit();
            return (edit == null || edit.getWindowVisibility() == 8) ? false : true;
        }

        @Override // com.devexpress.editors.popupmanagers.CollectionViewPopupManagerDelegate
        public boolean isFilterEnabled() {
            ComboBoxEdit edit = getEdit();
            if (!(edit != null ? edit.getIsFilterEnabled() : false)) {
                return false;
            }
            ComboBoxEdit edit2 = getEdit();
            return !(edit2 != null ? edit2.getHasExternContainer() : false);
        }

        @Override // com.devexpress.editors.popupmanagers.CollectionViewPopupManagerDelegate
        public CharSequence getFilterString() {
            EditTextStrategy editTextStrategy;
            ComboBoxEdit edit = getEdit();
            if (edit == null || (editTextStrategy = edit.filterStrategy) == null) {
                return null;
            }
            return editTextStrategy.getFilterString();
        }

        @Override // com.devexpress.editors.popupmanagers.PopupManagerBaseDelegate
        public void onShowPopup(PopupManagerBase manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            ComboBoxEdit edit = getEdit();
            if (edit != null) {
                edit.onDropdownOpened();
            }
        }

        @Override // com.devexpress.editors.popupmanagers.PopupManagerBaseDelegate
        public void onDismissPopup(PopupManagerBase manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            ComboBoxEdit edit = getEdit();
            if (edit != null) {
                edit.onDropdownClosed();
            }
            this.popupDismissingTime = System.currentTimeMillis();
        }

        @Override // com.devexpress.editors.popupmanagers.CollectionViewPopupManagerDelegate
        public void onFilterChanged() {
            EditTextStrategy editTextStrategy;
            ComboBoxEdit edit = getEdit();
            if (edit == null || (editTextStrategy = edit.filterStrategy) == null) {
                return;
            }
            editTextStrategy.notifyFilterChanged();
        }

        @Override // com.devexpress.editors.popupmanagers.CollectionViewPopupManagerDelegate
        public View onQueryListView() {
            CollectionViewOwner collectionViewOwner;
            ComboBoxEdit edit = getEdit();
            if (edit == null || (collectionViewOwner = edit.getCollectionViewOwner()) == null) {
                return null;
            }
            return collectionViewOwner.getCollectionView();
        }

        @Override // com.devexpress.editors.popupmanagers.CollectionViewPopupManagerDelegate
        public void onDropdownRecalculated() {
            CollectionViewOwner collectionViewOwner;
            ComboBoxEdit edit = getEdit();
            if (edit == null || (collectionViewOwner = edit.getCollectionViewOwner()) == null) {
                return;
            }
            collectionViewOwner.ensureSelectionVisible();
        }
    }

    /* compiled from: ComboBoxEdit.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J(\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J(\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/devexpress/editors/ComboBoxEdit$TextChangedListener;", "Landroid/text/TextWatcher;", "strategy", "Lcom/devexpress/editors/utils/textstrategies/TextStrategy;", "(Lcom/devexpress/editors/utils/textstrategies/TextStrategy;)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TextChangedListener implements TextWatcher {
        private final TextStrategy strategy;

        public TextChangedListener(TextStrategy strategy) {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            this.strategy = strategy;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Intrinsics.checkNotNullParameter(s, "s");
            this.strategy.afterTextChanged(s);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(s, "s");
            this.strategy.beforeTextChanged(s, start, count, after);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Intrinsics.checkNotNullParameter(s, "s");
            this.strategy.onTextChanged(s, start, before, count);
        }
    }

    /* compiled from: ComboBoxEdit.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/devexpress/editors/ComboBoxEdit$FilterEnabledTextStrategy;", "Lcom/devexpress/editors/WeakHolder;", "Lcom/devexpress/editors/ComboBoxEdit;", "Lcom/devexpress/editors/ComboBoxEdit$EditTextStrategy;", "edit", "(Lcom/devexpress/editors/ComboBoxEdit;)V", "filterString", "", "getFilterString", "()Ljava/lang/CharSequence;", "clearFilter", "", "notifyFilterChanged", "onClearIconClicked", "onHasFocus", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FilterEnabledTextStrategy extends WeakHolder<ComboBoxEdit> implements EditTextStrategy {
        public FilterEnabledTextStrategy(ComboBoxEdit comboBoxEdit) {
            super(comboBoxEdit);
        }

        @Override // com.devexpress.editors.ComboBoxEdit.EditTextStrategy
        public CharSequence getFilterString() {
            DXEditText editText;
            ComboBoxEdit edit = getEdit();
            CharSequence text = (edit == null || (editText = edit.getEditText()) == null) ? null : editText.getText();
            if (text == null) {
                text = "";
            }
            return text;
        }

        @Override // com.devexpress.editors.ComboBoxEdit.EditTextStrategy
        public void onHasFocus() {
            ComboBoxEdit edit;
            DXEditText editText;
            ComboBoxEdit edit2 = getEdit();
            if ((edit2 != null && edit2.getIsReadOnly()) || (edit = getEdit()) == null || (editText = edit.getEditText()) == null) {
                return;
            }
            editText.setText("");
        }

        @Override // com.devexpress.editors.ComboBoxEdit.EditTextStrategy
        public void clearFilter() {
            ComboBoxEdit edit = getEdit();
            if (edit == null || !edit.getIsReadOnly()) {
                ComboBoxEdit edit2 = getEdit();
                TextStrategy textStrategy$dxeditors_release = edit2 != null ? edit2.getTextStrategy$dxeditors_release() : null;
                if (textStrategy$dxeditors_release != null) {
                    textStrategy$dxeditors_release.setText("");
                }
                notifyFilterChanged();
            }
        }

        @Override // com.devexpress.editors.ComboBoxEdit.EditTextStrategy
        public void onClearIconClicked() {
            ComboBoxEdit edit = getEdit();
            if (edit != null) {
                CollectionViewOwner collectionViewOwner = edit.getCollectionViewOwner();
                if (collectionViewOwner != null) {
                    collectionViewOwner.clearValue();
                }
                clearFilter();
                edit.onValueChanged();
                notifyFilterChanged();
            }
        }

        @Override // com.devexpress.editors.ComboBoxEdit.EditTextStrategy
        public void notifyFilterChanged() {
            OnFilterTextChangedListener filterTextChangedListener;
            ComboBoxEdit edit = getEdit();
            if (edit == null || (filterTextChangedListener = edit.getFilterTextChangedListener()) == null) {
                return;
            }
            filterTextChangedListener.onFilterTextChanged(edit, edit.getEditText().getText());
        }
    }

    /* compiled from: ComboBoxEdit.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/devexpress/editors/ComboBoxEdit$FilterDisabledTextStrategy;", "Lcom/devexpress/editors/WeakHolder;", "Lcom/devexpress/editors/ComboBoxEdit;", "Lcom/devexpress/editors/ComboBoxEdit$EditTextStrategy;", "edit", "(Lcom/devexpress/editors/ComboBoxEdit;)V", "filterString", "", "getFilterString", "()Ljava/lang/CharSequence;", "clearFilter", "", "notifyFilterChanged", "onClearIconClicked", "onHasFocus", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FilterDisabledTextStrategy extends WeakHolder<ComboBoxEdit> implements EditTextStrategy {
        private final CharSequence filterString;

        @Override // com.devexpress.editors.ComboBoxEdit.EditTextStrategy
        public void clearFilter() {
        }

        @Override // com.devexpress.editors.ComboBoxEdit.EditTextStrategy
        public void notifyFilterChanged() {
        }

        public FilterDisabledTextStrategy(ComboBoxEdit comboBoxEdit) {
            super(comboBoxEdit);
            this.filterString = "";
        }

        @Override // com.devexpress.editors.ComboBoxEdit.EditTextStrategy
        public CharSequence getFilterString() {
            return this.filterString;
        }

        @Override // com.devexpress.editors.ComboBoxEdit.EditTextStrategy
        public void onHasFocus() {
            ComboBoxEdit edit = getEdit();
            if (edit != null) {
                edit.hideSoftKeyboard();
            }
        }

        @Override // com.devexpress.editors.ComboBoxEdit.EditTextStrategy
        public void onClearIconClicked() {
            ComboBoxEdit edit = getEdit();
            if (edit != null) {
                CollectionViewOwner collectionViewOwner = edit.getCollectionViewOwner();
                if (collectionViewOwner != null) {
                    collectionViewOwner.clearValue();
                }
                edit.onValueChanged();
            }
        }
    }
}
