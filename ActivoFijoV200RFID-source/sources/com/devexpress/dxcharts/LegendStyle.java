package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class LegendStyle extends TextElementStyleBase {
    private Integer backgroundColor;
    private Integer borderColor;
    private Float borderThickness;
    private Integer bottomIndentFromDiagram;
    private Integer itemsHorizontalIndent;
    private Integer itemsVerticalIndent;
    private Integer leftIndentFromDiagram;
    private Integer markerSize;
    private Integer paddingBottom;
    private Integer paddingLeft;
    private Integer paddingRight;
    private Integer paddingTop;
    private Integer rightIndentFromDiagram;
    private Integer textIndent;
    private Integer topIndentFromDiagram;

    private enum Property {
        BACKGROUND_COLOR,
        BORDER_COLOR,
        BORDER_THICKNESS,
        MARKER_SIZE,
        TEXT_INDENT,
        INTENT_FROM_DIAGRAM,
        PADDING,
        ITEMS_VERTICAL_INDENT,
        ITEMS_HORIZONTAL_INDENT
    }

    @Override // com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        float floatValue;
        float floatValue2;
        float floatValue3;
        float floatValue4;
        float floatValue5;
        float floatValue6;
        float floatValue7;
        float floatValue8;
        super.initDefaultStyle(contextProvider, objArr);
        this.borderColor = Integer.valueOf(ResourceHelper.getColorOrDefault(contextProvider, R.attr.dxLegendBorderColor));
        this.backgroundColor = Integer.valueOf(ResourceHelper.getColorOrDefault(contextProvider, R.attr.dxLegendBackground));
        this.markerSize = Integer.valueOf((int) contextProvider.getResources().getDimension(R.dimen.legend_marker_size));
        this.textIndent = Integer.valueOf((int) contextProvider.getResources().getDimension(R.dimen.legend_text_indent));
        Float dimension = ResourceHelper.getDimension(contextProvider, R.attr.dxLegendPadding);
        Float dimension2 = ResourceHelper.getDimension(contextProvider, R.attr.dxLegendPaddingHorizontal);
        Float dimension3 = ResourceHelper.getDimension(contextProvider, R.attr.dxLegendPaddingVertical);
        if (dimension != null) {
            floatValue = dimension.floatValue();
        } else {
            floatValue = dimension2 != null ? dimension2.floatValue() : ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxLegendPaddingLeft);
        }
        this.paddingLeft = Integer.valueOf((int) floatValue);
        if (dimension != null) {
            floatValue2 = dimension.floatValue();
        } else {
            floatValue2 = dimension2 != null ? dimension2.floatValue() : ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxLegendPaddingRight);
        }
        this.paddingRight = Integer.valueOf((int) floatValue2);
        if (dimension != null) {
            floatValue3 = dimension.floatValue();
        } else {
            floatValue3 = dimension3 != null ? dimension3.floatValue() : ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxLegendPaddingTop);
        }
        this.paddingTop = Integer.valueOf((int) floatValue3);
        if (dimension != null) {
            floatValue4 = dimension.floatValue();
        } else {
            floatValue4 = dimension3 != null ? dimension3.floatValue() : ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxLegendPaddingBottom);
        }
        this.paddingBottom = Integer.valueOf((int) floatValue4);
        Float dimension4 = ResourceHelper.getDimension(contextProvider, R.attr.dxLegendIndentToDiagram);
        Float dimension5 = ResourceHelper.getDimension(contextProvider, R.attr.dxLegendHorizontalIndentToDiagram);
        Float dimension6 = ResourceHelper.getDimension(contextProvider, R.attr.dxLegendVerticalIndentToDiagram);
        if (dimension4 != null) {
            floatValue5 = dimension4.floatValue();
        } else {
            floatValue5 = dimension5 != null ? dimension5.floatValue() : ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxLegendLeftIndentToDiagram);
        }
        this.leftIndentFromDiagram = Integer.valueOf((int) floatValue5);
        if (dimension4 != null) {
            floatValue6 = dimension4.floatValue();
        } else {
            floatValue6 = dimension5 != null ? dimension5.floatValue() : ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxLegendRightIndentToDiagram);
        }
        this.rightIndentFromDiagram = Integer.valueOf((int) floatValue6);
        if (dimension4 != null) {
            floatValue7 = dimension4.floatValue();
        } else {
            floatValue7 = dimension6 != null ? dimension6.floatValue() : ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxLegendTopIndentToDiagram);
        }
        this.topIndentFromDiagram = Integer.valueOf((int) floatValue7);
        if (dimension4 != null) {
            floatValue8 = dimension4.floatValue();
        } else {
            floatValue8 = dimension6 != null ? dimension6.floatValue() : ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxLegendBottomIndentToDiagram);
        }
        this.bottomIndentFromDiagram = Integer.valueOf((int) floatValue8);
        this.itemsVerticalIndent = Integer.valueOf((int) contextProvider.getResources().getDimension(R.dimen.legend_vertical_indent));
        this.itemsHorizontalIndent = Integer.valueOf((int) contextProvider.getResources().getDimension(R.dimen.legend_horizontal_indent));
        this.borderThickness = Float.valueOf(ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxLegendBorderThickness));
    }

    public Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(Integer num) {
        if (CompareHelper.areNotEquals(this.backgroundColor, num)) {
            this.backgroundColor = num;
            notifyListeners(Property.BACKGROUND_COLOR);
        }
    }

    public Integer getBorderColor() {
        return this.borderColor;
    }

    public void setBorderColor(Integer num) {
        if (CompareHelper.areNotEquals(this.borderColor, num)) {
            this.borderColor = num;
            notifyListeners(Property.BORDER_COLOR);
        }
    }

    public Float getBorderThickness() {
        return this.borderThickness;
    }

    public void setBorderThickness(Float f) {
        if (CompareHelper.areNotEquals(this.borderThickness, f)) {
            this.borderThickness = f;
            notifyListeners(Property.BORDER_THICKNESS);
        }
    }

    public Integer getMarkerSize() {
        return this.markerSize;
    }

    public void setMarkerSize(Integer num) {
        if (CompareHelper.areNotEquals(this.markerSize, num)) {
            this.markerSize = num;
            notifyListeners(Property.MARKER_SIZE);
        }
    }

    public Integer getTextIndent() {
        return this.textIndent;
    }

    public void setTextIndent(Integer num) {
        if (CompareHelper.areNotEquals(this.textIndent, num)) {
            this.textIndent = num;
            notifyListeners(Property.TEXT_INDENT);
        }
    }

    public Integer getPaddingLeft() {
        return this.paddingLeft;
    }

    public Integer getPaddingTop() {
        return this.paddingTop;
    }

    public Integer getPaddingRight() {
        return this.paddingRight;
    }

    public Integer getPaddingBottom() {
        return this.paddingBottom;
    }

    public void setPadding(Integer num, Integer num2, Integer num3, Integer num4) {
        if (CompareHelper.areNotEquals(this.paddingLeft, num) || CompareHelper.areNotEquals(this.paddingTop, num2) || CompareHelper.areNotEquals(this.paddingRight, num3) || CompareHelper.areNotEquals(this.paddingBottom, num4)) {
            this.paddingLeft = num;
            this.paddingTop = num2;
            this.paddingRight = num3;
            this.paddingBottom = num4;
            notifyListeners(Property.PADDING);
        }
    }

    public Integer getLeftIndentFromDiagram() {
        return this.leftIndentFromDiagram;
    }

    public Integer getTopIndentFromDiagram() {
        return this.topIndentFromDiagram;
    }

    public Integer getRightIndentFromDiagram() {
        return this.rightIndentFromDiagram;
    }

    public Integer getBottomIndentFromDiagram() {
        return this.bottomIndentFromDiagram;
    }

    public void setIndentFromDiagram(Integer num, Integer num2, Integer num3, Integer num4) {
        if (CompareHelper.areNotEquals(this.leftIndentFromDiagram, num) || CompareHelper.areNotEquals(this.topIndentFromDiagram, num2) || CompareHelper.areNotEquals(this.rightIndentFromDiagram, num3) || CompareHelper.areNotEquals(this.bottomIndentFromDiagram, num4)) {
            this.leftIndentFromDiagram = num;
            this.topIndentFromDiagram = num2;
            this.rightIndentFromDiagram = num3;
            this.bottomIndentFromDiagram = num4;
            notifyListeners(Property.INTENT_FROM_DIAGRAM);
        }
    }

    public Integer getItemsVerticalIndent() {
        return this.itemsVerticalIndent;
    }

    public void setItemsVerticalIndent(Integer num) {
        if (CompareHelper.areNotEquals(this.itemsVerticalIndent, num)) {
            this.itemsVerticalIndent = num;
            notifyListeners(Property.ITEMS_VERTICAL_INDENT);
        }
    }

    public Integer getItemsHorizontalIndent() {
        return this.itemsHorizontalIndent;
    }

    public void setItemsHorizontalIndent(Integer num) {
        if (CompareHelper.areNotEquals(this.itemsHorizontalIndent, num)) {
            this.itemsHorizontalIndent = num;
            notifyListeners(Property.ITEMS_HORIZONTAL_INDENT);
        }
    }
}
