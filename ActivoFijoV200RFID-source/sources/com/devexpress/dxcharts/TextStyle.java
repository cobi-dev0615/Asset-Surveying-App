package com.devexpress.dxcharts;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.TypedValue;
import java.util.Locale;

/* loaded from: classes.dex */
public class TextStyle extends StyleBase {
    private static final int ARGS_ATTR_COLOR_ID = 0;
    private static final int ARGS_ATTR_SIZE_ID = 1;
    private Integer color;
    private String fontFeatureSettings;
    private Float letterSpacing;
    private Locale locale;
    private Integer paintFlags;
    private Float scaleX;
    private Integer shadowColor;
    private Float shadowDx;
    private Float shadowDy;
    private Float shadowRadius;
    private Float size;
    private Float skewX;
    private Typeface typeface;

    enum TextStyleProperty {
        SIZE,
        COLOR,
        LOCALE,
        SCALE_X,
        TYPEFACE,
        FONT_FEATURE_SETTINGS,
        LETTER_SPACING,
        SKEW_X,
        PAINT_FLAGS,
        SHADOW_LAYER
    }

    @Override // com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        super.initDefaultStyle(contextProvider, objArr);
        Paint paint = new Paint(1);
        this.size = Float.valueOf(getSizeFromResources(contextProvider, objArr));
        this.color = Integer.valueOf(getColorFromResources(contextProvider, objArr));
        this.shadowColor = 0;
        Float valueOf = Float.valueOf(0.0f);
        this.shadowDx = valueOf;
        this.shadowDy = valueOf;
        this.shadowRadius = valueOf;
        this.scaleX = Float.valueOf(paint.getTextScaleX());
        this.skewX = Float.valueOf(paint.getTextSkewX());
        this.paintFlags = Integer.valueOf(paint.getFlags());
        this.letterSpacing = Float.valueOf(paint.getLetterSpacing());
        this.fontFeatureSettings = paint.getFontFeatureSettings();
        this.locale = paint.getTextLocale();
        this.typeface = paint.getTypeface();
    }

    private float getSizeFromResources(ContextProvider contextProvider, Object... objArr) {
        int i;
        if (objArr != null && objArr.length > 1) {
            Object obj = objArr[1];
            if (obj instanceof Integer) {
                i = ((Integer) obj).intValue();
                return ResourceHelper.getDimensionOrDefault(contextProvider, i);
            }
        }
        i = R.attr.dxChartTextSize;
        return ResourceHelper.getDimensionOrDefault(contextProvider, i);
    }

    private int getColorFromResources(ContextProvider contextProvider, Object... objArr) {
        int i;
        if (objArr != null && objArr.length > 0) {
            Object obj = objArr[0];
            if (obj instanceof Integer) {
                i = ((Integer) obj).intValue();
                return ResourceHelper.getColorOrDefault(contextProvider, i);
            }
        }
        i = R.attr.dxChartTextColor;
        return ResourceHelper.getColorOrDefault(contextProvider, i);
    }

    Paint createTextPaint(ContextProvider contextProvider) {
        Paint paint = new Paint(1);
        Float f = this.size;
        paint.setTextSize(f == null ? getSizeFromResources(contextProvider, new Object[0]) : f.floatValue());
        Integer num = this.color;
        paint.setColor(num == null ? getColorFromResources(contextProvider, new Object[0]) : num.intValue());
        Locale locale = this.locale;
        if (locale != null) {
            paint.setTextLocale(locale);
        }
        Float f2 = this.scaleX;
        if (f2 != null) {
            paint.setTextScaleX(f2.floatValue());
        }
        Float f3 = this.letterSpacing;
        paint.setLetterSpacing(f3 != null ? f3.floatValue() : 0.0f);
        paint.setFontFeatureSettings(this.fontFeatureSettings);
        paint.setTypeface(this.typeface);
        Float f4 = this.skewX;
        paint.setTextSkewX(f4 != null ? f4.floatValue() : 0.0f);
        Integer num2 = this.paintFlags;
        paint.setFlags(num2 != null ? num2.intValue() : 0);
        Float f5 = this.shadowRadius;
        float floatValue = f5 != null ? f5.floatValue() : 0.0f;
        Float f6 = this.shadowDx;
        float floatValue2 = f6 != null ? f6.floatValue() : 0.0f;
        Float f7 = this.shadowDy;
        float floatValue3 = f7 != null ? f7.floatValue() : 0.0f;
        Integer num3 = this.shadowColor;
        paint.setShadowLayer(floatValue, floatValue2, floatValue3, num3 != null ? num3.intValue() : 0);
        return paint;
    }

    float getScaledSize() {
        return this.size.floatValue() / Resources.getSystem().getDisplayMetrics().density;
    }

    public Float getSize() {
        return this.size;
    }

    public void setSize(int i, Float f) {
        setSize(Float.valueOf(TypedValue.applyDimension(i, f.floatValue(), Resources.getSystem().getDisplayMetrics())));
    }

    public void setSize(Float f) {
        if (CompareHelper.areNotEquals(this.size, f)) {
            this.size = f;
            notifyListeners(TextStyleProperty.SIZE);
        }
    }

    public Integer getColor() {
        return this.color;
    }

    public void setColor(Integer num) {
        if (CompareHelper.areNotEquals(this.color, num)) {
            this.color = num;
            notifyListeners(TextStyleProperty.COLOR);
        }
    }

    public Locale getLocale() {
        return this.locale;
    }

    public void setLocale(Locale locale) {
        if (this.locale != locale) {
            this.locale = locale;
            notifyListeners(TextStyleProperty.LOCALE);
        }
    }

    public Float getScaleX() {
        return this.scaleX;
    }

    public void setScaleX(Float f) {
        if (CompareHelper.areNotEquals(this.scaleX, f)) {
            this.scaleX = f;
            notifyListeners(TextStyleProperty.SCALE_X);
        }
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public void setTypeface(Typeface typeface) {
        if (this.typeface != typeface) {
            this.typeface = typeface;
            notifyListeners(TextStyleProperty.TYPEFACE);
        }
    }

    public String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    public void setFontFeatureSettings(String str) {
        if (CompareHelper.areNotEquals(this.fontFeatureSettings, str)) {
            this.fontFeatureSettings = str;
            notifyListeners(TextStyleProperty.FONT_FEATURE_SETTINGS);
        }
    }

    public Float getLetterSpacing() {
        return this.letterSpacing;
    }

    public void setLetterSpacing(Float f) {
        if (CompareHelper.areNotEquals(this.letterSpacing, f)) {
            this.letterSpacing = f;
            notifyListeners(TextStyleProperty.LETTER_SPACING);
        }
    }

    public Float getSkewX() {
        return this.skewX;
    }

    public void setSkewX(Float f) {
        if (CompareHelper.areNotEquals(this.skewX, f)) {
            this.skewX = f;
            notifyListeners(TextStyleProperty.SKEW_X);
        }
    }

    public Integer getPaintFlags() {
        return this.paintFlags;
    }

    public void setPaintFlags(Integer num) {
        if (CompareHelper.areNotEquals(this.paintFlags, num)) {
            this.paintFlags = num;
            notifyListeners(TextStyleProperty.PAINT_FLAGS);
        }
    }

    public Integer getShadowColor() {
        return this.shadowColor;
    }

    public Float getShadowDx() {
        return this.shadowDx;
    }

    public Float getShadowDy() {
        return this.shadowDy;
    }

    public Float getShadowRadius() {
        return this.shadowRadius;
    }

    public void setShadowLayer(Float f, Float f2, Float f3, Integer num) {
        if (CompareHelper.areNotEquals(this.shadowRadius, f) || CompareHelper.areNotEquals(this.shadowDx, f2) || CompareHelper.areNotEquals(this.shadowDy, f3) || CompareHelper.areNotEquals(this.shadowColor, num)) {
            this.shadowRadius = f;
            this.shadowDx = f2;
            this.shadowDy = f3;
            this.shadowColor = num;
            notifyListeners(TextStyleProperty.SHADOW_LAYER);
        }
    }
}
