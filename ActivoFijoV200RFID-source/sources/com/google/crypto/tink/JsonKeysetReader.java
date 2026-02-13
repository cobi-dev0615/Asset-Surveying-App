package com.google.crypto.tink;

import androidx.core.app.NotificationCompat;
import com.google.crypto.tink.internal.JsonParser;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.subtle.Base64;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;

/* loaded from: classes2.dex */
public final class JsonKeysetReader implements KeysetReader {
    private static final long MAX_KEY_ID = 4294967295L;
    private static final long MIN_KEY_ID = -2147483648L;
    private static final Charset UTF_8 = Charset.forName(com.bumptech.glide.load.Key.STRING_CHARSET_NAME);
    private final InputStream inputStream;
    private boolean urlSafeBase64 = false;

    private JsonKeysetReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public static JsonKeysetReader withInputStream(InputStream input) throws IOException {
        return new JsonKeysetReader(input);
    }

    @Deprecated
    public static JsonKeysetReader withJsonObject(Object input) {
        return withString(input.toString());
    }

    public static JsonKeysetReader withString(String input) {
        return new JsonKeysetReader(new ByteArrayInputStream(input.getBytes(UTF_8)));
    }

    @Deprecated
    public static JsonKeysetReader withBytes(final byte[] bytes) {
        return new JsonKeysetReader(new ByteArrayInputStream(bytes));
    }

    @Deprecated
    public static JsonKeysetReader withFile(File file) throws IOException {
        return withInputStream(new FileInputStream(file));
    }

    @Deprecated
    public static JsonKeysetReader withPath(String path) throws IOException {
        return withInputStream(new FileInputStream(new File(path)));
    }

    @Deprecated
    public static JsonKeysetReader withPath(Path path) throws IOException {
        return withInputStream(new FileInputStream(path.toFile()));
    }

    public JsonKeysetReader withUrlSafeBase64() {
        this.urlSafeBase64 = true;
        return this;
    }

