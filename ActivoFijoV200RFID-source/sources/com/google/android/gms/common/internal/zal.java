package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@18.7.0 */
/* loaded from: classes2.dex */
public final class zal {
    private final SparseIntArray zaa;
    private GoogleApiAvailabilityLight zab;

    public zal() {
        this(GoogleApiAvailability.getInstance());
    }

    public final int zaa(Context context, Api.Client client) {
        int isGooglePlayServicesAvailable;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        int i = 0;
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int zab = zab(context, minApkVersion);
        if (zab != -1) {
            return zab;
        }
        SparseIntArray sparseIntArray = this.zaa;
        synchronized (sparseIntArray) {
            int i2 = 0;
            while (true) {
                if (i2 >= sparseIntArray.size()) {
                    i = -1;
                    break;
                }
                int keyAt = sparseIntArray.keyAt(i2);
                if (keyAt > minApkVersion && sparseIntArray.get(keyAt) == 0) {
                    break;
                }
                i2++;
            }
            isGooglePlayServicesAvailable = i == -1 ? this.zab.isGooglePlayServicesAvailable(context, minApkVersion) : i;
            sparseIntArray.put(minApkVersion, isGooglePlayServicesAvailable);
        }
        return isGooglePlayServicesAvailable;
    }

    public final int zab(Context context, int i) {
        int i2;
        SparseIntArray sparseIntArray = this.zaa;
        synchronized (sparseIntArray) {
            i2 = sparseIntArray.get(i, -1);
        }
        return i2;
    }

    public final void zac() {
        SparseIntArray sparseIntArray = this.zaa;
        synchronized (sparseIntArray) {
            sparseIntArray.clear();
        }
    }

    public zal(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.zaa = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.zab = googleApiAvailabilityLight;
    }
}
