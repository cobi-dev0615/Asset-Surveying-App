package com.google.crypto.tink.subtle;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.daead.AesSivKey;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.mac.internal.AesUtil;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes3.dex */
public final class AesSiv implements DeterministicAead {
    private final byte[] aesCtrKey;
    private final PrfAesCmac cmacForS2V;
    private final byte[] outputPrefix;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final Collection<Integer> KEY_SIZES = Arrays.asList(64);
    private static final byte[] BLOCK_ZERO = new byte[16];
    private static final byte[] BLOCK_ONE = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
    private static final ThreadLocal<Cipher> localAesCtrCipher = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.subtle.AesSiv.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    };

    public static DeterministicAead create(AesSivKey key) throws GeneralSecurityException {
        return new AesSiv(key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), key.getOutputPrefix());
    }

    private AesSiv(final byte[] key, com.google.crypto.tink.util.Bytes outputPrefix) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        }
        if (!KEY_SIZES.contains(Integer.valueOf(key.length))) {
            throw new InvalidKeyException("invalid key size: " + key.length + " bytes; key must have 64 bytes");
        }
        byte[] copyOfRange = Arrays.copyOfRange(key, 0, key.length / 2);
        this.aesCtrKey = Arrays.copyOfRange(key, key.length / 2, key.length);
        this.cmacForS2V = new PrfAesCmac(copyOfRange);
        this.outputPrefix = outputPrefix.toByteArray();
    }

    public AesSiv(final byte[] key) throws GeneralSecurityException {
        this(key, com.google.crypto.tink.util.Bytes.copyFrom(new byte[0]));
    }

    private byte[] s2v(final byte[]... s) throws GeneralSecurityException {
        byte[] xor;
        if (s.length == 0) {
            return this.cmacForS2V.compute(BLOCK_ONE, 16);
        }
        byte[] compute = this.cmacForS2V.compute(BLOCK_ZERO, 16);
        for (int i = 0; i < s.length - 1; i++) {
            byte[] bArr = s[i];
            if (bArr == null) {
                bArr = new byte[0];
            }
            compute = Bytes.xor(AesUtil.dbl(compute), this.cmacForS2V.compute(bArr, 16));
        }
        byte[] bArr2 = s[s.length - 1];
        if (bArr2.length >= 16) {
            xor = Bytes.xorEnd(bArr2, compute);
        } else {
            xor = Bytes.xor(AesUtil.cmacPad(bArr2), AesUtil.dbl(compute));
        }
        return this.cmacForS2V.compute(xor, 16);
    }

    @Override // com.google.crypto.tink.DeterministicAead
    public byte[] encryptDeterministically(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        if (plaintext.length > 2147483631 - this.outputPrefix.length) {
            throw new GeneralSecurityException("plaintext too long");
        }
        Cipher cipher = localAesCtrCipher.get();
        byte[] s2v = s2v(associatedData, plaintext);
        byte[] bArr = (byte[]) s2v.clone();
        bArr[8] = (byte) (bArr[8] & ByteCompanionObject.MAX_VALUE);
        bArr[12] = (byte) (bArr[12] & ByteCompanionObject.MAX_VALUE);
        cipher.init(1, new SecretKeySpec(this.aesCtrKey, "AES"), new IvParameterSpec(bArr));
        byte[] bArr2 = this.outputPrefix;
        byte[] copyOf = Arrays.copyOf(bArr2, bArr2.length + s2v.length + plaintext.length);
        System.arraycopy(s2v, 0, copyOf, this.outputPrefix.length, s2v.length);
        if (cipher.doFinal(plaintext, 0, plaintext.length, copyOf, this.outputPrefix.length + s2v.length) == plaintext.length) {
            return copyOf;
        }
        throw new GeneralSecurityException("not enough data written");
    }

    @Override // com.google.crypto.tink.DeterministicAead
    public byte[] decryptDeterministically(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        int length = ciphertext.length;
        byte[] bArr = this.outputPrefix;
        if (length < bArr.length + 16) {
            throw new GeneralSecurityException("Ciphertext too short.");
        }
        if (!Util.isPrefix(bArr, ciphertext)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        Cipher cipher = localAesCtrCipher.get();
        byte[] bArr2 = this.outputPrefix;
        byte[] copyOfRange = Arrays.copyOfRange(ciphertext, bArr2.length, bArr2.length + 16);
        byte[] bArr3 = (byte[]) copyOfRange.clone();
        bArr3[8] = (byte) (bArr3[8] & ByteCompanionObject.MAX_VALUE);
        bArr3[12] = (byte) (bArr3[12] & ByteCompanionObject.MAX_VALUE);
        cipher.init(2, new SecretKeySpec(this.aesCtrKey, "AES"), new IvParameterSpec(bArr3));
        int length2 = this.outputPrefix.length + 16;
        int length3 = ciphertext.length - length2;
        byte[] doFinal = cipher.doFinal(ciphertext, length2, length3);
        if (length3 == 0 && doFinal == null && SubtleUtil.isAndroid()) {
            doFinal = new byte[0];
        }
        if (Bytes.equal(copyOfRange, s2v(associatedData, doFinal))) {
            return doFinal;
        }
        throw new AEADBadTagException("Integrity check failed.");
    }
}
