package com.devexpress.editors.utils.drawablemanager;

import com.devexpress.editors.DXCornerMode;
import com.devexpress.editors.model.drawables.CornerTreatment;
import com.devexpress.editors.model.drawables.CutCornerTreatment;
import com.devexpress.editors.model.drawables.RoundCornerTreatment;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CornerTreatmentFactory.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/utils/drawablemanager/CornerTreatmentFactory;", "", "()V", "createCornerTreatment", "Lcom/devexpress/editors/model/drawables/CornerTreatment;", "mode", "Lcom/devexpress/editors/DXCornerMode;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CornerTreatmentFactory {
    public static final CornerTreatmentFactory INSTANCE = new CornerTreatmentFactory();

    /* compiled from: CornerTreatmentFactory.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DXCornerMode.values().length];
            try {
                iArr[DXCornerMode.Cut.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DXCornerMode.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private CornerTreatmentFactory() {
    }

    @JvmStatic
    public static final CornerTreatment createCornerTreatment(DXCornerMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i == 1) {
            return new CutCornerTreatment();
        }
        if (i == 2) {
            return new RoundCornerTreatment();
        }
        throw new NoWhenBranchMatchedException();
    }
}
