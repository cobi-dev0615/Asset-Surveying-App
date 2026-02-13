package com.devexpress.dxlistview;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.devexpress.dxlistview.core.DXAsyncActionQueue;
import com.devexpress.dxlistview.core.DXAsyncViewAdapter;
import com.devexpress.dxlistview.core.DXListItemViewProvider;
import com.devexpress.dxlistview.core.DXSize;
import com.devexpress.dxlistview.core.DXSwipeRefreshLayout;
import com.devexpress.dxlistview.core.DragDropManager;
import com.devexpress.dxlistview.core.GestureListener;
import com.devexpress.dxlistview.core.MotionDirection;
import com.devexpress.dxlistview.core.ScrollingHelper;
import com.devexpress.dxlistview.helpers.MathHelper;
import com.devexpress.dxlistview.layouts.ComplexItemsLayout;
import com.devexpress.dxlistview.layouts.ComplexVerticalItemsLayout;
import com.devexpress.dxlistview.layouts.LayoutElement;
import com.devexpress.dxlistview.layouts.RequestLayoutRunnable;
import com.devexpress.dxlistview.swipes.DXListItemViewContainerProvider;
import com.devexpress.dxlistview.swipes.DXSwipeItemsViewProvider;
import com.devexpress.dxlistview.swipes.SwipeViewListener;
import com.devexpress.dxlistview.swipes.SwipesManager;
import com.devexpress.dxlistview.views.ItemContainerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DXVirtualScrollView.kt */
@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010}\u001a\u00020\u00102\u0006\u0010~\u001a\u00020\u007fH\u0016J\t\u0010\u0080\u0001\u001a\u00020\u0010H\u0016J\t\u0010\u0081\u0001\u001a\u00020\u0010H\u0016J\t\u0010\u0082\u0001\u001a\u00020\u0010H\u0016J.\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020\"2\u0007\u0010\u0086\u0001\u001a\u00020\"2\u0007\u0010\u0087\u0001\u001a\u00020\"2\u0007\u0010\u0088\u0001\u001a\u00020\"H\u0016J\t\u0010\u0089\u0001\u001a\u00020\"H\u0016J \u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00012\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\b\u0010\u008e\u0001\u001a\u00030\u008d\u0001H\u0002J\u000f\u0010\u008f\u0001\u001a\u00020oH\u0000¢\u0006\u0003\b\u0090\u0001J\u0011\u0010\u0091\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0092\u0001\u001a\u00020\u0010J+\u0010;\u001a\u00030\u0084\u00012\u0007\u0010\u0093\u0001\u001a\u00020\"2\u0007\u0010\u0094\u0001\u001a\u00020\"2\u0007\u0010\u0095\u0001\u001a\u00020\"2\u0007\u0010\u0096\u0001\u001a\u00020\"J\n\u0010\u0097\u0001\u001a\u00030\u0084\u0001H\u0016J\u001a\u0010\u0098\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0099\u0001\u001a\u00020\"2\u0007\u0010\u009a\u0001\u001a\u00020\"J\n\u0010\u009b\u0001\u001a\u00030\u0084\u0001H\u0016J7\u0010\u009c\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u009d\u0001\u001a\u00020\"2\u0007\u0010\u009e\u0001\u001a\u00020\"2\b\u0010\u009f\u0001\u001a\u00030 \u00012\b\u0010¡\u0001\u001a\u00030 \u00012\u0007\u0010¢\u0001\u001a\u00020\u0010J\n\u0010£\u0001\u001a\u00030\u0084\u0001H\u0016J\u0013\u0010¤\u0001\u001a\u00030\u0084\u00012\u0007\u0010¥\u0001\u001a\u00020\"H\u0016J\u0013\u0010¦\u0001\u001a\u00030\u0084\u00012\u0007\u0010§\u0001\u001a\u00020\"H\u0016J\u0011\u0010¨\u0001\u001a\u00020\u00102\u0006\u0010~\u001a\u00020\u007fH\u0016J\u0012\u0010©\u0001\u001a\u00030\u0084\u00012\u0006\u0010~\u001a\u00020\u007fH\u0016J\u0012\u0010ª\u0001\u001a\u00030\u0084\u00012\u0006\u0010~\u001a\u00020\u007fH\u0016J\u0012\u0010«\u0001\u001a\u00030\u0084\u00012\u0006\u0010~\u001a\u00020\u007fH\u0016J\u0012\u0010¬\u0001\u001a\u00030\u0084\u00012\u0006\u0010~\u001a\u00020\u007fH\u0016J\u001e\u0010\u00ad\u0001\u001a\u00030\u0084\u00012\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\b\u0010\u008e\u0001\u001a\u00030\u008d\u0001H\u0016J\n\u0010®\u0001\u001a\u00030\u0084\u0001H\u0016J\u001a\u0010¯\u0001\u001a\u00030\u0084\u00012\u0007\u0010°\u0001\u001a\u00020\u00102\u0007\u0010±\u0001\u001a\u00020\u0010J\n\u0010²\u0001\u001a\u00030\u0084\u0001H\u0016J\u0011\u0010²\u0001\u001a\u00030\u0084\u00012\u0007\u0010°\u0001\u001a\u00020\u0010J\u001c\u0010³\u0001\u001a\u00030\u0084\u00012\u0007\u0010´\u0001\u001a\u00020\"2\u0007\u0010µ\u0001\u001a\u00020\"H\u0016J\u001c\u0010¶\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u008c\u0001\u001a\u00020\"2\u0007\u0010\u008e\u0001\u001a\u00020\"H\u0016J\u001a\u0010·\u0001\u001a\u00030\u0084\u00012\u0007\u0010¸\u0001\u001a\u00020\"2\u0007\u0010¹\u0001\u001a\u00020\"J\u001c\u0010º\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u008c\u0001\u001a\u00020\"2\u0007\u0010\u008e\u0001\u001a\u00020\"H\u0002J\u0013\u0010»\u0001\u001a\u00030\u0084\u00012\u0007\u0010¼\u0001\u001a\u00020\"H\u0016J\u0013\u0010½\u0001\u001a\u00030\u0084\u00012\u0007\u0010¾\u0001\u001a\u00020\"H\u0016J\u0013\u0010¿\u0001\u001a\u00030\u0084\u00012\u0007\u0010À\u0001\u001a\u00020\"H\u0016J\n\u0010Á\u0001\u001a\u00030\u0084\u0001H\u0016J\n\u0010Â\u0001\u001a\u00030\u0084\u0001H\u0016J\b\u0010Ã\u0001\u001a\u00030\u0084\u0001J\n\u0010Ä\u0001\u001a\u00030\u0084\u0001H\u0002J\b\u0010Å\u0001\u001a\u00030\u0084\u0001R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010#\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\"@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0015R$\u0010*\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R\u000e\u0010,\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010-\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R$\u0010/\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u0010\u0013\"\u0004\b0\u0010\u0015R\u000e\u00101\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0013R(\u00104\u001a\u0004\u0018\u0001032\b\u0010\u000f\u001a\u0004\u0018\u000103@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R(\u0010;\u001a\u0004\u0018\u00010:2\b\u00109\u001a\u0004\u0018\u00010:@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010D\u001a\u00020E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR(\u0010J\u001a\u0004\u0018\u00010I2\b\u0010H\u001a\u0004\u0018\u00010I8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u000e\u0010W\u001a\u00020XX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010Y\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0013\"\u0004\b[\u0010\u0015R$\u0010\\\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0013\"\u0004\b^\u0010\u0015R$\u0010_\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\"@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010%\"\u0004\ba\u0010'R(\u0010c\u001a\u0004\u0018\u00010b2\b\u0010\u000f\u001a\u0004\u0018\u00010b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR(\u0010i\u001a\u0004\u0018\u00010h2\b\u0010H\u001a\u0004\u0018\u00010h8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u000e\u0010n\u001a\u00020oX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010p\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0013\"\u0004\br\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010s\u001a\u0004\u0018\u00010tX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010v\u001a\u0004\u0018\u00010u2\b\u0010\u000f\u001a\u0004\u0018\u00010u@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bw\u0010xR\u0014\u0010y\u001a\u00020zX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010|¨\u0006Æ\u0001"}, d2 = {"Lcom/devexpress/dxlistview/DXVirtualScrollView;", "Lcom/devexpress/dxlistview/IVirtualScrollView;", "Lcom/devexpress/dxlistview/LoadMoreActionProvider;", "Lcom/devexpress/dxlistview/IVirtualScrollLayoutOwner;", "context", "Landroid/content/Context;", "vScrollView", "Lcom/devexpress/dxlistview/DXVerticalScrollView;", "hScrollView", "Lcom/devexpress/dxlistview/DXHorizontalScrollView;", "panel", "Lcom/devexpress/dxlistview/VirtualScrollPanel;", "(Landroid/content/Context;Lcom/devexpress/dxlistview/DXVerticalScrollView;Lcom/devexpress/dxlistview/DXHorizontalScrollView;Lcom/devexpress/dxlistview/VirtualScrollPanel;)V", "_scrollingHelper", "Lcom/devexpress/dxlistview/core/ScrollingHelper;", "value", "", "allowCascadeUpdate", "getAllowCascadeUpdate", "()Z", "setAllowCascadeUpdate", "(Z)V", "contentView", "Landroid/view/ViewGroup;", "getContentView", "()Landroid/view/ViewGroup;", "dragDropManager", "Lcom/devexpress/dxlistview/core/DragDropManager;", "extentContentSize", "Lcom/devexpress/dxlistview/core/DXSize;", "getExtentContentSize", "()Lcom/devexpress/dxlistview/core/DXSize;", "gestureListener", "Lcom/devexpress/dxlistview/core/GestureListener;", "", "indicatorColor", "getIndicatorColor", "()I", "setIndicatorColor", "(I)V", "isLoadMoreEnabled", "setLoadMoreEnabled", "isPullToRefreshEnabled", "setPullToRefreshEnabled", "isRebuilding", "isRefreshing", "setRefreshing", "isScrollBarVisible", "setScrollBarVisible", "isUpdating", "isVertical", "Lcom/devexpress/dxlistview/core/DXListItemViewProvider;", "itemsViewProvider", "getItemsViewProvider", "()Lcom/devexpress/dxlistview/core/DXListItemViewProvider;", "setItemsViewProvider", "(Lcom/devexpress/dxlistview/core/DXListItemViewProvider;)V", "newLayout", "Lcom/devexpress/dxlistview/layouts/ComplexItemsLayout;", "layout", "getLayout", "()Lcom/devexpress/dxlistview/layouts/ComplexItemsLayout;", "setLayout", "(Lcom/devexpress/dxlistview/layouts/ComplexItemsLayout;)V", "layoutQueue", "Lcom/devexpress/dxlistview/core/DXAsyncActionQueue;", "loadMoreAdapter", "Lcom/devexpress/dxlistview/LoadMoreAdapter;", "motionDirection", "Lcom/devexpress/dxlistview/core/MotionDirection;", "getMotionDirection", "()Lcom/devexpress/dxlistview/core/MotionDirection;", "newListener", "Lcom/devexpress/dxlistview/ListViewListener;", "nativeListener", "getNativeListener", "()Lcom/devexpress/dxlistview/ListViewListener;", "setNativeListener", "(Lcom/devexpress/dxlistview/ListViewListener;)V", "pressedContainer", "Lcom/devexpress/dxlistview/views/ItemContainerView;", "refreshContainer", "Lcom/devexpress/dxlistview/core/DXSwipeRefreshLayout;", "getRefreshContainer", "()Lcom/devexpress/dxlistview/core/DXSwipeRefreshLayout;", "setRefreshContainer", "(Lcom/devexpress/dxlistview/core/DXSwipeRefreshLayout;)V", "scrolledEventArgs", "Lcom/devexpress/dxlistview/ListViewScrolledEventArgs;", "showFooter", "getShowFooter", "setShowFooter", "showHeader", "getShowHeader", "setShowHeader", "spanCount", "getSpanCount", "setSpanCount", "Lcom/devexpress/dxlistview/swipes/DXSwipeItemsViewProvider;", "swipeItemsViewProvider", "getSwipeItemsViewProvider", "()Lcom/devexpress/dxlistview/swipes/DXSwipeItemsViewProvider;", "setSwipeItemsViewProvider", "(Lcom/devexpress/dxlistview/swipes/DXSwipeItemsViewProvider;)V", "Lcom/devexpress/dxlistview/swipes/SwipeViewListener;", "swipeViewListener", "getSwipeViewListener", "()Lcom/devexpress/dxlistview/swipes/SwipeViewListener;", "setSwipeViewListener", "(Lcom/devexpress/dxlistview/swipes/SwipeViewListener;)V", "swipesManager", "Lcom/devexpress/dxlistview/swipes/SwipesManager;", "useRippleEffect", "getUseRippleEffect", "setUseRippleEffect", "viewAdapter", "Lcom/devexpress/dxlistview/core/DXAsyncViewAdapter;", "Lcom/devexpress/dxlistview/swipes/DXListItemViewContainerProvider;", "viewProvider", "setViewProvider", "(Lcom/devexpress/dxlistview/swipes/DXListItemViewContainerProvider;)V", "viewport", "Landroid/graphics/Rect;", "getViewport", "()Landroid/graphics/Rect;", "canIntercept", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "canLoadMore", "canPullToRefresh", "canScrollUp", "contentOffsetChanged", "", "oldOffsetX", "newOffsetX", "oldOffsetY", "newOffsetY", "getItemsCount", "getLayoutElementByMotionEvent", "Lcom/devexpress/dxlistview/layouts/LayoutElement;", "x", "", "y", "getSwipesManager", "getSwipesManager$dxlistview_release", "hideSwipeItems", "animated", "left", "top", "right", "bottom", "layoutSubviews", "measure", "widthMeasureSpec", "heightMeasureSpec", "measureSubviews", "moveItem", "fromIndex", "toIndex", "updateSource", "Ljava/lang/Runnable;", "completeAction", "animate", "onAutoScroll", "overScrolledX", "scrollX", "overScrolledY", "scrollY", "processTouchEvent", "raiseItemDoubleTap", "raiseItemLongPress", "raiseItemTap", "raiseItemTapConfirmed", "raisePressed", "raiseReleased", "rebuild", "forceSync", "forceClearViews", "requestLayout", "scrollBy", "dx", "dy", "scrollTo", "scrollToItem", "index", "scrollToPosition", "setContentOffset", "setContentOffsetX", "offsetX", "setContentOffsetY", "offsetY", "smoothScrollBy", TypedValues.CycleType.S_WAVE_OFFSET, "startLoadMore", "startPullToRefresh", "updateItems", "updateViewAdapter", "updateVisibleViews", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXVirtualScrollView implements IVirtualScrollView, LoadMoreActionProvider, IVirtualScrollLayoutOwner {
    private final ScrollingHelper _scrollingHelper;
    private boolean allowCascadeUpdate;
    private final Context context;
    private final DragDropManager dragDropManager;
    private final GestureListener gestureListener;
    private final DXHorizontalScrollView hScrollView;
    private int indicatorColor;
    private boolean isLoadMoreEnabled;
    private boolean isRebuilding;
    private boolean isRefreshing;
    private boolean isUpdating;
    private DXListItemViewProvider itemsViewProvider;
    private ComplexItemsLayout layout;
    private final DXAsyncActionQueue layoutQueue;
    private LoadMoreAdapter loadMoreAdapter;
    private final VirtualScrollPanel panel;
    private ItemContainerView pressedContainer;
    private DXSwipeRefreshLayout refreshContainer;
    private final ListViewScrolledEventArgs scrolledEventArgs;
    private boolean showFooter;
    private boolean showHeader;
    private int spanCount;
    private DXSwipeItemsViewProvider swipeItemsViewProvider;
    private final SwipesManager swipesManager;
    private boolean useRippleEffect;
    private final DXVerticalScrollView vScrollView;
    private DXAsyncViewAdapter viewAdapter;
    private DXListItemViewContainerProvider viewProvider;
    private final Rect viewport;

    public DXVirtualScrollView(Context context, DXVerticalScrollView vScrollView, DXHorizontalScrollView hScrollView, VirtualScrollPanel panel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vScrollView, "vScrollView");
        Intrinsics.checkNotNullParameter(hScrollView, "hScrollView");
        Intrinsics.checkNotNullParameter(panel, "panel");
        this.context = context;
        this.vScrollView = vScrollView;
        this.hScrollView = hScrollView;
        this.panel = panel;
        this.layoutQueue = new DXAsyncActionQueue(10L, 20L, 5L, context);
        DXVirtualScrollView dXVirtualScrollView = this;
        ScrollingHelper scrollingHelper = new ScrollingHelper(context, dXVirtualScrollView);
        this._scrollingHelper = scrollingHelper;
        this.scrolledEventArgs = new ListViewScrolledEventArgs();
        this.allowCascadeUpdate = true;
        this.viewport = new Rect();
        this.spanCount = 1;
        vScrollView.setScrollView(dXVirtualScrollView);
        hScrollView.setScrollView(dXVirtualScrollView);
        panel.setScrollView(this);
        DragDropManager dragDropManager = new DragDropManager(context, this.layout, this.viewAdapter, scrollingHelper, dXVirtualScrollView);
        this.dragDropManager = dragDropManager;
        SwipesManager swipesManager = new SwipesManager(context, this.layout, this.swipeItemsViewProvider, this);
        this.swipesManager = swipesManager;
        this.gestureListener = new GestureListener(context, dXVirtualScrollView, dragDropManager, swipesManager);
    }

    public final DXSwipeRefreshLayout getRefreshContainer() {
        return this.refreshContainer;
    }

    public final void setRefreshContainer(DXSwipeRefreshLayout dXSwipeRefreshLayout) {
        this.refreshContainer = dXSwipeRefreshLayout;
    }

    public final boolean getAllowCascadeUpdate() {
        return this.allowCascadeUpdate;
    }

    public final void setAllowCascadeUpdate(boolean z) {
        this.allowCascadeUpdate = z;
        DXAsyncViewAdapter dXAsyncViewAdapter = this.viewAdapter;
        if (dXAsyncViewAdapter == null) {
            return;
        }
        dXAsyncViewAdapter.setAllowCascadeUpdate(z);
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public Rect getViewport() {
        return this.viewport;
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public DXSize getExtentContentSize() {
        ComplexItemsLayout complexItemsLayout = this.layout;
        Intrinsics.checkNotNull(complexItemsLayout);
        DXSize extentSize = complexItemsLayout.extentSize;
        Intrinsics.checkNotNullExpressionValue(extentSize, "extentSize");
        return extentSize;
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public boolean canIntercept(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.dragDropManager.isInDraggingProcess() || this.swipesManager.isProcessing()) {
            return true;
        }
        return this.swipesManager.canInterceptTouchEvent(event);
    }

    public final boolean getUseRippleEffect() {
        return this.useRippleEffect;
    }

    public final void setUseRippleEffect(boolean z) {
        this.useRippleEffect = z;
        this.gestureListener.setUseRippleEffect(z);
    }

    /* renamed from: isRefreshing, reason: from getter */
    public final boolean getIsRefreshing() {
        return this.isRefreshing;
    }

    public final void setRefreshing(boolean z) {
        this.isRefreshing = z;
        if (z) {
            return;
        }
        DXSwipeRefreshLayout dXSwipeRefreshLayout = this.refreshContainer;
        if (dXSwipeRefreshLayout != null) {
            dXSwipeRefreshLayout.setRefreshing(z);
        }
        LoadMoreAdapter loadMoreAdapter = this.loadMoreAdapter;
        if (loadMoreAdapter != null) {
            loadMoreAdapter.stopLoadMore();
        }
        this.dragDropManager.stopDraggingProcess();
        this.gestureListener.cancel();
        ComplexItemsLayout complexItemsLayout = this.layout;
        if (complexItemsLayout != null) {
            complexItemsLayout.updateItems(true);
        }
    }

    public final boolean getShowHeader() {
        return this.showHeader;
    }

    public final void setShowHeader(boolean z) {
        this.showHeader = z;
        DXAsyncViewAdapter dXAsyncViewAdapter = this.viewAdapter;
        if (dXAsyncViewAdapter == null) {
            return;
        }
        dXAsyncViewAdapter.setShowHeader(z);
    }

    public final boolean getShowFooter() {
        return this.showFooter;
    }

    public final void setShowFooter(boolean z) {
        this.showFooter = z;
        DXAsyncViewAdapter dXAsyncViewAdapter = this.viewAdapter;
        if (dXAsyncViewAdapter == null) {
            return;
        }
        dXAsyncViewAdapter.setShowFooter(z);
    }

    public final int getIndicatorColor() {
        return this.indicatorColor;
    }

    public final void setIndicatorColor(int i) {
        this.indicatorColor = i;
        LoadMoreAdapter loadMoreAdapter = this.loadMoreAdapter;
        if (loadMoreAdapter != null) {
            loadMoreAdapter.setIndicatorColor(i);
        }
    }

    public final boolean isScrollBarVisible() {
        return this.hScrollView.isHorizontalScrollBarEnabled() && this.vScrollView.isVerticalScrollBarEnabled();
    }

    public final void setScrollBarVisible(boolean z) {
        this.hScrollView.setHorizontalScrollBarEnabled(z);
        this.vScrollView.setVerticalScrollBarEnabled(z);
    }

    public final int getSpanCount() {
        return this.spanCount;
    }

    public final void setSpanCount(int i) {
        if (this.spanCount == i) {
            return;
        }
        this.spanCount = i;
        ComplexItemsLayout complexItemsLayout = this.layout;
        if (complexItemsLayout != null) {
            complexItemsLayout.setSpanCount(i);
        }
        DXAsyncViewAdapter dXAsyncViewAdapter = this.viewAdapter;
        if (dXAsyncViewAdapter == null) {
            return;
        }
        dXAsyncViewAdapter.setSpanCount(i);
    }

    public final boolean isPullToRefreshEnabled() {
        DXSwipeRefreshLayout dXSwipeRefreshLayout = this.refreshContainer;
        return dXSwipeRefreshLayout != null && dXSwipeRefreshLayout.isEnabled();
    }

    public final void setPullToRefreshEnabled(boolean z) {
        DXSwipeRefreshLayout dXSwipeRefreshLayout = this.refreshContainer;
        if (dXSwipeRefreshLayout == null) {
            return;
        }
        dXSwipeRefreshLayout.setEnabled(z);
    }

    /* renamed from: isLoadMoreEnabled, reason: from getter */
    public final boolean getIsLoadMoreEnabled() {
        return this.isLoadMoreEnabled;
    }

    public final void setLoadMoreEnabled(boolean z) {
        requestLayout();
        if (this.isLoadMoreEnabled == z) {
            return;
        }
        this.isLoadMoreEnabled = z;
        if (z && this.loadMoreAdapter == null) {
            LoadMoreAdapter loadMoreAdapter = new LoadMoreAdapter(this.context, this);
            this.loadMoreAdapter = loadMoreAdapter;
            DXAsyncViewAdapter dXAsyncViewAdapter = this.viewAdapter;
            if (dXAsyncViewAdapter != null) {
                dXAsyncViewAdapter.setLoadMoreProvider(loadMoreAdapter);
            }
        }
        LoadMoreAdapter loadMoreAdapter2 = this.loadMoreAdapter;
        if (loadMoreAdapter2 != null) {
            loadMoreAdapter2.setEnabled(z);
        }
    }

    public final ComplexItemsLayout getLayout() {
        return this.layout;
    }

    public final void setLayout(ComplexItemsLayout complexItemsLayout) {
        ComplexItemsLayout complexItemsLayout2 = this.layout;
        if (complexItemsLayout2 != complexItemsLayout) {
            if (complexItemsLayout2 != null) {
                Intrinsics.checkNotNull(complexItemsLayout2);
                complexItemsLayout2.clear();
            }
            this.layout = complexItemsLayout;
            if (complexItemsLayout != null) {
                Intrinsics.checkNotNull(complexItemsLayout);
                complexItemsLayout.setOwner(this);
                ComplexItemsLayout complexItemsLayout3 = this.layout;
                Intrinsics.checkNotNull(complexItemsLayout3);
                complexItemsLayout3.setAdapter(this.viewAdapter);
                ComplexItemsLayout complexItemsLayout4 = this.layout;
                Intrinsics.checkNotNull(complexItemsLayout4);
                complexItemsLayout4.setSpanCount(this.spanCount);
                getViewport().left = 0;
                getViewport().top = 0;
            }
            this.dragDropManager.setLayout(this.layout);
            this.swipesManager.setItemsLayout(this.layout);
            requestLayout();
        }
    }

    private final void setViewProvider(DXListItemViewContainerProvider dXListItemViewContainerProvider) {
        if (Intrinsics.areEqual(this.viewProvider, dXListItemViewContainerProvider)) {
            return;
        }
        this.viewProvider = dXListItemViewContainerProvider;
        this.panel.removeAllViews();
        updateViewAdapter();
        requestLayout(true);
    }

    public final DXListItemViewProvider getItemsViewProvider() {
        return this.itemsViewProvider;
    }

    public final void setItemsViewProvider(DXListItemViewProvider dXListItemViewProvider) {
        if (Intrinsics.areEqual(this.itemsViewProvider, dXListItemViewProvider)) {
            return;
        }
        this.itemsViewProvider = dXListItemViewProvider;
        setViewProvider(new DXListItemViewContainerProvider(this.context, dXListItemViewProvider));
    }

    public final DXSwipeItemsViewProvider getSwipeItemsViewProvider() {
        return this.swipeItemsViewProvider;
    }

    public final void setSwipeItemsViewProvider(DXSwipeItemsViewProvider dXSwipeItemsViewProvider) {
        if (Intrinsics.areEqual(this.swipeItemsViewProvider, dXSwipeItemsViewProvider)) {
            return;
        }
        this.swipeItemsViewProvider = dXSwipeItemsViewProvider;
        this.swipesManager.setSwipesViewProvider(dXSwipeItemsViewProvider);
    }

    public final ListViewListener getNativeListener() {
        return this.dragDropManager.getListViewListener();
    }

    public final void setNativeListener(ListViewListener listViewListener) {
        this.dragDropManager.setListViewListener(listViewListener);
    }

    public final SwipeViewListener getSwipeViewListener() {
        return this.swipesManager.getSwipeViewListener();
    }

    public final void setSwipeViewListener(SwipeViewListener swipeViewListener) {
        this.swipesManager.setSwipeViewListener(swipeViewListener);
    }

    private final ViewGroup getContentView() {
        ViewGroup viewGroup = this.refreshContainer;
        if (viewGroup == null) {
            viewGroup = this.vScrollView;
        }
        return viewGroup;
    }

    private final void updateViewAdapter() {
        DXAsyncViewAdapter dXAsyncViewAdapter = new DXAsyncViewAdapter(this.viewProvider, this.panel, this.layoutQueue);
        this.viewAdapter = dXAsyncViewAdapter;
        Intrinsics.checkNotNull(dXAsyncViewAdapter);
        dXAsyncViewAdapter.setLoadMoreProvider(this.loadMoreAdapter);
        DXAsyncViewAdapter dXAsyncViewAdapter2 = this.viewAdapter;
        Intrinsics.checkNotNull(dXAsyncViewAdapter2);
        dXAsyncViewAdapter2.setAllowCascadeUpdate(this.allowCascadeUpdate);
        DXAsyncViewAdapter dXAsyncViewAdapter3 = this.viewAdapter;
        Intrinsics.checkNotNull(dXAsyncViewAdapter3);
        dXAsyncViewAdapter3.setSpanCount(this.spanCount);
        DXAsyncViewAdapter dXAsyncViewAdapter4 = this.viewAdapter;
        Intrinsics.checkNotNull(dXAsyncViewAdapter4);
        dXAsyncViewAdapter4.setShowHeader(this.showHeader);
        DXAsyncViewAdapter dXAsyncViewAdapter5 = this.viewAdapter;
        Intrinsics.checkNotNull(dXAsyncViewAdapter5);
        dXAsyncViewAdapter5.setShowFooter(this.showFooter);
        this.dragDropManager.setAdapter(this.viewAdapter);
        this.swipesManager.setInnerItemExtractor(this.viewProvider);
        ComplexItemsLayout complexItemsLayout = this.layout;
        if (complexItemsLayout != null) {
            Intrinsics.checkNotNull(complexItemsLayout);
            complexItemsLayout.setAdapter(this.viewAdapter);
        }
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public boolean canPullToRefresh() {
        if (getNativeListener() != null) {
            ListViewListener nativeListener = getNativeListener();
            Intrinsics.checkNotNull(nativeListener);
            if (nativeListener.canPullToRefresh()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public void startPullToRefresh() {
        if (canPullToRefresh()) {
            ListViewListener nativeListener = getNativeListener();
            Intrinsics.checkNotNull(nativeListener);
            nativeListener.pullToRefresh();
        }
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollLayoutOwner
    public void contentOffsetChanged(int oldOffsetX, int newOffsetX, int oldOffsetY, int newOffsetY) {
        if (getNativeListener() != null) {
            ComplexItemsLayout complexItemsLayout = this.layout;
            Intrinsics.checkNotNull(complexItemsLayout);
            LayoutElement firstVisibleItem = complexItemsLayout.getFirstVisibleItem();
            ComplexItemsLayout complexItemsLayout2 = this.layout;
            Intrinsics.checkNotNull(complexItemsLayout2);
            LayoutElement lastVisibleItem = complexItemsLayout2.getLastVisibleItem();
            this.scrolledEventArgs.set$dxlistview_release(newOffsetX - oldOffsetX, newOffsetY - oldOffsetY, newOffsetX, newOffsetY, firstVisibleItem != null ? firstVisibleItem.getIndex() : -1, lastVisibleItem != null ? lastVisibleItem.getIndex() : -1, getViewport().width(), getViewport().height(), getExtentContentSize().width, getExtentContentSize().height);
            ListViewListener nativeListener = getNativeListener();
            Intrinsics.checkNotNull(nativeListener);
            nativeListener.scrolled(this.scrolledEventArgs);
        }
    }

    @Override // com.devexpress.dxlistview.LoadMoreActionProvider
    public int getItemsCount() {
        DXAsyncViewAdapter dXAsyncViewAdapter = this.viewAdapter;
        if (dXAsyncViewAdapter == null) {
            return 0;
        }
        Intrinsics.checkNotNull(dXAsyncViewAdapter);
        return dXAsyncViewAdapter.getItemCount();
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView, com.devexpress.dxlistview.LoadMoreActionProvider
    public boolean canLoadMore() {
        if (!this.dragDropManager.isInDraggingProcess() && getNativeListener() != null) {
            ListViewListener nativeListener = getNativeListener();
            Intrinsics.checkNotNull(nativeListener);
            if (nativeListener.canLoadMore()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView, com.devexpress.dxlistview.LoadMoreActionProvider
    public void startLoadMore() {
        LoadMoreAdapter loadMoreAdapter;
        if (canLoadMore() && (loadMoreAdapter = this.loadMoreAdapter) != null && loadMoreAdapter.startLoadMore()) {
            ListViewListener nativeListener = getNativeListener();
            Intrinsics.checkNotNull(nativeListener);
            nativeListener.loadMore();
        }
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public void layoutSubviews() {
        ComplexItemsLayout complexItemsLayout = this.layout;
        if (complexItemsLayout != null) {
            Intrinsics.checkNotNull(complexItemsLayout);
            complexItemsLayout.layout(getViewport());
            ComplexItemsLayout complexItemsLayout2 = this.layout;
            Intrinsics.checkNotNull(complexItemsLayout2);
            int i = complexItemsLayout2.currentViewport.left;
            ComplexItemsLayout complexItemsLayout3 = this.layout;
            Intrinsics.checkNotNull(complexItemsLayout3);
            scrollTo(i, complexItemsLayout3.currentViewport.top);
            this.dragDropManager.process();
        }
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public void onAutoScroll() {
        this.dragDropManager.process();
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public void measureSubviews() {
        ComplexItemsLayout complexItemsLayout = this.layout;
        if (complexItemsLayout == null || this.viewAdapter == null) {
            return;
        }
        Intrinsics.checkNotNull(complexItemsLayout);
        complexItemsLayout.measure(getViewport());
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public void scrollBy(int dx, int dy) {
        scrollTo(getViewport().left + dx, getViewport().top + dy);
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public void scrollTo(int x, int y) {
        if (this.hScrollView.getWidth() == 0) {
            this.hScrollView.setPendingScrollX(x);
        } else {
            this.hScrollView.setScrollX(x);
        }
        if (this.vScrollView.getHeight() == 0) {
            this.vScrollView.setPendingScrollY(y);
        } else {
            this.vScrollView.setScrollY(y);
        }
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public void setContentOffsetY(int offsetY) {
        setContentOffset(getViewport().left, Math.max(offsetY, 0));
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public void setContentOffsetX(int offsetX) {
        setContentOffset(Math.max(offsetX, 0), getViewport().top);
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public void overScrolledX(int scrollX) {
        if (!isVertical() && scrollX == getViewport().left && getMotionDirection() == MotionDirection.RightToLeft) {
            LoadMoreAdapter loadMoreAdapter = this.loadMoreAdapter;
            if (loadMoreAdapter == null || !loadMoreAdapter.getIsBusy()) {
                LoadMoreAdapter loadMoreAdapter2 = this.loadMoreAdapter;
                if (loadMoreAdapter2 != null) {
                    loadMoreAdapter2.refresh();
                }
                setContentOffsetX(scrollX);
            }
        }
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public void overScrolledY(int scrollY) {
        if (isVertical() && scrollY == getViewport().top && getMotionDirection() == MotionDirection.BottomToTop) {
            LoadMoreAdapter loadMoreAdapter = this.loadMoreAdapter;
            if (loadMoreAdapter == null || !loadMoreAdapter.getIsBusy()) {
                LoadMoreAdapter loadMoreAdapter2 = this.loadMoreAdapter;
                if (loadMoreAdapter2 != null) {
                    loadMoreAdapter2.refresh();
                }
                setContentOffsetY(scrollY);
            }
        }
    }

    private final void setContentOffset(int x, int y) {
        int i = x - getViewport().left;
        int i2 = y - getViewport().top;
        getViewport().left += i;
        getViewport().top += i2;
        getViewport().right += i;
        getViewport().bottom += i2;
        requestLayout(false);
        ComplexItemsLayout complexItemsLayout = this.layout;
        if (complexItemsLayout != null) {
            complexItemsLayout.layoutFixedGroupHeader(getViewport());
        }
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public boolean canScrollUp() {
        return this.vScrollView.canScrollVertically(-1);
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public boolean processTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        LoadMoreAdapter loadMoreAdapter = this.loadMoreAdapter;
        if (loadMoreAdapter == null || !loadMoreAdapter.getIsBusy()) {
            return this.gestureListener.onTouchEvent(event);
        }
        return false;
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public void raiseItemTap(MotionEvent event) {
        ListViewListener nativeListener;
        Intrinsics.checkNotNullParameter(event, "event");
        LayoutElement layoutElementByMotionEvent = getLayoutElementByMotionEvent(event.getX(), event.getY());
        if (layoutElementByMotionEvent == null || (nativeListener = getNativeListener()) == null) {
            return;
        }
        nativeListener.itemTap(layoutElementByMotionEvent.getIndex());
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public void raiseItemTapConfirmed(MotionEvent event) {
        ListViewListener nativeListener;
        Intrinsics.checkNotNullParameter(event, "event");
        LayoutElement layoutElementByMotionEvent = getLayoutElementByMotionEvent(event.getX(), event.getY());
        if (layoutElementByMotionEvent == null || (nativeListener = getNativeListener()) == null) {
            return;
        }
        nativeListener.itemTapConfirmed(layoutElementByMotionEvent.getIndex());
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public void raiseItemDoubleTap(MotionEvent event) {
        ListViewListener nativeListener;
        Intrinsics.checkNotNullParameter(event, "event");
        LayoutElement layoutElementByMotionEvent = getLayoutElementByMotionEvent(event.getX(), event.getY());
        if (layoutElementByMotionEvent == null || (nativeListener = getNativeListener()) == null) {
            return;
        }
        nativeListener.itemDoubleTap(layoutElementByMotionEvent.getIndex());
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public void raiseItemLongPress(MotionEvent event) {
        ListViewListener nativeListener;
        Intrinsics.checkNotNullParameter(event, "event");
        LayoutElement layoutElementByMotionEvent = getLayoutElementByMotionEvent(event.getX(), event.getY());
        if (layoutElementByMotionEvent == null || (nativeListener = getNativeListener()) == null) {
            return;
        }
        nativeListener.itemLongPress(layoutElementByMotionEvent.getIndex());
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public void raisePressed(float x, float y) {
        ListViewListener nativeListener;
        LayoutElement layoutElementByMotionEvent = getLayoutElementByMotionEvent(x, y);
        if (layoutElementByMotionEvent == null) {
            return;
        }
        View view = layoutElementByMotionEvent.getView();
        ItemContainerView itemContainerView = view instanceof ItemContainerView ? (ItemContainerView) view : null;
        this.pressedContainer = itemContainerView;
        if (itemContainerView == null || (nativeListener = getNativeListener()) == null) {
            return;
        }
        ItemContainerView itemContainerView2 = this.pressedContainer;
        Intrinsics.checkNotNull(itemContainerView2);
        View itemView = itemContainerView2.getItemView();
        ItemContainerView itemContainerView3 = this.pressedContainer;
        Intrinsics.checkNotNull(itemContainerView3);
        float x2 = x - itemContainerView3.getX();
        ItemContainerView itemContainerView4 = this.pressedContainer;
        Intrinsics.checkNotNull(itemContainerView4);
        nativeListener.itemPressed(itemView, x2, y - itemContainerView4.getY());
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public void raiseReleased() {
        if (this.pressedContainer == null) {
            return;
        }
        ListViewListener nativeListener = getNativeListener();
        if (nativeListener != null) {
            ItemContainerView itemContainerView = this.pressedContainer;
            Intrinsics.checkNotNull(itemContainerView);
            View itemView = itemContainerView.getItemView();
            Intrinsics.checkNotNull(this.pressedContainer);
            Intrinsics.checkNotNull(this.pressedContainer);
            nativeListener.itemReleased(itemView, r2.getWidth() / 2.0f, r4.getHeight() / 2.0f);
        }
        this.pressedContainer = null;
    }

    private final LayoutElement getLayoutElementByMotionEvent(float x, float y) {
        Point point = new Point(MathHelper.round(x), MathHelper.round(y));
        ComplexItemsLayout complexItemsLayout = this.layout;
        if (complexItemsLayout != null) {
            return complexItemsLayout.findElementBy(point);
        }
        return null;
    }

    public final void layout(int left, int top, int right, int bottom) {
        if (getContentView().getWidth() != right - left || getContentView().getHeight() != bottom - top) {
            this.gestureListener.cancel();
        }
        getContentView().layout(left, top, right, bottom);
    }

    public final void measure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = getViewport().left + View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = getViewport().top + View.MeasureSpec.getSize(heightMeasureSpec);
        boolean z = (size == getViewport().right && size2 == getViewport().bottom) ? false : true;
        getViewport().right = size;
        getViewport().bottom = size2;
        if (z && !this.panel.isLayoutRequested()) {
            this.panel.forceLayout();
            this.hScrollView.forceLayout();
            this.vScrollView.forceLayout();
            getContentView().forceLayout();
        }
        getContentView().measure(widthMeasureSpec, heightMeasureSpec);
        if (this.isRebuilding) {
            ListViewListener nativeListener = getNativeListener();
            if (nativeListener != null) {
                nativeListener.onAfterRebuild();
            }
            this.isRebuilding = false;
        }
        if (this.isUpdating) {
            ListViewListener nativeListener2 = getNativeListener();
            if (nativeListener2 != null) {
                nativeListener2.onAfterUpdateItems();
            }
            this.isUpdating = false;
        }
    }

    public final void scrollToItem(final int index, final int scrollToPosition) {
        if (this.layout == null || this.vScrollView.getHeight() == 0 || this.hScrollView.getWidth() == 0) {
            this.panel.post(new Runnable() { // from class: com.devexpress.dxlistview.DXVirtualScrollView$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    DXVirtualScrollView.scrollToItem$lambda$2(DXVirtualScrollView.this, index, scrollToPosition);
                }
            });
            return;
        }
        DXAsyncViewAdapter dXAsyncViewAdapter = this.viewAdapter;
        Intrinsics.checkNotNull(dXAsyncViewAdapter);
        int calculateNodePosition = dXAsyncViewAdapter.calculateNodePosition(index);
        Intrinsics.checkNotNull(this.viewAdapter);
        int max = Math.max(0, Math.min(calculateNodePosition, r0.getItemCount() - 1));
        ComplexItemsLayout complexItemsLayout = this.layout;
        Intrinsics.checkNotNull(complexItemsLayout);
        Point updateLayoutAnchor = complexItemsLayout.updateLayoutAnchor(max, getViewport(), scrollToPosition);
        getViewport().left += updateLayoutAnchor.x;
        getViewport().top += updateLayoutAnchor.y;
        getViewport().right += updateLayoutAnchor.x;
        getViewport().bottom += updateLayoutAnchor.y;
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scrollToItem$lambda$2(DXVirtualScrollView this$0, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.scrollToItem(i, i2);
    }

    public final void updateItems() {
        this.isUpdating = true;
        this.gestureListener.cancel();
        ComplexItemsLayout complexItemsLayout = this.layout;
        if (complexItemsLayout != null) {
            complexItemsLayout.updateItems();
        }
    }

    public final void updateVisibleViews() {
        ComplexItemsLayout complexItemsLayout = this.layout;
        if (complexItemsLayout != null) {
            complexItemsLayout.updateVisibleViews();
        }
    }

    public final void rebuild(boolean forceSync, boolean forceClearViews) {
        this.isRebuilding = true;
        this.gestureListener.cancel();
        ComplexItemsLayout complexItemsLayout = this.layout;
        if (complexItemsLayout != null) {
            complexItemsLayout.clear();
        }
        getViewport().left = 0;
        getViewport().right = 0;
        if (forceClearViews) {
            DXListItemViewProvider dXListItemViewProvider = this.itemsViewProvider;
            if (dXListItemViewProvider != null) {
                dXListItemViewProvider.clearCache();
            }
            this.panel.removeAllViews();
        }
        requestLayout(forceSync);
    }

    public final void moveItem(int fromIndex, int toIndex, final Runnable updateSource, final Runnable completeAction, boolean animate) {
        Intrinsics.checkNotNullParameter(updateSource, "updateSource");
        Intrinsics.checkNotNullParameter(completeAction, "completeAction");
        final boolean animationEnabled = this.dragDropManager.getAnimationEnabled();
        Runnable runnable = new Runnable() { // from class: com.devexpress.dxlistview.DXVirtualScrollView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DXVirtualScrollView.moveItem$lambda$3(DXVirtualScrollView.this, completeAction, animationEnabled);
            }
        };
        Runnable runnable2 = new Runnable() { // from class: com.devexpress.dxlistview.DXVirtualScrollView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DXVirtualScrollView.moveItem$lambda$4(DXVirtualScrollView.this, updateSource);
            }
        };
        ComplexItemsLayout complexItemsLayout = this.layout;
        Intrinsics.checkNotNull(complexItemsLayout);
        LayoutElement firstVisibleItem = complexItemsLayout.getFirstVisibleItem();
        int index = firstVisibleItem != null ? firstVisibleItem.getIndex() : -1;
        ComplexItemsLayout complexItemsLayout2 = this.layout;
        Intrinsics.checkNotNull(complexItemsLayout2);
        LayoutElement lastVisibleItem = complexItemsLayout2.getLastVisibleItem();
        int index2 = lastVisibleItem != null ? lastVisibleItem.getIndex() : -1;
        if ((fromIndex < index && toIndex < index) || (fromIndex > index2 && toIndex > index2)) {
            runnable2.run();
            runnable.run();
        } else {
            this.dragDropManager.setAnimationEnabled(animate);
            this.dragDropManager.moveItem(fromIndex, toIndex, runnable2, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void moveItem$lambda$3(DXVirtualScrollView this$0, Runnable completeAction, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(completeAction, "$completeAction");
        ComplexItemsLayout complexItemsLayout = this$0.layout;
        Intrinsics.checkNotNull(complexItemsLayout);
        complexItemsLayout.isUpdateLocked = true;
        completeAction.run();
        ComplexItemsLayout complexItemsLayout2 = this$0.layout;
        Intrinsics.checkNotNull(complexItemsLayout2);
        complexItemsLayout2.isUpdateLocked = false;
        this$0.dragDropManager.setAnimationEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void moveItem$lambda$4(DXVirtualScrollView this$0, Runnable updateSource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(updateSource, "$updateSource");
        ComplexItemsLayout complexItemsLayout = this$0.layout;
        Intrinsics.checkNotNull(complexItemsLayout);
        complexItemsLayout.isUpdateLocked = true;
        updateSource.run();
        ComplexItemsLayout complexItemsLayout2 = this$0.layout;
        Intrinsics.checkNotNull(complexItemsLayout2);
        complexItemsLayout2.isUpdateLocked = false;
    }

    public final void hideSwipeItems(boolean animated) {
        this.swipesManager.hideSwipeItems(animated);
    }

    public final void requestLayout(boolean forceSync) {
        ComplexItemsLayout complexItemsLayout = this.layout;
        if (complexItemsLayout != null) {
            complexItemsLayout.forceSyncLayout(forceSync);
        }
        requestLayout();
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollLayoutOwner
    public void requestLayout() {
        if (!this.panel.isInLayout()) {
            this.panel.requestLayout();
        } else {
            VirtualScrollPanel virtualScrollPanel = this.panel;
            virtualScrollPanel.post(new RequestLayoutRunnable(virtualScrollPanel));
        }
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public boolean isVertical() {
        return this.layout instanceof ComplexVerticalItemsLayout;
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public MotionDirection getMotionDirection() {
        return this.dragDropManager.get_motionDirection();
    }

    @Override // com.devexpress.dxlistview.IVirtualScrollView
    public void smoothScrollBy(int offset) {
        if (isVertical()) {
            this.vScrollView.smoothScrollBy(0, offset);
        } else {
            this.hScrollView.smoothScrollBy(offset, 0);
        }
    }

    /* renamed from: getSwipesManager$dxlistview_release, reason: from getter */
    public final SwipesManager getSwipesManager() {
        return this.swipesManager;
    }
}
