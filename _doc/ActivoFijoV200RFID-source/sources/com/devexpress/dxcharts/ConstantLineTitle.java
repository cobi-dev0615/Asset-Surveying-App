package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class ConstantLineTitle extends TitleBase {
    static ConstantLineTitleAlignment DEFAULT_ALIGNMENT = ConstantLineTitleAlignment.NEAR;
    static boolean DEFAULT_SHOW_BELOW_LINE = false;
    private ConstantLineTitleAlignment mAlignment;
    private boolean mShowBelowLine;

    enum Property {
        ALIGNMENT,
        SHOW_BELOW_LINE
    }

    public ConstantLineTitle() {
        this.mShowBelowLine = DEFAULT_SHOW_BELOW_LINE;
        this.mAlignment = DEFAULT_ALIGNMENT;
    }

    public ConstantLineTitle(String str) {
        super(str);
        this.mShowBelowLine = DEFAULT_SHOW_BELOW_LINE;
        this.mAlignment = DEFAULT_ALIGNMENT;
    }

    public ConstantLineTitleAlignment getAlignment() {
        return this.mAlignment;
    }

    public void setAlignment(ConstantLineTitleAlignment constantLineTitleAlignment) {
        if (constantLineTitleAlignment == null || this.mAlignment == constantLineTitleAlignment) {
            return;
        }
        this.mAlignment = constantLineTitleAlignment;
        notifyListeners(Property.ALIGNMENT);
    }

    public boolean isShowBelowLine() {
        return this.mShowBelowLine;
    }

    public void setShowBelowLine(boolean z) {
        if (this.mShowBelowLine != z) {
            this.mShowBelowLine = z;
            notifyListeners(Property.SHOW_BELOW_LINE);
        }
    }
}
