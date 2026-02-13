package com.devexpress.editors.utils.textstrategies;

import android.text.Editable;
import com.devexpress.editors.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NumericTextProcessor.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013H\u0002J(\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0012\u0010!\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010\u0013H\u0016J(\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006H\u0002R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/devexpress/editors/utils/textstrategies/NumericTextProcessor;", "Lcom/devexpress/editors/utils/textstrategies/DecoratorTextProcessor;", "decimalSeparator", "", "minusSign", "maxDecimalDigitCount", "", "wrappee", "Lcom/devexpress/editors/utils/textstrategies/TextProcessor;", "(CCILcom/devexpress/editors/utils/textstrategies/TextProcessor;)V", "correctSelection", "getCorrectSelection", "()I", "setCorrectSelection", "(I)V", "isViewUpdateRequired", "", "()Z", "oldText", "", "textChanged", "afterTextChanged", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "checkedEmptySymbolText", "text", "onTextChanged", "before", "setText", "value", "validateText", "changedText", "location", "oldLength", "newLength", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NumericTextProcessor extends DecoratorTextProcessor {
    private int correctSelection;
    private final char decimalSeparator;
    private final boolean isViewUpdateRequired;
    private final int maxDecimalDigitCount;
    private final char minusSign;
    private CharSequence oldText;
    private boolean textChanged;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumericTextProcessor(char c, char c2, int i, TextProcessor wrappee) {
        super(wrappee);
        Intrinsics.checkNotNullParameter(wrappee, "wrappee");
        this.decimalSeparator = c;
        this.minusSign = c2;
        this.maxDecimalDigitCount = i;
        this.oldText = "";
        this.isViewUpdateRequired = true;
    }

    public final int getCorrectSelection() {
        return this.correctSelection;
    }

    public final void setCorrectSelection(int i) {
        this.correctSelection = i;
    }

    @Override // com.devexpress.editors.utils.textstrategies.DecoratorTextProcessor, com.devexpress.editors.utils.textstrategies.TextProcessor
    /* renamed from: isViewUpdateRequired, reason: from getter */
    public boolean getIsViewUpdateRequired() {
        return this.isViewUpdateRequired;
    }

    @Override // com.devexpress.editors.utils.textstrategies.DecoratorTextProcessor, com.devexpress.editors.utils.textstrategies.TextProcessor
    public boolean setText(CharSequence value) {
        CharSequence charSequence;
        if (value != null && value.length() != 0) {
            charSequence = validateText(value, 0, getTextInternal().length(), value.length());
        }
        this.oldText = charSequence;
        return super.setText(charSequence);
    }

    @Override // com.devexpress.editors.utils.textstrategies.DecoratorTextProcessor, com.devexpress.editors.utils.textstrategies.TextProcessor
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Intrinsics.checkNotNullParameter(s, "s");
        this.textChanged = false;
        this.correctSelection = 0;
    }

    @Override // com.devexpress.editors.utils.textstrategies.DecoratorTextProcessor, com.devexpress.editors.utils.textstrategies.TextProcessor
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Intrinsics.checkNotNullParameter(s, "s");
        CharSequence validateText = validateText(s.toString(), start, before, count);
        this.oldText = validateText;
        super.onTextChanged(validateText, start, before, count);
    }

    @Override // com.devexpress.editors.utils.textstrategies.DecoratorTextProcessor, com.devexpress.editors.utils.textstrategies.TextProcessor
    public boolean afterTextChanged(Editable s) {
        Intrinsics.checkNotNullParameter(s, "s");
        return this.textChanged;
    }

    private final CharSequence validateText(CharSequence changedText, int location, int oldLength, int newLength) {
        String sb;
        String copy = UtilsKt.copy(changedText);
        int i = location + newLength;
        CharSequence subSequence = changedText.subSequence(location, i);
        if (StringsKt.contains$default(this.oldText, this.decimalSeparator, false, 2, (Object) null) && newLength == 1 && subSequence.charAt(0) == this.decimalSeparator) {
            return this.oldText;
        }
        this.textChanged = true;
        if (newLength == 1) {
            char charAt = subSequence.charAt(0);
            char c = this.minusSign;
            if (charAt == c) {
                if (StringsKt.contains$default(this.oldText, c, false, 2, (Object) null)) {
                    CharSequence charSequence = this.oldText;
                    sb = charSequence.subSequence(1, charSequence.length());
                    this.correctSelection = -1;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.minusSign);
                    sb2.append((Object) this.oldText);
                    sb = sb2.toString();
                    this.correctSelection = 1;
                }
                int i2 = location + this.correctSelection;
                setSelectionStart(i2);
                setSelectionEnd(i2 + oldLength);
                return sb;
            }
        }
        int indexOf$default = StringsKt.indexOf$default(changedText, this.decimalSeparator, 0, false, 6, (Object) null);
        if (indexOf$default >= 0 && this.maxDecimalDigitCount >= 0) {
            int length = (changedText.length() - indexOf$default) - 1;
            int i3 = this.maxDecimalDigitCount;
            if (length > i3) {
                int i4 = i3 == 0 ? indexOf$default + i3 : indexOf$default + i3 + 1;
                copy = changedText.subSequence(0, i4).toString();
                i = Math.min(i, i4);
            }
        }
        setSelectionStart(i);
        setSelectionEnd(i);
        return checkedEmptySymbolText(copy);
    }

    private final CharSequence checkedEmptySymbolText(CharSequence text) {
        if (Intrinsics.areEqual(text, String.valueOf(this.minusSign))) {
            return "";
        }
        return UtilsKt.copy(text);
    }
}
