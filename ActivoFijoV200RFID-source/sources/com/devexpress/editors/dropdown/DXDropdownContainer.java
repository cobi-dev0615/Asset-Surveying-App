package com.devexpress.editors.dropdown;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import com.devexpress.editors.dropdown.DXDropdownContainer;
import com.devexpress.editors.dropdown.placement.PlacementStrategy;
import com.devexpress.editors.dropdown.utils.Offset;
import com.devexpress.editors.dropdown.utils.Rectangle;
import com.devexpress.editors.utils.Utils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: DXDropdownContainer.kt */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u0000 ç\u00012\u00020\u0001:\u0018å\u0001æ\u0001ç\u0001è\u0001é\u0001ê\u0001ë\u0001ì\u0001í\u0001î\u0001ï\u0001ð\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010¼\u0001\u001a\u00030½\u0001H\u0002J\n\u0010¾\u0001\u001a\u00030½\u0001H\u0002J\n\u0010¿\u0001\u001a\u00030½\u0001H\u0002J\n\u0010À\u0001\u001a\u00030½\u0001H\u0002J\t\u0010Á\u0001\u001a\u00020\u0010H\u0002J\n\u0010Â\u0001\u001a\u00030½\u0001H\u0002J\u0013\u0010Ã\u0001\u001a\u00030½\u00012\u0007\u0010Ä\u0001\u001a\u00020\u0010H\u0002J\t\u0010Å\u0001\u001a\u00020\u0006H\u0002J\n\u0010Æ\u0001\u001a\u00030½\u0001H\u0002J\u0016\u0010Ç\u0001\u001a\u0005\u0018\u00010È\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\t\u0010É\u0001\u001a\u00020\u0010H\u0002J\t\u0010Ê\u0001\u001a\u00020VH\u0002J\t\u0010Ë\u0001\u001a\u00020VH\u0002J\u0015\u0010Ì\u0001\u001a\u0004\u0018\u00010I2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\t\u0010Í\u0001\u001a\u00020+H\u0002J\u0016\u0010Î\u0001\u001a\u0005\u0018\u00010Ï\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\n\u0010Ð\u0001\u001a\u00030½\u0001H\u0002J\n\u0010Ñ\u0001\u001a\u00030½\u0001H\u0002J\n\u0010Ò\u0001\u001a\u00030½\u0001H\u0002J\n\u0010Ó\u0001\u001a\u00030½\u0001H\u0002J\n\u0010Ô\u0001\u001a\u00030½\u0001H\u0002J\n\u0010Õ\u0001\u001a\u00030½\u0001H\u0002J\n\u0010Ö\u0001\u001a\u00030½\u0001H\u0002J\n\u0010×\u0001\u001a\u00030½\u0001H\u0002J\t\u0010Ø\u0001\u001a\u00020\u0006H\u0002J\t\u0010Ù\u0001\u001a\u00020\u0006H\u0002J\n\u0010Ú\u0001\u001a\u00030½\u0001H\u0002J\n\u0010Û\u0001\u001a\u00030½\u0001H\u0002J\u001c\u0010Ü\u0001\u001a\u00030½\u00012\u0007\u0010Ý\u0001\u001a\u00020\u00062\u0007\u0010Þ\u0001\u001a\u00020\u0006H\u0002J\n\u0010ß\u0001\u001a\u00030½\u0001H\u0002J\b\u0010à\u0001\u001a\u00030½\u0001J\n\u0010á\u0001\u001a\u00030½\u0001H\u0002J\b\u0010â\u0001\u001a\u00030½\u0001J\b\u0010ã\u0001\u001a\u00030½\u0001J\n\u0010ä\u0001\u001a\u00030½\u0001H\u0002R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0012\u00100\u001a\u000601R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\b\"\u0004\b6\u0010\u0016R\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010?\u001a\u00020>2\u0006\u0010=\u001a\u00020>8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u000e\u0010D\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010G\u001a\u00060HR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010J\u001a\u0004\u0018\u00010I2\b\u0010=\u001a\u0004\u0018\u00010I@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010O\u001a\u00020PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010[\u001a\u00060\\R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010]\u001a\u00060^R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010_\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001a\u0010d\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\b\"\u0004\be\u0010\u0016R$\u0010f\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\b\"\u0004\bg\u0010\u0016R$\u0010h\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bh\u0010\b\"\u0004\bi\u0010\u0016R\u001a\u0010j\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\b\"\u0004\bk\u0010\u0016R\u001a\u0010l\u001a\u00020mX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001a\u0010r\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010-\"\u0004\bt\u0010/R\u001a\u0010u\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010-\"\u0004\bw\u0010/R\u001c\u0010x\u001a\u0004\u0018\u00010yX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u0014\u0010~\u001a\b\u0018\u000101R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u007f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001d\u0010\u0084\u0001\u001a\u00020+X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010-\"\u0005\b\u0086\u0001\u0010/R)\u0010\u0087\u0001\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R+\u0010\u008c\u0001\u001a\u0004\u0018\u00010I2\b\u0010=\u001a\u0004\u0018\u00010I8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008d\u0001\u0010L\"\u0005\b\u008e\u0001\u0010NR\u0014\u0010\u008f\u0001\u001a\u00070\u0090\u0001R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0091\u0001\u001a\u000b\u0012\u0004\u0012\u00020I\u0018\u00010\u0092\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001d\u0010\u0097\u0001\u001a\u00020+X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010-\"\u0005\b\u0099\u0001\u0010/R\u0010\u0010\u009a\u0001\u001a\u00030\u009b\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u009c\u0001\u001a\u00020+X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010-\"\u0005\b\u009e\u0001\u0010/R\u001d\u0010\u009f\u0001\u001a\u00020+X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010-\"\u0005\b¡\u0001\u0010/R\u001d\u0010¢\u0001\u001a\u00020+X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010-\"\u0005\b¤\u0001\u0010/R$\u0010¥\u0001\u001a\u0004\u0018\u00010I2\b\u0010=\u001a\u0004\u0018\u00010I@BX\u0082\u000e¢\u0006\t\n\u0000\"\u0005\b¦\u0001\u0010NR\u001d\u0010§\u0001\u001a\u00020+X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010-\"\u0005\b©\u0001\u0010/R\u001d\u0010ª\u0001\u001a\u00020+X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0001\u0010-\"\u0005\b¬\u0001\u0010/R\u000f\u0010\u00ad\u0001\u001a\u00020mX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010®\u0001\u001a\u00030¯\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b°\u0001\u0010±\u0001\"\u0006\b²\u0001\u0010³\u0001R\u001d\u0010´\u0001\u001a\u00020+X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010-\"\u0005\b¶\u0001\u0010/R\u001f\u0010·\u0001\u001a\u00020\u0012X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¸\u0001\u0010¹\u0001\"\u0006\bº\u0001\u0010»\u0001¨\u0006ñ\u0001"}, d2 = {"Lcom/devexpress/editors/dropdown/DXDropdownContainer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actualAllowScrim", "", "getActualAllowScrim", "()Z", "actualAllowShadow", "getActualAllowShadow", "actualHorizontalAlignment", "Lcom/devexpress/editors/dropdown/DXDropdownHorizontalAlignment;", "actualPlacement", "Lcom/devexpress/editors/dropdown/DXPlacement;", "actualPlacementRect", "Lcom/devexpress/editors/dropdown/utils/Rectangle;", "actualVerticalAlignment", "Lcom/devexpress/editors/dropdown/DXDropdownVerticalAlignment;", "allowAnimation", "getAllowAnimation", "setAllowAnimation", "(Z)V", "allowScrim", "getAllowScrim", "setAllowScrim", "allowShadow", "getAllowShadow", "setAllowShadow", "animationDuration", "", "getAnimationDuration", "()J", "setAnimationDuration", "(J)V", "animationListener", "Lcom/devexpress/editors/dropdown/DXDropdownContainer$DropdownAnimationListener;", "getAnimationListener", "()Lcom/devexpress/editors/dropdown/DXDropdownContainer$DropdownAnimationListener;", "setAnimationListener", "(Lcom/devexpress/editors/dropdown/DXDropdownContainer$DropdownAnimationListener;)V", "availableDisplayFrame", "backgroundColor", "", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "backgroundView", "Lcom/devexpress/editors/dropdown/DXDropdownContainer$DropdownBackgroundView;", "backgroundViewFrame", "blockRequestLayout", "closeOnScrimTap", "getCloseOnScrimTap", "setCloseOnScrimTap", "coerceListener", "Lcom/devexpress/editors/dropdown/DXDropdownContainer$CoerceValueListener;", "getCoerceListener", "()Lcom/devexpress/editors/dropdown/DXDropdownContainer$CoerceValueListener;", "setCoerceListener", "(Lcom/devexpress/editors/dropdown/DXDropdownContainer$CoerceValueListener;)V", "value", "", "contentDescription", "getContentDescription", "()Ljava/lang/CharSequence;", "setContentDescription", "(Ljava/lang/CharSequence;)V", "contentGlobalFrame", "contentLocalFrame", "contentShadowFrame", "contentShadowView", "Lcom/devexpress/editors/dropdown/DXDropdownContainer$DropdownContentShadowView;", "Landroid/view/View;", "contentView", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "cornerRadius", "", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "currentAnimation", "Landroid/animation/Animator;", "density", "dispatcher", "Landroid/os/Handler;", "edgeOffset", "globalLayoutListener", "Lcom/devexpress/editors/dropdown/DXDropdownContainer$GlobalLayoutListener;", "globalScrollChangedLayoutListener", "Lcom/devexpress/editors/dropdown/DXDropdownContainer$GlobalScrollChangedLayoutListener;", "horizontalAlignment", "getHorizontalAlignment", "()Lcom/devexpress/editors/dropdown/DXDropdownHorizontalAlignment;", "setHorizontalAlignment", "(Lcom/devexpress/editors/dropdown/DXDropdownHorizontalAlignment;)V", "isDeferredDropdownResized", "setDeferredDropdownResized", "isDropdownOpen", "setDropdownOpen", "isFocusable", "setFocusable", "isLayoutFixed", "setLayoutFixed", "margin", "Landroid/graphics/Rect;", "getMargin", "()Landroid/graphics/Rect;", "setMargin", "(Landroid/graphics/Rect;)V", "minHeight", "getMinHeight", "setMinHeight", "minWidth", "getMinWidth", "setMinWidth", "onActionlistener", "Lcom/devexpress/editors/dropdown/DXDropdownContainer$DropdownListener;", "getOnActionlistener", "()Lcom/devexpress/editors/dropdown/DXDropdownContainer$DropdownListener;", "setOnActionlistener", "(Lcom/devexpress/editors/dropdown/DXDropdownContainer$DropdownListener;)V", "parentPopupContainer", "placement", "getPlacement", "()Lcom/devexpress/editors/dropdown/DXPlacement;", "setPlacement", "(Lcom/devexpress/editors/dropdown/DXPlacement;)V", "placementHorizontalThreshold", "getPlacementHorizontalThreshold", "setPlacementHorizontalThreshold", "placementRectangle", "getPlacementRectangle", "()Lcom/devexpress/editors/dropdown/utils/Rectangle;", "setPlacementRectangle", "(Lcom/devexpress/editors/dropdown/utils/Rectangle;)V", "placementTarget", "getPlacementTarget", "setPlacementTarget", "placementTargetPositionListener", "Lcom/devexpress/editors/dropdown/DXDropdownContainer$PlacementTargetPositionListener;", "placementTargetWeak", "Ljava/lang/ref/WeakReference;", "getPlacementTargetWeak", "()Ljava/lang/ref/WeakReference;", "setPlacementTargetWeak", "(Ljava/lang/ref/WeakReference;)V", "placementVerticalThreshold", "getPlacementVerticalThreshold", "setPlacementVerticalThreshold", "popupWindow", "Lcom/devexpress/editors/dropdown/DXPopupWindow;", "positionOffset", "getPositionOffset", "setPositionOffset", "positionX", "getPositionX", "setPositionX", "positionY", "getPositionY", "setPositionY", "rootView", "setRootView", "scrimColor", "getScrimColor", "setScrimColor", "shadowColor", "getShadowColor", "setShadowColor", "shadowMargin", "shadowOffset", "Lcom/devexpress/editors/dropdown/utils/Offset;", "getShadowOffset", "()Lcom/devexpress/editors/dropdown/utils/Offset;", "setShadowOffset", "(Lcom/devexpress/editors/dropdown/utils/Offset;)V", "shadowRadius", "getShadowRadius", "setShadowRadius", "verticalAlignment", "getVerticalAlignment", "()Lcom/devexpress/editors/dropdown/DXDropdownVerticalAlignment;", "setVerticalAlignment", "(Lcom/devexpress/editors/dropdown/DXDropdownVerticalAlignment;)V", "calcFrames", "", "calcFramesForFixedPosition", "calcFramesForPlacementTarget", "calcFramesForWindow", "calcPlacementTargetWindowSpace", "calcShadowMargin", "calcVisibleFramesFromContentGlobalFrame", "displayFrame", "canShow", "findRootView", "getActivityFromContext", "Landroid/app/Activity;", "getAvailableDisplayFrame", "getClosingAnimation", "getOpeningAnimation", "getRootViewFromContext", "getTopWindowOffset", "getWindowFromContext", "Landroid/view/Window;", "hide", "onBackgroundViewLayout", "prepareVisual", "raiseClosingAnimationComplete", "raiseClosingAnimationWillStart", "raiseDropdownClosed", "raiseDropdownOpened", "raiseDropdownResized", "raiseDropdownWillClose", "raiseDropdownWillOpen", "raiseOpeningAnimationComplete", "raiseOpeningAnimationWillStart", "recalcFrames", "callForceLayout", "canChangePTPosition", "recalcFramesForPlacementTarget", "releaseResources", "resetFrames", "resizeOpenFrame", "resizeOpenFrameWithPosition", "show", "ClosingAnimationListener", "CoerceValueListener", "Companion", "DropdownAnimationListener", "DropdownBackgroundView", "DropdownContentClipView", "DropdownContentShadowView", "DropdownListener", "GlobalLayoutListener", "GlobalScrollChangedLayoutListener", "OpeningAnimationListener", "PlacementTargetPositionListener", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXDropdownContainer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long DEFAULT_ANIMATION_DURATION_MS = 167;
    public static final float DEFAULT_SHADOW_OFFSET_V_DIP = 6.0f;
    public static final float DEFAULT_SHADOW_OPACITY = 0.37f;
    public static final float DEFAULT_SHADOW_RADIUS_DIP = 7.5f;
    public static final float DEFAULT_VERTICAL_THRESHOLD_DIP = 200.0f;
    public static final int EDGE_OFFSET_DIP = 4;
    public static final int SHADOW_SIZE_MULTIPLIER = 2;
    private DXDropdownHorizontalAlignment actualHorizontalAlignment;
    private DXPlacement actualPlacement;
    private final Rectangle actualPlacementRect;
    private DXDropdownVerticalAlignment actualVerticalAlignment;
    private boolean allowAnimation;
    private boolean allowScrim;
    private boolean allowShadow;
    private long animationDuration;
    private DropdownAnimationListener animationListener;
    private Rectangle availableDisplayFrame;
    private int backgroundColor;
    private final DropdownBackgroundView backgroundView;
    private final Rectangle backgroundViewFrame;
    private boolean blockRequestLayout;
    private boolean closeOnScrimTap;
    private CoerceValueListener coerceListener;
    private final Rectangle contentGlobalFrame;
    private final Rectangle contentLocalFrame;
    private final Rectangle contentShadowFrame;
    private final DropdownContentShadowView contentShadowView;
    private View contentView;
    private final Context context;
    private float cornerRadius;
    private Animator currentAnimation;
    private final float density;
    private final Handler dispatcher;
    private final int edgeOffset;
    private final GlobalLayoutListener globalLayoutListener;
    private final GlobalScrollChangedLayoutListener globalScrollChangedLayoutListener;
    private DXDropdownHorizontalAlignment horizontalAlignment;
    private boolean isDeferredDropdownResized;
    private boolean isDropdownOpen;
    private boolean isLayoutFixed;
    private Rect margin;
    private int minHeight;
    private int minWidth;
    private DropdownListener onActionlistener;
    private DropdownBackgroundView parentPopupContainer;
    private DXPlacement placement;
    private int placementHorizontalThreshold;
    private Rectangle placementRectangle;
    private final PlacementTargetPositionListener placementTargetPositionListener;
    private WeakReference<View> placementTargetWeak;
    private int placementVerticalThreshold;
    private final DXPopupWindow popupWindow;
    private int positionOffset;
    private int positionX;
    private int positionY;
    private View rootView;
    private int scrimColor;
    private int shadowColor;
    private final Rect shadowMargin;
    private Offset shadowOffset;
    private int shadowRadius;
    private DXDropdownVerticalAlignment verticalAlignment;

    /* compiled from: DXDropdownContainer.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/devexpress/editors/dropdown/DXDropdownContainer$CoerceValueListener;", "", "coerceIsDropdownOpen", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface CoerceValueListener {
        void coerceIsDropdownOpen();
    }

    /* compiled from: DXDropdownContainer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/dropdown/DXDropdownContainer$DropdownAnimationListener;", "", "closingAnimationComplete", "", "closingAnimationWillStart", "openingAnimationComplete", "openingAnimationWillStart", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface DropdownAnimationListener {
        void closingAnimationComplete();

        void closingAnimationWillStart();

        void openingAnimationComplete();

        void openingAnimationWillStart();
    }

    /* compiled from: DXDropdownContainer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/devexpress/editors/dropdown/DXDropdownContainer$DropdownListener;", "", "dropdownClosed", "", "dropdownOpened", "dropdownResized", "dropdownWillClose", "", "dropdownWillOpen", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface DropdownListener {
        void dropdownClosed();

        void dropdownOpened();

        void dropdownResized();

        boolean dropdownWillClose();

        boolean dropdownWillOpen();
    }

    /* compiled from: DXDropdownContainer.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[DXDropdownHorizontalAlignment.values().length];
            try {
                iArr[DXDropdownHorizontalAlignment.Default.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DXDropdownHorizontalAlignment.Center.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DXDropdownHorizontalAlignment.Left.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DXDropdownHorizontalAlignment.Right.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DXDropdownHorizontalAlignment.Stretch.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DXDropdownVerticalAlignment.values().length];
            try {
                iArr2[DXDropdownVerticalAlignment.Default.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[DXDropdownVerticalAlignment.Center.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[DXDropdownVerticalAlignment.Top.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[DXDropdownVerticalAlignment.Bottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[DXPlacement.values().length];
            try {
                iArr3[DXPlacement.Left.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[DXPlacement.Top.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[DXPlacement.Right.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[DXPlacement.Bottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* compiled from: DXDropdownContainer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/devexpress/editors/dropdown/DXDropdownContainer$Companion;", "", "()V", "DEFAULT_ANIMATION_DURATION_MS", "", "DEFAULT_SHADOW_OFFSET_V_DIP", "", "DEFAULT_SHADOW_OPACITY", "DEFAULT_SHADOW_RADIUS_DIP", "DEFAULT_VERTICAL_THRESHOLD_DIP", "EDGE_OFFSET_DIP", "", "SHADOW_SIZE_MULTIPLIER", "forceLayout", "", "view", "Landroid/view/View;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void forceLayout(View view) {
            view.forceLayout();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                    forceLayout(childAt);
                }
            }
        }
    }

    public DXDropdownContainer(Context context) {
        DisplayMetrics displayMetrics;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.placementRectangle = new Rectangle();
        this.horizontalAlignment = DXDropdownHorizontalAlignment.Default;
        this.verticalAlignment = DXDropdownVerticalAlignment.Default;
        this.placement = DXPlacement.Bottom;
        this.margin = new Rect();
        this.positionX = -1;
        this.positionY = -1;
        this.allowAnimation = true;
        this.animationDuration = 167L;
        this.allowShadow = true;
        this.scrimColor = Color.argb(153, 0, 0, 0);
        this.backgroundColor = -1;
        DXPopupWindow dXPopupWindow = new DXPopupWindow(context);
        this.popupWindow = dXPopupWindow;
        this.globalLayoutListener = new GlobalLayoutListener();
        this.globalScrollChangedLayoutListener = new GlobalScrollChangedLayoutListener();
        Resources resources = context.getResources();
        float f = (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? 2.0f : displayMetrics.density;
        this.density = f;
        this.actualPlacementRect = new Rectangle();
        this.actualPlacement = DXPlacement.Bottom;
        this.actualVerticalAlignment = DXDropdownVerticalAlignment.Default;
        this.actualHorizontalAlignment = DXDropdownHorizontalAlignment.Default;
        this.shadowMargin = new Rect();
        float f2 = 4;
        this.edgeOffset = (int) ((f2 * f) + 0.5f);
        this.backgroundViewFrame = new Rectangle();
        this.contentShadowFrame = new Rectangle();
        this.contentGlobalFrame = new Rectangle();
        this.contentLocalFrame = new Rectangle();
        this.availableDisplayFrame = new Rectangle();
        this.placementTargetPositionListener = new PlacementTargetPositionListener();
        this.dispatcher = new Handler(context.getMainLooper());
        this.placementVerticalThreshold = (int) ((200.0f * f) + 0.5f);
        this.shadowColor = Color.argb(MathKt.roundToInt(94.35f), 0, 0, 0);
        this.shadowRadius = (int) ((7.5f * f) + 0.5f);
        this.shadowOffset = new Offset(0, (int) ((6.0f * f) + 0.5f));
        this.cornerRadius = f2 * f;
        DropdownBackgroundView dropdownBackgroundView = new DropdownBackgroundView(context);
        this.backgroundView = dropdownBackgroundView;
        this.contentShadowView = dropdownBackgroundView.getContentShadowView();
        dXPopupWindow.setClippingEnabled(false);
        dXPopupWindow.setTouchModal(true);
        dXPopupWindow.setOutsideTouchable(true);
        setFocusable(true);
        dXPopupWindow.setContentView(dropdownBackgroundView);
        dropdownBackgroundView.setCallbackForLayoutChanges(new AnonymousClass1(this));
    }

    public final View getContentView() {
        return this.contentView;
    }

    public final void setContentView(View view) {
        if (Intrinsics.areEqual(this.contentView, view)) {
            return;
        }
        this.contentView = view;
        this.contentShadowView.getContentClipView().setContentView(view);
        if (this.isDropdownOpen) {
            if (this.contentView == null) {
                hide();
            } else {
                resizeOpenFrameWithPosition();
            }
        }
    }

    public final WeakReference<View> getPlacementTargetWeak() {
        return this.placementTargetWeak;
    }

    public final void setPlacementTargetWeak(WeakReference<View> weakReference) {
        this.placementTargetWeak = weakReference;
    }

    public final void setPlacementTarget(View view) {
        if (Intrinsics.areEqual(this.placementTargetWeak, view)) {
            return;
        }
        WeakReference<View> weakReference = this.placementTargetWeak;
        this.placementTargetPositionListener.detach(weakReference != null ? weakReference.get() : null);
        this.placementTargetWeak = view == null ? null : new WeakReference<>(view);
        if ((view != null ? view.getRootView() : null) instanceof DropdownBackgroundView) {
            View rootView = view.getRootView();
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type com.devexpress.editors.dropdown.DXDropdownContainer.DropdownBackgroundView");
            DropdownBackgroundView dropdownBackgroundView = (DropdownBackgroundView) rootView;
            this.parentPopupContainer = dropdownBackgroundView;
            if (dropdownBackgroundView != null) {
                dropdownBackgroundView.setCallbackForLayoutChanges(new DXDropdownContainer$placementTarget$1(this));
            }
        }
        if (view != null) {
            this.placementTargetPositionListener.attach(view);
        }
        setRootView(null);
        if (this.isDropdownOpen) {
            findRootView();
        }
    }

    public final View getPlacementTarget() {
        WeakReference<View> weakReference = this.placementTargetWeak;
        if (weakReference == null || weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final Rectangle getPlacementRectangle() {
        return this.placementRectangle;
    }

    public final void setPlacementRectangle(Rectangle value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.placementRectangle, value)) {
            return;
        }
        this.placementRectangle = value;
        setRootView(null);
        findRootView();
    }

    public final DXDropdownHorizontalAlignment getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    public final void setHorizontalAlignment(DXDropdownHorizontalAlignment dXDropdownHorizontalAlignment) {
        Intrinsics.checkNotNullParameter(dXDropdownHorizontalAlignment, "<set-?>");
        this.horizontalAlignment = dXDropdownHorizontalAlignment;
    }

    public final DXDropdownVerticalAlignment getVerticalAlignment() {
        return this.verticalAlignment;
    }

    public final void setVerticalAlignment(DXDropdownVerticalAlignment dXDropdownVerticalAlignment) {
        Intrinsics.checkNotNullParameter(dXDropdownVerticalAlignment, "<set-?>");
        this.verticalAlignment = dXDropdownVerticalAlignment;
    }

    public final DXPlacement getPlacement() {
        return this.placement;
    }

    public final void setPlacement(DXPlacement dXPlacement) {
        Intrinsics.checkNotNullParameter(dXPlacement, "<set-?>");
        this.placement = dXPlacement;
    }

    public final int getPlacementVerticalThreshold() {
        return this.placementVerticalThreshold;
    }

    public final void setPlacementVerticalThreshold(int i) {
        this.placementVerticalThreshold = i;
    }

    public final int getPlacementHorizontalThreshold() {
        return this.placementHorizontalThreshold;
    }

    public final void setPlacementHorizontalThreshold(int i) {
        this.placementHorizontalThreshold = i;
    }

    public final Rect getMargin() {
        return this.margin;
    }

    public final void setMargin(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<set-?>");
        this.margin = rect;
    }

    public final int getMinWidth() {
        return this.minWidth;
    }

    public final void setMinWidth(int i) {
        this.minWidth = i;
    }

    public final int getMinHeight() {
        return this.minHeight;
    }

    public final void setMinHeight(int i) {
        this.minHeight = i;
    }

    public final int getPositionX() {
        return this.positionX;
    }

    public final void setPositionX(int i) {
        this.positionX = i;
    }

    public final int getPositionY() {
        return this.positionY;
    }

    public final void setPositionY(int i) {
        this.positionY = i;
    }

    public final int getPositionOffset() {
        return this.positionOffset;
    }

    public final void setPositionOffset(int i) {
        this.positionOffset = i;
    }

    /* renamed from: isDropdownOpen, reason: from getter */
    public final boolean getIsDropdownOpen() {
        return this.isDropdownOpen;
    }

    public final void setDropdownOpen(boolean z) {
        if (this.isDropdownOpen == z) {
            return;
        }
        if (z) {
            Animator animator = this.currentAnimation;
            if (animator != null) {
                animator.end();
            }
            if (!canShow() || !raiseDropdownWillOpen()) {
                resetFrames();
                CoerceValueListener coerceValueListener = this.coerceListener;
                if (coerceValueListener != null) {
                    coerceValueListener.coerceIsDropdownOpen();
                    return;
                }
                return;
            }
            this.isDropdownOpen = true;
            try {
                this.blockRequestLayout = true;
                show();
                return;
            } finally {
                this.blockRequestLayout = false;
            }
        }
        if (!raiseDropdownWillClose()) {
            CoerceValueListener coerceValueListener2 = this.coerceListener;
            if (coerceValueListener2 != null) {
                coerceValueListener2.coerceIsDropdownOpen();
                return;
            }
            return;
        }
        this.isDropdownOpen = false;
        hide();
    }

    public final boolean getAllowAnimation() {
        return this.allowAnimation;
    }

    public final void setAllowAnimation(boolean z) {
        this.allowAnimation = z;
    }

    public final long getAnimationDuration() {
        return this.animationDuration;
    }

    public final void setAnimationDuration(long j) {
        this.animationDuration = j;
    }

    public final boolean getAllowShadow() {
        return this.allowShadow;
    }

    public final void setAllowShadow(boolean z) {
        this.allowShadow = z;
    }

    public final int getShadowColor() {
        return this.shadowColor;
    }

    public final void setShadowColor(int i) {
        this.shadowColor = i;
    }

    public final int getShadowRadius() {
        return this.shadowRadius;
    }

    public final void setShadowRadius(int i) {
        this.shadowRadius = i;
    }

    public final Offset getShadowOffset() {
        return this.shadowOffset;
    }

    public final void setShadowOffset(Offset offset) {
        Intrinsics.checkNotNullParameter(offset, "<set-?>");
        this.shadowOffset = offset;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final void setCornerRadius(float f) {
        this.cornerRadius = f;
    }

    public final boolean getAllowScrim() {
        return this.allowScrim;
    }

    public final void setAllowScrim(boolean z) {
        this.allowScrim = z;
    }

    public final boolean getCloseOnScrimTap() {
        return this.closeOnScrimTap;
    }

    public final void setCloseOnScrimTap(boolean z) {
        this.closeOnScrimTap = z;
    }

    public final int getScrimColor() {
        return this.scrimColor;
    }

    public final void setScrimColor(int i) {
        this.scrimColor = i;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final CharSequence getContentDescription() {
        CharSequence contentDescription = this.backgroundView.getContentDescription();
        Intrinsics.checkNotNullExpressionValue(contentDescription, "getContentDescription(...)");
        return contentDescription;
    }

    public final void setContentDescription(CharSequence value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.backgroundView.setContentDescription(value);
    }

    /* renamed from: isDeferredDropdownResized, reason: from getter */
    public final boolean getIsDeferredDropdownResized() {
        return this.isDeferredDropdownResized;
    }

    public final void setDeferredDropdownResized(boolean z) {
        this.isDeferredDropdownResized = z;
    }

    public final boolean isFocusable() {
        return this.popupWindow.isFocusable();
    }

    public final void setFocusable(boolean z) {
        this.popupWindow.setFocusable(z);
    }

    private final void setRootView(View view) {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        ViewTreeObserver viewTreeObserver3;
        ViewTreeObserver viewTreeObserver4;
        if (Intrinsics.areEqual(this.rootView, view)) {
            return;
        }
        View view2 = this.rootView;
        if (view2 != null && (viewTreeObserver4 = view2.getViewTreeObserver()) != null) {
            viewTreeObserver4.removeOnGlobalLayoutListener(this.globalLayoutListener);
        }
        View view3 = this.rootView;
        if (view3 != null && (viewTreeObserver3 = view3.getViewTreeObserver()) != null) {
            viewTreeObserver3.removeOnScrollChangedListener(this.globalScrollChangedLayoutListener);
        }
        this.rootView = view;
        if (this.parentPopupContainer == null) {
            if (view != null && (viewTreeObserver2 = view.getViewTreeObserver()) != null) {
                viewTreeObserver2.addOnGlobalLayoutListener(this.globalLayoutListener);
            }
            View view4 = this.rootView;
            if (view4 == null || (viewTreeObserver = view4.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver.addOnScrollChangedListener(this.globalScrollChangedLayoutListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getActualAllowScrim() {
        return this.allowScrim && getPlacementTarget() == null && this.placementRectangle.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getActualAllowShadow() {
        return this.allowShadow && !(getPlacementTarget() == null && this.placementRectangle.isEmpty() && this.allowScrim);
    }

    /* compiled from: DXDropdownContainer.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.devexpress.editors.dropdown.DXDropdownContainer$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass1(Object obj) {
            super(0, obj, DXDropdownContainer.class, "onBackgroundViewLayout", "onBackgroundViewLayout()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((DXDropdownContainer) this.receiver).onBackgroundViewLayout();
        }
    }

    public final DropdownListener getOnActionlistener() {
        return this.onActionlistener;
    }

    public final void setOnActionlistener(DropdownListener dropdownListener) {
        this.onActionlistener = dropdownListener;
    }

    public final DropdownAnimationListener getAnimationListener() {
        return this.animationListener;
    }

    public final void setAnimationListener(DropdownAnimationListener dropdownAnimationListener) {
        this.animationListener = dropdownAnimationListener;
    }

    public final CoerceValueListener getCoerceListener() {
        return this.coerceListener;
    }

    public final void setCoerceListener(CoerceValueListener coerceValueListener) {
        this.coerceListener = coerceValueListener;
    }

    /* renamed from: isLayoutFixed, reason: from getter */
    public final boolean getIsLayoutFixed() {
        return this.isLayoutFixed;
    }

    public final void setLayoutFixed(boolean z) {
        this.isLayoutFixed = z;
    }

    public final void resizeOpenFrameWithPosition() {
        if (this.isDropdownOpen) {
            recalcFrames(!this.isLayoutFixed, true);
            this.popupWindow.update(this.backgroundViewFrame.getLeft(), this.backgroundViewFrame.getTop(), this.backgroundViewFrame.getWidth(), this.backgroundViewFrame.getHeight());
            this.isDeferredDropdownResized = true;
        }
    }

    public final void resizeOpenFrame() {
        if (this.isDropdownOpen) {
            recalcFrames(!this.isLayoutFixed, false);
            this.popupWindow.update(this.backgroundViewFrame.getLeft(), this.backgroundViewFrame.getTop(), this.backgroundViewFrame.getWidth(), this.backgroundViewFrame.getHeight());
        }
    }

    public final void releaseResources() {
        setRootView(null);
    }

    private final void show() {
        Animator animator = this.currentAnimation;
        if (animator != null) {
            animator.end();
        }
        if (getActualAllowScrim()) {
            Object systemService = this.context.getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            View view = this.rootView;
            Intrinsics.checkNotNull(view);
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        prepareVisual();
        calcFrames();
        this.popupWindow.setWidth(this.backgroundViewFrame.getWidth());
        this.popupWindow.setHeight(this.backgroundViewFrame.getHeight());
        this.popupWindow.showAtLocation(this.backgroundViewFrame.getLeft(), this.backgroundViewFrame.getTop());
        raiseDropdownOpened();
        if (this.allowAnimation) {
            raiseOpeningAnimationWillStart();
            Animator openingAnimation = getOpeningAnimation();
            this.currentAnimation = openingAnimation;
            Intrinsics.checkNotNull(openingAnimation);
            openingAnimation.start();
        }
    }

    private final void hide() {
        Animator animator = this.currentAnimation;
        if (animator != null) {
            animator.end();
        }
        if (!this.allowAnimation) {
            this.popupWindow.dismiss();
        }
        raiseDropdownClosed();
        if (this.allowAnimation) {
            raiseClosingAnimationWillStart();
            Animator closingAnimation = getClosingAnimation();
            this.currentAnimation = closingAnimation;
            Intrinsics.checkNotNull(closingAnimation);
            closingAnimation.start();
        } else if (this.popupWindow.isShowing()) {
            this.popupWindow.dismiss();
        }
        setRootView(null);
    }

    private final boolean canShow() {
        if (this.popupWindow.isShowing()) {
            return false;
        }
        if (this.rootView == null) {
            findRootView();
        }
        return (this.rootView == null || this.contentView == null) ? false : true;
    }

    private final void resetFrames() {
        this.backgroundViewFrame.setEmpty();
        this.contentShadowFrame.setEmpty();
        this.contentGlobalFrame.setEmpty();
        this.contentLocalFrame.setEmpty();
    }

    private final void findRootView() {
        View rootView;
        if (getPlacementTarget() == null) {
            setRootView(getRootViewFromContext(this.context));
            return;
        }
        View placementTarget = getPlacementTarget();
        Intrinsics.checkNotNull(placementTarget);
        if (placementTarget.getWindowToken() == null) {
            rootView = null;
        } else {
            View placementTarget2 = getPlacementTarget();
            Intrinsics.checkNotNull(placementTarget2);
            rootView = placementTarget2.getRootView();
        }
        setRootView(rootView);
    }

    private final View getRootViewFromContext(Context context) {
        View decorView;
        Window windowFromContext = getWindowFromContext(context);
        if (windowFromContext == null || (decorView = windowFromContext.getDecorView()) == null) {
            return null;
        }
        return decorView.getRootView();
    }

    private final Window getWindowFromContext(Context context) {
        Activity activityFromContext;
        if (context == null || (activityFromContext = getActivityFromContext(context)) == null) {
            return null;
        }
        return activityFromContext.getWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity getActivityFromContext(Context context) {
        return Utils.getActivityFromContext(context);
    }

    private final void prepareVisual() {
        this.contentShadowView.updateShadowLayer();
        this.contentShadowView.updateBackgroundColor();
        this.contentShadowView.getContentClipView().resetClipPath();
        calcShadowMargin();
        if (getActualAllowScrim()) {
            this.backgroundView.setBackgroundColor(this.scrimColor);
        } else {
            this.backgroundView.setBackground(null);
        }
    }

    private final void calcFrames() {
        this.actualPlacementRect.setEmpty();
        if (this.contentView != null) {
            INSTANCE.forceLayout(this.backgroundView);
            if (this.positionX != -1 && this.positionY != -1) {
                calcFramesForFixedPosition();
                return;
            } else if (getPlacementTarget() == null && this.placementRectangle.isEmpty()) {
                calcFramesForWindow();
                return;
            } else {
                calcFramesForPlacementTarget();
                return;
            }
        }
        resetFrames();
    }

    private final void calcFramesForWindow() {
        Rect rect = new Rect(Math.max(this.margin.left, this.edgeOffset), Math.max(this.margin.top, this.edgeOffset), Math.max(this.margin.right, this.edgeOffset), Math.max(this.margin.bottom, this.edgeOffset));
        Rectangle availableDisplayFrame = getAvailableDisplayFrame();
        Size size = new Size(availableDisplayFrame.getWidth() - (Math.max(rect.left, rect.right) * 2), availableDisplayFrame.getHeight() - (Math.max(rect.top, rect.bottom) * 2));
        View view = this.contentView;
        if (view == null) {
            return;
        }
        if (!this.isLayoutFixed) {
            view.measure(View.MeasureSpec.makeMeasureSpec(size.getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size.getHeight(), Integer.MIN_VALUE));
        }
        this.contentGlobalFrame.setWidth(Utils.clamp(view.getMeasuredWidth(), this.minWidth, size.getWidth()));
        this.contentGlobalFrame.setHeight(Utils.clamp(view.getMeasuredHeight(), this.minHeight, size.getHeight()));
        int i = WhenMappings.$EnumSwitchMapping$0[this.horizontalAlignment.ordinal()];
        if (i == 1 || i == 2) {
            this.contentGlobalFrame.setLeft(availableDisplayFrame.getLeft() + ((availableDisplayFrame.getWidth() - this.contentGlobalFrame.getWidth()) / 2));
        } else if (i == 3) {
            this.contentGlobalFrame.setLeft(availableDisplayFrame.getLeft() + rect.left);
        } else if (i == 4) {
            this.contentGlobalFrame.setLeft((availableDisplayFrame.right() - rect.right) - this.contentGlobalFrame.getWidth());
        } else if (i == 5) {
            this.contentGlobalFrame.setLeft(availableDisplayFrame.getLeft() + ((availableDisplayFrame.getWidth() - size.getWidth()) / 2));
            this.contentGlobalFrame.setWidth(size.getWidth());
        }
        int i2 = WhenMappings.$EnumSwitchMapping$1[this.verticalAlignment.ordinal()];
        if (i2 == 1 || i2 == 2) {
            this.contentGlobalFrame.setTop(availableDisplayFrame.getTop() + ((availableDisplayFrame.getHeight() - this.contentGlobalFrame.getHeight()) / 2));
        } else if (i2 == 3) {
            this.contentGlobalFrame.setTop(availableDisplayFrame.getTop() + rect.top);
        } else if (i2 == 4) {
            this.contentGlobalFrame.setTop((availableDisplayFrame.bottom() - rect.bottom) - this.contentGlobalFrame.getHeight());
        }
        calcVisibleFramesFromContentGlobalFrame(availableDisplayFrame);
    }

    private final void calcFramesForPlacementTarget() {
        View view = this.contentView;
        if (view == null) {
            return;
        }
        this.actualPlacementRect.set(this.placementRectangle);
        if (getPlacementTarget() != null) {
            this.actualPlacementRect.set(calcPlacementTargetWindowSpace());
            this.actualPlacementRect.offset(this.margin);
        }
        this.availableDisplayFrame = getAvailableDisplayFrame();
        Rectangle availableDisplayFrame = getAvailableDisplayFrame();
        int i = this.edgeOffset;
        availableDisplayFrame.inset(new Rect(i, i, i, i));
        PlacementStrategy create = PlacementStrategy.INSTANCE.create(this.placement, this.verticalAlignment, this.horizontalAlignment);
        if (create.getHorizontalCalculator().isContentSizeDependent()) {
            view.measure(View.MeasureSpec.makeMeasureSpec(availableDisplayFrame.getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(availableDisplayFrame.getHeight(), Integer.MIN_VALUE));
            create.calculateFrame(new Size(Math.max(view.getMeasuredWidth(), this.minWidth), Math.max(view.getMeasuredHeight(), this.minHeight)), availableDisplayFrame, this.actualPlacementRect, new Size(this.placementHorizontalThreshold, this.placementVerticalThreshold));
        } else {
            create.calculateFrame(new Size(this.minWidth, Math.max(view.getMeasuredHeight(), this.minHeight)), availableDisplayFrame, this.actualPlacementRect, new Size(this.placementHorizontalThreshold, this.placementVerticalThreshold));
            view.measure(View.MeasureSpec.makeMeasureSpec(create.getFrame().getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(availableDisplayFrame.getHeight(), Integer.MIN_VALUE));
            create.calculateFrame(new Size(Math.max(view.getMeasuredWidth(), this.minWidth), Math.max(view.getMeasuredHeight(), this.minHeight)), availableDisplayFrame, this.actualPlacementRect, new Size(this.placementHorizontalThreshold, this.placementVerticalThreshold));
        }
        this.actualPlacement = create.getActualPlacement();
        this.actualVerticalAlignment = create.getActualVerticalAlignment();
        this.actualHorizontalAlignment = create.getActualHorizontalAlignment();
        this.contentGlobalFrame.set(create.getFrame());
        calcVisibleFramesFromContentGlobalFrame(availableDisplayFrame);
    }

    private final void calcFramesForFixedPosition() {
        Rect rect = new Rect(Math.max(this.margin.left, this.edgeOffset), Math.max(this.margin.top, this.edgeOffset), Math.max(this.margin.right, this.edgeOffset), Math.max(this.margin.bottom, this.edgeOffset));
        Rectangle availableDisplayFrame = getAvailableDisplayFrame();
        Size size = new Size(availableDisplayFrame.getWidth() - (Math.max(rect.left, rect.right) * 2), availableDisplayFrame.getHeight() - (Math.max(rect.top, rect.bottom) * 2));
        View view = this.contentView;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(size.getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size.getHeight(), Integer.MIN_VALUE));
        this.contentGlobalFrame.setWidth(Utils.clamp(view.getMeasuredWidth(), this.minWidth, size.getWidth()));
        this.contentGlobalFrame.setHeight(Utils.clamp(view.getMeasuredHeight(), this.minHeight, size.getHeight()));
        int topWindowOffset = getTopWindowOffset();
        int i = this.positionY + topWindowOffset;
        int height = i - this.contentGlobalFrame.getHeight();
        int i2 = this.positionOffset;
        int height2 = height - i2 < topWindowOffset ? i + i2 : (i - i2) - this.contentGlobalFrame.getHeight();
        Rectangle rectangle = this.contentGlobalFrame;
        rectangle.setLeft(Utils.clamp(this.positionX - (rectangle.getWidth() / 2), rect.left, (availableDisplayFrame.getWidth() - this.contentGlobalFrame.getWidth()) - rect.right));
        this.contentGlobalFrame.setTop(Utils.clamp(height2, topWindowOffset, (availableDisplayFrame.getHeight() - this.contentGlobalFrame.getHeight()) - rect.bottom));
        calcVisibleFramesFromContentGlobalFrame(availableDisplayFrame);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recalcFrames(boolean callForceLayout, boolean canChangePTPosition) {
        if (callForceLayout) {
            INSTANCE.forceLayout(this.backgroundView);
        }
        if (this.positionX != -1 && this.positionY != -1) {
            calcFramesForFixedPosition();
            return;
        }
        if (getPlacementTarget() == null && this.placementRectangle.isEmpty()) {
            calcFramesForWindow();
        } else if (canChangePTPosition) {
            calcFramesForPlacementTarget();
        } else {
            recalcFramesForPlacementTarget();
        }
    }

    private final void recalcFramesForPlacementTarget() {
        View view = this.contentView;
        if (view == null) {
            return;
        }
        Rectangle availableDisplayFrame = getAvailableDisplayFrame();
        int i = this.edgeOffset;
        availableDisplayFrame.inset(new Rect(i, i, i, i));
        PlacementStrategy create = PlacementStrategy.INSTANCE.create(this.actualPlacement, this.actualVerticalAlignment, this.actualHorizontalAlignment);
        if (create.getHorizontalCalculator().isContentSizeDependent()) {
            view.measure(View.MeasureSpec.makeMeasureSpec(availableDisplayFrame.getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(availableDisplayFrame.getHeight(), Integer.MIN_VALUE));
        } else {
            create.resizeFrame(this.contentGlobalFrame, new Size(Utils.clamp(0, this.minWidth, availableDisplayFrame.getWidth()), Utils.clamp(view.getMeasuredHeight(), this.minHeight, availableDisplayFrame.getHeight())), availableDisplayFrame, this.actualPlacementRect);
            view.measure(View.MeasureSpec.makeMeasureSpec(create.getFrame().getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(availableDisplayFrame.getHeight(), Integer.MIN_VALUE));
        }
        create.resizeFrame(this.contentGlobalFrame, new Size(Utils.clamp(view.getMeasuredWidth(), this.minWidth, availableDisplayFrame.getWidth()), Utils.clamp(view.getMeasuredHeight(), this.minHeight, availableDisplayFrame.getHeight())), availableDisplayFrame, this.actualPlacementRect);
        this.contentGlobalFrame.set(create.getFrame());
        calcVisibleFramesFromContentGlobalFrame(availableDisplayFrame);
    }

    private final Rectangle calcPlacementTargetWindowSpace() {
        View placementTarget = getPlacementTarget();
        if (placementTarget == null) {
            return new Rectangle();
        }
        int[] iArr = new int[2];
        placementTarget.getLocationOnScreen(iArr);
        return new Rectangle(iArr[0], iArr[1], placementTarget.getWidth(), placementTarget.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rectangle getAvailableDisplayFrame() {
        Window window;
        View rootViewFromContext = getRootViewFromContext(this.context);
        if (rootViewFromContext == null) {
            return new Rectangle();
        }
        if (!rootViewFromContext.isAttachedToWindow()) {
            return new Rectangle();
        }
        Rect rect = new Rect();
        Activity activityFromContext = getActivityFromContext(this.context);
        WindowManager.LayoutParams attributes = (activityFromContext == null || (window = activityFromContext.getWindow()) == null) ? null : window.getAttributes();
        if (attributes == null) {
            attributes = new WindowManager.LayoutParams();
        }
        if ((attributes.flags & 512) != 0) {
            rootViewFromContext.getGlobalVisibleRect(rect);
        } else {
            rootViewFromContext.getWindowVisibleDisplayFrame(rect);
        }
        return Rectangle.INSTANCE.fromLTRB(0, rect.top, rect.right - rect.left, rect.bottom);
    }

    private final void calcShadowMargin() {
        if (!getActualAllowShadow()) {
            this.shadowMargin.setEmpty();
            return;
        }
        this.shadowMargin.left = -Math.min(this.shadowOffset.getHorizontal() - (this.shadowRadius * 2), 0);
        this.shadowMargin.top = -Math.min(this.shadowOffset.getVertical() - (this.shadowRadius * 2), 0);
        this.shadowMargin.right = Math.max((this.shadowRadius * 2) + this.shadowOffset.getHorizontal(), 0);
        this.shadowMargin.bottom = Math.max((this.shadowRadius * 2) + this.shadowOffset.getVertical(), 0);
    }

    private final void calcVisibleFramesFromContentGlobalFrame(Rectangle displayFrame) {
        if (getActualAllowScrim()) {
            this.backgroundViewFrame.set(displayFrame);
            this.contentShadowFrame.set(this.contentGlobalFrame.getLeft() - displayFrame.getLeft(), this.contentGlobalFrame.getTop() - displayFrame.getTop(), this.contentGlobalFrame.getWidth(), this.contentGlobalFrame.getHeight());
            this.contentLocalFrame.set(0, 0, this.contentGlobalFrame.getWidth(), this.contentGlobalFrame.getHeight());
            this.backgroundView.setBackgroundColor(this.scrimColor);
            return;
        }
        if (this.allowShadow) {
            this.backgroundViewFrame.set(this.contentGlobalFrame.getLeft() - this.shadowMargin.left, this.contentGlobalFrame.getTop() - this.shadowMargin.top, this.contentGlobalFrame.getWidth() + this.shadowMargin.left + this.shadowMargin.right, this.contentGlobalFrame.getHeight() + this.shadowMargin.top + this.shadowMargin.bottom);
            this.contentShadowFrame.set(0, 0, this.backgroundViewFrame.getWidth(), this.backgroundViewFrame.getHeight());
            this.contentLocalFrame.set(this.shadowMargin.left, this.shadowMargin.top, this.contentGlobalFrame.getWidth(), this.contentGlobalFrame.getHeight());
        } else {
            this.backgroundViewFrame.set(this.contentGlobalFrame);
            this.contentShadowFrame.set(0, 0, this.backgroundViewFrame.getWidth(), this.backgroundViewFrame.getHeight());
            this.contentLocalFrame.set(0, 0, this.contentGlobalFrame.getWidth(), this.contentGlobalFrame.getHeight());
        }
    }

    private final Animator getOpeningAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet.Builder play = animatorSet.play(ObjectAnimator.ofFloat(this.backgroundView, "alpha", 0.0f, 1.0f));
        Intrinsics.checkNotNullExpressionValue(play, "play(...)");
        if (getPlacementTarget() == null && this.placementRectangle.isEmpty()) {
            play.with(ObjectAnimator.ofFloat(this.contentShadowView, "scaleX", 0.0f, 1.0f));
            play.with(ObjectAnimator.ofFloat(this.contentShadowView, "scaleY", 0.0f, 1.0f));
        } else {
            int i = WhenMappings.$EnumSwitchMapping$2[this.actualPlacement.ordinal()];
            if (i == 1) {
                play.with(ObjectAnimator.ofFloat(this.contentShadowView, "translationX", r3.getWidth() / 3.0f, 0.0f));
            } else if (i == 2) {
                play.with(ObjectAnimator.ofFloat(this.contentShadowView, "translationY", r3.getHeight() / 3.0f, 0.0f));
            } else if (i == 3) {
                play.with(ObjectAnimator.ofFloat(this.contentShadowView, "translationX", (-r3.getWidth()) / 3.0f, 0.0f));
            } else if (i == 4) {
                play.with(ObjectAnimator.ofFloat(this.contentShadowView, "translationY", (-r3.getHeight()) / 3.0f, 0.0f));
            }
        }
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(this.animationDuration);
        animatorSet.addListener(new OpeningAnimationListener());
        return animatorSet;
    }

    private final Animator getClosingAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet.Builder play = animatorSet.play(ObjectAnimator.ofFloat(this.backgroundView, "alpha", 1.0f, 0.0f));
        Intrinsics.checkNotNullExpressionValue(play, "play(...)");
        if (getPlacementTarget() == null && this.placementRectangle.isEmpty()) {
            play.with(ObjectAnimator.ofFloat(this.contentShadowView, "scaleX", 1.0f, 0.0f));
            play.with(ObjectAnimator.ofFloat(this.contentShadowView, "scaleY", 1.0f, 0.0f));
        } else {
            int i = WhenMappings.$EnumSwitchMapping$2[this.actualPlacement.ordinal()];
            if (i == 1) {
                play.with(ObjectAnimator.ofFloat(this.contentShadowView, "translationX", 0.0f, r3.getWidth() / 3.0f));
            } else if (i == 2) {
                play.with(ObjectAnimator.ofFloat(this.contentShadowView, "translationY", 0.0f, r3.getHeight() / 3.0f));
            } else if (i == 3) {
                play.with(ObjectAnimator.ofFloat(this.contentShadowView, "translationX", 0.0f, (-r3.getWidth()) / 3.0f));
            } else if (i == 4) {
                play.with(ObjectAnimator.ofFloat(this.contentShadowView, "translationY", 0.0f, (-r3.getHeight()) / 3.0f));
            }
        }
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.setDuration((long) (this.animationDuration * 0.6667d));
        animatorSet.addListener(new ClosingAnimationListener());
        return animatorSet;
    }

    private final boolean raiseDropdownWillOpen() {
        DropdownListener dropdownListener = this.onActionlistener;
        if (dropdownListener == null) {
            return true;
        }
        return dropdownListener.dropdownWillOpen();
    }

    private final void raiseDropdownOpened() {
        DropdownListener dropdownListener = this.onActionlistener;
        if (dropdownListener != null) {
            dropdownListener.dropdownOpened();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBackgroundViewLayout() {
        if (this.isDeferredDropdownResized) {
            raiseDropdownResized();
            this.isDeferredDropdownResized = false;
        }
    }

    private final void raiseDropdownResized() {
        DropdownListener dropdownListener = this.onActionlistener;
        if (dropdownListener != null) {
            dropdownListener.dropdownResized();
        }
    }

    private final boolean raiseDropdownWillClose() {
        DropdownListener dropdownListener = this.onActionlistener;
        if (dropdownListener == null) {
            return true;
        }
        return dropdownListener.dropdownWillClose();
    }

    private final void raiseDropdownClosed() {
        DropdownListener dropdownListener = this.onActionlistener;
        if (dropdownListener != null) {
            dropdownListener.dropdownClosed();
        }
    }

    private final void raiseOpeningAnimationWillStart() {
        DropdownAnimationListener dropdownAnimationListener = this.animationListener;
        if (dropdownAnimationListener != null) {
            dropdownAnimationListener.openingAnimationWillStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void raiseOpeningAnimationComplete() {
        DropdownAnimationListener dropdownAnimationListener = this.animationListener;
        if (dropdownAnimationListener != null) {
            dropdownAnimationListener.openingAnimationComplete();
        }
    }

    private final void raiseClosingAnimationWillStart() {
        DropdownAnimationListener dropdownAnimationListener = this.animationListener;
        if (dropdownAnimationListener != null) {
            dropdownAnimationListener.closingAnimationWillStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void raiseClosingAnimationComplete() {
        DropdownAnimationListener dropdownAnimationListener = this.animationListener;
        if (dropdownAnimationListener != null) {
            dropdownAnimationListener.closingAnimationComplete();
        }
    }

    private final int getTopWindowOffset() {
        Rect rect = new Rect();
        Window windowFromContext = getWindowFromContext(this.context);
        Intrinsics.checkNotNull(windowFromContext);
        windowFromContext.getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DXDropdownContainer.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J0\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0014J\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018H\u0014J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\u0014\u0010 \u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u0015\u0010\u0005\u001a\u00060\u0006R\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/devexpress/editors/dropdown/DXDropdownContainer$DropdownBackgroundView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Lcom/devexpress/editors/dropdown/DXDropdownContainer;Landroid/content/Context;)V", "contentShadowView", "Lcom/devexpress/editors/dropdown/DXDropdownContainer$DropdownContentShadowView;", "Lcom/devexpress/editors/dropdown/DXDropdownContainer;", "getContentShadowView", "()Lcom/devexpress/editors/dropdown/DXDropdownContainer$DropdownContentShadowView;", "needsRemeasure", "", "onLayoutApplyChanges", "Lkotlin/Function0;", "", "dispatchKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onLayout", "changed", "l", "", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requestLayout", "setCallbackForLayoutChanges", "callback", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    final class DropdownBackgroundView extends ViewGroup {
        private final DropdownContentShadowView contentShadowView;
        private boolean needsRemeasure;
        private Function0<Unit> onLayoutApplyChanges;

        public DropdownBackgroundView(Context context) {
            super(context);
            DropdownContentShadowView dropdownContentShadowView = DXDropdownContainer.this.new DropdownContentShadowView(context);
            this.contentShadowView = dropdownContentShadowView;
            this.onLayoutApplyChanges = new Function0<Unit>() { // from class: com.devexpress.editors.dropdown.DXDropdownContainer$DropdownBackgroundView$onLayoutApplyChanges$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
            addView(dropdownContentShadowView);
        }

        public final DropdownContentShadowView getContentShadowView() {
            return this.contentShadowView;
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            super.requestLayout();
            if (DXDropdownContainer.this.blockRequestLayout || DXDropdownContainer.this.getIsLayoutFixed()) {
                return;
            }
            this.needsRemeasure = true;
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            if (this.needsRemeasure) {
                this.needsRemeasure = false;
                Rectangle rectangle = new Rectangle(DXDropdownContainer.this.contentShadowFrame);
                DXDropdownContainer.this.recalcFrames(false, false);
                if (!Intrinsics.areEqual(rectangle, DXDropdownContainer.this.contentShadowFrame)) {
                    final DXDropdownContainer dXDropdownContainer = DXDropdownContainer.this;
                    post(new Runnable() { // from class: com.devexpress.editors.dropdown.DXDropdownContainer$DropdownBackgroundView$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            DXDropdownContainer.DropdownBackgroundView.onMeasure$lambda$0(DXDropdownContainer.this);
                        }
                    });
                }
            }
            this.contentShadowView.measure(View.MeasureSpec.makeMeasureSpec(DXDropdownContainer.this.contentShadowFrame.getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(DXDropdownContainer.this.contentShadowFrame.getHeight(), BasicMeasure.EXACTLY));
            setMeasuredDimension(DXDropdownContainer.this.backgroundViewFrame.getWidth(), DXDropdownContainer.this.backgroundViewFrame.getHeight());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onMeasure$lambda$0(DXDropdownContainer this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.popupWindow.update(this$0.backgroundViewFrame.getLeft(), this$0.backgroundViewFrame.getTop(), this$0.backgroundViewFrame.getWidth(), this$0.backgroundViewFrame.getHeight());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            this.contentShadowView.layout(DXDropdownContainer.this.contentShadowFrame.getLeft(), DXDropdownContainer.this.contentShadowFrame.getTop(), DXDropdownContainer.this.contentShadowFrame.right(), DXDropdownContainer.this.contentShadowFrame.bottom());
            this.onLayoutApplyChanges.invoke();
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent event) {
            if (event != null && event.getKeyCode() == 4) {
                if (getKeyDispatcherState() == null) {
                    return super.dispatchKeyEvent(event);
                }
                int action = event.getAction();
                KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                if (action == 0 && event.getRepeatCount() == 0) {
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(event, this);
                    }
                    return true;
                }
                if (action == 1 && keyDispatcherState != null && keyDispatcherState.isTracking(event) && !event.isCanceled()) {
                    DXDropdownContainer.this.setDropdownOpen(false);
                    return true;
                }
            }
            return super.dispatchKeyEvent(event);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent ev) {
            if (ev == null) {
                return super.dispatchTouchEvent(ev);
            }
            int actionMasked = ev.getActionMasked();
            int rawX = (int) ev.getRawX();
            int rawY = (int) ev.getRawY();
            if (DXDropdownContainer.this.getPlacementTarget() != null && DXDropdownContainer.this.actualPlacementRect.contains(rawX, rawY)) {
                if (!DXDropdownContainer.this.popupWindow.isFocusable() || !DXDropdownContainer.this.popupWindow.isTouchModal()) {
                    return super.dispatchTouchEvent(ev);
                }
                MotionEvent obtain = MotionEvent.obtain(ev.getDownTime(), ev.getEventTime(), ev.getAction(), ev.getRawX(), ev.getRawY(), ev.getMetaState());
                try {
                    Activity activityFromContext = DXDropdownContainer.this.getActivityFromContext(getContext());
                    if (activityFromContext != null) {
                        activityFromContext.dispatchTouchEvent(obtain);
                    }
                    return true;
                } finally {
                    obtain.recycle();
                }
            }
            if (actionMasked == 0 || actionMasked == 4) {
                if (!DXDropdownContainer.this.availableDisplayFrame.isEmpty() && !DXDropdownContainer.this.availableDisplayFrame.contains(rawX, rawY)) {
                    return super.dispatchTouchEvent(ev);
                }
                if (rawX != 0 || rawY != 0) {
                    if ((DXDropdownContainer.this.getActualAllowScrim() && !DXDropdownContainer.this.getCloseOnScrimTap()) || DXDropdownContainer.this.contentGlobalFrame.contains(rawX, rawY)) {
                        return super.dispatchTouchEvent(ev);
                    }
                    DXDropdownContainer.this.setDropdownOpen(false);
                    return true;
                }
                return super.dispatchTouchEvent(ev);
            }
            return super.dispatchTouchEvent(ev);
        }

        public final void setCallbackForLayoutChanges(Function0<Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.onLayoutApplyChanges = callback;
        }
    }

    /* compiled from: DXDropdownContainer.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J0\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0014J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0014J\b\u0010\u001b\u001a\u00020\rH\u0002J\u0006\u0010\u001c\u001a\u00020\rJ\u0006\u0010\u001d\u001a\u00020\rR\u0015\u0010\u0005\u001a\u00060\u0006R\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/devexpress/editors/dropdown/DXDropdownContainer$DropdownContentShadowView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Lcom/devexpress/editors/dropdown/DXDropdownContainer;Landroid/content/Context;)V", "contentClipView", "Lcom/devexpress/editors/dropdown/DXDropdownContainer$DropdownContentClipView;", "Lcom/devexpress/editors/dropdown/DXDropdownContainer;", "getContentClipView", "()Lcom/devexpress/editors/dropdown/DXDropdownContainer$DropdownContentClipView;", "shadowPaint", "Landroid/graphics/Paint;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "l", "", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setLayerType", "updateBackgroundColor", "updateShadowLayer", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class DropdownContentShadowView extends ViewGroup {
        private final DropdownContentClipView contentClipView;
        private final Paint shadowPaint;

        public DropdownContentShadowView(Context context) {
            super(context);
            this.shadowPaint = new Paint(1);
            DropdownContentClipView dropdownContentClipView = DXDropdownContainer.this.new DropdownContentClipView(context);
            this.contentClipView = dropdownContentClipView;
            addView(dropdownContentClipView);
            setWillNotDraw(false);
            setBackground(null);
            setClickable(false);
            setFocusable(false);
            setFocusableInTouchMode(false);
            setLayerType();
            updateShadowLayer();
            updateBackgroundColor();
        }

        public final DropdownContentClipView getContentClipView() {
            return this.contentClipView;
        }

        public final void updateShadowLayer() {
            if (DXDropdownContainer.this.getActualAllowShadow()) {
                this.shadowPaint.setShadowLayer(DXDropdownContainer.this.getShadowRadius(), DXDropdownContainer.this.getShadowOffset().getHorizontal(), DXDropdownContainer.this.getShadowOffset().getVertical(), DXDropdownContainer.this.getShadowColor());
            } else {
                this.shadowPaint.clearShadowLayer();
            }
        }

        public final void updateBackgroundColor() {
            this.shadowPaint.setColor(DXDropdownContainer.this.getBackgroundColor());
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            this.contentClipView.measure(View.MeasureSpec.makeMeasureSpec(DXDropdownContainer.this.contentLocalFrame.getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(DXDropdownContainer.this.contentLocalFrame.getHeight(), BasicMeasure.EXACTLY));
            setMeasuredDimension(DXDropdownContainer.this.contentShadowFrame.getWidth(), DXDropdownContainer.this.contentShadowFrame.getHeight());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            this.contentClipView.layout(DXDropdownContainer.this.contentLocalFrame.getLeft(), DXDropdownContainer.this.contentLocalFrame.getTop(), DXDropdownContainer.this.contentLocalFrame.right(), DXDropdownContainer.this.contentLocalFrame.bottom());
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            if (DXDropdownContainer.this.getCornerRadius() == 0.0f) {
                canvas.drawRect(DXDropdownContainer.this.contentLocalFrame.toRect(), this.shadowPaint);
            } else {
                canvas.drawRoundRect(DXDropdownContainer.this.contentLocalFrame.toRectF(), DXDropdownContainer.this.getCornerRadius(), DXDropdownContainer.this.getCornerRadius(), this.shadowPaint);
            }
        }

        private final void setLayerType() {
            if (Build.VERSION.SDK_INT >= 28) {
                setLayerType(2, null);
            } else {
                setLayerType(1, null);
            }
        }
    }

    /* compiled from: DXDropdownContainer.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J0\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0014J\u0018\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001cH\u0014J\u0006\u0010#\u001a\u00020\u0015J\b\u0010$\u001a\u00020\u0015H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lcom/devexpress/editors/dropdown/DXDropdownContainer$DropdownContentClipView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Lcom/devexpress/editors/dropdown/DXDropdownContainer;Landroid/content/Context;)V", "clipPath", "Landroid/graphics/Path;", "getClipPath", "()Landroid/graphics/Path;", "value", "Landroid/view/View;", "contentView", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "l", "", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resetClipPath", "setLayerType", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class DropdownContentClipView extends ViewGroup {
        private final Path clipPath;
        private View contentView;
        private final Paint paint;

        public DropdownContentClipView(Context context) {
            super(context);
            this.clipPath = new Path();
            Paint paint = new Paint(1);
            this.paint = paint;
            setWillNotDraw(false);
            setBackground(null);
            setClickable(false);
            setFocusable(false);
            setFocusableInTouchMode(false);
            setLayerType();
            paint.setStyle(Paint.Style.FILL);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }

        public final Path getClipPath() {
            return this.clipPath;
        }

        public final Paint getPaint() {
            return this.paint;
        }

        public final View getContentView() {
            return this.contentView;
        }

        public final void setContentView(View view) {
            if (Intrinsics.areEqual(this.contentView, view)) {
                return;
            }
            View view2 = this.contentView;
            if (view2 != null) {
                removeView(view2);
            }
            this.contentView = view;
            if (view != null) {
                Intrinsics.checkNotNull(view);
                ViewParent parent = view.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(this.contentView);
                }
                addView(this.contentView);
            }
        }

        public final void resetClipPath() {
            this.clipPath.reset();
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            View view = this.contentView;
            if (view != null) {
                view.measure(widthMeasureSpec, heightMeasureSpec);
            }
            setMeasuredDimension(DXDropdownContainer.this.contentLocalFrame.getWidth(), DXDropdownContainer.this.contentLocalFrame.getHeight());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            int i = r - l;
            int i2 = b - t;
            View view = this.contentView;
            if (view != null) {
                view.layout(0, 0, i, i2);
            }
            if (changed) {
                this.clipPath.reset();
            }
            if (this.clipPath.isEmpty()) {
                this.clipPath.addRoundRect(new RectF(0.0f, 0.0f, i, i2), DXDropdownContainer.this.getCornerRadius(), DXDropdownContainer.this.getCornerRadius(), Path.Direction.CW);
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            canvas.clipPath(this.clipPath);
            canvas.drawPath(this.clipPath, this.paint);
        }

        private final void setLayerType() {
            setLayerType(2, null);
        }
    }

    /* compiled from: DXDropdownContainer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/devexpress/editors/dropdown/DXDropdownContainer$GlobalScrollChangedLayoutListener;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "(Lcom/devexpress/editors/dropdown/DXDropdownContainer;)V", "onScrollChanged", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class GlobalScrollChangedLayoutListener implements ViewTreeObserver.OnScrollChangedListener {
        public GlobalScrollChangedLayoutListener() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            DXDropdownContainer.this.resizeOpenFrameWithPosition();
            DXDropdownContainer.this.placementTargetPositionListener.onScrollChanged();
        }
    }

    /* compiled from: DXDropdownContainer.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0016\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0014J\u0010\u0010\u001a\u001a\u00020\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u0018R$\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/devexpress/editors/dropdown/DXDropdownContainer$PlacementTargetPositionListener;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "(Lcom/devexpress/editors/dropdown/DXDropdownContainer;)V", "placementTarget", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "getPlacementTarget", "()Ljava/lang/ref/WeakReference;", "setPlacementTarget", "(Ljava/lang/ref/WeakReference;)V", "positionX", "", "getPositionX", "()I", "setPositionX", "(I)V", "positionY", "getPositionY", "setPositionY", "attach", "", "view", "detach", "onPreDraw", "", "onScrollChanged", "updatePosition", "isInitOnly", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class PlacementTargetPositionListener implements ViewTreeObserver.OnPreDrawListener {
        private WeakReference<View> placementTarget;
        private int positionX;
        private int positionY;

        public PlacementTargetPositionListener() {
        }

        public final WeakReference<View> getPlacementTarget() {
            return this.placementTarget;
        }

        public final void setPlacementTarget(WeakReference<View> weakReference) {
            this.placementTarget = weakReference;
        }

        public final int getPositionX() {
            return this.positionX;
        }

        public final void setPositionX(int i) {
            this.positionX = i;
        }

        public final int getPositionY() {
            return this.positionY;
        }

        public final void setPositionY(int i) {
            this.positionY = i;
        }

        public final void attach(View view) {
            ViewTreeObserver viewTreeObserver;
            this.placementTarget = new WeakReference<>(view);
            updatePosition(true);
            if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver.addOnPreDrawListener(this);
        }

        public final void detach(View view) {
            ViewTreeObserver viewTreeObserver;
            this.placementTarget = null;
            if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver.removeOnPreDrawListener(this);
        }

        public final void onScrollChanged() {
            updatePosition(true);
        }

        public static /* synthetic */ void updatePosition$default(PlacementTargetPositionListener placementTargetPositionListener, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            placementTargetPositionListener.updatePosition(z);
        }

        public final void updatePosition(boolean isInitOnly) {
            View view;
            int i = this.positionX;
            int i2 = this.positionY;
            int[] iArr = new int[2];
            WeakReference<View> weakReference = this.placementTarget;
            if (weakReference != null && (view = weakReference.get()) != null) {
                view.getLocationInWindow(iArr);
            }
            int i3 = iArr[0];
            this.positionX = i3;
            int i4 = iArr[1];
            this.positionY = i4;
            if (isInitOnly) {
                return;
            }
            if (i == i3 && i2 == i4) {
                return;
            }
            DXDropdownContainer.this.resizeOpenFrameWithPosition();
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            updatePosition$default(this, false, 1, null);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DXDropdownContainer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/devexpress/editors/dropdown/DXDropdownContainer$GlobalLayoutListener;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "(Lcom/devexpress/editors/dropdown/DXDropdownContainer;)V", "onGlobalLayout", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    final class GlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        public GlobalLayoutListener() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Handler handler = DXDropdownContainer.this.dispatcher;
            final DXDropdownContainer dXDropdownContainer = DXDropdownContainer.this;
            handler.postDelayed(new Runnable() { // from class: com.devexpress.editors.dropdown.DXDropdownContainer$GlobalLayoutListener$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DXDropdownContainer.GlobalLayoutListener.onGlobalLayout$lambda$0(DXDropdownContainer.this);
                }
            }, 100L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onGlobalLayout$lambda$0(DXDropdownContainer this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.availableDisplayFrame.getHeight() != this$0.getAvailableDisplayFrame().getHeight()) {
                this$0.resizeOpenFrameWithPosition();
            }
        }
    }

    /* compiled from: DXDropdownContainer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/devexpress/editors/dropdown/DXDropdownContainer$OpeningAnimationListener;", "Landroid/animation/Animator$AnimatorListener;", "(Lcom/devexpress/editors/dropdown/DXDropdownContainer;)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class OpeningAnimationListener implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        public OpeningAnimationListener() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            animation.removeListener(this);
            DXDropdownContainer.this.raiseOpeningAnimationComplete();
            DXDropdownContainer.this.currentAnimation = null;
        }
    }

    /* compiled from: DXDropdownContainer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/devexpress/editors/dropdown/DXDropdownContainer$ClosingAnimationListener;", "Landroid/animation/Animator$AnimatorListener;", "(Lcom/devexpress/editors/dropdown/DXDropdownContainer;)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class ClosingAnimationListener implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        public ClosingAnimationListener() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            animation.removeListener(this);
            DXDropdownContainer.this.popupWindow.dismiss();
            DXDropdownContainer.this.contentShadowView.setTranslationX(0.0f);
            DXDropdownContainer.this.contentShadowView.setTranslationY(0.0f);
            DXDropdownContainer.this.contentShadowView.setScaleX(1.0f);
            DXDropdownContainer.this.contentShadowView.setScaleY(1.0f);
            DXDropdownContainer.this.backgroundView.setAlpha(1.0f);
            DXDropdownContainer.this.raiseClosingAnimationComplete();
            DXDropdownContainer.this.currentAnimation = null;
        }
    }
}
