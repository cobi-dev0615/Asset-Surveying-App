package com.devexpress.editors.utils.textstrategies;

import android.text.Editable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.devexpress.editors.DXCharacterCasing;
import com.devexpress.editors.utils.textstrategies.DefaultTextProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DecoratorTextProcessor.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0016J(\u0010-\u001a\u00020+2\u0006\u0010(\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u0015H\u0016J0\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u0015H\u0016J(\u00106\u001a\u00020+2\u0006\u0010(\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u0015H\u0016J\u0012\u00107\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\"H\u0016R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00158V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00158V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR$\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010\u0002\u001a\u00020\u0001X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00068"}, d2 = {"Lcom/devexpress/editors/utils/textstrategies/DecoratorTextProcessor;", "Lcom/devexpress/editors/utils/textstrategies/TextProcessor;", "wrappee", "(Lcom/devexpress/editors/utils/textstrategies/TextProcessor;)V", "value", "Lcom/devexpress/editors/DXCharacterCasing;", "characterCasing", "getCharacterCasing", "()Lcom/devexpress/editors/DXCharacterCasing;", "setCharacterCasing", "(Lcom/devexpress/editors/DXCharacterCasing;)V", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasPlaceholder", "getHasPlaceholder", "setHasPlaceholder", "isViewUpdateRequired", "", "selectionEnd", "getSelectionEnd", "()I", "setSelectionEnd", "(I)V", "selectionStart", "getSelectionStart", "setSelectionStart", "shouldReplaceEditorText", "getShouldReplaceEditorText", "setShouldReplaceEditorText", "text", "", "getText", "()Ljava/lang/CharSequence;", "getWrappee", "()Lcom/devexpress/editors/utils/textstrategies/TextProcessor;", "afterTextChanged", "s", "Landroid/text/Editable;", "applyDisplayText", "", TypedValues.AttributesType.S_TARGET, "beforeTextChanged", "start", "count", "after", "getActualStartAndCount", "Lcom/devexpress/editors/utils/textstrategies/DefaultTextProcessor$ActualStartAndCount;", "currentValue", "newValue", "before", "onTextChanged", "setText", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DecoratorTextProcessor implements TextProcessor {
    private final TextProcessor wrappee;

    public DecoratorTextProcessor(TextProcessor wrappee) {
        Intrinsics.checkNotNullParameter(wrappee, "wrappee");
        this.wrappee = wrappee;
    }

    protected final TextProcessor getWrappee() {
        return this.wrappee;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    /* renamed from: isViewUpdateRequired */
    public boolean getIsViewUpdateRequired() {
        return this.wrappee.getIsViewUpdateRequired();
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    /* renamed from: getText */
    public CharSequence getTextInternal() {
        return this.wrappee.getTextInternal();
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public boolean getHasFocus() {
        return this.wrappee.getHasFocus();
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public void setHasFocus(boolean z) {
        this.wrappee.setHasFocus(z);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public boolean getHasPlaceholder() {
        return this.wrappee.getHasPlaceholder();
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public void setHasPlaceholder(boolean z) {
        this.wrappee.setHasPlaceholder(z);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public int getSelectionStart() {
        return this.wrappee.getSelectionStart();
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public void setSelectionStart(int i) {
        this.wrappee.setSelectionStart(i);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public int getSelectionEnd() {
        return this.wrappee.getSelectionEnd();
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public void setSelectionEnd(int i) {
        this.wrappee.setSelectionEnd(i);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public DXCharacterCasing getCharacterCasing() {
        return this.wrappee.getCharacterCasing();
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public void setCharacterCasing(DXCharacterCasing value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.wrappee.setCharacterCasing(value);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public boolean getShouldReplaceEditorText() {
        return this.wrappee.getShouldReplaceEditorText();
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public void setShouldReplaceEditorText(boolean z) {
        this.wrappee.setShouldReplaceEditorText(z);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public void applyDisplayText(Editable target) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.wrappee.applyDisplayText(target);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public boolean setText(CharSequence value) {
        return this.wrappee.setText(value);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Intrinsics.checkNotNullParameter(s, "s");
        this.wrappee.beforeTextChanged(s, start, count, after);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Intrinsics.checkNotNullParameter(s, "s");
        this.wrappee.onTextChanged(s, start, before, count);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public boolean afterTextChanged(Editable s) {
        Intrinsics.checkNotNullParameter(s, "s");
        return this.wrappee.afterTextChanged(s);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public DefaultTextProcessor.ActualStartAndCount getActualStartAndCount(CharSequence currentValue, CharSequence newValue, int start, int before, int count) {
        Intrinsics.checkNotNullParameter(currentValue, "currentValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        return this.wrappee.getActualStartAndCount(currentValue, newValue, start, before, count);
    }
}
