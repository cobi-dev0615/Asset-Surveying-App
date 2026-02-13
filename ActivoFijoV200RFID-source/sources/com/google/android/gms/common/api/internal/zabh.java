package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.7.0 */
/* loaded from: classes2.dex */
final class zabh implements Runnable {
    final /* synthetic */ int zaa;
    final /* synthetic */ zabk zab;

    zabh(zabk zabkVar, int i) {
        this.zaa = i;
        this.zab = zabkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zab.zau(this.zaa);
    }
}
