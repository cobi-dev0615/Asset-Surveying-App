package com.devexpress.dxcharts;

import android.os.Handler;
import android.os.Looper;
import java.util.Calendar;

/* loaded from: classes.dex */
class AnimationTimer implements Runnable {
    private double mStartTime;
    private final Handler timerHandler = new Handler(Looper.getMainLooper());
    private boolean mIsRunning = false;
    private NativeObjectWrapper mTimerNative = new NativeObjectWrapper(nativeCreateAnimationTimer());

    native long nativeCreateAnimationTimer();

    native void nativeOnTick(long j, double d);

    AnimationTimer() {
    }

    public double start() {
        Calendar calendar = Calendar.getInstance();
        if (!this.mIsRunning) {
            this.timerHandler.postDelayed(this, 0L);
            this.mStartTime = calendar.getTime().getTime() / 1000.0d;
        }
        this.mIsRunning = true;
        return (calendar.getTime().getTime() / 1000.0d) - this.mStartTime;
    }

    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.timerHandler.removeCallbacks(this);
        }
    }

    public long getNativeTimer() {
        return this.mTimerNative.getObject();
    }

    @Override // java.lang.Runnable
    public void run() {
        Calendar calendar = Calendar.getInstance();
        synchronized (ChartBase.syncObject) {
            nativeOnTick(this.mTimerNative.getObject(), (calendar.getTime().getTime() / 1000.0d) - this.mStartTime);
        }
        if (this.mIsRunning) {
            this.timerHandler.postDelayed(this, 20L);
        }
    }
}
