package com.devexpress.dxgrid.providers;

import com.devexpress.dxgrid.models.GroupInfo;
import com.devexpress.dxgrid.utils.ObjectLambda;

/* loaded from: classes.dex */
public interface DataProvider {
    String getCellErrorText(String str, int i);

    String getDisplayText(Object obj, String str, int i);

    String getDisplayText(String str, int i);

    GroupInfo getGroupInfo(int i);

    int getRowCount();

    String getTotalSummary(int i);

    Object getValue(String str, int i);

    void getValueAsync(String str, int i, ObjectLambda objectLambda);

    boolean isGroupRow(int i);

    boolean isSelected(int i);

    String setCellValue(String str, int i, Object obj);
}
