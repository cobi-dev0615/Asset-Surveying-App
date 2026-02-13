package com.devexpress.editors;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageButton;
import com.devexpress.editors.layout.factories.NumericEditLayoutElementsFactory;
import com.devexpress.editors.style.NumericEditStyle;
import com.devexpress.editors.utils.NumericEditKeyListener;
import com.devexpress.editors.utils.textstrategies.NumericTextStrategy;
import com.devexpress.editors.utils.textstrategies.TextStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NumericEdit.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001oB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010W\u001a\u00020XH\u0014J\u0017\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010ZH\u0010¢\u0006\u0002\b\\J\b\u0010]\u001a\u00020\nH\u0002J\b\u0010^\u001a\u00020\nH\u0002J\u0010\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020(H\u0002J\b\u0010b\u001a\u00020`H\u0002J\b\u0010c\u001a\u00020`H\u0014J\b\u0010d\u001a\u00020`H\u0014J\b\u0010e\u001a\u00020`H\u0002J\u0010\u0010f\u001a\u00020`2\u0006\u0010g\u001a\u00020)H\u0014J\u000e\u0010h\u001a\u00020`2\u0006\u0010\t\u001a\u00020)J\b\u0010i\u001a\u00020`H\u0014J\b\u0010j\u001a\u00020`H\u0002J\u0010\u0010k\u001a\u00020`2\u0006\u0010l\u001a\u00020mH\u0014J\b\u0010n\u001a\u00020`H\u0002R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\t\u001a\u0004\u0018\u00010\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\t\u001a\u0004\u0018\u00010\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u0010\u0010'\u001a\u00020(8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R$\u0010*\u001a\u00020)2\u0006\u0010\t\u001a\u00020)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R$\u00104\u001a\u00020)2\u0006\u00103\u001a\u00020)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010,\"\u0004\b5\u0010.R$\u00106\u001a\u00020)2\u0006\u00103\u001a\u00020)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010,\"\u0004\b7\u0010.R$\u00108\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0012\"\u0004\b:\u0010\u0014R$\u0010;\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR\u0014\u0010>\u001a\u0002028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010H\u001a\u00020G2\u0006\u0010\t\u001a\u00020G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR(\u0010M\u001a\u0004\u0018\u00010\u001e2\b\u0010\t\u001a\u0004\u0018\u00010\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010!\"\u0004\bO\u0010#R$\u0010P\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010\u0012\"\u0004\bR\u0010\u0014R\u0010\u0010S\u001a\u00020(8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R$\u0010T\u001a\u00020)2\u0006\u0010\t\u001a\u00020)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010,\"\u0004\bV\u0010.¨\u0006p"}, d2 = {"Lcom/devexpress/editors/NumericEdit;", "Lcom/devexpress/editors/TextEditBase;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "decimalSeparator", "getDecimalSeparator", "()C", "setDecimalSeparator", "(C)V", "disabledDownIconColor", "getDisabledDownIconColor", "()I", "setDisabledDownIconColor", "(I)V", "disabledUpIconColor", "getDisabledUpIconColor", "setDisabledUpIconColor", "Lcom/devexpress/editors/DisplayTextFormatter;", "displayTextFormatter", "getDisplayTextFormatter", "()Lcom/devexpress/editors/DisplayTextFormatter;", "setDisplayTextFormatter", "(Lcom/devexpress/editors/DisplayTextFormatter;)V", "Landroid/graphics/drawable/Drawable;", "downIcon", "getDownIcon", "()Landroid/graphics/drawable/Drawable;", "setDownIcon", "(Landroid/graphics/drawable/Drawable;)V", "downIconColor", "getDownIconColor", "setDownIconColor", "downImage", "Landroidx/appcompat/widget/AppCompatImageButton;", "", "downImageEnabled", "getDownImageEnabled", "()Z", "setDownImageEnabled", "(Z)V", "factory", "Lcom/devexpress/editors/layout/factories/NumericEditLayoutElementsFactory;", "internalStyle", "Lcom/devexpress/editors/style/NumericEditStyle;", "visible", "isDownIconVisible", "setDownIconVisible", "isUpIconVisible", "setUpIconVisible", "maxDecimalDigitCount", "getMaxDecimalDigitCount", "setMaxDecimalDigitCount", "minusSign", "getMinusSign", "setMinusSign", "style", "getStyle", "()Lcom/devexpress/editors/style/NumericEditStyle;", "upDownClickListener", "Lcom/devexpress/editors/NumericEdit$UpDownClickListener;", "getUpDownClickListener", "()Lcom/devexpress/editors/NumericEdit$UpDownClickListener;", "setUpDownClickListener", "(Lcom/devexpress/editors/NumericEdit$UpDownClickListener;)V", "Lcom/devexpress/editors/DXNumericEditIconPosition;", "upDownIconPosition", "getUpDownIconPosition", "()Lcom/devexpress/editors/DXNumericEditIconPosition;", "setUpDownIconPosition", "(Lcom/devexpress/editors/DXNumericEditIconPosition;)V", "upIcon", "getUpIcon", "setUpIcon", "upIconColor", "getUpIconColor", "setUpIconColor", "upImage", "upImageEnabled", "getUpImageEnabled", "setUpImageEnabled", "createLayoutElementsFactory", "Lcom/devexpress/editors/LayoutElementsFactory;", "createTextStrategy", "Lcom/devexpress/editors/utils/textstrategies/TextStrategy;", "oldStrategy", "createTextStrategy$dxeditors_release", "getDecimalSeparatorFromLocale", "getMinusSignFromLocale", "initImage", "", "image", "onDownIconColorsChanged", "onEditorInputTypeChange", "onReadOnlyChanged", "onUpIconColorsChanged", "setChildrenEnabled", "enabled", "setSelectAllOnFocus", "updateAll", "updateDownImageEnabled", "updateDrawablesTintMode", "state", "", "updateUpImageEnabled", "UpDownClickListener", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NumericEdit extends TextEditBase {
    private char decimalSeparator;
    private DisplayTextFormatter displayTextFormatter;
    public final AppCompatImageButton downImage;
    private boolean downImageEnabled;
    private NumericEditLayoutElementsFactory factory;
    private final NumericEditStyle internalStyle;
    private boolean isDownIconVisible;
    private boolean isUpIconVisible;
    private int maxDecimalDigitCount;
    private char minusSign;
    private UpDownClickListener upDownClickListener;
    private DXNumericEditIconPosition upDownIconPosition;
    public final AppCompatImageButton upImage;
    private boolean upImageEnabled;

    /* compiled from: NumericEdit.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/devexpress/editors/NumericEdit$UpDownClickListener;", "", "clearClicked", "", "downClicked", "upClicked", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface UpDownClickListener {
        void clearClicked();

        void downClicked();

        void upClicked();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NumericEdit(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NumericEdit(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ NumericEdit(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumericEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.internalStyle = new NumericEditStyle();
        AppCompatImageButton appCompatImageButton = new AppCompatImageButton(context);
        this.upImage = appCompatImageButton;
        AppCompatImageButton appCompatImageButton2 = new AppCompatImageButton(context);
        this.downImage = appCompatImageButton2;
        this.upDownIconPosition = DXNumericEditIconPosition.DownStartUpEnd;
        this.isUpIconVisible = true;
        this.isDownIconVisible = true;
        this.decimalSeparator = getDecimalSeparatorFromLocale();
        this.minusSign = getMinusSignFromLocale();
        this.maxDecimalDigitCount = -1;
        requestTextStrategyChange();
        finishInitialization(attributeSet, i);
        setTextGravity(8388629);
        setUpIcon(null);
        setDownIcon(null);
        initImage(appCompatImageButton);
        initImage(appCompatImageButton2);
        appCompatImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.devexpress.editors.NumericEdit$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NumericEdit._init_$lambda$0(NumericEdit.this, view);
            }
        });
        appCompatImageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.devexpress.editors.NumericEdit$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NumericEdit._init_$lambda$1(NumericEdit.this, view);
            }
        });
        this.clearImage.setOnClickListener(new View.OnClickListener() { // from class: com.devexpress.editors.NumericEdit$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NumericEdit._init_$lambda$2(NumericEdit.this, view);
            }
        });
        setInputType(12290);
    }

    public final DisplayTextFormatter getDisplayTextFormatter() {
        return this.displayTextFormatter;
    }

    public final void setDisplayTextFormatter(DisplayTextFormatter displayTextFormatter) {
        if (Intrinsics.areEqual(this.displayTextFormatter, displayTextFormatter)) {
            return;
        }
        this.displayTextFormatter = displayTextFormatter;
        changeTextStrategy();
    }

    @Override // com.devexpress.editors.EditBase
    /* renamed from: getStyle, reason: from getter */
    public NumericEditStyle getInternalStyle() {
        return this.internalStyle;
    }

    public final UpDownClickListener getUpDownClickListener() {
        return this.upDownClickListener;
    }

    public final void setUpDownClickListener(UpDownClickListener upDownClickListener) {
        this.upDownClickListener = upDownClickListener;
    }

    public final DXNumericEditIconPosition getUpDownIconPosition() {
        return this.upDownIconPosition;
    }

    public final void setUpDownIconPosition(DXNumericEditIconPosition value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.upDownIconPosition != value) {
            this.upDownIconPosition = value;
            NumericEditLayoutElementsFactory numericEditLayoutElementsFactory = this.factory;
            if (numericEditLayoutElementsFactory != null) {
                numericEditLayoutElementsFactory.setUpDownIconPosition(value);
            }
            requestLayout();
        }
    }

    public final Drawable getUpIcon() {
        return this.upImage.getDrawable();
    }

    public final void setUpIcon(Drawable drawable) {
        if (drawable == null) {
            drawable = AppCompatResources.getDrawable(getContext(), R.drawable.dxe_plus);
        }
        if (Intrinsics.areEqual(this.upImage.getDrawable(), drawable)) {
            return;
        }
        this.upImage.setImageDrawable(drawable);
    }

    public final Drawable getDownIcon() {
        return this.downImage.getDrawable();
    }

    public final void setDownIcon(Drawable drawable) {
        if (drawable == null) {
            drawable = AppCompatResources.getDrawable(getContext(), R.drawable.dxe_minus);
        }
        if (Intrinsics.areEqual(this.downImage.getDrawable(), drawable)) {
            return;
        }
        this.downImage.setImageDrawable(drawable);
    }

    /* renamed from: isUpIconVisible, reason: from getter */
    public final boolean getIsUpIconVisible() {
        return this.isUpIconVisible;
    }

    public final void setUpIconVisible(boolean z) {
        if (this.isUpIconVisible == z) {
            return;
        }
        this.isUpIconVisible = z;
        updateIconVisibility(this.upImage, z);
    }

    /* renamed from: isDownIconVisible, reason: from getter */
    public final boolean getIsDownIconVisible() {
        return this.isDownIconVisible;
    }

    public final void setDownIconVisible(boolean z) {
        if (this.isDownIconVisible == z) {
            return;
        }
        this.isDownIconVisible = z;
        updateIconVisibility(this.downImage, z);
    }

    public final int getDownIconColor() {
        return getInternalStyle().getDownIconColor();
    }

    public final void setDownIconColor(int i) {
        if (getInternalStyle().getDownIconColor() == i) {
            return;
        }
        getInternalStyle().setDownIconColor(i);
        onDownIconColorsChanged();
    }

    public final int getDisabledDownIconColor() {
        return getInternalStyle().getDisabledDownIconColor();
    }

    public final void setDisabledDownIconColor(int i) {
        if (getInternalStyle().getDisabledDownIconColor() == i) {
            return;
        }
        getInternalStyle().setDisabledDownIconColor(i);
        onDownIconColorsChanged();
    }

    public final int getUpIconColor() {
        return getInternalStyle().getUpIconColor();
    }

    public final void setUpIconColor(int i) {
        if (getInternalStyle().getUpIconColor() == i) {
            return;
        }
        getInternalStyle().setUpIconColor(i);
        onUpIconColorsChanged();
    }

    public final int getDisabledUpIconColor() {
        return getInternalStyle().getDisabledUpIconColor();
    }

    public final void setDisabledUpIconColor(int i) {
        if (getInternalStyle().getDisabledUpIconColor() == i) {
            return;
        }
        getInternalStyle().setDisabledUpIconColor(i);
        onUpIconColorsChanged();
    }

    public final char getDecimalSeparator() {
        return this.decimalSeparator;
    }

    public final void setDecimalSeparator(char c) {
        if (this.decimalSeparator != c) {
            this.decimalSeparator = c;
            requestTextStrategyChange();
            getEditText().setKeyListener(new NumericEditKeyListener(getEditText().getInputType(), this.decimalSeparator, this.minusSign, this.maxDecimalDigitCount != 0));
        }
    }

    public final char getMinusSign() {
        return this.minusSign;
    }

    public final void setMinusSign(char c) {
        if (this.minusSign != c) {
            this.minusSign = c;
            requestTextStrategyChange();
            getEditText().setKeyListener(new NumericEditKeyListener(getEditText().getInputType(), this.decimalSeparator, this.minusSign, this.maxDecimalDigitCount != 0));
        }
    }

    private final char getDecimalSeparatorFromLocale() {
        if (Build.VERSION.SDK_INT >= 24) {
            return DecimalFormatSymbols.getInstance(getContext().getResources().getConfiguration().getLocales().get(0)).getDecimalSeparator();
        }
        return '.';
    }

    private final char getMinusSignFromLocale() {
        if (Build.VERSION.SDK_INT >= 24) {
            return DecimalFormatSymbols.getInstance(getContext().getResources().getConfiguration().getLocales().get(0)).getMinusSign();
        }
        return '-';
    }

    public final int getMaxDecimalDigitCount() {
        return this.maxDecimalDigitCount;
    }

    public final void setMaxDecimalDigitCount(int i) {
        if (this.maxDecimalDigitCount != i) {
            this.maxDecimalDigitCount = i;
            requestTextStrategyChange();
            getEditText().setKeyListener(new NumericEditKeyListener(getEditText().getInputType(), this.decimalSeparator, this.minusSign, this.maxDecimalDigitCount != 0));
        }
    }

    public final boolean getUpImageEnabled() {
        return this.upImageEnabled;
    }

    public final void setUpImageEnabled(boolean z) {
        this.upImageEnabled = z;
        updateUpImageEnabled();
    }

    public final boolean getDownImageEnabled() {
        return this.downImageEnabled;
    }

    public final void setDownImageEnabled(boolean z) {
        this.downImageEnabled = z;
        updateDownImageEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(NumericEdit this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UpDownClickListener upDownClickListener = this$0.upDownClickListener;
        if (upDownClickListener != null) {
            upDownClickListener.upClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(NumericEdit this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UpDownClickListener upDownClickListener = this$0.upDownClickListener;
        if (upDownClickListener != null) {
            upDownClickListener.downClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(NumericEdit this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UpDownClickListener upDownClickListener = this$0.upDownClickListener;
        if (upDownClickListener != null) {
            upDownClickListener.clearClicked();
        }
    }

    @Override // com.devexpress.editors.TextEditBase
    public TextStrategy createTextStrategy$dxeditors_release(TextStrategy oldStrategy) {
        return new NumericTextStrategy(this.decimalSeparator, this.minusSign, this.maxDecimalDigitCount, getEditText(), TextEditBase.INSTANCE.createTextChangedCallback(this), getFormat(), this.displayTextFormatter);
    }

    public final void setSelectAllOnFocus(boolean value) {
        getEditText().setSelectAllOnFocus(value);
    }

    @Override // com.devexpress.editors.EditBase
    protected void onEditorInputTypeChange() {
        super.onEditorInputTypeChange();
        if (getActualEditorInputType() != 0) {
            getEditText().setKeyListener(NumericEditKeyListener.INSTANCE.create(getActualEditorInputType(), this.decimalSeparator));
        }
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    protected LayoutElementsFactory createLayoutElementsFactory() {
        NumericEditLayoutElementsFactory numericEditLayoutElementsFactory = new NumericEditLayoutElementsFactory(getInternalEditor(), this.labelTextView, this.startImage, this.endImage, this.clearImage, this.errorImage, this.errorTextView, this.helpTextView, this.suffixView, this.prefixView, this.upImage, this.downImage, this.upDownIconPosition);
        this.factory = numericEditLayoutElementsFactory;
        return numericEditLayoutElementsFactory;
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    protected void setChildrenEnabled(boolean enabled) {
        super.setChildrenEnabled(enabled);
        updateUpImageEnabled();
        updateDownImageEnabled();
    }

    @Override // com.devexpress.editors.EditBase
    protected void updateAll() {
        super.updateAll();
        onDownIconColorsChanged();
        onUpIconColorsChanged();
    }

    @Override // com.devexpress.editors.EditBase
    protected void updateDrawablesTintMode(int[] state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.updateDrawablesTintMode(state);
        updateDrawableTintMode(this.upImage, state);
        updateDrawableTintMode(this.downImage, state);
    }

    @Override // com.devexpress.editors.EditBase
    protected void onReadOnlyChanged() {
        super.onReadOnlyChanged();
        setChildrenEnabled(isEnabled());
    }

    private final void initImage(AppCompatImageButton image) {
        addView(image);
        image.setBackgroundColor(0);
        image.setPadding(0, 0, 0, 0);
        image.setClickable(true);
    }

    private final void updateUpImageEnabled() {
        this.upImage.setEnabled(this.upImageEnabled && isEnabled() && !getIsReadOnly());
    }

    private final void updateDownImageEnabled() {
        this.downImage.setEnabled(this.downImageEnabled && isEnabled() && !getIsReadOnly());
    }

    private final void onDownIconColorsChanged() {
        updateIconTintList(this.downImage, getInternalStyle().getDownIconColor(), getInternalStyle().getDisabledDownIconColor());
    }

    private final void onUpIconColorsChanged() {
        updateIconTintList(this.upImage, getInternalStyle().getUpIconColor(), getInternalStyle().getDisabledUpIconColor());
    }
}
