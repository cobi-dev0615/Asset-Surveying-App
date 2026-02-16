package com.devexpress.navigation.tabs.models;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.devexpress.navigation.common.HeaderElements;
import com.devexpress.navigation.common.Position;
import com.devexpress.navigation.tabcontrol.TabControlAppearance;
import com.devexpress.navigation.tabs.models.TabItemSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class HeaderItemModel implements IReadonlyHeaderItemModel {
    private TabItemSettings.OnSettingsChangeListener mCommonSettingsListener;
    private TabSize mHeight;
    private Drawable mIcon;
    private TabItemSettings mSettings;
    private CharSequence mText;
    private HeaderItemModel mThis;
    private View mView;
    private TabSize mWidth;
    private Position mHeaderIconPosition = Position.Default;
    private HeaderElements mHeaderVisibleElements = HeaderElements.Default;
    private List<OnHeaderChangeListener> mListeners = new ArrayList();
    private HeaderSingleItemAppearance mHeaderItemAppearance = null;

    public interface OnHeaderChangeListener extends TabItemSettings.OnSettingsChangeListener {
        void onIconChanged(Drawable drawable, Drawable drawable2);

        void onTextChanged(CharSequence charSequence, CharSequence charSequence2);

        void onViewChanged(View view, View view2);
    }

    public HeaderItemModel(CharSequence charSequence, Drawable drawable) {
        this.mText = charSequence;
        this.mIcon = drawable;
    }

    public HeaderItemModel(View view) {
        this.mView = view;
    }

    private void tryCreateListener() {
        if (this.mCommonSettingsListener != null) {
            return;
        }
        this.mThis = this;
        this.mCommonSettingsListener = new TabItemSettings.OnSettingsChangeListener() { // from class: com.devexpress.navigation.tabs.models.HeaderItemModel.1
            @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
            public void onHeaderIconPositionChanged(Position position, Position position2) {
                if (HeaderItemModel.this.mHeaderIconPosition != Position.Default || HeaderItemModel.this.mListeners == null) {
                    return;
                }
                Iterator it = HeaderItemModel.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((OnHeaderChangeListener) it.next()).onHeaderIconPositionChanged(position, position2);
                }
            }

            @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
            public void onHeaderVisibleElementsChanged(HeaderElements headerElements, HeaderElements headerElements2) {
                if (HeaderItemModel.this.mHeaderVisibleElements != HeaderElements.Default || HeaderItemModel.this.mListeners == null) {
                    return;
                }
                Iterator it = HeaderItemModel.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((OnHeaderChangeListener) it.next()).onHeaderVisibleElementsChanged(headerElements, headerElements2);
                }
            }

            @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
            public void onHeaderWidthOnHorizontalPanelChanged(Object obj, TabSize tabSize, TabSize tabSize2) {
                if (HeaderItemModel.this.mWidth != null || HeaderItemModel.this.mListeners == null) {
                    return;
                }
                Iterator it = HeaderItemModel.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((OnHeaderChangeListener) it.next()).onHeaderWidthOnHorizontalPanelChanged(HeaderItemModel.this.mThis, tabSize, tabSize2);
                }
            }

            @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
            public void onHeaderHeightOnVerticalPanelChanged(Object obj, TabSize tabSize, TabSize tabSize2) {
                if (HeaderItemModel.this.mHeight != null || HeaderItemModel.this.mListeners == null) {
                    return;
                }
                Iterator it = HeaderItemModel.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((OnHeaderChangeListener) it.next()).onHeaderHeightOnVerticalPanelChanged(HeaderItemModel.this.mThis, tabSize, tabSize2);
                }
            }
        };
    }

    public void setCommonSettings(TabItemSettings tabItemSettings) {
        tryCreateListener();
        TabItemSettings tabItemSettings2 = this.mSettings;
        if (tabItemSettings2 != null) {
            tabItemSettings2.removeNativeListener(this.mCommonSettingsListener);
        }
        this.mSettings = tabItemSettings;
        if (tabItemSettings != null) {
            tabItemSettings.addNativeListener(this.mCommonSettingsListener);
        }
    }

    @Override // com.devexpress.navigation.tabs.models.IReadonlyHeaderItemModel
    public CharSequence getText() {
        return this.mText;
    }

    @Override // com.devexpress.navigation.tabs.models.IReadonlyHeaderItemModel
    public Drawable getIcon() {
        return this.mIcon;
    }

    @Override // com.devexpress.navigation.tabs.models.IReadonlyHeaderItemModel
    public View getView() {
        return this.mView;
    }

    @Override // com.devexpress.navigation.tabs.models.IReadonlyHeaderItemModel
    public TabSize getActualWidth() {
        TabSize tabSize = this.mWidth;
        return tabSize != null ? tabSize : this.mSettings.getItemHeaderWidth();
    }

    @Override // com.devexpress.navigation.tabs.models.IReadonlyHeaderItemModel
    public TabSize getActualHeight() {
        TabSize tabSize = this.mHeight;
        return tabSize != null ? tabSize : this.mSettings.getItemHeaderHeight();
    }

    public TabItemSettings getCommonSettings() {
        return this.mSettings;
    }

    @Override // com.devexpress.navigation.tabs.models.IReadonlyHeaderItemModel
    public Position getActualIconPosition() {
        if (this.mSettings == null) {
            return this.mHeaderIconPosition;
        }
        if (this.mHeaderIconPosition != Position.Default) {
            return this.mHeaderIconPosition;
        }
        return this.mSettings.getItemHeaderIconPosition();
    }

    @Override // com.devexpress.navigation.tabs.models.IReadonlyHeaderItemModel
    public HeaderElements getActualHeaderVisibleElements() {
        if (this.mSettings == null) {
            return this.mHeaderVisibleElements;
        }
        if (this.mHeaderVisibleElements != HeaderElements.Default) {
            return this.mHeaderVisibleElements;
        }
        return this.mSettings.getItemHeaderVisibleElements();
    }

    public Position getHeaderIconPosition() {
        return this.mHeaderIconPosition;
    }

    public HeaderElements getHeaderVisibleElements() {
        return this.mHeaderVisibleElements;
    }

    public HeaderSingleItemAppearance getHeaderItemAppearance() {
        if (this.mHeaderItemAppearance == null) {
            this.mHeaderItemAppearance = new HeaderSingleItemAppearance();
        }
        return this.mHeaderItemAppearance;
    }

    public void setText(CharSequence charSequence) {
        CharSequence charSequence2 = this.mText;
        if (charSequence2 != charSequence) {
            this.mText = charSequence;
            Iterator<OnHeaderChangeListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onTextChanged(charSequence2, charSequence);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        Drawable drawable2 = this.mIcon;
        if (drawable2 != drawable) {
            this.mIcon = drawable;
            Iterator<OnHeaderChangeListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onIconChanged(drawable2, drawable);
            }
        }
    }

    public void setView(View view) {
        View view2 = this.mView;
        if (view2 != view) {
            this.mView = view;
            Iterator<OnHeaderChangeListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onViewChanged(view2, view);
            }
        }
    }

    public void setHeaderWidth(TabSize tabSize) {
        TabSize tabSize2 = this.mWidth;
        if (tabSize2 != tabSize) {
            this.mWidth = tabSize;
            Iterator<OnHeaderChangeListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onHeaderWidthOnHorizontalPanelChanged(this, tabSize2, tabSize);
            }
        }
    }

    public void setHeaderHeight(TabSize tabSize) {
        TabSize tabSize2 = this.mHeight;
        if (tabSize2 != tabSize) {
            this.mHeight = tabSize;
            Iterator<OnHeaderChangeListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onHeaderHeightOnVerticalPanelChanged(this, tabSize2, tabSize);
            }
        }
    }

    public void setHeaderIconPosition(Position position) {
        Position actualIconPosition = getActualIconPosition();
        this.mHeaderIconPosition = position;
        if (actualIconPosition != position) {
            Iterator<OnHeaderChangeListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onHeaderIconPositionChanged(actualIconPosition, position);
            }
        }
    }

    public void setHeaderVisibleElements(HeaderElements headerElements) {
        HeaderElements actualHeaderVisibleElements = getActualHeaderVisibleElements();
        this.mHeaderVisibleElements = headerElements;
        if (actualHeaderVisibleElements != headerElements) {
            Iterator<OnHeaderChangeListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onHeaderVisibleElementsChanged(actualHeaderVisibleElements, headerElements);
            }
        }
    }

    public void setHeaderItemAppearance(HeaderSingleItemAppearance headerSingleItemAppearance) {
        this.mHeaderItemAppearance = headerSingleItemAppearance;
    }

    public void changeTabControlAppearance(TabControlAppearance tabControlAppearance) {
        this.mHeaderItemAppearance.setCommonAppearance(tabControlAppearance.getHeaderItemAppearance());
    }

    @Override // com.devexpress.navigation.tabs.models.IReadonlyHeaderItemModel
    public void addListener(OnHeaderChangeListener onHeaderChangeListener) {
        if (this.mListeners.indexOf(onHeaderChangeListener) < 0) {
            this.mListeners.add(onHeaderChangeListener);
        }
    }

    @Override // com.devexpress.navigation.tabs.models.IReadonlyHeaderItemModel
    public void clearListeners() {
        this.mListeners.clear();
    }

    @Override // com.devexpress.navigation.tabs.models.IReadonlyHeaderItemModel
    public void removeListener(OnHeaderChangeListener onHeaderChangeListener) {
        if (this.mListeners.indexOf(onHeaderChangeListener) >= 0) {
            this.mListeners.remove(onHeaderChangeListener);
        }
    }

    public static boolean isTextVisible(HeaderElements headerElements) {
        return headerElements == HeaderElements.Text || headerElements == HeaderElements.TextAndIcon;
    }

    public static boolean isIconVisible(HeaderElements headerElements) {
        return headerElements == HeaderElements.Icon || headerElements == HeaderElements.TextAndIcon;
    }
}
