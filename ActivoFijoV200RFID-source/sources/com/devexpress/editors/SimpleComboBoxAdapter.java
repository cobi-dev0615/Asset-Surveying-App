package com.devexpress.editors;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleListAdapter.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010)\u001a\u00020*H\u0004J\u0015\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0002¢\u0006\u0002\u0010.J\u0015\u0010/\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0016¢\u0006\u0002\u0010.J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0007H\u0016J\u0012\u00103\u001a\u0004\u0018\u00010-2\u0006\u00102\u001a\u00020\u0007H&J\"\u00104\u001a\u0002052\u0006\u00102\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u0001052\u0006\u00107\u001a\u000208H\u0016J\u0006\u00109\u001a\u00020:J.\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020\r2\u0006\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u00020\rJ&\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007J\u0016\u0010\u0011\u001a\u00020:2\u0006\u0010<\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR*\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\r@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010&\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\n\"\u0004\b(\u0010\f¨\u0006B"}, d2 = {"Lcom/devexpress/editors/SimpleComboBoxAdapter;", "Landroid/widget/BaseAdapter;", "Lcom/devexpress/editors/ComboBoxAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "horizontalTextAlignment", "getHorizontalTextAlignment", "()I", "setHorizontalTextAlignment", "(I)V", "", "itemTextSize", "getItemTextSize", "()Ljava/lang/Float;", "setItemTextSize", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "itemTextTint", "Landroid/content/res/ColorStateList;", "getItemTextTint", "()Landroid/content/res/ColorStateList;", "setItemTextTint", "(Landroid/content/res/ColorStateList;)V", "Landroid/graphics/Typeface;", "itemTypeface", "getItemTypeface", "()Landroid/graphics/Typeface;", "setItemTypeface", "(Landroid/graphics/Typeface;)V", "layoutInflater", "Landroid/view/LayoutInflater;", "paddingBottom", "paddingEnd", "paddingStart", "paddingTop", "selectedItemBackgroundColor", "getSelectedItemBackgroundColor", "setSelectedItemBackgroundColor", "createItemBackground", "Landroid/graphics/drawable/Drawable;", "generateAutofillOptions", "", "", "()[Ljava/lang/CharSequence;", "getAutofillOptions", "getItemId", "", "position", "getText", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "resetItemPadding", "", "setItemPaddingRelative", "unit", "start", "top", "end", "bottom", "size", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SimpleComboBoxAdapter extends BaseAdapter implements ComboBoxAdapter {
    private final Context context;
    private int horizontalTextAlignment;
    private Float itemTextSize;
    private ColorStateList itemTextTint;
    private Typeface itemTypeface;
    private final LayoutInflater layoutInflater;
    private int paddingBottom;
    private int paddingEnd;
    private int paddingStart;
    private int paddingTop;
    private int selectedItemBackgroundColor;

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    public abstract CharSequence getText(int position);

    public SimpleComboBoxAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(...)");
        this.layoutInflater = from;
        this.paddingStart = -1;
        this.paddingTop = -1;
        this.paddingEnd = -1;
        this.paddingBottom = -1;
        ColorStateList valueOf = ColorStateList.valueOf(-16777216);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        this.itemTextTint = valueOf;
        this.horizontalTextAlignment = 8388627;
        setItemTypeface(null);
        setItemTextSize(null);
        resetItemPadding();
    }

    public final int getSelectedItemBackgroundColor() {
        return this.selectedItemBackgroundColor;
    }

    public final void setSelectedItemBackgroundColor(int i) {
        if (this.selectedItemBackgroundColor == i) {
            return;
        }
        this.selectedItemBackgroundColor = i;
    }

    public final ColorStateList getItemTextTint() {
        return this.itemTextTint;
    }

    public final void setItemTextTint(ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "<set-?>");
        this.itemTextTint = colorStateList;
    }

    public final int getHorizontalTextAlignment() {
        return this.horizontalTextAlignment;
    }

    public final void setHorizontalTextAlignment(int i) {
        this.horizontalTextAlignment = i | 16;
    }

    public final Typeface getItemTypeface() {
        return this.itemTypeface;
    }

    public final void setItemTypeface(Typeface typeface) {
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        if (Intrinsics.areEqual(this.itemTypeface, typeface)) {
            return;
        }
        this.itemTypeface = typeface;
    }

    public final Float getItemTextSize() {
        return this.itemTextSize;
    }

    public final void setItemTextSize(Float f) {
        float floatValue = f != null ? f.floatValue() : this.context.getResources().getDimension(R.dimen.editor_dropDownItem_fontSize);
        if (Intrinsics.areEqual(this.itemTextSize, floatValue)) {
            return;
        }
        this.itemTextSize = Float.valueOf(floatValue);
    }

    private final CharSequence[] generateAutofillOptions() {
        if (isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int count = getCount();
        for (int i = 0; i < count; i++) {
            arrayList.add("id" + i);
        }
        return (CharSequence[]) arrayList.toArray(new CharSequence[0]);
    }

    public final void setItemTextSize(int unit, float size) {
        setItemTextSize(Float.valueOf(TypedValue.applyDimension(unit, size, this.context.getResources().getDisplayMetrics())));
    }

    public final void setItemPaddingRelative(int start, int top, int end, int bottom) {
        this.paddingStart = start;
        this.paddingTop = top;
        this.paddingEnd = end;
        this.paddingBottom = bottom;
    }

    public final void setItemPaddingRelative(int unit, float start, float top, float end, float bottom) {
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        this.paddingStart = (int) TypedValue.applyDimension(unit, start, displayMetrics);
        this.paddingTop = (int) TypedValue.applyDimension(unit, top, displayMetrics);
        this.paddingEnd = (int) TypedValue.applyDimension(unit, end, displayMetrics);
        this.paddingBottom = (int) TypedValue.applyDimension(unit, bottom, displayMetrics);
    }

    public final void resetItemPadding() {
        this.paddingStart = this.context.getResources().getDimensionPixelSize(R.dimen.editor_dropDownItem_paddingStart);
        this.paddingTop = this.context.getResources().getDimensionPixelSize(R.dimen.editor_dropDownItem_paddingVertical);
        this.paddingEnd = this.context.getResources().getDimensionPixelSize(R.dimen.editor_dropDownItem_paddingEnd);
        this.paddingBottom = this.context.getResources().getDimensionPixelSize(R.dimen.editor_dropDownItem_paddingVertical);
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (convertView == null) {
            View inflate = this.layoutInflater.inflate(R.layout.drop_down_item, parent, false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) inflate;
            textView.setTextColor(this.itemTextTint);
            textView.setBackground(createItemBackground());
            textView.setTypeface(this.itemTypeface);
            Float f = this.itemTextSize;
            Intrinsics.checkNotNull(f);
            textView.setTextSize(0, f.floatValue());
            textView.setPaddingRelative(this.paddingStart, this.paddingTop, this.paddingEnd, this.paddingBottom);
            convertView = textView;
        }
        TextView textView2 = convertView instanceof TextView ? (TextView) convertView : null;
        if (textView2 != null) {
            textView2.setText(getText(position));
            textView2.setGravity(this.horizontalTextAlignment);
        }
        return convertView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public CharSequence[] getAutofillOptions() {
        return generateAutofillOptions();
    }

    protected final Drawable createItemBackground() {
        if (this.selectedItemBackgroundColor == 0) {
            return new GradientDrawable();
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = new GradientDrawable();
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(this.selectedItemBackgroundColor);
        stateListDrawable.addState(Constants.ACTIVATED_STATE, gradientDrawable2);
        stateListDrawable.addState(Constants.DEFAULT_STATE, gradientDrawable);
        return stateListDrawable;
    }
}
