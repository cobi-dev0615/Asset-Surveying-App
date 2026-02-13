package com.devexpress.dxcharts;

import android.graphics.Paint;

/* loaded from: classes.dex */
public class Legend extends StyledElement {
    static final LegendHorizontalPosition DEFAULT_HORIZONTAL_POSITION = LegendHorizontalPosition.CENTER;
    static final LegendVerticalPosition DEFAULT_VERTICAL_POSITION = LegendVerticalPosition.BOTTOM_OUTSIDE;
    private boolean mVisibility = true;
    private LegendHorizontalPosition mHorizontalPosition = DEFAULT_HORIZONTAL_POSITION;
    private LegendVerticalPosition mVerticalPosition = DEFAULT_VERTICAL_POSITION;
    private LegendOrientation mOrientation = LegendOrientation.LEFT_TO_RIGHT;

    private enum Properties {
        VISIBILITY,
        HORIZONTAL_POSITION,
        VERTICAL_POSITION,
        ORIENTATION
    }

    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(LegendStyle.class);
    }

    int getBackgroundColor() {
        LegendStyle legendStyle = (LegendStyle) getActualStyleFromContainer(LegendStyle.class, new Object[0]);
        if (legendStyle.getBackgroundColor() == null) {
            legendStyle = (LegendStyle) getDefaultStyleFromContainer(LegendStyle.class);
        }
        return ColorHelper.convertToNativeColor(legendStyle.getBackgroundColor());
    }

    int getBorderColor() {
        LegendStyle legendStyle = (LegendStyle) getActualStyleFromContainer(LegendStyle.class, new Object[0]);
        if (legendStyle.getBorderColor() == null) {
            legendStyle = (LegendStyle) getDefaultStyleFromContainer(LegendStyle.class);
        }
        return ColorHelper.convertToNativeColor(legendStyle.getBorderColor());
    }

    int getBorderThickness() {
        LegendStyle legendStyle = (LegendStyle) getActualStyleFromContainer(LegendStyle.class, new Object[0]);
        if (legendStyle.getBorderThickness() == null) {
            legendStyle = (LegendStyle) getDefaultStyleFromContainer(LegendStyle.class);
        }
        return legendStyle.getBorderThickness().intValue();
    }

    int getTextIndent() {
        LegendStyle legendStyle = (LegendStyle) getActualStyleFromContainer(LegendStyle.class, new Object[0]);
        if (legendStyle.getTextIndent() == null) {
            legendStyle = (LegendStyle) getDefaultStyleFromContainer(LegendStyle.class);
        }
        return legendStyle.getTextIndent().intValue();
    }

    int getMarkerSize() {
        LegendStyle legendStyle = (LegendStyle) getActualStyleFromContainer(LegendStyle.class, new Object[0]);
        if (legendStyle.getMarkerSize() == null) {
            legendStyle = (LegendStyle) getDefaultStyleFromContainer(LegendStyle.class);
        }
        return legendStyle.getMarkerSize().intValue();
    }

    int getPaddingLeft() {
        LegendStyle legendStyle = (LegendStyle) getActualStyleFromContainer(LegendStyle.class, new Object[0]);
        if (legendStyle.getPaddingLeft() == null) {
            legendStyle = (LegendStyle) getDefaultStyleFromContainer(LegendStyle.class);
        }
        return legendStyle.getPaddingLeft().intValue();
    }

    int getPaddingTop() {
        LegendStyle legendStyle = (LegendStyle) getActualStyleFromContainer(LegendStyle.class, new Object[0]);
        if (legendStyle.getPaddingTop() == null) {
            legendStyle = (LegendStyle) getDefaultStyleFromContainer(LegendStyle.class);
        }
        return legendStyle.getPaddingTop().intValue();
    }

    int getPaddingRight() {
        LegendStyle legendStyle = (LegendStyle) getActualStyleFromContainer(LegendStyle.class, new Object[0]);
        if (legendStyle.getPaddingRight() == null) {
            legendStyle = (LegendStyle) getDefaultStyleFromContainer(LegendStyle.class);
        }
        return legendStyle.getPaddingRight().intValue();
    }

    int getPaddingBottom() {
        LegendStyle legendStyle = (LegendStyle) getActualStyleFromContainer(LegendStyle.class, new Object[0]);
        if (legendStyle.getPaddingBottom() == null) {
            legendStyle = (LegendStyle) getDefaultStyleFromContainer(LegendStyle.class);
        }
        return legendStyle.getPaddingBottom().intValue();
    }

    int getLeftIndentFromDiagram() {
        LegendStyle legendStyle = (LegendStyle) getActualStyleFromContainer(LegendStyle.class, new Object[0]);
        if (legendStyle.getLeftIndentFromDiagram() == null) {
            legendStyle = (LegendStyle) getDefaultStyleFromContainer(LegendStyle.class);
        }
        return legendStyle.getLeftIndentFromDiagram().intValue();
    }

    int getTopIndentFromDiagram() {
        LegendStyle legendStyle = (LegendStyle) getActualStyleFromContainer(LegendStyle.class, new Object[0]);
        if (legendStyle.getTopIndentFromDiagram() == null) {
            legendStyle = (LegendStyle) getDefaultStyleFromContainer(LegendStyle.class);
        }
        return legendStyle.getTopIndentFromDiagram().intValue();
    }

    int getRightIndentFromDiagram() {
        LegendStyle legendStyle = (LegendStyle) getActualStyleFromContainer(LegendStyle.class, new Object[0]);
        if (legendStyle.getRightIndentFromDiagram() == null) {
            legendStyle = (LegendStyle) getDefaultStyleFromContainer(LegendStyle.class);
        }
        return legendStyle.getRightIndentFromDiagram().intValue();
    }

    int getBottomIndentFromDiagram() {
        LegendStyle legendStyle = (LegendStyle) getActualStyleFromContainer(LegendStyle.class, new Object[0]);
        if (legendStyle.getBottomIndentFromDiagram() == null) {
            legendStyle = (LegendStyle) getDefaultStyleFromContainer(LegendStyle.class);
        }
        return legendStyle.getBottomIndentFromDiagram().intValue();
    }

    int getItemsVerticalIndent() {
        LegendStyle legendStyle = (LegendStyle) getActualStyleFromContainer(LegendStyle.class, new Object[0]);
        if (legendStyle.getItemsVerticalIndent() == null) {
            legendStyle = (LegendStyle) getDefaultStyleFromContainer(LegendStyle.class);
        }
        return legendStyle.getItemsVerticalIndent().intValue();
    }

    int getItemsHorizontalIndent() {
        LegendStyle legendStyle = (LegendStyle) getActualStyleFromContainer(LegendStyle.class, new Object[0]);
        if (legendStyle.getItemsHorizontalIndent() == null) {
            legendStyle = (LegendStyle) getDefaultStyleFromContainer(LegendStyle.class);
        }
        return legendStyle.getItemsHorizontalIndent().intValue();
    }

    Paint getActualTextPaint(ContextProvider contextProvider) {
        return ((LegendStyle) getActualStyleFromContainer(LegendStyle.class, contextProvider, new Object[0])).getActualTextStylePaint(contextProvider, new Object[0]);
    }

    public LegendStyle getStyle() {
        return (LegendStyle) getUserStyleFromContainer(LegendStyle.class);
    }

    public void setStyle(LegendStyle legendStyle) {
        super.trySetStyle(legendStyle);
    }

    public boolean isVisible() {
        return this.mVisibility;
    }

    public void setVisible(boolean z) {
        if (this.mVisibility != z) {
            this.mVisibility = z;
            notifyListeners(Properties.VISIBILITY);
        }
    }

    public LegendHorizontalPosition getHorizontalPosition() {
        return this.mHorizontalPosition;
    }

    public void setHorizontalPosition(LegendHorizontalPosition legendHorizontalPosition) {
        if (legendHorizontalPosition == null || this.mHorizontalPosition == legendHorizontalPosition) {
            return;
        }
        this.mHorizontalPosition = legendHorizontalPosition;
        notifyListeners(Properties.HORIZONTAL_POSITION);
    }

    public LegendVerticalPosition getVerticalPosition() {
        return this.mVerticalPosition;
    }

    public void setVerticalPosition(LegendVerticalPosition legendVerticalPosition) {
        if (legendVerticalPosition == null || this.mVerticalPosition == legendVerticalPosition) {
            return;
        }
        this.mVerticalPosition = legendVerticalPosition;
        notifyListeners(Properties.VERTICAL_POSITION);
    }

    public LegendOrientation getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(LegendOrientation legendOrientation) {
        if (legendOrientation == null || this.mOrientation == legendOrientation) {
            return;
        }
        this.mOrientation = legendOrientation;
        notifyListeners(Properties.ORIENTATION);
    }
}
