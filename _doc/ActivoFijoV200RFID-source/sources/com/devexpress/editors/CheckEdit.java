package com.devexpress.editors;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.widget.ImageViewCompat;
import com.devexpress.dxcore.DXNativeView;
import com.devexpress.editors.helpers.MathHelper;
import com.devexpress.editors.style.CheckEditStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckEdit.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u0093\u00012\u00020\u00012\u00020\u0002:\u0006\u0092\u0001\u0093\u0001\u0094\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010o\u001a\u00020pJ\u0006\u0010q\u001a\u00020pJ\b\u0010r\u001a\u00020?H\u0016J\b\u0010s\u001a\u00020:H\u0016J\u0012\u0010t\u001a\u00020p2\b\u0010u\u001a\u0004\u0018\u00010vH\u0016J\u0012\u0010w\u001a\u00020p2\b\u0010x\u001a\u0004\u0018\u00010yH\u0016J0\u0010z\u001a\u00020p2\u0006\u0010{\u001a\u00020:2\u0006\u0010|\u001a\u00020\b2\u0006\u0010}\u001a\u00020\b2\u0006\u0010~\u001a\u00020\b2\u0006\u0010\u007f\u001a\u00020\bH\u0014J\u001c\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020\b2\u0007\u0010\u0083\u0001\u001a\u00020\bH\u0014J\u0017\u0010\u001b\u001a\u00020p2\u0007\u0010\u0084\u0001\u001a\u00020\b2\u0006\u0010\n\u001a\u00020QJ\u0012\u0010\u0085\u0001\u001a\u00020p2\u0007\u0010\u0086\u0001\u001a\u00020:H\u0016J\u0012\u0010\u0087\u0001\u001a\u00020p2\u0007\u0010\u0088\u0001\u001a\u00020:H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020p2\u0007\u0010\u008a\u0001\u001a\u00020:H\u0016J\u0017\u0010U\u001a\u00020p2\u0007\u0010\u0084\u0001\u001a\u00020\b2\u0006\u0010\n\u001a\u00020QJ-\u0010\u008b\u0001\u001a\u00020p2\u0007\u0010\u008c\u0001\u001a\u00020\b2\u0007\u0010\u008d\u0001\u001a\u00020\b2\u0007\u0010\u008e\u0001\u001a\u00020\b2\u0007\u0010\u008f\u0001\u001a\u00020\bH\u0016J\u0017\u0010m\u001a\u00020p2\u0006\u0010\n\u001a\u00020j2\u0007\u0010\u0090\u0001\u001a\u00020:J\t\u0010\u0091\u0001\u001a\u00020pH\u0016R$\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\"8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R$\u0010,\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000fR$\u0010/\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010\r\"\u0004\b1\u0010\u000fR$\u00102\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000fR$\u00105\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010;\u001a\u00020:2\u0006\u0010\n\u001a\u00020:8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R(\u0010@\u001a\u0004\u0018\u00010?2\b\u0010\n\u001a\u0004\u0018\u00010?8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010E\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u0010\r\"\u0004\bG\u0010\u000fR$\u0010H\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010\r\"\u0004\bJ\u0010\u000fR$\u0010K\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u0010\r\"\u0004\bM\u0010\u000fR$\u0010N\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bO\u0010\r\"\u0004\bP\u0010\u000fR$\u0010R\u001a\u00020Q2\u0006\u0010\n\u001a\u00020Q8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR(\u0010X\u001a\u0004\u0018\u00010W2\b\u0010\n\u001a\u0004\u0018\u00010W8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0013\u0010]\u001a\u0004\u0018\u00010^8F¢\u0006\u0006\u001a\u0004\b_\u0010`R(\u0010b\u001a\u0004\u0018\u00010a2\b\u0010\n\u001a\u0004\u0018\u00010a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR$\u0010g\u001a\u00020:2\u0006\u0010\n\u001a\u00020:8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bh\u0010<\"\u0004\bi\u0010>R$\u0010\n\u001a\u00020j2\u0006\u0010\n\u001a\u00020j8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bk\u0010l\"\u0004\bm\u0010n¨\u0006\u0095\u0001"}, d2 = {"Lcom/devexpress/editors/CheckEdit;", "Lcom/devexpress/dxcore/DXNativeView;", "Landroid/widget/Checkable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "checkBoxColor", "getCheckBoxColor", "()I", "setCheckBoxColor", "(I)V", "Landroid/graphics/drawable/Drawable;", "checkboxDrawable", "getCheckboxDrawable", "()Landroid/graphics/drawable/Drawable;", "setCheckboxDrawable", "(Landroid/graphics/drawable/Drawable;)V", "checkboxGravity", "getCheckboxGravity", "setCheckboxGravity", "checkboxIndent", "getCheckboxIndent", "setCheckboxIndent", "Lcom/devexpress/editors/DXCheckBoxPosition;", "checkboxPosition", "getCheckboxPosition", "()Lcom/devexpress/editors/DXCheckBoxPosition;", "setCheckboxPosition", "(Lcom/devexpress/editors/DXCheckBoxPosition;)V", "Landroid/graphics/PorterDuff$Mode;", "checkboxTintMode", "getCheckboxTintMode", "()Landroid/graphics/PorterDuff$Mode;", "setCheckboxTintMode", "(Landroid/graphics/PorterDuff$Mode;)V", "checkboxView", "Landroid/widget/ImageView;", "getCheckboxView", "()Landroid/widget/ImageView;", "checkedCheckBoxColor", "getCheckedCheckBoxColor", "setCheckedCheckBoxColor", "disabledCheckBoxColor", "getDisabledCheckBoxColor", "setDisabledCheckBoxColor", "disabledCheckedCheckBoxColor", "getDisabledCheckedCheckBoxColor", "setDisabledCheckedCheckBoxColor", "disabledLabelTextColor", "getDisabledLabelTextColor", "setDisabledLabelTextColor", "innerCheckEdit", "Lcom/devexpress/editors/CheckEdit$CheckEditLayout;", "", "isIntermediateValueUserInputted", "()Z", "setIntermediateValueUserInputted", "(Z)V", "", "label", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "labelGravity", "getLabelGravity", "setLabelGravity", "labelPaintFlags", "getLabelPaintFlags", "setLabelPaintFlags", "labelTextAlignment", "getLabelTextAlignment", "setLabelTextAlignment", "labelTextColor", "getLabelTextColor", "setLabelTextColor", "", "labelTextSize", "getLabelTextSize", "()F", "setLabelTextSize", "(F)V", "Landroid/graphics/Typeface;", "labelTypeface", "getLabelTypeface", "()Landroid/graphics/Typeface;", "setLabelTypeface", "(Landroid/graphics/Typeface;)V", "labelView", "Landroid/widget/TextView;", "getLabelView", "()Landroid/widget/TextView;", "Lcom/devexpress/editors/CheckEdit$Listener;", "onActionListener", "getOnActionListener", "()Lcom/devexpress/editors/CheckEdit$Listener;", "setOnActionListener", "(Lcom/devexpress/editors/CheckEdit$Listener;)V", "shouldHandleClick", "getShouldHandleClick", "setShouldHandleClick", "Lcom/devexpress/editors/DXCheckEditValue;", "getValue", "()Lcom/devexpress/editors/DXCheckEditValue;", "setValue", "(Lcom/devexpress/editors/DXCheckEditValue;)V", "beginInit", "", "endInit", "getAccessibilityClassName", "isChecked", "onInitializeAccessibilityEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/accessibility/AccessibilityEvent;", "onInitializeAccessibilityNodeInfo", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "onLayout", "changed", "l", "t", "r", "b", "onMeasureCore", "Landroid/util/Size;", "widthMeasureSpec", "heightMeasureSpec", "unit", "setChecked", "checked", "setClickable", "clickable", "setEnabled", "enabled", "setPaddingRelative", "start", "top", "end", "bottom", "animated", "toggle", "CheckEditLayout", "Companion", "Listener", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckEdit extends DXNativeView implements Checkable {
    private final CheckEditLayout innerCheckEdit;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function4<View, Integer, Integer, Integer, Unit> applyCheckBoxSizeAsLabelPaddingStart = new Function4<View, Integer, Integer, Integer, Unit>() { // from class: com.devexpress.editors.CheckEdit$Companion$applyCheckBoxSizeAsLabelPaddingStart$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Integer num2, Integer num3) {
            invoke(view, num.intValue(), num2.intValue(), num3.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(View label, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(label, "label");
            label.setPaddingRelative(i + i3, 0, 0, 0);
        }
    };
    private static final Function4<View, Integer, Integer, Integer, Unit> applyCheckBoxSizeAsLabelPaddingEnd = new Function4<View, Integer, Integer, Integer, Unit>() { // from class: com.devexpress.editors.CheckEdit$Companion$applyCheckBoxSizeAsLabelPaddingEnd$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Integer num2, Integer num3) {
            invoke(view, num.intValue(), num2.intValue(), num3.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(View label, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(label, "label");
            label.setPaddingRelative(0, 0, i + i3, 0);
        }
    };
    private static final Function4<View, Integer, Integer, Integer, Unit> applyCheckBoxSizeAsLabelPaddingTop = new Function4<View, Integer, Integer, Integer, Unit>() { // from class: com.devexpress.editors.CheckEdit$Companion$applyCheckBoxSizeAsLabelPaddingTop$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Integer num2, Integer num3) {
            invoke(view, num.intValue(), num2.intValue(), num3.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(View label, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(label, "label");
            label.setPaddingRelative(0, i2 + i3, 0, 0);
        }
    };
    private static final Function4<View, Integer, Integer, Integer, Unit> applyCheckBoxSizeAsLabelPaddingBottom = new Function4<View, Integer, Integer, Integer, Unit>() { // from class: com.devexpress.editors.CheckEdit$Companion$applyCheckBoxSizeAsLabelPaddingBottom$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Integer num2, Integer num3) {
            invoke(view, num.intValue(), num2.intValue(), num3.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(View label, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(label, "label");
            label.setPaddingRelative(0, 0, 0, i2 + i3);
        }
    };
    private static final Function4<View, Integer, Integer, Integer, Unit> resetLabelPadding = new Function4<View, Integer, Integer, Integer, Unit>() { // from class: com.devexpress.editors.CheckEdit$Companion$resetLabelPadding$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Integer num2, Integer num3) {
            invoke(view, num.intValue(), num2.intValue(), num3.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(View label, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(label, "label");
            label.setPaddingRelative(0, 0, 0, 0);
        }
    };
    private static final Function1<DXCheckEditValue, DXCheckEditValue> getTrueFalseNextValue = new Function1<DXCheckEditValue, DXCheckEditValue>() { // from class: com.devexpress.editors.CheckEdit$Companion$getTrueFalseNextValue$1
        @Override // kotlin.jvm.functions.Function1
        public final DXCheckEditValue invoke(DXCheckEditValue value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value != DXCheckEditValue.Checked ? DXCheckEditValue.Checked : DXCheckEditValue.Unchecked;
        }
    };
    private static final Function1<DXCheckEditValue, DXCheckEditValue> getTrueFalseIndeterminateNextValue = new Function1<DXCheckEditValue, DXCheckEditValue>() { // from class: com.devexpress.editors.CheckEdit$Companion$getTrueFalseIndeterminateNextValue$1

        /* compiled from: CheckEdit.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DXCheckEditValue.values().length];
                try {
                    iArr[DXCheckEditValue.Unchecked.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DXCheckEditValue.Checked.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final DXCheckEditValue invoke(DXCheckEditValue value) {
            Intrinsics.checkNotNullParameter(value, "value");
            int i = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
            if (i == 1) {
                return DXCheckEditValue.Checked;
            }
            if (i == 2) {
                return DXCheckEditValue.Indeterminate;
            }
            return DXCheckEditValue.Unchecked;
        }
    };

    /* compiled from: CheckEdit.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/devexpress/editors/CheckEdit$Listener;", "", "onValueChanged", "", "newValue", "Lcom/devexpress/editors/DXCheckEditValue;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {
        void onValueChanged(DXCheckEditValue newValue);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CheckEdit(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CheckEdit(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @JvmStatic
    public static final Drawable getDefaultCheckboxDrawable(Context context) {
        return INSTANCE.getDefaultCheckboxDrawable(context);
    }

    @JvmStatic
    public static final Drawable getDefaultCheckedCheckboxDrawable(Context context) {
        return INSTANCE.getDefaultCheckedCheckboxDrawable(context);
    }

    @JvmStatic
    public static final Drawable getDefaultIndeterminateCheckboxDrawable(Context context) {
        return INSTANCE.getDefaultIndeterminateCheckboxDrawable(context);
    }

    @JvmStatic
    public static final Drawable getDefaultUncheckedCheckboxDrawable(Context context) {
        return INSTANCE.getDefaultUncheckedCheckboxDrawable(context);
    }

    /* compiled from: CheckEdit.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007R,\u0010\u0003\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\b\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\t\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\n\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000f\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/devexpress/editors/CheckEdit$Companion;", "", "()V", "applyCheckBoxSizeAsLabelPaddingBottom", "Lkotlin/Function4;", "Landroid/view/View;", "", "", "applyCheckBoxSizeAsLabelPaddingEnd", "applyCheckBoxSizeAsLabelPaddingStart", "applyCheckBoxSizeAsLabelPaddingTop", "getTrueFalseIndeterminateNextValue", "Lkotlin/Function1;", "Lcom/devexpress/editors/DXCheckEditValue;", "getTrueFalseNextValue", "resetLabelPadding", "getDefaultCheckboxDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "getDefaultCheckedCheckboxDrawable", "getDefaultIndeterminateCheckboxDrawable", "getDefaultUncheckedCheckboxDrawable", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Drawable getDefaultCheckboxDrawable(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return ContextCompat.getDrawable(context, R.drawable.dxe_checkbox);
        }

        @JvmStatic
        public final Drawable getDefaultCheckedCheckboxDrawable(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return ContextCompat.getDrawable(context, R.drawable.dxe_checkbox_checked);
        }

        @JvmStatic
        public final Drawable getDefaultUncheckedCheckboxDrawable(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return ContextCompat.getDrawable(context, R.drawable.dxe_checkbox_unchecked);
        }

        @JvmStatic
        public final Drawable getDefaultIndeterminateCheckboxDrawable(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return ContextCompat.getDrawable(context, R.drawable.dxe_checkbox_indeterminate);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        CheckEditLayout checkEditLayout = new CheckEditLayout(context, null, 0, 6, null);
        this.innerCheckEdit = checkEditLayout;
        addView(checkEditLayout);
        checkEditLayout.setOnClickListener(new View.OnClickListener() { // from class: com.devexpress.editors.CheckEdit$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckEdit._init_$lambda$0(CheckEdit.this, view);
            }
        });
    }

    public /* synthetic */ CheckEdit(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final TextView getLabelView() {
        return this.innerCheckEdit.getLabelView();
    }

    public final ImageView getCheckboxView() {
        return this.innerCheckEdit.getCheckboxView$dxeditors_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(CheckEdit this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.callOnClick();
    }

    public final DXCheckEditValue getValue() {
        return this.innerCheckEdit.getValue();
    }

    public final void setValue(DXCheckEditValue value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.innerCheckEdit.setValue(value);
    }

    public final CharSequence getLabel() {
        return this.innerCheckEdit.getLabel();
    }

    public final void setLabel(CharSequence charSequence) {
        this.innerCheckEdit.setLabel(charSequence);
    }

    public final boolean isIntermediateValueUserInputted() {
        return this.innerCheckEdit.getIsIntermediateValueUserInputted();
    }

    public final void setIntermediateValueUserInputted(boolean z) {
        this.innerCheckEdit.setIntermediateValueUserInputted(z);
    }

    public final boolean getShouldHandleClick() {
        return this.innerCheckEdit.getShouldHandleClick();
    }

    public final void setShouldHandleClick(boolean z) {
        this.innerCheckEdit.setShouldHandleClick(z);
    }

    public final Drawable getCheckboxDrawable() {
        return this.innerCheckEdit.getCheckboxDrawable();
    }

    public final void setCheckboxDrawable(Drawable drawable) {
        this.innerCheckEdit.setCheckboxDrawable(drawable);
    }

    public final int getCheckBoxColor() {
        return this.innerCheckEdit.getCheckBoxColor();
    }

    public final void setCheckBoxColor(int i) {
        this.innerCheckEdit.setCheckBoxColor(i);
    }

    public final int getCheckedCheckBoxColor() {
        return this.innerCheckEdit.getCheckedCheckBoxColor();
    }

    public final void setCheckedCheckBoxColor(int i) {
        this.innerCheckEdit.setCheckedCheckBoxColor(i);
    }

    public final int getDisabledCheckBoxColor() {
        return this.innerCheckEdit.getDisabledCheckBoxColor();
    }

    public final void setDisabledCheckBoxColor(int i) {
        this.innerCheckEdit.setDisabledCheckBoxColor(i);
    }

    public final int getDisabledCheckedCheckBoxColor() {
        return this.innerCheckEdit.getDisabledCheckedCheckBoxColor();
    }

    public final void setDisabledCheckedCheckBoxColor(int i) {
        this.innerCheckEdit.setDisabledCheckedCheckBoxColor(i);
    }

    public final PorterDuff.Mode getCheckboxTintMode() {
        return this.innerCheckEdit.getCheckboxTintMode();
    }

    public final void setCheckboxTintMode(PorterDuff.Mode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.innerCheckEdit.setCheckboxTintMode(value);
    }

    public final DXCheckBoxPosition getCheckboxPosition() {
        return this.innerCheckEdit.getCheckboxPosition();
    }

    public final void setCheckboxPosition(DXCheckBoxPosition value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.innerCheckEdit.setCheckboxPosition(value);
    }

    public final int getCheckboxGravity() {
        return this.innerCheckEdit.getCheckboxGravity();
    }

    public final void setCheckboxGravity(int i) {
        this.innerCheckEdit.setCheckboxGravity(i);
    }

    public final int getCheckboxIndent() {
        return this.innerCheckEdit.getCheckboxIndent();
    }

    public final void setCheckboxIndent(int i) {
        this.innerCheckEdit.setCheckboxIndent(i);
    }

    public final int getLabelTextColor() {
        return this.innerCheckEdit.getLabelTextColor();
    }

    public final void setLabelTextColor(int i) {
        this.innerCheckEdit.setLabelTextColor(i);
    }

    public final int getDisabledLabelTextColor() {
        return this.innerCheckEdit.getDisabledLabelTextColor();
    }

    public final void setDisabledLabelTextColor(int i) {
        this.innerCheckEdit.setDisabledLabelTextColor(i);
    }

    public final int getLabelGravity() {
        return this.innerCheckEdit.getLabelGravity();
    }

    public final void setLabelGravity(int i) {
        this.innerCheckEdit.setLabelGravity(i);
    }

    public final int getLabelTextAlignment() {
        return this.innerCheckEdit.getLabelTextAlignment();
    }

    public final void setLabelTextAlignment(int i) {
        this.innerCheckEdit.setLabelTextAlignment(i);
    }

    public final float getLabelTextSize() {
        return this.innerCheckEdit.getLabelTextSize();
    }

    public final void setLabelTextSize(float f) {
        this.innerCheckEdit.setLabelTextSize(f);
    }

    public final Typeface getLabelTypeface() {
        return this.innerCheckEdit.getLabelTypeface();
    }

    public final void setLabelTypeface(Typeface typeface) {
        this.innerCheckEdit.setLabelTypeface(typeface);
    }

    public final int getLabelPaintFlags() {
        return this.innerCheckEdit.getLabelPaintFlags();
    }

    public final void setLabelPaintFlags(int i) {
        this.innerCheckEdit.setLabelPaintFlags(i);
    }

    public final Listener getOnActionListener() {
        return this.innerCheckEdit.getOnActionListener();
    }

    public final void setOnActionListener(Listener listener) {
        this.innerCheckEdit.setOnActionListener(listener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        String name = CheckEdit.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        if (event == null) {
            return;
        }
        event.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        if (info != null) {
            info.setCheckable(true);
        }
        if (info == null) {
            return;
        }
        info.setChecked(isChecked());
    }

    @Override // android.view.View
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        this.innerCheckEdit.setPaddingRelative(start, top, end, bottom);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.innerCheckEdit.isChecked();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.innerCheckEdit.toggle();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        this.innerCheckEdit.setChecked(checked);
    }

    public final void beginInit() {
        this.innerCheckEdit.beginInit();
    }

    public final void endInit() {
        this.innerCheckEdit.endInit();
    }

    public final void setValue(DXCheckEditValue value, boolean animated) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.innerCheckEdit.setValue(value, animated);
    }

    @Override // com.devexpress.dxcore.DXNativeView
    protected Size onMeasureCore(int widthMeasureSpec, int heightMeasureSpec) {
        this.innerCheckEdit.measure(widthMeasureSpec, heightMeasureSpec);
        return new Size(this.innerCheckEdit.getMeasuredWidth(), this.innerCheckEdit.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.innerCheckEdit.layout(0, 0, r - l, b - t);
    }

    @Override // android.view.View
    public void setClickable(boolean clickable) {
        super.setClickable(clickable);
        this.innerCheckEdit.setClickable(clickable);
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.innerCheckEdit.setEnabled(enabled);
    }

    public final void setLabelTextSize(int unit, float value) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setLabelTextSize(companion.applyDimension(context, value, unit));
    }

    public final void setCheckboxIndent(int unit, float value) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setCheckboxIndent(companion.applyDimensionToInt(context, value, unit));
    }

    /* compiled from: CheckEdit.kt */
    @Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0013\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010z\u001a\u00020\rJ\b\u0010{\u001a\u00020\rH\u0002J\b\u0010|\u001a\u00020\rH\u0002J\b\u0010}\u001a\u00020\rH\u0002J\u0006\u0010~\u001a\u00020\rJ\b\u0010\u007f\u001a\u00020BH\u0016J\t\u0010\u0080\u0001\u001a\u00020\rH\u0016J\u0013\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020\bH\u0014J\u001b\u0010\u0084\u0001\u001a\u00020\r2\u0007\u0010\u0085\u0001\u001a\u00020\b2\u0007\u0010\u0086\u0001\u001a\u00020\bH\u0014J\t\u0010\u0087\u0001\u001a\u00020BH\u0016J\t\u0010\u0088\u0001\u001a\u00020\rH\u0016J\u0012\u0010\u0089\u0001\u001a\u00020\r2\u0007\u0010\u008a\u0001\u001a\u00020BH\u0016J\u0017\u0010x\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020@2\u0007\u0010\u008b\u0001\u001a\u00020BJ\t\u0010\u008c\u0001\u001a\u00020\rH\u0016J\t\u0010\u008d\u0001\u001a\u00020\rH\u0002J\t\u0010\u008e\u0001\u001a\u00020\rH\u0002J\t\u0010\u008f\u0001\u001a\u00020\rH\u0002J\t\u0010\u0090\u0001\u001a\u00020\rH\u0002J\t\u0010\u0091\u0001\u001a\u00020\rH\u0002J\t\u0010\u0092\u0001\u001a\u00020\rH\u0002J\t\u0010\u0093\u0001\u001a\u00020\rH\u0002J\t\u0010\u0094\u0001\u001a\u00020BH\u0002R,\u0010\n\u001a \u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\u000bX\u0082.¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R$\u0010\u001d\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R$\u0010!\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020 @FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020&8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013R$\u00105\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u0010\u0013R$\u00108\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010\u0011\"\u0004\b:\u0010\u0013R$\u0010;\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u0010\u0011\"\u0004\b=\u0010\u0013R\u001a\u0010>\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020@0?X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010C\u001a\u00020B2\u0006\u0010\u000e\u001a\u00020B@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR(\u0010H\u001a\u0004\u0018\u00010G2\b\u0010\u000e\u001a\u0004\u0018\u00010G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010M\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0011\"\u0004\bO\u0010\u0013R$\u0010P\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0011\"\u0004\bR\u0010\u0013R$\u0010S\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0011\"\u0004\bU\u0010\u0013R$\u0010V\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010\u0011\"\u0004\bX\u0010\u0013R$\u0010Z\u001a\u00020Y2\u0006\u0010\u000e\u001a\u00020Y@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R(\u0010`\u001a\u0004\u0018\u00010_2\b\u0010\u000e\u001a\u0004\u0018\u00010_@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001c\u0010e\u001a\u0004\u0018\u00010fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001c\u0010k\u001a\u0004\u0018\u00010lX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001a\u0010q\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010D\"\u0004\bs\u0010FR\u000e\u0010t\u001a\u00020uX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020@2\u0006\u0010\u000e\u001a\u00020@@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010y¨\u0006\u0095\u0001"}, d2 = {"Lcom/devexpress/editors/CheckEdit$CheckEditLayout;", "Landroid/widget/FrameLayout;", "Landroid/widget/Checkable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "applyCheckBoxSizeAsLabelPadding", "Lkotlin/Function4;", "Landroid/view/View;", "", "value", "checkBoxColor", "getCheckBoxColor", "()I", "setCheckBoxColor", "(I)V", "Landroid/graphics/drawable/Drawable;", "checkboxDrawable", "getCheckboxDrawable", "()Landroid/graphics/drawable/Drawable;", "setCheckboxDrawable", "(Landroid/graphics/drawable/Drawable;)V", "checkboxGravity", "getCheckboxGravity", "setCheckboxGravity", "checkboxIndent", "getCheckboxIndent", "setCheckboxIndent", "Lcom/devexpress/editors/DXCheckBoxPosition;", "checkboxPosition", "getCheckboxPosition", "()Lcom/devexpress/editors/DXCheckBoxPosition;", "setCheckboxPosition", "(Lcom/devexpress/editors/DXCheckBoxPosition;)V", "Landroid/graphics/PorterDuff$Mode;", "checkboxTintMode", "getCheckboxTintMode", "()Landroid/graphics/PorterDuff$Mode;", "setCheckboxTintMode", "(Landroid/graphics/PorterDuff$Mode;)V", "checkboxView", "Landroid/widget/ImageView;", "getCheckboxView$dxeditors_release", "()Landroid/widget/ImageView;", "setCheckboxView$dxeditors_release", "(Landroid/widget/ImageView;)V", "checkedCheckBoxColor", "getCheckedCheckBoxColor", "setCheckedCheckBoxColor", "disabledCheckBoxColor", "getDisabledCheckBoxColor", "setDisabledCheckBoxColor", "disabledCheckedCheckBoxColor", "getDisabledCheckedCheckBoxColor", "setDisabledCheckedCheckBoxColor", "disabledLabelTextColor", "getDisabledLabelTextColor", "setDisabledLabelTextColor", "getNextValue", "Lkotlin/Function1;", "Lcom/devexpress/editors/DXCheckEditValue;", "isInitInProgress", "", "isIntermediateValueUserInputted", "()Z", "setIntermediateValueUserInputted", "(Z)V", "", "label", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "labelGravity", "getLabelGravity", "setLabelGravity", "labelPaintFlags", "getLabelPaintFlags", "setLabelPaintFlags", "labelTextAlignment", "getLabelTextAlignment", "setLabelTextAlignment", "labelTextColor", "getLabelTextColor", "setLabelTextColor", "", "labelTextSize", "getLabelTextSize", "()F", "setLabelTextSize", "(F)V", "Landroid/graphics/Typeface;", "labelTypeface", "getLabelTypeface", "()Landroid/graphics/Typeface;", "setLabelTypeface", "(Landroid/graphics/Typeface;)V", "labelView", "Landroid/widget/TextView;", "getLabelView$dxeditors_release", "()Landroid/widget/TextView;", "setLabelView$dxeditors_release", "(Landroid/widget/TextView;)V", "onActionListener", "Lcom/devexpress/editors/CheckEdit$Listener;", "getOnActionListener", "()Lcom/devexpress/editors/CheckEdit$Listener;", "setOnActionListener", "(Lcom/devexpress/editors/CheckEdit$Listener;)V", "shouldHandleClick", "getShouldHandleClick", "setShouldHandleClick", "style", "Lcom/devexpress/editors/style/CheckEditStyle;", "getValue", "()Lcom/devexpress/editors/DXCheckEditValue;", "setValue", "(Lcom/devexpress/editors/DXCheckEditValue;)V", "beginInit", "changeClickBehavior", "createCheckboxView", "createLabelView", "endInit", "isChecked", "jumpDrawablesToCurrentState", "onCreateDrawableState", "", "extraSpace", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "performClick", "refreshDrawableState", "setChecked", "checked", "animated", "toggle", "updateCheckBoxBackground", "updateCheckBoxTint", "updateCheckboxGravity", "updateDrawableTintMode", "updateLabelGravity", "updateLabelTextAlignment", "updateLabelTint", "updateLabelViewText", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CheckEditLayout extends FrameLayout implements Checkable {
        private Function4<? super View, ? super Integer, ? super Integer, ? super Integer, Unit> applyCheckBoxSizeAsLabelPadding;
        private int checkboxGravity;
        private int checkboxIndent;
        private DXCheckBoxPosition checkboxPosition;
        public ImageView checkboxView;
        private Function1<? super DXCheckEditValue, ? extends DXCheckEditValue> getNextValue;
        private boolean isInitInProgress;
        private boolean isIntermediateValueUserInputted;
        private CharSequence label;
        private int labelGravity;
        private int labelPaintFlags;
        private int labelTextAlignment;
        private float labelTextSize;
        private Typeface labelTypeface;
        private TextView labelView;
        private Listener onActionListener;
        private boolean shouldHandleClick;
        private final CheckEditStyle style;
        private DXCheckEditValue value;

        /* compiled from: CheckEdit.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[DXCheckEditValue.values().length];
                try {
                    iArr[DXCheckEditValue.Checked.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DXCheckEditValue.Indeterminate.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[DXCheckBoxPosition.values().length];
                try {
                    iArr2[DXCheckBoxPosition.Start.ordinal()] = 1;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr2[DXCheckBoxPosition.End.ordinal()] = 2;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr2[DXCheckBoxPosition.Top.ordinal()] = 3;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr2[DXCheckBoxPosition.Bottom.ordinal()] = 4;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public CheckEditLayout(Context context) {
            this(context, null, 0, 6, null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public CheckEditLayout(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0, 4, null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CheckEditLayout(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            Intrinsics.checkNotNullParameter(context, "context");
            this.style = new CheckEditStyle(context);
            this.value = DXCheckEditValue.Unchecked;
            this.shouldHandleClick = true;
            this.checkboxPosition = DXCheckBoxPosition.Start;
            this.checkboxGravity = 8388627;
            this.labelGravity = 8388627;
            this.labelTextAlignment = 1;
            this.labelTextSize = -1.0f;
            this.labelPaintFlags = 1283;
            setClickable(true);
            setFocusable(true);
            setClipChildren(false);
            createCheckboxView();
            setCheckboxDrawable(null);
            changeClickBehavior();
            setLabelTextSize(context.getResources().getDimension(R.dimen.checkEdit_labelTextSize));
        }

        public /* synthetic */ CheckEditLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
        }

        public final ImageView getCheckboxView$dxeditors_release() {
            ImageView imageView = this.checkboxView;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("checkboxView");
            return null;
        }

        public final void setCheckboxView$dxeditors_release(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.checkboxView = imageView;
        }

        /* renamed from: getLabelView$dxeditors_release, reason: from getter */
        public final TextView getLabelView() {
            return this.labelView;
        }

        public final void setLabelView$dxeditors_release(TextView textView) {
            this.labelView = textView;
        }

        public final DXCheckEditValue getValue() {
            return this.value;
        }

        public final void setValue(DXCheckEditValue value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (this.value == value) {
                return;
            }
            this.value = value;
            refreshDrawableState();
            Listener listener = this.onActionListener;
            if (listener != null) {
                listener.onValueChanged(value);
            }
        }

        public final CharSequence getLabel() {
            return this.label;
        }

        public final void setLabel(CharSequence charSequence) {
            if (Intrinsics.areEqual(this.label, charSequence)) {
                return;
            }
            CharSequence charSequence2 = this.label;
            this.label = charSequence;
            updateLabelViewText();
            boolean z = charSequence2 == null || charSequence2.length() == 0;
            CharSequence charSequence3 = this.label;
            if ((charSequence3 == null || charSequence3.length() == 0) ^ z) {
                updateCheckboxGravity();
            }
        }

        /* renamed from: isIntermediateValueUserInputted, reason: from getter */
        public final boolean getIsIntermediateValueUserInputted() {
            return this.isIntermediateValueUserInputted;
        }

        public final void setIntermediateValueUserInputted(boolean z) {
            if (this.isIntermediateValueUserInputted == z) {
                return;
            }
            this.isIntermediateValueUserInputted = z;
            changeClickBehavior();
        }

        public final boolean getShouldHandleClick() {
            return this.shouldHandleClick;
        }

        public final void setShouldHandleClick(boolean z) {
            this.shouldHandleClick = z;
        }

        public final Drawable getCheckboxDrawable() {
            return getCheckboxView$dxeditors_release().getDrawable();
        }

        public final void setCheckboxDrawable(Drawable drawable) {
            if (drawable == null) {
                Companion companion = CheckEdit.INSTANCE;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                drawable = companion.getDefaultCheckboxDrawable(context);
                if (drawable == null) {
                    return;
                }
            }
            getCheckboxView$dxeditors_release().setImageDrawable(drawable);
            drawable.jumpToCurrentState();
        }

        public final int getCheckBoxColor() {
            return this.style.getForegroundColor();
        }

        public final void setCheckBoxColor(int i) {
            if (this.style.getForegroundColor() == i) {
                return;
            }
            this.style.setForegroundColor(i);
            updateCheckBoxTint();
            updateCheckBoxBackground();
        }

        public final int getCheckedCheckBoxColor() {
            return this.style.getCheckedForegroundColor();
        }

        public final void setCheckedCheckBoxColor(int i) {
            if (this.style.getCheckedForegroundColor() == i) {
                return;
            }
            this.style.setCheckedForegroundColor(i);
            updateCheckBoxTint();
            updateCheckBoxBackground();
        }

        public final int getDisabledCheckBoxColor() {
            return this.style.getDisabledForegroundColor();
        }

        public final void setDisabledCheckBoxColor(int i) {
            if (this.style.getDisabledForegroundColor() == i) {
                return;
            }
            this.style.setDisabledForegroundColor(i);
            updateCheckBoxTint();
        }

        public final int getDisabledCheckedCheckBoxColor() {
            return this.style.getDisabledCheckedForegroundColor();
        }

        public final void setDisabledCheckedCheckBoxColor(int i) {
            if (this.style.getDisabledCheckedForegroundColor() == i) {
                return;
            }
            this.style.setDisabledCheckedForegroundColor(i);
            updateCheckBoxTint();
        }

        public final PorterDuff.Mode getCheckboxTintMode() {
            PorterDuff.Mode imageTintMode = ImageViewCompat.getImageTintMode(getCheckboxView$dxeditors_release());
            Intrinsics.checkNotNull(imageTintMode);
            return imageTintMode;
        }

        public final void setCheckboxTintMode(PorterDuff.Mode value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ImageViewCompat.setImageTintMode(getCheckboxView$dxeditors_release(), value);
        }

        public final DXCheckBoxPosition getCheckboxPosition() {
            return this.checkboxPosition;
        }

        public final void setCheckboxPosition(DXCheckBoxPosition value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (this.checkboxPosition == value) {
                return;
            }
            this.checkboxPosition = value;
            updateCheckboxGravity();
        }

        public final int getCheckboxGravity() {
            return this.checkboxGravity;
        }

        public final void setCheckboxGravity(int i) {
            if (this.checkboxGravity == i) {
                return;
            }
            this.checkboxGravity = i;
            updateCheckboxGravity();
        }

        public final int getCheckboxIndent() {
            return this.checkboxIndent;
        }

        public final void setCheckboxIndent(int i) {
            if (this.checkboxIndent == i) {
                return;
            }
            this.checkboxIndent = i;
            requestLayout();
        }

        public final int getLabelTextColor() {
            return this.style.getLabelColor();
        }

        public final void setLabelTextColor(int i) {
            if (this.style.getLabelColor() == i) {
                return;
            }
            this.style.setLabelColor(i);
            updateLabelTint();
        }

        public final int getDisabledLabelTextColor() {
            return this.style.getDisabledLabelColor();
        }

        public final void setDisabledLabelTextColor(int i) {
            if (this.style.getDisabledLabelColor() == i) {
                return;
            }
            this.style.setDisabledLabelColor(i);
            updateLabelTint();
        }

        public final int getLabelGravity() {
            return this.labelGravity;
        }

        public final void setLabelGravity(int i) {
            if (this.labelGravity == i) {
                return;
            }
            this.labelGravity = i;
            updateLabelGravity();
        }

        public final int getLabelTextAlignment() {
            return this.labelTextAlignment;
        }

        public final void setLabelTextAlignment(int i) {
            if (this.labelTextAlignment == i) {
                return;
            }
            this.labelTextAlignment = i;
            updateLabelTextAlignment();
        }

        public final float getLabelTextSize() {
            return this.labelTextSize;
        }

        public final void setLabelTextSize(float f) {
            if (this.labelTextSize == f) {
                return;
            }
            this.labelTextSize = f;
            TextView textView = this.labelView;
            if (textView != null) {
                textView.setTextSize(0, f);
            }
        }

        public final Typeface getLabelTypeface() {
            return this.labelTypeface;
        }

        public final void setLabelTypeface(Typeface typeface) {
            if (Intrinsics.areEqual(this.labelTypeface, typeface)) {
                return;
            }
            this.labelTypeface = typeface;
            TextView textView = this.labelView;
            if (textView == null) {
                return;
            }
            textView.setTypeface(typeface);
        }

        public final int getLabelPaintFlags() {
            return this.labelPaintFlags;
        }

        public final void setLabelPaintFlags(int i) {
            if (this.labelPaintFlags == i) {
                return;
            }
            this.labelPaintFlags = i;
            TextView textView = this.labelView;
            if (textView == null) {
                return;
            }
            textView.setPaintFlags(i);
        }

        public final Listener getOnActionListener() {
            return this.onActionListener;
        }

        public final void setOnActionListener(Listener listener) {
            this.onActionListener = listener;
        }

        public final void setValue(DXCheckEditValue value, boolean animated) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (this.value == value) {
                return;
            }
            setValue(value);
            if (animated) {
                return;
            }
            jumpDrawablesToCurrentState();
        }

        public final void beginInit() {
            this.isInitInProgress = true;
        }

        public final void endInit() {
            this.isInitInProgress = false;
            updateCheckboxGravity();
            updateCheckBoxTint();
            if (updateLabelViewText()) {
                return;
            }
            updateLabelTint();
            updateLabelGravity();
            updateLabelTextAlignment();
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            TextView textView = this.labelView;
            if (textView != null) {
                measureChild(getCheckboxView$dxeditors_release(), widthMeasureSpec, heightMeasureSpec);
                Function4<? super View, ? super Integer, ? super Integer, ? super Integer, Unit> function4 = this.applyCheckBoxSizeAsLabelPadding;
                if (function4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("applyCheckBoxSizeAsLabelPadding");
                    function4 = null;
                }
                function4.invoke(textView, Integer.valueOf(getCheckboxView$dxeditors_release().getMeasuredWidth()), Integer.valueOf(getCheckboxView$dxeditors_release().getMeasuredHeight()), Integer.valueOf(this.checkboxIndent));
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int extraSpace) {
            int[] iArr;
            int i = WhenMappings.$EnumSwitchMapping$0[this.value.ordinal()];
            if (i == 1) {
                iArr = Constants.CHECKED_STATE;
            } else if (i == 2) {
                iArr = Constants.INDETERMINATE_STATE;
            } else {
                iArr = Constants.DEFAULT_STATE;
            }
            int[] onCreateDrawableState = super.onCreateDrawableState(extraSpace + iArr.length);
            Intrinsics.checkNotNullExpressionValue(onCreateDrawableState, "onCreateDrawableState(...)");
            int[] mergeDrawableStates = View.mergeDrawableStates(onCreateDrawableState, iArr);
            Intrinsics.checkNotNullExpressionValue(mergeDrawableStates, "mergeDrawableStates(...)");
            return mergeDrawableStates;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void jumpDrawablesToCurrentState() {
            super.jumpDrawablesToCurrentState();
            updateDrawableTintMode();
        }

        @Override // android.view.View
        public void refreshDrawableState() {
            super.refreshDrawableState();
            updateDrawableTintMode();
        }

        @Override // android.view.View
        public boolean performClick() {
            if (this.shouldHandleClick) {
                toggle();
            }
            boolean performClick = super.performClick();
            if (!performClick) {
                playSoundEffect(0);
            }
            return performClick;
        }

        @Override // android.widget.Checkable
        public boolean isChecked() {
            return this.value == DXCheckEditValue.Checked;
        }

        @Override // android.widget.Checkable
        public void toggle() {
            Function1<? super DXCheckEditValue, ? extends DXCheckEditValue> function1 = this.getNextValue;
            if (function1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("getNextValue");
                function1 = null;
            }
            setValue(function1.invoke(this.value), true);
        }

        @Override // android.widget.Checkable
        public void setChecked(boolean checked) {
            setValue(checked ? DXCheckEditValue.Checked : DXCheckEditValue.Unchecked, false);
        }

        private final boolean updateLabelViewText() {
            CharSequence charSequence;
            if (this.isInitInProgress) {
                return false;
            }
            if (this.labelView == null && (charSequence = this.label) != null && charSequence.length() != 0) {
                createLabelView();
                return true;
            }
            TextView textView = this.labelView;
            if (textView == null) {
                return false;
            }
            textView.setText(this.label);
            CharSequence charSequence2 = this.label;
            textView.setVisibility((charSequence2 == null || charSequence2.length() == 0) ? 8 : 0);
            return false;
        }

        private final void updateCheckboxGravity() {
            if (this.isInitInProgress) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = getCheckboxView$dxeditors_release().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            CharSequence charSequence = this.label;
            if (charSequence == null || charSequence.length() == 0) {
                layoutParams2.gravity = this.checkboxGravity;
                this.applyCheckBoxSizeAsLabelPadding = CheckEdit.resetLabelPadding;
            } else {
                int i = WhenMappings.$EnumSwitchMapping$1[this.checkboxPosition.ordinal()];
                if (i == 1) {
                    layoutParams2.gravity = (this.checkboxGravity & 112) | GravityCompat.START;
                    this.applyCheckBoxSizeAsLabelPadding = CheckEdit.applyCheckBoxSizeAsLabelPaddingStart;
                } else if (i == 2) {
                    layoutParams2.gravity = (this.checkboxGravity & 112) | GravityCompat.END;
                    this.applyCheckBoxSizeAsLabelPadding = CheckEdit.applyCheckBoxSizeAsLabelPaddingEnd;
                } else if (i == 3) {
                    layoutParams2.gravity = (this.checkboxGravity & 7) | 48;
                    this.applyCheckBoxSizeAsLabelPadding = CheckEdit.applyCheckBoxSizeAsLabelPaddingTop;
                } else if (i == 4) {
                    layoutParams2.gravity = (this.checkboxGravity & 7) | 80;
                    this.applyCheckBoxSizeAsLabelPadding = CheckEdit.applyCheckBoxSizeAsLabelPaddingBottom;
                }
            }
            requestLayout();
        }

        private final void updateCheckBoxTint() {
            if (this.isInitInProgress) {
                return;
            }
            ImageViewCompat.setImageTintList(getCheckboxView$dxeditors_release(), this.style.createCheckBoxTint());
        }

        private final void updateCheckBoxBackground() {
            if (this.isInitInProgress) {
                return;
            }
            getCheckboxView$dxeditors_release().setBackground(this.style.createCheckBoxBackground());
        }

        private final void updateLabelTint() {
            TextView textView;
            if (this.isInitInProgress || (textView = this.labelView) == null) {
                return;
            }
            textView.setTextColor(this.style.createLabelTint());
        }

        private final void updateLabelGravity() {
            TextView textView;
            if (this.isInitInProgress || (textView = this.labelView) == null) {
                return;
            }
            Intrinsics.checkNotNull(textView);
            textView.setGravity(this.labelGravity);
            TextView textView2 = this.labelView;
            Intrinsics.checkNotNull(textView2);
            ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ((FrameLayout.LayoutParams) layoutParams).gravity = this.labelGravity;
            requestLayout();
        }

        private final void updateLabelTextAlignment() {
            TextView textView;
            if (this.isInitInProgress || (textView = this.labelView) == null) {
                return;
            }
            textView.setTextAlignment(this.labelTextAlignment);
        }

        private final void changeClickBehavior() {
            this.getNextValue = this.isIntermediateValueUserInputted ? CheckEdit.getTrueFalseIndeterminateNextValue : CheckEdit.getTrueFalseNextValue;
        }

        private final void createCheckboxView() {
            setCheckboxView$dxeditors_release(new AppCompatImageView(getContext()));
            getCheckboxView$dxeditors_release().setDuplicateParentStateEnabled(true);
            getCheckboxView$dxeditors_release().setCropToPadding(false);
            getCheckboxView$dxeditors_release().setBackground(this.style.createCheckBoxBackground());
            ImageViewCompat.setImageTintList(getCheckboxView$dxeditors_release(), this.style.createCheckBoxTint());
            getContext().getTheme().obtainStyledAttributes(new int[]{androidx.appcompat.R.attr.colorButtonNormal});
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = this.checkboxGravity;
            addView(getCheckboxView$dxeditors_release(), layoutParams);
        }

        private final void createLabelView() {
            TextView textView = new TextView(getContext());
            textView.setDuplicateParentStateEnabled(true);
            textView.setText(this.label);
            textView.setTextAlignment(this.labelTextAlignment);
            textView.setGravity(this.labelGravity);
            CharSequence charSequence = this.label;
            textView.setVisibility((charSequence == null || charSequence.length() == 0) ? 8 : 0);
            textView.setTextColor(this.style.createLabelTint());
            textView.setPaintFlags(this.labelPaintFlags);
            Typeface typeface = this.labelTypeface;
            if (typeface != null) {
                textView.setTypeface(typeface);
            }
            float f = this.labelTextSize;
            if (f < 0.0f) {
                setLabelTextSize(textView.getTextSize());
            } else {
                textView.setTextSize(0, f);
            }
            this.labelView = textView;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = this.labelGravity;
            addView(textView, layoutParams);
        }

        private final void updateDrawableTintMode() {
            PorterDuff.Mode mode;
            ColorStateList imageTintList = ImageViewCompat.getImageTintList(getCheckboxView$dxeditors_release());
            Drawable checkboxDrawable = getCheckboxDrawable();
            if (checkboxDrawable != null) {
                if (imageTintList != null && imageTintList.getColorForState(getDrawableState(), Constants.getEMPTY_COLOR()) != Constants.getEMPTY_COLOR()) {
                    mode = PorterDuff.Mode.SRC_IN;
                } else {
                    mode = PorterDuff.Mode.DST;
                }
                DrawableCompat.setTintMode(checkboxDrawable, mode);
            }
        }
    }
}
