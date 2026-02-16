package com.devexpress.editors.utils;

import android.text.method.NumberKeyListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NumericEditKeyListener.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0002J<\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0014J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/devexpress/editors/utils/NumericEditKeyListener;", "Landroid/text/method/NumberKeyListener;", "inputType", "", "decimalSeparator", "", "minusSign", "decimalSeparatorEnabled", "", "(ICCZ)V", "acceptedChars", "", "createAcceptedChars", "hasSign", "filter", "", "source", "start", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "getAcceptedChars", "getInputType", "getMinusSigns", "", "isDecimalPointChar", "c", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class NumericEditKeyListener extends NumberKeyListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final char EN_DASH = 8211;
    private static final char HYPHEN_MINUS = '-';
    private static final char MINUS_SIGN = 8722;
    private static Map<Character, NumericEditKeyListener> signedCache;
    private static Map<Character, NumericEditKeyListener> unsignedCache;
    private char[] acceptedChars;
    private final char decimalSeparator;
    private final boolean decimalSeparatorEnabled;
    private final int inputType;
    private final char minusSign;

    public NumericEditKeyListener(int i, char c, char c2, boolean z) {
        this.inputType = i;
        this.decimalSeparator = c;
        this.minusSign = c2;
        this.decimalSeparatorEnabled = z;
    }

    /* compiled from: NumericEditKeyListener.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J(\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002JV\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b0\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/devexpress/editors/utils/NumericEditKeyListener$Companion;", "", "()V", "EN_DASH", "", "HYPHEN_MINUS", "MINUS_SIGN", "signedCache", "", "Lcom/devexpress/editors/utils/NumericEditKeyListener;", "unsignedCache", "create", "Landroid/text/method/NumberKeyListener;", "inputType", "", "decimalSeparator", "getInstance", "minusSign", "decimalSeparatorEnabled", "", "Lkotlin/Pair;", "cache", "getMinusSign", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final char getMinusSign() {
            NumberFormat numberFormat = NumberFormat.getInstance();
            return numberFormat instanceof DecimalFormat ? ((DecimalFormat) numberFormat).getDecimalFormatSymbols().getMinusSign() : NumericEditKeyListener.HYPHEN_MINUS;
        }

        public final NumberKeyListener create(int inputType, char decimalSeparator) {
            return getInstance(inputType, decimalSeparator, getMinusSign(), true);
        }

        private final NumericEditKeyListener getInstance(int inputType, char decimalSeparator, char minusSign, boolean decimalSeparatorEnabled) {
            if (UtilsKt.has(inputType, 4096)) {
                Pair<NumericEditKeyListener, Map<Character, NumericEditKeyListener>> companion = getInstance(inputType, decimalSeparator, minusSign, decimalSeparatorEnabled, NumericEditKeyListener.signedCache);
                NumericEditKeyListener.signedCache = companion.getSecond();
                return companion.getFirst();
            }
            Pair<NumericEditKeyListener, Map<Character, NumericEditKeyListener>> companion2 = getInstance(inputType, decimalSeparator, minusSign, decimalSeparatorEnabled, NumericEditKeyListener.unsignedCache);
            NumericEditKeyListener.unsignedCache = companion2.getSecond();
            return companion2.getFirst();
        }

        private final Pair<NumericEditKeyListener, Map<Character, NumericEditKeyListener>> getInstance(int inputType, char decimalSeparator, char minusSign, boolean decimalSeparatorEnabled, Map<Character, NumericEditKeyListener> cache) {
            if (cache == null) {
                cache = new HashMap(1);
            }
            if (!cache.containsKey(Character.valueOf(decimalSeparator))) {
                cache.put(Character.valueOf(decimalSeparator), new NumericEditKeyListener(inputType, decimalSeparator, minusSign, decimalSeparatorEnabled));
            }
            NumericEditKeyListener numericEditKeyListener = cache.get(Character.valueOf(decimalSeparator));
            Intrinsics.checkNotNull(numericEditKeyListener);
            return new Pair<>(numericEditKeyListener, cache);
        }
    }

    @Override // android.text.method.NumberKeyListener
    protected char[] getAcceptedChars() {
        boolean z = (this.inputType & 4096) == 4096;
        char[] cArr = this.acceptedChars;
        if (cArr == null) {
            cArr = createAcceptedChars(z);
        }
        this.acceptedChars = cArr;
        Intrinsics.checkNotNull(cArr);
        return cArr;
    }

    private final char[] createAcceptedChars(boolean hasSign) {
        String str = "0123456789";
        if (hasSign) {
            str = "0123456789" + getMinusSigns();
        }
        if (this.decimalSeparatorEnabled) {
            str = str + this.decimalSeparator;
        }
        char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        return charArray;
    }

    private final String getMinusSigns() {
        char c = this.minusSign;
        return (c == 8722 || c == 8211) ? "--" : "-";
    }

    private final boolean isDecimalPointChar(char c) {
        return c == this.decimalSeparator;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0070 A[LOOP:2: B:28:0x0043->B:43:0x0070, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0073 A[EDGE_INSN: B:44:0x0073->B:47:0x0073 BREAK  A[LOOP:2: B:28:0x0043->B:43:0x0070], SYNTHETIC] */
    @Override // android.text.method.NumberKeyListener, android.text.InputFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.CharSequence filter(java.lang.CharSequence r8, int r9, int r10, android.text.Spanned r11, int r12, int r13) {
        /*
            r7 = this;
            java.lang.CharSequence r0 = super.filter(r8, r9, r10, r11, r12, r13)
            if (r0 != 0) goto L8
            r1 = r8
            goto L9
        L8:
            r1 = r0
        L9:
            r2 = 0
            if (r0 == 0) goto Ld
            r9 = r2
        Ld:
            if (r0 == 0) goto L13
            int r10 = r0.length()
        L13:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            int r3 = r11.length()
            r4 = -1
            r5 = r2
        L1c:
            if (r5 >= r12) goto L2c
            char r6 = r11.charAt(r5)
            boolean r6 = r7.isDecimalPointChar(r6)
            if (r6 == 0) goto L29
            r4 = r5
        L29:
            int r5 = r5 + 1
            goto L1c
        L2c:
            if (r13 >= r3) goto L3c
            char r12 = r11.charAt(r13)
            boolean r12 = r7.isDecimalPointChar(r12)
            if (r12 == 0) goto L39
            r4 = r13
        L39:
            int r13 = r13 + 1
            goto L2c
        L3c:
            int r11 = r10 + (-1)
            java.lang.String r12 = ""
            r13 = 0
            if (r9 > r11) goto L73
        L43:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            char r3 = r1.charAt(r11)
            boolean r3 = r7.isDecimalPointChar(r3)
            if (r3 == 0) goto L55
            if (r4 < 0) goto L54
            r3 = 1
            goto L56
        L54:
            r4 = r11
        L55:
            r3 = r2
        L56:
            if (r3 == 0) goto L6e
            int r3 = r9 + 1
            if (r10 != r3) goto L5f
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            return r12
        L5f:
            if (r13 != 0) goto L66
            android.text.SpannableStringBuilder r13 = new android.text.SpannableStringBuilder
            r13.<init>(r1, r9, r10)
        L66:
            int r3 = r11 - r9
            int r5 = r11 + 1
            int r5 = r5 - r9
            r13.delete(r3, r5)
        L6e:
            if (r11 == r9) goto L73
            int r11 = r11 + (-1)
            goto L43
        L73:
            if (r13 == 0) goto L7f
            java.lang.String r9 = r13.toString()
            if (r9 == 0) goto L7f
            r8 = r9
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            goto L88
        L7f:
            if (r0 != 0) goto L87
            if (r8 != 0) goto L88
            r8 = r12
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            goto L88
        L87:
            r8 = r0
        L88:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.editors.utils.NumericEditKeyListener.filter(java.lang.CharSequence, int, int, android.text.Spanned, int, int):java.lang.CharSequence");
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.inputType;
    }
}
