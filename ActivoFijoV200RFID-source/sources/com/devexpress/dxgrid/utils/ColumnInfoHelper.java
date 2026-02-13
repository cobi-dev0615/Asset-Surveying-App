package com.devexpress.dxgrid.utils;

import androidx.camera.video.AudioStats;
import com.devexpress.dxgrid.models.FixedStyle;
import com.devexpress.dxgrid.models.GridControlModel;
import com.devexpress.dxgrid.models.GridLength;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.utils.ColumnInfoHelper;
import com.devexpress.dxgrid.utils.providers.ItemHeightProvider;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: ColumnInfoHelper.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00019B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0004J-\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 0\u000f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$¢\u0006\u0002\u0010%J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020+H\u0002JC\u0010-\u001a\u00020+2\u000e\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u000f2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0002\u00104J\b\u00105\u001a\u00020+H\u0002J\u000e\u00106\u001a\u00020+2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u00107\u001a\u00020+2\u0006\u00108\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u0011\u0010\u0014\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0006R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/devexpress/dxgrid/utils/ColumnInfoHelper;", "", "()V", "absoluteWidth", "", "getAbsoluteWidth", "()I", "cachedFixedEndColumnsWidth", "cachedFixedStartColumnsWidth", "cachedRowWidth", "calculator", "Lcom/devexpress/dxgrid/utils/GridColumnsCalculator;", "columnCount", "getColumnCount", "columnsInfo", "", "Lcom/devexpress/dxgrid/utils/ColumnInfo;", "[Lcom/devexpress/dxgrid/utils/ColumnInfo;", "fixedEndColumnsWidth", "getFixedEndColumnsWidth", "fixedStartColumnsWidth", "getFixedStartColumnsWidth", "gridControlModel", "Lcom/devexpress/dxgrid/models/GridControlModel;", "rowCalculators", "", "rowWidth", "getRowWidth", "viewPortWidth", "getColumn", "columnIndex", "getHeights", "Lkotlin/Pair;", "heights", "", "itemHeightProvider", "Lcom/devexpress/dxgrid/utils/providers/ItemHeightProvider;", "([ILcom/devexpress/dxgrid/utils/providers/ItemHeightProvider;)[Lkotlin/Pair;", "getMaxStarHeight", "", "rowHeights", "", "initialize", "", "initializeCalculators", "populateColumnsInfo", "info", "gridColumns", "Lcom/devexpress/dxgrid/models/columns/GridColumnModel;", "simple", "", "lastRow", "([Lcom/devexpress/dxgrid/utils/ColumnInfo;Lcom/devexpress/dxgrid/utils/GridColumnsCalculator;[Lcom/devexpress/dxgrid/models/columns/GridColumnModel;ZZ)V", "populateColumnsInfos", "setGridControlModel", "setViewPortWidth", "width", "LayoutInfo", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ColumnInfoHelper {
    private int cachedFixedEndColumnsWidth;
    private int cachedFixedStartColumnsWidth;
    private int cachedRowWidth;
    private GridColumnsCalculator calculator;
    private ColumnInfo[] columnsInfo;
    private GridControlModel gridControlModel;
    private final Map<Integer, GridColumnsCalculator> rowCalculators = new HashMap();
    private int viewPortWidth;

    public final void setGridControlModel(GridControlModel gridControlModel) {
        Intrinsics.checkNotNullParameter(gridControlModel, "gridControlModel");
        this.gridControlModel = gridControlModel;
        this.calculator = null;
        this.rowCalculators.clear();
        this.columnsInfo = null;
    }

    public final int getColumnCount() {
        GridControlModel gridControlModel = this.gridControlModel;
        if (gridControlModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
            gridControlModel = null;
        }
        return gridControlModel.getGridColumns().length;
    }

    public final void setViewPortWidth(int width) {
        if (this.viewPortWidth != width) {
            this.viewPortWidth = width;
            this.columnsInfo = null;
        }
        Iterator<T> it = this.rowCalculators.values().iterator();
        while (it.hasNext()) {
            ((GridColumnsCalculator) it.next()).setViewPortWidth(width);
        }
        GridColumnsCalculator gridColumnsCalculator = this.calculator;
        if (gridColumnsCalculator == null) {
            return;
        }
        gridColumnsCalculator.setViewPortWidth(this.viewPortWidth);
    }

    public final int getRowWidth() {
        if (this.columnsInfo == null) {
            initialize();
        }
        return this.cachedRowWidth;
    }

    public final int getFixedStartColumnsWidth() {
        if (this.columnsInfo == null) {
            initialize();
        }
        return this.cachedFixedStartColumnsWidth;
    }

    public final int getFixedEndColumnsWidth() {
        if (this.columnsInfo == null) {
            initialize();
        }
        return this.cachedFixedEndColumnsWidth;
    }

    public final int getAbsoluteWidth() {
        if (this.calculator == null && this.rowCalculators.isEmpty()) {
            initializeCalculators();
        }
        GridColumnsCalculator gridColumnsCalculator = this.calculator;
        if (gridColumnsCalculator != null) {
            return gridColumnsCalculator.getAbsoluteWidth();
        }
        Iterator<T> it = this.rowCalculators.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i = RangesKt.coerceAtLeast(i, ((GridColumnsCalculator) it.next()).getAbsoluteWidth());
        }
        return i;
    }

    public final Pair<Integer, Integer>[] getHeights(int[] heights, ItemHeightProvider itemHeightProvider) {
        int i;
        int i2;
        int floor;
        Intrinsics.checkNotNullParameter(heights, "heights");
        Intrinsics.checkNotNullParameter(itemHeightProvider, "itemHeightProvider");
        GridControlModel gridControlModel = this.gridControlModel;
        if (gridControlModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
            gridControlModel = null;
        }
        double[] dArr = new double[gridControlModel.getRowDefinitions().length];
        GridControlModel gridControlModel2 = this.gridControlModel;
        if (gridControlModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
            gridControlModel2 = null;
        }
        GridLength[] rowDefinitions = gridControlModel2.getRowDefinitions();
        Intrinsics.checkNotNullExpressionValue(rowDefinitions, "getRowDefinitions(...)");
        GridLength[] gridLengthArr = rowDefinitions;
        int length = gridLengthArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = i4 + 1;
            GridLength gridLength = gridLengthArr[i3];
            if (!gridLength.getAuto() && !gridLength.getStar()) {
                dArr[i4] = gridLength.getValue();
            }
            i3++;
            i4 = i5;
        }
        ArrayList arrayList = new ArrayList();
        GridControlModel gridControlModel3 = this.gridControlModel;
        if (gridControlModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
            gridControlModel3 = null;
        }
        GridColumnModel[] gridColumns = gridControlModel3.getGridColumns();
        Intrinsics.checkNotNullExpressionValue(gridColumns, "getGridColumns(...)");
        GridColumnModel[] gridColumnModelArr = gridColumns;
        int length2 = gridColumnModelArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length2) {
            GridColumnModel gridColumnModel = gridColumnModelArr[i6];
            Intrinsics.checkNotNull(gridColumnModel);
            arrayList.add(new LayoutInfo(gridColumnModel, heights[i7]));
            i6++;
            i7++;
        }
        CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.devexpress.dxgrid.utils.ColumnInfoHelper$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int heights$lambda$5;
                heights$lambda$5 = ColumnInfoHelper.getHeights$lambda$5((ColumnInfoHelper.LayoutInfo) obj, (ColumnInfoHelper.LayoutInfo) obj2);
                return heights$lambda$5;
            }
        });
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            GridColumnModel gridColumn = ((LayoutInfo) it.next()).getGridColumn();
            int rowIndex = gridColumn.getRowIndex() + gridColumn.getRowSpan();
            double d = 0.0d;
            double d2 = 0.0d;
            int i8 = 0;
            for (int rowIndex2 = gridColumn.getRowIndex(); rowIndex2 < rowIndex; rowIndex2++) {
                d += dArr[rowIndex2];
                GridControlModel gridControlModel4 = this.gridControlModel;
                if (gridControlModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                    gridControlModel4 = null;
                }
                if (gridControlModel4.getRowDefinitions()[rowIndex2].getAuto()) {
                    double d3 = dArr[rowIndex2];
                    if (d3 == AudioStats.AUDIO_AMPLITUDE_NONE) {
                        i8++;
                    } else {
                        d2 += d3;
                    }
                }
            }
            if (i8 != 0 || d != AudioStats.AUDIO_AMPLITUDE_NONE) {
                double height = r8.getHeight() - d;
                if (height > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    int rowIndex3 = gridColumn.getRowIndex() + gridColumn.getRowSpan();
                    for (int rowIndex4 = gridColumn.getRowIndex(); rowIndex4 < rowIndex3; rowIndex4++) {
                        GridControlModel gridControlModel5 = this.gridControlModel;
                        if (gridControlModel5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                            gridControlModel5 = null;
                        }
                        if (gridControlModel5.getRowDefinitions()[rowIndex4].getAuto()) {
                            if (i8 > 0) {
                                double d4 = dArr[rowIndex4];
                                if (d4 == AudioStats.AUDIO_AMPLITUDE_NONE) {
                                    dArr[rowIndex4] = d4 + (height / i8);
                                }
                            } else {
                                double d5 = dArr[rowIndex4];
                                dArr[rowIndex4] = d5 + ((d5 / d2) * height);
                            }
                        }
                    }
                }
            }
        }
        if (!itemHeightProvider.isFixedHeight()) {
            double maxStarHeight = getMaxStarHeight(dArr, heights);
            GridControlModel gridControlModel6 = this.gridControlModel;
            if (gridControlModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                gridControlModel6 = null;
            }
            int length3 = gridControlModel6.getRowDefinitions().length;
            for (int i9 = 0; i9 < length3; i9++) {
                GridControlModel gridControlModel7 = this.gridControlModel;
                if (gridControlModel7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                    gridControlModel7 = null;
                }
                GridLength gridLength2 = gridControlModel7.getRowDefinitions()[i9];
                if (gridLength2.getStar()) {
                    dArr[i9] = gridLength2.getValue() * maxStarHeight;
                }
            }
        } else {
            double fixedHeight = itemHeightProvider.getFixedHeight();
            GridControlModel gridControlModel8 = this.gridControlModel;
            if (gridControlModel8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                gridControlModel8 = null;
            }
            int length4 = gridControlModel8.getRowDefinitions().length;
            double d6 = 0.0d;
            double d7 = 0.0d;
            for (int i10 = 0; i10 < length4; i10++) {
                GridControlModel gridControlModel9 = this.gridControlModel;
                if (gridControlModel9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                    gridControlModel9 = null;
                }
                GridLength gridLength3 = gridControlModel9.getRowDefinitions()[i10];
                if (gridLength3.getAuto()) {
                    d6 += dArr[i10];
                }
                if (gridLength3.getStar()) {
                    d7 += gridLength3.getValue();
                } else {
                    fixedHeight -= dArr[i10];
                }
            }
            GridControlModel gridControlModel10 = this.gridControlModel;
            if (gridControlModel10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                gridControlModel10 = null;
            }
            GridLength[] rowDefinitions2 = gridControlModel10.getRowDefinitions();
            Intrinsics.checkNotNullExpressionValue(rowDefinitions2, "getRowDefinitions(...)");
            GridLength[] gridLengthArr2 = rowDefinitions2;
            int length5 = gridLengthArr2.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length5) {
                    i11 = -1;
                    break;
                }
                if (gridLengthArr2[i11].getStar()) {
                    break;
                }
                i11++;
            }
            boolean z = i11 >= 0;
            GridControlModel gridControlModel11 = this.gridControlModel;
            if (gridControlModel11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                gridControlModel11 = null;
            }
            int i12 = 0;
            for (int length6 = gridControlModel11.getRowDefinitions().length; i12 < length6; length6 = i) {
                GridControlModel gridControlModel12 = this.gridControlModel;
                if (gridControlModel12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                    gridControlModel12 = null;
                }
                GridLength gridLength4 = gridControlModel12.getRowDefinitions()[i12];
                if (!gridLength4.getAuto() || z) {
                    i = length6;
                } else {
                    i = length6;
                    dArr[i12] = dArr[i12] * (itemHeightProvider.getFixedHeight() / d6);
                }
                if (gridLength4.getStar()) {
                    dArr[i12] = (gridLength4.getValue() / d7) * fixedHeight;
                }
                i12++;
            }
        }
        GridControlModel gridControlModel13 = this.gridControlModel;
        if (gridControlModel13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
            gridControlModel13 = null;
        }
        GridLength[] rowDefinitions3 = gridControlModel13.getRowDefinitions();
        Intrinsics.checkNotNullExpressionValue(rowDefinitions3, "getRowDefinitions(...)");
        GridLength[] gridLengthArr3 = rowDefinitions3;
        int length7 = gridLengthArr3.length - 1;
        if (length7 >= 0) {
            while (true) {
                int i13 = length7 - 1;
                GridLength gridLength5 = gridLengthArr3[length7];
                if (gridLength5.getAuto() || gridLength5.getStar()) {
                    i2 = length7;
                    break;
                }
                if (i13 < 0) {
                    break;
                }
                length7 = i13;
            }
        }
        i2 = -1;
        GridControlModel gridControlModel14 = this.gridControlModel;
        if (gridControlModel14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
            gridControlModel14 = null;
        }
        int[] iArr = new int[gridControlModel14.getRowDefinitions().length];
        GridControlModel gridControlModel15 = this.gridControlModel;
        if (gridControlModel15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
            gridControlModel15 = null;
        }
        int length8 = gridControlModel15.getRowDefinitions().length;
        double d8 = AudioStats.AUDIO_AMPLITUDE_NONE;
        for (int i14 = 0; i14 < length8; i14++) {
            GridControlModel gridControlModel16 = this.gridControlModel;
            if (gridControlModel16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                gridControlModel16 = null;
            }
            if (!gridControlModel16.getRowDefinitions()[i14].getStar()) {
                GridControlModel gridControlModel17 = this.gridControlModel;
                if (gridControlModel17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                    gridControlModel17 = null;
                }
                if (!gridControlModel17.getRowDefinitions()[i14].getAuto()) {
                    iArr[i14] = (int) dArr[i14];
                }
            }
            double d9 = dArr[i14];
            if (i14 == i2 && d8 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                d8 = RangesKt.coerceAtMost(1.0d, (d9 % 1) + d8);
                floor = (int) Math.ceil(((int) d9) + d8);
            } else {
                d8 += d9 % 1;
                floor = (int) Math.floor(d9);
                if (d8 > 1.0d) {
                    floor++;
                    d8 -= 1.0d;
                }
            }
            iArr[i14] = floor;
        }
        GridControlModel gridControlModel18 = this.gridControlModel;
        if (gridControlModel18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
            gridControlModel18 = null;
        }
        int[] iArr2 = new int[gridControlModel18.getRowDefinitions().length];
        GridControlModel gridControlModel19 = this.gridControlModel;
        if (gridControlModel19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
            gridControlModel19 = null;
        }
        int length9 = gridControlModel19.getRowDefinitions().length - 1;
        int i15 = 0;
        while (i15 < length9) {
            int i16 = i15 + 1;
            iArr2[i16] = iArr2[i15] + iArr[i15];
            i15 = i16;
        }
        ArrayList arrayList2 = new ArrayList();
        int columnCount = getColumnCount();
        for (int i17 = 0; i17 < columnCount; i17++) {
            GridControlModel gridControlModel20 = this.gridControlModel;
            if (gridControlModel20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                gridControlModel20 = null;
            }
            int rowIndex5 = gridControlModel20.getGridColumns()[i17].getRowIndex();
            GridControlModel gridControlModel21 = this.gridControlModel;
            if (gridControlModel21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                gridControlModel21 = null;
            }
            GridControlModel gridControlModel22 = this.gridControlModel;
            if (gridControlModel22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                gridControlModel22 = null;
            }
            int rowIndex6 = gridControlModel22.getGridColumns()[i17].getRowIndex();
            GridControlModel gridControlModel23 = this.gridControlModel;
            if (gridControlModel23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                gridControlModel23 = null;
            }
            int rowSpan = rowIndex6 + gridControlModel23.getGridColumns()[i17].getRowSpan();
            int i18 = 0;
            for (int rowIndex7 = gridControlModel21.getGridColumns()[i17].getRowIndex(); rowIndex7 < rowSpan; rowIndex7++) {
                i18 += iArr[rowIndex7];
            }
            arrayList2.add(new Pair(Integer.valueOf(iArr2[rowIndex5]), Integer.valueOf(iArr2[rowIndex5] + i18)));
        }
        return (Pair[]) arrayList2.toArray(new Pair[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getHeights$lambda$5(LayoutInfo layoutInfo, LayoutInfo layoutInfo2) {
        return layoutInfo.getGridColumn().getRowSpan() - layoutInfo2.getGridColumn().getRowSpan();
    }

    private final double getMaxStarHeight(double[] rowHeights, int[] heights) {
        GridControlModel gridControlModel = this.gridControlModel;
        if (gridControlModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
            gridControlModel = null;
        }
        GridColumnModel[] gridColumns = gridControlModel.getGridColumns();
        Intrinsics.checkNotNullExpressionValue(gridColumns, "getGridColumns(...)");
        GridColumnModel[] gridColumnModelArr = gridColumns;
        int length = gridColumnModelArr.length;
        int i = 0;
        int i2 = 0;
        double d = 0.0d;
        while (i < length) {
            int i3 = i2 + 1;
            GridColumnModel gridColumnModel = gridColumnModelArr[i];
            int rowIndex = gridColumnModel.getRowIndex() + gridColumnModel.getRowSpan();
            double d2 = 0.0d;
            double d3 = 0.0d;
            for (int rowIndex2 = gridColumnModel.getRowIndex(); rowIndex2 < rowIndex; rowIndex2++) {
                GridControlModel gridControlModel2 = this.gridControlModel;
                if (gridControlModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                    gridControlModel2 = null;
                }
                if (!gridControlModel2.getRowDefinitions()[rowIndex2].getStar()) {
                    d2 += rowHeights[rowIndex2];
                } else {
                    GridControlModel gridControlModel3 = this.gridControlModel;
                    if (gridControlModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                        gridControlModel3 = null;
                    }
                    d3 += gridControlModel3.getRowDefinitions()[rowIndex2].getValue();
                }
            }
            d = RangesKt.coerceAtLeast(d, (heights[i2] - d2) / d3);
            i++;
            i2 = i3;
        }
        return d;
    }

    public final ColumnInfo getColumn(int columnIndex) {
        if (this.columnsInfo == null) {
            initialize();
        }
        ColumnInfo[] columnInfoArr = this.columnsInfo;
        Intrinsics.checkNotNull(columnInfoArr);
        ColumnInfo columnInfo = columnInfoArr[columnIndex];
        Intrinsics.checkNotNull(columnInfo);
        return columnInfo;
    }

    private final void initializeCalculators() {
        GridControlModel gridControlModel = this.gridControlModel;
        GridControlModel gridControlModel2 = null;
        if (gridControlModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
            gridControlModel = null;
        }
        if (gridControlModel.getColumnDefinitions() != null) {
            GridControlModel gridControlModel3 = this.gridControlModel;
            if (gridControlModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
            } else {
                gridControlModel2 = gridControlModel3;
            }
            GridColumnsCalculator gridColumnsCalculator = new GridColumnsCalculator(gridControlModel2.getColumnDefinitions());
            gridColumnsCalculator.setViewPortWidth(this.viewPortWidth);
            this.calculator = gridColumnsCalculator;
            return;
        }
        GridControlModel gridControlModel4 = this.gridControlModel;
        if (gridControlModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
        } else {
            gridControlModel2 = gridControlModel4;
        }
        GridColumnModel[] gridColumns = gridControlModel2.getGridColumns();
        Intrinsics.checkNotNullExpressionValue(gridColumns, "getGridColumns(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (GridColumnModel gridColumnModel : gridColumns) {
            Integer valueOf = Integer.valueOf(gridColumnModel.getRowIndex());
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                obj = (List) new ArrayList();
                linkedHashMap.put(valueOf, obj);
            }
            ((List) obj).add(gridColumnModel);
        }
        int i = 0;
        for (Object obj2 : linkedHashMap.values()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map<Integer, GridColumnsCalculator> map = this.rowCalculators;
            Integer valueOf2 = Integer.valueOf(i);
            List list = (List) obj2;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((GridColumnModel) it.next()).getGridColumnWidth());
            }
            GridColumnsCalculator gridColumnsCalculator2 = new GridColumnsCalculator((GridLength[]) arrayList.toArray(new GridLength[0]));
            gridColumnsCalculator2.setViewPortWidth(this.viewPortWidth);
            map.put(valueOf2, gridColumnsCalculator2);
            i = i2;
        }
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [kotlin.collections.IntIterator] */
    private final void populateColumnsInfos() {
        int i;
        int right;
        GridControlModel gridControlModel;
        GridControlModel gridControlModel2 = this.gridControlModel;
        if (gridControlModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
            gridControlModel2 = null;
        }
        ColumnInfo[] columnInfoArr = new ColumnInfo[gridControlModel2.getGridColumns().length];
        this.columnsInfo = columnInfoArr;
        GridControlModel gridControlModel3 = this.gridControlModel;
        if (gridControlModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
            gridControlModel3 = null;
        }
        int i2 = 0;
        if (gridControlModel3.getColumnDefinitions() != null) {
            GridColumnsCalculator gridColumnsCalculator = this.calculator;
            Intrinsics.checkNotNull(gridColumnsCalculator);
            GridControlModel gridControlModel4 = this.gridControlModel;
            if (gridControlModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                gridControlModel = null;
            } else {
                gridControlModel = gridControlModel4;
            }
            GridColumnModel[] gridColumns = gridControlModel.getGridColumns();
            Intrinsics.checkNotNullExpressionValue(gridColumns, "getGridColumns(...)");
            populateColumnsInfo(columnInfoArr, gridColumnsCalculator, gridColumns, false, false);
        } else {
            GridControlModel gridControlModel5 = this.gridControlModel;
            if (gridControlModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                gridControlModel5 = null;
            }
            GridColumnModel[] gridColumns2 = gridControlModel5.getGridColumns();
            Intrinsics.checkNotNullExpressionValue(gridColumns2, "getGridColumns(...)");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (GridColumnModel gridColumnModel : gridColumns2) {
                Integer valueOf = Integer.valueOf(gridColumnModel.getRowIndex());
                Object obj = linkedHashMap.get(valueOf);
                if (obj == null) {
                    obj = (List) new ArrayList();
                    linkedHashMap.put(valueOf, obj);
                }
                ((List) obj).add(gridColumnModel);
            }
            int i3 = 0;
            for (Object obj2 : linkedHashMap.values()) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                GridColumnsCalculator gridColumnsCalculator2 = this.rowCalculators.get(Integer.valueOf(i3));
                Intrinsics.checkNotNull(gridColumnsCalculator2);
                GridColumnsCalculator gridColumnsCalculator3 = gridColumnsCalculator2;
                GridColumnModel[] gridColumnModelArr = (GridColumnModel[]) ((List) obj2).toArray(new GridColumnModel[i2]);
                GridControlModel gridControlModel6 = this.gridControlModel;
                if (gridControlModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gridControlModel");
                    gridControlModel6 = null;
                }
                GridColumnModel[] gridColumns3 = gridControlModel6.getGridColumns();
                Intrinsics.checkNotNullExpressionValue(gridColumns3, "getGridColumns(...)");
                GridColumnModel[] gridColumnModelArr2 = gridColumns3;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                int length = gridColumnModelArr2.length;
                for (int i5 = i2; i5 < length; i5++) {
                    GridColumnModel gridColumnModel2 = gridColumnModelArr2[i5];
                    Integer valueOf2 = Integer.valueOf(gridColumnModel2.getRowIndex());
                    Object obj3 = linkedHashMap2.get(valueOf2);
                    if (obj3 == null) {
                        ArrayList arrayList = new ArrayList();
                        linkedHashMap2.put(valueOf2, arrayList);
                        obj3 = arrayList;
                    }
                    ((List) obj3).add(gridColumnModel2);
                }
                populateColumnsInfo(columnInfoArr, gridColumnsCalculator3, gridColumnModelArr, true, i3 == linkedHashMap2.values().size() - 1);
                i3 = i4;
                i2 = 0;
            }
        }
        if (columnInfoArr.length == 0) {
            i = 0;
            right = 0;
        } else {
            if (columnInfoArr.length == 0) {
                throw new NoSuchElementException();
            }
            i = 0;
            ColumnInfo columnInfo = columnInfoArr[0];
            int lastIndex = ArraysKt.getLastIndex(columnInfoArr);
            if (lastIndex != 0) {
                Intrinsics.checkNotNull(columnInfo);
                int right2 = columnInfo.getRight();
                ?? it = new IntRange(1, lastIndex).iterator();
                while (it.hasNext()) {
                    ColumnInfo columnInfo2 = columnInfoArr[it.nextInt()];
                    Intrinsics.checkNotNull(columnInfo2);
                    int right3 = columnInfo2.getRight();
                    if (right2 < right3) {
                        columnInfo = columnInfo2;
                        right2 = right3;
                    }
                }
            }
            Intrinsics.checkNotNull(columnInfo);
            right = columnInfo.getRight();
        }
        this.cachedRowWidth = right;
        int length2 = columnInfoArr.length;
        int i6 = i;
        int i7 = i6;
        while (i6 < length2) {
            ColumnInfo columnInfo3 = columnInfoArr[i6];
            Intrinsics.checkNotNull(columnInfo3);
            i7 += columnInfo3.getGridColumnModel().getFixedStyle() == FixedStyle.Start ? columnInfo3.getWidth() : i;
            i6++;
        }
        this.cachedFixedStartColumnsWidth = i7;
        int length3 = columnInfoArr.length;
        int i8 = i;
        int i9 = i8;
        while (i8 < length3) {
            ColumnInfo columnInfo4 = columnInfoArr[i8];
            Intrinsics.checkNotNull(columnInfo4);
            i9 += columnInfo4.getGridColumnModel().getFixedStyle() == FixedStyle.End ? columnInfo4.getWidth() : i;
            i8++;
        }
        this.cachedFixedEndColumnsWidth = i9;
    }

    private final void initialize() {
        initializeCalculators();
        populateColumnsInfos();
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x010a, code lost:
    
        if (r4 == r17.getRowDefinitions().length) goto L74;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void populateColumnsInfo(com.devexpress.dxgrid.utils.ColumnInfo[] r29, com.devexpress.dxgrid.utils.GridColumnsCalculator r30, com.devexpress.dxgrid.models.columns.GridColumnModel[] r31, boolean r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.dxgrid.utils.ColumnInfoHelper.populateColumnsInfo(com.devexpress.dxgrid.utils.ColumnInfo[], com.devexpress.dxgrid.utils.GridColumnsCalculator, com.devexpress.dxgrid.models.columns.GridColumnModel[], boolean, boolean):void");
    }

    /* compiled from: ColumnInfoHelper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/devexpress/dxgrid/utils/ColumnInfoHelper$LayoutInfo;", "", "gridColumn", "Lcom/devexpress/dxgrid/models/columns/GridColumnModel;", "height", "", "(Lcom/devexpress/dxgrid/models/columns/GridColumnModel;I)V", "getGridColumn", "()Lcom/devexpress/dxgrid/models/columns/GridColumnModel;", "getHeight", "()I", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class LayoutInfo {
        private final GridColumnModel gridColumn;
        private final int height;

        public LayoutInfo(GridColumnModel gridColumn, int i) {
            Intrinsics.checkNotNullParameter(gridColumn, "gridColumn");
            this.gridColumn = gridColumn;
            this.height = i;
        }

        public final GridColumnModel getGridColumn() {
            return this.gridColumn;
        }

        public final int getHeight() {
            return this.height;
        }
    }
}
