package com.devexpress.dxgrid.editform;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.devexpress.dxgrid.models.appearance.AppearanceBase;
import com.devexpress.dxgrid.providers.DataProvider;
import java.util.List;

/* loaded from: classes.dex */
public class GridEditFormView extends ScrollView {
    private GridEditFormItemView activeItem;
    private final AppearanceBase appearance;
    private GridEditFormViewContent contentView;
    private final List<GridEditFormViewInfo> editFormViewInfos;

    public GridEditFormView(Context context, DataProvider dataProvider, List<GridEditFormViewInfo> list, int i, AppearanceBase appearanceBase, Rect rect) {
        super(context);
        this.appearance = appearanceBase;
        this.editFormViewInfos = list;
        this.contentView = new GridEditFormViewContent(getContext());
        createSubviews(dataProvider, appearanceBase, i, rect);
        addView(this.contentView);
    }

    private void createSubviews(DataProvider dataProvider, AppearanceBase appearanceBase, int i, Rect rect) {
        for (int i2 = 0; i2 < this.editFormViewInfos.size(); i2++) {
            this.contentView.addView(new GridEditFormItemView(getContext(), dataProvider, this.editFormViewInfos.get(i2), i, new TouchCallback() { // from class: com.devexpress.dxgrid.editform.GridEditFormView.1
                @Override // com.devexpress.dxgrid.editform.TouchCallback
                public void touch(GridEditFormItemView gridEditFormItemView) {
                    if (GridEditFormView.this.activeItem == null) {
                        GridEditFormView.this.activeItem = gridEditFormItemView;
                    } else if (GridEditFormView.this.activeItem != gridEditFormItemView) {
                        GridEditFormView.this.activeItem.applyChanges();
                        GridEditFormView.this.activeItem = gridEditFormItemView;
                    }
                }
            }, appearanceBase, rect));
        }
    }

    public void commit() {
        for (int i = 0; i < this.contentView.getChildCount(); i++) {
            ((GridEditFormItemView) this.contentView.getChildAt(i)).applyChanges();
        }
    }

    public void updateValidation() {
        for (int i = 0; i < this.contentView.getChildCount(); i++) {
            ((GridEditFormItemView) this.contentView.getChildAt(i)).updateValidation();
        }
    }

    class GridEditFormViewContent extends ViewGroup {
        public GridEditFormViewContent(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            Rect noPadding = GridEditFormView.this.appearance.getNoPadding();
            int i5 = noPadding.top;
            int i6 = ((i3 - i) - noPadding.left) - noPadding.right;
            int i7 = 0;
            while (i7 < getChildCount()) {
                View childAt = getChildAt(i7);
                int measuredHeight = childAt.getMeasuredHeight() + i5;
                childAt.layout(noPadding.left, i5, noPadding.left + i6, measuredHeight);
                i7++;
                i5 = measuredHeight;
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            Rect noPadding = GridEditFormView.this.appearance.getNoPadding();
            int i3 = noPadding.left + noPadding.right;
            int i4 = noPadding.top + noPadding.bottom;
            if (View.MeasureSpec.getMode(i2) != 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2) - i4, Integer.MIN_VALUE);
            }
            if (View.MeasureSpec.getMode(i) != 0) {
                i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i) - i3, Integer.MIN_VALUE);
            }
            int i5 = 0;
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt = getChildAt(i6);
                childAt.measure(i, i2);
                i5 += childAt.getMeasuredHeight();
            }
            setMeasuredDimension(View.MeasureSpec.getSize(i) + i3, i5 + i4);
        }
    }
}
