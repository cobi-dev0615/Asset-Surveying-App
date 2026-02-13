package com.google.crypto.tink.internal;

import com.gg.reader.api.protocol.gx.EnumG;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EngineFactory;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public final class Ed25519 {
    public static final int PUBLIC_KEY_LEN = 32;
    public static final int SECRET_KEY_LEN = 32;
    public static final int SIGNATURE_LEN = 64;
    private static final CachedXYT CACHED_NEUTRAL = new CachedXYT(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    private static final PartialXYZT NEUTRAL = new PartialXYZT(new XYZ(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    static final byte[] GROUP_ORDER = {-19, -45, -11, 92, 26, 99, 18, 88, -42, -100, -9, -94, -34, -7, -34, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16};

    private static int eq(int a, int b) {
        int i = (~(a ^ b)) & 255;
        int i2 = i & (i << 4);
        int i3 = i2 & (i2 << 2);
        return ((i3 & (i3 << 1)) >> 7) & 1;
    }

    private static class XYZ {
        final long[] x;
        final long[] y;
        final long[] z;

        XYZ() {
            this(new long[10], new long[10], new long[10]);
        }

        XYZ(long[] x, long[] y, long[] z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        XYZ(XYZ xyz) {
            this.x = Arrays.copyOf(xyz.x, 10);
            this.y = Arrays.copyOf(xyz.y, 10);
            this.z = Arrays.copyOf(xyz.z, 10);
        }

        XYZ(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }

        static XYZ fromPartialXYZT(XYZ out, PartialXYZT in) {
            Field25519.mult(out.x, in.xyz.x, in.t);
            Field25519.mult(out.y, in.xyz.y, in.xyz.z);
            Field25519.mult(out.z, in.xyz.z, in.t);
            return out;
        }

        byte[] toBytes() {
            long[] jArr = new long[10];
            long[] jArr2 = new long[10];
            long[] jArr3 = new long[10];
            Field25519.inverse(jArr, this.z);
            Field25519.mult(jArr2, this.x, jArr);
            Field25519.mult(jArr3, this.y, jArr);
            byte[] contract = Field25519.contract(jArr3);
            contract[31] = (byte) ((Ed25519.getLsb(jArr2) << 7) ^ contract[31]);
            return contract;
        }

        boolean isOnCurve() {
            long[] jArr = new long[10];
            Field25519.square(jArr, this.x);
            long[] jArr2 = new long[10];
            Field25519.square(jArr2, this.y);
            long[] jArr3 = new long[10];
            Field25519.square(jArr3, this.z);
            long[] jArr4 = new long[10];
            Field25519.square(jArr4, jArr3);
            long[] jArr5 = new long[10];
            Field25519.sub(jArr5, jArr2, jArr);
            Field25519.mult(jArr5, jArr5, jArr3);
            long[] jArr6 = new long[10];
            Field25519.mult(jArr6, jArr, jArr2);
            Field25519.mult(jArr6, jArr6, Ed25519Constants.D);
            Field25519.sum(jArr6, jArr4);
            Field25519.reduce(jArr6, jArr6);
            return Bytes.equal(Field25519.contract(jArr5), Field25519.contract(jArr6));
        }
    }

    private static class XYZT {
        final long[] t;
        final XYZ xyz;

        XYZT() {
            this(new XYZ(), new long[10]);
        }

        XYZT(XYZ xyz, long[] t) {
            this.xyz = xyz;
            this.t = t;
        }

        XYZT(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static XYZT fromPartialXYZT(XYZT out, PartialXYZT in) {
            Field25519.mult(out.xyz.x, in.xyz.x, in.t);
            Field25519.mult(out.xyz.y, in.xyz.y, in.xyz.z);
            Field25519.mult(out.xyz.z, in.xyz.z, in.t);
            Field25519.mult(out.t, in.xyz.x, in.xyz.y);
            return out;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static XYZT fromBytesNegateVarTime(byte[] s) throws GeneralSecurityException {
            long[] jArr = new long[10];
            long[] expand = Field25519.expand(s);
            long[] jArr2 = new long[10];
            jArr2[0] = 1;
            long[] jArr3 = new long[10];
            long[] jArr4 = new long[10];
            long[] jArr5 = new long[10];
            long[] jArr6 = new long[10];
            long[] jArr7 = new long[10];
            Field25519.square(jArr4, expand);
            Field25519.mult(jArr5, jArr4, Ed25519Constants.D);
            Field25519.sub(jArr4, jArr4, jArr2);
            Field25519.sum(jArr5, jArr5, jArr2);
            long[] jArr8 = new long[10];
            Field25519.square(jArr8, jArr5);
            Field25519.mult(jArr8, jArr8, jArr5);
            Field25519.square(jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr5);
            Field25519.mult(jArr, jArr, jArr4);
            Ed25519.pow2252m3(jArr, jArr);
            Field25519.mult(jArr, jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr4);
            Field25519.square(jArr6, jArr);
            Field25519.mult(jArr6, jArr6, jArr5);
            Field25519.sub(jArr7, jArr6, jArr4);
            if (Ed25519.isNonZeroVarTime(jArr7)) {
                Field25519.sum(jArr7, jArr6, jArr4);
                if (Ed25519.isNonZeroVarTime(jArr7)) {
                    throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                }
                Field25519.mult(jArr, jArr, Ed25519Constants.SQRTM1);
            }
            if (Ed25519.isNonZeroVarTime(jArr) || ((s[31] & UByte.MAX_VALUE) >> 7) == 0) {
                if (Ed25519.getLsb(jArr) == ((s[31] & UByte.MAX_VALUE) >> 7)) {
                    Ed25519.neg(jArr, jArr);
                }
                Field25519.mult(jArr3, jArr, expand);
                return new XYZT(new XYZ(jArr, expand, jArr2), jArr3);
            }
            throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
        }
    }

    private static class PartialXYZT {
        final long[] t;
        final XYZ xyz;

        PartialXYZT() {
            this(new XYZ(), new long[10]);
        }

        PartialXYZT(XYZ xyz, long[] t) {
            this.xyz = xyz;
            this.t = t;
        }

        PartialXYZT(PartialXYZT other) {
            this.xyz = new XYZ(other.xyz);
            this.t = Arrays.copyOf(other.t, 10);
        }
    }

    static class CachedXYT {
        final long[] t2d;
        final long[] yMinusX;
        final long[] yPlusX;

        CachedXYT() {
            this(new long[10], new long[10], new long[10]);
        }

        CachedXYT(long[] yPlusX, long[] yMinusX, long[] t2d) {
            this.yPlusX = yPlusX;
            this.yMinusX = yMinusX;
            this.t2d = t2d;
        }

        CachedXYT(CachedXYT other) {
            this.yPlusX = Arrays.copyOf(other.yPlusX, 10);
            this.yMinusX = Arrays.copyOf(other.yMinusX, 10);
            this.t2d = Arrays.copyOf(other.t2d, 10);
        }

        void multByZ(long[] output, long[] in) {
            System.arraycopy(in, 0, output, 0, 10);
        }

        void copyConditional(CachedXYT other, int icopy) {
            Curve25519.copyConditional(this.yPlusX, other.yPlusX, icopy);
            Curve25519.copyConditional(this.yMinusX, other.yMinusX, icopy);
            Curve25519.copyConditional(this.t2d, other.t2d, icopy);
        }
    }

    private static class CachedXYZT extends CachedXYT {
        private final long[] z;

        CachedXYZT() {
            this(new long[10], new long[10], new long[10], new long[10]);
        }

        CachedXYZT(XYZT xyzt) {
            this();
            Field25519.sum(this.yPlusX, xyzt.xyz.y, xyzt.xyz.x);
            Field25519.sub(this.yMinusX, xyzt.xyz.y, xyzt.xyz.x);
            System.arraycopy(xyzt.xyz.z, 0, this.z, 0, 10);
            Field25519.mult(this.t2d, xyzt.t, Ed25519Constants.D2);
        }

        CachedXYZT(long[] yPlusX, long[] yMinusX, long[] z, long[] t2d) {
            super(yPlusX, yMinusX, t2d);
            this.z = z;
        }

        @Override // com.google.crypto.tink.internal.Ed25519.CachedXYT
        public void multByZ(long[] output, long[] in) {
            Field25519.mult(output, in, this.z);
        }
    }

    private static void add(PartialXYZT partialXYZT, XYZT extended, CachedXYT cached) {
        long[] jArr = new long[10];
        Field25519.sum(partialXYZT.xyz.x, extended.xyz.y, extended.xyz.x);
        Field25519.sub(partialXYZT.xyz.y, extended.xyz.y, extended.xyz.x);
        Field25519.mult(partialXYZT.xyz.y, partialXYZT.xyz.y, cached.yMinusX);
        Field25519.mult(partialXYZT.xyz.z, partialXYZT.xyz.x, cached.yPlusX);
        Field25519.mult(partialXYZT.t, extended.t, cached.t2d);
        cached.multByZ(partialXYZT.xyz.x, extended.xyz.z);
        Field25519.sum(jArr, partialXYZT.xyz.x, partialXYZT.xyz.x);
        Field25519.sub(partialXYZT.xyz.x, partialXYZT.xyz.z, partialXYZT.xyz.y);
        Field25519.sum(partialXYZT.xyz.y, partialXYZT.xyz.z, partialXYZT.xyz.y);
        Field25519.sum(partialXYZT.xyz.z, jArr, partialXYZT.t);
        Field25519.sub(partialXYZT.t, jArr, partialXYZT.t);
    }

    private static void sub(PartialXYZT partialXYZT, XYZT extended, CachedXYT cached) {
        long[] jArr = new long[10];
        Field25519.sum(partialXYZT.xyz.x, extended.xyz.y, extended.xyz.x);
        Field25519.sub(partialXYZT.xyz.y, extended.xyz.y, extended.xyz.x);
        Field25519.mult(partialXYZT.xyz.y, partialXYZT.xyz.y, cached.yPlusX);
        Field25519.mult(partialXYZT.xyz.z, partialXYZT.xyz.x, cached.yMinusX);
        Field25519.mult(partialXYZT.t, extended.t, cached.t2d);
        cached.multByZ(partialXYZT.xyz.x, extended.xyz.z);
        Field25519.sum(jArr, partialXYZT.xyz.x, partialXYZT.xyz.x);
        Field25519.sub(partialXYZT.xyz.x, partialXYZT.xyz.z, partialXYZT.xyz.y);
        Field25519.sum(partialXYZT.xyz.y, partialXYZT.xyz.z, partialXYZT.xyz.y);
        Field25519.sub(partialXYZT.xyz.z, jArr, partialXYZT.t);
        Field25519.sum(partialXYZT.t, jArr, partialXYZT.t);
    }

    private static void doubleXYZ(PartialXYZT partialXYZT, XYZ p) {
        long[] jArr = new long[10];
        Field25519.square(partialXYZT.xyz.x, p.x);
        Field25519.square(partialXYZT.xyz.z, p.y);
        Field25519.square(partialXYZT.t, p.z);
        Field25519.sum(partialXYZT.t, partialXYZT.t, partialXYZT.t);
        Field25519.sum(partialXYZT.xyz.y, p.x, p.y);
        Field25519.square(jArr, partialXYZT.xyz.y);
        Field25519.sum(partialXYZT.xyz.y, partialXYZT.xyz.z, partialXYZT.xyz.x);
        Field25519.sub(partialXYZT.xyz.z, partialXYZT.xyz.z, partialXYZT.xyz.x);
        Field25519.sub(partialXYZT.xyz.x, jArr, partialXYZT.xyz.y);
        Field25519.sub(partialXYZT.t, partialXYZT.t, partialXYZT.xyz.z);
    }

    private static void doubleXYZT(PartialXYZT partialXYZT, XYZT p) {
        doubleXYZ(partialXYZT, p.xyz);
    }

    private static void select(CachedXYT t, int pos, byte b) {
        int i = (b & UByte.MAX_VALUE) >> 7;
        int i2 = b - (((-i) & b) << 1);
        t.copyConditional(Ed25519Constants.B_TABLE[pos][0], eq(i2, 1));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][1], eq(i2, 2));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][2], eq(i2, 3));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][3], eq(i2, 4));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][4], eq(i2, 5));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][5], eq(i2, 6));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][6], eq(i2, 7));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][7], eq(i2, 8));
        long[] copyOf = Arrays.copyOf(t.yMinusX, 10);
        long[] copyOf2 = Arrays.copyOf(t.yPlusX, 10);
        long[] copyOf3 = Arrays.copyOf(t.t2d, 10);
        neg(copyOf3, copyOf3);
        t.copyConditional(new CachedXYT(copyOf, copyOf2, copyOf3), i);
    }

    private static XYZ scalarMultWithBase(byte[] a) {
        int i;
        byte[] bArr = new byte[64];
        int i2 = 0;
        while (true) {
            if (i2 >= 32) {
                break;
            }
            int i3 = i2 * 2;
            bArr[i3] = (byte) (a[i2] & 15);
            bArr[i3 + 1] = (byte) (((a[i2] & UByte.MAX_VALUE) >> 4) & 15);
            i2++;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < 63) {
            byte b = (byte) (bArr[i4] + i5);
            bArr[i4] = b;
            int i6 = (b + 8) >> 4;
            bArr[i4] = (byte) (b - (i6 << 4));
            i4++;
            i5 = i6;
        }
        bArr[63] = (byte) (bArr[63] + i5);
        PartialXYZT partialXYZT = new PartialXYZT(NEUTRAL);
        XYZT xyzt = new XYZT();
        for (i = 1; i < 64; i += 2) {
            CachedXYT cachedXYT = new CachedXYT(CACHED_NEUTRAL);
            select(cachedXYT, i / 2, bArr[i]);
            add(partialXYZT, XYZT.fromPartialXYZT(xyzt, partialXYZT), cachedXYT);
        }
        XYZ xyz = new XYZ();
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        for (int i7 = 0; i7 < 64; i7 += 2) {
            CachedXYT cachedXYT2 = new CachedXYT(CACHED_NEUTRAL);
            select(cachedXYT2, i7 / 2, bArr[i7]);
            add(partialXYZT, XYZT.fromPartialXYZT(xyzt, partialXYZT), cachedXYT2);
        }
        XYZ xyz2 = new XYZ(partialXYZT);
        if (xyz2.isOnCurve()) {
            return xyz2;
        }
        throw new IllegalStateException("arithmetic error in scalar multiplication");
    }

    public static byte[] scalarMultWithBaseToBytes(byte[] a) {
        return scalarMultWithBase(a).toBytes();
    }

    private static byte[] slide(byte[] a) {
        int i;
        byte[] bArr = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr[i2] = (byte) (1 & ((a[i2 >> 3] & UByte.MAX_VALUE) >> (i2 & 7)));
        }
        for (int i3 = 0; i3 < 256; i3++) {
            if (bArr[i3] != 0) {
                for (int i4 = 1; i4 <= 6 && (i = i3 + i4) < 256; i4++) {
                    byte b = bArr[i];
                    if (b != 0) {
                        byte b2 = bArr[i3];
                        if ((b << i4) + b2 <= 15) {
                            bArr[i3] = (byte) (b2 + (b << i4));
                            bArr[i] = 0;
                        } else if (b2 - (b << i4) >= -15) {
                            bArr[i3] = (byte) (b2 - (b << i4));
                            while (true) {
                                if (i >= 256) {
                                    break;
                                }
                                if (bArr[i] == 0) {
                                    bArr[i] = 1;
                                    break;
                                }
                                bArr[i] = 0;
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return bArr;
    }

    private static XYZ doubleScalarMultVarTime(byte[] a, XYZT pointA, byte[] b) {
        CachedXYZT[] cachedXYZTArr = new CachedXYZT[8];
        cachedXYZTArr[0] = new CachedXYZT(pointA);
        PartialXYZT partialXYZT = new PartialXYZT();
        doubleXYZT(partialXYZT, pointA);
        XYZT xyzt = new XYZT(partialXYZT);
        for (int i = 1; i < 8; i++) {
            add(partialXYZT, xyzt, cachedXYZTArr[i - 1]);
            cachedXYZTArr[i] = new CachedXYZT(new XYZT(partialXYZT));
        }
        byte[] slide = slide(a);
        byte[] slide2 = slide(b);
        PartialXYZT partialXYZT2 = new PartialXYZT(NEUTRAL);
        XYZT xyzt2 = new XYZT();
        int i2 = 255;
        while (i2 >= 0 && slide[i2] == 0 && slide2[i2] == 0) {
            i2--;
        }
        while (i2 >= 0) {
            doubleXYZ(partialXYZT2, new XYZ(partialXYZT2));
            byte b2 = slide[i2];
            if (b2 > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt2, partialXYZT2), cachedXYZTArr[slide[i2] / 2]);
            } else if (b2 < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt2, partialXYZT2), cachedXYZTArr[(-slide[i2]) / 2]);
            }
            byte b3 = slide2[i2];
            if (b3 > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt2, partialXYZT2), Ed25519Constants.B2[slide2[i2] / 2]);
            } else if (b3 < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt2, partialXYZT2), Ed25519Constants.B2[(-slide2[i2]) / 2]);
            }
            i2--;
        }
        return new XYZ(partialXYZT2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isNonZeroVarTime(long[] in) {
        long[] jArr = new long[in.length + 1];
        System.arraycopy(in, 0, jArr, 0, in.length);
        Field25519.reduceCoefficients(jArr);
        for (byte b : Field25519.contract(jArr)) {
            if (b != 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getLsb(long[] in) {
        return Field25519.contract(in)[0] & 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void neg(long[] out, long[] in) {
        for (int i = 0; i < in.length; i++) {
            out[i] = -in[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pow2252m3(long[] out, long[] in) {
        long[] jArr = new long[10];
        long[] jArr2 = new long[10];
        long[] jArr3 = new long[10];
        Field25519.square(jArr, in);
        Field25519.square(jArr2, jArr);
        Field25519.square(jArr2, jArr2);
        Field25519.mult(jArr2, in, jArr2);
        Field25519.mult(jArr, jArr, jArr2);
        Field25519.square(jArr, jArr);
        Field25519.mult(jArr, jArr2, jArr);
        Field25519.square(jArr2, jArr);
        for (int i = 1; i < 5; i++) {
            Field25519.square(jArr2, jArr2);
        }
        Field25519.mult(jArr, jArr2, jArr);
        Field25519.square(jArr2, jArr);
        for (int i2 = 1; i2 < 10; i2++) {
            Field25519.square(jArr2, jArr2);
        }
        Field25519.mult(jArr2, jArr2, jArr);
        Field25519.square(jArr3, jArr2);
        for (int i3 = 1; i3 < 20; i3++) {
            Field25519.square(jArr3, jArr3);
        }
        Field25519.mult(jArr2, jArr3, jArr2);
        Field25519.square(jArr2, jArr2);
        for (int i4 = 1; i4 < 10; i4++) {
            Field25519.square(jArr2, jArr2);
        }
        Field25519.mult(jArr, jArr2, jArr);
        Field25519.square(jArr2, jArr);
        for (int i5 = 1; i5 < 50; i5++) {
            Field25519.square(jArr2, jArr2);
        }
        Field25519.mult(jArr2, jArr2, jArr);
        Field25519.square(jArr3, jArr2);
        for (int i6 = 1; i6 < 100; i6++) {
            Field25519.square(jArr3, jArr3);
        }
        Field25519.mult(jArr2, jArr3, jArr2);
        Field25519.square(jArr2, jArr2);
        for (int i7 = 1; i7 < 50; i7++) {
            Field25519.square(jArr2, jArr2);
        }
        Field25519.mult(jArr, jArr2, jArr);
        Field25519.square(jArr, jArr);
        Field25519.square(jArr, jArr);
        Field25519.mult(out, jArr, in);
    }

    private static long load3(byte[] in, int idx) {
        return ((in[idx + 2] & UByte.MAX_VALUE) << 16) | (in[idx] & 255) | ((in[idx + 1] & UByte.MAX_VALUE) << 8);
    }

    private static long load4(byte[] in, int idx) {
        return ((in[idx + 3] & UByte.MAX_VALUE) << 24) | load3(in, idx);
    }

    private static void reduce(byte[] s) {
        long load3 = load3(s, 0) & 2097151;
        long load4 = (load4(s, 2) >> 5) & 2097151;
        long load32 = (load3(s, 5) >> 2) & 2097151;
        long load42 = (load4(s, 7) >> 7) & 2097151;
        long load43 = (load4(s, 10) >> 4) & 2097151;
        long load33 = (load3(s, 13) >> 1) & 2097151;
        long load44 = (load4(s, 15) >> 6) & 2097151;
        long load34 = (load3(s, 18) >> 3) & 2097151;
        long load35 = load3(s, 21) & 2097151;
        long load45 = (load4(s, 23) >> 5) & 2097151;
        long load36 = (load3(s, 26) >> 2) & 2097151;
        long load46 = (load4(s, 28) >> 7) & 2097151;
        long load47 = (load4(s, 31) >> 4) & 2097151;
        long load37 = (load3(s, 34) >> 1) & 2097151;
        long load48 = (load4(s, 36) >> 6) & 2097151;
        long load38 = (load3(s, 39) >> 3) & 2097151;
        long load39 = load3(s, 42) & 2097151;
        long load49 = (load4(s, 44) >> 5) & 2097151;
        long load310 = (load3(s, 47) >> 2) & 2097151;
        long load410 = (load4(s, 49) >> 7) & 2097151;
        long load411 = (load4(s, 52) >> 4) & 2097151;
        long load311 = (load3(s, 55) >> 1) & 2097151;
        long load412 = (load4(s, 57) >> 6) & 2097151;
        long load413 = load4(s, 60) >> 3;
        long j = load39 - (load413 * 683901);
        long j2 = ((load48 - (load413 * 997805)) + (load412 * 136657)) - (load311 * 683901);
        long j3 = ((((load47 + (load413 * 470296)) + (load412 * 654183)) - (load311 * 997805)) + (load411 * 136657)) - (load410 * 683901);
        long j4 = load44 + (load310 * 666643);
        long j5 = load34 + (load410 * 666643) + (load310 * 470296);
        long j6 = load35 + (load411 * 666643) + (load410 * 470296) + (load310 * 654183);
        long j7 = (((load45 + (load311 * 666643)) + (load411 * 470296)) + (load410 * 654183)) - (load310 * 997805);
        long j8 = ((((load36 + (load412 * 666643)) + (load311 * 470296)) + (load411 * 654183)) - (load410 * 997805)) + (load310 * 136657);
        long j9 = (((((load46 + (load413 * 666643)) + (load412 * 470296)) + (load311 * 654183)) - (load411 * 997805)) + (load410 * 136657)) - (load310 * 683901);
        long j10 = (j4 + EnumG.AntennaNo_21) >> 21;
        long j11 = j5 + j10;
        long j12 = j4 - (j10 << 21);
        long j13 = (j6 + EnumG.AntennaNo_21) >> 21;
        long j14 = j7 + j13;
        long j15 = j6 - (j13 << 21);
        long j16 = (j8 + EnumG.AntennaNo_21) >> 21;
        long j17 = j9 + j16;
        long j18 = j8 - (j16 << 21);
        long j19 = (j3 + EnumG.AntennaNo_21) >> 21;
        long j20 = ((((load37 + (load413 * 654183)) - (load412 * 997805)) + (load311 * 136657)) - (load411 * 683901)) + j19;
        long j21 = j3 - (j19 << 21);
        long j22 = (j2 + EnumG.AntennaNo_21) >> 21;
        long j23 = ((load38 + (load413 * 136657)) - (load412 * 683901)) + j22;
        long j24 = j2 - (j22 << 21);
        long j25 = (j + EnumG.AntennaNo_21) >> 21;
        long j26 = load49 + j25;
        long j27 = j - (j25 << 21);
        long j28 = (j11 + EnumG.AntennaNo_21) >> 21;
        long j29 = j15 + j28;
        long j30 = j11 - (j28 << 21);
        long j31 = (j14 + EnumG.AntennaNo_21) >> 21;
        long j32 = j18 + j31;
        long j33 = j14 - (j31 << 21);
        long j34 = (j17 + EnumG.AntennaNo_21) >> 21;
        long j35 = j21 + j34;
        long j36 = j17 - (j34 << 21);
        long j37 = (j20 + EnumG.AntennaNo_21) >> 21;
        long j38 = j24 + j37;
        long j39 = j20 - (j37 << 21);
        long j40 = (j23 + EnumG.AntennaNo_21) >> 21;
        long j41 = j27 + j40;
        long j42 = j23 - (j40 << 21);
        long j43 = j32 - (j26 * 683901);
        long j44 = ((j29 - (j26 * 997805)) + (j41 * 136657)) - (j42 * 683901);
        long j45 = ((((j12 + (j26 * 470296)) + (j41 * 654183)) - (j42 * 997805)) + (j38 * 136657)) - (j39 * 683901);
        long j46 = load3 + (j35 * 666643);
        long j47 = load4 + (j39 * 666643) + (j35 * 470296);
        long j48 = load32 + (j38 * 666643) + (j39 * 470296) + (j35 * 654183);
        long j49 = (((load42 + (j42 * 666643)) + (j38 * 470296)) + (j39 * 654183)) - (j35 * 997805);
        long j50 = ((((load43 + (j41 * 666643)) + (j42 * 470296)) + (j38 * 654183)) - (j39 * 997805)) + (j35 * 136657);
        long j51 = (((((load33 + (j26 * 666643)) + (j41 * 470296)) + (j42 * 654183)) - (j38 * 997805)) + (j39 * 136657)) - (j35 * 683901);
        long j52 = (j46 + EnumG.AntennaNo_21) >> 21;
        long j53 = j47 + j52;
        long j54 = j46 - (j52 << 21);
        long j55 = (j48 + EnumG.AntennaNo_21) >> 21;
        long j56 = j49 + j55;
        long j57 = j48 - (j55 << 21);
        long j58 = (j50 + EnumG.AntennaNo_21) >> 21;
        long j59 = j51 + j58;
        long j60 = j50 - (j58 << 21);
        long j61 = (j45 + EnumG.AntennaNo_21) >> 21;
        long j62 = ((((j30 + (j26 * 654183)) - (j41 * 997805)) + (j42 * 136657)) - (j38 * 683901)) + j61;
        long j63 = j45 - (j61 << 21);
        long j64 = (j44 + EnumG.AntennaNo_21) >> 21;
        long j65 = ((j33 + (j26 * 136657)) - (j41 * 683901)) + j64;
        long j66 = j44 - (j64 << 21);
        long j67 = (j43 + EnumG.AntennaNo_21) >> 21;
        long j68 = j36 + j67;
        long j69 = j43 - (j67 << 21);
        long j70 = (j53 + EnumG.AntennaNo_21) >> 21;
        long j71 = j57 + j70;
        long j72 = j53 - (j70 << 21);
        long j73 = (j56 + EnumG.AntennaNo_21) >> 21;
        long j74 = j60 + j73;
        long j75 = j56 - (j73 << 21);
        long j76 = (j59 + EnumG.AntennaNo_21) >> 21;
        long j77 = j63 + j76;
        long j78 = j59 - (j76 << 21);
        long j79 = (j62 + EnumG.AntennaNo_21) >> 21;
        long j80 = j66 + j79;
        long j81 = j62 - (j79 << 21);
        long j82 = (j65 + EnumG.AntennaNo_21) >> 21;
        long j83 = j69 + j82;
        long j84 = j65 - (j82 << 21);
        long j85 = (j68 + EnumG.AntennaNo_21) >> 21;
        long j86 = j54 + (j85 * 666643);
        long j87 = j86 >> 21;
        long j88 = j72 + (j85 * 470296) + j87;
        long j89 = j86 - (j87 << 21);
        long j90 = j88 >> 21;
        long j91 = j71 + (j85 * 654183) + j90;
        long j92 = j88 - (j90 << 21);
        long j93 = j91 >> 21;
        long j94 = (j75 - (j85 * 997805)) + j93;
        long j95 = j91 - (j93 << 21);
        long j96 = j94 >> 21;
        long j97 = j74 + (j85 * 136657) + j96;
        long j98 = j94 - (j96 << 21);
        long j99 = j97 >> 21;
        long j100 = (j78 - (j85 * 683901)) + j99;
        long j101 = j97 - (j99 << 21);
        long j102 = j100 >> 21;
        long j103 = j77 + j102;
        long j104 = j100 - (j102 << 21);
        long j105 = j103 >> 21;
        long j106 = j81 + j105;
        long j107 = j103 - (j105 << 21);
        long j108 = j106 >> 21;
        long j109 = j80 + j108;
        long j110 = j106 - (j108 << 21);
        long j111 = j109 >> 21;
        long j112 = j84 + j111;
        long j113 = j109 - (j111 << 21);
        long j114 = j112 >> 21;
        long j115 = j83 + j114;
        long j116 = j112 - (j114 << 21);
        long j117 = j115 >> 21;
        long j118 = (j68 - (j85 << 21)) + j117;
        long j119 = j115 - (j117 << 21);
        long j120 = j118 >> 21;
        long j121 = j118 - (j120 << 21);
        long j122 = j89 + (666643 * j120);
        long j123 = j92 + (470296 * j120);
        long j124 = j95 + (654183 * j120);
        long j125 = j98 - (997805 * j120);
        long j126 = j101 + (136657 * j120);
        long j127 = j104 - (j120 * 683901);
        long j128 = j122 >> 21;
        long j129 = j123 + j128;
        long j130 = j122 - (j128 << 21);
        long j131 = j129 >> 21;
        long j132 = j124 + j131;
        long j133 = j129 - (j131 << 21);
        long j134 = j132 >> 21;
        long j135 = j125 + j134;
        long j136 = j132 - (j134 << 21);
        long j137 = j135 >> 21;
        long j138 = j126 + j137;
        long j139 = j135 - (j137 << 21);
        long j140 = j138 >> 21;
        long j141 = j127 + j140;
        long j142 = j138 - (j140 << 21);
        long j143 = j141 >> 21;
        long j144 = j107 + j143;
        long j145 = j141 - (j143 << 21);
        long j146 = j144 >> 21;
        long j147 = j110 + j146;
        long j148 = j144 - (j146 << 21);
        long j149 = j147 >> 21;
        long j150 = j113 + j149;
        long j151 = j147 - (j149 << 21);
        long j152 = j150 >> 21;
        long j153 = j116 + j152;
        long j154 = j153 >> 21;
        long j155 = j119 + j154;
        long j156 = j153 - (j154 << 21);
        long j157 = j155 >> 21;
        long j158 = j121 + j157;
        long j159 = j155 - (j157 << 21);
        s[0] = (byte) j130;
        s[1] = (byte) (j130 >> 8);
        s[2] = (byte) ((j130 >> 16) | (j133 << 5));
        s[3] = (byte) (j133 >> 3);
        s[4] = (byte) (j133 >> 11);
        s[5] = (byte) ((j133 >> 19) | (j136 << 2));
        s[6] = (byte) (j136 >> 6);
        s[7] = (byte) ((j136 >> 14) | (j139 << 7));
        s[8] = (byte) (j139 >> 1);
        s[9] = (byte) (j139 >> 9);
        s[10] = (byte) ((j139 >> 17) | (j142 << 4));
        s[11] = (byte) (j142 >> 4);
        s[12] = (byte) (j142 >> 12);
        s[13] = (byte) ((j142 >> 20) | (j145 << 1));
        s[14] = (byte) (j145 >> 7);
        s[15] = (byte) ((j145 >> 15) | (j148 << 6));
        s[16] = (byte) (j148 >> 2);
        s[17] = (byte) (j148 >> 10);
        s[18] = (byte) ((j148 >> 18) | (j151 << 3));
        s[19] = (byte) (j151 >> 5);
        s[20] = (byte) (j151 >> 13);
        s[21] = (byte) (j150 - (j152 << 21));
        s[22] = (byte) (r11 >> 8);
        s[23] = (byte) ((r11 >> 16) | (j156 << 5));
        s[24] = (byte) (j156 >> 3);
        s[25] = (byte) (j156 >> 11);
        s[26] = (byte) ((j156 >> 19) | (j159 << 2));
        s[27] = (byte) (j159 >> 6);
        s[28] = (byte) ((j159 >> 14) | (j158 << 7));
        s[29] = (byte) (j158 >> 1);
        s[30] = (byte) (j158 >> 9);
        s[31] = (byte) (j158 >> 17);
    }

    private static void mulAdd(byte[] s, byte[] a, byte[] b, byte[] c) {
        long load3 = load3(a, 0) & 2097151;
        long load4 = (load4(a, 2) >> 5) & 2097151;
        long load32 = (load3(a, 5) >> 2) & 2097151;
        long load42 = (load4(a, 7) >> 7) & 2097151;
        long load43 = (load4(a, 10) >> 4) & 2097151;
        long load33 = (load3(a, 13) >> 1) & 2097151;
        long load44 = (load4(a, 15) >> 6) & 2097151;
        long load34 = (load3(a, 18) >> 3) & 2097151;
        long load35 = load3(a, 21) & 2097151;
        long load45 = (load4(a, 23) >> 5) & 2097151;
        long load36 = (load3(a, 26) >> 2) & 2097151;
        long load46 = load4(a, 28) >> 7;
        long load37 = load3(b, 0) & 2097151;
        long load47 = (load4(b, 2) >> 5) & 2097151;
        long load38 = (load3(b, 5) >> 2) & 2097151;
        long load48 = (load4(b, 7) >> 7) & 2097151;
        long load49 = (load4(b, 10) >> 4) & 2097151;
        long load39 = (load3(b, 13) >> 1) & 2097151;
        long load410 = (load4(b, 15) >> 6) & 2097151;
        long load310 = (load3(b, 18) >> 3) & 2097151;
        long load311 = load3(b, 21) & 2097151;
        long load411 = (load4(b, 23) >> 5) & 2097151;
        long load312 = (load3(b, 26) >> 2) & 2097151;
        long load412 = load4(b, 28) >> 7;
        long load313 = load3(c, 0) & 2097151;
        long load413 = (load4(c, 2) >> 5) & 2097151;
        long load314 = (load3(c, 5) >> 2) & 2097151;
        long load414 = (load4(c, 7) >> 7) & 2097151;
        long load415 = (load4(c, 10) >> 4) & 2097151;
        long load315 = (load3(c, 13) >> 1) & 2097151;
        long load416 = (load4(c, 15) >> 6) & 2097151;
        long load316 = (load3(c, 18) >> 3) & 2097151;
        long load317 = load3(c, 21) & 2097151;
        long j = load313 + (load3 * load37);
        long j2 = load413 + (load3 * load47) + (load4 * load37);
        long j3 = load314 + (load3 * load38) + (load4 * load47) + (load32 * load37);
        long j4 = load414 + (load3 * load48) + (load4 * load38) + (load32 * load47) + (load42 * load37);
        long j5 = load415 + (load3 * load49) + (load4 * load48) + (load32 * load38) + (load42 * load47) + (load43 * load37);
        long j6 = load315 + (load3 * load39) + (load4 * load49) + (load32 * load48) + (load42 * load38) + (load43 * load47) + (load33 * load37);
        long j7 = load416 + (load3 * load410) + (load4 * load39) + (load32 * load49) + (load42 * load48) + (load43 * load38) + (load33 * load47) + (load44 * load37);
        long j8 = load316 + (load3 * load310) + (load4 * load410) + (load32 * load39) + (load42 * load49) + (load43 * load48) + (load33 * load38) + (load44 * load47) + (load34 * load37);
        long j9 = load317 + (load3 * load311) + (load4 * load310) + (load32 * load410) + (load42 * load39) + (load43 * load49) + (load33 * load48) + (load44 * load38) + (load34 * load47) + (load35 * load37);
        long load417 = ((load4(c, 23) >> 5) & 2097151) + (load3 * load411) + (load4 * load311) + (load32 * load310) + (load42 * load410) + (load43 * load39) + (load33 * load49) + (load44 * load48) + (load34 * load38) + (load35 * load47) + (load45 * load37);
        long load318 = ((load3(c, 26) >> 2) & 2097151) + (load3 * load312) + (load4 * load411) + (load32 * load311) + (load42 * load310) + (load43 * load410) + (load33 * load39) + (load44 * load49) + (load34 * load48) + (load35 * load38) + (load45 * load47) + (load36 * load37);
        long load418 = (load4(c, 28) >> 7) + (load3 * load412) + (load4 * load312) + (load32 * load411) + (load42 * load311) + (load43 * load310) + (load33 * load410) + (load44 * load39) + (load34 * load49) + (load35 * load48) + (load45 * load38) + (load36 * load47) + (load37 * load46);
        long j10 = (load4 * load412) + (load32 * load312) + (load42 * load411) + (load43 * load311) + (load33 * load310) + (load44 * load410) + (load34 * load39) + (load35 * load49) + (load45 * load48) + (load36 * load38) + (load47 * load46);
        long j11 = (load32 * load412) + (load42 * load312) + (load43 * load411) + (load33 * load311) + (load44 * load310) + (load34 * load410) + (load35 * load39) + (load45 * load49) + (load36 * load48) + (load38 * load46);
        long j12 = (load42 * load412) + (load43 * load312) + (load33 * load411) + (load44 * load311) + (load34 * load310) + (load35 * load410) + (load45 * load39) + (load36 * load49) + (load48 * load46);
        long j13 = (load43 * load412) + (load33 * load312) + (load44 * load411) + (load34 * load311) + (load35 * load310) + (load45 * load410) + (load36 * load39) + (load49 * load46);
        long j14 = (load33 * load412) + (load44 * load312) + (load34 * load411) + (load35 * load311) + (load45 * load310) + (load36 * load410) + (load39 * load46);
        long j15 = (load44 * load412) + (load34 * load312) + (load35 * load411) + (load45 * load311) + (load36 * load310) + (load410 * load46);
        long j16 = (load34 * load412) + (load35 * load312) + (load45 * load411) + (load36 * load311) + (load310 * load46);
        long j17 = (load35 * load412) + (load45 * load312) + (load36 * load411) + (load311 * load46);
        long j18 = (load45 * load412) + (load36 * load312) + (load411 * load46);
        long j19 = (load36 * load412) + (load312 * load46);
        long j20 = load46 * load412;
        long j21 = (j + EnumG.AntennaNo_21) >> 21;
        long j22 = j2 + j21;
        long j23 = j - (j21 << 21);
        long j24 = (j3 + EnumG.AntennaNo_21) >> 21;
        long j25 = j4 + j24;
        long j26 = j3 - (j24 << 21);
        long j27 = (j5 + EnumG.AntennaNo_21) >> 21;
        long j28 = j6 + j27;
        long j29 = j5 - (j27 << 21);
        long j30 = (j7 + EnumG.AntennaNo_21) >> 21;
        long j31 = j8 + j30;
        long j32 = j7 - (j30 << 21);
        long j33 = (j9 + EnumG.AntennaNo_21) >> 21;
        long j34 = load417 + j33;
        long j35 = j9 - (j33 << 21);
        long j36 = (load318 + EnumG.AntennaNo_21) >> 21;
        long j37 = load418 + j36;
        long j38 = load318 - (j36 << 21);
        long j39 = (j10 + EnumG.AntennaNo_21) >> 21;
        long j40 = j11 + j39;
        long j41 = j10 - (j39 << 21);
        long j42 = (j12 + EnumG.AntennaNo_21) >> 21;
        long j43 = j13 + j42;
        long j44 = j12 - (j42 << 21);
        long j45 = (j14 + EnumG.AntennaNo_21) >> 21;
        long j46 = j15 + j45;
        long j47 = j14 - (j45 << 21);
        long j48 = (j16 + EnumG.AntennaNo_21) >> 21;
        long j49 = j17 + j48;
        long j50 = j16 - (j48 << 21);
        long j51 = (j18 + EnumG.AntennaNo_21) >> 21;
        long j52 = j19 + j51;
        long j53 = j18 - (j51 << 21);
        long j54 = (j20 + EnumG.AntennaNo_21) >> 21;
        long j55 = (j22 + EnumG.AntennaNo_21) >> 21;
        long j56 = j26 + j55;
        long j57 = j22 - (j55 << 21);
        long j58 = (j25 + EnumG.AntennaNo_21) >> 21;
        long j59 = j29 + j58;
        long j60 = j25 - (j58 << 21);
        long j61 = (j28 + EnumG.AntennaNo_21) >> 21;
        long j62 = j32 + j61;
        long j63 = j28 - (j61 << 21);
        long j64 = (j31 + EnumG.AntennaNo_21) >> 21;
        long j65 = j35 + j64;
        long j66 = j31 - (j64 << 21);
        long j67 = (j34 + EnumG.AntennaNo_21) >> 21;
        long j68 = j38 + j67;
        long j69 = j34 - (j67 << 21);
        long j70 = (j37 + EnumG.AntennaNo_21) >> 21;
        long j71 = j41 + j70;
        long j72 = j37 - (j70 << 21);
        long j73 = (j40 + EnumG.AntennaNo_21) >> 21;
        long j74 = j44 + j73;
        long j75 = j40 - (j73 << 21);
        long j76 = (j43 + EnumG.AntennaNo_21) >> 21;
        long j77 = j47 + j76;
        long j78 = j43 - (j76 << 21);
        long j79 = (j46 + EnumG.AntennaNo_21) >> 21;
        long j80 = j50 + j79;
        long j81 = j46 - (j79 << 21);
        long j82 = (j49 + EnumG.AntennaNo_21) >> 21;
        long j83 = j53 + j82;
        long j84 = j49 - (j82 << 21);
        long j85 = (j52 + EnumG.AntennaNo_21) >> 21;
        long j86 = (j20 - (j54 << 21)) + j85;
        long j87 = j52 - (j85 << 21);
        long j88 = j78 + (j54 * 136657);
        long j89 = j77 - (j54 * 683901);
        long j90 = ((j75 + (j54 * 654183)) - (j86 * 997805)) + (j87 * 136657);
        long j91 = ((j74 - (j54 * 997805)) + (j86 * 136657)) - (j87 * 683901);
        long j92 = ((((j72 + (j54 * 666643)) + (j86 * 470296)) + (j87 * 654183)) - (j83 * 997805)) + (j84 * 136657);
        long j93 = ((((j71 + (j54 * 470296)) + (j86 * 654183)) - (j87 * 997805)) + (j83 * 136657)) - (j84 * 683901);
        long j94 = j62 + (j80 * 666643);
        long j95 = j65 + (j83 * 666643) + (j84 * 470296) + (j80 * 654183);
        long j96 = ((((j68 + (j86 * 666643)) + (j87 * 470296)) + (j83 * 654183)) - (j84 * 997805)) + (j80 * 136657);
        long j97 = (j94 + EnumG.AntennaNo_21) >> 21;
        long j98 = j66 + (j84 * 666643) + (j80 * 470296) + j97;
        long j99 = j94 - (j97 << 21);
        long j100 = (j95 + EnumG.AntennaNo_21) >> 21;
        long j101 = ((((j69 + (j87 * 666643)) + (j83 * 470296)) + (j84 * 654183)) - (j80 * 997805)) + j100;
        long j102 = j95 - (j100 << 21);
        long j103 = (j96 + EnumG.AntennaNo_21) >> 21;
        long j104 = (j92 - (j80 * 683901)) + j103;
        long j105 = j96 - (j103 << 21);
        long j106 = (j93 + EnumG.AntennaNo_21) >> 21;
        long j107 = (j90 - (j83 * 683901)) + j106;
        long j108 = j93 - (j106 << 21);
        long j109 = (j91 + EnumG.AntennaNo_21) >> 21;
        long j110 = (j88 - (j86 * 683901)) + j109;
        long j111 = j91 - (j109 << 21);
        long j112 = (j89 + EnumG.AntennaNo_21) >> 21;
        long j113 = j81 + j112;
        long j114 = j89 - (j112 << 21);
        long j115 = (j98 + EnumG.AntennaNo_21) >> 21;
        long j116 = j102 + j115;
        long j117 = j98 - (j115 << 21);
        long j118 = (j101 + EnumG.AntennaNo_21) >> 21;
        long j119 = j105 + j118;
        long j120 = j101 - (j118 << 21);
        long j121 = (j104 + EnumG.AntennaNo_21) >> 21;
        long j122 = j108 + j121;
        long j123 = j104 - (j121 << 21);
        long j124 = (j107 + EnumG.AntennaNo_21) >> 21;
        long j125 = j111 + j124;
        long j126 = j107 - (j124 << 21);
        long j127 = (j110 + EnumG.AntennaNo_21) >> 21;
        long j128 = j114 + j127;
        long j129 = j110 - (j127 << 21);
        long j130 = j119 - (j113 * 683901);
        long j131 = ((j116 - (j113 * 997805)) + (j128 * 136657)) - (j129 * 683901);
        long j132 = ((((j99 + (j113 * 470296)) + (j128 * 654183)) - (j129 * 997805)) + (j125 * 136657)) - (j126 * 683901);
        long j133 = j23 + (j122 * 666643);
        long j134 = j56 + (j125 * 666643) + (j126 * 470296) + (j122 * 654183);
        long j135 = ((((j59 + (j128 * 666643)) + (j129 * 470296)) + (j125 * 654183)) - (j126 * 997805)) + (j122 * 136657);
        long j136 = (j133 + EnumG.AntennaNo_21) >> 21;
        long j137 = j57 + (j126 * 666643) + (j122 * 470296) + j136;
        long j138 = j133 - (j136 << 21);
        long j139 = (j134 + EnumG.AntennaNo_21) >> 21;
        long j140 = ((((j60 + (j129 * 666643)) + (j125 * 470296)) + (j126 * 654183)) - (j122 * 997805)) + j139;
        long j141 = j134 - (j139 << 21);
        long j142 = (j135 + EnumG.AntennaNo_21) >> 21;
        long j143 = ((((((j63 + (j113 * 666643)) + (j128 * 470296)) + (j129 * 654183)) - (j125 * 997805)) + (j126 * 136657)) - (j122 * 683901)) + j142;
        long j144 = j135 - (j142 << 21);
        long j145 = (j132 + EnumG.AntennaNo_21) >> 21;
        long j146 = ((((j117 + (j113 * 654183)) - (j128 * 997805)) + (j129 * 136657)) - (j125 * 683901)) + j145;
        long j147 = j132 - (j145 << 21);
        long j148 = (j131 + EnumG.AntennaNo_21) >> 21;
        long j149 = ((j120 + (j113 * 136657)) - (j128 * 683901)) + j148;
        long j150 = j131 - (j148 << 21);
        long j151 = (j130 + EnumG.AntennaNo_21) >> 21;
        long j152 = j123 + j151;
        long j153 = j130 - (j151 << 21);
        long j154 = (j137 + EnumG.AntennaNo_21) >> 21;
        long j155 = j141 + j154;
        long j156 = j137 - (j154 << 21);
        long j157 = (j140 + EnumG.AntennaNo_21) >> 21;
        long j158 = j144 + j157;
        long j159 = j140 - (j157 << 21);
        long j160 = (j143 + EnumG.AntennaNo_21) >> 21;
        long j161 = j147 + j160;
        long j162 = j143 - (j160 << 21);
        long j163 = (j146 + EnumG.AntennaNo_21) >> 21;
        long j164 = j150 + j163;
        long j165 = j146 - (j163 << 21);
        long j166 = (j149 + EnumG.AntennaNo_21) >> 21;
        long j167 = j153 + j166;
        long j168 = j149 - (j166 << 21);
        long j169 = (EnumG.AntennaNo_21 + j152) >> 21;
        long j170 = j138 + (j169 * 666643);
        long j171 = j170 >> 21;
        long j172 = j156 + (j169 * 470296) + j171;
        long j173 = j170 - (j171 << 21);
        long j174 = j172 >> 21;
        long j175 = j155 + (j169 * 654183) + j174;
        long j176 = j172 - (j174 << 21);
        long j177 = j175 >> 21;
        long j178 = (j159 - (j169 * 997805)) + j177;
        long j179 = j175 - (j177 << 21);
        long j180 = j178 >> 21;
        long j181 = j158 + (j169 * 136657) + j180;
        long j182 = j178 - (j180 << 21);
        long j183 = j181 >> 21;
        long j184 = (j162 - (j169 * 683901)) + j183;
        long j185 = j181 - (j183 << 21);
        long j186 = j184 >> 21;
        long j187 = j161 + j186;
        long j188 = j184 - (j186 << 21);
        long j189 = j187 >> 21;
        long j190 = j165 + j189;
        long j191 = j187 - (j189 << 21);
        long j192 = j190 >> 21;
        long j193 = j164 + j192;
        long j194 = j190 - (j192 << 21);
        long j195 = j193 >> 21;
        long j196 = j168 + j195;
        long j197 = j193 - (j195 << 21);
        long j198 = j196 >> 21;
        long j199 = j167 + j198;
        long j200 = j196 - (j198 << 21);
        long j201 = j199 >> 21;
        long j202 = (j152 - (j169 << 21)) + j201;
        long j203 = j199 - (j201 << 21);
        long j204 = j202 >> 21;
        long j205 = j202 - (j204 << 21);
        long j206 = j173 + (666643 * j204);
        long j207 = j176 + (470296 * j204);
        long j208 = j179 + (654183 * j204);
        long j209 = j182 - (997805 * j204);
        long j210 = j185 + (136657 * j204);
        long j211 = j188 - (j204 * 683901);
        long j212 = j206 >> 21;
        long j213 = j207 + j212;
        long j214 = j213 >> 21;
        long j215 = j208 + j214;
        long j216 = j213 - (j214 << 21);
        long j217 = j215 >> 21;
        long j218 = j209 + j217;
        long j219 = j215 - (j217 << 21);
        long j220 = j218 >> 21;
        long j221 = j210 + j220;
        long j222 = j218 - (j220 << 21);
        long j223 = j221 >> 21;
        long j224 = j211 + j223;
        long j225 = j221 - (j223 << 21);
        long j226 = j224 >> 21;
        long j227 = j191 + j226;
        long j228 = j224 - (j226 << 21);
        long j229 = j227 >> 21;
        long j230 = j194 + j229;
        long j231 = j227 - (j229 << 21);
        long j232 = j230 >> 21;
        long j233 = j197 + j232;
        long j234 = j230 - (j232 << 21);
        long j235 = j233 >> 21;
        long j236 = j200 + j235;
        long j237 = j236 >> 21;
        long j238 = j203 + j237;
        long j239 = j236 - (j237 << 21);
        long j240 = j238 >> 21;
        long j241 = j205 + j240;
        long j242 = j238 - (j240 << 21);
        s[0] = (byte) (j206 - (j212 << 21));
        s[1] = (byte) (r4 >> 8);
        s[2] = (byte) ((r4 >> 16) | (j216 << 5));
        s[3] = (byte) (j216 >> 3);
        s[4] = (byte) (j216 >> 11);
        s[5] = (byte) ((j216 >> 19) | (j219 << 2));
        s[6] = (byte) (j219 >> 6);
        s[7] = (byte) ((j219 >> 14) | (j222 << 7));
        s[8] = (byte) (j222 >> 1);
        s[9] = (byte) (j222 >> 9);
        s[10] = (byte) ((j222 >> 17) | (j225 << 4));
        s[11] = (byte) (j225 >> 4);
        s[12] = (byte) (j225 >> 12);
        s[13] = (byte) ((j225 >> 20) | (j228 << 1));
        s[14] = (byte) (j228 >> 7);
        s[15] = (byte) ((j228 >> 15) | (j231 << 6));
        s[16] = (byte) (j231 >> 2);
        s[17] = (byte) (j231 >> 10);
        s[18] = (byte) ((j231 >> 18) | (j234 << 3));
        s[19] = (byte) (j234 >> 5);
        s[20] = (byte) (j234 >> 13);
        s[21] = (byte) (j233 - (j235 << 21));
        s[22] = (byte) (r9 >> 8);
        s[23] = (byte) ((r9 >> 16) | (j239 << 5));
        s[24] = (byte) (j239 >> 3);
        s[25] = (byte) (j239 >> 11);
        s[26] = (byte) ((j239 >> 19) | (j242 << 2));
        s[27] = (byte) (j242 >> 6);
        s[28] = (byte) ((j242 >> 14) | (j241 << 7));
        s[29] = (byte) (j241 >> 1);
        s[30] = (byte) (j241 >> 9);
        s[31] = (byte) (j241 >> 17);
    }

    public static byte[] getHashedScalar(final byte[] privateKey) throws GeneralSecurityException {
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        engineFactory.update(privateKey, 0, 32);
        byte[] digest = engineFactory.digest();
        digest[0] = (byte) (digest[0] & 248);
        byte b = (byte) (digest[31] & ByteCompanionObject.MAX_VALUE);
        digest[31] = b;
        digest[31] = (byte) (b | 64);
        return digest;
    }

    public static byte[] sign(final byte[] message, final byte[] publicKey, final byte[] hashedPrivateKey) throws GeneralSecurityException {
        byte[] copyOfRange = Arrays.copyOfRange(message, 0, message.length);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        engineFactory.update(hashedPrivateKey, 32, 32);
        engineFactory.update(copyOfRange);
        byte[] digest = engineFactory.digest();
        reduce(digest);
        byte[] copyOfRange2 = Arrays.copyOfRange(scalarMultWithBase(digest).toBytes(), 0, 32);
        engineFactory.reset();
        engineFactory.update(copyOfRange2);
        engineFactory.update(publicKey);
        engineFactory.update(copyOfRange);
        byte[] digest2 = engineFactory.digest();
        reduce(digest2);
        byte[] bArr = new byte[32];
        mulAdd(bArr, digest2, hashedPrivateKey, digest);
        return Bytes.concat(copyOfRange2, bArr);
    }

    private static boolean isSmallerThanGroupOrder(byte[] s) {
        for (int i = 31; i >= 0; i--) {
            int i2 = s[i] & UByte.MAX_VALUE;
            int i3 = GROUP_ORDER[i] & UByte.MAX_VALUE;
            if (i2 != i3) {
                return i2 < i3;
            }
        }
        return false;
    }

    public static boolean verify(final byte[] message, final byte[] signature, final byte[] publicKey) throws GeneralSecurityException {
        if (signature.length != 64) {
            return false;
        }
        byte[] copyOfRange = Arrays.copyOfRange(signature, 32, 64);
        if (!isSmallerThanGroupOrder(copyOfRange)) {
            return false;
        }
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        engineFactory.update(signature, 0, 32);
        engineFactory.update(publicKey);
        engineFactory.update(message);
        byte[] digest = engineFactory.digest();
        reduce(digest);
        byte[] bytes = doubleScalarMultVarTime(digest, XYZT.fromBytesNegateVarTime(publicKey), copyOfRange).toBytes();
        for (int i = 0; i < 32; i++) {
            if (bytes[i] != signature[i]) {
                return false;
            }
        }
        return true;
    }

    public static void init() {
        if (Ed25519Constants.D == null) {
            throw new IllegalStateException("Could not initialize Ed25519.");
        }
    }

    private Ed25519() {
    }
}
