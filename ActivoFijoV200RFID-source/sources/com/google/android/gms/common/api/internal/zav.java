package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.7.0 */
/* loaded from: classes2.dex */
final class zav implements zabu {
    final /* synthetic */ zax zaa;

    /* synthetic */ zav(zax zaxVar, byte[] bArr) {
        this.zaa = zaxVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final void zaa(Bundle bundle) {
        zax zaxVar = this.zaa;
        zaxVar.zay().lock();
        try {
            zaxVar.zaq(bundle);
            zaxVar.zat(ConnectionResult.RESULT_SUCCESS);
            zaxVar.zao();
        } finally {
            this.zaa.zay().unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final void zab(ConnectionResult connectionResult) {
        zax zaxVar = this.zaa;
        zaxVar.zay().lock();
        try {
            zaxVar.zat(connectionResult);
            zaxVar.zao();
        } finally {
            this.zaa.zay().unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final void zac(int i, boolean z) {
        Lock zay;
        zax zaxVar = this.zaa;
        zaxVar.zay().lock();
        try {
            if (!zaxVar.zaw() && zaxVar.zau() != null && zaxVar.zau().isSuccess()) {
                zaxVar.zax(true);
                zaxVar.zas().onConnectionSuspended(i);
                zay = this.zaa.zay();
                zay.unlock();
            }
            zaxVar.zax(false);
            zaxVar.zap(i, z);
            zay = zaxVar.zay();
            zay.unlock();
        } catch (Throwable th) {
            this.zaa.zay().unlock();
            throw th;
        }
    }
}
