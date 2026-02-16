package com.devexpress.navigation.tabs.models;

import android.graphics.Typeface;
import com.devexpress.navigation.tabcontrol.TabControlAppearance;

/* loaded from: classes2.dex */
public class HeaderSingleItemAppearance extends HeaderItemAppearance {
    private boolean mItemHeaderColorSetted = false;
    private boolean mItemIconColorSetted = false;
    private boolean mSelectedItemHeaderColorSetted = false;
    private boolean mSelectedItemIconColorSetted = false;
    private boolean mSelectedItemHeaderBackgroundColorSetted = false;
    private boolean mItemHeaderIconSpacingSetted = false;
    private boolean mItemHeaderFontSetted = false;
    private boolean mItemHeaderFontSizeSetted = false;
    private TabControlAppearance.OnAppearancePropertyChangeListener commonAppearanceListener = new TabControlAppearance.OnAppearancePropertyChangeListener() { // from class: com.devexpress.navigation.tabs.models.HeaderSingleItemAppearance.1
        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onIndicatorPropertyChanged() {
        }

        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onPanelBackgroundPropertyChanged() {
        }

        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onPanelIndentPropertyChanged() {
        }

        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onPanelPaddingPropertyChanged() {
        }

        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onPanelSpacingPropertyChanged() {
        }

        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onItemSelectedPropertyChanged(SelectedStyleProperty selectedStyleProperty) {
            if (HeaderSingleItemAppearance.this.needRaiseSelectedPropertyChanged(selectedStyleProperty)) {
                HeaderSingleItemAppearance.this.raiseOnItemSelectedPropertyChanged(selectedStyleProperty);
            }
        }

        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onItemPaddingPropertyChanged() {
            if (HeaderSingleItemAppearance.this.needRaisePaddingPropertyChanged()) {
                HeaderSingleItemAppearance.this.raiseOnItemPaddingPropertyChanged();
            }
        }

        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onItemSpacingPropertyChanged() {
            if (HeaderSingleItemAppearance.this.needRaiseSpacingPropertyChanged()) {
                HeaderSingleItemAppearance.this.raiseOnItemSpacingPropertyChanged();
            }
        }

        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onItemCornerRadiusPropertyChanged() {
            if (HeaderSingleItemAppearance.this.needRaiseCornerRadiusPropertyChanged()) {
                HeaderSingleItemAppearance.this.raiseOnItemCornerRadiusPropertyChanged();
            }
        }

        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onItemStylePropertyChanged(StyleProperty styleProperty) {
            if (HeaderSingleItemAppearance.this.needRaiseStylePropertyChanged(styleProperty)) {
                HeaderSingleItemAppearance.this.raiseOnItemStylePropertyChanged(styleProperty);
            }
        }
    };
    private HeaderItemAppearance mCommonAppearance = null;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needRaiseCornerRadiusPropertyChanged() {
        return true;
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    protected Padding createDefaultPadding() {
        return null;
    }

    public void setCommonAppearance(HeaderItemAppearance headerItemAppearance) {
        HeaderItemAppearance headerItemAppearance2 = this.mCommonAppearance;
        if (headerItemAppearance2 != null) {
            headerItemAppearance2.removeOnAppearanceProperyChangeListener(this.commonAppearanceListener);
        }
        this.mCommonAppearance = headerItemAppearance;
        if (headerItemAppearance != null) {
            headerItemAppearance.addOnAppearanceProperyChangeListener(this.commonAppearanceListener);
        }
    }

    public HeaderItemAppearance getCommonAppearance() {
        return this.mCommonAppearance;
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    public int getItemHeaderColor() {
        return this.mItemHeaderColorSetted ? this.mItemHeaderColor : this.mCommonAppearance.getItemHeaderColor();
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    public void setItemHeaderColor(int i) {
        if (i == this.mItemHeaderColor && this.mItemHeaderColorSetted) {
            return;
        }
        this.mItemHeaderColorSetted = true;
        this.mItemHeaderColor = i;
        raiseOnItemStylePropertyChanged(StyleProperty.PRIMARY_COLOR);
    }

    public void resetItemHeaderColor() {
        if (this.mItemHeaderColorSetted) {
            this.mItemHeaderColorSetted = false;
            raiseOnItemStylePropertyChanged(StyleProperty.PRIMARY_COLOR);
        }
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    public int getIconColor() {
        return this.mItemIconColorSetted ? this.mItemIconColor : this.mCommonAppearance.getIconColor();
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    public void setIconColor(int i) {
        if (this.mItemIconColor == i && this.mItemIconColorSetted) {
            return;
        }
        this.mItemIconColorSetted = true;
        this.mItemIconColor = i;
        raiseOnItemStylePropertyChanged(StyleProperty.ICON_COLOR);
    }

    public void resetIconColor() {
        if (this.mItemIconColorSetted) {
            this.mItemIconColorSetted = false;
            raiseOnItemStylePropertyChanged(StyleProperty.ICON_COLOR);
        }
    }

    public boolean needPaintIcon() {
        return this.mItemIconColorSetted;
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    public int getSelectedItemHeaderColor() {
        return this.mSelectedItemHeaderColorSetted ? this.mSelectedItemHeaderColor : this.mCommonAppearance.getSelectedItemHeaderColor();
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    public void setSelectedItemHeaderColor(int i) {
        if (this.mSelectedItemHeaderColor == i && this.mSelectedItemHeaderColorSetted) {
            return;
        }
        this.mSelectedItemHeaderColorSetted = true;
        this.mSelectedItemHeaderColor = i;
        raiseOnItemSelectedPropertyChanged(SelectedStyleProperty.PRIMARY_COLOR);
    }

    public void resetSelectedItemHeaderColor() {
        if (this.mSelectedItemHeaderColorSetted) {
            this.mSelectedItemHeaderColorSetted = false;
            raiseOnItemSelectedPropertyChanged(SelectedStyleProperty.PRIMARY_COLOR);
        }
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    public int getSelectedIconColor() {
        return this.mSelectedItemIconColorSetted ? this.mSelectedItemIconColor : this.mCommonAppearance.getSelectedIconColor();
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    public void setSelectedIconColor(int i) {
        if (this.mSelectedItemIconColor == i && this.mSelectedItemIconColorSetted) {
            return;
        }
        this.mSelectedItemIconColorSetted = true;
        this.mSelectedItemIconColor = i;
        raiseOnItemSelectedPropertyChanged(SelectedStyleProperty.ICON_COLOR);
    }

    public void resetSelectedIconColor() {
        if (this.mSelectedItemIconColorSetted) {
            this.mSelectedItemIconColorSetted = false;
            raiseOnItemSelectedPropertyChanged(SelectedStyleProperty.ICON_COLOR);
        }
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    public int getSelectedItemHeaderBackgroundColor() {
        return this.mSelectedItemHeaderBackgroundColorSetted ? this.mSelectedItemHeaderBackgroundColor : this.mCommonAppearance.getSelectedItemHeaderBackgroundColor();
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    public void setSelectedItemHeaderBackgroundColor(int i) {
        if (this.mSelectedItemHeaderBackgroundColor == i && this.mSelectedItemHeaderBackgroundColorSetted) {
            return;
        }
        this.mSelectedItemHeaderBackgroundColorSetted = true;
        this.mSelectedItemHeaderBackgroundColor = i;
        raiseOnItemSelectedPropertyChanged(SelectedStyleProperty.BACKGROUND_COLOR);
    }

    public void resetSelectedItemHeaderBackgroundColor() {
        if (this.mSelectedItemHeaderBackgroundColorSetted) {
            this.mSelectedItemHeaderBackgroundColorSetted = false;
            raiseOnItemSelectedPropertyChanged(SelectedStyleProperty.BACKGROUND_COLOR);
        }
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    public float getItemHeaderIconSpacing() {
        return this.mItemHeaderIconSpacingSetted ? this.mItemHeaderIconSpacing : this.mCommonAppearance.getItemHeaderIconSpacing();
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    public void setItemHeaderIconSpacing(float f) {
        if (this.mItemHeaderIconSpacing == f && this.mItemHeaderIconSpacingSetted) {
            return;
        }
        this.mItemHeaderIconSpacingSetted = true;
        this.mItemHeaderIconSpacing = f;
        raiseOnItemSpacingPropertyChanged();
    }

    public void resetItemHeaderIconSpacing() {
        if (this.mItemHeaderIconSpacingSetted) {
            this.mItemHeaderIconSpacingSetted = false;
            raiseOnItemSpacingPropertyChanged();
        }
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    public Padding getActualPadding() {
        return this.mItemHeaderPadding != null ? this.mItemHeaderPadding : this.mCommonAppearance.getItemHeaderPadding();
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    public void setItemHeaderPadding(Padding padding) {
        if (padding != null) {
            super.setItemHeaderPadding(padding);
        } else {
            this.mItemHeaderPadding = padding;
        }
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    public void setItemHeaderFont(Typeface typeface) {
        if (this.mItemHeaderFont == typeface && this.mItemHeaderFontSetted) {
            return;
        }
        this.mItemHeaderFont = typeface;
        this.mItemHeaderFontSetted = true;
        raiseOnItemStylePropertyChanged(StyleProperty.FONT);
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    public Typeface getItemHeaderFont() {
        return this.mItemHeaderFontSetted ? this.mItemHeaderFont : this.mCommonAppearance.getItemHeaderFont();
    }

    public void resetItemHeaderFont() {
        if (this.mItemHeaderFontSetted) {
            this.mItemHeaderFontSetted = false;
            raiseOnItemStylePropertyChanged(StyleProperty.FONT);
        }
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    public void setItemHeaderFontSize(float f) {
        if (this.mItemHeaderFontSize == f && this.mItemHeaderFontSizeSetted) {
            return;
        }
        this.mItemHeaderFontSize = f;
        this.mItemHeaderFontSizeSetted = true;
        raiseOnItemStylePropertyChanged(StyleProperty.FONT);
    }

    @Override // com.devexpress.navigation.tabs.models.HeaderItemAppearance
    public float getItemHeaderFontSize() {
        return this.mItemHeaderFontSizeSetted ? this.mItemHeaderFontSize : this.mCommonAppearance.getItemHeaderFontSize();
    }

    public void resetItemHeaderFontSize() {
        if (this.mItemHeaderFontSizeSetted) {
            this.mItemHeaderFontSizeSetted = false;
            raiseOnItemStylePropertyChanged(StyleProperty.FONT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needRaiseSelectedPropertyChanged(SelectedStyleProperty selectedStyleProperty) {
        if (selectedStyleProperty == SelectedStyleProperty.PRIMARY_COLOR && this.mSelectedItemHeaderColorSetted) {
            return false;
        }
        if (selectedStyleProperty == SelectedStyleProperty.ICON_COLOR && this.mSelectedItemIconColorSetted) {
            return false;
        }
        return (selectedStyleProperty == SelectedStyleProperty.BACKGROUND_COLOR && this.mSelectedItemHeaderBackgroundColorSetted) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needRaisePaddingPropertyChanged() {
        return this.mItemHeaderPadding == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needRaiseSpacingPropertyChanged() {
        return !this.mItemHeaderIconSpacingSetted;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needRaiseStylePropertyChanged(StyleProperty styleProperty) {
        if (styleProperty == StyleProperty.PRIMARY_COLOR && this.mItemHeaderColorSetted) {
            return false;
        }
        return (styleProperty == StyleProperty.ICON_COLOR && this.mItemIconColorSetted) ? false : true;
    }
}
