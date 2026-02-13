package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
final class zzj implements DynamiteModule.VersionPolicy {
    zzj() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        int zza;
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int zzb = iVersions.zzb(context, str);
        selectionResult.localVersion = zzb;
        int i = 1;
        int i2 = 0;
        if (zzb != 0) {
            zza = iVersions.zza(context, str, false);
            selectionResult.remoteVersion = zza;
        } else {
            zza = iVersions.zza(context, str, true);
            selectionResult.remoteVersion = zza;
        }
        int i3 = selectionResult.localVersion;
        if (i3 != 0) {
            i2 = i3;
        } else if (zza == 0) {
            i = 0;
            selectionResult.selection = i;
            return selectionResult;
        }
        if (i2 >= zza) {
            i = -1;
        }
        selectionResult.selection = i;
        return selectionResult;
    }
}
