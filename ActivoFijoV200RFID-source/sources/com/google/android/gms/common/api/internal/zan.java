package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* compiled from: com.google.android.gms:play-services-base@@18.7.0 */
/* loaded from: classes2.dex */
final class zan extends zabr {
    final /* synthetic */ Dialog zaa;
    final /* synthetic */ zao zab;

    zan(zao zaoVar, Dialog dialog) {
        this.zaa = dialog;
        this.zab = zaoVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void zaa() {
        this.zab.zaa.zag();
        Dialog dialog = this.zaa;
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
