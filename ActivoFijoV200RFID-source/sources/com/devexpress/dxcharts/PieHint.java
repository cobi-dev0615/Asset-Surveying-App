package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class PieHint extends HintBase {
    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(PieHintStyle.class);
    }

    public PieHintStyle getStyle() {
        return (PieHintStyle) getUserStyleFromContainer(PieHintStyle.class);
    }

    public void setStyle(PieHintStyle pieHintStyle) {
        trySetStyle(pieHintStyle);
    }
}
