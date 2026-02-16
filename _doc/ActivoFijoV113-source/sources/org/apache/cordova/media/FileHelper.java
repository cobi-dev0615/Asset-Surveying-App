package org.apache.cordova.media;

import android.net.Uri;

/* loaded from: classes.dex */
public class FileHelper {
    public static String stripFileProtocol(String uriString) {
        return uriString.startsWith("file://") ? Uri.parse(uriString).getPath() : uriString;
    }
}
