package com.microsoft.maui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/* loaded from: classes3.dex */
public interface PlatformShadowDrawable {
    boolean canDrawShadow();

    void drawShadow(Canvas canvas, Paint paint, Path path);
}
