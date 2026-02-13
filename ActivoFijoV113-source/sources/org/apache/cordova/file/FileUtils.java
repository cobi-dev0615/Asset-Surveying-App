package org.apache.cordova.file;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.util.Base64;
import androidx.appcompat.app.AppCompatActivity;
import barcodescanner.xservices.nl.barcodescanner.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PermissionHelper;
import org.apache.cordova.PluginResult;
import org.apache.cordova.file.Filesystem;
import org.apache.cordova.file.PendingRequests;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class FileUtils extends CordovaPlugin {
    public static int ABORT_ERR = 3;
    public static final int ACTION_GET_DIRECTORY = 2;
    public static final int ACTION_GET_FILE = 0;
    public static final int ACTION_WRITE = 1;
    public static int ENCODING_ERR = 5;
    public static int INVALID_MODIFICATION_ERR = 9;
    public static int INVALID_STATE_ERR = 7;
    private static final String LOG_TAG = "FileUtils";
    public static int NOT_FOUND_ERR = 1;
    public static int NOT_READABLE_ERR = 4;
    public static int NO_MODIFICATION_ALLOWED_ERR = 6;
    public static int PATH_EXISTS_ERR = 12;
    public static int QUOTA_EXCEEDED_ERR = 10;
    public static final int READ = 4;
    public static int SECURITY_ERR = 2;
    public static int SYNTAX_ERR = 8;
    public static int TYPE_MISMATCH_ERR = 11;
    public static int UNKNOWN_ERR = 1000;
    public static final int WRITE = 3;
    private static FileUtils filePlugin;
    private ArrayList<Filesystem> filesystems;
    private PendingRequests pendingRequests;
    private boolean configured = false;
    private String[] permissions = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    private interface FileOp {
        void run(JSONArray args) throws Exception;
    }

    public void registerFilesystem(Filesystem fs) {
        if (fs == null || filesystemForName(fs.name) != null) {
            return;
        }
        this.filesystems.add(fs);
    }

    private Filesystem filesystemForName(String name) {
        Iterator<Filesystem> it = this.filesystems.iterator();
        while (it.hasNext()) {
            Filesystem next = it.next();
            if (next != null && next.name != null && next.name.equals(name)) {
                return next;
            }
        }
        return null;
    }

    protected String[] getExtraFileSystemsPreference(Activity activity) {
        return this.preferences.getString("androidextrafilesystems", "files,files-external,documents,sdcard,cache,cache-external,assets,root").split(",");
    }

    protected void registerExtraFileSystems(String[] filesystems, HashMap<String, String> availableFileSystems) {
        HashSet hashSet = new HashSet();
        for (String str : filesystems) {
            if (!hashSet.contains(str)) {
                String str2 = availableFileSystems.get(str);
                if (str2 != null) {
                    File file = new File(str2);
                    if (file.mkdirs() || file.isDirectory()) {
                        registerFilesystem(new LocalFilesystem(str, this.webView.getContext(), this.webView.getResourceApi(), file));
                        hashSet.add(str);
                    } else {
                        LOG.d(LOG_TAG, "Unable to create root dir for filesystem \"" + str + "\", skipping");
                    }
                } else {
                    LOG.d(LOG_TAG, "Unrecognized extra filesystem identifier: " + str);
                }
            }
        }
    }

    protected HashMap<String, String> getAvailableFileSystems(Activity activity) {
        Context applicationContext = activity.getApplicationContext();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("files", applicationContext.getFilesDir().getAbsolutePath());
        hashMap.put("documents", new File(applicationContext.getFilesDir(), "Documents").getAbsolutePath());
        hashMap.put("cache", applicationContext.getCacheDir().getAbsolutePath());
        hashMap.put("root", "/");
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                hashMap.put("files-external", applicationContext.getExternalFilesDir(null).getAbsolutePath());
                hashMap.put("sdcard", Environment.getExternalStorageDirectory().getAbsolutePath());
                hashMap.put("cache-external", applicationContext.getExternalCacheDir().getAbsolutePath());
            } catch (NullPointerException unused) {
                LOG.d(LOG_TAG, "External storage unavailable, check to see if USB Mass Storage Mode is on");
            }
        }
        return hashMap;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        String str;
        super.initialize(cordova, webView);
        this.filesystems = new ArrayList<>();
        this.pendingRequests = new PendingRequests();
        AppCompatActivity activity = cordova.getActivity();
        String packageName = activity.getPackageName();
        String string = this.preferences.getString("androidpersistentfilelocation", "internal");
        String absolutePath = activity.getCacheDir().getAbsolutePath();
        if ("internal".equalsIgnoreCase(string)) {
            str = activity.getFilesDir().getAbsolutePath() + "/files/";
            this.configured = true;
        } else if ("compatibility".equalsIgnoreCase(string)) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                String absolutePath2 = Environment.getExternalStorageDirectory().getAbsolutePath();
                absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + packageName + "/cache/";
                str = absolutePath2;
            } else {
                str = "/data/data/" + packageName;
            }
            this.configured = true;
        } else {
            str = null;
        }
        if (this.configured) {
            File file = new File(absolutePath);
            File file2 = new File(str);
            file.mkdirs();
            file2.mkdirs();
            registerFilesystem(new LocalFilesystem("temporary", webView.getContext(), webView.getResourceApi(), file));
            registerFilesystem(new LocalFilesystem("persistent", webView.getContext(), webView.getResourceApi(), file2));
            registerFilesystem(new ContentFilesystem(webView.getContext(), webView.getResourceApi()));
            registerFilesystem(new AssetFilesystem(webView.getContext().getAssets(), webView.getResourceApi()));
            registerExtraFileSystems(getExtraFileSystemsPreference(activity), getAvailableFileSystems(activity));
            if (filePlugin == null) {
                filePlugin = this;
                return;
            }
            return;
        }
        LOG.e(LOG_TAG, "File plugin configuration error: Please set AndroidPersistentFileLocation in config.xml to one of \"internal\" (for new applications) or \"compatibility\" (for compatibility with previous versions)");
        activity.finish();
    }

    public static FileUtils getFilePlugin() {
        return filePlugin;
    }

    private Filesystem filesystemForURL(LocalFilesystemURL localURL) {
        if (localURL == null) {
            return null;
        }
        return filesystemForName(localURL.fsName);
    }

    @Override // org.apache.cordova.CordovaPlugin
    public Uri remapUri(Uri uri) {
        if (!LocalFilesystemURL.FILESYSTEM_PROTOCOL.equals(uri.getScheme())) {
            return null;
        }
        try {
            LocalFilesystemURL parse = LocalFilesystemURL.parse(uri);
            Filesystem filesystemForURL = filesystemForURL(parse);
            if (filesystemForURL != null && filesystemForURL.filesystemPathForURL(parse) != null) {
                return Uri.parse("file://" + filesystemForURL.filesystemPathForURL(parse));
            }
        } catch (IllegalArgumentException unused) {
        }
        return null;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String action, final String rawArgs, final CallbackContext callbackContext) {
        if (!this.configured) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, "File plugin is not configured. Please see the README.md file for details on how to update config.xml"));
            return true;
        }
        if (action.equals("testSaveLocationExists")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.1
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) {
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, DirectoryManager.testSaveLocationExists()));
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("getFreeDiskSpace")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.2
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) {
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, DirectoryManager.getFreeExternalStorageSpace()));
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("testFileExists")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.3
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws JSONException {
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, DirectoryManager.testFileExists(args.getString(0))));
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("testDirectoryExists")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.4
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws JSONException {
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, DirectoryManager.testFileExists(args.getString(0))));
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("readAsText")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.5
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws JSONException, MalformedURLException {
                    String string = args.getString(1);
                    int i = args.getInt(2);
                    int i2 = args.getInt(3);
                    FileUtils.this.readFileAs(args.getString(0), i, i2, callbackContext, string, 1);
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("readAsDataURL")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.6
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws JSONException, MalformedURLException {
                    int i = args.getInt(1);
                    int i2 = args.getInt(2);
                    FileUtils.this.readFileAs(args.getString(0), i, i2, callbackContext, null, -1);
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("readAsArrayBuffer")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.7
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws JSONException, MalformedURLException {
                    int i = args.getInt(1);
                    int i2 = args.getInt(2);
                    FileUtils.this.readFileAs(args.getString(0), i, i2, callbackContext, null, 6);
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("readAsBinaryString")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.8
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws JSONException, MalformedURLException {
                    int i = args.getInt(1);
                    int i2 = args.getInt(2);
                    FileUtils.this.readFileAs(args.getString(0), i, i2, callbackContext, null, 7);
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("write")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.9
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws JSONException, FileNotFoundException, IOException, NoModificationAllowedException {
                    String string = FileUtils.this.resolveLocalFileSystemURI(args.getString(0)).getString("nativeURL");
                    String string2 = args.getString(1);
                    int i = args.getInt(2);
                    Boolean valueOf = Boolean.valueOf(args.getBoolean(3));
                    if (FileUtils.this.needPermission(string, 3)) {
                        FileUtils.this.getWritePermission(rawArgs, 1, callbackContext);
                    } else {
                        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, FileUtils.this.write(r0, string2, i, valueOf.booleanValue())));
                    }
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("truncate")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.10
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws JSONException, FileNotFoundException, IOException, NoModificationAllowedException {
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, FileUtils.this.truncateFile(args.getString(0), args.getInt(1))));
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("requestAllFileSystems")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.11
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws IOException, JSONException {
                    callbackContext.success(FileUtils.this.requestAllFileSystems());
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("requestAllPaths")) {
            this.cordova.getThreadPool().execute(new Runnable() { // from class: org.apache.cordova.file.FileUtils.12
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        callbackContext.success(FileUtils.this.requestAllPaths());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        } else if (action.equals("requestFileSystem")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.13
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws JSONException {
                    FileUtils.this.requestFileSystem(args.getInt(0), args.optLong(1), callbackContext);
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("resolveLocalFileSystemURI")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.14
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws IOException, JSONException {
                    callbackContext.success(FileUtils.this.resolveLocalFileSystemURI(args.getString(0)));
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("getFileMetadata")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.15
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws FileNotFoundException, JSONException, MalformedURLException {
                    callbackContext.success(FileUtils.this.getFileMetadata(args.getString(0)));
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("getParent")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.16
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws JSONException, IOException {
                    callbackContext.success(FileUtils.this.getParent(args.getString(0)));
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("getDirectory")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.17
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
                    String string = args.getString(0);
                    String string2 = args.getString(1);
                    String string3 = FileUtils.this.resolveLocalFileSystemURI(string).getString("nativeURL");
                    boolean optBoolean = args.isNull(2) ? false : args.getJSONObject(2).optBoolean("create", false);
                    if (!optBoolean || !FileUtils.this.needPermission(string3, 3)) {
                        if (!optBoolean && FileUtils.this.needPermission(string3, 4)) {
                            FileUtils.this.getReadPermission(rawArgs, 2, callbackContext);
                            return;
                        } else {
                            callbackContext.success(FileUtils.this.getFile(string, string2, args.optJSONObject(2), true));
                            return;
                        }
                    }
                    FileUtils.this.getWritePermission(rawArgs, 2, callbackContext);
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("getFile")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.18
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
                    String string = args.getString(0);
                    String string2 = args.getString(1);
                    String string3 = FileUtils.this.resolveLocalFileSystemURI(string).getString("nativeURL");
                    boolean optBoolean = args.isNull(2) ? false : args.getJSONObject(2).optBoolean("create", false);
                    if (!optBoolean || !FileUtils.this.needPermission(string3, 3)) {
                        if (!optBoolean && FileUtils.this.needPermission(string3, 4)) {
                            FileUtils.this.getReadPermission(rawArgs, 0, callbackContext);
                            return;
                        } else {
                            callbackContext.success(FileUtils.this.getFile(string, string2, args.optJSONObject(2), false));
                            return;
                        }
                    }
                    FileUtils.this.getWritePermission(rawArgs, 0, callbackContext);
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("remove")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.19
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws JSONException, NoModificationAllowedException, InvalidModificationException, MalformedURLException {
                    if (FileUtils.this.remove(args.getString(0))) {
                        callbackContext.success();
                    } else {
                        callbackContext.error(FileUtils.NO_MODIFICATION_ALLOWED_ERR);
                    }
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("removeRecursively")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.20
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws JSONException, FileExistsException, MalformedURLException, NoModificationAllowedException {
                    if (FileUtils.this.removeRecursively(args.getString(0))) {
                        callbackContext.success();
                    } else {
                        callbackContext.error(FileUtils.NO_MODIFICATION_ALLOWED_ERR);
                    }
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("moveTo")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.21
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws JSONException, NoModificationAllowedException, IOException, InvalidModificationException, EncodingException, FileExistsException {
                    callbackContext.success(FileUtils.this.transferTo(args.getString(0), args.getString(1), args.getString(2), true));
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("copyTo")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.22
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws JSONException, NoModificationAllowedException, IOException, InvalidModificationException, EncodingException, FileExistsException {
                    callbackContext.success(FileUtils.this.transferTo(args.getString(0), args.getString(1), args.getString(2), false));
                }
            }, rawArgs, callbackContext);
        } else if (action.equals("readEntries")) {
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.23
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws FileNotFoundException, JSONException, MalformedURLException {
                    callbackContext.success(FileUtils.this.readEntries(args.getString(0)));
                }
            }, rawArgs, callbackContext);
        } else {
            if (!action.equals("_getLocalFilesystemPath")) {
                return false;
            }
            threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.24
                @Override // org.apache.cordova.file.FileUtils.FileOp
                public void run(JSONArray args) throws FileNotFoundException, JSONException, MalformedURLException {
                    callbackContext.success(FileUtils.this.filesystemPathForURL(args.getString(0)));
                }
            }, rawArgs, callbackContext);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getReadPermission(String rawArgs, int action, CallbackContext callbackContext) {
        PermissionHelper.requestPermission(this, this.pendingRequests.createRequest(rawArgs, action, callbackContext), "android.permission.READ_EXTERNAL_STORAGE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getWritePermission(String rawArgs, int action, CallbackContext callbackContext) {
        PermissionHelper.requestPermission(this, this.pendingRequests.createRequest(rawArgs, action, callbackContext), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    private boolean hasReadPermission() {
        return PermissionHelper.hasPermission(this, "android.permission.READ_EXTERNAL_STORAGE");
    }

    private boolean hasWritePermission() {
        return PermissionHelper.hasPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needPermission(String nativeURL, int permissionType) throws JSONException {
        JSONObject requestAllPaths = requestAllPaths();
        ArrayList arrayList = new ArrayList();
        arrayList.add(requestAllPaths.getString("applicationDirectory"));
        arrayList.add(requestAllPaths.getString("applicationStorageDirectory"));
        if (requestAllPaths.has("externalApplicationStorageDirectory")) {
            arrayList.add(requestAllPaths.getString("externalApplicationStorageDirectory"));
        }
        if (permissionType == 4 && hasReadPermission()) {
            return false;
        }
        if (permissionType == 3 && hasWritePermission()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (nativeURL.startsWith((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    public LocalFilesystemURL resolveNativeUri(Uri nativeUri) {
        Iterator<Filesystem> it = this.filesystems.iterator();
        LocalFilesystemURL localFilesystemURL = null;
        while (it.hasNext()) {
            LocalFilesystemURL localUri = it.next().toLocalUri(nativeUri);
            if (localUri != null && (localFilesystemURL == null || localUri.uri.toString().length() < localFilesystemURL.toString().length())) {
                localFilesystemURL = localUri;
            }
        }
        return localFilesystemURL;
    }

    public String filesystemPathForURL(String localURLstr) throws MalformedURLException {
        try {
            LocalFilesystemURL parse = LocalFilesystemURL.parse(localURLstr);
            Filesystem filesystemForURL = filesystemForURL(parse);
            if (filesystemForURL == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
            return filesystemForURL.filesystemPathForURL(parse);
        } catch (IllegalArgumentException e) {
            MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
            malformedURLException.initCause(e);
            throw malformedURLException;
        }
    }

    public LocalFilesystemURL filesystemURLforLocalPath(String localPath) {
        Iterator<Filesystem> it = this.filesystems.iterator();
        LocalFilesystemURL localFilesystemURL = null;
        int i = 0;
        while (it.hasNext()) {
            LocalFilesystemURL URLforFilesystemPath = it.next().URLforFilesystemPath(localPath);
            if (URLforFilesystemPath != null && (localFilesystemURL == null || URLforFilesystemPath.path.length() < i)) {
                i = URLforFilesystemPath.path.length();
                localFilesystemURL = URLforFilesystemPath;
            }
        }
        return localFilesystemURL;
    }

    private void threadhelper(final FileOp f, final String rawArgs, final CallbackContext callbackContext) {
        this.cordova.getThreadPool().execute(new Runnable() { // from class: org.apache.cordova.file.FileUtils.25
            @Override // java.lang.Runnable
            public void run() {
                try {
                    f.run(new JSONArray(rawArgs));
                } catch (Exception e) {
                    boolean z = e instanceof EncodingException;
                    if (z) {
                        callbackContext.error(FileUtils.ENCODING_ERR);
                        return;
                    }
                    if (e instanceof FileNotFoundException) {
                        callbackContext.error(FileUtils.NOT_FOUND_ERR);
                        return;
                    }
                    if (e instanceof FileExistsException) {
                        callbackContext.error(FileUtils.PATH_EXISTS_ERR);
                        return;
                    }
                    if (e instanceof NoModificationAllowedException) {
                        callbackContext.error(FileUtils.NO_MODIFICATION_ALLOWED_ERR);
                        return;
                    }
                    if (e instanceof InvalidModificationException) {
                        callbackContext.error(FileUtils.INVALID_MODIFICATION_ERR);
                        return;
                    }
                    if (e instanceof MalformedURLException) {
                        callbackContext.error(FileUtils.ENCODING_ERR);
                        return;
                    }
                    if (e instanceof IOException) {
                        callbackContext.error(FileUtils.INVALID_MODIFICATION_ERR);
                        return;
                    }
                    if (z) {
                        callbackContext.error(FileUtils.ENCODING_ERR);
                        return;
                    }
                    if (e instanceof TypeMismatchException) {
                        callbackContext.error(FileUtils.TYPE_MISMATCH_ERR);
                        return;
                    }
                    if (e instanceof JSONException) {
                        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
                    } else if (e instanceof SecurityException) {
                        callbackContext.error(FileUtils.SECURITY_ERR);
                    } else {
                        e.printStackTrace();
                        callbackContext.error(FileUtils.UNKNOWN_ERR);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject resolveLocalFileSystemURI(String uriString) throws IOException, JSONException {
        if (uriString == null) {
            throw new MalformedURLException("Unrecognized filesystem URL");
        }
        Uri parse = Uri.parse(uriString);
        boolean z = false;
        LocalFilesystemURL parse2 = LocalFilesystemURL.parse(parse);
        if (parse2 == null) {
            parse2 = resolveNativeUri(parse);
            z = true;
        }
        try {
            Filesystem filesystemForURL = filesystemForURL(parse2);
            if (filesystemForURL == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
            if (filesystemForURL.exists(parse2)) {
                if (!z) {
                    parse2 = filesystemForURL.toLocalUri(filesystemForURL.toNativeUri(parse2));
                }
                return filesystemForURL.getEntryForLocalURL(parse2);
            }
            throw new FileNotFoundException();
        } catch (IllegalArgumentException e) {
            MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
            malformedURLException.initCause(e);
            throw malformedURLException;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray readEntries(String baseURLstr) throws FileNotFoundException, JSONException, MalformedURLException {
        try {
            LocalFilesystemURL parse = LocalFilesystemURL.parse(baseURLstr);
            Filesystem filesystemForURL = filesystemForURL(parse);
            if (filesystemForURL == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
            return filesystemForURL.readEntriesAtLocalURL(parse);
        } catch (IllegalArgumentException e) {
            MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
            malformedURLException.initCause(e);
            throw malformedURLException;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject transferTo(String srcURLstr, String destURLstr, String newName, boolean move) throws JSONException, NoModificationAllowedException, IOException, InvalidModificationException, EncodingException, FileExistsException {
        if (srcURLstr == null || destURLstr == null) {
            throw new FileNotFoundException();
        }
        LocalFilesystemURL parse = LocalFilesystemURL.parse(srcURLstr);
        LocalFilesystemURL parse2 = LocalFilesystemURL.parse(destURLstr);
        Filesystem filesystemForURL = filesystemForURL(parse);
        Filesystem filesystemForURL2 = filesystemForURL(parse2);
        if (newName != null && newName.contains(":")) {
            throw new EncodingException("Bad file name");
        }
        return filesystemForURL2.copyFileToURL(parse2, newName, filesystemForURL, parse, move);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeRecursively(String baseURLstr) throws FileExistsException, NoModificationAllowedException, MalformedURLException {
        try {
            LocalFilesystemURL parse = LocalFilesystemURL.parse(baseURLstr);
            if (BuildConfig.FLAVOR.equals(parse.path) || "/".equals(parse.path)) {
                throw new NoModificationAllowedException("You can't delete the root directory");
            }
            Filesystem filesystemForURL = filesystemForURL(parse);
            if (filesystemForURL == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
            return filesystemForURL.recursiveRemoveFileAtLocalURL(parse);
        } catch (IllegalArgumentException e) {
            MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
            malformedURLException.initCause(e);
            throw malformedURLException;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean remove(String baseURLstr) throws NoModificationAllowedException, InvalidModificationException, MalformedURLException {
        try {
            LocalFilesystemURL parse = LocalFilesystemURL.parse(baseURLstr);
            if (BuildConfig.FLAVOR.equals(parse.path) || "/".equals(parse.path)) {
                throw new NoModificationAllowedException("You can't delete the root directory");
            }
            Filesystem filesystemForURL = filesystemForURL(parse);
            if (filesystemForURL == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
            return filesystemForURL.removeFileAtLocalURL(parse);
        } catch (IllegalArgumentException e) {
            MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
            malformedURLException.initCause(e);
            throw malformedURLException;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject getFile(String baseURLstr, String path, JSONObject options, boolean directory) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
        try {
            LocalFilesystemURL parse = LocalFilesystemURL.parse(baseURLstr);
            Filesystem filesystemForURL = filesystemForURL(parse);
            if (filesystemForURL == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
            return filesystemForURL.getFileForLocalURL(parse, path, options, directory);
        } catch (IllegalArgumentException e) {
            MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
            malformedURLException.initCause(e);
            throw malformedURLException;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject getParent(String baseURLstr) throws JSONException, IOException {
        try {
            LocalFilesystemURL parse = LocalFilesystemURL.parse(baseURLstr);
            Filesystem filesystemForURL = filesystemForURL(parse);
            if (filesystemForURL == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
            return filesystemForURL.getParentForLocalURL(parse);
        } catch (IllegalArgumentException e) {
            MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
            malformedURLException.initCause(e);
            throw malformedURLException;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject getFileMetadata(String baseURLstr) throws FileNotFoundException, JSONException, MalformedURLException {
        try {
            LocalFilesystemURL parse = LocalFilesystemURL.parse(baseURLstr);
            Filesystem filesystemForURL = filesystemForURL(parse);
            if (filesystemForURL == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
            return filesystemForURL.getFileMetadataForLocalURL(parse);
        } catch (IllegalArgumentException e) {
            MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
            malformedURLException.initCause(e);
            throw malformedURLException;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestFileSystem(int type, long requiredSize, final CallbackContext callbackContext) throws JSONException {
        Filesystem filesystem;
        try {
            filesystem = this.filesystems.get(type);
        } catch (ArrayIndexOutOfBoundsException unused) {
            filesystem = null;
        }
        if (filesystem == null) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, NOT_FOUND_ERR));
            return;
        }
        if ((requiredSize > 0 ? filesystem.getFreeSpaceInBytes() : 0L) < requiredSize) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, QUOTA_EXCEEDED_ERR));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", filesystem.name);
        jSONObject.put("root", filesystem.getRootEntry());
        callbackContext.success(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray requestAllFileSystems() throws IOException, JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<Filesystem> it = this.filesystems.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().getRootEntry());
        }
        return jSONArray;
    }

    private static String toDirUrl(File f) {
        return Uri.fromFile(f).toString() + '/';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject requestAllPaths() throws JSONException {
        AppCompatActivity activity = this.cordova.getActivity();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("applicationDirectory", "file:///android_asset/");
        jSONObject.put("applicationStorageDirectory", toDirUrl(activity.getFilesDir().getParentFile()));
        jSONObject.put("dataDirectory", toDirUrl(activity.getFilesDir()));
        jSONObject.put("cacheDirectory", toDirUrl(activity.getCacheDir()));
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                jSONObject.put("externalApplicationStorageDirectory", toDirUrl(activity.getExternalFilesDir(null).getParentFile()));
                jSONObject.put("externalDataDirectory", toDirUrl(activity.getExternalFilesDir(null)));
                jSONObject.put("externalCacheDirectory", toDirUrl(activity.getExternalCacheDir()));
                jSONObject.put("externalRootDirectory", toDirUrl(Environment.getExternalStorageDirectory()));
            } catch (NullPointerException unused) {
                LOG.d(LOG_TAG, "Unable to access these paths, most liklely due to USB storage");
            }
        }
        return jSONObject;
    }

    public JSONObject getEntryForFile(File file) throws JSONException {
        Iterator<Filesystem> it = this.filesystems.iterator();
        while (it.hasNext()) {
            JSONObject makeEntryForFile = it.next().makeEntryForFile(file);
            if (makeEntryForFile != null) {
                return makeEntryForFile;
            }
        }
        return null;
    }

    @Deprecated
    public static JSONObject getEntry(File file) throws JSONException {
        if (getFilePlugin() != null) {
            return getFilePlugin().getEntryForFile(file);
        }
        return null;
    }

    public void readFileAs(final String srcURLstr, final int start, final int end, final CallbackContext callbackContext, final String encoding, final int resultType) throws MalformedURLException {
        try {
            LocalFilesystemURL parse = LocalFilesystemURL.parse(srcURLstr);
            Filesystem filesystemForURL = filesystemForURL(parse);
            if (filesystemForURL == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
            filesystemForURL.readFileAtURL(parse, start, end, new Filesystem.ReadFileCallback() { // from class: org.apache.cordova.file.FileUtils.26
                @Override // org.apache.cordova.file.Filesystem.ReadFileCallback
                public void handleData(InputStream inputStream, String contentType) {
                    PluginResult pluginResult;
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = inputStream.read(bArr, 0, 8192);
                            if (read <= 0) {
                                break;
                            } else {
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                        }
                        int i = resultType;
                        if (i == 1) {
                            pluginResult = new PluginResult(PluginResult.Status.OK, byteArrayOutputStream.toString(encoding));
                        } else if (i == 6) {
                            pluginResult = new PluginResult(PluginResult.Status.OK, byteArrayOutputStream.toByteArray());
                        } else if (i == 7) {
                            pluginResult = new PluginResult(PluginResult.Status.OK, byteArrayOutputStream.toByteArray(), true);
                        } else {
                            pluginResult = new PluginResult(PluginResult.Status.OK, "data:" + contentType + ";base64," + new String(Base64.encode(byteArrayOutputStream.toByteArray(), 2), "US-ASCII"));
                        }
                        callbackContext.sendPluginResult(pluginResult);
                    } catch (IOException e) {
                        LOG.d(FileUtils.LOG_TAG, e.getLocalizedMessage());
                        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, FileUtils.NOT_READABLE_ERR));
                    }
                }
            });
        } catch (FileNotFoundException unused) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, NOT_FOUND_ERR));
        } catch (IOException e) {
            LOG.d(LOG_TAG, e.getLocalizedMessage());
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, NOT_READABLE_ERR));
        } catch (IllegalArgumentException e2) {
            MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
            malformedURLException.initCause(e2);
            throw malformedURLException;
        }
    }

    public long write(String srcURLstr, String data, int offset, boolean isBinary) throws FileNotFoundException, IOException, NoModificationAllowedException {
        try {
            LocalFilesystemURL parse = LocalFilesystemURL.parse(srcURLstr);
            Filesystem filesystemForURL = filesystemForURL(parse);
            if (filesystemForURL == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
            long writeToFileAtURL = filesystemForURL.writeToFileAtURL(parse, data, offset, isBinary);
            LOG.d("TEST", srcURLstr + ": " + writeToFileAtURL);
            return writeToFileAtURL;
        } catch (IllegalArgumentException e) {
            MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
            malformedURLException.initCause(e);
            throw malformedURLException;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long truncateFile(String srcURLstr, long size) throws FileNotFoundException, IOException, NoModificationAllowedException {
        try {
            LocalFilesystemURL parse = LocalFilesystemURL.parse(srcURLstr);
            Filesystem filesystemForURL = filesystemForURL(parse);
            if (filesystemForURL == null) {
                throw new MalformedURLException("No installed handlers for this URL");
            }
            return filesystemForURL.truncateFileAtURL(parse, size);
        } catch (IllegalArgumentException e) {
            MalformedURLException malformedURLException = new MalformedURLException("Unrecognized filesystem URL");
            malformedURLException.initCause(e);
            throw malformedURLException;
        }
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults) throws JSONException {
        final PendingRequests.Request andRemove = this.pendingRequests.getAndRemove(requestCode);
        if (andRemove != null) {
            for (int i : grantResults) {
                if (i == -1) {
                    andRemove.getCallbackContext().sendPluginResult(new PluginResult(PluginResult.Status.ERROR, SECURITY_ERR));
                    return;
                }
            }
            int action = andRemove.getAction();
            if (action == 0) {
                threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.27
                    @Override // org.apache.cordova.file.FileUtils.FileOp
                    public void run(JSONArray args) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
                        andRemove.getCallbackContext().success(FileUtils.this.getFile(args.getString(0), args.getString(1), args.optJSONObject(2), false));
                    }
                }, andRemove.getRawArgs(), andRemove.getCallbackContext());
                return;
            } else {
                if (action != 1) {
                    if (action != 2) {
                        return;
                    }
                    threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.28
                        @Override // org.apache.cordova.file.FileUtils.FileOp
                        public void run(JSONArray args) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
                            andRemove.getCallbackContext().success(FileUtils.this.getFile(args.getString(0), args.getString(1), args.optJSONObject(2), true));
                        }
                    }, andRemove.getRawArgs(), andRemove.getCallbackContext());
                    return;
                }
                threadhelper(new FileOp() { // from class: org.apache.cordova.file.FileUtils.29
                    @Override // org.apache.cordova.file.FileUtils.FileOp
                    public void run(JSONArray args) throws JSONException, FileNotFoundException, IOException, NoModificationAllowedException {
                        andRemove.getCallbackContext().sendPluginResult(new PluginResult(PluginResult.Status.OK, FileUtils.this.write(args.getString(0), args.getString(1), args.getInt(2), Boolean.valueOf(args.getBoolean(3)).booleanValue())));
                    }
                }, andRemove.getRawArgs(), andRemove.getCallbackContext());
                return;
            }
        }
        LOG.d(LOG_TAG, "Received permission callback for unknown request code");
    }
}
