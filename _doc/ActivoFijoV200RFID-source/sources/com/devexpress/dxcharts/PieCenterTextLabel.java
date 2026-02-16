package com.devexpress.dxcharts;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.camera.video.AudioStats;

/* loaded from: classes.dex */
public class PieCenterTextLabel extends PieCenterLabel {
    private boolean autoSizeText;
    private float contentRatio;
    private final boolean defaultAutoSizeText;
    private final String defaultTextPattern;
    private final float defaultTextScale;
    private TextPaint paint;
    private PatternParser patternParser;
    private String textPattern;

    private double getTotalValue(PieSeries pieSeries) {
        PieSeriesData data = pieSeries.getData();
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (data != null) {
            int dataCount = data.getDataCount();
            for (int i = 0; i < dataCount; i++) {
                d += data.getValue(i);
            }
        }
        return d;
    }

    @Override // com.devexpress.dxcharts.PieCenterLabel, com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(PieCenterTextLabelStyle.class);
    }

    @Override // com.devexpress.dxcharts.PieCenterLabel
    protected void draw(Canvas canvas, Rect rect, Rect rect2, PieSeries pieSeries) {
        ContextProvider context = getContext();
        Paint actualTextStylePaint = ((PieCenterTextLabelStyle) getActualStyleFromContainer(PieCenterTextLabelStyle.class, context, new Object[0])).getActualTextStylePaint(context, new Object[0]);
        if (actualTextStylePaint != null) {
            this.paint.set(actualTextStylePaint);
            if (!rect2.isEmpty()) {
                rect = rect2;
            }
            Rect rect3 = new Rect(rect);
            String parsePieCenterLabelText = this.patternParser.parsePieCenterLabelText(this.textPattern, pieSeries.getDisplayName(), getTotalValue(pieSeries));
            Layout createTextLayout = createTextLayout(parsePieCenterLabelText, Integer.MAX_VALUE);
            int i = 0;
            for (int i2 = 0; i2 < createTextLayout.getLineCount(); i2++) {
                i = (int) Math.max(createTextLayout.getLineWidth(i2), i);
            }
            if (this.contentRatio > 0.0f && this.autoSizeText) {
                TextPaint textPaint = this.paint;
                textPaint.setTextSize((textPaint.getTextSize() * (rect3.width() * this.contentRatio)) / Math.max(i, createTextLayout.getHeight()));
                i = rect3.width();
            }
            Layout createTextLayout2 = createTextLayout(parsePieCenterLabelText, Integer.valueOf(i));
            canvas.translate(rect3.left + ((rect3.width() - createTextLayout2.getWidth()) / 2), rect3.top + ((rect3.height() - createTextLayout2.getHeight()) / 2));
            createTextLayout2.draw(canvas);
        }
    }

    private Layout createTextLayout(String str, Integer num) {
        return StaticLayout.Builder.obtain(str, 0, str.length(), this.paint, num.intValue()).setAlignment(Layout.Alignment.ALIGN_CENTER).build();
    }

    public PieCenterTextLabel() {
        this.defaultTextScale = 0.7f;
        this.defaultTextPattern = "{S}\n{TV}";
        this.defaultAutoSizeText = true;
        this.textPattern = "{S}\n{TV}";
        this.contentRatio = 0.7f;
        this.autoSizeText = true;
        this.patternParser = new PatternParser();
        this.paint = new TextPaint();
    }

    public PieCenterTextLabel(String str) {
        this.defaultTextScale = 0.7f;
        this.defaultTextPattern = "{S}\n{TV}";
        this.defaultAutoSizeText = true;
        this.textPattern = "{S}\n{TV}";
        this.contentRatio = 0.7f;
        this.autoSizeText = true;
        this.patternParser = new PatternParser();
        this.paint = new TextPaint();
        this.textPattern = str;
    }

    public String getTextPattern() {
        return this.textPattern;
    }

    public void setTextPattern(String str) {
        if (this.textPattern.equals(str)) {
            return;
        }
        this.textPattern = str;
        invalidate();
    }

    public float getContentRatio() {
        return this.contentRatio;
    }

    public void setContentRatio(float f) {
        if (this.contentRatio != f) {
            this.contentRatio = f;
            invalidate();
        }
    }

    public boolean getAutoSizeText() {
        return this.autoSizeText;
    }

    public void setAutoSizeText(boolean z) {
        if (this.autoSizeText != z) {
            this.autoSizeText = z;
            invalidate();
        }
    }

    public PieCenterTextLabelStyle getStyle() {
        return (PieCenterTextLabelStyle) getUserStyleFromContainer(PieCenterTextLabelStyle.class);
    }

    public void setStyle(PieCenterTextLabelStyle pieCenterTextLabelStyle) {
        if (trySetStyle(pieCenterTextLabelStyle)) {
            invalidate();
        }
    }
}
