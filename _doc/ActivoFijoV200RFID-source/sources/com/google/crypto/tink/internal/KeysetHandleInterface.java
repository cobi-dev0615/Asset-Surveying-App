package com.google.crypto.tink.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyStatus;

/* loaded from: classes2.dex */
public interface KeysetHandleInterface {

    public interface Entry {
        int getId();

        Key getKey();

        KeyStatus getStatus();

        boolean isPrimary();
    }

    Entry getAt(int i);

    Entry getPrimary();

    int size();
}
