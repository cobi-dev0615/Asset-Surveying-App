package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.ConscryptUtil;
import com.google.crypto.tink.signature.EcdsaParameters;
import com.google.crypto.tink.signature.EcdsaPrivateKey;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.Enums;
import com.google.crypto.tink.subtle.SubtleUtil;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

@Immutable
/* loaded from: classes2.dex */
public final class EcdsaSignJce implements PublicKeySign {
    private final EllipticCurves.EcdsaEncoding encoding;
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;
    private final ECPrivateKey privateKey;
    private final Provider provider;
    private final String signatureAlgorithm;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final byte[] EMPTY = new byte[0];
    private static final byte[] legacyMessageSuffix = {0};

    private EcdsaSignJce(final ECPrivateKey privateKey, Enums.HashType hash, EllipticCurves.EcdsaEncoding encoding, byte[] outputPrefix, byte[] messageSuffix, Provider provider) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use ECDSA in FIPS-mode, as BoringCrypto is not available.");
        }
        this.privateKey = privateKey;
        this.signatureAlgorithm = SubtleUtil.toEcdsaAlgo(hash);
        this.encoding = encoding;
        this.outputPrefix = outputPrefix;
        this.messageSuffix = messageSuffix;
        this.provider = provider;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public EcdsaSignJce(final java.security.interfaces.ECPrivateKey r8, com.google.crypto.tink.subtle.Enums.HashType r9, com.google.crypto.tink.subtle.EllipticCurves.EcdsaEncoding r10) throws java.security.GeneralSecurityException {
        /*
            r7 = this;
            byte[] r5 = com.google.crypto.tink.signature.internal.EcdsaSignJce.EMPTY
            java.security.Provider r6 = com.google.crypto.tink.internal.ConscryptUtil.providerOrNull()
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r5
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.signature.internal.EcdsaSignJce.<init>(java.security.interfaces.ECPrivateKey, com.google.crypto.tink.subtle.Enums$HashType, com.google.crypto.tink.subtle.EllipticCurves$EcdsaEncoding):void");
    }

    public static PublicKeySign create(EcdsaPrivateKey key) throws GeneralSecurityException {
        KeyFactory engineFactory;
        byte[] bArr;
        Enums.HashType protoEnum = EcdsaVerifyJce.HASH_TYPE_CONVERTER.toProtoEnum(key.getParameters().getHashType());
        EllipticCurves.EcdsaEncoding protoEnum2 = EcdsaVerifyJce.ENCODING_CONVERTER.toProtoEnum(key.getParameters().getSignatureEncoding());
        EllipticCurves.CurveType protoEnum3 = EcdsaVerifyJce.CURVE_TYPE_CONVERTER.toProtoEnum(key.getParameters().getCurveType());
        Provider providerOrNull = ConscryptUtil.providerOrNull();
        ECPrivateKeySpec eCPrivateKeySpec = new ECPrivateKeySpec(key.getPrivateValue().getBigInteger(InsecureSecretKeyAccess.get()), EllipticCurves.getCurveSpec(protoEnum3));
        if (providerOrNull == null) {
            engineFactory = EngineFactory.KEY_FACTORY.getInstance("EC");
        } else {
            engineFactory = KeyFactory.getInstance("EC", providerOrNull);
        }
        ECPrivateKey eCPrivateKey = (ECPrivateKey) engineFactory.generatePrivate(eCPrivateKeySpec);
        byte[] byteArray = key.getOutputPrefix().toByteArray();
        if (key.getParameters().getVariant().equals(EcdsaParameters.Variant.LEGACY)) {
            bArr = legacyMessageSuffix;
        } else {
            bArr = EMPTY;
        }
        return new EcdsaSignJce(eCPrivateKey, protoEnum, protoEnum2, byteArray, bArr, providerOrNull);
    }

    private Signature getInstance(String signatureAlgorithm) throws GeneralSecurityException {
        Provider provider = this.provider;
        if (provider != null) {
            return Signature.getInstance(signatureAlgorithm, provider);
        }
        return EngineFactory.SIGNATURE.getInstance(signatureAlgorithm);
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(final byte[] data) throws GeneralSecurityException {
        Signature ecdsaSignJce = getInstance(this.signatureAlgorithm);
        ecdsaSignJce.initSign(this.privateKey);
        ecdsaSignJce.update(data);
        byte[] bArr = this.messageSuffix;
        if (bArr.length > 0) {
            ecdsaSignJce.update(bArr);
        }
        byte[] sign = ecdsaSignJce.sign();
        if (this.encoding == EllipticCurves.EcdsaEncoding.IEEE_P1363) {
            sign = EllipticCurves.ecdsaDer2Ieee(sign, EllipticCurves.fieldSizeInBytes(this.privateKey.getParams().getCurve()) * 2);
        }
        byte[] bArr2 = this.outputPrefix;
        return bArr2.length == 0 ? sign : Bytes.concat(bArr2, sign);
    }
}
