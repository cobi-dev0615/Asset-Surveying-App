package com.devexpress.navigation.tabs.utils.calculators;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.devexpress.navigation.common.HeaderElements;
import com.devexpress.navigation.common.Position;
import com.devexpress.navigation.tabs.models.HeaderItemModel;
import com.devexpress.navigation.tabs.models.IReadonlyHeaderItemModel;
import com.devexpress.navigation.tabs.models.TabSize;
import com.devexpress.navigation.tabs.models.TabSizeInPixels;
import com.devexpress.navigation.tabs.utils.MeasuredSize;
import com.devexpress.navigation.tabs.utils.SizeConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class HeaderItemSizeCalculator {
    public static final int WRAP_CONTENT = -1;
    private int mActualCrossSize;
    private int[] mActualMainSizes;
    private int mCrossHeight;
    private int mCrossWidth;
    private boolean mFitToViewPort;
    private HeaderItemModel.OnHeaderChangeListener mHeaderItemListener;
    private List<TabSizeInPixels> mHeaderItemMainSizes;
    private List<IReadonlyHeaderItemModel> mHeaderItems;
    private int mHeaderPanelMainSize;
    private boolean mIsHorizontal;
    private int mMaxCrossHeight;
    private int mMaxCrossWidth;
    private HashMap<IReadonlyHeaderItemModel, MeasuredSize> mMeasuredSizes;
    private int mMinCrossHeight;
    private int mMinCrossWidth;
    private boolean mNeedRecalculate = true;
    private SizeConverter mSizeConverter;
    private int mSpacing;
    private int mViewPortHeight;
    private int mViewPortSize;
    private int mViewPortWidth;

    public HeaderItemSizeCalculator(List<IReadonlyHeaderItemModel> list, boolean z, int i, int i2, int i3, SizeConverter sizeConverter) {
        this.mSizeConverter = sizeConverter;
        this.mHeaderItems = list;
        this.mIsHorizontal = z;
        setSpacing(i);
        setCrossHeight(i3, -1, -1);
        setCrossWidth(i2, -1, -1);
        createHeaderItemListener();
        headerItemsUpdated();
    }

    public int getHeaderPanelMainSize() {
        return this.mHeaderPanelMainSize;
    }

    private void createHeaderItemListener() {
        this.mHeaderItemListener = new HeaderItemModel.OnHeaderChangeListener() { // from class: com.devexpress.navigation.tabs.utils.calculators.HeaderItemSizeCalculator.1
            @Override // com.devexpress.navigation.tabs.models.HeaderItemModel.OnHeaderChangeListener
            public void onViewChanged(View view, View view2) {
                HeaderItemSizeCalculator.this.mNeedRecalculate = true;
            }

            @Override // com.devexpress.navigation.tabs.models.HeaderItemModel.OnHeaderChangeListener
            public void onIconChanged(Drawable drawable, Drawable drawable2) {
                HeaderItemSizeCalculator.this.mNeedRecalculate = true;
            }

            @Override // com.devexpress.navigation.tabs.models.HeaderItemModel.OnHeaderChangeListener
            public void onTextChanged(CharSequence charSequence, CharSequence charSequence2) {
                HeaderItemSizeCalculator.this.mNeedRecalculate = true;
            }

            @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
            public void onHeaderIconPositionChanged(Position position, Position position2) {
                HeaderItemSizeCalculator.this.mNeedRecalculate = true;
            }

            @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
            public void onHeaderVisibleElementsChanged(HeaderElements headerElements, HeaderElements headerElements2) {
                HeaderItemSizeCalculator.this.mNeedRecalculate = true;
            }

            @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
            public void onHeaderWidthOnHorizontalPanelChanged(Object obj, TabSize tabSize, TabSize tabSize2) {
                if (HeaderItemSizeCalculator.this.mIsHorizontal && (obj instanceof HeaderItemModel)) {
                    HeaderItemSizeCalculator.this.mHeaderItemMainSizes.set(HeaderItemSizeCalculator.this.mHeaderItems.indexOf(obj), HeaderItemSizeCalculator.this.convertTabSize(((HeaderItemModel) obj).getActualWidth()));
                    HeaderItemSizeCalculator.this.mNeedRecalculate = true;
                }
            }

            @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
            public void onHeaderHeightOnVerticalPanelChanged(Object obj, TabSize tabSize, TabSize tabSize2) {
                if (HeaderItemSizeCalculator.this.mIsHorizontal || !(obj instanceof HeaderItemModel)) {
                    return;
                }
                HeaderItemSizeCalculator.this.mHeaderItemMainSizes.set(HeaderItemSizeCalculator.this.mHeaderItems.indexOf(obj), HeaderItemSizeCalculator.this.convertTabSize(((HeaderItemModel) obj).getActualHeight()));
                HeaderItemSizeCalculator.this.mNeedRecalculate = true;
            }
        };
    }

    private void listenHeaderItemsChanged() {
        Iterator<IReadonlyHeaderItemModel> it = this.mHeaderItems.iterator();
        while (it.hasNext()) {
            it.next().addListener(this.mHeaderItemListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TabSizeInPixels convertTabSize(TabSize tabSize) {
        return new TabSizeInPixels(this.mSizeConverter.convertDpToPx(tabSize.getSize()), this.mSizeConverter.convertDpToPx(tabSize.getMinSize()), this.mSizeConverter.convertDpToPx(tabSize.getMaxSize()), tabSize.getIsStar(), tabSize.getIsAuto());
    }

    private void refillHeaderItemMainSizes() {
        this.mHeaderItemMainSizes = new ArrayList();
        for (IReadonlyHeaderItemModel iReadonlyHeaderItemModel : this.mHeaderItems) {
            this.mHeaderItemMainSizes.add(convertTabSize(this.mIsHorizontal ? iReadonlyHeaderItemModel.getActualWidth() : iReadonlyHeaderItemModel.getActualHeight()));
        }
    }

    private void refillMeasuredSizes() {
        this.mMeasuredSizes = new HashMap<>(this.mHeaderItems.size());
        Iterator<IReadonlyHeaderItemModel> it = this.mHeaderItems.iterator();
        while (it.hasNext()) {
            this.mMeasuredSizes.put(it.next(), new MeasuredSize(0, 0));
        }
    }

    public void headerItemsUpdated() {
        this.mNeedRecalculate = true;
        refillHeaderItemMainSizes();
        refillMeasuredSizes();
        listenHeaderItemsChanged();
        if (isCrossSizeFixed()) {
            return;
        }
        this.mNeedRecalculate = true;
    }

    private boolean isCrossSizeFixed() {
        boolean z = this.mIsHorizontal;
        return (!z && this.mCrossWidth >= 0) || (z && this.mCrossHeight >= 0);
    }

    public void setOrientation(boolean z) {
        int correctItemSize;
        if (this.mIsHorizontal != z) {
            this.mIsHorizontal = z;
            if (z) {
                correctItemSize = correctItemSize(this.mCrossHeight, this.mMinCrossHeight, this.mMaxCrossHeight);
            } else {
                correctItemSize = correctItemSize(this.mCrossWidth, this.mMinCrossWidth, this.mMaxCrossWidth);
            }
            this.mActualCrossSize = correctItemSize;
            this.mViewPortSize = this.mIsHorizontal ? this.mViewPortWidth : this.mViewPortHeight;
            refillHeaderItemMainSizes();
            this.mNeedRecalculate = true;
        }
    }

    public void setViewPort(int i, int i2) {
        boolean z = this.mIsHorizontal;
        if ((z && this.mViewPortWidth != i) || (!z && this.mViewPortHeight != i2)) {
            this.mNeedRecalculate = true;
        }
        this.mViewPortWidth = i;
        this.mViewPortHeight = i2;
        if (!z) {
            i = i2;
        }
        this.mViewPortSize = i;
    }

    public void setSpacing(int i) {
        if (this.mSpacing != i) {
            this.mSpacing = i;
            this.mNeedRecalculate = true;
        }
    }

    public boolean isMainSizeFitToViewPort() {
        return this.mFitToViewPort;
    }

    public void calculateHeaderItemMainSizes() {
        int[] iArr;
        if (this.mHeaderItems == null) {
            return;
        }
        boolean calculateActualSizes = calculateActualSizes();
        this.mFitToViewPort = calculateActualSizes;
        if (calculateActualSizes) {
            int resetStarSizes = resetStarSizes();
            int calculateFreeSpace = calculateFreeSpace();
            while (resetStarSizes > 0) {
                int i = calculateFreeSpace / resetStarSizes;
                int i2 = 0;
                boolean z = false;
                while (true) {
                    int[] iArr2 = this.mActualMainSizes;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    if (iArr2[i2] < 0) {
                        TabSizeInPixels actualSize = getActualSize(i2);
                        int correctItemSize = correctItemSize(i, actualSize.getMinSize(), actualSize.getMaxSize());
                        if (correctItemSize != i) {
                            this.mActualMainSizes[i2] = correctItemSize;
                            resetStarSizes--;
                            calculateFreeSpace -= correctItemSize;
                            z = true;
                        }
                    }
                    i2++;
                }
                if (!z) {
                    int i3 = -1;
                    int i4 = 0;
                    while (true) {
                        iArr = this.mActualMainSizes;
                        if (i4 >= iArr.length) {
                            break;
                        }
                        if (iArr[i4] < 0) {
                            iArr[i4] = i;
                            calculateFreeSpace -= i;
                            i3 = i4;
                        }
                        i4++;
                    }
                    if (i3 > 0 && calculateFreeSpace > 0) {
                        iArr[i3] = iArr[i3] + calculateFreeSpace;
                    }
                    resetStarSizes = 0;
                }
            }
        }
        this.mNeedRecalculate = false;
    }

    public void setCrossWidth(int i, int i2, int i3) {
        if (this.mCrossWidth == i && this.mMinCrossWidth == i2 && this.mMaxCrossWidth == i3) {
            return;
        }
        this.mCrossWidth = i;
        this.mMinCrossWidth = i2;
        this.mMaxCrossWidth = i3;
        if (this.mIsHorizontal) {
            return;
        }
        this.mActualCrossSize = correctItemSize(i, i2, i3);
        this.mNeedRecalculate = true;
    }

    public void setCrossHeight(int i, int i2, int i3) {
        if (this.mCrossHeight == i && this.mMinCrossHeight == i2 && this.mMaxCrossHeight == i3) {
            return;
        }
        this.mCrossHeight = i;
        this.mMinCrossHeight = i2;
        this.mMaxCrossHeight = i3;
        if (this.mIsHorizontal) {
            this.mActualCrossSize = correctItemSize(i, i2, i3);
            this.mNeedRecalculate = true;
        }
    }

    public void checkSizeChanged(IReadonlyHeaderItemModel iReadonlyHeaderItemModel, int i, int i2) {
        MeasuredSize measuredSize = this.mMeasuredSizes.get(iReadonlyHeaderItemModel);
        if (measuredSize.getWidth() == i && measuredSize.getHeight() == i2) {
            return;
        }
        measuredSize.setSize(i, i2);
        if (this.mNeedRecalculate) {
            return;
        }
        this.mNeedRecalculate = !isCrossSizeFixed();
    }

    public int calculateCrossSize() {
        if (isCrossSizeFixed()) {
            return this.mActualCrossSize;
        }
        int i = 0;
        for (MeasuredSize measuredSize : this.mMeasuredSizes.values()) {
            i = Math.max(i, this.mIsHorizontal ? measuredSize.getHeight() : measuredSize.getWidth());
        }
        this.mNeedRecalculate = false;
        int min = Math.min(this.mViewPortSize, correctItemSize(i, getMinCrossSize(), getMaxCrossSize()));
        this.mActualCrossSize = min;
        return min;
    }

    private int getMinCrossSize() {
        return this.mIsHorizontal ? this.mMinCrossHeight : this.mMinCrossWidth;
    }

    private int getMaxCrossSize() {
        return this.mIsHorizontal ? this.mMaxCrossHeight : this.mMaxCrossWidth;
    }

    public boolean needRecalculate() {
        return this.mNeedRecalculate;
    }

    private int calculateFreeSpace() {
        int spacingSize = getSpacingSize();
        int i = 0;
        while (true) {
            int[] iArr = this.mActualMainSizes;
            if (i < iArr.length) {
                int i2 = iArr[i];
                if (i2 > 0) {
                    spacingSize += i2;
                }
                i++;
            } else {
                return this.mViewPortSize - spacingSize;
            }
        }
    }

    public int getHeaderItemSize(int i) {
        int[] iArr;
        if (this.mHeaderItems == null || (iArr = this.mActualMainSizes) == null) {
            return 0;
        }
        return iArr[i];
    }

    private TabSizeInPixels getActualSize(int i) {
        return this.mHeaderItemMainSizes.get(i);
    }

    private int resetStarSizes() {
        int i = 0;
        for (int i2 = 0; i2 < this.mHeaderItems.size(); i2++) {
            if (getActualSize(i2).getIsStar()) {
                this.mActualMainSizes[i2] = -1;
                i++;
            }
        }
        return i;
    }

    private boolean calculateActualSizes() {
        int correctItemSize;
        int height;
        this.mActualMainSizes = new int[this.mHeaderItems.size()];
        int spacingSize = getSpacingSize();
        for (int i = 0; i < this.mHeaderItems.size(); i++) {
            TabSizeInPixels actualSize = getActualSize(i);
            if (actualSize.getIsAuto()) {
                if (this.mIsHorizontal) {
                    height = this.mMeasuredSizes.get(this.mHeaderItems.get(i)).getWidth();
                } else {
                    height = this.mMeasuredSizes.get(this.mHeaderItems.get(i)).getHeight();
                }
                correctItemSize = correctItemSize(height, actualSize.getMinSize(), actualSize.getMaxSize());
            } else if (actualSize.getIsStar()) {
                correctItemSize = Math.max(actualSize.getMinSize(), 0);
            } else {
                correctItemSize = correctItemSize(actualSize.getSize(), actualSize.getMinSize(), actualSize.getMaxSize());
            }
            this.mActualMainSizes[i] = correctItemSize;
            spacingSize += correctItemSize;
        }
        int i2 = this.mViewPortSize;
        this.mHeaderPanelMainSize = spacingSize <= i2 ? i2 : spacingSize;
        return spacingSize <= i2;
    }

    private int getSpacingSize() {
        return (this.mHeaderItems.size() - 1) * this.mSpacing;
    }

    private int correctItemSize(int i, int i2, int i3) {
        int max = Math.max(Math.max(i, 0), i2);
        return i3 > i2 ? Math.min(max, i3) : max;
    }

    public int getViewPortWidth() {
        return this.mViewPortWidth;
    }

    public int getViewPortHeight() {
        return this.mViewPortHeight;
    }

    public int getActualViewPortWidth() {
        if (!this.mIsHorizontal) {
            int i = this.mCrossWidth;
            if (i > 0) {
                return i;
            }
            int i2 = this.mMaxCrossWidth;
            if (i2 > 0 && i2 < this.mViewPortWidth) {
                return i2;
            }
        }
        return this.mViewPortWidth;
    }

    public int getActualViewPortHeight() {
        if (this.mIsHorizontal) {
            int i = this.mCrossHeight;
            if (i > 0) {
                return i;
            }
            int i2 = this.mMaxCrossHeight;
            if (i2 > 0 && i2 < this.mViewPortHeight) {
                return i2;
            }
        }
        return this.mViewPortHeight;
    }
}
