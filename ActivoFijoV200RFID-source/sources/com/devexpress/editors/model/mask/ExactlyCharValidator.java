package com.devexpress.editors.model.mask;

import kotlin.Metadata;
import kotlin.text.CharsKt;

/* compiled from: CharValidator.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/devexpress/editors/model/mask/ExactlyCharValidator;", "Lcom/devexpress/editors/model/mask/CharValidator;", "targetChar", "", "(C)V", "canBeSkipped", "", "getCanBeSkipped", "()Z", "isValid", "char", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExactlyCharValidator implements CharValidator {
    private final boolean canBeSkipped = true;
    private final char targetChar;

    public ExactlyCharValidator(char c) {
        this.targetChar = c;
    }

    @Override // com.devexpress.editors.model.mask.CharValidator
    public boolean getCanBeSkipped() {
        return this.canBeSkipped;
    }

    @Override // com.devexpress.editors.model.mask.CharValidator
    public boolean isValid(char r3) {
        return CharsKt.equals(this.targetChar, r3, false);
    }
}
