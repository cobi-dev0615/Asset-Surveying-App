package com.devexpress.dxcharts;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Legend.java */
/* loaded from: classes.dex */
class LegendContainer extends ChartElement implements OverlayDrawableInterface {
    private ContextProvider context;
    private Legend legend;
    private TextSize maxTextSize;
    private List<LegendItemInfo> info = new ArrayList();
    private List<LegendHitTestInfo> hitTestInfos = new ArrayList();
    private Rect layout = new Rect(-1, -1, 0, 0);

    LegendContainer(ContextProvider contextProvider) {
        this.context = contextProvider;
    }

    private boolean getLegendVisibility() {
        Legend legend = this.legend;
        return legend != null && legend.isVisible();
    }

    private TextSize getTextBounds(Paint paint, String str) {
        paint.getTextBounds(str, 0, str.length(), new Rect());
        String upperCase = str.toUpperCase();
        paint.getTextBounds(upperCase, 0, upperCase.length(), new Rect());
        return new TextSize(paint.measureText(str), Math.abs(Math.min(r3.top, r0.top)), Math.abs(Math.max(r3.bottom, r0.bottom)));
    }

    private int getHorizontalTextIndent() {
        return this.legend.getMarkerSize() + this.legend.getTextIndent();
    }

    private void drawLegendBorder(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.legend.getBackgroundColor());
        Rect rect = new Rect(this.layout.left + getLeftIndentFromDiagram(), this.layout.top + getTopIndentFromDiagram(), this.layout.right - getRightIndentFromDiagram(), this.layout.bottom - getBottomIndentFromDiagram());
        canvas.drawRect(rect, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(this.legend.getBorderColor());
        paint.setStrokeWidth(this.legend.getBorderThickness());
        canvas.drawRect(rect, paint);
    }

    private void drawLegendItems(Canvas canvas, ContextProvider contextProvider) {
        int i;
        int i2;
        Paint paint = new Paint(1);
        int borderThickness = this.legend.getBorderThickness();
        int markerSize = this.legend.getMarkerSize();
        int paddingLeft = this.layout.left + this.legend.getPaddingLeft() + borderThickness + getLeftIndentFromDiagram();
        int paddingTop = this.layout.top + this.legend.getPaddingTop() + borderThickness + getTopIndentFromDiagram();
        int horizontalTextIndent = getHorizontalTextIndent();
        int height = ((int) (this.maxTextSize.getHeight() - markerSize)) / 2;
        this.hitTestInfos.clear();
        for (LegendItemInfo legendItemInfo : this.info) {
            int offsetX = legendItemInfo.getOffsetX() + paddingLeft;
            int offsetY = paddingTop + legendItemInfo.getOffsetY();
            float f = offsetX;
            int i3 = offsetX + horizontalTextIndent;
            int i4 = paddingLeft;
            int i5 = paddingTop;
            int i6 = horizontalTextIndent;
            this.hitTestInfos.add(new LegendHitTestInfo(new RectF(f, offsetY, ((int) legendItemInfo.getTextSize().getWidth()) + i3, ((int) this.maxTextSize.getHeight()) + offsetY), legendItemInfo.getItem().getSeriesIndex(), legendItemInfo.getItem().getPointIndex()));
            LegendItem item = legendItemInfo.getItem();
            int color = item.getColor();
            paint.setColor(color);
            int color2 = item.getColor2();
            if (color2 != color) {
                int i7 = offsetY + height;
                float f2 = i7;
                float f3 = offsetX + markerSize;
                float f4 = i7 + markerSize;
                i = i3;
                i2 = offsetY;
                canvas.drawArc(new RectF(f, f2, f3, f4), 135.0f, 180.0f, true, paint);
                paint.setColor(color2);
                canvas.drawArc(new RectF(f, f2, f3, f4), -45.0f, 180.0f, true, paint);
            } else {
                i = i3;
                i2 = offsetY;
                canvas.drawOval(new RectF(f, i2 + height, offsetX + markerSize, r6 + markerSize), paint);
            }
            canvas.drawText(legendItemInfo.getItem().getText(), i, i2 + ((int) ((this.maxTextSize.getHeight() + this.maxTextSize.getOverline()) / 2.0d)), this.legend.getActualTextPaint(contextProvider));
            horizontalTextIndent = i6;
            paddingLeft = i4;
            paddingTop = i5;
        }
    }

