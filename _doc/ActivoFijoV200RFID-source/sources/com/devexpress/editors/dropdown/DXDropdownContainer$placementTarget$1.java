package com.devexpress.editors.dropdown;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: DXDropdownContainer.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class DXDropdownContainer$placementTarget$1 extends FunctionReferenceImpl implements Function0<Unit> {
    DXDropdownContainer$placementTarget$1(Object obj) {
        super(0, obj, DXDropdownContainer.class, "resizeOpenFrameWithPosition", "resizeOpenFrameWithPosition()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((DXDropdownContainer) this.receiver).resizeOpenFrameWithPosition();
    }
}
