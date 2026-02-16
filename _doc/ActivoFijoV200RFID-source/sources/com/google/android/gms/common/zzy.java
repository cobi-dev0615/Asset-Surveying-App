package com.google.android.gms.common;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
final class zzy {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;

    /* synthetic */ zzy(String str, boolean z, boolean z2, boolean z3, boolean z4, zzq zzqVar, byte[] bArr) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z4;
    }

    final boolean zza() {
        return this.zzc;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [android.os.IBinder, com.google.android.gms.dynamic.IObjectWrapper] */
    final zzr zzb(Context context) {
        return new zzr(this.zza, this.zzb, false, ObjectWrapper.wrap(context), false, true, null);
    }
}
