package com.devexpress.dxgrid.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import com.devexpress.dxgrid.R;
import com.devexpress.dxgrid.models.ColumnSortOrder;
import com.devexpress.dxgrid.models.ContentAlignment;
import com.devexpress.dxgrid.models.GridElement;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.utils.ColumnInfo;
import com.devexpress.dxgrid.utils.GridColumnsOnTouchListener;
import com.devexpress.dxgrid.utils.GridContainerViewInfo;
import com.devexpress.dxgrid.utils.providers.ColumnHeaderViewProviderNative;
import com.devexpress.dxgrid.utils.providers.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GridHeaderView.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0007H\u0014J\b\u0010\u001c\u001a\u00020\u0010H\u0014J\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011¨\u0006 "}, d2 = {"Lcom/devexpress/dxgrid/views/GridHeaderView;", "Lcom/devexpress/dxgrid/views/GridColumnsViewBase;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "columnNameTextViewParams", "Landroid/widget/LinearLayout$LayoutParams;", "drawableDown", "Landroid/graphics/drawable/Drawable;", "drawableUp", "imageViewParams", "isFixedHeight", "", "()Z", "createCellContainer", "Lcom/devexpress/dxgrid/views/GridCellContainer;", "columnIndex", "serviceProvider", "Lcom/devexpress/dxgrid/utils/providers/ServiceProvider;", "createViewForContainer", "Landroid/view/View;", "getFixedHeight", "getTouchListener", "Landroid/view/View$OnTouchListener;", "isVisible", "updateViewsInContainers", "", "Companion", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GridHeaderView extends GridColumnsViewBase {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
    private final LinearLayout.LayoutParams columnNameTextViewParams;
    private final Drawable drawableDown;
    private final Drawable drawableUp;
    private final LinearLayout.LayoutParams imageViewParams;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GridHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridHeaderView(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.drawableDown = ResourcesCompat.getDrawable(getResources(), R.drawable.dxg_sorting_down_24dp, null);
        this.drawableUp = ResourcesCompat.getDrawable(getResources(), R.drawable.dxg_sorting_up_24dp, null);
        int imageSize = ColumnHeaderViewProviderNative.getImageSize(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(imageSize, imageSize);
        this.imageViewParams = layoutParams2;
        layoutParams2.gravity = 16;
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        this.columnNameTextViewParams = layoutParams3;
        layoutParams3.gravity = 16;
    }

    public /* synthetic */ GridHeaderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // com.devexpress.dxgrid.utils.providers.ItemHeightProvider
    public boolean isFixedHeight() {
        return getServiceProvider().getFixedHeaderHeight();
    }

    @Override // com.devexpress.dxgrid.utils.providers.ItemHeightProvider
    public int getFixedHeight() {
        return getServiceProvider().getHeaderHeight();
    }

    public final void updateViewsInContainers() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.devexpress.dxgrid.views.GridCellContainer");
            GridCellContainer gridCellContainer = (GridCellContainer) childAt;
            gridCellContainer.removeAllViews();
            gridCellContainer.addView(createViewForContainer(gridCellContainer.getColumnIndex()), getLayoutParams());
        }
    }

    @Override // com.devexpress.dxgrid.views.GridColumnsViewBase
    protected boolean isVisible() {
        return getServiceProvider().getHeaderHeight() != 0;
    }

    private final View createViewForContainer(int columnIndex) {
        ColumnInfo column = getServiceProvider().getColumn(columnIndex);
        Intrinsics.checkNotNullExpressionValue(column, "getColumn(...)");
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        GridColumnModel gridColumnModel = column.getGridColumnModel();
        linearLayout.addView(getServiceProvider().getColumnHeaderView(getContext(), columnIndex), -1, this.columnNameTextViewParams);
        ColumnSortOrder sortOrder = gridColumnModel.getSortOrder();
        if (sortOrder != ColumnSortOrder.None) {
            AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
            if (sortOrder == ColumnSortOrder.Ascending) {
                appCompatImageView.setImageDrawable(this.drawableUp);
            } else if (sortOrder == ColumnSortOrder.Descending) {
                appCompatImageView.setImageDrawable(this.drawableDown);
            }
            linearLayout.addView(appCompatImageView, ColumnHeaderViewProviderNative.getTextGravity(gridColumnModel.getBaseHorizontalContentAlignment()) != 8388613 ? -1 : 0, this.imageViewParams);
        }
        return linearLayout;
    }

    @Override // com.devexpress.dxgrid.views.GridViewBase
    protected GridCellContainer createCellContainer(Context context, int columnIndex, ServiceProvider serviceProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
        ColumnInfo column = serviceProvider.getColumn(columnIndex);
        Intrinsics.checkNotNullExpressionValue(column, "getColumn(...)");
        GridCellContainer gridCellContainer = new GridCellContainer(context, createViewForContainer(columnIndex), column.getGridColumnModel().getHeaderAppearance(), new GridContainerViewInfo(column.getFixedColumnSeparatorStyle(), column.getShouldDrawLeftBorder(), column.getShouldDrawRightBorder(), false, true, column.getBottomColumn()), getLayoutParams(), columnIndex);
        gridCellContainer.setVerticalAlignment(ContentAlignment.Center);
        return gridCellContainer;
    }

    @Override // com.devexpress.dxgrid.views.GridViewBase
    protected View.OnTouchListener getTouchListener(int columnIndex) {
        return new GridColumnsOnTouchListener(getContext(), GridElement.ColumnHeader, getGridAction(), columnIndex);
    }

    /* compiled from: GridHeaderView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/devexpress/dxgrid/views/GridHeaderView$Companion;", "", "()V", "layoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "getLayoutParams", "()Landroid/widget/LinearLayout$LayoutParams;", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LinearLayout.LayoutParams getLayoutParams() {
            return GridHeaderView.layoutParams;
        }
    }
}
