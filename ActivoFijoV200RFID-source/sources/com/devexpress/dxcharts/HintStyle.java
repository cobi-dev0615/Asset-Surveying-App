package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class HintStyle extends HintStyleBase {
    private StyledElement argumentLineStyledElement = new StyledElement() { // from class: com.devexpress.dxcharts.HintStyle.1
        @Override // com.devexpress.dxcharts.StyledElement
        StyleContainer<? extends StyleBase> createStyleContainer() {
            return new StyleContainer<>(CrosshairLineStyle.class);
        }
    };
    private StyledElement valueLineStyledElement = new StyledElement() { // from class: com.devexpress.dxcharts.HintStyle.2
        @Override // com.devexpress.dxcharts.StyledElement
        StyleContainer<? extends StyleBase> createStyleContainer() {
            return new StyleContainer<>(CrosshairLineStyle.class);
        }
    };

    StyledElement getArgumentLineStyledElement() {
        return this.argumentLineStyledElement;
    }

    StyledElement getValueLineStyledElement() {
        return this.valueLineStyledElement;
    }

    CrosshairLineStyle getActualArgumentLineStyle(ContextProvider contextProvider) {
        return (CrosshairLineStyle) this.argumentLineStyledElement.getActualStyleFromContainer(CrosshairLineStyle.class, contextProvider, new Object[0]);
    }

    CrosshairLineStyle getDefaultArgumentLineStyle(ContextProvider contextProvider) {
        return (CrosshairLineStyle) this.argumentLineStyledElement.getDefaultStyleFromContainer(CrosshairLineStyle.class, contextProvider, new Object[0]);
    }

    CrosshairLineStyle getActualValueLineStyle(ContextProvider contextProvider) {
        return (CrosshairLineStyle) this.valueLineStyledElement.getActualStyleFromContainer(CrosshairLineStyle.class, contextProvider, new Object[0]);
    }

    CrosshairLineStyle getDefaultValueLineStyle(ContextProvider contextProvider) {
        return (CrosshairLineStyle) this.valueLineStyledElement.getDefaultStyleFromContainer(CrosshairLineStyle.class, contextProvider, new Object[0]);
    }

    public CrosshairLineStyle getArgumentLineStyle() {
        return (CrosshairLineStyle) this.argumentLineStyledElement.getUserStyleFromContainer(CrosshairLineStyle.class);
    }

    public void setArgumentLineStyle(CrosshairLineStyle crosshairLineStyle) {
        this.argumentLineStyledElement.trySetStyle(crosshairLineStyle);
    }

    public CrosshairLineStyle getValueLineStyle() {
        return (CrosshairLineStyle) this.valueLineStyledElement.getUserStyleFromContainer(CrosshairLineStyle.class);
    }

    public void setValueLineStyle(CrosshairLineStyle crosshairLineStyle) {
        this.valueLineStyledElement.trySetStyle(crosshairLineStyle);
    }

    public Integer getItemsIndent() {
        return getItemsIndentInternal();
    }

    public void setItemsIndent(Integer num) {
        setItemsIndentInternal(num);
    }
}
