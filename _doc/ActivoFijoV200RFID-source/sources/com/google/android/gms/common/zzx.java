package com.google.android.gms.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
final class zzx {
    private String zza = null;
    private Boolean zzb = null;
    private Boolean zzc = null;

    private zzx() {
    }

    /* synthetic */ zzx(byte[] bArr) {
    }

    final zzx zza(String str) {
        this.zza = str;
        return this;
    }

    final zzx zzb(boolean z) {
        this.zzb = Boolean.valueOf(z);
        return this;
    }

    final zzx zzc(boolean z) {
        this.zzc = Boolean.valueOf(z);
        return this;
    }

    final zzy zzd() {
        Boolean bool = this.zzb;
        if (bool == null) {
            throw new IllegalStateException("allowTestKeys must be set");
        }
        if (this.zzc != null) {
            return new zzy(this.zza, bool.booleanValue(), false, false, this.zzc.booleanValue(), null, null);
        }
        throw new IllegalStateException("isGoogleOrPlatformOnly must be set");
    }
}
