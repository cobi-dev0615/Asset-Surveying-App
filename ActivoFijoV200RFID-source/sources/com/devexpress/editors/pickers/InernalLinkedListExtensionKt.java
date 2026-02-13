package com.devexpress.editors.pickers;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InernalLinkedListExtension.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0000¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"dxRemoveFirstOrNull", ExifInterface.LONGITUDE_EAST, "Ljava/util/LinkedList;", "(Ljava/util/LinkedList;)Ljava/lang/Object;", "dxeditors_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InernalLinkedListExtensionKt {
    public static final <E> E dxRemoveFirstOrNull(LinkedList<E> linkedList) {
        Intrinsics.checkNotNullParameter(linkedList, "<this>");
        E e = (E) CollectionsKt.firstOrNull((List) linkedList);
        if (!linkedList.isEmpty()) {
            linkedList.removeFirst();
        }
        return e;
    }
}
