package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.7.0 */
/* loaded from: classes2.dex */
final class zau implements Runnable {
    final /* synthetic */ zax zaa;

    zau(zax zaxVar) {
        this.zaa = zaxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zax zaxVar = this.zaa;
        zaxVar.zay().lock();
        try {
            zaxVar.zao();
        } finally {
            this.zaa.zay().unlock();
        }
    }
}
