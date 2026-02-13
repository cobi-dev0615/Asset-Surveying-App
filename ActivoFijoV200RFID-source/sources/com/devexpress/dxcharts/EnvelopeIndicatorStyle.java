package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class EnvelopeIndicatorStyle extends StyleBase {
    private Float alpha;
    private Integer fill;
    private Integer lowerStroke;
    private Float lowerStrokeThickness;
    private Integer upperStroke;
    private Float upperStrokeThickness;

    enum Property {
        STROKE_HIGH,
        STROKE_THICKNESS_HIGH,
        STROKE_LOW,
        STROKE_THICKNESS_LOW,
        FILL,
        ALPHA
    }

    @Override // com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        super.initDefaultStyle(contextProvider, objArr);
        Integer valueOf = Integer.valueOf(getStrokeFromResources(contextProvider));
        this.lowerStroke = valueOf;
        this.upperStroke = valueOf;
        Float valueOf2 = Float.valueOf(getStrokeThicknessFromResources(contextProvider));
        this.lowerStrokeThickness = valueOf2;
        this.upperStrokeThickness = valueOf2;
        this.fill = Integer.valueOf(getFillFromResources(contextProvider));
        this.alpha = Float.valueOf(getAlphaFromResources(contextProvider));
    }

    int getStrokeFromResources(ContextProvider contextProvider) {
        return ResourceHelper.getSimpleColor(contextProvider, R.color.color_line_series);
    }

    float getStrokeThicknessFromResources(ContextProvider contextProvider) {
        return contextProvider.getResources().getDimension(R.dimen.line_series_stroke_thickness);
    }

    int getFillFromResources(ContextProvider contextProvider) {
        return ResourceHelper.getSimpleColor(contextProvider, R.color.color_area_series);
    }

    float getAlphaFromResources(ContextProvider contextProvider) {
        return contextProvider.getResources().getDimension(R.dimen.area_series_alpha);
    }

    public Integer getUpperStroke() {
        return this.upperStroke;
    }

    public void setUpperStroke(Integer num) {
        if (CompareHelper.areNotEquals(this.upperStroke, num)) {
            this.upperStroke = num;
            notifyListeners(Property.STROKE_HIGH);
        }
    }

    public Integer getLowerStroke() {
        return this.lowerStroke;
    }

    public void setLowerStroke(Integer num) {
        if (CompareHelper.areNotEquals(this.lowerStroke, num)) {
            this.lowerStroke = num;
            notifyListeners(Property.STROKE_LOW);
        }
    }

    public Float getUpperStrokeThickness() {
        return this.upperStrokeThickness;
    }

    public void setUpperStrokeThickness(Float f) {
        if (CompareHelper.areNotEquals(this.upperStrokeThickness, f)) {
            this.upperStrokeThickness = f;
            notifyListeners(Property.STROKE_THICKNESS_HIGH);
        }
    }

    public Float getLowerStrokeThickness() {
        return this.lowerStrokeThickness;
    }

    public void setLowerStrokeThickness(Float f) {
        if (CompareHelper.areNotEquals(this.lowerStrokeThickness, f)) {
            this.lowerStrokeThickness = f;
            notifyListeners(Property.STROKE_THICKNESS_LOW);
        }
    }

    public Integer getFill() {
        return this.fill;
    }

    public void setFill(Integer num) {
        if (CompareHelper.areNotEquals(this.fill, num)) {
            this.fill = num;
            notifyListeners(Property.FILL);
        }
    }

    public Float getAlpha() {
        return this.alpha;
    }

    public void setAlpha(Float f) {
        if (CompareHelper.areNotEquals(this.alpha, f)) {
            this.alpha = f;
            notifyListeners(Property.ALPHA);
        }
    }
}
