package org.apache.cordova.camera;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import barcodescanner.xservices.nl.barcodescanner.BuildConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import org.apache.cordova.CordovaInterface;

/* loaded from: classes.dex */
public class FileHelper {
    private static final String LOG_TAG = "FileUtils";
    private static final String _DATA = "_data";

    public static String getRealPath(Uri uri, CordovaInterface cordova) {
        return getRealPathFromURI(cordova.getActivity(), uri);
    }

    public static String getRealPath(String uriString, CordovaInterface cordova) {
        return getRealPath(Uri.parse(uriString), cordova);
    }

    public static String getRealPathFromURI(final Context context, final Uri uri) {
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else {
                if (isDownloadsDocument(uri)) {
                    String documentId = DocumentsContract.getDocumentId(uri);
                    if (documentId != null && documentId.length() > 0) {
                        if (documentId.startsWith("raw:")) {
                            return documentId.replaceFirst("raw:", BuildConfig.FLAVOR);
                        }
                        try {
                            return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                }
                if (isMediaDocument(uri)) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = split2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
                }
                if (isFileProviderUri(context, uri)) {
                    return getFileProviderPath(context, uri);
                }
                return getDataColumn(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public static InputStream getInputStreamFromUriString(String uriString, CordovaInterface cordova) throws IOException {
        InputStream inputStream;
        if (uriString.startsWith("content")) {
            return cordova.getActivity().getContentResolver().openInputStream(Uri.parse(uriString));
        }
        if (uriString.startsWith("file://")) {
            int indexOf = uriString.indexOf("?");
            if (indexOf > -1) {
                uriString = uriString.substring(0, indexOf);
            }
            if (uriString.startsWith("file:///android_asset/")) {
                return cordova.getActivity().getAssets().open(Uri.parse(uriString).getPath().substring(15));
            }
            try {
                inputStream = cordova.getActivity().getContentResolver().openInputStream(Uri.parse(uriString));
            } catch (Exception unused) {
                inputStream = null;
            }
            if (inputStream == null) {
                inputStream = new FileInputStream(getRealPath(uriString, cordova));
            }
            return inputStream;
        }
        return new FileInputStream(uriString);
    }

    public static String stripFileProtocol(String uriString) {
        return uriString.startsWith("file://") ? uriString.substring(7) : uriString;
    }

    public static String getMimeTypeForExtension(String path) {
        int lastIndexOf = path.lastIndexOf(46);
        if (lastIndexOf != -1) {
            path = path.substring(lastIndexOf + 1);
        }
        String lowerCase = path.toLowerCase(Locale.getDefault());
        return lowerCase.equals("3ga") ? "audio/3gpp" : MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
    }

    public static String getMimeType(String uriString, CordovaInterface cordova) {
        Uri parse = Uri.parse(uriString);
        if (uriString.startsWith("content://")) {
            return cordova.getActivity().getContentResolver().getType(parse);
        }
        return getMimeTypeForExtension(parse.getPath());
    }

    public static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{_DATA}, selection, selectionArgs, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow(_DATA));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return string;
                    }
                } catch (Exception unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Exception unused2) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isFileProviderUri(final Context context, final Uri uri) {
        return (context.getPackageName() + ".provider").equals(uri.getAuthority());
    }

    public static String getFileProviderPath(final Context context, final Uri uri) {
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), uri.getLastPathSegment());
        if (file.exists()) {
            return file.toString();
        }
        return null;
    }
}
