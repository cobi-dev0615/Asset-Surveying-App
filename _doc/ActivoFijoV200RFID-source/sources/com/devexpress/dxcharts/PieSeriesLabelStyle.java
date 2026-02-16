package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class PieSeriesLabelStyle extends SeriesLabelStyle {
    private Float connectorThickness;

    enum Property {
        CONNECTOR_THICKNESS
    }

    @Override // com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        super.initDefaultStyle(contextProvider, objArr);
        this.connectorThickness = Float.valueOf(ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxPieChartLabelConnectorThickness));
    }

    public Float getConnectorThickness() {
        return this.connectorThickness;
    }

    public void setConnectorThickness(Float f) {
        if (CompareHelper.areNotEquals(this.connectorThickness, f)) {
            this.connectorThickness = f;
            notifyListeners(Property.CONNECTOR_THICKNESS);
        }
    }
}
