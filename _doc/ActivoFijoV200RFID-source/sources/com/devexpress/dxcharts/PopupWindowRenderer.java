package com.devexpress.dxcharts;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.PopupWindow;

/* compiled from: OverlayInfo.java */
/* loaded from: classes.dex */
class PopupWindowRenderer {
    private ContextProvider mContext;
    private CrosshairRenderer mCrosshairRenderer;
    private boolean mHintIsShown = false;
    private Rect mLayoutRect;
    private OverlayInfo mOverlayInfo;
    private HintContainer mOwner;
    private PopupWindow mPopUpWindow;
    private int mScreenDensity;

    PopupWindowRenderer(ContextProvider contextProvider, HintContainer hintContainer) {
        this.mContext = contextProvider;
        this.mOwner = hintContainer;
        this.mCrosshairRenderer = new CrosshairRenderer(hintContainer, contextProvider);
        this.mScreenDensity = Math.round(contextProvider.getResources().getDisplayMetrics().density);
        View view = new View(this.mContext.getContext()) { // from class: com.devexpress.dxcharts.PopupWindowRenderer.1
            @Override // android.view.View
            public void draw(Canvas canvas) {
                super.draw(canvas);
                if (PopupWindowRenderer.this.mOverlayInfo == null || !PopupWindowRenderer.this.mHintIsShown) {
                    return;
                }
                canvas.save();
                PointF anchorPoint = PopupWindowRenderer.this.mOverlayInfo.getAnchorPoint();
                canvas.translate(PopupWindowRenderer.this.mScreenDensity - anchorPoint.x, PopupWindowRenderer.this.mScreenDensity - anchorPoint.y);
                PopupWindowRenderer.this.mCrosshairRenderer.draw(canvas, PopupWindowRenderer.this.mContext, PopupWindowRenderer.this.mOverlayInfo);
                canvas.restore();
            }
        };
        view.setWillNotDraw(false);
        PopupWindow popupWindow = new PopupWindow(this.mContext.getContext());
        this.mPopUpWindow = popupWindow;
        popupWindow.setFocusable(false);
        this.mPopUpWindow.setContentView(view);
        this.mPopUpWindow.setBackgroundDrawable(new ColorDrawable(0));
        this.mPopUpWindow.setOutsideTouchable(true);
    }

    void show(OverlayInfo overlayInfo) {
        synchronized (this) {
            this.mOverlayInfo = overlayInfo;
            ChartBase ownerChart = this.mOwner.getOwnerChart();
            if (ownerChart.getVisibility() == 0) {
                PointF anchorPoint = overlayInfo.getAnchorPoint();
                int tailPosition = overlayInfo.getTailPosition();
                Rect tailRect = this.mOwner.getActualHint().getTailRect(this.mContext);
                int leftOffsetForTail = CrosshairRenderer.getLeftOffsetForTail(tailPosition, tailRect);
                int topOffsetForTail = CrosshairRenderer.getTopOffsetForTail(tailPosition, tailRect);
                Point point = new Point((int) ((anchorPoint.x - leftOffsetForTail) - this.mScreenDensity), (int) ((anchorPoint.y - topOffsetForTail) - this.mScreenDensity));
                this.mPopUpWindow.showAsDropDown(ownerChart, point.x, point.y);
                this.mPopUpWindow.update(ownerChart, point.x, point.y - ownerChart.getHeight(), this.mLayoutRect.width() + leftOffsetForTail + CrosshairRenderer.getRightOffsetForTail(tailPosition, tailRect) + (this.mScreenDensity * 2), this.mLayoutRect.height() + topOffsetForTail + CrosshairRenderer.getBottomOffsetForTail(tailPosition, tailRect) + (this.mScreenDensity * 2));
                this.mHintIsShown = true;
            }
        }
    }

    void hide() {
        try {
            if (this.mPopUpWindow.isShowing()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.devexpress.dxcharts.PopupWindowRenderer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PopupWindowRenderer.this.mPopUpWindow.dismiss();
                    }
                });
            }
            this.mHintIsShown = false;
        } catch (IllegalArgumentException unused) {
        }
    }

    boolean hintIsShown() {
        return this.mHintIsShown;
    }

    Rect measure(TooltipItem[] tooltipItemArr) {
        Rect measure = this.mCrosshairRenderer.measure(tooltipItemArr);
        this.mLayoutRect = measure;
        return measure;
    }
}
