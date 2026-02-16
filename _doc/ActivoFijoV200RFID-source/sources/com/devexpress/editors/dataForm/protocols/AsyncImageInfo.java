package com.devexpress.editors.dataForm.protocols;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AsyncImageInfo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0010B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/devexpress/editors/dataForm/protocols/AsyncImageInfo;", "", "icon", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "imageInfoListener", "Lcom/devexpress/editors/dataForm/protocols/AsyncImageInfo$AsyncImageInfoListener;", "getImageInfoListener", "()Lcom/devexpress/editors/dataForm/protocols/AsyncImageInfo$AsyncImageInfoListener;", "setImageInfoListener", "(Lcom/devexpress/editors/dataForm/protocols/AsyncImageInfo$AsyncImageInfoListener;)V", "setImage", "", "AsyncImageInfoListener", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class AsyncImageInfo {
    private Drawable icon;
    private AsyncImageInfoListener imageInfoListener;

    /* compiled from: AsyncImageInfo.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/devexpress/editors/dataForm/protocols/AsyncImageInfo$AsyncImageInfoListener;", "", "onImageLoaded", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AsyncImageInfoListener {
        void onImageLoaded();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncImageInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public AsyncImageInfo(Drawable drawable) {
        this.icon = drawable;
    }

    public /* synthetic */ AsyncImageInfo(Drawable drawable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : drawable);
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final void setIcon(Drawable drawable) {
        this.icon = drawable;
    }

    public final AsyncImageInfoListener getImageInfoListener() {
        return this.imageInfoListener;
    }

    public final void setImageInfoListener(AsyncImageInfoListener asyncImageInfoListener) {
        this.imageInfoListener = asyncImageInfoListener;
    }

    public final void setImage(Drawable icon) {
        this.icon = icon;
        AsyncImageInfoListener asyncImageInfoListener = this.imageInfoListener;
        if (asyncImageInfoListener != null) {
            asyncImageInfoListener.onImageLoaded();
        }
    }
}
