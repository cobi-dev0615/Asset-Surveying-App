package com.devexpress.dxgrid.utils;

import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* compiled from: OnGridScrollChangeListener.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/devexpress/dxgrid/utils/OnGridScrollChangeListener;", "", "getSwipeOffset", "", "isMotionInsideSwipedContainer", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "onActionUp", "", "onHorizontalOverScroll", "distanceX", "", "onHorizontalScrollChange", "scrollX", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface OnGridScrollChangeListener {
    int getSwipeOffset();

    boolean isMotionInsideSwipedContainer(MotionEvent event);

    void onActionUp();

    void onHorizontalOverScroll(float distanceX);

    void onHorizontalScrollChange(int scrollX);
}
