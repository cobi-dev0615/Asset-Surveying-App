package com.devexpress.dxgrid.views;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import android.widget.ProgressBar;
import com.devexpress.dxgrid.appearance.providers.IndicatorAppearanceProvider;
import com.devexpress.dxgrid.utils.providers.LoadMoreActionProvider;
import com.devexpress.dxgrid.utils.providers.ViewPortWidthProvider;
import java.util.Objects;

/* loaded from: classes2.dex */
public class GridProgressBarRow extends GridRowViewBase {
    private static final int progressSize = 30;
    private final IndicatorAppearanceProvider appearanceProvider;
    private final int height;
    private final LoadMoreActionProvider loadMoreActionProvider;
    private ProgressBar progressBar;
    private final int progressBarHeight;
    private ViewPortWidthProvider viewPortWidthProvider;

    @Override // com.devexpress.dxgrid.views.GridViewBase
    protected View.OnTouchListener getTouchListener(int i) {
        return null;
    }

    public GridProgressBarRow(Context context, ViewPortWidthProvider viewPortWidthProvider, LoadMoreActionProvider loadMoreActionProvider, IndicatorAppearanceProvider indicatorAppearanceProvider) {
        super(context, null);
        this.viewPortWidthProvider = viewPortWidthProvider;
        ProgressBar progressBar = new ProgressBar(context);
        this.progressBar = progressBar;
        this.loadMoreActionProvider = loadMoreActionProvider;
        this.appearanceProvider = indicatorAppearanceProvider;
        progressBar.setIndeterminate(true);
        int rowHeight = getRowHeight(context);
        this.height = rowHeight;
        this.progressBarHeight = rowHeight / 2;
        addView(this.progressBar);
    }

    public static int getRowHeight(Context context) {
        return ((int) (context.getResources().getDisplayMetrics().density * 30.0f)) * 2;
    }

    @Override // com.devexpress.dxgrid.views.GridRowViewBase
    public void updateContent() {
        final LoadMoreActionProvider loadMoreActionProvider = this.loadMoreActionProvider;
        Objects.requireNonNull(loadMoreActionProvider);
        post(new Runnable() { // from class: com.devexpress.dxgrid.views.GridProgressBarRow$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LoadMoreActionProvider.this.sendLoadMore();
            }
        });
    }

    @Override // com.devexpress.dxgrid.views.GridRowViewBase
    public void update(int i) {
        super.update(i);
        this.progressBar.getIndeterminateDrawable().setColorFilter(new PorterDuffColorFilter(this.appearanceProvider.getIndicatorColor(), PorterDuff.Mode.SRC_IN));
    }

    @Override // com.devexpress.dxgrid.views.GridViewBase
    public void layoutChildren() {
        int offset = getOffset() + ((this.viewPortWidthProvider.getViewPortWidth() - this.progressBar.getMeasuredWidth()) / 2);
        int height = (getHeight() - this.progressBarHeight) / 2;
        ProgressBar progressBar = this.progressBar;
        progressBar.layout(offset, height, progressBar.getMeasuredWidth() + offset, this.progressBarHeight + height);
    }

    @Override // com.devexpress.dxgrid.views.GridViewBase, android.view.View
    protected void onMeasure(int i, int i2) {
        this.progressBar.measure(this.viewPortWidthProvider.getViewPortWidth(), this.progressBarHeight);
        setMeasuredDimension(View.MeasureSpec.getSize(i), this.height);
    }
}
