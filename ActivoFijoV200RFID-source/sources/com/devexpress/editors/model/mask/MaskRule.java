package com.devexpress.editors.model.mask;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MaskRule.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\tR\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/devexpress/editors/model/mask/MaskRule;", "", "validator", "Lcom/devexpress/editors/model/mask/CharValidator;", "(Lcom/devexpress/editors/model/mask/CharValidator;)V", "_value", "", "Ljava/lang/Character;", "canBeSkipped", "", "getCanBeSkipped", "()Z", "isEmpty", "value", "getValue", "()Ljava/lang/Character;", "accept", "char", "clear", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MaskRule {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Character _value;
    private final boolean canBeSkipped;
    private final CharValidator validator;

    /* compiled from: MaskRule.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/devexpress/editors/model/mask/MaskRule$Companion;", "", "()V", "any", "Lcom/devexpress/editors/model/mask/MaskRule;", "digit", "exactly", "char", "", "letter", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MaskRule exactly(char r3) {
            MaskRule maskRule = new MaskRule(new ExactlyCharValidator(r3));
            maskRule.accept(r3);
            return maskRule;
        }

        public final MaskRule digit() {
            return new MaskRule(new DigitCharValidator());
        }

        public final MaskRule letter() {
            return new MaskRule(new LetterCharValidator());
        }

        public final MaskRule any() {
            return new MaskRule(new AnyCharValidator());
        }
    }

    public MaskRule(CharValidator validator) {
        Intrinsics.checkNotNullParameter(validator, "validator");
        this.validator = validator;
        this.canBeSkipped = validator.getCanBeSkipped();
    }

    /* renamed from: getValue, reason: from getter */
    public final Character get_value() {
        return this._value;
    }

    public final boolean getCanBeSkipped() {
        return this.canBeSkipped;
    }

    public final boolean isEmpty() {
        return get_value() == null;
    }

    public final boolean accept(char r2) {
        if (!this.validator.isValid(r2)) {
            return false;
        }
        this._value = Character.valueOf(r2);
        return true;
    }

    public final boolean clear() {
        if (this.canBeSkipped) {
            return false;
        }
        this._value = null;
        return true;
    }
}
