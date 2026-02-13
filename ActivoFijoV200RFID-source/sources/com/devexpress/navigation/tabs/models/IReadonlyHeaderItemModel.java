package com.devexpress.navigation.tabs.models;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.devexpress.navigation.common.HeaderElements;
import com.devexpress.navigation.common.Position;
import com.devexpress.navigation.tabs.models.HeaderItemModel;

/* loaded from: classes2.dex */
public interface IReadonlyHeaderItemModel {
    void addListener(HeaderItemModel.OnHeaderChangeListener onHeaderChangeListener);

    void clearListeners();

    HeaderElements getActualHeaderVisibleElements();

    TabSize getActualHeight();

    Position getActualIconPosition();

    TabSize getActualWidth();

    Drawable getIcon();

    CharSequence getText();

    View getView();

    void removeListener(HeaderItemModel.OnHeaderChangeListener onHeaderChangeListener);
}
