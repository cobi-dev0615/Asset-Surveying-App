package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
final class zzz extends zzaa {
    private final Callable zzf;

    /* synthetic */ zzz(Callable callable, byte[] bArr) {
        super(false, 1, 5, null, null, -1L, null, null);
        this.zzf = callable;
    }

    @Override // com.google.android.gms.common.zzaa
    final String zza() {
        try {
            return (String) this.zzf.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
