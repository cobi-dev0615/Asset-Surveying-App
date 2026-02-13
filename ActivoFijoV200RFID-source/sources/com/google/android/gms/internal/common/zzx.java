package com.google.android.gms.internal.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
public final class zzx {
    private final zzp zza;
    private final boolean zzb;
    private final zzy zzc;

    private zzx(zzy zzyVar, boolean z, zzp zzpVar, int i) {
        this.zzc = zzyVar;
        this.zzb = z;
        this.zza = zzpVar;
    }

    public static zzx zza(zzp zzpVar) {
        return new zzx(new zzy(zzpVar), false, zzo.zza, Integer.MAX_VALUE);
    }

    public final zzx zzb() {
        return new zzx(this.zzc, true, this.zza, Integer.MAX_VALUE);
    }

    public final Iterable zzc(CharSequence charSequence) {
        return new zzv(this, charSequence);
    }

    final /* synthetic */ Iterator zze(CharSequence charSequence) {
        return this.zzc.zza(this, charSequence);
    }

    final /* synthetic */ zzp zzf() {
        return this.zza;
    }

    final /* synthetic */ boolean zzg() {
        return this.zzb;
    }

    public final List zzd(CharSequence charSequence) {
        charSequence.getClass();
        Iterator zza = this.zzc.zza(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (zza.hasNext()) {
            arrayList.add((String) zza.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
