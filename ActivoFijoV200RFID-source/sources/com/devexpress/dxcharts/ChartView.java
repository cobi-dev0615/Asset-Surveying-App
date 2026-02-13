package com.devexpress.dxcharts;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import android.view.View;

/* loaded from: classes.dex */
class ChartView extends GLSurfaceView implements ChartViewHolder {
    private GLRenderer renderer;
    private Object syncObject;

    @Override // com.devexpress.dxcharts.ChartViewHolder
    public boolean canFixFlicker() {
        return false;
    }

    @Override // com.devexpress.dxcharts.ChartViewHolder
    public View getView() {
        return this;
    }

    public ChartView(Context context, Object obj) {
        super(context);
        this.syncObject = obj;
    }

    @Override // com.devexpress.dxcharts.ChartViewHolder
    public void setRenderer(GLRenderer gLRenderer) {
        this.renderer = gLRenderer;
        setWillNotDraw(false);
        setEGLContextClientVersion(2);
        setEGLConfigChooser(new EglConfigChooser());
        super.setRenderer((GLSurfaceView.Renderer) gLRenderer);
        setRenderMode(0);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        resetRenderer();
        super.surfaceDestroyed(surfaceHolder);
    }

    private void resetRenderer() {
        synchronized (ChartBase.syncObject) {
            this.renderer.setShouldResetRenderer();
            requestRender();
            try {
                this.syncObject.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
