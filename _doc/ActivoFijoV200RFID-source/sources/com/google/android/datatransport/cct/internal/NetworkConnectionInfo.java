package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;
import com.google.android.datatransport.cct.internal.AutoValue_NetworkConnectionInfo;

/* loaded from: classes2.dex */
public abstract class NetworkConnectionInfo {

    public static abstract class Builder {
        public abstract NetworkConnectionInfo build();

        public abstract Builder setMobileSubtype(MobileSubtype mobileSubtype);

        public abstract Builder setNetworkType(NetworkType networkType);
    }

    public abstract MobileSubtype getMobileSubtype();

    public abstract NetworkType getNetworkType();

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.google.android.datatransport.cct.internal.NetworkConnectionInfo$NetworkType, still in use, count: 1, list:
      (r0v0 com.google.android.datatransport.cct.internal.NetworkConnectionInfo$NetworkType) from 0x00e4: INVOKE 
      (r4v9 android.util.SparseArray<com.google.android.datatransport.cct.internal.NetworkConnectionInfo$NetworkType>)
      (0 int)
      (r0v0 com.google.android.datatransport.cct.internal.NetworkConnectionInfo$NetworkType)
     VIRTUAL call: android.util.SparseArray.put(int, java.lang.Object):void A[MD:(int, E):void (c)] (LINE:52)
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class NetworkType {
        MOBILE(0),
        WIFI(1),
        MOBILE_MMS(2),
        MOBILE_SUPL(3),
        MOBILE_DUN(4),
        MOBILE_HIPRI(5),
        WIMAX(6),
        BLUETOOTH(7),
        DUMMY(8),
        ETHERNET(9),
        MOBILE_FOTA(10),
        MOBILE_IMS(11),
        MOBILE_CBS(12),
        WIFI_P2P(13),
        MOBILE_IA(14),
        MOBILE_EMERGENCY(15),
        PROXY(16),
        VPN(17),
        NONE(-1);

        private static final SparseArray<NetworkType> valueMap;
        private final int value;

        public static NetworkType valueOf(String str) {
            return (NetworkType) Enum.valueOf(NetworkType.class, str);
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
        }

        static {
            SparseArray<NetworkType> sparseArray = new SparseArray<>();
            valueMap = sparseArray;
            sparseArray.put(0, new NetworkType(0));
            sparseArray.put(1, new NetworkType(1));
            sparseArray.put(2, new NetworkType(2));
            sparseArray.put(3, new NetworkType(3));
            sparseArray.put(4, new NetworkType(4));
            sparseArray.put(5, new NetworkType(5));
            sparseArray.put(6, new NetworkType(6));
            sparseArray.put(7, new NetworkType(7));
            sparseArray.put(8, new NetworkType(8));
            sparseArray.put(9, new NetworkType(9));
            sparseArray.put(10, new NetworkType(10));
            sparseArray.put(11, new NetworkType(11));
            sparseArray.put(12, new NetworkType(12));
            sparseArray.put(13, new NetworkType(13));
            sparseArray.put(14, new NetworkType(14));
            sparseArray.put(15, new NetworkType(15));
            sparseArray.put(16, new NetworkType(16));
            sparseArray.put(17, new NetworkType(17));
            sparseArray.put(-1, new NetworkType(-1));
        }

        private NetworkType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static NetworkType forNumber(int i) {
            return valueMap.get(i);
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype, still in use, count: 1, list:
      (r0v0 com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype) from 0x00ff: INVOKE 
      (r2v10 android.util.SparseArray<com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype>)
      (0 int)
      (r0v0 com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype)
     VIRTUAL call: android.util.SparseArray.put(int, java.lang.Object):void A[MD:(int, E):void (c)] (LINE:119)
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class MobileSubtype {
        UNKNOWN_MOBILE_SUBTYPE(0),
        GPRS(1),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        EVDO_0(5),
        EVDO_A(6),
        RTT(7),
        HSDPA(8),
        HSUPA(9),
        HSPA(10),
        IDEN(11),
        EVDO_B(12),
        LTE(13),
        EHRPD(14),
        HSPAP(15),
        GSM(16),
        TD_SCDMA(17),
        IWLAN(18),
        LTE_CA(19),
        COMBINED(100);

        private static final SparseArray<MobileSubtype> valueMap;
        private final int value;

        public static MobileSubtype valueOf(String str) {
            return (MobileSubtype) Enum.valueOf(MobileSubtype.class, str);
        }

        public static MobileSubtype[] values() {
            return (MobileSubtype[]) $VALUES.clone();
        }

        static {
            SparseArray<MobileSubtype> sparseArray = new SparseArray<>();
            valueMap = sparseArray;
            sparseArray.put(0, new MobileSubtype(0));
            sparseArray.put(1, new MobileSubtype(1));
            sparseArray.put(2, new MobileSubtype(2));
            sparseArray.put(3, new MobileSubtype(3));
            sparseArray.put(4, new MobileSubtype(4));
            sparseArray.put(5, new MobileSubtype(5));
            sparseArray.put(6, new MobileSubtype(6));
            sparseArray.put(7, new MobileSubtype(7));
            sparseArray.put(8, new MobileSubtype(8));
            sparseArray.put(9, new MobileSubtype(9));
            sparseArray.put(10, new MobileSubtype(10));
            sparseArray.put(11, new MobileSubtype(11));
            sparseArray.put(12, new MobileSubtype(12));
            sparseArray.put(13, new MobileSubtype(13));
            sparseArray.put(14, new MobileSubtype(14));
            sparseArray.put(15, new MobileSubtype(15));
            sparseArray.put(16, new MobileSubtype(16));
            sparseArray.put(17, new MobileSubtype(17));
            sparseArray.put(18, new MobileSubtype(18));
            sparseArray.put(19, new MobileSubtype(19));
        }

        private MobileSubtype(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static MobileSubtype forNumber(int i) {
            return valueMap.get(i);
        }
    }

    public static Builder builder() {
        return new AutoValue_NetworkConnectionInfo.Builder();
    }
}
