package com.devexpress.editors.layout2;

import android.util.Size;
import android.view.View;
import com.devexpress.editors.EditBase;
import com.devexpress.editors.MultilineEdit;
import com.devexpress.editors.dropdown.utils.Rectangle;
import com.devexpress.editors.utils.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultilineFilledLayout.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\tH\u0014¨\u0006\f"}, d2 = {"Lcom/devexpress/editors/layout2/MultilineFilledLayout;", "Lcom/devexpress/editors/layout2/FilledLayout;", "edit", "Lcom/devexpress/editors/EditBase;", "(Lcom/devexpress/editors/EditBase;)V", "applyLinesToTextSize", "Landroid/util/Size;", "size", "calcInternalEditorSizeDesired", "", "calcInternalEditorSizeExact", "calcPlaceholderFrame", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class MultilineFilledLayout extends FilledLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultilineFilledLayout(EditBase edit) {
        super(edit);
        Intrinsics.checkNotNullParameter(edit, "edit");
    }

    @Override // com.devexpress.editors.layout2.Layout
    protected void calcInternalEditorSizeDesired() {
        getEdit().getActualInternalEditorView().forceLayout();
        EditBase edit = getEdit();
        Intrinsics.checkNotNull(edit, "null cannot be cast to non-null type com.devexpress.editors.MultilineEdit");
        MultilineEdit multilineEdit = (MultilineEdit) edit;
        int width = (((getMaxSize().getWidth() - getActualBoxPaddings().left) - getActualBoxPaddings().right) - getLeadingIconOffset()) - getTrailingIconOffset();
        int makeMeasureSpec = width == Integer.MAX_VALUE ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(width, getLayoutWidthMode());
        int makeMeasureSpec2 = getMaxSize().getHeight() == Integer.MAX_VALUE ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(getMaxSize().getHeight(), getLayoutHeightMode());
        getTextPaint().setTypeface(multilineEdit.getTextTypeface());
        getTextPaint().setTextSize(multilineEdit.getTextSize());
        Size applyLinesToTextSize = applyLinesToTextSize(Layout.INSTANCE.calcTextSize(getTextPaint(), multilineEdit.getText(), width).sizeWithMargins());
        getEdit().getActualInternalEditorView().measure(makeMeasureSpec, makeMeasureSpec2);
        getInternalEditorFrame().setWidth(Math.max(getEdit().getActualInternalEditorView().getMeasuredWidth(), getPlaceholderFrame().getWidth()));
        getInternalEditorFrame().setHeight(applyLinesToTextSize.getHeight());
        if (getActualBoxPaddings().top == Integer.MIN_VALUE || getActualBoxPaddings().bottom == Integer.MIN_VALUE || getInternalEditorFrame().getHeight() + getActualBoxPaddings().top + getActualBoxPaddings().bottom <= getMaxSize().getHeight()) {
            return;
        }
        getInternalEditorFrame().setHeight(Math.max((getMaxSize().getHeight() - getActualBoxPaddings().top) - getActualBoxPaddings().bottom, 0));
    }

    @Override // com.devexpress.editors.layout2.Layout
    protected void calcInternalEditorSizeExact() {
        EditBase edit = getEdit();
        Intrinsics.checkNotNull(edit, "null cannot be cast to non-null type com.devexpress.editors.MultilineEdit");
        MultilineEdit multilineEdit = (MultilineEdit) edit;
        int width = (((getContentFrame().getWidth() - getLeadingIconOffset()) - getTrailingIconOffset()) - getPrefixFrame().getWidth()) - getSuffixFrame().getWidth();
        getTextPaint().setTypeface(multilineEdit.getTextTypeface());
        getTextPaint().setTextSize(multilineEdit.getTextSize());
        getInternalEditorFrame().setSize(applyLinesToTextSize(new Size(width, Layout.INSTANCE.calcTextSize(getTextPaint(), multilineEdit.getText(), width).sizeWithMargins().getHeight())));
        if (getActualBoxPaddings().top == Integer.MIN_VALUE || getActualBoxPaddings().bottom == Integer.MIN_VALUE || getInternalEditorFrame().getHeight() + getActualBoxPaddings().top + getActualBoxPaddings().bottom + getLabelTextSize().getHeight() <= getMaxSize().getHeight()) {
            return;
        }
        getInternalEditorFrame().setHeight(Math.max(((getMaxSize().getHeight() - getActualBoxPaddings().top) - getActualBoxPaddings().bottom) - getLabelTextSize().getHeight(), 0));
    }

    @Override // com.devexpress.editors.layout2.Layout
    protected void calcPlaceholderFrame() {
        getTextPaint().setTypeface(getEdit().getTextTypeface());
        getTextPaint().setTextSize(getEdit().getTextSize());
        int height = Layout.INSTANCE.calcTextSize(getTextPaint(), getEdit().getLabelText(), getInternalEditorFrame().getWidth()).sizeWithMargins().getHeight();
        CharSequence labelText = getEdit().getLabelText();
        setPlaceholderFrame(new Rectangle(getContentFrame().getLeft() + getLeadingIconOffset(), calcTopPositionForVerticalGravity(getEdit().getTextGravity(), height, (labelText == null || labelText.length() == 0) ? 0 : getSpecZeroLengthLabelOffset()), getInternalEditorFrame().getWidth(), height));
    }

    private final Size applyLinesToTextSize(Size size) {
        EditBase edit = getEdit();
        Intrinsics.checkNotNull(edit, "null cannot be cast to non-null type com.devexpress.editors.MultilineEdit");
        MultilineEdit multilineEdit = (MultilineEdit) edit;
        int max = Math.max(multilineEdit.getMinLineCount(), 1);
        int max2 = multilineEdit.getMaxLineCount() <= 0 ? Integer.MAX_VALUE : Math.max(multilineEdit.getMaxLineCount(), max);
        getTextPaint().setTypeface(multilineEdit.getTextTypeface());
        getTextPaint().setTextSize(multilineEdit.getTextSize());
        TextSizeInfo calcTextSize = Layout.INSTANCE.calcTextSize(getTextPaint());
        return new Size(size.getWidth(), Utils.clamp(size.getHeight(), Math.max(getSpecMinTextFieldHeight(), (max * calcTextSize.getSize().getHeight()) + calcTextSize.getTextTopMargin() + calcTextSize.getTextBottomMargin()), Math.max(getSpecMinTextFieldHeight(), max2 != Integer.MAX_VALUE ? (max2 * calcTextSize.getSize().getHeight()) + calcTextSize.getTextTopMargin() + calcTextSize.getTextBottomMargin() : Integer.MAX_VALUE)));
    }
}
