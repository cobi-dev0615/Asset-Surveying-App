package com.devexpress.editors;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.editors.ItemsEditBase;
import com.devexpress.editors.TextEditBase;
import com.devexpress.editors.layout2.FilledLayout;
import com.devexpress.editors.layout2.FilledLayoutWithCustomInternalEditor;
import com.devexpress.editors.layout2.Layout;
import com.devexpress.editors.layout2.OutlinedLayout;
import com.devexpress.editors.layout2.OutlinedLayoutWithCustomInternalEditor;
import com.devexpress.editors.popupmanagers.CollectionViewOwner;
import com.devexpress.editors.utils.GestureHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ItemsEditBase.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001:\u0002ABB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0014J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0014H&J\b\u00108\u001a\u000206H\u0016J\b\u00109\u001a\u000206H\u0014J\b\u0010:\u001a\u00020\u0014H\u0014J\b\u0010;\u001a\u000206H\u0014J\u0010\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u0014H\u0002J\b\u0010>\u001a\u000206H\u0014J\u0010\u0010?\u001a\u0002062\b\b\u0002\u0010@\u001a\u00020\u0014R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010 \u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\fR\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020\u00148TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0017R\u001a\u0010*\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0017\"\u0004\b,\u0010\u0019R\u0014\u0010-\u001a\u00020\u00148TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0017R\u0014\u0010/\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0017¨\u0006C"}, d2 = {"Lcom/devexpress/editors/ItemsEditBase;", "Lcom/devexpress/editors/TextEditBase;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actualInternalEditorView", "Landroid/view/View;", "getActualInternalEditorView", "()Landroid/view/View;", "actualPrefix", "", "getActualPrefix", "()Ljava/lang/CharSequence;", "actualSuffix", "getActualSuffix", "value", "", "allowMultiselection", "getAllowMultiselection", "()Z", "setAllowMultiselection", "(Z)V", "collectionViewOwner", "Lcom/devexpress/editors/popupmanagers/CollectionViewOwner;", "getCollectionViewOwner", "()Lcom/devexpress/editors/popupmanagers/CollectionViewOwner;", "setCollectionViewOwner", "(Lcom/devexpress/editors/popupmanagers/CollectionViewOwner;)V", "customInternalEditor", "getCustomInternalEditor", "setCustomInternalEditor", "(Landroid/view/View;)V", "dropdownPlacementTarget", "getDropdownPlacementTarget", "editorHolder", "Lcom/devexpress/editors/ItemsEditBase$CustomInternalEditorHolder;", "hasValue", "getHasValue", "keepFocusOnItemSelection", "getKeepFocusOnItemSelection", "setKeepFocusOnItemSelection", "useCustomEditorWhenFocused", "getUseCustomEditorWhenFocused", "useCustomInternalEditor", "getUseCustomInternalEditor", "createLayout", "Lcom/devexpress/editors/layout2/Layout;", "borderMode", "Lcom/devexpress/editors/DXBorderMode;", "dismissDropDown", "", "onLostFocus", "handleSelectionChanged", "onContainsFocusChange", "onSingleTapUp", "onValueChanged", "shouldUseCustomEditor", "isFocused", "updateClearImageVisibility", "updateCustomEditorVisibility", "animated", "CustomInternalEditorHolder", "ViewHolder", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ItemsEditBase extends TextEditBase {
    private boolean allowMultiselection;
    private CollectionViewOwner collectionViewOwner;
    private View customInternalEditor;
    private CustomInternalEditorHolder editorHolder;
    private boolean keepFocusOnItemSelection;

    public abstract void dismissDropDown(boolean onLostFocus);

    public abstract View getDropdownPlacementTarget();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemsEditBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.keepFocusOnItemSelection = true;
    }

    public /* synthetic */ ItemsEditBase(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, i);
    }

    private final boolean getUseCustomInternalEditor() {
        return this.customInternalEditor != null;
    }

    @Override // com.devexpress.editors.EditBase
    public View getActualInternalEditorView() {
        if (!getUseCustomInternalEditor()) {
            return getInternalEditor();
        }
        CustomInternalEditorHolder customInternalEditorHolder = this.editorHolder;
        Intrinsics.checkNotNull(customInternalEditorHolder);
        return customInternalEditorHolder;
    }

    @Override // com.devexpress.editors.EditBase
    public CharSequence getActualPrefix() {
        if (getUseCustomInternalEditor()) {
            return null;
        }
        return getPrefix();
    }

    @Override // com.devexpress.editors.EditBase
    public CharSequence getActualSuffix() {
        if (getUseCustomInternalEditor()) {
            return null;
        }
        return getSuffix();
    }

    @Override // com.devexpress.editors.EditBase
    protected boolean onSingleTapUp() {
        if (!isEnabled()) {
            return true;
        }
        if (!getContainsFocus()) {
            requestFocus();
        }
        return super.onSingleTapUp();
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    protected void onContainsFocusChange() {
        super.onContainsFocusChange();
        updateCustomEditorVisibility$default(this, false, 1, null);
        if (getContainsFocus()) {
            return;
        }
        dismissDropDown(true);
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    protected void onValueChanged() {
        super.onValueChanged();
        updateCustomEditorVisibility$default(this, false, 1, null);
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    protected void updateClearImageVisibility() {
        boolean z = false;
        updateIconVisibility(this.clearImage, getClearIconVisibility() == DXIconVisibility.Always || (getClearIconVisibility() == DXIconVisibility.Auto && getHasValue()));
        AppCompatImageButton appCompatImageButton = this.clearImage;
        if (isEnabled() && getHasValue()) {
            z = true;
        }
        appCompatImageButton.setEnabled(z);
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    protected boolean getHasValue() {
        CollectionViewOwner collectionViewOwner = this.collectionViewOwner;
        if (collectionViewOwner != null) {
            return collectionViewOwner.hasValue();
        }
        return false;
    }

    @Override // com.devexpress.editors.EditBase
    protected Layout createLayout(DXBorderMode borderMode) {
        Intrinsics.checkNotNullParameter(borderMode, "borderMode");
        if (borderMode == DXBorderMode.Filled) {
            return getUseCustomInternalEditor() ? new FilledLayoutWithCustomInternalEditor(this) : new FilledLayout(this);
        }
        return getUseCustomInternalEditor() ? new OutlinedLayoutWithCustomInternalEditor(this) : new OutlinedLayout(this);
    }

    public final View getCustomInternalEditor() {
        return this.customInternalEditor;
    }

    public final void setCustomInternalEditor(View view) {
        int indexOfChild;
        if (Intrinsics.areEqual(this.customInternalEditor, view)) {
            return;
        }
        if (this.customInternalEditor == null) {
            indexOfChild = indexOfChild(getInternalEditor());
            removeView(getInternalEditor());
        } else {
            indexOfChild = indexOfChild(this.editorHolder);
            removeView(this.editorHolder);
            CustomInternalEditorHolder customInternalEditorHolder = this.editorHolder;
            Intrinsics.checkNotNull(customInternalEditorHolder);
            customInternalEditorHolder.removeAllViews();
        }
        if (view != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            CustomInternalEditorHolder customInternalEditorHolder2 = new CustomInternalEditorHolder(context, view, getInternalEditor());
            this.editorHolder = customInternalEditorHolder2;
            customInternalEditorHolder2.setGestureDelegate(new TextEditBase.TextEditBaseGestureDelegate(this));
            TextView internalEditor = getInternalEditor();
            DXEditText dXEditText = internalEditor instanceof DXEditText ? (DXEditText) internalEditor : null;
            if (dXEditText != null) {
                dXEditText.setGestureDelegate(new TextEditBase.EmptyTextEditBaseGestureDelegate());
            }
            CustomInternalEditorHolder customInternalEditorHolder3 = this.editorHolder;
            if (customInternalEditorHolder3 != null) {
                customInternalEditorHolder3.setShouldRequestFocusFromCustomEditor(new Function1<Boolean, Boolean>() { // from class: com.devexpress.editors.ItemsEditBase$customInternalEditor$1
                    {
                        super(1);
                    }

                    public final Boolean invoke(boolean z) {
                        boolean shouldUseCustomEditor;
                        shouldUseCustomEditor = ItemsEditBase.this.shouldUseCustomEditor(z);
                        return Boolean.valueOf(shouldUseCustomEditor);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                        return invoke(bool.booleanValue());
                    }
                });
            }
            addView(this.editorHolder, indexOfChild);
            updateCustomEditorVisibility(false);
        } else {
            TextView internalEditor2 = getInternalEditor();
            DXEditText dXEditText2 = internalEditor2 instanceof DXEditText ? (DXEditText) internalEditor2 : null;
            if (dXEditText2 != null && (dXEditText2.getGestureDelegate() instanceof TextEditBase.EmptyTextEditBaseGestureDelegate)) {
                dXEditText2.setGestureDelegate(new TextEditBase.TextEditBaseGestureDelegate(this));
            }
            addView(getInternalEditor(), indexOfChild);
            this.editorHolder = null;
        }
        this.customInternalEditor = view;
        setContentLayout(createLayout(getBorderMode()));
    }

    public final boolean getKeepFocusOnItemSelection() {
        return this.keepFocusOnItemSelection;
    }

    public final void setKeepFocusOnItemSelection(boolean z) {
        this.keepFocusOnItemSelection = z;
    }

    public final boolean getAllowMultiselection() {
        return this.allowMultiselection;
    }

    public final void setAllowMultiselection(boolean z) {
        setDescendantFocusability(z ? 262144 : 131072);
        setFocusable(z);
        setFocusableInTouchMode(z);
        this.allowMultiselection = z;
    }

    public final CollectionViewOwner getCollectionViewOwner() {
        return this.collectionViewOwner;
    }

    public final void setCollectionViewOwner(CollectionViewOwner collectionViewOwner) {
        this.collectionViewOwner = collectionViewOwner;
    }

    protected boolean getUseCustomEditorWhenFocused() {
        return getHasValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldUseCustomEditor(boolean isFocused) {
        return (!isFocused && getHasValue()) || (isFocused && getUseCustomEditorWhenFocused()) || this.allowMultiselection;
    }

    public void handleSelectionChanged() {
        if (this.keepFocusOnItemSelection) {
            return;
        }
        clearFocus();
        hideSoftKeyboard();
    }

    public static /* synthetic */ void updateCustomEditorVisibility$default(ItemsEditBase itemsEditBase, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCustomEditorVisibility");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        itemsEditBase.updateCustomEditorVisibility(z);
    }

    public final void updateCustomEditorVisibility(boolean animated) {
        CustomInternalEditorHolder customInternalEditorHolder = this.editorHolder;
        if (customInternalEditorHolder != null) {
            boolean allowAnimations = animated & getAllowAnimations();
            if (shouldUseCustomEditor(getContainsFocus())) {
                customInternalEditorHolder.showCustomEditor(allowAnimations);
            } else {
                customInternalEditorHolder.showInternalEditor(allowAnimations);
            }
        }
    }

    /* compiled from: ItemsEditBase.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J0\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!H\u0014J\u0018\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020!H\u0014J\u001a\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020!2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\b\u0010,\u001a\u00020\u001eH\u0016J\u0010\u0010-\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u0015J\u0010\u0010/\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u00060"}, d2 = {"Lcom/devexpress/editors/ItemsEditBase$CustomInternalEditorHolder;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "customEditor", "Landroid/view/View;", "internalEditor", "(Landroid/content/Context;Landroid/view/View;Landroid/view/View;)V", "customEditorHolder", "Lcom/devexpress/editors/ItemsEditBase$ViewHolder;", "gestureDelegate", "Lcom/devexpress/editors/GestureDelegate;", "getGestureDelegate", "()Lcom/devexpress/editors/GestureDelegate;", "setGestureDelegate", "(Lcom/devexpress/editors/GestureDelegate;)V", "gestureHelper", "Lcom/devexpress/editors/utils/GestureHandler;", "internalEditorHolder", "shouldRequestFocusFromCustomEditor", "Lkotlin/Function1;", "", "getShouldRequestFocusFromCustomEditor", "()Lkotlin/jvm/functions/Function1;", "setShouldRequestFocusFromCustomEditor", "(Lkotlin/jvm/functions/Function1;)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onLayout", "", "changed", "l", "", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRequestFocusInDescendants", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "removeAllViews", "showCustomEditor", "animated", "showInternalEditor", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CustomInternalEditorHolder extends ViewGroup {
        private final ViewHolder customEditorHolder;
        private GestureDelegate gestureDelegate;
        private final GestureHandler gestureHelper;
        private final ViewHolder internalEditorHolder;
        public Function1<? super Boolean, Boolean> shouldRequestFocusFromCustomEditor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomInternalEditorHolder(Context context, View customEditor, View internalEditor) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(customEditor, "customEditor");
            Intrinsics.checkNotNullParameter(internalEditor, "internalEditor");
            int i = 12;
            DefaultConstructorMarker defaultConstructorMarker = null;
            AttributeSet attributeSet = null;
            int i2 = 0;
            ViewHolder viewHolder = new ViewHolder(customEditor, context, attributeSet, i2, i, defaultConstructorMarker);
            this.customEditorHolder = viewHolder;
            ViewHolder viewHolder2 = new ViewHolder(internalEditor, context, attributeSet, i2, i, defaultConstructorMarker);
            this.internalEditorHolder = viewHolder2;
            this.gestureHelper = new GestureHandler();
            addView(viewHolder);
            addView(viewHolder2);
        }

        public final GestureDelegate getGestureDelegate() {
            return this.gestureDelegate;
        }

        public final void setGestureDelegate(GestureDelegate gestureDelegate) {
            this.gestureDelegate = gestureDelegate;
        }

        public final Function1<Boolean, Boolean> getShouldRequestFocusFromCustomEditor() {
            Function1 function1 = this.shouldRequestFocusFromCustomEditor;
            if (function1 != null) {
                return function1;
            }
            Intrinsics.throwUninitializedPropertyAccessException("shouldRequestFocusFromCustomEditor");
            return null;
        }

        public final void setShouldRequestFocusFromCustomEditor(Function1<? super Boolean, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.shouldRequestFocusFromCustomEditor = function1;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent ev) {
            GestureHandler gestureHandler = this.gestureHelper;
            Intrinsics.checkNotNull(ev);
            if (gestureHandler.dispatchTouchEvent(ev, this.gestureDelegate)) {
                return true;
            }
            super.dispatchTouchEvent(ev);
            return true;
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            this.customEditorHolder.measure(widthMeasureSpec, heightMeasureSpec);
            this.internalEditorHolder.measure(widthMeasureSpec, heightMeasureSpec);
            setMeasuredDimension(Math.max(this.customEditorHolder.getMeasuredWidth(), this.internalEditorHolder.getMeasuredWidth()), Math.max(this.customEditorHolder.getMeasuredHeight(), this.internalEditorHolder.getMeasuredHeight()));
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            int i = r - l;
            int i2 = b - t;
            this.customEditorHolder.layout(0, 0, i, i2);
            if (this.internalEditorHolder.getMeasuredWidth() != i || this.internalEditorHolder.getMeasuredHeight() != i2) {
                this.internalEditorHolder.measure(View.MeasureSpec.makeMeasureSpec(i, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(i2, BasicMeasure.EXACTLY));
            }
            this.internalEditorHolder.layout(0, 0, i, i2);
        }

        @Override // android.view.ViewGroup
        protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
            return getShouldRequestFocusFromCustomEditor().invoke(true).booleanValue() ? this.customEditorHolder.requestFocus() : this.internalEditorHolder.requestFocus();
        }

        public static /* synthetic */ void showCustomEditor$default(CustomInternalEditorHolder customInternalEditorHolder, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            customInternalEditorHolder.showCustomEditor(z);
        }

        public final void showCustomEditor(boolean animated) {
            if (!this.internalEditorHolder.isTransparent()) {
                this.internalEditorHolder.hide();
            }
            if (this.customEditorHolder.isTransparent()) {
                this.customEditorHolder.show(animated);
            }
        }

        public static /* synthetic */ void showInternalEditor$default(CustomInternalEditorHolder customInternalEditorHolder, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            customInternalEditorHolder.showInternalEditor(z);
        }

        public final void showInternalEditor(boolean animated) {
            if (!this.customEditorHolder.isTransparent()) {
                this.customEditorHolder.hide();
            }
            if (this.internalEditorHolder.isTransparent()) {
                this.internalEditorHolder.show(animated);
            }
        }

        @Override // android.view.ViewGroup
        public void removeAllViews() {
            super.removeAllViews();
            this.customEditorHolder.removeAllViews();
            this.internalEditorHolder.removeAllViews();
        }
    }

    /* compiled from: ItemsEditBase.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B-\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0011J0\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0014J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0014J\u0010\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000f¨\u0006!"}, d2 = {"Lcom/devexpress/editors/ItemsEditBase$ViewHolder;", "Landroid/view/ViewGroup;", "content", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/view/View;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getContent", "()Landroid/view/View;", "isTransparent", "", "()Z", "animateAlphaToValue", "", "newAlpha", "", "hide", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "show", "animated", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewHolder extends ViewGroup {
        public static final long ANIMATION_TIME = 150;
        private final View content;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View content, Context context) {
            this(content, context, null, 0, 12, null);
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(context, "context");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View content, Context context, AttributeSet attributeSet) {
            this(content, context, attributeSet, 0, 8, null);
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(context, "context");
        }

        public /* synthetic */ ViewHolder(View view, Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(view, context, (i2 & 4) != 0 ? null : attributeSet, (i2 & 8) != 0 ? 0 : i);
        }

        public final View getContent() {
            return this.content;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View content, Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(context, "context");
            this.content = content;
            addView(content);
        }

        public final boolean isTransparent() {
            return getAlpha() < 1.0f;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            this.content.layout(0, 0, r - l, b - t);
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            this.content.measure(widthMeasureSpec, heightMeasureSpec);
            setMeasuredDimension(this.content.getMeasuredWidth(), this.content.getMeasuredHeight());
        }

        public static /* synthetic */ void show$default(ViewHolder viewHolder, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            viewHolder.show(z);
        }

        public final void show(boolean animated) {
            setVisibility(0);
            setEnabled(true);
            if (animated) {
                animateAlphaToValue(1.0f);
            } else {
                setAlpha(1.0f);
            }
        }

        public final void hide() {
            setVisibility(8);
            setAlpha(0.0f);
            setEnabled(false);
        }

        private final void animateAlphaToValue(final float newAlpha) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<ViewHolder, Float>) View.ALPHA, newAlpha);
            ofFloat.setDuration(150L);
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.devexpress.editors.ItemsEditBase$ViewHolder$animateAlphaToValue$anim$1$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    ItemsEditBase.ViewHolder.this.setAlpha(newAlpha);
                }
            });
            ofFloat.start();
        }
    }
}
