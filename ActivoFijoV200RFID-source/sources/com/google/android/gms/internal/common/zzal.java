package com.google.android.gms.internal.common;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
final class zzal extends zzaj {
    static final zzaj zza = new zzal(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzal(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzt.zzb(i, this.zzc, "index");
        return Objects.requireNonNull(this.zzb[i]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.common.zzae
    final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.common.zzae
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.common.zzae
    final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.common.zzae
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.common.zzaj, com.google.android.gms.internal.common.zzae
    final int zzg(Object[] objArr, int i) {
        Object[] objArr2 = this.zzb;
        int i2 = this.zzc;
        System.arraycopy(objArr2, 0, objArr, 0, i2);
        return i2;
    }
}
