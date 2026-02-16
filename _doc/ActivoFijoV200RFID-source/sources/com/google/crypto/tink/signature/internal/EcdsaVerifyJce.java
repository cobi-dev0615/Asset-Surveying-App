package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.ConscryptUtil;
import com.google.crypto.tink.internal.EnumTypeProtoConverter;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.signature.EcdsaParameters;
import com.google.crypto.tink.signature.EcdsaPublicKey;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.Enums;
import com.google.crypto.tink.subtle.SubtleUtil;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Signature;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPublicKeySpec;
import java.util.Arrays;

@Immutable
/* loaded from: classes2.dex */
public final class EcdsaVerifyJce implements PublicKeyVerify {
    private final EllipticCurves.EcdsaEncoding encoding;
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;
    private final Provider provider;
    private final ECPublicKey publicKey;
    private final String signatureAlgorithm;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final byte[] EMPTY = new byte[0];
    private static final byte[] legacyMessageSuffix = {0};
    static final EnumTypeProtoConverter<Enums.HashType, EcdsaParameters.HashType> HASH_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(Enums.HashType.SHA256, EcdsaParameters.HashType.SHA256).add(Enums.HashType.SHA384, EcdsaParameters.HashType.SHA384).add(Enums.HashType.SHA512, EcdsaParameters.HashType.SHA512).build();
    static final EnumTypeProtoConverter<EllipticCurves.EcdsaEncoding, EcdsaParameters.SignatureEncoding> ENCODING_CONVERTER = EnumTypeProtoConverter.builder().add(EllipticCurves.EcdsaEncoding.IEEE_P1363, EcdsaParameters.SignatureEncoding.IEEE_P1363).add(EllipticCurves.EcdsaEncoding.DER, EcdsaParameters.SignatureEncoding.DER).build();
    static final EnumTypeProtoConverter<EllipticCurves.CurveType, EcdsaParameters.CurveType> CURVE_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(EllipticCurves.CurveType.NIST_P256, EcdsaParameters.CurveType.NIST_P256).add(EllipticCurves.CurveType.NIST_P384, EcdsaParameters.CurveType.NIST_P384).add(EllipticCurves.CurveType.NIST_P521, EcdsaParameters.CurveType.NIST_P521).build();

    public static PublicKeyVerify create(EcdsaPublicKey key) throws GeneralSecurityException {
        KeyFactory engineFactory;
        byte[] bArr;
        Provider providerOrNull = ConscryptUtil.providerOrNull();
        ECPublicKeySpec eCPublicKeySpec = new ECPublicKeySpec(key.getPublicPoint(), EllipticCurves.getCurveSpec(CURVE_TYPE_CONVERTER.toProtoEnum(key.getParameters().getCurveType())));
        if (providerOrNull == null) {
            engineFactory = EngineFactory.KEY_FACTORY.getInstance("EC");
        } else {
            engineFactory = KeyFactory.getInstance("EC", providerOrNull);
        }
        ECPublicKey eCPublicKey = (ECPublicKey) engineFactory.generatePublic(eCPublicKeySpec);
        Enums.HashType protoEnum = HASH_TYPE_CONVERTER.toProtoEnum(key.getParameters().getHashType());
        EllipticCurves.EcdsaEncoding protoEnum2 = ENCODING_CONVERTER.toProtoEnum(key.getParameters().getSignatureEncoding());
        byte[] byteArray = key.getOutputPrefix().toByteArray();
        if (key.getParameters().getVariant().equals(EcdsaParameters.Variant.LEGACY)) {
            bArr = legacyMessageSuffix;
        } else {
            bArr = EMPTY;
        }
        return new EcdsaVerifyJce(eCPublicKey, protoEnum, protoEnum2, byteArray, bArr, providerOrNull);
    }

    private EcdsaVerifyJce(final ECPublicKey publicKey, Enums.HashType hash, EllipticCurves.EcdsaEncoding encoding, byte[] outputPrefix, byte[] messageSuffix, Provider provider) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use ECDSA in FIPS-mode, as BoringCrypto is not available.");
        }
        this.signatureAlgorithm = SubtleUtil.toEcdsaAlgo(hash);
        this.publicKey = publicKey;
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
    public EcdsaVerifyJce(final java.security.interfaces.ECPublicKey r8, com.google.crypto.tink.subtle.Enums.HashType r9, com.google.crypto.tink.subtle.EllipticCurves.EcdsaEncoding r10) throws java.security.GeneralSecurityException {
        /*
            r7 = this;
            byte[] r5 = com.google.crypto.tink.signature.internal.EcdsaVerifyJce.EMPTY
            java.security.Provider r6 = com.google.crypto.tink.internal.ConscryptUtil.providerOrNull()
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r5
            r0.<init>(r1, r2, r3, r4, r5, r6)
            java.security.spec.ECPoint r9 = r8.getW()
            java.security.spec.ECParameterSpec r8 = r8.getParams()
            java.security.spec.EllipticCurve r8 = r8.getCurve()
            com.google.crypto.tink.internal.EllipticCurvesUtil.checkPointOnCurve(r9, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.signature.internal.EcdsaVerifyJce.<init>(java.security.interfaces.ECPublicKey, com.google.crypto.tink.subtle.Enums$HashType, com.google.crypto.tink.subtle.EllipticCurves$EcdsaEncoding):void");
    }

    private Signature getInstance(String signatureAlgorithm) throws GeneralSecurityException {
        Provider provider = this.provider;
        if (provider != null) {
            return Signature.getInstance(signatureAlgorithm, provider);
        }
        return EngineFactory.SIGNATURE.getInstance(signatureAlgorithm);
    }

    private void noPrefixVerify(final byte[] signature, final byte[] data) throws GeneralSecurityException {
        boolean z;
        if (this.encoding == EllipticCurves.EcdsaEncoding.IEEE_P1363) {
            if (signature.length != EllipticCurves.fieldSizeInBytes(this.publicKey.getParams().getCurve()) * 2) {
                throw new GeneralSecurityException("Invalid signature");
            }
            signature = EllipticCurves.ecdsaIeee2Der(signature);
        }
        if (!EllipticCurves.isValidDerEncoding(signature)) {
            throw new GeneralSecurityException("Invalid signature");
        }
        Signature ecdsaVerifyJce = getInstance(this.signatureAlgorithm);
        ecdsaVerifyJce.initVerify(this.publicKey);
        ecdsaVerifyJce.update(data);
        byte[] bArr = this.messageSuffix;
        if (bArr.length > 0) {
            ecdsaVerifyJce.update(bArr);
        }
        try {
            z = ecdsaVerifyJce.verify(signature);
        } catch (RuntimeException unused) {
            z = false;
        }
        if (!z) {
            throw new GeneralSecurityException("Invalid signature");
        }
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(final byte[] signature, final byte[] data) throws GeneralSecurityException {
        byte[] bArr = this.outputPrefix;
        if (bArr.length == 0) {
            noPrefixVerify(signature, data);
        } else {
            if (!Util.isPrefix(bArr, signature)) {
                throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
            }
            noPrefixVerify(Arrays.copyOfRange(signature, this.outputPrefix.length, signature.length), data);
        }
    }
}
