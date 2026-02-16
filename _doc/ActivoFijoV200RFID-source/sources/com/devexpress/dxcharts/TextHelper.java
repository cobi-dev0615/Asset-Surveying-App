package com.devexpress.dxcharts;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.SuperscriptSpan;

/* compiled from: ChartTextRenderer.java */
/* loaded from: classes.dex */
class TextHelper {
    TextHelper() {
    }

    public static StaticLayout createTextLayout(SpannableString spannableString, Integer num, Paint paint) {
        return StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), new TextPaint(paint), num.intValue()).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(true).build();
    }

    public static Rect measureMultilineText(String str, int i, int i2, TextPaint textPaint) {
        String[] split = str.split("\n");
        SpannableString spannableString = new SpannableString(str);
        if (i != -1) {
            spannableString.setSpan(new SuperscriptSpan(), i, i2 + i, 34);
        }
        int i3 = 0;
        for (String str2 : split) {
            i3 = Math.max(i3, (int) textPaint.measureText(str2));
        }
        return new Rect(0, 0, i3, createTextLayout(spannableString, Integer.valueOf(i3), textPaint).getHeight());
    }

    public static void drawMultilineText(String str, int i, int i2, Paint paint, Canvas canvas) {
        int fontSpacing = (int) paint.getFontSpacing();
        String[] split = str.split("\n");
        int i3 = 0;
        for (int i4 = 0; i4 < split.length; i4++) {
            String replaceAll = split[i4].replaceAll("\n", "");
            if (i4 == 0) {
                Rect rect = new Rect();
                paint.getTextBounds(replaceAll, 0, replaceAll.length(), rect);
                i3 = -rect.top;
            }
            canvas.drawText(replaceAll, i, i2 + i3, paint);
            i3 += fontSpacing;
        }
    }
}
