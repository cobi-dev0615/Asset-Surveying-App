package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-base@@18.7.0 */
/* loaded from: classes2.dex */
public final class ListenerHolder<L> {
    private static final Object zaa = new Object();
    private final Executor zab;
    private volatile Object zac;
    private volatile ListenerKey zad;

    /* compiled from: com.google.android.gms:play-services-base@@18.7.0 */
    public static final class ListenerKey<L> {
        private final Object zaa;
        private final String zab;

        ListenerKey(L l, String str) {
            this.zaa = l;
            this.zab = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            return this.zaa == listenerKey.zaa && this.zab.equals(listenerKey.zab);
        }

        public int hashCode() {
            return (System.identityHashCode(this.zaa) * 31) + this.zab.hashCode();
        }

        public String toIdString() {
            int identityHashCode = System.identityHashCode(this.zaa);
            String str = this.zab;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(identityHashCode).length());
            sb.append(str);
            sb.append("@");
            sb.append(identityHashCode);
            return sb.toString();
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.7.0 */
    public interface Notifier<L> {
        void notifyListener(L l);

        void onNotifyListenerFailed();
    }

    ListenerHolder(Looper looper, L l, String str) {
        this.zab = new HandlerExecutor(looper);
        this.zac = Preconditions.checkNotNull(l, "Listener must not be null");
        this.zad = new ListenerKey(l, Preconditions.checkNotEmpty(str));
    }

    public void clear() {
        synchronized (zaa) {
            this.zac = null;
            this.zad = null;
        }
    }

    public ListenerKey<L> getListenerKey() {
        ListenerKey<L> listenerKey;
        synchronized (zaa) {
            listenerKey = this.zad;
        }
        return listenerKey;
    }

    public boolean hasListener() {
        boolean z;
        synchronized (zaa) {
            z = this.zac != null;
        }
        return z;
    }

    public void notifyListener(final Notifier<? super L> notifier) {
        Preconditions.checkNotNull(notifier, "Notifier must not be null");
        this.zab.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.zabw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                ListenerHolder.this.zaa(notifier);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ void zaa(Notifier notifier) {
        synchronized (zaa) {
            Object obj = this.zac;
            if (obj == null) {
                notifier.onNotifyListenerFailed();
            } else {
                try {
                    notifier.notifyListener(obj);
                } catch (RuntimeException e) {
                    notifier.onNotifyListenerFailed();
                    throw e;
                }
            }
        }
    }

    ListenerHolder(Executor executor, L l, String str) {
        this.zab = (Executor) Preconditions.checkNotNull(executor, "Executor must not be null");
        this.zac = Preconditions.checkNotNull(l, "Listener must not be null");
        this.zad = new ListenerKey(l, Preconditions.checkNotEmpty(str));
    }
}
