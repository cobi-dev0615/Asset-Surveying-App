package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
abstract class zzm extends zzk {
    private static final WeakReference zzb = new WeakReference(null);
    private WeakReference zza;

    zzm(byte[] bArr) {
        super(bArr);
        this.zza = zzb;
    }

    protected abstract byte[] zzb();

    @Override // com.google.android.gms.common.zzk
    final byte[] zzc() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.zza.get();
            if (bArr == null) {
                bArr = zzb();
                this.zza = new WeakReference(bArr);
            }
        }
        return bArr;
    }
}
