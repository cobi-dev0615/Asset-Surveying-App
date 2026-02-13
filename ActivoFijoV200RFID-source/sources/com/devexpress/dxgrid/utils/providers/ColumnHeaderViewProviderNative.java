package com.devexpress.dxgrid.utils.providers;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.core.view.GravityCompat;
import com.devexpress.dxgrid.appearance.GridTextAppearance;
import com.devexpress.dxgrid.models.ContentAlignment;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.providers.ColumnHeaderViewProvider;
import com.devexpress.dxgrid.utils.BitMaskHelper;
import com.devexpress.dxgrid.utils.DisplayEditExtensionKt;
import com.devexpress.editors.DisplayEdit;

/* loaded from: classes2.dex */
public class ColumnHeaderViewProviderNative implements ColumnHeaderViewProvider {
    private static final int defaultImageSize = 24;
    private final ColumnsProvider columnsProvider;

    public ColumnHeaderViewProviderNative(ColumnsProvider columnsProvider) {
        this.columnsProvider = columnsProvider;
    }

    @Override // com.devexpress.dxgrid.providers.ColumnHeaderViewProvider
    public View getColumnHeaderView(Context context, int i) {
        GridColumnModel gridColumnModel = this.columnsProvider.getColumn(i).getGridColumnModel();
        DisplayEdit displayEdit = new DisplayEdit(context);
        GridTextAppearance gridHeaderTextAppearance = gridColumnModel.getGridHeaderTextAppearance();
        displayEdit.setTextSize(gridHeaderTextAppearance.getTextSize() * context.getResources().getDisplayMetrics().density);
        displayEdit.setTypeface(gridHeaderTextAppearance.getTypeface());
        displayEdit.setTextColors(ColorStateList.valueOf(gridHeaderTextAppearance.getTextColor()));
        displayEdit.setPaintFlags(BitMaskHelper.INSTANCE.setFlag(BitMaskHelper.INSTANCE.setFlag(displayEdit.getPaintFlags(), 8, gridHeaderTextAppearance.getTextIsUnderlined()), 16, gridHeaderTextAppearance.getTextIsStrikethrough()));
        displayEdit.setText(gridColumnModel.getCaption());
        displayEdit.setMinimumHeight(getImageSize(context));
        displayEdit.setTextGravity(getTextGravity(gridColumnModel.getHorizontalHeaderAlignment()) | 16);
        DisplayEditExtensionKt.setLineBreakMode(displayEdit, gridColumnModel.getHeaderCaptionLineBreakMode());
        return displayEdit;
    }

    public static int getImageSize(Context context) {
        return ((int) context.getResources().getDisplayMetrics().density) * 24;
    }

    /* renamed from: com.devexpress.dxgrid.utils.providers.ColumnHeaderViewProviderNative$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxgrid$models$ContentAlignment;

        static {
            int[] iArr = new int[ContentAlignment.values().length];
            $SwitchMap$com$devexpress$dxgrid$models$ContentAlignment = iArr;
            try {
                iArr[ContentAlignment.Center.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxgrid$models$ContentAlignment[ContentAlignment.End.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static int getTextGravity(ContentAlignment contentAlignment) {
        if (contentAlignment == null) {
            return GravityCompat.START;
        }
        int i = AnonymousClass1.$SwitchMap$com$devexpress$dxgrid$models$ContentAlignment[contentAlignment.ordinal()];
        if (i != 1) {
            return i != 2 ? GravityCompat.START : GravityCompat.END;
        }
        return 1;
    }
}
