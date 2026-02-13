package com.devexpress.dxcharts;

import com.devexpress.dxcharts.AxisLabel;
import com.devexpress.dxcharts.AxisLabelBase;
import com.devexpress.dxcharts.StripAxisLabel;
import com.devexpress.dxcharts.StripStyle;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class StripBase extends StyledElement {
    private StripAxisLabel mAxisLabel;
    private boolean mVisibility = true;
    private boolean mMinLimitEnabled = true;
    private boolean mMaxLimitEnabled = true;
    private String mLegendText = null;
    private boolean mVisibleInLegend = true;

    enum Property {
        MIN_LIMIT,
        MIN_LIMIT_ENABLED,
        MAX_LIMIT,
        MAX_LIMIT_ENABLED,
        VISIBILITY,
        LEGEND_TEXT,
        VISIBLE_IN_LEGEND
    }

    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(StripStyle.class);
    }

    @Override // com.devexpress.dxcharts.StyledElement
    List<Enum<?>> getListenPropertiesNames() {
        List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
        Collections.addAll(listenPropertiesNames, StripStyle.Property.values());
        return listenPropertiesNames;
    }

    @Override // com.devexpress.dxcharts.StyledElement
    void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r3) {
        super.applyStyleAttribute(contextProvider, styleContainer, r3);
        notifyListeners(r3);
    }

    @Override // com.devexpress.dxcharts.StyledElement
    List<StyledElement> getInnerStyledElements(ContextProvider contextProvider) {
        List<StyledElement> innerStyledElements = super.getInnerStyledElements(contextProvider);
        innerStyledElements.add(this.mAxisLabel);
        return innerStyledElements;
    }

    StripStyle getDefaultStyle() {
        return (StripStyle) getDefaultStyleFromContainer(StripStyle.class);
    }

    StripStyle getActualStyle(ContextProvider contextProvider, Object... objArr) {
        return (StripStyle) getActualStyleFromContainer(StripStyle.class, contextProvider, objArr);
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

    public boolean isMinLimitEnabled() {
        return this.mMinLimitEnabled;
    }

    public void setMinLimitEnabled(boolean z) {
        if (this.mMinLimitEnabled != z) {
            this.mMinLimitEnabled = z;
            notifyListeners(Property.MIN_LIMIT_ENABLED);
        }
    }

    public boolean isMaxLimitEnabled() {
        return this.mMaxLimitEnabled;
    }

    public void setMaxLimitEnabled(boolean z) {
        if (this.mMaxLimitEnabled != z) {
            this.mMaxLimitEnabled = z;
            notifyListeners(Property.MAX_LIMIT_ENABLED);
        }
    }

    public String getLegendText() {
        return this.mLegendText;
    }

    public void setLegendText(String str) {
        if (CompareHelper.areNotEquals(this.mLegendText, str)) {
            this.mLegendText = str;
            notifyListeners(Property.LEGEND_TEXT);
        }
    }

    public boolean isVisibleInLegend() {
        return this.mVisibleInLegend;
    }

    public void setVisibleInLegend(boolean z) {
        if (this.mVisibleInLegend != z) {
            this.mVisibleInLegend = z;
            notifyListeners(Property.VISIBLE_IN_LEGEND);
        }
    }

    public StripAxisLabel getAxisLabel() {
        return this.mAxisLabel;
    }

    public void setAxisLabel(StripAxisLabel stripAxisLabel) {
        StripAxisLabel stripAxisLabel2 = this.mAxisLabel;
        if (stripAxisLabel2 != stripAxisLabel) {
            if (stripAxisLabel2 != null) {
                stripAxisLabel2.removeListener(getSelfListener());
            }
            this.mAxisLabel = stripAxisLabel;
            if (stripAxisLabel != null) {
                stripAxisLabel.applyCurrentTheme(getContext(), new Object[0]);
                this.mAxisLabel.addListener(getSelfListener());
            }
            for (AxisLabelBase.Property property : AxisLabelBase.Property.values()) {
                notifyListeners(property);
            }
            for (AxisLabel.Property property2 : AxisLabel.Property.values()) {
                notifyListeners(property2);
            }
            for (StripAxisLabel.Property property3 : StripAxisLabel.Property.values()) {
                notifyListeners(property3);
            }
        }
    }

    public StripStyle getStyle() {
        return (StripStyle) getUserStyleFromContainer(StripStyle.class);
    }

    public void setStyle(StripStyle stripStyle) {
        trySetStyle(stripStyle);
    }
}
