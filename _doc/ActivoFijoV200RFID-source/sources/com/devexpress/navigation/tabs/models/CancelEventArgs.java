package com.devexpress.navigation.tabs.models;

/* loaded from: classes2.dex */
public class CancelEventArgs {
    boolean mCancel;

    public CancelEventArgs() {
        this.mCancel = false;
    }

    public CancelEventArgs(boolean z) {
        this.mCancel = z;
    }

    public void setCancel(boolean z) {
        this.mCancel = z;
    }

    public boolean getCancel() {
        return this.mCancel;
    }
}
