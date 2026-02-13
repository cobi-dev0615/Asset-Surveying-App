package com.google.crypto.tink;

import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.signature.Ed25519PublicKey;
import com.google.crypto.tink.subtle.Ed25519Verify;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class ConfigurationV0$$ExternalSyntheticLambda11 implements PrimitiveConstructor.PrimitiveConstructionFunction {
    @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
    public final Object constructPrimitive(Key key) {
        return Ed25519Verify.create((Ed25519PublicKey) key);
    }
}
