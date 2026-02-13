package com.devexpress.dxcharts;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import androidx.camera.video.AudioStats;

/* compiled from: Chart.java */
/* loaded from: classes.dex */
class GestureScaleListener extends GestureListener implements ScaleGestureDetector.OnScaleGestureListener {
    private double interceptPositionX;
    private double interceptPositionY;
    private boolean isDown;
    private boolean isLongPress;
    private boolean isScrolling;
    private ScaleGestureDetector scaleGestureDetector;
    private VelocityTracker velocityTracker;

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public GestureScaleListener(Context context, Chart chart) {
        super(context, chart);
        this.isScrolling = false;
        this.isLongPress = false;
        this.isDown = false;
        this.scaleGestureDetector = new ScaleGestureDetector(context, this);
    }

    Chart getChart() {
        return (Chart) getChartBase();
    }

    @Override // com.devexpress.dxcharts.GestureListener, com.devexpress.dxcharts.OnTouchEventListener
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Chart chart = getChart();
        AxisNavigationMode axisYNavigationMode = chart.isRotated() ? chart.getAxisYNavigationMode() : chart.getAxisXNavigationMode();
        AxisNavigationMode axisXNavigationMode = chart.isRotated() ? chart.getAxisXNavigationMode() : chart.getAxisYNavigationMode();
        if (motionEvent.getPointerCount() != 1 && axisYNavigationMode == AxisNavigationMode.SCROLLING_AND_ZOOMING) {
            chart.requestDisallowInterceptTouchEvent(true);
            return true;
        }
        if (motionEvent.getPointerCount() != 1 && axisXNavigationMode == AxisNavigationMode.SCROLLING_AND_ZOOMING) {
            chart.requestDisallowInterceptTouchEvent(true);
            return true;
        }
        if (axisYNavigationMode != AxisNavigationMode.NONE) {
            double x = this.interceptPositionX - motionEvent.getX();
            MinMaxValues axisXVisualRange = chart.getAxisXVisualRange();
            MinMaxValues axisXWholeRange = chart.getAxisXWholeRange();
            double min = axisXVisualRange.getMin();
            double max = axisXVisualRange.getMax();
            double min2 = axisXWholeRange.getMin();
            double max2 = axisXWholeRange.getMax();
            this.interceptPositionX = motionEvent.getX();
            if ((min <= min2 || x <= AudioStats.AUDIO_AMPLITUDE_NONE) && ((max >= max2 || x >= AudioStats.AUDIO_AMPLITUDE_NONE) && (min <= min2 || max >= max2))) {
                return true;
            }
            chart.requestDisallowInterceptTouchEvent(true);
            return true;
        }
        if (axisXNavigationMode == AxisNavigationMode.NONE) {
            return false;
        }
        double y = this.interceptPositionY - motionEvent.getY();
        MinMaxValues axisYVisualRange = chart.getAxisYVisualRange();
        MinMaxValues axisYWholeRange = chart.getAxisYWholeRange();
        double min3 = axisYVisualRange.getMin();
        double max3 = axisYVisualRange.getMax();
        double min4 = axisYWholeRange.getMin();
        double max4 = axisYWholeRange.getMax();
        this.interceptPositionY = motionEvent.getY();
        if ((min3 <= min4 || y >= AudioStats.AUDIO_AMPLITUDE_NONE) && ((max3 >= max4 || y <= AudioStats.AUDIO_AMPLITUDE_NONE) && (min3 <= min4 || max3 >= max4))) {
            return true;
        }
        chart.requestDisallowInterceptTouchEvent(true);
        return true;
    }

    @Override // com.devexpress.dxcharts.GestureListener, com.devexpress.dxcharts.OnTouchEventListener
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            getChart().stopScrollingAnimation();
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            } else {
                velocityTracker.clear();
            }
            this.velocityTracker.addMovement(motionEvent);
        }
        if (motionEvent.getAction() == 2) {
            this.velocityTracker.addMovement(motionEvent);
            if (this.isLongPress) {
                getChart().longPress(motionEvent.getX(), motionEvent.getY());
            } else if (this.isDown) {
                this.isDown = getChart().down(motionEvent.getX(), motionEvent.getY());
            }
        }
        if (motionEvent.getAction() == 1) {
            getChart().stopScrollingAnimation();
            if (this.isScrolling) {
                this.isScrolling = false;
                this.velocityTracker.computeCurrentVelocity(1000);
                Chart chart = getChart();
                chart.processGestureEndAction((!chart.isRotated() ? chart.getAxisXNavigationMode() : chart.getAxisYNavigationMode()) == AxisNavigationMode.NONE ? 0.0f : this.velocityTracker.getXVelocity(), (!chart.isRotated() ? chart.getAxisYNavigationMode() : chart.getAxisXNavigationMode()) != AxisNavigationMode.NONE ? this.velocityTracker.getYVelocity() : 0.0f);
            }
            if (this.isLongPress) {
                this.isLongPress = false;
                getChart().longPressEnd();
            }
            if (this.isDown) {
                this.isDown = false;
                getChart().up();
            }
        }
        if (motionEvent.getAction() == 3) {
            this.velocityTracker.recycle();
            this.velocityTracker = null;
            if (this.isLongPress) {
                this.isLongPress = false;
                getChart().longPressEnd();
            }
            if (this.isDown) {
                this.isDown = false;
                getChart().up();
            }
        }
        if (this.isLongPress || this.isDown) {
            return true;
        }
        this.scaleGestureDetector.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.devexpress.dxcharts.GestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.isDown = getChart().down(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // com.devexpress.dxcharts.GestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.isLongPress = true;
        getChart().longPress(motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        Chart chart = getChart();
        boolean z = chart.getAxisXNavigationMode() == AxisNavigationMode.SCROLLING_AND_ZOOMING;
        boolean z2 = chart.getAxisYNavigationMode() == AxisNavigationMode.SCROLLING_AND_ZOOMING;
        if (chart.isRotated()) {
            boolean z3 = z2;
            z2 = z;
            z = z3;
        }
        if (!z && !z2) {
            return false;
        }
        Size size = chart.getSize();
        float scaleFactor = this.scaleGestureDetector.getScaleFactor();
        float currentSpanX = this.scaleGestureDetector.getCurrentSpanX();
        float currentSpanY = this.scaleGestureDetector.getCurrentSpanY();
        float f = z ? scaleFactor : 1.0f;
        if (!z2) {
            scaleFactor = 1.0f;
        }
        if (currentSpanX > currentSpanY) {
            scaleFactor = (((scaleFactor - 1.0f) * currentSpanY) / currentSpanX) + 1.0f;
        } else {
            f = (((f - 1.0f) * currentSpanX) / currentSpanY) + 1.0f;
        }
        chart.processGesturePinchAction(f, scaleFactor, z ? (size.getWidth() / 2.0f) - this.scaleGestureDetector.getFocusX() : 0.0f, z2 ? this.scaleGestureDetector.getFocusY() - (size.getHeight() / 2.0f) : 0.0f);
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        getChart().processGestureEndAction();
    }

    @Override // com.devexpress.dxcharts.GestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!this.isLongPress && !this.isDown) {
            Chart chart = getChart();
            AxisNavigationMode axisXNavigationMode = !chart.isRotated() ? chart.getAxisXNavigationMode() : chart.getAxisYNavigationMode();
            AxisNavigationMode axisYNavigationMode = !chart.isRotated() ? chart.getAxisYNavigationMode() : chart.getAxisXNavigationMode();
            if (axisXNavigationMode == AxisNavigationMode.NONE) {
                f = 0.0f;
            }
            if (axisYNavigationMode == AxisNavigationMode.NONE) {
                f2 = 0.0f;
            }
            if (f != 0.0f || f2 != 0.0f) {
                chart.processGesturePanAction(-f, f2);
                this.isScrolling = true;
            }
        }
        return true;
    }
}
