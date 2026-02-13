package com.devexpress.dxgrid.layout;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.devexpress.dxgrid.layout.RunnablesQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RunnablesQueue.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\b\u0010\u0016\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/devexpress/dxgrid/layout/RunnablesQueue;", "", "()V", "first", "Lcom/devexpress/dxgrid/layout/RunnablesQueue$Item;", "handler", "Landroid/os/Handler;", "hasItems", "", "getHasItems", "()Z", "last", "processQueue", "Ljava/lang/Runnable;", "readyForNextRunnable", "add", "", "item", "findIntervalStart", TypedValues.TransitionType.S_FROM, "moveIntervalToEnd", TypedValues.TransitionType.S_TO, "resume", "Companion", "Item", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RunnablesQueue {
    private static final int AVAILABLE_TIME = 5;
    private static final long RUNNABLE_DELAY = 10;
    private final Item first;
    private final Handler handler;
    private final Item last;
    private final Runnable processQueue;
    private boolean readyForNextRunnable;

    /* JADX WARN: Multi-variable type inference failed */
    public RunnablesQueue() {
        boolean z = false;
        int i = 3;
        Item item = new Item(null, z, i, 0 == true ? 1 : 0);
        this.first = item;
        Item item2 = new Item(0 == true ? 1 : 0, z, i, 0 == true ? 1 : 0);
        this.last = item2;
        item.insertAfter(item2);
        this.handler = new Handler(Looper.getMainLooper());
        this.readyForNextRunnable = true;
        this.processQueue = new Runnable() { // from class: com.devexpress.dxgrid.layout.RunnablesQueue$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RunnablesQueue.processQueue$lambda$0(RunnablesQueue.this);
            }
        };
    }

    public final void add(Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        item.remove();
        this.last.insertBefore(item);
        resume();
    }

    public final void moveIntervalToEnd(Item from, Item to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        from.getPrev().setNext$dxgrid_release(to.getNext());
        to.getNext().setPrev$dxgrid_release(from.getPrev());
        this.last.getPrev().setNext$dxgrid_release(from);
        from.setPrev$dxgrid_release(this.last.getPrev());
        to.setNext$dxgrid_release(this.last);
        this.last.setPrev$dxgrid_release(to);
    }

    public final Item findIntervalStart(Item from) {
        Intrinsics.checkNotNullParameter(from, "from");
        while (!Intrinsics.areEqual(from.getPrev(), this.first) && !from.getPrev().getIsShowAll()) {
            from = from.getPrev();
        }
        return from;
    }

    public final boolean getHasItems() {
        return !Intrinsics.areEqual(this.first.getNext(), this.last);
    }

    private final void resume() {
        if (getHasItems() && this.readyForNextRunnable) {
            this.readyForNextRunnable = false;
            this.handler.postDelayed(this.processQueue, RUNNABLE_DELAY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processQueue$lambda$0(RunnablesQueue this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long elapsedRealtime = SystemClock.elapsedRealtime() + 5;
        while (this$0.getHasItems()) {
            this$0.first.getNext().remove().getRunnable().run();
            if (SystemClock.elapsedRealtime() >= elapsedRealtime) {
                break;
            }
        }
        this$0.readyForNextRunnable = true;
        this$0.resume();
    }

    /* compiled from: RunnablesQueue.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0000J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0000J\u0006\u0010\u001a\u001a\u00020\u0000R\u0011\u0010\u0007\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR$\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/devexpress/dxgrid/layout/RunnablesQueue$Item;", "", "runnable", "Ljava/lang/Runnable;", "isShowAll", "", "(Ljava/lang/Runnable;Z)V", "isInQueue", "()Z", "<set-?>", "next", "getNext", "()Lcom/devexpress/dxgrid/layout/RunnablesQueue$Item;", "setNext$dxgrid_release", "(Lcom/devexpress/dxgrid/layout/RunnablesQueue$Item;)V", "prev", "getPrev", "setPrev$dxgrid_release", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "insertAfter", "", "item", "insertBefore", "remove", "Companion", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Item {
        private static final Item empty = new Item(0 == true ? 1 : 0, false, 3, 0 == true ? 1 : 0);
        private final boolean isShowAll;
        private Item next;
        private Item prev;
        private Runnable runnable;

        /* JADX WARN: Multi-variable type inference failed */
        public Item() {
            this(null, false, 3, 0 == true ? 1 : 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0() {
        }

        public Item(Runnable runnable, boolean z) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.runnable = runnable;
            this.isShowAll = z;
            Item item = empty;
            this.prev = item;
            this.next = item;
        }

        public /* synthetic */ Item(Runnable runnable, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new Runnable() { // from class: com.devexpress.dxgrid.layout.RunnablesQueue$Item$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    RunnablesQueue.Item._init_$lambda$0();
                }
            } : runnable, (i & 2) != 0 ? false : z);
        }

        public final Runnable getRunnable() {
            return this.runnable;
        }

        /* renamed from: isShowAll, reason: from getter */
        public final boolean getIsShowAll() {
            return this.isShowAll;
        }

        public final void setRunnable(Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "<set-?>");
            this.runnable = runnable;
        }

        public final Item getPrev() {
            return this.prev;
        }

        public final void setPrev$dxgrid_release(Item item) {
            Intrinsics.checkNotNullParameter(item, "<set-?>");
            this.prev = item;
        }

        public final Item getNext() {
            return this.next;
        }

        public final void setNext$dxgrid_release(Item item) {
            Intrinsics.checkNotNullParameter(item, "<set-?>");
            this.next = item;
        }

        public final void insertAfter(Item item) {
            Intrinsics.checkNotNullParameter(item, "item");
            item.prev = this;
            item.next = this.next;
            this.next.prev = item;
            this.next = item;
        }

        public final void insertBefore(Item item) {
            Intrinsics.checkNotNullParameter(item, "item");
            item.next = this;
            item.prev = this.prev;
            this.prev.next = item;
            this.prev = item;
        }

        public final Item remove() {
            Item item = this.prev;
            item.next = this.next;
            this.next.prev = item;
            Item item2 = empty;
            this.prev = item2;
            this.next = item2;
            return this;
        }

        public final boolean isInQueue() {
            Item item = this.next;
            Item item2 = empty;
            return (Intrinsics.areEqual(item, item2) || Intrinsics.areEqual(this.prev, item2)) ? false : true;
        }
    }
}
