package com.google.crypto.tink.signature;

import java.security.GeneralSecurityException;

@Deprecated
/* loaded from: classes2.dex */
public final class PublicKeySignConfig {
    @Deprecated
    public static void registerStandardKeyTypes() throws GeneralSecurityException {
        SignatureConfig.register();
    }

    private PublicKeySignConfig() {
    }
}
