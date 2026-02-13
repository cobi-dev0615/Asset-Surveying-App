package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.3.0 */
/* loaded from: classes2.dex */
final class zzi implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzj zzb;

    zzi(zzj zzjVar, Task task) {
        this.zza = task;
        this.zzb = zzjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzj zzjVar = this.zzb;
        synchronized (zzjVar.zzc()) {
            if (zzjVar.zzd() != null) {
                zzjVar.zzd().onComplete(this.zza);
            }
        }
    }
}
