package com.devexpress.navigation.modal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TouchReceiver.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/devexpress/navigation/modal/TouchReceiver;", "Landroid/view/View$OnTouchListener;", TypedValues.AttributesType.S_TARGET, "Landroid/content/Context;", "(Landroid/content/Context;)V", "onTouch", "", "v", "Landroid/view/View;", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "dxnavigation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TouchReceiver implements View.OnTouchListener {
    private final Context target;

    public TouchReceiver(Context target) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.target = target;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int[] iArr = {0, 0};
        TypedValue typedValue = new TypedValue();
        Matrix matrix = new Matrix();
        int complexToDimensionPixelSize = TypedValue.complexToDimensionPixelSize(typedValue.data, this.target.getResources().getDisplayMetrics());
        if (v != null) {
            v.getLocationOnScreen(iArr);
        }
        matrix.setTranslate(0.0f, complexToDimensionPixelSize + iArr[1]);
        if (event != null) {
            event.transform(matrix);
        }
        Context context = this.target;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.dispatchTouchEvent(event);
        }
        return true;
    }
}
