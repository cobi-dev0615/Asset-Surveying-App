package com.devexpress.dxcharts;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.util.ArrayList;

/* loaded from: classes.dex */
class OverlayContainer extends OverlayContainerBase {
    @Override // com.devexpress.dxcharts.OverlayContainerBase
    void hide() {
    }

    public OverlayContainer(HintContainer hintContainer) {
        super(hintContainer);
    }

    @Override // com.devexpress.dxcharts.OverlayContainerBase
    void updateOverlay(OverlayInfo[] overlayInfoArr, HintInfo hintInfo, Rect rect, boolean z) {
        setItemInfos(overlayInfoArr);
        if (overlayInfoArr != null && overlayInfoArr.length > 0) {
            synchronized (this) {
                if (getHintContainer().isHintEnabled()) {
                    getHintContainer().show(overlayInfoArr, hintInfo);
                }
            }
            return;
        }
        getHintContainer().hide(z);
    }

    @Override // com.devexpress.dxcharts.OverlayContainerBase, com.devexpress.dxcharts.OverlayDrawableInterface
    public boolean canDraw() {
        return getHintContainer().hintIsShown();
    }

    @Override // com.devexpress.dxcharts.OverlayContainerBase, com.devexpress.dxcharts.OverlayDrawableInterface
    public void draw(Canvas canvas, ContextProvider contextProvider) {
        int i;
        HintBase actualHint = getHintContainer().getActualHint();
        if ((actualHint instanceof Hint) && (actualHint.getBehaviorInternal() instanceof CrosshairHintBehavior) && getItemInfos() != null) {
            Hint hint = (Hint) getActualHint();
            CrosshairLineStyle actualArgumentLineStyle = hint.getActualStyle(contextProvider, new Object[0]).getActualArgumentLineStyle(contextProvider);
            CrosshairLineStyle defaultArgumentLineStyle = hint.getActualStyle(contextProvider, new Object[0]).getDefaultArgumentLineStyle(contextProvider);
            CrosshairLineStyle actualValueLineStyle = hint.getActualStyle(contextProvider, new Object[0]).getActualValueLineStyle(contextProvider);
            CrosshairLineStyle defaultValueLineStyle = hint.getActualStyle(contextProvider, new Object[0]).getDefaultValueLineStyle(contextProvider);
            CrosshairHintBehavior crosshairHintBehavior = (CrosshairHintBehavior) hint.getBehavior();
            ArrayList<TooltipAxesLabelsInfo> arrayList = new ArrayList();
            for (OverlayInfo overlayInfo : getItemInfos()) {
                TooltipAxesLabelsInfo tooltipAxesLabelsInfo = overlayInfo.getTooltipAxesLabelsInfo();
                if (tooltipAxesLabelsInfo != null) {
                    arrayList.add(tooltipAxesLabelsInfo);
                }
                if (overlayInfo.getOverlayLabelType() == 3) {
                    getHintContainer().draw(canvas, contextProvider, overlayInfo);
                }
            }
            for (TooltipAxesLabelsInfo tooltipAxesLabelsInfo2 : arrayList) {
                int labelCount = tooltipAxesLabelsInfo2.getLabelCount();
                if (!crosshairHintBehavior.isArgumentLabelVisible() || labelCount <= 0) {
                    i = 0;
                } else {
                    drawCrosshairLabel(canvas, tooltipAxesLabelsInfo2.getLabelTexts(0), tooltipAxesLabelsInfo2.getLabelRects(0), (actualArgumentLineStyle.getLabelBackgroundColor() != null ? actualArgumentLineStyle : defaultArgumentLineStyle).getLabelBackgroundColor().intValue(), actualArgumentLineStyle.getActualTextStylePaint(contextProvider, Integer.valueOf(R.attr.dxChartCrosshairArgumentLabelTextColor)), defaultArgumentLineStyle.getLabelBorderRadius(), defaultArgumentLineStyle.getLabelBorderThickness());
                    i = 1;
                }
                if (crosshairHintBehavior.isValueLabelVisible()) {
                    while (i < labelCount) {
                        drawCrosshairLabel(canvas, tooltipAxesLabelsInfo2.getLabelTexts(i), tooltipAxesLabelsInfo2.getLabelRects(i), (actualValueLineStyle.getLabelBackgroundColor() != null ? actualValueLineStyle : defaultValueLineStyle).getLabelBackgroundColor().intValue(), actualValueLineStyle.getActualTextStylePaint(contextProvider, Integer.valueOf(R.attr.dxChartCrosshairValueLabelTextColor)), defaultValueLineStyle.getLabelBorderRadius(), defaultArgumentLineStyle.getLabelBorderThickness());
                        i++;
                    }
                }
            }
        }
    }

    private void drawCrosshairLabel(Canvas canvas, String str, Rect rect, int i, Paint paint, float f, float f2) {
        if (str == null || str.isEmpty()) {
            return;
        }
        CrosshairRenderer.drawPopupBackground(canvas, rect, 12, f, f2, new Rect(), i);
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, (rect.left + ((rect.width() - r12.width()) / 2.0f)) - r12.left, (rect.bottom - ((rect.height() - r12.height()) / 2.0f)) - r12.bottom, paint);
    }
}
