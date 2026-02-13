package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.3.0 */
/* loaded from: classes2.dex */
final class zzm implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzn zzb;

    zzm(zzn zznVar, Task task) {
        this.zza = task;
        this.zzb = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzn zznVar = this.zzb;
        synchronized (zznVar.zzc()) {
            if (zznVar.zzd() != null) {
                zznVar.zzd().onSuccess(this.zza.getResult());
            }
        }
    }
}
