package com.google.crypto.tink.subtle;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.signature.RsaSsaPkcs1Parameters;
import com.google.crypto.tink.signature.RsaSsaPkcs1PrivateKey;
import com.google.crypto.tink.subtle.Enums;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;

@Immutable
/* loaded from: classes3.dex */
public final class RsaSsaPkcs1SignJce implements PublicKeySign {
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;
    private final RSAPrivateCrtKey privateKey;
    private final RSAPublicKey publicKey;
    private final String signatureAlgorithm;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final byte[] EMPTY = new byte[0];
    private static final byte[] LEGACY_MESSAGE_SUFFIX = {0};
    private static final byte[] TEST_DATA = {1, 2, 3};

    private RsaSsaPkcs1SignJce(final RSAPrivateCrtKey priv, Enums.HashType hash, byte[] outputPrefix, byte[] messageSuffix) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use RSA PKCS1.5 in FIPS-mode, as BoringCrypto module is not available.");
        }
        Validators.validateSignatureHash(hash);
        Validators.validateRsaModulusSize(priv.getModulus().bitLength());
        Validators.validateRsaPublicExponent(priv.getPublicExponent());
        this.privateKey = priv;
        this.signatureAlgorithm = SubtleUtil.toRsaSsaPkcs1Algo(hash);
        this.publicKey = (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(priv.getModulus(), priv.getPublicExponent()));
        this.outputPrefix = outputPrefix;
        this.messageSuffix = messageSuffix;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public RsaSsaPkcs1SignJce(final java.security.interfaces.RSAPrivateCrtKey r2, com.google.crypto.tink.subtle.Enums.HashType r3) throws java.security.GeneralSecurityException {
        /*
            r1 = this;
            byte[] r0 = com.google.crypto.tink.subtle.RsaSsaPkcs1SignJce.EMPTY
            r1.<init>(r2, r3, r0, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.RsaSsaPkcs1SignJce.<init>(java.security.interfaces.RSAPrivateCrtKey, com.google.crypto.tink.subtle.Enums$HashType):void");
    }

    public static PublicKeySign create(RsaSsaPkcs1PrivateKey key) throws GeneralSecurityException {
        byte[] bArr;
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePrivate(new RSAPrivateCrtKeySpec(key.getPublicKey().getModulus(), key.getParameters().getPublicExponent(), key.getPrivateExponent().getBigInteger(InsecureSecretKeyAccess.get()), key.getPrimeP().getBigInteger(InsecureSecretKeyAccess.get()), key.getPrimeQ().getBigInteger(InsecureSecretKeyAccess.get()), key.getPrimeExponentP().getBigInteger(InsecureSecretKeyAccess.get()), key.getPrimeExponentQ().getBigInteger(InsecureSecretKeyAccess.get()), key.getCrtCoefficient().getBigInteger(InsecureSecretKeyAccess.get())));
        Enums.HashType protoEnum = RsaSsaPkcs1VerifyJce.HASH_TYPE_CONVERTER.toProtoEnum(key.getParameters().getHashType());
        byte[] byteArray = key.getOutputPrefix().toByteArray();
        if (key.getParameters().getVariant().equals(RsaSsaPkcs1Parameters.Variant.LEGACY)) {
            bArr = LEGACY_MESSAGE_SUFFIX;
        } else {
            bArr = EMPTY;
        }
        RsaSsaPkcs1SignJce rsaSsaPkcs1SignJce = new RsaSsaPkcs1SignJce(rSAPrivateCrtKey, protoEnum, byteArray, bArr);
        PublicKeyVerify create = RsaSsaPkcs1VerifyJce.create(key.getPublicKey());
        try {
            byte[] bArr2 = TEST_DATA;
            create.verify(rsaSsaPkcs1SignJce.sign(bArr2), bArr2);
            return rsaSsaPkcs1SignJce;
        } catch (GeneralSecurityException e) {
            throw new GeneralSecurityException("RsaSsaPkcs1 signing with private key followed by verifying with public key failed. The key may be corrupted.", e);
        }
    }

    private byte[] noPrefixSign(final byte[] data) throws GeneralSecurityException {
        Signature engineFactory = EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm);
        engineFactory.initSign(this.privateKey);
        engineFactory.update(data);
        byte[] bArr = this.messageSuffix;
        if (bArr.length > 0) {
            engineFactory.update(bArr);
        }
        byte[] sign = engineFactory.sign();
        Signature engineFactory2 = EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm);
        engineFactory2.initVerify(this.publicKey);
        engineFactory2.update(data);
        byte[] bArr2 = this.messageSuffix;
        if (bArr2.length > 0) {
            engineFactory2.update(bArr2);
        }
        if (engineFactory2.verify(sign)) {
            return sign;
        }
        throw new IllegalStateException("Security bug: RSA signature computation error");
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(final byte[] data) throws GeneralSecurityException {
        byte[] noPrefixSign = noPrefixSign(data);
        byte[] bArr = this.outputPrefix;
        return bArr.length == 0 ? noPrefixSign : Bytes.concat(bArr, noPrefixSign);
    }
}
