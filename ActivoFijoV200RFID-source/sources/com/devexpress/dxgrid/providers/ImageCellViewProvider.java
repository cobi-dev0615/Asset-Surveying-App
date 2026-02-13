package com.devexpress.dxgrid.providers;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.devexpress.dxgrid.models.appearance.AppearanceBase;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.utils.ObjectLambda;
import com.devexpress.dxgrid.views.GridImageCell;

/* loaded from: classes.dex */
public class ImageCellViewProvider extends NativeViewProviderBase {
    @Override // com.devexpress.dxgrid.providers.ViewProvider
    public void updateAppearance(View view, GridColumnModel gridColumnModel, AppearanceBase appearanceBase, int i) {
    }

    @Override // com.devexpress.dxgrid.providers.ViewProvider
    public View requestView(Context context, int i) {
        return new GridImageCell(context);
    }

    @Override // com.devexpress.dxgrid.providers.ViewProvider
    public void updateContent(View view, DataProvider dataProvider, String str, int i) {
        final GridImageCell gridImageCell = (GridImageCell) view;
        recycleOldBitmap(gridImageCell);
        dataProvider.getValueAsync(str, i, new ObjectLambda() { // from class: com.devexpress.dxgrid.providers.ImageCellViewProvider$$ExternalSyntheticLambda0
            @Override // com.devexpress.dxgrid.utils.ObjectLambda
            public final void Action(Object obj) {
                ImageCellViewProvider.lambda$updateContent$0(GridImageCell.this, obj);
            }
        });
    }

    static /* synthetic */ void lambda$updateContent$0(GridImageCell gridImageCell, Object obj) {
        gridImageCell.setAdjustViewBounds(true);
        gridImageCell.setImageDrawable(obj instanceof Drawable ? (Drawable) obj : null);
    }

    private void recycleOldBitmap(GridImageCell gridImageCell) {
        gridImageCell.setImageDrawable(null);
        gridImageCell.setImageResource(R.color.transparent);
    }
}
