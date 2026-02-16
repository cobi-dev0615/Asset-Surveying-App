package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public abstract class AxisLabelBase extends StyledElement {
    private boolean mVisibility = true;

    enum Property {
        VISIBILITY
    }

    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(AxisLabelStyle.class);
    }

    AxisLabelStyle getActualStyle(ContextProvider contextProvider, Object... objArr) {
        return (AxisLabelStyle) getActualStyleFromContainer(AxisLabelStyle.class, contextProvider, objArr);
    }

    public boolean isVisible() {
        return this.mVisibility;
    }

    public void setVisible(boolean z) {
        if (this.mVisibility != z) {
            this.mVisibility = z;
            notifyListeners(Property.VISIBILITY);
        }
    }

    public AxisLabelStyle getStyle() {
        return (AxisLabelStyle) getUserStyleFromContainer(AxisLabelStyle.class);
    }

    public void setStyle(AxisLabelStyle axisLabelStyle) {
        trySetStyle(axisLabelStyle);
    }
}
