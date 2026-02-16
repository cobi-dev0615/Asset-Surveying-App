package com.devexpress.editors.helpers;

import android.content.Context;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MathHelper.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b6\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/devexpress/editors/helpers/MathHelper;", "", "()V", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MathHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ MathHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: MathHelper.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/devexpress/editors/helpers/MathHelper$Companion;", "", "()V", "applyDimension", "", "context", "Landroid/content/Context;", "value", "unit", "", "applyDimensionToInt", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int applyDimensionToInt(Context context, float value, int unit) {
            Intrinsics.checkNotNullParameter(context, "context");
            float applyDimension = applyDimension(context, value, unit);
            return (int) (applyDimension + (Math.signum(applyDimension) * 0.5f));
        }

        public final float applyDimension(Context context, float value, int unit) {
            Intrinsics.checkNotNullParameter(context, "context");
            return TypedValue.applyDimension(unit, value, context.getResources().getDisplayMetrics());
        }
    }

    private MathHelper() {
    }
}
