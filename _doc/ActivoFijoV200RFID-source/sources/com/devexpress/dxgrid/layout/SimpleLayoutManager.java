package com.devexpress.dxgrid.layout;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.devexpress.dxgrid.utils.providers.LayoutProvider;
import com.devexpress.dxgrid.utils.providers.RowHeightProvider;
import com.devexpress.dxgrid.views.GridRowViewBase;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleLayoutManager.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 f2\u00020\u00012\u00020\u0002:\u0001fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010>\u001a\u00020\fH\u0016J\u0010\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u001eH\u0016J\u0010\u0010A\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u001eH\u0016J\u0010\u0010B\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u001eH\u0016J\u0006\u0010C\u001a\u00020\u0007J\u0006\u0010D\u001a\u00020\u0007J\b\u0010E\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020\u000eH\u0002J\b\u0010I\u001a\u00020JH\u0016J\u0006\u0010K\u001a\u00020\u0007J\b\u0010L\u001a\u00020\u0007H\u0016J\b\u0010M\u001a\u00020\fH\u0016J\u001c\u0010N\u001a\u00020\u000e2\n\u0010O\u001a\u00060PR\u00020Q2\u0006\u0010R\u001a\u00020\u0007H\u0002J\u0010\u0010S\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0002J\b\u0010T\u001a\u00020FH\u0002J4\u0010U\u001a\u00020F2\n\u0010O\u001a\u00060PR\u00020Q2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\f2\u0006\u0010Y\u001a\u00020\fH\u0002J\u0010\u0010Z\u001a\u00020F2\u0006\u0010[\u001a\u00020\u0007H\u0002J\u0014\u0010\\\u001a\u00020F2\n\u0010O\u001a\u00060PR\u00020QH\u0002J\u001c\u0010]\u001a\u00020F2\n\u0010O\u001a\u00060PR\u00020Q2\u0006\u0010@\u001a\u00020\u001eH\u0016J\u0010\u0010^\u001a\u00020F2\u0006\u0010,\u001a\u00020\u0007H\u0016J$\u0010_\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u00072\n\u0010O\u001a\u00060PR\u00020Q2\u0006\u0010@\u001a\u00020\u001eH\u0016J\u0016\u0010`\u001a\u00020F2\u0006\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u0007J\u0010\u0010c\u001a\u00020F2\u0006\u0010H\u001a\u00020\u000eH\u0016J\b\u0010d\u001a\u00020FH\u0002J\f\u0010e\u001a\u00020F*\u00020\u000eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0011R\u001a\u0010#\u001a\u00020$X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0011R\u0018\u00109\u001a\u00020\u0007*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0018\u0010<\u001a\u00020\f*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006g"}, d2 = {"Lcom/devexpress/dxgrid/layout/SimpleLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Lcom/devexpress/dxgrid/utils/providers/LayoutProvider;", "rowHeightProvider", "Lcom/devexpress/dxgrid/utils/providers/RowHeightProvider;", "(Lcom/devexpress/dxgrid/utils/providers/RowHeightProvider;)V", "aHeight", "", "bottomIndex", "currentHeight", "delta", "desiredLayoutDirection", "", "draggedView", "Landroid/view/View;", "extentHeight", "getExtentHeight", "()I", "extentWidth", "getExtentWidth", "free", "Landroid/util/SparseArray;", "Ljava/util/ArrayList;", "gridRowsAdapter", "Lcom/devexpress/dxgrid/layout/GridRowsAdapter;", "getGridRowsAdapter", "()Lcom/devexpress/dxgrid/layout/GridRowsAdapter;", "setGridRowsAdapter", "(Lcom/devexpress/dxgrid/layout/GridRowsAdapter;)V", "layoutState", "Landroidx/recyclerview/widget/RecyclerView$State;", "offsetBottom", "offsetTop", "offsetY", "getOffsetY", "onBottomOverScrolledRunnable", "Ljava/lang/Runnable;", "getOnBottomOverScrolledRunnable", "()Ljava/lang/Runnable;", "setOnBottomOverScrolledRunnable", "(Ljava/lang/Runnable;)V", "onTopOverScrolledRunnable", "getOnTopOverScrolledRunnable", "setOnTopOverScrolledRunnable", "position", "scrollToRow", "shouldSetLayoutDirection", "topIndex", "topToBottom", "getTopToBottom", "()Z", "setTopToBottom", "(Z)V", "totalOffset", "views", "visibleChildCount", "getVisibleChildCount", "adapterPosition", "getAdapterPosition", "(Landroid/view/View;)I", "isAtBigTop", "(Landroid/view/View;)Z", "canScrollVertically", "computeVerticalScrollExtent", "state", "computeVerticalScrollOffset", "computeVerticalScrollRange", "findFirstVisibleItemPosition", "findLastVisibleItemPosition", "finishDrag", "", "freeView", "view", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "getCurrentHeight", "getDefaultRowHeight", "getDidStructureChanged", "getView", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "pos", "getViewKindByPosition", "init", "layout", "offsetT", "offsetB", "shouldSetTopIndex", "shouldSetBottomIndex", "offsetChildren", "dy", "offsetOnOffsetTop", "onLayoutChildren", "scrollToPosition", "scrollVerticallyBy", "setLayoutDirectionForItemMove", "fromPosition", "toPosition", "startDrag", "tryLoadMore", "moveToBigTop", "Companion", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SimpleLayoutManager extends RecyclerView.LayoutManager implements LayoutProvider {
    private static final int BIG_TOP = -100000;
    private int aHeight;
    private int bottomIndex;
    private int currentHeight;
    private int delta;
    private boolean desiredLayoutDirection;
    private View draggedView;
    private final SparseArray<ArrayList<View>> free;
    public GridRowsAdapter gridRowsAdapter;
    private RecyclerView.State layoutState;
    private int offsetBottom;
    private int offsetTop;
    public Runnable onBottomOverScrolledRunnable;
    private Runnable onTopOverScrolledRunnable;
    private int position;
    private final RowHeightProvider rowHeightProvider;
    private boolean scrollToRow;
    private boolean shouldSetLayoutDirection;
    private int topIndex;
    private boolean topToBottom;
    private int totalOffset;
    private final ArrayList<View> views;

    public SimpleLayoutManager(RowHeightProvider rowHeightProvider) {
        Intrinsics.checkNotNullParameter(rowHeightProvider, "rowHeightProvider");
        this.rowHeightProvider = rowHeightProvider;
        this.topToBottom = true;
        this.free = new SparseArray<>();
        this.views = new ArrayList<>();
    }

    public final GridRowsAdapter getGridRowsAdapter() {
        GridRowsAdapter gridRowsAdapter = this.gridRowsAdapter;
        if (gridRowsAdapter != null) {
            return gridRowsAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gridRowsAdapter");
        return null;
    }

    public final void setGridRowsAdapter(GridRowsAdapter gridRowsAdapter) {
        Intrinsics.checkNotNullParameter(gridRowsAdapter, "<set-?>");
        this.gridRowsAdapter = gridRowsAdapter;
    }

    @Override // com.devexpress.dxgrid.utils.providers.LayoutProvider
    public void finishDrag() {
        this.draggedView = null;
    }

    @Override // com.devexpress.dxgrid.utils.providers.LayoutProvider
    public void startDrag(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.draggedView = view;
    }

    public final boolean getTopToBottom() {
        return this.topToBottom;
    }

    public final void setTopToBottom(boolean z) {
        this.topToBottom = z;
    }

    public final Runnable getOnBottomOverScrolledRunnable() {
        Runnable runnable = this.onBottomOverScrolledRunnable;
        if (runnable != null) {
            return runnable;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onBottomOverScrolledRunnable");
        return null;
    }

    public final void setOnBottomOverScrolledRunnable(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "<set-?>");
        this.onBottomOverScrolledRunnable = runnable;
    }

    public final Runnable getOnTopOverScrolledRunnable() {
        return this.onTopOverScrolledRunnable;
    }

    public final void setOnTopOverScrolledRunnable(Runnable runnable) {
        this.onTopOverScrolledRunnable = runnable;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public final void setLayoutDirectionForItemMove(int fromPosition, int toPosition) {
        int i = this.topIndex;
        if (fromPosition >= i || toPosition >= i) {
            int i2 = this.bottomIndex;
            if (fromPosition <= i2 || toPosition <= i2) {
                if (toPosition < i) {
                    this.shouldSetLayoutDirection = true;
                    this.desiredLayoutDirection = false;
                } else if (toPosition > i2) {
                    this.shouldSetLayoutDirection = true;
                    this.desiredLayoutDirection = true;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        this.layoutState = state;
        if (this.offsetBottom < getHeight()) {
            this.topToBottom = true;
        }
        if (state.didStructureChange()) {
            detachAndScrapAttachedViews(recycler);
            if (this.bottomIndex >= getItemCount()) {
                this.bottomIndex = getItemCount() - 1;
                this.offsetBottom = getHeight();
            }
            if (this.topIndex >= getItemCount() || getItemCount() == 0) {
                this.topIndex = 0;
                this.offsetTop = 0;
            }
            if (this.shouldSetLayoutDirection) {
                this.topToBottom = this.desiredLayoutDirection;
                this.shouldSetLayoutDirection = false;
            } else {
                this.topToBottom = true;
            }
        }
        if (!this.scrollToRow) {
            this.delta = 0;
        }
        init();
        layout(recycler, this.offsetTop, this.offsetBottom, true, true);
        int i = this.offsetTop;
        if (i > 0) {
            offsetOnOffsetTop(recycler);
        } else if (i < 0 && this.offsetBottom < getHeight()) {
            if (this.topIndex == 0) {
                offsetChildren(-this.offsetTop);
                this.offsetTop = 0;
            } else {
                offsetChildren(getHeight() - this.offsetBottom);
                this.position = this.topIndex - 1;
                this.topToBottom = false;
                layout(recycler, 0, (getHeight() - this.offsetBottom) + this.offsetTop, true, false);
                this.offsetBottom = getHeight();
                if (this.offsetTop > 0) {
                    offsetOnOffsetTop(recycler);
                }
            }
        }
        getGridRowsAdapter().setCascadeTreeCreationEnabled(false);
    }

    private final void offsetOnOffsetTop(RecyclerView.Recycler recycler) {
        offsetChildren(-this.offsetTop);
        this.position = this.bottomIndex + 1;
        this.topToBottom = true;
        layout(recycler, getHeight() - this.offsetTop, 0, false, false);
        this.offsetTop = 0;
    }

    private final void layout(RecyclerView.Recycler recycler, int offsetT, int offsetB, boolean shouldSetTopIndex, boolean shouldSetBottomIndex) {
        int i;
        int i2;
        if (this.topToBottom) {
            boolean z = false;
            i2 = 0;
            i = 0;
            while (offsetT < getHeight() && this.position < getItemCount()) {
                View view = getView(recycler, this.position);
                if (shouldSetTopIndex && !z) {
                    this.topIndex = getAdapterPosition(view);
                    z = true;
                }
                if (view.isLayoutRequested()) {
                    view.measure(getWidth(), 0);
                }
                view.layout(0, offsetT, view.getMeasuredWidth(), view.getMeasuredHeight() + offsetT);
                i2++;
                i += view.getMeasuredHeight();
                this.offsetBottom = view.getMeasuredHeight() + offsetT;
                this.bottomIndex = getAdapterPosition(view);
                offsetT += view.getMeasuredHeight();
                this.position = getAdapterPosition(view) + 1;
            }
        } else {
            int i3 = 0;
            boolean z2 = false;
            i = 0;
            while (offsetB > 0) {
                int i4 = this.position;
                if (i4 < 0) {
                    break;
                }
                View view2 = getView(recycler, i4);
                if (shouldSetBottomIndex && !z2) {
                    this.bottomIndex = getAdapterPosition(view2);
                    z2 = true;
                }
                if (view2.isLayoutRequested()) {
                    view2.measure(getWidth(), 0);
                }
                view2.layout(0, offsetB - view2.getMeasuredHeight(), view2.getMeasuredWidth(), offsetB);
                i3++;
                i += view2.getMeasuredHeight();
                this.offsetTop = offsetB - view2.getMeasuredHeight();
                this.topIndex = getAdapterPosition(view2);
                offsetB -= view2.getMeasuredHeight();
                this.position = getAdapterPosition(view2) - 1;
            }
            i2 = i3;
        }
        Iterator<T> it = this.views.iterator();
        while (it.hasNext()) {
            moveToBigTop((View) it.next());
        }
        View view3 = this.draggedView;
        if (view3 != null && ((ViewGroup) view3).getParent() == null && getAdapterPosition(view3) >= 0) {
            addView(view3);
            view3.measure(getWidth(), 0);
        }
        if (i > 0) {
            this.aHeight = i / i2;
        }
        this.currentHeight = i;
    }

    public final int getCurrentHeight() {
        return this.currentHeight;
    }

    private final View getView(RecyclerView.Recycler recycler, int pos) {
        Object obj;
        Object obj2;
        if (this.views.size() > 0) {
            View remove = this.views.remove(0);
            Intrinsics.checkNotNullExpressionValue(remove, "removeAt(...)");
            return remove;
        }
        int viewKindByPosition = getViewKindByPosition(this.position);
        if (this.free.indexOfKey(viewKindByPosition) >= 0) {
            ArrayList<View> arrayList = this.free.get(viewKindByPosition);
            Intrinsics.checkNotNullExpressionValue(arrayList, "get(...)");
            Iterator<T> it = arrayList.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                View view = (View) obj2;
                if (getAdapterPosition(view) == pos && !Intrinsics.areEqual(view, this.draggedView)) {
                    break;
                }
            }
            View view2 = (View) obj2;
            if (view2 == null) {
                ArrayList<View> arrayList2 = this.free.get(viewKindByPosition);
                Intrinsics.checkNotNullExpressionValue(arrayList2, "get(...)");
                Iterator<T> it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    View view3 = (View) next;
                    if (!Intrinsics.areEqual(view3, this.draggedView)) {
                        Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type com.devexpress.dxgrid.views.GridRowViewBase");
                        if (!((GridRowViewBase) view3).isVisibleAndReadyAfterScrollToRow) {
                            obj = next;
                            break;
                        }
                    }
                }
                view2 = (View) obj;
            }
            if (view2 != null) {
                View view4 = this.draggedView;
                if (view4 != null && getAdapterPosition(view4) == pos) {
                    View view5 = this.draggedView;
                    Intrinsics.checkNotNull(view5);
                    return view5;
                }
                this.free.get(viewKindByPosition).remove(view2);
                recycler.bindViewToPosition(view2, pos);
                return view2;
            }
        }
        View view6 = this.draggedView;
        View viewForPosition = (view6 == null || getAdapterPosition(view6) != pos) ? recycler.getViewForPosition(pos) : this.draggedView;
        Intrinsics.checkNotNull(viewForPosition, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) viewForPosition;
        if (viewGroup.getParent() == null) {
            addView(viewForPosition);
            viewGroup.measure(getWidth(), 0);
        }
        return viewForPosition;
    }

    private final int getViewKindByPosition(int position) {
        return getGridRowsAdapter().getItemViewType(position);
    }

    private final void init() {
        View view;
        View view2;
        this.free.clear();
        this.views.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.devexpress.dxgrid.views.GridRowViewBase");
            GridRowViewBase gridRowViewBase = (GridRowViewBase) childAt;
            gridRowViewBase.isVisibleAndReadyAfterScrollToRow = false;
            if (!this.scrollToRow) {
                GridRowViewBase gridRowViewBase2 = gridRowViewBase;
                if (!isAtBigTop(gridRowViewBase2)) {
                    if (gridRowViewBase.getBottom() - this.delta < 0) {
                        this.offsetTop += gridRowViewBase.getMeasuredHeight();
                        freeView(gridRowViewBase2);
                    } else if (gridRowViewBase.getTop() - this.delta > getHeight()) {
                        this.offsetBottom -= gridRowViewBase.getMeasuredHeight();
                        freeView(gridRowViewBase2);
                    } else {
                        this.views.add(gridRowViewBase);
                    }
                }
            }
            if (this.scrollToRow && gridRowViewBase.getIsReady() && gridRowViewBase.getBottom() - this.delta >= 0 && gridRowViewBase.getTop() - this.delta < getHeight()) {
                gridRowViewBase.isVisibleAndReadyAfterScrollToRow = true;
            }
            freeView(gridRowViewBase);
        }
        this.scrollToRow = false;
        CollectionsKt.sortWith(this.views, new Comparator() { // from class: com.devexpress.dxgrid.layout.SimpleLayoutManager$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int init$lambda$4;
                init$lambda$4 = SimpleLayoutManager.init$lambda$4(SimpleLayoutManager.this, (View) obj, (View) obj2);
                return init$lambda$4;
            }
        });
        if (this.views.size() > 0) {
            if (this.topToBottom) {
                view = this.views.get(0);
            } else {
                ArrayList<View> arrayList = this.views;
                view = arrayList.get(arrayList.size() - 1);
            }
            Intrinsics.checkNotNullExpressionValue(view, "get(...)");
            this.topIndex = getAdapterPosition(view);
            if (this.topToBottom) {
                ArrayList<View> arrayList2 = this.views;
                view2 = arrayList2.get(arrayList2.size() - 1);
            } else {
                view2 = this.views.get(0);
            }
            Intrinsics.checkNotNullExpressionValue(view2, "get(...)");
            this.bottomIndex = getAdapterPosition(view2);
            View view3 = this.views.get(0);
            Intrinsics.checkNotNullExpressionValue(view3, "get(...)");
            this.position = getAdapterPosition(view3);
        } else if (getDefaultRowHeight() > 0 && (-this.totalOffset) > getDefaultRowHeight()) {
            int defaultRowHeight = (-this.totalOffset) / getDefaultRowHeight();
            if (this.topToBottom) {
                this.position += defaultRowHeight;
            } else {
                this.position -= defaultRowHeight;
            }
        } else {
            this.position = this.topToBottom ? this.topIndex : this.bottomIndex;
        }
        if (getDefaultRowHeight() > 0) {
            this.totalOffset %= getDefaultRowHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int init$lambda$4(SimpleLayoutManager this$0, View v1, View v2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v1, "v1");
        Intrinsics.checkNotNullParameter(v2, "v2");
        return this$0.topToBottom ? this$0.getAdapterPosition(v1) - this$0.getAdapterPosition(v2) : this$0.getAdapterPosition(v2) - this$0.getAdapterPosition(v1);
    }

    private final boolean isAtBigTop(View view) {
        return view.getTop() == BIG_TOP;
    }

    private final void moveToBigTop(View view) {
        if (isAtBigTop(view)) {
            return;
        }
        view.offsetTopAndBottom(BIG_TOP - view.getTop());
    }

    private final int getAdapterPosition(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        return ((RecyclerView.LayoutParams) layoutParams).getBindingAdapterPosition();
    }

    private final void freeView(View view) {
        moveToBigTop(view);
        int viewKindByPosition = getViewKindByPosition(getAdapterPosition(view));
        if (this.free.indexOfKey(viewKindByPosition) < 0) {
            this.free.append(viewKindByPosition, new ArrayList<>());
        }
        this.free.get(viewKindByPosition).add(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int position) {
        if (this.draggedView != null) {
            return;
        }
        int i = this.topIndex;
        if (position <= i || position >= this.bottomIndex) {
            this.position = position;
            this.totalOffset = 0;
            this.scrollToRow = true;
            if (position <= i) {
                this.delta = this.offsetTop - ((i - position) * this.aHeight);
                this.topIndex = position;
                this.offsetTop = 0;
                this.topToBottom = true;
            } else if (position >= this.bottomIndex) {
                this.delta = (this.offsetBottom - getHeight()) + ((position - this.bottomIndex) * this.aHeight);
                this.bottomIndex = position;
                this.offsetBottom = getHeight();
                this.topToBottom = false;
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.bottomIndex < getItemCount() - 1 || this.topIndex > 0 || this.offsetTop < 0 || this.offsetBottom > getHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        this.layoutState = state;
        this.delta = dy;
        this.topToBottom = dy > 0;
        if (this.topIndex == 0) {
            int i = this.offsetTop;
            if (i - dy > 0) {
                this.delta = i;
                this.topToBottom = true;
            }
        }
        if (this.bottomIndex == getItemCount() - 1 && this.offsetBottom - this.delta < getHeight()) {
            this.delta = this.offsetBottom - getHeight();
            this.topToBottom = false;
        }
        int i2 = this.offsetTop;
        int i3 = this.delta;
        this.offsetTop = i2 - i3;
        this.offsetBottom -= i3;
        this.totalOffset -= i3;
        init();
        offsetChildren(-this.delta);
        this.views.clear();
        if (this.offsetBottom < getHeight()) {
            this.position = this.bottomIndex + 1;
            layout(recycler, this.offsetBottom, 0, false, false);
        } else {
            int i4 = this.offsetTop;
            if (i4 > 0) {
                this.position = this.topIndex - 1;
                layout(recycler, 0, i4, false, false);
            }
        }
        if (this.delta > 0) {
            tryLoadMore();
        } else {
            Runnable runnable = this.onTopOverScrolledRunnable;
            if (runnable != null) {
                runnable.run();
            }
        }
        return this.delta;
    }

    private final void tryLoadMore() {
        if (this.bottomIndex != getItemCount() - 1 || this.offsetBottom > getHeight()) {
            return;
        }
        getOnBottomOverScrolledRunnable().run();
    }

    private final void offsetChildren(int dy) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null && !isAtBigTop(childAt)) {
                childAt.offsetTopAndBottom(dy);
            }
        }
    }

    private final int getVisibleChildCount() {
        return (this.bottomIndex - this.topIndex) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return getExtentHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return getOffsetY();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return getHeight();
    }

    public final int getExtentHeight() {
        if (getVisibleChildCount() > 0) {
            return ((this.offsetBottom - this.offsetTop) * getItemCount()) / getVisibleChildCount();
        }
        return 0;
    }

    public final int getExtentWidth() {
        return getWidth();
    }

    public final int getOffsetY() {
        if (getVisibleChildCount() > 0) {
            return (((this.offsetBottom - this.offsetTop) * this.topIndex) / getVisibleChildCount()) - this.offsetTop;
        }
        return 0;
    }

    /* renamed from: findFirstVisibleItemPosition, reason: from getter */
    public final int getTopIndex() {
        return this.topIndex;
    }

    /* renamed from: findLastVisibleItemPosition, reason: from getter */
    public final int getBottomIndex() {
        return this.bottomIndex;
    }

    @Override // com.devexpress.dxgrid.utils.providers.LayoutProvider
    public boolean getDidStructureChanged() {
        RecyclerView.State state = this.layoutState;
        if (state == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutState");
            state = null;
        }
        return state.didStructureChange();
    }

    @Override // com.devexpress.dxgrid.utils.providers.LayoutProvider
    public int getDefaultRowHeight() {
        if (this.rowHeightProvider.getFixedRowHeight()) {
            return this.rowHeightProvider.getRowHeight();
        }
        int i = this.aHeight;
        if (i > 0) {
            return i;
        }
        return 150;
    }
}
