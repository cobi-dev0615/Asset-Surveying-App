package com.devexpress.navigation.tabs.models;

/* loaded from: classes2.dex */
public class Padding {
    private float mBottom;
    private float mLeft;
    private OnPaddingChangeListener mListener;
    private float mRight;
    private float mTop;

    public interface OnPaddingChangeListener {
        void onPaddingChanged();
    }

    public Padding() {
        this.mLeft = 0.0f;
        this.mRight = 0.0f;
        this.mTop = 0.0f;
        this.mBottom = 0.0f;
    }

    public Padding(Padding padding) {
        this.mLeft = 0.0f;
        this.mRight = 0.0f;
        this.mTop = 0.0f;
        this.mBottom = 0.0f;
        this.mLeft = padding.mLeft;
        this.mRight = padding.mRight;
        this.mTop = padding.mTop;
        this.mBottom = padding.mBottom;
    }

    public void setLeft(float f) {
        if (this.mLeft != f) {
            this.mLeft = f;
            raiseOnPaddingChanged();
        }
    }

    public float getLeft() {
        return this.mLeft;
    }

    public void setRight(float f) {
        if (this.mRight != f) {
            this.mRight = f;
            raiseOnPaddingChanged();
        }
    }

    public float getRight() {
        return this.mRight;
    }

    public void setTop(float f) {
        if (this.mTop != f) {
            this.mTop = f;
            raiseOnPaddingChanged();
        }
    }

    public float getTop() {
        return this.mTop;
    }

    public void setBottom(float f) {
        if (this.mBottom != f) {
            this.mBottom = f;
            raiseOnPaddingChanged();
        }
    }

    public float getBottom() {
        return this.mBottom;
    }

    public void setPadding(float f) {
        this.mLeft = f;
        this.mRight = f;
        this.mTop = f;
        this.mBottom = f;
        raiseOnPaddingChanged();
    }

    public void setHorizontal(float f) {
        this.mLeft = f;
        this.mRight = f;
        raiseOnPaddingChanged();
    }

    public void setVertical(float f) {
        this.mTop = f;
        this.mBottom = f;
        raiseOnPaddingChanged();
    }

    public void setPaddingChangeListener(OnPaddingChangeListener onPaddingChangeListener) {
        this.mListener = onPaddingChangeListener;
    }

    private void raiseOnPaddingChanged() {
        OnPaddingChangeListener onPaddingChangeListener = this.mListener;
        if (onPaddingChangeListener != null) {
            onPaddingChangeListener.onPaddingChanged();
        }
    }
}
