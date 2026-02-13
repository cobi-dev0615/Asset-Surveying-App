package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class CandleStickSeriesStyle extends StockSeriesStyle {
    private Integer fallingFill;
    private Integer risingFill;

    enum Property {
        RISING_FILL,
        FALLING_FILL
    }

    @Override // com.devexpress.dxcharts.StockSeriesStyle, com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        super.initDefaultStyle(contextProvider, objArr);
        this.risingFill = Integer.valueOf(ResourceHelper.getSimpleColor(contextProvider, R.color.color_candle_stick_series_rising_fill));
        this.fallingFill = Integer.valueOf(ResourceHelper.getSimpleColor(contextProvider, R.color.color_candle_stick_series_falling_fill));
    }

    @Override // com.devexpress.dxcharts.StockSeriesStyle
    int getRisingStrokeFromResources(ContextProvider contextProvider) {
        return ResourceHelper.getSimpleColor(contextProvider, R.color.color_candle_stick_series_rising_stroke);
    }

    @Override // com.devexpress.dxcharts.StockSeriesStyle
    int getFallingStrokeFromResources(ContextProvider contextProvider) {
        return ResourceHelper.getSimpleColor(contextProvider, R.color.color_candle_stick_series_falling_stroke);
    }

    @Override // com.devexpress.dxcharts.StockSeriesStyle
    float getStrokeThicknessFromResources(ContextProvider contextProvider) {
        return contextProvider.getResources().getDimension(R.dimen.candle_stick_series_stroke_thickness);
    }

    public Integer getRisingFill() {
        return this.risingFill;
    }

    public void setRisingFill(Integer num) {
        if (CompareHelper.areNotEquals(this.risingFill, num)) {
            this.risingFill = num;
            notifyListeners(Property.RISING_FILL);
        }
    }

    public Integer getFallingFill() {
        return this.fallingFill;
    }

    public void setFallingFill(Integer num) {
        if (CompareHelper.areNotEquals(this.fallingFill, num)) {
            this.fallingFill = num;
            notifyListeners(Property.FALLING_FILL);
        }
    }
}
