package com.devexpress.navigation.tabs.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.devexpress.navigation.tabs.utils.SizeConverter;

/* loaded from: classes2.dex */
public class TextViewContainer extends RelativeLayout {
    private float mDefaultTextSize;
    private AppCompatTextView mTextView;

    public TextViewContainer(Context context) {
        super(context);
        createTextView(context);
    }

    public void setText(CharSequence charSequence) {
        this.mTextView.setText(charSequence);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    }

    public CharSequence getText() {
        return this.mTextView.getText();
    }

    public void setTextColor(int i) {
        this.mTextView.setTextColor(i);
    }

    public ColorStateList getTextColors() {
        return this.mTextView.getTextColors();
    }

    public void setTypeface(Typeface typeface) {
        this.mTextView.setTypeface(typeface);
    }

    public void setTextSize(float f) {
        if (f > 0.0f) {
            this.mTextView.setTextSize(1, f);
            return;
        }
        float textSize = this.mTextView.getTextSize();
        float f2 = this.mDefaultTextSize;
        if (textSize != f2) {
            this.mTextView.setTextSize(0, f2);
        }
    }

    public Typeface getTypeface() {
        return this.mTextView.getTypeface();
    }

    private void createTextView(Context context) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        this.mTextView = appCompatTextView;
        this.mDefaultTextSize = appCompatTextView.getTextSize();
        this.mTextView.setId(AppCompatTextView.generateViewId());
        this.mTextView.setMaxLines(1);
        this.mTextView.setTextAlignment(4);
        this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.mTextView, new RelativeLayout.LayoutParams(-2, -1));
    }

    public void setBounds(int i, int i2) {
        if (SizeConverter.convertSpToPx(getContext(), this.mTextView.getTextSize()) <= (i - getPaddingRight()) - getPaddingLeft()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(i, -1));
        } else if (layoutParams.width != i) {
            layoutParams.width = i;
            setLayoutParams(layoutParams);
        }
        setLeft(i2);
    }
}
