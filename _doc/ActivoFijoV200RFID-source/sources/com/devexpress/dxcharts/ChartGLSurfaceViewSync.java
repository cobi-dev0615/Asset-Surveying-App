package com.devexpress.dxcharts;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* compiled from: ChartGLSurfaceViewNew.java */
/* loaded from: classes.dex */
class ChartGLSurfaceViewSync extends SurfaceView implements SurfaceHolder.Callback {
    private EglHelperNew eglHelper;
    private int height;
    private GLSurfaceView.Renderer renderer;
    private SurfaceHolder surfaceHolder;
    private int width;

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public ChartGLSurfaceViewSync(Context context) {
        super(context);
        init();
    }

    public ChartGLSurfaceViewSync(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ChartGLSurfaceViewSync(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    void init() {
        SurfaceHolder holder = getHolder();
        this.surfaceHolder = holder;
        holder.addCallback(this);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        synchronized (this) {
            this.renderer = renderer;
            EglHelperNew eglHelperNew = new EglHelperNew(this.surfaceHolder);
            this.eglHelper = eglHelperNew;
            eglHelperNew.start();
            renderer.onSurfaceCreated(null, null);
        }
    }

    public void requestRender() {
        synchronized (this) {
            render();
        }
    }

    void render() {
        if (this.width <= 0 || this.height <= 0) {
            return;
        }
        this.renderer.onDrawFrame(null);
        this.eglHelper.swap();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        synchronized (this) {
            this.renderer.onSurfaceCreated(null, null);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        synchronized (this) {
            this.width = i2;
            this.height = i3;
            if (i2 > 0 && i3 > 0) {
                this.eglHelper.createSurface();
                this.renderer.onSurfaceChanged(null, i2, i3);
                render();
            }
        }
    }
}
