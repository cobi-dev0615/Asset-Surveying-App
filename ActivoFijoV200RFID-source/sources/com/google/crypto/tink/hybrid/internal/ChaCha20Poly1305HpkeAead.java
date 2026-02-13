package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.aead.internal.InsecureNonceChaCha20Poly1305;
import com.google.crypto.tink.aead.internal.InsecureNonceChaCha20Poly1305Jce;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

@Immutable
/* loaded from: classes2.dex */
final class ChaCha20Poly1305HpkeAead implements HpkeAead {
    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public int getKeyLength() {
        return 32;
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public int getNonceLength() {
        return 12;
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public /* synthetic */ byte[] open(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        byte[] open;
        open = open(bArr, bArr2, bArr3, 0, bArr4);
        return open;
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public /* synthetic */ byte[] seal(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        byte[] seal;
        seal = seal(bArr, bArr2, bArr3, 0, bArr4);
        return seal;
    }

    ChaCha20Poly1305HpkeAead() {
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public byte[] seal(byte[] key, byte[] nonce, byte[] plaintext, int ciphertextOffset, byte[] associatedData) throws GeneralSecurityException {
        if (key.length != getKeyLength()) {
            throw new InvalidAlgorithmParameterException("Unexpected key length: " + getKeyLength());
        }
        if (InsecureNonceChaCha20Poly1305Jce.isSupported()) {
            return InsecureNonceChaCha20Poly1305Jce.create(key).encrypt(nonce, plaintext, ciphertextOffset, associatedData);
        }
        byte[] encrypt = new InsecureNonceChaCha20Poly1305(key).encrypt(nonce, plaintext, associatedData);
        if (encrypt.length > Integer.MAX_VALUE - ciphertextOffset) {
            throw new InvalidAlgorithmParameterException("Plaintext too long");
        }
        byte[] bArr = new byte[encrypt.length + ciphertextOffset];
        System.arraycopy(encrypt, 0, bArr, ciphertextOffset, encrypt.length);
        return bArr;
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public byte[] open(byte[] key, byte[] nonce, byte[] ciphertext, int ciphertextOffset, byte[] associatedData) throws GeneralSecurityException {
        if (key.length != getKeyLength()) {
            throw new InvalidAlgorithmParameterException("Unexpected key length: " + getKeyLength());
        }
        if (InsecureNonceChaCha20Poly1305Jce.isSupported()) {
            return InsecureNonceChaCha20Poly1305Jce.create(key).decrypt(nonce, ciphertext, ciphertextOffset, associatedData);
        }
        return new InsecureNonceChaCha20Poly1305(key).decrypt(nonce, Arrays.copyOfRange(ciphertext, ciphertextOffset, ciphertext.length), associatedData);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public byte[] getAeadId() {
        return HpkeUtil.CHACHA20_POLY1305_AEAD_ID;
    }
}
