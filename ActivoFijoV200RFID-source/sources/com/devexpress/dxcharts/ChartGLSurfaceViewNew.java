package com.devexpress.dxcharts;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* loaded from: classes.dex */
class ChartGLSurfaceViewNew extends SurfaceView implements SurfaceHolder.Callback {
    private ChartDrawThread drawThread;
    private GLSurfaceView.Renderer renderer;

    public ChartGLSurfaceViewNew(Context context) {
        super(context);
        init();
    }

    public ChartGLSurfaceViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ChartGLSurfaceViewNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    void init() {
        getHolder().addCallback(this);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        ChartDrawThread chartDrawThread = new ChartDrawThread(getHolder(), renderer);
        this.drawThread = chartDrawThread;
        chartDrawThread.setRunning(true);
        this.drawThread.start();
    }

    public void requestRender() {
        ChartDrawThread chartDrawThread = this.drawThread;
        if (chartDrawThread != null) {
            chartDrawThread.requestRender();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.drawThread.surfaceCreated(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.drawThread.onWindowResize(i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.drawThread.setRunning(false);
        boolean z = true;
        while (z) {
            try {
                this.drawThread.join();
                z = false;
            } catch (InterruptedException unused) {
            }
        }
    }
}
