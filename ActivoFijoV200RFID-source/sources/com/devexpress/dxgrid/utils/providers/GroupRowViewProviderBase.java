package com.devexpress.dxgrid.utils.providers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import com.devexpress.dxgrid.R;
import com.devexpress.dxgrid.models.GroupInfo;
import com.devexpress.dxgrid.providers.DataProvider;
import com.devexpress.dxgrid.providers.GroupRowValueViewProviderBase;

/* loaded from: classes2.dex */
public class GroupRowViewProviderBase implements com.devexpress.dxgrid.providers.GroupRowViewProviderBase {
    private DataProvider dataProvider;
    private Drawable drawableDown;
    private Drawable drawableUp;
    private GroupRowValueViewProviderBase groupRowSummaryViewProvider;
    private GroupRowValueViewProviderBase groupRowValueViewProvider;
    private int imageViewIndex;
    private final LinearLayout.LayoutParams lpSimple;
    private final LinearLayout.LayoutParams lpWeighted;
    private int summaryTextCellIndex;
    private int valueTextCellIndex;

    public GroupRowViewProviderBase(GroupRowValueViewProviderBase groupRowValueViewProviderBase, GroupRowValueViewProviderBase groupRowValueViewProviderBase2, DataProvider dataProvider) {
        this.groupRowValueViewProvider = groupRowValueViewProviderBase;
        this.groupRowSummaryViewProvider = groupRowValueViewProviderBase2;
        this.dataProvider = dataProvider;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.lpSimple = layoutParams;
        layoutParams.gravity = 16;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2, 1.0f);
        this.lpWeighted = layoutParams2;
        layoutParams2.gravity = 16;
    }

    @Override // com.devexpress.dxgrid.providers.GroupRowViewProviderBase
    public View getView(Context context, int i) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        this.imageViewIndex = linearLayout.getChildCount();
        linearLayout.addView(appCompatImageView, -1, this.lpSimple);
        linearLayout.addView(new View(context), -1, new LinearLayout.LayoutParams((int) (context.getResources().getDisplayMetrics().density * 8.0f), 1));
        View view = this.groupRowValueViewProvider.getView(context, i);
        this.valueTextCellIndex = linearLayout.getChildCount();
        linearLayout.addView(view, -1, this.lpWeighted);
        View view2 = this.groupRowSummaryViewProvider.getView(context, i);
        this.summaryTextCellIndex = linearLayout.getChildCount();
        linearLayout.addView(view2, -1, this.lpWeighted);
        updateView(context, linearLayout, i);
        return linearLayout;
    }

    @Override // com.devexpress.dxgrid.providers.GroupRowViewProviderBase
    public void updateView(Context context, View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view;
        View childAt = viewGroup.getChildAt(this.summaryTextCellIndex);
        this.groupRowSummaryViewProvider.updateView(context, childAt, i);
        GroupInfo groupInfo = this.dataProvider.getGroupInfo(i);
        String summary = groupInfo.getSummary();
        childAt.setLayoutParams((summary == null || summary.length() <= 0) ? this.lpSimple : this.lpWeighted);
        this.groupRowValueViewProvider.updateView(context, viewGroup.getChildAt(this.valueTextCellIndex), i);
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewGroup.getChildAt(this.imageViewIndex);
        if (!groupInfo.getIsCollapsed()) {
            appCompatImageView.setImageDrawable(getDrawableUp(context));
        } else {
            appCompatImageView.setImageDrawable(getDrawableDown(context));
        }
    }

    private Drawable getDrawableDown(Context context) {
        if (this.drawableDown == null) {
            this.drawableDown = ResourcesCompat.getDrawable(context.getResources(), R.drawable.dxg_group_down_24dp, null);
        }
        return this.drawableDown;
    }

    private Drawable getDrawableUp(Context context) {
        if (this.drawableUp == null) {
            this.drawableUp = ResourcesCompat.getDrawable(context.getResources(), R.drawable.dxg_group_up_24dp, null);
        }
        return this.drawableUp;
    }
}
