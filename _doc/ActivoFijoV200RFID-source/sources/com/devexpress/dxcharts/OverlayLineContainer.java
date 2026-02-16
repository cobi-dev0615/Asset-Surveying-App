package com.devexpress.dxcharts;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* compiled from: OverlayContainer.java */
/* loaded from: classes.dex */
class OverlayLineContainer extends OverlayContainerBase {
    private boolean canDrawLines;
    private Rect mPaneRect;

    public OverlayLineContainer(HintContainer hintContainer) {
        super(hintContainer);
        this.canDrawLines = false;
    }

    @Override // com.devexpress.dxcharts.OverlayContainerBase
    void updateOverlay(OverlayInfo[] overlayInfoArr, HintInfo hintInfo, Rect rect, boolean z) {
        setItemInfos(overlayInfoArr);
        this.mPaneRect = rect;
        if (overlayInfoArr != null && overlayInfoArr.length > 0) {
            for (OverlayInfo overlayInfo : overlayInfoArr) {
                if (overlayInfo.getOverlayLabelType() == 3) {
                    this.canDrawLines = true;
                }
            }
            return;
        }
        getHintContainer().hide(z);
    }

    @Override // com.devexpress.dxcharts.OverlayContainerBase
    void hide() {
        this.canDrawLines = false;
    }

    @Override // com.devexpress.dxcharts.OverlayContainerBase, com.devexpress.dxcharts.OverlayDrawableInterface
    public boolean canDraw() {
        return this.canDrawLines;
    }

    @Override // com.devexpress.dxcharts.OverlayContainerBase, com.devexpress.dxcharts.OverlayDrawableInterface
    public void draw(Canvas canvas, ContextProvider contextProvider) {
        int i;
        int i2;
        int i3;
        int i4;
        double[] dArr;
        HintBase actualHint = getActualHint();
        if ((actualHint instanceof Hint) && (actualHint.getBehaviorInternal() instanceof CrosshairHintBehavior) && getItemInfos() != null) {
            Hint hint = (Hint) getActualHint();
            CrosshairLineStyle actualArgumentLineStyle = hint.getActualStyle(contextProvider, new Object[0]).getActualArgumentLineStyle(contextProvider);
            CrosshairLineStyle defaultArgumentLineStyle = hint.getActualStyle(contextProvider, new Object[0]).getDefaultArgumentLineStyle(contextProvider);
            CrosshairLineStyle actualValueLineStyle = hint.getActualStyle(contextProvider, new Object[0]).getActualValueLineStyle(contextProvider);
            CrosshairLineStyle defaultValueLineStyle = hint.getActualStyle(contextProvider, new Object[0]).getDefaultValueLineStyle(contextProvider);
            CrosshairHintBehavior crosshairHintBehavior = (CrosshairHintBehavior) hint.getBehavior();
            Paint paint = new Paint();
            boolean isRotated = ((Chart) getHintContainer().getOwnerChart()).isRotated();
            OverlayInfo[] itemInfos = getItemInfos();
            int length = itemInfos.length;
            int i5 = 0;
            while (i5 < length) {
                TooltipLinesInfo tooltipLinesInfo = itemInfos[i5].getTooltipLinesInfo();
                if (tooltipLinesInfo != null) {
                    if (crosshairHintBehavior.isArgumentLineVisible()) {
                        long argumentLineValue = (long) tooltipLinesInfo.getArgumentLineValue();
                        paint.setColor((actualArgumentLineStyle.getStroke() != null ? actualArgumentLineStyle : defaultArgumentLineStyle).getStroke().intValue());
                        paint.setStrokeWidth((actualArgumentLineStyle.getThickness() != null ? actualArgumentLineStyle : defaultArgumentLineStyle).getThickness().floatValue());
                        if (isRotated) {
                            float f = argumentLineValue;
                            i = i5;
                            i2 = length;
                            canvas.drawLine(this.mPaneRect.left, f, this.mPaneRect.right, f, paint);
                        } else {
                            i = i5;
                            i2 = length;
                            float f2 = argumentLineValue;
                            canvas.drawLine(f2, this.mPaneRect.top, f2, this.mPaneRect.bottom, paint);
                        }
                    } else {
                        i = i5;
                        i2 = length;
                    }
                    double[] pointLineValues = tooltipLinesInfo.getPointLineValues();
                    if (crosshairHintBehavior.isValueLineVisible()) {
                        paint.setColor((actualValueLineStyle.getStroke() != null ? actualValueLineStyle : defaultValueLineStyle).getStroke().intValue());
                        paint.setStrokeWidth((actualValueLineStyle.getThickness() != null ? actualValueLineStyle : defaultValueLineStyle).getThickness().floatValue());
                        int length2 = pointLineValues.length;
                        int i6 = 0;
                        while (i6 < length2) {
                            double d = pointLineValues[i6];
                            if (isRotated) {
                                float f3 = (int) d;
                                i3 = i6;
                                i4 = length2;
                                dArr = pointLineValues;
                                canvas.drawLine(f3, this.mPaneRect.top, f3, this.mPaneRect.bottom, paint);
                            } else {
                                i3 = i6;
                                i4 = length2;
                                dArr = pointLineValues;
                                float f4 = (int) d;
                                canvas.drawLine(this.mPaneRect.left, f4, this.mPaneRect.right, f4, paint);
                            }
                            i6 = i3 + 1;
                            pointLineValues = dArr;
                            length2 = i4;
                        }
                    }
                } else {
                    i = i5;
                    i2 = length;
                }
                i5 = i + 1;
                length = i2;
            }
        }
    }
}
