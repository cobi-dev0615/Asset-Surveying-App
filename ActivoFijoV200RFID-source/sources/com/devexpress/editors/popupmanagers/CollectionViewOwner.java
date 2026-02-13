package com.devexpress.editors.popupmanagers;

import android.view.View;
import kotlin.Metadata;

/* compiled from: CollectionViewOwner.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Lcom/devexpress/editors/popupmanagers/CollectionViewOwner;", "", "clearValue", "", "ensureSelectionVisible", "getCollectionView", "Landroid/view/View;", "getSelectedItemText", "", "hasValue", "", "isDataSourceEmpty", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CollectionViewOwner {
    void clearValue();

    void ensureSelectionVisible();

    View getCollectionView();

    CharSequence getSelectedItemText();

    boolean hasValue();

    boolean isDataSourceEmpty();
}
