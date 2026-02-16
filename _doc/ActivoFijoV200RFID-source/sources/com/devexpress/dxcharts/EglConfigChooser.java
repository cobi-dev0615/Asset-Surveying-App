package com.devexpress.dxcharts;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* loaded from: classes.dex */
class EglConfigChooser implements GLSurfaceView.EGLConfigChooser {
    int[] mSimpleConfigSpec = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 0, 12344};

    EglConfigChooser() {
    }

    @Override // android.opengl.GLSurfaceView.EGLConfigChooser
    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr;
        int i;
        int[] iArr2 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12338, 1, 12337, 4, 12326, 0, 12352, 4, 12344};
        int[] iArr3 = new int[1];
        boolean eglChooseConfig = egl10.eglChooseConfig(eGLDisplay, iArr2, null, 0, iArr3);
        if (!eglChooseConfig) {
            iArr2 = this.mSimpleConfigSpec;
            if (!egl10.eglChooseConfig(eGLDisplay, iArr2, null, 0, iArr3)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
        }
        int i2 = iArr3[0];
        if (i2 <= 0) {
            if (eglChooseConfig) {
                iArr2 = this.mSimpleConfigSpec;
                if (!egl10.eglChooseConfig(eGLDisplay, iArr2, null, 0, iArr3)) {
                    throw new IllegalArgumentException("eglChooseConfig failed");
                }
            }
            int i3 = iArr3[0];
            if (i3 <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            iArr = iArr2;
            i = i3;
        } else {
            iArr = iArr2;
            i = i2;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[i];
        if (!egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr3)) {
            throw new IllegalArgumentException("eglChooseConfig#2 failed");
        }
        EGLConfig chooseConfigCore = chooseConfigCore(egl10, eGLDisplay, eGLConfigArr);
        if (chooseConfigCore != null) {
            return chooseConfigCore;
        }
        throw new IllegalArgumentException("No config chosen");
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
}
