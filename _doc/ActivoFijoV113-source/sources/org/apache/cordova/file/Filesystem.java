package org.apache.cordova.file;

import android.net.Uri;
import barcodescanner.xservices.nl.barcodescanner.BuildConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.cordova.CordovaResourceApi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class Filesystem {
    public final String name;
    protected final CordovaResourceApi resourceApi;
    private JSONObject rootEntry;
    protected final Uri rootUri;

    public interface ReadFileCallback {
        void handleData(InputStream inputStream, String contentType) throws IOException;
    }

    abstract LocalFilesystemURL URLforFilesystemPath(String path);

    abstract boolean canRemoveFileAtLocalURL(LocalFilesystemURL inputURL);

    abstract String filesystemPathForURL(LocalFilesystemURL url);

    abstract JSONObject getFileForLocalURL(LocalFilesystemURL inputURL, String path, JSONObject options, boolean directory) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException;

    abstract JSONObject getFileMetadataForLocalURL(LocalFilesystemURL inputURL) throws FileNotFoundException;

    public long getFreeSpaceInBytes() {
        return 0L;
    }

    abstract LocalFilesystemURL[] listChildren(LocalFilesystemURL inputURL) throws FileNotFoundException;

    abstract boolean recursiveRemoveFileAtLocalURL(LocalFilesystemURL inputURL) throws FileExistsException, NoModificationAllowedException;

    abstract boolean removeFileAtLocalURL(LocalFilesystemURL inputURL) throws InvalidModificationException, NoModificationAllowedException;

    public abstract LocalFilesystemURL toLocalUri(Uri inputURL);

    public abstract Uri toNativeUri(LocalFilesystemURL inputURL);

    abstract long truncateFileAtURL(LocalFilesystemURL inputURL, long size) throws IOException, NoModificationAllowedException;

    abstract long writeToFileAtURL(LocalFilesystemURL inputURL, String data, int offset, boolean isBinary) throws NoModificationAllowedException, IOException;

    public Filesystem(Uri rootUri, String name, CordovaResourceApi resourceApi) {
        this.rootUri = rootUri;
        this.name = name;
        this.resourceApi = resourceApi;
    }

    public static JSONObject makeEntryForURL(LocalFilesystemURL inputURL, Uri nativeURL) {
        try {
            String str = inputURL.path;
            String[] split = str.substring(0, str.length() - (str.endsWith("/") ? 1 : 0)).split("/+");
            String str2 = split[split.length - 1];
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isFile", !inputURL.isDirectory);
            jSONObject.put("isDirectory", inputURL.isDirectory);
            jSONObject.put("name", str2);
            jSONObject.put("fullPath", str);
            jSONObject.put("filesystemName", inputURL.fsName);
            jSONObject.put("filesystem", "temporary".equals(inputURL.fsName) ? 0 : 1);
            String uri = nativeURL.toString();
            if (inputURL.isDirectory && !uri.endsWith("/")) {
                uri = uri + "/";
            }
            jSONObject.put("nativeURL", uri);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public JSONObject makeEntryForURL(LocalFilesystemURL inputURL) {
        Uri nativeUri = toNativeUri(inputURL);
        if (nativeUri == null) {
            return null;
        }
        return makeEntryForURL(inputURL, nativeUri);
    }

    public JSONObject makeEntryForNativeUri(Uri nativeUri) {
        LocalFilesystemURL localUri = toLocalUri(nativeUri);
        if (localUri == null) {
            return null;
        }
        return makeEntryForURL(localUri, nativeUri);
    }

    public JSONObject getEntryForLocalURL(LocalFilesystemURL inputURL) throws IOException {
        return makeEntryForURL(inputURL);
    }

    public JSONObject makeEntryForFile(File file) {
        return makeEntryForNativeUri(Uri.fromFile(file));
    }

    public final JSONArray readEntriesAtLocalURL(LocalFilesystemURL inputURL) throws FileNotFoundException {
        LocalFilesystemURL[] listChildren = listChildren(inputURL);
        JSONArray jSONArray = new JSONArray();
        if (listChildren != null) {
            for (LocalFilesystemURL localFilesystemURL : listChildren) {
                jSONArray.put(makeEntryForURL(localFilesystemURL));
            }
        }
        return jSONArray;
    }

    public Uri getRootUri() {
        return this.rootUri;
    }

    public boolean exists(LocalFilesystemURL inputURL) {
        try {
            getFileMetadataForLocalURL(inputURL);
            return true;
        } catch (FileNotFoundException unused) {
            return false;
        }
    }

    public Uri nativeUriForFullPath(String fullPath) {
        if (fullPath == null) {
            return null;
        }
        String encodedPath = Uri.fromFile(new File(fullPath)).getEncodedPath();
        if (encodedPath.startsWith("/")) {
            encodedPath = encodedPath.substring(1);
        }
        return this.rootUri.buildUpon().appendEncodedPath(encodedPath).build();
    }

    public LocalFilesystemURL localUrlforFullPath(String fullPath) {
        Uri nativeUriForFullPath = nativeUriForFullPath(fullPath);
        if (nativeUriForFullPath != null) {
            return toLocalUri(nativeUriForFullPath);
        }
        return null;
    }

    protected static String normalizePath(String rawPath) {
        boolean startsWith = rawPath.startsWith("/");
        if (startsWith) {
            rawPath = rawPath.replaceFirst("/+", BuildConfig.FLAVOR);
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(rawPath.split("/+")));
        int i = 0;
        while (i < arrayList.size()) {
            if (((String) arrayList.get(i)).equals("..")) {
                arrayList.remove(i);
                if (i > 0) {
                    arrayList.remove(i - 1);
                    i--;
                }
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            sb.append("/");
            sb.append(str);
        }
        if (startsWith) {
            return sb.toString();
        }
        return sb.toString().substring(1);
    }

    public JSONObject getRootEntry() {
        if (this.rootEntry == null) {
            this.rootEntry = makeEntryForNativeUri(this.rootUri);
        }
        return this.rootEntry;
    }

    public JSONObject getParentForLocalURL(LocalFilesystemURL inputURL) throws IOException {
        Uri uri = inputURL.uri;
        String parent = new File(inputURL.uri.getPath()).getParent();
        if (!"/".equals(parent)) {
            uri = inputURL.uri.buildUpon().path(parent + '/').build();
        }
        return getEntryForLocalURL(LocalFilesystemURL.parse(uri));
    }

    protected LocalFilesystemURL makeDestinationURL(String newName, LocalFilesystemURL srcURL, LocalFilesystemURL destURL, boolean isDirectory) {
        String str;
        if ("null".equals(newName) || BuildConfig.FLAVOR.equals(newName)) {
            newName = srcURL.uri.getLastPathSegment();
        }
        String uri = destURL.uri.toString();
        if (uri.endsWith("/")) {
            str = uri + newName;
        } else {
            str = uri + "/" + newName;
        }
        if (isDirectory) {
            str = str + '/';
        }
        return LocalFilesystemURL.parse(str);
    }

    public JSONObject copyFileToURL(LocalFilesystemURL destURL, String newName, Filesystem srcFs, LocalFilesystemURL srcURL, boolean move) throws IOException, InvalidModificationException, JSONException, NoModificationAllowedException, FileExistsException {
        if (move && !srcFs.canRemoveFileAtLocalURL(srcURL)) {
            throw new NoModificationAllowedException("Cannot move file at source URL");
        }
        LocalFilesystemURL makeDestinationURL = makeDestinationURL(newName, srcURL, destURL, srcURL.isDirectory);
        CordovaResourceApi.OpenForReadResult openForRead = this.resourceApi.openForRead(srcFs.toNativeUri(srcURL));
        try {
            this.resourceApi.copyResource(openForRead, getOutputStreamForURL(makeDestinationURL));
            if (move) {
                srcFs.removeFileAtLocalURL(srcURL);
            }
            return getEntryForLocalURL(makeDestinationURL);
        } catch (IOException e) {
            openForRead.inputStream.close();
            throw e;
        }
    }

    public OutputStream getOutputStreamForURL(LocalFilesystemURL inputURL) throws IOException {
        return this.resourceApi.openOutputStream(toNativeUri(inputURL));
    }

    public void readFileAtURL(LocalFilesystemURL inputURL, long start, long end, ReadFileCallback readFileCallback) throws IOException {
        CordovaResourceApi.OpenForReadResult openForRead = this.resourceApi.openForRead(toNativeUri(inputURL));
        if (end < 0) {
            end = openForRead.length;
        }
        long j = end - start;
        if (start > 0) {
            try {
                openForRead.inputStream.skip(start);
            } finally {
                openForRead.inputStream.close();
            }
        }
        InputStream inputStream = openForRead.inputStream;
        if (end < openForRead.length) {
            inputStream = new LimitedInputStream(inputStream, j);
        }
        readFileCallback.handleData(inputStream, openForRead.mimeType);
    }

    protected class LimitedInputStream extends FilterInputStream {
        long numBytesToRead;

        public LimitedInputStream(InputStream in, long numBytesToRead) {
            super(in);
            this.numBytesToRead = numBytesToRead;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            long j = this.numBytesToRead;
            if (j <= 0) {
                return -1;
            }
            this.numBytesToRead = j - 1;
            return this.in.read();
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
            long j = this.numBytesToRead;
            if (j <= 0) {
                return -1;
            }
            if (byteCount > j) {
                byteCount = (int) j;
            }
            int read = this.in.read(buffer, byteOffset, byteCount);
            this.numBytesToRead -= read;
            return read;
        }
    }
}
