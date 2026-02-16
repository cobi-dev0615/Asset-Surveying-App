package com.devexpress.dxcharts;

import android.graphics.Canvas;
import android.graphics.Rect;

/* compiled from: OverlayContainer.java */
/* loaded from: classes.dex */
abstract class OverlayContainerBase extends ChartElement implements OverlayDrawableInterface {
    private HintContainer hintContainer;
    private OverlayInfo[] mItemInfos;

    public abstract boolean canDraw();

    public abstract void draw(Canvas canvas, ContextProvider contextProvider);

    abstract void hide();

    abstract void updateOverlay(OverlayInfo[] overlayInfoArr, HintInfo hintInfo, Rect rect, boolean z);

    public OverlayContainerBase(HintContainer hintContainer) {
        this.hintContainer = hintContainer;
    }

    OverlayInfo[] getItemInfos() {
        return this.mItemInfos;
    }

    void setItemInfos(OverlayInfo[] overlayInfoArr) {
        this.mItemInfos = overlayInfoArr;
    }

    HintContainer getHintContainer() {
        return this.hintContainer;
    }

    HintBase getActualHint() {
        return getHintContainer().getActualHint();
    }
}
