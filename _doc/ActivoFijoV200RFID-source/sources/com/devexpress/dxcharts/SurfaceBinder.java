package com.devexpress.dxcharts;

import android.content.Context;
import android.os.Handler;
import android.view.SurfaceHolder;

/* loaded from: classes.dex */
class SurfaceBinder implements SurfaceHolder.Callback {
    private Context ctx;
    private Object obj;

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public SurfaceBinder(Object obj, Context context) {
        this.obj = obj;
        this.ctx = context;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        delayedUnbind();
    }

    void setObject(Object obj) {
        this.obj = obj;
    }

    private void delayedUnbind() {
        new Handler(this.ctx.getMainLooper()).postDelayed(new Runnable() { // from class: com.devexpress.dxcharts.SurfaceBinder.1
            @Override // java.lang.Runnable
            public void run() {
                this.setObject(null);
            }
        }, 300L);
    }
}
