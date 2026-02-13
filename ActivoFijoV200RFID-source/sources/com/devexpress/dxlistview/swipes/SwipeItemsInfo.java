package com.devexpress.dxlistview.swipes;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwipeItemsInfo.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/devexpress/dxlistview/swipes/SwipeItemsInfo;", "", "views", "", "Lcom/devexpress/dxlistview/swipes/SwipeItemContainerView;", "sizes", "", "colors", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getColors", "()Ljava/util/List;", "getSizes", "getViews", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SwipeItemsInfo {
    private final List<Integer> colors;
    private final List<Integer> sizes;
    private final List<SwipeItemContainerView> views;

    public SwipeItemsInfo(List<SwipeItemContainerView> views, List<Integer> sizes, List<Integer> colors) {
        Intrinsics.checkNotNullParameter(views, "views");
        Intrinsics.checkNotNullParameter(sizes, "sizes");
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.views = views;
        this.sizes = sizes;
        this.colors = colors;
    }

    public final List<SwipeItemContainerView> getViews() {
        return this.views;
    }

    public final List<Integer> getSizes() {
        return this.sizes;
    }

    public final List<Integer> getColors() {
        return this.colors;
    }
}
