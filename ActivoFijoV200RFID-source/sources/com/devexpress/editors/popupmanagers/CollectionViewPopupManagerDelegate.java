package com.devexpress.editors.popupmanagers;

import android.view.View;
import com.devexpress.editors.popupmanagers.PopupManagerBaseDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CollectionViewPopupManagerDelegate.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0012\u0010\t\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/devexpress/editors/popupmanagers/CollectionViewPopupManagerDelegate;", "Lcom/devexpress/editors/popupmanagers/PopupManagerBaseDelegate;", "filterString", "", "getFilterString", "()Ljava/lang/CharSequence;", "isDataSourceEmpty", "", "()Z", "isFilterEnabled", "onDropdownRecalculated", "", "onFilterChanged", "onQueryListView", "Landroid/view/View;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CollectionViewPopupManagerDelegate extends PopupManagerBaseDelegate {
    CharSequence getFilterString();

    boolean isDataSourceEmpty();

    boolean isFilterEnabled();

    void onDropdownRecalculated();

    void onFilterChanged();

    View onQueryListView();

    /* compiled from: CollectionViewPopupManagerDelegate.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static View onQueryListView(CollectionViewPopupManagerDelegate collectionViewPopupManagerDelegate) {
            return null;
        }

        public static void onDismissPopup(CollectionViewPopupManagerDelegate collectionViewPopupManagerDelegate, PopupManagerBase manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            PopupManagerBaseDelegate.DefaultImpls.onDismissPopup(collectionViewPopupManagerDelegate, manager);
        }

        public static void onShowPopup(CollectionViewPopupManagerDelegate collectionViewPopupManagerDelegate, PopupManagerBase manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            PopupManagerBaseDelegate.DefaultImpls.onShowPopup(collectionViewPopupManagerDelegate, manager);
        }
    }
}
