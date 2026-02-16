package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* loaded from: classes2.dex */
public abstract class zzxn {
    public static zzxn zzg(Iterable iterable, int i, int i2, float f) {
        Iterator it = iterable.iterator();
        int i3 = 0;
        int i4 = i;
        int i5 = i2;
        int i6 = 0;
        while (it.hasNext()) {
            Point point = (Point) it.next();
            i4 = Math.min(i4, point.x);
            i5 = Math.min(i5, point.y);
            i3 = Math.max(i3, point.x);
            i6 = Math.max(i6, point.y);
        }
        float f2 = i;
        float f3 = i2;
        return new zzxg((i4 + 0.0f) / f2, (i5 + 0.0f) / f3, (i3 + 0.0f) / f2, (i6 + 0.0f) / f3, 0.0f);
    }

    abstract float zza();

    abstract float zzb();

    abstract float zzc();

    abstract float zzd();

    abstract float zze();

    final float zzf() {
        if (zzh()) {
            return (zzb() - zzc()) * (zzd() - zze());
        }
        return 0.0f;
    }

    final boolean zzh() {
        return zzc() >= 0.0f && zzc() < zzb() && zzb() <= 1.0f && zze() >= 0.0f && zze() < zzd() && zzd() <= 1.0f;
    }
}
