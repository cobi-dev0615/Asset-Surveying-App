package com.devexpress.dxlistview.swipes;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.devexpress.dxlistview.helpers.MathHelper;
import com.devexpress.dxlistview.layouts.ItemContainerLayout;
import com.devexpress.dxlistview.layouts.LayoutElement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwipeViewManager.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010.\u001a\u00020/H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u0010,\u001a\u00020\nH\u0002J\u0006\u00100\u001a\u00020/J\b\u00101\u001a\u00020/H\u0002J\b\u00102\u001a\u00020/H\u0002J\b\u00103\u001a\u00020/H\u0002J\u001e\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020\r2\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020/07J\b\u00108\u001a\u00020/H\u0002J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001aH\u0002J\u000e\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020:J\u0006\u0010>\u001a\u00020/J\u001a\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\nH\u0002J\b\u0010C\u001a\u00020\rH\u0002J\b\u0010 \u001a\u00020\rH\u0002J\b\u0010D\u001a\u00020\rH\u0002J\u0010\u0010E\u001a\u00020/2\u0006\u0010F\u001a\u00020\nH\u0002J\u000e\u0010G\u001a\u00020\r2\u0006\u0010=\u001a\u00020:J\u000e\u0010H\u001a\u00020\r2\u0006\u0010;\u001a\u00020\u001aJ \u0010I\u001a\u00020/2\u0006\u0010J\u001a\u00020#2\u0006\u0010K\u001a\u00020\r2\u0006\u0010L\u001a\u00020\u0011H\u0002J\u0018\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020#2\u0006\u0010O\u001a\u00020#H\u0002J\u001e\u0010P\u001a\u00020/2\u0006\u0010Q\u001a\u00020#2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020/07H\u0002J\u001e\u0010S\u001a\u00020/2\u0006\u0010Q\u001a\u00020#2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020/07H\u0002J\u0006\u0010U\u001a\u00020\rR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u001e\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001cR\u000e\u0010 \u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0016¨\u0006V"}, d2 = {"Lcom/devexpress/dxlistview/swipes/SwipeViewManager;", "", "context", "Landroid/content/Context;", "itemContainerLayout", "Lcom/devexpress/dxlistview/layouts/ItemContainerLayout;", "adapter", "Lcom/devexpress/dxlistview/swipes/DXSwipeItemsViewAdapter;", "(Landroid/content/Context;Lcom/devexpress/dxlistview/layouts/ItemContainerLayout;Lcom/devexpress/dxlistview/swipes/DXSwipeItemsViewAdapter;)V", "_committedOffset", "", "_interactionUserOffset", "_isDefaultButtonExpanded", "", "_motionDirection", "Lcom/devexpress/dxlistview/swipes/MotionDirection;", "_swipeGroup", "Lcom/devexpress/dxlistview/swipes/DXSwipeGroup;", "_swipeItemsLayout", "Lcom/devexpress/dxlistview/swipes/SwipeItemsLayout;", "actualSwipeOffset", "getActualSwipeOffset$dxlistview_release", "()I", "actualSwipeOffsetPoint", "getActualSwipeOffsetPoint", "initialStartMoving", "Landroid/graphics/PointF;", "isClosed", "()Z", "isClosing", "isInOpeningProcess", "isOpened", "isSwipeAllowed", "isSwipeAllowedRaised", "lastMoveX", "", "lastMoveY", "previousSwipeState", "Lcom/devexpress/dxlistview/swipes/SwipeViewPreviousState;", "state", "Lcom/devexpress/dxlistview/swipes/SwipeViewState;", "swipeActionUpAnimation", "Landroid/animation/ValueAnimator;", "swipeDefaultActionItemAnimation", "swipeOffset", "getSwipeOffset$dxlistview_release", "applySwipeOffset", "", "cancel", "cancelDefaultActionItemAnimation", "cancelUpAnimation", "clearState", "closeSwipe", "animated", "onItemTap", "Lkotlin/Function0;", "commitSwipeOffset", "convertToSwipeItemsPanelCoordinates", "Landroid/graphics/Point;", "point", "down", NotificationCompat.CATEGORY_EVENT, "endClose", "findElementBy", "Lcom/devexpress/dxlistview/layouts/LayoutElement;", "x", "y", "isFullSwipeAllowed", "isSwipeDirectionOpening", "itemTap", "index", "move", "onSingleTapUp", "processOpening", "swipeDelta", "openingState", "swipeGroup", "shouldSwipe", "xDiff", "yDiff", "startDefaultActionItemAnimation", TypedValues.TransitionType.S_TO, "onAnimationEnd", "startSwipeAnimation", "onSwipeAnimationEnd", "up", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class SwipeViewManager {
    private int _committedOffset;
    private int _interactionUserOffset;
    private boolean _isDefaultButtonExpanded;
    private MotionDirection _motionDirection;
    private DXSwipeGroup _swipeGroup;
    private SwipeItemsLayout _swipeItemsLayout;
    private final DXSwipeItemsViewAdapter adapter;
    private final Context context;
    private PointF initialStartMoving;
    private boolean isSwipeAllowed;
    private boolean isSwipeAllowedRaised;
    private final ItemContainerLayout itemContainerLayout;
    private float lastMoveX;
    private float lastMoveY;
    private SwipeViewPreviousState previousSwipeState;
    private SwipeViewState state;
    private ValueAnimator swipeActionUpAnimation;
    private ValueAnimator swipeDefaultActionItemAnimation;

    public SwipeViewManager(Context context, ItemContainerLayout itemContainerLayout, DXSwipeItemsViewAdapter adapter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemContainerLayout, "itemContainerLayout");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.context = context;
        this.itemContainerLayout = itemContainerLayout;
        this.adapter = adapter;
        this.initialStartMoving = new PointF();
        this._motionDirection = MotionDirection.None;
        this.state = SwipeViewState.Cancelled;
        this.previousSwipeState = SwipeViewPreviousState.Unknown;
    }

    private final boolean isSwipeAllowed() {
        this.isSwipeAllowedRaised = true;
        DXSwipeGroup dXSwipeGroup = this._swipeGroup;
        if (dXSwipeGroup == null) {
            return false;
        }
        DXSwipeItemsViewAdapter dXSwipeItemsViewAdapter = this.adapter;
        Intrinsics.checkNotNull(dXSwipeGroup);
        return dXSwipeItemsViewAdapter.isSwipeAllowed(dXSwipeGroup);
    }

    private final boolean isFullSwipeAllowed() {
        DXSwipeGroup dXSwipeGroup = this._swipeGroup;
        if (dXSwipeGroup == null) {
            return true;
        }
        DXSwipeItemsViewAdapter dXSwipeItemsViewAdapter = this.adapter;
        Intrinsics.checkNotNull(dXSwipeGroup);
        return dXSwipeItemsViewAdapter.isFullSwipeAllowed(dXSwipeGroup);
    }

    private final boolean isClosing() {
        return this.state == SwipeViewState.Closing;
    }

    public final boolean isClosed() {
        return this.state == SwipeViewState.Closed;
    }

    public final boolean isOpened() {
        return this.state == SwipeViewState.Opened;
    }

    public final boolean isInOpeningProcess() {
        return this.state == SwipeViewState.Opening;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getActualSwipeOffsetPoint() {
        return this._committedOffset + this._interactionUserOffset;
    }

    public final int getActualSwipeOffset$dxlistview_release() {
        return getActualSwipeOffsetPoint();
    }

    public final int getSwipeOffset$dxlistview_release() {
        if (this.adapter.getIsListViewVertical()) {
            float f = this.lastMoveX;
            PointF pointF = this.initialStartMoving;
            Intrinsics.checkNotNull(pointF);
            return MathHelper.round(f - pointF.x);
        }
        float f2 = this.lastMoveY;
        PointF pointF2 = this.initialStartMoving;
        Intrinsics.checkNotNull(pointF2);
        return MathHelper.round(f2 - pointF2.y);
    }

    public final boolean onSingleTapUp(PointF point) {
        Intrinsics.checkNotNullParameter(point, "point");
        Point convertToSwipeItemsPanelCoordinates = convertToSwipeItemsPanelCoordinates(point);
        final LayoutElement findElementBy = findElementBy(convertToSwipeItemsPanelCoordinates.x, convertToSwipeItemsPanelCoordinates.y);
        if (findElementBy == null) {
            return false;
        }
        if (!isOpened() && !isInOpeningProcess()) {
            return false;
        }
        closeSwipe(true, new Function0<Unit>() { // from class: com.devexpress.dxlistview.swipes.SwipeViewManager$onSingleTapUp$1
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
                SwipeViewManager.this.itemTap(findElementBy.getIndex());
            }
        });
        return true;
    }

    public final void down(Point event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.lastMoveX = event.x;
        this.lastMoveY = event.y;
        this.previousSwipeState = SwipeViewPreviousState.Unknown;
        this.isSwipeAllowedRaised = false;
        this.initialStartMoving = new PointF(this.lastMoveX, this.lastMoveY);
        if (this.state == SwipeViewState.Cancelled) {
            this.state = SwipeViewState.Closed;
        }
    }

    private final boolean shouldSwipe(float xDiff, float yDiff) {
        float f = this.adapter.getIsListViewVertical() ? xDiff : yDiff;
        if (isInOpeningProcess()) {
            xDiff = 0.0f;
        } else if (this.adapter.getIsListViewVertical()) {
            xDiff = yDiff;
        }
        return f > xDiff;
    }

    public final boolean move(Point event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.state == SwipeViewState.Cancelled) {
            return false;
        }
        float f = event.x - this.lastMoveX;
        float f2 = event.y - this.lastMoveY;
        this.lastMoveX = event.x;
        this.lastMoveY = event.y;
        if (!shouldSwipe(Math.abs(f), Math.abs(f2))) {
            return isInOpeningProcess();
        }
        cancelUpAnimation();
        if (isClosed()) {
            int i = -1;
            int i2 = (!this.adapter.getIsListViewVertical() || f == 0.0f) ? 0 : f > 0.0f ? -1 : 1;
            if (this.adapter.getIsListViewVertical() || f2 == 0.0f) {
                i = 0;
            } else if (f2 <= 0.0f) {
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
        }
        if (this._motionDirection == MotionDirection.None) {
            return false;
        }
        this._swipeGroup = (this._motionDirection == MotionDirection.TopToBottom || this._motionDirection == MotionDirection.LeftToRight) ? DXSwipeGroup.Start : DXSwipeGroup.End;
        if (this.previousSwipeState == SwipeViewPreviousState.Unknown) {
            this.previousSwipeState = this.state == SwipeViewState.Opened ? SwipeViewPreviousState.Opened : SwipeViewPreviousState.Closed;
        }
        if (!this.isSwipeAllowedRaised && this.previousSwipeState == SwipeViewPreviousState.Closed) {
            this.isSwipeAllowed = isSwipeAllowed();
        }
        if (!this.isSwipeAllowed) {
            this.initialStartMoving = new PointF(this.lastMoveX, this.lastMoveY);
            return false;
        }
        boolean z = isInOpeningProcess() || isOpened();
        this.state = SwipeViewState.Opening;
        if (!this.adapter.getIsListViewVertical()) {
            f = f2;
        }
        DXSwipeGroup dXSwipeGroup = this._swipeGroup;
        Intrinsics.checkNotNull(dXSwipeGroup);
        processOpening(f, z, dXSwipeGroup);
        return true;
    }

    public final void cancel() {
        if (this.state == SwipeViewState.Cancelled) {
            return;
        }
        commitSwipeOffset();
        clearState();
        this.state = SwipeViewState.Cancelled;
    }

    private final boolean isSwipeDirectionOpening() {
        return (this._interactionUserOffset > 0 && this._swipeGroup == DXSwipeGroup.Start) || (this._interactionUserOffset < 0 && this._swipeGroup == DXSwipeGroup.End);
    }

    public final boolean up() {
        int i;
        if (!isInOpeningProcess()) {
            return false;
        }
        int actualSwipeOffset$dxlistview_release = getActualSwipeOffset$dxlistview_release();
        if (actualSwipeOffset$dxlistview_release == 0) {
            commitSwipeOffset();
            endClose();
            return true;
        }
        if (Math.abs(actualSwipeOffset$dxlistview_release) < this.itemContainerLayout.getAutoActionTargetOffset() || !isFullSwipeAllowed()) {
            int minimizedOpenStateTargetOffset = this.itemContainerLayout.getMinimizedOpenStateTargetOffset();
            if (isSwipeDirectionOpening()) {
                minimizedOpenStateTargetOffset = this.itemContainerLayout.getExpandItemTargetOffset() - minimizedOpenStateTargetOffset;
            }
            final float signum = Math.abs(actualSwipeOffset$dxlistview_release) > minimizedOpenStateTargetOffset ? Math.signum(actualSwipeOffset$dxlistview_release) * this.itemContainerLayout.getExpandItemTargetOffset() : 0.0f;
            if (signum == 0.0f) {
                this.state = SwipeViewState.Closing;
            }
            startSwipeAnimation(signum, new Function0<Unit>() { // from class: com.devexpress.dxlistview.swipes.SwipeViewManager$up$1
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
                    SwipeViewManager.this.commitSwipeOffset();
                    if (signum == 0.0f) {
                        SwipeViewManager.this.endClose();
                    } else {
                        SwipeViewManager.this.state = SwipeViewState.Opened;
                    }
                }
            });
            return true;
        }
        SwipeItemsLayout swipeItemsLayout = this._swipeItemsLayout;
        Intrinsics.checkNotNull(swipeItemsLayout);
        final int i2 = swipeItemsLayout.get_defaultActionItemIndex();
        if (this.adapter.getIsListViewVertical()) {
            i = this.itemContainerLayout.get_prevViewport().right;
        } else {
            i = this.itemContainerLayout.get_prevViewport().bottom;
        }
        this.state = SwipeViewState.Closing;
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.devexpress.dxlistview.swipes.SwipeViewManager$up$closeAction$1
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
                SwipeViewManager.this.commitSwipeOffset();
                SwipeViewManager.this.endClose();
            }
        };
        final boolean raiseItemTapImmediately = this.adapter.getRaiseItemTapImmediately();
        if (Math.abs(actualSwipeOffset$dxlistview_release) >= i) {
            itemTap(i2);
            function0.invoke();
            return true;
        }
        if (raiseItemTapImmediately) {
            itemTap(i2);
        }
        startSwipeAnimation(Math.signum(actualSwipeOffset$dxlistview_release) * i, new Function0<Unit>() { // from class: com.devexpress.dxlistview.swipes.SwipeViewManager$up$2
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
                if (!raiseItemTapImmediately) {
                    this.itemTap(i2);
                }
                function0.invoke();
            }
        });
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean closeSwipe$default(SwipeViewManager swipeViewManager, boolean z, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closeSwipe");
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: com.devexpress.dxlistview.swipes.SwipeViewManager$closeSwipe$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        return swipeViewManager.closeSwipe(z, function0);
    }

    public final boolean closeSwipe(boolean animated, final Function0<Unit> onItemTap) {
        Intrinsics.checkNotNullParameter(onItemTap, "onItemTap");
        if (this.state == SwipeViewState.Cancelled || this.state == SwipeViewState.Closed || this._swipeItemsLayout == null || isClosing()) {
            return false;
        }
        this.state = SwipeViewState.Closing;
        final boolean raiseItemTapImmediately = this.adapter.getRaiseItemTapImmediately();
        if (animated) {
            if (raiseItemTapImmediately) {
                onItemTap.invoke();
            }
            startSwipeAnimation(0.0f, new Function0<Unit>() { // from class: com.devexpress.dxlistview.swipes.SwipeViewManager$closeSwipe$2
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
                    if (!raiseItemTapImmediately) {
                        onItemTap.invoke();
                    }
                    this.commitSwipeOffset();
                    this.endClose();
                }
            });
            return true;
        }
        onItemTap.invoke();
        applySwipeOffset(0);
        commitSwipeOffset();
        endClose();
        return true;
    }

    public final void endClose() {
        clearState();
        this.state = SwipeViewState.Closed;
    }

    private final void processOpening(float swipeDelta, boolean openingState, DXSwipeGroup swipeGroup) {
        if (this._swipeItemsLayout == null) {
            SwipeItemsPanel swipeItemsPanel = new SwipeItemsPanel(this.context);
            SwipeItemsLayout create = SwipeItemsLayout.INSTANCE.create(swipeItemsPanel, this.adapter, swipeGroup);
            this._swipeItemsLayout = create;
            swipeItemsPanel.setContainerLayout(create);
            this.itemContainerLayout.setSwipeItemsLayout(this._swipeItemsLayout);
        }
        boolean z = this._swipeGroup == DXSwipeGroup.Start;
        float actualSwipeOffset$dxlistview_release = getActualSwipeOffset$dxlistview_release() + swipeDelta;
        if (openingState && ((z && actualSwipeOffset$dxlistview_release < 0.0f) || (!z && actualSwipeOffset$dxlistview_release > 0.0f))) {
            if (this.adapter.getIsListViewVertical()) {
                PointF pointF = this.initialStartMoving;
                Intrinsics.checkNotNull(pointF);
                pointF.x = this.lastMoveX + this._committedOffset;
            } else {
                PointF pointF2 = this.initialStartMoving;
                Intrinsics.checkNotNull(pointF2);
                pointF2.y = this.lastMoveY + this._committedOffset;
            }
        }
        applySwipeOffset();
    }

    private final void applySwipeOffset(int swipeOffset) {
        this._interactionUserOffset = swipeOffset;
        int abs = Math.abs(getActualSwipeOffset$dxlistview_release());
        if ((isFullSwipeAllowed() && abs > this.itemContainerLayout.getAutoActionTargetOffset() && !this._isDefaultButtonExpanded) || (abs < this.itemContainerLayout.getAutoActionTargetOffset() && this._isDefaultButtonExpanded)) {
            startDefaultActionItemAnimation(this._isDefaultButtonExpanded ? 0.0f : 1.0f, new Function0<Unit>() { // from class: com.devexpress.dxlistview.swipes.SwipeViewManager$applySwipeOffset$1
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
                    ItemContainerLayout itemContainerLayout;
                    int actualSwipeOffsetPoint;
                    itemContainerLayout = SwipeViewManager.this.itemContainerLayout;
                    actualSwipeOffsetPoint = SwipeViewManager.this.getActualSwipeOffsetPoint();
                    itemContainerLayout.setContentOffset(actualSwipeOffsetPoint);
                }
            });
            this._isDefaultButtonExpanded = !this._isDefaultButtonExpanded;
        } else {
            this.itemContainerLayout.setContentOffset(getActualSwipeOffsetPoint());
        }
    }

    private final void applySwipeOffset() {
        applySwipeOffset(getSwipeOffset$dxlistview_release());
    }

    private final void clearState() {
        cancelDefaultActionItemAnimation();
        cancelUpAnimation();
        this.itemContainerLayout.clear();
        this._swipeItemsLayout = null;
        this._committedOffset = 0;
        this._interactionUserOffset = 0;
        this.lastMoveX = 0.0f;
        this.lastMoveY = 0.0f;
        this.initialStartMoving = new PointF();
        this._motionDirection = MotionDirection.None;
    }

    private final void cancelUpAnimation() {
        ValueAnimator valueAnimator = this.swipeActionUpAnimation;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
            if (valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.swipeActionUpAnimation;
                Intrinsics.checkNotNull(valueAnimator2);
                valueAnimator2.cancel();
            }
        }
    }

    private final void startSwipeAnimation(float to, final Function0<Unit> onSwipeAnimationEnd) {
        cancelUpAnimation();
        ValueAnimator valueAnimator = new ValueAnimator();
        this.swipeActionUpAnimation = valueAnimator;
        Intrinsics.checkNotNull(valueAnimator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.devexpress.dxlistview.swipes.SwipeViewManager$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                SwipeViewManager.startSwipeAnimation$lambda$0(SwipeViewManager.this, valueAnimator2);
            }
        });
        ValueAnimator valueAnimator2 = this.swipeActionUpAnimation;
        Intrinsics.checkNotNull(valueAnimator2);
        valueAnimator2.addListener(new Animator.AnimatorListener() { // from class: com.devexpress.dxlistview.swipes.SwipeViewManager$startSwipeAnimation$2
            private boolean cancelled;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            public final boolean getCancelled() {
                return this.cancelled;
            }

            public final void setCancelled(boolean z) {
                this.cancelled = z;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SwipeViewManager.this.commitSwipeOffset();
                SwipeViewManager.this.state = SwipeViewState.Opening;
                this.cancelled = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (this.cancelled) {
                    return;
                }
                onSwipeAnimationEnd.invoke();
            }
        });
        int i = this._committedOffset;
        int actualSwipeOffset$dxlistview_release = getActualSwipeOffset$dxlistview_release() - i;
        ValueAnimator valueAnimator3 = this.swipeActionUpAnimation;
        Intrinsics.checkNotNull(valueAnimator3);
        valueAnimator3.setFloatValues(actualSwipeOffset$dxlistview_release, to - i);
        ValueAnimator valueAnimator4 = this.swipeActionUpAnimation;
        Intrinsics.checkNotNull(valueAnimator4);
        valueAnimator4.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startSwipeAnimation$lambda$0(SwipeViewManager this$0, ValueAnimator animation) {
        int round;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (this$0.adapter.getIsListViewVertical()) {
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            round = MathHelper.round(((Float) animatedValue).floatValue());
        } else {
            Object animatedValue2 = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
            round = MathHelper.round(((Float) animatedValue2).floatValue());
        }
        this$0.applySwipeOffset(round);
    }

    private final void cancelDefaultActionItemAnimation() {
        ValueAnimator valueAnimator = this.swipeDefaultActionItemAnimation;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
            if (valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.swipeDefaultActionItemAnimation;
                Intrinsics.checkNotNull(valueAnimator2);
                valueAnimator2.cancel();
            }
        }
    }

    private final void startDefaultActionItemAnimation(float to, final Function0<Unit> onAnimationEnd) {
        cancelDefaultActionItemAnimation();
        ValueAnimator valueAnimator = new ValueAnimator();
        this.swipeDefaultActionItemAnimation = valueAnimator;
        Intrinsics.checkNotNull(valueAnimator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.devexpress.dxlistview.swipes.SwipeViewManager$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                SwipeViewManager.startDefaultActionItemAnimation$lambda$2(SwipeViewManager.this, valueAnimator2);
            }
        });
        ValueAnimator valueAnimator2 = this.swipeDefaultActionItemAnimation;
        Intrinsics.checkNotNull(valueAnimator2);
        valueAnimator2.addListener(new Animator.AnimatorListener() { // from class: com.devexpress.dxlistview.swipes.SwipeViewManager$startDefaultActionItemAnimation$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                onAnimationEnd.invoke();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                onAnimationEnd.invoke();
            }
        });
        ValueAnimator valueAnimator3 = this.swipeDefaultActionItemAnimation;
        Intrinsics.checkNotNull(valueAnimator3);
        SwipeItemsLayout swipeItemsLayout = this._swipeItemsLayout;
        Intrinsics.checkNotNull(swipeItemsLayout);
        valueAnimator3.setFloatValues(swipeItemsLayout.getScaleDefaultItemSizeProgress(), to);
        ValueAnimator valueAnimator4 = this.swipeDefaultActionItemAnimation;
        Intrinsics.checkNotNull(valueAnimator4);
        valueAnimator4.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startDefaultActionItemAnimation$lambda$2(SwipeViewManager this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        this$0.itemContainerLayout.forceSetContentOffset(this$0.getActualSwipeOffsetPoint());
        SwipeItemsLayout swipeItemsLayout = this$0._swipeItemsLayout;
        Intrinsics.checkNotNull(swipeItemsLayout);
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        swipeItemsLayout.setScaleDefaultItemSizeProgress(((Float) animatedValue).floatValue());
    }

    private final LayoutElement findElementBy(int x, int y) {
        if (this._swipeItemsLayout == null) {
            return null;
        }
        if ((this.adapter.getIsListViewVertical() && Math.abs(getActualSwipeOffset$dxlistview_release()) < Math.abs(x)) || (!this.adapter.getIsListViewVertical() && Math.abs(getActualSwipeOffset$dxlistview_release()) < Math.abs(y))) {
            return null;
        }
        SwipeItemsLayout swipeItemsLayout = this._swipeItemsLayout;
        Intrinsics.checkNotNull(swipeItemsLayout);
        return swipeItemsLayout.findElementBy(new Point(x, y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void itemTap(int index) {
        this.adapter.itemTap(index, this._swipeGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void commitSwipeOffset() {
        this._committedOffset = getActualSwipeOffsetPoint();
        this._interactionUserOffset = 0;
    }

    private final Point convertToSwipeItemsPanelCoordinates(PointF point) {
        Point point2 = new Point(MathHelper.round(point.x), MathHelper.round(point.y));
        if (this._swipeItemsLayout == null) {
            return point2;
        }
        SwipeItemsLayout swipeItemsLayout = this._swipeItemsLayout;
        Intrinsics.checkNotNull(swipeItemsLayout);
        int left = swipeItemsLayout.getOwner().getLeft();
        SwipeItemsLayout swipeItemsLayout2 = this._swipeItemsLayout;
        Intrinsics.checkNotNull(swipeItemsLayout2);
        Point point3 = new Point(left, swipeItemsLayout2.getOwner().getTop());
        return new Point(point2.x - point3.x, point2.y - point3.y);
    }
}
