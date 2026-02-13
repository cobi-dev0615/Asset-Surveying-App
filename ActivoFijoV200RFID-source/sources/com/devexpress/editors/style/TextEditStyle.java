package com.devexpress.editors.style;

import com.devexpress.editors.Constants;
import com.devexpress.editors.DXBorderMode;
import com.devexpress.editors.DXCornerMode;
import com.devexpress.editors.model.BorderRounds;
import com.devexpress.editors.model.Thickness;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextEditStyle.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\bk\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001e\u00100\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u00109\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001e\u0010<\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001e\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\u001a\u0010B\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\u001e\u0010E\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\u001e\u0010H\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR\u001e\u0010K\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\bR\u001e\u0010N\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR\u001e\u0010Q\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0006\"\u0004\bS\u0010\bR\u001e\u0010T\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0006\"\u0004\bV\u0010\bR\u001e\u0010W\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0006\"\u0004\bY\u0010\bR\u001e\u0010Z\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0006\"\u0004\b\\\u0010\bR\u001e\u0010]\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u0006\"\u0004\b_\u0010\bR\u001a\u0010`\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0006\"\u0004\bb\u0010\bR\u001e\u0010c\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u0006\"\u0004\be\u0010\bR\u001e\u0010f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0006\"\u0004\bh\u0010\bR\u001e\u0010i\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u0006\"\u0004\bk\u0010\bR\u001a\u0010l\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u0006\"\u0004\bn\u0010\bR\u001e\u0010o\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0006\"\u0004\bq\u0010\bR\u001e\u0010r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0006\"\u0004\bt\u0010\bR\u001a\u0010u\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\u0006\"\u0004\bw\u0010\bR\u001a\u0010x\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u0006\"\u0004\bz\u0010\bR\u001e\u0010{\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\u0006\"\u0004\b}\u0010\bR\u001b\u0010~\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010\u0006\"\u0005\b\u0080\u0001\u0010\bR\u001d\u0010\u0081\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u0006\"\u0005\b\u0083\u0001\u0010\bR\u001d\u0010\u0084\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010\u0006\"\u0005\b\u0086\u0001\u0010\bR\u001d\u0010\u0087\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010\u0006\"\u0005\b\u0089\u0001\u0010\bR\u001d\u0010\u008a\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010\u0006\"\u0005\b\u008c\u0001\u0010\bR\u001d\u0010\u008d\u0001\u001a\u00020(X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010*\"\u0005\b\u008f\u0001\u0010,R\u001d\u0010\u0090\u0001\u001a\u00020(X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010*\"\u0005\b\u0092\u0001\u0010,R!\u0010\u0093\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010\u0006\"\u0005\b\u0095\u0001\u0010\bR!\u0010\u0096\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010\u0006\"\u0005\b\u0098\u0001\u0010\bR\u001d\u0010\u0099\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010\u0006\"\u0005\b\u009b\u0001\u0010\bR!\u0010\u009c\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010\u0006\"\u0005\b\u009e\u0001\u0010\b¨\u0006\u009f\u0001"}, d2 = {"Lcom/devexpress/editors/style/TextEditStyle;", "", "()V", "affixColor", "", "getAffixColor", "()I", "setAffixColor", "(I)V", "affixIndent", "getAffixIndent", "setAffixIndent", "borderColor", "getBorderColor", "setBorderColor", "borderMode", "Lcom/devexpress/editors/DXBorderMode;", "getBorderMode", "()Lcom/devexpress/editors/DXBorderMode;", "setBorderMode", "(Lcom/devexpress/editors/DXBorderMode;)V", "borderRounds", "Lcom/devexpress/editors/model/BorderRounds;", "getBorderRounds", "()Lcom/devexpress/editors/model/BorderRounds;", "setBorderRounds", "(Lcom/devexpress/editors/model/BorderRounds;)V", "borderThickness", "getBorderThickness", "setBorderThickness", "bottomTextTopIndent", "getBottomTextTopIndent", "setBottomTextTopIndent", "boxBackgroundColor", "getBoxBackgroundColor", "setBoxBackgroundColor", "boxHeight", "getBoxHeight", "setBoxHeight", "boxPadding", "Lcom/devexpress/editors/model/Thickness;", "getBoxPadding", "()Lcom/devexpress/editors/model/Thickness;", "setBoxPadding", "(Lcom/devexpress/editors/model/Thickness;)V", "characterCounterStartIndent", "getCharacterCounterStartIndent", "setCharacterCounterStartIndent", "clearIconColor", "getClearIconColor", "setClearIconColor", "cornerMode", "Lcom/devexpress/editors/DXCornerMode;", "getCornerMode", "()Lcom/devexpress/editors/DXCornerMode;", "setCornerMode", "(Lcom/devexpress/editors/DXCornerMode;)V", "cursorColor", "getCursorColor", "setCursorColor", "disabledAffixColor", "getDisabledAffixColor", "setDisabledAffixColor", "disabledBorderColor", "getDisabledBorderColor", "setDisabledBorderColor", "disabledBorderThickness", "getDisabledBorderThickness", "setDisabledBorderThickness", "disabledBoxBackgroundColor", "getDisabledBoxBackgroundColor", "setDisabledBoxBackgroundColor", "disabledClearIconColor", "getDisabledClearIconColor", "setDisabledClearIconColor", "disabledEndIconColor", "getDisabledEndIconColor", "setDisabledEndIconColor", "disabledErrorIconColor", "getDisabledErrorIconColor", "setDisabledErrorIconColor", "disabledHelpTextColor", "getDisabledHelpTextColor", "setDisabledHelpTextColor", "disabledLabelColor", "getDisabledLabelColor", "setDisabledLabelColor", "disabledStartIconColor", "getDisabledStartIconColor", "setDisabledStartIconColor", "disabledTextColor", "getDisabledTextColor", "setDisabledTextColor", "endIconColor", "getEndIconColor", "setEndIconColor", "endIconVerticalGravity", "getEndIconVerticalGravity", "setEndIconVerticalGravity", "errorColor", "getErrorColor", "setErrorColor", "errorIconColor", "getErrorIconColor", "setErrorIconColor", "focusedBorderColor", "getFocusedBorderColor", "setFocusedBorderColor", "focusedBorderThickness", "getFocusedBorderThickness", "setFocusedBorderThickness", "focusedLabelColor", "getFocusedLabelColor", "setFocusedLabelColor", "helpTextColor", "getHelpTextColor", "setHelpTextColor", "iconIndent", "getIconIndent", "setIconIndent", "iconSpacing", "getIconSpacing", "setIconSpacing", "labelColor", "getLabelColor", "setLabelColor", "labelShakeAmplitude", "getLabelShakeAmplitude", "setLabelShakeAmplitude", "labelTextBorderIndent", "getLabelTextBorderIndent", "setLabelTextBorderIndent", "minBoxHeight", "getMinBoxHeight", "setMinBoxHeight", "minBoxWidth", "getMinBoxWidth", "setMinBoxWidth", "minEditorWidth", "getMinEditorWidth", "setMinEditorWidth", "noLabelBoxPadding", "getNoLabelBoxPadding", "setNoLabelBoxPadding", "padding", "getPadding", "setPadding", "placeholderTextColor", "getPlaceholderTextColor", "setPlaceholderTextColor", "startIconColor", "getStartIconColor", "setStartIconColor", "startIconVerticalGravity", "getStartIconVerticalGravity", "setStartIconVerticalGravity", "textColor", "getTextColor", "setTextColor", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class TextEditStyle {
    private int affixColor;
    private int affixIndent;
    private int borderColor;
    private int borderThickness;
    private int bottomTextTopIndent;
    private int boxBackgroundColor;
    private int characterCounterStartIndent;
    private int cursorColor;
    private int disabledAffixColor;
    private int disabledBorderColor;
    private int disabledBorderThickness;
    private int disabledBoxBackgroundColor;
    private int disabledHelpTextColor;
    private int disabledLabelColor;
    private int disabledTextColor;
    private int endIconVerticalGravity;
    private int errorColor;
    private int focusedBorderColor;
    private int focusedBorderThickness;
    private int focusedLabelColor;
    private int helpTextColor;
    private int iconIndent;
    private int iconSpacing;
    private int labelColor;
    private int labelShakeAmplitude;
    private int labelTextBorderIndent;
    private int minEditorWidth;
    private int placeholderTextColor;
    private int startIconVerticalGravity;
    private int textColor;
    private Thickness padding = new Thickness();
    private Thickness boxPadding = new Thickness();
    private Thickness noLabelBoxPadding = new Thickness();
    private DXBorderMode borderMode = DXBorderMode.Outlined;
    private DXCornerMode cornerMode = DXCornerMode.Round;
    private BorderRounds borderRounds = new BorderRounds();
    private int startIconColor = Constants.getEMPTY_COLOR();
    private int disabledStartIconColor = Constants.getEMPTY_COLOR();
    private int endIconColor = Constants.getEMPTY_COLOR();
    private int disabledEndIconColor = Constants.getEMPTY_COLOR();
    private int clearIconColor = Constants.getEMPTY_COLOR();
    private int disabledClearIconColor = Constants.getEMPTY_COLOR();
    private int errorIconColor = Constants.getEMPTY_COLOR();
    private int disabledErrorIconColor = Constants.getEMPTY_COLOR();
    private int minBoxHeight = -1;
    private int minBoxWidth = -1;
    private int boxHeight = -1;

    public final int getMinEditorWidth() {
        return this.minEditorWidth;
    }

    public final void setMinEditorWidth(int i) {
        this.minEditorWidth = i;
    }

    public final Thickness getPadding() {
        return this.padding;
    }

    public final void setPadding(Thickness thickness) {
        Intrinsics.checkNotNullParameter(thickness, "<set-?>");
        this.padding = thickness;
    }

    public final Thickness getBoxPadding() {
        return this.boxPadding;
    }

    public final void setBoxPadding(Thickness thickness) {
        Intrinsics.checkNotNullParameter(thickness, "<set-?>");
        this.boxPadding = thickness;
    }

    public final Thickness getNoLabelBoxPadding() {
        return this.noLabelBoxPadding;
    }

    public final void setNoLabelBoxPadding(Thickness thickness) {
        Intrinsics.checkNotNullParameter(thickness, "<set-?>");
        this.noLabelBoxPadding = thickness;
    }

    public final int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public final void setBoxBackgroundColor(int i) {
        this.boxBackgroundColor = i;
    }

    public final int getDisabledBoxBackgroundColor() {
        return this.disabledBoxBackgroundColor;
    }

    public final void setDisabledBoxBackgroundColor(int i) {
        this.disabledBoxBackgroundColor = i;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(int i) {
        this.textColor = i;
    }

    public final int getDisabledTextColor() {
        return this.disabledTextColor;
    }

    public final void setDisabledTextColor(int i) {
        this.disabledTextColor = i;
    }

    public final int getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    public final void setPlaceholderTextColor(int i) {
        this.placeholderTextColor = i;
    }

    public final int getBorderThickness() {
        return this.borderThickness;
    }

    public final void setBorderThickness(int i) {
        this.borderThickness = i;
    }

    public final int getFocusedBorderThickness() {
        return this.focusedBorderThickness;
    }

    public final void setFocusedBorderThickness(int i) {
        this.focusedBorderThickness = i;
    }

    public final int getDisabledBorderThickness() {
        return this.disabledBorderThickness;
    }

    public final void setDisabledBorderThickness(int i) {
        this.disabledBorderThickness = i;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final void setBorderColor(int i) {
        this.borderColor = i;
    }

    public final int getFocusedBorderColor() {
        return this.focusedBorderColor;
    }

    public final void setFocusedBorderColor(int i) {
        this.focusedBorderColor = i;
    }

    public final int getCursorColor() {
        return this.cursorColor;
    }

    public final void setCursorColor(int i) {
        this.cursorColor = i;
    }

    public final int getDisabledBorderColor() {
        return this.disabledBorderColor;
    }

    public final void setDisabledBorderColor(int i) {
        this.disabledBorderColor = i;
    }

    public DXBorderMode getBorderMode() {
        return this.borderMode;
    }

    public void setBorderMode(DXBorderMode dXBorderMode) {
        Intrinsics.checkNotNullParameter(dXBorderMode, "<set-?>");
        this.borderMode = dXBorderMode;
    }

    public final DXCornerMode getCornerMode() {
        return this.cornerMode;
    }

    public final void setCornerMode(DXCornerMode dXCornerMode) {
        Intrinsics.checkNotNullParameter(dXCornerMode, "<set-?>");
        this.cornerMode = dXCornerMode;
    }

    public final BorderRounds getBorderRounds() {
        return this.borderRounds;
    }

    public final void setBorderRounds(BorderRounds borderRounds) {
        Intrinsics.checkNotNullParameter(borderRounds, "<set-?>");
        this.borderRounds = borderRounds;
    }

    public final int getAffixColor() {
        return this.affixColor;
    }

    public final void setAffixColor(int i) {
        this.affixColor = i;
    }

    public final int getDisabledAffixColor() {
        return this.disabledAffixColor;
    }

    public final void setDisabledAffixColor(int i) {
        this.disabledAffixColor = i;
    }

    public final int getStartIconColor() {
        return this.startIconColor;
    }

    public final void setStartIconColor(int i) {
        this.startIconColor = i;
    }

    public final int getDisabledStartIconColor() {
        return this.disabledStartIconColor;
    }

    public final void setDisabledStartIconColor(int i) {
        this.disabledStartIconColor = i;
    }

    public final int getEndIconColor() {
        return this.endIconColor;
    }

    public final void setEndIconColor(int i) {
        this.endIconColor = i;
    }

    public final int getDisabledEndIconColor() {
        return this.disabledEndIconColor;
    }

    public final void setDisabledEndIconColor(int i) {
        this.disabledEndIconColor = i;
    }

    public final int getClearIconColor() {
        return this.clearIconColor;
    }

    public final void setClearIconColor(int i) {
        this.clearIconColor = i;
    }

    public final int getDisabledClearIconColor() {
        return this.disabledClearIconColor;
    }

    public final void setDisabledClearIconColor(int i) {
        this.disabledClearIconColor = i;
    }

    public final int getErrorIconColor() {
        return this.errorIconColor;
    }

    public final void setErrorIconColor(int i) {
        this.errorIconColor = i;
    }

    public final int getDisabledErrorIconColor() {
        return this.disabledErrorIconColor;
    }

    public final void setDisabledErrorIconColor(int i) {
        this.disabledErrorIconColor = i;
    }

    public final int getIconIndent() {
        return this.iconIndent;
    }

    public final void setIconIndent(int i) {
        this.iconIndent = i;
    }

    public final int getAffixIndent() {
        return this.affixIndent;
    }

    public final void setAffixIndent(int i) {
        this.affixIndent = i;
    }

    public final int getStartIconVerticalGravity() {
        return this.startIconVerticalGravity;
    }

    public final void setStartIconVerticalGravity(int i) {
        this.startIconVerticalGravity = i;
    }

    public final int getEndIconVerticalGravity() {
        return this.endIconVerticalGravity;
    }

    public final void setEndIconVerticalGravity(int i) {
        this.endIconVerticalGravity = i;
    }

    public final int getIconSpacing() {
        return this.iconSpacing;
    }

    public final void setIconSpacing(int i) {
        this.iconSpacing = i;
    }

    public final int getLabelColor() {
        return this.labelColor;
    }

    public final void setLabelColor(int i) {
        this.labelColor = i;
    }

    public final int getFocusedLabelColor() {
        return this.focusedLabelColor;
    }

    public final void setFocusedLabelColor(int i) {
        this.focusedLabelColor = i;
    }

    public final int getDisabledLabelColor() {
        return this.disabledLabelColor;
    }

    public final void setDisabledLabelColor(int i) {
        this.disabledLabelColor = i;
    }

    public final int getLabelTextBorderIndent() {
        return this.labelTextBorderIndent;
    }

    public final void setLabelTextBorderIndent(int i) {
        this.labelTextBorderIndent = i;
    }

    public final int getBottomTextTopIndent() {
        return this.bottomTextTopIndent;
    }

    public final void setBottomTextTopIndent(int i) {
        this.bottomTextTopIndent = i;
    }

    public final int getCharacterCounterStartIndent() {
        return this.characterCounterStartIndent;
    }

    public final void setCharacterCounterStartIndent(int i) {
        this.characterCounterStartIndent = i;
    }

    public final int getMinBoxHeight() {
        return this.minBoxHeight;
    }

    public final void setMinBoxHeight(int i) {
        this.minBoxHeight = i;
    }

    public final int getMinBoxWidth() {
        return this.minBoxWidth;
    }

    public final void setMinBoxWidth(int i) {
        this.minBoxWidth = i;
    }

    public final int getBoxHeight() {
        return this.boxHeight;
    }

    public final void setBoxHeight(int i) {
        this.boxHeight = i;
    }

    public final int getHelpTextColor() {
        return this.helpTextColor;
    }

    public final void setHelpTextColor(int i) {
        this.helpTextColor = i;
    }

    public final int getDisabledHelpTextColor() {
        return this.disabledHelpTextColor;
    }

    public final void setDisabledHelpTextColor(int i) {
        this.disabledHelpTextColor = i;
    }

    public final int getErrorColor() {
        return this.errorColor;
    }

    public final void setErrorColor(int i) {
        this.errorColor = i;
    }

    public final int getLabelShakeAmplitude() {
        return this.labelShakeAmplitude;
    }

    public final void setLabelShakeAmplitude(int i) {
        this.labelShakeAmplitude = i;
    }
}
