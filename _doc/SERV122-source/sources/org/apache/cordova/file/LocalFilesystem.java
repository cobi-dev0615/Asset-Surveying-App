package org.apache.cordova.file;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaResourceApi;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LocalFilesystem extends Filesystem {
    private final Context context;

    public LocalFilesystem(String name, Context context, CordovaResourceApi resourceApi, File fsRoot, CordovaPreferences preferences) {
        super(Uri.fromFile(fsRoot).buildUpon().appendEncodedPath("").build(), name, resourceApi, preferences);
        this.context = context;
    }

    public String filesystemPathForFullPath(String fullPath) {
        return new File(this.rootUri.getPath(), fullPath).toString();
    }

    @Override // org.apache.cordova.file.Filesystem
    public String filesystemPathForURL(LocalFilesystemURL url) {
        return filesystemPathForFullPath(url.path);
    }

    private String fullPathForFilesystemPath(String absolutePath) {
        if (absolutePath == null || !absolutePath.startsWith(this.rootUri.getPath())) {
            return null;
        }
        return absolutePath.substring(this.rootUri.getPath().length() - 1);
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
        File file = new File(inputURL.getPath());
        Uri fromFile = Uri.fromFile(file);
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
        if (file.isDirectory()) {
            createLocalUriBuilder.appendEncodedPath("");
        }
        return LocalFilesystemURL.parse(createLocalUriBuilder.build());
    }

    @Override // org.apache.cordova.file.Filesystem
    public LocalFilesystemURL URLforFilesystemPath(String path) {
        return localUrlforFullPath(fullPathForFilesystemPath(path));
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    @Override // org.apache.cordova.file.Filesystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject getFileForLocalURL(org.apache.cordova.file.LocalFilesystemURL r4, java.lang.String r5, org.json.JSONObject r6, boolean r7) throws org.apache.cordova.file.FileExistsException, java.io.IOException, org.apache.cordova.file.TypeMismatchException, org.apache.cordova.file.EncodingException, org.json.JSONException {
        /*
            r3 = this;
            r0 = 0
            if (r6 == 0) goto L15
            java.lang.String r1 = "create"
            boolean r1 = r6.optBoolean(r1)
            if (r1 == 0) goto L14
            java.lang.String r0 = "exclusive"
            boolean r0 = r6.optBoolean(r0)
            r6 = r0
            r0 = r1
            goto L16
        L14:
            r0 = r1
        L15:
            r6 = 0
        L16:
            java.lang.String r1 = ":"
            boolean r1 = r5.contains(r1)
            if (r1 != 0) goto Lc8
            java.lang.String r1 = "/"
            if (r7 == 0) goto L37
            boolean r2 = r5.endsWith(r1)
            if (r2 != 0) goto L37
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r2.append(r1)
            java.lang.String r5 = r2.toString()
        L37:
            boolean r2 = r5.startsWith(r1)
            if (r2 == 0) goto L46
            java.lang.String r4 = normalizePath(r5)
            org.apache.cordova.file.LocalFilesystemURL r4 = r3.localUrlforFullPath(r4)
            goto L62
        L46:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r4.path
            r2.append(r4)
            r2.append(r1)
            r2.append(r5)
            java.lang.String r4 = r2.toString()
            java.lang.String r4 = normalizePath(r4)
            org.apache.cordova.file.LocalFilesystemURL r4 = r3.localUrlforFullPath(r4)
        L62:
            java.io.File r5 = new java.io.File
            java.lang.String r1 = r3.filesystemPathForURL(r4)
            r5.<init>(r1)
            if (r0 == 0) goto L96
            if (r6 == 0) goto L7e
            boolean r6 = r5.exists()
            if (r6 != 0) goto L76
            goto L7e
        L76:
            org.apache.cordova.file.FileExistsException r4 = new org.apache.cordova.file.FileExistsException
            java.lang.String r5 = "create/exclusive fails"
            r4.<init>(r5)
            throw r4
        L7e:
            if (r7 == 0) goto L84
            r5.mkdir()
            goto L87
        L84:
            r5.createNewFile()
        L87:
            boolean r5 = r5.exists()
            if (r5 == 0) goto L8e
            goto Lb3
        L8e:
            org.apache.cordova.file.FileExistsException r4 = new org.apache.cordova.file.FileExistsException
            java.lang.String r5 = "create fails"
            r4.<init>(r5)
            throw r4
        L96:
            boolean r6 = r5.exists()
            if (r6 == 0) goto Lc0
            if (r7 == 0) goto Lad
            boolean r5 = r5.isFile()
            if (r5 != 0) goto La5
            goto Lb3
        La5:
            org.apache.cordova.file.TypeMismatchException r4 = new org.apache.cordova.file.TypeMismatchException
            java.lang.String r5 = "path doesn't exist or is file"
            r4.<init>(r5)
            throw r4
        Lad:
            boolean r5 = r5.isDirectory()
            if (r5 != 0) goto Lb8
        Lb3:
            org.json.JSONObject r4 = r3.makeEntryForURL(r4)
            return r4
        Lb8:
            org.apache.cordova.file.TypeMismatchException r4 = new org.apache.cordova.file.TypeMismatchException
            java.lang.String r5 = "path doesn't exist or is directory"
            r4.<init>(r5)
            throw r4
        Lc0:
            java.io.FileNotFoundException r4 = new java.io.FileNotFoundException
            java.lang.String r5 = "path does not exist"
            r4.<init>(r5)
            throw r4
        Lc8:
            org.apache.cordova.file.EncodingException r4 = new org.apache.cordova.file.EncodingException
            java.lang.String r5 = "This path has an invalid \":\" in it."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.cordova.file.LocalFilesystem.getFileForLocalURL(org.apache.cordova.file.LocalFilesystemURL, java.lang.String, org.json.JSONObject, boolean):org.json.JSONObject");
    }

    @Override // org.apache.cordova.file.Filesystem
    public boolean removeFileAtLocalURL(LocalFilesystemURL inputURL) throws InvalidModificationException {
        File file = new File(filesystemPathForURL(inputURL));
        if (file.isDirectory() && file.list().length > 0) {
            throw new InvalidModificationException("You can't delete a directory that is not empty.");
        }
        return file.delete();
    }

    @Override // org.apache.cordova.file.Filesystem
    public boolean exists(LocalFilesystemURL inputURL) {
        return new File(filesystemPathForURL(inputURL)).exists();
    }

    @Override // org.apache.cordova.file.Filesystem
    public long getFreeSpaceInBytes() {
        return DirectoryManager.getFreeSpaceInBytes(this.rootUri.getPath());
    }

    @Override // org.apache.cordova.file.Filesystem
    public boolean recursiveRemoveFileAtLocalURL(LocalFilesystemURL inputURL) throws FileExistsException {
        return removeDirRecursively(new File(filesystemPathForURL(inputURL)));
    }

    protected boolean removeDirRecursively(File directory) throws FileExistsException {
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                removeDirRecursively(file);
            }
        }
        if (directory.delete()) {
            return true;
        }
        throw new FileExistsException("could not delete: " + directory.getName());
    }

    @Override // org.apache.cordova.file.Filesystem
    public LocalFilesystemURL[] listChildren(LocalFilesystemURL inputURL) throws FileNotFoundException {
        File file = new File(filesystemPathForURL(inputURL));
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return null;
        }
        LocalFilesystemURL[] localFilesystemURLArr = new LocalFilesystemURL[listFiles.length];
        for (int i = 0; i < listFiles.length; i++) {
            localFilesystemURLArr[i] = URLforFilesystemPath(listFiles[i].getPath());
        }
        return localFilesystemURLArr;
    }

    @Override // org.apache.cordova.file.Filesystem
    public JSONObject getFileMetadataForLocalURL(LocalFilesystemURL inputURL) throws FileNotFoundException {
        File file = new File(filesystemPathForURL(inputURL));
        if (!file.exists()) {
            throw new FileNotFoundException("File at " + inputURL.uri + " does not exist.");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("size", file.isDirectory() ? 0L : file.length());
            jSONObject.put("type", this.resourceApi.getMimeType(Uri.fromFile(file)));
            jSONObject.put("name", file.getName());
            jSONObject.put("fullPath", inputURL.path);
            jSONObject.put("lastModifiedDate", file.lastModified());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private void copyFile(Filesystem srcFs, LocalFilesystemURL srcURL, File destFile, boolean move) throws IOException, InvalidModificationException, NoModificationAllowedException {
        String filesystemPathForURL;
        if (move && (filesystemPathForURL = srcFs.filesystemPathForURL(srcURL)) != null && new File(filesystemPathForURL).renameTo(destFile)) {
            return;
        }
        this.resourceApi.copyResource(this.resourceApi.openForRead(srcFs.toNativeUri(srcURL)), new FileOutputStream(destFile));
        if (move) {
            srcFs.removeFileAtLocalURL(srcURL);
        }
    }

    private void copyDirectory(Filesystem srcFs, LocalFilesystemURL srcURL, File dstDir, boolean move) throws IOException, NoModificationAllowedException, InvalidModificationException, FileExistsException {
        String filesystemPathForURL;
        if (move && (filesystemPathForURL = srcFs.filesystemPathForURL(srcURL)) != null) {
            File file = new File(filesystemPathForURL);
            if (dstDir.exists()) {
                if (dstDir.list().length > 0) {
                    throw new InvalidModificationException("directory is not empty");
                }
                dstDir.delete();
            }
            if (file.renameTo(dstDir)) {
                return;
            }
        }
        if (dstDir.exists()) {
            if (dstDir.list().length > 0) {
                throw new InvalidModificationException("directory is not empty");
            }
        } else if (!dstDir.mkdir()) {
            throw new NoModificationAllowedException("Couldn't create the destination directory");
        }
        for (LocalFilesystemURL localFilesystemURL : srcFs.listChildren(srcURL)) {
            File file2 = new File(dstDir, new File(localFilesystemURL.path).getName());
            if (localFilesystemURL.isDirectory) {
                copyDirectory(srcFs, localFilesystemURL, file2, false);
            } else {
                copyFile(srcFs, localFilesystemURL, file2, false);
            }
        }
        if (move) {
            srcFs.recursiveRemoveFileAtLocalURL(srcURL);
        }
    }

    @Override // org.apache.cordova.file.Filesystem
    public JSONObject copyFileToURL(LocalFilesystemURL destURL, String newName, Filesystem srcFs, LocalFilesystemURL srcURL, boolean move) throws IOException, InvalidModificationException, JSONException, NoModificationAllowedException, FileExistsException {
        if (!new File(filesystemPathForURL(destURL)).exists()) {
            throw new FileNotFoundException("The source does not exist");
        }
        LocalFilesystemURL makeDestinationURL = makeDestinationURL(newName, srcURL, destURL, srcURL.isDirectory);
        Uri nativeUri = toNativeUri(makeDestinationURL);
        Uri nativeUri2 = srcFs.toNativeUri(srcURL);
        if (nativeUri.equals(nativeUri2)) {
            throw new InvalidModificationException("Can't copy onto itself");
        }
        if (move && !srcFs.canRemoveFileAtLocalURL(srcURL)) {
            throw new InvalidModificationException("Source URL is read-only (cannot move)");
        }
        File file = new File(nativeUri.getPath());
        if (file.exists()) {
            if (!srcURL.isDirectory && file.isDirectory()) {
                throw new InvalidModificationException("Can't copy/move a file to an existing directory");
            }
            if (srcURL.isDirectory && file.isFile()) {
                throw new InvalidModificationException("Can't copy/move a directory to an existing file");
            }
        }
        if (srcURL.isDirectory) {
            if (nativeUri.toString().startsWith(nativeUri2.toString() + '/')) {
                throw new InvalidModificationException("Can't copy directory into itself");
            }
            copyDirectory(srcFs, srcURL, file, move);
        } else {
            copyFile(srcFs, srcURL, file, move);
        }
        return makeEntryForURL(makeDestinationURL);
    }

    @Override // org.apache.cordova.file.Filesystem
    public long writeToFileAtURL(LocalFilesystemURL inputURL, String data, int offset, boolean isBinary) throws IOException, NoModificationAllowedException {
        boolean z;
        byte[] bytes;
        if (offset > 0) {
            truncateFileAtURL(inputURL, offset);
            z = true;
        } else {
            z = false;
        }
        if (isBinary) {
            bytes = Base64.decode(data, 0);
        } else {
            bytes = data.getBytes(Charset.defaultCharset());
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            int length = bytes.length;
            byte[] bArr = new byte[length];
            String filesystemPathForURL = filesystemPathForURL(inputURL);
            FileOutputStream fileOutputStream = new FileOutputStream(filesystemPathForURL, z);
            try {
                byteArrayInputStream.read(bArr, 0, length);
                fileOutputStream.write(bArr, 0, bytes.length);
                fileOutputStream.flush();
                fileOutputStream.close();
                if (isPublicDirectory(filesystemPathForURL)) {
                    broadcastNewFile(Uri.fromFile(new File(filesystemPathForURL)));
                }
                return bytes.length;
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (NullPointerException e) {
            NoModificationAllowedException noModificationAllowedException = new NoModificationAllowedException(inputURL.toString());
            noModificationAllowedException.initCause(e);
            throw noModificationAllowedException;
        }
    }

    private boolean isPublicDirectory(String absolutePath) {
        if (Build.VERSION.SDK_INT >= 21) {
            for (File file : this.context.getExternalMediaDirs()) {
                if (file != null && absolutePath.startsWith(file.getAbsolutePath())) {
                    return true;
                }
            }
        }
        return absolutePath.startsWith(Environment.getExternalStorageDirectory().getAbsolutePath());
    }

    private void broadcastNewFile(Uri nativeUri) {
        this.context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", nativeUri));
    }

    @Override // org.apache.cordova.file.Filesystem
    public long truncateFileAtURL(LocalFilesystemURL inputURL, long size) throws IOException {
        if (!new File(filesystemPathForURL(inputURL)).exists()) {
            throw new FileNotFoundException("File at " + inputURL.uri + " does not exist.");
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(filesystemPathForURL(inputURL), "rw");
        try {
            if (randomAccessFile.length() >= size) {
                randomAccessFile.getChannel().truncate(size);
                return size;
            }
            return randomAccessFile.length();
        } finally {
            randomAccessFile.close();
        }
    }

    @Override // org.apache.cordova.file.Filesystem
    public boolean canRemoveFileAtLocalURL(LocalFilesystemURL inputURL) {
        return new File(filesystemPathForURL(inputURL)).exists();
    }
}
