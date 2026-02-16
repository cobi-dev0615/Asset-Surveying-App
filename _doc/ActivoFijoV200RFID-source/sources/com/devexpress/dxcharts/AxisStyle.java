package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class AxisStyle extends StyleBase {
    private Integer color;
    private Integer interlacedColor;
    private float[] majorGridlineDashes;
    private Integer majorGridlinesColor;
    private Float majorGridlinesThickness;
    private float[] majorTickmarkDashes;
    private Float majorTickmarksLength;
    private Float majorTickmarksThickness;
    private float[] minorGridlineDashes;
    private Integer minorGridlinesColor;
    private Float minorGridlinesThickness;
    private float[] minorTickmarkDashes;
    private Float minorTickmarksLength;
    private Float minorTickmarksThickness;
    private Boolean showInterlaced;
    private Boolean showLine;
    private Boolean showMajorGridlines;
    private Boolean showMajorTickmarks;
    private Boolean showMinorGridlines;
    private Boolean showMinorTickmarks;
    private Float thickness;

    enum Property {
        SHOW_LINE,
        COLOR,
        THICKNESS,
        SHOW_MAJOR_GRIDLINES,
        MAJOR_GRIDLINES_THICKNESS,
        MAJOR_GRIDLINES_COLOR,
        MAJOR_GRIDLINE_DASHES,
        SHOW_MINOR_GRIDLINES,
        MINOR_GRIDLINES_THICKNESS,
        MINOR_GRIDLINES_COLOR,
        MINOR_GRIDLINE_DASHES,
        SHOW_MAJOR_TICKMARKS,
        MAJOR_TICKMARKS_LENGTH,
        MAJOR_TICKMARKS_THICKNESS,
        MAJOR_TICKMARK_DASHES,
        SHOW_MINOR_TICKMARKS,
        MINOR_TICKMARKS_LENGTH,
        MINOR_TICKMARKS_THICKNESS,
        MINOR_TICKMARK_DASHES,
        SHOW_INTERLACED,
        INTERLACED_COLOR
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    @Override // com.devexpress.dxcharts.StyleBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void initDefaultStyle(com.devexpress.dxcharts.ContextProvider r5, java.lang.Object... r6) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.dxcharts.AxisStyle.initDefaultStyle(com.devexpress.dxcharts.ContextProvider, java.lang.Object[]):void");
    }

    public Boolean isLineVisible() {
        return this.showLine;
    }

    public void setLineVisible(Boolean bool) {
        if (CompareHelper.areNotEquals(this.showLine, bool)) {
            this.showLine = bool;
            notifyListeners(Property.SHOW_LINE);
        }
    }

    public Integer getLineColor() {
        return this.color;
    }

    public void setLineColor(Integer num) {
        if (CompareHelper.areNotEquals(this.color, num)) {
            this.color = num;
            notifyListeners(Property.COLOR);
        }
    }

    public Float getLineThickness() {
        return this.thickness;
    }

    public void setLineThickness(Float f) {
        if (CompareHelper.areNotEquals(this.thickness, f)) {
            this.thickness = f;
            notifyListeners(Property.THICKNESS);
        }
    }

    public Boolean isMajorGridlinesVisible() {
        return this.showMajorGridlines;
    }

    public void setMajorGridlinesVisible(Boolean bool) {
        if (CompareHelper.areNotEquals(this.showMajorGridlines, bool)) {
            this.showMajorGridlines = bool;
            notifyListeners(Property.SHOW_MAJOR_GRIDLINES);
        }
    }

    public Float getMajorGridlinesThickness() {
        return this.majorGridlinesThickness;
    }

    public void setMajorGridlinesThickness(Float f) {
        if (CompareHelper.areNotEquals(this.majorGridlinesThickness, f)) {
            this.majorGridlinesThickness = f;
            notifyListeners(Property.MAJOR_GRIDLINES_THICKNESS);
        }
    }

    public Integer getMajorGridlinesColor() {
        return this.majorGridlinesColor;
    }

    public void setMajorGridlinesColor(Integer num) {
        if (CompareHelper.areNotEquals(this.majorGridlinesColor, num)) {
            this.majorGridlinesColor = num;
            notifyListeners(Property.MAJOR_GRIDLINES_COLOR);
        }
    }

    public float[] getMajorGridlineDashes() {
        float[] fArr = this.majorGridlineDashes;
        if (fArr == null) {
            return null;
        }
        return (float[]) fArr.clone();
    }

    public void setMajorGridlineDashes(float[] fArr) {
        if (this.majorGridlineDashes != fArr) {
            this.majorGridlineDashes = fArr;
            notifyListeners(Property.MAJOR_GRIDLINE_DASHES);
        }
    }

    public Boolean isMinorGridlinesVisible() {
        return this.showMinorGridlines;
    }

    public void setMinorGridlinesVisible(Boolean bool) {
        if (CompareHelper.areNotEquals(this.showMinorGridlines, bool)) {
            this.showMinorGridlines = bool;
            notifyListeners(Property.SHOW_MINOR_GRIDLINES);
        }
    }

    public Float getMinorGridlinesThickness() {
        return this.minorGridlinesThickness;
    }

    public void setMinorGridlinesThickness(Float f) {
        if (CompareHelper.areNotEquals(this.minorGridlinesThickness, f)) {
            this.minorGridlinesThickness = f;
            notifyListeners(Property.MINOR_GRIDLINES_THICKNESS);
        }
    }

    public Integer getMinorGridlinesColor() {
        return this.minorGridlinesColor;
    }

    public void setMinorGridlinesColor(Integer num) {
        if (CompareHelper.areNotEquals(this.minorGridlinesColor, num)) {
            this.minorGridlinesColor = num;
            notifyListeners(Property.MINOR_GRIDLINES_COLOR);
        }
    }

    public float[] getMinorGridlineDashes() {
        float[] fArr = this.minorGridlineDashes;
        if (fArr == null) {
            return null;
        }
        return (float[]) fArr.clone();
    }

    public void setMinorGridlineDashes(float[] fArr) {
        if (this.minorGridlineDashes != fArr) {
            this.minorGridlineDashes = fArr;
            notifyListeners(Property.MINOR_GRIDLINE_DASHES);
        }
    }

    public Boolean isMajorTickmarksVisible() {
        return this.showMajorTickmarks;
    }

    public void setMajorTickmarksVisible(Boolean bool) {
        if (CompareHelper.areNotEquals(this.showMajorTickmarks, bool)) {
            this.showMajorTickmarks = bool;
            notifyListeners(Property.SHOW_MAJOR_TICKMARKS);
        }
    }

    public Float getMajorTickmarksLength() {
        return this.majorTickmarksLength;
    }

    public void setMajorTickmarksLength(Float f) {
        if (CompareHelper.areNotEquals(this.majorTickmarksLength, f)) {
            this.majorTickmarksLength = f;
            notifyListeners(Property.MAJOR_TICKMARKS_LENGTH);
        }
    }

    public Float getMajorTickmarksThickness() {
        return this.majorTickmarksThickness;
    }

    public void setMajorTickmarksThickness(Float f) {
        if (CompareHelper.areNotEquals(this.majorTickmarksThickness, f)) {
            this.majorTickmarksThickness = f;
            notifyListeners(Property.MAJOR_TICKMARKS_THICKNESS);
        }
    }

    public float[] getMajorTickmarkDashes() {
        float[] fArr = this.majorTickmarkDashes;
        if (fArr == null) {
            return null;
        }
        return (float[]) fArr.clone();
    }

    public void setMajorTickmarkDashes(float[] fArr) {
        if (this.majorTickmarkDashes != fArr) {
            this.majorTickmarkDashes = fArr;
            notifyListeners(Property.MINOR_TICKMARK_DASHES);
        }
    }

    public Boolean isMinorTickmarksVisible() {
        return this.showMinorTickmarks;
    }

    public void setMinorTickmarksVisible(Boolean bool) {
        if (CompareHelper.areNotEquals(this.showMinorTickmarks, bool)) {
            this.showMinorTickmarks = bool;
            notifyListeners(Property.SHOW_MINOR_TICKMARKS);
        }
    }

    public Float getMinorTickmarksLength() {
        return this.minorTickmarksLength;
    }

    public void setMinorTickmarksLength(Float f) {
        if (CompareHelper.areNotEquals(this.minorTickmarksLength, f)) {
            this.minorTickmarksLength = f;
            notifyListeners(Property.MINOR_TICKMARKS_LENGTH);
        }
    }

    public Float getMinorTickmarksThickness() {
        return this.minorTickmarksThickness;
    }

    public void setMinorTickmarksThickness(Float f) {
        if (CompareHelper.areNotEquals(this.minorTickmarksThickness, f)) {
            this.minorTickmarksThickness = f;
            notifyListeners(Property.MINOR_TICKMARKS_THICKNESS);
        }
    }

    public float[] getMinorTickmarkDashes() {
        float[] fArr = this.minorTickmarkDashes;
        if (fArr == null) {
            return null;
        }
        return (float[]) fArr.clone();
    }

    public void setMinorTickmarkDashes(float[] fArr) {
        if (this.minorTickmarkDashes != fArr) {
            this.minorTickmarkDashes = fArr;
            notifyListeners(Property.MINOR_TICKMARK_DASHES);
        }
    }

    public Boolean isInterlacedVisible() {
        return this.showInterlaced;
    }

    public void setInterlacedVisible(Boolean bool) {
        if (CompareHelper.areNotEquals(this.showInterlaced, bool)) {
            this.showInterlaced = bool;
            notifyListeners(Property.SHOW_INTERLACED);
        }
    }

    public Integer getInterlacedColor() {
        return this.interlacedColor;
    }

    public void setInterlacedColor(Integer num) {
        if (CompareHelper.areNotEquals(this.interlacedColor, num)) {
            this.interlacedColor = num;
            notifyListeners(Property.INTERLACED_COLOR);
        }
    }
}
