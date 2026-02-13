package com.devexpress.editors.dataForm.protocols;

import android.graphics.Typeface;
import android.view.View;
import androidx.profileinstaller.ProfileVerifier;
import com.devexpress.editors.model.Thickness;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExpanderInfo.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B½\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0002\u0010\u001bJ&\u0010\"\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020\u0005J&\u0010A\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020\u0005R\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u001a\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b%\u0010\u001dR\u0011\u0010&\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b'\u0010\u001dR\u0011\u0010(\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b)\u0010\u001dR\u0011\u0010*\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b+\u0010\u001dR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001d\"\u0004\b;\u0010\u001fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010!\"\u0004\bA\u0010#R\u0011\u0010B\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bC\u0010\u001dR\u0011\u0010D\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bE\u0010\u001dR\u0011\u0010F\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bG\u0010\u001dR\u0011\u0010H\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bI\u0010\u001dR\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00103\"\u0004\bK\u0010LR\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010M\"\u0004\bN\u0010OR\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010M\"\u0004\bP\u0010OR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010M\"\u0004\bQ\u0010OR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010M\"\u0004\bR\u0010OR\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010M\"\u0004\bS\u0010OR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u001d\"\u0004\bU\u0010\u001fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u001d\"\u0004\bW\u0010\u001f¨\u0006]"}, d2 = {"Lcom/devexpress/editors/dataForm/protocols/ExpanderInfo;", "", "groupName", "", "separatorColor", "", "separatorThickness", "isLastRowSeparatorVisible", "", "isHeaderVisible", "isVisible", "isCollapsed", "isCollapsable", "headerBackgroundColor", "headerFontColor", "contentBackgroundColor", "headerFontSize", "", "headerFont", "Landroid/graphics/Typeface;", "headerText", "customHeader", "Landroid/view/View;", "editorSpacing", "headerPadding", "Lcom/devexpress/editors/model/Thickness;", "contentPadding", "(Ljava/lang/String;IIZZZZZIIIFLandroid/graphics/Typeface;Ljava/lang/String;Landroid/view/View;ILcom/devexpress/editors/model/Thickness;Lcom/devexpress/editors/model/Thickness;)V", "getContentBackgroundColor", "()I", "setContentBackgroundColor", "(I)V", "getContentPadding", "()Lcom/devexpress/editors/model/Thickness;", "setContentPadding", "(Lcom/devexpress/editors/model/Thickness;)V", "contentPaddingBottom", "getContentPaddingBottom", "contentPaddingLeft", "getContentPaddingLeft", "contentPaddingRight", "getContentPaddingRight", "contentPaddingTop", "getContentPaddingTop", "getCustomHeader", "()Landroid/view/View;", "setCustomHeader", "(Landroid/view/View;)V", "getEditorSpacing", "setEditorSpacing", "getGroupName", "()Ljava/lang/String;", "getHeaderBackgroundColor", "setHeaderBackgroundColor", "getHeaderFont", "()Landroid/graphics/Typeface;", "setHeaderFont", "(Landroid/graphics/Typeface;)V", "getHeaderFontColor", "setHeaderFontColor", "getHeaderFontSize", "()F", "setHeaderFontSize", "(F)V", "getHeaderPadding", "setHeaderPadding", "headerPaddingBottom", "getHeaderPaddingBottom", "headerPaddingLeft", "getHeaderPaddingLeft", "headerPaddingRight", "getHeaderPaddingRight", "headerPaddingTop", "getHeaderPaddingTop", "getHeaderText", "setHeaderText", "(Ljava/lang/String;)V", "()Z", "setCollapsable", "(Z)V", "setCollapsed", "setHeaderVisible", "setLastRowSeparatorVisible", "setVisible", "getSeparatorColor", "setSeparatorColor", "getSeparatorThickness", "setSeparatorThickness", "", "left", "top", "right", "bottom", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class ExpanderInfo {
    private int contentBackgroundColor;
    private Thickness contentPadding;
    private View customHeader;
    private int editorSpacing;
    private final String groupName;
    private int headerBackgroundColor;
    private Typeface headerFont;
    private int headerFontColor;
    private float headerFontSize;
    private Thickness headerPadding;
    private String headerText;
    private boolean isCollapsable;
    private boolean isCollapsed;
    private boolean isHeaderVisible;
    private boolean isLastRowSeparatorVisible;
    private boolean isVisible;
    private int separatorColor;
    private int separatorThickness;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderInfo(String groupName) {
        this(groupName, 0, 0, false, false, false, false, false, 0, 0, 0, 0.0f, null, null, null, 0, null, null, 262142, null);
        Intrinsics.checkNotNullParameter(groupName, "groupName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderInfo(String groupName, int i) {
        this(groupName, i, 0, false, false, false, false, false, 0, 0, 0, 0.0f, null, null, null, 0, null, null, 262140, null);
        Intrinsics.checkNotNullParameter(groupName, "groupName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderInfo(String groupName, int i, int i2) {
        this(groupName, i, i2, false, false, false, false, false, 0, 0, 0, 0.0f, null, null, null, 0, null, null, 262136, null);
        Intrinsics.checkNotNullParameter(groupName, "groupName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderInfo(String groupName, int i, int i2, boolean z) {
        this(groupName, i, i2, z, false, false, false, false, 0, 0, 0, 0.0f, null, null, null, 0, null, null, 262128, null);
        Intrinsics.checkNotNullParameter(groupName, "groupName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderInfo(String groupName, int i, int i2, boolean z, boolean z2) {
        this(groupName, i, i2, z, z2, false, false, false, 0, 0, 0, 0.0f, null, null, null, 0, null, null, 262112, null);
        Intrinsics.checkNotNullParameter(groupName, "groupName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderInfo(String groupName, int i, int i2, boolean z, boolean z2, boolean z3) {
        this(groupName, i, i2, z, z2, z3, false, false, 0, 0, 0, 0.0f, null, null, null, 0, null, null, 262080, null);
        Intrinsics.checkNotNullParameter(groupName, "groupName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderInfo(String groupName, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4) {
        this(groupName, i, i2, z, z2, z3, z4, false, 0, 0, 0, 0.0f, null, null, null, 0, null, null, 262016, null);
        Intrinsics.checkNotNullParameter(groupName, "groupName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderInfo(String groupName, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this(groupName, i, i2, z, z2, z3, z4, z5, 0, 0, 0, 0.0f, null, null, null, 0, null, null, 261888, null);
        Intrinsics.checkNotNullParameter(groupName, "groupName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderInfo(String groupName, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i3) {
        this(groupName, i, i2, z, z2, z3, z4, z5, i3, 0, 0, 0.0f, null, null, null, 0, null, null, 261632, null);
        Intrinsics.checkNotNullParameter(groupName, "groupName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderInfo(String groupName, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i3, int i4) {
        this(groupName, i, i2, z, z2, z3, z4, z5, i3, i4, 0, 0.0f, null, null, null, 0, null, null, 261120, null);
        Intrinsics.checkNotNullParameter(groupName, "groupName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderInfo(String groupName, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i3, int i4, int i5) {
        this(groupName, i, i2, z, z2, z3, z4, z5, i3, i4, i5, 0.0f, null, null, null, 0, null, null, 260096, null);
        Intrinsics.checkNotNullParameter(groupName, "groupName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderInfo(String groupName, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i3, int i4, int i5, float f) {
        this(groupName, i, i2, z, z2, z3, z4, z5, i3, i4, i5, f, null, null, null, 0, null, null, 258048, null);
        Intrinsics.checkNotNullParameter(groupName, "groupName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderInfo(String groupName, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i3, int i4, int i5, float f, Typeface typeface) {
        this(groupName, i, i2, z, z2, z3, z4, z5, i3, i4, i5, f, typeface, null, null, 0, null, null, 253952, null);
        Intrinsics.checkNotNullParameter(groupName, "groupName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderInfo(String groupName, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i3, int i4, int i5, float f, Typeface typeface, String headerText) {
        this(groupName, i, i2, z, z2, z3, z4, z5, i3, i4, i5, f, typeface, headerText, null, 0, null, null, 245760, null);
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(headerText, "headerText");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderInfo(String groupName, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i3, int i4, int i5, float f, Typeface typeface, String headerText, View view) {
        this(groupName, i, i2, z, z2, z3, z4, z5, i3, i4, i5, f, typeface, headerText, view, 0, null, null, 229376, null);
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(headerText, "headerText");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderInfo(String groupName, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i3, int i4, int i5, float f, Typeface typeface, String headerText, View view, int i6) {
        this(groupName, i, i2, z, z2, z3, z4, z5, i3, i4, i5, f, typeface, headerText, view, i6, null, null, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, null);
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(headerText, "headerText");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpanderInfo(String groupName, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i3, int i4, int i5, float f, Typeface typeface, String headerText, View view, int i6, Thickness headerPadding) {
        this(groupName, i, i2, z, z2, z3, z4, z5, i3, i4, i5, f, typeface, headerText, view, i6, headerPadding, null, 131072, null);
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(headerText, "headerText");
        Intrinsics.checkNotNullParameter(headerPadding, "headerPadding");
    }

    public ExpanderInfo(String groupName, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i3, int i4, int i5, float f, Typeface typeface, String headerText, View view, int i6, Thickness headerPadding, Thickness contentPadding) {
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(headerText, "headerText");
        Intrinsics.checkNotNullParameter(headerPadding, "headerPadding");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        this.groupName = groupName;
        this.separatorColor = i;
        this.separatorThickness = i2;
        this.isLastRowSeparatorVisible = z;
        this.isHeaderVisible = z2;
        this.isVisible = z3;
        this.isCollapsed = z4;
        this.isCollapsable = z5;
        this.headerBackgroundColor = i3;
        this.headerFontColor = i4;
        this.contentBackgroundColor = i5;
        this.headerFontSize = f;
        this.headerFont = typeface;
        this.headerText = headerText;
        this.customHeader = view;
        this.editorSpacing = i6;
        this.headerPadding = headerPadding;
        this.contentPadding = contentPadding;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final int getSeparatorColor() {
        return this.separatorColor;
    }

    public final void setSeparatorColor(int i) {
        this.separatorColor = i;
    }

    public final int getSeparatorThickness() {
        return this.separatorThickness;
    }

    public final void setSeparatorThickness(int i) {
        this.separatorThickness = i;
    }

    /* renamed from: isLastRowSeparatorVisible, reason: from getter */
    public final boolean getIsLastRowSeparatorVisible() {
        return this.isLastRowSeparatorVisible;
    }

    public final void setLastRowSeparatorVisible(boolean z) {
        this.isLastRowSeparatorVisible = z;
    }

    /* renamed from: isHeaderVisible, reason: from getter */
    public final boolean getIsHeaderVisible() {
        return this.isHeaderVisible;
    }

    public final void setHeaderVisible(boolean z) {
        this.isHeaderVisible = z;
    }

    /* renamed from: isVisible, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    public final void setVisible(boolean z) {
        this.isVisible = z;
    }

    /* renamed from: isCollapsed, reason: from getter */
    public final boolean getIsCollapsed() {
        return this.isCollapsed;
    }

    public final void setCollapsed(boolean z) {
        this.isCollapsed = z;
    }

    /* renamed from: isCollapsable, reason: from getter */
    public final boolean getIsCollapsable() {
        return this.isCollapsable;
    }

    public final void setCollapsable(boolean z) {
        this.isCollapsable = z;
    }

    public final int getHeaderBackgroundColor() {
        return this.headerBackgroundColor;
    }

    public final void setHeaderBackgroundColor(int i) {
        this.headerBackgroundColor = i;
    }

    public final int getHeaderFontColor() {
        return this.headerFontColor;
    }

    public final void setHeaderFontColor(int i) {
        this.headerFontColor = i;
    }

    public final int getContentBackgroundColor() {
        return this.contentBackgroundColor;
    }

    public final void setContentBackgroundColor(int i) {
        this.contentBackgroundColor = i;
    }

    public final float getHeaderFontSize() {
        return this.headerFontSize;
    }

    public final void setHeaderFontSize(float f) {
        this.headerFontSize = f;
    }

    public final Typeface getHeaderFont() {
        return this.headerFont;
    }

    public final void setHeaderFont(Typeface typeface) {
        this.headerFont = typeface;
    }

    public /* synthetic */ ExpanderInfo(String str, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i3, int i4, int i5, float f, Typeface typeface, String str2, View view, int i6, Thickness thickness, Thickness thickness2, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i7 & 2) != 0 ? 0 : i, (i7 & 4) != 0 ? 0 : i2, (i7 & 8) != 0 ? true : z, (i7 & 16) != 0 ? true : z2, (i7 & 32) != 0 ? true : z3, (i7 & 64) != 0 ? false : z4, (i7 & 128) == 0 ? z5 : true, (i7 & 256) != 0 ? 0 : i3, (i7 & 512) != 0 ? 0 : i4, (i7 & 1024) != 0 ? 0 : i5, (i7 & 2048) != 0 ? -1.0f : f, (i7 & 4096) != 0 ? null : typeface, (i7 & 8192) != 0 ? "" : str2, (i7 & 16384) == 0 ? view : null, (32768 & i7) != 0 ? 0 : i6, (i7 & 65536) != 0 ? new Thickness() : thickness, (i7 & 131072) != 0 ? new Thickness() : thickness2);
    }

    public final String getHeaderText() {
        return this.headerText;
    }

    public final void setHeaderText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.headerText = str;
    }

    public final View getCustomHeader() {
        return this.customHeader;
    }

    public final void setCustomHeader(View view) {
        this.customHeader = view;
    }

    public final int getEditorSpacing() {
        return this.editorSpacing;
    }

    public final void setEditorSpacing(int i) {
        this.editorSpacing = i;
    }

    public final Thickness getHeaderPadding() {
        return this.headerPadding;
    }

    public final void setHeaderPadding(Thickness thickness) {
        Intrinsics.checkNotNullParameter(thickness, "<set-?>");
        this.headerPadding = thickness;
    }

    public final Thickness getContentPadding() {
        return this.contentPadding;
    }

    public final void setContentPadding(Thickness thickness) {
        Intrinsics.checkNotNullParameter(thickness, "<set-?>");
        this.contentPadding = thickness;
    }

    public final int getHeaderPaddingLeft() {
        return this.headerPadding.getStart();
    }

    public final int getHeaderPaddingTop() {
        return this.headerPadding.getTop();
    }

    public final int getHeaderPaddingRight() {
        return this.headerPadding.getEnd();
    }

    public final int getHeaderPaddingBottom() {
        return this.headerPadding.getBottom();
    }

    public final int getContentPaddingLeft() {
        return this.contentPadding.getStart();
    }

    public final int getContentPaddingTop() {
        return this.contentPadding.getTop();
    }

    public final int getContentPaddingRight() {
        return this.contentPadding.getEnd();
    }

    public final int getContentPaddingBottom() {
        return this.contentPadding.getBottom();
    }

    public final void setHeaderPadding(int left, int top, int right, int bottom) {
        this.headerPadding = new Thickness(left, top, right, bottom);
    }

    public final void setContentPadding(int left, int top, int right, int bottom) {
        this.contentPadding = new Thickness(left, top, right, bottom);
    }
}
