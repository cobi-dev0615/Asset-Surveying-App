package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class AxisLabelScientificNotation extends AxisLabelNotationBase {
    private ScientificNotation scientificNotation = ScientificNotation.NORMALIZED;

    enum Property {
        NOTATION
    }

    public ScientificNotation getScientificNotation() {
        return this.scientificNotation;
    }

    public void setScientificNotation(ScientificNotation scientificNotation) {
        if (this.scientificNotation != scientificNotation) {
            this.scientificNotation = scientificNotation;
            notifyListeners(Property.NOTATION);
        }
    }
}
