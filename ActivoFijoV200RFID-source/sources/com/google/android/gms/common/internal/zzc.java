package com.google.android.gms.common.internal;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
public abstract class zzc {
    private Object zza;
    private boolean zzb = false;
    final /* synthetic */ BaseGmsClient zzd;

    public zzc(BaseGmsClient baseGmsClient, Object obj) {
        this.zzd = baseGmsClient;
        this.zza = obj;
    }

    protected abstract void zzc(Object obj);

    public final void zzd() {
        Object obj;
        synchronized (this) {
            obj = this.zza;
            if (this.zzb) {
                String obj2 = toString();
                StringBuilder sb = new StringBuilder(obj2.length() + 47);
                sb.append("Callback proxy ");
                sb.append(obj2);
                sb.append(" being reused. This is not safe.");
                Log.w("GmsClient", sb.toString());
            }
        }
        if (obj != null) {
            zzc(obj);
        }
        synchronized (this) {
            this.zzb = true;
        }
        zze();
    }

    public final void zze() {
        zzf();
        BaseGmsClient baseGmsClient = this.zzd;
        synchronized (baseGmsClient.zzj()) {
            baseGmsClient.zzj().remove(this);
        }
    }

    public final void zzf() {
        synchronized (this) {
            this.zza = null;
        }
    }
}
