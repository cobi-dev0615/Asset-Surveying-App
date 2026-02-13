package com.devexpress.dxlistview.swipes;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.devexpress.dxlistview.DXVirtualScrollView;
import com.devexpress.dxlistview.core.DXAsyncViewAdapter;
import com.devexpress.dxlistview.core.GestureInteractionListener;
import com.devexpress.dxlistview.helpers.MathHelper;
import com.devexpress.dxlistview.layouts.ComplexItemsLayout;
import com.devexpress.dxlistview.layouts.ItemContainerLayout;
import com.devexpress.dxlistview.layouts.LayoutElement;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwipesManager.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001a\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u000208J \u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020\u000fH\u0002J\u0018\u0010?\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<H\u0002J\u0010\u0010@\u001a\u0002082\u0006\u00105\u001a\u000206H\u0016J\u000f\u0010A\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0002\bBJ\u0012\u0010C\u001a\u0004\u0018\u00010\u000f2\u0006\u0010D\u001a\u00020 H\u0002J\u000f\u0010E\u001a\u0004\u0018\u00010,H\u0000¢\u0006\u0002\bFJ\u0010\u0010G\u001a\u00020\u00172\b\b\u0002\u0010H\u001a\u00020\u0017J\u0010\u0010I\u001a\u00020\u00172\u0006\u00105\u001a\u000206H\u0016J\u0010\u0010J\u001a\u00020\u00172\u0006\u00105\u001a\u000206H\u0016J\u0010\u0010K\u001a\u0002082\u0006\u00105\u001a\u000206H\u0016J\u0016\u0010L\u001a\u0002082\u0006\u0010M\u001a\u00020<2\u0006\u0010N\u001a\u00020<J\u0010\u0010O\u001a\u00020\u00172\u0006\u00105\u001a\u000206H\u0016J\u0010\u0010P\u001a\u00020\u00172\u0006\u00105\u001a\u000206H\u0016J\u0010\u0010Q\u001a\u0002082\u0006\u0010R\u001a\u00020\u000fH\u0016J\u0010\u0010S\u001a\u00020\u00172\u0006\u00105\u001a\u000206H\u0016J\u0010\u0010T\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u000fH\u0002J\u0010\u0010U\u001a\u00020\u00172\u0006\u0010D\u001a\u00020 H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R(\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020,0.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006V"}, d2 = {"Lcom/devexpress/dxlistview/swipes/SwipesManager;", "Lcom/devexpress/dxlistview/core/GestureInteractionListener;", "Lcom/devexpress/dxlistview/swipes/RecycleListener;", "context", "Landroid/content/Context;", "_itemsLayout", "Lcom/devexpress/dxlistview/layouts/ComplexItemsLayout;", "swipesViewProvider", "Lcom/devexpress/dxlistview/swipes/DXSwipeItemsViewProvider;", "scrollView", "Lcom/devexpress/dxlistview/DXVirtualScrollView;", "(Landroid/content/Context;Lcom/devexpress/dxlistview/layouts/ComplexItemsLayout;Lcom/devexpress/dxlistview/swipes/DXSwipeItemsViewProvider;Lcom/devexpress/dxlistview/DXVirtualScrollView;)V", "getContext", "()Landroid/content/Context;", "currentItemLayout", "Lcom/devexpress/dxlistview/layouts/LayoutElement;", "innerItemExtractor", "Lcom/devexpress/dxlistview/swipes/IInnerItemExtractor;", "getInnerItemExtractor", "()Lcom/devexpress/dxlistview/swipes/IInnerItemExtractor;", "setInnerItemExtractor", "(Lcom/devexpress/dxlistview/swipes/IInnerItemExtractor;)V", "isProcessing", "", "()Z", "value", "itemsLayout", "getItemsLayout", "()Lcom/devexpress/dxlistview/layouts/ComplexItemsLayout;", "setItemsLayout", "(Lcom/devexpress/dxlistview/layouts/ComplexItemsLayout;)V", "lastPointDown", "Landroid/graphics/Point;", "needUpdateInitialPoint", "parentState", "Lcom/devexpress/dxlistview/swipes/ParentScrollingState;", "singleTapUpDetected", "swipeViewListener", "Lcom/devexpress/dxlistview/swipes/SwipeViewListener;", "getSwipeViewListener", "()Lcom/devexpress/dxlistview/swipes/SwipeViewListener;", "setSwipeViewListener", "(Lcom/devexpress/dxlistview/swipes/SwipeViewListener;)V", "swipeViewManager", "Lcom/devexpress/dxlistview/swipes/SwipeViewManager;", "swipeViewManagerCache", "", "", "getSwipesViewProvider", "()Lcom/devexpress/dxlistview/swipes/DXSwipeItemsViewProvider;", "setSwipesViewProvider", "(Lcom/devexpress/dxlistview/swipes/DXSwipeItemsViewProvider;)V", "canInterceptTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "cancel", "", "convertToElementCoordinates", "Landroid/graphics/PointF;", "x", "", "y", "element", "convertToPoint", "down", "getCurrentItemLayout", "getCurrentItemLayout$dxlistview_release", "getElementByPoint", "point", "getSwipeViewManager", "getSwipeViewManager$dxlistview_release", "hideSwipeItems", "animated", "move", "onDoubleTap", "onLongPress", "onParentScroll", "distanceX", "distanceY", "onSingleTapConfirmed", "onSingleTapUp", "recycleItem", "item", "up", "updateSwipeViewManager", "updateSwipeViewManagerIfNecessary", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class SwipesManager implements GestureInteractionListener, RecycleListener {
    private ComplexItemsLayout _itemsLayout;
    private final Context context;
    private LayoutElement currentItemLayout;
    private IInnerItemExtractor innerItemExtractor;
    private Point lastPointDown;
    private boolean needUpdateInitialPoint;
    private ParentScrollingState parentState;
    private final DXVirtualScrollView scrollView;
    private boolean singleTapUpDetected;
    private SwipeViewListener swipeViewListener;
    private SwipeViewManager swipeViewManager;
    private Map<Integer, SwipeViewManager> swipeViewManagerCache;
    private DXSwipeItemsViewProvider swipesViewProvider;

    public SwipesManager(Context context, ComplexItemsLayout complexItemsLayout, DXSwipeItemsViewProvider dXSwipeItemsViewProvider, DXVirtualScrollView scrollView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        this.context = context;
        this._itemsLayout = complexItemsLayout;
        this.swipesViewProvider = dXSwipeItemsViewProvider;
        this.scrollView = scrollView;
        this.swipeViewManagerCache = new LinkedHashMap();
        this.parentState = ParentScrollingState.Unknown;
    }

    public final Context getContext() {
        return this.context;
    }

    public final DXSwipeItemsViewProvider getSwipesViewProvider() {
        return this.swipesViewProvider;
    }

    public final void setSwipesViewProvider(DXSwipeItemsViewProvider dXSwipeItemsViewProvider) {
        this.swipesViewProvider = dXSwipeItemsViewProvider;
    }

    public final IInnerItemExtractor getInnerItemExtractor() {
        return this.innerItemExtractor;
    }

    public final void setInnerItemExtractor(IInnerItemExtractor iInnerItemExtractor) {
        this.innerItemExtractor = iInnerItemExtractor;
    }

    public final SwipeViewListener getSwipeViewListener() {
        return this.swipeViewListener;
    }

    public final void setSwipeViewListener(SwipeViewListener swipeViewListener) {
        this.swipeViewListener = swipeViewListener;
    }

    public final boolean isProcessing() {
        SwipeViewManager swipeViewManager = this.swipeViewManager;
        if (swipeViewManager != null) {
            Intrinsics.checkNotNull(swipeViewManager);
            if (!swipeViewManager.isInOpeningProcess()) {
                SwipeViewManager swipeViewManager2 = this.swipeViewManager;
                Intrinsics.checkNotNull(swipeViewManager2);
                if (swipeViewManager2.isOpened()) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: getItemsLayout, reason: from getter */
    public final ComplexItemsLayout get_itemsLayout() {
        return this._itemsLayout;
    }

    public final void setItemsLayout(ComplexItemsLayout complexItemsLayout) {
        this._itemsLayout = complexItemsLayout;
        if (complexItemsLayout != null) {
            complexItemsLayout.setRecycleListener(this);
        }
    }

    public final boolean canInterceptTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            down(event);
            return false;
        }
        if (action != 2) {
            return false;
        }
        return move(event);
    }

    private final LayoutElement getElementByPoint(Point point) {
        ComplexItemsLayout complexItemsLayout = get_itemsLayout();
        if (complexItemsLayout != null) {
            return complexItemsLayout.findElementBy(point);
        }
        return null;
    }

    private final boolean updateSwipeViewManager(LayoutElement element) {
        ItemContainerLayout itemContainerLayout;
        SwipeViewManager swipeViewManager;
        if (!Intrinsics.areEqual(element, this.currentItemLayout)) {
            if (isProcessing()) {
                hideSwipeItems$default(this, false, 1, null);
            }
            IInnerItemExtractor iInnerItemExtractor = this.innerItemExtractor;
            if (iInnerItemExtractor != null) {
                View view = element.getView();
                Intrinsics.checkNotNullExpressionValue(view, "getView(...)");
                itemContainerLayout = iInnerItemExtractor.extractContainerLayout(view);
            } else {
                itemContainerLayout = null;
            }
            boolean IS_ITEM = DXAsyncViewAdapter.IS_ITEM(element.getViewType());
            if (itemContainerLayout == null || !IS_ITEM) {
                this.swipeViewManager = null;
                this.currentItemLayout = null;
            } else {
                if (this.swipeViewManagerCache.containsKey(Integer.valueOf(element.getIndex()))) {
                    swipeViewManager = this.swipeViewManagerCache.get(Integer.valueOf(element.getIndex()));
                } else {
                    swipeViewManager = new SwipeViewManager(this.context, itemContainerLayout, new DXSwipeItemsViewAdapter(this.context, this.swipeViewListener, this.scrollView.isVertical(), element.getIndex(), this.swipesViewProvider));
                }
                this.swipeViewManager = swipeViewManager;
                this.currentItemLayout = element;
                Map<Integer, SwipeViewManager> map = this.swipeViewManagerCache;
                Intrinsics.checkNotNull(element);
                Integer valueOf = Integer.valueOf(element.getIndex());
                SwipeViewManager swipeViewManager2 = this.swipeViewManager;
                Intrinsics.checkNotNull(swipeViewManager2);
                map.put(valueOf, swipeViewManager2);
            }
        }
        return this.swipeViewManager != null;
    }

    private final Point convertToPoint(float x, float y) {
        return new Point(MathHelper.round(x), MathHelper.round(y));
    }

    private final PointF convertToElementCoordinates(float x, float y, LayoutElement element) {
        return new PointF(x - element.getLeft(), y - element.getTop());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
    
        if (r0.contains(r5.x, r5.y) == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean updateSwipeViewManagerIfNecessary(android.graphics.Point r5) {
        /*
            r4 = this;
            com.devexpress.dxlistview.swipes.SwipeViewManager r0 = r4.swipeViewManager
            r1 = 1
            if (r0 == 0) goto L25
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.isClosed()
            if (r0 != 0) goto L25
            boolean r0 = r4.needUpdateInitialPoint
            if (r0 == 0) goto L24
            com.devexpress.dxlistview.layouts.LayoutElement r0 = r4.currentItemLayout
            if (r0 == 0) goto L24
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r2 = r5.x
            int r3 = r5.y
            boolean r0 = r0.contains(r2, r3)
            if (r0 != 0) goto L24
            goto L25
        L24:
            return r1
        L25:
            com.devexpress.dxlistview.layouts.LayoutElement r5 = r4.getElementByPoint(r5)
            if (r5 == 0) goto L32
            boolean r5 = r4.updateSwipeViewManager(r5)
            if (r5 == 0) goto L32
            goto L33
        L32:
            r1 = 0
        L33:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.dxlistview.swipes.SwipesManager.updateSwipeViewManagerIfNecessary(android.graphics.Point):boolean");
    }

    public final void onParentScroll(float distanceX, float distanceY) {
        if (this.parentState != ParentScrollingState.Unknown) {
            return;
        }
        if ((Math.abs(distanceY) > Math.abs(distanceX) && this.scrollView.isVertical()) || (Math.abs(distanceX) > Math.abs(distanceY) && !this.scrollView.isVertical())) {
            this.parentState = ParentScrollingState.True;
            if (isProcessing()) {
                hideSwipeItems$default(this, false, 1, null);
                return;
            }
            return;
        }
        this.parentState = ParentScrollingState.False;
    }

    public final void cancel() {
        Iterator<T> it = this.swipeViewManagerCache.values().iterator();
        while (it.hasNext()) {
            ((SwipeViewManager) it.next()).cancel();
        }
    }

    public static /* synthetic */ boolean hideSwipeItems$default(SwipesManager swipesManager, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideSwipeItems");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return swipesManager.hideSwipeItems(z);
    }

    public final boolean hideSwipeItems(boolean animated) {
        SwipeViewManager swipeViewManager = this.swipeViewManager;
        if (swipeViewManager == null) {
            return false;
        }
        Intrinsics.checkNotNull(swipeViewManager);
        return SwipeViewManager.closeSwipe$default(swipeViewManager, animated, null, 2, null);
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public void onLongPress(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        hideSwipeItems$default(this, false, 1, null);
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public void down(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.parentState == ParentScrollingState.True) {
            return;
        }
        this.lastPointDown = convertToPoint(event.getX(), event.getY());
        this.needUpdateInitialPoint = true;
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public boolean onSingleTapUp(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.singleTapUpDetected = false;
        if (this.parentState != ParentScrollingState.True && this.swipeViewManager != null) {
            Point convertToPoint = convertToPoint(event.getX(), event.getY());
            LayoutElement layoutElement = this.currentItemLayout;
            if (layoutElement != null) {
                Intrinsics.checkNotNull(layoutElement);
                if (!layoutElement.contains(convertToPoint.x, convertToPoint.y)) {
                    this.singleTapUpDetected = hideSwipeItems$default(this, false, 1, null);
                }
            }
            float x = event.getX();
            float y = event.getY();
            LayoutElement layoutElement2 = this.currentItemLayout;
            Intrinsics.checkNotNull(layoutElement2);
            PointF convertToElementCoordinates = convertToElementCoordinates(x, y, layoutElement2);
            SwipeViewManager swipeViewManager = this.swipeViewManager;
            Intrinsics.checkNotNull(swipeViewManager);
            this.singleTapUpDetected = swipeViewManager.onSingleTapUp(convertToElementCoordinates) || hideSwipeItems$default(this, false, 1, null);
        }
        return this.singleTapUpDetected;
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public boolean onSingleTapConfirmed(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean z = this.singleTapUpDetected;
        this.singleTapUpDetected = false;
        return z;
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public boolean onDoubleTap(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean z = this.singleTapUpDetected;
        this.singleTapUpDetected = false;
        return z;
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public boolean move(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.lastPointDown != null && this.parentState != ParentScrollingState.True && event.getActionMasked() == 2) {
            Point point = this.lastPointDown;
            Intrinsics.checkNotNull(point);
            if (updateSwipeViewManagerIfNecessary(point) && this.swipeViewManager != null) {
                Point convertToPoint = convertToPoint(event.getX(), event.getY());
                if (this.needUpdateInitialPoint) {
                    SwipeViewManager swipeViewManager = this.swipeViewManager;
                    Intrinsics.checkNotNull(swipeViewManager);
                    Point point2 = this.lastPointDown;
                    Intrinsics.checkNotNull(point2);
                    swipeViewManager.down(point2);
                    this.needUpdateInitialPoint = false;
                }
                SwipeViewManager swipeViewManager2 = this.swipeViewManager;
                Intrinsics.checkNotNull(swipeViewManager2);
                return swipeViewManager2.move(convertToPoint);
            }
        }
        return false;
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public boolean up(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.parentState = ParentScrollingState.Unknown;
        if (this.swipeViewManager == null) {
            return false;
        }
        if (event.getAction() == 3) {
            return hideSwipeItems$default(this, false, 1, null);
        }
        SwipeViewManager swipeViewManager = this.swipeViewManager;
        Intrinsics.checkNotNull(swipeViewManager);
        return swipeViewManager.up();
    }

    @Override // com.devexpress.dxlistview.swipes.RecycleListener
    public void recycleItem(LayoutElement item) {
        Intrinsics.checkNotNullParameter(item, "item");
        SwipeViewManager swipeViewManager = this.swipeViewManagerCache.get(Integer.valueOf(item.getIndex()));
        if (swipeViewManager != null) {
            swipeViewManager.endClose();
        }
        this.swipeViewManagerCache.remove(Integer.valueOf(item.getIndex()));
    }

    /* renamed from: getSwipeViewManager$dxlistview_release, reason: from getter */
    public final SwipeViewManager getSwipeViewManager() {
        return this.swipeViewManager;
    }

    /* renamed from: getCurrentItemLayout$dxlistview_release, reason: from getter */
    public final LayoutElement getCurrentItemLayout() {
        return this.currentItemLayout;
    }
}
