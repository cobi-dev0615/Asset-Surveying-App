package org.apache.cordova.file;

import android.content.res.AssetManager;
import android.net.Uri;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.LOG;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AssetFilesystem extends Filesystem {
    private static final String LOG_TAG = "AssetFilesystem";
    private static Map<String, Long> lengthCache;
    private static Map<String, String[]> listCache;
    private static boolean listCacheFromFile;
    private static Object listCacheLock = new Object();
    private final AssetManager assetManager;

    @Override // org.apache.cordova.file.Filesystem
    LocalFilesystemURL URLforFilesystemPath(String path) {
        return null;
    }

    @Override // org.apache.cordova.file.Filesystem
    public boolean canRemoveFileAtLocalURL(LocalFilesystemURL inputURL) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0068 A[Catch: all -> 0x008b, TRY_LEAVE, TryCatch #7 {, blocks: (B:4:0x0003, B:12:0x0028, B:14:0x0064, B:16:0x0068, B:20:0x002d, B:21:0x0033, B:26:0x0043, B:29:0x0048, B:34:0x0058, B:37:0x005d, B:44:0x007a, B:41:0x0088, B:47:0x007f, B:53:0x0089), top: B:3:0x0003, inners: #0, #8, #9, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void lazyInitCaches() {
        /*
            r6 = this;
            java.lang.Object r0 = org.apache.cordova.file.AssetFilesystem.listCacheLock
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.String[]> r1 = org.apache.cordova.file.AssetFilesystem.listCache     // Catch: java.lang.Throwable -> L8b
            if (r1 != 0) goto L89
            r1 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L40 java.lang.ClassNotFoundException -> L4f
            android.content.res.AssetManager r3 = r6.assetManager     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L40 java.lang.ClassNotFoundException -> L4f
            java.lang.String r4 = "cdvasset.manifest"
            java.io.InputStream r3 = r3.open(r4)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L40 java.lang.ClassNotFoundException -> L4f
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L40 java.lang.ClassNotFoundException -> L4f
            java.lang.Object r1 = r2.readObject()     // Catch: java.io.IOException -> L37 java.lang.ClassNotFoundException -> L39 java.lang.Throwable -> L77
            java.util.Map r1 = (java.util.Map) r1     // Catch: java.io.IOException -> L37 java.lang.ClassNotFoundException -> L39 java.lang.Throwable -> L77
            org.apache.cordova.file.AssetFilesystem.listCache = r1     // Catch: java.io.IOException -> L37 java.lang.ClassNotFoundException -> L39 java.lang.Throwable -> L77
            java.lang.Object r1 = r2.readObject()     // Catch: java.io.IOException -> L37 java.lang.ClassNotFoundException -> L39 java.lang.Throwable -> L77
            java.util.Map r1 = (java.util.Map) r1     // Catch: java.io.IOException -> L37 java.lang.ClassNotFoundException -> L39 java.lang.Throwable -> L77
            org.apache.cordova.file.AssetFilesystem.lengthCache = r1     // Catch: java.io.IOException -> L37 java.lang.ClassNotFoundException -> L39 java.lang.Throwable -> L77
            r1 = 1
            org.apache.cordova.file.AssetFilesystem.listCacheFromFile = r1     // Catch: java.io.IOException -> L37 java.lang.ClassNotFoundException -> L39 java.lang.Throwable -> L77
            r2.close()     // Catch: java.io.IOException -> L2c java.lang.Throwable -> L8b
            goto L64
        L2c:
            r1 = move-exception
            java.lang.String r2 = "AssetFilesystem"
            java.lang.String r1 = r1.getLocalizedMessage()     // Catch: java.lang.Throwable -> L8b
        L33:
            org.apache.cordova.LOG.d(r2, r1)     // Catch: java.lang.Throwable -> L8b
            goto L64
        L37:
            r1 = r2
            goto L41
        L39:
            r1 = move-exception
            goto L53
        L3b:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L78
        L40:
        L41:
            if (r1 == 0) goto L64
            r1.close()     // Catch: java.io.IOException -> L47 java.lang.Throwable -> L8b
            goto L64
        L47:
            r1 = move-exception
            java.lang.String r2 = "AssetFilesystem"
            java.lang.String r1 = r1.getLocalizedMessage()     // Catch: java.lang.Throwable -> L8b
            goto L33
        L4f:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L53:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L77
            if (r2 == 0) goto L64
            r2.close()     // Catch: java.io.IOException -> L5c java.lang.Throwable -> L8b
            goto L64
        L5c:
            r1 = move-exception
            java.lang.String r2 = "AssetFilesystem"
            java.lang.String r1 = r1.getLocalizedMessage()     // Catch: java.lang.Throwable -> L8b
            goto L33
        L64:
            java.util.Map<java.lang.String, java.lang.String[]> r1 = org.apache.cordova.file.AssetFilesystem.listCache     // Catch: java.lang.Throwable -> L8b
            if (r1 != 0) goto L89
            java.lang.String r1 = "AssetFilesystem"
            java.lang.String r2 = "Asset manifest not found. Recursive copies and directory listing will be slow."
            org.apache.cordova.LOG.w(r1, r2)     // Catch: java.lang.Throwable -> L8b
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L8b
            r1.<init>()     // Catch: java.lang.Throwable -> L8b
            org.apache.cordova.file.AssetFilesystem.listCache = r1     // Catch: java.lang.Throwable -> L8b
            goto L89
        L77:
            r1 = move-exception
        L78:
            if (r2 == 0) goto L88
            r2.close()     // Catch: java.io.IOException -> L7e java.lang.Throwable -> L8b
            goto L88
        L7e:
            r2 = move-exception
            java.lang.String r3 = "AssetFilesystem"
            java.lang.String r2 = r2.getLocalizedMessage()     // Catch: java.lang.Throwable -> L8b
            org.apache.cordova.LOG.d(r3, r2)     // Catch: java.lang.Throwable -> L8b
        L88:
            throw r1     // Catch: java.lang.Throwable -> L8b
        L89:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8b
            return
        L8b:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8b
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.cordova.file.AssetFilesystem.lazyInitCaches():void");
    }

    private String[] listAssets(String assetPath) throws IOException {
        if (assetPath.startsWith("/")) {
            assetPath = assetPath.substring(1);
        }
        if (assetPath.endsWith("/")) {
            assetPath = assetPath.substring(0, assetPath.length() - 1);
        }
        lazyInitCaches();
        String[] strArr = listCache.get(assetPath);
        if (strArr != null) {
            return strArr;
        }
        if (listCacheFromFile) {
            return new String[0];
        }
        String[] list = this.assetManager.list(assetPath);
        listCache.put(assetPath, list);
        return list;
    }

    private long getAssetSize(String assetPath) throws FileNotFoundException {
        if (assetPath.startsWith("/")) {
            assetPath = assetPath.substring(1);
        }
        lazyInitCaches();
        Map<String, Long> map = lengthCache;
        if (map != null) {
            Long l = map.get(assetPath);
            if (l == null) {
                throw new FileNotFoundException("Asset not found: " + assetPath);
            }
            return l.longValue();
        }
        CordovaResourceApi.OpenForReadResult openForReadResult = null;
        try {
            try {
                openForReadResult = this.resourceApi.openForRead(nativeUriForFullPath(assetPath));
                long j = openForReadResult.length;
                if (j < 0) {
                    j = openForReadResult.inputStream.available();
                }
                return j;
            } catch (IOException e) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("File not found: " + assetPath);
                fileNotFoundException.initCause(e);
                throw fileNotFoundException;
            }
        } finally {
            if (openForReadResult != null) {
                try {
                    openForReadResult.inputStream.close();
                } catch (IOException e2) {
                    LOG.d(LOG_TAG, e2.getLocalizedMessage());
                }
            }
        }
    }

    public AssetFilesystem(AssetManager assetManager, CordovaResourceApi resourceApi, CordovaPreferences preferences) {
        super(Uri.parse("file:///android_asset/"), "assets", resourceApi, preferences);
        this.assetManager = assetManager;
    }

    @Override // org.apache.cordova.file.Filesystem
    public Uri toNativeUri(LocalFilesystemURL inputURL) {
        return nativeUriForFullPath(inputURL.path);
    }

    @Override // org.apache.cordova.file.Filesystem
    public LocalFilesystemURL toLocalUri(Uri inputURL) {
        if (!"file".equals(inputURL.getScheme())) {
            return null;
        }
        Uri fromFile = Uri.fromFile(new File(inputURL.getPath()));
        String encodedPath = this.rootUri.getEncodedPath();
        String substring = encodedPath.substring(0, encodedPath.length() - 1);
        if (!fromFile.getEncodedPath().startsWith(substring)) {
            return null;
        }
        String substring2 = fromFile.getEncodedPath().substring(substring.length());
        if (!substring2.isEmpty()) {
            substring2 = substring2.substring(1);
        }
        Uri.Builder createLocalUriBuilder = createLocalUriBuilder();
        if (!substring2.isEmpty()) {
            createLocalUriBuilder.appendEncodedPath(substring2);
        }
        if (isDirectory(substring2) || inputURL.getPath().endsWith("/")) {
            createLocalUriBuilder.appendEncodedPath("");
        }
        return LocalFilesystemURL.parse(createLocalUriBuilder.build());
    }

    private boolean isDirectory(String assetPath) {
        try {
            return listAssets(assetPath).length != 0;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // org.apache.cordova.file.Filesystem
    public LocalFilesystemURL[] listChildren(LocalFilesystemURL inputURL) throws FileNotFoundException {
        String substring = inputURL.path.substring(1);
        if (substring.endsWith("/")) {
            substring = substring.substring(0, substring.length() - 1);
        }
        try {
            String[] listAssets = listAssets(substring);
            LocalFilesystemURL[] localFilesystemURLArr = new LocalFilesystemURL[listAssets.length];
            for (int i = 0; i < listAssets.length; i++) {
                localFilesystemURLArr[i] = localUrlforFullPath(new File(inputURL.path, listAssets[i]).getPath());
            }
            return localFilesystemURLArr;
        } catch (IOException e) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException();
            fileNotFoundException.initCause(e);
            throw fileNotFoundException;
        }
    }

    @Override // org.apache.cordova.file.Filesystem
    public JSONObject getFileForLocalURL(LocalFilesystemURL inputURL, String path, JSONObject options, boolean directory) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
        LocalFilesystemURL localUrlforFullPath;
        if (options != null && options.optBoolean("create")) {
            throw new UnsupportedOperationException("Assets are read-only");
        }
        if (directory && !path.endsWith("/")) {
            path = path + "/";
        }
        if (path.startsWith("/")) {
            localUrlforFullPath = localUrlforFullPath(normalizePath(path));
        } else {
            localUrlforFullPath = localUrlforFullPath(normalizePath(inputURL.path + "/" + path));
        }
        getFileMetadataForLocalURL(localUrlforFullPath);
        boolean isDirectory = isDirectory(localUrlforFullPath.path);
        if (directory && !isDirectory) {
            throw new TypeMismatchException("path doesn't exist or is file");
        }
        if (!directory && isDirectory) {
            throw new TypeMismatchException("path doesn't exist or is directory");
        }
        return makeEntryForURL(localUrlforFullPath);
    }

    @Override // org.apache.cordova.file.Filesystem
    public JSONObject getFileMetadataForLocalURL(LocalFilesystemURL inputURL) throws FileNotFoundException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("size", inputURL.isDirectory ? 0L : getAssetSize(inputURL.path));
            jSONObject.put("type", inputURL.isDirectory ? "text/directory" : this.resourceApi.getMimeType(toNativeUri(inputURL)));
            jSONObject.put("name", new File(inputURL.path).getName());
            jSONObject.put("fullPath", inputURL.path);
            jSONObject.put("lastModifiedDate", 0);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // org.apache.cordova.file.Filesystem
    long writeToFileAtURL(LocalFilesystemURL inputURL, String data, int offset, boolean isBinary) throws NoModificationAllowedException, IOException {
        throw new NoModificationAllowedException("Assets are read-only");
    }

    @Override // org.apache.cordova.file.Filesystem
    long truncateFileAtURL(LocalFilesystemURL inputURL, long size) throws IOException, NoModificationAllowedException {
        throw new NoModificationAllowedException("Assets are read-only");
    }

    @Override // org.apache.cordova.file.Filesystem
    String filesystemPathForURL(LocalFilesystemURL url) {
        return new File(this.rootUri.getPath(), url.path).toString();
    }

    @Override // org.apache.cordova.file.Filesystem
    boolean removeFileAtLocalURL(LocalFilesystemURL inputURL) throws InvalidModificationException, NoModificationAllowedException {
        throw new NoModificationAllowedException("Assets are read-only");
    }

    @Override // org.apache.cordova.file.Filesystem
    boolean recursiveRemoveFileAtLocalURL(LocalFilesystemURL inputURL) throws NoModificationAllowedException {
        throw new NoModificationAllowedException("Assets are read-only");
    }
}
