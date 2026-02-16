package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@18.7.0 */
/* loaded from: classes2.dex */
public class AvailabilityException extends Exception {
    private final ArrayMap zaa;

    public AvailabilityException(ArrayMap arrayMap) {
        this.zaa = arrayMap;
    }

    public ConnectionResult getConnectionResult(GoogleApi<? extends Api.ApiOptions> googleApi) {
        ArrayMap arrayMap = this.zaa;
        ApiKey<? extends Api.ApiOptions> apiKey = googleApi.getApiKey();
        Object obj = arrayMap.get(apiKey);
        String zaa = apiKey.zaa();
        StringBuilder sb = new StringBuilder(String.valueOf(zaa).length() + 58);
        sb.append("The given API (");
        sb.append(zaa);
        sb.append(") was not part of the availability request.");
        Preconditions.checkArgument(obj != null, sb.toString());
        return (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) arrayMap.get(apiKey));
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = this.zaa;
        boolean z = true;
        for (ApiKey apiKey : arrayMap.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) arrayMap.get(apiKey));
            z &= !connectionResult.isSuccess();
            String zaa = apiKey.zaa();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(zaa).length() + 2 + String.valueOf(valueOf).length());
            sb.append(zaa);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }

    public ConnectionResult getConnectionResult(HasApiKey<? extends Api.ApiOptions> hasApiKey) {
        ArrayMap arrayMap = this.zaa;
        ApiKey<? extends Api.ApiOptions> apiKey = hasApiKey.getApiKey();
        Object obj = arrayMap.get(apiKey);
        String zaa = apiKey.zaa();
        StringBuilder sb = new StringBuilder(String.valueOf(zaa).length() + 58);
        sb.append("The given API (");
        sb.append(zaa);
        sb.append(") was not part of the availability request.");
        Preconditions.checkArgument(obj != null, sb.toString());
        return (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) arrayMap.get(apiKey));
    }
}