    private List<TextSize> measureItemsText(List<LegendItem> list) {
        Paint actualTextPaint = this.legend.getActualTextPaint(this.context);
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<LegendItem> it = list.iterator();
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        while (it.hasNext()) {
            TextSize textBounds = getTextBounds(actualTextPaint, it.next().getText());
            d = Math.max(d, textBounds.getWidth());
            d3 = Math.max(d3, textBounds.getUnderline());
            d2 = Math.max(d2, textBounds.getOverline());
            arrayList.add(textBounds);
        }
        this.maxTextSize = new TextSize(d, d2, d3);
        return arrayList;
    }

    private Rect updateAndMeasure(List<LegendItem> list, Size size) {
        int borderThickness = this.legend.getBorderThickness() * 2;
        int paddingTop = this.legend.getPaddingTop() + this.legend.getPaddingBottom() + borderThickness + getTopIndentFromDiagram() + getBottomIndentFromDiagram();
        int paddingLeft = this.legend.getPaddingLeft() + this.legend.getPaddingRight() + borderThickness + getLeftIndentFromDiagram() + getRightIndentFromDiagram();
        Size size2 = new Size(size.getWidth() - paddingLeft, size.getHeight() - paddingTop);
        if (list.size() == 0) {
            return this.layout;
        }
        this.info.clear();
        List<TextSize> measureItemsText = measureItemsText(list);
        int i = 0;
        LegendLayoutCalculator legendLayoutCalculator = new LegendLayoutCalculator(this.legend.getOrientation() == LegendOrientation.TOP_TO_BOTTOM, this.legend.getMarkerSize(), this.legend.getTextIndent(), this.legend.getItemsHorizontalIndent(), this.legend.getItemsVerticalIndent(), size2, measureItemsText);
        for (Point point : legendLayoutCalculator.getItemsLocations()) {
            LegendItemInfo legendItemInfo = new LegendItemInfo(measureItemsText.get(i), list.get(i));
            legendItemInfo.setOffsetX(point.x);
            legendItemInfo.setOffsetY(point.y);
            this.info.add(legendItemInfo);
            i++;
        }
        Size measurementSize = legendLayoutCalculator.getMeasurementSize();
        Rect rect = new Rect(this.layout.left, this.layout.top, this.layout.left + measurementSize.getWidth() + paddingLeft, this.layout.top + measurementSize.getHeight() + paddingTop);
        this.layout = rect;
        return rect;
    }

    private int getLeftIndentFromDiagram() {
        LegendHorizontalPosition horizontalPosition = this.legend.getHorizontalPosition();
        if (horizontalPosition == LegendHorizontalPosition.LEFT || horizontalPosition == LegendHorizontalPosition.RIGHT_OUTSIDE) {
            return this.legend.getLeftIndentFromDiagram();
        }
        return 0;
    }

    private int getRightIndentFromDiagram() {
        LegendHorizontalPosition horizontalPosition = this.legend.getHorizontalPosition();
        if (horizontalPosition == LegendHorizontalPosition.LEFT_OUTSIDE || horizontalPosition == LegendHorizontalPosition.RIGHT) {
            return this.legend.getRightIndentFromDiagram();
        }
        return 0;
    }

    private int getTopIndentFromDiagram() {
        LegendVerticalPosition verticalPosition = this.legend.getVerticalPosition();
        if (verticalPosition == LegendVerticalPosition.TOP || verticalPosition == LegendVerticalPosition.BOTTOM_OUTSIDE) {
            return this.legend.getTopIndentFromDiagram();
        }
        return 0;
    }

