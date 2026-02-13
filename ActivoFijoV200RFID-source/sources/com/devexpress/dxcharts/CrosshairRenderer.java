package com.devexpress.dxcharts;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: OverlayInfo.java */
/* loaded from: classes.dex */
class CrosshairRenderer {
    static final int TTP_BOTTOM_CENTER = 7;
    static final int TTP_BOTTOM_LEFT = 8;
    static final int TTP_BOTTOM_RIGHT = 6;
    static final int TTP_LEFT_BOTTOM = 9;
    static final int TTP_LEFT_CENTER = 10;
    static final int TTP_LEFT_TOP = 11;
    static final int TTP_NO_TILE = 12;
    static final int TTP_RIGHT_BOTTOM = 5;
    static final int TTP_RIGHT_CENTER = 4;
    static final int TTP_RIGHT_TOP = 3;
    static final int TTP_TOP_CENTER = 1;
    static final int TTP_TOP_LEFT = 0;
    static final int TTP_TOP_RIGHT = 2;
    private ContextProvider context;
    private HintContainer owner;
    private int screenDensity;
    private Rect layoutRect = new Rect();
    private ArrayList<CrosshairItem> crosshairItems = new ArrayList<>();
    private boolean isMarker = false;
    private Paint markerPaint = new Paint();
    private int itemsWidth = 0;

    /* compiled from: OverlayInfo.java */
    class CrosshairItem {
        Rect bounds;
        TooltipItem item;
        int offsetY;

        CrosshairItem(TooltipItem tooltipItem, Rect rect, int i) {
            this.item = tooltipItem;
            this.bounds = rect;
            this.offsetY = i;
        }

        TooltipItem getTooltipItem() {
            return this.item;
        }

        Rect getBounds() {
            return this.bounds;
        }

        public int getOffsetY() {
            return this.offsetY;
        }
    }

    CrosshairRenderer(HintContainer hintContainer, ContextProvider contextProvider) {
        this.owner = hintContainer;
        this.context = contextProvider;
        this.screenDensity = (int) contextProvider.getResources().getDisplayMetrics().density;
    }

    public Rect measure(TooltipItem[] tooltipItemArr) {
        int i;
        int i2;
        this.crosshairItems.clear();
        HintBase actualHint = this.owner.getActualHint();
        int borderThickness = actualHint.getBorderThickness(this.context);
        int markerSize = actualHint.getMarkerSize(this.context);
        Paint actualTextPaint = actualHint.getActualTextPaint(this.context);
        this.isMarker = false;
        this.itemsWidth = 0;
        if (tooltipItemArr.length > 0) {
            int i3 = 0;
            int i4 = 0;
            for (TooltipItem tooltipItem : tooltipItemArr) {
                Rect measureMultilineText = TextHelper.measureMultilineText(tooltipItem.getText(), -1, -1, new TextPaint(actualTextPaint));
                int height = measureMultilineText.height();
                int width = measureMultilineText.width();
                if (tooltipItem.getShowMarker()) {
                    height = Math.max(height, markerSize);
                    width += actualHint.getTextIndent(this.context) + markerSize;
                    this.isMarker = true;
                }
                this.crosshairItems.add(new CrosshairItem(tooltipItem, measureMultilineText, i4));
                i4 += height + actualHint.getItemsIndent(this.context);
                i3 = Math.max(i3, width);
            }
            this.itemsWidth = i3;
            int i5 = borderThickness * 2;
            i2 = i4 + (i5 - actualHint.getItemsIndent(this.context)) + actualHint.getPaddingBottom(this.context) + actualHint.getPaddingTop(this.context);
            i = i3 + i5 + actualHint.getPaddingLeft(this.context) + actualHint.getPaddingRight(this.context);
        } else {
            i = 0;
            i2 = 0;
        }
        Rect rect = new Rect(0, 0, i, i2);
        this.layoutRect = rect;
        return rect;
    }

