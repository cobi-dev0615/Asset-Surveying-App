package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
public final class zzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();
    private final boolean zza;

    @Nullable
    private final String zzb;
    private final int zzc;
    private final int zzd;
    private final long zze;

    @Nullable
    private final zzt zzf;

    zzt(boolean z, String str, int i, int i2, long j, zzt zztVar) {
        this.zza = z;
        this.zzb = str;
        this.zzc = zzab.zza(i) - 1;
        this.zzd = zzd.zza(i2) - 1;
        this.zze = j;
        this.zzf = zztVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeLong(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zza() {
        return this.zza;
    }

    @Nullable
    public final String zzb() {
        return this.zzb;
    }

    public final long zzc() {
        return this.zze;
    }

    @Nullable
    public final zzt zzd() {
        return this.zzf;
    }

    public final int zze() {
        return zzab.zza(this.zzc);
    }

    public final int zzf() {
        return zzd.zza(this.zzd);
    }
}
