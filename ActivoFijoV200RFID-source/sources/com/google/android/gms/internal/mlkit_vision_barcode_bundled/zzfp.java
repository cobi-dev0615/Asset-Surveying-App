package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes2.dex */
final class zzfp<T> implements zzge<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzgz.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfm zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzgs zzl;
    private final zzdt zzm;

    private zzfp(int[] iArr, Object[] objArr, int i, int i2, zzfm zzfmVar, boolean z, int[] iArr2, int i3, int i4, zzfs zzfsVar, zzez zzezVar, zzgs zzgsVar, zzdt zzdtVar, zzfh zzfhVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzdtVar != null && (zzfmVar instanceof zzed)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzgsVar;
        this.zzm = zzdtVar;
        this.zzg = zzfmVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int zzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzge zzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzM(obj2, i2, i)) {
            int zzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = zzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzge zzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j, zze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int zzp = zzp(i);
        long j = 1048575 & zzp;
        if (j == 1048575) {
            return;
        }
        zzgz.zzq(obj, j, (1 << (zzp >>> 20)) | zzgz.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzgz.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int zzp = zzp(i);
        long j = zzp & 1048575;
        if (j != 1048575) {
            return (zzgz.zzc(obj, j) & (1 << (zzp >>> 20))) != 0;
        }
        int zzs = zzs(i);
        long j2 = zzs & 1048575;
        switch (zzr(zzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzgz.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzgz.zzb(obj, j2)) != 0;
            case 2:
                return zzgz.zzd(obj, j2) != 0;
            case 3:
                return zzgz.zzd(obj, j2) != 0;
            case 4:
                return zzgz.zzc(obj, j2) != 0;
            case 5:
                return zzgz.zzd(obj, j2) != 0;
            case 6:
                return zzgz.zzc(obj, j2) != 0;
            case 7:
                return zzgz.zzw(obj, j2);
            case 8:
                Object zzf = zzgz.zzf(obj, j2);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                }
                if (zzf instanceof zzdf) {
                    return !zzdf.zzb.equals(zzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzgz.zzf(obj, j2) != null;
            case 10:
                return !zzdf.zzb.equals(zzgz.zzf(obj, j2));
            case 11:
                return zzgz.zzc(obj, j2) != 0;
            case 12:
                return zzgz.zzc(obj, j2) != 0;
            case 13:
                return zzgz.zzc(obj, j2) != 0;
            case 14:
                return zzgz.zzd(obj, j2) != 0;
            case 15:
                return zzgz.zzc(obj, j2) != 0;
            case 16:
                return zzgz.zzd(obj, j2) != 0;
            case 17:
                return zzgz.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzI(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzge zzgeVar) {
        return zzgeVar.zzk(zzgz.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzeh) {
            return ((zzeh) obj).zzY();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzgz.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzgz.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzhh zzhhVar) throws IOException {
        if (obj instanceof String) {
            zzhhVar.zzG(i, (String) obj);
        } else {
            zzhhVar.zzd(i, (zzdf) obj);
        }
    }

    static zzgt zzd(Object obj) {
        zzeh zzehVar = (zzeh) obj;
        zzgt zzgtVar = zzehVar.zzc;
        if (zzgtVar != zzgt.zzc()) {
            return zzgtVar;
        }
        zzgt zzf = zzgt.zzf();
        zzehVar.zzc = zzf;
        return zzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0268  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp zzl(java.lang.Class r34, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfj r35, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfs r36, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzez r37, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgs r38, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdt r39, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfh r40) {
        /*
            Method dump skipped, instructions count: 1036
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp.zzl(java.lang.Class, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfj, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfs, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzez, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgs, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdt, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfh):com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp");
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzgz.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzgz.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzgz.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzgz.zzf(obj, j)).longValue();
    }

    private final zzel zzu(int i) {
        int i2 = i / 3;
        return (zzel) this.zzd[i2 + i2 + 1];
    }

    private final zzge zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzge zzgeVar = (zzge) objArr[i3];
        if (zzgeVar != null) {
            return zzgeVar;
        }
        zzge zzb2 = zzfu.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzge zzv = zzv(i);
        int zzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzge zzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v115, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v118, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v120, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v185, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v256, types: [int] */
    /* JADX WARN: Type inference failed for: r0v263, types: [int] */
    /* JADX WARN: Type inference failed for: r0v268 */
    /* JADX WARN: Type inference failed for: r0v269 */
    /* JADX WARN: Type inference failed for: r0v270 */
    /* JADX WARN: Type inference failed for: r0v271 */
    /* JADX WARN: Type inference failed for: r0v272 */
    /* JADX WARN: Type inference failed for: r0v273 */
    /* JADX WARN: Type inference failed for: r0v274 */
    /* JADX WARN: Type inference failed for: r0v275 */
    /* JADX WARN: Type inference failed for: r0v276 */
    /* JADX WARN: Type inference failed for: r0v277 */
    /* JADX WARN: Type inference failed for: r0v278 */
    /* JADX WARN: Type inference failed for: r0v279 */
    /* JADX WARN: Type inference failed for: r0v280 */
    /* JADX WARN: Type inference failed for: r0v281 */
    /* JADX WARN: Type inference failed for: r0v282 */
    /* JADX WARN: Type inference failed for: r0v283 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v120, types: [int] */
    /* JADX WARN: Type inference failed for: r1v123, types: [int] */
    /* JADX WARN: Type inference failed for: r1v162 */
    /* JADX WARN: Type inference failed for: r1v165 */
    /* JADX WARN: Type inference failed for: r1v166 */
    /* JADX WARN: Type inference failed for: r1v167 */
    /* JADX WARN: Type inference failed for: r1v168 */
    /* JADX WARN: Type inference failed for: r1v80, types: [int] */
    /* JADX WARN: Type inference failed for: r1v82 */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38, types: [int] */
    /* JADX WARN: Type inference failed for: r2v42, types: [int] */
    /* JADX WARN: Type inference failed for: r2v46, types: [int] */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55, types: [int] */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27, types: [int] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30, types: [int] */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v39, types: [int] */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v46, types: [int] */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31, types: [int] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v38, types: [int] */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zza(Object obj) {
        int i;
        int i2;
        ?? r5;
        int zzA;
        int zzA2;
        int zzA3;
        int zzB;
        int zzA4;
        int zzA5;
        int zzd;
        int zzA6;
        ?? zzg;
        int size;
        int zzA7;
        int zzz;
        int zzz2;
        ?? r3;
        int zzy;
        ?? r1;
        ?? r0;
        int zze;
        int zzA8;
        int zzA9;
        ?? r4;
        Unsafe unsafe = zzb;
        boolean z = false;
        int i3 = 1048575;
        ?? r12 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i4 < this.zzc.length) {
            int zzs = zzs(i4);
            int zzr = zzr(zzs);
            int[] iArr = this.zzc;
            int i7 = iArr[i4];
            int i8 = iArr[i4 + 2];
            int i9 = i8 & i3;
            if (zzr <= 17) {
                if (i9 != i6) {
                    r12 = i9 == i3 ? z : unsafe.getInt(obj, i9);
                    i6 = i9;
                }
                i = i6;
                i2 = r12;
                r5 = 1 << (i8 >>> 20);
            } else {
                i = i6;
                i2 = r12;
                r5 = z;
            }
            int i10 = zzs & i3;
            if (zzr >= zzdy.DOUBLE_LIST_PACKED.zza()) {
                zzdy.SINT64_LIST_PACKED.zza();
            }
            long j = i10;
            switch (zzr) {
                case 0:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzA = zzdn.zzA(i7 << 3);
                        r0 = zzA + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 1:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzA2 = zzdn.zzA(i7 << 3);
                        r0 = zzA2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 2:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        long j2 = unsafe.getLong(obj, j);
                        zzA3 = zzdn.zzA(i7 << 3);
                        zzB = zzdn.zzB(j2);
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 3:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        long j3 = unsafe.getLong(obj, j);
                        zzA3 = zzdn.zzA(i7 << 3);
                        zzB = zzdn.zzB(j3);
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 4:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        long j4 = unsafe.getInt(obj, j);
                        zzA3 = zzdn.zzA(i7 << 3);
                        zzB = zzdn.zzB(j4);
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 5:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzA = zzdn.zzA(i7 << 3);
                        r0 = zzA + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 6:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzA2 = zzdn.zzA(i7 << 3);
                        r0 = zzA2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 7:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzA4 = zzdn.zzA(i7 << 3);
                        r0 = zzA4 + 1;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 8:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        int i11 = i7 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzdf) {
                            zzA5 = zzdn.zzA(i11);
                            zzd = ((zzdf) object).zzd();
                            zzA6 = zzdn.zzA(zzd);
                            r0 = zzA5 + zzA6 + zzd;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            zzA3 = zzdn.zzA(i11);
                            zzB = zzdn.zzz((String) object);
                            r0 = zzA3 + zzB;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 9:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        r0 = zzgg.zzh(i7, unsafe.getObject(obj, j), zzv(i4));
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 10:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzdf zzdfVar = (zzdf) unsafe.getObject(obj, j);
                        zzA5 = zzdn.zzA(i7 << 3);
                        zzd = zzdfVar.zzd();
                        zzA6 = zzdn.zzA(zzd);
                        r0 = zzA5 + zzA6 + zzd;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 11:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        int i12 = unsafe.getInt(obj, j);
                        zzA3 = zzdn.zzA(i7 << 3);
                        zzB = zzdn.zzA(i12);
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 12:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        long j5 = unsafe.getInt(obj, j);
                        zzA3 = zzdn.zzA(i7 << 3);
                        zzB = zzdn.zzB(j5);
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 13:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzA2 = zzdn.zzA(i7 << 3);
                        r0 = zzA2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 14:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzA = zzdn.zzA(i7 << 3);
                        r0 = zzA + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 15:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        int i13 = unsafe.getInt(obj, j);
                        zzA3 = zzdn.zzA(i7 << 3);
                        zzB = zzdn.zzA((i13 >> 31) ^ (i13 + i13));
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 16:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        long j6 = unsafe.getLong(obj, j);
                        zzA3 = zzdn.zzA(i7 << 3);
                        zzB = zzdn.zzB((j6 >> 63) ^ (j6 + j6));
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 17:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        r0 = zzdn.zzw(i7, (zzfm) unsafe.getObject(obj, j), zzv(i4));
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 18:
                    r0 = zzgg.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 19:
                    r0 = zzgg.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i14 = zzgg.zza;
                    if (list.size() != 0) {
                        zzg = zzgg.zzg(list) + (list.size() * zzdn.zzA(i7 << 3));
                        i5 += zzg;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    zzg = z;
                    i5 += zzg;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i15 = zzgg.zza;
                    size = list2.size();
                    if (size != 0) {
                        zzA3 = zzgg.zzl(list2);
                        zzA7 = zzdn.zzA(i7 << 3);
                        zzB = size * zzA7;
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i16 = zzgg.zza;
                    size = list3.size();
                    if (size != 0) {
                        zzA3 = zzgg.zzf(list3);
                        zzA7 = zzdn.zzA(i7 << 3);
                        zzB = size * zzA7;
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 23:
                    r0 = zzgg.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 24:
                    r0 = zzgg.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i17 = zzgg.zza;
                    int size2 = list4.size();
                    if (size2 != 0) {
                        r0 = size2 * (zzdn.zzA(i7 << 3) + 1);
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 26:
                    ?? r02 = (List) unsafe.getObject(obj, j);
                    int i18 = zzgg.zza;
                    int size3 = r02.size();
                    if (size3 != 0) {
                        int zzA10 = zzdn.zzA(i7 << 3) * size3;
                        if (r02 instanceof zzey) {
                            zzey zzeyVar = (zzey) r02;
                            zzg = zzA10;
                            for (?? r32 = z; r32 < size3; r32++) {
                                Object zza2 = zzeyVar.zza();
                                if (zza2 instanceof zzdf) {
                                    int zzd2 = ((zzdf) zza2).zzd();
                                    zzz2 = zzg + zzdn.zzA(zzd2) + zzd2;
                                } else {
                                    zzz2 = zzg + zzdn.zzz((String) zza2);
                                }
                                zzg = zzz2;
                            }
                        } else {
                            zzg = zzA10;
                            for (?? r33 = z; r33 < size3; r33++) {
                                Object obj2 = r02.get(r33);
                                if (obj2 instanceof zzdf) {
                                    int zzd3 = ((zzdf) obj2).zzd();
                                    zzz = zzg + zzdn.zzA(zzd3) + zzd3;
                                } else {
                                    zzz = zzg + zzdn.zzz((String) obj2);
                                }
                                zzg = zzz;
                            }
                        }
                        i5 += zzg;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    zzg = z;
                    i5 += zzg;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 27:
                    ?? r03 = (List) unsafe.getObject(obj, j);
                    zzge zzv = zzv(i4);
                    int i19 = zzgg.zza;
                    int size4 = r03.size();
                    if (size4 == 0) {
                        r3 = z;
                    } else {
                        r3 = zzdn.zzA(i7 << 3) * size4;
                        for (?? r42 = z; r42 < size4; r42++) {
                            Object obj3 = r03.get(r42);
                            if (obj3 instanceof zzex) {
                                int zza3 = ((zzex) obj3).zza();
                                zzy = (r3 == true ? 1 : 0) + zzdn.zzA(zza3) + zza3;
                            } else {
                                zzy = (r3 == true ? 1 : 0) + zzdn.zzy((zzfm) obj3, zzv);
                            }
                            r3 = zzy;
                        }
                    }
                    i5 += r3;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 28:
                    ?? r04 = (List) unsafe.getObject(obj, j);
                    int i20 = zzgg.zza;
                    int size5 = r04.size();
                    if (size5 == 0) {
                        r1 = z;
                    } else {
                        r1 = size5 * zzdn.zzA(i7 << 3);
                        for (?? r2 = z; r2 < r04.size(); r2++) {
                            int zzd4 = ((zzdf) r04.get(r2)).zzd();
                            r1 += zzdn.zzA(zzd4) + zzd4;
                        }
                    }
                    i5 += r1;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 29:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i21 = zzgg.zza;
                    size = list5.size();
                    if (size != 0) {
                        zzA3 = zzgg.zzk(list5);
                        zzA7 = zzdn.zzA(i7 << 3);
                        zzB = size * zzA7;
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 30:
                    List list6 = (List) unsafe.getObject(obj, j);
                    int i22 = zzgg.zza;
                    size = list6.size();
                    if (size != 0) {
                        zzA3 = zzgg.zza(list6);
                        zzA7 = zzdn.zzA(i7 << 3);
                        zzB = size * zzA7;
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 31:
                    r0 = zzgg.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 32:
                    r0 = zzgg.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i23 = zzgg.zza;
                    size = list7.size();
                    if (size != 0) {
                        zzA3 = zzgg.zzi(list7);
                        zzA7 = zzdn.zzA(i7 << 3);
                        zzB = size * zzA7;
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 34:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i24 = zzgg.zza;
                    size = list8.size();
                    if (size != 0) {
                        zzA3 = zzgg.zzj(list8);
                        zzA7 = zzdn.zzA(i7 << 3);
                        zzB = size * zzA7;
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                    r0 = z;
                    i5 += r0;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 35:
                    zze = zzgg.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA8 = zzdn.zzA(i7 << 3);
                        zzA9 = zzdn.zzA(zze);
                        r1 = zzA8 + zzA9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 36:
                    zze = zzgg.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA8 = zzdn.zzA(i7 << 3);
                        zzA9 = zzdn.zzA(zze);
                        r1 = zzA8 + zzA9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 37:
                    zze = zzgg.zzg((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA8 = zzdn.zzA(i7 << 3);
                        zzA9 = zzdn.zzA(zze);
                        r1 = zzA8 + zzA9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 38:
                    zze = zzgg.zzl((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA8 = zzdn.zzA(i7 << 3);
                        zzA9 = zzdn.zzA(zze);
                        r1 = zzA8 + zzA9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 39:
                    zze = zzgg.zzf((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA8 = zzdn.zzA(i7 << 3);
                        zzA9 = zzdn.zzA(zze);
                        r1 = zzA8 + zzA9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 40:
                    zze = zzgg.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA8 = zzdn.zzA(i7 << 3);
                        zzA9 = zzdn.zzA(zze);
                        r1 = zzA8 + zzA9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 41:
                    zze = zzgg.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA8 = zzdn.zzA(i7 << 3);
                        zzA9 = zzdn.zzA(zze);
                        r1 = zzA8 + zzA9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 42:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i25 = zzgg.zza;
                    zze = list9.size();
                    if (zze > 0) {
                        zzA8 = zzdn.zzA(i7 << 3);
                        zzA9 = zzdn.zzA(zze);
                        r1 = zzA8 + zzA9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 43:
                    zze = zzgg.zzk((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA8 = zzdn.zzA(i7 << 3);
                        zzA9 = zzdn.zzA(zze);
                        r1 = zzA8 + zzA9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 44:
                    zze = zzgg.zza((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA8 = zzdn.zzA(i7 << 3);
                        zzA9 = zzdn.zzA(zze);
                        r1 = zzA8 + zzA9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 45:
                    zze = zzgg.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA8 = zzdn.zzA(i7 << 3);
                        zzA9 = zzdn.zzA(zze);
                        r1 = zzA8 + zzA9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 46:
                    zze = zzgg.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA8 = zzdn.zzA(i7 << 3);
                        zzA9 = zzdn.zzA(zze);
                        r1 = zzA8 + zzA9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 47:
                    zze = zzgg.zzi((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA8 = zzdn.zzA(i7 << 3);
                        zzA9 = zzdn.zzA(zze);
                        r1 = zzA8 + zzA9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 48:
                    zze = zzgg.zzj((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA8 = zzdn.zzA(i7 << 3);
                        zzA9 = zzdn.zzA(zze);
                        r1 = zzA8 + zzA9 + zze;
                        i5 += r1;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 49:
                    ?? r05 = (List) unsafe.getObject(obj, j);
                    zzge zzv2 = zzv(i4);
                    int i26 = zzgg.zza;
                    int size6 = r05.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z2 = z;
                        r4 = z2;
                        ?? r34 = z2;
                        while (r34 < size6) {
                            int zzw = zzdn.zzw(i7, (zzfm) r05.get(r34), zzv2);
                            r34++;
                            r4 = (r4 == true ? 1 : 0) + zzw;
                        }
                    }
                    i5 += r4;
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 50:
                    zzfg zzfgVar = (zzfg) unsafe.getObject(obj, j);
                    if (zzfgVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzfgVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
                case 51:
                    if (zzM(obj, i7, i4)) {
                        zzA = zzdn.zzA(i7 << 3);
                        r0 = zzA + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 52:
                    if (zzM(obj, i7, i4)) {
                        zzA2 = zzdn.zzA(i7 << 3);
                        r0 = zzA2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 53:
                    if (zzM(obj, i7, i4)) {
                        long zzt = zzt(obj, j);
                        zzA3 = zzdn.zzA(i7 << 3);
                        zzB = zzdn.zzB(zzt);
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 54:
                    if (zzM(obj, i7, i4)) {
                        long zzt2 = zzt(obj, j);
                        zzA3 = zzdn.zzA(i7 << 3);
                        zzB = zzdn.zzB(zzt2);
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 55:
                    if (zzM(obj, i7, i4)) {
                        long zzo = zzo(obj, j);
                        zzA3 = zzdn.zzA(i7 << 3);
                        zzB = zzdn.zzB(zzo);
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 56:
                    if (zzM(obj, i7, i4)) {
                        zzA = zzdn.zzA(i7 << 3);
                        r0 = zzA + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 57:
                    if (zzM(obj, i7, i4)) {
                        zzA2 = zzdn.zzA(i7 << 3);
                        r0 = zzA2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 58:
                    if (zzM(obj, i7, i4)) {
                        zzA4 = zzdn.zzA(i7 << 3);
                        r0 = zzA4 + 1;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 59:
                    if (zzM(obj, i7, i4)) {
                        int i27 = i7 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzdf) {
                            zzA5 = zzdn.zzA(i27);
                            zzd = ((zzdf) object2).zzd();
                            zzA6 = zzdn.zzA(zzd);
                            r0 = zzA5 + zzA6 + zzd;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        } else {
                            zzA3 = zzdn.zzA(i27);
                            zzB = zzdn.zzz((String) object2);
                            r0 = zzA3 + zzB;
                            i5 += r0;
                            i4 += 3;
                            i6 = i;
                            r12 = i2;
                            z = false;
                            i3 = 1048575;
                        }
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 60:
                    if (zzM(obj, i7, i4)) {
                        r0 = zzgg.zzh(i7, unsafe.getObject(obj, j), zzv(i4));
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 61:
                    if (zzM(obj, i7, i4)) {
                        zzdf zzdfVar2 = (zzdf) unsafe.getObject(obj, j);
                        zzA5 = zzdn.zzA(i7 << 3);
                        zzd = zzdfVar2.zzd();
                        zzA6 = zzdn.zzA(zzd);
                        r0 = zzA5 + zzA6 + zzd;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 62:
                    if (zzM(obj, i7, i4)) {
                        int zzo2 = zzo(obj, j);
                        zzA3 = zzdn.zzA(i7 << 3);
                        zzB = zzdn.zzA(zzo2);
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 63:
                    if (zzM(obj, i7, i4)) {
                        long zzo3 = zzo(obj, j);
                        zzA3 = zzdn.zzA(i7 << 3);
                        zzB = zzdn.zzB(zzo3);
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 64:
                    if (zzM(obj, i7, i4)) {
                        zzA2 = zzdn.zzA(i7 << 3);
                        r0 = zzA2 + 4;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 65:
                    if (zzM(obj, i7, i4)) {
                        zzA = zzdn.zzA(i7 << 3);
                        r0 = zzA + 8;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 66:
                    if (zzM(obj, i7, i4)) {
                        int zzo4 = zzo(obj, j);
                        zzA3 = zzdn.zzA(i7 << 3);
                        zzB = zzdn.zzA((zzo4 >> 31) ^ (zzo4 + zzo4));
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 67:
                    if (zzM(obj, i7, i4)) {
                        long zzt3 = zzt(obj, j);
                        zzA3 = zzdn.zzA(i7 << 3);
                        zzB = zzdn.zzB((zzt3 >> 63) ^ (zzt3 + zzt3));
                        r0 = zzA3 + zzB;
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                case 68:
                    if (zzM(obj, i7, i4)) {
                        r0 = zzdn.zzw(i7, (zzfm) unsafe.getObject(obj, j), zzv(i4));
                        i5 += r0;
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r12 = i2;
                        z = false;
                        i3 = 1048575;
                    }
                default:
                    i4 += 3;
                    i6 = i;
                    r12 = i2;
                    z = false;
                    i3 = 1048575;
            }
        }
        int zza4 = i5 + ((zzeh) obj).zzc.zza();
        if (!this.zzh) {
            return zza4;
        }
        zzdx zzdxVar = ((zzed) obj).zzb;
        int zzc = zzdxVar.zza.zzc();
        int i28 = 0;
        for (int i29 = 0; i29 < zzc; i29++) {
            Map.Entry zzg2 = zzdxVar.zza.zzg(i29);
            i28 += zzdx.zza((zzdw) ((zzgi) zzg2).zza(), zzg2.getValue());
        }
        for (Map.Entry entry2 : zzdxVar.zza.zzd()) {
            i28 += zzdx.zza((zzdw) entry2.getKey(), entry2.getValue());
        }
        return zza4 + i28;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zzb(Object obj) {
        int i;
        long doubleToLongBits;
        int floatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int zzs = zzs(i4);
            int[] iArr = this.zzc;
            int i5 = 1048575 & zzs;
            int zzr = zzr(zzs);
            int i6 = iArr[i4];
            long j = i5;
            int i7 = 37;
            switch (zzr) {
                case 0:
                    i = i3 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzgz.zza(obj, j));
                    byte[] bArr = zzep.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    floatToIntBits = Float.floatToIntBits(zzgz.zzb(obj, j));
                    i3 = i + floatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    doubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr2 = zzep.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    doubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr3 = zzep.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    floatToIntBits = zzgz.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    doubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr4 = zzep.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    floatToIntBits = zzgz.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    floatToIntBits = zzep.zza(zzgz.zzw(obj, j));
                    i3 = i + floatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    floatToIntBits = ((String) zzgz.zzf(obj, j)).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object zzf = zzgz.zzf(obj, j);
                    if (zzf != null) {
                        i7 = zzf.hashCode();
                    }
                    i3 = i2 + i7;
                    break;
                case 10:
                    i = i3 * 53;
                    floatToIntBits = zzgz.zzf(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    floatToIntBits = zzgz.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    floatToIntBits = zzgz.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    floatToIntBits = zzgz.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    doubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr5 = zzep.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    floatToIntBits = zzgz.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    doubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr6 = zzep.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object zzf2 = zzgz.zzf(obj, j);
                    if (zzf2 != null) {
                        i7 = zzf2.hashCode();
                    }
                    i3 = i2 + i7;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i3 * 53;
                    floatToIntBits = zzgz.zzf(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    floatToIntBits = zzgz.zzf(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzep.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr8 = zzep.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzep.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr10 = zzep.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzep.zza(zzN(obj, j));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = ((String) zzgz.zzf(obj, j)).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzgz.zzf(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzgz.zzf(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr11 = zzep.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzo(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzt(obj, j);
                        byte[] bArr12 = zzep.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzgz.zzf(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + ((zzeh) obj).zzc.hashCode();
        return this.zzh ? (hashCode * 53) + ((zzed) obj).zzb.zza.hashCode() : hashCode;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0dc0, code lost:
    
        if (r6 == 1048575) goto L554;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0dc2, code lost:
    
        r9.putInt(r7, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0dc6, code lost:
    
        r3 = r10.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0dca, code lost:
    
        if (r3 >= r10.zzk) goto L670;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0dcc, code lost:
    
        r5 = r10.zzi;
        r6 = r10.zzc;
        r5 = r5[r3];
        r6 = r6[r5];
        r6 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgz.zzf(r7, r10.zzs(r5) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0dde, code lost:
    
        if (r6 != null) goto L560;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0de5, code lost:
    
        if (r10.zzu(r5) != null) goto L669;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0dee, code lost:
    
        r6 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfg) r6;
        r0 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzff) r10.zzw(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0df6, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0de7, code lost:
    
        r5 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt) null;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0df9, code lost:
    
        if (r0 != 0) goto L571;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0dfb, code lost:
    
        if (r1 != r8) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0e03, code lost:
    
        throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("Failed to parse the message.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0e08, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0e04, code lost:
    
        if (r1 > r8) goto L574;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0e06, code lost:
    
        if (r4 != r0) goto L574;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0e0e, code lost:
    
        throw new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer("Failed to parse the message.");
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0a32 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0a47 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0cfe A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0d14 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:614:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:717:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0d2f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int zzc(java.lang.Object r41, byte[] r42, int r43, int r44, int r45, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu r46) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu):int");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final Object zze() {
        return ((zzeh) this.zzg).zzK();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzeh) {
                zzeh zzehVar = (zzeh) obj;
                zzehVar.zzW(Integer.MAX_VALUE);
                zzehVar.zza = 0;
                zzehVar.zzU();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zzs = zzs(i);
                int i2 = 1048575 & zzs;
                int zzr = zzr(zzs);
                long j = i2;
                if (zzr != 9) {
                    if (zzr != 60 && zzr != 68) {
                        switch (zzr) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                ((zzeo) zzgz.zzf(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzfg) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzM(obj, this.zzc[i], i)) {
                        zzv(i).zzf(zzb.getObject(obj, j));
                    }
                }
                if (zzI(obj, i)) {
                    zzv(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzl.zza(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzs = zzs(i);
            int i2 = 1048575 & zzs;
            int[] iArr = this.zzc;
            int zzr = zzr(zzs);
            int i3 = iArr[i];
            long j = i2;
            switch (zzr) {
                case 0:
                    if (zzI(obj2, i)) {
                        zzgz.zzo(obj, j, zzgz.zza(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzI(obj2, i)) {
                        zzgz.zzp(obj, j, zzgz.zzb(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzI(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzI(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzI(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzI(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzI(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzI(obj2, i)) {
                        zzgz.zzm(obj, j, zzgz.zzw(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzI(obj2, i)) {
                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzI(obj2, i)) {
                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzI(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzI(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzI(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzI(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzI(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzI(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzB(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzeo zzeoVar = (zzeo) zzgz.zzf(obj, j);
                    zzeo zzeoVar2 = (zzeo) zzgz.zzf(obj2, j);
                    int size = zzeoVar.size();
                    int size2 = zzeoVar2.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzeoVar.zzc()) {
                            zzeoVar = zzeoVar.zzd(size2 + size);
                        }
                        zzeoVar.addAll(zzeoVar2);
                    }
                    if (size > 0) {
                        zzeoVar2 = zzeoVar;
                    }
                    zzgz.zzs(obj, j, zzeoVar2);
                    break;
                case 50:
                    int i4 = zzgg.zza;
                    zzgz.zzs(obj, j, zzfh.zza(zzgz.zzf(obj, j), zzgz.zzf(obj2, j)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzM(obj2, i3, i)) {
                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                        zzE(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i3, i)) {
                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                        zzE(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
        }
        zzgg.zzp(this.zzl, obj, obj2);
        if (this.zzh) {
            zzgg.zzo(this.zzm, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzcu zzcuVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzcuVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:255:0x06ca  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzi(java.lang.Object r24, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1914
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp.zzi(java.lang.Object, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh):void");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzj(Object obj, Object obj2) {
        boolean zzE;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzs = zzs(i);
            long j = zzs & 1048575;
            switch (zzr(zzs)) {
                case 0:
                    if (zzH(obj, obj2, i) && Double.doubleToLongBits(zzgz.zza(obj, j)) == Double.doubleToLongBits(zzgz.zza(obj2, j))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzH(obj, obj2, i) && Float.floatToIntBits(zzgz.zzb(obj, j)) == Float.floatToIntBits(zzgz.zzb(obj2, j))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzH(obj, obj2, i) && zzgz.zzd(obj, j) == zzgz.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzH(obj, obj2, i) && zzgz.zzd(obj, j) == zzgz.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzH(obj, obj2, i) && zzgz.zzc(obj, j) == zzgz.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzH(obj, obj2, i) && zzgz.zzd(obj, j) == zzgz.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzH(obj, obj2, i) && zzgz.zzc(obj, j) == zzgz.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzH(obj, obj2, i) && zzgz.zzw(obj, j) == zzgz.zzw(obj2, j)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzH(obj, obj2, i) && zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzH(obj, obj2, i) && zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzH(obj, obj2, i) && zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzH(obj, obj2, i) && zzgz.zzc(obj, j) == zzgz.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzH(obj, obj2, i) && zzgz.zzc(obj, j) == zzgz.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzH(obj, obj2, i) && zzgz.zzc(obj, j) == zzgz.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzH(obj, obj2, i) && zzgz.zzd(obj, j) == zzgz.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzH(obj, obj2, i) && zzgz.zzc(obj, j) == zzgz.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzH(obj, obj2, i) && zzgz.zzd(obj, j) == zzgz.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzH(obj, obj2, i) && zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzE = zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j));
                    break;
                case 50:
                    zzE = zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzp = zzp(i) & 1048575;
                    if (zzgz.zzc(obj, zzp) == zzgz.zzc(obj2, zzp) && zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzE) {
                return false;
            }
        }
        if (!((zzeh) obj).zzc.equals(((zzeh) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzed) obj).zzb.equals(((zzed) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i4 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i6 = iArr[i4];
            int i7 = iArr2[i6];
            int zzs = zzs(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i5) {
                if (i9 != 1048575) {
                    i3 = zzb.getInt(obj, i9);
                }
                i2 = i3;
                i = i9;
            } else {
                i = i5;
                i2 = i3;
            }
            if ((268435456 & zzs) != 0 && !zzJ(obj, i6, i, i2, i10)) {
                return false;
            }
            int zzr = zzr(zzs);
            if (zzr != 9 && zzr != 17) {
                if (zzr != 27) {
                    if (zzr == 60 || zzr == 68) {
                        if (zzM(obj, i7, i6) && !zzK(obj, zzs, zzv(i6))) {
                            return false;
                        }
                    } else if (zzr != 49) {
                        if (zzr == 50 && !((zzfg) zzgz.zzf(obj, zzs & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzgz.zzf(obj, zzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzge zzv = zzv(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzv.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                }
            } else if (zzJ(obj, i6, i, i2, i10) && !zzK(obj, zzs, zzv(i6))) {
                return false;
            }
            i4++;
            i5 = i;
            i3 = i2;
        }
        return !this.zzh || ((zzed) obj).zzb.zzk();
    }
}
