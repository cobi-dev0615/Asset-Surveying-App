package com.devexpress.dxcharts;

import com.devexpress.dxcharts.StaticCrosshairLabelPosition;

/* loaded from: classes.dex */
public class CrosshairHintBehavior extends HintBehavior {
    static boolean DEFAULT_ARGUMENT_LABEL_VISIBLE = true;
    static boolean DEFAULT_ARGUMENT_LINE_VISIBLE = true;
    static String DEFAULT_GROUP_HEADER_TEXT_PATTERN = "{A}";
    static boolean DEFAULT_GROUP_HEADER_VISIBLE = true;
    static boolean DEFAULT_HIGHLIGHT_POINT = true;
    static int DEFAULT_MAX_SERIES_COUNT = 2;
    static boolean DEFAULT_VALUE_LABEL_VISIBLE = true;
    static boolean DEFAULT_VALUE_LINE_VISIBLE = true;
    private String groupHeaderTextPattern;
    private CrosshairLabelPositionBase labelMode;
    private int maxSeriesCount = DEFAULT_MAX_SERIES_COUNT;
    private boolean argumentLineVisible = DEFAULT_ARGUMENT_LINE_VISIBLE;
    private boolean argumentLabelVisible = DEFAULT_ARGUMENT_LABEL_VISIBLE;
    private boolean valueLineVisible = DEFAULT_VALUE_LINE_VISIBLE;
    private boolean valueLabelVisible = DEFAULT_VALUE_LABEL_VISIBLE;
    private boolean groupHeaderVisible = DEFAULT_GROUP_HEADER_VISIBLE;
    private boolean highlightPoint = DEFAULT_HIGHLIGHT_POINT;

    enum Property {
        GROUP_HEADER_TEXT_PATTERN,
        GROUP_HEADER_VISIBLE,
        MAX_SERIES_COUNT,
        LABEL_POSITION,
        HIGHLIGHT_POINT
    }

    public String getGroupHeaderTextPattern() {
        return this.groupHeaderTextPattern;
    }

    public void setGroupHeaderTextPattern(String str) {
        if (CompareHelper.areNotEquals(this.groupHeaderTextPattern, str)) {
            this.groupHeaderTextPattern = str;
            notifyListeners(Property.GROUP_HEADER_TEXT_PATTERN);
        }
    }

    public int getMaxSeriesCount() {
        return this.maxSeriesCount;
    }

    public void setMaxSeriesCount(int i) {
        if (this.maxSeriesCount != i) {
            this.maxSeriesCount = i;
            notifyListeners(Property.MAX_SERIES_COUNT);
        }
    }

    public boolean isGroupHeaderVisible() {
        return this.groupHeaderVisible;
    }

    public void setGroupHeaderVisible(boolean z) {
        if (this.groupHeaderVisible != z) {
            this.groupHeaderVisible = z;
            notifyListeners(Property.GROUP_HEADER_VISIBLE);
        }
    }

    public boolean isArgumentLineVisible() {
        return this.argumentLineVisible;
    }

    public void setArgumentLineVisible(boolean z) {
        this.argumentLineVisible = z;
    }

    public boolean isArgumentLabelVisible() {
        return this.argumentLabelVisible;
    }

    public void setArgumentLabelVisible(boolean z) {
        this.argumentLabelVisible = z;
    }

    public boolean isValueLineVisible() {
        return this.valueLineVisible;
    }

    public void setValueLineVisible(boolean z) {
        this.valueLineVisible = z;
    }

    public boolean isValueLabelVisible() {
        return this.valueLabelVisible;
    }

    public void setValueLabelVisible(boolean z) {
        this.valueLabelVisible = z;
    }

    public CrosshairLabelPositionBase getLabelPosition() {
        return this.labelMode;
    }

    public void setLabelPosition(CrosshairLabelPositionBase crosshairLabelPositionBase) {
        CrosshairLabelPositionBase crosshairLabelPositionBase2 = this.labelMode;
        if (crosshairLabelPositionBase2 != crosshairLabelPositionBase) {
            if (crosshairLabelPositionBase2 != null) {
                crosshairLabelPositionBase2.removeListener(getSelfListener());
            }
            this.labelMode = crosshairLabelPositionBase;
            if (crosshairLabelPositionBase != null) {
                crosshairLabelPositionBase.addListener(getSelfListener());
            }
            notifyListeners(Property.LABEL_POSITION);
            for (StaticCrosshairLabelPosition.Property property : StaticCrosshairLabelPosition.Property.values()) {
                notifyListeners(this.labelMode, property);
            }
        }
    }

    public boolean isHighlightPoint() {
        return this.highlightPoint;
    }

    public void setHighlightPoint(boolean z) {
        if (this.highlightPoint != z) {
            this.highlightPoint = z;
            notifyListeners(Property.HIGHLIGHT_POINT);
        }
    }
}
