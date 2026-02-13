package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.internal.EnumTypeProtoConverter;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.RsaSsaPkcs1KeyFormat;
import com.google.crypto.tink.proto.RsaSsaPkcs1Params;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.signature.RsaSsaPkcs1Parameters;
import com.google.crypto.tink.signature.RsaSsaPkcs1PrivateKey;
import com.google.crypto.tink.signature.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBigInteger;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class RsaSsaPkcs1ProtoSerialization {
    private static final EnumTypeProtoConverter<HashType, RsaSsaPkcs1Parameters.HashType> HASH_TYPE_CONVERTER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<RsaSsaPkcs1Parameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final KeyParser<ProtoKeySerialization> PRIVATE_KEY_PARSER;
    private static final KeySerializer<RsaSsaPkcs1PrivateKey, ProtoKeySerialization> PRIVATE_KEY_SERIALIZER;
    private static final String PRIVATE_TYPE_URL = "type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PrivateKey";
    private static final Bytes PRIVATE_TYPE_URL_BYTES;
    private static final KeyParser<ProtoKeySerialization> PUBLIC_KEY_PARSER;
    private static final KeySerializer<RsaSsaPkcs1PublicKey, ProtoKeySerialization> PUBLIC_KEY_SERIALIZER;
    private static final String PUBLIC_TYPE_URL = "type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PublicKey";
    private static final Bytes PUBLIC_TYPE_URL_BYTES;
    private static final EnumTypeProtoConverter<OutputPrefixType, RsaSsaPkcs1Parameters.Variant> VARIANT_CONVERTER;

    static {
        Bytes bytesFromPrintableAscii = Util.toBytesFromPrintableAscii(PRIVATE_TYPE_URL);
        PRIVATE_TYPE_URL_BYTES = bytesFromPrintableAscii;
        Bytes bytesFromPrintableAscii2 = Util.toBytesFromPrintableAscii(PUBLIC_TYPE_URL);
        PUBLIC_TYPE_URL_BYTES = bytesFromPrintableAscii2;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.signature.internal.RsaSsaPkcs1ProtoSerialization$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                ProtoParametersSerialization serializeParameters;
                serializeParameters = RsaSsaPkcs1ProtoSerialization.serializeParameters((RsaSsaPkcs1Parameters) parameters);
                return serializeParameters;
            }
        }, RsaSsaPkcs1Parameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.signature.internal.RsaSsaPkcs1ProtoSerialization$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                RsaSsaPkcs1Parameters parseParameters;
                parseParameters = RsaSsaPkcs1ProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
                return parseParameters;
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        PUBLIC_KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.signature.internal.RsaSsaPkcs1ProtoSerialization$$ExternalSyntheticLambda2
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                ProtoKeySerialization serializePublicKey;
                serializePublicKey = RsaSsaPkcs1ProtoSerialization.serializePublicKey((RsaSsaPkcs1PublicKey) key, secretKeyAccess);
                return serializePublicKey;
            }
        }, RsaSsaPkcs1PublicKey.class, ProtoKeySerialization.class);
        PUBLIC_KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.signature.internal.RsaSsaPkcs1ProtoSerialization$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                RsaSsaPkcs1PublicKey parsePublicKey;
                parsePublicKey = RsaSsaPkcs1ProtoSerialization.parsePublicKey((ProtoKeySerialization) serialization, secretKeyAccess);
                return parsePublicKey;
            }
        }, bytesFromPrintableAscii2, ProtoKeySerialization.class);
        PRIVATE_KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.signature.internal.RsaSsaPkcs1ProtoSerialization$$ExternalSyntheticLambda4
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                ProtoKeySerialization serializePrivateKey;
                serializePrivateKey = RsaSsaPkcs1ProtoSerialization.serializePrivateKey((RsaSsaPkcs1PrivateKey) key, secretKeyAccess);
                return serializePrivateKey;
            }
        }, RsaSsaPkcs1PrivateKey.class, ProtoKeySerialization.class);
        PRIVATE_KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.signature.internal.RsaSsaPkcs1ProtoSerialization$$ExternalSyntheticLambda5
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                RsaSsaPkcs1PrivateKey parsePrivateKey;
                parsePrivateKey = RsaSsaPkcs1ProtoSerialization.parsePrivateKey((ProtoKeySerialization) serialization, secretKeyAccess);
                return parsePrivateKey;
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
        VARIANT_CONVERTER = EnumTypeProtoConverter.builder().add(OutputPrefixType.RAW, RsaSsaPkcs1Parameters.Variant.NO_PREFIX).add(OutputPrefixType.TINK, RsaSsaPkcs1Parameters.Variant.TINK).add(OutputPrefixType.CRUNCHY, RsaSsaPkcs1Parameters.Variant.CRUNCHY).add(OutputPrefixType.LEGACY, RsaSsaPkcs1Parameters.Variant.LEGACY).build();
        HASH_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(HashType.SHA256, RsaSsaPkcs1Parameters.HashType.SHA256).add(HashType.SHA384, RsaSsaPkcs1Parameters.HashType.SHA384).add(HashType.SHA512, RsaSsaPkcs1Parameters.HashType.SHA512).build();
    }

    private static RsaSsaPkcs1Params getProtoParams(RsaSsaPkcs1Parameters parameters) throws GeneralSecurityException {
        return (RsaSsaPkcs1Params) RsaSsaPkcs1Params.newBuilder().setHashType(HASH_TYPE_CONVERTER.toProtoEnum(parameters.getHashType())).build();
    }

    private static ByteString encodeBigInteger(BigInteger i) {
        return ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytes(i));
    }

    private static com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey getProtoPublicKey(RsaSsaPkcs1PublicKey key) throws GeneralSecurityException {
        return (com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey) com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey.newBuilder().setParams(getProtoParams(key.getParameters())).setN(encodeBigInteger(key.getModulus())).setE(encodeBigInteger(key.getParameters().getPublicExponent())).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(RsaSsaPkcs1Parameters parameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(PRIVATE_TYPE_URL).setValue(((RsaSsaPkcs1KeyFormat) RsaSsaPkcs1KeyFormat.newBuilder().setParams(getProtoParams(parameters)).setModulusSizeInBits(parameters.getModulusSizeBits()).setPublicExponent(encodeBigInteger(parameters.getPublicExponent())).build()).toByteString()).setOutputPrefixType(VARIANT_CONVERTER.toProtoEnum(parameters.getVariant())).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializePublicKey(RsaSsaPkcs1PublicKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PUBLIC_TYPE_URL, getProtoPublicKey(key).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, VARIANT_CONVERTER.toProtoEnum(key.getParameters().getVariant()), key.getIdRequirementOrNull());
    }

    private static ByteString encodeSecretBigInteger(SecretBigInteger i, SecretKeyAccess access) {
        return encodeBigInteger(i.getBigInteger(access));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializePrivateKey(RsaSsaPkcs1PrivateKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        SecretKeyAccess requireAccess = SecretKeyAccess.requireAccess(access);
        return ProtoKeySerialization.create(PRIVATE_TYPE_URL, ((com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKey) com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKey.newBuilder().setVersion(0).setPublicKey(getProtoPublicKey(key.getPublicKey())).setD(encodeSecretBigInteger(key.getPrivateExponent(), requireAccess)).setP(encodeSecretBigInteger(key.getPrimeP(), requireAccess)).setQ(encodeSecretBigInteger(key.getPrimeQ(), requireAccess)).setDp(encodeSecretBigInteger(key.getPrimeExponentP(), requireAccess)).setDq(encodeSecretBigInteger(key.getPrimeExponentQ(), requireAccess)).setCrt(encodeSecretBigInteger(key.getCrtCoefficient(), requireAccess)).build()).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE, VARIANT_CONVERTER.toProtoEnum(key.getParameters().getVariant()), key.getIdRequirementOrNull());
    }

    private static BigInteger decodeBigInteger(ByteString data) {
        return BigIntegerEncoding.fromUnsignedBigEndianBytes(data.toByteArray());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RsaSsaPkcs1Parameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (!serialization.getKeyTemplate().getTypeUrl().equals(PRIVATE_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to RsaSsaPkcs1ProtoSerialization.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
        }
        try {
            RsaSsaPkcs1KeyFormat parseFrom = RsaSsaPkcs1KeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());
            return RsaSsaPkcs1Parameters.builder().setHashType(HASH_TYPE_CONVERTER.fromProtoEnum(parseFrom.getParams().getHashType())).setPublicExponent(decodeBigInteger(parseFrom.getPublicExponent())).setModulusSizeBits(parseFrom.getModulusSizeInBits()).setVariant(VARIANT_CONVERTER.fromProtoEnum(serialization.getKeyTemplate().getOutputPrefixType())).build();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Parsing RsaSsaPkcs1Parameters failed: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RsaSsaPkcs1PublicKey parsePublicKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (!serialization.getTypeUrl().equals(PUBLIC_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to RsaSsaPkcs1ProtoSerialization.parsePublicKey: " + serialization.getTypeUrl());
        }
        try {
            com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey parseFrom = com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (parseFrom.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            BigInteger decodeBigInteger = decodeBigInteger(parseFrom.getN());
            return RsaSsaPkcs1PublicKey.builder().setParameters(RsaSsaPkcs1Parameters.builder().setHashType(HASH_TYPE_CONVERTER.fromProtoEnum(parseFrom.getParams().getHashType())).setPublicExponent(decodeBigInteger(parseFrom.getE())).setModulusSizeBits(decodeBigInteger.bitLength()).setVariant(VARIANT_CONVERTER.fromProtoEnum(serialization.getOutputPrefixType())).build()).setModulus(decodeBigInteger).setIdRequirement(serialization.getIdRequirementOrNull()).build();
        } catch (InvalidProtocolBufferException | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing RsaSsaPkcs1PublicKey failed");
        }
    }

    private static SecretBigInteger decodeSecretBigInteger(ByteString data, SecretKeyAccess access) {
        return SecretBigInteger.fromBigInteger(BigIntegerEncoding.fromUnsignedBigEndianBytes(data.toByteArray()), access);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RsaSsaPkcs1PrivateKey parsePrivateKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (!serialization.getTypeUrl().equals(PRIVATE_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to RsaSsaPkcs1ProtoSerialization.parsePrivateKey: " + serialization.getTypeUrl());
        }
        try {
            com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKey parseFrom = com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (parseFrom.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey publicKey = parseFrom.getPublicKey();
            if (publicKey.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            BigInteger decodeBigInteger = decodeBigInteger(publicKey.getN());
            RsaSsaPkcs1PublicKey build = RsaSsaPkcs1PublicKey.builder().setParameters(RsaSsaPkcs1Parameters.builder().setHashType(HASH_TYPE_CONVERTER.fromProtoEnum(publicKey.getParams().getHashType())).setPublicExponent(decodeBigInteger(publicKey.getE())).setModulusSizeBits(decodeBigInteger.bitLength()).setVariant(VARIANT_CONVERTER.fromProtoEnum(serialization.getOutputPrefixType())).build()).setModulus(decodeBigInteger).setIdRequirement(serialization.getIdRequirementOrNull()).build();
            SecretKeyAccess requireAccess = SecretKeyAccess.requireAccess(access);
            return RsaSsaPkcs1PrivateKey.builder().setPublicKey(build).setPrimes(decodeSecretBigInteger(parseFrom.getP(), requireAccess), decodeSecretBigInteger(parseFrom.getQ(), requireAccess)).setPrivateExponent(decodeSecretBigInteger(parseFrom.getD(), requireAccess)).setPrimeExponents(decodeSecretBigInteger(parseFrom.getDp(), requireAccess), decodeSecretBigInteger(parseFrom.getDq(), requireAccess)).setCrtCoefficient(decodeSecretBigInteger(parseFrom.getCrt(), requireAccess)).build();
        } catch (InvalidProtocolBufferException | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing RsaSsaPkcs1PrivateKey failed");
        }
    }

    public static void register() throws GeneralSecurityException {
        register(MutableSerializationRegistry.globalInstance());
    }

    public static void register(MutableSerializationRegistry registry) throws GeneralSecurityException {
        registry.registerParametersSerializer(PARAMETERS_SERIALIZER);
        registry.registerParametersParser(PARAMETERS_PARSER);
        registry.registerKeySerializer(PUBLIC_KEY_SERIALIZER);
        registry.registerKeyParser(PUBLIC_KEY_PARSER);
        registry.registerKeySerializer(PRIVATE_KEY_SERIALIZER);
        registry.registerKeyParser(PRIVATE_KEY_PARSER);
    }

    private RsaSsaPkcs1ProtoSerialization() {
    }
}
