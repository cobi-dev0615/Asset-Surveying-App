package com.devexpress.dxcharts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
class ScrollIndicatorsContainer implements OverlayDrawableInterface {
    private Chart chart;
    private HideIndicatorTask hideIndicatorTask;
    private Timer hideIndicatorsTimer;
    private int indicatorWidth;
    private int minIndicatorWidth;
    private int opacity;
    private final int DEFAULT_INDICATOR_WIDTH_PX = 4;
    private final int DEFAULT_OPACITY = 102;
    private final int HIDE_INDICATOR_DELAY = 500;
    private boolean showHorIndicator = false;
    private boolean showVerIndicator = false;
    private boolean userEnable = true;
    private Rect layout = new Rect();

    @Override // com.devexpress.dxcharts.OverlayDrawableInterface
    public boolean canDraw() {
        return true;
    }

    private class HideIndicatorTask extends TimerTask {
        private final int CHANGE_OPACITY_DELAY;
        private final int CHANGE_OPACITY_PERIOD;
        private final int CHANGE_OPACITY_STEP;
        private Timer changeOpacityTimer;

        private HideIndicatorTask() {
            this.CHANGE_OPACITY_DELAY = 20;
            this.CHANGE_OPACITY_PERIOD = 20;
            this.CHANGE_OPACITY_STEP = 10;
            this.changeOpacityTimer = null;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ScrollIndicatorsContainer.this.invalidateRender();
            Timer timer = new Timer();
            this.changeOpacityTimer = timer;
            timer.schedule(new TimerTask() { // from class: com.devexpress.dxcharts.ScrollIndicatorsContainer.HideIndicatorTask.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    ScrollIndicatorsContainer.access$120(ScrollIndicatorsContainer.this, 10);
                    if (ScrollIndicatorsContainer.this.opacity > 0) {
                        ScrollIndicatorsContainer.this.invalidateRender();
                    } else {
                        ScrollIndicatorsContainer.this.setShowIndicators(false, false);
                        cancel();
                    }
                }
            }, 20L, 20L);
        }

