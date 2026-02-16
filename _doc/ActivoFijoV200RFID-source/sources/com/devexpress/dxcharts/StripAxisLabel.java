package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class StripAxisLabel extends AxisLabelBase {
    static String DEFAULT_TEXT = null;
    static boolean DEFAULT_VISIBILITY = false;
    private String mText = DEFAULT_TEXT;

    enum Property {
        TEXT
    }

    public String getText() {
        return this.mText;
    }

    public void setText(String str) {
        if (CompareHelper.areNotEquals(this.mText, str)) {
            this.mText = str;
            notifyListeners(Property.TEXT);
        }
    }
}
