package com.devexpress.dxgrid.layout;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.devexpress.dxgrid.providers.DragPreviewTemplateProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RowTouchHelperCallback.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J@\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u001fH\u0016J \u0010(\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0017H\u0016J\u001a\u0010+\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010&\u001a\u00020\u0010H\u0016J\u0018\u0010,\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u0010H\u0016J\u000e\u0010.\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010/\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0010J\u0010\u00100\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001e\u00101\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001503H\u0002J\u0010\u00104\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/devexpress/dxgrid/layout/RowTouchHelperCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "dragPreviewTemplateProvider", "Lcom/devexpress/dxgrid/providers/DragPreviewTemplateProvider;", "(Lcom/devexpress/dxgrid/providers/DragPreviewTemplateProvider;)V", "ELEVATION_VALUE", "", "SCALE_FACTOR", "adapter", "Lcom/devexpress/dxgrid/layout/GridRowsAdapter;", "getDragPreviewTemplateProvider", "()Lcom/devexpress/dxgrid/providers/DragPreviewTemplateProvider;", "draggedView", "Landroid/view/View;", "previewView", "rowDragPreviewBackgroundColor", "", "getRowDragPreviewBackgroundColor", "()I", "rowDragPreviewShadowColor", "clearPreviewView", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "clearView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getGridContainerView", "Landroid/view/ViewGroup;", "getMovementFlags", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "source", TypedValues.AttributesType.S_TARGET, "onSelectedChanged", "onSwiped", "i", "setAdapter", "setRowDragPreviewShadowColor", "startDragAnimation", "startDropAnimation", "endAction", "Lkotlin/Function0;", "tryToPreparePreviewView", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RowTouchHelperCallback extends ItemTouchHelper.Callback {
    private final float ELEVATION_VALUE;
    private final float SCALE_FACTOR;
    private GridRowsAdapter adapter;
    private final DragPreviewTemplateProvider dragPreviewTemplateProvider;
    private View draggedView;
    private View previewView;
    private int rowDragPreviewShadowColor;

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }

    public RowTouchHelperCallback(DragPreviewTemplateProvider dragPreviewTemplateProvider) {
        Intrinsics.checkNotNullParameter(dragPreviewTemplateProvider, "dragPreviewTemplateProvider");
        this.dragPreviewTemplateProvider = dragPreviewTemplateProvider;
        this.SCALE_FACTOR = 1.02f;
        this.ELEVATION_VALUE = 8.0f;
        this.rowDragPreviewShadowColor = -16777216;
    }

    public final DragPreviewTemplateProvider getDragPreviewTemplateProvider() {
        return this.dragPreviewTemplateProvider;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
    }

    public final void setAdapter(GridRowsAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
    }

    public final void setRowDragPreviewShadowColor(int rowDragPreviewShadowColor) {
        this.rowDragPreviewShadowColor = rowDragPreviewShadowColor;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        GridRowsAdapter gridRowsAdapter = this.adapter;
        if (gridRowsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            gridRowsAdapter = null;
        }
        gridRowsAdapter.onMove(source, target);
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState == 2 && viewHolder != null) {
            GridRowsAdapter gridRowsAdapter = this.adapter;
            if (gridRowsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                gridRowsAdapter = null;
            }
            gridRowsAdapter.onDrag(viewHolder);
            startDragAnimation(viewHolder);
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        View view = this.previewView;
        if (view != null) {
            View view2 = viewHolder.itemView;
            int i = (int) dY;
            view.layout(0, view2.getTop() + i, view2.getMeasuredWidth(), view2.getBottom() + i);
        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(final RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        startDropAnimation(viewHolder, new Function0<Unit>() { // from class: com.devexpress.dxgrid.layout.RowTouchHelperCallback$clearView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GridRowsAdapter gridRowsAdapter;
                super/*androidx.recyclerview.widget.ItemTouchHelper.Callback*/.clearView(recyclerView, viewHolder);
                gridRowsAdapter = RowTouchHelperCallback.this.adapter;
                if (gridRowsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    gridRowsAdapter = null;
                }
                gridRowsAdapter.onDrop();
            }
        });
    }

    private final int getRowDragPreviewBackgroundColor() {
        ViewParent parent;
        ViewParent parent2;
        ViewParent parent3;
        ViewParent parent4;
        ViewParent parent5;
        View view = this.draggedView;
        ViewGroup viewGroup = (ViewGroup) ((view == null || (parent = view.getParent()) == null || (parent2 = parent.getParent()) == null || (parent3 = parent2.getParent()) == null || (parent4 = parent3.getParent()) == null || (parent5 = parent4.getParent()) == null) ? null : parent5.getParent());
        Drawable background = viewGroup != null ? viewGroup.getBackground() : null;
        if (background instanceof ColorDrawable) {
            return ((ColorDrawable) background).getColor();
        }
        if (background instanceof ShapeDrawable) {
            return ((ShapeDrawable) background).getPaint().getColor();
        }
        return -1;
    }

    private final void startDragAnimation(RecyclerView.ViewHolder viewHolder) {
        if (this.draggedView == null) {
            tryToPreparePreviewView(viewHolder);
            View itemView = this.previewView;
            if (itemView == null) {
                itemView = viewHolder.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            }
            this.draggedView = itemView;
            if (Build.VERSION.SDK_INT >= 28) {
                itemView.setOutlineSpotShadowColor(this.rowDragPreviewShadowColor);
            }
            itemView.setBackgroundColor(getRowDragPreviewBackgroundColor());
            itemView.animate().setDuration(itemView.getContext().getResources().getInteger(R.integer.config_shortAnimTime)).scaleX(this.SCALE_FACTOR).scaleY(this.SCALE_FACTOR).translationZ(this.ELEVATION_VALUE * itemView.getContext().getResources().getDisplayMetrics().density).start();
        }
    }

    private final void tryToPreparePreviewView(RecyclerView.ViewHolder viewHolder) {
        DragPreviewTemplateProvider dragPreviewTemplateProvider = this.dragPreviewTemplateProvider;
        Context context = viewHolder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        View dragPreview = dragPreviewTemplateProvider.getDragPreview(context, viewHolder.getBindingAdapterPosition());
        if (dragPreview != null) {
            dragPreview.measure(View.MeasureSpec.makeMeasureSpec(viewHolder.itemView.getMeasuredWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(viewHolder.itemView.getMeasuredHeight(), BasicMeasure.EXACTLY));
            getGridContainerView(viewHolder).addView(dragPreview, 1);
            this.previewView = dragPreview;
            viewHolder.itemView.setAlpha(0.0f);
        }
    }

    private final ViewGroup getGridContainerView(RecyclerView.ViewHolder viewHolder) {
        ViewParent parent = viewHolder.itemView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewParent parent2 = ((ViewGroup) parent).getParent();
        Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) parent2;
    }

    private final void startDropAnimation(final RecyclerView.ViewHolder viewHolder, final Function0<Unit> endAction) {
        final View view = this.draggedView;
        if (view != null) {
            view.animate().setDuration(view.getContext().getResources().getInteger(R.integer.config_shortAnimTime)).scaleX(1.0f).scaleY(1.0f).translationZ(0.0f).withEndAction(new Runnable() { // from class: com.devexpress.dxgrid.layout.RowTouchHelperCallback$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    RowTouchHelperCallback.startDropAnimation$lambda$6$lambda$5(view, this, viewHolder, endAction);
                }
            }).start();
        }
        this.draggedView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startDropAnimation$lambda$6$lambda$5(View it, RowTouchHelperCallback this$0, RecyclerView.ViewHolder viewHolder, Function0 endAction) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(endAction, "$endAction");
        it.setBackground(null);
        this$0.clearPreviewView(viewHolder);
        endAction.invoke();
    }

    private final void clearPreviewView(RecyclerView.ViewHolder viewHolder) {
        View view = this.previewView;
        if (view != null) {
            ViewParent parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(view);
            viewHolder.itemView.setAlpha(1.0f);
        }
        this.previewView = null;
    }
}
