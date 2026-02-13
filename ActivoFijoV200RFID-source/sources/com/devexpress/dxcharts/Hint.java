package com.devexpress.dxcharts;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Hint extends HintBase {
    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(HintStyle.class);
    }

    @Override // com.devexpress.dxcharts.StyledElement
    List<StyledElement> getInnerStyledElements(ContextProvider contextProvider) {
        ArrayList arrayList = new ArrayList();
        HintStyle hintStyle = (HintStyle) getDefaultStyleFromContainer(HintStyle.class, contextProvider, new Object[0]);
        if (hintStyle != null) {
            arrayList.add(hintStyle.getArgumentLineStyledElement());
        }
        HintStyle hintStyle2 = (HintStyle) getUserStyleFromContainer(HintStyle.class);
        if (hintStyle2 != null) {
            arrayList.add(hintStyle2.getArgumentLineStyledElement());
        }
        HintStyle hintStyle3 = (HintStyle) getDefaultStyleFromContainer(HintStyle.class, contextProvider, new Object[0]);
        if (hintStyle3 != null) {
            arrayList.add(hintStyle3.getValueLineStyledElement());
        }
        HintStyle hintStyle4 = (HintStyle) getUserStyleFromContainer(HintStyle.class);
        if (hintStyle4 != null) {
            arrayList.add(hintStyle4.getValueLineStyledElement());
        }
        return arrayList;
    }

    HintStyle getActualStyle(ContextProvider contextProvider, Object... objArr) {
        return (HintStyle) getActualStyleFromContainer(HintStyle.class, contextProvider, objArr);
    }

    HintStyle getDefaultStyle() {
        return (HintStyle) getDefaultStyleFromContainer(HintStyle.class);
    }

    public HintBehavior getBehavior() {
        return getBehaviorInternal();
    }

    public void setBehavior(HintBehavior hintBehavior) {
        setBehaviorInternal(hintBehavior);
    }

    public HintStyle getStyle() {
        return (HintStyle) getUserStyleFromContainer(HintStyle.class);
    }

    public void setStyle(HintStyle hintStyle) {
        trySetStyle(hintStyle);
    }
}
