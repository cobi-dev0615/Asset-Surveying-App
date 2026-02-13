package com.google.crypto.tink;

import com.google.crypto.tink.aead.AesCtrHmacAeadKey;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.subtle.EncryptThenAuthenticate;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class ConfigurationFips140v2$$ExternalSyntheticLambda3 implements PrimitiveConstructor.PrimitiveConstructionFunction {
    @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
    public final Object constructPrimitive(Key key) {
        return EncryptThenAuthenticate.create((AesCtrHmacAeadKey) key);
    }
}
