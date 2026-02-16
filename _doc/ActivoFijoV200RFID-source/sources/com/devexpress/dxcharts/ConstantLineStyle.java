package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class ConstantLineStyle extends StyleBase {
    private float[] mDashes = null;
    private Integer stroke;
    private Float thickness;

    enum Property {
        STROKE,
        THICKNESS,
        DASHES
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.devexpress.dxcharts.StyleBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void initDefaultStyle(com.devexpress.dxcharts.ContextProvider r2, java.lang.Object... r3) {
        /*
            r1 = this;
            super.initDefaultStyle(r2, r3)
            int r0 = r3.length
            if (r0 <= 0) goto L14
            r0 = 0
            r3 = r3[r0]
            boolean r0 = r3 instanceof java.lang.Boolean
            if (r0 == 0) goto L14
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            goto L15
        L14:
            r3 = 1
        L15:
            if (r3 == 0) goto L1a
            int r3 = com.devexpress.dxcharts.R.attr.dxChartAxisXConstantLineColor
            goto L1c
        L1a:
            int r3 = com.devexpress.dxcharts.R.attr.dxChartAxisYConstantLineColor
        L1c:
            int r3 = com.devexpress.dxcharts.ResourceHelper.getColorOrDefault(r2, r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1.stroke = r3
            android.content.res.Resources r2 = r2.getResources()
            int r3 = com.devexpress.dxcharts.R.dimen.axis_constant_line_thickness
            float r2 = r2.getDimension(r3)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r1.thickness = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.dxcharts.ConstantLineStyle.initDefaultStyle(com.devexpress.dxcharts.ContextProvider, java.lang.Object[]):void");
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

    public float[] getDashes() {
        float[] fArr = this.mDashes;
        if (fArr == null) {
            return null;
        }
        return (float[]) fArr.clone();
    }

    public void setDashes(float[] fArr) {
        if (this.mDashes != fArr) {
            this.mDashes = fArr;
            notifyListeners(Property.DASHES);
        }
    }
}
