package com.devexpress.editors.pickers;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.devexpress.dxcore.DXNativeView;
import com.devexpress.editors.DateEdit;
import com.devexpress.editors.DateValue;
import com.devexpress.editors.R;
import com.devexpress.editors.model.Thickness;
import com.devexpress.editors.pickers.providers.DayOfMonthViewProvider;
import com.devexpress.editors.pickers.providers.DayOfWeekViewProvider;
import com.devexpress.editors.pickers.providers.HeaderViewProvider;
import com.devexpress.editors.pickers.providers.MonthViewProvider;
import com.devexpress.editors.pickers.providers.YearViewProvider;
import com.devexpress.editors.pickers.providers.empty.EmptyDayOfMonthViewProvider;
import com.devexpress.editors.pickers.providers.empty.EmptyDayOfWeekViewProvider;
import com.devexpress.editors.pickers.providers.empty.EmptyHeaderViewProvider;
import com.devexpress.editors.pickers.providers.empty.EmptyMonthViewProvider;
import com.devexpress.editors.pickers.providers.empty.EmptyYearViewProvider;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: DateEditPicker.kt */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001f*\u00065[^ad~\u0018\u0000 µ\u00012\u00020\u0001:\u0004µ\u0001¶\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020BH\u0002J\u0012\u0010\u0083\u0001\u001a\u00030\u0081\u00012\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001J\b\u0010\u0086\u0001\u001a\u00030\u0085\u0001J\b\u0010\u0087\u0001\u001a\u00030\u0085\u0001J\u0013\u0010\u0088\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020BH\u0002J\u0016\u0010\u0089\u0001\u001a\u00030\u0085\u00012\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0016J\u0012\u0010\u008c\u0001\u001a\u00030\u0081\u00012\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001J\u0013\u0010\u008d\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u008e\u0001\u001a\u00020\u0007H\u0002J#\u0010\u008f\u0001\u001a\u00030\u0081\u00012\u0006\u0010t\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\u0007\u0010\u0090\u0001\u001a\u00020\u0007H\u0002J8\u0010\u0091\u0001\u001a\u00030\u0081\u00012\b\u0010\u0092\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u00072\u0007\u0010\u0094\u0001\u001a\u00020\u00072\u0007\u0010\u0095\u0001\u001a\u00020\u00072\u0007\u0010\u0096\u0001\u001a\u00020\u0007H\u0014J\u001c\u0010\u0097\u0001\u001a\u00030\u0098\u00012\u0007\u0010\u0099\u0001\u001a\u00020\u00072\u0007\u0010\u009a\u0001\u001a\u00020\u0007H\u0014J\u0013\u0010\u009b\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0090\u0001\u001a\u00020\u0007H\u0002J\n\u0010\u009c\u0001\u001a\u00030\u0081\u0001H\u0002J.\u0010\u009d\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u009e\u0001\u001a\u00020\u00072\u0007\u0010\u009f\u0001\u001a\u00020\u00072\u0007\u0010 \u0001\u001a\u00020\u00072\u0007\u0010¡\u0001\u001a\u00020\u0007H\u0014J\u0013\u0010¢\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0090\u0001\u001a\u00020\u0007H\u0002J\n\u0010£\u0001\u001a\u00030\u0081\u0001H\u0002J\b\u0010¤\u0001\u001a\u00030\u0081\u0001J\n\u0010¥\u0001\u001a\u00030\u0081\u0001H\u0016J\b\u0010¦\u0001\u001a\u00030\u0081\u0001J!\u0010P\u001a\u00030\u0081\u00012\u0006\u0010t\u001a\u00020\u00072\u0007\u0010§\u0001\u001a\u00020\u00072\u0007\u0010¨\u0001\u001a\u00020\u0007J!\u0010S\u001a\u00030\u0081\u00012\u0006\u0010t\u001a\u00020\u00072\u0007\u0010§\u0001\u001a\u00020\u00072\u0007\u0010¨\u0001\u001a\u00020\u0007J.\u0010©\u0001\u001a\u00030\u0081\u00012\u0007\u0010ª\u0001\u001a\u00020\u00072\u0007\u0010«\u0001\u001a\u00020\u00072\u0007\u0010¬\u0001\u001a\u00020\u00072\u0007\u0010\u00ad\u0001\u001a\u00020\u0007H\u0016J,\u0010®\u0001\u001a\u00030\u0081\u00012\u0007\u0010ª\u0001\u001a\u00020\u00072\u0007\u0010«\u0001\u001a\u00020\u00072\u0007\u0010¬\u0001\u001a\u00020\u00072\u0007\u0010\u00ad\u0001\u001a\u00020\u0007J\u0019\u0010¯\u0001\u001a\u00030\u0081\u00012\u0006\u0010t\u001a\u00020\u00072\u0007\u0010§\u0001\u001a\u00020\u0007J\u0011\u0010°\u0001\u001a\u00030\u0081\u00012\u0007\u0010±\u0001\u001a\u00020\u0007J\u0012\u0010²\u0001\u001a\u00030\u0081\u00012\u0006\u0010o\u001a\u00020pH\u0002J\b\u0010³\u0001\u001a\u00030\u0081\u0001J\n\u0010´\u0001\u001a\u00030\u0081\u0001H\u0002R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u0010*\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010-R(\u0010.\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u0010 R\u0010\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0004\n\u0002\u00106R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR(\u0010G\u001a\u0004\u0018\u00010\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0014\"\u0004\bI\u0010JR$\u0010K\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010 \"\u0004\bM\u0010\"R\u001e\u0010O\u001a\u00020N2\u0006\u0010\u001d\u001a\u00020N@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bP\u0010QR\u001e\u0010R\u001a\u00020N2\u0006\u0010\u001d\u001a\u00020N@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bS\u0010QR\u0014\u0010T\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bU\u0010 R(\u0010V\u001a\u0004\u0018\u00010\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0018\"\u0004\bX\u0010YR\u0010\u0010Z\u001a\u00020[X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\\R\u0010\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0004\n\u0002\u0010_R\u0010\u0010`\u001a\u00020aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010bR\u0010\u0010c\u001a\u00020dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010eR$\u0010f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010 \"\u0004\bh\u0010\"R\u0014\u0010i\u001a\u00020jX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010lR\u000e\u0010m\u001a\u00020nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020pX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010q\u001a\b\u0012\u0004\u0012\u00020p0rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010sR\u0014\u0010t\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bu\u0010 R$\u0010v\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010 \"\u0004\bx\u0010\"R(\u0010y\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u001c\"\u0004\b{\u0010|R\u0010\u0010}\u001a\u00020~X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u007f¨\u0006·\u0001"}, d2 = {"Lcom/devexpress/editors/pickers/DateEditPicker;", "Lcom/devexpress/dxcore/DXNativeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actualDayOfMonthViewProvider", "Lcom/devexpress/editors/pickers/providers/DayOfMonthViewProvider;", "getActualDayOfMonthViewProvider", "()Lcom/devexpress/editors/pickers/providers/DayOfMonthViewProvider;", "actualDayOfWeekViewProvider", "Lcom/devexpress/editors/pickers/providers/DayOfWeekViewProvider;", "getActualDayOfWeekViewProvider", "()Lcom/devexpress/editors/pickers/providers/DayOfWeekViewProvider;", "actualHeaderViewProvider", "Lcom/devexpress/editors/pickers/providers/HeaderViewProvider;", "getActualHeaderViewProvider", "()Lcom/devexpress/editors/pickers/providers/HeaderViewProvider;", "actualMonthViewProvider", "Lcom/devexpress/editors/pickers/providers/MonthViewProvider;", "getActualMonthViewProvider", "()Lcom/devexpress/editors/pickers/providers/MonthViewProvider;", "actualYearViewProvider", "Lcom/devexpress/editors/pickers/providers/YearViewProvider;", "getActualYearViewProvider", "()Lcom/devexpress/editors/pickers/providers/YearViewProvider;", "value", "cellMinSize", "getCellMinSize", "()I", "setCellMinSize", "(I)V", "currentOffset", "dateEditPickerListener", "Lcom/devexpress/editors/pickers/DateEditPicker$DateEditPickerListener;", "getDateEditPickerListener", "()Lcom/devexpress/editors/pickers/DateEditPicker$DateEditPickerListener;", "setDateEditPickerListener", "(Lcom/devexpress/editors/pickers/DateEditPicker$DateEditPickerListener;)V", "dayOfMonthViewProvider", "getDayOfMonthViewProvider", "setDayOfMonthViewProvider", "(Lcom/devexpress/editors/pickers/providers/DayOfMonthViewProvider;)V", "dayOfWeekViewProvider", "getDayOfWeekViewProvider", "setDayOfWeekViewProvider", "(Lcom/devexpress/editors/pickers/providers/DayOfWeekViewProvider;)V", "decade", "getDecade", "decadeViewsManager", "com/devexpress/editors/pickers/DateEditPicker$decadeViewsManager$1", "Lcom/devexpress/editors/pickers/DateEditPicker$decadeViewsManager$1;", "emptyDayOfMonthViewProvider", "Lcom/devexpress/editors/pickers/providers/empty/EmptyDayOfMonthViewProvider;", "emptyDayOfWeekViewProvider", "Lcom/devexpress/editors/pickers/providers/empty/EmptyDayOfWeekViewProvider;", "emptyHeaderViewProvider", "Lcom/devexpress/editors/pickers/providers/empty/EmptyHeaderViewProvider;", "emptyMonthViewProvider", "Lcom/devexpress/editors/pickers/providers/empty/EmptyMonthViewProvider;", "emptyYearViewProvider", "Lcom/devexpress/editors/pickers/providers/empty/EmptyYearViewProvider;", "headerView", "Landroid/view/View;", "getHeaderView", "()Landroid/view/View;", "setHeaderView", "(Landroid/view/View;)V", "headerViewProvider", "getHeaderViewProvider", "setHeaderViewProvider", "(Lcom/devexpress/editors/pickers/providers/HeaderViewProvider;)V", "horizontalCellsSpacing", "getHorizontalCellsSpacing", "setHorizontalCellsSpacing", "Lcom/devexpress/editors/DateValue;", "maxDate", "setMaxDate", "(Lcom/devexpress/editors/DateValue;)V", "minDate", "setMinDate", "month", "getMonth", "monthViewProvider", "getMonthViewProvider", "setMonthViewProvider", "(Lcom/devexpress/editors/pickers/providers/MonthViewProvider;)V", "monthViewsManager", "com/devexpress/editors/pickers/DateEditPicker$monthViewsManager$1", "Lcom/devexpress/editors/pickers/DateEditPicker$monthViewsManager$1;", "scrollGestureDetector", "com/devexpress/editors/pickers/DateEditPicker$scrollGestureDetector$1", "Lcom/devexpress/editors/pickers/DateEditPicker$scrollGestureDetector$1;", "swipeAnimator", "com/devexpress/editors/pickers/DateEditPicker$swipeAnimator$1", "Lcom/devexpress/editors/pickers/DateEditPicker$swipeAnimator$1;", "velocityTracker", "com/devexpress/editors/pickers/DateEditPicker$velocityTracker$1", "Lcom/devexpress/editors/pickers/DateEditPicker$velocityTracker$1;", "verticalCellsSpacing", "getVerticalCellsSpacing", "setVerticalCellsSpacing", "viewPadding", "Lcom/devexpress/editors/model/Thickness;", "getViewPadding$dxeditors_release", "()Lcom/devexpress/editors/model/Thickness;", "viewState", "Lcom/devexpress/editors/pickers/CalendarViewStates;", "viewsManager", "Lcom/devexpress/editors/pickers/ViewsManager;", "viewsManagerTypes", "", "[Lcom/devexpress/editors/pickers/ViewsManager;", "year", "getYear", "yearMonth", "getYearMonth$dxeditors_release", "setYearMonth$dxeditors_release", "yearViewProvider", "getYearViewProvider", "setYearViewProvider", "(Lcom/devexpress/editors/pickers/providers/YearViewProvider;)V", "yearViewsManager", "com/devexpress/editors/pickers/DateEditPicker$yearViewsManager$1", "Lcom/devexpress/editors/pickers/DateEditPicker$yearViewsManager$1;", "addOrAttachView", "", "view", "backward", "animated", "", "canBackward", "canForward", "detachView", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "forward", "offsetViews", TypedValues.CycleType.S_WAVE_OFFSET, "onDayOfMonthClick", "cellIndex", "onLayout", "changed", "l", "t", "r", "b", "onMeasureCore", "Landroid/util/Size;", "widthMeasureSpec", "heightMeasureSpec", "onMonthClick", "onMonthHeaderClick", "onSizeChanged", "w", "h", "oldw", "oldh", "onYearClick", "onYearHeaderClick", "rebuild", "requestLayout", "resetToDefaultView", "zeroBasedMonth", "dayOfMonth", "setPadding", "left", "top", "right", "bottom", "setViewPadding", "setYearMonth", "switchToViewType", "viewType", "switchToViewsManager", "update", "updateHeader", "Companion", "DateEditPickerListener", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DateEditPicker extends DXNativeView {
    private static final ViewGroup.LayoutParams cellLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    private int cellMinSize;
    private int currentOffset;
    private DateEditPickerListener dateEditPickerListener;
    private DayOfMonthViewProvider dayOfMonthViewProvider;
    private DayOfWeekViewProvider dayOfWeekViewProvider;
    private final DateEditPicker$decadeViewsManager$1 decadeViewsManager;
    private final EmptyDayOfMonthViewProvider emptyDayOfMonthViewProvider;
    private final EmptyDayOfWeekViewProvider emptyDayOfWeekViewProvider;
    private final EmptyHeaderViewProvider emptyHeaderViewProvider;
    private final EmptyMonthViewProvider emptyMonthViewProvider;
    private final EmptyYearViewProvider emptyYearViewProvider;
    private View headerView;
    private HeaderViewProvider headerViewProvider;
    private int horizontalCellsSpacing;
    private DateValue maxDate;
    private DateValue minDate;
    private MonthViewProvider monthViewProvider;
    private final DateEditPicker$monthViewsManager$1 monthViewsManager;
    private final DateEditPicker$scrollGestureDetector$1 scrollGestureDetector;
    private final DateEditPicker$swipeAnimator$1 swipeAnimator;
    private final DateEditPicker$velocityTracker$1 velocityTracker;
    private int verticalCellsSpacing;
    private final Thickness viewPadding;
    private CalendarViewStates viewState;
    private ViewsManager viewsManager;
    private final ViewsManager[] viewsManagerTypes;
    private int yearMonth;
    private YearViewProvider yearViewProvider;
    private final DateEditPicker$yearViewsManager$1 yearViewsManager;

    /* compiled from: DateEditPicker.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J(\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, d2 = {"Lcom/devexpress/editors/pickers/DateEditPicker$DateEditPickerListener;", "", "onActiveViewChanged", "", "picker", "Lcom/devexpress/editors/pickers/DateEditPicker;", "viewType", "", "onDayCellTap", "year", "zeroBasedMonth", "cellIndex", "onDisplayYearMonthChanged", "onSizeChanged", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface DateEditPickerListener {
        void onActiveViewChanged(DateEditPicker picker, int viewType);

        void onDayCellTap(DateEditPicker picker, int year, int zeroBasedMonth, int cellIndex);

        void onDisplayYearMonthChanged(DateEditPicker picker, int year, int zeroBasedMonth);

        void onSizeChanged();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DateEditPicker(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DateEditPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DateEditPicker(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.devexpress.editors.pickers.DateEditPicker$monthViewsManager$1] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.devexpress.editors.pickers.DateEditPicker$yearViewsManager$1] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.devexpress.editors.pickers.DateEditPicker$decadeViewsManager$1] */
    public DateEditPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Calendar calendar = Calendar.getInstance();
        this.yearMonth = (calendar.get(1) * 12) + calendar.get(2);
        this.minDate = DateEdit.INSTANCE.getDEFAULT_START_DATE$dxeditors_release();
        this.maxDate = DateEdit.INSTANCE.getDEFAULT_END_DATE$dxeditors_release();
        this.emptyDayOfWeekViewProvider = new EmptyDayOfWeekViewProvider(context);
        this.emptyDayOfMonthViewProvider = new EmptyDayOfMonthViewProvider(context);
        this.emptyMonthViewProvider = new EmptyMonthViewProvider(context);
        this.emptyYearViewProvider = new EmptyYearViewProvider(context);
        this.emptyHeaderViewProvider = new EmptyHeaderViewProvider(context);
        this.viewState = CalendarViewStates.STATE_MONTH;
        this.cellMinSize = context.getResources().getDimensionPixelSize(R.dimen.date_edit_picker_cell_min_size);
        this.horizontalCellsSpacing = context.getResources().getDimensionPixelSize(R.dimen.date_edit_picker_horizontal_spacing);
        this.verticalCellsSpacing = context.getResources().getDimensionPixelSize(R.dimen.date_edit_picker_vertical_spacing);
        this.viewPadding = new Thickness(this.horizontalCellsSpacing, this.verticalCellsSpacing);
        setClickable(true);
        setClipToPadding(false);
        setClipChildren(false);
        ?? r0 = new ViewsManager() { // from class: com.devexpress.editors.pickers.DateEditPicker$monthViewsManager$1
            private final ViewsUpdater viewsUpdater;

            /* JADX WARN: Type inference failed for: r4v0, types: [com.devexpress.editors.pickers.DateEditPicker$monthViewsManager$1$viewsUpdater$3] */
            /* JADX WARN: Type inference failed for: r5v0, types: [com.devexpress.editors.pickers.DateEditPicker$monthViewsManager$1$viewsUpdater$4] */
            /* JADX WARN: Type inference failed for: r6v0, types: [com.devexpress.editors.pickers.DateEditPicker$monthViewsManager$1$viewsUpdater$5] */
            /* JADX WARN: Type inference failed for: r7v0, types: [com.devexpress.editors.pickers.DateEditPicker$monthViewsManager$1$viewsUpdater$6] */
            /* JADX WARN: Type inference failed for: r8v0, types: [com.devexpress.editors.pickers.DateEditPicker$monthViewsManager$1$viewsUpdater$7] */
            /* JADX WARN: Type inference failed for: r9v0, types: [com.devexpress.editors.pickers.DateEditPicker$monthViewsManager$1$viewsUpdater$8] */
            {
                final DateEditPicker$monthViewsManager$1$viewsUpdater$2 dateEditPicker$monthViewsManager$1$viewsUpdater$2 = new DateEditPicker$monthViewsManager$1$viewsUpdater$2(DateEditPicker.this, this);
                final ?? r4 = new Function1<View, Unit>() { // from class: com.devexpress.editors.pickers.DateEditPicker$monthViewsManager$1$viewsUpdater$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View v) {
                        Intrinsics.checkNotNullParameter(v, "v");
                        DateEditPicker.this.detachView(v);
                    }
                };
                final ?? r5 = new Function1<Integer, View>() { // from class: com.devexpress.editors.pickers.DateEditPicker$monthViewsManager$1$viewsUpdater$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ View invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final View invoke(int i2) {
                        DayOfMonthViewProvider actualDayOfMonthViewProvider;
                        DayOfWeekViewProvider actualDayOfWeekViewProvider;
                        int indexOnPage = getLayoutProvider().indexOnPage(i2);
                        if (indexOnPage < 7) {
                            actualDayOfWeekViewProvider = r2.getActualDayOfWeekViewProvider();
                            return actualDayOfWeekViewProvider.request(indexOnPage);
                        }
                        int yearMonth = r2.getYearMonth() + getLayoutProvider().page(i2);
                        actualDayOfMonthViewProvider = r2.getActualDayOfMonthViewProvider();
                        return actualDayOfMonthViewProvider.request(yearMonth / 12, yearMonth % 12, indexOnPage - 7);
                    }
                };
                final ?? r6 = new Function2<View, Integer, Boolean>() { // from class: com.devexpress.editors.pickers.DateEditPicker$monthViewsManager$1$viewsUpdater$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Boolean invoke(View view, Integer num) {
                        return invoke(view, num.intValue());
                    }

                    public final Boolean invoke(View v, int i2) {
                        DayOfMonthViewProvider actualDayOfMonthViewProvider;
                        boolean check;
                        DayOfWeekViewProvider actualDayOfWeekViewProvider;
                        Intrinsics.checkNotNullParameter(v, "v");
                        int indexOnPage = getLayoutProvider().indexOnPage(i2);
                        if (indexOnPage < 7) {
                            actualDayOfWeekViewProvider = r2.getActualDayOfWeekViewProvider();
                            check = actualDayOfWeekViewProvider.check(v, indexOnPage);
                        } else {
                            int yearMonth = r2.getYearMonth() + getLayoutProvider().page(i2);
                            actualDayOfMonthViewProvider = r2.getActualDayOfMonthViewProvider();
                            check = actualDayOfMonthViewProvider.check(v, yearMonth / 12, yearMonth % 12, indexOnPage - 7);
                        }
                        return Boolean.valueOf(check);
                    }
                };
                final ?? r7 = new Function2<View, Integer, Unit>() { // from class: com.devexpress.editors.pickers.DateEditPicker$monthViewsManager$1$viewsUpdater$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num) {
                        invoke(view, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(View v, int i2) {
                        DayOfMonthViewProvider actualDayOfMonthViewProvider;
                        DayOfWeekViewProvider actualDayOfWeekViewProvider;
                        Intrinsics.checkNotNullParameter(v, "v");
                        int indexOnPage = getLayoutProvider().indexOnPage(i2);
                        if (indexOnPage < 7) {
                            actualDayOfWeekViewProvider = r2.getActualDayOfWeekViewProvider();
                            actualDayOfWeekViewProvider.update(v, indexOnPage);
                        } else {
                            int yearMonth = r2.getYearMonth() + getLayoutProvider().page(i2);
                            actualDayOfMonthViewProvider = r2.getActualDayOfMonthViewProvider();
                            actualDayOfMonthViewProvider.update(v, yearMonth / 12, yearMonth % 12, indexOnPage - 7);
                        }
                        getLayoutProvider().measureCell(v);
                    }
                };
                final ?? r8 = new Function2<View, Integer, Unit>() { // from class: com.devexpress.editors.pickers.DateEditPicker$monthViewsManager$1$viewsUpdater$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num) {
                        invoke(view, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(View v, int i2) {
                        DayOfMonthViewProvider actualDayOfMonthViewProvider;
                        Intrinsics.checkNotNullParameter(v, "v");
                        getLayoutProvider().indexOnPage(i2);
                        actualDayOfMonthViewProvider = r2.getActualDayOfMonthViewProvider();
                        actualDayOfMonthViewProvider.recycle(v);
                    }
                };
                final ?? r9 = new Function1<Integer, Integer>() { // from class: com.devexpress.editors.pickers.DateEditPicker$monthViewsManager$1$viewsUpdater$8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Integer invoke(int i2) {
                        return Integer.valueOf((DateEditPicker.this.getYearMonth() * getLayoutProvider().getCellsOnPage()) + i2);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                };
                this.viewsUpdater = new ViewsUpdater(this, dateEditPicker$monthViewsManager$1$viewsUpdater$2, r4, r5, r6, r7, r8, r9) { // from class: com.devexpress.editors.pickers.DateEditPicker$monthViewsManager$1$viewsUpdater$1
                    final /* synthetic */ DateEditPicker$monthViewsManager$1 this$1;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(dateEditPicker$monthViewsManager$1$viewsUpdater$2, r4, r5, r6, r7, r8, r9);
                    }

                    @Override // com.devexpress.editors.pickers.ViewsUpdater
                    public int viewIndexToCellIndex(int viewIndex) {
                        return viewIndex - (DateEditPicker.this.getYearMonth() * getLayoutProvider().getCellsOnPage());
                    }
                };
            }

            @Override // com.devexpress.editors.pickers.ViewsManager
            public ViewsUpdater getViewsUpdater() {
                return this.viewsUpdater;
            }

            @Override // com.devexpress.editors.pickers.ViewsManager
            public LayoutProvider obtainCellLocationProvider() {
                Size size = new Size(DateEditPicker.this.getWidth(), DateEditPicker.this.getHeight());
                Size size2 = new Size(DateEditPicker.this.getHorizontalCellsSpacing(), DateEditPicker.this.getVerticalCellsSpacing());
                Thickness viewPadding = DateEditPicker.this.getViewPadding();
                View headerView = DateEditPicker.this.getHeaderView();
                Intrinsics.checkNotNull(headerView);
                return new LayoutProvider(7, 7, size, size2, viewPadding, headerView.getMeasuredHeight());
            }

            @Override // com.devexpress.editors.pickers.ViewsManager
            protected void onSwitchToPreviousPage() {
                DateEditPicker.this.setYearMonth$dxeditors_release(r0.getYearMonth() - 1);
            }

            @Override // com.devexpress.editors.pickers.ViewsManager
            protected void onSwitchToNextPage() {
                DateEditPicker dateEditPicker = DateEditPicker.this;
                dateEditPicker.setYearMonth$dxeditors_release(dateEditPicker.getYearMonth() + 1);
            }

            @Override // com.devexpress.editors.pickers.ViewsManager
            public boolean canSwitchToPreviousPage() {
                DateValue dateValue;
                DateValue dateValue2;
                int yearMonth = DateEditPicker.this.getYearMonth();
                dateValue = DateEditPicker.this.minDate;
                int year = dateValue.getYear() * 12;
                dateValue2 = DateEditPicker.this.minDate;
                return yearMonth > year + dateValue2.getMonth();
            }

            @Override // com.devexpress.editors.pickers.ViewsManager
            public boolean canSwitchToNextPage() {
                DateValue dateValue;
                DateValue dateValue2;
                int yearMonth = DateEditPicker.this.getYearMonth();
                dateValue = DateEditPicker.this.maxDate;
                int year = dateValue.getYear() * 12;
                dateValue2 = DateEditPicker.this.maxDate;
                return yearMonth < year + dateValue2.getMonth();
            }
        };
        this.monthViewsManager = r0;
        ?? r2 = new ViewsManager() { // from class: com.devexpress.editors.pickers.DateEditPicker$yearViewsManager$1
            private final ViewsUpdater viewsUpdater;

            /* JADX WARN: Type inference failed for: r4v0, types: [com.devexpress.editors.pickers.DateEditPicker$yearViewsManager$1$viewsUpdater$3] */
            /* JADX WARN: Type inference failed for: r5v0, types: [com.devexpress.editors.pickers.DateEditPicker$yearViewsManager$1$viewsUpdater$4] */
            /* JADX WARN: Type inference failed for: r6v0, types: [com.devexpress.editors.pickers.DateEditPicker$yearViewsManager$1$viewsUpdater$5] */
            /* JADX WARN: Type inference failed for: r7v0, types: [com.devexpress.editors.pickers.DateEditPicker$yearViewsManager$1$viewsUpdater$6] */
            /* JADX WARN: Type inference failed for: r8v0, types: [com.devexpress.editors.pickers.DateEditPicker$yearViewsManager$1$viewsUpdater$7] */
            /* JADX WARN: Type inference failed for: r9v0, types: [com.devexpress.editors.pickers.DateEditPicker$yearViewsManager$1$viewsUpdater$8] */
            {
                final DateEditPicker$yearViewsManager$1$viewsUpdater$2 dateEditPicker$yearViewsManager$1$viewsUpdater$2 = new DateEditPicker$yearViewsManager$1$viewsUpdater$2(DateEditPicker.this, this);
                final ?? r4 = new Function1<View, Unit>() { // from class: com.devexpress.editors.pickers.DateEditPicker$yearViewsManager$1$viewsUpdater$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        DateEditPicker.this.detachView(it);
                    }
                };
                final ?? r5 = new Function1<Integer, View>() { // from class: com.devexpress.editors.pickers.DateEditPicker$yearViewsManager$1$viewsUpdater$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final View invoke(int i2) {
                        MonthViewProvider actualMonthViewProvider;
                        int year;
                        actualMonthViewProvider = DateEditPicker.this.getActualMonthViewProvider();
                        year = DateEditPicker.this.getYear();
                        return actualMonthViewProvider.request(year + getLayoutProvider().page(i2), getLayoutProvider().indexOnPage(i2));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ View invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                };
                final ?? r6 = new Function2<View, Integer, Boolean>() { // from class: com.devexpress.editors.pickers.DateEditPicker$yearViewsManager$1$viewsUpdater$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public final Boolean invoke(View v, int i2) {
                        MonthViewProvider actualMonthViewProvider;
                        int year;
                        Intrinsics.checkNotNullParameter(v, "v");
                        actualMonthViewProvider = DateEditPicker.this.getActualMonthViewProvider();
                        year = DateEditPicker.this.getYear();
                        return Boolean.valueOf(actualMonthViewProvider.check(v, year + getLayoutProvider().page(i2), getLayoutProvider().indexOnPage(i2)));
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Boolean invoke(View view, Integer num) {
                        return invoke(view, num.intValue());
                    }
                };
                final ?? r7 = new Function2<View, Integer, Unit>() { // from class: com.devexpress.editors.pickers.DateEditPicker$yearViewsManager$1$viewsUpdater$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num) {
                        invoke(view, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(View v, int i2) {
                        MonthViewProvider actualMonthViewProvider;
                        int year;
                        Intrinsics.checkNotNullParameter(v, "v");
                        actualMonthViewProvider = DateEditPicker.this.getActualMonthViewProvider();
                        year = DateEditPicker.this.getYear();
                        actualMonthViewProvider.update(v, year + getLayoutProvider().page(i2), getLayoutProvider().indexOnPage(i2));
                        getLayoutProvider().measureCell(v);
                    }
                };
                final ?? r8 = new Function2<View, Integer, Unit>() { // from class: com.devexpress.editors.pickers.DateEditPicker$yearViewsManager$1$viewsUpdater$7
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num) {
                        invoke(view, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(View v, int i2) {
                        MonthViewProvider actualMonthViewProvider;
                        Intrinsics.checkNotNullParameter(v, "v");
                        actualMonthViewProvider = DateEditPicker.this.getActualMonthViewProvider();
                        actualMonthViewProvider.recycle(v);
                    }
                };
                final ?? r9 = new Function1<Integer, Integer>() { // from class: com.devexpress.editors.pickers.DateEditPicker$yearViewsManager$1$viewsUpdater$8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Integer invoke(int i2) {
                        return Integer.valueOf(((DateEditPicker.this.getYearMonth() / 12) * getLayoutProvider().getCellsOnPage()) + i2);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                };
                this.viewsUpdater = new ViewsUpdater(this, dateEditPicker$yearViewsManager$1$viewsUpdater$2, r4, r5, r6, r7, r8, r9) { // from class: com.devexpress.editors.pickers.DateEditPicker$yearViewsManager$1$viewsUpdater$1
                    final /* synthetic */ DateEditPicker$yearViewsManager$1 this$1;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(dateEditPicker$yearViewsManager$1$viewsUpdater$2, r4, r5, r6, r7, r8, r9);
                    }

                    @Override // com.devexpress.editors.pickers.ViewsUpdater
                    public int viewIndexToCellIndex(int viewIndex) {
                        return viewIndex - ((DateEditPicker.this.getYearMonth() / 12) * getLayoutProvider().getCellsOnPage());
                    }
                };
            }

            @Override // com.devexpress.editors.pickers.ViewsManager
            public ViewsUpdater getViewsUpdater() {
                return this.viewsUpdater;
            }

            @Override // com.devexpress.editors.pickers.ViewsManager
            public LayoutProvider obtainCellLocationProvider() {
                Size size = new Size(DateEditPicker.this.getWidth(), DateEditPicker.this.getHeight());
                Size size2 = new Size(DateEditPicker.this.getHorizontalCellsSpacing(), DateEditPicker.this.getVerticalCellsSpacing());
                Thickness viewPadding = DateEditPicker.this.getViewPadding();
                View headerView = DateEditPicker.this.getHeaderView();
                Intrinsics.checkNotNull(headerView);
                return new LayoutProvider(4, 3, size, size2, viewPadding, headerView.getMeasuredHeight());
            }

            @Override // com.devexpress.editors.pickers.ViewsManager
            protected void onSwitchToPreviousPage() {
                DateEditPicker.this.setYearMonth$dxeditors_release(r0.getYearMonth() - 12);
            }

            @Override // com.devexpress.editors.pickers.ViewsManager
            protected void onSwitchToNextPage() {
                DateEditPicker dateEditPicker = DateEditPicker.this;
                dateEditPicker.setYearMonth$dxeditors_release(dateEditPicker.getYearMonth() + 12);
            }

            @Override // com.devexpress.editors.pickers.ViewsManager
            public boolean canSwitchToPreviousPage() {
                int year;
                DateValue dateValue;
                year = DateEditPicker.this.getYear();
                dateValue = DateEditPicker.this.minDate;
                return year > dateValue.getYear();
            }

            @Override // com.devexpress.editors.pickers.ViewsManager
            public boolean canSwitchToNextPage() {
                int year;
                DateValue dateValue;
                year = DateEditPicker.this.getYear();
                dateValue = DateEditPicker.this.maxDate;
                return year < dateValue.getYear();
            }
        };
        this.yearViewsManager = r2;
        ?? r3 = new ViewsManager() { // from class: com.devexpress.editors.pickers.DateEditPicker$decadeViewsManager$1
            private final ViewsUpdater viewsUpdater;

            /* JADX WARN: Type inference failed for: r4v0, types: [com.devexpress.editors.pickers.DateEditPicker$decadeViewsManager$1$viewsUpdater$3] */
            /* JADX WARN: Type inference failed for: r5v0, types: [com.devexpress.editors.pickers.DateEditPicker$decadeViewsManager$1$viewsUpdater$4] */
            /* JADX WARN: Type inference failed for: r6v0, types: [com.devexpress.editors.pickers.DateEditPicker$decadeViewsManager$1$viewsUpdater$5] */
            /* JADX WARN: Type inference failed for: r7v0, types: [com.devexpress.editors.pickers.DateEditPicker$decadeViewsManager$1$viewsUpdater$6] */
            /* JADX WARN: Type inference failed for: r8v0, types: [com.devexpress.editors.pickers.DateEditPicker$decadeViewsManager$1$viewsUpdater$7] */
            /* JADX WARN: Type inference failed for: r9v0, types: [com.devexpress.editors.pickers.DateEditPicker$decadeViewsManager$1$viewsUpdater$8] */
            {
                final DateEditPicker$decadeViewsManager$1$viewsUpdater$2 dateEditPicker$decadeViewsManager$1$viewsUpdater$2 = new DateEditPicker$decadeViewsManager$1$viewsUpdater$2(DateEditPicker.this, this);
                final ?? r4 = new Function1<View, Unit>() { // from class: com.devexpress.editors.pickers.DateEditPicker$decadeViewsManager$1$viewsUpdater$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        DateEditPicker.this.detachView(it);
                    }
                };
                final ?? r5 = new Function1<Integer, View>() { // from class: com.devexpress.editors.pickers.DateEditPicker$decadeViewsManager$1$viewsUpdater$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final View invoke(int i2) {
                        YearViewProvider actualYearViewProvider;
                        int decade;
                        actualYearViewProvider = DateEditPicker.this.getActualYearViewProvider();
                        decade = DateEditPicker.this.getDecade();
                        return actualYearViewProvider.request(decade + getLayoutProvider().page(i2), getLayoutProvider().indexOnPage(i2));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ View invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                };
                final ?? r6 = new Function2<View, Integer, Boolean>() { // from class: com.devexpress.editors.pickers.DateEditPicker$decadeViewsManager$1$viewsUpdater$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public final Boolean invoke(View v, int i2) {
                        YearViewProvider actualYearViewProvider;
                        int decade;
                        Intrinsics.checkNotNullParameter(v, "v");
                        actualYearViewProvider = DateEditPicker.this.getActualYearViewProvider();
                        decade = DateEditPicker.this.getDecade();
                        return Boolean.valueOf(actualYearViewProvider.check(v, decade + getLayoutProvider().page(i2), getLayoutProvider().indexOnPage(i2)));
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Boolean invoke(View view, Integer num) {
                        return invoke(view, num.intValue());
                    }
                };
                final ?? r7 = new Function2<View, Integer, Unit>() { // from class: com.devexpress.editors.pickers.DateEditPicker$decadeViewsManager$1$viewsUpdater$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num) {
                        invoke(view, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(View v, int i2) {
                        YearViewProvider actualYearViewProvider;
                        int decade;
                        Intrinsics.checkNotNullParameter(v, "v");
                        actualYearViewProvider = DateEditPicker.this.getActualYearViewProvider();
                        decade = DateEditPicker.this.getDecade();
                        actualYearViewProvider.update(v, decade + getLayoutProvider().page(i2), getLayoutProvider().indexOnPage(i2));
                        getLayoutProvider().measureCell(v);
                    }
                };
                final ?? r8 = new Function2<View, Integer, Unit>() { // from class: com.devexpress.editors.pickers.DateEditPicker$decadeViewsManager$1$viewsUpdater$7
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num) {
                        invoke(view, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(View v, int i2) {
                        YearViewProvider actualYearViewProvider;
                        Intrinsics.checkNotNullParameter(v, "v");
                        actualYearViewProvider = DateEditPicker.this.getActualYearViewProvider();
                        actualYearViewProvider.recycle(v);
                    }
                };
                final ?? r9 = new Function1<Integer, Integer>() { // from class: com.devexpress.editors.pickers.DateEditPicker$decadeViewsManager$1$viewsUpdater$8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Integer invoke(int i2) {
                        return Integer.valueOf(((DateEditPicker.this.getYearMonth() / 120) * getLayoutProvider().getCellsOnPage()) + i2);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                };
                this.viewsUpdater = new ViewsUpdater(this, dateEditPicker$decadeViewsManager$1$viewsUpdater$2, r4, r5, r6, r7, r8, r9) { // from class: com.devexpress.editors.pickers.DateEditPicker$decadeViewsManager$1$viewsUpdater$1
                    final /* synthetic */ DateEditPicker$decadeViewsManager$1 this$1;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(dateEditPicker$decadeViewsManager$1$viewsUpdater$2, r4, r5, r6, r7, r8, r9);
                    }

                    @Override // com.devexpress.editors.pickers.ViewsUpdater
                    public int viewIndexToCellIndex(int viewIndex) {
                        return viewIndex - ((DateEditPicker.this.getYearMonth() / 120) * getLayoutProvider().getCellsOnPage());
                    }
                };
            }

            @Override // com.devexpress.editors.pickers.ViewsManager
            public ViewsUpdater getViewsUpdater() {
                return this.viewsUpdater;
            }

            @Override // com.devexpress.editors.pickers.ViewsManager
            public LayoutProvider obtainCellLocationProvider() {
                Size size = new Size(DateEditPicker.this.getWidth(), DateEditPicker.this.getHeight());
                Size size2 = new Size(DateEditPicker.this.getHorizontalCellsSpacing(), DateEditPicker.this.getVerticalCellsSpacing());
                Thickness viewPadding = DateEditPicker.this.getViewPadding();
                View headerView = DateEditPicker.this.getHeaderView();
                Intrinsics.checkNotNull(headerView);
                return new LayoutProvider(4, 3, size, size2, viewPadding, headerView.getMeasuredHeight());
            }

            @Override // com.devexpress.editors.pickers.ViewsManager
            protected void onSwitchToPreviousPage() {
                DateEditPicker.this.setYearMonth$dxeditors_release(r0.getYearMonth() - 120);
            }

            @Override // com.devexpress.editors.pickers.ViewsManager
            protected void onSwitchToNextPage() {
                DateEditPicker dateEditPicker = DateEditPicker.this;
                dateEditPicker.setYearMonth$dxeditors_release(dateEditPicker.getYearMonth() + 120);
            }

            @Override // com.devexpress.editors.pickers.ViewsManager
            public boolean canSwitchToPreviousPage() {
                int decade;
                DateValue dateValue;
                decade = DateEditPicker.this.getDecade();
                dateValue = DateEditPicker.this.minDate;
                return decade > dateValue.getYear() / 10;
            }

            @Override // com.devexpress.editors.pickers.ViewsManager
            public boolean canSwitchToNextPage() {
                int decade;
                DateValue dateValue;
                decade = DateEditPicker.this.getDecade();
                dateValue = DateEditPicker.this.maxDate;
                return decade < dateValue.getYear() / 10;
            }
        };
        this.decadeViewsManager = r3;
        this.viewsManager = (ViewsManager) r0;
        final DateEditPicker$swipeAnimator$1 dateEditPicker$swipeAnimator$1 = new DateEditPicker$swipeAnimator$1(this);
        dateEditPicker$swipeAnimator$1.setFloatValues(0.0f, 1.0f);
        dateEditPicker$swipeAnimator$1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.devexpress.editors.pickers.DateEditPicker$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DateEditPicker.swipeAnimator$lambda$2$lambda$1(DateEditPicker$swipeAnimator$1.this, this, valueAnimator);
            }
        });
        dateEditPicker$swipeAnimator$1.addListener(new Animator.AnimatorListener() { // from class: com.devexpress.editors.pickers.DateEditPicker$swipeAnimator$2$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                DateEditPicker$swipeAnimator$1.this.getEndAnimationAction().invoke();
                this.offsetViews(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                DateEditPicker$swipeAnimator$1.this.getEndAnimationAction().invoke();
                this.offsetViews(0);
            }
        });
        this.swipeAnimator = dateEditPicker$swipeAnimator$1;
        this.velocityTracker = new DateEditPicker$velocityTracker$1();
        this.scrollGestureDetector = new DateEditPicker$scrollGestureDetector$1(context, this);
        this.viewsManagerTypes = new ViewsManager[]{r0, r2, r3};
    }

    /* renamed from: getYearMonth$dxeditors_release, reason: from getter */
    public final int getYearMonth() {
        return this.yearMonth;
    }

    public final void setYearMonth$dxeditors_release(int i) {
        if (this.yearMonth != i) {
            this.yearMonth = RangesKt.coerceIn(i, 12, 119988);
            DateEditPickerListener dateEditPickerListener = this.dateEditPickerListener;
            if (dateEditPickerListener != null) {
                dateEditPickerListener.onDisplayYearMonthChanged(this, getYear(), getMonth());
            }
        }
    }

    private final int getMonth() {
        return this.yearMonth % 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getYear() {
        return this.yearMonth / 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getDecade() {
        return this.yearMonth / 120;
    }

    private final void setMinDate(DateValue dateValue) {
        if (Intrinsics.areEqual(this.minDate, dateValue)) {
            return;
        }
        this.minDate = dateValue;
        update();
    }

    private final void setMaxDate(DateValue dateValue) {
        if (Intrinsics.areEqual(this.maxDate, dateValue)) {
            return;
        }
        this.maxDate = dateValue;
        update();
    }

    public final void setYearMonth(int year, int zeroBasedMonth) {
        int i = (year * 12) + zeroBasedMonth;
        if (this.yearMonth != i) {
            setYearMonth$dxeditors_release(i);
            this.viewsManager.recycle();
        }
        this.viewsManager.update();
        requestLayout();
    }

    public final DayOfWeekViewProvider getDayOfWeekViewProvider() {
        return this.dayOfWeekViewProvider;
    }

    public final void setDayOfWeekViewProvider(DayOfWeekViewProvider dayOfWeekViewProvider) {
        this.dayOfWeekViewProvider = dayOfWeekViewProvider;
        this.viewsManager.update();
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DayOfWeekViewProvider getActualDayOfWeekViewProvider() {
        DayOfWeekViewProvider dayOfWeekViewProvider = this.dayOfWeekViewProvider;
        return dayOfWeekViewProvider == null ? this.emptyDayOfWeekViewProvider : dayOfWeekViewProvider;
    }

    public final DayOfMonthViewProvider getDayOfMonthViewProvider() {
        return this.dayOfMonthViewProvider;
    }

    public final void setDayOfMonthViewProvider(DayOfMonthViewProvider dayOfMonthViewProvider) {
        this.dayOfMonthViewProvider = dayOfMonthViewProvider;
        this.viewsManager.update();
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DayOfMonthViewProvider getActualDayOfMonthViewProvider() {
        DayOfMonthViewProvider dayOfMonthViewProvider = this.dayOfMonthViewProvider;
        return dayOfMonthViewProvider == null ? this.emptyDayOfMonthViewProvider : dayOfMonthViewProvider;
    }

    public final MonthViewProvider getMonthViewProvider() {
        return this.monthViewProvider;
    }

    public final void setMonthViewProvider(MonthViewProvider monthViewProvider) {
        this.monthViewProvider = monthViewProvider;
        this.viewsManager.update();
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MonthViewProvider getActualMonthViewProvider() {
        MonthViewProvider monthViewProvider = this.monthViewProvider;
        return monthViewProvider == null ? this.emptyMonthViewProvider : monthViewProvider;
    }

    public final YearViewProvider getYearViewProvider() {
        return this.yearViewProvider;
    }

    public final void setYearViewProvider(YearViewProvider yearViewProvider) {
        this.yearViewProvider = yearViewProvider;
        this.viewsManager.update();
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final YearViewProvider getActualYearViewProvider() {
        YearViewProvider yearViewProvider = this.yearViewProvider;
        return yearViewProvider == null ? this.emptyYearViewProvider : yearViewProvider;
    }

    public final HeaderViewProvider getHeaderViewProvider() {
        return this.headerViewProvider;
    }

    public final void setHeaderViewProvider(HeaderViewProvider headerViewProvider) {
        this.headerViewProvider = headerViewProvider;
        this.viewsManager.update();
        requestLayout();
    }

    private final HeaderViewProvider getActualHeaderViewProvider() {
        HeaderViewProvider headerViewProvider = this.headerViewProvider;
        return headerViewProvider == null ? this.emptyHeaderViewProvider : headerViewProvider;
    }

    public final void setMinDate(int year, int zeroBasedMonth, int dayOfMonth) {
        setMinDate(new DateValue(year, zeroBasedMonth, dayOfMonth));
    }

    public final void setMaxDate(int year, int zeroBasedMonth, int dayOfMonth) {
        setMaxDate(new DateValue(year, zeroBasedMonth, dayOfMonth));
    }

    public final DateEditPickerListener getDateEditPickerListener() {
        return this.dateEditPickerListener;
    }

    public final void setDateEditPickerListener(DateEditPickerListener dateEditPickerListener) {
        this.dateEditPickerListener = dateEditPickerListener;
    }

    public final int getCellMinSize() {
        return this.cellMinSize;
    }

    public final void setCellMinSize(int i) {
        if (this.cellMinSize != i) {
            this.cellMinSize = i;
            this.viewsManager.invalidateLayoutCache();
            requestLayout();
        }
    }

    public final int getHorizontalCellsSpacing() {
        return this.horizontalCellsSpacing;
    }

    public final void setHorizontalCellsSpacing(int i) {
        if (this.horizontalCellsSpacing != i) {
            this.horizontalCellsSpacing = i;
            this.viewsManager.invalidateLayoutCache();
            requestLayout();
        }
    }

    public final int getVerticalCellsSpacing() {
        return this.verticalCellsSpacing;
    }

    public final void setVerticalCellsSpacing(int i) {
        if (this.verticalCellsSpacing != i) {
            this.verticalCellsSpacing = i;
            this.viewsManager.invalidateLayoutCache();
            requestLayout();
        }
    }

    /* renamed from: getViewPadding$dxeditors_release, reason: from getter */
    public final Thickness getViewPadding() {
        return this.viewPadding;
    }

    public final View getHeaderView() {
        return this.headerView;
    }

    public final void setHeaderView(View view) {
        this.headerView = view;
    }

    public final boolean canForward() {
        return this.viewsManager.canSwitchToNextPage();
    }

    public final void forward(boolean animated) {
        if (canForward()) {
            if (animated) {
                this.swipeAnimator.startTo(-getWidth(), new Function0<Unit>() { // from class: com.devexpress.editors.pickers.DateEditPicker$forward$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ViewsManager viewsManager;
                        viewsManager = DateEditPicker.this.viewsManager;
                        viewsManager.switchToNextPage();
                    }
                });
            } else {
                this.viewsManager.switchToNextPage();
            }
        }
    }

    public final boolean canBackward() {
        return this.viewsManager.canSwitchToPreviousPage();
    }

    public final void backward(boolean animated) {
        if (canBackward()) {
            if (animated) {
                this.swipeAnimator.startTo(getWidth(), new Function0<Unit>() { // from class: com.devexpress.editors.pickers.DateEditPicker$backward$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ViewsManager viewsManager;
                        viewsManager = DateEditPicker.this.viewsManager;
                        viewsManager.switchToPreviousPage();
                    }
                });
            } else {
                this.viewsManager.switchToPreviousPage();
            }
        }
    }

    public final void setViewPadding(int left, int top, int right, int bottom) {
        this.viewPadding.set(left, top, right, bottom);
        this.viewsManager.invalidateLayoutCache();
        requestLayout();
    }

    @Override // android.view.View
    public void setPadding(int left, int top, int right, int bottom) {
        this.viewsManager.invalidateLayoutCache();
        super.setPadding(left, top, right, bottom);
    }

    private final void updateHeader() {
        if (this.headerView != null) {
            HeaderViewProvider actualHeaderViewProvider = getActualHeaderViewProvider();
            View view = this.headerView;
            Intrinsics.checkNotNull(view);
            if (actualHeaderViewProvider.check(view, getDecade(), getYear(), getMonth(), this.viewState)) {
                HeaderViewProvider actualHeaderViewProvider2 = getActualHeaderViewProvider();
                View view2 = this.headerView;
                Intrinsics.checkNotNull(view2);
                actualHeaderViewProvider2.update(view2, getDecade(), getYear(), getMonth(), this.viewState);
                return;
            }
        }
        View request = getActualHeaderViewProvider().request(getDecade(), getYear(), getMonth(), this.viewState);
        if (!Intrinsics.areEqual(this.headerView, request)) {
            if (this.headerView != null) {
                HeaderViewProvider actualHeaderViewProvider3 = getActualHeaderViewProvider();
                View view3 = this.headerView;
                Intrinsics.checkNotNull(view3);
                actualHeaderViewProvider3.recycle(view3, this.viewState);
                removeView(this.headerView);
            }
            this.headerView = request;
            addView(request);
        }
        HeaderViewProvider actualHeaderViewProvider4 = getActualHeaderViewProvider();
        View view4 = this.headerView;
        Intrinsics.checkNotNull(view4);
        actualHeaderViewProvider4.update(view4, getDecade(), getYear(), getMonth(), this.viewState);
    }

    @Override // com.devexpress.dxcore.DXNativeView
    protected Size onMeasureCore(int widthMeasureSpec, int heightMeasureSpec) {
        updateHeader();
        View view = this.headerView;
        Intrinsics.checkNotNull(view);
        view.measure(widthMeasureSpec, heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        if (mode == 0) {
            size = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        int horizontal = size - this.viewPadding.getHorizontal();
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (mode2 == 0) {
            size2 = getContext().getResources().getDisplayMetrics().heightPixels;
        }
        int vertical = size2 - this.viewPadding.getVertical();
        int i = this.cellMinSize;
        if (i < 0) {
            View view2 = this.headerView;
            Intrinsics.checkNotNull(view2);
            int min = Math.min(horizontal, vertical - view2.getMeasuredHeight());
            i = Math.min(Math.max(0, (min - (this.horizontalCellsSpacing * 6)) / 7), Math.max(0, (min - (this.verticalCellsSpacing * 6)) / 7));
        }
        int i2 = i * 7;
        int horizontal2 = this.viewPadding.getHorizontal() + i2 + (this.horizontalCellsSpacing * 6);
        int vertical2 = i2 + this.viewPadding.getVertical() + (this.verticalCellsSpacing * 6);
        View view3 = this.headerView;
        Intrinsics.checkNotNull(view3);
        int measuredHeight = vertical2 + view3.getMeasuredHeight();
        if (mode != 0) {
            if (mode == 1073741824) {
                horizontal2 = View.MeasureSpec.getSize(widthMeasureSpec);
            } else {
                horizontal2 = Math.min(horizontal2, View.MeasureSpec.getSize(widthMeasureSpec));
            }
        }
        if (mode2 != 0) {
            if (mode2 == 1073741824) {
                measuredHeight = View.MeasureSpec.getSize(heightMeasureSpec);
            } else {
                measuredHeight = Math.min(measuredHeight, View.MeasureSpec.getSize(heightMeasureSpec));
            }
        }
        return new Size(horizontal2, measuredHeight);
    }

    public final void update() {
        updateHeader();
        this.viewsManager.update();
    }

    public final void rebuild() {
        this.viewsManager.invalidateLayoutCache();
        update();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        invalidateLayoutCache();
        invalidateLayoutCache();
        invalidateLayoutCache();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.viewsManager.invalidateLayoutCache();
        this.viewsManager.layout(this.currentOffset);
        View view = this.headerView;
        Intrinsics.checkNotNull(view);
        int i = r - l;
        View view2 = this.headerView;
        Intrinsics.checkNotNull(view2);
        view.layout(0, 0, i, view2.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void swipeAnimator$lambda$2$lambda$1(DateEditPicker$swipeAnimator$1 this_apply, DateEditPicker this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = this_apply.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.offsetViews((int) (((this_apply.getEndOffset() - this_apply.getStartOffset()) * ((Float) animatedValue).floatValue()) + this_apply.getStartOffset()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void offsetViews(int offset) {
        this.currentOffset = offset;
        this.viewsManager.layout(offset);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev != null && this.scrollGestureDetector.processEvent(ev)) {
            return true;
        }
        super.dispatchTouchEvent(ev);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addOrAttachView(View view) {
        addViewInLayout(view, -1, cellLayoutParams, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void detachView(View view) {
        removeViewInLayout(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDayOfMonthClick(int year, int month, int cellIndex) {
        DateEditPickerListener dateEditPickerListener = this.dateEditPickerListener;
        if (dateEditPickerListener != null) {
            dateEditPickerListener.onDayCellTap(this, year, month, cellIndex);
        }
    }

    private final void switchToViewsManager(ViewsManager viewsManager) {
        CalendarViewStates calendarViewStates;
        if (this.swipeAnimator.isRunning()) {
            this.swipeAnimator.end();
        }
        if (!Intrinsics.areEqual(this.viewsManager, viewsManager)) {
            int indexOf = ArraysKt.indexOf(this.viewsManagerTypes, viewsManager);
            if (indexOf == 0) {
                calendarViewStates = CalendarViewStates.STATE_MONTH;
            } else if (indexOf == 1) {
                calendarViewStates = CalendarViewStates.STATE_YEAR;
            } else {
                calendarViewStates = CalendarViewStates.STATE_DECADE;
            }
            this.viewState = calendarViewStates;
            this.viewsManager.hide();
            this.viewsManager = viewsManager;
            viewsManager.show();
            DateEditPickerListener dateEditPickerListener = this.dateEditPickerListener;
            if (dateEditPickerListener != null) {
                dateEditPickerListener.onActiveViewChanged(this, ArraysKt.indexOf(this.viewsManagerTypes, viewsManager));
            }
        }
        requestLayout();
    }

    public final void switchToViewType(int viewType) {
        switchToViewsManager(this.viewsManagerTypes[viewType]);
    }

    public final void resetToDefaultView() {
        switchToViewsManager(this.monthViewsManager);
        this.viewsManager.layout(this.currentOffset);
        this.viewsManager.update();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        DateEditPickerListener dateEditPickerListener = this.dateEditPickerListener;
        if (dateEditPickerListener != null) {
            dateEditPickerListener.onSizeChanged();
        }
    }

    private final void onMonthHeaderClick() {
        switchToViewsManager(this.yearViewsManager);
        this.viewsManager.layout(this.currentOffset);
        this.viewsManager.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onMonthClick(int cellIndex) {
        switchToViewsManager(this.monthViewsManager);
        setYearMonth$dxeditors_release((getYear() * 12) + cellIndex);
        this.viewsManager.layout(this.currentOffset);
        this.viewsManager.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onYearClick(int cellIndex) {
        switchToViewsManager(this.yearViewsManager);
        setYearMonth$dxeditors_release(((((getDecade() + CalendarMath.INSTANCE.div(cellIndex, 12)) * 10) + CalendarMath.INSTANCE.mod(cellIndex, 12)) * 12) + getMonth());
        this.viewsManager.layout(this.currentOffset);
        this.viewsManager.update();
    }

    private final void onYearHeaderClick() {
        switchToViewsManager(this.decadeViewsManager);
        this.viewsManager.layout(this.currentOffset);
        this.viewsManager.update();
    }
}
