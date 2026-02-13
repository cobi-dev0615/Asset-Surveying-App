package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.7.0 */
/* loaded from: classes2.dex */
public final class zabk implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zat {
    final /* synthetic */ GoogleApiManager zaa;
    private final Api.Client zac;
    private final ApiKey zad;
    private final zaaa zae;
    private final int zah;
    private final zacm zai;
    private boolean zaj;
    private final Queue zab = new LinkedList();
    private final Set zaf = new HashSet();
    private final Map zag = new HashMap();
    private final List zak = new ArrayList();
    private ConnectionResult zal = null;
    private int zam = 0;

    public zabk(GoogleApiManager googleApiManager, GoogleApi googleApi) {
        this.zaa = googleApiManager;
        Api.Client zaa = googleApi.zaa(googleApiManager.zaF().getLooper(), this);
        this.zac = zaa;
        this.zad = googleApi.getApiKey();
        this.zae = new zaaa();
        this.zah = googleApi.zab();
        if (zaa.requiresSignIn()) {
            this.zai = googleApi.zac(googleApiManager.zaz(), googleApiManager.zaF());
        } else {
            this.zai = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zaC, reason: merged with bridge method [inline-methods] */
    public final void zat() {
        zah();
        zaN(ConnectionResult.RESULT_SUCCESS);
        zaK();
        Iterator it = this.zag.values().iterator();
        while (it.hasNext()) {
            RegisterListenerMethod registerListenerMethod = ((zacd) it.next()).zaa;
            if (zaO(registerListenerMethod.getRequiredFeatures()) != null) {
                it.remove();
            } else {
                try {
                    registerListenerMethod.registerListener(this.zac, new TaskCompletionSource<>());
                } catch (DeadObjectException unused) {
                    onConnectionSuspended(3);
                    this.zac.disconnect("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException e) {
                    e = e;
                    Log.e("GoogleApiManager", "Failed to register listener on re-connection.", e);
                    it.remove();
                } catch (RuntimeException e2) {
                    e = e2;
                    Log.e("GoogleApiManager", "Failed to register listener on re-connection.", e);
                    it.remove();
                }
            }
        }
        zaF();
        zaL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zaD, reason: merged with bridge method [inline-methods] */
    public final void zau(int i) {
        zah();
        this.zaj = true;
        this.zae.zae(i, this.zac.getLastDisconnectMessage());
        ApiKey apiKey = this.zad;
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.zaF().sendMessageDelayed(Message.obtain(googleApiManager.zaF(), 9, apiKey), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        googleApiManager.zaF().sendMessageDelayed(Message.obtain(googleApiManager.zaF(), 11, apiKey), 120000L);
        googleApiManager.zaB().zac();
        Iterator it = this.zag.values().iterator();
        while (it.hasNext()) {
            ((zacd) it.next()).zac.run();
        }
    }

    private final boolean zaE(ConnectionResult connectionResult) {
        Object obj;
        obj = GoogleApiManager.zae;
        synchronized (obj) {
            GoogleApiManager googleApiManager = this.zaa;
            if (googleApiManager.zaD() == null || !googleApiManager.zaE().contains(this.zad)) {
                return false;
            }
            googleApiManager.zaD().zaf(connectionResult, this.zah);
            return true;
        }
    }

    private final void zaF() {
        Queue queue = this.zab;
        ArrayList arrayList = new ArrayList(queue);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zai zaiVar = (zai) arrayList.get(i);
            if (!this.zac.isConnected()) {
                return;
            }
            if (zaG(zaiVar)) {
                queue.remove(zaiVar);
            }
        }
    }

    private final boolean zaG(zai zaiVar) {
        if (!(zaiVar instanceof zac)) {
            zaH(zaiVar);
            return true;
        }
        zac zacVar = (zac) zaiVar;
        Feature zaO = zaO(zacVar.zaa(this));
        if (zaO == null) {
            zaH(zaiVar);
            return true;
        }
        String name = this.zac.getClass().getName();
        String name2 = zaO.getName();
        long version = zaO.getVersion();
        int length = String.valueOf(name).length();
        StringBuilder sb = new StringBuilder(length + 53 + String.valueOf(name2).length() + 2 + String.valueOf(version).length() + 2);
        sb.append(name);
        sb.append(" could not execute call because it requires feature (");
        sb.append(name2);
        sb.append(", ");
        sb.append(version);
        sb.append(").");
        Log.w("GoogleApiManager", sb.toString());
        GoogleApiManager googleApiManager = this.zaa;
        if (!googleApiManager.zaG() || !zacVar.zab(this)) {
            zacVar.zad(new UnsupportedApiCallException(zaO));
            return true;
        }
        zabl zablVar = new zabl(this.zad, zaO, null);
        List list = this.zak;
        int indexOf = list.indexOf(zablVar);
        if (indexOf >= 0) {
            zabl zablVar2 = (zabl) list.get(indexOf);
            googleApiManager.zaF().removeMessages(15, zablVar2);
            googleApiManager.zaF().sendMessageDelayed(Message.obtain(googleApiManager.zaF(), 15, zablVar2), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
            return false;
        }
        list.add(zablVar);
        googleApiManager.zaF().sendMessageDelayed(Message.obtain(googleApiManager.zaF(), 15, zablVar), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        googleApiManager.zaF().sendMessageDelayed(Message.obtain(googleApiManager.zaF(), 16, zablVar), 120000L);
        ConnectionResult connectionResult = new ConnectionResult(2, null);
        if (zaE(connectionResult)) {
            return false;
        }
        googleApiManager.zap(connectionResult, this.zah);
        return false;
    }

    private final void zaH(zai zaiVar) {
        zaiVar.zae(this.zae, zap());
        try {
            zaiVar.zaf(this);
        } catch (DeadObjectException unused) {
            onConnectionSuspended(1);
            this.zac.disconnect("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    private final void zaI(Status status, Exception exc, boolean z) {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.zab.iterator();
        while (it.hasNext()) {
            zai zaiVar = (zai) it.next();
            if (!z || zaiVar.zac == 2) {
                if (status != null) {
                    zaiVar.zac(status);
                } else {
                    zaiVar.zad(exc);
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zaJ, reason: merged with bridge method [inline-methods] */
    public final void zav(Status status) {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        zaI(status, null, false);
    }

    private final void zaK() {
        if (this.zaj) {
            GoogleApiManager googleApiManager = this.zaa;
            ApiKey apiKey = this.zad;
            googleApiManager.zaF().removeMessages(11, apiKey);
            googleApiManager.zaF().removeMessages(9, apiKey);
            this.zaj = false;
        }
    }

    private final void zaL() {
        ApiKey apiKey = this.zad;
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.zaF().removeMessages(12, apiKey);
        googleApiManager.zaF().sendMessageDelayed(googleApiManager.zaF().obtainMessage(12, apiKey), googleApiManager.zaw());
    }

    private final boolean zaM(boolean z) {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        Api.Client client = this.zac;
        if (!client.isConnected() || !this.zag.isEmpty()) {
            return false;
        }
        if (!this.zae.zac()) {
            client.disconnect("Timing out service connection.");
            return true;
        }
        if (!z) {
            return false;
        }
        zaL();
        return false;
    }

    private final void zaN(ConnectionResult connectionResult) {
        Set set = this.zaf;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((zal) it.next()).zac(this.zad, connectionResult, Objects.equal(connectionResult, ConnectionResult.RESULT_SUCCESS) ? this.zac.getEndpointPackageName() : null);
        }
        set.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Feature zaO(Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            Feature[] availableFeatures = this.zac.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            ArrayMap arrayMap = new ArrayMap(availableFeatures.length);
            for (Feature feature : availableFeatures) {
                arrayMap.put(feature.getName(), Long.valueOf(feature.getVersion()));
            }
            for (Feature feature2 : featureArr) {
                Long l = (Long) arrayMap.get(feature2.getName());
                if (l == null || l.longValue() < feature2.getVersion()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        GoogleApiManager googleApiManager = this.zaa;
        if (Looper.myLooper() == googleApiManager.zaF().getLooper()) {
            zat();
        } else {
            googleApiManager.zaF().post(new zabg(this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zac(connectionResult, null);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        GoogleApiManager googleApiManager = this.zaa;
        if (Looper.myLooper() == googleApiManager.zaF().getLooper()) {
            zau(i);
        } else {
            googleApiManager.zaF().post(new zabh(this, i));
        }
    }

    final /* synthetic */ ApiKey zaA() {
        return this.zad;
    }

    final /* synthetic */ boolean zaB() {
        return this.zaj;
    }

    @Override // com.google.android.gms.common.api.internal.zat
    public final void zaa(ConnectionResult connectionResult, Api api, boolean z) {
        throw null;
    }

    public final void zab(ConnectionResult connectionResult) {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        Api.Client client = this.zac;
        String name = client.getClass().getName();
        String valueOf = String.valueOf(connectionResult);
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 25 + String.valueOf(valueOf).length());
        sb.append("onSignInFailed for ");
        sb.append(name);
        sb.append(" with ");
        sb.append(valueOf);
        client.disconnect(sb.toString());
        zac(connectionResult, null);
    }

    public final void zac(ConnectionResult connectionResult, Exception exc) {
        Status zaJ;
        Status zaJ2;
        Status zaJ3;
        Status zaJ4;
        Status status;
        GoogleApiManager googleApiManager = this.zaa;
        Preconditions.checkHandlerThread(googleApiManager.zaF());
        zacm zacmVar = this.zai;
        if (zacmVar != null) {
            zacmVar.zad();
        }
        zah();
        googleApiManager.zaB().zac();
        zaN(connectionResult);
        if ((this.zac instanceof com.google.android.gms.common.internal.service.zap) && connectionResult.getErrorCode() != 24) {
            googleApiManager.zax(true);
            googleApiManager.zaF().sendMessageDelayed(googleApiManager.zaF().obtainMessage(19), 300000L);
        }
        if (connectionResult.getErrorCode() == 4) {
            status = GoogleApiManager.zab;
            zav(status);
            return;
        }
        if (connectionResult.getErrorCode() == 25) {
            zaJ4 = GoogleApiManager.zaJ(this.zad, connectionResult);
            zav(zaJ4);
            return;
        }
        Queue queue = this.zab;
        if (queue.isEmpty()) {
            this.zal = connectionResult;
            return;
        }
        if (exc != null) {
            Preconditions.checkHandlerThread(googleApiManager.zaF());
            zaI(null, exc, false);
            return;
        }
        if (!googleApiManager.zaG()) {
            zaJ = GoogleApiManager.zaJ(this.zad, connectionResult);
            zav(zaJ);
            return;
        }
        ApiKey apiKey = this.zad;
        zaJ2 = GoogleApiManager.zaJ(apiKey, connectionResult);
        zaI(zaJ2, null, true);
        if (queue.isEmpty() || zaE(connectionResult) || googleApiManager.zap(connectionResult, this.zah)) {
            return;
        }
        if (connectionResult.getErrorCode() == 18) {
            this.zaj = true;
        }
        if (this.zaj) {
            googleApiManager.zaF().sendMessageDelayed(Message.obtain(googleApiManager.zaF(), 9, apiKey), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        } else {
            zaJ3 = GoogleApiManager.zaJ(apiKey, connectionResult);
            zav(zaJ3);
        }
    }

    public final void zad(zai zaiVar) {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        if (this.zac.isConnected()) {
            if (zaG(zaiVar)) {
                zaL();
                return;
            } else {
                this.zab.add(zaiVar);
                return;
            }
        }
        this.zab.add(zaiVar);
        ConnectionResult connectionResult = this.zal;
        if (connectionResult == null || !connectionResult.hasResolution()) {
            zam();
        } else {
            zac(this.zal, null);
        }
    }

    public final void zae() {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        zav(GoogleApiManager.zaa);
        this.zae.zad();
        for (ListenerHolder.ListenerKey listenerKey : (ListenerHolder.ListenerKey[]) this.zag.keySet().toArray(new ListenerHolder.ListenerKey[0])) {
            zad(new zah(listenerKey, new TaskCompletionSource()));
        }
        zaN(new ConnectionResult(4));
        Api.Client client = this.zac;
        if (client.isConnected()) {
            client.onUserSignOut(new zabj(this));
        }
    }

    public final Api.Client zaf() {
        return this.zac;
    }

    public final Map zag() {
        return this.zag;
    }

    public final void zah() {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        this.zal = null;
    }

    public final ConnectionResult zai() {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        return this.zal;
    }

    public final void zaj() {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        if (this.zaj) {
            zam();
        }
    }

    public final void zak() {
        GoogleApiManager googleApiManager = this.zaa;
        Preconditions.checkHandlerThread(googleApiManager.zaF());
        if (this.zaj) {
            zaK();
            zav(googleApiManager.zaA().isGooglePlayServicesAvailable(googleApiManager.zaz()) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.zac.disconnect("Timing out connection while resuming.");
        }
    }

    public final boolean zal() {
        return zaM(true);
    }

    public final void zam() {
        GoogleApiManager googleApiManager = this.zaa;
        Preconditions.checkHandlerThread(googleApiManager.zaF());
        Api.Client client = this.zac;
        if (client.isConnected() || client.isConnecting()) {
            return;
        }
        try {
            int zaa = googleApiManager.zaB().zaa(googleApiManager.zaz(), client);
            if (zaa == 0) {
                zabn zabnVar = new zabn(googleApiManager, client, this.zad);
                if (client.requiresSignIn()) {
                    ((zacm) Preconditions.checkNotNull(this.zai)).zac(zabnVar);
                }
                try {
                    client.connect(zabnVar);
                    return;
                } catch (SecurityException e) {
                    zac(new ConnectionResult(10), e);
                    return;
                }
            }
            ConnectionResult connectionResult = new ConnectionResult(zaa, null);
            String name = this.zac.getClass().getName();
            String obj = connectionResult.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 35 + obj.length());
            sb.append("The service for ");
            sb.append(name);
            sb.append(" is not available: ");
            sb.append(obj);
            Log.w("GoogleApiManager", sb.toString());
            zac(connectionResult, null);
        } catch (IllegalStateException e2) {
            zac(new ConnectionResult(10), e2);
        }
    }

    public final void zan(zal zalVar) {
        Preconditions.checkHandlerThread(this.zaa.zaF());
        this.zaf.add(zalVar);
    }

    final boolean zao() {
        return this.zac.isConnected();
    }

    public final boolean zap() {
        return this.zac.requiresSignIn();
    }

    public final int zaq() {
        return this.zah;
    }

    final int zar() {
        return this.zam;
    }

    final void zas() {
        this.zam++;
    }

    final /* synthetic */ boolean zaw(boolean z) {
        return zaM(false);
    }

    final /* synthetic */ void zax(zabl zablVar) {
        if (this.zak.contains(zablVar) && !this.zaj) {
            if (this.zac.isConnected()) {
                zaF();
            } else {
                zam();
            }
        }
    }

    final /* synthetic */ void zay(zabl zablVar) {
        Feature[] zaa;
        if (this.zak.remove(zablVar)) {
            GoogleApiManager googleApiManager = this.zaa;
            googleApiManager.zaF().removeMessages(15, zablVar);
            googleApiManager.zaF().removeMessages(16, zablVar);
            Feature zab = zablVar.zab();
            Queue<zai> queue = this.zab;
            ArrayList arrayList = new ArrayList(queue.size());
            for (zai zaiVar : queue) {
                if ((zaiVar instanceof zac) && (zaa = ((zac) zaiVar).zaa(this)) != null && ArrayUtils.contains(zaa, zab)) {
                    arrayList.add(zaiVar);
                }
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zai zaiVar2 = (zai) arrayList.get(i);
                queue.remove(zaiVar2);
                zaiVar2.zad(new UnsupportedApiCallException(zab));
            }
        }
    }

    final /* synthetic */ Api.Client zaz() {
        return this.zac;
    }
}
