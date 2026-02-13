package com.devexpress.navigation.tabs.utils;

import com.devexpress.navigation.common.Position;

/* loaded from: classes2.dex */
public class PositionHelper {

    /* renamed from: com.devexpress.navigation.tabs.utils.PositionHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$navigation$common$Position;

        static {
            int[] iArr = new int[Position.values().length];
            $SwitchMap$com$devexpress$navigation$common$Position = iArr;
            try {
                iArr[Position.Left.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Top.ordinal()] = 2;
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

    public static boolean needChangeViewsOrder(Position position, Position position2) {
        if (position2 == position) {
            return false;
        }
        int i = AnonymousClass1.$SwitchMap$com$devexpress$navigation$common$Position[position2.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? (i == 4 && position == Position.Right) ? false : true : position != Position.Bottom : position != Position.Left : position != Position.Top;
    }

    public static boolean isReverseDirection(Position position) {
        return (position == Position.Left || position == Position.Top) ? false : true;
    }

    public static boolean isLeftOrRightPosition(Position position) {
        return position == Position.Left || position == Position.Right;
    }

    public static int getOrientationByDirection(Position position) {
        return isLeftOrRightPosition(position) ? 0 : 1;
    }
}
