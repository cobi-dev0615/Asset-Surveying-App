package com.devexpress.dxgrid.views;

import android.content.Context;
import com.devexpress.dxgrid.utils.providers.LayoutProvider;

/* loaded from: classes2.dex */
public abstract class GridRowViewBase extends GridViewBase {
    protected boolean isCascadeUpdateEnabled;
    private boolean isReady;
    public boolean isVisibleAndReadyAfterScrollToRow;
    protected LayoutProvider layoutProvider;
    private int rowIndex;

    public int getFixedHeight() {
        return 0;
    }

    public boolean isFixedHeight() {
        return false;
    }

    public boolean onSingleTapUp() {
        return false;
    }

    public void updateAppearance() {
    }

    public abstract void updateContent();

    public GridRowViewBase(Context context, LayoutProvider layoutProvider) {
        super(context);
        this.rowIndex = -1;
        this.layoutProvider = layoutProvider;
    }

    protected void hideAllViews() {
        for (int i = 0; i < getChildCount(); i++) {
            ((GridCellContainer) getChildAt(i)).hide();
        }
    }

    protected void showAll() {
        for (int i = 0; i < getChildCount(); i++) {
            ((GridCellContainer) getChildAt(i)).show();
        }
    }

    public int getDefaultHeight() {
        return this.layoutProvider.getDefaultRowHeight();
    }

    public int getRowIndex() {
        return this.rowIndex;
    }

    public void setRowIndex(int i) {
        this.rowIndex = i;
    }

    public void update(int i) {
        this.rowIndex = i;
        updateAppearance();
        if (getIsReady()) {
            updateContent();
        } else {
            hideAllViews();
        }
    }

    public void setIsReady(boolean z) {
        this.isReady = z;
    }

    public boolean getIsReady() {
        return this.isReady;
    }

    @Override // android.view.View
    public void clearAnimation() {
        super.clearAnimation();
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).clearAnimation();
        }
    }

    public void setCascadeUpdateEnabled(boolean z) {
        this.isCascadeUpdateEnabled = z;
    }
}
