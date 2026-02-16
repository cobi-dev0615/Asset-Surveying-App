package com.devexpress.navigation.navigationdrawer;

import com.devexpress.navigation.tabs.models.TabSize;
import com.devexpress.navigation.tabs.utils.SizeConverter;

/* loaded from: classes2.dex */
public class StarSizeCalculator {
    static int[] calculateSizes(SizeConverter sizeConverter, TabSize[] tabSizeArr, int i) {
        float f = 0.0f;
        int i2 = 0;
        for (TabSize tabSize : tabSizeArr) {
            if (tabSize.getIsStar()) {
                i2++;
                f += tabSize.getSize();
            }
        }
        float f2 = i / f;
        int[] iArr = new int[i2];
        for (TabSize tabSize2 : tabSizeArr) {
            if (tabSize2.getIsStar()) {
                iArr[0] = sizeConverter.convertDpToPx(tabSize2.getSize() * f2);
            }
        }
        return iArr;
    }
}
