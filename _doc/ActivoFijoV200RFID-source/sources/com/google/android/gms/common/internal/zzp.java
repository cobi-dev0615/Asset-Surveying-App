package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
final class zzp implements Handler.Callback {
    final /* synthetic */ zzq zza;

    /* synthetic */ zzp(zzq zzqVar, byte[] bArr) {
        this.zza = zzqVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            zzq zzqVar = this.zza;
            synchronized (zzqVar.zzf()) {
                zzn zznVar = (zzn) message.obj;
                zzo zzoVar = (zzo) zzqVar.zzf().get(zznVar);
                if (zzoVar != null && zzoVar.zzg()) {
                    if (zzoVar.zzd()) {
                        zzoVar.zza("GmsClientSupervisor");
                    }
                    zzqVar.zzf().remove(zznVar);
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        zzq zzqVar2 = this.zza;
        synchronized (zzqVar2.zzf()) {
            zzn zznVar2 = (zzn) message.obj;
            zzo zzoVar2 = (zzo) zzqVar2.zzf().get(zznVar2);
            if (zzoVar2 != null && zzoVar2.zze() == 3) {
                String valueOf = String.valueOf(zznVar2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                sb.append("Timeout waiting for ServiceConnection callback ");
                sb.append(valueOf);
                Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                ComponentName zzi = zzoVar2.zzi();
                if (zzi == null) {
                    zzi = zznVar2.zzc();
                }
                if (zzi == null) {
                    String zzb = zznVar2.zzb();
                    Preconditions.checkNotNull(zzb);
                    String str = zzb;
                    zzi = new ComponentName(zzb, EnvironmentCompat.MEDIA_UNKNOWN);
                }
                zzoVar2.onServiceDisconnected(zzi);
            }
        }
        return true;
    }
}
