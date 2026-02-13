package com.devexpress.dxcharts;

import com.devexpress.dxcharts.PieSeriesLabelStyle;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class PieSeriesLabel extends SeriesLabel {
    @Override // com.devexpress.dxcharts.SeriesLabel
    native long nativeCreateLabel();

    native int nativeGetPosition(long j);

    native void nativeSetConnectorThickness(float f, long j);

    native void nativeSetPosition(int i, long j);

    @Override // com.devexpress.dxcharts.SeriesLabel
    String getDefaultTextPattern() {
        return "{L}";
    }

    @Override // com.devexpress.dxcharts.SeriesLabel, com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(PieSeriesLabelStyle.class);
    }

    @Override // com.devexpress.dxcharts.StyledElement
    void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r4) {
        super.applyStyleAttribute(contextProvider, styleContainer, r4);
        if (r4 instanceof PieSeriesLabelStyle.Property) {
            PieSeriesLabelStyle pieSeriesLabelStyle = (PieSeriesLabelStyle) styleContainer.getActualStyle(contextProvider, new Object[0]);
            PieSeriesLabelStyle pieSeriesLabelStyle2 = (PieSeriesLabelStyle) styleContainer.getDefaultStyle();
            if (AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$PieSeriesLabelStyle$Property[((PieSeriesLabelStyle.Property) r4).ordinal()] != 1) {
                return;
            }
            if (pieSeriesLabelStyle.getConnectorThickness() == null) {
                pieSeriesLabelStyle = pieSeriesLabelStyle2;
            }
            nativeSetConnectorThickness(pieSeriesLabelStyle.getConnectorThickness().floatValue(), getNativeLabel());
            return;
        }
        super.applyStyleAttribute(contextProvider, styleContainer, r4);
    }

    /* renamed from: com.devexpress.dxcharts.PieSeriesLabel$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$PieSeriesLabelStyle$Property;

        static {
            int[] iArr = new int[PieSeriesLabelStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$PieSeriesLabelStyle$Property = iArr;
            try {
                iArr[PieSeriesLabelStyle.Property.CONNECTOR_THICKNESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @Override // com.devexpress.dxcharts.StyledElement
    List<Enum<?>> getListenPropertiesNames() {
        List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
        Collections.addAll(listenPropertiesNames, PieSeriesLabelStyle.Property.values());
        return listenPropertiesNames;
    }

    public PieSeriesLabelStyle getStyle() {
        return (PieSeriesLabelStyle) getUserStyleFromContainer(PieSeriesLabelStyle.class);
    }

    public void setStyle(PieSeriesLabelStyle pieSeriesLabelStyle) {
        trySetStyle(pieSeriesLabelStyle);
    }

    public PieSeriesLabelPosition getPosition() {
        return PieSeriesLabelPosition.values()[nativeGetPosition(getNativeLabel())];
    }

    public void setPosition(PieSeriesLabelPosition pieSeriesLabelPosition) {
        if (pieSeriesLabelPosition != null) {
            nativeSetPosition(pieSeriesLabelPosition.ordinal(), getNativeLabel());
        }
    }
}
