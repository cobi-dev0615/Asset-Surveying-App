package com.devexpress.dxgrid.models.appearance;

import android.graphics.Rect;
import android.graphics.Typeface;
import androidx.core.internal.view.SupportMenu;
import com.devexpress.dxgrid.appearance.GridCellContainerAppearance;
import com.devexpress.dxgrid.appearance.GridTextAppearance;

/* loaded from: classes.dex */
public class AppearanceBase implements GridTextAppearance, GridCellContainerAppearance {
    private Typeface typeface = Typeface.DEFAULT;
    private float textSize = 20.0f;
    private int textColor = -16777216;
    private Typeface errorTypeface = Typeface.DEFAULT;
    private float errorTextSize = 10.0f;
    private int errorTextColor = SupportMenu.CATEGORY_MASK;
    private int selectionTextColor = -16777216;
    private int backgroundColor = -1;
    private int selectionColor = -1;
    private int borderColor = -16777216;
    private int bottomBorderColor = -16777216;
    private int checkedCheckBoxColor = -1;
    private int checkBoxColor = -1;
    private int errorTopOffset = 5;
    private int errorMinBottomOffset = 5;
    private boolean textIsUnderlined = false;
    private boolean textIsStrikethrough = false;
    private int horizontalLineThickness = 1;
    private Rect padding = new Rect();
    private String prefixText = null;
    private String suffixText = null;
    private float affixTextSize = this.textSize;
    private Typeface affixTypeface = this.typeface;
    private int affixIndent = 0;
    private int affixColor = this.textColor;
    private boolean affixIsUnderlined = this.textIsUnderlined;
    private boolean affixIsStrikethrough = this.textIsStrikethrough;
    private String mask = "";
    private char maskPlaceholderChar = '_';

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getFixedColumnSeparatorWidth() {
        return 0;
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getVerticalLineThickness() {
        return 0;
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getSelectionColor() {
        return this.selectionColor;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public int getSelectionTextColor() {
        return this.selectionTextColor;
    }

    public void setSelectionTextColor(int i) {
        this.selectionTextColor = i;
    }

    public void setSelectionColor(int i) {
        this.selectionColor = i;
    }

    public void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getBorderColor() {
        return this.borderColor;
    }

    public void setBorderColor(int i) {
        this.borderColor = i;
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getBottomBorderColor() {
        return this.bottomBorderColor;
    }

    public void setBottomBorderColor(int i) {
        this.bottomBorderColor = i;
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public int getHorizontalLineThickness() {
        return this.horizontalLineThickness;
    }

    public void setHorizontalLineThickness(int i) {
        this.horizontalLineThickness = i;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public int getTextColor() {
        return this.textColor;
    }

    public void setTextColor(int i) {
        this.textColor = i;
    }

    public int getErrorTextColor() {
        return this.errorTextColor;
    }

    public void setErrorTextColor(int i) {
        this.errorTextColor = i;
    }

    public int getCheckedCheckBoxColor() {
        return this.checkedCheckBoxColor;
    }

    public void setCheckedCheckBoxColor(int i) {
        this.checkedCheckBoxColor = i;
    }

    public int getCheckBoxColor() {
        return this.checkBoxColor;
    }

    public void setCheckBoxColor(int i) {
        this.checkBoxColor = i;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public Typeface getTypeface() {
        return this.typeface;
    }

    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }

    public Typeface getErrorTypeface() {
        return this.errorTypeface;
    }

    public void setErrorTypeface(Typeface typeface) {
        this.errorTypeface = typeface;
    }

    @Override // com.devexpress.dxgrid.appearance.GridCellContainerAppearance
    public Rect getPadding() {
        return this.padding;
    }

    public void setPadding(Rect rect) {
        this.padding = rect;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public float getTextSize() {
        return this.textSize;
    }

    public void setTextSize(float f) {
        this.textSize = f;
    }

    public float getErrorTextSize() {
        return this.errorTextSize;
    }

    public void setErrorTextSize(float f) {
        this.errorTextSize = f;
    }

    public int getErrorTopOffset() {
        return this.errorTopOffset;
    }

    public void setErrorTopOffset(int i) {
        this.errorTopOffset = i;
    }

    public int getErrorMinBottomOffset() {
        return this.errorMinBottomOffset;
    }

    public void setErrorMinBottomOffset(int i) {
        this.errorMinBottomOffset = i;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public boolean getTextIsStrikethrough() {
        return this.textIsStrikethrough;
    }

    public void setTextIsStrikethrough(boolean z) {
        this.textIsStrikethrough = z;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public boolean getTextIsUnderlined() {
        return this.textIsUnderlined;
    }

    public void setTextIsUnderlined(boolean z) {
        this.textIsUnderlined = z;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public String getPrefixText() {
        return this.prefixText;
    }

    public void setPrefixText(String str) {
        this.prefixText = str;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public String getSuffixText() {
        return this.suffixText;
    }

    public void setSuffixText(String str) {
        this.suffixText = str;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public float getAffixTextSize() {
        return this.affixTextSize;
    }

    public void setAffixTextSize(float f) {
        this.affixTextSize = f;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public Typeface getAffixTypeface() {
        return this.affixTypeface;
    }

    public void setAffixTypeface(Typeface typeface) {
        this.affixTypeface = typeface;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public int getAffixIndent() {
        return this.affixIndent;
    }

    public void setAffixIndent(int i) {
        this.affixIndent = i;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public int getAffixColor() {
        return this.affixColor;
    }

    public void setAffixColor(int i) {
        this.affixColor = i;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public boolean getAffixIsUnderlined() {
        return this.affixIsUnderlined;
    }

    public void setAffixIsUnderlined(boolean z) {
        this.affixIsUnderlined = z;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public boolean getAffixIsStrikethrough() {
        return this.affixIsStrikethrough;
    }

    public void setAffixIsStrikethrough(boolean z) {
        this.affixIsStrikethrough = z;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public String getMask() {
        return this.mask;
    }

    public void setMask(String str) {
        this.mask = str;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public char getMaskPlaceholderChar() {
        return this.maskPlaceholderChar;
    }

    public void setMaskPlaceholderChar(char c) {
        this.maskPlaceholderChar = c;
    }
}
