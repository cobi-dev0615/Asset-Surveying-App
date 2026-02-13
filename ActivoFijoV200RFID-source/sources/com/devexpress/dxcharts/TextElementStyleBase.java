package com.devexpress.dxcharts;

import android.graphics.Paint;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class TextElementStyleBase extends StyleBase {
    private Paint superscriptTextPaint;
    private Paint textPaint;
    StyledElement textStyledElement;

    enum Property {
        TEXT_STYLE
    }

    public TextElementStyleBase() {
        StyledElement styledElement = new StyledElement() { // from class: com.devexpress.dxcharts.TextElementStyleBase.1
            @Override // com.devexpress.dxcharts.StyledElement
            StyleContainer<? extends StyleBase> createStyleContainer() {
                return new StyleContainer<>(TextStyle.class);
            }

            @Override // com.devexpress.dxcharts.StyledElement
            void applyCurrentTheme(boolean z, ContextProvider contextProvider, Object... objArr) {
                resetDefaultStyle();
            }

            @Override // com.devexpress.dxcharts.StyledElement, com.devexpress.dxcharts.ChartElement
            void onChartElementPropertyChanged(Object obj, PropertyChangedArgs propertyChangedArgs) {
                super.onChartElementPropertyChanged(obj, propertyChangedArgs);
                TextElementStyleBase.this.textPaint = null;
                notifyListeners(propertyChangedArgs.getProperty());
            }
        };
        this.textStyledElement = styledElement;
        styledElement.addListener(getSelfListener());
    }

    StyledElement getTextStyledElement() {
        return this.textStyledElement;
    }

    TextStyle getActualTextStyleInternal(ContextProvider contextProvider, Object... objArr) {
        return (TextStyle) this.textStyledElement.getActualStyleFromContainer(TextStyle.class, contextProvider, objArr);
    }

    TextStyle getDefaultTextStyleInternal(ContextProvider contextProvider, Object... objArr) {
        return (TextStyle) this.textStyledElement.getDefaultStyleFromContainer(TextStyle.class, contextProvider, objArr);
    }

    Paint getActualTextStylePaint(ContextProvider contextProvider, Object... objArr) {
        if (this.textPaint == null) {
            this.textPaint = createTextPaint(contextProvider, (TextStyle) this.textStyledElement.getDefaultStyleFromContainer(TextStyle.class, contextProvider, objArr), (TextStyle) this.textStyledElement.getUserStyleFromContainer(TextStyle.class));
        }
        return this.textPaint;
    }

    Paint getActualSuperscriptTextStylePaint(ContextProvider contextProvider, Object... objArr) {
        if (this.superscriptTextPaint == null) {
            Paint createTextPaint = createTextPaint(contextProvider, (TextStyle) this.textStyledElement.getDefaultStyleFromContainer(TextStyle.class, contextProvider, objArr), (TextStyle) this.textStyledElement.getUserStyleFromContainer(TextStyle.class));
            this.superscriptTextPaint = createTextPaint;
            createTextPaint.setTextSize(createTextPaint.getTextSize() * 0.8f);
        }
        return this.superscriptTextPaint;
    }

    private Paint createTextPaint(ContextProvider contextProvider, TextStyle textStyle, TextStyle textStyle2) {
        Paint paint = new Paint(1);
        if (textStyle2 == null || textStyle2.getTypeface() == null) {
            textStyle.getTypeface();
        } else {
            textStyle2.getTypeface();
        }
        paint.setTextSize(((textStyle2 == null || textStyle2.getSize() == null) ? textStyle.getSize() : textStyle2.getSize()).floatValue());
        paint.setColor(((textStyle2 == null || textStyle2.getColor() == null) ? textStyle.getColor() : textStyle2.getColor()).intValue());
        Locale locale = (textStyle2 == null || textStyle2.getLocale() == null) ? textStyle.getLocale() : textStyle2.getLocale();
        if (locale != null) {
            paint.setTextLocale(locale);
        }
        Float scaleX = (textStyle2 == null || textStyle2.getScaleX() == null) ? textStyle.getScaleX() : textStyle2.getScaleX();
        if (scaleX != null) {
            paint.setTextScaleX(scaleX.floatValue());
        }
        Float letterSpacing = (textStyle2 == null || textStyle2.getLetterSpacing() == null) ? textStyle.getLetterSpacing() : textStyle2.getLetterSpacing();
        paint.setLetterSpacing(letterSpacing != null ? letterSpacing.floatValue() : 0.0f);
        paint.setFontFeatureSettings((textStyle2 == null || textStyle2.getFontFeatureSettings() == null) ? textStyle.getFontFeatureSettings() : textStyle2.getFontFeatureSettings());
        paint.setTypeface((textStyle2 == null || textStyle2.getTypeface() == null) ? textStyle.getTypeface() : textStyle2.getTypeface());
        Float skewX = (textStyle2 == null || textStyle2.getSkewX() == null) ? textStyle.getSkewX() : textStyle2.getSkewX();
        paint.setTextSkewX(skewX != null ? skewX.floatValue() : 0.0f);
        Integer paintFlags = (textStyle2 == null || textStyle2.getPaintFlags() == null) ? textStyle.getPaintFlags() : textStyle2.getPaintFlags();
        paint.setFlags(paintFlags != null ? paintFlags.intValue() : 0);
        Float shadowRadius = (textStyle2 == null || textStyle2.getShadowRadius() == null) ? textStyle.getShadowRadius() : textStyle2.getShadowRadius();
        Float shadowDx = (textStyle2 == null || textStyle2.getShadowDx() == null) ? textStyle.getShadowDx() : textStyle2.getShadowDx();
        Float shadowDy = (textStyle2 == null || textStyle2.getShadowDy() == null) ? textStyle.getShadowDy() : textStyle2.getShadowDy();
        Integer shadowColor = (textStyle2 == null || textStyle2.getShadowColor() == null) ? textStyle.getShadowColor() : textStyle2.getShadowColor();
        paint.setShadowLayer(shadowRadius != null ? shadowRadius.floatValue() : 0.0f, shadowDx != null ? shadowDx.floatValue() : 0.0f, shadowDy != null ? shadowDy.floatValue() : 0.0f, shadowColor != null ? shadowColor.intValue() : 0);
        return paint;
    }

    public TextStyle getTextStyle() {
        return (TextStyle) this.textStyledElement.getUserStyleFromContainer(TextStyle.class);
    }

    public void setTextStyle(TextStyle textStyle) {
        if (this.textStyledElement.trySetStyle(textStyle)) {
            notifyListeners(Property.TEXT_STYLE);
            this.textPaint = null;
        }
    }
}
