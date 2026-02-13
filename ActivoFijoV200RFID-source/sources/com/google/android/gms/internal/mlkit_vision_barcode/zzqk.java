package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* loaded from: classes2.dex */
public final class zzqk {
    private final zzqi zza;
    private final Integer zzb;
    private final Integer zzc;
    private final Boolean zzd;

    /* synthetic */ zzqk(zzqh zzqhVar, zzqj zzqjVar) {
        zzqi zzqiVar;
        Integer num;
        zzqiVar = zzqhVar.zza;
        this.zza = zzqiVar;
        num = zzqhVar.zzb;
        this.zzb = num;
        this.zzc = null;
        this.zzd = null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzqk)) {
            return false;
        }
        zzqk zzqkVar = (zzqk) obj;
        if (Objects.equal(this.zza, zzqkVar.zza) && Objects.equal(this.zzb, zzqkVar.zzb)) {
            Integer num = zzqkVar.zzc;
            if (Objects.equal(null, null)) {
                Boolean bool = zzqkVar.zzd;
                if (Objects.equal(null, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, null, null);
    }

    public final zzqi zza() {
        return this.zza;
    }

    public final Integer zzb() {
        return this.zzb;
    }
}