    public void draw(Canvas canvas, ContextProvider contextProvider, OverlayInfo overlayInfo) {
        synchronized (this) {
            PointF anchorPoint = overlayInfo.getAnchorPoint();
            Rect rect = new Rect(this.layoutRect);
            rect.offset((int) anchorPoint.x, (int) anchorPoint.y);
            HintBase actualHint = this.owner.getActualHint();
            Paint actualTextPaint = actualHint.getActualTextPaint(contextProvider);
            drawPopupBackground(canvas, rect, overlayInfo.getTailPosition(), actualHint.getCornerRadius(contextProvider), actualHint.getBorderThickness(contextProvider), actualHint.getTailRect(contextProvider), actualHint.getBackgroundColor(contextProvider));
            int markerSize = this.isMarker ? actualHint.getMarkerSize(contextProvider) + actualHint.getTextIndent(contextProvider) : 0;
            int markerSize2 = actualHint.getMarkerSize(contextProvider);
            int tailPosition = overlayInfo.getTailPosition();
            Rect tailRect = this.owner.getActualHint().getTailRect(contextProvider);
            rect.offset(actualHint.getBorderThickness(contextProvider) + actualHint.getPaddingLeft(contextProvider) + getLeftOffsetForTail(tailPosition, tailRect), actualHint.getBorderThickness(contextProvider) + actualHint.getPaddingTop(contextProvider) + getTopOffsetForTail(tailPosition, tailRect));
            Iterator<CrosshairItem> it = this.crosshairItems.iterator();
            while (it.hasNext()) {
                CrosshairItem next = it.next();
                TooltipItem tooltipItem = next.getTooltipItem();
                Rect bounds = next.getBounds();
                int i = rect.left;
                int offsetY = rect.top + next.getOffsetY();
                if (tooltipItem.isAlignmentByCenter()) {
                    i += ((this.itemsWidth - bounds.width()) / 2) - markerSize;
                }
                if (tooltipItem.getShowMarker()) {
                    drawMarker(new RectF(i, offsetY, i + markerSize2, offsetY + markerSize2), tooltipItem.getMarkerColor(), tooltipItem.getMarkerColor2(), canvas);
                    offsetY += bounds.height() < markerSize2 ? (bounds.top + markerSize2) / 2 : 0;
                }
                TextHelper.drawMultilineText(tooltipItem.getText(), i + markerSize, offsetY, actualTextPaint, canvas);
            }
        }
    }

    private void drawMarker(RectF rectF, int i, int i2, Canvas canvas) {
        this.markerPaint.setColor(i);
        if (i2 != i) {
            canvas.drawArc(rectF, 135.0f, 180.0f, true, this.markerPaint);
            this.markerPaint.setColor(i2);
            canvas.drawArc(rectF, -45.0f, 180.0f, true, this.markerPaint);
            return;
        }
        canvas.drawOval(rectF, this.markerPaint);
    }

