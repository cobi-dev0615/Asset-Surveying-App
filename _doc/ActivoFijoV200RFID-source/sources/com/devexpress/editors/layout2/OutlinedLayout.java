package com.devexpress.editors.layout2;

import android.util.Size;
import com.devexpress.editors.EditBase;
import com.devexpress.editors.dropdown.utils.Rectangle;
import com.devexpress.editors.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OutlinedLayout.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\bH\u0014J\b\u0010\r\u001a\u00020\u0006H\u0014J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/devexpress/editors/layout2/OutlinedLayout;", "Lcom/devexpress/editors/layout2/Layout;", "edit", "Lcom/devexpress/editors/EditBase;", "(Lcom/devexpress/editors/EditBase;)V", "specVertPadding", "", "calcBoxFrame", "", "calcContentFrame", "calcFullBounds", "calcInternalEditorFrame", "calcLabelFrame", "calcTopPadding", "getLabelOffset", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class OutlinedLayout extends Layout {
    public static final float SPEC_VERT_PADDING_DIP = 16.0f;
    private final int specVertPadding;

    @Override // com.devexpress.editors.layout2.Layout
    /* renamed from: getLabelOffset */
    public int getSpecZeroLengthLabelOffset() {
        return 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutlinedLayout(EditBase edit) {
        super(edit);
        Intrinsics.checkNotNullParameter(edit, "edit");
        this.specVertPadding = (int) ((getDensity() * 16.0f) + 0.5f);
    }

    @Override // com.devexpress.editors.layout2.Layout
    protected void calcBoxFrame() {
        int max3 = UtilsKt.max3(getInternalEditorFrame().getHeight(), getLeadingIconFrame().getHeight(), getTrailingIconFrame().getHeight());
        int height = getLabelTextSize().getHeight() / 2;
        setBoxFrame(new Rectangle(0, height, getBoxFrame().getWidth(), calcTargetBoxHeightAndPaddings(max3, height, this.specVertPadding)));
    }

    @Override // com.devexpress.editors.layout2.Layout
    protected void calcFullBounds() {
        int height = getBoxFrame().getHeight() + Math.max(getBottomTextAreaFrame().getHeight(), getCharCounterAreaFrame().getHeight()) + getBoxFrame().getTop();
        if (getLayoutHeightMode() == 1073741824 && height != getMaxSize().getHeight()) {
            height = getMaxSize().getHeight();
        }
        setFullBounds(new Size(getBoxFrame().getWidth(), height));
    }

    @Override // com.devexpress.editors.layout2.Layout
    protected void calcContentFrame() {
        setContentFrame(new Rectangle(getActualBoxPaddings().left, Math.max(getActualBoxPaddings().top, getLabelTextSize().getHeight() / 2) + getBoxFrame().getTop(), getContentFrame().getWidth(), Math.max((getBoxFrame().getHeight() - Math.max(getActualBoxPaddings().top, getLabelTextSize().getHeight() / 2)) - getActualBoxPaddings().bottom, getInternalEditorFrame().getHeight())));
    }

    @Override // com.devexpress.editors.layout2.Layout
    protected void calcInternalEditorFrame() {
        setInternalEditorFrame(new Rectangle(getContentFrame().getLeft() + getLeadingIconOffset() + getPrefixOffset(), calcTopPositionForVerticalGravity(getEdit().getTextGravity(), getInternalEditorFrame().getHeight(), 0), getInternalEditorFrame().getWidth(), Math.min(getInternalEditorFrame().getHeight(), getContentFrame().getHeight())));
    }

    @Override // com.devexpress.editors.layout2.Layout
    protected void calcLabelFrame() {
        setLabelFrame(new Rectangle(getContentFrame().getLeft(), 0, getLabelTextSize().getWidth(), getLabelTextSize().getHeight()));
    }

    @Override // com.devexpress.editors.layout2.Layout
    protected int calcTopPadding() {
        return Math.max(getActualBoxPaddings().top, getLabelTextSize().getHeight() / 2);
    }
}
