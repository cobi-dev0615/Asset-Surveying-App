package com.devexpress.dxcharts;

import android.os.Looper;
import android.view.View;

/* compiled from: DrawingListener.java */
/* loaded from: classes.dex */
class InternalDrawingListener implements DrawingListener {
    private Object drawingListenerLocker = new Object();
    private View owner;
    private Object syncObject;
    private DrawingListener userListener;

    InternalDrawingListener(View view, Object obj) {
        this.owner = view;
        this.syncObject = obj;
    }

    @Override // com.devexpress.dxcharts.DrawingListener
    public void onDrawingStarted() {
        synchronized (this.syncObject) {
            if (this.userListener == null) {
                return;
            }
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                Runnable runnable = new Runnable() { // from class: com.devexpress.dxcharts.InternalDrawingListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (InternalDrawingListener.this.drawingListenerLocker) {
                            InternalDrawingListener.this.userListener.onDrawingStarted();
                            InternalDrawingListener.this.drawingListenerLocker.notifyAll();
                        }
                    }
                };
                synchronized (this.syncObject) {
                    synchronized (this.drawingListenerLocker) {
                        this.owner.post(runnable);
                        try {
                            this.drawingListenerLocker.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return;
            }
            synchronized (this.drawingListenerLocker) {
                this.userListener.onDrawingStarted();
            }
        }
    }

    @Override // com.devexpress.dxcharts.DrawingListener
    public void onDrawingFinished() {
        synchronized (this.syncObject) {
            if (this.userListener != null) {
                this.owner.post(new Runnable() { // from class: com.devexpress.dxcharts.InternalDrawingListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        InternalDrawingListener.this.userListener.onDrawingFinished();
                    }
                });
            }
        }
    }

    void setUserDrawingListener(DrawingListener drawingListener) {
        synchronized (this.syncObject) {
            this.userListener = drawingListener;
        }
    }
}
