package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class AxisTitle extends TitleBase {
    static final AxisTitleAlignment DEFAULT_ALIGNMENT = AxisTitleAlignment.CENTER;
    private AxisTitleAlignment mAlignment;

    enum Property {
        ALIGNMENT
    }

    public AxisTitle() {
        this.mAlignment = DEFAULT_ALIGNMENT;
    }

    public AxisTitle(String str) {
        super(str);
        this.mAlignment = DEFAULT_ALIGNMENT;
    }

    public AxisTitleAlignment getAlignment() {
        return this.mAlignment;
    }

    public void setAlignment(AxisTitleAlignment axisTitleAlignment) {
        if (axisTitleAlignment == null || this.mAlignment == axisTitleAlignment) {
            return;
        }
        this.mAlignment = axisTitleAlignment;
        notifyListeners(Property.ALIGNMENT);
    }
}
