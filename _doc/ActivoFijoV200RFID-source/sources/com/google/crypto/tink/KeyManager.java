package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public interface KeyManager<P> {
    @Deprecated
    boolean doesSupport(String typeUrl);

    String getKeyType();

    P getPrimitive(ByteString serializedKey) throws GeneralSecurityException;

    @Deprecated
    P getPrimitive(MessageLite key) throws GeneralSecurityException;

    Class<P> getPrimitiveClass();

    @Deprecated
    int getVersion();

    @Deprecated
    MessageLite newKey(ByteString serializedKeyFormat) throws GeneralSecurityException;

    @Deprecated
    MessageLite newKey(MessageLite keyFormat) throws GeneralSecurityException;

    KeyData newKeyData(ByteString serializedKeyFormat) throws GeneralSecurityException;

    /* renamed from: com.google.crypto.tink.KeyManager$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        @Deprecated
        public static Object $default$getPrimitive(KeyManager _this, MessageLite key) throws GeneralSecurityException {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public static MessageLite $default$newKey(KeyManager _this, ByteString serializedKeyFormat) throws GeneralSecurityException {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public static MessageLite $default$newKey(KeyManager _this, MessageLite keyFormat) throws GeneralSecurityException {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public static boolean $default$doesSupport(KeyManager _this, String typeUrl) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public static int $default$getVersion(KeyManager _this) {
            throw new UnsupportedOperationException();
        }
    }
}
