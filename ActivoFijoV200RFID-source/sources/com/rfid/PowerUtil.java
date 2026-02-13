package com.rfid;

import android.util.Log;
import java.io.FileWriter;

/* loaded from: classes3.dex */
public class PowerUtil {
    private static String s1 = "/proc/gpiocontrol/set_id";
    private static String s2 = "/proc/gpiocontrol/set_uhf";

    public static void power(String str) {
        try {
            FileWriter fileWriter = new FileWriter(s2);
            fileWriter.write(str);
            fileWriter.close();
            Log.e("PowerUtil", "power=" + str + " Path=" + s2);
            Thread.sleep(1500L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
