package com.devexpress.dxgrid.appearance;

import android.graphics.Typeface;
import com.devexpress.dxgrid.models.columns.GridColumnModel;

/* loaded from: classes.dex */
public class GridHeaderTextAppearance implements GridTextAppearance {
    private GridColumnModel gridColumnModel;
    private GridTextAppearance gridTextAppearance;

    public void initialize(GridTextAppearance gridTextAppearance, GridColumnModel gridColumnModel) {
        this.gridTextAppearance = gridTextAppearance;
        this.gridColumnModel = gridColumnModel;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public Typeface getTypeface() {
        return this.gridTextAppearance.getTypeface();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public float getTextSize() {
        return this.gridTextAppearance.getTextSize();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public int getTextColor() {
        return this.gridTextAppearance.getTextColor();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public int getSelectionTextColor() {
        return this.gridTextAppearance.getSelectionTextColor();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public boolean getTextIsUnderlined() {
        return this.gridTextAppearance.getTextIsUnderlined();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public boolean getTextIsStrikethrough() {
        return this.gridTextAppearance.getTextIsStrikethrough();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public String getPrefixText() {
        return this.gridTextAppearance.getPrefixText();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public String getSuffixText() {
        return this.gridTextAppearance.getSuffixText();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public float getAffixTextSize() {
        return this.gridTextAppearance.getAffixTextSize();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public Typeface getAffixTypeface() {
        return this.gridTextAppearance.getAffixTypeface();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public int getAffixIndent() {
        return this.gridTextAppearance.getAffixIndent();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public int getAffixColor() {
        return this.gridTextAppearance.getAffixColor();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public boolean getAffixIsUnderlined() {
        return this.gridTextAppearance.getAffixIsUnderlined();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public boolean getAffixIsStrikethrough() {
        return this.gridTextAppearance.getAffixIsStrikethrough();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public String getMask() {
        return this.gridTextAppearance.getMask();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public char getMaskPlaceholderChar() {
        return this.gridTextAppearance.getMaskPlaceholderChar();
    }
}
