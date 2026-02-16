package com.devexpress.dxcharts;

import android.graphics.Canvas;

/* compiled from: OverlayView.java */
/* loaded from: classes.dex */
interface OverlayDrawableInterface {
    boolean canDraw();

    void draw(Canvas canvas, ContextProvider contextProvider);
}
