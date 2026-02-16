package com.devexpress.navigation.tabs.models;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.devexpress.navigation.tabcontrol.TabControlAppearance;
import com.devexpress.navigation.tabs.models.Padding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class HeaderItemAppearance {
    public static final int DEFAULT_ITEM_BACKGROUND_COLOR = 0;
    public static final int DEFAULT_PRIMARY_COLOR = Color.parseColor("#6200EE");
    public static final float DEFAULT_SHADOW_SIZE = 5.0f;
    public static final int ITEM_ICON_SPACING = 5;
    public static final int ITEM_LEFT_RIGHT_PADDINGS = 16;
    public static final int ITEM_MAX_WIDTH = 360;
    public static final int ITEM_MIN_WIDTH = 90;
    public static final int ITEM_MIN_WIDTH_ICON_ONLY = 48;
    public static final int ITEM_ONELINE_HEIGHT = 48;
    public static final int ITEM_TOP_BOTTOM_PADDINGS = 12;
    public static final int ITEM_TWOLINE_HEIGHT = 72;
    protected float mItemCornerRadius;
    protected int mItemHeaderColor;
    protected Typeface mItemHeaderFont;
    protected float mItemHeaderFontSize;
    protected float mItemHeaderIconSpacing;
    protected Padding mItemHeaderPadding;
    protected int mItemIconColor;
    protected List<TabControlAppearance.OnAppearancePropertyChangeListener> mOnAppearancePropertyChangeListeners;
    protected int mSelectedItemHeaderBackgroundColor;
    protected int mSelectedItemHeaderColor;
    protected int mSelectedItemIconColor;

    public HeaderItemAppearance() {
        int i = DEFAULT_PRIMARY_COLOR;
        this.mItemHeaderColor = i;
        this.mItemIconColor = i;
        this.mItemHeaderIconSpacing = 5.0f;
        this.mSelectedItemHeaderColor = i;
        this.mSelectedItemIconColor = i;
        this.mSelectedItemHeaderBackgroundColor = 0;
        this.mItemHeaderFont = Typeface.DEFAULT;
        this.mItemHeaderFontSize = -1.0f;
        this.mItemCornerRadius = -1.0f;
        this.mOnAppearancePropertyChangeListeners = new ArrayList();
        setItemHeaderPadding(createDefaultPadding());
    }

    public void setItemHeaderColor(int i) {
        if (this.mItemHeaderColor != i) {
            this.mItemHeaderColor = i;
            raiseOnItemStylePropertyChanged(StyleProperty.PRIMARY_COLOR);
        }
    }

    public int getItemHeaderColor() {
        return this.mItemHeaderColor;
    }

    public void setIconColor(int i) {
        if (this.mItemIconColor != i) {
            this.mItemIconColor = i;
            raiseOnItemStylePropertyChanged(StyleProperty.ICON_COLOR);
        }
    }

    public int getIconColor() {
        return this.mItemIconColor;
    }

    public void setItemHeaderFont(Typeface typeface) {
        if (this.mItemHeaderFont != typeface) {
            this.mItemHeaderFont = typeface;
            raiseOnItemStylePropertyChanged(StyleProperty.FONT);
        }
    }

    public float getItemHeaderFontSize() {
        return this.mItemHeaderFontSize;
    }

    public void setItemHeaderFontSize(float f) {
        if (this.mItemHeaderFontSize != f) {
            this.mItemHeaderFontSize = f;
            raiseOnItemStylePropertyChanged(StyleProperty.FONT);
        }
    }

    public float getItemCornerRadius() {
        return this.mItemCornerRadius;
    }

    public void setItemCornerRadius(float f) {
        if (this.mItemCornerRadius != f) {
            this.mItemCornerRadius = f;
            raiseOnItemCornerRadiusPropertyChanged();
        }
    }

    public Typeface getItemHeaderFont() {
        return this.mItemHeaderFont;
    }

    public void setItemHeaderIconSpacing(float f) {
        if (this.mItemHeaderIconSpacing != f) {
            this.mItemHeaderIconSpacing = f;
            raiseOnItemSpacingPropertyChanged();
        }
    }

    public float getItemHeaderIconSpacing() {
        return this.mItemHeaderIconSpacing;
    }

    public Padding getActualPadding() {
        return this.mItemHeaderPadding;
    }

    public Padding getItemHeaderPadding() {
        return this.mItemHeaderPadding;
    }

    public void setItemHeaderPadding(Padding padding) {
        if (padding == this.mItemHeaderPadding || padding == null) {
            return;
        }
        this.mItemHeaderPadding = padding;
        padding.setPaddingChangeListener(new Padding.OnPaddingChangeListener() { // from class: com.devexpress.navigation.tabs.models.HeaderItemAppearance.1
            @Override // com.devexpress.navigation.tabs.models.Padding.OnPaddingChangeListener
            public void onPaddingChanged() {
                HeaderItemAppearance.this.raiseOnItemPaddingPropertyChanged();
            }
        });
        raiseOnItemPaddingPropertyChanged();
    }

    protected Padding createDefaultPadding() {
        Padding padding = new Padding();
        padding.setHorizontal(16.0f);
        padding.setVertical(12.0f);
        return padding;
    }

    public void setSelectedIconColor(int i) {
        if (this.mSelectedItemIconColor != i) {
            this.mSelectedItemIconColor = i;
            raiseOnItemSelectedPropertyChanged(SelectedStyleProperty.ICON_COLOR);
        }
    }

    public int getSelectedIconColor() {
        return this.mSelectedItemIconColor;
    }

    public void setSelectedItemHeaderColor(int i) {
        if (this.mSelectedItemHeaderColor != i) {
            this.mSelectedItemHeaderColor = i;
            raiseOnItemSelectedPropertyChanged(SelectedStyleProperty.PRIMARY_COLOR);
        }
    }

    public int getSelectedItemHeaderColor() {
        return this.mSelectedItemHeaderColor;
    }

    public void setSelectedItemHeaderBackgroundColor(int i) {
        if (this.mSelectedItemHeaderBackgroundColor != i) {
            this.mSelectedItemHeaderBackgroundColor = i;
            raiseOnItemSelectedPropertyChanged(SelectedStyleProperty.BACKGROUND_COLOR);
        }
    }

    public int getSelectedItemHeaderBackgroundColor() {
        return this.mSelectedItemHeaderBackgroundColor;
    }

    public Drawable getBackgroundWithRadius(int i) {
        float f = i;
        if (getItemCornerRadius() != -1.0f) {
            f = getItemCornerRadius();
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(new float[]{f, f, f, f, f, f, f, f});
        gradientDrawable.setColor(getSelectedItemHeaderBackgroundColor());
        return gradientDrawable;
    }

    public void addOnAppearanceProperyChangeListener(TabControlAppearance.OnAppearancePropertyChangeListener onAppearancePropertyChangeListener) {
        if (this.mOnAppearancePropertyChangeListeners.contains(onAppearancePropertyChangeListener)) {
            return;
        }
        this.mOnAppearancePropertyChangeListeners.add(onAppearancePropertyChangeListener);
    }

    public void removeOnAppearanceProperyChangeListener(TabControlAppearance.OnAppearancePropertyChangeListener onAppearancePropertyChangeListener) {
        this.mOnAppearancePropertyChangeListeners.remove(onAppearancePropertyChangeListener);
    }

    public void clearOnAppearanceProperyChangeListener() {
        this.mOnAppearancePropertyChangeListeners.clear();
    }

    protected void raiseOnItemStylePropertyChanged(StyleProperty styleProperty) {
        Iterator<TabControlAppearance.OnAppearancePropertyChangeListener> it = this.mOnAppearancePropertyChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onItemStylePropertyChanged(styleProperty);
        }
    }

    protected void raiseOnItemCornerRadiusPropertyChanged() {
        Iterator<TabControlAppearance.OnAppearancePropertyChangeListener> it = this.mOnAppearancePropertyChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onItemCornerRadiusPropertyChanged();
        }
    }

    protected void raiseOnItemSpacingPropertyChanged() {
        Iterator<TabControlAppearance.OnAppearancePropertyChangeListener> it = this.mOnAppearancePropertyChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onItemSpacingPropertyChanged();
        }
    }

    protected void raiseOnItemPaddingPropertyChanged() {
        Iterator<TabControlAppearance.OnAppearancePropertyChangeListener> it = this.mOnAppearancePropertyChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onItemPaddingPropertyChanged();
        }
    }

    protected void raiseOnItemSelectedPropertyChanged(SelectedStyleProperty selectedStyleProperty) {
        Iterator<TabControlAppearance.OnAppearancePropertyChangeListener> it = this.mOnAppearancePropertyChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onItemSelectedPropertyChanged(selectedStyleProperty);
        }
    }
}
