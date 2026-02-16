package com.devexpress.dxgrid.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerticalRecyclerViewSmoothScroller.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/devexpress/dxgrid/utils/VerticalRecyclerViewSmoothScroller;", "", "cascadeUpdateProvider", "Lcom/devexpress/dxgrid/utils/CascadeUpdateProvider;", "inplaceEditingService", "Lcom/devexpress/dxgrid/interfaces/InplaceEditingService;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Lcom/devexpress/dxgrid/utils/CascadeUpdateProvider;Lcom/devexpress/dxgrid/interfaces/InplaceEditingService;Landroidx/recyclerview/widget/RecyclerView;)V", "smoothScrollBy", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VerticalRecyclerViewSmoothScroller {
    private final CascadeUpdateProvider cascadeUpdateProvider;
    private final com.devexpress.dxgrid.interfaces.InplaceEditingService inplaceEditingService;
    private final RecyclerView recyclerView;

    public VerticalRecyclerViewSmoothScroller(CascadeUpdateProvider cascadeUpdateProvider, com.devexpress.dxgrid.interfaces.InplaceEditingService inplaceEditingService, RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(cascadeUpdateProvider, "cascadeUpdateProvider");
        Intrinsics.checkNotNullParameter(inplaceEditingService, "inplaceEditingService");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.cascadeUpdateProvider = cascadeUpdateProvider;
        this.inplaceEditingService = inplaceEditingService;
        this.recyclerView = recyclerView;
    }

    public final void smoothScrollBy(int offset) {
        final boolean cascadeUpdateEnabled = this.cascadeUpdateProvider.getCascadeUpdateEnabled();
        final RecyclerView recyclerView = this.recyclerView;
        new SmoothValueAnimator(cascadeUpdateEnabled, recyclerView) { // from class: com.devexpress.dxgrid.utils.VerticalRecyclerViewSmoothScroller$smoothScrollBy$1
            final /* synthetic */ boolean $cascadeUpdateEnabled;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(recyclerView);
            }

            @Override // com.devexpress.dxgrid.utils.SmoothValueAnimator
            protected void onNewDeltaValue(int delta) {
                com.devexpress.dxgrid.interfaces.InplaceEditingService inplaceEditingService;
                RecyclerView recyclerView2;
                inplaceEditingService = VerticalRecyclerViewSmoothScroller.this.inplaceEditingService;
                if (inplaceEditingService.getInplaceEditorContainer() != null) {
                    recyclerView2 = VerticalRecyclerViewSmoothScroller.this.recyclerView;
                    recyclerView2.scrollBy(0, delta);
                } else {
                    cancel();
                }
            }

            @Override // com.devexpress.dxgrid.utils.SmoothValueAnimator
            protected void onStart() {
                CascadeUpdateProvider cascadeUpdateProvider;
                cascadeUpdateProvider = VerticalRecyclerViewSmoothScroller.this.cascadeUpdateProvider;
                cascadeUpdateProvider.setCascadeUpdateEnabled(false);
            }

            @Override // com.devexpress.dxgrid.utils.SmoothValueAnimator
            protected void onFinish() {
                CascadeUpdateProvider cascadeUpdateProvider;
                cascadeUpdateProvider = VerticalRecyclerViewSmoothScroller.this.cascadeUpdateProvider;
                cascadeUpdateProvider.setCascadeUpdateEnabled(this.$cascadeUpdateEnabled);
            }
        }.animate(offset);
    }
}
