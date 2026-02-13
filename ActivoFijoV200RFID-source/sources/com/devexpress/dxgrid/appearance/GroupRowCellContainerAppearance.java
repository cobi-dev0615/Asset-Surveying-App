package com.devexpress.dxgrid.appearance;

import android.graphics.Rect;
import kotlin.Metadata;

/* compiled from: GroupRowCellContainerAppearance.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/devexpress/dxgrid/appearance/GroupRowCellContainerAppearance;", "Lcom/devexpress/dxgrid/appearance/PaddingCellContainerAppearance;", "()V", "noPadding", "Landroid/graphics/Rect;", "getPadding", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GroupRowCellContainerAppearance extends PaddingCellContainerAppearance {
    private final Rect noPadding = new Rect();

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    /* renamed from: getPadding, reason: from getter */
    public Rect getNoPadding() {
        return this.noPadding;
    }
}
