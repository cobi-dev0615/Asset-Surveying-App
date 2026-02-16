package com.devexpress.dxcharts;

import android.graphics.Bitmap;
import android.view.View;
import com.devexpress.dxcharts.GLTextureView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
class GLRenderer implements GLTextureView.Renderer {
    private Bitmap currentImage;
    private InternalDrawingListener drawingListener;
    private int height;
    private NativeObjectWrapper nativeChart;
    private NativeObjectWrapper nativeTextRenderer;
    private Object syncObject;
    private ChartTextRenderer textRenderer;
    private int width;
    private NativeObjectWrapper nativeRenderer = null;
    private boolean needCreateBitmap = false;
    private Object lock = new Object();
    private boolean shouldResetRenderer = false;

    native long nativeCreateRenderer();

    native long nativeCreateTextRenderer(Object obj);

    native boolean nativeGetBitmap(long j, long j2, Object obj);

    native void nativeOnSurfaceChanged(long j, int i, int i2);

    native void nativeRenderChart(long j, long j2, long j3);

    native void nativeResetRenderer(long j, long j2);

    GLRenderer(ContextProvider contextProvider, Object obj, NativeObjectWrapper nativeObjectWrapper, TextStyleProviderInterface textStyleProviderInterface, View view) {
        init(contextProvider, obj, nativeObjectWrapper, textStyleProviderInterface, view);
    }

    private void init(ContextProvider contextProvider, Object obj, NativeObjectWrapper nativeObjectWrapper, TextStyleProviderInterface textStyleProviderInterface, View view) {
        this.syncObject = obj;
        this.nativeChart = nativeObjectWrapper;
        ChartTextRenderer chartTextRenderer = new ChartTextRenderer(contextProvider, textStyleProviderInterface);
        this.textRenderer = chartTextRenderer;
        this.nativeTextRenderer = new NativeObjectWrapper(nativeCreateTextRenderer(chartTextRenderer));
        this.drawingListener = new InternalDrawingListener(view, obj);
    }

    public Boolean isReady() {
        return Boolean.valueOf(this.nativeRenderer != null);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        reset();
        this.nativeRenderer = new NativeObjectWrapper(nativeCreateRenderer());
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.width = i;
        this.height = i2;
        nativeOnSurfaceChanged(this.nativeRenderer.getObject(), i, i2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        synchronized (this.syncObject) {
            if (this.shouldResetRenderer) {
                nativeResetRenderer(this.nativeChart.getObject(), this.nativeRenderer.getObject());
                this.shouldResetRenderer = false;
            } else {
                nativeRenderChart(this.nativeChart.getObject(), this.nativeRenderer.getObject(), this.nativeTextRenderer.getObject());
                synchronized (this.lock) {
                    if (this.needCreateBitmap) {
                        this.currentImage = createBitmapFromGL();
                        this.needCreateBitmap = false;
                        this.lock.notifyAll();
                    }
                }
            }
            this.syncObject.notifyAll();
        }
        notifyFinishDrawing();
    }

    @Override // com.devexpress.dxcharts.GLTextureView.Renderer
    public Bitmap drawFrameToBitmap(ChartViewHolder chartViewHolder) {
        synchronized (this.lock) {
            this.needCreateBitmap = true;
            chartViewHolder.requestRender();
        }
        return this.currentImage;
    }

    private Bitmap createBitmapFromGL() {
        Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
        nativeGetBitmap(this.nativeChart.getObject(), this.nativeRenderer.getObject(), createBitmap);
        return createBitmap;
    }

    public Bitmap createBitmap(int i, int i2) {
        return this.textRenderer.createBitmap(i, i2);
    }

    public void updateOverlay(Object[] objArr, long[] jArr, float[] fArr) {
        this.textRenderer.updateOverlay(objArr, jArr, fArr);
    }

    void resetCurrentImage() {
        Bitmap bitmap = this.currentImage;
        if (bitmap != null) {
            bitmap.recycle();
            this.currentImage = null;
        }
    }

    void setShouldResetRenderer() {
        this.shouldResetRenderer = true;
    }

    void setDrawingListener(DrawingListener drawingListener) {
        this.drawingListener.setUserDrawingListener(drawingListener);
    }

    void notifyStartDrawing() {
        this.drawingListener.onDrawingStarted();
    }

    private void notifyFinishDrawing() {
        this.drawingListener.onDrawingFinished();
    }

    @Override // com.devexpress.dxcharts.GLTextureView.Renderer
    public void reset() {
        if (this.nativeRenderer != null) {
            nativeResetRenderer(this.nativeChart.getObject(), this.nativeRenderer.getObject());
            this.nativeRenderer = null;
        }
    }

    Size getSize() {
        return new Size(this.width, this.height);
    }
}
