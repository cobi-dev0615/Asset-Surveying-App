package com.devexpress.dxgrid.utils.providers;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.core.view.GravityCompat;
import com.devexpress.dxgrid.appearance.GridTextAppearance;
import com.devexpress.dxgrid.appearance.providers.GroupHeaderAppearanceProvider;
import com.devexpress.dxgrid.models.GroupInfo;
import com.devexpress.dxgrid.providers.DataProvider;
import com.devexpress.dxgrid.providers.GroupRowValueViewProviderBase;
import com.devexpress.dxgrid.utils.BitMaskHelper;
import com.devexpress.editors.DisplayEdit;

/* loaded from: classes2.dex */
public class GroupRowValueViewProviderNative implements GroupRowValueViewProviderBase {
    private final GroupHeaderAppearanceProvider appearanceProvider;
    private final DataProvider dataProvider;

    public GroupRowValueViewProviderNative(GroupHeaderAppearanceProvider groupHeaderAppearanceProvider, DataProvider dataProvider) {
        this.appearanceProvider = groupHeaderAppearanceProvider;
        this.dataProvider = dataProvider;
    }

    @Override // com.devexpress.dxgrid.providers.GroupRowValueViewProviderBase
    public View getView(Context context, int i) {
        DisplayEdit displayEdit = new DisplayEdit(context);
        displayEdit.setTextGravity(GravityCompat.START);
        return displayEdit;
    }

    @Override // com.devexpress.dxgrid.providers.GroupRowValueViewProviderBase
    public void updateView(Context context, View view, int i) {
        GroupInfo groupInfo = this.dataProvider.getGroupInfo(i);
        DisplayEdit displayEdit = (DisplayEdit) view;
        GridTextAppearance groupHeaderTextAppearance = this.appearanceProvider.getGroupHeaderTextAppearance();
        displayEdit.setTextSize(groupHeaderTextAppearance.getTextSize() * context.getResources().getDisplayMetrics().density);
        displayEdit.setTypeface(groupHeaderTextAppearance.getTypeface());
        displayEdit.setPaintFlags(BitMaskHelper.INSTANCE.setFlag(displayEdit.getPaintFlags(), 8, groupHeaderTextAppearance.getTextIsUnderlined()));
        displayEdit.setPaintFlags(BitMaskHelper.INSTANCE.setFlag(displayEdit.getPaintFlags(), 16, groupHeaderTextAppearance.getTextIsStrikethrough()));
        displayEdit.setTextColors(ColorStateList.valueOf(groupHeaderTextAppearance.getTextColor()));
        displayEdit.setText(groupInfo.getValue());
    }
}
