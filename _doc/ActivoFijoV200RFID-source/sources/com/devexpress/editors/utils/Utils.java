package com.devexpress.editors.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/devexpress/editors/utils/Utils;", "", "()V", "clamp", "", "value", "minValue", "maxValue", "getActivityFromContext", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Utils {
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    @JvmStatic
    public static final int clamp(int value, int minValue, int maxValue) {
        return Math.min(Math.max(value, minValue), maxValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.content.ContextWrapper] */
    @JvmStatic
    public static final Activity getActivityFromContext(Context context) {
        if (context == null) {
            return null;
        }
        Activity activity = context instanceof ContextWrapper ? (ContextWrapper) context : null;
        if (activity == null) {
            return null;
        }
        Activity activity2 = activity instanceof Activity ? activity : null;
        return activity2 != null ? activity2 : getActivityFromContext(activity.getBaseContext());
    }
}
