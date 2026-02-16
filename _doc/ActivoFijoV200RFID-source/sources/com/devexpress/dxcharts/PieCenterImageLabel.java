package com.devexpress.dxcharts;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Icon;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class PieCenterImageLabel extends PieCenterLabel {
    private float contentRatio;
    private final float defaultContentRatio = 0.7f;
    private final PieCenterImageLabelScaleType defaultScaleType;
    private Object imageObject;
    private ImageSource imageSource;
    private ImageView imageView;
    private PieCenterImageLabelScaleType scaleType;

    private enum ImageSource {
        Drawable,
        Bitmap,
        Icon,
        Resource,
        None
    }

    private ImageView getImageView() {
        if (this.imageView == null) {
            this.imageView = new ImageView(getContext().getContext());
        }
        int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$PieCenterImageLabel$ImageSource[this.imageSource.ordinal()];
        if (i == 1) {
            this.imageView.setImageDrawable((android.graphics.drawable.Drawable) this.imageObject);
        } else if (i == 2) {
            this.imageView.setImageBitmap((Bitmap) this.imageObject);
        } else if (i == 3) {
            this.imageView.setImageIcon((Icon) this.imageObject);
        } else if (i == 4) {
            this.imageView.setImageResource(((Integer) this.imageObject).intValue());
        }
        this.imageSource = ImageSource.None;
        return this.imageView;
    }

    /* renamed from: com.devexpress.dxcharts.PieCenterImageLabel$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$PieCenterImageLabel$ImageSource;

        static {
            int[] iArr = new int[ImageSource.values().length];
            $SwitchMap$com$devexpress$dxcharts$PieCenterImageLabel$ImageSource = iArr;
            try {
                iArr[ImageSource.Drawable.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$PieCenterImageLabel$ImageSource[ImageSource.Bitmap.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$PieCenterImageLabel$ImageSource[ImageSource.Icon.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$PieCenterImageLabel$ImageSource[ImageSource.Resource.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.devexpress.dxcharts.PieCenterLabel
    protected void draw(Canvas canvas, Rect rect, Rect rect2, PieSeries pieSeries) {
        ImageView imageView = getImageView();
        float f = this.contentRatio;
        float f2 = (f + 1.0f) / 2.0f;
        float f3 = (1.0f - f) / 2.0f;
        if (!rect2.isEmpty()) {
            rect = rect2;
        }
        Rect rect3 = new Rect(rect);
        rect3.set((int) ((rect3.left * f2) + (rect3.right * f3)), (int) ((rect3.top * f2) + (rect3.bottom * f3)), (int) ((rect3.right * f2) + (rect3.left * f3)), (int) ((rect3.bottom * f2) + (rect3.top * f3)));
        canvas.translate(rect3.left, rect3.top);
        imageView.layout(rect3.left, rect3.top, rect3.right, rect3.bottom);
        imageView.setScaleType(this.scaleType.value);
        imageView.draw(canvas);
    }

    public PieCenterImageLabel() {
        PieCenterImageLabelScaleType pieCenterImageLabelScaleType = PieCenterImageLabelScaleType.CENTER_INSIDE;
        this.defaultScaleType = pieCenterImageLabelScaleType;
        this.scaleType = pieCenterImageLabelScaleType;
        this.contentRatio = 0.7f;
    }

    public PieCenterImageLabel(android.graphics.drawable.Drawable drawable) {
        PieCenterImageLabelScaleType pieCenterImageLabelScaleType = PieCenterImageLabelScaleType.CENTER_INSIDE;
        this.defaultScaleType = pieCenterImageLabelScaleType;
        this.scaleType = pieCenterImageLabelScaleType;
        this.contentRatio = 0.7f;
        this.imageObject = drawable;
        this.imageSource = ImageSource.Drawable;
    }

    public PieCenterImageLabel(Bitmap bitmap) {
        PieCenterImageLabelScaleType pieCenterImageLabelScaleType = PieCenterImageLabelScaleType.CENTER_INSIDE;
        this.defaultScaleType = pieCenterImageLabelScaleType;
        this.scaleType = pieCenterImageLabelScaleType;
        this.contentRatio = 0.7f;
        this.imageObject = bitmap;
        this.imageSource = ImageSource.Bitmap;
    }

    public PieCenterImageLabel(Icon icon) {
        PieCenterImageLabelScaleType pieCenterImageLabelScaleType = PieCenterImageLabelScaleType.CENTER_INSIDE;
        this.defaultScaleType = pieCenterImageLabelScaleType;
        this.scaleType = pieCenterImageLabelScaleType;
        this.contentRatio = 0.7f;
        this.imageObject = icon;
        this.imageSource = ImageSource.Icon;
    }

    public PieCenterImageLabel(int i) {
        PieCenterImageLabelScaleType pieCenterImageLabelScaleType = PieCenterImageLabelScaleType.CENTER_INSIDE;
        this.defaultScaleType = pieCenterImageLabelScaleType;
        this.scaleType = pieCenterImageLabelScaleType;
        this.contentRatio = 0.7f;
        this.imageObject = Integer.valueOf(i);
        this.imageSource = ImageSource.Resource;
    }

    public void setImageDrawable(android.graphics.drawable.Drawable drawable) {
        this.imageObject = drawable;
        this.imageSource = ImageSource.Drawable;
        invalidate();
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.imageObject = bitmap;
        this.imageSource = ImageSource.Bitmap;
        invalidate();
    }

    public void setImageIcon(Icon icon) {
        this.imageObject = icon;
        this.imageSource = ImageSource.Icon;
        invalidate();
    }

    public void setImageResource(int i) {
        this.imageObject = Integer.valueOf(i);
        this.imageSource = ImageSource.Resource;
        invalidate();
    }

    public float getContentRatio() {
        return this.contentRatio;
    }

    public void setContentRatio(float f) {
        if (this.contentRatio != f) {
            this.contentRatio = f;
            invalidate();
        }
    }

    public PieCenterImageLabelScaleType getScaleType() {
        return this.scaleType;
    }

    public void setScaleType(PieCenterImageLabelScaleType pieCenterImageLabelScaleType) {
        if (this.scaleType != pieCenterImageLabelScaleType) {
            this.scaleType = pieCenterImageLabelScaleType;
            invalidate();
        }
    }
}
