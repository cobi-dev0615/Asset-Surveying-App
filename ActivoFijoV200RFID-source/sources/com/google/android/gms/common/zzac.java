package com.google.android.gms.common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.common.zzaj;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
final class zzac {
    private String zza = null;
    private long zzb = -1;
    private zzaj zzc = zzaj.zzj();
    private zzaj zzd = zzaj.zzj();

    zzac() {
    }

    final zzac zza(String str) {
        this.zza = str;
        return this;
    }

    final zzac zzb(long j) {
        this.zzb = j;
        return this;
    }

    final zzac zzc(List list) {
        Preconditions.checkNotNull(list);
        this.zzc = zzaj.zzp(list);
        return this;
    }

    final zzac zzd(List list) {
        Preconditions.checkNotNull(list);
        this.zzd = zzaj.zzp(list);
        return this;
    }

    final zzad zze() {
        if (this.zza == null) {
            throw new IllegalStateException("packageName must be defined");
        }
        if (this.zzb < 0) {
            throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
        }
        if (this.zzc.isEmpty() && this.zzd.isEmpty()) {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
        return new zzad(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
