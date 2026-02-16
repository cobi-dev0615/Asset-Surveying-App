package com.devexpress.dxcharts;

/* compiled from: Chart.java */
/* loaded from: classes.dex */
class NativeObjectWrapper {
    private long _pObject;

    native boolean nativeCompareObjects(long j, long j2);

    native void nativeDeleteObject(long j);

    NativeObjectWrapper(long j) {
        this._pObject = j;
    }

    protected void finalize() throws Throwable {
        try {
            nativeDeleteObject(this._pObject);
        } finally {
            super.finalize();
        }
    }

    long getObject() {
        return this._pObject;
    }

    boolean compare(long j) {
        return nativeCompareObjects(this._pObject, j);
    }
}
