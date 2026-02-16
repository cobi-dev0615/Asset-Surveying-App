package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
public class PackageSignatureVerifier {
    static volatile zzae zza;
    private static zzaf zzb;

    private static zzaf zza(Context context) {
        zzaf zzafVar;
        synchronized (PackageSignatureVerifier.class) {
            if (zzb == null) {
                zzb = new zzaf(context);
            }
            zzafVar = zzb;
        }
        return zzafVar;
    }

    public PackageVerificationResult queryPackageSignatureVerified(Context context, String str) {
        boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(context);
        zza(context);
        if (!zzo.zze()) {
            throw new zzag();
        }
        String str2 = true != honorsDebugCertificates ? "-0" : "-1";
        String.valueOf(str);
        String concat = String.valueOf(str).concat(str2);
        if (zza != null && zza.zza().equals(concat)) {
            return zza.zzb();
        }
        zza(context);
        zzx zzxVar = new zzx(null);
        zzxVar.zza(str);
        zzxVar.zzb(honorsDebugCertificates);
        zzxVar.zzc(false);
        zzaa zzb2 = zzo.zzb(zzxVar.zzd());
        if (zzb2.zza) {
            zza = new zzae(concat, PackageVerificationResult.zzd(str, zzb2.zze));
            return zza.zzb();
        }
        String str3 = zzb2.zzb;
        Preconditions.checkNotNull(str3);
        return PackageVerificationResult.zza(str, str3, zzb2.zzc);
    }

    public PackageVerificationResult queryPackageSignatureVerifiedWithRetry(Context context, String str) {
        try {
            PackageVerificationResult queryPackageSignatureVerified = queryPackageSignatureVerified(context, str);
            queryPackageSignatureVerified.zzc();
            return queryPackageSignatureVerified;
        } catch (SecurityException e) {
            PackageVerificationResult queryPackageSignatureVerified2 = queryPackageSignatureVerified(context, str);
            if (!queryPackageSignatureVerified2.zzb()) {
                return queryPackageSignatureVerified2;
            }
            Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", e);
            return queryPackageSignatureVerified2;
        }
    }
}
