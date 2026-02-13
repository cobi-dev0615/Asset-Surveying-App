package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class CrosshairLineStyle extends TextElementStyleBase {
    private Integer labelBackgroundColor;
    private float labelBorderRadius;
    private float labelBorderThickness;
    private Integer stroke;
    private Float thickness;

    private enum Property {
        STROKE,
        THICKNESS,
        LABEL_BACKGROUND_COLOR
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.devexpress.dxcharts.StyleBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void initDefaultStyle(com.devexpress.dxcharts.ContextProvider r3, java.lang.Object... r4) {
        /*
            r2 = this;
            super.initDefaultStyle(r3, r4)
            int r0 = r4.length
            if (r0 <= 0) goto L14
            r0 = 0
            r4 = r4[r0]
            boolean r0 = r4 instanceof java.lang.Boolean
            if (r0 == 0) goto L14
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            goto L15
        L14:
            r4 = 1
        L15:
            if (r4 == 0) goto L1a
            int r0 = com.devexpress.dxcharts.R.attr.dxChartCrosshairArgumentLineStroke
            goto L1c
        L1a:
            int r0 = com.devexpress.dxcharts.R.attr.dxChartCrosshairValueLineStroke
        L1c:
            int r0 = com.devexpress.dxcharts.ResourceHelper.getColorOrDefault(r3, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.stroke = r0
            if (r4 == 0) goto L2b
            int r0 = com.devexpress.dxcharts.R.attr.dxChartCrosshairArgumentLabelBackground
            goto L2d
        L2b:
            int r0 = com.devexpress.dxcharts.R.attr.dxChartCrosshairValueLabelBackground
        L2d:
            int r0 = com.devexpress.dxcharts.ResourceHelper.getColorOrDefault(r3, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.labelBackgroundColor = r0
            android.content.res.Resources r0 = r3.getResources()
            int r1 = com.devexpress.dxcharts.R.dimen.hint_border_thickness
            float r0 = r0.getDimension(r1)
            r2.labelBorderThickness = r0
            android.content.res.Resources r0 = r3.getResources()
            int r1 = com.devexpress.dxcharts.R.dimen.hint_border_radius
            float r0 = r0.getDimension(r1)
            r2.labelBorderRadius = r0
            if (r4 == 0) goto L54
            int r4 = com.devexpress.dxcharts.R.attr.dxChartCrosshairArgumentLineThickness
            goto L56
        L54:
            int r4 = com.devexpress.dxcharts.R.attr.dxChartCrosshairValueLineThickness
        L56:
            float r3 = com.devexpress.dxcharts.ResourceHelper.getDimensionOrDefault(r3, r4)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            r2.thickness = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.dxcharts.CrosshairLineStyle.initDefaultStyle(com.devexpress.dxcharts.ContextProvider, java.lang.Object[]):void");
    }

    float getLabelBorderThickness() {
        return this.labelBorderThickness;
    }

    float getLabelBorderRadius() {
        return this.labelBorderRadius;
    }

    public Integer getStroke() {
        return this.stroke;
    }

    public void setStroke(Integer num) {
        if (CompareHelper.areNotEquals(this.stroke, num)) {
            this.stroke = num;
            notifyListeners(Property.STROKE);
        }
    }

    public Float getThickness() {
        return this.thickness;
    }

    public void setThickness(Float f) {
        if (CompareHelper.areNotEquals(this.thickness, f)) {
            this.thickness = f;
            notifyListeners(Property.THICKNESS);
        }
    }

    public Integer getLabelBackgroundColor() {
        return this.labelBackgroundColor;
    }

    public void setLabelBackgroundColor(Integer num) {
        if (CompareHelper.areNotEquals(this.labelBackgroundColor, num)) {
            this.labelBackgroundColor = num;
            notifyListeners(Property.LABEL_BACKGROUND_COLOR);
        }
    }
}
