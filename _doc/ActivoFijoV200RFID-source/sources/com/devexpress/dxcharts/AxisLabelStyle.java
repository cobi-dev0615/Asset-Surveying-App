package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class AxisLabelStyle extends TextElementStyleBase {
    @Override // com.devexpress.dxcharts.ChartElement
    void onChartElementPropertyChanged(Object obj, PropertyChangedArgs propertyChangedArgs) {
        super.onChartElementPropertyChanged(obj, propertyChangedArgs);
        if (obj instanceof StyledElement) {
            notifyListeners(this, propertyChangedArgs.getProperty());
        }
    }
}
