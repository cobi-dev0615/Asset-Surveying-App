package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.7.0 */
/* loaded from: classes2.dex */
abstract class zaaq implements Runnable {
    final /* synthetic */ zaar zab;

    /* synthetic */ zaaq(zaar zaarVar, byte[] bArr) {
        this.zab = zaarVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Lock zas;
        zaar zaarVar = this.zab;
        zaarVar.zas().lock();
        try {
            try {
            } catch (RuntimeException e) {
                this.zab.zar().zas(e);
            }
            if (Thread.interrupted()) {
                zas = zaarVar.zas();
                zas.unlock();
            } else {
                zaa();
                zas = this.zab.zas();
                zas.unlock();
            }
        } catch (Throwable th) {
            this.zab.zas().unlock();
            throw th;
        }
    }

    protected abstract void zaa();
}
