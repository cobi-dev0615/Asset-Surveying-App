package com.devexpress.editors;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.FragmentManager;
import com.devexpress.editors.layout.factories.PickerEditLayoutElementsFactory;
import com.devexpress.editors.style.DateEditStyle;
import com.devexpress.editors.utils.DXTextView;
import com.devexpress.editors.utils.DatePickerDialogFragment;
import com.devexpress.editors.utils.textstrategies.ProcessorTextStrategy;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DateEdit.kt */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0016\u0018\u0000 \u0087\u00012\u00020\u0001:\f\u0087\u0001\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010g\u001a\u00020hJ\b\u0010i\u001a\u00020hH\u0002J\u0010\u0010j\u001a\u00020h2\u0006\u0010k\u001a\u00020\u0014H\u0002J\u0010\u0010l\u001a\u00020h2\u0006\u0010m\u001a\u00020\u0014H\u0002J\b\u0010n\u001a\u00020oH\u0014J\u001a\u0010p\u001a\u00020h2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010q\u001a\u00020hH\u0002J\u0006\u0010r\u001a\u00020hJ\b\u0010s\u001a\u00020hH\u0014J\b\u0010t\u001a\u00020hH\u0002J\b\u0010u\u001a\u00020hH\u0002J\b\u0010v\u001a\u00020NH\u0014J\u0006\u0010w\u001a\u00020NJ\u0010\u0010x\u001a\u00020h2\u0006\u0010y\u001a\u00020NH\u0014J\u0012\u0010z\u001a\u00020h2\b\u0010\u0013\u001a\u0004\u0018\u00010{H\u0016J\u001e\u0010\u0016\u001a\u00020h2\u0006\u0010|\u001a\u00020\u00072\u0006\u0010}\u001a\u00020\u00072\u0006\u0010~\u001a\u00020\u0007J\u0010\u0010\u007f\u001a\u00020h2\b\u0010\u0013\u001a\u0004\u0018\u00010{J\u001e\u0010Z\u001a\u00020h2\u0006\u0010|\u001a\u00020\u00072\u0006\u0010}\u001a\u00020\u00072\u0006\u0010~\u001a\u00020\u0007J\u001e\u0010\\\u001a\u00020h2\u0006\u0010|\u001a\u00020\u00072\u0006\u0010}\u001a\u00020\u00072\u0006\u0010~\u001a\u00020\u0007J\t\u0010\u0080\u0001\u001a\u00020hH\u0002J\u0007\u0010\u0081\u0001\u001a\u00020hJ\t\u0010\u0082\u0001\u001a\u00020hH\u0014J\t\u0010\u0083\u0001\u001a\u00020hH\u0014J\u0013\u0010\u0084\u0001\u001a\u00020h2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0014R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u00020*8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R(\u0010,\u001a\u0004\u0018\u00010\n2\b\u0010+\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010&\"\u0004\b8\u0010(R$\u00109\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b:\u0010&\"\u0004\b;\u0010(R\"\u0010>\u001a\u0004\u0018\u00010=2\b\u0010<\u001a\u0004\u0018\u00010=@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR(\u0010H\u001a\u0004\u0018\u00010G2\b\u0010+\u001a\u0004\u0018\u00010G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020N8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020R8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR$\u0010V\u001a\u00020N2\u0006\u0010U\u001a\u00020N@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010P\"\u0004\bW\u0010XR\u001e\u0010Y\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bZ\u0010\u0017R\u001e\u0010[\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\\\u0010\u0017R\u000e\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010`\u001a\u00020a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\u000e\u0010d\u001a\u00020aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008d\u0001"}, d2 = {"Lcom/devexpress/editors/DateEdit;", "Lcom/devexpress/editors/EditBase;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actualDatePickerListener", "Lcom/devexpress/editors/DateEditPickerListener;", "getActualDatePickerListener", "()Lcom/devexpress/editors/DateEditPickerListener;", "characterCasing", "Lcom/devexpress/editors/DXCharacterCasing;", "getCharacterCasing", "()Lcom/devexpress/editors/DXCharacterCasing;", "setCharacterCasing", "(Lcom/devexpress/editors/DXCharacterCasing;)V", "value", "Lcom/devexpress/editors/DateValue;", "currentDate", "setCurrentDate", "(Lcom/devexpress/editors/DateValue;)V", "dateChangedListener", "Lcom/devexpress/editors/DateEdit$DateChangedListener;", "getDateChangedListener", "()Lcom/devexpress/editors/DateEdit$DateChangedListener;", "setDateChangedListener", "(Lcom/devexpress/editors/DateEdit$DateChangedListener;)V", "Landroid/graphics/drawable/Drawable;", "dateIcon", "getDateIcon", "()Landroid/graphics/drawable/Drawable;", "setDateIcon", "(Landroid/graphics/drawable/Drawable;)V", "dateIconColor", "getDateIconColor", "()I", "setDateIconColor", "(I)V", "dateImage", "Landroidx/appcompat/widget/AppCompatImageButton;", "newValue", "datePickerListener", "getDatePickerListener", "setDatePickerListener", "(Lcom/devexpress/editors/DateEditPickerListener;)V", "dialogStateChangeListener", "Lcom/devexpress/editors/DialogStateChangedListener;", "getDialogStateChangeListener", "()Lcom/devexpress/editors/DialogStateChangedListener;", "setDialogStateChangeListener", "(Lcom/devexpress/editors/DialogStateChangedListener;)V", "dialogThemeResId", "getDialogThemeResId", "setDialogThemeResId", "disabledDateIconColor", "getDisabledDateIconColor", "setDisabledDateIconColor", "<set-?>", "", "displayText", "getDisplayText", "()Ljava/lang/CharSequence;", "formatter", "Lcom/devexpress/editors/DateFormatter;", "getFormatter", "()Lcom/devexpress/editors/DateFormatter;", "setFormatter", "(Lcom/devexpress/editors/DateFormatter;)V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "hasValue", "", "getHasValue", "()Z", "internalEditor", "Landroid/widget/TextView;", "getInternalEditor", "()Landroid/widget/TextView;", "visible", "isDateIconVisible", "setDateIconVisible", "(Z)V", "maxDate", "setMaxDate", "minDate", "setMinDate", "nativeDatePickerListener", "Lcom/devexpress/editors/DateEdit$NativeDateEditPickerListener;", "pendingIsDropdownOpen", "style", "Lcom/devexpress/editors/style/DateEditStyle;", "getStyle", "()Lcom/devexpress/editors/style/DateEditStyle;", "textEditStyle", "textView", "Lcom/devexpress/editors/utils/DXTextView;", "clearCurrentDate", "", "correctCurrentDate", "correctMaxDate", "newMinDate", "correctMinDate", "newMaxDate", "createLayoutElementsFactory", "Lcom/devexpress/editors/LayoutElementsFactory;", "finishInitialization", "focusAndShowDialog", "hideDateDialog", "onAttachedToWindow", "onDateChanged", "onDateIconColorsChanged", "onSingleTapUp", "refreshDisplayDate", "setChildrenEnabled", "enabled", "setClearIconClickedListener", "Lcom/devexpress/editors/OnClickHandledListener;", "year", "month", "dayOfMonth", "setDateIconClickedListener", "setupDateIcon", "showDateDialog", "updateAll", "updateClearImageVisibility", "updateDrawablesTintMode", "state", "", "Companion", "DateChangedListener", "DateEditAutofillDelegate", "DateEditGestureDelegate", "FragmentDelegate", "NativeDateEditPickerListener", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class DateEdit extends EditBase {
    private DXCharacterCasing characterCasing;
    private DateValue currentDate;
    private DateChangedListener dateChangedListener;
    public final AppCompatImageButton dateImage;
    private DateEditPickerListener datePickerListener;
    private DialogStateChangedListener dialogStateChangeListener;
    private int dialogThemeResId;
    private CharSequence displayText;
    private DateFormatter formatter;
    private FragmentManager fragmentManager;
    private boolean isDateIconVisible;
    private DateValue maxDate;
    private DateValue minDate;
    private final NativeDateEditPickerListener nativeDatePickerListener;
    private boolean pendingIsDropdownOpen;
    private final DateEditStyle textEditStyle;
    private final DXTextView textView;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DateValue DEFAULT_START_DATE = new DateValue(1900, 0, 1);
    private static final DateValue DEFAULT_END_DATE = new DateValue(2100, 11, 31);

    /* compiled from: DateEdit.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/devexpress/editors/DateEdit$DateChangedListener;", "", "onDateChanged", "", "edit", "Lcom/devexpress/editors/DateEdit;", "year", "", "month", "dayOfMonth", "onMaxDateChanged", "onMinDateChanged", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface DateChangedListener {
        void onDateChanged(DateEdit edit, int year, int month, int dayOfMonth);

        void onMaxDateChanged(DateEdit edit, int year, int month, int dayOfMonth);

        void onMinDateChanged(DateEdit edit, int year, int month, int dayOfMonth);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DateEdit(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DateEdit(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* compiled from: DateEdit.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/devexpress/editors/DateEdit$Companion;", "", "()V", "DEFAULT_END_DATE", "Lcom/devexpress/editors/DateValue;", "getDEFAULT_END_DATE$dxeditors_release", "()Lcom/devexpress/editors/DateValue;", "DEFAULT_START_DATE", "getDEFAULT_START_DATE$dxeditors_release", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DateValue getDEFAULT_START_DATE$dxeditors_release() {
            return DateEdit.DEFAULT_START_DATE;
        }

        public final DateValue getDEFAULT_END_DATE$dxeditors_release() {
            return DateEdit.DEFAULT_END_DATE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        DXTextView dXTextView = new DXTextView(context, null, 0, 6, null);
        this.textView = dXTextView;
        this.dateImage = new AppCompatImageButton(context);
        this.textEditStyle = new DateEditStyle();
        this.nativeDatePickerListener = new NativeDateEditPickerListener(this);
        this.currentDate = DateValue.INSTANCE.getDefault();
        this.minDate = DEFAULT_START_DATE;
        this.maxDate = DEFAULT_END_DATE;
        this.isDateIconVisible = true;
        this.characterCasing = DXCharacterCasing.Normal;
        dXTextView.setDuplicateParentStateEnabled(true);
        dXTextView.setFocusable(true);
        dXTextView.setFocusableInTouchMode(true);
        dXTextView.setGestureDelegate(new DateEditGestureDelegate(this));
        finishInitialization(attributeSet, i);
    }

    public /* synthetic */ DateEdit(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentDate(DateValue dateValue) {
        this.currentDate = dateValue;
        correctCurrentDate();
        onDateChanged();
    }

    private final void setMinDate(DateValue dateValue) {
        if (Intrinsics.areEqual(this.minDate, dateValue)) {
            return;
        }
        this.minDate = dateValue;
        correctMaxDate(dateValue);
        DateChangedListener dateChangedListener = this.dateChangedListener;
        if (dateChangedListener != null) {
            dateChangedListener.onMinDateChanged(this, dateValue.getYear(), dateValue.getMonth(), dateValue.getDayOfMonth());
        }
        correctCurrentDate();
    }

    private final void setMaxDate(DateValue dateValue) {
        if (Intrinsics.areEqual(this.maxDate, dateValue)) {
            return;
        }
        this.maxDate = dateValue;
        correctMinDate(dateValue);
        DateChangedListener dateChangedListener = this.dateChangedListener;
        if (dateChangedListener != null) {
            dateChangedListener.onMaxDateChanged(this, dateValue.getYear(), dateValue.getMonth(), dateValue.getDayOfMonth());
        }
        correctCurrentDate();
    }

    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public final void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        this.nativeDatePickerListener.setFragmentManager(fragmentManager);
    }

    public final DateEditPickerListener getDatePickerListener() {
        return this.datePickerListener;
    }

    public final void setDatePickerListener(DateEditPickerListener dateEditPickerListener) {
        hideDateDialog();
        this.datePickerListener = dateEditPickerListener;
    }

    private final DateEditPickerListener getActualDatePickerListener() {
        DateEditPickerListener dateEditPickerListener = this.datePickerListener;
        if (dateEditPickerListener == null) {
            return this.nativeDatePickerListener;
        }
        Intrinsics.checkNotNull(dateEditPickerListener);
        return dateEditPickerListener;
    }

    public final DateFormatter getFormatter() {
        return this.formatter;
    }

    public final void setFormatter(DateFormatter dateFormatter) {
        this.formatter = dateFormatter;
    }

    public final DateChangedListener getDateChangedListener() {
        return this.dateChangedListener;
    }

    public final void setDateChangedListener(DateChangedListener dateChangedListener) {
        this.dateChangedListener = dateChangedListener;
    }

    public final int getDialogThemeResId() {
        return this.dialogThemeResId;
    }

    public final void setDialogThemeResId(int i) {
        this.dialogThemeResId = i;
    }

    /* renamed from: isDateIconVisible, reason: from getter */
    public final boolean getIsDateIconVisible() {
        return this.isDateIconVisible;
    }

    public final void setDateIconVisible(boolean z) {
        if (this.isDateIconVisible == z) {
            return;
        }
        this.isDateIconVisible = z;
        updateIconVisibility(this.dateImage, z);
    }

    public final Drawable getDateIcon() {
        return this.dateImage.getDrawable();
    }

    public final void setDateIcon(Drawable drawable) {
        if (drawable == null) {
            drawable = AppCompatResources.getDrawable(getContext(), R.drawable.dxe_date_picker);
        }
        if (Intrinsics.areEqual(this.dateImage.getDrawable(), drawable)) {
            return;
        }
        this.dateImage.setImageDrawable(drawable);
    }

    public final int getDateIconColor() {
        return getTextEditStyle().getDateIconColor();
    }

    public final void setDateIconColor(int i) {
        if (getTextEditStyle().getDateIconColor() == i) {
            return;
        }
        getTextEditStyle().setDateIconColor(i);
        onDateIconColorsChanged();
    }

    public final int getDisabledDateIconColor() {
        return getTextEditStyle().getDisabledDateIconColor();
    }

    public final void setDisabledDateIconColor(int i) {
        if (getTextEditStyle().getDisabledDateIconColor() == i) {
            return;
        }
        getTextEditStyle().setDisabledDateIconColor(i);
        onDateIconColorsChanged();
    }

    public final DialogStateChangedListener getDialogStateChangeListener() {
        return this.dialogStateChangeListener;
    }

    public final void setDialogStateChangeListener(DialogStateChangedListener dialogStateChangedListener) {
        this.dialogStateChangeListener = dialogStateChangedListener;
    }

    @Override // com.devexpress.editors.EditBase
    public TextView getInternalEditor() {
        return this.textView;
    }

    @Override // com.devexpress.editors.EditBase
    /* renamed from: getStyle, reason: from getter */
    public DateEditStyle getTextEditStyle() {
        return this.textEditStyle;
    }

    @Override // com.devexpress.editors.EditBase
    public final CharSequence getDisplayText() {
        return this.displayText;
    }

    @Override // com.devexpress.editors.EditBase
    public DXCharacterCasing getCharacterCasing() {
        return this.characterCasing;
    }

    @Override // com.devexpress.editors.EditBase
    public void setCharacterCasing(DXCharacterCasing dXCharacterCasing) {
        Intrinsics.checkNotNullParameter(dXCharacterCasing, "<set-?>");
        this.characterCasing = dXCharacterCasing;
    }

    @Override // com.devexpress.editors.EditBase
    protected boolean getHasValue() {
        return !this.currentDate.isDefault();
    }

    @Override // com.devexpress.editors.EditBase
    protected LayoutElementsFactory createLayoutElementsFactory() {
        return new PickerEditLayoutElementsFactory(getInternalEditor(), this.labelTextView, this.startImage, this.endImage, this.clearImage, this.dateImage, this.errorImage, this.errorTextView, this.helpTextView, this.suffixView, this.prefixView);
    }

    public final void clearCurrentDate() {
        setCurrentDate(DateValue.INSTANCE.getDefault());
    }

    public final void setCurrentDate(int year, int month, int dayOfMonth) {
        setCurrentDate(new DateValue(year, month, dayOfMonth));
    }

    public final void setMinDate(int year, int month, int dayOfMonth) {
        setMinDate(new DateValue(year, month, dayOfMonth));
    }

    public final void setMaxDate(int year, int month, int dayOfMonth) {
        setMaxDate(new DateValue(year, month, dayOfMonth));
    }

    @Override // com.devexpress.editors.EditBase
    protected void setChildrenEnabled(boolean enabled) {
        super.setChildrenEnabled(enabled);
        this.dateImage.setEnabled(enabled && !getIsReadOnly());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDateIconClickedListener$lambda$0(DateEdit this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.focusAndShowDialog();
    }

    public final void setDateIconClickedListener(OnClickHandledListener value) {
        if (value != null) {
            value.setClickListener(new View.OnClickListener() { // from class: com.devexpress.editors.DateEdit$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DateEdit.setDateIconClickedListener$lambda$0(DateEdit.this, view);
                }
            });
        }
        this.dateImage.setOnClickListener(value != null ? value : new View.OnClickListener() { // from class: com.devexpress.editors.DateEdit$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DateEdit.setDateIconClickedListener$lambda$1(DateEdit.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDateIconClickedListener$lambda$1(DateEdit this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.focusAndShowDialog();
    }

    private final void focusAndShowDialog() {
        showDateDialog();
        if (getContainsFocus()) {
            return;
        }
        this.textView.requestFocus();
    }

    private final void setupDateIcon() {
        this.dateImage.setBackgroundColor(0);
        this.dateImage.setPadding(0, 0, 0, 0);
        this.dateImage.setClickable(true);
        setDateIcon(null);
        setDateIconClickedListener(null);
        updateIconVisibility(this.dateImage, true);
    }

    private final void onDateIconColorsChanged() {
        updateIconTintList(this.dateImage, getTextEditStyle().getDateIconColor(), getTextEditStyle().getDisabledDateIconColor());
    }

    @Override // com.devexpress.editors.EditBase, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.pendingIsDropdownOpen) {
            this.pendingIsDropdownOpen = false;
            showDateDialog();
        }
    }

    @Override // com.devexpress.editors.EditBase
    protected void finishInitialization(AttributeSet attrs, int defStyleAttr) {
        super.finishInitialization(attrs, defStyleAttr);
        addView(this.dateImage);
        setupDateIcon();
        if (Build.VERSION.SDK_INT >= 26) {
            this.textView.setAutofillDelegate(new DateEditAutofillDelegate(this));
        }
    }

    @Override // com.devexpress.editors.EditBase
    protected void updateDrawablesTintMode(int[] state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.updateDrawablesTintMode(state);
        updateDrawableTintMode(this.dateImage, state);
    }

    @Override // com.devexpress.editors.EditBase
    protected void updateClearImageVisibility() {
        CharSequence text;
        CharSequence text2;
        boolean z = false;
        updateIconVisibility(this.clearImage, getClearIconVisibility() == DXIconVisibility.Always || !(getClearIconVisibility() != DXIconVisibility.Auto || (text2 = this.textView.getText()) == null || text2.length() == 0));
        AppCompatImageButton appCompatImageButton = this.clearImage;
        if (isEnabled() && (text = this.textView.getText()) != null && text.length() != 0) {
            z = true;
        }
        appCompatImageButton.setEnabled(z);
    }

    @Override // com.devexpress.editors.EditBase
    public void setClearIconClickedListener(OnClickHandledListener value) {
        if (value != null) {
            value.setClickListener(new View.OnClickListener() { // from class: com.devexpress.editors.DateEdit$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DateEdit.setClearIconClickedListener$lambda$2(DateEdit.this, view);
                }
            });
        }
        this.clearImage.setOnClickListener(value != null ? value : new View.OnClickListener() { // from class: com.devexpress.editors.DateEdit$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DateEdit.setClearIconClickedListener$lambda$3(DateEdit.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClearIconClickedListener$lambda$2(DateEdit this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.clearCurrentDate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClearIconClickedListener$lambda$3(DateEdit this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.clearCurrentDate();
    }

    public final void showDateDialog() {
        hideSoftKeyboard();
        if (!getIsReadOnly() && isEnabled() && getVisibility() == 0) {
            if (!isAttachedToWindow()) {
                this.pendingIsDropdownOpen = true;
            } else {
                getActualDatePickerListener().show();
            }
        }
    }

    public final boolean refreshDisplayDate() {
        String formatDateTime;
        CharSequence charSequence = this.displayText;
        if (this.currentDate.isDefault()) {
            formatDateTime = null;
        } else {
            DateFormatter dateFormatter = this.formatter;
            if (dateFormatter == null || (formatDateTime = dateFormatter.format(this.currentDate.getYear(), this.currentDate.getMonth(), this.currentDate.getDayOfMonth())) == null) {
                formatDateTime = DateUtils.formatDateTime(getContext(), this.currentDate.getMillisecondsForCurrentLocale(), 16);
            }
        }
        this.displayText = formatDateTime;
        if (formatDateTime != null) {
            DXTextView dXTextView = this.textView;
            ProcessorTextStrategy.Companion companion = ProcessorTextStrategy.INSTANCE;
            CharSequence charSequence2 = this.displayText;
            Intrinsics.checkNotNull(charSequence2);
            DXCharacterCasing characterCasing = getCharacterCasing();
            CharSequence charSequence3 = this.displayText;
            Intrinsics.checkNotNull(charSequence3);
            dXTextView.setText(companion.applyCharacterCasing(charSequence2, characterCasing, 0, charSequence3.length()));
            this.displayText = this.textView.getText();
        } else {
            this.textView.setText((CharSequence) null);
        }
        return !Intrinsics.areEqual(this.displayText, charSequence);
    }

    public final void hideDateDialog() {
        getActualDatePickerListener().dismiss();
    }

    @Override // com.devexpress.editors.EditBase
    protected boolean onSingleTapUp() {
        if (super.onSingleTapUp()) {
            return true;
        }
        showDateDialog();
        return false;
    }

    @Override // com.devexpress.editors.EditBase
    protected void updateAll() {
        super.updateAll();
        refreshDisplayDate();
        onDateIconColorsChanged();
    }

    private final void correctMaxDate(DateValue newMinDate) {
        if (this.maxDate.compareTo(newMinDate) < 0) {
            setMinDate(newMinDate);
        }
    }

    private final void correctMinDate(DateValue newMaxDate) {
        if (this.minDate.compareTo(newMaxDate) > 0) {
            setMinDate(newMaxDate);
        }
    }

    private final void correctCurrentDate() {
        if (this.maxDate.compareTo(this.minDate) < 0) {
            throw new RuntimeException("Invalid Min/Max date!");
        }
        if (this.currentDate.isDefault()) {
            return;
        }
        if (this.currentDate.compareTo(this.minDate) < 0) {
            setCurrentDate(this.minDate);
        } else if (this.currentDate.compareTo(this.maxDate) > 0) {
            setCurrentDate(this.maxDate);
        }
    }

    private final void onDateChanged() {
        if (refreshDisplayDate()) {
            DateChangedListener dateChangedListener = this.dateChangedListener;
            if (dateChangedListener != null) {
                dateChangedListener.onDateChanged(this, this.currentDate.getYear(), this.currentDate.getMonth(), this.currentDate.getDayOfMonth());
            }
            updateClearImageVisibility();
            onValueChanged();
        }
    }

    /* compiled from: DateEdit.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u000f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/devexpress/editors/DateEdit$FragmentDelegate;", "Lcom/devexpress/editors/WeakHolder;", "Lcom/devexpress/editors/DateEdit;", "Lcom/devexpress/editors/utils/DatePickerDialogFragment$DatePickerDelegate;", "Landroid/app/DatePickerDialog$OnDateSetListener;", "edit", "(Lcom/devexpress/editors/DateEdit;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getListener", "()Landroid/app/DatePickerDialog$OnDateSetListener;", "themeResId", "", "getThemeResId", "()I", "configure", "", "dialog", "Landroid/app/DatePickerDialog;", "onDateSet", "view", "Landroid/widget/DatePicker;", "year", "month", "dayOfMonth", "onDismiss", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class FragmentDelegate extends WeakHolder<DateEdit> implements DatePickerDialogFragment.DatePickerDelegate, DatePickerDialog.OnDateSetListener {
        public FragmentDelegate(DateEdit dateEdit) {
            super(dateEdit);
        }

        @Override // com.devexpress.editors.utils.DatePickerDialogFragment.DatePickerDelegate
        public int getThemeResId() {
            DateEdit edit = getEdit();
            if (edit != null) {
                return edit.getDialogThemeResId();
            }
            return 0;
        }

        @Override // com.devexpress.editors.utils.DatePickerDialogFragment.DatePickerDelegate
        public DatePickerDialog.OnDateSetListener getListener() {
            return this;
        }

        @Override // com.devexpress.editors.utils.DatePickerDialogFragment.DatePickerDelegate
        public void configure(DatePickerDialog dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            DateEdit edit = getEdit();
            if (edit != null) {
                DatePicker datePicker = dialog.getDatePicker();
                Intrinsics.checkNotNullExpressionValue(datePicker, "getDatePicker(...)");
                if (!edit.minDate.isDefault()) {
                    datePicker.setMinDate(edit.minDate.getMillisecondsForCurrentLocale());
                }
                if (!edit.maxDate.isDefault()) {
                    datePicker.setMaxDate(edit.maxDate.getMillisecondsForCurrentLocale());
                }
                if (edit.currentDate.isDefault()) {
                    return;
                }
                datePicker.updateDate(edit.currentDate.getYear(), edit.currentDate.getMonth(), edit.currentDate.getDayOfMonth());
            }
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Intrinsics.checkNotNullParameter(view, "view");
            DateEdit edit = getEdit();
            if (edit != null) {
                edit.setCurrentDate(year, month, dayOfMonth);
            }
        }

        @Override // com.devexpress.editors.utils.DatePickerDialogFragment.DatePickerDelegate
        public void onDismiss() {
            DialogStateChangedListener dialogStateChangeListener;
            DateEdit edit = getEdit();
            if (edit == null || (dialogStateChangeListener = edit.getDialogStateChangeListener()) == null) {
                return;
            }
            dialogStateChangeListener.onDialogStateChanged(edit, false);
        }
    }

    /* compiled from: DateEdit.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/devexpress/editors/DateEdit$DateEditAutofillDelegate;", "Lcom/devexpress/editors/AutofillDelegate;", "edit", "Lcom/devexpress/editors/DateEdit;", "(Lcom/devexpress/editors/DateEdit;)V", "autofill", "", "value", "Landroid/view/autofill/AutofillValue;", "provideAutofillOptions", "", "", "()[Ljava/lang/CharSequence;", "provideAutofillType", "", "provideAutofillValue", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class DateEditAutofillDelegate implements AutofillDelegate {
        private final DateEdit edit;

        @Override // com.devexpress.editors.AutofillDelegate
        public CharSequence[] provideAutofillOptions() {
            return new CharSequence[0];
        }

        public DateEditAutofillDelegate(DateEdit edit) {
            Intrinsics.checkNotNullParameter(edit, "edit");
            this.edit = edit;
        }

        @Override // com.devexpress.editors.AutofillDelegate
        public int provideAutofillType() {
            return (!this.edit.isEnabled() || this.edit.getIsReadOnly()) ? 0 : 4;
        }

        @Override // com.devexpress.editors.AutofillDelegate
        public AutofillValue provideAutofillValue() {
            return AutofillValue.forDate(this.edit.currentDate.getMillisecondsForCurrentLocale());
        }

        @Override // com.devexpress.editors.AutofillDelegate
        public void autofill(AutofillValue value) {
            if (value != null) {
                this.edit.setCurrentDate(DateValue.INSTANCE.fromMillisecondsInCurrentLocale(value.getDateValue()));
            }
        }
    }

    /* compiled from: DateEdit.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/devexpress/editors/DateEdit$DateEditGestureDelegate;", "Lcom/devexpress/editors/GestureDelegate;", "edit", "Lcom/devexpress/editors/DateEdit;", "(Lcom/devexpress/editors/DateEdit;)V", "onDoubleTap", "", "onLongPress", "onSingleTapUp", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class DateEditGestureDelegate implements GestureDelegate {
        private final DateEdit edit;

        public DateEditGestureDelegate(DateEdit edit) {
            Intrinsics.checkNotNullParameter(edit, "edit");
            this.edit = edit;
        }

        @Override // com.devexpress.editors.GestureDelegate
        public boolean onSingleTapUp() {
            return this.edit.onSingleTapUp();
        }

        @Override // com.devexpress.editors.GestureDelegate
        public boolean onDoubleTap() {
            return this.edit.onDoubleTap();
        }

        @Override // com.devexpress.editors.GestureDelegate
        public boolean onLongPress() {
            return this.edit.onLongPress();
        }
    }

    /* compiled from: DateEdit.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/devexpress/editors/DateEdit$NativeDateEditPickerListener;", "Lcom/devexpress/editors/DateEditPickerListener;", "edit", "Lcom/devexpress/editors/DateEdit;", "(Lcom/devexpress/editors/DateEdit;)V", "dialogFragment", "Lcom/devexpress/editors/utils/DatePickerDialogFragment;", "fragmentDelegate", "Lcom/devexpress/editors/DateEdit$FragmentDelegate;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "dismiss", "", "show", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class NativeDateEditPickerListener implements DateEditPickerListener {
        private DatePickerDialogFragment dialogFragment;
        private final DateEdit edit;
        private final FragmentDelegate fragmentDelegate;
        private FragmentManager fragmentManager;

        public NativeDateEditPickerListener(DateEdit edit) {
            Intrinsics.checkNotNullParameter(edit, "edit");
            this.edit = edit;
            this.fragmentDelegate = new FragmentDelegate(edit);
        }

        public final FragmentManager getFragmentManager() {
            return this.fragmentManager;
        }

        public final void setFragmentManager(FragmentManager fragmentManager) {
            this.fragmentManager = fragmentManager;
        }

        @Override // com.devexpress.editors.DateEditPickerListener
        public void show() {
            FragmentManager fragmentManager;
            if (this.dialogFragment == null && (fragmentManager = this.fragmentManager) != null) {
                DatePickerDialogFragment create = DatePickerDialogFragment.INSTANCE.create(this.fragmentDelegate);
                create.show(fragmentManager, "dateDialog");
                this.dialogFragment = create;
                DialogStateChangedListener dialogStateChangeListener = this.edit.getDialogStateChangeListener();
                if (dialogStateChangeListener != null) {
                    dialogStateChangeListener.onDialogStateChanged(this.edit, true);
                }
            }
        }

        @Override // com.devexpress.editors.DateEditPickerListener
        public void dismiss() {
            DatePickerDialogFragment datePickerDialogFragment = this.dialogFragment;
            if (datePickerDialogFragment == null) {
                return;
            }
            datePickerDialogFragment.dismiss();
            DialogStateChangedListener dialogStateChangeListener = this.edit.getDialogStateChangeListener();
            if (dialogStateChangeListener != null) {
                dialogStateChangeListener.onDialogStateChanged(this.edit, false);
            }
            this.dialogFragment = null;
        }
    }
}
