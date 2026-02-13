package com.devexpress.editors.popupmanagers;

import android.content.Context;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.devexpress.editors.dropdown.DXDropdownContainer;
import com.devexpress.editors.model.BorderRounds;
import com.devexpress.editors.utils.KeyCodeUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CollectionViewPopupManager.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010+\u001a\u00020(H\u0016J0\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\u001eH\u0002J\u0018\u00102\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\t2\u0006\u00103\u001a\u000204H\u0014J\u0018\u00105\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\t2\u0006\u00103\u001a\u000204H\u0014J\u0010\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020\u001eH\u0014J\b\u00108\u001a\u00020(H\u0016R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b!\u0010\u0018R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000e¨\u00069"}, d2 = {"Lcom/devexpress/editors/popupmanagers/CollectionViewPopupManager;", "Lcom/devexpress/editors/popupmanagers/PopupManagerBase;", "Lcom/devexpress/editors/popupmanagers/PopupPresenter;", "context", "Landroid/content/Context;", "delegate", "Lcom/devexpress/editors/popupmanagers/CollectionViewPopupManagerDelegate;", "(Landroid/content/Context;Lcom/devexpress/editors/popupmanagers/CollectionViewPopupManagerDelegate;)V", "value", "", "backgroundColor", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "Lcom/devexpress/editors/model/BorderRounds;", "borderRounds", "getBorderRounds", "()Lcom/devexpress/editors/model/BorderRounds;", "setBorderRounds", "(Lcom/devexpress/editors/model/BorderRounds;)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "getDelegate", "()Lcom/devexpress/editors/popupmanagers/CollectionViewPopupManagerDelegate;", "isPopupShowing", "", "()Z", "placementTarget", "getPlacementTarget", "popup", "Lcom/devexpress/editors/dropdown/DXDropdownContainer;", "verticalOffset", "getVerticalOffset", "setVerticalOffset", "buildContent", "", "convertToFloat", "", "dismissPopup", "isNavigationAllowed", "keyCode", "selectedIndex", "firstIndex", "lastIndex", "isBelowAnchor", "onContentKeyDown", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "onContentKeyUp", "showPopup", "checkCanShow", "updatePopup", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class CollectionViewPopupManager extends PopupManagerBase implements PopupPresenter {
    private int backgroundColor;
    private BorderRounds borderRounds;
    private View contentView;
    private final CollectionViewPopupManagerDelegate delegate;
    private DXDropdownContainer popup;
    private int verticalOffset;

    private final boolean isNavigationAllowed(int keyCode, int selectedIndex, int firstIndex, int lastIndex, boolean isBelowAnchor) {
        return (isBelowAnchor && keyCode == 19 && selectedIndex <= firstIndex) || (!isBelowAnchor && keyCode == 20 && selectedIndex >= lastIndex);
    }

    @Override // com.devexpress.editors.popupmanagers.PopupManagerBase
    protected boolean onContentKeyDown(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.devexpress.editors.popupmanagers.PopupManagerBase
    public CollectionViewPopupManagerDelegate getDelegate() {
        return this.delegate;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionViewPopupManager(Context context, CollectionViewPopupManagerDelegate delegate) {
        super(context, delegate);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.backgroundColor = -1;
        this.borderRounds = new BorderRounds();
    }

    public final View getContentView() {
        return this.contentView;
    }

    public final void setContentView(View view) {
        this.contentView = view;
    }

    @Override // com.devexpress.editors.popupmanagers.PopupManagerBase, com.devexpress.editors.popupmanagers.PopupPresenter
    public boolean isPopupShowing() {
        DXDropdownContainer dXDropdownContainer = this.popup;
        if (dXDropdownContainer != null) {
            return dXDropdownContainer.getIsDropdownOpen();
        }
        return false;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
        DXDropdownContainer dXDropdownContainer = this.popup;
        if (dXDropdownContainer == null) {
            return;
        }
        dXDropdownContainer.setBackgroundColor(i);
    }

    public final BorderRounds getBorderRounds() {
        return this.borderRounds;
    }

    public final void setBorderRounds(BorderRounds value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.borderRounds = value;
        DXDropdownContainer dXDropdownContainer = this.popup;
        if (dXDropdownContainer == null) {
            return;
        }
        dXDropdownContainer.setCornerRadius(convertToFloat(value));
    }

    public final int getVerticalOffset() {
        return this.verticalOffset;
    }

    public final void setVerticalOffset(int i) {
        this.verticalOffset = i;
    }

    public final View getPlacementTarget() {
        DXDropdownContainer dXDropdownContainer = this.popup;
        if (dXDropdownContainer != null) {
            return dXDropdownContainer.getPlacementTarget();
        }
        return null;
    }

    @Override // com.devexpress.editors.popupmanagers.PopupManagerBase
    protected void showPopup(boolean checkCanShow) {
        if (this.popup == null) {
            DXDropdownContainer dXDropdownContainer = new DXDropdownContainer(getContext());
            this.popup = dXDropdownContainer;
            dXDropdownContainer.setFocusable(false);
            DXDropdownContainer dXDropdownContainer2 = this.popup;
            if (dXDropdownContainer2 != null) {
                dXDropdownContainer2.setCornerRadius(convertToFloat(this.borderRounds));
            }
            DXDropdownContainer dXDropdownContainer3 = this.popup;
            if (dXDropdownContainer3 != null) {
                dXDropdownContainer3.setBackgroundColor(this.backgroundColor);
            }
            DXDropdownContainer dXDropdownContainer4 = this.popup;
            if (dXDropdownContainer4 != null) {
                dXDropdownContainer4.setOnActionlistener(new DXDropdownContainer.DropdownListener() { // from class: com.devexpress.editors.popupmanagers.CollectionViewPopupManager$showPopup$1
                    @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownListener
                    public boolean dropdownWillClose() {
                        return true;
                    }

                    @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownListener
                    public boolean dropdownWillOpen() {
                        return true;
                    }

                    @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownListener
                    public void dropdownOpened() {
                        CollectionViewPopupManager.this.getDelegate().onDropdownRecalculated();
                    }

                    @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownListener
                    public void dropdownClosed() {
                        CollectionViewPopupManager.this.getDelegate().onDismissPopup(CollectionViewPopupManager.this);
                    }

                    @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownListener
                    public void dropdownResized() {
                        CollectionViewPopupManager.this.getDelegate().onDropdownRecalculated();
                    }
                });
            }
        }
        buildContent();
        DXDropdownContainer dXDropdownContainer5 = this.popup;
        if (dXDropdownContainer5 != null) {
            dXDropdownContainer5.setMargin(new Rect(0, 0, 0, -this.verticalOffset));
        }
        DXDropdownContainer dXDropdownContainer6 = this.popup;
        if (dXDropdownContainer6 != null) {
            dXDropdownContainer6.setContentView(this.contentView);
        }
        DXDropdownContainer dXDropdownContainer7 = this.popup;
        if (dXDropdownContainer7 != null) {
            dXDropdownContainer7.setPlacementTarget(getDelegate().getTarget());
        }
        DXDropdownContainer dXDropdownContainer8 = this.popup;
        if (dXDropdownContainer8 != null) {
            dXDropdownContainer8.setDropdownOpen(true);
        }
        getDelegate().onShowPopup(this);
    }

    public void buildContent() {
        this.contentView = getDelegate().onQueryListView();
    }

    @Override // com.devexpress.editors.popupmanagers.PopupManagerBase
    public void dismissPopup() {
        super.dismissPopup();
        DXDropdownContainer dXDropdownContainer = this.popup;
        if (dXDropdownContainer != null) {
            dXDropdownContainer.setDropdownOpen(false);
        }
        DXDropdownContainer dXDropdownContainer2 = this.popup;
        if (dXDropdownContainer2 == null) {
            return;
        }
        dXDropdownContainer2.setPlacementTarget(null);
    }

    @Override // com.devexpress.editors.popupmanagers.PopupPresenter
    public void updatePopup() {
        getDelegate().onFilterChanged();
        DXDropdownContainer dXDropdownContainer = this.popup;
        if (dXDropdownContainer != null ? dXDropdownContainer.getIsDropdownOpen() : false) {
            DXDropdownContainer dXDropdownContainer2 = this.popup;
            if (dXDropdownContainer2 != null) {
                dXDropdownContainer2.resizeOpenFrame();
                return;
            }
            return;
        }
        showPopup(false);
    }

    @Override // com.devexpress.editors.popupmanagers.PopupManagerBase
    protected boolean onContentKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        View view = this.contentView;
        if (view == null || !isPopupShowing()) {
            return false;
        }
        boolean onKeyUp = view.onKeyUp(keyCode, event);
        if (onKeyUp && KeyCodeUtilsKt.isConfirmKeyCode(keyCode)) {
            dismissPopup();
        }
        return onKeyUp;
    }

    private final float convertToFloat(BorderRounds borderRounds) {
        return (((borderRounds.topLeft + borderRounds.topRight) + borderRounds.bottomLeft) + borderRounds.bottomRight) / 4;
    }
}
