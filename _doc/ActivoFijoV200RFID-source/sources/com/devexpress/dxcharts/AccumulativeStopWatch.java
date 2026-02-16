package com.devexpress.dxcharts;

import android.util.Log;

/* loaded from: classes.dex */
class AccumulativeStopWatch {
    private long begin;
    private int count;
    private long end;
    private String name;
    private boolean started;
    private long total;

    public AccumulativeStopWatch(String str) {
        this.name = str;
    }

    public void start() {
        if (this.started) {
            return;
        }
        this.begin = System.nanoTime();
        this.started = true;
    }

    public long getDelta() {
        if (this.started) {
            return -1L;
        }
        return this.end - this.begin;
    }

    public void stop() {
        if (this.started) {
            this.end = System.nanoTime();
            this.started = false;
            this.total += getDelta();
            this.count++;
        }
    }

    public int getCount() {
        return this.count;
    }

    public int getTotalMs() {
        return (int) (this.total / 1000000);
    }

    public void log() {
        Log.d("DX", String.format("EXECUTION TIME: %s - %d ms", this.name, Integer.valueOf(getTotalMs())));
    }
}
