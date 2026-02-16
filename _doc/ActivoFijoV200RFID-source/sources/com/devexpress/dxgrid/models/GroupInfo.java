package com.devexpress.dxgrid.models;

/* loaded from: classes.dex */
public class GroupInfo {
    private boolean isCollapsed;
    private String summary;
    private String value;

    public GroupInfo(String str, String str2, boolean z) {
        this.value = str;
        this.summary = str2;
        this.isCollapsed = z;
    }

    public String getValue() {
        return this.value;
    }

    public String getSummary() {
        return this.summary;
    }

    public boolean getIsCollapsed() {
        return this.isCollapsed;
    }
}
