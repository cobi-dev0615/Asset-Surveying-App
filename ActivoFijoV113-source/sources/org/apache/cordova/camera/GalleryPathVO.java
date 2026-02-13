package org.apache.cordova.camera;

/* loaded from: classes.dex */
public class GalleryPathVO {
    private String galleryFileName;
    private final String galleryPath;
    private String picturesDirectory;

    public GalleryPathVO(String picturesDirectory, String galleryFileName) {
        this.picturesDirectory = picturesDirectory;
        this.galleryFileName = galleryFileName;
        this.galleryPath = this.picturesDirectory + "/" + this.galleryFileName;
    }

    public String getGalleryPath() {
        return this.galleryPath;
    }

    public String getPicturesDirectory() {
        return this.picturesDirectory;
    }

    public String getGalleryFileName() {
        return this.galleryFileName;
    }
}
