package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class StaticCrosshairLabelPosition extends CrosshairLabelPositionBase {
    static LabelPositionHorizontalAlignment DEFAULT_HORIZONTAL_ALIGNMENT = LabelPositionHorizontalAlignment.RIGHT;
    static LabelPositionVerticalAlignment DEFAULT_VERTICAL_ALIGNMENT = LabelPositionVerticalAlignment.TOP;
    private LabelPositionHorizontalAlignment mHorizontalAlignment = DEFAULT_HORIZONTAL_ALIGNMENT;
    private LabelPositionVerticalAlignment mVerticalAlignment = DEFAULT_VERTICAL_ALIGNMENT;

    enum Property {
        HORIZONTAL_ALIGNMENT,
        VERTICAL_ALIGNMENT
    }

    public LabelPositionHorizontalAlignment getHorizontalAlignment() {
        return this.mHorizontalAlignment;
    }

    public void setHorizontalAlignment(LabelPositionHorizontalAlignment labelPositionHorizontalAlignment) {
        if (labelPositionHorizontalAlignment == null || this.mHorizontalAlignment == labelPositionHorizontalAlignment) {
            return;
        }
        this.mHorizontalAlignment = labelPositionHorizontalAlignment;
        notifyListeners(Property.HORIZONTAL_ALIGNMENT);
    }

    public LabelPositionVerticalAlignment getVerticalAlignment() {
        return this.mVerticalAlignment;
    }

    public void setVerticalAlignment(LabelPositionVerticalAlignment labelPositionVerticalAlignment) {
        if (labelPositionVerticalAlignment == null || this.mVerticalAlignment == labelPositionVerticalAlignment) {
            return;
        }
        this.mVerticalAlignment = labelPositionVerticalAlignment;
        notifyListeners(Property.VERTICAL_ALIGNMENT);
    }
}
