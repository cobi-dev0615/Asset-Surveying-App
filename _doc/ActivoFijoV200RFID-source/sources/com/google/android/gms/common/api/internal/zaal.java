package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.7.0 */
/* loaded from: classes2.dex */
final class zaal extends zaaq {
    final /* synthetic */ zaar zaa;
    private final Map zac;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaal(zaar zaarVar, Map map) {
        super(zaarVar, null);
        this.zaa = zaarVar;
        this.zac = map;
    }

    @Override // com.google.android.gms.common.api.internal.zaaq
    public final void zaa() {
        zaar zaarVar = this.zaa;
        com.google.android.gms.common.internal.zal zalVar = new com.google.android.gms.common.internal.zal(zaarVar.zau());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Map map = this.zac;
        for (Api.Client client : map.keySet()) {
            if (!client.requiresGooglePlayServices() || ((zaai) map.get(client)).zaa()) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        int i = 0;
        int i2 = -1;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i < size) {
                i2 = zalVar.zaa(zaarVar.zat(), (Api.Client) arrayList.get(i));
                i++;
                if (i2 != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i < size2) {
                i2 = zalVar.zaa(zaarVar.zat(), (Api.Client) arrayList2.get(i));
                i++;
                if (i2 == 0) {
                    break;
                }
            }
        }
        if (i2 != 0) {
            zaarVar.zar().zar(new zaaj(this, zaarVar, new ConnectionResult(i2, null)));
            return;
        }
        if (zaarVar.zaw() && zaarVar.zav() != null) {
            zaarVar.zav().zad();
        }
        for (Api.Client client2 : map.keySet()) {
            BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = (BaseGmsClient.ConnectionProgressReportCallbacks) map.get(client2);
            if (!client2.requiresGooglePlayServices() || zalVar.zaa(zaarVar.zat(), client2) == 0) {
                client2.connect(connectionProgressReportCallbacks);
            } else {
                zaarVar.zar().zar(new zaak(this, zaarVar, connectionProgressReportCallbacks));
            }
        }
    }
}
