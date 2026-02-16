package com.devexpress.dxcharts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class StyledElement extends ChartElement {
    private ContextProvider context;
    private StyleContainer<? extends StyleBase> styleContainer = createStyleContainer();

    void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r3) {
    }

    abstract StyleContainer<? extends StyleBase> createStyleContainer();

    StyledElement() {
    }

    <T extends StyleBase> T getDefaultStyleFromContainer(Class<T> cls) {
        return cls.cast(this.styleContainer.getDefaultStyle());
    }

    <T extends StyleBase> T getDefaultStyleFromContainer(Class<T> cls, ContextProvider contextProvider, Object... objArr) {
        return cls.cast(this.styleContainer.getDefaultStyle(contextProvider, objArr));
    }

    <T extends StyleBase> T getUserStyleFromContainer(Class<T> cls) {
        return cls.cast(this.styleContainer.getUserStyle());
    }

    <T extends StyleBase> T getActualStyleFromContainer(Class<T> cls, Object... objArr) {
        return (T) getActualStyleFromContainer(cls, this.context, objArr);
    }

    <T extends StyleBase> T getActualStyleFromContainer(Class<T> cls, ContextProvider contextProvider, Object... objArr) {
        return cls.cast(this.styleContainer.getActualStyle(contextProvider, objArr));
    }

    boolean trySetStyle(StyleBase styleBase) {
        ContextProvider contextProvider;
        if (!this.styleContainer.trySetUserStyle(styleBase, getSelfListener()) || (contextProvider = this.context) == null) {
            return false;
        }
        applyActualStyle(contextProvider, new Object[0]);
        return true;
    }

    ContextProvider getContext() {
        return this.context;
    }

    List<Enum<?>> getListenPropertiesNames() {
        return new ArrayList();
    }

    List<StyledElement> getInnerStyledElements(ContextProvider contextProvider) {
        ArrayList arrayList = new ArrayList();
        if (TextElementStyleBase.class.isAssignableFrom(this.styleContainer.getStyleClass())) {
            TextElementStyleBase textElementStyleBase = (TextElementStyleBase) getDefaultStyleFromContainer(TextElementStyleBase.class, contextProvider, new Object[0]);
            if (textElementStyleBase != null) {
                arrayList.add(textElementStyleBase.getTextStyledElement());
            }
            TextElementStyleBase textElementStyleBase2 = (TextElementStyleBase) getUserStyleFromContainer(TextElementStyleBase.class);
            if (textElementStyleBase2 != null) {
                arrayList.add(textElementStyleBase2.getTextStyledElement());
            }
        }
        return arrayList;
    }

    private void applyActualStyle(ContextProvider contextProvider, Object... objArr) {
        this.context = contextProvider;
        List<Enum<?>> listenPropertiesNames = getListenPropertiesNames();
        if (contextProvider != null && listenPropertiesNames != null) {
            Iterator<Enum<?>> it = listenPropertiesNames.iterator();
            while (it.hasNext()) {
                applyStyleAttribute(contextProvider, this.styleContainer, it.next());
            }
        }
        for (StyledElement styledElement : getInnerStyledElements(contextProvider)) {
            if (styledElement != null) {
                styledElement.applyActualStyle(contextProvider, objArr);
            }
        }
    }

    void applyCurrentTheme(ContextProvider contextProvider, Object... objArr) {
        applyCurrentTheme(false, contextProvider, objArr);
        for (StyledElement styledElement : getInnerStyledElements(contextProvider)) {
            if (styledElement != null) {
                styledElement.applyCurrentTheme(contextProvider, objArr);
            }
        }
    }

    void applyCurrentTheme(boolean z, ContextProvider contextProvider, Object... objArr) {
        setUpdatesEnabled(z);
        resetDefaultStyle();
        applyActualStyle(contextProvider, objArr);
        setUpdatesEnabled(true);
    }

    @Override // com.devexpress.dxcharts.ChartElement
    void onChartElementPropertyChanged(Object obj, PropertyChangedArgs propertyChangedArgs) {
        if (obj instanceof StyleBase) {
            ContextProvider contextProvider = this.context;
            if (contextProvider != null) {
                applyStyleAttribute(contextProvider, this.styleContainer, propertyChangedArgs.getProperty());
                return;
            }
            return;
        }
        super.onChartElementPropertyChanged(obj, propertyChangedArgs);
    }

    void resetDefaultStyle() {
        this.styleContainer.resetDefaultStyle();
    }
}
