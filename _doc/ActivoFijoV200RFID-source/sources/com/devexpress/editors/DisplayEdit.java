package com.devexpress.editors;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.devexpress.editors.utils.UtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayEdit.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020\u000bJ \u0010q\u001a\u00020o2\u0006\u0010p\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020\u00072\u0006\u0010s\u001a\u00020/H\u0002J\u0018\u0010t\u001a\u00020o2\u0006\u0010p\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020\u0007H\u0002J\u0018\u0010u\u001a\u00020o2\u0006\u0010p\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020\u0007H\u0002J\u000e\u0010v\u001a\u00020o2\u0006\u0010p\u001a\u00020\u000bJ\b\u0010w\u001a\u00020RH\u0002J\b\u0010x\u001a\u00020oH\u0002J\b\u0010y\u001a\u00020oH\u0002J\b\u0010z\u001a\u00020oH\u0002J\b\u0010{\u001a\u00020oH\u0002J\u0018\u0010|\u001a\u00020\u00072\u0006\u0010s\u001a\u00020/2\u0006\u0010}\u001a\u00020=H\u0002J\u0019\u0010~\u001a\u00020o2\u0006\u0010\u007f\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u0007H\u0014J\u0012\u0010\u0081\u0001\u001a\u00020o2\u0007\u0010\u0082\u0001\u001a\u00020\u0007H\u0016J\u000f\u0010\u0083\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00020\u000bJ\u0019\u0010\u0084\u0001\u001a\u00020o2\u0006\u0010r\u001a\u00020\u00072\u0006\u0010s\u001a\u00020/H\u0002J\u0011\u0010\u0085\u0001\u001a\u00020o2\u0006\u0010r\u001a\u00020\u0007H\u0002J\u0011\u0010\u0086\u0001\u001a\u00020o2\u0006\u0010r\u001a\u00020\u0007H\u0002J\u000f\u0010\u0087\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00020\u000bJ\u001b\u0010\u0088\u0001\u001a\u00020o2\b\u0010\u0089\u0001\u001a\u00030\u008a\u00012\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u001b\u0010\u008b\u0001\u001a\u00020o2\b\u0010\u0089\u0001\u001a\u00030\u008a\u00012\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u001b\u0010\u008c\u0001\u001a\u00020o2\b\u0010\u0089\u0001\u001a\u00030\u008a\u00012\u0006\u0010\r\u001a\u00020\u0007H\u0002J\t\u0010\u008d\u0001\u001a\u00020oH\u0002J\t\u0010\u008e\u0001\u001a\u00020oH\u0002J\t\u0010\u008f\u0001\u001a\u00020oH\u0002J\u001c\u0010\u0090\u0001\u001a\u00020o2\u0007\u0010\u0091\u0001\u001a\u00020R2\b\u0010Z\u001a\u0004\u0018\u00010KH\u0002J\t\u0010\u0092\u0001\u001a\u00020oH\u0002J\t\u0010\u0093\u0001\u001a\u00020oH\u0002J\u0019\u0010\u0094\u0001\u001a\u00020o2\u0006\u0010s\u001a\u00020/2\u0006\u0010}\u001a\u00020=H\u0002J\u0019\u0010\u0095\u0001\u001a\u00020o2\u0006\u0010s\u001a\u00020/2\u0006\u0010}\u001a\u00020=H\u0002J\t\u0010\u0096\u0001\u001a\u00020oH\u0002J\u0019\u0010\u0097\u0001\u001a\u00020o2\u0006\u0010s\u001a\u00020/2\u0006\u0010}\u001a\u00020=H\u0002J\t\u0010\u0098\u0001\u001a\u00020oH\u0002J\t\u0010\u0099\u0001\u001a\u00020oH\u0002J\t\u0010\u009a\u0001\u001a\u00020oH\u0002J\t\u0010\u009b\u0001\u001a\u00020oH\u0002J\t\u0010\u009c\u0001\u001a\u00020=H\u0002J\t\u0010\u009d\u0001\u001a\u00020=H\u0002R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u001c@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\"@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R(\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\r\u001a\u0004\u0018\u00010(8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u00100\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001018F¢\u0006\u0006\u001a\u0004\b2\u00103R$\u00104\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R$\u00107\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0016\"\u0004\b9\u0010\u0018R$\u0010:\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010\u0018R$\u0010>\u001a\u00020=2\u0006\u0010\r\u001a\u00020=8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010B\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bC\u0010\u0016\"\u0004\bD\u0010\u0018R$\u0010E\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u0010\u0016\"\u0004\bG\u0010\u0018R$\u0010H\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010\u0016\"\u0004\bJ\u0010\u0018R(\u0010L\u001a\u0004\u0018\u00010K2\b\u0010\r\u001a\u0004\u0018\u00010K@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010T\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001018F¢\u0006\u0006\u001a\u0004\bU\u00103R(\u0010V\u001a\u0004\u0018\u00010K2\b\u0010\r\u001a\u0004\u0018\u00010K@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010N\"\u0004\bX\u0010PR\u0010\u0010Y\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010Z\u001a\u0004\u0018\u00010K2\b\u0010\r\u001a\u0004\u0018\u00010K8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u0010N\"\u0004\b\\\u0010PR(\u0010]\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010\u0011\"\u0004\b_\u0010\u0013R$\u0010`\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010\u0016\"\u0004\bb\u0010\u0018R$\u0010c\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010\u001f\"\u0004\be\u0010!R\u000e\u0010f\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010g\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bh\u0010\u0016R\u0014\u0010i\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bj\u0010\u0016R$\u0010k\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\"8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bl\u0010%\"\u0004\bm\u0010'¨\u0006\u009e\u0001"}, d2 = {"Lcom/devexpress/editors/DisplayEdit;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_endDrawables", "", "Landroid/graphics/drawable/Drawable;", "_startDrawables", "value", "Landroid/content/res/ColorStateList;", "affixColors", "getAffixColors", "()Landroid/content/res/ColorStateList;", "setAffixColors", "(Landroid/content/res/ColorStateList;)V", "affixGravity", "getAffixGravity", "()I", "setAffixGravity", "(I)V", "affixIndent", "getAffixIndent", "setAffixIndent", "", "affixTextSize", "getAffixTextSize", "()F", "setAffixTextSize", "(F)V", "Landroid/graphics/Typeface;", "affixTypeface", "getAffixTypeface", "()Landroid/graphics/Typeface;", "setAffixTypeface", "(Landroid/graphics/Typeface;)V", "Landroid/text/TextUtils$TruncateAt;", "ellipsize", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "setEllipsize", "(Landroid/text/TextUtils$TruncateAt;)V", "endContainer", "Landroid/widget/LinearLayout;", "endDrawables", "", "getEndDrawables", "()Ljava/util/List;", "iconGravity", "getIconGravity", "setIconGravity", "iconIndent", "getIconIndent", "setIconIndent", "iconSpacing", "getIconSpacing", "setIconSpacing", "", "isSingleLine", "()Z", "setSingleLine", "(Z)V", "maxLines", "getMaxLines", "setMaxLines", "minLines", "getMinLines", "setMinLines", "paintFlags", "getPaintFlags", "setPaintFlags", "", "prefixText", "getPrefixText", "()Ljava/lang/CharSequence;", "setPrefixText", "(Ljava/lang/CharSequence;)V", "prefixTextView", "Landroid/widget/TextView;", "startContainer", "startDrawables", "getStartDrawables", "suffixText", "getSuffixText", "setSuffixText", "suffixTextView", "text", "getText", "setText", "textColors", "getTextColors", "setTextColors", "textGravity", "getTextGravity", "setTextGravity", "textSize", "getTextSize", "setTextSize", "textView", "textViewPaddingEnd", "getTextViewPaddingEnd", "textViewPaddingStart", "getTextViewPaddingStart", "typeface", "getTypeface", "setTypeface", "addEndDrawable", "", "drawable", "addImageToContainer", "index", "container", "addImageToEndContainer", "addImageToStartContainer", "addStartDrawable", "createAffixTextView", "createEndContainer", "createPrefixTextView", "createStartContainer", "createSuffixTextView", "getLastIconIndexInContainer", "hasAffix", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRtlPropertiesChanged", "layoutDirection", "removeEndDrawable", "removeImageFromContainer", "removeImageFromEndContainer", "removeImageFromStartContainer", "removeStartDrawable", "setLayoutGravity", "view", "Landroid/view/View;", "setMarginEnd", "setMarginStart", "updateAffixesColors", "updateAffixesGravity", "updateAffixesIndents", "updateAffixesText", "affixView", "updateAffixesTextSize", "updateAffixesTypeface", "updateIconIndentInContainer", "updateIconSpacingInContainer", "updateIconsGravity", "updateIconsGravityInContainer", "updateIconsIndents", "updateIconsSpacings", "updatePrefixTextViewText", "updateSuffixTextViewText", "updateTextViewMinHeightBasedOnContainers", "updateTextViewPaddingBasedOnContainers", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DisplayEdit extends FrameLayout {
    private List<Drawable> _endDrawables;
    private List<Drawable> _startDrawables;
    private ColorStateList affixColors;
    private int affixGravity;
    private int affixIndent;
    private float affixTextSize;
    private Typeface affixTypeface;
    private LinearLayout endContainer;
    private int iconGravity;
    private int iconIndent;
    private int iconSpacing;
    private CharSequence prefixText;
    private TextView prefixTextView;
    private LinearLayout startContainer;
    private CharSequence suffixText;
    private TextView suffixTextView;
    private final TextView textView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DisplayEdit(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DisplayEdit(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        this.textView = appCompatTextView;
        Typeface DEFAULT = Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
        this.affixTypeface = DEFAULT;
        this.affixGravity = 8388627;
        this.iconGravity = 8388627;
        this.iconIndent = context.getResources().getDimensionPixelSize(R.dimen.editor_icon_indent);
        this.iconSpacing = context.getResources().getDimensionPixelSize(R.dimen.editor_icon_spacing);
        this.affixIndent = context.getResources().getDimensionPixelSize(R.dimen.editor_affix_indent);
        this.affixColors = ColorStateList.valueOf(-7829368);
        appCompatTextView.setGravity(8388627);
        addView(appCompatTextView, new FrameLayout.LayoutParams(-1, -1));
    }

    public /* synthetic */ DisplayEdit(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final int getTextViewPaddingStart() {
        LinearLayout linearLayout = this.startContainer;
        if (linearLayout == null) {
            return 0;
        }
        return linearLayout.getMeasuredWidth();
    }

    private final int getTextViewPaddingEnd() {
        LinearLayout linearLayout = this.endContainer;
        if (linearLayout == null) {
            return 0;
        }
        return linearLayout.getMeasuredWidth();
    }

    public final CharSequence getText() {
        return this.textView.getText();
    }

    public final void setText(CharSequence charSequence) {
        if (Intrinsics.areEqual(this.textView.getText(), charSequence)) {
            return;
        }
        this.textView.setText(charSequence);
    }

    public final CharSequence getPrefixText() {
        return this.prefixText;
    }

    public final void setPrefixText(CharSequence charSequence) {
        if (Intrinsics.areEqual(this.prefixText, charSequence)) {
            return;
        }
        this.prefixText = charSequence;
        updatePrefixTextViewText();
    }

    public final CharSequence getSuffixText() {
        return this.suffixText;
    }

    public final void setSuffixText(CharSequence charSequence) {
        if (Intrinsics.areEqual(this.suffixText, charSequence)) {
            return;
        }
        this.suffixText = charSequence;
        updateSuffixTextViewText();
    }

    public final List<Drawable> getStartDrawables() {
        return this._startDrawables;
    }

    public final List<Drawable> getEndDrawables() {
        return this._endDrawables;
    }

    public final Typeface getTypeface() {
        Typeface typeface = this.textView.getTypeface();
        Intrinsics.checkNotNullExpressionValue(typeface, "getTypeface(...)");
        return typeface;
    }

    public final void setTypeface(Typeface value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.textView.setTypeface(value);
    }

    public final Typeface getAffixTypeface() {
        return this.affixTypeface;
    }

    public final void setAffixTypeface(Typeface value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.affixTypeface, value)) {
            return;
        }
        this.affixTypeface = value;
        updateAffixesTypeface();
    }

    public final float getTextSize() {
        return this.textView.getTextSize();
    }

    public final void setTextSize(float f) {
        this.textView.setTextSize(0, f);
    }

    public final float getAffixTextSize() {
        return this.affixTextSize;
    }

    public final void setAffixTextSize(float f) {
        if (this.affixTextSize == f) {
            return;
        }
        this.affixTextSize = f;
        updateAffixesTextSize();
    }

    public final int getTextGravity() {
        return this.textView.getGravity();
    }

    public final void setTextGravity(int i) {
        this.textView.setGravity(i);
    }

    public final int getAffixGravity() {
        return this.affixGravity;
    }

    public final void setAffixGravity(int i) {
        if (this.affixGravity == i) {
            return;
        }
        this.affixGravity = i;
        updateAffixesGravity();
    }

    public final int getIconGravity() {
        return this.iconGravity;
    }

    public final void setIconGravity(int i) {
        if (this.iconGravity == i) {
            return;
        }
        this.iconGravity = i;
        updateIconsGravity();
    }

    public final int getPaintFlags() {
        return this.textView.getPaintFlags();
    }

    public final void setPaintFlags(int i) {
        this.textView.setPaintFlags(i);
    }

    public final int getIconIndent() {
        return this.iconIndent;
    }

    public final void setIconIndent(int i) {
        if (this.iconIndent == i) {
            return;
        }
        this.iconIndent = i;
        updateIconsIndents();
    }

    public final int getIconSpacing() {
        return this.iconSpacing;
    }

    public final void setIconSpacing(int i) {
        if (this.iconSpacing == i) {
            return;
        }
        this.iconSpacing = i;
        updateIconsSpacings();
    }

    public final int getAffixIndent() {
        return this.affixIndent;
    }

    public final void setAffixIndent(int i) {
        if (this.affixIndent == i) {
            return;
        }
        this.affixIndent = i;
        updateAffixesIndents();
    }

    public final ColorStateList getTextColors() {
        return this.textView.getTextColors();
    }

    public final void setTextColors(ColorStateList colorStateList) {
        this.textView.setTextColor(colorStateList);
    }

    public final ColorStateList getAffixColors() {
        return this.affixColors;
    }

    public final void setAffixColors(ColorStateList colorStateList) {
        if (Intrinsics.areEqual(this.affixColors, colorStateList)) {
            return;
        }
        this.affixColors = colorStateList;
        updateAffixesColors();
    }

    public final boolean isSingleLine() {
        return UtilsKt.has(this.textView.getInputType(), 131072);
    }

    public final void setSingleLine(boolean z) {
        this.textView.setSingleLine(z);
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.textView.getEllipsize();
    }

    public final void setEllipsize(TextUtils.TruncateAt truncateAt) {
        this.textView.setEllipsize(truncateAt);
    }

    public final int getMinLines() {
        return this.textView.getMinLines();
    }

    public final void setMinLines(int i) {
        this.textView.setMinLines(i);
    }

    public final int getMaxLines() {
        return this.textView.getMaxLines();
    }

    public final void setMaxLines(int i) {
        this.textView.setMaxLines(i);
    }

    public final void addStartDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (this._startDrawables == null) {
            this._startDrawables = new ArrayList();
        }
        List<Drawable> list = this._startDrawables;
        Intrinsics.checkNotNull(list);
        list.add(drawable);
        addImageToStartContainer(drawable, CollectionsKt.getLastIndex(list));
    }

    public final void removeStartDrawable(Drawable drawable) {
        int indexOf;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        List<Drawable> list = this._startDrawables;
        if (list != null && (indexOf = list.indexOf(drawable)) >= 0) {
            list.remove(indexOf);
            removeImageFromStartContainer(indexOf);
        }
    }

    public final void addEndDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (this._endDrawables == null) {
            this._endDrawables = new ArrayList();
        }
        List<Drawable> list = this._endDrawables;
        Intrinsics.checkNotNull(list);
        list.add(drawable);
        addImageToEndContainer(drawable, CollectionsKt.getLastIndex(list));
    }

    public final void removeEndDrawable(Drawable drawable) {
        int indexOf;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        List<Drawable> list = this._startDrawables;
        if (list != null && (indexOf = list.indexOf(drawable)) >= 0) {
            list.remove(indexOf);
            removeImageFromEndContainer(indexOf);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        boolean updateTextViewMinHeightBasedOnContainers = updateTextViewMinHeightBasedOnContainers();
        boolean updateTextViewPaddingBasedOnContainers = updateTextViewPaddingBasedOnContainers();
        if (updateTextViewMinHeightBasedOnContainers || updateTextViewPaddingBasedOnContainers) {
            this.textView.post(new Runnable() { // from class: com.devexpress.editors.DisplayEdit$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DisplayEdit.onMeasure$lambda$0(DisplayEdit.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMeasure$lambda$0(DisplayEdit this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.textView.requestLayout();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        super.onRtlPropertiesChanged(layoutDirection);
        if (layoutDirection == 1) {
            LinearLayout linearLayout = this.startContainer;
            if (linearLayout != null) {
                linearLayout.setLayoutDirection(1);
            }
            LinearLayout linearLayout2 = this.endContainer;
            if (linearLayout2 == null) {
                return;
            }
            linearLayout2.setLayoutDirection(0);
            return;
        }
        LinearLayout linearLayout3 = this.startContainer;
        if (linearLayout3 != null) {
            linearLayout3.setLayoutDirection(0);
        }
        LinearLayout linearLayout4 = this.endContainer;
        if (linearLayout4 == null) {
            return;
        }
        linearLayout4.setLayoutDirection(1);
    }

    private final boolean updateTextViewMinHeightBasedOnContainers() {
        LinearLayout linearLayout = this.endContainer;
        int measuredHeight = linearLayout != null ? linearLayout.getMeasuredHeight() : 0;
        LinearLayout linearLayout2 = this.startContainer;
        int max = Math.max(measuredHeight, linearLayout2 != null ? linearLayout2.getMeasuredHeight() : 0);
        if (this.textView.getMeasuredHeight() >= max) {
            return false;
        }
        this.textView.setMinimumHeight(max);
        return true;
    }

    private final boolean updateTextViewPaddingBasedOnContainers() {
        int textViewPaddingStart = getTextViewPaddingStart();
        boolean z = textViewPaddingStart != this.textView.getPaddingStart();
        int textViewPaddingEnd = getTextViewPaddingEnd();
        boolean z2 = textViewPaddingEnd != this.textView.getPaddingEnd();
        if (!z && !z2) {
            return false;
        }
        TextView textView = this.textView;
        textView.setPaddingRelative(textViewPaddingStart, textView.getPaddingTop(), textViewPaddingEnd, this.textView.getPaddingBottom());
        return true;
    }

    private final void updatePrefixTextViewText() {
        if (this.prefixTextView == null) {
            createPrefixTextView();
        }
        TextView textView = this.prefixTextView;
        Intrinsics.checkNotNull(textView);
        updateAffixesText(textView, this.prefixText);
    }

    private final void updateSuffixTextViewText() {
        if (this.suffixTextView == null) {
            createSuffixTextView();
        }
        TextView textView = this.suffixTextView;
        Intrinsics.checkNotNull(textView);
        updateAffixesText(textView, this.suffixText);
    }

    private final void updateAffixesText(TextView affixView, CharSequence text) {
        affixView.setVisibility((text == null || text.length() == 0) ? 8 : 0);
        affixView.setText(text);
    }

    private final void updateAffixesIndents() {
        boolean z;
        TextView textView = this.prefixTextView;
        boolean z2 = true;
        if (textView != null) {
            setMarginEnd(textView, this.affixIndent);
            z = true;
        } else {
            z = false;
        }
        TextView textView2 = this.suffixTextView;
        if (textView2 != null) {
            setMarginStart(textView2, this.affixIndent);
        } else {
            z2 = z;
        }
        if (z2) {
            requestLayout();
        }
    }

    private final void updateAffixesColors() {
        TextView textView = this.prefixTextView;
        if (textView != null) {
            textView.setTextColor(this.affixColors);
        }
        TextView textView2 = this.suffixTextView;
        if (textView2 != null) {
            textView2.setTextColor(this.affixColors);
        }
    }

    private final void updateAffixesTypeface() {
        TextView textView = this.prefixTextView;
        if (textView != null) {
            textView.setTypeface(this.affixTypeface);
        }
        TextView textView2 = this.suffixTextView;
        if (textView2 == null) {
            return;
        }
        textView2.setTypeface(this.affixTypeface);
    }

    private final void updateAffixesTextSize() {
        TextView textView = this.prefixTextView;
        if (textView != null) {
            textView.setTextSize(0, this.affixTextSize);
        }
        TextView textView2 = this.suffixTextView;
        if (textView2 != null) {
            textView2.setTextSize(0, this.affixTextSize);
        }
    }

    private final void updateAffixesGravity() {
        TextView textView = this.prefixTextView;
        if (textView != null) {
            setLayoutGravity(textView, this.affixGravity);
        }
        TextView textView2 = this.suffixTextView;
        if (textView2 != null) {
            setLayoutGravity(textView2, this.affixGravity);
        }
    }

    private final void updateIconsIndents() {
        boolean z;
        LinearLayout linearLayout = this.startContainer;
        boolean z2 = true;
        if (linearLayout != null) {
            updateIconIndentInContainer(linearLayout, this.prefixTextView != null);
            z = true;
        } else {
            z = false;
        }
        LinearLayout linearLayout2 = this.endContainer;
        if (linearLayout2 != null) {
            updateIconIndentInContainer(linearLayout2, this.suffixTextView != null);
        } else {
            z2 = z;
        }
        if (z2) {
            requestLayout();
        }
    }

    private final void updateIconsSpacings() {
        boolean z;
        LinearLayout linearLayout = this.startContainer;
        boolean z2 = true;
        if (linearLayout != null) {
            updateIconSpacingInContainer(linearLayout, this.prefixTextView != null);
            z = true;
        } else {
            z = false;
        }
        LinearLayout linearLayout2 = this.endContainer;
        if (linearLayout2 != null) {
            updateIconSpacingInContainer(linearLayout2, this.suffixTextView != null);
        } else {
            z2 = z;
        }
        if (z2) {
            requestLayout();
        }
    }

    private final void updateIconsGravity() {
        LinearLayout linearLayout = this.startContainer;
        if (linearLayout != null) {
            updateIconsGravityInContainer(linearLayout, this.prefixTextView != null);
        }
        LinearLayout linearLayout2 = this.endContainer;
        if (linearLayout2 != null) {
            updateIconsGravityInContainer(linearLayout2, this.suffixTextView != null);
        }
    }

    private final void updateIconSpacingInContainer(LinearLayout container, boolean hasAffix) {
        int lastIconIndexInContainer = getLastIconIndexInContainer(container, hasAffix);
        if (lastIconIndexInContainer < 1) {
            return;
        }
        for (int i = 0; i < lastIconIndexInContainer; i++) {
            View childAt = container.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
            setMarginEnd(childAt, this.iconSpacing);
        }
    }

    private final void updateIconIndentInContainer(LinearLayout container, boolean hasAffix) {
        int lastIconIndexInContainer = getLastIconIndexInContainer(container, hasAffix);
        if (lastIconIndexInContainer < 0) {
            return;
        }
        View childAt = container.getChildAt(lastIconIndexInContainer);
        Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
        setMarginEnd(childAt, this.iconSpacing);
    }

    private final void updateIconsGravityInContainer(LinearLayout container, boolean hasAffix) {
        int lastIconIndexInContainer = getLastIconIndexInContainer(container, hasAffix);
        if (lastIconIndexInContainer < 0 || lastIconIndexInContainer < 0) {
            return;
        }
        int i = 0;
        while (true) {
            View childAt = container.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
            setLayoutGravity(childAt, this.iconGravity);
            if (i == lastIconIndexInContainer) {
                return;
            } else {
                i++;
            }
        }
    }

    private final void createPrefixTextView() {
        if (this.startContainer == null) {
            createStartContainer();
        }
        this.prefixTextView = createAffixTextView();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = this.affixGravity;
        layoutParams.setMarginEnd(this.affixIndent);
        LinearLayout linearLayout = this.startContainer;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.addView(this.prefixTextView, layoutParams);
    }

    private final void createSuffixTextView() {
        if (this.endContainer == null) {
            createEndContainer();
        }
        this.suffixTextView = createAffixTextView();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = this.affixGravity;
        layoutParams.setMarginStart(this.affixIndent);
        LinearLayout linearLayout = this.endContainer;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.addView(this.suffixTextView, layoutParams);
    }

    private final TextView createAffixTextView() {
        TextView textView = new TextView(getContext());
        textView.setTypeface(this.affixTypeface);
        textView.setTextColor(this.affixColors);
        textView.setTextSize(0, this.affixTextSize);
        return textView;
    }

    private final void addImageToStartContainer(Drawable drawable, int index) {
        if (this.startContainer == null) {
            createStartContainer();
        }
        LinearLayout linearLayout = this.startContainer;
        Intrinsics.checkNotNull(linearLayout);
        addImageToContainer(drawable, index, linearLayout);
    }

    private final void addImageToEndContainer(Drawable drawable, int index) {
        if (this.endContainer == null) {
            createEndContainer();
        }
        LinearLayout linearLayout = this.endContainer;
        Intrinsics.checkNotNull(linearLayout);
        addImageToContainer(drawable, index, linearLayout);
    }

    private final void addImageToContainer(Drawable drawable, int index, LinearLayout container) {
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        appCompatImageView.setImageDrawable(drawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginEnd(this.iconIndent);
        layoutParams.gravity = this.iconGravity;
        if (index > 0) {
            ViewGroup.LayoutParams layoutParams2 = container.getChildAt(index - 1).getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams2).setMarginEnd(this.iconSpacing);
        }
        container.addView(appCompatImageView, index, layoutParams);
    }

    private final void removeImageFromStartContainer(int index) {
        LinearLayout linearLayout = this.startContainer;
        if (linearLayout == null) {
            return;
        }
        removeImageFromContainer(index, linearLayout);
    }

    private final void removeImageFromEndContainer(int index) {
        LinearLayout linearLayout = this.endContainer;
        if (linearLayout == null) {
            return;
        }
        removeImageFromContainer(index, linearLayout);
    }

    private final void removeImageFromContainer(int index, LinearLayout container) {
        container.removeViewAt(index);
        if (index > 0) {
            ViewGroup.LayoutParams layoutParams = container.getChildAt(index - 1).getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams).setMarginEnd(this.iconIndent);
        }
    }

    private final void createStartContainer() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.startContainer = linearLayout;
        addView(linearLayout, new FrameLayout.LayoutParams(-2, -1, 8388627));
    }

    private final void createEndContainer() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.endContainer = linearLayout;
        addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 8388629));
    }

    private final int getLastIconIndexInContainer(LinearLayout container, boolean hasAffix) {
        int childCount = container.getChildCount();
        if (hasAffix) {
            if (childCount == 1) {
                return -1;
            }
            return childCount - 2;
        }
        if (childCount == 0) {
            return -1;
        }
        return childCount - 1;
    }

    private final void setMarginEnd(View view, int value) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMarginEnd(value);
    }

    private final void setMarginStart(View view, int value) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMarginStart(value);
    }

    private final void setLayoutGravity(View view, int value) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).gravity = value;
    }
}
