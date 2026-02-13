package com.devexpress.editors.layout;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HStack.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"HStack", "Lcom/devexpress/editors/layout/HStack;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "dxeditors_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HStackKt {
    public static final HStack HStack(Function1<? super HStack, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        HStack hStack = new HStack(null, null, 0, null, 15, null);
        init.invoke(hStack);
        return hStack;
    }
}
