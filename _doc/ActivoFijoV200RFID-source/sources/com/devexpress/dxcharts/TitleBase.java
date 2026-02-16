package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public abstract class TitleBase extends StyledElement {
    static final String DEFAULT_TEXT = null;
    static final boolean DEFAULT_VISIBILITY = true;
    private String mText;
    private boolean mVisibility;

    enum Property {
        TEXT,
        VISIBILITY
    }

    TitleBase() {
        this.mText = DEFAULT_TEXT;
        this.mVisibility = true;
    }

    TitleBase(String str) {
        this.mVisibility = true;
        this.mText = str;
    }

    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(TitleStyle.class);
    }

    TitleStyle getActualStyle(ContextProvider contextProvider, Object... objArr) {
        return (TitleStyle) getActualStyleFromContainer(TitleStyle.class, contextProvider, objArr);
    }

    public String getText() {
        return this.mText;
    }

    public void setText(String str) {
        if (CompareHelper.areNotEquals(this.mText, str)) {
            this.mText = str;
            notifyListeners(Property.TEXT);
        }
    }

    public boolean isVisible() {
        return this.mVisibility;
    }

    public void setVisible(boolean z) {
        if (this.mVisibility != z) {
            this.mVisibility = z;
            notifyListeners(Property.VISIBILITY);
        }
    }

    public TitleStyle getStyle() {
        return (TitleStyle) getUserStyleFromContainer(TitleStyle.class);
    }

    public void setStyle(TitleStyle titleStyle) {
        trySetStyle(titleStyle);
    }
}
