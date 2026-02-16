package com.devexpress.dxcharts;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class HintBase extends StyledElement {
    private HintBehavior behavior;
    private boolean enabled = true;
    private HintShowMode showMode = HintShowMode.DEFAULT;

    enum Property {
        ENABLED,
        SHOW_MODE,
        BEHAVIOR
    }

    private TextStyle getDefaultTextStyle(ContextProvider contextProvider) {
        return ((HintStyleBase) getActualStyleFromContainer(HintStyleBase.class, contextProvider, new Object[0])).getDefaultTextStyleInternal(contextProvider, Integer.valueOf(R.attr.dxHintLabelTextColor));
    }

    private TextStyle getActualTextStyle(ContextProvider contextProvider) {
        return ((HintStyleBase) getActualStyleFromContainer(HintStyleBase.class, contextProvider, new Object[0])).getActualTextStyleInternal(contextProvider, Integer.valueOf(R.attr.dxHintLabelTextColor));
    }

    int getBackgroundColor(ContextProvider contextProvider) {
        HintStyleBase hintStyleBase = (HintStyleBase) getActualStyleFromContainer(HintStyleBase.class, contextProvider, new Object[0]);
        if (hintStyleBase.getBackgroundColor() == null) {
            hintStyleBase = (HintStyleBase) getDefaultStyleFromContainer(HintStyleBase.class);
        }
        return ColorHelper.convertToNativeColor(hintStyleBase.getBackgroundColor());
    }

    int getTextIndent(ContextProvider contextProvider) {
        HintStyleBase hintStyleBase = (HintStyleBase) getActualStyleFromContainer(HintStyleBase.class, contextProvider, new Object[0]);
        if (hintStyleBase.getTextIndent() == null) {
            hintStyleBase = (HintStyleBase) getDefaultStyleFromContainer(HintStyleBase.class);
        }
        return hintStyleBase.getTextIndent().intValue();
    }

    int getMarkerSize(ContextProvider contextProvider) {
        HintStyleBase hintStyleBase = (HintStyleBase) getActualStyleFromContainer(HintStyleBase.class, contextProvider, new Object[0]);
        if (hintStyleBase.getMarkerSize() == null) {
            hintStyleBase = (HintStyleBase) getDefaultStyleFromContainer(HintStyleBase.class);
        }
        return hintStyleBase.getMarkerSize().intValue();
    }

    int getPaddingLeft(ContextProvider contextProvider) {
        HintStyleBase hintStyleBase = (HintStyleBase) getActualStyleFromContainer(HintStyleBase.class, contextProvider, new Object[0]);
        if (hintStyleBase.getPaddingLeft() == null) {
            hintStyleBase = (HintStyleBase) getDefaultStyleFromContainer(HintStyleBase.class);
        }
        return hintStyleBase.getPaddingLeft().intValue();
    }

    int getPaddingTop(ContextProvider contextProvider) {
        HintStyleBase hintStyleBase = (HintStyleBase) getActualStyleFromContainer(HintStyleBase.class, contextProvider, new Object[0]);
        if (hintStyleBase.getPaddingTop() == null) {
            hintStyleBase = (HintStyleBase) getDefaultStyleFromContainer(HintStyleBase.class);
        }
        return hintStyleBase.getPaddingTop().intValue();
    }

    int getPaddingRight(ContextProvider contextProvider) {
        HintStyleBase hintStyleBase = (HintStyleBase) getActualStyleFromContainer(HintStyleBase.class, contextProvider, new Object[0]);
        if (hintStyleBase.getPaddingRight() == null) {
            hintStyleBase = (HintStyleBase) getDefaultStyleFromContainer(HintStyleBase.class);
        }
        return hintStyleBase.getPaddingRight().intValue();
    }

    int getPaddingBottom(ContextProvider contextProvider) {
        HintStyleBase hintStyleBase = (HintStyleBase) getActualStyleFromContainer(HintStyleBase.class, contextProvider, new Object[0]);
        if (hintStyleBase.getPaddingBottom() == null) {
            hintStyleBase = (HintStyleBase) getDefaultStyleFromContainer(HintStyleBase.class);
        }
        return hintStyleBase.getPaddingBottom().intValue();
    }

    int getItemsIndent(ContextProvider contextProvider) {
        HintStyleBase hintStyleBase = (HintStyleBase) getActualStyleFromContainer(HintStyleBase.class, contextProvider, new Object[0]);
        if (hintStyleBase.getItemsIndentInternal() == null) {
            hintStyleBase = (HintStyleBase) getDefaultStyleFromContainer(HintStyleBase.class);
        }
        return hintStyleBase.getItemsIndentInternal().intValue();
    }

    int getTextColor(ContextProvider contextProvider) {
        TextStyle actualTextStyle = getActualTextStyle(contextProvider);
        if (actualTextStyle.getColor() == null) {
            actualTextStyle = getDefaultTextStyle(contextProvider);
        }
        return ColorHelper.convertToNativeColor(actualTextStyle.getColor());
    }

    float getTextSize(ContextProvider contextProvider) {
        TextStyle actualTextStyle = getActualTextStyle(contextProvider);
        if (actualTextStyle.getSize() == null) {
            actualTextStyle = getDefaultTextStyle(contextProvider);
        }
        return actualTextStyle.getScaledSize();
    }

    Locale getTextLocale(ContextProvider contextProvider) {
        TextStyle actualTextStyle = getActualTextStyle(contextProvider);
        if (actualTextStyle.getLocale() == null) {
            actualTextStyle = getDefaultTextStyle(contextProvider);
        }
        return actualTextStyle.getLocale();
    }

    float getScaleX(ContextProvider contextProvider) {
        TextStyle actualTextStyle = getActualTextStyle(contextProvider);
        if (actualTextStyle.getScaleX() == null) {
            actualTextStyle = getDefaultTextStyle(contextProvider);
        }
        return actualTextStyle.getScaleX().floatValue();
    }

    Typeface getTextTypeface(ContextProvider contextProvider) {
        TextStyle actualTextStyle = getActualTextStyle(contextProvider);
        if (actualTextStyle.getTypeface() == null) {
            actualTextStyle = getDefaultTextStyle(contextProvider);
        }
        return actualTextStyle.getTypeface();
    }

    String getFontFeatureSettings(ContextProvider contextProvider) {
        TextStyle actualTextStyle = getActualTextStyle(contextProvider);
        if (actualTextStyle.getFontFeatureSettings() == null) {
            actualTextStyle = getDefaultTextStyle(contextProvider);
        }
        return actualTextStyle.getFontFeatureSettings();
    }

    float getLetterSpacing(ContextProvider contextProvider) {
        TextStyle actualTextStyle = getActualTextStyle(contextProvider);
        if (actualTextStyle.getLetterSpacing() == null) {
            actualTextStyle = getDefaultTextStyle(contextProvider);
        }
        return actualTextStyle.getLetterSpacing().floatValue();
    }

    int getPaintFlags(ContextProvider contextProvider) {
        TextStyle actualTextStyle = getActualTextStyle(contextProvider);
        if (actualTextStyle.getPaintFlags() == null) {
            actualTextStyle = getDefaultTextStyle(contextProvider);
        }
        return actualTextStyle.getPaintFlags().intValue();
    }

    int getShadowColor(ContextProvider contextProvider) {
        TextStyle actualTextStyle = getActualTextStyle(contextProvider);
        if (actualTextStyle.getShadowColor() == null) {
            actualTextStyle = getDefaultTextStyle(contextProvider);
        }
        return actualTextStyle.getShadowColor().intValue();
    }

    float getShadowDx(ContextProvider contextProvider) {
        TextStyle actualTextStyle = getActualTextStyle(contextProvider);
        if (actualTextStyle.getShadowDx() == null) {
            actualTextStyle = getDefaultTextStyle(contextProvider);
        }
        return actualTextStyle.getShadowDx().floatValue();
    }

    float getShadowDy(ContextProvider contextProvider) {
        TextStyle actualTextStyle = getActualTextStyle(contextProvider);
        if (actualTextStyle.getShadowDy() == null) {
            actualTextStyle = getDefaultTextStyle(contextProvider);
        }
        return actualTextStyle.getShadowDy().floatValue();
    }

    float getShadowRadius(ContextProvider contextProvider) {
        TextStyle actualTextStyle = getActualTextStyle(contextProvider);
        if (actualTextStyle.getShadowRadius() == null) {
            actualTextStyle = getDefaultTextStyle(contextProvider);
        }
        return actualTextStyle.getShadowRadius().floatValue();
    }

    Rect getTailRect(ContextProvider contextProvider) {
        return ((HintStyleBase) getDefaultStyleFromContainer(HintStyleBase.class, contextProvider, new Object[0])).getTailSize();
    }

    int getBorderThickness(ContextProvider contextProvider) {
        return (int) ((HintStyleBase) getDefaultStyleFromContainer(HintStyleBase.class, contextProvider, new Object[0])).getBorderThickness();
    }

    float getCornerRadius(ContextProvider contextProvider) {
        return ((HintStyleBase) getDefaultStyleFromContainer(HintStyleBase.class, contextProvider, new Object[0])).getBorderRadius();
    }

    Paint getActualTextPaint(ContextProvider contextProvider) {
        return ((HintStyleBase) getActualStyleFromContainer(HintStyleBase.class, contextProvider, new Object[0])).getActualTextStylePaint(contextProvider, Integer.valueOf(R.attr.dxHintLabelTextColor));
    }

    HintBehavior getBehaviorInternal() {
        return this.behavior;
    }

    void setBehaviorInternal(HintBehavior hintBehavior) {
        HintBehavior hintBehavior2 = this.behavior;
        if (hintBehavior2 != hintBehavior) {
            if (hintBehavior2 != null) {
                hintBehavior2.removeListener(getSelfListener());
            }
            this.behavior = hintBehavior;
            if (hintBehavior != null) {
                hintBehavior.addListener(getSelfListener());
            }
            notifyListeners(Property.BEHAVIOR);
        }
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        if (this.enabled != z) {
            this.enabled = z;
            notifyListeners(Property.ENABLED);
        }
    }

    public HintShowMode getShowMode() {
        return this.showMode;
    }

    public void setShowMode(HintShowMode hintShowMode) {
        if (hintShowMode == null || this.showMode == hintShowMode) {
            return;
        }
        this.showMode = hintShowMode;
        notifyListeners(Property.SHOW_MODE);
    }
}
