package com.google.crypto.tink;

import com.google.crypto.tink.hybrid.HpkePublicKey;
import com.google.crypto.tink.hybrid.internal.HpkeEncrypt;
import com.google.crypto.tink.internal.PrimitiveConstructor;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class ConfigurationV0$$ExternalSyntheticLambda6 implements PrimitiveConstructor.PrimitiveConstructionFunction {
    @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
    public final Object constructPrimitive(Key key) {
        return HpkeEncrypt.create((HpkePublicKey) key);
    }
}
