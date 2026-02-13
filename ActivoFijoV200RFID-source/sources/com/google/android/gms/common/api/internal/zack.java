package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.7.0 */
/* loaded from: classes2.dex */
final class zack implements Runnable {
    final /* synthetic */ com.google.android.gms.signin.internal.zak zaa;
    final /* synthetic */ zacm zab;

    zack(zacm zacmVar, com.google.android.gms.signin.internal.zak zakVar) {
        this.zaa = zakVar;
        this.zab = zacmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zab.zae(this.zaa);
    }
}
