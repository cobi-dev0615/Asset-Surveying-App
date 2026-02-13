package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes2.dex */
final class zzgg {
    public static final /* synthetic */ int zza = 0;
    private static final zzgs zzb;

    static {
        int i = zzfu.zza;
        zzb = new zzgu();
    }

    public static void zzA(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzC(i, list, z);
    }

    public static void zzB(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzE(i, list, z);
    }

    public static void zzC(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzJ(i, list, z);
    }

    public static void zzD(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzL(i, list, z);
    }

    static boolean zzE(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzei) {
            zzei zzeiVar = (zzei) list;
            i = 0;
            while (i2 < size) {
                i += zzdn.zzB(zzeiVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdn.zzB(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzdn.zzA(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzdn.zzA(i << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzei) {
            zzei zzeiVar = (zzei) list;
            i = 0;
            while (i2 < size) {
                i += zzdn.zzB(zzeiVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdn.zzB(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzg(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfb) {
            zzfb zzfbVar = (zzfb) list;
            i = 0;
            while (i2 < size) {
                i += zzdn.zzB(zzfbVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdn.zzB(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzh(int i, Object obj, zzge zzgeVar) {
        int i2 = i << 3;
        if (!(obj instanceof zzex)) {
            return zzdn.zzA(i2) + zzdn.zzy((zzfm) obj, zzgeVar);
        }
        int zzA = zzdn.zzA(i2);
        int zza2 = ((zzex) obj).zza();
        return zzA + zzdn.zzA(zza2) + zza2;
    }

    static int zzi(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzei) {
            zzei zzeiVar = (zzei) list;
            i = 0;
            while (i2 < size) {
                int zze = zzeiVar.zze(i2);
                i += zzdn.zzA((zze >> 31) ^ (zze + zze));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i += zzdn.zzA((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    static int zzj(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfb) {
            zzfb zzfbVar = (zzfb) list;
            i = 0;
            while (i2 < size) {
                long zze = zzfbVar.zze(i2);
                i += zzdn.zzB((zze >> 63) ^ (zze + zze));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i += zzdn.zzB((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    static int zzk(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzei) {
            zzei zzeiVar = (zzei) list;
            i = 0;
            while (i2 < size) {
                i += zzdn.zzA(zzeiVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdn.zzA(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzl(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfb) {
            zzfb zzfbVar = (zzfb) list;
            i = 0;
            while (i2 < size) {
                i += zzdn.zzB(zzfbVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdn.zzB(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzgs zzm() {
        return zzb;
    }

    static Object zzn(Object obj, int i, int i2, Object obj2, zzgs zzgsVar) {
        Object obj3 = obj2;
        if (obj2 == null) {
            zzeh zzehVar = (zzeh) obj;
            zzgt zzgtVar = zzehVar.zzc;
            obj3 = zzgtVar;
            if (zzgtVar == zzgt.zzc()) {
                zzgt zzf = zzgt.zzf();
                zzehVar.zzc = zzf;
                obj3 = zzf;
            }
        }
        ((zzgt) obj3).zzj(i << 3, Long.valueOf(i2));
        return obj3;
    }

    static void zzo(zzdt zzdtVar, Object obj, Object obj2) {
        zzdx zzdxVar = ((zzed) obj2).zzb;
        if (zzdxVar.zza.isEmpty()) {
            return;
        }
        ((zzed) obj).zzc().zzh(zzdxVar);
    }

    static void zzp(zzgs zzgsVar, Object obj, Object obj2) {
        zzeh zzehVar = (zzeh) obj;
        zzgt zzgtVar = zzehVar.zzc;
        zzgt zzgtVar2 = ((zzeh) obj2).zzc;
        if (!zzgt.zzc().equals(zzgtVar2)) {
            if (zzgt.zzc().equals(zzgtVar)) {
                zzgtVar = zzgt.zze(zzgtVar, zzgtVar2);
            } else {
                zzgtVar.zzd(zzgtVar2);
            }
        }
        zzehVar.zzc = zzgtVar;
    }

    public static void zzq(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzc(i, list, z);
    }

    public static void zzr(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzg(i, list, z);
    }

    public static void zzs(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzj(i, list, z);
    }

    public static void zzt(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzl(i, list, z);
    }

    public static void zzu(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzn(i, list, z);
    }

    public static void zzv(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzp(i, list, z);
    }

    public static void zzw(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzs(i, list, z);
    }

    public static void zzx(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzu(i, list, z);
    }

    public static void zzy(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzy(i, list, z);
    }

    public static void zzz(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzA(i, list, z);
    }
}
