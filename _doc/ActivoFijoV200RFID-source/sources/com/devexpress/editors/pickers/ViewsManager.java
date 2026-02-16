package com.devexpress.editors.pickers;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ViewsManager.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0004H&J\b\u0010\u0016\u001a\u00020\u0010H$J\b\u0010\u0017\u001a\u00020\u0010H$J\u0006\u0010\u0018\u001a\u00020\u0010J\u0006\u0010\u0019\u001a\u00020\u0010J\u0006\u0010\u001a\u001a\u00020\rJ\u0006\u0010\u001b\u001a\u00020\rJ\u0006\u0010\u001c\u001a\u00020\u0010J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/devexpress/editors/pickers/ViewsManager;", "", "()V", "_layoutProvider", "Lcom/devexpress/editors/pickers/LayoutProvider;", "layoutProvider", "getLayoutProvider", "()Lcom/devexpress/editors/pickers/LayoutProvider;", "viewsUpdater", "Lcom/devexpress/editors/pickers/ViewsUpdater;", "getViewsUpdater", "()Lcom/devexpress/editors/pickers/ViewsUpdater;", "canSwitchToNextPage", "", "canSwitchToPreviousPage", "hide", "", "invalidateLayoutCache", "layout", TypedValues.CycleType.S_WAVE_OFFSET, "", "obtainCellLocationProvider", "onSwitchToNextPage", "onSwitchToPreviousPage", "recycle", "show", "switchToNextPage", "switchToPreviousPage", "update", "validateOffset", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ViewsManager {
    private LayoutProvider _layoutProvider;

    public abstract boolean canSwitchToNextPage();

    public abstract boolean canSwitchToPreviousPage();

    public abstract ViewsUpdater getViewsUpdater();

    public abstract LayoutProvider obtainCellLocationProvider();

    protected abstract void onSwitchToNextPage();

    protected abstract void onSwitchToPreviousPage();

    public final LayoutProvider getLayoutProvider() {
        LayoutProvider layoutProvider = this._layoutProvider;
        if (layoutProvider == null) {
            layoutProvider = obtainCellLocationProvider();
        }
        this._layoutProvider = layoutProvider;
        return layoutProvider;
    }

    public final void invalidateLayoutCache() {
        this._layoutProvider = null;
    }

    private final int validateOffset(int offset) {
        if (offset < 0 && canSwitchToNextPage()) {
            return offset;
        }
        if (offset <= 0 || !canSwitchToPreviousPage()) {
            return 0;
        }
        return offset;
    }

    public final void layout(int offset) {
        final int validateOffset = validateOffset(offset);
        getLayoutProvider().doActionForCellIndexIfItIsVisible(false, validateOffset, new Function1<Integer, Unit>() { // from class: com.devexpress.editors.pickers.ViewsManager$layout$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                ViewsManager.this.getViewsUpdater().recycleViewForCellWithIndex(i);
            }
        });
        getLayoutProvider().doActionForCellIndexIfItIsVisible(true, validateOffset, new Function1<Integer, Unit>() { // from class: com.devexpress.editors.pickers.ViewsManager$layout$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                View viewForCellWithIndex = ViewsManager.this.getViewsUpdater().getViewForCellWithIndex(i);
                if (viewForCellWithIndex != null) {
                    ViewsManager.this.getLayoutProvider().layoutCell(viewForCellWithIndex, i, validateOffset);
                }
            }
        });
    }

    public final void update() {
        getViewsUpdater().update();
    }

    public final void recycle() {
        getViewsUpdater().recycle();
    }

    public final void hide() {
        getViewsUpdater().hide();
    }

    public final void show() {
        getViewsUpdater().show();
    }

    public final boolean switchToPreviousPage() {
        if (!canSwitchToPreviousPage()) {
            return false;
        }
        onSwitchToPreviousPage();
        return true;
    }

    public final boolean switchToNextPage() {
        if (!canSwitchToNextPage()) {
            return false;
        }
        onSwitchToNextPage();
        return true;
    }
}
