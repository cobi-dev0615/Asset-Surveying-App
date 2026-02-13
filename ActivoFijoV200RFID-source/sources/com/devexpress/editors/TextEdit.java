package com.devexpress.editors;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.devexpress.editors.model.mask.Mask;
import com.devexpress.editors.style.TextEditStyle;
import com.devexpress.editors.utils.MaskDigitsKeyListener;
import com.devexpress.editors.utils.MaskManager;
import com.devexpress.editors.utils.UtilsKt;
import com.devexpress.editors.utils.textstrategies.DefaultTextStrategy;
import com.devexpress.editors.utils.textstrategies.DisplayFormatTextStrategy;
import com.devexpress.editors.utils.textstrategies.MaskedTextStrategy;
import com.devexpress.editors.utils.textstrategies.TextStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextEdit.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u0000 42\u00020\u0001:\u00014B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0002J\b\u0010-\u001a\u00020&H\u0002J\u0017\u0010.\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010&H\u0010¢\u0006\u0002\b0J\b\u00101\u001a\u00020$H\u0014J\b\u00102\u001a\u00020$H\u0014J\b\u00103\u001a\u00020$H\u0002R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u00065"}, d2 = {"Lcom/devexpress/editors/TextEdit;", "Lcom/devexpress/editors/TextEditBase;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/devexpress/editors/DisplayTextFormatter;", "displayTextFormatter", "getDisplayTextFormatter", "()Lcom/devexpress/editors/DisplayTextFormatter;", "setDisplayTextFormatter", "(Lcom/devexpress/editors/DisplayTextFormatter;)V", "internalStyle", "Lcom/devexpress/editors/style/TextEditStyle;", "", "mask", "getMask", "()Ljava/lang/CharSequence;", "setMask", "(Ljava/lang/CharSequence;)V", "maskManager", "Lcom/devexpress/editors/utils/MaskManager;", "", "maskPlaceholderChar", "getMaskPlaceholderChar", "()C", "setMaskPlaceholderChar", "(C)V", "style", "getStyle", "()Lcom/devexpress/editors/style/TextEditStyle;", "cleanMaskWatcher", "", "createDisplayFormatTextStrategy", "Lcom/devexpress/editors/utils/textstrategies/TextStrategy;", "format", "createMaskNumericListener", "Lcom/devexpress/editors/utils/MaskDigitsKeyListener;", "sign", "", "decimal", "createMaskTextStrategy", "createTextStrategy", "oldStrategy", "createTextStrategy$dxeditors_release", "onEditorInputTypeChange", "onPlaceholderColorChanged", "updateInputTypeIfRequired", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class TextEdit extends TextEditBase {
    private static final char DEFAULT_MASK_PLACEHOLDER_CHAR = '_';
    private DisplayTextFormatter displayTextFormatter;
    private final TextEditStyle internalStyle;
    private CharSequence mask;
    private MaskManager maskManager;
    private char maskPlaceholderChar;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextEdit(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextEdit(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TextEdit(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.internalStyle = new TextEditStyle();
        finishInitialization(attributeSet, i);
        requestTextStrategyChange();
        getEditText().setSingleLine();
        this.maskPlaceholderChar = DEFAULT_MASK_PLACEHOLDER_CHAR;
    }

    @Override // com.devexpress.editors.EditBase
    /* renamed from: getStyle, reason: from getter */
    public TextEditStyle getInternalStyle() {
        return this.internalStyle;
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

    public final CharSequence getMask() {
        return this.mask;
    }

    public final void setMask(CharSequence charSequence) {
        if (TextUtils.equals(this.mask, charSequence)) {
            return;
        }
        this.mask = charSequence;
        changeTextStrategy();
        updateEditorTextSettings();
        getTextStrategy$dxeditors_release().updateEditorText();
    }

    public final char getMaskPlaceholderChar() {
        return this.maskPlaceholderChar;
    }

    public final void setMaskPlaceholderChar(char c) {
        if (c == this.maskPlaceholderChar) {
            return;
        }
        this.maskPlaceholderChar = c;
        MaskManager maskManager = this.maskManager;
        if (maskManager != null) {
            maskManager.getMask().setPlaceholderChar(this.maskPlaceholderChar);
            getTextStrategy$dxeditors_release().updateEditorText();
        }
    }

    @Override // com.devexpress.editors.EditBase
    protected void onEditorInputTypeChange() {
        super.onEditorInputTypeChange();
        updateInputTypeIfRequired();
        getTextStrategy$dxeditors_release().updateEditorText();
    }

    @Override // com.devexpress.editors.TextEditBase
    public TextStrategy createTextStrategy$dxeditors_release(TextStrategy oldStrategy) {
        CharSequence format = getFormat();
        DisplayTextFormatter displayTextFormatter = this.displayTextFormatter;
        if (displayTextFormatter != null && format != null && format.length() != 0) {
            return createDisplayFormatTextStrategy(format, displayTextFormatter);
        }
        CharSequence charSequence = this.mask;
        if (charSequence != null && charSequence.length() != 0) {
            return createMaskTextStrategy();
        }
        cleanMaskWatcher();
        DefaultTextStrategy defaultTextStrategy = oldStrategy instanceof DefaultTextStrategy ? (DefaultTextStrategy) oldStrategy : null;
        return defaultTextStrategy != null ? defaultTextStrategy : super.createTextStrategy$dxeditors_release(oldStrategy);
    }

    @Override // com.devexpress.editors.EditBase
    protected void onPlaceholderColorChanged() {
        super.onPlaceholderColorChanged();
        MaskManager maskManager = this.maskManager;
        if (maskManager != null) {
            maskManager.getMask().setPlaceholderColor(getPlaceholderColor());
            getTextStrategy$dxeditors_release().updateEditorText();
        }
    }

    private final void cleanMaskWatcher() {
        this.maskManager = null;
    }

    private final TextStrategy createMaskTextStrategy() {
        Mask.Companion companion = Mask.INSTANCE;
        String str = this.mask;
        if (str == null) {
        }
        Mask parse = companion.parse(str, getCharacterCasing(), this.maskPlaceholderChar, getPlaceholderColor());
        MaskManager maskManager = this.maskManager;
        if (maskManager == null) {
            maskManager = new MaskManager(parse);
            this.maskManager = maskManager;
        } else {
            maskManager.setMask(parse);
        }
        return new MaskedTextStrategy(maskManager, getEditText(), TextEditBase.INSTANCE.createTextChangedCallback(this));
    }

    private final TextStrategy createDisplayFormatTextStrategy(CharSequence format, DisplayTextFormatter displayTextFormatter) {
        CharSequence charSequence = this.mask;
        if (charSequence != null && charSequence.length() != 0) {
            cleanMaskWatcher();
        }
        return new DisplayFormatTextStrategy(format, displayTextFormatter, getEditText(), TextEditBase.INSTANCE.createTextChangedCallback(this));
    }

    private final void updateInputTypeIfRequired() {
        int actualEditorInputType = getActualEditorInputType();
        CharSequence charSequence = this.mask;
        if (charSequence == null || charSequence.length() == 0 || (actualEditorInputType & 15) != 2) {
            return;
        }
        int i = actualEditorInputType & 16773120;
        getInternalEditor().setKeyListener(createMaskNumericListener(UtilsKt.has(i, 4096), UtilsKt.has(i, 8192)));
    }

    private final MaskDigitsKeyListener createMaskNumericListener(boolean sign, boolean decimal) {
        if (Build.VERSION.SDK_INT >= 26) {
            LocaleList imeHintLocales = getInternalEditor().getImeHintLocales();
            return new MaskDigitsKeyListener(imeHintLocales != null ? imeHintLocales.get(0) : null, sign, decimal);
        }
        return new MaskDigitsKeyListener(sign, decimal);
    }
}
