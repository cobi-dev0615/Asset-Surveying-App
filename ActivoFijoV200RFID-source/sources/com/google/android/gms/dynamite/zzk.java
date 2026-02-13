package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
final class zzk implements DynamiteModule.VersionPolicy {
    zzk() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        selectionResult.localVersion = iVersions.zzb(context, str);
        int i = 1;
        int zza = iVersions.zza(context, str, true);
        selectionResult.remoteVersion = zza;
        int i2 = selectionResult.localVersion;
        if (i2 == 0) {
            i2 = 0;
            if (zza == 0) {
                i = 0;
                selectionResult.selection = i;
                return selectionResult;
            }
        }
        if (zza < i2) {
            i = -1;
        }
        selectionResult.selection = i;
        return selectionResult;
    }
}
