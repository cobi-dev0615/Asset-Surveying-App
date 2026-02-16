package com.google.crypto.tink.jwt;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.jwt.JwtEcdsaParameters;
import com.google.crypto.tink.jwt.JwtRsaSsaPkcs1Parameters;
import com.google.crypto.tink.jwt.JwtRsaSsaPssParameters;
import com.google.crypto.tink.subtle.Base64;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import java.util.Optional;

/* loaded from: classes2.dex */
public final class JwkSetConverter {
    public static String fromPublicKeysetHandle(KeysetHandle handle) throws IOException, GeneralSecurityException {
        KeysetHandle build = KeysetHandle.newBuilder(handle).build();
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < build.size(); i++) {
            KeysetHandle.Entry at = build.getAt(i);
            if (at.getStatus() == KeyStatus.ENABLED) {
                Key key = at.getKey();
                if (key instanceof JwtEcdsaPublicKey) {
                    jsonArray.add(convertJwtEcdsaKey((JwtEcdsaPublicKey) key));
                } else if (key instanceof JwtRsaSsaPkcs1PublicKey) {
                    jsonArray.add(convertJwtRsaSsaPkcs1Key((JwtRsaSsaPkcs1PublicKey) key));
                } else if (key instanceof JwtRsaSsaPssPublicKey) {
                    jsonArray.add(convertJwtRsaSsaPssKey((JwtRsaSsaPssPublicKey) key));
                } else {
                    throw new GeneralSecurityException("unsupported key with parameters " + key.getParameters());
                }
            }
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("keys", jsonArray);
        return jsonObject.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
    
        if (r4.equals("ES") == false) goto L8;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x003e. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.crypto.tink.KeysetHandle toPublicKeysetHandle(java.lang.String r8) throws java.io.IOException, java.security.GeneralSecurityException {
        /*
            com.google.gson.JsonElement r8 = com.google.crypto.tink.internal.JsonParser.parse(r8)     // Catch: java.io.IOException -> Lc9 java.lang.IllegalStateException -> Lcb
            com.google.gson.JsonObject r8 = r8.getAsJsonObject()     // Catch: java.io.IOException -> Lc9 java.lang.IllegalStateException -> Lcb
            com.google.crypto.tink.KeysetHandle$Builder r0 = com.google.crypto.tink.KeysetHandle.newBuilder()
            java.lang.String r1 = "keys"
            com.google.gson.JsonElement r8 = r8.get(r1)
            com.google.gson.JsonArray r8 = r8.getAsJsonArray()
            java.util.Iterator r8 = r8.iterator()
        L1a:
            boolean r1 = r8.hasNext()
            r2 = 0
            if (r1 == 0) goto Laf
            java.lang.Object r1 = r8.next()
            com.google.gson.JsonElement r1 = (com.google.gson.JsonElement) r1
            com.google.gson.JsonObject r1 = r1.getAsJsonObject()
            java.lang.String r3 = "alg"
            java.lang.String r4 = getStringItem(r1, r3)
            r5 = 2
            java.lang.String r4 = r4.substring(r2, r5)
            r4.hashCode()
            int r6 = r4.hashCode()
            r7 = -1
            switch(r6) {
                case 2222: goto L59;
                case 2563: goto L4e;
                case 2625: goto L43;
                default: goto L41;
            }
        L41:
            r2 = r7
            goto L62
        L43:
            java.lang.String r2 = "RS"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L4c
            goto L41
        L4c:
            r2 = r5
            goto L62
        L4e:
            java.lang.String r2 = "PS"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L57
            goto L41
        L57:
            r2 = 1
            goto L62
        L59:
            java.lang.String r5 = "ES"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L62
            goto L41
        L62:
            switch(r2) {
                case 0: goto L9e;
                case 1: goto L8d;
                case 2: goto L7d;
                default: goto L65;
            }
        L65:
            java.security.GeneralSecurityException r8 = new java.security.GeneralSecurityException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "unexpected alg value: "
            r0.<init>(r2)
            java.lang.String r1 = getStringItem(r1, r3)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L7d:
            com.google.crypto.tink.jwt.JwtRsaSsaPkcs1PublicKey r1 = convertToRsaSsaPkcs1Key(r1)
            com.google.crypto.tink.KeysetHandle$Builder$Entry r1 = com.google.crypto.tink.KeysetHandle.importKey(r1)
            com.google.crypto.tink.KeysetHandle$Builder$Entry r1 = r1.withRandomId()
            r0.addEntry(r1)
            goto L1a
        L8d:
            com.google.crypto.tink.jwt.JwtRsaSsaPssPublicKey r1 = convertToRsaSsaPssKey(r1)
            com.google.crypto.tink.KeysetHandle$Builder$Entry r1 = com.google.crypto.tink.KeysetHandle.importKey(r1)
            com.google.crypto.tink.KeysetHandle$Builder$Entry r1 = r1.withRandomId()
            r0.addEntry(r1)
            goto L1a
        L9e:
            com.google.crypto.tink.jwt.JwtEcdsaPublicKey r1 = convertToEcdsaKey(r1)
            com.google.crypto.tink.KeysetHandle$Builder$Entry r1 = com.google.crypto.tink.KeysetHandle.importKey(r1)
            com.google.crypto.tink.KeysetHandle$Builder$Entry r1 = r1.withRandomId()
            r0.addEntry(r1)
            goto L1a
        Laf:
            int r8 = r0.size()
            if (r8 <= 0) goto Lc1
            com.google.crypto.tink.KeysetHandle$Builder$Entry r8 = r0.getAt(r2)
            r8.makePrimary()
            com.google.crypto.tink.KeysetHandle r8 = r0.build()
            return r8
        Lc1:
            java.security.GeneralSecurityException r8 = new java.security.GeneralSecurityException
            java.lang.String r0 = "empty keyset"
            r8.<init>(r0)
            throw r8
        Lc9:
            r8 = move-exception
            goto Lcc
        Lcb:
            r8 = move-exception
        Lcc:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
            java.lang.String r1 = "JWK set is invalid JSON"
            r0.<init>(r1, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.jwt.JwkSetConverter.toPublicKeysetHandle(java.lang.String):com.google.crypto.tink.KeysetHandle");
    }

    private static JsonObject convertJwtEcdsaKey(JwtEcdsaPublicKey key) throws GeneralSecurityException {
        String str;
        String str2;
        int i;
        JwtEcdsaParameters.Algorithm algorithm = key.getParameters().getAlgorithm();
        if (algorithm.equals(JwtEcdsaParameters.Algorithm.ES256)) {
            str = "ES256";
            str2 = "P-256";
            i = 32;
        } else if (algorithm.equals(JwtEcdsaParameters.Algorithm.ES384)) {
            str = "ES384";
            str2 = "P-384";
            i = 48;
        } else if (algorithm.equals(JwtEcdsaParameters.Algorithm.ES512)) {
            str = "ES512";
            str2 = "P-521";
            i = 66;
        } else {
            throw new GeneralSecurityException("unknown algorithm");
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("kty", "EC");
        jsonObject.addProperty("crv", str2);
        BigInteger affineX = key.getPublicPoint().getAffineX();
        BigInteger affineY = key.getPublicPoint().getAffineY();
        jsonObject.addProperty("x", Base64.urlSafeEncode(BigIntegerEncoding.toBigEndianBytesOfFixedLength(affineX, i)));
        jsonObject.addProperty("y", Base64.urlSafeEncode(BigIntegerEncoding.toBigEndianBytesOfFixedLength(affineY, i)));
        jsonObject.addProperty("use", "sig");
        jsonObject.addProperty("alg", str);
        JsonArray jsonArray = new JsonArray();
        jsonArray.add("verify");
        jsonObject.add("key_ops", jsonArray);
        Optional<String> kid = key.getKid();
        if (kid.isPresent()) {
            jsonObject.addProperty("kid", kid.get());
        }
        return jsonObject;
    }

    private static byte[] base64urlUInt(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return new byte[]{0};
        }
        return BigIntegerEncoding.toUnsignedBigEndianBytes(n);
    }

    private static JsonObject convertJwtRsaSsaPkcs1Key(JwtRsaSsaPkcs1PublicKey key) throws GeneralSecurityException {
        String standardName = key.getParameters().getAlgorithm().getStandardName();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("kty", "RSA");
        jsonObject.addProperty("n", Base64.urlSafeEncode(base64urlUInt(key.getModulus())));
        jsonObject.addProperty("e", Base64.urlSafeEncode(base64urlUInt(key.getParameters().getPublicExponent())));
        jsonObject.addProperty("use", "sig");
        jsonObject.addProperty("alg", standardName);
        JsonArray jsonArray = new JsonArray();
        jsonArray.add("verify");
        jsonObject.add("key_ops", jsonArray);
        Optional<String> kid = key.getKid();
        if (kid.isPresent()) {
            jsonObject.addProperty("kid", kid.get());
        }
        return jsonObject;
    }

    private static JsonObject convertJwtRsaSsaPssKey(JwtRsaSsaPssPublicKey key) throws GeneralSecurityException {
        String standardName = key.getParameters().getAlgorithm().getStandardName();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("kty", "RSA");
        jsonObject.addProperty("n", Base64.urlSafeEncode(base64urlUInt(key.getModulus())));
        jsonObject.addProperty("e", Base64.urlSafeEncode(base64urlUInt(key.getParameters().getPublicExponent())));
        jsonObject.addProperty("use", "sig");
        jsonObject.addProperty("alg", standardName);
        JsonArray jsonArray = new JsonArray();
        jsonArray.add("verify");
        jsonObject.add("key_ops", jsonArray);
        Optional<String> kid = key.getKid();
        if (kid.isPresent()) {
            jsonObject.addProperty("kid", kid.get());
        }
        return jsonObject;
    }

    private static String getStringItem(JsonObject obj, String name) throws GeneralSecurityException {
        if (!obj.has(name)) {
            throw new GeneralSecurityException(name + " not found");
        }
        if (!obj.get(name).isJsonPrimitive() || !obj.get(name).getAsJsonPrimitive().isString()) {
            throw new GeneralSecurityException(name + " is not a string");
        }
        return obj.get(name).getAsString();
    }

    private static void expectStringItem(JsonObject obj, String name, String expectedValue) throws GeneralSecurityException {
        String stringItem = getStringItem(obj, name);
        if (stringItem.equals(expectedValue)) {
            return;
        }
        throw new GeneralSecurityException("unexpected " + name + " value: " + stringItem);
    }

    private static void validateUseIsSig(JsonObject jsonKey) throws GeneralSecurityException {
        if (jsonKey.has("use")) {
            expectStringItem(jsonKey, "use", "sig");
        }
    }

    private static void validateKeyOpsIsVerify(JsonObject jsonKey) throws GeneralSecurityException {
        if (jsonKey.has("key_ops")) {
            if (!jsonKey.get("key_ops").isJsonArray()) {
                throw new GeneralSecurityException("key_ops is not an array");
            }
            JsonArray asJsonArray = jsonKey.get("key_ops").getAsJsonArray();
            if (asJsonArray.size() != 1) {
                throw new GeneralSecurityException("key_ops must contain exactly one element");
            }
            if (!asJsonArray.get(0).isJsonPrimitive() || !asJsonArray.get(0).getAsJsonPrimitive().isString()) {
                throw new GeneralSecurityException("key_ops is not a string");
            }
            if (asJsonArray.get(0).getAsString().equals("verify")) {
                return;
            }
            throw new GeneralSecurityException("unexpected keyOps value: " + asJsonArray.get(0).getAsString());
        }
    }

    private static JwtRsaSsaPkcs1PublicKey convertToRsaSsaPkcs1Key(JsonObject jsonKey) throws GeneralSecurityException {
        JwtRsaSsaPkcs1Parameters.Algorithm algorithm;
        String stringItem = getStringItem(jsonKey, "alg");
        stringItem.hashCode();
        switch (stringItem) {
            case "RS256":
                algorithm = JwtRsaSsaPkcs1Parameters.Algorithm.RS256;
                break;
            case "RS384":
                algorithm = JwtRsaSsaPkcs1Parameters.Algorithm.RS384;
                break;
            case "RS512":
                algorithm = JwtRsaSsaPkcs1Parameters.Algorithm.RS512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Rsa Algorithm: " + getStringItem(jsonKey, "alg"));
        }
        if (jsonKey.has("p") || jsonKey.has("q") || jsonKey.has("dp") || jsonKey.has("dq") || jsonKey.has("d") || jsonKey.has("qi")) {
            throw new UnsupportedOperationException("importing RSA private keys is not implemented");
        }
        expectStringItem(jsonKey, "kty", "RSA");
        validateUseIsSig(jsonKey);
        validateKeyOpsIsVerify(jsonKey);
        BigInteger bigInteger = new BigInteger(1, Base64.urlSafeDecode(getStringItem(jsonKey, "e")));
        BigInteger bigInteger2 = new BigInteger(1, Base64.urlSafeDecode(getStringItem(jsonKey, "n")));
        if (jsonKey.has("kid")) {
            return JwtRsaSsaPkcs1PublicKey.builder().setParameters(JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(bigInteger2.bitLength()).setPublicExponent(bigInteger).setAlgorithm(algorithm).setKidStrategy(JwtRsaSsaPkcs1Parameters.KidStrategy.CUSTOM).build()).setModulus(bigInteger2).setCustomKid(getStringItem(jsonKey, "kid")).build();
        }
        return JwtRsaSsaPkcs1PublicKey.builder().setParameters(JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(bigInteger2.bitLength()).setPublicExponent(bigInteger).setAlgorithm(algorithm).setKidStrategy(JwtRsaSsaPkcs1Parameters.KidStrategy.IGNORED).build()).setModulus(bigInteger2).build();
    }

    private static JwtRsaSsaPssPublicKey convertToRsaSsaPssKey(JsonObject jsonKey) throws GeneralSecurityException {
        JwtRsaSsaPssParameters.Algorithm algorithm;
        String stringItem = getStringItem(jsonKey, "alg");
        stringItem.hashCode();
        switch (stringItem) {
            case "PS256":
                algorithm = JwtRsaSsaPssParameters.Algorithm.PS256;
                break;
            case "PS384":
                algorithm = JwtRsaSsaPssParameters.Algorithm.PS384;
                break;
            case "PS512":
                algorithm = JwtRsaSsaPssParameters.Algorithm.PS512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Rsa Algorithm: " + getStringItem(jsonKey, "alg"));
        }
        if (jsonKey.has("p") || jsonKey.has("q") || jsonKey.has("dq") || jsonKey.has("dq") || jsonKey.has("d") || jsonKey.has("qi")) {
            throw new UnsupportedOperationException("importing RSA private keys is not implemented");
        }
        expectStringItem(jsonKey, "kty", "RSA");
        validateUseIsSig(jsonKey);
        validateKeyOpsIsVerify(jsonKey);
        BigInteger bigInteger = new BigInteger(1, Base64.urlSafeDecode(getStringItem(jsonKey, "e")));
        BigInteger bigInteger2 = new BigInteger(1, Base64.urlSafeDecode(getStringItem(jsonKey, "n")));
        if (jsonKey.has("kid")) {
            return JwtRsaSsaPssPublicKey.builder().setParameters(JwtRsaSsaPssParameters.builder().setModulusSizeBits(bigInteger2.bitLength()).setPublicExponent(bigInteger).setAlgorithm(algorithm).setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.CUSTOM).build()).setModulus(bigInteger2).setCustomKid(getStringItem(jsonKey, "kid")).build();
        }
        return JwtRsaSsaPssPublicKey.builder().setParameters(JwtRsaSsaPssParameters.builder().setModulusSizeBits(bigInteger2.bitLength()).setPublicExponent(bigInteger).setAlgorithm(algorithm).setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.IGNORED).build()).setModulus(bigInteger2).build();
    }

    private static JwtEcdsaPublicKey convertToEcdsaKey(JsonObject jsonKey) throws GeneralSecurityException {
        JwtEcdsaParameters.Algorithm algorithm;
        String stringItem = getStringItem(jsonKey, "alg");
        stringItem.hashCode();
        switch (stringItem) {
            case "ES256":
                expectStringItem(jsonKey, "crv", "P-256");
                algorithm = JwtEcdsaParameters.Algorithm.ES256;
                break;
            case "ES384":
                expectStringItem(jsonKey, "crv", "P-384");
                algorithm = JwtEcdsaParameters.Algorithm.ES384;
                break;
            case "ES512":
                expectStringItem(jsonKey, "crv", "P-521");
                algorithm = JwtEcdsaParameters.Algorithm.ES512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Ecdsa Algorithm: " + getStringItem(jsonKey, "alg"));
        }
        if (jsonKey.has("d")) {
            throw new UnsupportedOperationException("importing ECDSA private keys is not implemented");
        }
        expectStringItem(jsonKey, "kty", "EC");
        validateUseIsSig(jsonKey);
        validateKeyOpsIsVerify(jsonKey);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, Base64.urlSafeDecode(getStringItem(jsonKey, "x"))), new BigInteger(1, Base64.urlSafeDecode(getStringItem(jsonKey, "y"))));
        if (jsonKey.has("kid")) {
            return JwtEcdsaPublicKey.builder().setParameters(JwtEcdsaParameters.builder().setKidStrategy(JwtEcdsaParameters.KidStrategy.CUSTOM).setAlgorithm(algorithm).build()).setPublicPoint(eCPoint).setCustomKid(getStringItem(jsonKey, "kid")).build();
        }
        return JwtEcdsaPublicKey.builder().setParameters(JwtEcdsaParameters.builder().setKidStrategy(JwtEcdsaParameters.KidStrategy.IGNORED).setAlgorithm(algorithm).build()).setPublicPoint(eCPoint).build();
    }

    @Deprecated
    public static String fromKeysetHandle(KeysetHandle handle, KeyAccess keyAccess) throws IOException, GeneralSecurityException {
        return fromPublicKeysetHandle(handle);
    }

    @Deprecated
    public static KeysetHandle toKeysetHandle(String jwkSet, KeyAccess keyAccess) throws IOException, GeneralSecurityException {
        return toPublicKeysetHandle(jwkSet);
    }

    private JwkSetConverter() {
    }
}
