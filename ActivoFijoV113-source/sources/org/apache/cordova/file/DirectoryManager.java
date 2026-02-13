package org.apache.cordova.file;

import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import barcodescanner.xservices.nl.barcodescanner.BuildConfig;
import java.io.File;

/* loaded from: classes.dex */
public class DirectoryManager {
    private static final String LOG_TAG = "DirectoryManager";

    public static boolean testFileExists(String name) {
        if (!testSaveLocationExists() || name.equals(BuildConfig.FLAVOR)) {
            return false;
        }
        return constructFilePaths(Environment.getExternalStorageDirectory().toString(), name).exists();
    }

    public static long getFreeExternalStorageSpace() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return getFreeSpaceInBytes(Environment.getExternalStorageDirectory().getPath()) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return -1L;
    }

    public static long getFreeSpaceInBytes(String path) {
        try {
            StatFs statFs = new StatFs(path);
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (IllegalArgumentException unused) {
            return 0L;
        }
    }

    public static boolean testSaveLocationExists() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    private static File constructFilePaths(String file1, String file2) {
        if (file2.startsWith(file1)) {
            return new File(file2);
        }
        return new File(file1 + "/" + file2);
    }
}
