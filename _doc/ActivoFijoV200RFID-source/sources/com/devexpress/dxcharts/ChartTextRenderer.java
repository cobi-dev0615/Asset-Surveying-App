package com.devexpress.dxcharts;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.SuperscriptSpan;
import java.util.ArrayList;

/* loaded from: classes.dex */
class ChartTextRenderer {
    private Bitmap bitmap;
    private Paint paint;
    private final TextStyleProviderInterface textStyleProvider;
    private int textureWidth = 0;
    private int textureHeight = 0;
    private final ArrayList<Rect> rects = new ArrayList<>();
    private final ArrayList<Matrix> matrices = new ArrayList<>();
    private final TextFormatter textFormatter = new TextFormatter();
    private final Canvas canvas = new Canvas();

    ChartTextRenderer(ContextProvider contextProvider, TextStyleProviderInterface textStyleProviderInterface) {
        this.textStyleProvider = textStyleProviderInterface;
        initPaint();
    }

    private void recycleOverlayBitmap() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    private void initPaint() {
        Paint paint = new Paint(1);
        this.paint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.paint.setColor(0);
    }

    private void render(Canvas canvas, Object[] objArr, long[] jArr, float[] fArr) {
        for (int i = 0; i < this.matrices.size(); i++) {
            Rect rect = this.rects.get(i);
            canvas.save();
            canvas.setMatrix(this.matrices.get(i));
            canvas.drawRect(rect, this.paint);
            canvas.restore();
        }
        this.rects.clear();
        this.matrices.clear();
        int i2 = ((int[]) objArr[objArr.length - 1])[0];
        int i3 = ((int[]) objArr[objArr.length - 1])[1];
        int i4 = ((int[]) objArr[objArr.length - 1])[2];
        int i5 = ((int[]) objArr[objArr.length - 1])[3];
        int i6 = ((int[]) objArr[objArr.length - 1])[4];
        int i7 = ((int[]) objArr[objArr.length - 1])[5];
        int saveCount = canvas.getSaveCount();
        Paint paint = null;
        long j = -255;
        int i8 = 0;
        for (int i9 = 2; i8 < objArr.length / i9; i9 = 2) {
            if (i2 >= 0 && i3 >= 0) {
                if (i8 == i2) {
                    canvas.save();
                    canvas.clipRect(i4, i5, i6, i7);
                }
                if (i8 == i3 + 1) {
                    canvas.restore();
                }
            }
            int i10 = i5;
            long j2 = jArr[i8];
            if (j != j2) {
                paint = getTextPaintByStyleID(j2);
                j = j2;
            }
            int i11 = i8 * 2;
            int[] iArr = (int[]) objArr[i11];
            int i12 = iArr[0];
            int i13 = iArr[1];
            String str = (String) objArr[i11 + 1];
            int i14 = i2;
            String[] split = str.split("\n");
            int i15 = i4;
            int i16 = i6;
            int i17 = i7;
            int i18 = 0;
            int i19 = 0;
            for (int length = split.length; i18 < length; length = length) {
                i19 = Math.max(i19, (int) paint.measureText(split[i18]));
                i18++;
            }
            SpannableString spannableString = new SpannableString(str);
            if (i12 != -1) {
                int i20 = i13 + i12;
                spannableString.setSpan(new AbsoluteSizeSpan((int) (paint.getTextSize() * 0.8f)), i12, i20, 33);
                spannableString.setSpan(new SuperscriptSpan(), i12, i20, 33);
            }
            StaticLayout createTextLayout = TextHelper.createTextLayout(spannableString, Integer.valueOf(i19), paint);
            canvas.save();
            Matrix matrix = new Matrix();
            float[] fArr2 = new float[9];
            System.arraycopy(fArr, i8 * 9, fArr2, 0, 9);
            matrix.setValues(fArr2);
            canvas.setMatrix(matrix);
            createTextLayout.draw(canvas);
            canvas.restore();
            this.rects.add(new Rect(0, 0, i19, createTextLayout.getHeight()));
            this.matrices.add(matrix);
            i8++;
            paint = paint;
            i5 = i10;
            i2 = i14;
            i4 = i15;
            i6 = i16;
            i7 = i17;
        }
        if (i3 != ((objArr.length - 1) / 2) - 1 || canvas.getSaveCount() <= saveCount) {
            return;
        }
        canvas.restore();
    }

    private Paint getTextPaintByStyleID(long j) {
        return this.textStyleProvider.getTextStylePaint(j);
    }

    int[] measureText(String[] strArr, int[] iArr, long j) {
        int[] iArr2 = new int[strArr.length * 4];
        TextPaint textPaint = new TextPaint(getTextPaintByStyleID(j));
        for (int i = 0; i < strArr.length; i++) {
            int i2 = i * 4;
            int i3 = i * 2;
            Rect measureMultilineText = TextHelper.measureMultilineText(strArr[i], iArr[i3], iArr[i3 + 1], textPaint);
            iArr2[i2] = measureMultilineText.left;
            iArr2[i2 + 1] = measureMultilineText.top;
            iArr2[i2 + 2] = measureMultilineText.right;
            iArr2[i2 + 3] = measureMultilineText.bottom;
        }
        return iArr2;
    }

    private int[] measureText(String str, long j) {
        Rect measureMultilineText = TextHelper.measureMultilineText(str, -1, -1, new TextPaint(getTextPaintByStyleID(j)));
        return new int[]{measureMultilineText.left, measureMultilineText.top, measureMultilineText.right, measureMultilineText.bottom};
    }

    String getDefaultDateFormat() {
        return this.textFormatter.getDefaultDateFormat();
    }

    String formatValue(Object obj, int i, String str) {
        return this.textFormatter.formatValue(obj, i, str);
    }

    String[] formatValues(Object[] objArr, int i, String str) {
        return this.textFormatter.formatValues(objArr, i, str);
    }

    Bitmap createBitmap(int i, int i2) {
        try {
            if (this.textureWidth != i || this.textureHeight != i2) {
                this.canvas.setBitmap(null);
                recycleOverlayBitmap();
                this.textureWidth = i;
                this.textureHeight = i2;
                Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.bitmap = createBitmap;
                this.canvas.setBitmap(createBitmap);
                this.canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            }
            return this.bitmap;
        } catch (Error e) {
            UIHandler.reThrow(e);
            return null;
        }
    }

    void updateOverlay(Object[] objArr, long[] jArr, float[] fArr) {
        if (this.bitmap != null) {
            render(this.canvas, objArr, jArr, fArr);
        }
    }
}
