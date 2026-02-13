package com.devexpress.navigation.tabs.models;

import com.devexpress.navigation.common.HeaderElements;
import com.devexpress.navigation.common.Position;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class TabItemSettings {
    private Position mHeaderIconPosition = Position.Top;
    private HeaderElements mHeaderVisibleElements = HeaderElements.TextAndIcon;
    private TabSize mItemHeaderWidth = TabSize.createDefaultHorizontalTabSize();
    private TabSize mItemHeaderHeight = TabSize.createDefaultVerticalTabSize();
    private List<OnSettingsChangeListener> listeners = new ArrayList();
    private TabItemSettings mThis = this;

    public interface OnSettingsChangeListener {
        void onHeaderHeightOnVerticalPanelChanged(Object obj, TabSize tabSize, TabSize tabSize2);

        void onHeaderIconPositionChanged(Position position, Position position2);

        void onHeaderVisibleElementsChanged(HeaderElements headerElements, HeaderElements headerElements2);

        void onHeaderWidthOnHorizontalPanelChanged(Object obj, TabSize tabSize, TabSize tabSize2);
    }

    public Position getItemHeaderIconPosition() {
        return this.mHeaderIconPosition;
    }

    public HeaderElements getItemHeaderVisibleElements() {
        return this.mHeaderVisibleElements;
    }

    public TabSize getItemHeaderWidth() {
        return this.mItemHeaderWidth;
    }

    public TabSize getItemHeaderHeight() {
        return this.mItemHeaderHeight;
    }

    public void setItemHeaderIconPosition(Position position) {
        Position position2 = this.mHeaderIconPosition;
        if (position2 != position) {
            this.mHeaderIconPosition = position;
            Iterator<OnSettingsChangeListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onHeaderIconPositionChanged(position2, position);
            }
        }
    }

    public void setItemHeaderVisibleElements(HeaderElements headerElements) {
        HeaderElements headerElements2 = this.mHeaderVisibleElements;
        if (headerElements2 != headerElements) {
            this.mHeaderVisibleElements = headerElements;
            Iterator<OnSettingsChangeListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onHeaderVisibleElementsChanged(headerElements2, headerElements);
            }
        }
    }

    public void setItemHeaderWidth(TabSize tabSize) {
        TabSize tabSize2 = this.mItemHeaderWidth;
        if (tabSize2 != tabSize) {
            this.mItemHeaderWidth = tabSize;
            Iterator<OnSettingsChangeListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onHeaderWidthOnHorizontalPanelChanged(this.mThis, tabSize2, tabSize);
            }
        }
    }

    public void setItemHeaderHeight(TabSize tabSize) {
        TabSize tabSize2 = this.mItemHeaderHeight;
        if (tabSize2 != tabSize) {
            this.mItemHeaderHeight = tabSize;
            Iterator<OnSettingsChangeListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onHeaderHeightOnVerticalPanelChanged(this.mThis, tabSize2, tabSize);
            }
        }
    }

    public void addNativeListener(OnSettingsChangeListener onSettingsChangeListener) {
        this.listeners.add(onSettingsChangeListener);
    }

    public void removeNativeListener(OnSettingsChangeListener onSettingsChangeListener) {
        this.listeners.remove(onSettingsChangeListener);
    }

    public void clearListeners() {
        this.listeners.clear();
    }
}
