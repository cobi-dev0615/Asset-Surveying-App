package com.devexpress.dxgrid.providers;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.view.View;
import com.devexpress.dxgrid.appearance.GridTextAppearance;
import com.devexpress.dxgrid.appearance.wrappers.CustomGridTextAppearanceWrapper;
import com.devexpress.dxgrid.models.LineBreakMode;
import com.devexpress.dxgrid.models.appearance.AppearanceBase;
import com.devexpress.dxgrid.models.appearance.CellAppearance;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.models.columns.TextColumnModelBase;
import com.devexpress.dxgrid.utils.BitMaskHelper;
import com.devexpress.dxgrid.utils.DisplayEditExtensionKt;
import com.devexpress.editors.DisplayEdit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextCellViewProvider.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J*\u0010\u0010\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u0016"}, d2 = {"Lcom/devexpress/dxgrid/providers/TextCellViewProvider;", "Lcom/devexpress/dxgrid/providers/NativeViewProviderBase;", "()V", "requestView", "Landroid/view/View;", "context", "Landroid/content/Context;", "rowIndex", "", "updateAppearance", "", "view", "columnModel", "Lcom/devexpress/dxgrid/models/columns/GridColumnModel;", "customAppearance", "Lcom/devexpress/dxgrid/models/appearance/AppearanceBase;", "updateContent", "dataProvider", "Lcom/devexpress/dxgrid/providers/DataProvider;", "fieldName", "", "Companion", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextCellViewProvider extends NativeViewProviderBase {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Override // com.devexpress.dxgrid.providers.ViewProvider
    public View requestView(Context context, int rowIndex) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new DisplayEdit(context, null, 0, 6, null);
    }

    @Override // com.devexpress.dxgrid.providers.ViewProvider
    public void updateContent(View view, DataProvider dataProvider, String fieldName, int rowIndex) {
        Intrinsics.checkNotNullParameter(dataProvider, "dataProvider");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        if (view instanceof DisplayEdit) {
            DisplayEdit displayEdit = (DisplayEdit) view;
            String displayText = dataProvider.getDisplayText(fieldName, rowIndex);
            if (displayText == null) {
                displayText = "";
            }
            displayEdit.setText(displayText);
        }
    }

    @Override // com.devexpress.dxgrid.providers.ViewProvider
    public void updateAppearance(View view, GridColumnModel columnModel, AppearanceBase customAppearance, int rowIndex) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(columnModel, "columnModel");
        if (view instanceof DisplayEdit) {
            CellAppearance cellAppearance = columnModel.getCellAppearance();
            Intrinsics.checkNotNullExpressionValue(cellAppearance, "getCellAppearance(...)");
            DisplayEdit displayEdit = (DisplayEdit) view;
            INSTANCE.updateAppearance(displayEdit, new CustomGridTextAppearanceWrapper(cellAppearance, customAppearance));
            displayEdit.setTextGravity(columnModel.getGravity());
            LineBreakMode lineBreakMode = ((TextColumnModelBase) columnModel).getLineBreakMode();
            Intrinsics.checkNotNullExpressionValue(lineBreakMode, "getLineBreakMode(...)");
            DisplayEditExtensionKt.setLineBreakMode(displayEdit, lineBreakMode);
        }
    }

    /* compiled from: TextCellViewProvider.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/devexpress/dxgrid/providers/TextCellViewProvider$Companion;", "", "()V", "updateAppearance", "", "view", "Lcom/devexpress/editors/DisplayEdit;", "textAppearance", "Lcom/devexpress/dxgrid/appearance/GridTextAppearance;", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void updateAppearance(DisplayEdit view, GridTextAppearance textAppearance) {
            String prefixText;
            String suffixText;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(textAppearance, "textAppearance");
            CharSequence prefixText2 = view.getPrefixText();
            if ((prefixText2 != null && prefixText2.length() != 0) || ((prefixText = textAppearance.getPrefixText()) != null && prefixText.length() != 0)) {
                view.setPrefixText(textAppearance.getPrefixText());
            }
            CharSequence suffixText2 = view.getSuffixText();
            if ((suffixText2 != null && suffixText2.length() != 0) || ((suffixText = textAppearance.getSuffixText()) != null && suffixText.length() != 0)) {
                view.setSuffixText(textAppearance.getSuffixText());
            }
            Typeface typeface = textAppearance.getTypeface();
            Intrinsics.checkNotNullExpressionValue(typeface, "getTypeface(...)");
            view.setTypeface(typeface);
            view.setTextSize(textAppearance.getTextSize() * view.getContext().getResources().getDisplayMetrics().density);
            view.setTextColors(ColorStateList.valueOf(view.isSelected() ? textAppearance.getSelectionTextColor() : textAppearance.getTextColor()));
            view.setAffixColors(ColorStateList.valueOf(textAppearance.getAffixColor()));
            view.setAffixIndent(textAppearance.getAffixIndent());
            view.setAffixTextSize(textAppearance.getAffixTextSize() * view.getContext().getResources().getDisplayMetrics().density);
            Typeface affixTypeface = textAppearance.getAffixTypeface();
            Intrinsics.checkNotNullExpressionValue(affixTypeface, "getAffixTypeface(...)");
            view.setAffixTypeface(affixTypeface);
            view.setPaintFlags(BitMaskHelper.INSTANCE.setFlag(BitMaskHelper.INSTANCE.setFlag(view.getPaintFlags(), 8, textAppearance.getTextIsUnderlined()), 16, textAppearance.getTextIsStrikethrough()));
        }
    }
}
