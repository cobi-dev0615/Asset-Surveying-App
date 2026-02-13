package com.devexpress.dxcharts;

import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;

/* compiled from: ChartGLSurfaceViewNew.java */
/* loaded from: classes.dex */
class ChartDrawThread extends Thread {
    private EglHelperNew eglHelper;
    private int height;
    private GLSurfaceView.Renderer renderer;
    private SurfaceHolder surfaceGLHolder;
    private int width;
    private boolean isRunning = false;
    private boolean sizeChanged = false;
    private boolean requestRender = false;

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public ChartDrawThread(SurfaceHolder surfaceHolder, GLSurfaceView.Renderer renderer) {
        this.surfaceGLHolder = surfaceHolder;
        this.renderer = renderer;
    }

    public void setRunning(boolean z) {
        this.isRunning = z;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        EglHelperNew eglHelperNew = new EglHelperNew(this.surfaceGLHolder);
        this.eglHelper = eglHelperNew;
        eglHelperNew.start();
        this.renderer.onSurfaceCreated(null, null);
        int i = 0;
        int i2 = 0;
        while (this.isRunning) {
            synchronized (this) {
                z = this.sizeChanged;
                if (z) {
                    i = this.width;
                    i2 = this.height;
                    this.sizeChanged = false;
                }
                z2 = this.requestRender && i > 0 && i2 > 0;
                this.requestRender = false;
            }
            if (z) {
                this.eglHelper.createSurface();
                this.renderer.onSurfaceChanged(null, i, i2);
            }
            if (z2) {
                this.renderer.onDrawFrame(null);
                this.eglHelper.swap();
            }
        }
    }

    public void onWindowResize(int i, int i2) {
        synchronized (this) {
            this.width = i;
            this.height = i2;
            this.sizeChanged = true;
            this.requestRender = true;
        }
    }

    public void requestRender() {
        synchronized (this) {
            this.requestRender = true;
        }
    }
}
