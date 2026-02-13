package com.devexpress.dxcharts;

import android.util.Log;

/* loaded from: classes.dex */
class Stopwatch {
    private long begin;
    private long end;
    private String name;
    private boolean started;

    public Stopwatch(String str) {
        this.name = str;
        start();
    }

    public void start() {
        if (this.started) {
            return;
        }
        this.begin = System.currentTimeMillis();
        this.started = true;
    }

    public int getDelta() {
        if (this.started) {
            return -1;
        }
        return (int) (this.end - this.begin);
    }

    public void stop(boolean z) {
        if (this.started) {
            this.end = System.currentTimeMillis();
            this.started = false;
        }
        if (z) {
            Log.d("DX", String.format("EXECUTION TIME: %s - %d ms", this.name, Integer.valueOf(getDelta())));
        }
    }

    public void stop() {
        stop(true);
    }
}
