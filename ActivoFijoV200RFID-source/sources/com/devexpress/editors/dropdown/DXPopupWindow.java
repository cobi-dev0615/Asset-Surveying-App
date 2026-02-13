package com.devexpress.editors.dropdown;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.WindowManager;
import com.devexpress.editors.utils.Utils;

/* loaded from: classes2.dex */
public class DXPopupWindow {
    private View contentView;
    private Context context;
    private boolean isNotTouchModal;
    private boolean isShowing;
    private WindowManager windowManager;
    private int width = -2;
    private int height = -2;
    private boolean ignoreCheekPress = false;
    private boolean isFocusable = true;
    private boolean isTouchable = true;
    private boolean isOutsideTouchable = false;
    private boolean splitTouchEnabled = true;
    private boolean layoutInScreen = true;
    private boolean isClippingEnabled = true;

    public DXPopupWindow(Context context) {
        this.context = context;
        this.windowManager = (WindowManager) context.getSystemService("window");
    }

    public View getContentView() {
        return this.contentView;
    }

    public void setContentView(View view) {
        if (this.isShowing) {
            return;
        }
        this.contentView = view;
        if (this.context == null && view != null) {
            this.context = view.getContext();
        }
        if (this.windowManager != null || this.contentView == null) {
            return;
        }
        this.windowManager = (WindowManager) this.context.getSystemService("window");
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void setIgnoreCheekPress() {
        this.ignoreCheekPress = true;
    }

    public boolean isSplitTouchEnabled() {
        return this.splitTouchEnabled;
    }

    public void setSplitTouchEnabled() {
        this.splitTouchEnabled = true;
    }

    public boolean isTouchable() {
        return this.isTouchable;
    }

    public void setTouchable(boolean z) {
        this.isTouchable = z;
    }

    public boolean isOutsideTouchable() {
        return this.isOutsideTouchable;
    }

    public void setOutsideTouchable(boolean z) {
        this.isOutsideTouchable = z;
    }

    public boolean isClippingEnabled() {
        return this.isClippingEnabled;
    }

    public void setClippingEnabled(boolean z) {
        this.isClippingEnabled = z;
    }

    public boolean isLaidOutInScreen() {
        return this.layoutInScreen;
    }

    public void setIsLaidOutInScreen(boolean z) {
        this.layoutInScreen = z;
    }

    public boolean isTouchModal() {
        return !this.isNotTouchModal;
    }

    public void setTouchModal(boolean z) {
        this.isNotTouchModal = !z;
    }

    public boolean isFocusable() {
        return this.isFocusable;
    }

    public void setFocusable(boolean z) {
        this.isFocusable = z;
    }

    public void showAtLocation(int i, int i2) {
        if (isShowing() || this.contentView == null) {
            return;
        }
        this.isShowing = true;
        WindowManager.LayoutParams createPopupLayoutParams = createPopupLayoutParams();
        Point convertToLocationInWindow = convertToLocationInWindow(i, i2);
        createPopupLayoutParams.x = convertToLocationInWindow.x;
        createPopupLayoutParams.y = convertToLocationInWindow.y;
        invokePopup(createPopupLayoutParams);
    }

    Point convertToLocationInWindow(int i, int i2) {
        Activity activityFromContext = Utils.getActivityFromContext(this.context);
        if (activityFromContext == null) {
            return new Point(i, i2);
        }
        int[] iArr = new int[2];
        activityFromContext.getWindow().getDecorView().getLocationOnScreen(iArr);
        return new Point(i - iArr[0], i2 - Math.max(0, iArr[1]));
    }

    public void update(int i, int i2, int i3, int i4) {
        update(i, i2, i3, i4, false);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        View view;
        setWidth(Math.max(i3, 0));
        setHeight(Math.max(i4, 0));
        if (!this.isShowing || (view = this.contentView) == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) view.getLayoutParams();
        int i5 = layoutParams.width;
        int i6 = this.width;
        if (i5 != i6) {
            layoutParams.width = i6;
        }
        int i7 = layoutParams.height;
        int i8 = this.height;
        if (i7 != i8) {
            layoutParams.height = i8;
        }
        Point convertToLocationInWindow = convertToLocationInWindow(i, i2);
        int i9 = convertToLocationInWindow.x;
        int i10 = convertToLocationInWindow.y;
        if (layoutParams.x != i9) {
            layoutParams.x = i9;
        }
        if (layoutParams.y != i10) {
            layoutParams.y = i10;
        }
        int computeFlags = computeFlags(layoutParams.flags);
        if (computeFlags != layoutParams.flags) {
            layoutParams.flags = computeFlags;
        }
        this.windowManager.updateViewLayout(this.contentView, layoutParams);
    }

    public void dismiss() {
        if (this.isShowing) {
            if (this.contentView.isAttachedToWindow()) {
                this.windowManager.removeViewImmediate(this.contentView);
            }
            this.isShowing = false;
        }
    }

    private WindowManager.LayoutParams createPopupLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 8388659;
        layoutParams.flags = computeFlags(layoutParams.flags);
        layoutParams.type = 2;
        layoutParams.token = null;
        layoutParams.softInputMode = 1;
        layoutParams.windowAnimations = 0;
        layoutParams.format = -3;
        layoutParams.width = this.width;
        layoutParams.height = this.height;
        return layoutParams;
    }

    private int computeFlags(int i) {
        int i2 = i & (-8815129);
        if (this.ignoreCheekPress) {
            i2 |= 32768;
        }
        if (!this.isFocusable) {
            i2 |= 8;
        }
        if (!this.isTouchable) {
            i2 |= 16;
        }
        if (this.isOutsideTouchable) {
            i2 |= 262144;
        }
        if (!this.isClippingEnabled) {
            i2 |= 512;
        }
        if (this.splitTouchEnabled) {
            i2 |= 8388608;
        }
        if (this.layoutInScreen) {
            i2 |= 256;
        }
        return this.isNotTouchModal ? i2 | 32 : i2;
    }

    private void invokePopup(WindowManager.LayoutParams layoutParams) {
        Context context = this.context;
        if (context != null) {
            layoutParams.packageName = context.getPackageName();
        }
        this.windowManager.addView(this.contentView, layoutParams);
    }
}
