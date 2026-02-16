package com.google.crypto.tink.internal;

import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class KeyManagerRegistry {
    private ConcurrentMap<String, KeyManager<?>> keyManagerMap;
    private ConcurrentMap<String, Boolean> newKeyAllowedMap;
    private static final Logger logger = Logger.getLogger(KeyManagerRegistry.class.getName());
    private static final KeyManagerRegistry GLOBAL_INSTANCE = new KeyManagerRegistry();

    public static KeyManagerRegistry globalInstance() {
        return GLOBAL_INSTANCE;
    }

    public static void resetGlobalInstanceTestOnly() {
        KeyManagerRegistry keyManagerRegistry = GLOBAL_INSTANCE;
        keyManagerRegistry.keyManagerMap = new ConcurrentHashMap();
        keyManagerRegistry.newKeyAllowedMap = new ConcurrentHashMap();
    }

    public KeyManagerRegistry(KeyManagerRegistry original) {
        this.keyManagerMap = new ConcurrentHashMap(original.keyManagerMap);
        this.newKeyAllowedMap = new ConcurrentHashMap(original.newKeyAllowedMap);
    }

    public KeyManagerRegistry() {
        this.keyManagerMap = new ConcurrentHashMap();
        this.newKeyAllowedMap = new ConcurrentHashMap();
    }

    private synchronized KeyManager<?> getKeyManagerOrThrow(String typeUrl) throws GeneralSecurityException {
        if (!this.keyManagerMap.containsKey(typeUrl)) {
            throw new GeneralSecurityException("No key manager found for key type " + typeUrl + ", see https://developers.google.com/tink/faq/registration_errors");
        }
        return this.keyManagerMap.get(typeUrl);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0088, code lost:
    
        r5.keyManagerMap.putIfAbsent(r2, r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void insertKeyManager(final com.google.crypto.tink.KeyManager<?> r6, boolean r7, boolean r8) throws java.security.GeneralSecurityException {
        /*
            r5 = this;
            java.lang.String r0 = "New keys are already disallowed for key type "
            java.lang.String r1 = "Attempted overwrite of a registered key manager for key type "
            monitor-enter(r5)
            java.lang.String r2 = r6.getKeyType()     // Catch: java.lang.Throwable -> L9e
            if (r8 == 0) goto L34
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Boolean> r3 = r5.newKeyAllowedMap     // Catch: java.lang.Throwable -> L9e
            boolean r3 = r3.containsKey(r2)     // Catch: java.lang.Throwable -> L9e
            if (r3 == 0) goto L34
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Boolean> r3 = r5.newKeyAllowedMap     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Throwable -> L9e
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch: java.lang.Throwable -> L9e
            boolean r3 = r3.booleanValue()     // Catch: java.lang.Throwable -> L9e
            if (r3 == 0) goto L22
            goto L34
        L22:
            java.security.GeneralSecurityException r6 = new java.security.GeneralSecurityException     // Catch: java.lang.Throwable -> L9e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L9e
            r7.append(r2)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L9e
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L9e
            throw r6     // Catch: java.lang.Throwable -> L9e
        L34:
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.crypto.tink.KeyManager<?>> r0 = r5.keyManagerMap     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L9e
            com.google.crypto.tink.KeyManager r0 = (com.google.crypto.tink.KeyManager) r0     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto L86
            java.lang.Class r3 = r0.getClass()     // Catch: java.lang.Throwable -> L9e
            java.lang.Class r4 = r6.getClass()     // Catch: java.lang.Throwable -> L9e
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L9e
            if (r3 == 0) goto L4d
            goto L86
        L4d:
            java.util.logging.Logger r7 = com.google.crypto.tink.internal.KeyManagerRegistry.logger     // Catch: java.lang.Throwable -> L9e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L9e
            r8.append(r2)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L9e
            r7.warning(r8)     // Catch: java.lang.Throwable -> L9e
            java.security.GeneralSecurityException r7 = new java.security.GeneralSecurityException     // Catch: java.lang.Throwable -> L9e
            java.lang.String r8 = "typeUrl (%s) is already registered with %s, cannot be re-registered with %s"
            java.lang.Class r0 = r0.getClass()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> L9e
            java.lang.Class r6 = r6.getClass()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r6 = r6.getName()     // Catch: java.lang.Throwable -> L9e
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L9e
            r3 = 0
            r1[r3] = r2     // Catch: java.lang.Throwable -> L9e
            r2 = 1
            r1[r2] = r0     // Catch: java.lang.Throwable -> L9e
            r0 = 2
            r1[r0] = r6     // Catch: java.lang.Throwable -> L9e
            java.lang.String r6 = java.lang.String.format(r8, r1)     // Catch: java.lang.Throwable -> L9e
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L9e
            throw r7     // Catch: java.lang.Throwable -> L9e
        L86:
            if (r7 != 0) goto L8e
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.crypto.tink.KeyManager<?>> r7 = r5.keyManagerMap     // Catch: java.lang.Throwable -> L9e
            r7.putIfAbsent(r2, r6)     // Catch: java.lang.Throwable -> L9e
            goto L93
        L8e:
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.crypto.tink.KeyManager<?>> r7 = r5.keyManagerMap     // Catch: java.lang.Throwable -> L9e
            r7.put(r2, r6)     // Catch: java.lang.Throwable -> L9e
        L93:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Boolean> r6 = r5.newKeyAllowedMap     // Catch: java.lang.Throwable -> L9e
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.Throwable -> L9e
            r6.put(r2, r7)     // Catch: java.lang.Throwable -> L9e
            monitor-exit(r5)
            return
        L9e:
            r6 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L9e
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.internal.KeyManagerRegistry.insertKeyManager(com.google.crypto.tink.KeyManager, boolean, boolean):void");
    }

    public synchronized <P> void registerKeyManager(final KeyManager<P> manager, boolean newKeyAllowed) throws GeneralSecurityException {
        registerKeyManagerWithFipsCompatibility(manager, TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS, newKeyAllowed);
    }

    public synchronized <P> void registerKeyManagerWithFipsCompatibility(final KeyManager<P> manager, TinkFipsUtil.AlgorithmFipsCompatibility compatibility, boolean newKeyAllowed) throws GeneralSecurityException {
        if (!compatibility.isCompatible()) {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
        insertKeyManager(manager, false, newKeyAllowed);
    }

    public boolean typeUrlExists(String typeUrl) {
        return this.keyManagerMap.containsKey(typeUrl);
    }

    public <P> KeyManager<P> getKeyManager(String str, Class<P> cls) throws GeneralSecurityException {
        KeyManager<P> keyManager = (KeyManager<P>) getKeyManagerOrThrow(str);
        if (keyManager.getPrimitiveClass().equals(cls)) {
            return keyManager;
        }
        throw new GeneralSecurityException("Primitive type " + cls.getName() + " not supported by key manager of type " + keyManager.getClass() + ", which only supports: " + keyManager.getPrimitiveClass());
    }

    public KeyManager<?> getUntypedKeyManager(String typeUrl) throws GeneralSecurityException {
        return getKeyManagerOrThrow(typeUrl);
    }

    public boolean isNewKeyAllowed(String typeUrl) {
        return this.newKeyAllowedMap.get(typeUrl).booleanValue();
    }

    public boolean isEmpty() {
        return this.keyManagerMap.isEmpty();
    }

    public synchronized void restrictToFipsIfEmptyAndGlobalInstance() throws GeneralSecurityException {
        if (this != globalInstance()) {
            throw new GeneralSecurityException("Only the global instance can be restricted to FIPS.");
        }
        if (TinkFipsUtil.useOnlyFips()) {
            return;
        }
        if (!isEmpty()) {
            throw new GeneralSecurityException("Could not enable FIPS mode as Registry is not empty.");
        }
        TinkFipsUtil.setFipsRestricted();
    }
}
