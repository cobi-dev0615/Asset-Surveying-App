package com.devexpress.dxcharts;

/* loaded from: classes.dex */
final class LicenseManager {
    static native int nativeSetLicenseKey(String str);

    static {
        System.loadLibrary("DXChartsNative");
    }

    private LicenseManager() {
    }

    public static LicenseState setLicenseKey(String str) {
        return LicenseState.values()[nativeSetLicenseKey(str)];
    }
}
