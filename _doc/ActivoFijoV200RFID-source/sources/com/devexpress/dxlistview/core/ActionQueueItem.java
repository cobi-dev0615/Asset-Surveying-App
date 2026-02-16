package com.devexpress.dxlistview.core;

import android.view.View;

/* loaded from: classes2.dex */
public class ActionQueueItem {
    private final QueueItemAction action;
    private final QueueItemCompleteAction completeAction;
    private final int index;
    private final int nodePosition;
    private final View view;
    private final int viewType;

    public ActionQueueItem(View view, int i, int i2, int i3, QueueItemAction queueItemAction, QueueItemCompleteAction queueItemCompleteAction) {
        this.view = view;
        this.index = i2;
        this.nodePosition = i;
        this.viewType = i3;
        this.action = queueItemAction;
        this.completeAction = queueItemCompleteAction;
    }

    View getView() {
        return this.view;
    }

    int getIndex() {
        return this.index;
    }

    int getNodePosition() {
        return this.nodePosition;
    }

    int getViewType() {
        return this.viewType;
    }

    QueueItemAction getAction() {
        return this.action;
    }

    QueueItemCompleteAction getCompleteAction() {
        return this.completeAction;
    }
}
