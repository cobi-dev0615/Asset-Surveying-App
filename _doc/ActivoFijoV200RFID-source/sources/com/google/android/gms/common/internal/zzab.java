package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
public final class zzab extends com.google.android.gms.internal.common.zza implements zzad {
    zzab(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzad
    public final boolean zze(com.google.android.gms.common.zzv zzvVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzc(zza, zzvVar);
        com.google.android.gms.internal.common.zzc.zze(zza, iObjectWrapper);
        Parcel zzB = zzB(5, zza);
        boolean zza2 = com.google.android.gms.internal.common.zzc.zza(zzB);
        zzB.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.common.internal.zzad
    public final com.google.android.gms.common.zzt zzf(com.google.android.gms.common.zzr zzrVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzc(zza, zzrVar);
        Parcel zzB = zzB(6, zza);
        com.google.android.gms.common.zzt zztVar = (com.google.android.gms.common.zzt) com.google.android.gms.internal.common.zzc.zzb(zzB, com.google.android.gms.common.zzt.CREATOR);
        zzB.recycle();
        return zztVar;
    }

    @Override // com.google.android.gms.common.internal.zzad
    public final boolean zzg() throws RemoteException {
        Parcel zzB = zzB(7, zza());
        boolean zza = com.google.android.gms.internal.common.zzc.zza(zzB);
        zzB.recycle();
        return zza;
    }

    @Override // com.google.android.gms.common.internal.zzad
    public final com.google.android.gms.common.zzt zzh(com.google.android.gms.common.zzr zzrVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzc(zza, zzrVar);
        Parcel zzB = zzB(8, zza);
        com.google.android.gms.common.zzt zztVar = (com.google.android.gms.common.zzt) com.google.android.gms.internal.common.zzc.zzb(zzB, com.google.android.gms.common.zzt.CREATOR);
        zzB.recycle();
        return zztVar;
    }

    @Override // com.google.android.gms.common.internal.zzad
    public final boolean zzi() throws RemoteException {
        Parcel zzB = zzB(9, zza());
        boolean zza = com.google.android.gms.internal.common.zzc.zza(zzB);
        zzB.recycle();
        return zza;
    }
}
