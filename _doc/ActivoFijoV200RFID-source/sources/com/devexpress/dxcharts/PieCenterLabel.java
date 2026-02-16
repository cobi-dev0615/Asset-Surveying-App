package com.devexpress.dxcharts;

import android.graphics.Canvas;
import android.graphics.Rect;

/* loaded from: classes.dex */
public abstract class PieCenterLabel extends StyledElement {
    protected abstract void draw(Canvas canvas, Rect rect, Rect rect2, PieSeries pieSeries);

    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(new StyleBase() { // from class: com.devexpress.dxcharts.PieCenterLabel.1
        }.getClass());
    }

    protected void invalidate() {
        notifyListeners(null);
    }
}
