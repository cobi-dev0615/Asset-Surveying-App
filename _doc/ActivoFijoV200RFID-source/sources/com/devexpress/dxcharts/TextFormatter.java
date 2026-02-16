package com.devexpress.dxcharts;

import java.util.Date;

/* compiled from: ChartTextRenderer.java */
/* loaded from: classes.dex */
class TextFormatter {
    TextFormatter() {
    }

    String getDefaultDateFormat() {
        return FormatHelper.getDefaultDateFormat(DateTimeMeasureUnit.DEFAULT.ordinal());
    }

    String formatValue(Object obj, int i, String str) {
        String formatString;
        if (obj == null) {
            return "";
        }
        try {
            if (i == 0) {
                formatString = FormatHelper.formatDecimal(((Double) obj).doubleValue(), str);
            } else if (i == 1) {
                formatString = FormatHelper.formatDate(new Date((long) (((Double) obj).doubleValue() * 1000.0d)), str);
            } else {
                formatString = FormatHelper.formatString((String) obj, str);
            }
            return formatString;
        } catch (Exception unused) {
            return "invalid format: " + str;
        }
    }

    String[] formatValues(Object[] objArr, int i, String str) {
        String[] strArr = new String[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            strArr[i2] = formatValue(objArr[i2], i, str);
        }
        return strArr;
    }
}
