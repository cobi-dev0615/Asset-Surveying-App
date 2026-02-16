package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public enum RenderMode {
    SURFACE,
    TEXTURE;

    static RenderMode parse(int i) {
        if (i != 1) {
            return SURFACE;
        }
        return TEXTURE;
    }
}
