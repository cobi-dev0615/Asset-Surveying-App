package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.7.0 */
/* loaded from: classes2.dex */
final class zaah implements Runnable {
    final /* synthetic */ zaar zaa;

    zaah(zaar zaarVar) {
        this.zaa = zaarVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zaar zaarVar = this.zaa;
        zaarVar.zau().cancelAvailabilityErrorNotifications(zaarVar.zat());
    }
}
