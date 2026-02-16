package com.devexpress.editors.layout2;

import android.util.Size;
import com.devexpress.editors.EditBase;
import com.devexpress.editors.dropdown.utils.Rectangle;
import com.devexpress.editors.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FilledLayout.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\f\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\nH\u0014J\b\u0010\u000e\u001a\u00020\nH\u0014J\b\u0010\u000f\u001a\u00020\u0006H\u0014J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/devexpress/editors/layout2/FilledLayout;", "Lcom/devexpress/editors/layout2/Layout;", "edit", "Lcom/devexpress/editors/EditBase;", "(Lcom/devexpress/editors/EditBase;)V", "specFilledVertPadding", "", "specOutlinedVertPadding", "specZeroLengthLabelOffset", "calcBoxFrame", "", "calcContentFrame", "calcFullBounds", "calcInternalEditorFrame", "calcLabelFrame", "calcTopPadding", "getLabelOffset", "getPaddingWithEmptyLabel", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class FilledLayout extends Layout {
    public static final float SPEC_ZERO_LENGTH_LABEL_OFFSET = 8.0f;
    private final int specFilledVertPadding;
    private final int specOutlinedVertPadding;
    private final int specZeroLengthLabelOffset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilledLayout(EditBase edit) {
        super(edit);
        Intrinsics.checkNotNullParameter(edit, "edit");
        this.specOutlinedVertPadding = (int) ((getDensity() * 16.0f) + 0.5f);
        this.specFilledVertPadding = (int) ((getDensity() * 8.0f) + 0.5f);
        this.specZeroLengthLabelOffset = (int) ((getDensity() * 8.0f) + 0.5f);
    }

    @Override // com.devexpress.editors.layout2.Layout
    /* renamed from: getLabelOffset, reason: from getter */
    public int getSpecZeroLengthLabelOffset() {
        return this.specZeroLengthLabelOffset;
    }

    @Override // com.devexpress.editors.layout2.Layout
    protected void calcBoxFrame() {
        int max3 = UtilsKt.max3(getInternalEditorFrame().getHeight() + getLabelTextSize().getHeight(), getLeadingIconFrame().getHeight(), getTrailingIconFrame().getHeight());
        CharSequence labelText = getEdit().getLabelText();
        setBoxFrame(new Rectangle(0, 0, getBoxFrame().getWidth(), calcTargetBoxHeightAndPaddings(max3, 0, (labelText == null || labelText.length() == 0) ? getPaddingWithEmptyLabel() : this.specFilledVertPadding)));
    }

    @Override // com.devexpress.editors.layout2.Layout
    protected void calcFullBounds() {
        int height = getBoxFrame().getHeight() + Math.max(getBottomTextAreaFrame().getHeight(), getCharCounterAreaFrame().getHeight());
        if (getLayoutHeightMode() == 1073741824 && height != getMaxSize().getHeight()) {
            height = getMaxSize().getHeight();
        }
        setFullBounds(new Size(getBoxFrame().getWidth(), height));
    }

    @Override // com.devexpress.editors.layout2.Layout
    protected void calcContentFrame() {
        setContentFrame(new Rectangle(getActualBoxPaddings().left, getActualBoxPaddings().top, getContentFrame().getWidth(), Math.max((getBoxFrame().getHeight() - getActualBoxPaddings().top) - getActualBoxPaddings().bottom, 0)));
    }

    @Override // com.devexpress.editors.layout2.Layout
    protected void calcInternalEditorFrame() {
        CharSequence labelText = getEdit().getLabelText();
        setInternalEditorFrame(new Rectangle(getContentFrame().getLeft() + getLeadingIconOffset() + getPrefixOffset(), calcTopPositionForVerticalGravity(getEdit().getTextGravity(), getInternalEditorFrame().getHeight(), (labelText == null || labelText.length() == 0) ? 0 : getLabelTextSize().getHeight()), getInternalEditorFrame().getWidth(), getInternalEditorFrame().getHeight()));
    }

    @Override // com.devexpress.editors.layout2.Layout
    protected void calcLabelFrame() {
        setLabelFrame(new Rectangle(getInternalEditorFrame().getLeft() - getPrefixOffset(), getContentFrame().getTop(), getLabelTextSize().getWidth(), getLabelTextSize().getHeight()));
    }

    @Override // com.devexpress.editors.layout2.Layout
    protected int calcTopPadding() {
        return getActualBoxPaddings().top;
    }

    private final int getPaddingWithEmptyLabel() {
        if (getActualBoxPaddings().top == Integer.MIN_VALUE) {
            return this.specFilledVertPadding + this.specZeroLengthLabelOffset;
        }
        return getActualBoxPaddings().top > this.specOutlinedVertPadding ? getActualBoxPaddings().top - this.specZeroLengthLabelOffset : getActualBoxPaddings().top;
    }
}
