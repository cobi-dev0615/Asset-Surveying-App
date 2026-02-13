package com.devexpress.dxgrid.appearance.wrappers;

import android.graphics.Typeface;
import com.devexpress.dxgrid.appearance.GridTextAppearance;
import com.devexpress.dxgrid.models.appearance.AppearanceBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomGridTextAppearanceWrapper.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/devexpress/dxgrid/appearance/wrappers/CustomGridTextAppearanceWrapper;", "Lcom/devexpress/dxgrid/appearance/GridTextAppearance;", "gridTextAppearance", "customAppearanceBase", "Lcom/devexpress/dxgrid/models/appearance/AppearanceBase;", "(Lcom/devexpress/dxgrid/appearance/GridTextAppearance;Lcom/devexpress/dxgrid/models/appearance/AppearanceBase;)V", "getAffixColor", "", "getAffixIndent", "getAffixIsStrikethrough", "", "getAffixIsUnderlined", "getAffixTextSize", "", "getAffixTypeface", "Landroid/graphics/Typeface;", "getMask", "", "getMaskPlaceholderChar", "", "getPrefixText", "getSelectionTextColor", "getSuffixText", "getTextColor", "getTextIsStrikethrough", "getTextIsUnderlined", "getTextSize", "getTypeface", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CustomGridTextAppearanceWrapper implements GridTextAppearance {
    private final AppearanceBase customAppearanceBase;
    private final GridTextAppearance gridTextAppearance;

    public CustomGridTextAppearanceWrapper(GridTextAppearance gridTextAppearance, AppearanceBase appearanceBase) {
        Intrinsics.checkNotNullParameter(gridTextAppearance, "gridTextAppearance");
        this.gridTextAppearance = gridTextAppearance;
        this.customAppearanceBase = appearanceBase;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public Typeface getTypeface() {
        AppearanceBase appearanceBase = this.customAppearanceBase;
        Typeface typeface = appearanceBase != null ? appearanceBase.getTypeface() : null;
        if (typeface != null) {
            return typeface;
        }
        Typeface typeface2 = this.gridTextAppearance.getTypeface();
        Intrinsics.checkNotNullExpressionValue(typeface2, "getTypeface(...)");
        return typeface2;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public float getTextSize() {
        AppearanceBase appearanceBase = this.customAppearanceBase;
        return appearanceBase != null ? appearanceBase.getTextSize() : this.gridTextAppearance.getTextSize();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public boolean getTextIsUnderlined() {
        AppearanceBase appearanceBase = this.customAppearanceBase;
        return appearanceBase != null ? appearanceBase.getTextIsUnderlined() : this.gridTextAppearance.getTextIsUnderlined();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public int getTextColor() {
        AppearanceBase appearanceBase = this.customAppearanceBase;
        return appearanceBase != null ? appearanceBase.getTextColor() : this.gridTextAppearance.getTextColor();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public int getSelectionTextColor() {
        AppearanceBase appearanceBase = this.customAppearanceBase;
        return appearanceBase != null ? appearanceBase.getTextColor() : this.gridTextAppearance.getSelectionTextColor();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public boolean getTextIsStrikethrough() {
        AppearanceBase appearanceBase = this.customAppearanceBase;
        return appearanceBase != null ? appearanceBase.getTextIsStrikethrough() : this.gridTextAppearance.getTextIsStrikethrough();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public float getAffixTextSize() {
        AppearanceBase appearanceBase = this.customAppearanceBase;
        return appearanceBase != null ? appearanceBase.getAffixTextSize() : this.gridTextAppearance.getAffixTextSize();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public String getSuffixText() {
        String suffixText;
        AppearanceBase appearanceBase = this.customAppearanceBase;
        return (appearanceBase == null || (suffixText = appearanceBase.getSuffixText()) == null) ? this.gridTextAppearance.getSuffixText() : suffixText;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public boolean getAffixIsStrikethrough() {
        AppearanceBase appearanceBase = this.customAppearanceBase;
        return appearanceBase != null ? appearanceBase.getAffixIsStrikethrough() : this.gridTextAppearance.getAffixIsStrikethrough();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public int getAffixIndent() {
        AppearanceBase appearanceBase = this.customAppearanceBase;
        return appearanceBase != null ? appearanceBase.getAffixIndent() : this.gridTextAppearance.getAffixIndent();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public String getMask() {
        String mask;
        AppearanceBase appearanceBase = this.customAppearanceBase;
        return (appearanceBase == null || (mask = appearanceBase.getMask()) == null) ? this.gridTextAppearance.getMask() : mask;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public Typeface getAffixTypeface() {
        AppearanceBase appearanceBase = this.customAppearanceBase;
        Typeface affixTypeface = appearanceBase != null ? appearanceBase.getAffixTypeface() : null;
        if (affixTypeface != null) {
            return affixTypeface;
        }
        Typeface affixTypeface2 = this.gridTextAppearance.getAffixTypeface();
        Intrinsics.checkNotNullExpressionValue(affixTypeface2, "getAffixTypeface(...)");
        return affixTypeface2;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public String getPrefixText() {
        String prefixText;
        AppearanceBase appearanceBase = this.customAppearanceBase;
        return (appearanceBase == null || (prefixText = appearanceBase.getPrefixText()) == null) ? this.gridTextAppearance.getPrefixText() : prefixText;
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public int getAffixColor() {
        AppearanceBase appearanceBase = this.customAppearanceBase;
        return appearanceBase != null ? appearanceBase.getAffixColor() : this.gridTextAppearance.getAffixColor();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public boolean getAffixIsUnderlined() {
        AppearanceBase appearanceBase = this.customAppearanceBase;
        return appearanceBase != null ? appearanceBase.getAffixIsUnderlined() : this.gridTextAppearance.getAffixIsUnderlined();
    }

    @Override // com.devexpress.dxgrid.appearance.GridTextAppearance
    public char getMaskPlaceholderChar() {
        AppearanceBase appearanceBase = this.customAppearanceBase;
        return appearanceBase != null ? appearanceBase.getMaskPlaceholderChar() : this.gridTextAppearance.getMaskPlaceholderChar();
    }
}