        @Override // java.util.TimerTask
        public boolean cancel() {
            Timer timer = this.changeOpacityTimer;
            if (timer != null) {
                timer.cancel();
                this.changeOpacityTimer = null;
            }
            return super.cancel();
        }
    }

    static /* synthetic */ int access$120(ScrollIndicatorsContainer scrollIndicatorsContainer, int i) {
        int i2 = scrollIndicatorsContainer.opacity - i;
        scrollIndicatorsContainer.opacity = i2;
        return i2;
    }

    ScrollIndicatorsContainer(Context context, Chart chart) {
        this.chart = chart;
        int i = (int) context.getResources().getDisplayMetrics().density;
        this.indicatorWidth = i * 4;
        this.minIndicatorWidth = i * 8;
    }

    @Override // com.devexpress.dxcharts.OverlayDrawableInterface
    public void draw(Canvas canvas, ContextProvider contextProvider) {
        RectF rectF;
        RectF rectF2;
        synchronized (this) {
            this.layout = this.chart.getPaneRect();
            boolean nativeGetRotated = this.chart.nativeGetRotated();
            float height = nativeGetRotated ? this.layout.height() : this.layout.width();
            float width = nativeGetRotated ? this.layout.width() : this.layout.height();
            float f = 0.0f;
            if (height > 0.0f && width > 0.0f && ((this.showHorIndicator || this.showVerIndicator) && this.userEnable)) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                int colorOrDefault = ResourceHelper.getColorOrDefault(contextProvider, R.attr.dxScrollIndicatorColor);
                paint.setColor(Color.argb(this.opacity, Color.red(colorOrDefault), Color.green(colorOrDefault), Color.blue(colorOrDefault)));
                if (this.showHorIndicator) {
                    MinMaxValues axisYWholeRange = nativeGetRotated ? this.chart.getAxisYWholeRange() : this.chart.getAxisXWholeRange();
                    MinMaxValues axisYVisualRange = nativeGetRotated ? this.chart.getAxisYVisualRange() : this.chart.getAxisXVisualRange();
                    float min = (float) (((height - this.indicatorWidth) * (axisYVisualRange.getMin() - axisYWholeRange.getMin())) / (axisYWholeRange.getMax() - axisYWholeRange.getMin()));
                    float max = (float) ((height - this.indicatorWidth) * ((axisYVisualRange.getMax() - axisYVisualRange.getMin()) / (axisYWholeRange.getMax() - axisYWholeRange.getMin())));
                    if (min < 0.0f) {
                        max += min;
                        min = 0.0f;
                    }
                    float f2 = min + max;
                    int i = this.indicatorWidth;
                    if (f2 > height - i) {
                        max -= f2 - (height - i);
                    }
                    float max2 = Math.max(max, this.minIndicatorWidth);
                    float min2 = Math.min(min, (height - max2) - this.indicatorWidth);
                    if (nativeGetRotated) {
                        rectF2 = new RectF(this.layout.left, this.layout.top + min2, this.layout.left + this.indicatorWidth, this.layout.top + min2 + max2);
                    } else {
                        rectF2 = new RectF(this.layout.left + min2 + this.indicatorWidth, this.layout.bottom - this.indicatorWidth, this.layout.left + min2 + max2, this.layout.bottom);
                    }
                    int i2 = this.indicatorWidth;
                    canvas.drawRoundRect(rectF2, i2, i2, paint);
                }
                if (this.showVerIndicator) {
                    MinMaxValues axisXWholeRange = nativeGetRotated ? this.chart.getAxisXWholeRange() : this.chart.getAxisYWholeRange();
                    MinMaxValues axisXVisualRange = nativeGetRotated ? this.chart.getAxisXVisualRange() : this.chart.getAxisYVisualRange();
                    float max3 = (float) (((width - this.indicatorWidth) * (axisXVisualRange.getMax() - axisXWholeRange.getMax())) / (axisXWholeRange.getMin() - axisXWholeRange.getMax()));
                    float max4 = (float) ((width - this.indicatorWidth) * ((axisXVisualRange.getMax() - axisXVisualRange.getMin()) / (axisXWholeRange.getMax() - axisXWholeRange.getMin())));
                    if (max3 < 0.0f) {
                        max4 += max3;
                    } else {
                        f = max3;
                    }
                    float f3 = f + max4;
                    int i3 = this.indicatorWidth;
                    if (f3 > width - i3) {
                        max4 -= f3 - (width - i3);
                    }
                    float max5 = Math.max(max4, this.minIndicatorWidth);
                    float min3 = Math.min(f, (width - max5) - this.indicatorWidth);
                    if (nativeGetRotated) {
                        rectF = new RectF(this.layout.left + min3 + this.indicatorWidth, this.layout.bottom - this.indicatorWidth, this.layout.left + min3 + max5, this.layout.bottom);
                    } else {
                        rectF = new RectF(this.layout.left, this.layout.top + min3, this.layout.left + this.indicatorWidth, this.layout.top + min3 + max5);
                    }
                    int i4 = this.indicatorWidth;
                    canvas.drawRoundRect(rectF, i4, i4, paint);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateRender() {
        this.chart.invalidateOverlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShowIndicators(boolean z, boolean z2) {
        this.showHorIndicator = z;
        this.showVerIndicator = z2;
    }

    void showIndicators() {
        setShowIndicators(this.chart.getAxisXNavigationMode() != AxisNavigationMode.NONE, this.chart.getAxisYNavigationMode() != AxisNavigationMode.NONE);
        this.opacity = 102;
        Timer timer = this.hideIndicatorsTimer;
        if (timer != null) {
            timer.cancel();
            this.hideIndicatorTask.cancel();
            this.hideIndicatorsTimer = null;
            this.hideIndicatorTask = null;
        }
    }

    void hideIndicators() {
        this.hideIndicatorsTimer = new Timer();
        HideIndicatorTask hideIndicatorTask = new HideIndicatorTask();
        this.hideIndicatorTask = hideIndicatorTask;
        this.hideIndicatorsTimer.schedule(hideIndicatorTask, 500L);
    }

    boolean isIndicatorsEnabled() {
        return this.userEnable;
    }

    void setIndicatorsEnabled(boolean z) {
        this.userEnable = z;
    }
}
