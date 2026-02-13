package com.devexpress.editors.pickers;

import android.graphics.Point;
import android.util.Size;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.editors.model.Thickness;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: LayoutProvider.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ*\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u001dJ\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\u000e\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u001e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#J\u000e\u0010&\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/devexpress/editors/pickers/LayoutProvider;", "", "rowsOnPage", "", "columnsOnPage", "containerSize", "Landroid/util/Size;", "cellsSpacing", "padding", "Lcom/devexpress/editors/model/Thickness;", "headerHeight", "(IILandroid/util/Size;Landroid/util/Size;Lcom/devexpress/editors/model/Thickness;I)V", "cellHeight", "", "cellWidth", "cellsIndexRange", "Lkotlin/ranges/IntRange;", "cellsLocations", "", "Landroid/graphics/Point;", "cellsOnPage", "getCellsOnPage", "()I", "doActionForCellIndexIfItIsVisible", "", "isVisible", "", TypedValues.CycleType.S_WAVE_OFFSET, "action", "Lkotlin/Function1;", "get", "cellIndex", "indexOnPage", "layoutCell", "view", "Landroid/view/View;", "mapCellIndexes", "measureCell", "page", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LayoutProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double cellHeight;
    private final double cellWidth;
    private final IntRange cellsIndexRange;
    private List<? extends Point> cellsLocations;
    private final int cellsOnPage;
    private final Size cellsSpacing;
    private final int columnsOnPage;
    private final Size containerSize;
    private final int headerHeight;
    private final Thickness padding;

    public LayoutProvider(int i, int i2, Size containerSize, Size cellsSpacing, Thickness padding, int i3) {
        Intrinsics.checkNotNullParameter(containerSize, "containerSize");
        Intrinsics.checkNotNullParameter(cellsSpacing, "cellsSpacing");
        Intrinsics.checkNotNullParameter(padding, "padding");
        this.columnsOnPage = i2;
        this.containerSize = containerSize;
        this.cellsSpacing = cellsSpacing;
        this.padding = padding;
        this.headerHeight = i3;
        int i4 = i * i2;
        this.cellsOnPage = i4;
        Companion companion = INSTANCE;
        this.cellWidth = companion.calcCellSize(containerSize.getWidth(), i2, padding.getHorizontal(), cellsSpacing.getWidth());
        this.cellHeight = companion.calcCellSize(containerSize.getHeight(), i, padding.getVertical() + cellsSpacing.getHeight() + i3, cellsSpacing.getHeight());
        this.cellsIndexRange = RangesKt.until(-i4, i4 * 2);
        this.cellsLocations = mapCellIndexes();
    }

    /* compiled from: LayoutProvider.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¨\u0006\n"}, d2 = {"Lcom/devexpress/editors/pickers/LayoutProvider$Companion;", "", "()V", "calcCellSize", "", "containerSize", "", "cellsInContainerCount", "containerPadding", "cellsSpacing", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final double calcCellSize(int containerSize, int cellsInContainerCount, int containerPadding, int cellsSpacing) {
            return ((containerSize - containerPadding) - (cellsSpacing * (cellsInContainerCount - 1))) / cellsInContainerCount;
        }

        private Companion() {
        }
    }

    public final int getCellsOnPage() {
        return this.cellsOnPage;
    }

    public final int page(int cellIndex) {
        return CalendarMath.INSTANCE.div(cellIndex, this.cellsOnPage);
    }

    public final int indexOnPage(int cellIndex) {
        return CalendarMath.INSTANCE.mod(cellIndex, this.cellsOnPage);
    }

    private final List<Point> mapCellIndexes() {
        IntRange intRange = this.cellsIndexRange;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            Point point = new Point();
            int div = CalendarMath.INSTANCE.div(nextInt, this.cellsOnPage);
            int mod = CalendarMath.INSTANCE.mod(nextInt, this.cellsOnPage);
            int mod2 = CalendarMath.INSTANCE.mod(mod, this.columnsOnPage);
            int div2 = CalendarMath.INSTANCE.div(mod, this.columnsOnPage);
            point.x = (div * this.containerSize.getWidth()) + this.padding.getStart() + ((int) ((mod2 * (this.cellWidth + this.cellsSpacing.getWidth())) + 0.5d));
            point.y = this.padding.getTop() + ((int) ((div2 * (this.cellHeight + this.cellsSpacing.getHeight())) + this.headerHeight + this.cellsSpacing.getHeight() + 0.5d));
            arrayList.add(point);
        }
        return arrayList;
    }

    private final Point get(int cellIndex) {
        return this.cellsLocations.get(cellIndex - this.cellsIndexRange.getFirst());
    }

    private final boolean isVisible(int cellIndex, int offset) {
        int width = this.containerSize.getWidth();
        int i = get(cellIndex).x + offset;
        return i >= 0 && i <= width;
    }

    public final void doActionForCellIndexIfItIsVisible(boolean isVisible, int offset, Function1<? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator<Integer> it = this.cellsIndexRange.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            if (isVisible(nextInt, offset) == isVisible) {
                action.invoke(Integer.valueOf(nextInt));
            }
        }
    }

    public final void measureCell(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.measure(View.MeasureSpec.makeMeasureSpec((int) (this.cellWidth + 0.5d), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec((int) (this.cellHeight + 0.5d), BasicMeasure.EXACTLY));
    }

    public final void layoutCell(View view, int cellIndex, int offset) {
        Intrinsics.checkNotNullParameter(view, "view");
        Point point = get(cellIndex);
        view.layout(point.x, point.y, point.x + ((int) (this.cellWidth + 0.5d)), point.y + ((int) (this.cellHeight + 0.5d)));
        view.setTranslationX(offset);
    }
}
