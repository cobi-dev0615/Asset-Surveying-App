package com.devexpress.editors;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DXLocker.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0086\bø\u0001\u0000J\u001a\u0010\f\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0086\bø\u0001\u0000J\u001a\u0010\r\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0086\bø\u0001\u0000J\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"Lcom/devexpress/editors/DXLocker;", "", "()V", "isLocked", "", "()Z", "lockerCount", "", "doIfNotLocked", "", "action", "Lkotlin/Function0;", "doLocked", "doLockedIfNotLocked", "lock", "unlock", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXLocker {
    private int lockerCount;

    public final void lock() {
        this.lockerCount++;
    }

    public final void unlock() {
        int i = this.lockerCount;
        if (i == 0) {
            return;
        }
        this.lockerCount = i - 1;
    }

    public final boolean isLocked() {
        return this.lockerCount > 0;
    }

    public final void doLocked(Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        try {
            lock();
            action.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            unlock();
            InlineMarker.finallyEnd(1);
        }
    }

    public final void doLockedIfNotLocked(Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (isLocked()) {
            return;
        }
        try {
            lock();
            action.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            unlock();
            InlineMarker.finallyEnd(1);
        }
    }

    public final void doIfNotLocked(Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (isLocked()) {
            return;
        }
        action.invoke();
    }
}
