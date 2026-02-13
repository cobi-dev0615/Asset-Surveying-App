package com.devexpress.editors.dataForm.protocols;

import android.graphics.Typeface;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.devexpress.editors.model.Thickness;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataFormEditorInfo.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\bR\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0099\u0002\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010 \u001a\u00020\u001e\u0012\b\b\u0002\u0010!\u001a\u00020\u0006\u0012\b\b\u0002\u0010\"\u001a\u00020\u0006\u0012\b\b\u0002\u0010#\u001a\u00020\u0006\u0012\b\b\u0002\u0010$\u001a\u00020\u0016\u0012\b\b\u0002\u0010%\u001a\u00020\u0003\u0012\b\b\u0002\u0010&\u001a\u00020'¢\u0006\u0002\u0010(J&\u0010c\u001a\u00020z2\u0006\u0010{\u001a\u00020\u00062\u0006\u0010|\u001a\u00020\u00062\u0006\u0010}\u001a\u00020\u00062\u0006\u0010~\u001a\u00020\u0006R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010 \u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010\u0014\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010\"\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010*\"\u0004\b>\u0010,R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010%\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010@\"\u0004\bD\u0010BR\u001a\u0010!\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010*\"\u0004\bF\u0010,R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010G\"\u0004\bH\u0010IR\u001a\u0010\u0017\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010G\"\u0004\bJ\u0010IR\u001a\u0010#\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010*\"\u0004\bL\u0010,R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u00106\"\u0004\bN\u00108R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010*\"\u0004\bT\u0010,R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010@\"\u0004\bZ\u0010BR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010.\"\u0004\b\\\u00100R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u00102\"\u0004\b^\u00104R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010:\"\u0004\b`\u0010<R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0011\u0010e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bf\u0010*R\u0011\u0010g\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bh\u0010*R\u0011\u0010i\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bj\u0010*R\u0011\u0010k\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bl\u0010*R\u001a\u0010$\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010G\"\u0004\bn\u0010IR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010*\"\u0004\bp\u0010,R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010*\"\u0004\br\u0010,R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010*\"\u0004\bt\u0010,R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\by\u0010@¨\u0006\u007f"}, d2 = {"Lcom/devexpress/editors/dataForm/protocols/DataFormEditorInfo;", "", "uniqueId", "", "fieldName", "rowIndex", "", "rowItemIndex", "rowSpan", "backgroundColor", "type", "Lcom/devexpress/editors/dataForm/protocols/EditorType;", "labelPosition", "Lcom/devexpress/editors/dataForm/protocols/EditorLabelPosition;", "labelHorizontalAlignment", "Lcom/devexpress/editors/dataForm/protocols/LayoutAlignment;", "editorHorizontalAlignment", "labelIndent", "labelWidth", "Lcom/devexpress/editors/dataForm/protocols/DXSize;", "editorWidth", "isLabelVisible", "", "isVisible", "labelText", "labelIconInfo", "Lcom/devexpress/editors/dataForm/protocols/AsyncImageInfo;", "labelTextTypeface", "Landroid/graphics/Typeface;", "labelTextSize", "", "bottomTextTypeface", "bottomTextSize", "helperFontColor", "errorFontColor", "labelFontColor", "reserveBottomTextLine", "helpText", "padding", "Lcom/devexpress/editors/model/Thickness;", "(Ljava/lang/String;Ljava/lang/String;IIIILcom/devexpress/editors/dataForm/protocols/EditorType;Lcom/devexpress/editors/dataForm/protocols/EditorLabelPosition;Lcom/devexpress/editors/dataForm/protocols/LayoutAlignment;Lcom/devexpress/editors/dataForm/protocols/LayoutAlignment;ILcom/devexpress/editors/dataForm/protocols/DXSize;Lcom/devexpress/editors/dataForm/protocols/DXSize;ZZLjava/lang/String;Lcom/devexpress/editors/dataForm/protocols/AsyncImageInfo;Landroid/graphics/Typeface;FLandroid/graphics/Typeface;FIIIZLjava/lang/String;Lcom/devexpress/editors/model/Thickness;)V", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "getBottomTextSize", "()F", "setBottomTextSize", "(F)V", "getBottomTextTypeface", "()Landroid/graphics/Typeface;", "setBottomTextTypeface", "(Landroid/graphics/Typeface;)V", "getEditorHorizontalAlignment", "()Lcom/devexpress/editors/dataForm/protocols/LayoutAlignment;", "setEditorHorizontalAlignment", "(Lcom/devexpress/editors/dataForm/protocols/LayoutAlignment;)V", "getEditorWidth", "()Lcom/devexpress/editors/dataForm/protocols/DXSize;", "setEditorWidth", "(Lcom/devexpress/editors/dataForm/protocols/DXSize;)V", "getErrorFontColor", "setErrorFontColor", "getFieldName", "()Ljava/lang/String;", "setFieldName", "(Ljava/lang/String;)V", "getHelpText", "setHelpText", "getHelperFontColor", "setHelperFontColor", "()Z", "setLabelVisible", "(Z)V", "setVisible", "getLabelFontColor", "setLabelFontColor", "getLabelHorizontalAlignment", "setLabelHorizontalAlignment", "getLabelIconInfo", "()Lcom/devexpress/editors/dataForm/protocols/AsyncImageInfo;", "setLabelIconInfo", "(Lcom/devexpress/editors/dataForm/protocols/AsyncImageInfo;)V", "getLabelIndent", "setLabelIndent", "getLabelPosition", "()Lcom/devexpress/editors/dataForm/protocols/EditorLabelPosition;", "setLabelPosition", "(Lcom/devexpress/editors/dataForm/protocols/EditorLabelPosition;)V", "getLabelText", "setLabelText", "getLabelTextSize", "setLabelTextSize", "getLabelTextTypeface", "setLabelTextTypeface", "getLabelWidth", "setLabelWidth", "getPadding", "()Lcom/devexpress/editors/model/Thickness;", "setPadding", "(Lcom/devexpress/editors/model/Thickness;)V", "paddingBottom", "getPaddingBottom", "paddingLeft", "getPaddingLeft", "paddingRight", "getPaddingRight", "paddingTop", "getPaddingTop", "getReserveBottomTextLine", "setReserveBottomTextLine", "getRowIndex", "setRowIndex", "getRowItemIndex", "setRowItemIndex", "getRowSpan", "setRowSpan", "getType", "()Lcom/devexpress/editors/dataForm/protocols/EditorType;", "setType", "(Lcom/devexpress/editors/dataForm/protocols/EditorType;)V", "getUniqueId", "", "left", "top", "right", "bottom", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class DataFormEditorInfo {
    private int backgroundColor;
    private float bottomTextSize;
    private Typeface bottomTextTypeface;
    private LayoutAlignment editorHorizontalAlignment;
    private DXSize editorWidth;
    private int errorFontColor;
    private String fieldName;
    private String helpText;
    private int helperFontColor;
    private boolean isLabelVisible;
    private boolean isVisible;
    private int labelFontColor;
    private LayoutAlignment labelHorizontalAlignment;
    private AsyncImageInfo labelIconInfo;
    private int labelIndent;
    private EditorLabelPosition labelPosition;
    private String labelText;
    private float labelTextSize;
    private Typeface labelTextTypeface;
    private DXSize labelWidth;
    private Thickness padding;
    private boolean reserveBottomTextLine;
    private int rowIndex;
    private int rowItemIndex;
    private int rowSpan;
    private EditorType type;
    private final String uniqueId;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId) {
        this(uniqueId, null, 0, 0, 0, 0, null, null, null, null, 0, null, null, false, false, null, null, null, 0.0f, null, 0.0f, 0, 0, 0, false, null, null, 134217726, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName) {
        this(uniqueId, fieldName, 0, 0, 0, 0, null, null, null, null, 0, null, null, false, false, null, null, null, 0.0f, null, 0.0f, 0, 0, 0, false, null, null, 134217724, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i) {
        this(uniqueId, fieldName, i, 0, 0, 0, null, null, null, null, 0, null, null, false, false, null, null, null, 0.0f, null, 0.0f, 0, 0, 0, false, null, null, 134217720, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2) {
        this(uniqueId, fieldName, i, i2, 0, 0, null, null, null, null, 0, null, null, false, false, null, null, null, 0.0f, null, 0.0f, 0, 0, 0, false, null, null, 134217712, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3) {
        this(uniqueId, fieldName, i, i2, i3, 0, null, null, null, null, 0, null, null, false, false, null, null, null, 0.0f, null, 0.0f, 0, 0, 0, false, null, null, 134217696, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4) {
        this(uniqueId, fieldName, i, i2, i3, i4, null, null, null, null, 0, null, null, false, false, null, null, null, 0.0f, null, 0.0f, 0, 0, 0, false, null, null, 134217664, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, null, null, null, 0, null, null, false, false, null, null, null, 0.0f, null, 0.0f, 0, 0, 0, false, null, null, 134217600, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, null, null, 0, null, null, false, false, null, null, null, 0.0f, null, 0.0f, 0, 0, 0, false, null, null, 134217472, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, labelHorizontalAlignment, null, 0, null, null, false, false, null, null, null, 0.0f, null, 0.0f, 0, 0, 0, false, null, null, 134217216, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment, LayoutAlignment editorHorizontalAlignment) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, labelHorizontalAlignment, editorHorizontalAlignment, 0, null, null, false, false, null, null, null, 0.0f, null, 0.0f, 0, 0, 0, false, null, null, 134216704, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
        Intrinsics.checkNotNullParameter(editorHorizontalAlignment, "editorHorizontalAlignment");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment, LayoutAlignment editorHorizontalAlignment, int i5) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, labelHorizontalAlignment, editorHorizontalAlignment, i5, null, null, false, false, null, null, null, 0.0f, null, 0.0f, 0, 0, 0, false, null, null, 134215680, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
        Intrinsics.checkNotNullParameter(editorHorizontalAlignment, "editorHorizontalAlignment");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment, LayoutAlignment editorHorizontalAlignment, int i5, DXSize labelWidth) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, labelHorizontalAlignment, editorHorizontalAlignment, i5, labelWidth, null, false, false, null, null, null, 0.0f, null, 0.0f, 0, 0, 0, false, null, null, 134213632, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
        Intrinsics.checkNotNullParameter(editorHorizontalAlignment, "editorHorizontalAlignment");
        Intrinsics.checkNotNullParameter(labelWidth, "labelWidth");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment, LayoutAlignment editorHorizontalAlignment, int i5, DXSize labelWidth, DXSize editorWidth) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, labelHorizontalAlignment, editorHorizontalAlignment, i5, labelWidth, editorWidth, false, false, null, null, null, 0.0f, null, 0.0f, 0, 0, 0, false, null, null, 134209536, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
        Intrinsics.checkNotNullParameter(editorHorizontalAlignment, "editorHorizontalAlignment");
        Intrinsics.checkNotNullParameter(labelWidth, "labelWidth");
        Intrinsics.checkNotNullParameter(editorWidth, "editorWidth");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment, LayoutAlignment editorHorizontalAlignment, int i5, DXSize labelWidth, DXSize editorWidth, boolean z) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, labelHorizontalAlignment, editorHorizontalAlignment, i5, labelWidth, editorWidth, z, false, null, null, null, 0.0f, null, 0.0f, 0, 0, 0, false, null, null, 134201344, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
        Intrinsics.checkNotNullParameter(editorHorizontalAlignment, "editorHorizontalAlignment");
        Intrinsics.checkNotNullParameter(labelWidth, "labelWidth");
        Intrinsics.checkNotNullParameter(editorWidth, "editorWidth");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment, LayoutAlignment editorHorizontalAlignment, int i5, DXSize labelWidth, DXSize editorWidth, boolean z, boolean z2) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, labelHorizontalAlignment, editorHorizontalAlignment, i5, labelWidth, editorWidth, z, z2, null, null, null, 0.0f, null, 0.0f, 0, 0, 0, false, null, null, 134184960, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
        Intrinsics.checkNotNullParameter(editorHorizontalAlignment, "editorHorizontalAlignment");
        Intrinsics.checkNotNullParameter(labelWidth, "labelWidth");
        Intrinsics.checkNotNullParameter(editorWidth, "editorWidth");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment, LayoutAlignment editorHorizontalAlignment, int i5, DXSize labelWidth, DXSize editorWidth, boolean z, boolean z2, String labelText) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, labelHorizontalAlignment, editorHorizontalAlignment, i5, labelWidth, editorWidth, z, z2, labelText, null, null, 0.0f, null, 0.0f, 0, 0, 0, false, null, null, 134152192, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
        Intrinsics.checkNotNullParameter(editorHorizontalAlignment, "editorHorizontalAlignment");
        Intrinsics.checkNotNullParameter(labelWidth, "labelWidth");
        Intrinsics.checkNotNullParameter(editorWidth, "editorWidth");
        Intrinsics.checkNotNullParameter(labelText, "labelText");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment, LayoutAlignment editorHorizontalAlignment, int i5, DXSize labelWidth, DXSize editorWidth, boolean z, boolean z2, String labelText, AsyncImageInfo asyncImageInfo) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, labelHorizontalAlignment, editorHorizontalAlignment, i5, labelWidth, editorWidth, z, z2, labelText, asyncImageInfo, null, 0.0f, null, 0.0f, 0, 0, 0, false, null, null, 134086656, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
        Intrinsics.checkNotNullParameter(editorHorizontalAlignment, "editorHorizontalAlignment");
        Intrinsics.checkNotNullParameter(labelWidth, "labelWidth");
        Intrinsics.checkNotNullParameter(editorWidth, "editorWidth");
        Intrinsics.checkNotNullParameter(labelText, "labelText");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment, LayoutAlignment editorHorizontalAlignment, int i5, DXSize labelWidth, DXSize editorWidth, boolean z, boolean z2, String labelText, AsyncImageInfo asyncImageInfo, Typeface typeface) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, labelHorizontalAlignment, editorHorizontalAlignment, i5, labelWidth, editorWidth, z, z2, labelText, asyncImageInfo, typeface, 0.0f, null, 0.0f, 0, 0, 0, false, null, null, 133955584, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
        Intrinsics.checkNotNullParameter(editorHorizontalAlignment, "editorHorizontalAlignment");
        Intrinsics.checkNotNullParameter(labelWidth, "labelWidth");
        Intrinsics.checkNotNullParameter(editorWidth, "editorWidth");
        Intrinsics.checkNotNullParameter(labelText, "labelText");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment, LayoutAlignment editorHorizontalAlignment, int i5, DXSize labelWidth, DXSize editorWidth, boolean z, boolean z2, String labelText, AsyncImageInfo asyncImageInfo, Typeface typeface, float f) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, labelHorizontalAlignment, editorHorizontalAlignment, i5, labelWidth, editorWidth, z, z2, labelText, asyncImageInfo, typeface, f, null, 0.0f, 0, 0, 0, false, null, null, 133693440, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
        Intrinsics.checkNotNullParameter(editorHorizontalAlignment, "editorHorizontalAlignment");
        Intrinsics.checkNotNullParameter(labelWidth, "labelWidth");
        Intrinsics.checkNotNullParameter(editorWidth, "editorWidth");
        Intrinsics.checkNotNullParameter(labelText, "labelText");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment, LayoutAlignment editorHorizontalAlignment, int i5, DXSize labelWidth, DXSize editorWidth, boolean z, boolean z2, String labelText, AsyncImageInfo asyncImageInfo, Typeface typeface, float f, Typeface typeface2) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, labelHorizontalAlignment, editorHorizontalAlignment, i5, labelWidth, editorWidth, z, z2, labelText, asyncImageInfo, typeface, f, typeface2, 0.0f, 0, 0, 0, false, null, null, 133169152, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
        Intrinsics.checkNotNullParameter(editorHorizontalAlignment, "editorHorizontalAlignment");
        Intrinsics.checkNotNullParameter(labelWidth, "labelWidth");
        Intrinsics.checkNotNullParameter(editorWidth, "editorWidth");
        Intrinsics.checkNotNullParameter(labelText, "labelText");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment, LayoutAlignment editorHorizontalAlignment, int i5, DXSize labelWidth, DXSize editorWidth, boolean z, boolean z2, String labelText, AsyncImageInfo asyncImageInfo, Typeface typeface, float f, Typeface typeface2, float f2) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, labelHorizontalAlignment, editorHorizontalAlignment, i5, labelWidth, editorWidth, z, z2, labelText, asyncImageInfo, typeface, f, typeface2, f2, 0, 0, 0, false, null, null, 132120576, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
        Intrinsics.checkNotNullParameter(editorHorizontalAlignment, "editorHorizontalAlignment");
        Intrinsics.checkNotNullParameter(labelWidth, "labelWidth");
        Intrinsics.checkNotNullParameter(editorWidth, "editorWidth");
        Intrinsics.checkNotNullParameter(labelText, "labelText");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment, LayoutAlignment editorHorizontalAlignment, int i5, DXSize labelWidth, DXSize editorWidth, boolean z, boolean z2, String labelText, AsyncImageInfo asyncImageInfo, Typeface typeface, float f, Typeface typeface2, float f2, int i6) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, labelHorizontalAlignment, editorHorizontalAlignment, i5, labelWidth, editorWidth, z, z2, labelText, asyncImageInfo, typeface, f, typeface2, f2, i6, 0, 0, false, null, null, 130023424, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
        Intrinsics.checkNotNullParameter(editorHorizontalAlignment, "editorHorizontalAlignment");
        Intrinsics.checkNotNullParameter(labelWidth, "labelWidth");
        Intrinsics.checkNotNullParameter(editorWidth, "editorWidth");
        Intrinsics.checkNotNullParameter(labelText, "labelText");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment, LayoutAlignment editorHorizontalAlignment, int i5, DXSize labelWidth, DXSize editorWidth, boolean z, boolean z2, String labelText, AsyncImageInfo asyncImageInfo, Typeface typeface, float f, Typeface typeface2, float f2, int i6, int i7) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, labelHorizontalAlignment, editorHorizontalAlignment, i5, labelWidth, editorWidth, z, z2, labelText, asyncImageInfo, typeface, f, typeface2, f2, i6, i7, 0, false, null, null, 125829120, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
        Intrinsics.checkNotNullParameter(editorHorizontalAlignment, "editorHorizontalAlignment");
        Intrinsics.checkNotNullParameter(labelWidth, "labelWidth");
        Intrinsics.checkNotNullParameter(editorWidth, "editorWidth");
        Intrinsics.checkNotNullParameter(labelText, "labelText");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment, LayoutAlignment editorHorizontalAlignment, int i5, DXSize labelWidth, DXSize editorWidth, boolean z, boolean z2, String labelText, AsyncImageInfo asyncImageInfo, Typeface typeface, float f, Typeface typeface2, float f2, int i6, int i7, int i8) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, labelHorizontalAlignment, editorHorizontalAlignment, i5, labelWidth, editorWidth, z, z2, labelText, asyncImageInfo, typeface, f, typeface2, f2, i6, i7, i8, false, null, null, 117440512, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
        Intrinsics.checkNotNullParameter(editorHorizontalAlignment, "editorHorizontalAlignment");
        Intrinsics.checkNotNullParameter(labelWidth, "labelWidth");
        Intrinsics.checkNotNullParameter(editorWidth, "editorWidth");
        Intrinsics.checkNotNullParameter(labelText, "labelText");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment, LayoutAlignment editorHorizontalAlignment, int i5, DXSize labelWidth, DXSize editorWidth, boolean z, boolean z2, String labelText, AsyncImageInfo asyncImageInfo, Typeface typeface, float f, Typeface typeface2, float f2, int i6, int i7, int i8, boolean z3) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, labelHorizontalAlignment, editorHorizontalAlignment, i5, labelWidth, editorWidth, z, z2, labelText, asyncImageInfo, typeface, f, typeface2, f2, i6, i7, i8, z3, null, null, 100663296, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
        Intrinsics.checkNotNullParameter(editorHorizontalAlignment, "editorHorizontalAlignment");
        Intrinsics.checkNotNullParameter(labelWidth, "labelWidth");
        Intrinsics.checkNotNullParameter(editorWidth, "editorWidth");
        Intrinsics.checkNotNullParameter(labelText, "labelText");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment, LayoutAlignment editorHorizontalAlignment, int i5, DXSize labelWidth, DXSize editorWidth, boolean z, boolean z2, String labelText, AsyncImageInfo asyncImageInfo, Typeface typeface, float f, Typeface typeface2, float f2, int i6, int i7, int i8, boolean z3, String helpText) {
        this(uniqueId, fieldName, i, i2, i3, i4, type, labelPosition, labelHorizontalAlignment, editorHorizontalAlignment, i5, labelWidth, editorWidth, z, z2, labelText, asyncImageInfo, typeface, f, typeface2, f2, i6, i7, i8, z3, helpText, null, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL, null);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
        Intrinsics.checkNotNullParameter(editorHorizontalAlignment, "editorHorizontalAlignment");
        Intrinsics.checkNotNullParameter(labelWidth, "labelWidth");
        Intrinsics.checkNotNullParameter(editorWidth, "editorWidth");
        Intrinsics.checkNotNullParameter(labelText, "labelText");
        Intrinsics.checkNotNullParameter(helpText, "helpText");
    }

    public DataFormEditorInfo(String uniqueId, String fieldName, int i, int i2, int i3, int i4, EditorType type, EditorLabelPosition labelPosition, LayoutAlignment labelHorizontalAlignment, LayoutAlignment editorHorizontalAlignment, int i5, DXSize labelWidth, DXSize editorWidth, boolean z, boolean z2, String labelText, AsyncImageInfo asyncImageInfo, Typeface typeface, float f, Typeface typeface2, float f2, int i6, int i7, int i8, boolean z3, String helpText, Thickness padding) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(labelPosition, "labelPosition");
        Intrinsics.checkNotNullParameter(labelHorizontalAlignment, "labelHorizontalAlignment");
        Intrinsics.checkNotNullParameter(editorHorizontalAlignment, "editorHorizontalAlignment");
        Intrinsics.checkNotNullParameter(labelWidth, "labelWidth");
        Intrinsics.checkNotNullParameter(editorWidth, "editorWidth");
        Intrinsics.checkNotNullParameter(labelText, "labelText");
        Intrinsics.checkNotNullParameter(helpText, "helpText");
        Intrinsics.checkNotNullParameter(padding, "padding");
        this.uniqueId = uniqueId;
        this.fieldName = fieldName;
        this.rowIndex = i;
        this.rowItemIndex = i2;
        this.rowSpan = i3;
        this.backgroundColor = i4;
        this.type = type;
        this.labelPosition = labelPosition;
        this.labelHorizontalAlignment = labelHorizontalAlignment;
        this.editorHorizontalAlignment = editorHorizontalAlignment;
        this.labelIndent = i5;
        this.labelWidth = labelWidth;
        this.editorWidth = editorWidth;
        this.isLabelVisible = z;
        this.isVisible = z2;
        this.labelText = labelText;
        this.labelIconInfo = asyncImageInfo;
        this.labelTextTypeface = typeface;
        this.labelTextSize = f;
        this.bottomTextTypeface = typeface2;
        this.bottomTextSize = f2;
        this.helperFontColor = i6;
        this.errorFontColor = i7;
        this.labelFontColor = i8;
        this.reserveBottomTextLine = z3;
        this.helpText = helpText;
        this.padding = padding;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ DataFormEditorInfo(java.lang.String r28, java.lang.String r29, int r30, int r31, int r32, int r33, com.devexpress.editors.dataForm.protocols.EditorType r34, com.devexpress.editors.dataForm.protocols.EditorLabelPosition r35, com.devexpress.editors.dataForm.protocols.LayoutAlignment r36, com.devexpress.editors.dataForm.protocols.LayoutAlignment r37, int r38, com.devexpress.editors.dataForm.protocols.DXSize r39, com.devexpress.editors.dataForm.protocols.DXSize r40, boolean r41, boolean r42, java.lang.String r43, com.devexpress.editors.dataForm.protocols.AsyncImageInfo r44, android.graphics.Typeface r45, float r46, android.graphics.Typeface r47, float r48, int r49, int r50, int r51, boolean r52, java.lang.String r53, com.devexpress.editors.model.Thickness r54, int r55, kotlin.jvm.internal.DefaultConstructorMarker r56) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.editors.dataForm.protocols.DataFormEditorInfo.<init>(java.lang.String, java.lang.String, int, int, int, int, com.devexpress.editors.dataForm.protocols.EditorType, com.devexpress.editors.dataForm.protocols.EditorLabelPosition, com.devexpress.editors.dataForm.protocols.LayoutAlignment, com.devexpress.editors.dataForm.protocols.LayoutAlignment, int, com.devexpress.editors.dataForm.protocols.DXSize, com.devexpress.editors.dataForm.protocols.DXSize, boolean, boolean, java.lang.String, com.devexpress.editors.dataForm.protocols.AsyncImageInfo, android.graphics.Typeface, float, android.graphics.Typeface, float, int, int, int, boolean, java.lang.String, com.devexpress.editors.model.Thickness, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final void setFieldName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fieldName = str;
    }

    public final int getRowIndex() {
        return this.rowIndex;
    }

    public final void setRowIndex(int i) {
        this.rowIndex = i;
    }

    public final int getRowItemIndex() {
        return this.rowItemIndex;
    }

    public final void setRowItemIndex(int i) {
        this.rowItemIndex = i;
    }

    public final int getRowSpan() {
        return this.rowSpan;
    }

    public final void setRowSpan(int i) {
        this.rowSpan = i;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final EditorType getType() {
        return this.type;
    }

    public final void setType(EditorType editorType) {
        Intrinsics.checkNotNullParameter(editorType, "<set-?>");
        this.type = editorType;
    }

    public final EditorLabelPosition getLabelPosition() {
        return this.labelPosition;
    }

    public final void setLabelPosition(EditorLabelPosition editorLabelPosition) {
        Intrinsics.checkNotNullParameter(editorLabelPosition, "<set-?>");
        this.labelPosition = editorLabelPosition;
    }

    public final LayoutAlignment getLabelHorizontalAlignment() {
        return this.labelHorizontalAlignment;
    }

    public final void setLabelHorizontalAlignment(LayoutAlignment layoutAlignment) {
        Intrinsics.checkNotNullParameter(layoutAlignment, "<set-?>");
        this.labelHorizontalAlignment = layoutAlignment;
    }

    public final LayoutAlignment getEditorHorizontalAlignment() {
        return this.editorHorizontalAlignment;
    }

    public final void setEditorHorizontalAlignment(LayoutAlignment layoutAlignment) {
        Intrinsics.checkNotNullParameter(layoutAlignment, "<set-?>");
        this.editorHorizontalAlignment = layoutAlignment;
    }

    public final int getLabelIndent() {
        return this.labelIndent;
    }

    public final void setLabelIndent(int i) {
        this.labelIndent = i;
    }

    public final DXSize getLabelWidth() {
        return this.labelWidth;
    }

    public final void setLabelWidth(DXSize dXSize) {
        Intrinsics.checkNotNullParameter(dXSize, "<set-?>");
        this.labelWidth = dXSize;
    }

    public final DXSize getEditorWidth() {
        return this.editorWidth;
    }

    public final void setEditorWidth(DXSize dXSize) {
        Intrinsics.checkNotNullParameter(dXSize, "<set-?>");
        this.editorWidth = dXSize;
    }

    /* renamed from: isLabelVisible, reason: from getter */
    public final boolean getIsLabelVisible() {
        return this.isLabelVisible;
    }

    public final void setLabelVisible(boolean z) {
        this.isLabelVisible = z;
    }

    /* renamed from: isVisible, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    public final void setVisible(boolean z) {
        this.isVisible = z;
    }

    public final String getLabelText() {
        return this.labelText;
    }

    public final void setLabelText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.labelText = str;
    }

    public final AsyncImageInfo getLabelIconInfo() {
        return this.labelIconInfo;
    }

    public final void setLabelIconInfo(AsyncImageInfo asyncImageInfo) {
        this.labelIconInfo = asyncImageInfo;
    }

    public final Typeface getLabelTextTypeface() {
        return this.labelTextTypeface;
    }

    public final void setLabelTextTypeface(Typeface typeface) {
        this.labelTextTypeface = typeface;
    }

    public final float getLabelTextSize() {
        return this.labelTextSize;
    }

    public final void setLabelTextSize(float f) {
        this.labelTextSize = f;
    }

    public final Typeface getBottomTextTypeface() {
        return this.bottomTextTypeface;
    }

    public final void setBottomTextTypeface(Typeface typeface) {
        this.bottomTextTypeface = typeface;
    }

    public final float getBottomTextSize() {
        return this.bottomTextSize;
    }

    public final void setBottomTextSize(float f) {
        this.bottomTextSize = f;
    }

    public final int getHelperFontColor() {
        return this.helperFontColor;
    }

    public final void setHelperFontColor(int i) {
        this.helperFontColor = i;
    }

    public final int getErrorFontColor() {
        return this.errorFontColor;
    }

    public final void setErrorFontColor(int i) {
        this.errorFontColor = i;
    }

    public final int getLabelFontColor() {
        return this.labelFontColor;
    }

    public final void setLabelFontColor(int i) {
        this.labelFontColor = i;
    }

    public final boolean getReserveBottomTextLine() {
        return this.reserveBottomTextLine;
    }

    public final void setReserveBottomTextLine(boolean z) {
        this.reserveBottomTextLine = z;
    }

    public final String getHelpText() {
        return this.helpText;
    }

    public final void setHelpText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.helpText = str;
    }

    public final Thickness getPadding() {
        return this.padding;
    }

    public final void setPadding(Thickness thickness) {
        Intrinsics.checkNotNullParameter(thickness, "<set-?>");
        this.padding = thickness;
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        this.padding = new Thickness(left, top, right, bottom);
    }

    public final int getPaddingLeft() {
        return this.padding.getStart();
    }

    public final int getPaddingTop() {
        return this.padding.getTop();
    }

    public final int getPaddingRight() {
        return this.padding.getEnd();
    }

    public final int getPaddingBottom() {
        return this.padding.getBottom();
    }
}
