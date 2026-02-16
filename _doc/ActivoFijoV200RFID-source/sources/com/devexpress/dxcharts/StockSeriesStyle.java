package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class StockSeriesStyle extends StyleBase {
    private Integer fallingStroke;
    private Integer risingStroke;
    private Float strokeThickness;

    enum Property {
        STROKE_THICKNESS,
        RISING_STROKE,
        FALLING_STROKE
    }

    @Override // com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        super.initDefaultStyle(contextProvider, objArr);
        this.risingStroke = Integer.valueOf(getRisingStrokeFromResources(contextProvider));
        this.fallingStroke = Integer.valueOf(getFallingStrokeFromResources(contextProvider));
        this.strokeThickness = Float.valueOf(getStrokeThicknessFromResources(contextProvider));
    }

    int getRisingStrokeFromResources(ContextProvider contextProvider) {
        return ResourceHelper.getSimpleColor(contextProvider, R.color.color_stock_series_rising_stroke);
    }

    int getFallingStrokeFromResources(ContextProvider contextProvider) {
        return ResourceHelper.getSimpleColor(contextProvider, R.color.color_stock_series_falling_stroke);
    }

    float getStrokeThicknessFromResources(ContextProvider contextProvider) {
        return contextProvider.getResources().getDimension(R.dimen.stock_series_stroke_thickness);
    }

    public Float getStrokeThickness() {
        return this.strokeThickness;
    }

    public void setStrokeThickness(Float f) {
        if (CompareHelper.areNotEquals(this.strokeThickness, f)) {
            this.strokeThickness = f;
            notifyListeners(Property.STROKE_THICKNESS);
        }
    }

    public Integer getRisingStroke() {
        return this.risingStroke;
    }

    public void setRisingStroke(Integer num) {
        if (CompareHelper.areNotEquals(this.risingStroke, num)) {
            this.risingStroke = num;
            notifyListeners(Property.RISING_STROKE);
        }
    }

    public Integer getFallingStroke() {
        return this.fallingStroke;
    }

    public void setFallingStroke(Integer num) {
        if (CompareHelper.areNotEquals(this.fallingStroke, num)) {
            this.fallingStroke = num;
            notifyListeners(Property.FALLING_STROKE);
        }
    }
}
