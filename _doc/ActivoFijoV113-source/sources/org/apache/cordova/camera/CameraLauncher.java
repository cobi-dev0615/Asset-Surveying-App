package org.apache.cordova.camera;

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import barcodescanner.xservices.nl.barcodescanner.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.cordova.BuildHelper;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.apache.cordova.PermissionHelper;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class CameraLauncher extends CordovaPlugin implements MediaScannerConnection.MediaScannerConnectionClient {
    private static final int ALLMEDIA = 2;
    private static final int CAMERA = 1;
    private static final String CROPPED_URI_KEY = "croppedUri";
    private static final int CROP_CAMERA = 100;
    private static final int DATA_URL = 0;
    private static final int FILE_URI = 1;
    private static final String GET_All = "Get All";
    private static final String GET_PICTURE = "Get Picture";
    private static final String GET_VIDEO = "Get Video";
    private static final String HEIC_MIME_TYPE = "image/heic";
    private static final String IMAGE_FILE_PATH_KEY = "imageFilePath";
    private static final String IMAGE_URI_KEY = "imageUri";
    private static final int JPEG = 0;
    private static final String JPEG_EXTENSION = ".jpg";
    private static final String JPEG_MIME_TYPE = "image/jpeg";
    private static final String JPEG_TYPE = "jpg";
    private static final String LOG_TAG = "CameraLauncher";
    public static final int PERMISSION_DENIED_ERROR = 20;
    private static final int PHOTOLIBRARY = 0;
    private static final int PICTURE = 0;
    private static final int PNG = 1;
    private static final String PNG_EXTENSION = ".png";
    private static final String PNG_MIME_TYPE = "image/png";
    private static final String PNG_TYPE = "png";
    private static final int SAVEDPHOTOALBUM = 2;
    public static final int SAVE_TO_ALBUM_SEC = 1;
    private static final String TAKE_PICTURE_ACTION = "takePicture";
    public static final int TAKE_PIC_SEC = 0;
    private static final String TIME_FORMAT = "yyyyMMdd_HHmmss";
    private static final int VIDEO = 1;
    protected static final String[] permissions = {"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private boolean allowEdit;
    private String applicationId;
    public CallbackContext callbackContext;
    private MediaScannerConnection conn;
    private boolean correctOrientation;
    private String croppedFilePath;
    private Uri croppedUri;
    private int destType;
    private int encodingType;
    private ExifHelper exifData;
    private String imageFilePath;
    private Uri imageUri;
    private int mQuality;
    private int mediaType;
    private int numPics;
    private boolean orientationCorrected;
    private boolean saveToPhotoAlbum;
    private Uri scanMe;
    private int srcType;
    private int targetHeight;
    private int targetWidth;

    private int exifToDegrees(int exifOrientation) {
        if (exifOrientation == 6) {
            return 90;
        }
        if (exifOrientation == 3) {
            return 180;
        }
        return exifOrientation == 8 ? 270 : 0;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        this.callbackContext = callbackContext;
        this.applicationId = (String) BuildHelper.getBuildConfigValue(this.cordova.getActivity(), "APPLICATION_ID");
        this.applicationId = this.preferences.getString("applicationId", this.applicationId);
        if (!action.equals(TAKE_PICTURE_ACTION)) {
            return false;
        }
        this.srcType = 1;
        this.destType = 1;
        this.saveToPhotoAlbum = false;
        this.targetHeight = 0;
        this.targetWidth = 0;
        this.encodingType = 0;
        this.mediaType = 0;
        this.mQuality = 50;
        this.destType = args.getInt(1);
        this.srcType = args.getInt(2);
        this.mQuality = args.getInt(0);
        this.targetWidth = args.getInt(3);
        this.targetHeight = args.getInt(4);
        this.encodingType = args.getInt(5);
        this.mediaType = args.getInt(6);
        this.allowEdit = args.getBoolean(7);
        this.correctOrientation = args.getBoolean(8);
        this.saveToPhotoAlbum = args.getBoolean(9);
        if (this.targetWidth < 1) {
            this.targetWidth = -1;
        }
        if (this.targetHeight < 1) {
            this.targetHeight = -1;
        }
        if (this.targetHeight == -1 && this.targetWidth == -1 && this.mQuality == 100 && !this.correctOrientation && this.encodingType == 1 && this.srcType == 1) {
            this.encodingType = 0;
        }
        try {
            int i = this.srcType;
            if (i == 1) {
                callTakePicture(this.destType, this.encodingType);
            } else if (i == 0 || i == 2) {
                if (!PermissionHelper.hasPermission(this, "android.permission.READ_EXTERNAL_STORAGE")) {
                    PermissionHelper.requestPermission(this, 1, "android.permission.READ_EXTERNAL_STORAGE");
                } else {
                    getImage(this.srcType, this.destType);
                }
            }
            PluginResult pluginResult = new PluginResult(PluginResult.Status.NO_RESULT);
            pluginResult.setKeepCallback(true);
            callbackContext.sendPluginResult(pluginResult);
            return true;
        } catch (IllegalArgumentException unused) {
            callbackContext.error("Illegal Argument Exception");
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR));
            return true;
        }
    }

    private String getTempDirectoryPath() {
        File cacheDir = this.cordova.getActivity().getCacheDir();
        cacheDir.mkdirs();
        return cacheDir.getAbsolutePath();
    }

    public void callTakePicture(int returnType, int encodingType) {
        boolean z = true;
        boolean z2 = PermissionHelper.hasPermission(this, "android.permission.READ_EXTERNAL_STORAGE") && PermissionHelper.hasPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
        boolean hasPermission = PermissionHelper.hasPermission(this, "android.permission.CAMERA");
        if (hasPermission) {
            z = hasPermission;
        } else {
            try {
                String[] strArr = this.cordova.getActivity().getPackageManager().getPackageInfo(this.cordova.getActivity().getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        if (strArr[i].equals("android.permission.CAMERA")) {
                            z = false;
                            break;
                        }
                        i++;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (z && z2) {
            takePicture(returnType, encodingType);
            return;
        }
        if (z2) {
            PermissionHelper.requestPermission(this, 0, "android.permission.CAMERA");
        } else if (z) {
            PermissionHelper.requestPermissions(this, 0, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"});
        } else {
            PermissionHelper.requestPermissions(this, 0, permissions);
        }
    }

    public void takePicture(int returnType, int encodingType) {
        this.numPics = queryImgDB(whichContentStore()).getCount();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File createCaptureFile = createCaptureFile(encodingType);
        this.imageFilePath = createCaptureFile.getAbsolutePath();
        Uri uriForFile = androidx.core.content.FileProvider.getUriForFile(this.cordova.getActivity(), this.applicationId + ".cordova.plugin.camera.provider", createCaptureFile);
        this.imageUri = uriForFile;
        intent.putExtra("output", uriForFile);
        intent.addFlags(2);
        if (this.cordova != null) {
            if (intent.resolveActivity(this.cordova.getActivity().getPackageManager()) != null) {
                this.cordova.startActivityForResult(this, intent, returnType + 32 + 1);
            } else {
                LOG.d(LOG_TAG, "Error: You don't have a default camera.  Your device may not be CTS complaint.");
            }
        }
    }

    private File createCaptureFile(int encodingType) {
        return createCaptureFile(encodingType, BuildConfig.FLAVOR);
    }

    private File createCaptureFile(int encodingType, String fileName) {
        String str;
        if (fileName.isEmpty()) {
            fileName = ".Pic";
        }
        if (encodingType == 0) {
            str = fileName + JPEG_EXTENSION;
        } else if (encodingType == 1) {
            str = fileName + PNG_EXTENSION;
        } else {
            throw new IllegalArgumentException("Invalid Encoding Type: " + encodingType);
        }
        return new File(getTempDirectoryPath(), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void getImage(int r7, int r8) {
        /*
            r6 = this;
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            r1 = 0
            r6.croppedUri = r1
            r6.croppedFilePath = r1
            int r1 = r6.mediaType
            java.lang.String r2 = "android.intent.category.OPENABLE"
            java.lang.String r3 = "android.intent.action.GET_CONTENT"
            r4 = 1
            if (r1 != 0) goto L6c
            java.lang.String r1 = "image/*"
            r0.setType(r1)
            boolean r1 = r6.allowEdit
            if (r1 == 0) goto L65
            java.lang.String r1 = "android.intent.action.PICK"
            r0.setAction(r1)
            java.lang.String r1 = "crop"
            java.lang.String r2 = "true"
            r0.putExtra(r1, r2)
            int r1 = r6.targetWidth
            if (r1 <= 0) goto L31
            java.lang.String r2 = "outputX"
            r0.putExtra(r2, r1)
        L31:
            int r1 = r6.targetHeight
            if (r1 <= 0) goto L3a
            java.lang.String r2 = "outputY"
            r0.putExtra(r2, r1)
        L3a:
            int r1 = r6.targetHeight
            if (r1 <= 0) goto L4e
            int r2 = r6.targetWidth
            if (r2 <= 0) goto L4e
            if (r2 != r1) goto L4e
            java.lang.String r1 = "aspectX"
            r0.putExtra(r1, r4)
            java.lang.String r1 = "aspectY"
            r0.putExtra(r1, r4)
        L4e:
            r1 = 0
            java.io.File r1 = r6.createCaptureFile(r1)
            java.lang.String r2 = r1.getAbsolutePath()
            r6.croppedFilePath = r2
            android.net.Uri r1 = android.net.Uri.fromFile(r1)
            r6.croppedUri = r1
            java.lang.String r2 = "output"
            r0.putExtra(r2, r1)
            goto L8d
        L65:
            r0.setAction(r3)
            r0.addCategory(r2)
            goto L8d
        L6c:
            if (r1 != r4) goto L7c
            java.lang.String r1 = "video/*"
            r0.setType(r1)
            r0.setAction(r3)
            r0.addCategory(r2)
            java.lang.String r1 = "Get Video"
            goto L8f
        L7c:
            r5 = 2
            if (r1 != r5) goto L8d
        */
        //  java.lang.String r1 = "*/*"
        /*
            r0.setType(r1)
            r0.setAction(r3)
            r0.addCategory(r2)
            java.lang.String r1 = "Get All"
            goto L8f
        L8d:
            java.lang.String r1 = "Get Picture"
        L8f:
            org.apache.cordova.CordovaInterface r2 = r6.cordova
            if (r2 == 0) goto La6
            org.apache.cordova.CordovaInterface r2 = r6.cordova
            java.lang.String r3 = new java.lang.String
            r3.<init>(r1)
            android.content.Intent r0 = android.content.Intent.createChooser(r0, r3)
            int r7 = r7 + r4
            int r7 = r7 * 16
            int r7 = r7 + r8
            int r7 = r7 + r4
            r2.startActivityForResult(r6, r0, r7)
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.cordova.camera.CameraLauncher.getImage(int, int):void");
    }

    private void performCrop(Uri picUri, int destType, Intent cameraIntent) {
        int i;
        try {
            Intent intent = new Intent("com.android.camera.action.CROP");
            intent.setDataAndType(picUri, "image/*");
            intent.putExtra("crop", "true");
            int i2 = this.targetWidth;
            if (i2 > 0) {
                intent.putExtra("outputX", i2);
            }
            int i3 = this.targetHeight;
            if (i3 > 0) {
                intent.putExtra("outputY", i3);
            }
            int i4 = this.targetHeight;
            if (i4 > 0 && (i = this.targetWidth) > 0 && i == i4) {
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
            }
            String absolutePath = createCaptureFile(this.encodingType, System.currentTimeMillis() + BuildConfig.FLAVOR).getAbsolutePath();
            this.croppedFilePath = absolutePath;
            this.croppedUri = Uri.parse(absolutePath);
            intent.addFlags(1);
            intent.addFlags(2);
            intent.putExtra("output", this.croppedUri);
            if (this.cordova != null) {
                this.cordova.startActivityForResult(this, intent, destType + 100);
            }
        } catch (ActivityNotFoundException unused) {
            LOG.e(LOG_TAG, "Crop operation not supported on this device");
            try {
                processResultFromCamera(destType, cameraIntent);
            } catch (IOException e) {
                e.printStackTrace();
                LOG.e(LOG_TAG, "Unable to write to file");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void processResultFromCamera(int r13, android.content.Intent r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.cordova.camera.CameraLauncher.processResultFromCamera(int, android.content.Intent):void");
    }

    private void writeTakenPictureToGalleryLowerThanAndroidQ(Uri galleryUri) throws IOException {
        writeUncompressedImage(this.imageUri, galleryUri);
        refreshGallery(galleryUri);
    }

    private void writeTakenPictureToGalleryStartingFromAndroidQ(GalleryPathVO galleryPathVO) throws IOException {
        ContentResolver contentResolver = this.cordova.getActivity().getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", galleryPathVO.getGalleryFileName());
        contentValues.put("mime_type", getMimetypeForEncodingType());
        writeUncompressedImage(FileHelper.getInputStreamFromUriString(this.imageUri.toString(), this.cordova), contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues));
    }

    private Bitmap.CompressFormat getCompressFormatForEncodingType(int encodingType) {
        return encodingType == 0 ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
    }

    private GalleryPathVO getPicturesPath() {
        String str = "IMG_" + new SimpleDateFormat(TIME_FORMAT).format(new Date()) + getExtensionForEncodingType();
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        externalStoragePublicDirectory.mkdirs();
        return new GalleryPathVO(externalStoragePublicDirectory.getAbsolutePath(), str);
    }

    private void refreshGallery(Uri contentUri) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(contentUri);
        this.cordova.getActivity().sendBroadcast(intent);
    }

    private String getMimetypeForEncodingType() {
        int i = this.encodingType;
        return i == 1 ? PNG_MIME_TYPE : i == 0 ? JPEG_MIME_TYPE : BuildConfig.FLAVOR;
    }

    private String outputModifiedBitmap(Bitmap bitmap, Uri uri, String mimeTypeOfOriginalFile) throws IOException {
        String str = getTempDirectoryPath() + "/" + calculateModifiedBitmapOutputFileName(mimeTypeOfOriginalFile, FileHelper.getRealPath(uri, this.cordova));
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        bitmap.compress(getCompressFormatForEncodingType(this.encodingType), this.mQuality, fileOutputStream);
        fileOutputStream.close();
        ExifHelper exifHelper = this.exifData;
        if (exifHelper != null && this.encodingType == 0) {
            try {
                if (this.correctOrientation && this.orientationCorrected) {
                    exifHelper.resetOrientation();
                }
                this.exifData.createOutFile(str);
                this.exifData.writeExifData();
                this.exifData = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    private String calculateModifiedBitmapOutputFileName(String mimeTypeOfOriginalFile, String realPath) {
        if (realPath == null) {
            return "modified" + getExtensionForEncodingType();
        }
        String substring = realPath.substring(realPath.lastIndexOf(47) + 1);
        if (getMimetypeForEncodingType().equals(mimeTypeOfOriginalFile)) {
            return substring;
        }
        return substring.substring(substring.lastIndexOf(".") + 1) + getExtensionForEncodingType();
    }

    private String getExtensionForEncodingType() {
        return this.encodingType == 0 ? JPEG_EXTENSION : PNG_EXTENSION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processResultFromGallery(int destType, Intent intent) {
        Uri data = intent.getData();
        if (data == null && (data = this.croppedUri) == null) {
            failPicture("null data from photo library");
            return;
        }
        String realPath = FileHelper.getRealPath(data, this.cordova);
        LOG.d(LOG_TAG, "File location is: " + realPath);
        String uri = data.toString();
        if (realPath == null) {
            realPath = uri;
        }
        String mimeType = FileHelper.getMimeType(uri, this.cordova);
        if (realPath == null) {
            failPicture("Error retrieving result.");
            return;
        }
        if (this.mediaType == 1 || !isImageMimeTypeProcessable(mimeType)) {
            this.callbackContext.success(realPath);
            return;
        }
        if (this.targetHeight == -1 && this.targetWidth == -1 && destType == 1 && !this.correctOrientation && getMimetypeForEncodingType().equalsIgnoreCase(mimeType)) {
            this.callbackContext.success(realPath);
            return;
        }
        Bitmap bitmap = null;
        try {
            bitmap = getScaledAndRotatedBitmap(uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bitmap == null) {
            LOG.d(LOG_TAG, "I either have a null image path or bitmap");
            failPicture("Unable to create bitmap!");
            return;
        }
        if (destType == 0) {
            processPicture(bitmap, this.encodingType);
        } else if (destType == 1) {
            if ((this.targetHeight > 0 && this.targetWidth > 0) || ((this.correctOrientation && this.orientationCorrected) || !mimeType.equalsIgnoreCase(getMimetypeForEncodingType()))) {
                try {
                    String outputModifiedBitmap = outputModifiedBitmap(bitmap, data, mimeType);
                    this.callbackContext.success("file://" + outputModifiedBitmap + "?" + System.currentTimeMillis());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    failPicture("Error retrieving image: " + e2.getLocalizedMessage());
                }
            } else {
                this.callbackContext.success(realPath);
            }
        }
        if (bitmap != null) {
            bitmap.recycle();
        }
        System.gc();
    }

    private boolean isImageMimeTypeProcessable(String mimeType) {
        return JPEG_MIME_TYPE.equalsIgnoreCase(mimeType) || PNG_MIME_TYPE.equalsIgnoreCase(mimeType) || HEIC_MIME_TYPE.equalsIgnoreCase(mimeType);
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onActivityResult(int requestCode, int resultCode, final Intent intent) {
        int i = (requestCode / 16) - 1;
        final int i2 = (requestCode % 16) - 1;
        if (requestCode >= 100) {
            if (resultCode != -1) {
                if (resultCode == 0) {
                    failPicture("No Image Selected");
                    return;
                } else {
                    failPicture("Did not complete!");
                    return;
                }
            }
            try {
                processResultFromCamera(requestCode - 100, intent);
                return;
            } catch (IOException e) {
                e.printStackTrace();
                LOG.e(LOG_TAG, "Unable to write to file");
                return;
            }
        }
        if (i != 1) {
            if (i == 0 || i == 2) {
                if (resultCode == -1 && intent != null) {
                    this.cordova.getThreadPool().execute(new Runnable() { // from class: org.apache.cordova.camera.CameraLauncher.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CameraLauncher.this.processResultFromGallery(i2, intent);
                        }
                    });
                    return;
                } else if (resultCode == 0) {
                    failPicture("No Image Selected");
                    return;
                } else {
                    failPicture("Selection did not complete!");
                    return;
                }
            }
            return;
        }
        if (resultCode != -1) {
            if (resultCode == 0) {
                failPicture("No Image Selected");
                return;
            } else {
                failPicture("Did not complete!");
                return;
            }
        }
        try {
            if (this.allowEdit) {
                performCrop(androidx.core.content.FileProvider.getUriForFile(this.cordova.getActivity(), this.applicationId + ".cordova.plugin.camera.provider", createCaptureFile(this.encodingType)), i2, intent);
            } else {
                processResultFromCamera(i2, intent);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            failPicture("Error capturing image: " + e2.getLocalizedMessage());
        }
    }

    private void writeUncompressedImage(InputStream fis, Uri dest) throws FileNotFoundException, IOException {
        OutputStream outputStream = null;
        try {
            outputStream = this.cordova.getActivity().getContentResolver().openOutputStream(dest);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fis.read(bArr);
                if (read == -1) {
                    break;
                } else {
                    outputStream.write(bArr, 0, read);
                }
            }
            outputStream.flush();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException unused) {
                    LOG.d(LOG_TAG, "Exception while closing output stream.");
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException unused2) {
                    LOG.d(LOG_TAG, "Exception while closing file input stream.");
                }
            }
        } finally {
        }
    }

    private void writeUncompressedImage(Uri src, Uri dest) throws FileNotFoundException, IOException {
        writeUncompressedImage(FileHelper.getInputStreamFromUriString(src.toString(), this.cordova), dest);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:(7:(4:44|45|46|(2:48|(11:50|52|53|54|55|57|58|(2:123|124)|60|(10:65|(1:69)|70|(6:75|76|77|78|(2:107|108)|(2:(1:82)|83)(8:(2:85|86)(1:106)|(1:88)(1:105)|89|(1:91)|92|(4:95|96|97|98)|(1:103)|104))|119|76|77|78|(0)|(0)(0))|122)))(1:145)|57|58|(0)|60|(11:62|65|(2:67|69)|70|(7:72|75|76|77|78|(0)|(0)(0))|119|76|77|78|(0)|(0)(0))|122)|52|53|54|55) */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01db, code lost:
    
        r8.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        if (r2 != null) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01e2, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        if (r2 == null) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0174 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x017d A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0183  */
    /* JADX WARN: Type inference failed for: r2v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Bitmap getScaledAndRotatedBitmap(java.lang.String r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.cordova.camera.CameraLauncher.getScaledAndRotatedBitmap(java.lang.String):android.graphics.Bitmap");
    }

    public int[] calculateAspectRatio(int origWidth, int origHeight) {
        int i = this.targetWidth;
        int i2 = this.targetHeight;
        if (i > 0 || i2 > 0) {
            if (i <= 0 || i2 > 0) {
                if (i > 0 || i2 <= 0) {
                    double d = i / i2;
                    double d2 = origWidth / origHeight;
                    if (d2 > d) {
                        origHeight = (origHeight * i) / origWidth;
                    } else {
                        origWidth = d2 < d ? (origWidth * i2) / origHeight : i;
                    }
                } else {
                    origWidth = (int) ((i2 / origHeight) * origWidth);
                }
                origHeight = i2;
            } else {
                origHeight = (int) ((i / origWidth) * origHeight);
            }
            origWidth = i;
        }
        return new int[]{origWidth, origHeight};
    }

    public static int calculateSampleSize(int srcWidth, int srcHeight, int dstWidth, int dstHeight) {
        if (srcWidth / srcHeight > dstWidth / dstHeight) {
            return srcWidth / dstWidth;
        }
        return srcHeight / dstHeight;
    }

    private Cursor queryImgDB(Uri contentStore) {
        return this.cordova.getActivity().getContentResolver().query(contentStore, new String[]{"_id"}, null, null, null);
    }

    private void cleanup(int imageType, Uri oldImage, Uri newImage, Bitmap bitmap) {
        if (bitmap != null) {
            bitmap.recycle();
        }
        new File(FileHelper.stripFileProtocol(oldImage.toString())).delete();
        checkForDuplicateImage(imageType);
        if (this.saveToPhotoAlbum && newImage != null) {
            scanForGallery(newImage);
        }
        System.gc();
    }

    private void checkForDuplicateImage(int type) {
        Uri whichContentStore = whichContentStore();
        Cursor queryImgDB = queryImgDB(whichContentStore);
        int count = queryImgDB.getCount();
        int i = 1;
        if (type == 1 && this.saveToPhotoAlbum) {
            i = 2;
        }
        if (count - this.numPics == i) {
            queryImgDB.moveToLast();
            int intValue = Integer.valueOf(queryImgDB.getString(queryImgDB.getColumnIndex("_id"))).intValue();
            if (i == 2) {
                intValue--;
            }
            this.cordova.getActivity().getContentResolver().delete(Uri.parse(whichContentStore + "/" + intValue), null, null);
            queryImgDB.close();
        }
    }

    private Uri whichContentStore() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }
        return MediaStore.Images.Media.INTERNAL_CONTENT_URI;
    }

    public void processPicture(Bitmap bitmap, int encodingType) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            if (bitmap.compress(getCompressFormatForEncodingType(encodingType), this.mQuality, byteArrayOutputStream)) {
                this.callbackContext.success(new String(Base64.encode(byteArrayOutputStream.toByteArray(), 2)));
            }
        } catch (Exception e) {
            failPicture("Error compressing image: " + e.getLocalizedMessage());
        }
    }

    public void failPicture(String err) {
        this.callbackContext.error(err);
    }

    private void scanForGallery(Uri newImage) {
        this.scanMe = newImage;
        MediaScannerConnection mediaScannerConnection = this.conn;
        if (mediaScannerConnection != null) {
            mediaScannerConnection.disconnect();
        }
        MediaScannerConnection mediaScannerConnection2 = new MediaScannerConnection(this.cordova.getActivity().getApplicationContext(), this);
        this.conn = mediaScannerConnection2;
        mediaScannerConnection2.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        try {
            this.conn.scanFile(this.scanMe.toString(), "image/*");
        } catch (IllegalStateException unused) {
            LOG.e(LOG_TAG, "Can't scan file in MediaScanner after taking picture");
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String path, Uri uri) {
        this.conn.disconnect();
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onRequestPermissionResult(int requestCode, String[] permissions2, int[] grantResults) {
        for (int i : grantResults) {
            if (i == -1) {
                this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, 20));
                return;
            }
        }
        if (requestCode == 0) {
            takePicture(this.destType, this.encodingType);
        } else {
            if (requestCode != 1) {
                return;
            }
            getImage(this.srcType, this.destType);
        }
    }

    @Override // org.apache.cordova.CordovaPlugin
    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putInt("destType", this.destType);
        bundle.putInt("srcType", this.srcType);
        bundle.putInt("mQuality", this.mQuality);
        bundle.putInt("targetWidth", this.targetWidth);
        bundle.putInt("targetHeight", this.targetHeight);
        bundle.putInt("encodingType", this.encodingType);
        bundle.putInt("mediaType", this.mediaType);
        bundle.putInt("numPics", this.numPics);
        bundle.putBoolean("allowEdit", this.allowEdit);
        bundle.putBoolean("correctOrientation", this.correctOrientation);
        bundle.putBoolean("saveToPhotoAlbum", this.saveToPhotoAlbum);
        if (this.croppedUri != null) {
            bundle.putString(CROPPED_URI_KEY, this.croppedFilePath);
        }
        if (this.imageUri != null) {
            bundle.putString(IMAGE_URI_KEY, this.imageFilePath);
        }
        String str = this.imageFilePath;
        if (str != null) {
            bundle.putString(IMAGE_FILE_PATH_KEY, str);
        }
        return bundle;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onRestoreStateForActivityResult(Bundle state, CallbackContext callbackContext) {
        this.destType = state.getInt("destType");
        this.srcType = state.getInt("srcType");
        this.mQuality = state.getInt("mQuality");
        this.targetWidth = state.getInt("targetWidth");
        this.targetHeight = state.getInt("targetHeight");
        this.encodingType = state.getInt("encodingType");
        this.mediaType = state.getInt("mediaType");
        this.numPics = state.getInt("numPics");
        this.allowEdit = state.getBoolean("allowEdit");
        this.correctOrientation = state.getBoolean("correctOrientation");
        this.saveToPhotoAlbum = state.getBoolean("saveToPhotoAlbum");
        if (state.containsKey(CROPPED_URI_KEY)) {
            this.croppedUri = Uri.parse(state.getString(CROPPED_URI_KEY));
        }
        if (state.containsKey(IMAGE_URI_KEY)) {
            this.imageUri = Uri.parse(state.getString(IMAGE_URI_KEY));
        }
        if (state.containsKey(IMAGE_FILE_PATH_KEY)) {
            this.imageFilePath = state.getString(IMAGE_FILE_PATH_KEY);
        }
        this.callbackContext = callbackContext;
    }
}
