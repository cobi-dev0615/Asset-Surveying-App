package com.devexpress.editors.utils;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* compiled from: WeakProperty.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"weak", "Lcom/devexpress/editors/utils/WeakProperty;", ExifInterface.GPS_DIRECTION_TRUE, "obj", "(Ljava/lang/Object;)Lcom/devexpress/editors/utils/WeakProperty;", "dxeditors_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WeakPropertyKt {
    public static final <T> WeakProperty<T> weak(T t) {
        return new WeakProperty<>(t);
    }

    public static /* synthetic */ WeakProperty weak$default(Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return weak(obj);
    }
}
