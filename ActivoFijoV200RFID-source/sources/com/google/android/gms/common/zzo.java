package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
final class zzo {
    private static volatile com.google.android.gms.common.internal.zzad zzg;
    private static Context zzi;
    static final zzm zza = new zze(zzk.zzf("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u007f¢fú§p\u0085xb±"));
    static final zzm zzb = new zzf(zzk.zzf("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014QÕÛ\u0004÷XçB\u0086<"));
    static final zzm zzc = new zzg(zzk.zzf("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
    static final zzm zzd = new zzh(zzk.zzf("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
    static final zzm zze = new zzi(zzk.zzf("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
    static final zzm zzf = new zzj(zzk.zzf("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
    private static final Object zzh = new Object();

    static synchronized void zza(Context context) {
        synchronized (zzo.class) {
            if (zzi != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                zzi = context.getApplicationContext();
            }
        }
    }

    static zzaa zzb(zzy zzyVar) {
        zzaa zzd2;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.checkNotNull(zzi);
            try {
                zzg();
                Preconditions.checkNotNull(zzi);
                zzr zzb2 = zzyVar.zzb(zzi);
                try {
                    zzd2 = zzh(zzyVar.zza() ? zzg.zzf(zzb2) : zzg.zzh(zzb2));
                } catch (RemoteException e) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                    zzd2 = zzaa.zzd("module call", e);
                }
            } catch (DynamiteModule.LoadingException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                String message = e2.getMessage();
                String.valueOf(message);
                zzd2 = zzaa.zzd("module init: ".concat(String.valueOf(message)), e2);
            }
            return zzd2;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    @Deprecated
    static zzaa zzc(String str, zzk zzkVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return zzi(str, zzkVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    static boolean zzd() {
        boolean z;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                zzg();
                z = zzg.zzg();
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.LoadingException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            z = false;
        }
        return z;
    }

    static boolean zze() {
        boolean z;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                zzg();
                z = zzg.zzi();
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.LoadingException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            z = false;
        }
        return z;
    }

    static /* synthetic */ String zzf(boolean z, String str, zzk zzkVar) {
        String str2 = (z || !zzi(str, zzkVar, true, false).zza) ? "not allowed" : "debug cert rejected";
        MessageDigest zza2 = AndroidUtilsLight.zza("SHA-256");
        Preconditions.checkNotNull(zza2);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, Hex.bytesToStringLowercase(zza2.digest(zzkVar.zzc())), Boolean.valueOf(z), "12451000.false");
    }

    private static void zzg() throws DynamiteModule.LoadingException {
        if (zzg != null) {
            return;
        }
        Preconditions.checkNotNull(zzi);
        synchronized (zzh) {
            if (zzg == null) {
                zzg = com.google.android.gms.common.internal.zzac.zzb(DynamiteModule.load(zzi, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
            }
        }
    }

    private static zzaa zzh(zzt zztVar) {
        if (zztVar.zza()) {
            zzt zzd2 = zztVar.zzd();
            return zzaa.zzf(zztVar.zzf(), zztVar.zzc(), zzd2 != null ? zzh(zzd2) : null);
        }
        String zzb2 = zztVar.zzb();
        PackageManager.NameNotFoundException nameNotFoundException = zztVar.zze() == 4 ? new PackageManager.NameNotFoundException() : null;
        if (zzb2 == null) {
            zzb2 = "error checking package certificate";
        }
        return zzaa.zzg(zztVar.zzf(), zztVar.zze(), zzb2, nameNotFoundException);
    }

    @Deprecated
    private static zzaa zzi(final String str, final zzk zzkVar, final boolean z, boolean z2) {
        try {
            zzg();
            Preconditions.checkNotNull(zzi);
            try {
                return zzg.zze(new zzv(str, zzkVar, z, z2), ObjectWrapper.wrap(zzi.getPackageManager())) ? zzaa.zzb() : new zzz(new Callable() { // from class: com.google.android.gms.common.zzp
                    @Override // java.util.concurrent.Callable
                    public final /* synthetic */ Object call() {
                        return zzo.zzf(z, str, zzkVar);
                    }
                }, null);
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return zzaa.zzd("module call", e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            String message = e2.getMessage();
            String.valueOf(message);
            return zzaa.zzd("module init: ".concat(String.valueOf(message)), e2);
        }
    }
}
