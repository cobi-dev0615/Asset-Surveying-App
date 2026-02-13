package com.devexpress.navigation.tabs.models;

import kotlin.Metadata;

/* compiled from: TabSizeInPixels.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/devexpress/navigation/tabs/models/TabSizeInPixels;", "", "size", "", "minSize", "maxSize", "isStar", "", "isAuto", "(IIIZZ)V", "()Z", "getMaxSize", "()I", "getMinSize", "getSize", "setSize", "(I)V", "dxnavigation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TabSizeInPixels {
    private final boolean isAuto;
    private final boolean isStar;
    private final int maxSize;
    private final int minSize;
    private int size;

    public TabSizeInPixels(int i, int i2, int i3, boolean z, boolean z2) {
        this.size = i;
        this.minSize = i2;
        this.maxSize = i3;
        this.isStar = z;
        this.isAuto = z2;
    }

    public final int getSize() {
        return this.size;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    public final int getMinSize() {
        return this.minSize;
    }

    public final int getMaxSize() {
        return this.maxSize;
    }

    /* renamed from: isStar, reason: from getter */
    public final boolean getIsStar() {
        return this.isStar;
    }

    /* renamed from: isAuto, reason: from getter */
    public final boolean getIsAuto() {
        return this.isAuto;
    }
}
