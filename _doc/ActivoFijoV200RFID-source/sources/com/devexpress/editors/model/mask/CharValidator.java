package com.devexpress.editors.model.mask;

import kotlin.Metadata;

/* compiled from: CharValidator.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/devexpress/editors/model/mask/CharValidator;", "", "canBeSkipped", "", "getCanBeSkipped", "()Z", "isValid", "char", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CharValidator {

    /* compiled from: CharValidator.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean getCanBeSkipped(CharValidator charValidator) {
            return false;
        }
    }

    boolean getCanBeSkipped();

    boolean isValid(char r1);
}
