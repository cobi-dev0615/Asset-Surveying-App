package com.devexpress.dxcharts;

import android.graphics.Rect;

/* loaded from: classes.dex */
public class HintStyleBase extends TextElementStyleBase {
    private Integer backgroundColor;
    private float borderRadius;
    private float borderThickness;
    private Integer itemsIndent;
    private Integer markerSize;
    private Integer paddingBottom;
    private Integer paddingLeft;
    private Integer paddingRight;
    private Integer paddingTop;
    private Rect tailSize;
    private Integer textIndent;

    private enum Property {
        BACKGROUND_COLOR,
        MARKER_SIZE,
        TEXT_INDENT,
        PADDING,
        ITEMS_INDENT
    }

    @Override // com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        float floatValue;
        float floatValue2;
        float floatValue3;
        float floatValue4;
        super.initDefaultStyle(contextProvider, objArr);
        this.backgroundColor = Integer.valueOf(ResourceHelper.getColorOrDefault(contextProvider, R.attr.dxHintLabelBackground));
        this.markerSize = Integer.valueOf((int) contextProvider.getResources().getDimension(R.dimen.hint_marker_size));
        this.textIndent = Integer.valueOf((int) contextProvider.getResources().getDimension(R.dimen.hint_text_indent));
        Float dimension = ResourceHelper.getDimension(contextProvider, R.attr.dxHintPadding);
        Float dimension2 = ResourceHelper.getDimension(contextProvider, R.attr.dxHintPaddingHorizontal);
        Float dimension3 = ResourceHelper.getDimension(contextProvider, R.attr.dxHintPaddingVertical);
        if (dimension != null) {
            floatValue = dimension.floatValue();
        } else {
            floatValue = dimension2 != null ? dimension2.floatValue() : ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxHintPaddingLeft);
        }
        this.paddingLeft = Integer.valueOf((int) floatValue);
        if (dimension != null) {
            floatValue2 = dimension.floatValue();
        } else {
            floatValue2 = dimension2 != null ? dimension2.floatValue() : ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxHintPaddingRight);
        }
        this.paddingRight = Integer.valueOf((int) floatValue2);
        if (dimension != null) {
            floatValue3 = dimension.floatValue();
        } else {
            floatValue3 = dimension3 != null ? dimension3.floatValue() : ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxHintPaddingTop);
        }
        this.paddingTop = Integer.valueOf((int) floatValue3);
        if (dimension != null) {
            floatValue4 = dimension.floatValue();
        } else {
            floatValue4 = dimension3 != null ? dimension3.floatValue() : ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxHintPaddingBottom);
        }
        this.paddingBottom = Integer.valueOf((int) floatValue4);
        this.itemsIndent = Integer.valueOf((int) contextProvider.getResources().getDimension(R.dimen.hint_items_indent));
        this.borderThickness = contextProvider.getResources().getDimension(R.dimen.hint_border_thickness);
        this.borderRadius = contextProvider.getResources().getDimension(R.dimen.hint_border_radius);
        this.tailSize = new Rect(0, 0, (int) contextProvider.getResources().getDimension(R.dimen.hint_tail_width), (int) contextProvider.getResources().getDimension(R.dimen.hint_tail_height));
    }

    float getBorderRadius() {
        return this.borderRadius;
    }

    Rect getTailSize() {
        return this.tailSize;
    }

    float getBorderThickness() {
        return this.borderThickness;
    }

    Integer getItemsIndentInternal() {
        return this.itemsIndent;
    }

    void setItemsIndentInternal(Integer num) {
        if (CompareHelper.areNotEquals(this.itemsIndent, num)) {
            this.itemsIndent = num;
            notifyListeners(Property.ITEMS_INDENT);
        }
    }

    public Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(Integer num) {
        if (CompareHelper.areNotEquals(this.backgroundColor, num)) {
            this.backgroundColor = num;
            notifyListeners(Property.BACKGROUND_COLOR);
        }
    }

    public Integer getMarkerSize() {
        return this.markerSize;
    }

    public void setMarkerSize(Integer num) {
        if (CompareHelper.areNotEquals(this.markerSize, num)) {
            this.markerSize = num;
            notifyListeners(Property.MARKER_SIZE);
        }
    }

    public Integer getTextIndent() {
        return this.textIndent;
    }

    public void setTextIndent(Integer num) {
        if (CompareHelper.areNotEquals(this.textIndent, num)) {
            this.textIndent = num;
            notifyListeners(Property.TEXT_INDENT);
        }
    }

    public Integer getPaddingLeft() {
        return this.paddingLeft;
    }

    public Integer getPaddingTop() {
        return this.paddingTop;
    }

    public Integer getPaddingRight() {
        return this.paddingRight;
    }

    public Integer getPaddingBottom() {
        return this.paddingBottom;
    }

    public void setPadding(Integer num, Integer num2, Integer num3, Integer num4) {
        if (CompareHelper.areNotEquals(this.paddingLeft, num) || CompareHelper.areNotEquals(this.paddingTop, num2) || CompareHelper.areNotEquals(this.paddingRight, num3) || CompareHelper.areNotEquals(this.paddingBottom, num4)) {
            this.paddingLeft = num;
            this.paddingTop = num2;
            this.paddingRight = num3;
            this.paddingBottom = num4;
            notifyListeners(Property.PADDING);
        }
    }
}
