package com.google.crypto.tink.hybrid.internal;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

@Immutable
/* loaded from: classes2.dex */
public interface HpkeAead {
    byte[] getAeadId() throws GeneralSecurityException;

    int getKeyLength();

    int getNonceLength();

    byte[] open(byte[] key, byte[] nonce, byte[] ciphertext, int ciphertextOffset, byte[] associatedData) throws GeneralSecurityException;

    byte[] open(byte[] key, byte[] nonce, byte[] ciphertext, byte[] associatedData) throws GeneralSecurityException;

    byte[] seal(byte[] key, byte[] nonce, byte[] plaintext, int ciphertextOffset, byte[] associatedData) throws GeneralSecurityException;

    byte[] seal(byte[] key, byte[] nonce, byte[] plaintext, byte[] associatedData) throws GeneralSecurityException;

    /* renamed from: com.google.crypto.tink.hybrid.internal.HpkeAead$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
    }
}
