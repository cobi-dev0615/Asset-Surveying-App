package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.aead.internal.XAesGcm;
import com.google.crypto.tink.internal.PrimitiveConstructor;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class AeadConfigurationV0$$ExternalSyntheticLambda2 implements PrimitiveConstructor.PrimitiveConstructionFunction {
    @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
    public final Object constructPrimitive(Key key) {
        return XAesGcm.create((XAesGcmKey) key);
    }
}
