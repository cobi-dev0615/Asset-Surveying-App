package com.devexpress.dxgrid.utils;

import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.dxgrid.utils.providers.ColumnsProvider;
import com.devexpress.dxgrid.views.GridCellContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MeasureHelper.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/devexpress/dxgrid/utils/MeasureHelper;", "", "()V", "Companion", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MeasureHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: MeasureHelper.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/devexpress/dxgrid/utils/MeasureHelper$Companion;", "", "()V", "measureView", "", "columnsProvider", "Lcom/devexpress/dxgrid/utils/providers/ColumnsProvider;", "view", "Lcom/devexpress/dxgrid/views/GridCellContainer;", "rowHeight", "", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void measureView(ColumnsProvider columnsProvider, GridCellContainer view, int rowHeight) {
            Intrinsics.checkNotNullParameter(columnsProvider, "columnsProvider");
            Intrinsics.checkNotNullParameter(view, "view");
            int width = columnsProvider.getColumn(view.getColumnIndex()).getWidth();
            int i = BasicMeasure.EXACTLY;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, BasicMeasure.EXACTLY);
            if (rowHeight <= 0) {
                i = 0;
            }
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(rowHeight, i);
            if (!view.isLayoutRequested() && view.getCell().isLayoutRequested()) {
                view.forceLayout();
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
        }
    }
}
