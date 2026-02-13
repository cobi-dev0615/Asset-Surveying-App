package com.devexpress.dxcharts;

import android.view.SurfaceHolder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: ChartGLSurfaceViewNew.java */
/* loaded from: classes.dex */
class EglHelperNew {
    private EGL10 egl;
    private EGLConfig eglConfig;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;
    private SurfaceHolder surfaceHolder;

    public EglHelperNew(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
    }

    public void start() {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.egl = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.eglDisplay = eglGetDisplay;
        if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("eglGetDisplay failed");
        }
        if (!this.egl.eglInitialize(this.eglDisplay, new int[2])) {
            throw new RuntimeException("eglInitialize failed");
        }
        EGLConfig chooseConfig = chooseConfig(this.egl, this.eglDisplay);
        this.eglConfig = chooseConfig;
        EGLContext createContext = createContext(this.egl, this.eglDisplay, chooseConfig);
        this.eglContext = createContext;
        if (createContext == null || createContext == EGL10.EGL_NO_CONTEXT) {
            this.eglContext = null;
            throwEglException("createContext");
        }
        this.eglSurface = null;
    }

    boolean createSurface() {
        if (this.egl == null) {
            throw new RuntimeException("egl not initialized");
        }
        if (this.eglDisplay == null) {
            throw new RuntimeException("eglDisplay not initialized");
        }
        if (this.eglConfig == null) {
            throw new RuntimeException("mEglConfig not initialized");
        }
        destroySurfaceImp();
        EGLSurface createWindowSurface = createWindowSurface(this.egl, this.eglDisplay, this.eglConfig, this.surfaceHolder);
        this.eglSurface = createWindowSurface;
        if (createWindowSurface == null || createWindowSurface == EGL10.EGL_NO_SURFACE) {
            return false;
        }
        EGL10 egl10 = this.egl;
        EGLDisplay eGLDisplay = this.eglDisplay;
        EGLSurface eGLSurface = this.eglSurface;
        return egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext);
    }

    int swap() {
        if (this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface)) {
            return 12288;
        }
        return this.egl.eglGetError();
    }

    public void destroySurface() {
        destroySurfaceImp();
    }

    public void finish() {
        EGLContext eGLContext = this.eglContext;
        if (eGLContext != null) {
            destroyContextImp(this.egl, this.eglDisplay, eGLContext);
            this.eglContext = null;
        }
        EGLDisplay eGLDisplay = this.eglDisplay;
        if (eGLDisplay != null) {
            this.egl.eglTerminate(eGLDisplay);
            this.eglDisplay = null;
        }
    }

    private EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 0, 12344};
        int[] iArr2 = new int[1];
        if (!egl10.eglChooseConfig(eGLDisplay, iArr, null, 0, iArr2)) {
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
        int i = iArr2[0];
        if (i <= 0) {
            throw new IllegalArgumentException("No configs match configSpec");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[i];
        if (!egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2)) {
            throw new IllegalArgumentException("eglChooseConfig#2 failed");
        }
        EGLConfig chooseConfigCore = chooseConfigCore(egl10, eGLDisplay, eGLConfigArr);
        if (chooseConfigCore != null) {
            return chooseConfigCore;
        }
        throw new IllegalArgumentException("No config chosen");
    }

    private void destroySurfaceImp() {
        EGLSurface eGLSurface = this.eglSurface;
        if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
            return;
        }
        this.egl.eglMakeCurrent(this.eglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        destroySurfaceCore(this.egl, this.eglDisplay, this.eglSurface);
        this.eglSurface = null;
    }

    private void destroyContextImp(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
            return;
        }
        throwEglException("eglDestroyContex");
    }

    private void destroySurfaceCore(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        egl10.eglDestroySurface(eGLDisplay, eGLSurface);
    }

    private EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
        try {
            return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
    }

    private EGLConfig chooseConfigCore(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        for (EGLConfig eGLConfig : eGLConfigArr) {
            int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
            int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
            if (findConfigAttrib >= 16 && findConfigAttrib2 >= 0) {
                int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
                int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12323, 0);
                int findConfigAttrib5 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
                int findConfigAttrib6 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
                if (findConfigAttrib3 == 8 && findConfigAttrib4 == 8 && findConfigAttrib5 == 8 && findConfigAttrib6 == 8) {
                    return eGLConfig;
                }
            }
        }
        return null;
    }

    private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        int[] iArr = new int[1];
        return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr) ? iArr[0] : i2;
    }

    private void throwEglException(String str) {
        throw new RuntimeException(str + " failed: " + this.egl.eglGetError());
    }
}
