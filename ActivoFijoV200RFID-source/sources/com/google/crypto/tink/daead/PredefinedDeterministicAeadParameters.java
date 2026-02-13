package com.google.crypto.tink.daead;

import com.google.crypto.tink.daead.AesSivParameters;
import com.google.crypto.tink.internal.TinkBugException;

/* loaded from: classes2.dex */
public final class PredefinedDeterministicAeadParameters {
    public static final AesSivParameters AES256_SIV = (AesSivParameters) TinkBugException.exceptionIsBug(new TinkBugException.ThrowingSupplier() { // from class: com.google.crypto.tink.daead.PredefinedDeterministicAeadParameters$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.TinkBugException.ThrowingSupplier
        public final Object get() {
            AesSivParameters build;
            build = AesSivParameters.builder().setKeySizeBytes(64).setVariant(AesSivParameters.Variant.TINK).build();
            return build;
        }
    });

    private PredefinedDeterministicAeadParameters() {
    }
}
