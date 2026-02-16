package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class TooltipHintBehavior extends HintBehavior {
    static boolean DEFAULT_SHOW_POINT_TOOLTIP = true;
    static boolean DEFAULT_SHOW_SERIES_TOOLTIP = true;
    private boolean showPointTooltip = DEFAULT_SHOW_POINT_TOOLTIP;
    private boolean showSeriesTooltip = DEFAULT_SHOW_SERIES_TOOLTIP;

    enum Property {
        SHOW_POINT_TOOLTIP,
        SHOW_SERIES_TOOLTIP
    }

    public boolean isShowPointTooltip() {
        return this.showPointTooltip;
    }

    public void setShowPointTooltip(boolean z) {
        if (this.showPointTooltip != z) {
            this.showPointTooltip = z;
            notifyListeners(Property.SHOW_POINT_TOOLTIP);
        }
    }

    public boolean isShowSeriesTooltip() {
        return this.showSeriesTooltip;
    }

    public void setShowSeriesTooltip(boolean z) {
        if (this.showSeriesTooltip != z) {
            this.showSeriesTooltip = z;
            notifyListeners(Property.SHOW_SERIES_TOOLTIP);
        }
    }
}
