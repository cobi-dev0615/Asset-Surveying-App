package com.devexpress.navigation.common;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/* loaded from: classes2.dex */
public class ShadowDrawer {
    public static void drawHeaderPanelShadow(Canvas canvas, int i, int i2, View view, Position position, int i3) {
        int i4 = i - i2;
        int i5 = 255;
        if (i4 < 0) {
            i5 = (int) (255 * (i / i2));
            i4 = 0;
        } else {
            drawHeaderPanelShadowFiller(canvas, view, position, i4, i3);
        }
        drawHeaderPanelShadowGradient(canvas, view, position, i5, i4, i, i3);
    }

    private static void drawHeaderPanelShadowGradient(Canvas canvas, View view, Position position, int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        int i5 = AnonymousClass1.$SwitchMap$com$devexpress$navigation$common$Position[position.ordinal()];
        if (i5 == 1) {
            rect.top = i2;
            rect.bottom = i3;
            rect.right = view.getWidth();
            rect.offset(0, view.getBottom());
        } else if (i5 == 2) {
            orientation = GradientDrawable.Orientation.LEFT_RIGHT;
            rect.left = i2;
            rect.right = i3;
            rect.bottom = view.getHeight();
            rect.offset(view.getRight(), 0);
        } else if (i5 == 3) {
            orientation = GradientDrawable.Orientation.RIGHT_LEFT;
            rect.left = -i3;
            rect.right = -i2;
            rect.bottom = view.getHeight();
            rect.offset(view.getLeft(), 0);
        } else if (i5 == 4) {
            orientation = GradientDrawable.Orientation.BOTTOM_TOP;
            rect.top = -i3;
            rect.bottom = -i2;
            rect.right = view.getWidth();
            rect.offset(0, view.getTop());
        }
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, new int[]{i4, 0});
        gradientDrawable.setBounds(rect);
        gradientDrawable.setAlpha(i);
        gradientDrawable.draw(canvas);
    }

    /* renamed from: com.devexpress.navigation.common.ShadowDrawer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$navigation$common$Position;

        static {
            int[] iArr = new int[Position.values().length];
            $SwitchMap$com$devexpress$navigation$common$Position = iArr;
            try {
                iArr[Position.Top.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Left.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Right.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Bottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static void drawHeaderPanelShadowFiller(Canvas canvas, View view, Position position, int i, int i2) {
        Rect rect = new Rect();
        int i3 = AnonymousClass1.$SwitchMap$com$devexpress$navigation$common$Position[position.ordinal()];
        if (i3 == 1) {
            rect.top = view.getBottom();
            rect.bottom = rect.top + i;
            rect.right = view.getWidth();
        } else if (i3 == 2) {
            rect.left = view.getRight();
            rect.right = rect.left + i;
            rect.bottom = view.getHeight();
        } else if (i3 == 3) {
            rect.left = view.getLeft() - i;
            rect.right = view.getLeft();
            rect.bottom = view.getHeight();
        } else if (i3 == 4) {
            rect.top = view.getTop() - i;
            rect.bottom = view.getTop();
            rect.right = view.getWidth();
        }
        Paint paint = new Paint();
        paint.setColor(i2);
        canvas.drawRect(rect, paint);
    }
}
