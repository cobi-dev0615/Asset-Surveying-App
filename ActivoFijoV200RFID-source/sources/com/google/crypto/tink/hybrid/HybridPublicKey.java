package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;

@Immutable
/* loaded from: classes2.dex */
public abstract class HybridPublicKey extends Key {
    public abstract Bytes getOutputPrefix();

    @Override // com.google.crypto.tink.Key
    public abstract HybridParameters getParameters();
}
