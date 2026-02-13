package com.devexpress.dxlistview.core;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Property;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewOutlineProvider;
import androidx.core.app.NotificationCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.devexpress.dxlistview.AffectedIndexRange;
import com.devexpress.dxlistview.IVirtualScrollView;
import com.devexpress.dxlistview.ListViewListener;
import com.devexpress.dxlistview.helpers.MathHelper;
import com.devexpress.dxlistview.layouts.ComplexItemsLayout;
import com.devexpress.dxlistview.layouts.LayoutElement;
import com.devexpress.dxlistview.layouts.LayoutSpanContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DragDropManager.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0016\u0018\u0000 m2\u00020\u0001:\u0001mB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010<\u001a\u00020\u00192\u0006\u0010=\u001a\u000202H\u0002J\u0018\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u0002022\u0006\u0010@\u001a\u000202H\u0002J\u0010\u0010A\u001a\u00020\u00192\u0006\u0010?\u001a\u000202H\u0002J\u0006\u0010B\u001a\u00020CJ\u0018\u0010D\u001a\u00020\u00192\u0006\u0010=\u001a\u0002022\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020CH\u0002J8\u0010H\u001a\u00020\u001f2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020%2\u0006\u0010L\u001a\u00020%2\u0006\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020%H\u0002J\u0010\u0010P\u001a\u00020C2\u0006\u0010Q\u001a\u00020RH\u0016J\u0018\u0010S\u001a\u00020C2\u0006\u0010?\u001a\u0002022\u0006\u0010@\u001a\u000202H\u0002J\u0018\u0010T\u001a\u00020C2\u0006\u0010?\u001a\u0002022\u0006\u0010@\u001a\u000202H\u0002J\u0018\u0010U\u001a\u00020C2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u0019H\u0002J\b\u0010Y\u001a\u00020CH\u0002J\u0010\u0010Z\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020RH\u0016J&\u0010[\u001a\u00020C2\u0006\u0010\\\u001a\u0002022\u0006\u0010]\u001a\u0002022\u0006\u0010^\u001a\u00020W2\u0006\u0010V\u001a\u00020WJ\u0018\u0010_\u001a\u00020C2\u0006\u0010?\u001a\u0002022\u0006\u0010@\u001a\u000202H\u0002J\u0010\u0010`\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010a\u001a\u00020C2\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010b\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010c\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020RH\u0016J\u0006\u0010d\u001a\u00020CJ\u0018\u0010e\u001a\u00020C2\u0006\u0010f\u001a\u00020%2\u0006\u0010g\u001a\u00020%H\u0002J\u0006\u0010h\u001a\u00020CJ\u0010\u0010i\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010j\u001a\u00020CH\u0002J\u0010\u0010k\u001a\u00020C2\u0006\u0010l\u001a\u00020!H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\"\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001bR\u0010\u0010#\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00103\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b4\u00105R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lcom/devexpress/dxlistview/core/DragDropManager;", "Lcom/devexpress/dxlistview/core/GestureInteractionListener;", "context", "Landroid/content/Context;", "layout", "Lcom/devexpress/dxlistview/layouts/ComplexItemsLayout;", "adapter", "Lcom/devexpress/dxlistview/core/DXAsyncViewAdapter;", "scrollingHelper", "Lcom/devexpress/dxlistview/core/ScrollingHelper;", "scrollView", "Lcom/devexpress/dxlistview/IVirtualScrollView;", "(Landroid/content/Context;Lcom/devexpress/dxlistview/layouts/ComplexItemsLayout;Lcom/devexpress/dxlistview/core/DXAsyncViewAdapter;Lcom/devexpress/dxlistview/core/ScrollingHelper;Lcom/devexpress/dxlistview/IVirtualScrollView;)V", "_motionDirection", "Lcom/devexpress/dxlistview/core/MotionDirection;", "actualLayouts", "Landroid/util/SparseArray;", "Lcom/devexpress/dxlistview/core/ElementHolder;", "getAdapter", "()Lcom/devexpress/dxlistview/core/DXAsyncViewAdapter;", "setAdapter", "(Lcom/devexpress/dxlistview/core/DXAsyncViewAdapter;)V", "affectedIndexRange", "Lcom/devexpress/dxlistview/AffectedIndexRange;", "animationEnabled", "", "getAnimationEnabled", "()Z", "setAnimationEnabled", "(Z)V", "animator", "Landroid/animation/AnimatorSet;", "initialStartDragging", "Landroid/graphics/Point;", "isInDraggingProcess", "lastDraggingPoint", "lastMoveX", "", "lastMoveY", "getLayout", "()Lcom/devexpress/dxlistview/layouts/ComplexItemsLayout;", "setLayout", "(Lcom/devexpress/dxlistview/layouts/ComplexItemsLayout;)V", "listViewListener", "Lcom/devexpress/dxlistview/ListViewListener;", "getListViewListener", "()Lcom/devexpress/dxlistview/ListViewListener;", "setListViewListener", "(Lcom/devexpress/dxlistview/ListViewListener;)V", "mTouchSlop", "", "motionDirection", "getMotionDirection", "()Lcom/devexpress/dxlistview/core/MotionDirection;", "selectedContainer", "Lcom/devexpress/dxlistview/layouts/LayoutSpanContainer;", "selectedItem", "Lcom/devexpress/dxlistview/layouts/LayoutElement;", "state", "Lcom/devexpress/dxlistview/core/DragDropState;", "canDrag", "index", "canDrop", "sourceIndex", "targetIndex", "canStartDrag", "cancel", "", "checkIsAffectedInRange", "range", "Lcom/devexpress/dxlistview/core/RangeInt;", "clearState", "createAnimator", "animationOptions", "Lcom/devexpress/dxlistview/core/AnimationOptions;", "scale", "elevation", "alpha", "offsetX", "offsetY", "down", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "drop", "endDrop", "endMoveItem", "completeAction", "Ljava/lang/Runnable;", "toEnd", "liftSelectedItem", "move", "moveItem", "fromIndex", "toIndex", "updateSource", "notifyListener", "onDoubleTap", "onLongPress", "onSingleTapConfirmed", "onSingleTapUp", "process", "processDrag", "x", "y", "stopDraggingProcess", "up", "updateActualLayout", "updateAffectedIndexRange", "point", "Companion", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class DragDropManager implements GestureInteractionListener {
    private static final long DROP_ANIMATION_DURATION = 200;
    private static final float ELEVATION_VALUE = 8.0f;
    private static final long LIFT_ANIMATION_DURATION = 100;
    private static final long MOVE_ANIMATION_DURATION = 500;
    private static final float SCALE_FACTOR = 1.02f;
    private MotionDirection _motionDirection;
    private final SparseArray<ElementHolder> actualLayouts;
    private DXAsyncViewAdapter adapter;
    private AffectedIndexRange affectedIndexRange;
    private boolean animationEnabled;
    private AnimatorSet animator;
    private Point initialStartDragging;
    private Point lastDraggingPoint;
    private float lastMoveX;
    private float lastMoveY;
    private ComplexItemsLayout layout;
    private ListViewListener listViewListener;
    private final int mTouchSlop;
    private final IVirtualScrollView scrollView;
    private final ScrollingHelper scrollingHelper;
    private LayoutSpanContainer selectedContainer;
    private LayoutElement selectedItem;
    private DragDropState state;

    public DragDropManager(Context context, ComplexItemsLayout complexItemsLayout, DXAsyncViewAdapter dXAsyncViewAdapter, ScrollingHelper scrollingHelper, IVirtualScrollView scrollView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scrollingHelper, "scrollingHelper");
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        this.layout = complexItemsLayout;
        this.adapter = dXAsyncViewAdapter;
        this.scrollingHelper = scrollingHelper;
        this.scrollView = scrollView;
        this.animationEnabled = true;
        this._motionDirection = MotionDirection.None;
        this.state = DragDropState.Unknown;
        this.actualLayouts = new SparseArray<>();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public final ComplexItemsLayout getLayout() {
        return this.layout;
    }

    public final void setLayout(ComplexItemsLayout complexItemsLayout) {
        this.layout = complexItemsLayout;
    }

    public final DXAsyncViewAdapter getAdapter() {
        return this.adapter;
    }

    public final void setAdapter(DXAsyncViewAdapter dXAsyncViewAdapter) {
        this.adapter = dXAsyncViewAdapter;
    }

    public final ListViewListener getListViewListener() {
        return this.listViewListener;
    }

    public final void setListViewListener(ListViewListener listViewListener) {
        this.listViewListener = listViewListener;
    }

    public final boolean getAnimationEnabled() {
        return this.animationEnabled;
    }

    public final void setAnimationEnabled(boolean z) {
        this.animationEnabled = z;
    }

    public final boolean isInDraggingProcess() {
        return this.state == DragDropState.Dragging;
    }

    /* renamed from: getMotionDirection, reason: from getter */
    public final MotionDirection get_motionDirection() {
        return this._motionDirection;
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public boolean onSingleTapUp(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.scrollView.raiseItemTap(event);
        return true;
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public boolean onSingleTapConfirmed(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.scrollView.raiseItemTapConfirmed(event);
        return true;
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public boolean onDoubleTap(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.scrollView.raiseItemDoubleTap(event);
        return true;
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public void onLongPress(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.state == DragDropState.Unknown) {
            this.initialStartDragging = new Point(MathHelper.round(event.getX()), MathHelper.round(event.getY()));
            ComplexItemsLayout complexItemsLayout = this.layout;
            Intrinsics.checkNotNull(complexItemsLayout);
            Point point = this.initialStartDragging;
            Intrinsics.checkNotNull(point);
            LayoutElement findElementBy = complexItemsLayout.findElementBy(point);
            if (findElementBy == null || !canStartDrag(findElementBy.getIndex())) {
                return;
            }
            DXAsyncViewAdapter dXAsyncViewAdapter = this.adapter;
            Intrinsics.checkNotNull(dXAsyncViewAdapter);
            dXAsyncViewAdapter.freezeView(findElementBy.getIndex(), findElementBy.getView());
            this.selectedItem = findElementBy;
            ComplexItemsLayout complexItemsLayout2 = this.layout;
            Intrinsics.checkNotNull(complexItemsLayout2);
            this.selectedContainer = complexItemsLayout2.getLayouts().get(findElementBy.getIndex());
            this.state = DragDropState.Dragging;
            this.lastDraggingPoint = this.initialStartDragging;
            LayoutElement layoutElement = this.selectedItem;
            Intrinsics.checkNotNull(layoutElement);
            this.affectedIndexRange = new AffectedIndexRange(layoutElement.getIndex());
            liftSelectedItem();
        }
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public boolean move(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        float x = event.getX() - this.lastMoveX;
        float y = event.getY() - this.lastMoveY;
        int i = -1;
        int i2 = Math.abs(x) <= ((float) this.mTouchSlop) ? 0 : x > 0.0f ? -1 : 1;
        if (Math.abs(y) <= this.mTouchSlop) {
            i = 0;
        } else if (y <= 0.0f) {
            i = 1;
        }
        if (i2 == 0 && i == 0) {
            this._motionDirection = MotionDirection.None;
        }
        if (Math.abs(i) > 0) {
            this._motionDirection = i < 0 ? MotionDirection.TopToBottom : MotionDirection.BottomToTop;
        }
        if (Math.abs(i2) > 0) {
            this._motionDirection = i2 < 0 ? MotionDirection.LeftToRight : MotionDirection.RightToLeft;
        }
        this.lastMoveX = event.getX();
        this.lastMoveY = event.getY();
        if (!isInDraggingProcess()) {
            return false;
        }
        processDrag(this.lastMoveX, this.lastMoveY);
        return true;
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public void down(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.lastMoveX = event.getX();
        this.lastMoveY = event.getY();
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public boolean up(MotionEvent event) {
        int i;
        int i2;
        int end;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isInDraggingProcess()) {
            return false;
        }
        LayoutElement layoutElement = this.selectedItem;
        Intrinsics.checkNotNull(layoutElement);
        int index = layoutElement.getIndex();
        AffectedIndexRange affectedIndexRange = this.affectedIndexRange;
        Intrinsics.checkNotNull(affectedIndexRange);
        if (affectedIndexRange.getSize() == 0) {
            end = -1;
        } else {
            Point point = new Point(MathHelper.round(event.getX()), MathHelper.round(event.getY()));
            if (this.scrollView.isVertical()) {
                i = point.y;
                Point point2 = this.initialStartDragging;
                Intrinsics.checkNotNull(point2);
                i2 = point2.y;
            } else {
                i = point.x;
                Point point3 = this.initialStartDragging;
                Intrinsics.checkNotNull(point3);
                i2 = point3.x;
            }
            if (i - i2 < 0) {
                AffectedIndexRange affectedIndexRange2 = this.affectedIndexRange;
                Intrinsics.checkNotNull(affectedIndexRange2);
                end = affectedIndexRange2.getStart();
            } else {
                AffectedIndexRange affectedIndexRange3 = this.affectedIndexRange;
                Intrinsics.checkNotNull(affectedIndexRange3);
                end = affectedIndexRange3.getEnd();
            }
        }
        drop(index, end);
        return true;
    }

    public final void cancel() {
        if (this.state == DragDropState.Dragging) {
            clearState();
        }
    }

    public final void process() {
        if (isInDraggingProcess()) {
            processDrag(this.lastMoveX, this.lastMoveY);
        }
    }

    public final void moveItem(int fromIndex, int toIndex, Runnable updateSource, final Runnable completeAction) {
        float f;
        FastOutSlowInInterpolator fastOutSlowInInterpolator;
        float left;
        float f2;
        Intrinsics.checkNotNullParameter(updateSource, "updateSource");
        Intrinsics.checkNotNullParameter(completeAction, "completeAction");
        ComplexItemsLayout complexItemsLayout = this.layout;
        Intrinsics.checkNotNull(complexItemsLayout);
        LayoutSpanContainer firstVisibleContainer = complexItemsLayout.getFirstVisibleContainer();
        ComplexItemsLayout complexItemsLayout2 = this.layout;
        Intrinsics.checkNotNull(complexItemsLayout2);
        LayoutSpanContainer lastVisibleContainer = complexItemsLayout2.getLastVisibleContainer();
        Intrinsics.checkNotNull(firstVisibleContainer);
        int start = firstVisibleContainer.getStart();
        Intrinsics.checkNotNull(lastVisibleContainer);
        int end = lastVisibleContainer.getEnd();
        final boolean z = fromIndex < toIndex;
        ComplexItemsLayout complexItemsLayout3 = this.layout;
        Intrinsics.checkNotNull(complexItemsLayout3);
        LayoutSpanContainer layoutSpanContainer = complexItemsLayout3.getLayouts().get(fromIndex);
        this.selectedContainer = layoutSpanContainer;
        this.selectedItem = layoutSpanContainer != null ? layoutSpanContainer.getFirstElement() : null;
        ComplexItemsLayout complexItemsLayout4 = this.layout;
        Intrinsics.checkNotNull(complexItemsLayout4);
        LayoutSpanContainer layoutSpanContainer2 = complexItemsLayout4.getLayouts().get(toIndex);
        LayoutElement layoutElement = this.selectedItem;
        boolean z2 = layoutElement == null && layoutSpanContainer2 != null;
        boolean z3 = layoutElement != null && layoutSpanContainer2 == null;
        if (layoutElement == null) {
            int i = z ? start : end;
            ComplexItemsLayout complexItemsLayout5 = this.layout;
            Intrinsics.checkNotNull(complexItemsLayout5);
            LayoutSpanContainer addContainerForPositionToCache = complexItemsLayout5.addContainerForPositionToCache(fromIndex, !z, i);
            this.selectedContainer = addContainerForPositionToCache;
            Intrinsics.checkNotNull(addContainerForPositionToCache);
            this.selectedItem = addContainerForPositionToCache.getFirstElement();
        }
        DXAsyncViewAdapter dXAsyncViewAdapter = this.adapter;
        Intrinsics.checkNotNull(dXAsyncViewAdapter);
        LayoutElement layoutElement2 = this.selectedItem;
        Intrinsics.checkNotNull(layoutElement2);
        int index = layoutElement2.getIndex();
        LayoutElement layoutElement3 = this.selectedItem;
        Intrinsics.checkNotNull(layoutElement3);
        dXAsyncViewAdapter.freezeView(index, layoutElement3.getView());
        LayoutSpanContainer layoutSpanContainer3 = this.selectedContainer;
        Intrinsics.checkNotNull(layoutSpanContainer3);
        int size = layoutSpanContainer3.getSize();
        if (!z2) {
            ComplexItemsLayout complexItemsLayout6 = this.layout;
            Intrinsics.checkNotNull(complexItemsLayout6);
            complexItemsLayout6.applyAdditionalLayoutAreaSize(size, z);
        }
        updateActualLayout();
        LayoutElement layoutElement4 = this.selectedItem;
        Intrinsics.checkNotNull(layoutElement4);
        View view = layoutElement4.getView();
        view.setOutlineProvider(null);
        view.setElevation(view.getContext().getResources().getDisplayMetrics().density * 8.0f);
        if (layoutSpanContainer2 == null) {
            if (!z) {
                end = start - size;
            }
            f = end;
        } else {
            int start2 = layoutSpanContainer2.getStart();
            int end2 = layoutSpanContainer2.getEnd();
            if (z) {
                start2 = end2 - size;
            }
            f = start2;
        }
        updateSource.run();
        RangeInt rangeInt = new RangeInt(fromIndex, toIndex);
        if (z) {
            size = -size;
        }
        if (z2) {
            fastOutSlowInInterpolator = new LinearOutSlowInInterpolator();
        } else if (z3) {
            fastOutSlowInInterpolator = new FastOutLinearInInterpolator();
        } else {
            fastOutSlowInInterpolator = new FastOutSlowInInterpolator();
        }
        AnimationOptions animationOptions = new AnimationOptions(MOVE_ANIMATION_DURATION, fastOutSlowInInterpolator);
        int size2 = this.actualLayouts.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ElementHolder valueAt = this.actualLayouts.valueAt(i2);
            if (rangeInt.inRange(valueAt.getIndex())) {
                if (this.scrollView.isVertical()) {
                    valueAt.translateY(size, this.animationEnabled ? animationOptions : null);
                } else {
                    valueAt.translateX(size, this.animationEnabled ? animationOptions : null);
                }
            }
        }
        if (!z3) {
            z = !z;
        }
        if (this.animationEnabled) {
            if (this.scrollView.isVertical()) {
                left = 0.0f;
            } else {
                Intrinsics.checkNotNull(this.selectedItem);
                left = f - r0.getLeft();
            }
            if (this.scrollView.isVertical()) {
                Intrinsics.checkNotNull(this.selectedItem);
                f2 = f - r0.getTop();
            } else {
                f2 = 0.0f;
            }
            AnimatorSet createAnimator = createAnimator(animationOptions, 1.0f, 0.0f, 1.0f, left, f2);
            this.animator = createAnimator;
            Intrinsics.checkNotNull(createAnimator);
            createAnimator.addListener(new Animator.AnimatorListener() { // from class: com.devexpress.dxlistview.core.DragDropManager$moveItem$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    DragDropManager.this.endMoveItem(completeAction, z);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    DragDropManager.this.endMoveItem(completeAction, z);
                }
            });
            AnimatorSet animatorSet = this.animator;
            Intrinsics.checkNotNull(animatorSet);
            animatorSet.start();
            return;
        }
        endMoveItem(completeAction, z);
    }

    public final void stopDraggingProcess() {
        if (isInDraggingProcess()) {
            LayoutElement layoutElement = this.selectedItem;
            Intrinsics.checkNotNull(layoutElement);
            int index = layoutElement.getIndex();
            LayoutElement layoutElement2 = this.selectedItem;
            Intrinsics.checkNotNull(layoutElement2);
            drop(index, layoutElement2.getIndex());
        }
    }

    private final void liftSelectedItem() {
        LayoutElement layoutElement = this.selectedItem;
        Intrinsics.checkNotNull(layoutElement);
        View view = layoutElement.getView();
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        if (this.animationEnabled) {
            AnimatorSet createAnimator = createAnimator(new AnimationOptions(LIFT_ANIMATION_DURATION, null, 2, null), SCALE_FACTOR, 8.0f, 0.99f, 0.0f, 0.0f);
            this.animator = createAnimator;
            Intrinsics.checkNotNull(createAnimator);
            createAnimator.start();
            return;
        }
        view.setScaleX(SCALE_FACTOR);
        view.setScaleY(SCALE_FACTOR);
        view.setElevation(view.getContext().getResources().getDisplayMetrics().density * 8.0f);
    }

    private final void updateAffectedIndexRange(Point point) {
        RangeInt rangeInt;
        int i;
        int i2;
        int i3;
        if (this.scrollView.isVertical()) {
            int i4 = point.y;
            Point point2 = this.lastDraggingPoint;
            Intrinsics.checkNotNull(point2);
            rangeInt = new RangeInt(i4, point2.y);
        } else {
            int i5 = point.x;
            Point point3 = this.lastDraggingPoint;
            Intrinsics.checkNotNull(point3);
            rangeInt = new RangeInt(i5, point3.x);
        }
        if (this.scrollView.isVertical()) {
            i = point.y;
            Point point4 = this.lastDraggingPoint;
            Intrinsics.checkNotNull(point4);
            i2 = point4.y;
        } else {
            i = point.x;
            Point point5 = this.lastDraggingPoint;
            Intrinsics.checkNotNull(point5);
            i2 = point5.x;
        }
        int i6 = i - i2;
        int i7 = 0;
        if (i6 > 0) {
            int size = this.actualLayouts.size();
            i3 = 0;
            while (i7 < size) {
                if (checkIsAffectedInRange(i7, rangeInt)) {
                    i3 = 1;
                }
                i7++;
            }
        } else {
            for (int size2 = this.actualLayouts.size() - 1; -1 < size2; size2--) {
                if (checkIsAffectedInRange(size2, rangeInt)) {
                    i7 = 1;
                }
            }
            i3 = i7;
        }
        if (i3 != 0) {
            this.lastDraggingPoint = point;
        }
    }

    private final boolean checkIsAffectedInRange(int index, RangeInt range) {
        ElementHolder valueAt = this.actualLayouts.valueAt(index);
        Intrinsics.checkNotNull(valueAt);
        int index2 = valueAt.getIndex();
        LayoutElement layoutElement = this.selectedItem;
        Intrinsics.checkNotNull(layoutElement);
        if (index2 == layoutElement.getIndex()) {
            return false;
        }
        Rect renderContentBounds = valueAt.getRenderContentBounds();
        if (!range.inRange(this.scrollView.isVertical() ? renderContentBounds.centerY() : renderContentBounds.centerX()) || !canDrag(index2)) {
            return false;
        }
        AffectedIndexRange affectedIndexRange = this.affectedIndexRange;
        Intrinsics.checkNotNull(affectedIndexRange);
        affectedIndexRange.affect(index2);
        return true;
    }

    private final void updateActualLayout() {
        ComplexItemsLayout complexItemsLayout = this.layout;
        Intrinsics.checkNotNull(complexItemsLayout);
        SparseArray<LayoutSpanContainer> layouts = complexItemsLayout.getLayouts();
        SparseArray sparseArray = new SparseArray();
        AnimationOptions animationOptions = this.animationEnabled ? new AnimationOptions(DROP_ANIMATION_DURATION, null, 2, null) : null;
        int size = this.actualLayouts.size();
        for (int i = 0; i < size; i++) {
            ElementHolder valueAt = this.actualLayouts.valueAt(i);
            Intrinsics.checkNotNull(valueAt);
            if (layouts.get(valueAt.getIndex()) == null) {
                valueAt.resetTranslation(animationOptions);
                sparseArray.put(valueAt.getIndex(), valueAt);
            }
        }
        int size2 = sparseArray.size();
        for (int i2 = 0; i2 < size2; i2++) {
            SparseArray<ElementHolder> sparseArray2 = this.actualLayouts;
            Object valueAt2 = sparseArray.valueAt(i2);
            Intrinsics.checkNotNull(valueAt2);
            sparseArray2.remove(((ElementHolder) valueAt2).getIndex());
        }
        int size3 = layouts.size();
        for (int i3 = 0; i3 < size3; i3++) {
            LayoutSpanContainer valueAt3 = layouts.valueAt(i3);
            Intrinsics.checkNotNull(valueAt3);
            int startIndex = valueAt3.getStartIndex();
            LayoutElement layoutElement = this.selectedItem;
            Intrinsics.checkNotNull(layoutElement);
            if (startIndex != layoutElement.getIndex() && this.actualLayouts.get(valueAt3.getStartIndex()) == null) {
                SparseArray<ElementHolder> sparseArray3 = this.actualLayouts;
                int startIndex2 = valueAt3.getStartIndex();
                LayoutElement firstElement = valueAt3.getFirstElement();
                Intrinsics.checkNotNullExpressionValue(firstElement, "getFirstElement(...)");
                sparseArray3.put(startIndex2, new ElementHolder(firstElement));
            }
        }
    }

    private final void processDrag(float x, float y) {
        updateActualLayout();
        Point point = new Point(MathHelper.round(x), MathHelper.round(y));
        updateAffectedIndexRange(point);
        LayoutSpanContainer layoutSpanContainer = this.selectedContainer;
        Intrinsics.checkNotNull(layoutSpanContainer);
        int size = layoutSpanContainer.getSize();
        AnimationOptions animationOptions = this.animationEnabled ? new AnimationOptions(DROP_ANIMATION_DURATION, null, 2, null) : null;
        int size2 = this.actualLayouts.size();
        for (int i = 0; i < size2; i++) {
            ElementHolder valueAt = this.actualLayouts.valueAt(i);
            AffectedIndexRange affectedIndexRange = this.affectedIndexRange;
            Intrinsics.checkNotNull(affectedIndexRange);
            Intrinsics.checkNotNull(valueAt);
            if (affectedIndexRange.isAffected(valueAt.getIndex())) {
                LayoutElement layoutElement = this.selectedItem;
                Intrinsics.checkNotNull(layoutElement);
                int i2 = layoutElement.getIndex() < valueAt.getIndex() ? -size : size;
                if (this.scrollView.isVertical()) {
                    valueAt.translateY(i2, animationOptions);
                } else {
                    valueAt.translateX(i2, animationOptions);
                }
            } else {
                valueAt.resetTranslation(animationOptions);
            }
        }
        if (this.scrollView.isVertical()) {
            LayoutElement layoutElement2 = this.selectedItem;
            Intrinsics.checkNotNull(layoutElement2);
            View view = layoutElement2.getView();
            float f = point.y;
            Intrinsics.checkNotNull(this.initialStartDragging);
            view.setTranslationY(f - r1.y);
        } else {
            LayoutElement layoutElement3 = this.selectedItem;
            Intrinsics.checkNotNull(layoutElement3);
            View view2 = layoutElement3.getView();
            float f2 = point.x;
            Intrinsics.checkNotNull(this.initialStartDragging);
            view2.setTranslationX(f2 - r1.x);
        }
        this.scrollingHelper.onPan(point);
    }

    private final AnimatorSet createAnimator(AnimationOptions animationOptions, float scale, float elevation, float alpha, float offsetX, float offsetY) {
        LayoutElement layoutElement = this.selectedItem;
        Intrinsics.checkNotNull(layoutElement);
        View view = layoutElement.getView();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, scale);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, scale);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, offsetX);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, offsetY);
        if (animationOptions.getInterpolator() != null) {
            ofFloat3.setInterpolator(animationOptions.getInterpolator());
            ofFloat4.setInterpolator(animationOptions.getInterpolator());
        }
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, alpha);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(animationOptions.getDuration());
        animatorSet.play(ofFloat).with(ofFloat2).with(ObjectAnimator.ofFloat(view, "elevation", elevation * view.getContext().getResources().getDisplayMetrics().density)).with(ofFloat3).with(ofFloat4).with(ofFloat5);
        return animatorSet;
    }

    private final void drop(final int sourceIndex, final int targetIndex) {
        Rect rect;
        int i;
        int i2;
        this.state = DragDropState.Dropping;
        this.scrollingHelper.stopAutoScroll();
        AnimatorSet animatorSet = this.animator;
        if (animatorSet != null) {
            Intrinsics.checkNotNull(animatorSet);
            if (animatorSet.isRunning()) {
                AnimatorSet animatorSet2 = this.animator;
                Intrinsics.checkNotNull(animatorSet2);
                animatorSet2.cancel();
            }
        }
        ElementHolder elementHolder = this.actualLayouts.get(targetIndex);
        if (elementHolder == null || (rect = elementHolder.getFrame()) == null) {
            LayoutElement layoutElement = this.selectedItem;
            Intrinsics.checkNotNull(layoutElement);
            int left = layoutElement.getLeft();
            LayoutElement layoutElement2 = this.selectedItem;
            Intrinsics.checkNotNull(layoutElement2);
            int top = layoutElement2.getTop();
            LayoutElement layoutElement3 = this.selectedItem;
            Intrinsics.checkNotNull(layoutElement3);
            int right = layoutElement3.getRight();
            LayoutElement layoutElement4 = this.selectedItem;
            Intrinsics.checkNotNull(layoutElement4);
            rect = new Rect(left, top, right, layoutElement4.getBottom());
        }
        LayoutElement layoutElement5 = this.selectedItem;
        Intrinsics.checkNotNull(layoutElement5);
        float f = -layoutElement5.getLeft();
        LayoutElement layoutElement6 = this.selectedItem;
        Intrinsics.checkNotNull(layoutElement6);
        float f2 = -layoutElement6.getTop();
        if (this.scrollView.isVertical()) {
            if (targetIndex > sourceIndex) {
                int i3 = rect.bottom;
                LayoutElement layoutElement7 = this.selectedItem;
                Intrinsics.checkNotNull(layoutElement7);
                i2 = i3 - layoutElement7.getHeight();
            } else {
                i2 = rect.top;
            }
            f2 += i2;
        } else {
            if (targetIndex > sourceIndex) {
                int i4 = rect.right;
                LayoutElement layoutElement8 = this.selectedItem;
                Intrinsics.checkNotNull(layoutElement8);
                i = i4 - layoutElement8.getWidth();
            } else {
                i = rect.left;
            }
            f += i;
        }
        float f3 = f;
        float f4 = f2;
        if (this.animationEnabled) {
            AnimatorSet createAnimator = createAnimator(new AnimationOptions(DROP_ANIMATION_DURATION, null, 2, null), 1.0f, 0.0f, 1.0f, f3, f4);
            this.animator = createAnimator;
            Intrinsics.checkNotNull(createAnimator);
            createAnimator.addListener(new Animator.AnimatorListener() { // from class: com.devexpress.dxlistview.core.DragDropManager$drop$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    DragDropManager.this.endDrop(sourceIndex, targetIndex);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    DragDropManager.this.endDrop(sourceIndex, targetIndex);
                }
            });
            AnimatorSet animatorSet3 = this.animator;
            Intrinsics.checkNotNull(animatorSet3);
            animatorSet3.start();
            return;
        }
        endDrop(sourceIndex, targetIndex);
    }

    private final void clearState() {
        this.state = DragDropState.Unknown;
        LayoutElement layoutElement = this.selectedItem;
        Intrinsics.checkNotNull(layoutElement);
        View view = layoutElement.getView();
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        view.setAlpha(1.0f);
        view.setElevation(0.0f);
        int size = this.actualLayouts.size();
        for (int i = 0; i < size; i++) {
            ElementHolder valueAt = this.actualLayouts.valueAt(i);
            Intrinsics.checkNotNull(valueAt);
            ElementHolder.resetTranslation$default(valueAt, null, 1, null);
        }
        this.actualLayouts.clear();
        DXAsyncViewAdapter dXAsyncViewAdapter = this.adapter;
        Intrinsics.checkNotNull(dXAsyncViewAdapter);
        LayoutElement layoutElement2 = this.selectedItem;
        Intrinsics.checkNotNull(layoutElement2);
        dXAsyncViewAdapter.defrostView(layoutElement2.getIndex());
        this.affectedIndexRange = null;
        this.selectedItem = null;
        this.selectedContainer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endMoveItem(Runnable completeAction, boolean toEnd) {
        DXAsyncViewAdapter dXAsyncViewAdapter = this.adapter;
        Intrinsics.checkNotNull(dXAsyncViewAdapter);
        LayoutElement layoutElement = this.selectedItem;
        Intrinsics.checkNotNull(layoutElement);
        dXAsyncViewAdapter.defrostView(layoutElement.getIndex());
        clearState();
        completeAction.run();
        ComplexItemsLayout complexItemsLayout = this.layout;
        Intrinsics.checkNotNull(complexItemsLayout);
        complexItemsLayout.resetAdditionalLayoutAreaSize();
        ComplexItemsLayout complexItemsLayout2 = this.layout;
        Intrinsics.checkNotNull(complexItemsLayout2);
        complexItemsLayout2.clearCachedContainers();
        ComplexItemsLayout complexItemsLayout3 = this.layout;
        Intrinsics.checkNotNull(complexItemsLayout3);
        complexItemsLayout3.updateItems(toEnd, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endDrop(int sourceIndex, int targetIndex) {
        clearState();
        if (targetIndex < 0 || sourceIndex == targetIndex) {
            return;
        }
        notifyListener(sourceIndex, targetIndex);
    }

    private final boolean canStartDrag(int sourceIndex) {
        DXAsyncViewAdapter dXAsyncViewAdapter = this.adapter;
        Intrinsics.checkNotNull(dXAsyncViewAdapter);
        if (!dXAsyncViewAdapter.isItemIndexExist(sourceIndex)) {
            return false;
        }
        ListViewListener listViewListener = this.listViewListener;
        if (listViewListener != null) {
            Intrinsics.checkNotNull(listViewListener);
            if (!listViewListener.canStartDrag(sourceIndex)) {
                return false;
            }
        }
        return true;
    }

    private final boolean canDrop(int sourceIndex, int targetIndex) {
        DXAsyncViewAdapter dXAsyncViewAdapter = this.adapter;
        Intrinsics.checkNotNull(dXAsyncViewAdapter);
        if (!dXAsyncViewAdapter.isItemIndexExist(targetIndex)) {
            return false;
        }
        ListViewListener listViewListener = this.listViewListener;
        if (listViewListener != null) {
            Intrinsics.checkNotNull(listViewListener);
            if (!listViewListener.canDrop(sourceIndex, targetIndex)) {
                return false;
            }
        }
        return true;
    }

    private final void notifyListener(int sourceIndex, int targetIndex) {
        if (this.listViewListener != null && canDrop(sourceIndex, targetIndex)) {
            ComplexItemsLayout complexItemsLayout = this.layout;
            Intrinsics.checkNotNull(complexItemsLayout);
            complexItemsLayout.isUpdateLocked = true;
            ListViewListener listViewListener = this.listViewListener;
            Intrinsics.checkNotNull(listViewListener);
            listViewListener.drop(sourceIndex, targetIndex);
            ComplexItemsLayout complexItemsLayout2 = this.layout;
            Intrinsics.checkNotNull(complexItemsLayout2);
            complexItemsLayout2.isUpdateLocked = false;
        }
        ComplexItemsLayout complexItemsLayout3 = this.layout;
        Intrinsics.checkNotNull(complexItemsLayout3);
        complexItemsLayout3.updateItems();
    }

    private final boolean canDrag(int index) {
        LayoutElement layoutElement = this.selectedItem;
        Intrinsics.checkNotNull(layoutElement);
        return canDrop(layoutElement.getIndex(), index);
    }
}
