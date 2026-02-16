package com.devexpress.editors;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.devexpress.editors.utils.WeakProperty;
import com.devexpress.editors.utils.WeakPropertyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: WeakHolder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\b\u0016\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004R\u001d\u0010\u0005\u001a\u0004\u0018\u00018\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/devexpress/editors/WeakHolder;", ExifInterface.GPS_DIRECTION_TRUE, "", TypedValues.AttributesType.S_TARGET, "(Ljava/lang/Object;)V", "edit", "getEdit", "()Ljava/lang/Object;", "edit$delegate", "Lcom/devexpress/editors/utils/WeakProperty;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class WeakHolder<T> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(WeakHolder.class, "edit", "getEdit()Ljava/lang/Object;", 0))};

    /* renamed from: edit$delegate, reason: from kotlin metadata */
    private final WeakProperty edit;

    public WeakHolder(T t) {
        this.edit = WeakPropertyKt.weak(t);
    }

    public final T getEdit() {
        return (T) this.edit.getValue(this, $$delegatedProperties[0]);
    }
}
