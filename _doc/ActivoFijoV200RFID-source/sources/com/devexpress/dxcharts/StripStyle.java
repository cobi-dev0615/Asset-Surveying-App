package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class StripStyle extends StyleBase {
    private Integer fill;

    enum Property {
        FILL
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
            int r3 = com.devexpress.dxcharts.R.attr.dxChartAxisXStripColor
            goto L1c
        L1a:
            int r3 = com.devexpress.dxcharts.R.attr.dxChartAxisYStripColor
        L1c:
            int r2 = com.devexpress.dxcharts.ResourceHelper.getColorOrDefault(r2, r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.fill = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.dxcharts.StripStyle.initDefaultStyle(com.devexpress.dxcharts.ContextProvider, java.lang.Object[]):void");
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
}
