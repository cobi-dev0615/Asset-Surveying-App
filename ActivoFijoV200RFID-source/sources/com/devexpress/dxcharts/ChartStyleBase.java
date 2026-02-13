package com.devexpress.dxcharts;

import android.graphics.Paint;

/* loaded from: classes.dex */
public abstract class ChartStyleBase extends StyleBase {
    private Integer backgroundColor;
    private Integer borderColor;
    private Float borderThickness;
    private Integer paddingBottom;
    private Integer paddingLeft;
    private Integer paddingRight;
    private Integer paddingTop;
    private int[] palette;
    private Paint textPaint;
    private StyleContainer<TextStyle> textStyle = new StyleContainer<>(TextStyle.class);

    enum Property {
        PALETTE,
        PADDING,
        BACKGROUND_COLOR,
        BORDER_COLOR,
        BORDER_THICKNESS,
        TEXT_STYLE
    }

    ChartStyleBase() {
    }

    @Override // com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        float floatValue;
        float floatValue2;
        float floatValue3;
        float floatValue4;
        super.initDefaultStyle(contextProvider, objArr);
        this.palette = ResourceHelper.getIntArrayOrDefault(contextProvider, R.attr.dxChartPalette);
        this.backgroundColor = Integer.valueOf(ResourceHelper.getColorOrDefault(contextProvider, R.attr.dxChartBackground));
        this.borderColor = Integer.valueOf(ResourceHelper.getColorOrDefault(contextProvider, R.attr.dxChartBorderColor));
        this.borderThickness = Float.valueOf(ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxChartBorderThickness));
        Float dimension = ResourceHelper.getDimension(contextProvider, R.attr.dxChartPadding);
        Float dimension2 = ResourceHelper.getDimension(contextProvider, R.attr.dxChartPaddingHorizontal);
        Float dimension3 = ResourceHelper.getDimension(contextProvider, R.attr.dxChartPaddingVertical);
        if (dimension != null) {
            floatValue = dimension.floatValue();
        } else {
            floatValue = dimension2 != null ? dimension2.floatValue() : ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxChartPaddingLeft);
        }
        this.paddingLeft = Integer.valueOf((int) floatValue);
        if (dimension != null) {
            floatValue2 = dimension.floatValue();
        } else {
            floatValue2 = dimension2 != null ? dimension2.floatValue() : ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxChartPaddingRight);
        }
        this.paddingRight = Integer.valueOf((int) floatValue2);
        if (dimension != null) {
            floatValue3 = dimension.floatValue();
        } else {
            floatValue3 = dimension3 != null ? dimension3.floatValue() : ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxChartPaddingTop);
        }
        this.paddingTop = Integer.valueOf((int) floatValue3);
        if (dimension != null) {
            floatValue4 = dimension.floatValue();
        } else {
            floatValue4 = dimension3 != null ? dimension3.floatValue() : ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxChartPaddingBottom);
        }
        this.paddingBottom = Integer.valueOf((int) floatValue4);
    }

    TextStyle getTextStyleInternal(ContextProvider contextProvider) {
        return this.textStyle.getActualStyle(contextProvider, new Object[0]);
    }

    Paint getTextStylePaintInternal(ContextProvider contextProvider) {
        if (this.textPaint == null) {
            this.textPaint = getTextStyleInternal(contextProvider).createTextPaint(contextProvider);
        }
        return this.textPaint;
    }

    public int[] getPalette() {
        return this.palette;
    }

    public void setPalette(int[] iArr) {
        if (this.palette != iArr) {
            if (iArr == null || iArr.length <= 0) {
                iArr = null;
            }
            this.palette = iArr;
            notifyListeners(Property.PALETTE);
        }
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
}
