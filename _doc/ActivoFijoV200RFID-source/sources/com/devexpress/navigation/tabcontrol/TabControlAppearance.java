package com.devexpress.navigation.tabcontrol;

import android.graphics.Color;
import com.devexpress.navigation.tabs.models.HeaderItemAppearance;
import com.devexpress.navigation.tabs.models.Padding;
import com.devexpress.navigation.tabs.models.SelectedStyleProperty;
import com.devexpress.navigation.tabs.models.StyleProperty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class TabControlAppearance {
    public static final int DEFAULT_SHADOW_COLOR = Color.parseColor("#BB000000");
    public static final int DEFAULT_SHADOW_COLOR_END = 0;
    public static final int DEFAULT_SHADOW_SIZE = 5;
    public static final int INDICATOR_SIZE = 3;
    public static final int MATCH_SHADOW_HEIGHT = -1;
    public static final int SCROLLABLE_MODE_INDENT = 52;
    private int mHeaderPanelBorderColor;
    private float mHeaderPanelBorderHeight;
    private float mHeaderPanelItemSpacing;
    private Padding mHeaderPanelPadding;
    private int mHeaderIndicatorColor = HeaderItemAppearance.DEFAULT_PRIMARY_COLOR;
    private boolean mHeaderIndicatorVisibility = true;
    private int mHeaderPanelBackgroundColor = -1;
    private boolean mHeaderPanelBorderVisibility = false;
    private int mHeaderPanelShadowColorStart = DEFAULT_SHADOW_COLOR;
    private int mHeaderPanelShadowRadius = -1;
    private boolean mHeaderPanelShadowVisibility = false;
    private List<OnAppearancePropertyChangeListener> mOnAppearancePropertyChangeListeners = new ArrayList();
    private OnAppearancePropertyChangeListener mOnAppearancePropertyChangeListener = new OnAppearancePropertyChangeListener() { // from class: com.devexpress.navigation.tabcontrol.TabControlAppearance.1
        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onItemStylePropertyChanged(StyleProperty styleProperty) {
            TabControlAppearance.this.raiseOnItemStyleProperyChanged(styleProperty);
        }

        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onItemPaddingPropertyChanged() {
            TabControlAppearance.this.raiseOnItemPaddingProperyChanged();
        }

        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onItemSpacingPropertyChanged() {
            TabControlAppearance.this.raiseOnItemSpacingProperyChanged();
        }

        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onItemCornerRadiusPropertyChanged() {
            TabControlAppearance.this.raiseOnItemCornerRadiusProperyChanged();
        }

        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onItemSelectedPropertyChanged(SelectedStyleProperty selectedStyleProperty) {
            TabControlAppearance.this.raiseOnItemAppearanceSelectedProperyChanged(selectedStyleProperty);
        }

        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onPanelIndentPropertyChanged() {
            TabControlAppearance.this.raiseOnPanelIndentProperyChanged();
        }

        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onPanelSpacingPropertyChanged() {
            TabControlAppearance.this.raiseOnPanelSpacingProperyChanged();
        }

        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onPanelPaddingPropertyChanged() {
            TabControlAppearance.this.raiseOnPanelPaddingProperyChanged();
        }

        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onPanelBackgroundPropertyChanged() {
            TabControlAppearance.this.raiseOnPanelBackgroundProperyChanged();
        }

        @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
        public void onIndicatorPropertyChanged() {
            TabControlAppearance.this.raiseOnIndicatorAppearanceProperyChanged();
        }
    };
    private HeaderItemAppearance mHeaderItemAppearance = getHeaderItemAppearance();
    private float mHeaderPanelIndent = 52.0f;
    private float mHeaderIndicatorHeight = 3.0f;
    private float mHeaderPanelShadowHeight = 5.0f;

    public interface OnAppearancePropertyChangeListener {
        void onIndicatorPropertyChanged();

        void onItemCornerRadiusPropertyChanged();

        void onItemPaddingPropertyChanged();

        void onItemSelectedPropertyChanged(SelectedStyleProperty selectedStyleProperty);

        void onItemSpacingPropertyChanged();

        void onItemStylePropertyChanged(StyleProperty styleProperty);

        void onPanelBackgroundPropertyChanged();

        void onPanelIndentPropertyChanged();

        void onPanelPaddingPropertyChanged();

        void onPanelSpacingPropertyChanged();
    }

    public TabControlAppearance() {
        Padding padding = new Padding();
        this.mHeaderPanelPadding = padding;
        padding.setTop(52.0f);
        this.mHeaderPanelPadding.setBottom(52.0f);
    }

    public float getHeaderIndicatorHeight() {
        return this.mHeaderIndicatorHeight;
    }

    public void setHeaderIndicatorHeight(float f) {
        if (f != this.mHeaderIndicatorHeight) {
            this.mHeaderIndicatorHeight = f;
            raiseOnIndicatorAppearanceProperyChanged();
        }
    }

    public int getHeaderIndicatorColor() {
        return this.mHeaderIndicatorColor;
    }

    public void setHeaderIndicatorColor(int i) {
        if (i != this.mHeaderIndicatorColor) {
            this.mHeaderIndicatorColor = i;
            raiseOnIndicatorAppearanceProperyChanged();
        }
    }

    public boolean getHeaderIndicatorVisibility() {
        return this.mHeaderIndicatorVisibility;
    }

    public void setHeaderIndicatorVisibility(boolean z) {
        if (z != this.mHeaderIndicatorVisibility) {
            this.mHeaderIndicatorVisibility = z;
            raiseOnIndicatorAppearanceProperyChanged();
        }
    }

    public void setHeaderItemAppearance(HeaderItemAppearance headerItemAppearance) {
        HeaderItemAppearance headerItemAppearance2 = this.mHeaderItemAppearance;
        if (headerItemAppearance2 != null) {
            headerItemAppearance2.removeOnAppearanceProperyChangeListener(this.mOnAppearancePropertyChangeListener);
        }
        this.mHeaderItemAppearance = headerItemAppearance;
        headerItemAppearance.addOnAppearanceProperyChangeListener(this.mOnAppearancePropertyChangeListener);
    }

    public HeaderItemAppearance getHeaderItemAppearance() {
        if (this.mHeaderItemAppearance == null) {
            HeaderItemAppearance headerItemAppearance = new HeaderItemAppearance();
            this.mHeaderItemAppearance = headerItemAppearance;
            headerItemAppearance.addOnAppearanceProperyChangeListener(this.mOnAppearancePropertyChangeListener);
        }
        return this.mHeaderItemAppearance;
    }

    public void setHeaderPanelBackgroundColor(int i) {
        if (i != this.mHeaderPanelBackgroundColor) {
            this.mHeaderPanelBackgroundColor = i;
            raiseOnPanelBackgroundProperyChanged();
        }
    }

    public int getHeaderPanelBackgroundColor() {
        return this.mHeaderPanelBackgroundColor;
    }

    public void setHeaderPanelItemSpacing(float f) {
        if (f != this.mHeaderPanelItemSpacing) {
            this.mHeaderPanelItemSpacing = f;
            raiseOnPanelSpacingProperyChanged();
        }
    }

    public Padding getHeaderPanelPadding() {
        return this.mHeaderPanelPadding;
    }

    public void setHeaderPanelPadding(Padding padding) {
        if (padding != this.mHeaderPanelPadding) {
            this.mHeaderPanelPadding = padding;
            raiseOnPanelSpacingProperyChanged();
        }
    }

    public float getHeaderPanelItemSpacing() {
        return this.mHeaderPanelItemSpacing;
    }

    public float getHeaderPanelBorderHeight() {
        return this.mHeaderPanelBorderHeight;
    }

    public void setHeaderPanelBorderHeight(float f) {
        if (f != this.mHeaderPanelBorderHeight) {
            this.mHeaderPanelBorderHeight = f;
            raiseOnPanelBackgroundProperyChanged();
        }
    }

    public int getHeaderPanelBorderColor() {
        return this.mHeaderPanelBorderColor;
    }

    public void setHeaderPanelBorderColor(int i) {
        if (i != this.mHeaderPanelBorderColor) {
            this.mHeaderPanelBorderColor = i;
            raiseOnPanelBackgroundProperyChanged();
        }
    }

    public boolean getHeaderPanelBorderVisibility() {
        return this.mHeaderPanelBorderVisibility;
    }

    public void setHeaderPanelBorderVisibility(boolean z) {
        if (z != this.mHeaderPanelBorderVisibility) {
            this.mHeaderPanelBorderVisibility = z;
            raiseOnPanelBackgroundProperyChanged();
        }
    }

    public float getHeaderPanelShadowHeight() {
        return this.mHeaderPanelShadowHeight;
    }

    public void setHeaderPanelShadowHeight(float f) {
        if (f != this.mHeaderPanelShadowHeight) {
            this.mHeaderPanelShadowHeight = f;
            raiseOnPanelBackgroundProperyChanged();
        }
    }

    public int getHeaderPanelShadowColorStart() {
        return this.mHeaderPanelShadowColorStart;
    }

    public void setHeaderPanelShadowColorStart(int i) {
        if (i != this.mHeaderPanelShadowColorStart) {
            this.mHeaderPanelShadowColorStart = i;
            raiseOnPanelBackgroundProperyChanged();
        }
    }

    public int getHeaderPanelShadowRadius() {
        return this.mHeaderPanelShadowRadius;
    }

    public void setHeaderPanelShadowRadius(int i) {
        if (i != this.mHeaderPanelShadowRadius) {
            this.mHeaderPanelShadowRadius = i;
            raiseOnPanelBackgroundProperyChanged();
        }
    }

    public boolean getHeaderPanelShadowVisibility() {
        return this.mHeaderPanelShadowVisibility;
    }

    public void setHeaderPanelShadowVisibility(boolean z) {
        if (z != this.mHeaderPanelShadowVisibility) {
            this.mHeaderPanelShadowVisibility = z;
            raiseOnPanelBackgroundProperyChanged();
        }
    }

    public float getHeaderPanelIndent() {
        return this.mHeaderPanelIndent;
    }

    public void setHeaderPanelIndent(float f) {
        if (f != getHeaderPanelIndent()) {
            this.mHeaderPanelIndent = f;
            raiseOnPanelIndentProperyChanged();
        }
    }

    public void addOnAppearanceProperyChangeListener(OnAppearancePropertyChangeListener onAppearancePropertyChangeListener) {
        if (this.mOnAppearancePropertyChangeListeners.contains(onAppearancePropertyChangeListener)) {
            return;
        }
        this.mOnAppearancePropertyChangeListeners.add(onAppearancePropertyChangeListener);
    }

    public void removeOnAppearanceProperyChangeListener(OnAppearancePropertyChangeListener onAppearancePropertyChangeListener) {
        this.mOnAppearancePropertyChangeListeners.remove(onAppearancePropertyChangeListener);
    }

    public void clearOnAppearanceProperyChangeListener() {
        this.mOnAppearancePropertyChangeListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void raiseOnItemStyleProperyChanged(StyleProperty styleProperty) {
        Iterator<OnAppearancePropertyChangeListener> it = this.mOnAppearancePropertyChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onItemStylePropertyChanged(styleProperty);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void raiseOnItemPaddingProperyChanged() {
        Iterator<OnAppearancePropertyChangeListener> it = this.mOnAppearancePropertyChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onItemPaddingPropertyChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void raiseOnItemSpacingProperyChanged() {
        Iterator<OnAppearancePropertyChangeListener> it = this.mOnAppearancePropertyChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onItemSpacingPropertyChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void raiseOnItemCornerRadiusProperyChanged() {
        Iterator<OnAppearancePropertyChangeListener> it = this.mOnAppearancePropertyChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onItemCornerRadiusPropertyChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void raiseOnItemAppearanceSelectedProperyChanged(SelectedStyleProperty selectedStyleProperty) {
        Iterator<OnAppearancePropertyChangeListener> it = this.mOnAppearancePropertyChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onItemSelectedPropertyChanged(selectedStyleProperty);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void raiseOnPanelIndentProperyChanged() {
        Iterator<OnAppearancePropertyChangeListener> it = this.mOnAppearancePropertyChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onPanelIndentPropertyChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void raiseOnPanelSpacingProperyChanged() {
        Iterator<OnAppearancePropertyChangeListener> it = this.mOnAppearancePropertyChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onPanelSpacingPropertyChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void raiseOnPanelPaddingProperyChanged() {
        Iterator<OnAppearancePropertyChangeListener> it = this.mOnAppearancePropertyChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onPanelPaddingPropertyChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void raiseOnPanelBackgroundProperyChanged() {
        Iterator<OnAppearancePropertyChangeListener> it = this.mOnAppearancePropertyChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onPanelBackgroundPropertyChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void raiseOnIndicatorAppearanceProperyChanged() {
        Iterator<OnAppearancePropertyChangeListener> it = this.mOnAppearancePropertyChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onIndicatorPropertyChanged();
        }
    }
}
