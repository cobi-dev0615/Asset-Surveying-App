package mono.android.app;

import crc64386635862eb82281.MainApplication;
import crc6488302ad6e9e4df1a.MauiApplication;
import mono.android.Runtime;

/* loaded from: classes3.dex */
public class ApplicationRegistration {
    public static void registerApplications() {
        Runtime.register("Microsoft.Maui.MauiApplication, Microsoft.Maui, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", MauiApplication.class, MauiApplication.__md_methods);
        Runtime.register("AuditoriaActivoFijo.MainApplication, AuditoriaActivoFijo, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", MainApplication.class, MainApplication.__md_methods);
    }
}
