package com.devexpress.dxlistview.core;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class DXAsyncActionQueue {
    private final long availableTime;
    private CanSkipAction canSkipIteration;
    private final long delay;
    private final Handler handler;
    private long lastUpdate;
    private final long maxDelay;
    private final Runnable queueRunnable = new Runnable() { // from class: com.devexpress.dxlistview.core.DXAsyncActionQueue$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            DXAsyncActionQueue.this.queue();
        }
    };
    private DXAsyncActionQueueState state = DXAsyncActionQueueState.Free;
    private final ArrayList<ActionQueueItem> queue = new ArrayList<>();
    private boolean suspended = false;

    public DXAsyncActionQueue(long j, long j2, long j3, Context context) {
        this.delay = j;
        this.maxDelay = j2;
        this.availableTime = j3;
        this.handler = new Handler(context.getMainLooper());
    }

    public void setCanSkipIteration(CanSkipAction canSkipAction) {
        this.canSkipIteration = canSkipAction;
    }

    public void pushAction(QueueItemAction queueItemAction, QueueItemCompleteAction queueItemCompleteAction, View view, int i, int i2, int i3) {
        this.queue.add(new ActionQueueItem(view, i, i2, i3, queueItemAction, queueItemCompleteAction));
        resume();
    }

    public void pushAction(QueueItemAction queueItemAction, View view, int i, int i2, int i3) {
        this.queue.add(new ActionQueueItem(view, i, i2, i3, queueItemAction, null));
        resume();
    }

    public void removeAction(int i, View view) {
        int i2 = 0;
        while (i2 < this.queue.size()) {
            ActionQueueItem actionQueueItem = this.queue.get(i2);
            if (actionQueueItem.getIndex() == i && actionQueueItem.getView() == view) {
                this.queue.remove(actionQueueItem);
            } else {
                i2++;
            }
        }
    }

    public void suspend() {
        this.suspended = true;
    }

    public void resume() {
        this.suspended = false;
        if (this.state != DXAsyncActionQueueState.Free || this.queue.size() <= 0) {
            return;
        }
        this.state = DXAsyncActionQueueState.Busy;
        runWithDelay();
    }

    public boolean canSkip() {
        CanSkipAction canSkipAction = this.canSkipIteration;
        if (canSkipAction == null) {
            return false;
        }
        return canSkipAction.run();
    }

    public void queue() {
        if (this.suspended) {
            this.state = DXAsyncActionQueueState.Free;
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (this.queue.size() > 0 && ((SystemClock.elapsedRealtime() - this.lastUpdate >= this.maxDelay || !canSkip()) && SystemClock.elapsedRealtime() - elapsedRealtime <= this.availableTime)) {
            processNext();
            this.lastUpdate = SystemClock.elapsedRealtime();
        }
        if (this.queue.size() > 0) {
            runWithDelay();
        } else {
            this.state = DXAsyncActionQueueState.Free;
        }
    }

    void runWithDelay() {
        this.handler.postDelayed(this.queueRunnable, this.delay);
    }

    void processNext() {
        ActionQueueItem actionQueueItem = this.queue.get(0);
        if (actionQueueItem.getAction() != null ? true ^ actionQueueItem.getAction().run(actionQueueItem.getView(), actionQueueItem.getNodePosition(), actionQueueItem.getIndex(), actionQueueItem.getViewType()) : true) {
            this.queue.remove(0);
            if (actionQueueItem.getCompleteAction() != null) {
                actionQueueItem.getCompleteAction().run(actionQueueItem.getView(), actionQueueItem.getNodePosition(), actionQueueItem.getIndex());
            }
        }
    }
}
