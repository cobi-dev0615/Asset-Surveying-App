package com.google.crypto.tink.keyderivation.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.TinkProtoParametersFormat;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.keyderivation.PrfBasedKeyDerivationKey;
import com.google.crypto.tink.keyderivation.PrfBasedKeyDerivationParameters;
import com.google.crypto.tink.prf.PrfKey;
import com.google.crypto.tink.prf.PrfParameters;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.PrfBasedDeriverKey;
import com.google.crypto.tink.proto.PrfBasedDeriverKeyFormat;
import com.google.crypto.tink.proto.PrfBasedDeriverParams;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
final class PrfBasedKeyDerivationKeyProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER;
    private static final KeySerializer<PrfBasedKeyDerivationKey, ProtoKeySerialization> KEY_SERIALIZER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<PrfBasedKeyDerivationParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.PrfBasedDeriverKey";
    private static final Bytes TYPE_URL_BYTES;

    static {
        Bytes bytesFromPrintableAscii = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = bytesFromPrintableAscii;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.keyderivation.internal.PrfBasedKeyDerivationKeyProtoSerialization$$ExternalSyntheticLambda0
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                ProtoParametersSerialization serializeParameters;
                serializeParameters = PrfBasedKeyDerivationKeyProtoSerialization.serializeParameters((PrfBasedKeyDerivationParameters) parameters);
                return serializeParameters;
            }
        }, PrfBasedKeyDerivationParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.keyderivation.internal.PrfBasedKeyDerivationKeyProtoSerialization$$ExternalSyntheticLambda1
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                PrfBasedKeyDerivationParameters parseParameters;
                parseParameters = PrfBasedKeyDerivationKeyProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
                return parseParameters;
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.keyderivation.internal.PrfBasedKeyDerivationKeyProtoSerialization$$ExternalSyntheticLambda2
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                ProtoKeySerialization serializeKey;
                serializeKey = PrfBasedKeyDerivationKeyProtoSerialization.serializeKey((PrfBasedKeyDerivationKey) key, secretKeyAccess);
                return serializeKey;
            }
        }, PrfBasedKeyDerivationKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.keyderivation.internal.PrfBasedKeyDerivationKeyProtoSerialization$$ExternalSyntheticLambda3
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                PrfBasedKeyDerivationKey parseKey;
                parseKey = PrfBasedKeyDerivationKeyProtoSerialization.parseKey((ProtoKeySerialization) serialization, secretKeyAccess);
                return parseKey;
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PrfBasedKeyDerivationParameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (!serialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to PrfBasedKeyDerivationKeyProtoSerialization.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
        }
        try {
            PrfBasedDeriverKeyFormat parseFrom = PrfBasedDeriverKeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());
            Parameters parse = TinkProtoParametersFormat.parse(parseFrom.getParams().getDerivedKeyTemplate().toByteArray());
            Parameters parse2 = TinkProtoParametersFormat.parse(parseFrom.getPrfKeyTemplate().toByteArray());
            if (!(parse2 instanceof PrfParameters)) {
                throw new GeneralSecurityException("Non-PRF parameters stored in the field prf_key_template");
            }
            if (serialization.getKeyTemplate().getOutputPrefixType() != parseFrom.getParams().getDerivedKeyTemplate().getOutputPrefixType()) {
                throw new GeneralSecurityException("Output-Prefix mismatch in parameters while parsing " + parseFrom);
            }
            return PrfBasedKeyDerivationParameters.builder().setPrfParameters((PrfParameters) parse2).setDerivedKeyParameters(parse).build();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Parsing PrfBasedDeriverKeyFormat failed: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(PrfBasedKeyDerivationParameters parameters) throws GeneralSecurityException {
        try {
            KeyTemplate parseFrom = KeyTemplate.parseFrom(TinkProtoParametersFormat.serialize(parameters.getPrfParameters()), ExtensionRegistryLite.getEmptyRegistry());
            KeyTemplate parseFrom2 = KeyTemplate.parseFrom(TinkProtoParametersFormat.serialize(parameters.getDerivedKeyParameters()), ExtensionRegistryLite.getEmptyRegistry());
            return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(((PrfBasedDeriverKeyFormat) PrfBasedDeriverKeyFormat.newBuilder().setPrfKeyTemplate(parseFrom).setParams(PrfBasedDeriverParams.newBuilder().setDerivedKeyTemplate(parseFrom2)).build()).toByteString()).setOutputPrefixType(parseFrom2.getOutputPrefixType()).build());
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Serializing PrfBasedKeyDerivationParameters failed: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializeKey(PrfBasedKeyDerivationKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        ProtoKeySerialization protoKeySerialization = (ProtoKeySerialization) MutableSerializationRegistry.globalInstance().serializeKey(key.getPrfKey(), ProtoKeySerialization.class, access);
        ProtoParametersSerialization protoParametersSerialization = (ProtoParametersSerialization) MutableSerializationRegistry.globalInstance().serializeParameters(key.getParameters().getDerivedKeyParameters(), ProtoParametersSerialization.class);
        return ProtoKeySerialization.create(TYPE_URL, ((PrfBasedDeriverKey) PrfBasedDeriverKey.newBuilder().setPrfKey(KeyData.newBuilder().setValue(protoKeySerialization.getValue()).setTypeUrl(protoKeySerialization.getTypeUrl()).setKeyMaterialType(protoKeySerialization.getKeyMaterialType())).setParams(PrfBasedDeriverParams.newBuilder().setDerivedKeyTemplate(protoParametersSerialization.getKeyTemplate())).build()).toByteString(), KeyData.KeyMaterialType.SYMMETRIC, protoParametersSerialization.getKeyTemplate().getOutputPrefixType(), key.getIdRequirementOrNull());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PrfBasedKeyDerivationKey parseKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (!serialization.getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to PrfBasedKeyDerivationKey.parseKey");
        }
        try {
            PrfBasedDeriverKey parseFrom = PrfBasedDeriverKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            Key parseKey = MutableSerializationRegistry.globalInstance().parseKey(ProtoKeySerialization.create(parseFrom.getPrfKey().getTypeUrl(), parseFrom.getPrfKey().getValue(), parseFrom.getPrfKey().getKeyMaterialType(), OutputPrefixType.RAW, null), access);
            if (!(parseKey instanceof PrfKey)) {
                throw new GeneralSecurityException("Non-PRF key stored in the field prf_key");
            }
            PrfKey prfKey = (PrfKey) parseKey;
            ProtoParametersSerialization checkedCreate = ProtoParametersSerialization.checkedCreate(parseFrom.getParams().getDerivedKeyTemplate());
            PrfBasedKeyDerivationParameters build = PrfBasedKeyDerivationParameters.builder().setDerivedKeyParameters(MutableSerializationRegistry.globalInstance().parseParameters(checkedCreate)).setPrfParameters(prfKey.getParameters()).build();
            if (serialization.getOutputPrefixType() != checkedCreate.getKeyTemplate().getOutputPrefixType()) {
                throw new GeneralSecurityException("Output-Prefix mismatch in parameters while parsing PrfBasedKeyDerivationKey with parameters " + build);
            }
            return PrfBasedKeyDerivationKey.create(build, prfKey, serialization.getIdRequirementOrNull());
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
        }
    }

    public static void register() throws GeneralSecurityException {
        register(MutableSerializationRegistry.globalInstance());
    }

    public static void register(MutableSerializationRegistry registry) throws GeneralSecurityException {
        registry.registerParametersSerializer(PARAMETERS_SERIALIZER);
        registry.registerParametersParser(PARAMETERS_PARSER);
        registry.registerKeySerializer(KEY_SERIALIZER);
        registry.registerKeyParser(KEY_PARSER);
    }

    private PrfBasedKeyDerivationKeyProtoSerialization() {
    }
}
