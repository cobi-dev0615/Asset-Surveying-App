package com.devexpress.navigation.navigationdrawer;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes2.dex */
public interface IDrawerViewAdapter {

    public interface ContentChangedListener {
        void onContentChanged();
    }

    void ApplyMainContent(ContentView contentView);

    void addContentChangedListener(ContentChangedListener contentChangedListener);

    void clearContentChangedListener();

    View getDrawerContent(ViewGroup viewGroup);

    View getDrawerFooterContent(ViewGroup viewGroup);

    View getDrawerHeaderContent(ViewGroup viewGroup);

    void removeContentChangedListener(ContentChangedListener contentChangedListener);
}
