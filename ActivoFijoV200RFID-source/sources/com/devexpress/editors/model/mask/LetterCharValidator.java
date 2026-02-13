package com.devexpress.editors.model.mask;

import com.devexpress.editors.model.mask.CharValidator;
import kotlin.Metadata;

/* compiled from: CharValidator.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/model/mask/LetterCharValidator;", "Lcom/devexpress/editors/model/mask/CharValidator;", "()V", "isValid", "", "char", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LetterCharValidator implements CharValidator {
    @Override // com.devexpress.editors.model.mask.CharValidator
    public boolean getCanBeSkipped() {
        return CharValidator.DefaultImpls.getCanBeSkipped(this);
    }

    @Override // com.devexpress.editors.model.mask.CharValidator
    public boolean isValid(char r1) {
        return Character.isLetter(r1);
    }
}
