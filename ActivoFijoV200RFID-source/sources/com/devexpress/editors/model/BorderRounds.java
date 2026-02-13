package com.devexpress.editors.model;

/* loaded from: classes2.dex */
public class BorderRounds {
    public float bottomLeft;
    public float bottomRight;
    public float topLeft;
    public float topRight;

    public BorderRounds() {
    }

    public BorderRounds(float f, float f2, float f3, float f4) {
        set(f, f2, f3, f4);
    }

    public BorderRounds(int i) {
        float f = i;
        this.topLeft = f;
        this.topRight = f;
        this.bottomLeft = f;
        this.bottomRight = f;
    }

    public BorderRounds set(float f, float f2, float f3, float f4) {
        this.topLeft = f;
        this.topRight = f2;
        this.bottomLeft = f3;
        this.bottomRight = f4;
        return this;
    }

    public BorderRounds set(BorderRounds borderRounds) {
        this.topLeft = borderRounds.topLeft;
        this.topRight = borderRounds.topRight;
        this.bottomLeft = borderRounds.bottomLeft;
        this.bottomRight = borderRounds.bottomRight;
        return this;
    }

    public BorderRounds set(float f) {
        this.topLeft = f;
        this.topRight = f;
        this.bottomLeft = f;
        this.bottomRight = f;
        return this;
    }

    public BorderRounds setAdjusted(BorderRounds borderRounds, float f) {
        this.topLeft = Math.max(0.0f, borderRounds.topLeft + f);
        this.topRight = Math.max(0.0f, borderRounds.topRight + f);
        this.bottomLeft = Math.max(0.0f, borderRounds.bottomLeft + f);
        this.bottomRight = Math.max(0.0f, borderRounds.bottomRight + f);
        return this;
    }
}
