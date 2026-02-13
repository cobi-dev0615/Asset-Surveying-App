package com.google.android.gms.internal.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
final class zzu extends zzw {
    final /* synthetic */ zzp zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzu(zzx zzxVar, CharSequence charSequence, zzp zzpVar) {
        super(zzxVar, charSequence);
        this.zza = zzpVar;
    }

    @Override // com.google.android.gms.internal.common.zzw
    final int zzc(int i) {
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzt.zzc(i, length, "index");
        while (i < length) {
            if (this.zza.zza(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.common.zzw
    final int zzd(int i) {
        return i + 1;
    }
}
