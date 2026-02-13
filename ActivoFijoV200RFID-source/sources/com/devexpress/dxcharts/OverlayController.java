package com.devexpress.dxcharts;

import android.graphics.Rect;

/* loaded from: classes.dex */
class OverlayController {
    private HintContainer mHintContainer;
    private OverlayContainerBase overlayContainer;
    private OverlayContainerBase overlayLineContainer;

    OverlayController(ContextProvider contextProvider, ChartBase chartBase, NotifyPropertyChanged notifyPropertyChanged) {
        HintContainer hintContainer = new HintContainer(contextProvider, chartBase);
        this.mHintContainer = hintContainer;
        hintContainer.addListener(notifyPropertyChanged);
        OverlayContainer overlayContainer = new OverlayContainer(this.mHintContainer);
        this.overlayContainer = overlayContainer;
        overlayContainer.addListener(notifyPropertyChanged);
        OverlayLineContainer overlayLineContainer = new OverlayLineContainer(this.mHintContainer);
        this.overlayLineContainer = overlayLineContainer;
        overlayLineContainer.addListener(notifyPropertyChanged);
    }

    OverlayContainerBase getOverlayContainer() {
        return this.overlayContainer;
    }

    OverlayContainerBase getOverlayLineContainer() {
        return this.overlayLineContainer;
    }

    HintContainer getHintContainer() {
        return this.mHintContainer;
    }

    HintBase getHint() {
        return this.mHintContainer.getHint();
    }

    void setHint(HintBase hintBase) {
        this.mHintContainer.setHint(hintBase);
    }

    void setHintListener(HintListener hintListener) {
        this.mHintContainer.setHintListener(hintListener);
    }

    HintBase getActualHint() {
        return this.mHintContainer.getActualHint();
    }

    boolean canUpdateOverlay() {
        return this.mHintContainer.isHintEnabled() || this.mHintContainer.hintIsShown();
    }

    void applyTheme(ContextProvider contextProvider) {
        this.mHintContainer.applyTheme(contextProvider);
    }

    void updateOverlay(OverlayInfo[] overlayInfoArr, HintInfo hintInfo, Rect rect, boolean z) {
        this.overlayLineContainer.updateOverlay(overlayInfoArr, hintInfo, rect, z);
        this.overlayContainer.updateOverlay(overlayInfoArr, hintInfo, rect, z);
    }

    void hide() {
        this.overlayLineContainer.hide();
        this.overlayContainer.hide();
        this.mHintContainer.hide(false);
    }
}
