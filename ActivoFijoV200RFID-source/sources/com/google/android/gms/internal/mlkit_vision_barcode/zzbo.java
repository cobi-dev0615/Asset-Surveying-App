package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* loaded from: classes2.dex */
class zzbo extends AbstractCollection {
    final Object zza;
    Collection zzb;

    @CheckForNull
    final zzbo zzc;

    @CheckForNull
    final Collection zzd;
    final /* synthetic */ zzbr zze;

    zzbo(zzbr zzbrVar, Object obj, @CheckForNull Collection collection, zzbo zzboVar) {
        this.zze = zzbrVar;
        this.zza = obj;
        this.zzb = collection;
        this.zzc = zzboVar;
        this.zzd = zzboVar == null ? null : zzboVar.zzb;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        int i;
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        boolean add = this.zzb.add(obj);
        if (add) {
            zzbr zzbrVar = this.zze;
            i = zzbrVar.zzb;
            zzbrVar.zzb = i + 1;
            if (isEmpty) {
                zza();
                return true;
            }
        }
        return add;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        int i;
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.zzb.addAll(collection);
        if (!addAll) {
            return addAll;
        }
        int size2 = this.zzb.size();
        zzbr zzbrVar = this.zze;
        i = zzbrVar.zzb;
        zzbrVar.zzb = i + (size2 - size);
        if (size != 0) {
            return addAll;
        }
        zza();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int i;
        int size = size();
        if (size == 0) {
            return;
        }
        this.zzb.clear();
        zzbr zzbrVar = this.zze;
        i = zzbrVar.zzb;
        zzbrVar.zzb = i - size;
        zzc();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        zzb();
        return this.zzb.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        zzb();
        return this.zzb.containsAll(collection);
    }

    @Override // java.util.Collection
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        zzb();
        return this.zzb.equals(obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        zzb();
        return this.zzb.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzb();
        return new zzbn(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(@CheckForNull Object obj) {
        int i;
        zzb();
        boolean remove = this.zzb.remove(obj);
        if (remove) {
            zzbr zzbrVar = this.zze;
            i = zzbrVar.zzb;
            zzbrVar.zzb = i - 1;
            zzc();
        }
        return remove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        int i;
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.zzb.removeAll(collection);
        if (removeAll) {
            int size2 = this.zzb.size();
            zzbr zzbrVar = this.zze;
            int i2 = size2 - size;
            i = zzbrVar.zzb;
            zzbrVar.zzb = i + i2;
            zzc();
        }
        return removeAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        zzb();
        return this.zzb.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        zzb();
        return this.zzb.toString();
    }

    final void zza() {
        Map map;
        zzbo zzboVar = this.zzc;
        if (zzboVar != null) {
            zzboVar.zza();
            return;
        }
        zzbr zzbrVar = this.zze;
        Object obj = this.zza;
        map = zzbrVar.zza;
        map.put(obj, this.zzb);
    }

    final void zzb() {
        Map map;
        zzbo zzboVar = this.zzc;
        if (zzboVar != null) {
            zzboVar.zzb();
            zzbo zzboVar2 = this.zzc;
            if (zzboVar2.zzb != this.zzd) {
                throw new ConcurrentModificationException();
            }
            return;
        }
        if (this.zzb.isEmpty()) {
            zzbr zzbrVar = this.zze;
            Object obj = this.zza;
            map = zzbrVar.zza;
            Collection collection = (Collection) map.get(obj);
            if (collection != null) {
                this.zzb = collection;
            }
        }
    }

    final void zzc() {
        Map map;
        zzbo zzboVar = this.zzc;
        if (zzboVar != null) {
            zzboVar.zzc();
        } else if (this.zzb.isEmpty()) {
            zzbr zzbrVar = this.zze;
            Object obj = this.zza;
            map = zzbrVar.zza;
            map.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        int i;
        collection.getClass();
        int size = size();
        boolean retainAll = this.zzb.retainAll(collection);
        if (retainAll) {
            int size2 = this.zzb.size();
            zzbr zzbrVar = this.zze;
            int i2 = size2 - size;
            i = zzbrVar.zzb;
            zzbrVar.zzb = i + i2;
            zzc();
        }
        return retainAll;
    }
}
