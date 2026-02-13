package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.RegistryConfiguration;
import java.security.GeneralSecurityException;

@Deprecated
/* loaded from: classes2.dex */
public final class AeadFactory {
    @Deprecated
    public static Aead getPrimitive(KeysetHandle keysetHandle) throws GeneralSecurityException {
        AeadWrapper.register();
        return (Aead) keysetHandle.getPrimitive(RegistryConfiguration.get(), Aead.class);
    }

    private AeadFactory() {
    }
}