    static void drawPopupBackground(Canvas canvas, Rect rect, int i, float f, float f2, Rect rect2, int i2) {
        Path path = new Path();
        path.moveTo((rect.right - f2) + getLeftOffsetForTail(i, rect2), rect.top + f + f2 + getTopOffsetForTail(i, rect2));
        float f3 = -f;
        path.rQuadTo(0.0f, f3, f3, f3);
        if (i == 1) {
            path.rLineTo(-((((rect.width() / 2.0f) - f) - f2) - (rect2.width() / 2.0f)), 0.0f);
            path.rLineTo((-rect2.width()) / 2.0f, -rect2.height());
            path.rLineTo((-rect2.width()) / 2.0f, rect2.height());
            path.rLineTo(-((((rect.width() / 2.0f) - f) - f2) - (rect2.width() / 2.0f)), 0.0f);
        } else if (i == 0) {
            path.rLineTo(-(((rect.width() - (f * 2.0f)) - (f2 * 2.0f)) - rect2.width()), 0.0f);
            path.rLineTo((-rect2.width()) / 2.0f, -rect2.height());
            path.rLineTo((-rect2.width()) / 2.0f, rect2.height());
        } else if (i == 2) {
            path.rLineTo((-rect2.width()) / 2.0f, -rect2.height());
            path.rLineTo((-rect2.width()) / 2.0f, rect2.height());
            path.rLineTo(-(((rect.width() - (f * 2.0f)) - (f2 * 2.0f)) - rect2.width()), 0.0f);
        } else {
            path.rLineTo(-((rect.width() - (f * 2.0f)) - (f2 * 2.0f)), 0.0f);
        }
        path.rQuadTo(f3, 0.0f, f3, f);
        if (i == 10) {
            path.rLineTo(0.0f, (((rect.height() / 2.0f) - f) - f2) - (rect2.width() / 2.0f));
            path.rLineTo(-rect2.height(), rect2.width() / 2.0f);
            path.rLineTo(rect2.height(), rect2.width() / 2.0f);
            path.rLineTo(0.0f, (((rect.height() / 2.0f) - f) - f2) - (rect2.width() / 2.0f));
        } else if (i == 11) {
            path.rLineTo(-rect2.height(), rect2.width() / 2.0f);
            path.rLineTo(rect2.height(), rect2.width() / 2.0f);
            path.rLineTo(0.0f, ((rect.height() - (f * 2.0f)) - (f2 * 2.0f)) - rect2.width());
        } else if (i == 9) {
            path.rLineTo(0.0f, ((rect.height() - (f * 2.0f)) - (f2 * 2.0f)) - rect2.width());
            path.rLineTo(-rect2.height(), rect2.width() / 2.0f);
            path.rLineTo(rect2.height(), rect2.width() / 2.0f);
        } else {
            path.rLineTo(0.0f, (rect.height() - (f * 2.0f)) - (f2 * 2.0f));
        }
        path.rQuadTo(0.0f, f, f, f);
        if (i == 7) {
            path.rLineTo((((rect.width() / 2.0f) - f) - f2) - (rect2.width() / 2.0f), 0.0f);
            path.rLineTo(rect2.width() / 2.0f, rect2.height());
            path.rLineTo(rect2.width() / 2.0f, -rect2.height());
            path.rLineTo((((rect.width() / 2.0f) - f) - f2) - (rect2.width() / 2.0f), 0.0f);
        } else if (i == 8) {
            path.rLineTo(rect2.width() / 2.0f, rect2.height());
            path.rLineTo(rect2.width() / 2.0f, -rect2.height());
            path.rLineTo(((rect.width() - (f * 2.0f)) - (f2 * 2.0f)) - rect2.width(), 0.0f);
        } else if (i == 6) {
            path.rLineTo(((rect.width() - (f * 2.0f)) - (f2 * 2.0f)) - rect2.width(), 0.0f);
            path.rLineTo(rect2.width() / 2.0f, rect2.height());
            path.rLineTo(rect2.width() / 2.0f, -rect2.height());
        } else {
            path.rLineTo((rect.width() - (f * 2.0f)) - (f2 * 2.0f), 0.0f);
        }
        path.rQuadTo(f, 0.0f, f, f3);
        if (i == 4) {
            path.rLineTo(0.0f, -((((rect.height() / 2.0f) - f) - f2) - (rect2.width() / 2.0f)));
            path.rLineTo(rect2.height(), (-rect2.width()) / 2.0f);
            path.rLineTo(-rect2.height(), (-rect2.width()) / 2.0f);
            path.rLineTo(0.0f, -((((rect.height() / 2.0f) - f) - f2) - (rect2.width() / 2.0f)));
        } else if (i == 3) {
            path.rLineTo(0.0f, -(((rect.height() - (f * 2.0f)) - (f2 * 2.0f)) - rect2.width()));
            path.rLineTo(rect2.height(), (-rect2.width()) / 2.0f);
            path.rLineTo(-rect2.height(), (-rect2.width()) / 2.0f);
        } else if (i == 5) {
            path.rLineTo(rect2.height(), (-rect2.width()) / 2.0f);
            path.rLineTo(-rect2.height(), (-rect2.width()) / 2.0f);
            path.rLineTo(0.0f, -(((rect.height() - (f * 2.0f)) - (f2 * 2.0f)) - rect2.width()));
        } else {
            path.rLineTo(0.0f, -((rect.height() - (f * 2.0f)) - (f2 * 2.0f)));
        }
        path.close();
        Paint paint = new Paint(1);
        paint.setColor(i2);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);
    }

    static int getBottomOffsetForTail(int i, Rect rect) {
        if (i < 6 || i > 8) {
            return 0;
        }
        return rect.height();
    }

    static int getLeftOffsetForTail(int i, Rect rect) {
        if (i < 9 || i > 11) {
            return 0;
        }
        return rect.height();
    }

    static int getTopOffsetForTail(int i, Rect rect) {
        if (i < 0 || i > 2) {
            return 0;
        }
        return rect.height();
    }

    static int getRightOffsetForTail(int i, Rect rect) {
        if (i < 3 || i > 5) {
            return 0;
        }
        return rect.height();
    }
}
