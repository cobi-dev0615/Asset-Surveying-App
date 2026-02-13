package com.google.android.gms.internal.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
final class zzag extends zzab {
    private final zzaj zza;

    zzag(zzaj zzajVar, int i) {
        super(zzajVar.size(), i);
        this.zza = zzajVar;
    }

    @Override // com.google.android.gms.internal.common.zzab
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
