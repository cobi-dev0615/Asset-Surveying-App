package com.google.android.gms.internal.mlkit_common;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.CheckForNull;
import kotlin.UByte;

/* compiled from: com.google.mlkit:common@@18.11.0 */
/* loaded from: classes2.dex */
final class zzaq extends zzai {
    static final zzai zza = new zzaq(null, new Object[0], 0);
    final transient Object[] zzb;

    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzaq(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    static zzaq zzg(int i, Object[] objArr, zzah zzahVar) {
        int i2;
        short[] sArr;
        char c;
        char c2;
        byte[] bArr;
        int i3 = i;
        Object[] objArr2 = objArr;
        if (i3 == 0) {
            return (zzaq) zza;
        }
        Object obj = null;
        int i4 = 1;
        if (i3 == 1) {
            zzw.zza(Objects.requireNonNull(objArr2[0]), Objects.requireNonNull(objArr2[1]));
            return new zzaq(null, objArr2, 1);
        }
        zzt.zzb(i3, objArr2.length >> 1, "index");
        int max = Math.max(i3, 2);
        if (max < 751619276) {
            i2 = Integer.highestOneBit(max - 1);
            do {
                i2 += i2;
            } while (i2 * 0.7d < max);
        } else {
            i2 = BasicMeasure.EXACTLY;
            if (max >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i3 == 1) {
            zzw.zza(Objects.requireNonNull(objArr2[0]), Objects.requireNonNull(objArr2[1]));
            i3 = 1;
            c = 1;
            c2 = 2;
        } else {
            int i5 = i2 - 1;
            char c3 = 65535;
            if (i2 <= 128) {
                byte[] bArr2 = new byte[i2];
                Arrays.fill(bArr2, (byte) -1);
                int i6 = 0;
                int i7 = 0;
                while (i6 < i3) {
                    int i8 = i7 + i7;
                    int i9 = i6 + i6;
                    Object requireNonNull = Objects.requireNonNull(objArr2[i9]);
                    Object requireNonNull2 = Objects.requireNonNull(objArr2[i9 ^ i4]);
                    zzw.zza(requireNonNull, requireNonNull2);
                    int zza2 = zzy.zza(requireNonNull.hashCode());
                    while (true) {
                        int i10 = zza2 & i5;
                        int i11 = bArr2[i10] & UByte.MAX_VALUE;
                        if (i11 == 255) {
                            bArr2[i10] = (byte) i8;
                            if (i7 < i6) {
                                objArr2[i8] = requireNonNull;
                                objArr2[i8 ^ 1] = requireNonNull2;
                            }
                            i7++;
                        } else {
                            if (requireNonNull.equals(objArr2[i11])) {
                                int i12 = i11 ^ 1;
                                zzag zzagVar = new zzag(requireNonNull, requireNonNull2, Objects.requireNonNull(objArr2[i12]));
                                objArr2[i12] = requireNonNull2;
                                obj = zzagVar;
                                break;
                            }
                            zza2 = i10 + 1;
                        }
                    }
                    i6++;
                    i4 = 1;
                }
                if (i7 == i3) {
                    bArr = bArr2;
                } else {
                    bArr = new Object[]{bArr2, Integer.valueOf(i7), obj};
                    c2 = 2;
                    c = 1;
                    obj = bArr;
                }
            } else if (i2 <= 32768) {
                sArr = new short[i2];
                Arrays.fill(sArr, (short) -1);
                int i13 = 0;
                for (int i14 = 0; i14 < i3; i14++) {
                    int i15 = i13 + i13;
                    int i16 = i14 + i14;
                    Object requireNonNull3 = Objects.requireNonNull(objArr2[i16]);
                    Object requireNonNull4 = Objects.requireNonNull(objArr2[i16 ^ 1]);
                    zzw.zza(requireNonNull3, requireNonNull4);
                    int zza3 = zzy.zza(requireNonNull3.hashCode());
                    while (true) {
                        int i17 = zza3 & i5;
                        char c4 = (char) sArr[i17];
                        if (c4 == 65535) {
                            sArr[i17] = (short) i15;
                            if (i13 < i14) {
                                objArr2[i15] = requireNonNull3;
                                objArr2[i15 ^ 1] = requireNonNull4;
                            }
                            i13++;
                        } else {
                            if (requireNonNull3.equals(objArr2[c4])) {
                                int i18 = c4 ^ 1;
                                zzag zzagVar2 = new zzag(requireNonNull3, requireNonNull4, Objects.requireNonNull(objArr2[i18]));
                                objArr2[i18] = requireNonNull4;
                                obj = zzagVar2;
                                break;
                            }
                            zza3 = i17 + 1;
                        }
                    }
                }
                if (i13 != i3) {
                    c2 = 2;
                    obj = new Object[]{sArr, Integer.valueOf(i13), obj};
                    c = 1;
                }
                bArr = sArr;
            } else {
                int i19 = 1;
                sArr = new int[i2];
                Arrays.fill((int[]) sArr, -1);
                int i20 = 0;
                int i21 = 0;
                while (i20 < i3) {
                    int i22 = i21 + i21;
                    int i23 = i20 + i20;
                    Object requireNonNull5 = Objects.requireNonNull(objArr2[i23]);
                    Object requireNonNull6 = Objects.requireNonNull(objArr2[i23 ^ i19]);
                    zzw.zza(requireNonNull5, requireNonNull6);
                    int zza4 = zzy.zza(requireNonNull5.hashCode());
                    while (true) {
                        int i24 = zza4 & i5;
                        ?? r15 = sArr[i24];
                        if (r15 == c3) {
                            sArr[i24] = i22;
                            if (i21 < i20) {
                                objArr2[i22] = requireNonNull5;
                                objArr2[i22 ^ 1] = requireNonNull6;
                            }
                            i21++;
                        } else {
                            if (requireNonNull5.equals(objArr2[r15])) {
                                int i25 = r15 ^ 1;
                                zzag zzagVar3 = new zzag(requireNonNull5, requireNonNull6, Objects.requireNonNull(objArr2[i25]));
                                objArr2[i25] = requireNonNull6;
                                obj = zzagVar3;
                                break;
                            }
                            zza4 = i24 + 1;
                            c3 = 65535;
                        }
                    }
                    i20++;
                    i19 = 1;
                    c3 = 65535;
                }
                if (i21 != i3) {
                    c = 1;
                    c2 = 2;
                    obj = new Object[]{sArr, Integer.valueOf(i21), obj};
                }
                bArr = sArr;
            }
            c2 = 2;
            c = 1;
            obj = bArr;
        }
        boolean z = obj instanceof Object[];
        Object obj2 = obj;
        if (z) {
            Object[] objArr3 = (Object[]) obj;
            zzag zzagVar4 = (zzag) objArr3[c2];
            if (zzahVar == null) {
                throw zzagVar4.zza();
            }
            zzahVar.zzc = zzagVar4;
            Object obj3 = objArr3[0];
            int intValue = ((Integer) objArr3[c]).intValue();
            objArr2 = Arrays.copyOf(objArr2, intValue + intValue);
            obj2 = obj3;
            i3 = intValue;
        }
        return new zzaq(obj2, objArr2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x00a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00a1 A[RETURN] */
    @Override // com.google.android.gms.internal.mlkit_common.zzai, java.util.Map
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L6
        L3:
            r10 = r0
            goto L9e
        L6:
            int r1 = r9.zzd
            java.lang.Object[] r2 = r9.zzb
            r3 = 1
            if (r1 != r3) goto L22
            r1 = 0
            r1 = r2[r1]
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
            boolean r10 = r1.equals(r10)
            if (r10 == 0) goto L3
            r10 = r2[r3]
            java.lang.Object r10 = java.util.Objects.requireNonNull(r10)
            goto L9e
        L22:
            java.lang.Object r1 = r9.zzc
            if (r1 != 0) goto L27
            goto L3
        L27:
            boolean r4 = r1 instanceof byte[]
            r5 = -1
            if (r4 == 0) goto L53
            r4 = r1
            byte[] r4 = (byte[]) r4
            int r1 = r4.length
            int r6 = r1 + (-1)
            int r1 = r10.hashCode()
            int r1 = com.google.android.gms.internal.mlkit_common.zzy.zza(r1)
        L3a:
            r1 = r1 & r6
            r5 = r4[r1]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L43
            goto L3
        L43:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L50
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L9e
        L50:
            int r1 = r1 + 1
            goto L3a
        L53:
            boolean r4 = r1 instanceof short[]
            if (r4 == 0) goto L7f
            r4 = r1
            short[] r4 = (short[]) r4
            int r1 = r4.length
            int r6 = r1 + (-1)
            int r1 = r10.hashCode()
            int r1 = com.google.android.gms.internal.mlkit_common.zzy.zza(r1)
        L65:
            r1 = r1 & r6
            short r5 = r4[r1]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L6f
            goto L3
        L6f:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L7c
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L9e
        L7c:
            int r1 = r1 + 1
            goto L65
        L7f:
            int[] r1 = (int[]) r1
            int r4 = r1.length
            int r4 = r4 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.mlkit_common.zzy.zza(r6)
        L8b:
            r6 = r6 & r4
            r7 = r1[r6]
            if (r7 != r5) goto L92
            goto L3
        L92:
            r8 = r2[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto La2
            r10 = r7 ^ 1
            r10 = r2[r10]
        L9e:
            if (r10 != 0) goto La1
            return r0
        La1:
            return r10
        La2:
            int r6 = r6 + 1
            goto L8b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaq.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzai
    final zzab zza() {
        return new zzap(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzai
    final zzaj zzd() {
        return new zzan(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzai
    final zzaj zze() {
        return new zzao(this, new zzap(this.zzb, 0, this.zzd));
    }
}
