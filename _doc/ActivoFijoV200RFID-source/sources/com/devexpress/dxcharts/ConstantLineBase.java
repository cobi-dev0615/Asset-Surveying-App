package com.devexpress.dxcharts;

import com.devexpress.dxcharts.ConstantLineStyle;
import com.devexpress.dxcharts.ConstantLineTitle;
import com.devexpress.dxcharts.TitleBase;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ConstantLineBase extends StyledElement {
    private ConstantLineTitle mTitle;
    private boolean mVisibility = true;
    private String mLegendText = null;
    private boolean mVisibleInLegend = true;
    private boolean mShowBehind = false;
    private ConstantLineTitle mFakeTitle = new ConstantLineTitle();

    enum Property {
        AXIS_VALUE,
        VISIBILITY,
        LEGEND_TEXT,
        VISIBLE_IN_LEGEND,
        SHOW_BEHIND
    }

    @Override // com.devexpress.dxcharts.StyledElement, com.devexpress.dxcharts.ChartElement
    void onChartElementPropertyChanged(Object obj, PropertyChangedArgs propertyChangedArgs) {
        if (obj instanceof ConstantLineTitle) {
            notifyListeners(this, propertyChangedArgs);
        } else {
            super.onChartElementPropertyChanged(obj, propertyChangedArgs);
        }
    }

    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(ConstantLineStyle.class);
    }

    @Override // com.devexpress.dxcharts.StyledElement
    List<Enum<?>> getListenPropertiesNames() {
        List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
        Collections.addAll(listenPropertiesNames, ConstantLineStyle.Property.values());
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
        innerStyledElements.add(this.mTitle);
        innerStyledElements.add(this.mFakeTitle);
        return innerStyledElements;
    }

    ConstantLineStyle getDefaultStyle() {
        return (ConstantLineStyle) getDefaultStyleFromContainer(ConstantLineStyle.class);
    }

    ConstantLineStyle getActualStyle(ContextProvider contextProvider, Object... objArr) {
        return (ConstantLineStyle) getActualStyleFromContainer(ConstantLineStyle.class, contextProvider, objArr);
    }

    ConstantLineTitle getTitleInternal() {
        ConstantLineTitle constantLineTitle = this.mTitle;
        return constantLineTitle != null ? constantLineTitle : this.mFakeTitle;
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

    public boolean isShowBehind() {
        return this.mShowBehind;
    }

    public void setShowBehind(boolean z) {
        if (this.mShowBehind != z) {
            this.mShowBehind = z;
            notifyListeners(Property.SHOW_BEHIND);
        }
    }

    public ConstantLineTitle getTitle() {
        return this.mTitle;
    }

    public void setTitle(ConstantLineTitle constantLineTitle) {
        ConstantLineTitle constantLineTitle2 = this.mTitle;
        if (constantLineTitle2 != constantLineTitle) {
            if (constantLineTitle2 != null) {
                constantLineTitle2.removeListener(getSelfListener());
            }
            this.mTitle = constantLineTitle;
            if (constantLineTitle != null) {
                constantLineTitle.applyCurrentTheme(getContext(), new Object[0]);
                this.mTitle.addListener(getSelfListener());
            }
            for (TitleBase.Property property : TitleBase.Property.values()) {
                notifyListeners(property);
            }
            for (ConstantLineTitle.Property property2 : ConstantLineTitle.Property.values()) {
                notifyListeners(property2);
            }
        }
    }

    public ConstantLineStyle getStyle() {
        return (ConstantLineStyle) getUserStyleFromContainer(ConstantLineStyle.class);
    }

    public void setStyle(ConstantLineStyle constantLineStyle) {
        trySetStyle(constantLineStyle);
    }
}
