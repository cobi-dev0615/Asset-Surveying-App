package com.devexpress.editors;

import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.FragmentManager;
import com.devexpress.editors.layout.factories.PickerEditLayoutElementsFactory;
import com.devexpress.editors.style.TimeEditStyle;
import com.devexpress.editors.utils.DXTextView;
import com.devexpress.editors.utils.TimePickerDialogFragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeEdit.kt */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0004|}~\u007fB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010b\u001a\u00020cJ\b\u0010d\u001a\u00020eH\u0014J\u001a\u0010f\u001a\u00020c2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010g\u001a\u00020cH\u0002J\u0006\u0010h\u001a\u00020cJ\b\u0010i\u001a\u000204H\u0002J\b\u0010j\u001a\u000204H\u0014J\b\u0010k\u001a\u00020cH\u0002J\b\u0010l\u001a\u00020cH\u0002J\b\u0010m\u001a\u00020cH\u0002J\u0010\u0010n\u001a\u00020c2\u0006\u0010o\u001a\u000204H\u0014J\u0012\u0010p\u001a\u00020c2\b\u0010\u001c\u001a\u0004\u0018\u00010qH\u0016J\u0016\u0010I\u001a\u00020c2\u0006\u0010r\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u0007J\u0010\u0010t\u001a\u00020c2\b\u0010\u001c\u001a\u0004\u0018\u00010qJ\b\u0010u\u001a\u00020cH\u0002J\u0006\u0010v\u001a\u00020cJ\b\u0010w\u001a\u00020cH\u0014J\b\u0010x\u001a\u00020cH\u0014J\u0010\u0010y\u001a\u00020c2\u0006\u0010z\u001a\u00020{H\u0014R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\"\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R(\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u001c\u001a\u0004\u0018\u00010%@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u00103\u001a\u0002048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u0002088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R$\u0010<\u001a\u0002042\u0006\u0010;\u001a\u000204@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00106\"\u0004\b=\u0010>R\u000e\u0010?\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\u00020A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u000e\u0010D\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010H\u001a\u00020G2\u0006\u0010\u001c\u001a\u00020G@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010R\u001a\u00020Q2\u0006\u0010\u001c\u001a\u00020Q@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR(\u0010X\u001a\u0004\u0018\u00010W2\b\u0010\u001c\u001a\u0004\u0018\u00010W8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R$\u0010]\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010\u0019\"\u0004\b_\u0010\u001bR\u0010\u0010`\u001a\u00020a8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0080\u0001"}, d2 = {"Lcom/devexpress/editors/TimeEdit;", "Lcom/devexpress/editors/EditBase;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "characterCasing", "Lcom/devexpress/editors/DXCharacterCasing;", "getCharacterCasing", "()Lcom/devexpress/editors/DXCharacterCasing;", "setCharacterCasing", "(Lcom/devexpress/editors/DXCharacterCasing;)V", "dialogFragment", "Lcom/devexpress/editors/utils/TimePickerDialogFragment;", "dialogStateChangeListener", "Lcom/devexpress/editors/DialogStateChangedListener;", "getDialogStateChangeListener", "()Lcom/devexpress/editors/DialogStateChangedListener;", "setDialogStateChangeListener", "(Lcom/devexpress/editors/DialogStateChangedListener;)V", "dialogThemeResId", "getDialogThemeResId", "()I", "setDialogThemeResId", "(I)V", "value", "disabledTimeIconColor", "getDisabledTimeIconColor", "setDisabledTimeIconColor", "<set-?>", "", "displayText", "getDisplayText", "()Ljava/lang/CharSequence;", "Lcom/devexpress/editors/TimeFormatter;", "formatter", "getFormatter", "()Lcom/devexpress/editors/TimeFormatter;", "setFormatter", "(Lcom/devexpress/editors/TimeFormatter;)V", "fragmentDelegate", "Lcom/devexpress/editors/TimeEdit$FragmentDelegate;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "hasValue", "", "getHasValue", "()Z", "internalEditor", "Landroid/widget/TextView;", "getInternalEditor", "()Landroid/widget/TextView;", "visible", "isTimeIconVisible", "setTimeIconVisible", "(Z)V", "raiseTimeChanged", "style", "Lcom/devexpress/editors/style/TimeEditStyle;", "getStyle", "()Lcom/devexpress/editors/style/TimeEditStyle;", "textEditStyle", "textView", "Lcom/devexpress/editors/utils/DXTextView;", "Lcom/devexpress/editors/TimeValue;", "time", "setTime", "(Lcom/devexpress/editors/TimeValue;)V", "timeChangedListener", "Lcom/devexpress/editors/TimeEdit$TimeChangedListener;", "getTimeChangedListener", "()Lcom/devexpress/editors/TimeEdit$TimeChangedListener;", "setTimeChangedListener", "(Lcom/devexpress/editors/TimeEdit$TimeChangedListener;)V", "Lcom/devexpress/editors/DXTimeFormatMode;", "timeFormatMode", "getTimeFormatMode", "()Lcom/devexpress/editors/DXTimeFormatMode;", "setTimeFormatMode", "(Lcom/devexpress/editors/DXTimeFormatMode;)V", "Landroid/graphics/drawable/Drawable;", "timeIcon", "getTimeIcon", "()Landroid/graphics/drawable/Drawable;", "setTimeIcon", "(Landroid/graphics/drawable/Drawable;)V", "timeIconColor", "getTimeIconColor", "setTimeIconColor", "timeImage", "Landroidx/appcompat/widget/AppCompatImageButton;", "clearTime", "", "createLayoutElementsFactory", "Lcom/devexpress/editors/LayoutElementsFactory;", "finishInitialization", "focusAndShowDialog", "hideTimeDialog", "is24HourView", "onSingleTapUp", "onTimeChanged", "onTimeIconColorsChanged", "refreshDisplayTime", "setChildrenEnabled", "enabled", "setClearIconClickedListener", "Lcom/devexpress/editors/OnClickHandledListener;", "hour", "minute", "setTimeIconClickedListener", "setupTimeIcon", "showTimeDialog", "updateAll", "updateClearImageVisibility", "updateDrawablesTintMode", "state", "", "FragmentDelegate", "TimeChangedListener", "TimeEditAutofillDelegate", "TimeEditGestureDelegate", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class TimeEdit extends EditBase {
    private DXCharacterCasing characterCasing;
    private TimePickerDialogFragment dialogFragment;
    private DialogStateChangedListener dialogStateChangeListener;
    private int dialogThemeResId;
    private CharSequence displayText;
    private TimeFormatter formatter;
    private final FragmentDelegate fragmentDelegate;
    private FragmentManager fragmentManager;
    private boolean isTimeIconVisible;
    private boolean raiseTimeChanged;
    private final TimeEditStyle textEditStyle;
    private final DXTextView textView;
    private TimeValue time;
    private TimeChangedListener timeChangedListener;
    private DXTimeFormatMode timeFormatMode;
    public final AppCompatImageButton timeImage;

    /* compiled from: TimeEdit.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/devexpress/editors/TimeEdit$TimeChangedListener;", "", "onTimeChanged", "", "edit", "Lcom/devexpress/editors/TimeEdit;", "hour", "", "minute", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface TimeChangedListener {
        void onTimeChanged(TimeEdit edit, int hour, int minute);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TimeEdit(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TimeEdit(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        DXTextView dXTextView = new DXTextView(context, null, 0, 6, null);
        this.textView = dXTextView;
        this.timeImage = new AppCompatImageButton(context);
        this.textEditStyle = new TimeEditStyle();
        this.raiseTimeChanged = true;
        this.fragmentDelegate = new FragmentDelegate(this);
        this.time = TimeValue.INSTANCE.getDefault();
        dXTextView.setDuplicateParentStateEnabled(true);
        dXTextView.setFocusable(true);
        dXTextView.setFocusableInTouchMode(true);
        finishInitialization(attributeSet, i);
        this.timeFormatMode = DXTimeFormatMode.Auto;
        this.isTimeIconVisible = true;
        this.characterCasing = DXCharacterCasing.Normal;
    }

    public /* synthetic */ TimeEdit(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public final void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public final TimeFormatter getFormatter() {
        return this.formatter;
    }

    public final void setFormatter(TimeFormatter timeFormatter) {
        if (Intrinsics.areEqual(this.formatter, timeFormatter)) {
            return;
        }
        this.formatter = timeFormatter;
        refreshDisplayTime();
    }

    public final TimeChangedListener getTimeChangedListener() {
        return this.timeChangedListener;
    }

    public final void setTimeChangedListener(TimeChangedListener timeChangedListener) {
        this.timeChangedListener = timeChangedListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTime(TimeValue timeValue) {
        if (Intrinsics.areEqual(this.time, timeValue)) {
            return;
        }
        this.time = timeValue;
        onTimeChanged();
    }

    public final void clearTime() {
        setTime(TimeValue.INSTANCE.getDefault());
    }

    public final void setTime(int hour, int minute) {
        setTime(new TimeValue(hour, minute));
    }

    public final int getDialogThemeResId() {
        return this.dialogThemeResId;
    }

    public final void setDialogThemeResId(int i) {
        this.dialogThemeResId = i;
    }

    public final DXTimeFormatMode getTimeFormatMode() {
        return this.timeFormatMode;
    }

    public final void setTimeFormatMode(DXTimeFormatMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.timeFormatMode = value;
        refreshDisplayTime();
    }

    /* renamed from: isTimeIconVisible, reason: from getter */
    public final boolean getIsTimeIconVisible() {
        return this.isTimeIconVisible;
    }

    public final void setTimeIconVisible(boolean z) {
        if (this.isTimeIconVisible == z) {
            return;
        }
        this.isTimeIconVisible = z;
        updateIconVisibility(this.timeImage, z);
    }

    public final Drawable getTimeIcon() {
        return this.timeImage.getDrawable();
    }

    public final void setTimeIcon(Drawable drawable) {
        if (drawable == null) {
            drawable = AppCompatResources.getDrawable(getContext(), R.drawable.dxe_time_picker);
        }
        if (Intrinsics.areEqual(this.timeImage.getDrawable(), drawable)) {
            return;
        }
        this.timeImage.setImageDrawable(drawable);
    }

    public final int getTimeIconColor() {
        return getTextEditStyle().getTimeIconColor();
    }

    public final void setTimeIconColor(int i) {
        if (getTextEditStyle().getTimeIconColor() == i) {
            return;
        }
        getTextEditStyle().setTimeIconColor(i);
        onTimeIconColorsChanged();
    }

    public final int getDisabledTimeIconColor() {
        return getTextEditStyle().getDisabledTimeIconColor();
    }

    public final void setDisabledTimeIconColor(int i) {
        if (getTextEditStyle().getDisabledTimeIconColor() == i) {
            return;
        }
        getTextEditStyle().setDisabledTimeIconColor(i);
        onTimeIconColorsChanged();
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
    public TimeEditStyle getTextEditStyle() {
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
        return !this.time.isDefault();
    }

    @Override // com.devexpress.editors.EditBase
    protected LayoutElementsFactory createLayoutElementsFactory() {
        return new PickerEditLayoutElementsFactory(getInternalEditor(), this.labelTextView, this.startImage, this.endImage, this.clearImage, this.timeImage, this.errorImage, this.errorTextView, this.helpTextView, this.suffixView, this.prefixView);
    }

    @Override // com.devexpress.editors.EditBase
    protected void setChildrenEnabled(boolean enabled) {
        super.setChildrenEnabled(enabled);
        this.timeImage.setEnabled(enabled && !getIsReadOnly());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTimeIconClickedListener$lambda$0(TimeEdit this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.focusAndShowDialog();
    }

    public final void setTimeIconClickedListener(OnClickHandledListener value) {
        if (value != null) {
            value.setClickListener(new View.OnClickListener() { // from class: com.devexpress.editors.TimeEdit$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TimeEdit.setTimeIconClickedListener$lambda$0(TimeEdit.this, view);
                }
            });
        }
        this.timeImage.setOnClickListener(value != null ? value : new View.OnClickListener() { // from class: com.devexpress.editors.TimeEdit$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimeEdit.setTimeIconClickedListener$lambda$1(TimeEdit.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTimeIconClickedListener$lambda$1(TimeEdit this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.focusAndShowDialog();
    }

    private final void focusAndShowDialog() {
        showTimeDialog();
        if (getContainsFocus()) {
            return;
        }
        this.textView.requestFocus();
    }

    @Override // com.devexpress.editors.EditBase
    protected void finishInitialization(AttributeSet attrs, int defStyleAttr) {
        this.raiseTimeChanged = false;
        super.finishInitialization(attrs, defStyleAttr);
        this.raiseTimeChanged = true;
        addView(this.timeImage);
        setupTimeIcon();
        this.textView.setGestureDelegate(new TimeEditGestureDelegate(this));
        if (Build.VERSION.SDK_INT >= 26) {
            this.textView.setAutofillDelegate(new TimeEditAutofillDelegate(this));
        }
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
            value.setClickListener(new View.OnClickListener() { // from class: com.devexpress.editors.TimeEdit$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TimeEdit.setClearIconClickedListener$lambda$2(TimeEdit.this, view);
                }
            });
        }
        this.clearImage.setOnClickListener(value != null ? value : new View.OnClickListener() { // from class: com.devexpress.editors.TimeEdit$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimeEdit.setClearIconClickedListener$lambda$3(TimeEdit.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClearIconClickedListener$lambda$2(TimeEdit this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.clearTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClearIconClickedListener$lambda$3(TimeEdit this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.clearTime();
    }

    @Override // com.devexpress.editors.EditBase
    protected void updateDrawablesTintMode(int[] state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.updateDrawablesTintMode(state);
        updateDrawableTintMode(this.timeImage, state);
    }

    private final void setupTimeIcon() {
        this.timeImage.setBackgroundColor(0);
        this.timeImage.setPadding(0, 0, 0, 0);
        this.timeImage.setClickable(true);
        setTimeIcon(null);
        setTimeIconClickedListener(null);
        updateIconVisibility(this.timeImage, true);
    }

    public final void showTimeDialog() {
        FragmentManager fragmentManager;
        hideSoftKeyboard();
        if (this.dialogFragment == null && !getIsReadOnly() && isEnabled() && getVisibility() == 0 && (fragmentManager = this.fragmentManager) != null) {
            TimePickerDialogFragment create = TimePickerDialogFragment.INSTANCE.create(this.fragmentDelegate);
            create.show(fragmentManager, "timeDialog");
            this.dialogFragment = create;
            DialogStateChangedListener dialogStateChangedListener = this.dialogStateChangeListener;
            if (dialogStateChangedListener != null) {
                dialogStateChangedListener.onDialogStateChanged(this, true);
            }
        }
    }

    public final void hideTimeDialog() {
        TimePickerDialogFragment timePickerDialogFragment = this.dialogFragment;
        if (timePickerDialogFragment == null) {
            return;
        }
        timePickerDialogFragment.dismiss();
        this.dialogFragment = null;
    }

    @Override // com.devexpress.editors.EditBase
    protected boolean onSingleTapUp() {
        if (super.onSingleTapUp()) {
            return true;
        }
        showTimeDialog();
        return false;
    }

    @Override // com.devexpress.editors.EditBase
    protected void updateAll() {
        super.updateAll();
        refreshDisplayTime();
        onTimeIconColorsChanged();
    }

    private final void onTimeChanged() {
        TimeChangedListener timeChangedListener;
        refreshDisplayTime();
        if (this.raiseTimeChanged && (timeChangedListener = this.timeChangedListener) != null) {
            timeChangedListener.onTimeChanged(this, this.time.getHour(), this.time.getMinute());
        }
        updateClearImageVisibility();
        onValueChanged();
    }

    private final void onTimeIconColorsChanged() {
        updateIconTintList(this.timeImage, getTextEditStyle().getTimeIconColor(), getTextEditStyle().getDisabledTimeIconColor());
    }

    private final void refreshDisplayTime() {
        String str;
        CharSequence format;
        if (this.time.isDefault()) {
            format = null;
        } else {
            TimeFormatter timeFormatter = this.formatter;
            if (timeFormatter != null) {
                format = timeFormatter.format(this.time.getHour(), this.time.getMinute(), is24HourView());
            } else {
                if (is24HourView()) {
                }
                format = DateFormat.format(str, this.time.getMillisecondsForCurrentLocale());
            }
        }
        this.displayText = format;
        this.textView.setText(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean is24HourView() {
        if (this.timeFormatMode == DXTimeFormatMode.Auto) {
            return DateFormat.is24HourFormat(getContext());
        }
        return this.timeFormatMode == DXTimeFormatMode.H24;
    }

    /* compiled from: TimeEdit.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\"\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000eH\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\n\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/devexpress/editors/TimeEdit$FragmentDelegate;", "Lcom/devexpress/editors/WeakHolder;", "Lcom/devexpress/editors/TimeEdit;", "Lcom/devexpress/editors/utils/TimePickerDialogFragment$TimePickerDelegate;", "Landroid/app/TimePickerDialog$OnTimeSetListener;", "edit", "(Lcom/devexpress/editors/TimeEdit;)V", "is24HourView", "", "()Z", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getListener", "()Landroid/app/TimePickerDialog$OnTimeSetListener;", "themeResId", "", "getThemeResId", "()I", "configure", "", "dialog", "Landroid/app/TimePickerDialog;", "onDismiss", "onTimeSet", "view", "Landroid/widget/TimePicker;", "hourOfDay", "minute", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class FragmentDelegate extends WeakHolder<TimeEdit> implements TimePickerDialogFragment.TimePickerDelegate, TimePickerDialog.OnTimeSetListener {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentDelegate(TimeEdit edit) {
            super(edit);
            Intrinsics.checkNotNullParameter(edit, "edit");
        }

        @Override // com.devexpress.editors.utils.TimePickerDialogFragment.TimePickerDelegate
        public int getThemeResId() {
            TimeEdit edit = getEdit();
            if (edit != null) {
                return edit.getDialogThemeResId();
            }
            return 0;
        }

        @Override // com.devexpress.editors.utils.TimePickerDialogFragment.TimePickerDelegate
        public boolean is24HourView() {
            TimeEdit edit = getEdit();
            if (edit != null) {
                return edit.is24HourView();
            }
            return true;
        }

        @Override // com.devexpress.editors.utils.TimePickerDialogFragment.TimePickerDelegate
        public TimePickerDialog.OnTimeSetListener getListener() {
            return this;
        }

        @Override // com.devexpress.editors.utils.TimePickerDialogFragment.TimePickerDelegate
        public void configure(TimePickerDialog dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            TimeEdit edit = getEdit();
            if (edit == null || edit.time.isDefault()) {
                return;
            }
            dialog.updateTime(edit.time.getHour(), edit.time.getMinute());
        }

        @Override // com.devexpress.editors.utils.TimePickerDialogFragment.TimePickerDelegate
        public void onDismiss() {
            DialogStateChangedListener dialogStateChangeListener;
            TimeEdit edit = getEdit();
            if (edit == null || (dialogStateChangeListener = edit.getDialogStateChangeListener()) == null) {
                return;
            }
            dialogStateChangeListener.onDialogStateChanged(edit, false);
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            TimeEdit edit = getEdit();
            if (edit != null) {
                edit.setTime(hourOfDay, minute);
            }
        }
    }

    /* compiled from: TimeEdit.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/devexpress/editors/TimeEdit$TimeEditAutofillDelegate;", "Lcom/devexpress/editors/AutofillDelegate;", "edit", "Lcom/devexpress/editors/TimeEdit;", "(Lcom/devexpress/editors/TimeEdit;)V", "autofill", "", "value", "Landroid/view/autofill/AutofillValue;", "provideAutofillOptions", "", "", "()[Ljava/lang/CharSequence;", "provideAutofillType", "", "provideAutofillValue", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class TimeEditAutofillDelegate implements AutofillDelegate {
        private final TimeEdit edit;

        @Override // com.devexpress.editors.AutofillDelegate
        public CharSequence[] provideAutofillOptions() {
            return new CharSequence[0];
        }

        public TimeEditAutofillDelegate(TimeEdit edit) {
            Intrinsics.checkNotNullParameter(edit, "edit");
            this.edit = edit;
        }

        @Override // com.devexpress.editors.AutofillDelegate
        public int provideAutofillType() {
            return (!this.edit.isEnabled() || this.edit.getIsReadOnly()) ? 0 : 4;
        }

        @Override // com.devexpress.editors.AutofillDelegate
        public AutofillValue provideAutofillValue() {
            return AutofillValue.forDate(this.edit.time.getMillisecondsForCurrentLocale());
        }

        @Override // com.devexpress.editors.AutofillDelegate
        public void autofill(AutofillValue value) {
            if (value != null) {
                this.edit.setTime(TimeValue.INSTANCE.fromMillisecondsInCurrentLocale(value.getDateValue()));
            }
        }
    }

    /* compiled from: TimeEdit.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/devexpress/editors/TimeEdit$TimeEditGestureDelegate;", "Lcom/devexpress/editors/GestureDelegate;", "edit", "Lcom/devexpress/editors/TimeEdit;", "(Lcom/devexpress/editors/TimeEdit;)V", "onDoubleTap", "", "onLongPress", "onSingleTapUp", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class TimeEditGestureDelegate implements GestureDelegate {
        private final TimeEdit edit;

        public TimeEditGestureDelegate(TimeEdit edit) {
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
}
