package com.devexpress.dxlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.dxcore.DXNativeView;
import com.devexpress.dxlistview.core.DXAsyncViewAdapter;
import com.devexpress.dxlistview.core.DXListItemViewProvider;
import com.devexpress.dxlistview.core.DXSwipeRefreshLayout;
import com.devexpress.dxlistview.layouts.ComplexHorizontalItemsLayout;
import com.devexpress.dxlistview.layouts.ComplexItemsLayout;
import com.devexpress.dxlistview.layouts.ComplexVerticalItemsLayout;
import com.devexpress.dxlistview.layouts.ItemSizeRange;
import com.devexpress.dxlistview.swipes.DXSwipeItemsViewProvider;
import com.devexpress.dxlistview.swipes.SwipeViewListener;
import com.devexpress.dxlistview.views.ItemContainerView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: DXListViewNative.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Ä\u00012\u00020\u00012\u00020\u0002:\u0002Ä\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u0096\u0001\u001a\u00020\u00112\n\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001H\u0016J\t\u0010\u0099\u0001\u001a\u00020\u0011H\u0016J\u0011\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u0011J\t\u0010\u009d\u0001\u001a\u00020\u0011H\u0002J\u001c\u0010\u009e\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009f\u0001\u001a\u00020\n2\u0007\u0010 \u0001\u001a\u00020\nH\u0002J7\u0010¡\u0001\u001a\u00030\u009b\u00012\u0007\u0010¢\u0001\u001a\u00020\n2\u0007\u0010£\u0001\u001a\u00020\n2\b\u0010¤\u0001\u001a\u00030¥\u00012\b\u0010¦\u0001\u001a\u00030¥\u00012\u0007\u0010§\u0001\u001a\u00020\u0011J\n\u0010¨\u0001\u001a\u00030\u009b\u0001H\u0014J7\u0010©\u0001\u001a\u00030\u009b\u00012\u0007\u0010ª\u0001\u001a\u00020\u00112\u0007\u0010«\u0001\u001a\u00020\n2\u0007\u0010¬\u0001\u001a\u00020\n2\u0007\u0010\u00ad\u0001\u001a\u00020\n2\u0007\u0010®\u0001\u001a\u00020\nH\u0014J\u001c\u0010¯\u0001\u001a\u00030°\u00012\u0007\u0010±\u0001\u001a\u00020\n2\u0007\u0010²\u0001\u001a\u00020\nH\u0014J\u0011\u0010³\u0001\u001a\u00030\u009b\u00012\u0007\u0010´\u0001\u001a\u00020\u0011J\n\u0010µ\u0001\u001a\u00030\u009b\u0001H\u0002J\b\u0010¶\u0001\u001a\u00030\u009b\u0001J\u001a\u0010·\u0001\u001a\u00030\u009b\u00012\u0007\u0010¸\u0001\u001a\u00020\n2\u0007\u0010¹\u0001\u001a\u00020\nJ\u000b\u0010º\u0001\u001a\u0004\u0018\u00010\u0000H\u0002J/\u0010»\u0001\u001a\u00030\u009b\u00012\b\u0010¼\u0001\u001a\u00030½\u00012\u0007\u0010¾\u0001\u001a\u00020\n2\u0007\u0010¿\u0001\u001a\u00020\u00112\u0007\u0010À\u0001\u001a\u00020\u0011H\u0016J\b\u0010Á\u0001\u001a\u00030\u009b\u0001J\n\u0010Â\u0001\u001a\u00030\u009b\u0001H\u0002J\b\u0010Ã\u0001\u001a\u00030\u009b\u0001R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0016R$\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R$\u0010&\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R$\u0010)\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R$\u0010,\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R*\u0010/\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@FX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010\u0014\u001a\u0004\b1\u0010 \"\u0004\b2\u0010\"R\u0014\u00103\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0016R$\u00104\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0016\"\u0004\b5\u0010\u0018R$\u00106\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u0010\u0018R$\u00108\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0016\"\u0004\b9\u0010\u0018R*\u0010:\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b;\u0010\u0014\u001a\u0004\b:\u0010\u0016\"\u0004\b<\u0010\u0018R$\u0010=\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010 \"\u0004\b?\u0010\"R$\u0010@\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010 \"\u0004\bB\u0010\"R$\u0010C\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010 \"\u0004\bE\u0010\"R*\u0010F\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@FX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bG\u0010\u0014\u001a\u0004\bH\u0010 \"\u0004\bI\u0010\"R(\u0010K\u001a\u0004\u0018\u00010J2\b\u0010\u0010\u001a\u0004\u0018\u00010J@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u000e\u0010P\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010Q\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010 \"\u0004\bS\u0010\"R$\u0010T\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010 \"\u0004\bV\u0010\"R$\u0010W\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010 \"\u0004\bY\u0010\"R$\u0010Z\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010 \"\u0004\b\\\u0010\"R(\u0010^\u001a\u0004\u0018\u00010]2\b\u0010\u0010\u001a\u0004\u0018\u00010]8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010d\u001a\u00020c2\u0006\u0010\u0010\u001a\u00020c@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u0010\u0010i\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010j\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0016\"\u0004\bl\u0010\u0018R$\u0010m\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u0016\"\u0004\bo\u0010\u0018R$\u0010p\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0016\"\u0004\br\u0010\u0018R$\u0010s\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\u0016\"\u0004\bu\u0010\u0018R$\u0010v\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bw\u0010 \"\u0004\bx\u0010\"R*\u0010y\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@FX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bz\u0010\u0014\u001a\u0004\b{\u0010 \"\u0004\b|\u0010\"R$\u0010}\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010 \"\u0004\b\u007f\u0010\"R'\u0010\u0080\u0001\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010 \"\u0005\b\u0082\u0001\u0010\"R6\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00012\t\u0010\u0010\u001a\u0005\u0018\u00010\u0083\u0001@FX\u0086\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b\u0085\u0001\u0010\u0014\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R6\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u00012\t\u0010\u0010\u001a\u0005\u0018\u00010\u008a\u00018F@FX\u0086\u000e¢\u0006\u0017\u0012\u0005\b\u008c\u0001\u0010\u0014\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R'\u0010\u0091\u0001\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010\u0016\"\u0005\b\u0093\u0001\u0010\u0018R\u0012\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Å\u0001"}, d2 = {"Lcom/devexpress/dxlistview/DXListViewNative;", "Lcom/devexpress/dxcore/DXNativeView;", "Lcom/devexpress/dxlistview/IAppearanceOwner;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_layout", "Lcom/devexpress/dxlistview/layouts/ComplexItemsLayout;", "_scrollView", "Lcom/devexpress/dxlistview/DXVirtualScrollView;", "value", "", "allowCascadeUpdate", "getAllowCascadeUpdate$annotations", "()V", "getAllowCascadeUpdate", "()Z", "setAllowCascadeUpdate", "(Z)V", "allowFixedGroupHeaders", "getAllowFixedGroupHeaders", "setAllowFixedGroupHeaders", "allowSyncLayout", "getAllowSyncLayout", "endGroupItemSeparatorCapMargin", "getEndGroupItemSeparatorCapMargin", "()I", "setEndGroupItemSeparatorCapMargin", "(I)V", "endItemSeparatorCapMargin", "getEndItemSeparatorCapMargin", "setEndItemSeparatorCapMargin", "groupItemSeparatorColor", "getGroupItemSeparatorColor", "setGroupItemSeparatorColor", "groupItemSeparatorThickness", "getGroupItemSeparatorThickness", "setGroupItemSeparatorThickness", "groupItemSize", "getGroupItemSize", "setGroupItemSize", "indicatorColor", "getIndicatorColor$annotations", "getIndicatorColor", "setIndicatorColor", "isForceSyncLayoutRequested", "isLoadMoreEnabled", "setLoadMoreEnabled", "isPullToRefreshEnabled", "setPullToRefreshEnabled", "isRefreshing", "setRefreshing", "isScrollBarVisible", "isScrollBarVisible$annotations", "setScrollBarVisible", "itemSeparatorColor", "getItemSeparatorColor", "setItemSeparatorColor", "itemSeparatorThickness", "getItemSeparatorThickness", "setItemSeparatorThickness", "itemSize", "getItemSize", "setItemSize", "itemSpacing", "getItemSpacing$annotations", "getItemSpacing", "setItemSpacing", "Lcom/devexpress/dxlistview/core/DXListItemViewProvider;", "itemsViewProvider", "getItemsViewProvider", "()Lcom/devexpress/dxlistview/core/DXListItemViewProvider;", "setItemsViewProvider", "(Lcom/devexpress/dxlistview/core/DXListItemViewProvider;)V", "loadMoreItemSize", "maxGroupItemSize", "getMaxGroupItemSize", "setMaxGroupItemSize", "maxItemSize", "getMaxItemSize", "setMaxItemSize", "minGroupItemSize", "getMinGroupItemSize", "setMinGroupItemSize", "minItemSize", "getMinItemSize", "setMinItemSize", "Lcom/devexpress/dxlistview/ListViewListener;", "nativeListener", "getNativeListener", "()Lcom/devexpress/dxlistview/ListViewListener;", "setNativeListener", "(Lcom/devexpress/dxlistview/ListViewListener;)V", "Lcom/devexpress/dxlistview/DXLOrientation;", "orientation", "getOrientation", "()Lcom/devexpress/dxlistview/DXLOrientation;", "setOrientation", "(Lcom/devexpress/dxlistview/DXLOrientation;)V", "parentAsListView", "reduceSizeToContent", "getReduceSizeToContent", "setReduceSizeToContent", "showFooter", "getShowFooter", "setShowFooter", "showHeader", "getShowHeader", "setShowHeader", "showItemSeparatorBeforeGroup", "getShowItemSeparatorBeforeGroup", "setShowItemSeparatorBeforeGroup", "spanCount", "getSpanCount", "setSpanCount", "spanSpacing", "getSpanSpacing$annotations", "getSpanSpacing", "setSpanSpacing", "startGroupItemSeparatorCapMargin", "getStartGroupItemSeparatorCapMargin", "setStartGroupItemSeparatorCapMargin", "startItemSeparatorCapMargin", "getStartItemSeparatorCapMargin", "setStartItemSeparatorCapMargin", "Lcom/devexpress/dxlistview/swipes/DXSwipeItemsViewProvider;", "swipeItemsViewProvider", "getSwipeItemsViewProvider$annotations", "getSwipeItemsViewProvider", "()Lcom/devexpress/dxlistview/swipes/DXSwipeItemsViewProvider;", "setSwipeItemsViewProvider", "(Lcom/devexpress/dxlistview/swipes/DXSwipeItemsViewProvider;)V", "Lcom/devexpress/dxlistview/swipes/SwipeViewListener;", "swipeViewListener", "getSwipeViewListener$annotations", "getSwipeViewListener", "()Lcom/devexpress/dxlistview/swipes/SwipeViewListener;", "setSwipeViewListener", "(Lcom/devexpress/dxlistview/swipes/SwipeViewListener;)V", "useRippleEffect", "getUseRippleEffect", "setUseRippleEffect", "watermarkImageView", "Landroid/widget/ImageView;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "hasItemSeparator", "hideSwipeItems", "", "animated", "isTrialWatermarkShouldShown", "layoutWatermark", "width", "height", "moveItem", "fromIndex", "toIndex", "updateSource", "Ljava/lang/Runnable;", "completeAction", "animate", "onAttachedToWindow", "onLayout", "b", "left", "top", "right", "bottom", "onMeasureCore", "Landroid/util/Size;", "widthMeasureSpec", "heightMeasureSpec", "rebuild", "forceClearViews", "recreateLayout", "resetScrollOffset", "scrollToItem", "index", "position", "tryToFindParentAsListView", "updateItemContainerAppearance", "view", "Landroid/view/View;", "viewType", "isLast", "isLastInGroup", "updateItems", "updateNestedScrollEnabled", "updateVisibleViews", "Companion", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXListViewNative extends DXNativeView implements IAppearanceOwner {
    public static final int SCROLL_POSITION_END = 2;
    public static final int SCROLL_POSITION_START = 1;
    public static final int SCROLL_POSITION_UNKNOWN = 0;
    private ComplexItemsLayout _layout;
    private final DXVirtualScrollView _scrollView;
    private boolean allowCascadeUpdate;
    private boolean allowFixedGroupHeaders;
    private int endGroupItemSeparatorCapMargin;
    private int endItemSeparatorCapMargin;
    private int groupItemSeparatorColor;
    private int groupItemSeparatorThickness;
    private int groupItemSize;
    private int indicatorColor;
    private boolean isLoadMoreEnabled;
    private boolean isPullToRefreshEnabled;
    private boolean isRefreshing;
    private boolean isScrollBarVisible;
    private int itemSeparatorColor;
    private int itemSeparatorThickness;
    private int itemSize;
    private int itemSpacing;
    private DXListItemViewProvider itemsViewProvider;
    private final int loadMoreItemSize;
    private int maxGroupItemSize;
    private int maxItemSize;
    private int minGroupItemSize;
    private int minItemSize;
    private DXLOrientation orientation;
    private DXListViewNative parentAsListView;
    private boolean reduceSizeToContent;
    private boolean showFooter;
    private boolean showHeader;
    private boolean showItemSeparatorBeforeGroup;
    private int spanSpacing;
    private int startGroupItemSeparatorCapMargin;
    private int startItemSeparatorCapMargin;
    private DXSwipeItemsViewProvider swipeItemsViewProvider;
    private boolean useRippleEffect;
    private ImageView watermarkImageView;

    /* compiled from: DXListViewNative.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DXLOrientation.values().length];
            try {
                iArr[DXLOrientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DXLOrientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getAllowCascadeUpdate$annotations() {
    }

    public static /* synthetic */ void getIndicatorColor$annotations() {
    }

    public static /* synthetic */ void getItemSpacing$annotations() {
    }

    public static /* synthetic */ void getSpanSpacing$annotations() {
    }

    public static /* synthetic */ void getSwipeItemsViewProvider$annotations() {
    }

    public static /* synthetic */ void getSwipeViewListener$annotations() {
    }

    public static /* synthetic */ void isScrollBarVisible$annotations() {
    }

    private final boolean isTrialWatermarkShouldShown() {
        return false;
    }

    private final boolean getAllowSyncLayout() {
        DXListViewNative dXListViewNative = this.parentAsListView;
        if (dXListViewNative != null) {
            Intrinsics.checkNotNull(dXListViewNative);
            if (!dXListViewNative.isForceSyncLayoutRequested()) {
                return false;
            }
        }
        return true;
    }

    private final boolean isForceSyncLayoutRequested() {
        ComplexItemsLayout complexItemsLayout = this._layout;
        if (complexItemsLayout != null) {
            Intrinsics.checkNotNull(complexItemsLayout);
            if (!complexItemsLayout.getIsForceSyncLayoutRequested()) {
                return false;
            }
        }
        return true;
    }

    public final boolean getAllowCascadeUpdate() {
        return this.allowCascadeUpdate;
    }

    public final void setAllowCascadeUpdate(boolean z) {
        if (this.allowCascadeUpdate != z) {
            this.allowCascadeUpdate = z;
            this._scrollView.setAllowCascadeUpdate(z);
        }
    }

    public final DXLOrientation getOrientation() {
        return this.orientation;
    }

    public final void setOrientation(DXLOrientation value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.orientation != value) {
            this.orientation = value;
            updateNestedScrollEnabled();
            recreateLayout();
        }
    }

    public final int getSpanCount() {
        return this._scrollView.getSpanCount();
    }

    public final void setSpanCount(int i) {
        if (this._scrollView.getSpanCount() == i) {
            return;
        }
        this._scrollView.setSpanCount(i);
        rebuild(false);
    }

    public final int getItemSeparatorColor() {
        return this.itemSeparatorColor;
    }

    public final void setItemSeparatorColor(int i) {
        if (this.itemSeparatorColor != i) {
            this.itemSeparatorColor = i;
            updateItems();
        }
    }

    public final int getItemSeparatorThickness() {
        return this.itemSeparatorThickness;
    }

    public final void setItemSeparatorThickness(int i) {
        if (this.itemSeparatorThickness != i) {
            this.itemSeparatorThickness = i;
            updateItems();
        }
    }

    public final int getStartItemSeparatorCapMargin() {
        return this.startItemSeparatorCapMargin;
    }

    public final void setStartItemSeparatorCapMargin(int i) {
        if (this.startItemSeparatorCapMargin != i) {
            this.startItemSeparatorCapMargin = i;
            updateItems();
        }
    }

    public final int getEndItemSeparatorCapMargin() {
        return this.endItemSeparatorCapMargin;
    }

    public final void setEndItemSeparatorCapMargin(int i) {
        if (this.endItemSeparatorCapMargin != i) {
            this.endItemSeparatorCapMargin = i;
            updateItems();
        }
    }

    public final boolean getShowItemSeparatorBeforeGroup() {
        return this.showItemSeparatorBeforeGroup;
    }

    public final void setShowItemSeparatorBeforeGroup(boolean z) {
        if (this.showItemSeparatorBeforeGroup != z) {
            this.showItemSeparatorBeforeGroup = z;
            updateItems();
        }
    }

    public final int getGroupItemSeparatorColor() {
        return this.groupItemSeparatorColor;
    }

    public final void setGroupItemSeparatorColor(int i) {
        if (this.groupItemSeparatorColor != i) {
            this.groupItemSeparatorColor = i;
            updateItems();
        }
    }

    public final int getGroupItemSeparatorThickness() {
        return this.groupItemSeparatorThickness;
    }

    public final void setGroupItemSeparatorThickness(int i) {
        if (this.groupItemSeparatorThickness != i) {
            this.groupItemSeparatorThickness = i;
            updateItems();
        }
    }

    public final int getStartGroupItemSeparatorCapMargin() {
        return this.startGroupItemSeparatorCapMargin;
    }

    public final void setStartGroupItemSeparatorCapMargin(int i) {
        if (this.startGroupItemSeparatorCapMargin != i) {
            this.startGroupItemSeparatorCapMargin = i;
            updateItems();
        }
    }

    public final int getEndGroupItemSeparatorCapMargin() {
        return this.endGroupItemSeparatorCapMargin;
    }

    public final void setEndGroupItemSeparatorCapMargin(int i) {
        if (this.endGroupItemSeparatorCapMargin != i) {
            this.endGroupItemSeparatorCapMargin = i;
            updateItems();
        }
    }

    /* renamed from: isScrollBarVisible, reason: from getter */
    public final boolean getIsScrollBarVisible() {
        return this.isScrollBarVisible;
    }

    public final void setScrollBarVisible(boolean z) {
        if (this.isScrollBarVisible != z) {
            this.isScrollBarVisible = z;
            this._scrollView.setScrollBarVisible(z);
        }
    }

    public final int getIndicatorColor() {
        return this.indicatorColor;
    }

    public final void setIndicatorColor(int i) {
        this.indicatorColor = i;
        this._scrollView.setIndicatorColor(i);
    }

    public final boolean getUseRippleEffect() {
        return this.useRippleEffect;
    }

    public final void setUseRippleEffect(boolean z) {
        this.useRippleEffect = z;
        this._scrollView.setUseRippleEffect(z);
    }

    /* renamed from: isRefreshing, reason: from getter */
    public final boolean getIsRefreshing() {
        return this.isRefreshing;
    }

    public final void setRefreshing(boolean z) {
        this.isRefreshing = z;
        this._scrollView.setRefreshing(z);
    }

    public final boolean getShowHeader() {
        return this.showHeader;
    }

    public final void setShowHeader(boolean z) {
        this.showHeader = z;
        this._scrollView.setShowHeader(z);
    }

    public final boolean getShowFooter() {
        return this.showFooter;
    }

    public final void setShowFooter(boolean z) {
        this.showFooter = z;
        this._scrollView.setShowFooter(z);
    }

    /* renamed from: isPullToRefreshEnabled, reason: from getter */
    public final boolean getIsPullToRefreshEnabled() {
        return this.isPullToRefreshEnabled;
    }

    public final void setPullToRefreshEnabled(boolean z) {
        DXSwipeRefreshLayout dXSwipeRefreshLayout;
        if (this.isPullToRefreshEnabled == z) {
            return;
        }
        this.isPullToRefreshEnabled = z;
        View findViewById = findViewById(R.id.dx_vertical_scrollview);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        DXVerticalScrollView dXVerticalScrollView = (DXVerticalScrollView) findViewById;
        if (z) {
            DXVerticalScrollView dXVerticalScrollView2 = dXVerticalScrollView;
            removeView(dXVerticalScrollView2);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            dXSwipeRefreshLayout = new DXSwipeRefreshLayout(context);
            dXSwipeRefreshLayout.initialize(this._scrollView);
            dXSwipeRefreshLayout.addView(dXVerticalScrollView2);
            addView(dXSwipeRefreshLayout);
        } else {
            ViewParent parent = dXVerticalScrollView.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type com.devexpress.dxlistview.core.DXSwipeRefreshLayout");
            DXSwipeRefreshLayout dXSwipeRefreshLayout2 = (DXSwipeRefreshLayout) parent;
            removeView(dXSwipeRefreshLayout2);
            DXVerticalScrollView dXVerticalScrollView3 = dXVerticalScrollView;
            dXSwipeRefreshLayout2.removeView(dXVerticalScrollView3);
            dXSwipeRefreshLayout2.initialize(null);
            addView(dXVerticalScrollView3);
            dXSwipeRefreshLayout = null;
        }
        this._scrollView.setRefreshContainer(dXSwipeRefreshLayout);
        this._scrollView.setPullToRefreshEnabled(z);
    }

    /* renamed from: isLoadMoreEnabled, reason: from getter */
    public final boolean getIsLoadMoreEnabled() {
        return this.isLoadMoreEnabled;
    }

    public final void setLoadMoreEnabled(boolean z) {
        this.isLoadMoreEnabled = z;
        this._scrollView.setLoadMoreEnabled(z);
    }

    public final int getItemSize() {
        return this.itemSize;
    }

    public final void setItemSize(int i) {
        if (this.itemSize != i) {
            this.itemSize = i;
            ComplexItemsLayout complexItemsLayout = this._layout;
            Intrinsics.checkNotNull(complexItemsLayout);
            complexItemsLayout.setItemSizeRangeByViewType(0, ItemSizeRange.create(this.itemSize, this.minItemSize, this.maxItemSize));
            ComplexItemsLayout complexItemsLayout2 = this._layout;
            Intrinsics.checkNotNull(complexItemsLayout2);
            complexItemsLayout2.setItemSizeRangeByViewType(1, ItemSizeRange.create(this.itemSize, this.minItemSize, this.maxItemSize));
        }
    }

    public final int getItemSpacing() {
        return this.itemSpacing;
    }

    public final void setItemSpacing(int i) {
        if (this.itemSpacing == i) {
            return;
        }
        this.itemSpacing = i;
        ComplexItemsLayout complexItemsLayout = this._layout;
        Intrinsics.checkNotNull(complexItemsLayout);
        complexItemsLayout.updateItemSpacing(i);
    }

    public final int getSpanSpacing() {
        return this.spanSpacing;
    }

    public final void setSpanSpacing(int i) {
        if (this.spanSpacing == i) {
            return;
        }
        this.spanSpacing = i;
        ComplexItemsLayout complexItemsLayout = this._layout;
        Intrinsics.checkNotNull(complexItemsLayout);
        complexItemsLayout.updateSpanSpacing(i);
    }

    public final int getMinItemSize() {
        return this.minItemSize;
    }

    public final void setMinItemSize(int i) {
        if (this.minItemSize != i) {
            this.minItemSize = i;
            ComplexItemsLayout complexItemsLayout = this._layout;
            Intrinsics.checkNotNull(complexItemsLayout);
            complexItemsLayout.setItemSizeRangeByViewType(0, ItemSizeRange.create(this.itemSize, this.minItemSize, this.maxItemSize));
            ComplexItemsLayout complexItemsLayout2 = this._layout;
            Intrinsics.checkNotNull(complexItemsLayout2);
            complexItemsLayout2.setItemSizeRangeByViewType(1, ItemSizeRange.create(this.itemSize, this.minItemSize, this.maxItemSize));
        }
    }

    public final int getMaxItemSize() {
        return this.maxItemSize;
    }

    public final void setMaxItemSize(int i) {
        if (this.maxItemSize != i) {
            this.maxItemSize = i;
            ComplexItemsLayout complexItemsLayout = this._layout;
            Intrinsics.checkNotNull(complexItemsLayout);
            complexItemsLayout.setItemSizeRangeByViewType(0, ItemSizeRange.create(this.itemSize, this.minItemSize, this.maxItemSize));
            ComplexItemsLayout complexItemsLayout2 = this._layout;
            Intrinsics.checkNotNull(complexItemsLayout2);
            complexItemsLayout2.setItemSizeRangeByViewType(1, ItemSizeRange.create(this.itemSize, this.minItemSize, this.maxItemSize));
        }
    }

    public final int getGroupItemSize() {
        return this.groupItemSize;
    }

    public final void setGroupItemSize(int i) {
        if (this.groupItemSize != i) {
            this.groupItemSize = i;
            ComplexItemsLayout complexItemsLayout = this._layout;
            Intrinsics.checkNotNull(complexItemsLayout);
            complexItemsLayout.setItemSizeRangeByViewType(2, ItemSizeRange.create(this.groupItemSize, this.minGroupItemSize, this.maxGroupItemSize));
        }
    }

    public final int getMinGroupItemSize() {
        return this.minGroupItemSize;
    }

    public final void setMinGroupItemSize(int i) {
        if (this.minGroupItemSize != i) {
            this.minGroupItemSize = i;
            ComplexItemsLayout complexItemsLayout = this._layout;
            Intrinsics.checkNotNull(complexItemsLayout);
            complexItemsLayout.setItemSizeRangeByViewType(2, ItemSizeRange.create(this.groupItemSize, this.minGroupItemSize, this.maxGroupItemSize));
        }
    }

    public final int getMaxGroupItemSize() {
        return this.maxGroupItemSize;
    }

    public final void setMaxGroupItemSize(int i) {
        if (this.maxGroupItemSize != i) {
            this.maxGroupItemSize = i;
            ComplexItemsLayout complexItemsLayout = this._layout;
            Intrinsics.checkNotNull(complexItemsLayout);
            complexItemsLayout.setItemSizeRangeByViewType(2, ItemSizeRange.create(this.groupItemSize, this.minGroupItemSize, this.maxGroupItemSize));
        }
    }

    public final boolean getAllowFixedGroupHeaders() {
        return this.allowFixedGroupHeaders;
    }

    public final void setAllowFixedGroupHeaders(boolean z) {
        if (this.allowFixedGroupHeaders != z) {
            this.allowFixedGroupHeaders = z;
            ComplexItemsLayout complexItemsLayout = this._layout;
            Intrinsics.checkNotNull(complexItemsLayout);
            complexItemsLayout.updateAllowFixedGroupHeaders(Boolean.valueOf(z));
        }
    }

    public final boolean getReduceSizeToContent() {
        return this.reduceSizeToContent;
    }

    public final void setReduceSizeToContent(boolean z) {
        if (this.reduceSizeToContent != z) {
            this.reduceSizeToContent = z;
            requestLayout();
        }
    }

    public final DXListItemViewProvider getItemsViewProvider() {
        return this.itemsViewProvider;
    }

    public final void setItemsViewProvider(DXListItemViewProvider dXListItemViewProvider) {
        if (Intrinsics.areEqual(this.itemsViewProvider, dXListItemViewProvider)) {
            return;
        }
        this.itemsViewProvider = dXListItemViewProvider;
        this._scrollView.setItemsViewProvider(dXListItemViewProvider);
    }

    public final DXSwipeItemsViewProvider getSwipeItemsViewProvider() {
        return this.swipeItemsViewProvider;
    }

    public final void setSwipeItemsViewProvider(DXSwipeItemsViewProvider dXSwipeItemsViewProvider) {
        if (Intrinsics.areEqual(this.swipeItemsViewProvider, dXSwipeItemsViewProvider)) {
            return;
        }
        this.swipeItemsViewProvider = dXSwipeItemsViewProvider;
        this._scrollView.setSwipeItemsViewProvider(dXSwipeItemsViewProvider);
    }

    public final ListViewListener getNativeListener() {
        return this._scrollView.getNativeListener();
    }

    public final void setNativeListener(ListViewListener listViewListener) {
        this._scrollView.setNativeListener(listViewListener);
    }

    public final SwipeViewListener getSwipeViewListener() {
        return this._scrollView.getSwipeViewListener();
    }

    public final void setSwipeViewListener(SwipeViewListener swipeViewListener) {
        this._scrollView.setSwipeViewListener(swipeViewListener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DXListViewNative(Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.loadMoreItemSize = (int) (getContext().getResources().getDisplayMetrics().density * 30 * 2);
        this.allowCascadeUpdate = true;
        this.orientation = DXLOrientation.Vertical;
        this.isScrollBarVisible = true;
        this.showHeader = true;
        this.itemSize = -1;
        this.minItemSize = 20;
        this.maxItemSize = -1;
        this.groupItemSize = -1;
        this.minGroupItemSize = 20;
        this.maxGroupItemSize = -1;
        ViewGroup.inflate(getContext(), R.layout.dxcollectionview_content, this);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        View findViewById = findViewById(R.id.dx_vertical_scrollview);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        View findViewById2 = findViewById(R.id.dx_horizontal_scrollview);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        View findViewById3 = findViewById(R.id.dx_virtual_scroll_panel);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this._scrollView = new DXVirtualScrollView(context2, (DXVerticalScrollView) findViewById, (DXHorizontalScrollView) findViewById2, (VirtualScrollPanel) findViewById3);
        recreateLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DXListViewNative(Context context, AttributeSet attrs) {
        super(context, attrs, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.loadMoreItemSize = (int) (getContext().getResources().getDisplayMetrics().density * 30 * 2);
        this.allowCascadeUpdate = true;
        this.orientation = DXLOrientation.Vertical;
        this.isScrollBarVisible = true;
        this.showHeader = true;
        this.itemSize = -1;
        this.minItemSize = 20;
        this.maxItemSize = -1;
        this.groupItemSize = -1;
        this.minGroupItemSize = 20;
        this.maxGroupItemSize = -1;
        ViewGroup.inflate(getContext(), R.layout.dxcollectionview_content, this);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        View findViewById = findViewById(R.id.dx_vertical_scrollview);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        View findViewById2 = findViewById(R.id.dx_horizontal_scrollview);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        View findViewById3 = findViewById(R.id.dx_virtual_scroll_panel);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this._scrollView = new DXVirtualScrollView(context2, (DXVerticalScrollView) findViewById, (DXHorizontalScrollView) findViewById2, (VirtualScrollPanel) findViewById3);
        recreateLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DXListViewNative(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.loadMoreItemSize = (int) (getContext().getResources().getDisplayMetrics().density * 30 * 2);
        this.allowCascadeUpdate = true;
        this.orientation = DXLOrientation.Vertical;
        this.isScrollBarVisible = true;
        this.showHeader = true;
        this.itemSize = -1;
        this.minItemSize = 20;
        this.maxItemSize = -1;
        this.groupItemSize = -1;
        this.minGroupItemSize = 20;
        this.maxGroupItemSize = -1;
        ViewGroup.inflate(getContext(), R.layout.dxcollectionview_content, this);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        View findViewById = findViewById(R.id.dx_vertical_scrollview);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        View findViewById2 = findViewById(R.id.dx_horizontal_scrollview);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        View findViewById3 = findViewById(R.id.dx_virtual_scroll_panel);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this._scrollView = new DXVirtualScrollView(context2, (DXVerticalScrollView) findViewById, (DXHorizontalScrollView) findViewById2, (VirtualScrollPanel) findViewById3);
        recreateLayout();
    }

    private final DXListViewNative tryToFindParentAsListView() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof DXListViewNative) {
                return (DXListViewNative) parent;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean b, int left, int top, int right, int bottom) {
        int i = right - left;
        int i2 = bottom - top;
        this._scrollView.layout(0, 0, i, i2);
        layoutWatermark(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (isEnabled()) {
            return super.dispatchTouchEvent(ev);
        }
        return false;
    }

    private final void layoutWatermark(int width, int height) {
        ImageView imageView = this.watermarkImageView;
        if (imageView == null) {
            return;
        }
        Intrinsics.checkNotNull(imageView);
        int maxWidth = imageView.getMaxWidth();
        ImageView imageView2 = this.watermarkImageView;
        Intrinsics.checkNotNull(imageView2);
        int maxHeight = imageView2.getMaxHeight();
        int i = (width / 2) - (maxWidth / 2);
        int i2 = (height / 2) - (maxHeight / 2);
        ImageView imageView3 = this.watermarkImageView;
        Intrinsics.checkNotNull(imageView3);
        imageView3.layout(i, i2, maxWidth + i, maxHeight + i2);
    }

    @Override // com.devexpress.dxcore.DXNativeView
    protected Size onMeasureCore(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (mode == 0) {
            size = (this.reduceSizeToContent && this.orientation == DXLOrientation.Horizontal) ? Integer.MAX_VALUE : displayMetrics.widthPixels;
        }
        if (mode2 == 0) {
            size2 = (this.reduceSizeToContent && this.orientation == DXLOrientation.Vertical) ? Integer.MAX_VALUE : displayMetrics.heightPixels;
        }
        if (this.reduceSizeToContent) {
            this._scrollView.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            ComplexItemsLayout complexItemsLayout = this._layout;
            Intrinsics.checkNotNull(complexItemsLayout);
            size = complexItemsLayout.getMeasureWidth(size, this._scrollView.getExtentContentSize().width);
            ComplexItemsLayout complexItemsLayout2 = this._layout;
            Intrinsics.checkNotNull(complexItemsLayout2);
            size2 = complexItemsLayout2.getMeasureHeight(size2, this._scrollView.getExtentContentSize().height);
        } else {
            this._scrollView.measure(View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(size2, BasicMeasure.EXACTLY));
        }
        return new Size(size, size2);
    }

    public final void updateItems() {
        this._scrollView.updateItems();
    }

    public final void updateVisibleViews() {
        this._scrollView.updateVisibleViews();
    }

    public final void scrollToItem(int index, int position) {
        this._scrollView.scrollToItem(index, position);
    }

    public final void moveItem(int fromIndex, int toIndex, Runnable updateSource, Runnable completeAction, boolean animate) {
        Intrinsics.checkNotNullParameter(updateSource, "updateSource");
        Intrinsics.checkNotNullParameter(completeAction, "completeAction");
        this._scrollView.moveItem(fromIndex, toIndex, updateSource, completeAction, animate);
    }

    public final void hideSwipeItems(boolean animated) {
        this._scrollView.hideSwipeItems(animated);
    }

    public final void resetScrollOffset() {
        this._scrollView.scrollTo(0, 0);
    }

    public final void rebuild(boolean forceClearViews) {
        resetScrollOffset();
        this._scrollView.rebuild(getAllowSyncLayout(), forceClearViews);
    }

    @Override // com.devexpress.dxlistview.IAppearanceOwner
    public void updateItemContainerAppearance(View view, int viewType, boolean isLast, boolean isLastInGroup) {
        Intrinsics.checkNotNullParameter(view, "view");
        if ((view instanceof ItemContainerView) && DXAsyncViewAdapter.IS_ITEM_OR_GROUP(viewType)) {
            int i = 0;
            boolean z = !isLast && ((isLastInGroup && this.showItemSeparatorBeforeGroup) || !isLastInGroup);
            boolean IS_ITEM = DXAsyncViewAdapter.IS_ITEM(viewType);
            if (IS_ITEM) {
                ItemContainerView itemContainerView = (ItemContainerView) view;
                itemContainerView.setStartSeparatorCapMargin(this.startItemSeparatorCapMargin);
                itemContainerView.setEndSeparatorCapMargin(this.endItemSeparatorCapMargin);
                itemContainerView.setSeparatorColor(this.itemSeparatorColor);
            } else {
                ItemContainerView itemContainerView2 = (ItemContainerView) view;
                itemContainerView2.setStartSeparatorCapMargin(this.startGroupItemSeparatorCapMargin);
                itemContainerView2.setEndSeparatorCapMargin(this.endGroupItemSeparatorCapMargin);
                itemContainerView2.setSeparatorColor(this.groupItemSeparatorColor);
            }
            if (this.orientation == DXLOrientation.Vertical) {
                ItemContainerView itemContainerView3 = (ItemContainerView) view;
                itemContainerView3.setRightSeparatorThickness(0);
                if (z) {
                    i = IS_ITEM ? this.itemSeparatorThickness : this.groupItemSeparatorThickness;
                }
                itemContainerView3.setBottomSeparatorThickness(i);
                return;
            }
            ItemContainerView itemContainerView4 = (ItemContainerView) view;
            itemContainerView4.setRightSeparatorThickness(z ? IS_ITEM ? this.itemSeparatorThickness : this.groupItemSeparatorThickness : 0);
            itemContainerView4.setBottomSeparatorThickness(0);
        }
    }

    @Override // com.devexpress.dxlistview.IAppearanceOwner
    public boolean hasItemSeparator() {
        return this.itemSeparatorThickness > 0;
    }

    private final void recreateLayout() {
        ComplexVerticalItemsLayout complexVerticalItemsLayout;
        resetScrollOffset();
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            complexVerticalItemsLayout = new ComplexVerticalItemsLayout();
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            complexVerticalItemsLayout = new ComplexHorizontalItemsLayout();
        }
        this._layout = complexVerticalItemsLayout;
        Intrinsics.checkNotNull(complexVerticalItemsLayout);
        complexVerticalItemsLayout.setAppearanceOwner(this);
        ComplexItemsLayout complexItemsLayout = this._layout;
        Intrinsics.checkNotNull(complexItemsLayout);
        complexItemsLayout.setItemSizeRangeByViewType(0, ItemSizeRange.create(this.itemSize, this.minItemSize, this.maxItemSize));
        ComplexItemsLayout complexItemsLayout2 = this._layout;
        Intrinsics.checkNotNull(complexItemsLayout2);
        complexItemsLayout2.setItemSizeRangeByViewType(1, ItemSizeRange.create(this.itemSize, this.minItemSize, this.maxItemSize));
        ComplexItemsLayout complexItemsLayout3 = this._layout;
        Intrinsics.checkNotNull(complexItemsLayout3);
        complexItemsLayout3.setItemSizeRangeByViewType(2, ItemSizeRange.create(this.groupItemSize, this.minGroupItemSize, this.maxGroupItemSize));
        ComplexItemsLayout complexItemsLayout4 = this._layout;
        Intrinsics.checkNotNull(complexItemsLayout4);
        complexItemsLayout4.setItemSizeRangeByViewType(-1, ItemSizeRange.create(this.loadMoreItemSize, 0, 0));
        ComplexItemsLayout complexItemsLayout5 = this._layout;
        Intrinsics.checkNotNull(complexItemsLayout5);
        complexItemsLayout5.setItemSizeRangeByViewType(3, ItemSizeRange.create(-1, -1, -1));
        ComplexItemsLayout complexItemsLayout6 = this._layout;
        Intrinsics.checkNotNull(complexItemsLayout6);
        complexItemsLayout6.setItemSizeRangeByViewType(4, ItemSizeRange.create(-1, -1, -1));
        ComplexItemsLayout complexItemsLayout7 = this._layout;
        Intrinsics.checkNotNull(complexItemsLayout7);
        complexItemsLayout7.updateItemSpacing(this.itemSpacing);
        ComplexItemsLayout complexItemsLayout8 = this._layout;
        Intrinsics.checkNotNull(complexItemsLayout8);
        complexItemsLayout8.updateSpanSpacing(this.spanSpacing);
        ComplexItemsLayout complexItemsLayout9 = this._layout;
        Intrinsics.checkNotNull(complexItemsLayout9);
        complexItemsLayout9.updateAllowFixedGroupHeaders(Boolean.valueOf(this.allowFixedGroupHeaders));
        ComplexItemsLayout complexItemsLayout10 = this._layout;
        Intrinsics.checkNotNull(complexItemsLayout10);
        complexItemsLayout10.forceSyncLayout(getAllowSyncLayout());
        DXVirtualScrollView dXVirtualScrollView = this._scrollView;
        ComplexItemsLayout complexItemsLayout11 = this._layout;
        Intrinsics.checkNotNull(complexItemsLayout11, "null cannot be cast to non-null type com.devexpress.dxlistview.layouts.ComplexItemsLayout");
        dXVirtualScrollView.setLayout(complexItemsLayout11);
    }

    private final void updateNestedScrollEnabled() {
        View findViewById = findViewById(R.id.dx_vertical_scrollview);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        ((DXVerticalScrollView) findViewById).setNestedScrollingEnabled(this.parentAsListView == null || this.orientation == DXLOrientation.Vertical);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.parentAsListView = tryToFindParentAsListView();
        ComplexItemsLayout complexItemsLayout = this._layout;
        Intrinsics.checkNotNull(complexItemsLayout);
        complexItemsLayout.forceSyncLayout(getAllowSyncLayout());
        updateNestedScrollEnabled();
        if (isTrialWatermarkShouldShown()) {
            ImageView imageView = new ImageView(getContext());
            this.watermarkImageView = imageView;
            Intrinsics.checkNotNull(imageView);
            imageView.setImageResource(R.drawable.dxco_watermark);
            ImageView imageView2 = this.watermarkImageView;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setAdjustViewBounds(true);
            float f = getResources().getDisplayMetrics().density;
            Intrinsics.checkNotNull(this.watermarkImageView);
            int intrinsicWidth = (int) ((r1.getDrawable().getIntrinsicWidth() / f) + 0.5f);
            Intrinsics.checkNotNull(this.watermarkImageView);
            ImageView imageView3 = this.watermarkImageView;
            Intrinsics.checkNotNull(imageView3);
            imageView3.setMaxWidth(intrinsicWidth);
            ImageView imageView4 = this.watermarkImageView;
            Intrinsics.checkNotNull(imageView4);
            imageView4.setMaxHeight((int) ((r3.getDrawable().getIntrinsicHeight() / f) + 0.5f));
            ImageView imageView5 = this.watermarkImageView;
            Intrinsics.checkNotNull(imageView5);
            imageView5.setImageAlpha(WorkQueueKt.MASK);
            addView(this.watermarkImageView);
        }
    }
}
