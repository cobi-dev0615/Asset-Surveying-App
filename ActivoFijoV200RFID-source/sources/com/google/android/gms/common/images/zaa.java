package com.google.android.gms.common.images;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* compiled from: com.google.android.gms:play-services-base@@18.7.0 */
/* loaded from: classes2.dex */
final class zaa implements Runnable {
    final /* synthetic */ ImageManager zaa;
    private final Uri zab;
    private final AssetFileDescriptor zac;

    public zaa(ImageManager imageManager, Uri uri, AssetFileDescriptor assetFileDescriptor) {
        this.zaa = imageManager;
        this.zab = uri;
        this.zac = assetFileDescriptor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        AssetFileDescriptor assetFileDescriptor = this.zac;
        Bitmap bitmap = null;
        boolean z = false;
        if (assetFileDescriptor != null) {
            try {
                FileInputStream createInputStream = assetFileDescriptor.createInputStream();
                if (createInputStream != null) {
                    try {
                        bitmap = BitmapFactory.decodeStream(createInputStream);
                    } catch (Throwable th) {
                        try {
                            createInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (createInputStream != null) {
                    createInputStream.close();
                }
            } catch (IOException | OutOfMemoryError e) {
                String valueOf = String.valueOf(this.zab);
                String.valueOf(valueOf);
                Log.e("ImageManager", "Error loading bitmap for uri: ".concat(String.valueOf(valueOf)), e);
                z = e instanceof OutOfMemoryError;
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager imageManager = this.zaa;
        imageManager.zae().post(new zac(imageManager, this.zab, bitmap, z, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            String valueOf2 = String.valueOf(this.zab);
            String.valueOf(valueOf2);
            Log.w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(valueOf2)));
        }
    }
}
