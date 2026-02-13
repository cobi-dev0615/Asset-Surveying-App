package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
public class GoogleSignatureVerifier {

    @Nullable
    private static GoogleSignatureVerifier zza;

    @Nullable
    private static volatile Set zzd;

    @Nullable
    private static volatile Set zze;
    private final Context zzb;
    private volatile String zzc;

    public GoogleSignatureVerifier(Context context) {
        this.zzb = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zza == null) {
                zzo.zza(context);
                zza = new GoogleSignatureVerifier(context);
            }
        }
        return zza;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c6, code lost:
    
        r5 = r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static final boolean zza(android.content.pm.PackageInfo r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.zza(android.content.pm.PackageInfo, boolean):boolean");
    }

    private final zzaa zzb(@Nullable String str, boolean z, boolean z2) {
        zzaa zzc;
        if (str == null) {
            return zzaa.zzc("null pkg");
        }
        if (str.equals(this.zzc)) {
            return zzaa.zzb();
        }
        if (zzo.zzd()) {
            zzx zzxVar = new zzx(null);
            zzxVar.zza(str);
            zzxVar.zzb(GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb));
            zzxVar.zzc(true);
            zzc = zzo.zzb(zzxVar.zzd());
        } else {
            try {
                PackageInfo packageInfo = this.zzb.getPackageManager().getPackageInfo(str, Build.VERSION.SDK_INT >= 28 ? 134217792 : 64);
                boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb);
                if (packageInfo == null) {
                    zzc = zzaa.zzc("null pkg");
                } else if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
                    zzc = zzaa.zzc("single cert required");
                } else {
                    zzl zzlVar = new zzl(packageInfo.signatures[0].toByteArray());
                    String str2 = packageInfo.packageName;
                    zzaa zzc2 = zzo.zzc(str2, zzlVar, honorsDebugCertificates, false);
                    zzc = (!zzc2.zza || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 2) == 0 || !zzo.zzc(str2, zzlVar, false, true).zza) ? zzc2 : zzaa.zzc("debuggable release cert app rejected");
                }
            } catch (PackageManager.NameNotFoundException e) {
                return zzaa.zzd("no pkg ".concat(str), e);
            }
        }
        if (zzc.zza) {
            this.zzc = str;
        }
        return zzc;
    }

    @Nullable
    private static zzk zzc(PackageInfo packageInfo, zzk... zzkVarArr) {
        if (packageInfo.signatures != null) {
            if (packageInfo.signatures.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzl zzlVar = new zzl(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < zzkVarArr.length; i++) {
                if (zzkVarArr[i].equals(zzlVar)) {
                    return zzkVarArr[i];
                }
            }
        }
        return null;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (zza(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean isPackageGoogleSigned(@Nullable String str) {
        zzaa zzb = zzb(str, false, false);
        zzb.zze();
        return zzb.zza;
    }

    public boolean isUidGoogleSigned(int i) {
        zzaa zzc;
        int length;
        String[] packagesForUid = this.zzb.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            zzc = null;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    Preconditions.checkNotNull(zzc);
                    break;
                }
                zzc = zzb(packagesForUid[i2], false, false);
                if (zzc.zza) {
                    break;
                }
                i2++;
            }
        } else {
            zzc = zzaa.zzc("no pkgs");
        }
        zzc.zze();
        return zzc.zza;
    }
}
