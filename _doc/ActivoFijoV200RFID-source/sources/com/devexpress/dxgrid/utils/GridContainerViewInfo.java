package com.devexpress.dxgrid.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GridContainerViewInfo.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/devexpress/dxgrid/utils/GridContainerViewInfo;", "", "fixedColumnSeparatorStyle", "Lcom/devexpress/dxgrid/utils/FixedColumnSeparatorStyle;", "drawLeftBorder", "", "drawRightBorder", "drawTopBorder", "drawBottomBorder", "bottomContainer", "(Lcom/devexpress/dxgrid/utils/FixedColumnSeparatorStyle;ZZZZZ)V", "getBottomContainer", "()Z", "getDrawBottomBorder", "getDrawLeftBorder", "getDrawRightBorder", "getDrawTopBorder", "getFixedColumnSeparatorStyle", "()Lcom/devexpress/dxgrid/utils/FixedColumnSeparatorStyle;", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GridContainerViewInfo {
    private final boolean bottomContainer;
    private final boolean drawBottomBorder;
    private final boolean drawLeftBorder;
    private final boolean drawRightBorder;
    private final boolean drawTopBorder;
    private final FixedColumnSeparatorStyle fixedColumnSeparatorStyle;

    public GridContainerViewInfo(FixedColumnSeparatorStyle fixedColumnSeparatorStyle, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(fixedColumnSeparatorStyle, "fixedColumnSeparatorStyle");
        this.fixedColumnSeparatorStyle = fixedColumnSeparatorStyle;
        this.drawLeftBorder = z;
        this.drawRightBorder = z2;
        this.drawTopBorder = z3;
        this.drawBottomBorder = z4;
        this.bottomContainer = z5;
    }

    public final FixedColumnSeparatorStyle getFixedColumnSeparatorStyle() {
        return this.fixedColumnSeparatorStyle;
    }

    public final boolean getDrawLeftBorder() {
        return this.drawLeftBorder;
    }

    public final boolean getDrawRightBorder() {
        return this.drawRightBorder;
    }

    public final boolean getDrawTopBorder() {
        return this.drawTopBorder;
    }

    public final boolean getDrawBottomBorder() {
        return this.drawBottomBorder;
    }

    public final boolean getBottomContainer() {
        return this.bottomContainer;
    }
}
