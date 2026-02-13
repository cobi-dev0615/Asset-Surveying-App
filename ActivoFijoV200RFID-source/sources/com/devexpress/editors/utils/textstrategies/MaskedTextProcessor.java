package com.devexpress.editors.utils.textstrategies;

import android.text.Editable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.devexpress.editors.DXCharacterCasing;
import com.devexpress.editors.utils.MaskManager;
import com.devexpress.editors.utils.UtilsKt;
import com.devexpress.editors.utils.textstrategies.DefaultTextProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MaskedTextProcessor.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0017H\u0016R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/devexpress/editors/utils/textstrategies/MaskedTextProcessor;", "Lcom/devexpress/editors/utils/textstrategies/DecoratorTextProcessor;", "manager", "Lcom/devexpress/editors/utils/MaskManager;", "wrappee", "Lcom/devexpress/editors/utils/textstrategies/TextProcessor;", "(Lcom/devexpress/editors/utils/MaskManager;Lcom/devexpress/editors/utils/textstrategies/TextProcessor;)V", "value", "Lcom/devexpress/editors/DXCharacterCasing;", "characterCasing", "getCharacterCasing", "()Lcom/devexpress/editors/DXCharacterCasing;", "setCharacterCasing", "(Lcom/devexpress/editors/DXCharacterCasing;)V", "isViewUpdateRequired", "", "()Z", "applyDisplayText", "", TypedValues.AttributesType.S_TARGET, "Landroid/text/Editable;", "onTextChanged", "s", "", "start", "", "before", "count", "setText", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MaskedTextProcessor extends DecoratorTextProcessor {
    private final boolean isViewUpdateRequired;
    private final MaskManager manager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskedTextProcessor(MaskManager manager, TextProcessor wrappee) {
        super(wrappee);
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(wrappee, "wrappee");
        this.manager = manager;
        this.isViewUpdateRequired = true;
    }

    @Override // com.devexpress.editors.utils.textstrategies.DecoratorTextProcessor, com.devexpress.editors.utils.textstrategies.TextProcessor
    /* renamed from: isViewUpdateRequired, reason: from getter */
    public boolean getIsViewUpdateRequired() {
        return this.isViewUpdateRequired;
    }

    @Override // com.devexpress.editors.utils.textstrategies.DecoratorTextProcessor, com.devexpress.editors.utils.textstrategies.TextProcessor
    public DXCharacterCasing getCharacterCasing() {
        return this.manager.getMask().getCharacterCasing();
    }

    @Override // com.devexpress.editors.utils.textstrategies.DecoratorTextProcessor, com.devexpress.editors.utils.textstrategies.TextProcessor
    public void setCharacterCasing(DXCharacterCasing value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.manager.getMask().getCharacterCasing() == value) {
            return;
        }
        this.manager.getMask().setCharacterCasing(value);
    }

    @Override // com.devexpress.editors.utils.textstrategies.DecoratorTextProcessor, com.devexpress.editors.utils.textstrategies.TextProcessor
    public boolean setText(CharSequence value) {
        this.manager.setText(value);
        boolean text = getWrappee().setText(this.manager.getText());
        setSelectionStart(this.manager.getNextPosition());
        setSelectionEnd(this.manager.getNextPosition());
        return text;
    }

    @Override // com.devexpress.editors.utils.textstrategies.DecoratorTextProcessor, com.devexpress.editors.utils.textstrategies.TextProcessor
    public void applyDisplayText(Editable target) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (!getHasFocus() && this.manager.isEmpty() && getHasPlaceholder()) {
            target.clear();
        } else {
            this.manager.populateWithFormattedValue(target);
        }
    }

    @Override // com.devexpress.editors.utils.textstrategies.DecoratorTextProcessor, com.devexpress.editors.utils.textstrategies.TextProcessor
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Intrinsics.checkNotNullParameter(s, "s");
        DefaultTextProcessor.ActualStartAndCount actualStartAndCount = getActualStartAndCount(s, this.manager.getDisplayText(), start, before, count);
        this.manager.onTextChanged(s, actualStartAndCount.getStartSymbolIndex(), before - (actualStartAndCount.getStartSymbolIndex() - start), actualStartAndCount.getNewSymbolsCount());
        getWrappee().onTextChanged(UtilsKt.copy(this.manager.getText()), start, before, count);
        getWrappee().setSelectionStart(this.manager.getNextPosition());
        getWrappee().setSelectionEnd(this.manager.getNextPosition());
    }
}
