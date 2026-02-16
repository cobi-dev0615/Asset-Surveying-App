package com.devexpress.editors.utils.drawablemanager;

import com.devexpress.editors.DXBorderMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DropDownDrawableManager.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/utils/drawablemanager/DropDownDrawableManagerFactory;", "", "()V", "createManager", "Lcom/devexpress/editors/utils/drawablemanager/DropDownDrawableManager;", "boxMode", "Lcom/devexpress/editors/DXBorderMode;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DropDownDrawableManagerFactory {
    public static final DropDownDrawableManagerFactory INSTANCE = new DropDownDrawableManagerFactory();

    /* compiled from: DropDownDrawableManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DXBorderMode.values().length];
            try {
                iArr[DXBorderMode.Outlined.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DXBorderMode.Filled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private DropDownDrawableManagerFactory() {
    }

    public final DropDownDrawableManager createManager(DXBorderMode boxMode) {
        Intrinsics.checkNotNullParameter(boxMode, "boxMode");
        int i = WhenMappings.$EnumSwitchMapping$0[boxMode.ordinal()];
        if (i == 1) {
            return new OutlinedDropDownDrawableManager();
        }
        if (i == 2) {
            return new FilledDropDownDrawableManager();
        }
        throw new NoWhenBranchMatchedException();
    }
}
