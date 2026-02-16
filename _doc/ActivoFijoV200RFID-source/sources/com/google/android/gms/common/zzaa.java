package com.google.android.gms.common;

import android.util.Log;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
public class zzaa {
    private static final zzaa zzf = new zzaa(true, 3, 1, null, null, -1, null);
    final boolean zza;

    @Nullable
    final String zzb;

    @Nullable
    final Throwable zzc;

    @Nullable
    final zzaa zzd;
    final int zze;

    private zzaa(boolean z, int i, int i2, @Nullable String str, @Nullable Throwable th, long j, @Nullable zzaa zzaaVar) {
        this.zza = z;
        this.zze = i;
        this.zzb = str;
        this.zzc = th;
        this.zzd = zzaaVar;
    }

    /* synthetic */ zzaa(boolean z, int i, int i2, String str, Throwable th, long j, zzaa zzaaVar, byte[] bArr) {
        this(false, 1, 5, null, null, -1L, null);
    }

    @Deprecated
    static zzaa zzb() {
        return zzf;
    }

    static zzaa zzc(String str) {
        return new zzaa(false, 1, 5, str, null, -1L, null);
    }

    static zzaa zzd(String str, Throwable th) {
        return new zzaa(false, 1, 5, str, th, -1L, null);
    }

    public static zzaa zzf(int i, long j, @Nullable zzaa zzaaVar) {
        return new zzaa(true, i, 1, null, null, j, zzaaVar);
    }

    static zzaa zzg(int i, int i2, String str, @Nullable Throwable th) {
        return new zzaa(false, i, i2, str, th, -1L, null);
    }

    @Nullable
    String zza() {
        return this.zzb;
    }

    final void zze() {
        if (this.zza || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        Throwable th = this.zzc;
        if (th != null) {
            Log.d("GoogleCertificatesRslt", zza(), th);
        } else {
            Log.d("GoogleCertificatesRslt", zza());
        }
    }
}
