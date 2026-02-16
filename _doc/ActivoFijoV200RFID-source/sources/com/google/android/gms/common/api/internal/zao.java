package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.7.0 */
/* loaded from: classes2.dex */
final class zao implements Runnable {
    final /* synthetic */ zap zaa;
    private final zam zab;

    zao(zap zapVar, zam zamVar) {
        this.zaa = zapVar;
        this.zab = zamVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zap zapVar = this.zaa;
        if (zapVar.zaa) {
            zam zamVar = this.zab;
            ConnectionResult zab = zamVar.zab();
            if (zab.hasResolution()) {
                zapVar.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(zapVar.getActivity(), (PendingIntent) Preconditions.checkNotNull(zab.getResolution()), zamVar.zaa(), false), 1);
                return;
            }
            Activity activity = zapVar.getActivity();
            int errorCode = zab.getErrorCode();
            GoogleApiAvailability googleApiAvailability = zapVar.zac;
            if (googleApiAvailability.getErrorResolutionIntent(activity, errorCode, null) != null) {
                googleApiAvailability.zab(zapVar.getActivity(), zapVar.mLifecycleFragment, zab.getErrorCode(), 2, zapVar);
            } else if (zab.getErrorCode() != 18) {
                zapVar.zah(zab, zamVar.zaa());
            } else {
                googleApiAvailability.zaf(zapVar.getActivity().getApplicationContext(), new zan(this, googleApiAvailability.zae(zapVar.getActivity(), zapVar)));
            }
        }
    }
}
