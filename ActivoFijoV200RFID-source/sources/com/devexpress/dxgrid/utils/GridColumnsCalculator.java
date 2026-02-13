package com.devexpress.dxgrid.utils;

import androidx.camera.video.AudioStats;
import com.devexpress.dxgrid.models.GridControlModel;
import com.devexpress.dxgrid.models.GridLength;
import com.devexpress.dxgrid.models.columns.GridColumnModel;

/* loaded from: classes2.dex */
public class GridColumnsCalculator {
    private GridLength[] gridLengths;
    private GridLength[] layoutDefinitions;
    private int[] layoutLengths;
    private int viewPortWidth;

    public GridColumnsCalculator(GridLength[] gridLengthArr) {
        this.layoutDefinitions = gridLengthArr;
    }

    public GridColumnsCalculator(GridControlModel gridControlModel) {
        if (gridControlModel.getColumnDefinitions() != null) {
            this.layoutDefinitions = gridControlModel.getColumnDefinitions();
        } else {
            initializeColumnDefinitions(gridControlModel.getGridColumns());
        }
    }

    private void initializeColumnDefinitions(GridColumnModel[] gridColumnModelArr) {
        if (gridColumnModelArr != null) {
            this.layoutDefinitions = new GridLength[gridColumnModelArr.length];
            for (int i = 0; i < gridColumnModelArr.length; i++) {
                gridColumnModelArr[i].setColumnIndex(i);
                this.layoutDefinitions[i] = gridColumnModelArr[i].getGridColumnWidth();
            }
        }
    }

    public GridLength[] getLayoutDefinitions() {
        return this.layoutDefinitions;
    }

    public void setViewPortWidth(int i) {
        if (this.viewPortWidth != i) {
            this.viewPortWidth = i;
            this.layoutLengths = null;
        }
    }

    public int getViewPortWidth() {
        return this.viewPortWidth;
    }

    public int getAbsoluteWidth() {
        GridLength[] gridLengthArr = this.layoutDefinitions;
        if (gridLengthArr == null) {
            return 0;
        }
        int i = 0;
        for (GridLength gridLength : gridLengthArr) {
            if (gridLength.getStar()) {
                i += gridLength.getMinWidth();
            } else {
                i = (int) (i + Math.max(gridLength.getValue(), gridLength.getMinWidth()));
            }
        }
        return i;
    }

