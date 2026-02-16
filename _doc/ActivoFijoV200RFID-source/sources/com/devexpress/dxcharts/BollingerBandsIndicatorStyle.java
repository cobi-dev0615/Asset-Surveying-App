package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class BollingerBandsIndicatorStyle extends LineIndicatorStyle {
    private Integer lowerStroke;
    private Float lowerStrokeThickness;
    private Integer upperStroke;
    private Float upperStrokeThickness;

    enum Property {
        BANDS_HIGH_STROKE,
        BANDS_HIGH_STROKE_THICKNESS,
        BANDS_LOW_STROKE,
        BANDS_LOW_STROKE_THICKNESS
    }

    @Override // com.devexpress.dxcharts.LineIndicatorStyle, com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        super.initDefaultStyle(contextProvider, objArr);
        Integer valueOf = Integer.valueOf(getStrokeFromResources(contextProvider));
        this.lowerStroke = valueOf;
        this.upperStroke = valueOf;
        Float valueOf2 = Float.valueOf(getStrokeThicknessFromResources(contextProvider));
        this.lowerStrokeThickness = valueOf2;
        this.upperStrokeThickness = valueOf2;
    }

    public Integer getUpperStroke() {
        return this.upperStroke;
    }

    public void setUpperStroke(Integer num) {
        if (CompareHelper.areNotEquals(this.upperStroke, num)) {
            this.upperStroke = num;
            notifyListeners(Property.BANDS_HIGH_STROKE);
        }
    }

    public Float getUpperStrokeThickness() {
        return this.upperStrokeThickness;
    }

    public void setUpperStrokeThickness(Float f) {
        if (CompareHelper.areNotEquals(this.upperStrokeThickness, f)) {
            this.upperStrokeThickness = f;
            notifyListeners(Property.BANDS_HIGH_STROKE_THICKNESS);
        }
    }

    public Integer getLowerStroke() {
        return this.lowerStroke;
    }

    public void setLowerStroke(Integer num) {
        if (CompareHelper.areNotEquals(this.lowerStroke, num)) {
            this.lowerStroke = num;
            notifyListeners(Property.BANDS_LOW_STROKE);
        }
    }

    public Float getLowerStrokeThickness() {
        return this.lowerStrokeThickness;
    }

    public void setLowerStrokeThickness(Float f) {
        if (CompareHelper.areNotEquals(this.lowerStrokeThickness, f)) {
            this.lowerStrokeThickness = f;
            notifyListeners(Property.BANDS_LOW_STROKE_THICKNESS);
        }
    }
}