    @Override // com.google.crypto.tink.KeysetReader
    public Keyset read() throws IOException {
        try {
            try {
                return keysetFromJson(JsonParser.parse(new String(Util.readAll(this.inputStream), UTF_8)).getAsJsonObject());
            } finally {
                InputStream inputStream = this.inputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (JsonParseException | IllegalStateException e) {
            throw new IOException(e);
        }
    }

    @Override // com.google.crypto.tink.KeysetReader
    public EncryptedKeyset readEncrypted() throws IOException {
        try {
            try {
                return encryptedKeysetFromJson(JsonParser.parse(new String(Util.readAll(this.inputStream), UTF_8)).getAsJsonObject());
            } finally {
                InputStream inputStream = this.inputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (JsonParseException | IllegalStateException e) {
            throw new IOException(e);
        }
    }

    private static int getKeyId(JsonElement element) throws IOException {
        if (!element.isJsonPrimitive()) {
            throw new IOException("invalid key id: not a JSON primitive");
        }
        if (!element.getAsJsonPrimitive().isNumber()) {
            throw new IOException("invalid key id: not a JSON number");
        }
        try {
            long parsedNumberAsLongOrThrow = JsonParser.getParsedNumberAsLongOrThrow(element.getAsJsonPrimitive().getAsNumber());
            if (parsedNumberAsLongOrThrow > MAX_KEY_ID || parsedNumberAsLongOrThrow < -2147483648L) {
                throw new IOException("invalid key id");
            }
            return (int) parsedNumberAsLongOrThrow;
        } catch (NumberFormatException e) {
            throw new IOException(e);
        }
    }

    private Keyset keysetFromJson(JsonObject json) throws IOException {
        if (!json.has("key")) {
            throw new JsonParseException("invalid keyset: no key");
        }
        JsonElement jsonElement = json.get("key");
        if (!jsonElement.isJsonArray()) {
            throw new JsonParseException("invalid keyset: key must be an array");
        }
        JsonArray asJsonArray = jsonElement.getAsJsonArray();
        if (asJsonArray.size() == 0) {
            throw new JsonParseException("invalid keyset: key is empty");
        }
        Keyset.Builder newBuilder = Keyset.newBuilder();
        if (json.has("primaryKeyId")) {
            newBuilder.setPrimaryKeyId(getKeyId(json.get("primaryKeyId")));
        }
        for (int i = 0; i < asJsonArray.size(); i++) {
            newBuilder.addKey(keyFromJson(asJsonArray.get(i).getAsJsonObject()));
        }
        return (Keyset) newBuilder.build();
    }

    private EncryptedKeyset encryptedKeysetFromJson(JsonObject json) throws IOException {
        byte[] decode;
        validateEncryptedKeyset(json);
        if (this.urlSafeBase64) {
            decode = Base64.urlSafeDecode(json.get("encryptedKeyset").getAsString());
        } else {
            decode = Base64.decode(json.get("encryptedKeyset").getAsString());
        }
        if (json.has("keysetInfo")) {
            return (EncryptedKeyset) EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(decode)).setKeysetInfo(keysetInfoFromJson(json.getAsJsonObject("keysetInfo"))).build();
        }
        return (EncryptedKeyset) EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(decode)).build();
    }

    private Keyset.Key keyFromJson(JsonObject json) throws IOException {
        if (!json.has("keyData") || !json.has(NotificationCompat.CATEGORY_STATUS) || !json.has("keyId") || !json.has("outputPrefixType")) {
            throw new JsonParseException("invalid key");
        }
        JsonElement jsonElement = json.get("keyData");
        if (!jsonElement.isJsonObject()) {
            throw new JsonParseException("invalid key: keyData must be an object");
        }
        return (Keyset.Key) Keyset.Key.newBuilder().setStatus(getStatus(json.get(NotificationCompat.CATEGORY_STATUS).getAsString())).setKeyId(getKeyId(json.get("keyId"))).setOutputPrefixType(getOutputPrefixType(json.get("outputPrefixType").getAsString())).setKeyData(keyDataFromJson(jsonElement.getAsJsonObject())).build();
    }

    private static KeysetInfo keysetInfoFromJson(JsonObject json) throws IOException {
        KeysetInfo.Builder newBuilder = KeysetInfo.newBuilder();
        if (json.has("primaryKeyId")) {
            newBuilder.setPrimaryKeyId(getKeyId(json.get("primaryKeyId")));
        }
        if (json.has("keyInfo")) {
            JsonArray asJsonArray = json.getAsJsonArray("keyInfo");
            for (int i = 0; i < asJsonArray.size(); i++) {
                newBuilder.addKeyInfo(keyInfoFromJson(asJsonArray.get(i).getAsJsonObject()));
            }
        }
        return (KeysetInfo) newBuilder.build();
    }

    private static KeysetInfo.KeyInfo keyInfoFromJson(JsonObject json) throws IOException {
        return (KeysetInfo.KeyInfo) KeysetInfo.KeyInfo.newBuilder().setStatus(getStatus(json.get(NotificationCompat.CATEGORY_STATUS).getAsString())).setKeyId(getKeyId(json.get("keyId"))).setOutputPrefixType(getOutputPrefixType(json.get("outputPrefixType").getAsString())).setTypeUrl(json.get("typeUrl").getAsString()).build();
    }

    private KeyData keyDataFromJson(JsonObject json) {
        byte[] decode;
        if (!json.has("typeUrl") || !json.has("value") || !json.has("keyMaterialType")) {
            throw new JsonParseException("invalid keyData");
        }
        if (this.urlSafeBase64) {
            decode = Base64.urlSafeDecode(json.get("value").getAsString());
        } else {
            decode = Base64.decode(json.get("value").getAsString());
        }
        return (KeyData) KeyData.newBuilder().setTypeUrl(json.get("typeUrl").getAsString()).setValue(ByteString.copyFrom(decode)).setKeyMaterialType(getKeyMaterialType(json.get("keyMaterialType").getAsString())).build();
    }

    private static KeyStatusType getStatus(String status) {
        status.hashCode();
        switch (status) {
            case "ENABLED":
                return KeyStatusType.ENABLED;
            case "DESTROYED":
                return KeyStatusType.DESTROYED;
            case "DISABLED":
                return KeyStatusType.DISABLED;
            default:
                throw new JsonParseException("unknown status: " + status);
        }
    }

    private static OutputPrefixType getOutputPrefixType(String type) {
        type.hashCode();
        switch (type) {
            case "LEGACY":
                return OutputPrefixType.LEGACY;
            case "RAW":
                return OutputPrefixType.RAW;
            case "TINK":
                return OutputPrefixType.TINK;
            case "CRUNCHY":
                return OutputPrefixType.CRUNCHY;
            default:
                throw new JsonParseException("unknown output prefix type: " + type);
        }
    }

    private static KeyData.KeyMaterialType getKeyMaterialType(String type) {
        type.hashCode();
        switch (type) {
            case "REMOTE":
                return KeyData.KeyMaterialType.REMOTE;
            case "SYMMETRIC":
                return KeyData.KeyMaterialType.SYMMETRIC;
            case "ASYMMETRIC_PRIVATE":
                return KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
            case "ASYMMETRIC_PUBLIC":
                return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
            default:
                throw new JsonParseException("unknown key material type: " + type);
        }
    }

    private static void validateEncryptedKeyset(JsonObject json) {
        if (!json.has("encryptedKeyset")) {
            throw new JsonParseException("invalid encrypted keyset");
        }
    }
}