    public int getLayoutLength(int i) {
        GridLength[] gridLengthArr = this.layoutDefinitions;
        if (gridLengthArr == null) {
            return 0;
        }
        if (this.layoutLengths == null) {
            this.layoutLengths = new int[gridLengthArr.length];
            this.gridLengths = new GridLength[gridLengthArr.length];
            int i2 = 0;
            while (true) {
                GridLength[] gridLengthArr2 = this.layoutDefinitions;
                if (i2 >= gridLengthArr2.length) {
                    break;
                }
                GridLength gridLength = gridLengthArr2[i2];
                double max = Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, gridLength.getValue());
                int max2 = Math.max(0, gridLength.getMinWidth());
                int max3 = Math.max(0, gridLength.getMaxWidth());
                this.gridLengths[i2] = new GridLength(max, max2, max3 < max2 ? 0 : max3, gridLength.getStar(), gridLength.getAuto());
                i2++;
            }
            calcLayoutLengths();
        }
        return this.layoutLengths[i];
    }

    private void calcLayoutLengths() {
        double d;
        int floor;
        int i = 0;
        if (getAbsoluteWidth() >= this.viewPortWidth) {
            while (true) {
                GridLength[] gridLengthArr = this.gridLengths;
                if (i >= gridLengthArr.length) {
                    return;
                }
                GridLength gridLength = gridLengthArr[i];
                if (gridLength.getStar()) {
                    this.layoutLengths[i] = gridLength.getMinWidth();
                } else {
                    this.layoutLengths[i] = Math.max((int) gridLength.getValue(), gridLength.getMinWidth());
                }
                i++;
            }
        } else {
            normalizeColumnWidths();
            double widthForOnePart = getWidthForOnePart();
            int lastIndexOfStarColumn = getLastIndexOfStarColumn();
            int i2 = 0;
            boolean z = false;
            double d2 = 0.0d;
            double d3 = 0.0d;
            while (true) {
                GridLength[] gridLengthArr2 = this.gridLengths;
                if (i2 >= gridLengthArr2.length) {
                    break;
                }
                GridLength gridLength2 = gridLengthArr2[i2];
                if (gridLength2.getStar()) {
                    double value = gridLength2.getValue() * widthForOnePart;
                    d = widthForOnePart;
                    if (i2 == lastIndexOfStarColumn && d3 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                        double min = Math.min(1.0d, (value % 1.0d) + d3);
                        floor = (int) Math.ceil(((int) value) + min);
                        d3 = min;
                    } else {
                        d3 += value % 1.0d;
                        floor = (int) Math.floor(value);
                        if (d3 > 1.0d) {
                            floor++;
                            d3 -= 1.0d;
                        }
                    }
                    this.layoutLengths[i2] = floor;
                    z = true;
                } else {
                    d = widthForOnePart;
                    int max = Math.max((int) gridLength2.getValue(), gridLength2.getMinWidth());
                    if (gridLength2.getAuto()) {
                        d2 += max;
                    }
                    this.layoutLengths[i2] = max;
                }
                i2++;
                widthForOnePart = d;
            }
            if (z || d2 <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                return;
            }
            double widthForParts = getWidthForParts(false);
            if (widthForParts <= d2) {
                return;
            }
            while (true) {
                GridLength[] gridLengthArr3 = this.gridLengths;
                if (i >= gridLengthArr3.length) {
                    return;
                }
                GridLength gridLength3 = gridLengthArr3[i];
                if (gridLength3.getAuto()) {
                    double min2 = Math.min((int) ((gridLength3.getValue() * widthForParts) / d2), gridLength3.getMaxWidth());
                    this.layoutLengths[i] = (int) min2;
                    d2 -= gridLength3.getValue();
                    widthForParts -= min2;
                }
                i++;
            }
        }
    }

    private int getLastIndexOfStarColumn() {
        for (int length = this.gridLengths.length - 1; length >= 0; length--) {
            if (this.gridLengths[length].getStar()) {
                return length;
            }
        }
        return -1;
    }

    private void normalizeColumnWidths() {
        while (true) {
            double widthForOnePart = getWidthForOnePart();
            for (GridLength gridLength : this.gridLengths) {
                double value = gridLength.getValue() * widthForOnePart;
                if (gridLength.getStar() && ((gridLength.getMinWidth() > 0 && value < gridLength.getMinWidth()) || (gridLength.getMaxWidth() > 0 && value > gridLength.getMaxWidth()))) {
                    gridLength.setStar(false);
                    gridLength.setValue(Math.max(Math.min(value, gridLength.getMaxWidth()), gridLength.getMinWidth()));
                }
            }
            return;
        }
    }

    private double getWidthForOnePart() {
        double partsCount = getPartsCount();
        return partsCount == AudioStats.AUDIO_AMPLITUDE_NONE ? AudioStats.AUDIO_AMPLITUDE_NONE : getWidthForParts(true) / partsCount;
    }

    private double getPartsCount() {
        GridLength[] gridLengthArr = this.gridLengths;
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        for (GridLength gridLength : gridLengthArr) {
            if (gridLength.getStar()) {
                d += gridLength.getValue();
            }
        }
        return d;
    }

    private int getWidthForParts(boolean z) {
        int i = this.viewPortWidth;
        for (GridLength gridLength : this.gridLengths) {
            if (!gridLength.getStar() && (z || !gridLength.getAuto())) {
                i = (int) (i - Math.max(gridLength.getValue(), gridLength.getMinWidth()));
            }
        }
        return i;
    }
}
