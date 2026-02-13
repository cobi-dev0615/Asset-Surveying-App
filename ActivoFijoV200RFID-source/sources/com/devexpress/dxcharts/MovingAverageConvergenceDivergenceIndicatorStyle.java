package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class MovingAverageConvergenceDivergenceIndicatorStyle extends LineIndicatorStyle {
    private Integer signalStroke;
    private Float signalStrokeThickness;

    enum Property {
        SIGNAL_STROKE,
        SIGNAL_STROKE_THICKNESS
    }

    @Override // com.devexpress.dxcharts.LineIndicatorStyle, com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        super.initDefaultStyle(contextProvider, objArr);
        this.signalStroke = Integer.valueOf(getStrokeFromResources(contextProvider));
        this.signalStrokeThickness = Float.valueOf(getStrokeThicknessFromResources(contextProvider));
    }

    public Integer getSignalStroke() {
        return this.signalStroke;
    }

    public void setSignalStroke(Integer num) {
        if (CompareHelper.areNotEquals(this.signalStroke, num)) {
            this.signalStroke = num;
            notifyListeners(Property.SIGNAL_STROKE);
        }
    }

    public Float getSignalStrokeThickness() {
        return this.signalStrokeThickness;
    }

    public void setSignalStrokeThickness(Float f) {
        if (CompareHelper.areNotEquals(this.signalStrokeThickness, f)) {
            this.signalStrokeThickness = f;
            notifyListeners(Property.SIGNAL_STROKE_THICKNESS);
        }
    }
}
