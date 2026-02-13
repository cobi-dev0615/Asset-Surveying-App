package com.devexpress.navigation.pagercontrol;

/* loaded from: classes2.dex */
public class PagePositionProvider implements IPagePositionProvider {
    private int changedPagePosition = -1;

    public void setChangedPagePosition(int i) {
        this.changedPagePosition = i;
    }

    public void reset() {
        this.changedPagePosition = -1;
    }

    @Override // com.devexpress.navigation.pagercontrol.IPagePositionProvider
    public int getNewPosition(int i) {
        return i == this.changedPagePosition ? -2 : -1;
    }
}