    private int getBottomIndentFromDiagram() {
        LegendVerticalPosition verticalPosition = this.legend.getVerticalPosition();
        if (verticalPosition == LegendVerticalPosition.TOP_OUTSIDE || verticalPosition == LegendVerticalPosition.BOTTOM) {
            return this.legend.getBottomIndentFromDiagram();
        }
        return 0;
    }

    private boolean isValidLegendLayout() {
        return this.layout.width() > 0 && this.layout.height() > 0 && this.layout.left >= 0 && this.layout.top >= 0;
    }

    @Override // com.devexpress.dxcharts.OverlayDrawableInterface
    public void draw(Canvas canvas, ContextProvider contextProvider) {
        synchronized (this) {
            if (isValidLegendLayout()) {
                drawLegendBorder(canvas);
                drawLegendItems(canvas, contextProvider);
            }
        }
    }

    @Override // com.devexpress.dxcharts.OverlayDrawableInterface
    public boolean canDraw() {
        return getLegendVisibility();
    }

    int[] getSize(Object[] objArr, int i, int i2) {
        int[] iArr;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < objArr.length; i3 += 2) {
                String str = (String) objArr[i3];
                Object obj = objArr[i3 + 1];
                arrayList.add(new LegendItem(str, ((int[]) obj)[0], ((int[]) obj)[1], ((int[]) obj)[2], ((int[]) obj)[3]));
            }
            if ((this.legend.getVerticalPosition() == LegendVerticalPosition.TOP_OUTSIDE || this.legend.getVerticalPosition() == LegendVerticalPosition.BOTTOM_OUTSIDE) && this.legend.getHorizontalPosition() != LegendHorizontalPosition.CENTER) {
                i2 /= 2;
            }
            if ((this.legend.getHorizontalPosition() == LegendHorizontalPosition.LEFT_OUTSIDE || this.legend.getHorizontalPosition() == LegendHorizontalPosition.RIGHT_OUTSIDE) && this.legend.getVerticalPosition() != LegendVerticalPosition.CENTER) {
                i /= 2;
            }
            Rect updateAndMeasure = updateAndMeasure(arrayList, new Size(i, i2));
            iArr = new int[]{updateAndMeasure.width(), updateAndMeasure.height()};
        }
        return iArr;
    }

    void updateBounds(int[] iArr) {
        Rect rect = new Rect(iArr[0], iArr[1], iArr[2], iArr[3]);
        synchronized (this) {
            if (rect.width() == this.layout.width()) {
                rect.height();
                this.layout.height();
            }
            this.layout.set(rect);
            notifyListeners(null);
        }
    }

    HitTestInfoBase hitTest(PointF pointF) {
        for (LegendHitTestInfo legendHitTestInfo : this.hitTestInfos) {
            if (legendHitTestInfo.hitTest(pointF)) {
                return legendHitTestInfo;
            }
        }
        if (this.layout.contains((int) pointF.x, (int) pointF.y)) {
            return new LegendHitTestInfo(new RectF(this.layout), -1, -1);
        }
        return null;
    }

    Legend getLegend() {
        return this.legend;
    }

    void setLegend(Legend legend) {
        Legend legend2 = this.legend;
        if (legend2 != legend) {
            if (legend2 != null) {
                legend2.removeListener(getSelfListener());
            }
            this.legend = legend;
            if (legend != null) {
                legend.applyCurrentTheme(this.context, new Object[0]);
                this.legend.addListener(getSelfListener());
            }
        }
    }

    int getLegendHorizontalPosition() {
        Legend legend = this.legend;
        return legend != null ? legend.getHorizontalPosition().ordinal() : Legend.DEFAULT_HORIZONTAL_POSITION.ordinal();
    }

    int getLegendVerticalPosition() {
        Legend legend = this.legend;
        return legend != null ? legend.getVerticalPosition().ordinal() : Legend.DEFAULT_VERTICAL_POSITION.ordinal();
    }

    void applyTheme(ContextProvider contextProvider) {
        Legend legend = this.legend;
        if (legend != null) {
            legend.applyCurrentTheme(contextProvider, new Object[0]);
        }
    }
}
