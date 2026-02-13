package com.devexpress.editors;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.ArrowKeyMovementMethod;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.AttributeSet;
import android.util.Size;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.ImageViewCompat;
import com.devexpress.dxcore.DXNativeView;
import com.devexpress.editors.EditBase;
import com.devexpress.editors.animations.BottomTextAnimator;
import com.devexpress.editors.animations.LabelAnimator;
import com.devexpress.editors.helpers.MathHelper;
import com.devexpress.editors.layout.Element;
import com.devexpress.editors.layout.OnBoxMarginChangedListener;
import com.devexpress.editors.layout.ViewHolder;
import com.devexpress.editors.layout.factories.EditLayoutElementsFactory;
import com.devexpress.editors.layout2.FilledLayout;
import com.devexpress.editors.layout2.Layout;
import com.devexpress.editors.layout2.OutlinedLayout;
import com.devexpress.editors.model.BorderRounds;
import com.devexpress.editors.style.TextEditStyle;
import com.devexpress.editors.utils.BottomTextVisibility;
import com.devexpress.editors.utils.ContextMenuDelegate;
import com.devexpress.editors.utils.LabelPosition;
import com.devexpress.editors.utils.Utils;
import com.devexpress.editors.utils.WeakProperty;
import com.devexpress.editors.utils.WeakPropertyKt;
import com.devexpress.editors.utils.drawablemanager.BackgroundDrawableManager;
import com.devexpress.editors.utils.drawablemanager.DrawableManagerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.time.DurationKt;

/* compiled from: EditBase.kt */
@Metadata(d1 = {"\u0000î\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u0000 ®\u00042\u00020\u0001:\u0006®\u0004¯\u0004°\u0004B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u0096\u0003\u001a\u00030\u0097\u0003H\u0002J\u001c\u0010\u0098\u0003\u001a\u00030\u0099\u00032\u0007\u0010\u009a\u0003\u001a\u00020\u00072\u0007\u0010\u009b\u0003\u001a\u00020\u0007H\u0002J\t\u0010\u009c\u0003\u001a\u00020EH\u0002J\n\u0010\u009d\u0003\u001a\u00030¯\u0002H\u0002J\u0012\u0010\u009e\u0003\u001a\u00030\u0090\u00012\u0006\u00106\u001a\u000205H\u0014J\n\u0010\u009f\u0003\u001a\u00030 \u0003H\u0014J\u0013\u0010¡\u0003\u001a\u00020-2\b\u0010¢\u0003\u001a\u00030£\u0003H\u0016J\n\u0010¤\u0003\u001a\u00030\u0097\u0003H\u0014J\u001e\u0010¥\u0003\u001a\u00030\u0097\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\n\u0010¦\u0003\u001a\u00030\u0097\u0003H\u0016J\t\u0010§\u0003\u001a\u0004\u0018\u00010WJ\n\u0010¨\u0003\u001a\u00030\u0097\u0003H\u0004J\n\u0010©\u0003\u001a\u00030\u0097\u0003H\u0002J\n\u0010ª\u0003\u001a\u00030\u0097\u0003H\u0002J\n\u0010«\u0003\u001a\u00030\u0097\u0003H\u0016J?\u0010¬\u0003\u001a\u00030\u0097\u00032\u000f\u0010\u00ad\u0003\u001a\n\u0012\u0005\u0012\u00030Â\u00020Á\u00022\u0007\u0010®\u0003\u001a\u00020\u00072\u0007\u0010¯\u0003\u001a\u00020\u00072\u0007\u0010°\u0003\u001a\u00020\u00072\u0007\u0010±\u0003\u001a\u00020\u0007H\u0002J\n\u0010²\u0003\u001a\u00030\u0097\u0003H\u0002J\n\u0010³\u0003\u001a\u00030\u0097\u0003H\u0014J\n\u0010´\u0003\u001a\u00030\u0097\u0003H\u0015J\u001b\u0010µ\u0003\u001a\u00030\u0097\u00032\u0007\u0010¶\u0003\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020 H\u0015J\u0015\u0010·\u0003\u001a\u00030\u0097\u00032\t\u0010¸\u0003\u001a\u0004\u0018\u00010&H\u0015J\n\u0010¹\u0003\u001a\u00030\u0097\u0003H\u0002J\n\u0010º\u0003\u001a\u00030\u0097\u0003H\u0004J\n\u0010»\u0003\u001a\u00030\u0097\u0003H\u0015J\n\u0010¼\u0003\u001a\u00030\u0097\u0003H\u0015J\n\u0010½\u0003\u001a\u00030\u0097\u0003H\u0015J\u0013\u0010¾\u0003\u001a\u00030¿\u00032\u0007\u0010À\u0003\u001a\u00020\u0007H\u0014J\n\u0010Á\u0003\u001a\u00030\u0097\u0003H\u0002J\n\u0010Â\u0003\u001a\u00030\u0097\u0003H\u0014J\u001d\u0010Ã\u0003\u001a\u00020-2\b\u0010¢\u0003\u001a\u00030£\u00032\b\u0010Ä\u0003\u001a\u00030\u0099\u0003H\u0004J\t\u0010Å\u0003\u001a\u00020-H\u0014J\u0014\u0010Æ\u0003\u001a\u00030\u0097\u00032\b\u0010Ç\u0003\u001a\u00030È\u0003H\u0014J\u0012\u0010É\u0003\u001a\u00020-2\u0007\u0010Ê\u0003\u001a\u00020\u0007H\u0014J\n\u0010Ë\u0003\u001a\u00030\u0097\u0003H\u0015J\n\u0010Ì\u0003\u001a\u00030\u0097\u0003H\u0002J\n\u0010Í\u0003\u001a\u00030\u0097\u0003H\u0014J\n\u0010Î\u0003\u001a\u00030\u0097\u0003H\u0002J\n\u0010Ï\u0003\u001a\u00030\u0097\u0003H\u0014J7\u0010Ð\u0003\u001a\u00030\u0097\u00032\u0007\u0010Ñ\u0003\u001a\u00020-2\u0007\u0010®\u0003\u001a\u00020\u00072\u0007\u0010¯\u0003\u001a\u00020\u00072\u0007\u0010°\u0003\u001a\u00020\u00072\u0007\u0010±\u0003\u001a\u00020\u0007H\u0014J\n\u0010Ò\u0003\u001a\u00030\u0097\u0003H\u0004J\t\u0010Ó\u0003\u001a\u00020-H\u0014J\u001c\u0010Ô\u0003\u001a\u00030Õ\u00032\u0007\u0010Ö\u0003\u001a\u00020\u00072\u0007\u0010×\u0003\u001a\u00020\u0007H\u0014J\n\u0010Ø\u0003\u001a\u00030\u0097\u0003H\u0015J\n\u0010Ù\u0003\u001a\u00030\u0097\u0003H\u0014J\t\u0010Ú\u0003\u001a\u00020-H\u0014J\n\u0010Û\u0003\u001a\u00030\u0097\u0003H\u0002J\n\u0010Ü\u0003\u001a\u00030\u0097\u0003H\u0002J\n\u0010Ý\u0003\u001a\u00030\u0097\u0003H\u0014J\n\u0010Þ\u0003\u001a\u00030\u0097\u0003H\u0016J\n\u0010ß\u0003\u001a\u00030\u0097\u0003H\u0016J\b\u0010à\u0003\u001a\u00030\u0097\u0003J\b\u0010á\u0003\u001a\u00030\u0097\u0003J\u0013\u0010â\u0003\u001a\u00030\u0097\u00032\t\u0010\u0018\u001a\u0005\u0018\u00010ã\u0003J\u0018\u0010\u001f\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\u0018\u0010$\u001a\u00030\u0097\u00032\u0007\u0010¶\u0003\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020 J,\u0010ä\u0003\u001a\u00030\u0097\u00032\u001a\u0010å\u0003\u001a\u000e\u0012\t\b\u0001\u0012\u0005\u0018\u00010ç\u00030æ\u0003\"\u0005\u0018\u00010ç\u0003H\u0017¢\u0006\u0003\u0010è\u0003J\u0013\u0010é\u0003\u001a\u00030\u0097\u00032\t\u0010\u0018\u001a\u0005\u0018\u00010ã\u0003J\u0018\u0010=\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\u0018\u0010@\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\u0018\u0010C\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\u0018\u0010L\u001a\u00030\u0097\u00032\u0007\u0010¶\u0003\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020 J\u0018\u0010O\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\u0013\u0010ê\u0003\u001a\u00030\u0097\u00032\t\u0010\u0018\u001a\u0005\u0018\u00010ã\u0003J\u0018\u0010^\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J5\u0010ë\u0003\u001a\u00030\u0097\u00032\u0007\u0010¶\u0003\u001a\u00020\u00072\u0007\u0010ì\u0003\u001a\u00020 2\u0007\u0010í\u0003\u001a\u00020 2\u0007\u0010î\u0003\u001a\u00020 2\u0007\u0010ï\u0003\u001a\u00020 J,\u0010ë\u0003\u001a\u00030\u0097\u00032\u0007\u0010ì\u0003\u001a\u00020\u00072\u0007\u0010í\u0003\u001a\u00020\u00072\u0007\u0010î\u0003\u001a\u00020\u00072\u0007\u0010ï\u0003\u001a\u00020\u0007J\u0018\u0010a\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\u0018\u0010d\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\u0018\u0010g\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\u0018\u0010j\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\u0018\u0010w\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\u0013\u0010ð\u0003\u001a\u00030\u0097\u00032\u0007\u0010ñ\u0003\u001a\u00020-H\u0015J\u0015\u0010ò\u0003\u001a\u00030\u0097\u00032\t\u0010\u0018\u001a\u0005\u0018\u00010ó\u0003H&J\u0010\u0010ô\u0003\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 J\u0019\u0010ô\u0003\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\u0019\u0010§\u0001\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\u0013\u0010õ\u0003\u001a\u00030\u0097\u00032\u0007\u0010ñ\u0003\u001a\u00020-H\u0016J\u0013\u0010ö\u0003\u001a\u00030\u0097\u00032\t\u0010\u0018\u001a\u0005\u0018\u00010÷\u0003J\u0013\u0010ø\u0003\u001a\u00030\u0097\u00032\t\u0010\u0018\u001a\u0005\u0018\u00010÷\u0003J\b\u0010ù\u0003\u001a\u00030\u0097\u0003J\b\u0010ú\u0003\u001a\u00030\u0097\u0003J\u0019\u0010ó\u0001\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\u0013\u0010û\u0003\u001a\u00030\u0097\u00032\t\u0010\u0018\u001a\u0005\u0018\u00010ã\u0003J\u0019\u0010\u008e\u0002\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\u0019\u0010\u0091\u0002\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\u0013\u0010ü\u0003\u001a\u00030\u0097\u00032\u0007\u0010ý\u0003\u001a\u00020-H\u0015J\u0013\u0010þ\u0003\u001a\u00030\u0097\u00032\u0007\u0010ÿ\u0003\u001a\u00020-H\u0004J\u0013\u0010\u0080\u0004\u001a\u00030\u0097\u00032\t\u0010\u0018\u001a\u0005\u0018\u00010ã\u0003J\u0019\u0010»\u0002\u001a\u00030\u0097\u00032\u0007\u0010¶\u0003\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020 J\u0019\u0010Ñ\u0002\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\u0019\u0010Ô\u0002\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\u0011\u0010\u0081\u0004\u001a\u00030\u0097\u00032\u0007\u0010\u0018\u001a\u00030\u0082\u0004J\b\u0010\u0083\u0004\u001a\u00030\u0097\u0003J\b\u0010\u0084\u0004\u001a\u00030\u0097\u0003J\u0013\u0010\u0085\u0004\u001a\u00030\u0097\u00032\t\u0010\u0018\u001a\u0005\u0018\u00010÷\u0003J\u0013\u0010\u0086\u0004\u001a\u00030\u0097\u00032\u0007\u0010\u0087\u0004\u001a\u00020\u0007H\u0016J\u0013\u0010\u0088\u0004\u001a\u00030\u0097\u00032\t\u0010\u0018\u001a\u0005\u0018\u00010ã\u0003J\u0019\u0010\u0082\u0003\u001a\u00030\u0097\u00032\u0007\u0010¶\u0003\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020 J\u0019\u0010\u0088\u0003\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\u0019\u0010\u008b\u0003\u001a\u00030\u0097\u00032\u0006\u0010\u0018\u001a\u00020 2\u0007\u0010¶\u0003\u001a\u00020\u0007J\n\u0010\u0089\u0004\u001a\u00030\u0097\u0003H\u0002J\n\u0010\u008a\u0004\u001a\u00030\u0097\u0003H\u0002J\n\u0010\u008b\u0004\u001a\u00030\u0097\u0003H\u0015J\n\u0010\u008c\u0004\u001a\u00030\u0097\u0003H\u0015J\n\u0010\u008d\u0004\u001a\u00030\u0097\u0003H\u0002J\n\u0010\u008e\u0004\u001a\u00030\u0097\u0003H\u0002J\n\u0010\u008f\u0004\u001a\u00030\u0097\u0003H\u0002J\n\u0010\u0090\u0004\u001a\u00030\u0097\u0003H\u0002J\n\u0010\u0091\u0004\u001a\u00030\u0097\u0003H\u0002J\n\u0010\u0092\u0004\u001a\u00030\u0097\u0003H\u0002J\n\u0010\u0093\u0004\u001a\u00030\u0097\u0003H\u0002J\n\u0010\u0094\u0004\u001a\u00030\u0097\u0003H\u0002J\n\u0010\u0095\u0004\u001a\u00030\u0097\u0003H\u0004J\b\u0010\u0096\u0004\u001a\u00030\u0097\u0003J\n\u0010\u0097\u0004\u001a\u00030\u0097\u0003H\u0014J\n\u0010\u0098\u0004\u001a\u00030\u0097\u0003H\u0002J\u0013\u0010\u0099\u0004\u001a\u00030\u0097\u00032\u0007\u0010\u009a\u0004\u001a\u00020-H\u0002J\n\u0010\u009b\u0004\u001a\u00030\u0097\u0003H$J\u001e\u0010\u009c\u0004\u001a\u00030\u0097\u00032\b\u0010\u009d\u0004\u001a\u00030\u009e\u00042\b\u0010\u009f\u0004\u001a\u00030¿\u0003H\u0004J\u0014\u0010 \u0004\u001a\u00030\u0097\u00032\b\u0010\u009f\u0004\u001a\u00030¿\u0003H\u0015J\n\u0010¡\u0004\u001a\u00030\u0097\u0003H\u0014J\n\u0010¢\u0004\u001a\u00030\u0097\u0003H\u0002J&\u0010£\u0004\u001a\u00030\u0097\u00032\b\u0010\u009d\u0004\u001a\u00030\u0085\u00012\u0007\u0010¤\u0004\u001a\u00020\u00072\u0007\u0010¥\u0004\u001a\u00020\u0007H\u0004J\u001d\u0010¦\u0004\u001a\u00030\u0097\u00032\b\u0010§\u0004\u001a\u00030\u009e\u00042\u0007\u0010¨\u0004\u001a\u00020-H\u0004J\u0013\u0010©\u0004\u001a\u00030\u0097\u00032\u0007\u0010\u009a\u0004\u001a\u00020-H\u0004J\n\u0010ª\u0004\u001a\u00030\u0097\u0003H\u0004J\n\u0010«\u0004\u001a\u00030\u0097\u0003H\u0014J\u0012\u0010¬\u0004\u001a\u00020-2\u0007\u0010\u00ad\u0004\u001a\u00020WH\u0014R\u0014\u0010\t\u001a\u00020\u00078TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R$\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\u001cR$\u0010!\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\u0018\u001a\u0004\u0018\u00010&8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u0010\u000b\"\u0004\b4\u0010\u001cR$\u00106\u001a\u0002052\u0006\u0010\u0018\u001a\u0002058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010;\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u0010\u000b\"\u0004\b=\u0010\u001cR$\u0010>\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010#\"\u0004\b@\u0010%R$\u0010A\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010#\"\u0004\bC\u0010%R\u001b\u0010D\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bF\u0010GR$\u0010J\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bK\u0010#\"\u0004\bL\u0010%R$\u0010M\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010\u000b\"\u0004\bO\u0010\u001cR(\u0010P\u001a\u0004\u0018\u00010&2\b\u0010\u0018\u001a\u0004\u0018\u00010&8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010)\"\u0004\bR\u0010+R$\u0010S\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010\u000b\"\u0004\bU\u0010\u001cR\u001c\u0010V\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010\\\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010\u000b\"\u0004\b^\u0010\u001cR$\u0010_\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b`\u0010\u000b\"\u0004\ba\u0010\u001cR$\u0010b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bc\u0010\u000b\"\u0004\bd\u0010\u001cR$\u0010e\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bf\u0010\u000b\"\u0004\bg\u0010\u001cR$\u0010h\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bi\u0010\u000b\"\u0004\bj\u0010\u001cR\u0011\u0010k\u001a\u00020l8F¢\u0006\u0006\u001a\u0004\bm\u0010nR\u0018\u0010o\u001a\u00020pX¦\u000e¢\u0006\f\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR$\u0010u\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bv\u0010\u000b\"\u0004\bw\u0010\u001cR(\u0010x\u001a\u0004\u0018\u00010W2\b\u0010\u0018\u001a\u0004\u0018\u00010W8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\by\u0010Y\"\u0004\bz\u0010[R$\u0010{\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b|\u0010\u000b\"\u0004\b}\u0010\u001cR(\u0010\u007f\u001a\u00020~2\u0006\u0010\u0018\u001a\u00020~@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0012\u0010\u0084\u0001\u001a\u00030\u0085\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R'\u0010\u0086\u0001\u001a\u00020-2\u0006\u0010\u0018\u001a\u00020-@@X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010/\"\u0005\b\u0088\u0001\u00101R\"\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R \u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R+\u0010\u0096\u0001\u001a\u00030\u0095\u00012\u0007\u0010\u0018\u001a\u00030\u0095\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0011\u0010\u009b\u0001\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010\u009c\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009d\u0001\u0010\u000b\"\u0005\b\u009e\u0001\u0010\u001cR'\u0010\u009f\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b \u0001\u0010\u000b\"\u0005\b¡\u0001\u0010\u001cR'\u0010¢\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b£\u0001\u0010\u000b\"\u0005\b¤\u0001\u0010\u001cR'\u0010¥\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¦\u0001\u0010\u000b\"\u0005\b§\u0001\u0010\u001cR'\u0010¨\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b©\u0001\u0010\u000b\"\u0005\bª\u0001\u0010\u001cR'\u0010«\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¬\u0001\u0010\u000b\"\u0005\b\u00ad\u0001\u0010\u001cR'\u0010®\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¯\u0001\u0010\u000b\"\u0005\b°\u0001\u0010\u001cR'\u0010±\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b²\u0001\u0010\u000b\"\u0005\b³\u0001\u0010\u001cR'\u0010´\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bµ\u0001\u0010\u000b\"\u0005\b¶\u0001\u0010\u001cR'\u0010·\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¸\u0001\u0010\u000b\"\u0005\b¹\u0001\u0010\u001cR'\u0010º\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b»\u0001\u0010\u000b\"\u0005\b¼\u0001\u0010\u001cR'\u0010½\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¾\u0001\u0010\u000b\"\u0005\b¿\u0001\u0010\u001cR\u0016\u0010À\u0001\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0007\u001a\u0005\bÁ\u0001\u0010\u0013R\u0010\u0010Â\u0001\u001a\u00030Ã\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Ä\u0001\u001a\u00030Å\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010È\u0001\u001a\u0005\u0018\u00010É\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R/\u0010Ï\u0001\u001a\u0005\u0018\u00010Î\u00012\t\u0010\u0018\u001a\u0005\u0018\u00010Î\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÐ\u0001\u0010Ñ\u0001\"\u0006\bÒ\u0001\u0010Ó\u0001R+\u0010Ô\u0001\u001a\u0004\u0018\u00010W2\b\u0010\u0018\u001a\u0004\u0018\u00010W8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÕ\u0001\u0010Y\"\u0005\bÖ\u0001\u0010[R'\u0010×\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bØ\u0001\u0010\u000b\"\u0005\bÙ\u0001\u0010\u001cR'\u0010Ú\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÛ\u0001\u0010\u000b\"\u0005\bÜ\u0001\u0010\u001cR\u0012\u0010Ý\u0001\u001a\u00030\u0085\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R'\u0010Þ\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bß\u0001\u0010\u000b\"\u0005\bà\u0001\u0010\u001cR+\u0010á\u0001\u001a\u0004\u0018\u00010W2\b\u0010\u0018\u001a\u0004\u0018\u00010W8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bâ\u0001\u0010Y\"\u0005\bã\u0001\u0010[R'\u0010ä\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bå\u0001\u0010\u000b\"\u0005\bæ\u0001\u0010\u001cR\u0012\u0010ç\u0001\u001a\u00030\u0085\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R,\u0010è\u0001\u001a\u0004\u0018\u00010\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00118F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\bé\u0001\u0010\u0013\"\u0006\bê\u0001\u0010ë\u0001R\u0012\u0010ì\u0001\u001a\u00030í\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R'\u0010î\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bï\u0001\u0010\u000b\"\u0005\bð\u0001\u0010\u001cR'\u0010ñ\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bò\u0001\u0010\u000b\"\u0005\bó\u0001\u0010\u001cR'\u0010ô\u0001\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bõ\u0001\u0010\u000b\"\u0005\bö\u0001\u0010\u001cR\u000f\u0010÷\u0001\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010ø\u0001\u001a\u00030ù\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010ú\u0001\u001a\u00020-2\u0006\u0010\u0018\u001a\u00020-@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bû\u0001\u0010/\"\u0005\bü\u0001\u00101R\u0014\u0010ý\u0001\u001a\u00020-X¤\u0004¢\u0006\u0007\u001a\u0005\bþ\u0001\u0010/R,\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00118F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b\u0080\u0002\u0010\u0013\"\u0006\b\u0081\u0002\u0010ë\u0001R'\u0010\u0082\u0002\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0083\u0002\u0010\u000b\"\u0005\b\u0084\u0002\u0010\u001cR\u0012\u0010\u0085\u0002\u001a\u00030í\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R+\u0010\u0087\u0002\u001a\u00030\u0086\u00022\u0007\u0010\u0018\u001a\u00030\u0086\u0002@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0002\u0010\u0089\u0002\"\u0006\b\u008a\u0002\u0010\u008b\u0002R'\u0010\u008c\u0002\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008d\u0002\u0010\u000b\"\u0005\b\u008e\u0002\u0010\u001cR'\u0010\u008f\u0002\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0090\u0002\u0010\u000b\"\u0005\b\u0091\u0002\u0010\u001cR\u0013\u0010\u0092\u0002\u001a\u00020\u00078F¢\u0006\u0007\u001a\u0005\b\u0093\u0002\u0010\u000bR\u0013\u0010\u0094\u0002\u001a\u00020\u00118F¢\u0006\u0007\u001a\u0005\b\u0095\u0002\u0010\u0013R(\u0010\u0097\u0002\u001a\u00020\u00072\u0007\u0010\u0096\u0002\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0098\u0002\u0010\u000b\"\u0005\b\u0099\u0002\u0010\u001cR'\u0010\u009a\u0002\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0002\u0010\u000b\"\u0005\b\u009c\u0002\u0010\u001cR\u0016\u0010\u009d\u0002\u001a\u00030í\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u009e\u0002\u0010\u009f\u0002R(\u0010¡\u0002\u001a\u00020-2\u0007\u0010 \u0002\u001a\u00020-@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0002\u0010/\"\u0005\b¢\u0002\u00101R(\u0010£\u0002\u001a\u00020-2\u0007\u0010 \u0002\u001a\u00020-@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0002\u0010/\"\u0005\b¤\u0002\u00101R'\u0010¥\u0002\u001a\u00020-2\u0006\u0010\u0018\u001a\u00020-@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0002\u0010/\"\u0005\b¦\u0002\u00101R\u0016\u0010§\u0002\u001a\u00020-X\u0094D¢\u0006\t\n\u0000\u001a\u0005\b§\u0002\u0010/R'\u0010¨\u0002\u001a\u00020-2\u0006\u0010\u0018\u001a\u00020-@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0002\u0010/\"\u0005\b©\u0002\u00101R!\u0010«\u0002\u001a\u00020-2\u0007\u0010ª\u0002\u001a\u00020-@BX\u0084\u000e¢\u0006\t\n\u0000\u001a\u0005\b«\u0002\u0010/R(\u0010¬\u0002\u001a\u00020-2\u0007\u0010 \u0002\u001a\u00020-@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¬\u0002\u0010/\"\u0005\b\u00ad\u0002\u00101R \u0010®\u0002\u001a\u00030¯\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b²\u0002\u0010I\u001a\u0006\b°\u0002\u0010±\u0002R'\u0010³\u0002\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b´\u0002\u0010\u000b\"\u0005\bµ\u0002\u0010\u001cR,\u0010¶\u0002\u001a\u0004\u0018\u00010\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00118F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b·\u0002\u0010\u0013\"\u0006\b¸\u0002\u0010ë\u0001R'\u0010¹\u0002\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020 8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bº\u0002\u0010#\"\u0005\b»\u0002\u0010%R\u0012\u0010¼\u0002\u001a\u00030í\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R+\u0010½\u0002\u001a\u0004\u0018\u00010&2\b\u0010\u0018\u001a\u0004\u0018\u00010&8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¾\u0002\u0010)\"\u0005\b¿\u0002\u0010+R'\u0010À\u0002\u001a\n\u0012\u0005\u0012\u00030Â\u00020Á\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÃ\u0002\u0010Ä\u0002\"\u0006\bÅ\u0002\u0010Æ\u0002R\u0018\u0010Ç\u0002\u001a\u00030È\u00028TX\u0094\u0004¢\u0006\b\u001a\u0006\bÉ\u0002\u0010Ê\u0002R\u0018\u0010Ë\u0002\u001a\u00030Ì\u0002X\u0084\u0004¢\u0006\n\n\u0000\u001a\u0006\bÍ\u0002\u0010Î\u0002R'\u0010Ï\u0002\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÐ\u0002\u0010\u000b\"\u0005\bÑ\u0002\u0010\u001cR'\u0010Ò\u0002\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÓ\u0002\u0010\u000b\"\u0005\bÔ\u0002\u0010\u001cR/\u0010Ö\u0002\u001a\u0005\u0018\u00010Õ\u00022\t\u0010\u0018\u001a\u0005\u0018\u00010Õ\u0002@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b×\u0002\u0010Ø\u0002\"\u0006\bÙ\u0002\u0010Ú\u0002R-\u0010Û\u0002\u001a\u0004\u0018\u00010\u00112\t\u0010Û\u0002\u001a\u0004\u0018\u00010\u0011@FX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bÜ\u0002\u0010\u0013\"\u0006\bÝ\u0002\u0010ë\u0001R'\u0010Þ\u0002\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bß\u0002\u0010\u000b\"\u0005\bà\u0002\u0010\u001cR,\u0010á\u0002\u001a\u0004\u0018\u00010\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00118F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\bâ\u0002\u0010\u0013\"\u0006\bã\u0002\u0010ë\u0001R\u0012\u0010ä\u0002\u001a\u00030í\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R'\u0010å\u0002\u001a\u00020-2\u0006\u0010\u0018\u001a\u00020-@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bæ\u0002\u0010/\"\u0005\bç\u0002\u00101R+\u0010è\u0002\u001a\u0004\u0018\u00010W2\b\u0010\u0018\u001a\u0004\u0018\u00010W8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bé\u0002\u0010Y\"\u0005\bê\u0002\u0010[R'\u0010ë\u0002\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bì\u0002\u0010\u000b\"\u0005\bí\u0002\u0010\u001cR'\u0010î\u0002\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bï\u0002\u0010\u000b\"\u0005\bð\u0002\u0010\u001cR\u0012\u0010ñ\u0002\u001a\u00030\u0085\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010ò\u0002\u001a\u00030ó\u0002X¦\u0004¢\u0006\b\u001a\u0006\bô\u0002\u0010õ\u0002R,\u0010ö\u0002\u001a\u0004\u0018\u00010\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00118F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b÷\u0002\u0010\u0013\"\u0006\bø\u0002\u0010ë\u0001R\u0012\u0010ù\u0002\u001a\u00030í\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R'\u0010ú\u0002\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bû\u0002\u0010\u000b\"\u0005\bü\u0002\u0010\u001cR'\u0010ý\u0002\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bþ\u0002\u0010\u000b\"\u0005\bÿ\u0002\u0010\u001cR'\u0010\u0080\u0003\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020 8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0081\u0003\u0010#\"\u0005\b\u0082\u0003\u0010%R+\u0010\u0083\u0003\u001a\u0004\u0018\u00010&2\b\u0010\u0018\u001a\u0004\u0018\u00010&@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0003\u0010)\"\u0005\b\u0085\u0003\u0010+R'\u0010\u0086\u0003\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020 8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0087\u0003\u0010#\"\u0005\b\u0088\u0003\u0010%R'\u0010\u0089\u0003\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020 8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008a\u0003\u0010#\"\u0005\b\u008b\u0003\u0010%R'\u0010\u008c\u0003\u001a\n\u0012\u0005\u0012\u00030Â\u00020Á\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008d\u0003\u0010Ä\u0002\"\u0006\b\u008e\u0003\u0010Æ\u0002R\u0018\u0010\u008f\u0003\u001a\u00020\u0007*\u00020\u00078F¢\u0006\b\u001a\u0006\b\u0090\u0003\u0010\u0091\u0003R\u0019\u0010\u0092\u0003\u001a\u00030Å\u0001*\u00020\u00078F¢\u0006\b\u001a\u0006\b\u0093\u0003\u0010\u0094\u0003R\u001a\u0010\u0092\u0003\u001a\u00030Å\u0001*\u00030Å\u00018F¢\u0006\b\u001a\u0006\b\u0093\u0003\u0010\u0095\u0003¨\u0006±\u0004"}, d2 = {"Lcom/devexpress/editors/EditBase;", "Lcom/devexpress/dxcore/DXNativeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actualEditorInputType", "getActualEditorInputType", "()I", "actualInternalEditorView", "Landroid/view/View;", "getActualInternalEditorView", "()Landroid/view/View;", "actualPlaceholder", "", "getActualPlaceholder", "()Ljava/lang/CharSequence;", "actualPrefix", "getActualPrefix", "actualSuffix", "getActualSuffix", "value", "affixColor", "getAffixColor", "setAffixColor", "(I)V", "affixIndent", "getAffixIndent", "setAffixIndent", "", "affixTextSize", "getAffixTextSize", "()F", "setAffixTextSize", "(F)V", "Landroid/graphics/Typeface;", "affixTypeface", "getAffixTypeface", "()Landroid/graphics/Typeface;", "setAffixTypeface", "(Landroid/graphics/Typeface;)V", "allowAnimations", "", "getAllowAnimations", "()Z", "setAllowAnimations", "(Z)V", "borderColor", "getBorderColor", "setBorderColor", "Lcom/devexpress/editors/DXBorderMode;", "borderMode", "getBorderMode", "()Lcom/devexpress/editors/DXBorderMode;", "setBorderMode", "(Lcom/devexpress/editors/DXBorderMode;)V", "borderThickness", "getBorderThickness", "setBorderThickness", "bottomLeftCornerRadius", "getBottomLeftCornerRadius", "setBottomLeftCornerRadius", "bottomRightCornerRadius", "getBottomRightCornerRadius", "setBottomRightCornerRadius", "bottomTextAnimator", "Lcom/devexpress/editors/animations/BottomTextAnimator;", "getBottomTextAnimator", "()Lcom/devexpress/editors/animations/BottomTextAnimator;", "bottomTextAnimator$delegate", "Lkotlin/Lazy;", "bottomTextSize", "getBottomTextSize", "setBottomTextSize", "bottomTextTopIndent", "getBottomTextTopIndent", "setBottomTextTopIndent", "bottomTextTypeface", "getBottomTextTypeface", "setBottomTextTypeface", "boxBackgroundColor", "getBoxBackgroundColor", "setBoxBackgroundColor", "boxBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getBoxBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setBoxBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "boxHeight", "getBoxHeight", "setBoxHeight", "boxPaddingBottom", "getBoxPaddingBottom", "setBoxPaddingBottom", "boxPaddingEnd", "getBoxPaddingEnd", "setBoxPaddingEnd", "boxPaddingStart", "getBoxPaddingStart", "setBoxPaddingStart", "boxPaddingTop", "getBoxPaddingTop", "setBoxPaddingTop", "boxRect", "Landroid/graphics/Rect;", "getBoxRect", "()Landroid/graphics/Rect;", "characterCasing", "Lcom/devexpress/editors/DXCharacterCasing;", "getCharacterCasing", "()Lcom/devexpress/editors/DXCharacterCasing;", "setCharacterCasing", "(Lcom/devexpress/editors/DXCharacterCasing;)V", "characterCounterStartIndent", "getCharacterCounterStartIndent", "setCharacterCounterStartIndent", "clearIcon", "getClearIcon", "setClearIcon", "clearIconColor", "getClearIconColor", "setClearIconColor", "Lcom/devexpress/editors/DXIconVisibility;", "clearIconVisibility", "getClearIconVisibility", "()Lcom/devexpress/editors/DXIconVisibility;", "setClearIconVisibility", "(Lcom/devexpress/editors/DXIconVisibility;)V", "clearImage", "Landroidx/appcompat/widget/AppCompatImageButton;", "containsFocus", "getContainsFocus", "setContainsFocus$dxeditors_release", "containsFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "getContainsFocusChangeListener", "()Landroid/view/View$OnFocusChangeListener;", "setContainsFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "contentLayout", "Lcom/devexpress/editors/layout2/Layout;", "getContentLayout", "()Lcom/devexpress/editors/layout2/Layout;", "setContentLayout", "(Lcom/devexpress/editors/layout2/Layout;)V", "Lcom/devexpress/editors/DXCornerMode;", "cornerMode", "getCornerMode", "()Lcom/devexpress/editors/DXCornerMode;", "setCornerMode", "(Lcom/devexpress/editors/DXCornerMode;)V", "currentFocus", "cursorColor", "getCursorColor", "setCursorColor", "disabledAffixColor", "getDisabledAffixColor", "setDisabledAffixColor", "disabledBorderColor", "getDisabledBorderColor", "setDisabledBorderColor", "disabledBorderThickness", "getDisabledBorderThickness", "setDisabledBorderThickness", "disabledBoxBackgroundColor", "getDisabledBoxBackgroundColor", "setDisabledBoxBackgroundColor", "disabledClearIconColor", "getDisabledClearIconColor", "setDisabledClearIconColor", "disabledEndIconColor", "getDisabledEndIconColor", "setDisabledEndIconColor", "disabledErrorIconColor", "getDisabledErrorIconColor", "setDisabledErrorIconColor", "disabledHelpTextColor", "getDisabledHelpTextColor", "setDisabledHelpTextColor", "disabledLabelColor", "getDisabledLabelColor", "setDisabledLabelColor", "disabledStartIconColor", "getDisabledStartIconColor", "setDisabledStartIconColor", "disabledTextColor", "getDisabledTextColor", "setDisabledTextColor", "displayText", "getDisplayText", "downPosition", "Landroid/graphics/PointF;", "downTime", "", "drawableManager", "Lcom/devexpress/editors/utils/drawablemanager/BackgroundDrawableManager;", "editorGestureListener", "Lcom/devexpress/editors/EditorGestureListener;", "getEditorGestureListener", "()Lcom/devexpress/editors/EditorGestureListener;", "setEditorGestureListener", "(Lcom/devexpress/editors/EditorGestureListener;)V", "Landroid/text/TextUtils$TruncateAt;", "ellipsize", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "setEllipsize", "(Landroid/text/TextUtils$TruncateAt;)V", "endIcon", "getEndIcon", "setEndIcon", "endIconColor", "getEndIconColor", "setEndIconColor", "endIconVerticalGravity", "getEndIconVerticalGravity", "setEndIconVerticalGravity", "endImage", "errorColor", "getErrorColor", "setErrorColor", "errorIcon", "getErrorIcon", "setErrorIcon", "errorIconColor", "getErrorIconColor", "setErrorIconColor", "errorImage", "errorText", "getErrorText", "setErrorText", "(Ljava/lang/CharSequence;)V", "errorTextView", "Landroid/widget/TextView;", "focusedBorderColor", "getFocusedBorderColor", "setFocusedBorderColor", "focusedBorderThickness", "getFocusedBorderThickness", "setFocusedBorderThickness", "focusedLabelColor", "getFocusedLabelColor", "setFocusedLabelColor", "forceXamarinKeepFocus", "globalFocusChangeListener", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "hasError", "getHasError", "setHasError", "hasValue", "getHasValue", "helpText", "getHelpText", "setHelpText", "helpTextColor", "getHelpTextColor", "setHelpTextColor", "helpTextView", "Lcom/devexpress/editors/DXVerticalAlignment;", "iconAlignment", "getIconAlignment", "()Lcom/devexpress/editors/DXVerticalAlignment;", "setIconAlignment", "(Lcom/devexpress/editors/DXVerticalAlignment;)V", "iconIndent", "getIconIndent", "setIconIndent", "iconSpacing", "getIconSpacing", "setIconSpacing", "imeActionId", "getImeActionId", "imeActionLabel", "getImeActionLabel", "options", "imeActionOptions", "getImeActionOptions", "setImeActionOptions", "inputType", "getInputType", "setInputType", "internalEditor", "getInternalEditor", "()Landroid/widget/TextView;", "visible", "isEndIconVisible", "setEndIconVisible", "isErrorIconVisible", "setErrorIconVisible", "isLabelFloating", "setLabelFloating", "isMultilineEdit", "isReadOnly", "setReadOnly", "<set-?>", "isRefreshSuspended", "isStartIconVisible", "setStartIconVisible", "labelAnimator", "Lcom/devexpress/editors/animations/LabelAnimator;", "getLabelAnimator", "()Lcom/devexpress/editors/animations/LabelAnimator;", "labelAnimator$delegate", "labelColor", "getLabelColor", "setLabelColor", "labelText", "getLabelText", "setLabelText", "labelTextSize", "getLabelTextSize", "setLabelTextSize", "labelTextView", "labelTypeface", "getLabelTypeface", "setLabelTypeface", "leadingIconElements", "", "Lcom/devexpress/editors/layout/Element;", "getLeadingIconElements$dxeditors_release", "()Ljava/util/List;", "setLeadingIconElements$dxeditors_release", "(Ljava/util/List;)V", "locale", "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", "locker", "Lcom/devexpress/editors/DXLocker;", "getLocker", "()Lcom/devexpress/editors/DXLocker;", "minBoxHeight", "getMinBoxHeight", "setMinBoxHeight", "minBoxWidth", "getMinBoxWidth", "setMinBoxWidth", "Lcom/devexpress/editors/OnEditActionListener;", "onEditActionListener", "getOnEditActionListener", "()Lcom/devexpress/editors/OnEditActionListener;", "setOnEditActionListener", "(Lcom/devexpress/editors/OnEditActionListener;)V", "placeholder", "getPlaceholder", "setPlaceholder", "placeholderColor", "getPlaceholderColor", "setPlaceholderColor", "prefix", "getPrefix", "setPrefix", "prefixView", "reserveBottomTextLine", "getReserveBottomTextLine", "setReserveBottomTextLine", "startIcon", "getStartIcon", "setStartIcon", "startIconColor", "getStartIconColor", "setStartIconColor", "startIconVerticalGravity", "getStartIconVerticalGravity", "setStartIconVerticalGravity", "startImage", "style", "Lcom/devexpress/editors/style/TextEditStyle;", "getStyle", "()Lcom/devexpress/editors/style/TextEditStyle;", "suffix", "getSuffix", "setSuffix", "suffixView", "textColor", "getTextColor", "setTextColor", "textGravity", "getTextGravity", "setTextGravity", "textSize", "getTextSize", "setTextSize", "textTypeface", "getTextTypeface", "setTextTypeface", "topLeftCornerRadius", "getTopLeftCornerRadius", "setTopLeftCornerRadius", "topRightCornerRadius", "getTopRightCornerRadius", "setTopRightCornerRadius", "trailingIconElements", "getTrailingIconElements$dxeditors_release", "setTrailingIconElements$dxeditors_release", "dp", "getDp", "(I)I", "ms", "getMs", "(I)J", "(J)J", "beginBottomTextTransition", "", "calcHitTest", "Lcom/devexpress/editors/HitTestType;", "x", "y", "createBottomTextAnimator", "createLabelAnimator", "createLayout", "createLayoutElementsFactory", "Lcom/devexpress/editors/LayoutElementsFactory;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "drawableStateChanged", "finishInitialization", "forceLayout", "getCursorDrawable", "hideSoftKeyboard", "initDefaultStyle", "initStyle", "jumpDrawablesToCurrentState", "layoutIcons", "icons", "l", "t", "r", "b", "onAffixColorChanged", "onAttachedToWindow", "onBorderModeChanged", "onBottomTextSizeChanged", "unit", "onBottomTextTypefaceChanged", "typeface", "onClearIconColorsChanged", "onColorSettingsChanged", "onContainsFocusChange", "onCornerModeChanged", "onCornerRadiusChanged", "onCreateDrawableState", "", "extraSpace", "onCursorColorChanged", "onDetachedFromWindow", "onDispatchActionUp", "hitTest", "onDoubleTap", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onEditorAction", "actionId", "onEditorInputTypeChange", "onEndIconColorsChanged", "onErrorColorChanged", "onErrorIconColorsChanged", "onHelpTextColorChanged", "onLayout", "changed", "onLayoutSettingsChanged", "onLongPress", "onMeasureCore", "Landroid/util/Size;", "widthMeasureSpec", "heightMeasureSpec", "onPlaceholderColorChanged", "onReadOnlyChanged", "onSingleTapUp", "onStartIconColorsChanged", "onTextColorChanged", "onValueChanged", "refreshDrawableState", "requestLayout", "resetBoxPadding", "resumeRender", "setAffixColors", "Landroid/content/res/ColorStateList;", "setAutofillHints", "autofillHints", "", "", "([Ljava/lang/String;)V", "setBorderColors", "setBoxBackgroundColors", "setBoxPadding", "start", "top", "end", "bottom", "setChildrenEnabled", "enabled", "setClearIconClickedListener", "Lcom/devexpress/editors/OnClickHandledListener;", "setCornerRadius", "setEnabled", "setEndIconClickedListener", "Landroid/view/View$OnClickListener;", "setErrorIconClickedListener", "setFilledCutStyle", "setFilledStyle", "setHelpTextColors", "setInternalEditorEditable", "isEditable", "setInternalEditorTextSelectable", "isSelectable", "setLabelColors", "setOnBoxMarginChangedListener", "Lcom/devexpress/editors/layout/OnBoxMarginChangedListener;", "setOutlinedCutStyle", "setOutlinedStyle", "setStartIconClickedListener", "setTextAlignment", "textAlignment", "setTextColors", "setupAffix", "setupClearIcon", "setupCommonStyleColors", "setupCommonStyleSizes", "setupFilledStyleColors", "setupFilledStyleSizes", "setupHelpAndError", "setupImages", "setupInternalEditor", "setupLabel", "setupOutlinedStyleColors", "setupOutlinedStyleSizes", "showSoftKeyboard", "suspendRender", "updateAll", "updateAppearance", "updateBottomTextState", "animated", "updateClearImageVisibility", "updateDrawableTintMode", "iconView", "Landroid/widget/ImageView;", "state", "updateDrawablesTintMode", "updateEditorTextSettings", "updateErrorTextTextColor", "updateIconTintList", TypedValues.Custom.S_COLOR, "disabledColor", "updateIconVisibility", "image", "isVisible", "updateLabelState", "updatePlaceholderText", "updateStrategyText", "verifyDrawable", "who", "Companion", "GlobalFocusChangedListener", "OnEditorActionListener", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class EditBase extends DXNativeView {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean allowAnimations;

    /* renamed from: bottomTextAnimator$delegate, reason: from kotlin metadata */
    private final Lazy bottomTextAnimator;
    private Drawable boxBackgroundDrawable;
    private DXIconVisibility clearIconVisibility;
    public final AppCompatImageButton clearImage;
    private boolean containsFocus;
    private View.OnFocusChangeListener containsFocusChangeListener;
    private Layout contentLayout;
    private View currentFocus;
    private PointF downPosition;
    private long downTime;
    private BackgroundDrawableManager drawableManager;
    private EditorGestureListener editorGestureListener;
    public final AppCompatImageButton endImage;
    public final AppCompatImageButton errorImage;
    public final TextView errorTextView;
    private boolean forceXamarinKeepFocus;
    private ViewTreeObserver.OnGlobalFocusChangeListener globalFocusChangeListener;
    private boolean hasError;
    public final TextView helpTextView;
    private DXVerticalAlignment iconAlignment;
    private int inputType;
    private boolean isEndIconVisible;
    private boolean isErrorIconVisible;
    private boolean isLabelFloating;
    private final boolean isMultilineEdit;
    private boolean isReadOnly;
    private boolean isRefreshSuspended;
    private boolean isStartIconVisible;

    /* renamed from: labelAnimator$delegate, reason: from kotlin metadata */
    private final Lazy labelAnimator;
    public final TextView labelTextView;
    private List<? extends Element> leadingIconElements;
    private final DXLocker locker;
    private OnEditActionListener onEditActionListener;
    private CharSequence placeholder;
    public final TextView prefixView;
    private boolean reserveBottomTextLine;
    public final AppCompatImageButton startImage;
    public final TextView suffixView;
    private Typeface textTypeface;
    private List<? extends Element> trailingIconElements;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EditBase(Context context, int i) {
        this(context, null, i, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @JvmStatic
    public static final Function1<LabelPosition, Unit> createLabelStateChangedCallback(EditBase editBase) {
        return INSTANCE.createLabelStateChangedCallback(editBase);
    }

    public abstract DXCharacterCasing getCharacterCasing();

    public abstract CharSequence getDisplayText();

    protected abstract boolean getHasValue();

    public abstract TextView getInternalEditor();

    public final long getMs(int i) {
        return i * DurationKt.NANOS_IN_MILLIS;
    }

    public final long getMs(long j) {
        return j * DurationKt.NANOS_IN_MILLIS;
    }

    /* renamed from: getStyle */
    public abstract TextEditStyle getDropDownStyle();

    public abstract void setCharacterCasing(DXCharacterCasing dXCharacterCasing);

    public abstract void setClearIconClickedListener(OnClickHandledListener value);

    public final void setOnBoxMarginChangedListener(OnBoxMarginChangedListener value) {
        Intrinsics.checkNotNullParameter(value, "value");
    }

    protected abstract void updateClearImageVisibility();

    protected void updateStrategyText() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.labelTextView = new AppCompatTextView(context);
        this.helpTextView = new AppCompatTextView(context);
        this.errorTextView = new AppCompatTextView(context);
        this.suffixView = new AppCompatTextView(context);
        this.prefixView = new AppCompatTextView(context);
        this.startImage = new AppCompatImageButton(context);
        this.endImage = new AppCompatImageButton(context);
        this.errorImage = new AppCompatImageButton(context);
        this.clearImage = new AppCompatImageButton(context);
        this.locker = new DXLocker();
        this.labelAnimator = LazyKt.lazy(new Function0<LabelAnimator>() { // from class: com.devexpress.editors.EditBase$labelAnimator$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LabelAnimator invoke() {
                LabelAnimator createLabelAnimator;
                createLabelAnimator = EditBase.this.createLabelAnimator();
                return createLabelAnimator;
            }
        });
        this.bottomTextAnimator = LazyKt.lazy(new Function0<BottomTextAnimator>() { // from class: com.devexpress.editors.EditBase$bottomTextAnimator$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BottomTextAnimator invoke() {
                BottomTextAnimator createBottomTextAnimator;
                createBottomTextAnimator = EditBase.this.createBottomTextAnimator();
                return createBottomTextAnimator;
            }
        });
        this.contentLayout = createLayout(DXBorderMode.Outlined);
        this.allowAnimations = true;
        this.isLabelFloating = true;
        this.iconAlignment = DXVerticalAlignment.Center;
        this.isStartIconVisible = true;
        this.isEndIconVisible = true;
        this.isErrorIconVisible = true;
        this.clearIconVisibility = DXIconVisibility.Auto;
        this.leadingIconElements = new ArrayList();
        this.trailingIconElements = new ArrayList();
        this.downPosition = new PointF();
        this.globalFocusChangeListener = new GlobalFocusChangedListener();
        setClipToPadding(false);
        setClipChildren(false);
    }

    public /* synthetic */ EditBase(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, i);
    }

    public final Drawable getBoxBackgroundDrawable() {
        return this.boxBackgroundDrawable;
    }

    public final void setBoxBackgroundDrawable(Drawable drawable) {
        this.boxBackgroundDrawable = drawable;
    }

    protected final DXLocker getLocker() {
        return this.locker;
    }

    /* renamed from: isRefreshSuspended, reason: from getter */
    protected final boolean getIsRefreshSuspended() {
        return this.isRefreshSuspended;
    }

    protected Locale getLocale() {
        if (Build.VERSION.SDK_INT >= 24) {
            Locale locale = getResources().getConfiguration().getLocales().get(0);
            Intrinsics.checkNotNull(locale);
            return locale;
        }
        Locale locale2 = getResources().getConfiguration().locale;
        Intrinsics.checkNotNull(locale2);
        return locale2;
    }

    private final LabelAnimator getLabelAnimator() {
        return (LabelAnimator) this.labelAnimator.getValue();
    }

    private final BottomTextAnimator getBottomTextAnimator() {
        return (BottomTextAnimator) this.bottomTextAnimator.getValue();
    }

    public final Rect getBoxRect() {
        return this.contentLayout.getBoxFrame().toRect();
    }

    public View getActualInternalEditorView() {
        return getInternalEditor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BottomTextAnimator createBottomTextAnimator() {
        return new BottomTextAnimator(this.helpTextView, this.errorTextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LabelAnimator createLabelAnimator() {
        return new LabelAnimator(this.labelTextView, getInternalEditor(), this.prefixView, this.suffixView, getDropDownStyle(), INSTANCE.createLabelStateChangedCallback(this));
    }

    protected LayoutElementsFactory createLayoutElementsFactory() {
        TextView internalEditor = getInternalEditor();
        TextView textView = this.labelTextView;
        AppCompatImageButton appCompatImageButton = this.startImage;
        AppCompatImageButton appCompatImageButton2 = this.endImage;
        AppCompatImageButton appCompatImageButton3 = this.clearImage;
        AppCompatImageButton appCompatImageButton4 = this.errorImage;
        TextView textView2 = this.errorTextView;
        return new EditLayoutElementsFactory(internalEditor, textView, appCompatImageButton, appCompatImageButton2, appCompatImageButton4, textView2, this.helpTextView, this.suffixView, this.prefixView, appCompatImageButton3);
    }

    /* renamed from: isMultilineEdit, reason: from getter */
    protected boolean getIsMultilineEdit() {
        return this.isMultilineEdit;
    }

    public final Layout getContentLayout() {
        return this.contentLayout;
    }

    public final void setContentLayout(Layout layout) {
        Intrinsics.checkNotNullParameter(layout, "<set-?>");
        this.contentLayout = layout;
    }

    public final int getInputType() {
        return this.inputType;
    }

    public final void setInputType(int i) {
        if (this.inputType == i) {
            return;
        }
        this.inputType = i;
        updateEditorTextSettings();
    }

    protected int getActualEditorInputType() {
        if (this.isReadOnly) {
            return 0;
        }
        if (getCharacterCasing() != DXCharacterCasing.Normal) {
            return 524288 | this.inputType;
        }
        return this.inputType;
    }

    protected void updateEditorTextSettings() {
        int selectionStart = getInternalEditor().getSelectionStart();
        int selectionEnd = getInternalEditor().getSelectionEnd();
        onEditorInputTypeChange();
        CharSequence text = getInternalEditor().getText();
        Spannable spannable = text instanceof Spannable ? (Spannable) text : null;
        if (spannable == null) {
            return;
        }
        Selection.setSelection(spannable, selectionStart, selectionEnd);
    }

    protected void onEditorInputTypeChange() {
        getInternalEditor().setInputType(getActualEditorInputType());
    }

    public final CharSequence getLabelText() {
        return this.labelTextView.getText();
    }

    public final void setLabelText(CharSequence charSequence) {
        if (Intrinsics.areEqual(this.labelTextView.getText(), charSequence)) {
            return;
        }
        this.labelTextView.setText(charSequence);
        onLayoutSettingsChanged();
        refreshDrawableState();
    }

    public final CharSequence getPlaceholder() {
        return this.placeholder;
    }

    public final void setPlaceholder(CharSequence charSequence) {
        if (Intrinsics.areEqual(this.placeholder, charSequence)) {
            return;
        }
        this.placeholder = charSequence;
        updatePlaceholderText();
        updateStrategyText();
    }

    public final CharSequence getHelpText() {
        return this.helpTextView.getText();
    }

    public final void setHelpText(CharSequence charSequence) {
        if (Intrinsics.areEqual(this.helpTextView.getText(), charSequence)) {
            return;
        }
        this.helpTextView.setText(charSequence);
        updateBottomTextState(this.allowAnimations);
    }

    public final CharSequence getErrorText() {
        return this.errorTextView.getText();
    }

    public final void setErrorText(CharSequence charSequence) {
        if (Intrinsics.areEqual(this.errorTextView.getText(), charSequence)) {
            return;
        }
        this.errorTextView.setText(charSequence);
        updateBottomTextState(this.allowAnimations);
    }

    public final CharSequence getPrefix() {
        return this.prefixView.getText();
    }

    public final void setPrefix(CharSequence charSequence) {
        if (TextUtils.equals(this.prefixView.getText(), charSequence)) {
            return;
        }
        this.prefixView.setText(charSequence);
        this.prefixView.setVisibility((charSequence == null || charSequence.length() == 0) ? 8 : 0);
        requestLayout();
    }

    public CharSequence getActualPrefix() {
        return getPrefix();
    }

    public final CharSequence getSuffix() {
        return this.suffixView.getText();
    }

    public final void setSuffix(CharSequence charSequence) {
        if (TextUtils.equals(this.suffixView.getText(), charSequence)) {
            return;
        }
        this.suffixView.setText(charSequence);
        this.suffixView.setVisibility((charSequence == null || charSequence.length() == 0) ? 8 : 0);
        requestLayout();
    }

    /* renamed from: getActualPlaceholder, reason: from getter */
    public CharSequence getPlaceholder() {
        return this.placeholder;
    }

    public CharSequence getActualSuffix() {
        return getSuffix();
    }

    public final Drawable getStartIcon() {
        return this.startImage.getDrawable();
    }

    public final void setStartIcon(Drawable drawable) {
        if (Intrinsics.areEqual(this.startImage.getDrawable(), drawable)) {
            return;
        }
        this.startImage.setBackgroundColor(0);
        this.startImage.setImageDrawable(drawable);
        updateIconVisibility(this.startImage, this.isStartIconVisible);
    }

    public final Drawable getEndIcon() {
        return this.endImage.getDrawable();
    }

    public final void setEndIcon(Drawable drawable) {
        if (Intrinsics.areEqual(this.endImage.getDrawable(), drawable)) {
            return;
        }
        this.endImage.setBackgroundColor(0);
        this.endImage.setImageDrawable(drawable);
        updateIconVisibility(this.endImage, this.isEndIconVisible);
    }

    public final Drawable getClearIcon() {
        return this.clearImage.getDrawable();
    }

    public final void setClearIcon(Drawable drawable) {
        if (drawable == null) {
            drawable = AppCompatResources.getDrawable(getContext(), R.drawable.dxe_clean);
        }
        if (Intrinsics.areEqual(this.clearImage.getDrawable(), drawable)) {
            return;
        }
        this.clearImage.setImageDrawable(drawable);
    }

    public final Drawable getErrorIcon() {
        return this.errorImage.getDrawable();
    }

    public final void setErrorIcon(Drawable drawable) {
        if (drawable == null) {
            drawable = AppCompatResources.getDrawable(getContext(), R.drawable.dxe_error);
        }
        if (Intrinsics.areEqual(this.errorImage.getDrawable(), drawable)) {
            return;
        }
        this.errorImage.setImageDrawable(drawable);
        boolean z = false;
        this.errorImage.setBackgroundColor(0);
        AppCompatImageButton appCompatImageButton = this.errorImage;
        if (this.isErrorIconVisible && this.hasError) {
            z = true;
        }
        updateIconVisibility(appCompatImageButton, z);
    }

    public final boolean getHasError() {
        return this.hasError;
    }

    public final void setHasError(boolean z) {
        if (this.hasError == z) {
            return;
        }
        this.hasError = z;
        updateBottomTextState(this.allowAnimations);
        updateIconVisibility(this.errorImage, this.isErrorIconVisible && this.hasError);
        refreshDrawableState();
        getLabelAnimator().setHasError(z, this.allowAnimations);
    }

    public final boolean getAllowAnimations() {
        return this.allowAnimations;
    }

    public final void setAllowAnimations(boolean z) {
        this.allowAnimations = z;
    }

    /* renamed from: isReadOnly, reason: from getter */
    public final boolean getIsReadOnly() {
        return this.isReadOnly;
    }

    public final void setReadOnly(boolean z) {
        if (this.isReadOnly == z) {
            return;
        }
        this.isReadOnly = z;
        onReadOnlyChanged();
    }

    public final int getTextGravity() {
        return getInternalEditor().getGravity();
    }

    public final void setTextGravity(int i) {
        getInternalEditor().setGravity(i);
        requestLayout();
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return getInternalEditor().getEllipsize();
    }

    public final void setEllipsize(TextUtils.TruncateAt truncateAt) {
        getInternalEditor().setEllipsize(truncateAt);
    }

    public final boolean getReserveBottomTextLine() {
        return this.reserveBottomTextLine;
    }

    public final void setReserveBottomTextLine(boolean z) {
        if (this.reserveBottomTextLine == z) {
            return;
        }
        this.reserveBottomTextLine = z;
        updateBottomTextState(false);
        requestLayout();
    }

    /* renamed from: isLabelFloating, reason: from getter */
    public final boolean getIsLabelFloating() {
        return this.isLabelFloating;
    }

    public final void setLabelFloating(boolean z) {
        if (this.isLabelFloating == z) {
            return;
        }
        this.isLabelFloating = z;
        updateLabelState(this.allowAnimations);
    }

    public final int getStartIconColor() {
        return getDropDownStyle().getStartIconColor();
    }

    public final void setStartIconColor(int i) {
        if (getDropDownStyle().getStartIconColor() == i) {
            return;
        }
        getDropDownStyle().setStartIconColor(i);
        onStartIconColorsChanged();
    }

    public final int getDisabledStartIconColor() {
        return getDropDownStyle().getDisabledStartIconColor();
    }

    public final void setDisabledStartIconColor(int i) {
        if (getDropDownStyle().getDisabledStartIconColor() == i) {
            return;
        }
        getDropDownStyle().setDisabledStartIconColor(i);
        onStartIconColorsChanged();
    }

    public final int getEndIconColor() {
        return getDropDownStyle().getEndIconColor();
    }

    public final void setEndIconColor(int i) {
        if (getDropDownStyle().getEndIconColor() == i) {
            return;
        }
        getDropDownStyle().setEndIconColor(i);
        onEndIconColorsChanged();
    }

    public final int getDisabledEndIconColor() {
        return getDropDownStyle().getDisabledEndIconColor();
    }

    public final void setDisabledEndIconColor(int i) {
        if (getDropDownStyle().getDisabledEndIconColor() == i) {
            return;
        }
        getDropDownStyle().setDisabledEndIconColor(i);
        onEndIconColorsChanged();
    }

    public final int getClearIconColor() {
        return getDropDownStyle().getClearIconColor();
    }

    public final void setClearIconColor(int i) {
        if (getDropDownStyle().getClearIconColor() == i) {
            return;
        }
        getDropDownStyle().setClearIconColor(i);
        onClearIconColorsChanged();
    }

    public final int getDisabledClearIconColor() {
        return getDropDownStyle().getDisabledClearIconColor();
    }

    public final void setDisabledClearIconColor(int i) {
        if (getDropDownStyle().getDisabledClearIconColor() == i) {
            return;
        }
        getDropDownStyle().setDisabledClearIconColor(i);
        onClearIconColorsChanged();
    }

    public final int getErrorIconColor() {
        return getDropDownStyle().getErrorIconColor();
    }

    public final void setErrorIconColor(int i) {
        if (getDropDownStyle().getErrorIconColor() == i) {
            return;
        }
        getDropDownStyle().setErrorIconColor(i);
        onErrorIconColorsChanged();
    }

    public final int getDisabledErrorIconColor() {
        return getDropDownStyle().getDisabledErrorIconColor();
    }

    public final void setDisabledErrorIconColor(int i) {
        if (getDropDownStyle().getDisabledErrorIconColor() == i) {
            return;
        }
        getDropDownStyle().setDisabledErrorIconColor(i);
        onErrorIconColorsChanged();
    }

    public final int getBoxPaddingStart() {
        return getDropDownStyle().getBoxPadding().getStart();
    }

    public final void setBoxPaddingStart(int i) {
        if (getDropDownStyle().getBoxPadding().getStart() == i) {
            return;
        }
        getDropDownStyle().getBoxPadding().setStart(i);
        getDropDownStyle().getNoLabelBoxPadding().setStart(i);
        onLayoutSettingsChanged();
    }

    public final int getBoxPaddingTop() {
        return getDropDownStyle().getBoxPadding().getTop();
    }

    public final void setBoxPaddingTop(int i) {
        if (getDropDownStyle().getBoxPadding().getTop() == i) {
            return;
        }
        getDropDownStyle().getBoxPadding().setTop(i);
        onLayoutSettingsChanged();
    }

    public final int getBoxPaddingEnd() {
        return getDropDownStyle().getBoxPadding().getEnd();
    }

    public final void setBoxPaddingEnd(int i) {
        if (getDropDownStyle().getBoxPadding().getEnd() == i) {
            return;
        }
        getDropDownStyle().getBoxPadding().setEnd(i);
        getDropDownStyle().getNoLabelBoxPadding().setEnd(i);
        onLayoutSettingsChanged();
    }

    public final int getBoxPaddingBottom() {
        return getDropDownStyle().getBoxPadding().getBottom();
    }

    public final void setBoxPaddingBottom(int i) {
        if (getDropDownStyle().getBoxPadding().getBottom() == i) {
            return;
        }
        getDropDownStyle().getBoxPadding().setBottom(i);
        getDropDownStyle().getNoLabelBoxPadding().setBottom(i);
        onLayoutSettingsChanged();
    }

    public final int getIconIndent() {
        return getDropDownStyle().getIconIndent();
    }

    public final void setIconIndent(int i) {
        if (getDropDownStyle().getIconIndent() == i) {
            return;
        }
        getDropDownStyle().setIconIndent(i);
        onLayoutSettingsChanged();
    }

    public final int getIconSpacing() {
        return getDropDownStyle().getIconSpacing();
    }

    public final void setIconSpacing(int i) {
        if (getDropDownStyle().getIconSpacing() == i) {
            return;
        }
        getDropDownStyle().setIconSpacing(i);
        onLayoutSettingsChanged();
    }

    public final int getAffixIndent() {
        return getDropDownStyle().getAffixIndent();
    }

    public final void setAffixIndent(int i) {
        if (getDropDownStyle().getAffixIndent() == i) {
            return;
        }
        getDropDownStyle().setAffixIndent(i);
        onLayoutSettingsChanged();
    }

    public final DXVerticalAlignment getIconAlignment() {
        return this.iconAlignment;
    }

    public final void setIconAlignment(DXVerticalAlignment value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.iconAlignment == value) {
            return;
        }
        this.iconAlignment = value;
        onLayoutSettingsChanged();
    }

    public final int getStartIconVerticalGravity() {
        return getDropDownStyle().getStartIconVerticalGravity();
    }

    public final void setStartIconVerticalGravity(int i) {
        if (getDropDownStyle().getStartIconVerticalGravity() == i) {
            return;
        }
        getDropDownStyle().setStartIconVerticalGravity(i);
        onLayoutSettingsChanged();
    }

    public final int getEndIconVerticalGravity() {
        return getDropDownStyle().getEndIconVerticalGravity();
    }

    public final void setEndIconVerticalGravity(int i) {
        if (getDropDownStyle().getEndIconVerticalGravity() == i) {
            return;
        }
        getDropDownStyle().setEndIconVerticalGravity(i);
        onLayoutSettingsChanged();
    }

    public final int getBottomTextTopIndent() {
        return getDropDownStyle().getBottomTextTopIndent();
    }

    public final void setBottomTextTopIndent(int i) {
        if (getDropDownStyle().getBottomTextTopIndent() == i) {
            return;
        }
        getDropDownStyle().setBottomTextTopIndent(i);
        onLayoutSettingsChanged();
    }

    public final int getCharacterCounterStartIndent() {
        return getDropDownStyle().getCharacterCounterStartIndent();
    }

    public final void setCharacterCounterStartIndent(int i) {
        if (getDropDownStyle().getCharacterCounterStartIndent() == i) {
            return;
        }
        getDropDownStyle().setCharacterCounterStartIndent(i);
        onLayoutSettingsChanged();
    }

    public final int getMinBoxHeight() {
        return getDropDownStyle().getMinBoxHeight();
    }

    public final void setMinBoxHeight(int i) {
        if (getDropDownStyle().getMinBoxHeight() == i) {
            return;
        }
        getDropDownStyle().setMinBoxHeight(i);
        onLayoutSettingsChanged();
    }

    public final int getMinBoxWidth() {
        return getDropDownStyle().getMinBoxWidth();
    }

    public final void setMinBoxWidth(int i) {
        if (getDropDownStyle().getMinBoxWidth() == i) {
            return;
        }
        getDropDownStyle().setMinBoxWidth(i);
        onLayoutSettingsChanged();
    }

    public final int getBoxHeight() {
        return getDropDownStyle().getBoxHeight();
    }

    public final void setBoxHeight(int i) {
        if (getDropDownStyle().getBoxHeight() == i) {
            return;
        }
        getDropDownStyle().setBoxHeight(i);
        onLayoutSettingsChanged();
    }

    public final float getTopLeftCornerRadius() {
        return getDropDownStyle().getBorderRounds().topLeft;
    }

    public final void setTopLeftCornerRadius(float f) {
        if (getDropDownStyle().getBorderRounds().topLeft == f) {
            return;
        }
        getDropDownStyle().getBorderRounds().topLeft = f;
        onCornerRadiusChanged();
    }

    public final float getTopRightCornerRadius() {
        return getDropDownStyle().getBorderRounds().topRight;
    }

    public final void setTopRightCornerRadius(float f) {
        if (getDropDownStyle().getBorderRounds().topRight == f) {
            return;
        }
        getDropDownStyle().getBorderRounds().topRight = f;
        onCornerRadiusChanged();
    }

    public final float getBottomLeftCornerRadius() {
        return getDropDownStyle().getBorderRounds().bottomLeft;
    }

    public final void setBottomLeftCornerRadius(float f) {
        if (getDropDownStyle().getBorderRounds().bottomLeft == f) {
            return;
        }
        getDropDownStyle().getBorderRounds().bottomLeft = f;
        onCornerRadiusChanged();
    }

    public final float getBottomRightCornerRadius() {
        return getDropDownStyle().getBorderRounds().bottomRight;
    }

    public final void setBottomRightCornerRadius(float f) {
        if (getDropDownStyle().getBorderRounds().bottomRight == f) {
            return;
        }
        getDropDownStyle().getBorderRounds().bottomRight = f;
        onCornerRadiusChanged();
    }

    public final int getBoxBackgroundColor() {
        return getDropDownStyle().getBoxBackgroundColor();
    }

    public final void setBoxBackgroundColor(int i) {
        if (getDropDownStyle().getBoxBackgroundColor() == i) {
            return;
        }
        getDropDownStyle().setBoxBackgroundColor(i);
        onColorSettingsChanged();
    }

    public final int getDisabledBoxBackgroundColor() {
        return getDropDownStyle().getDisabledBoxBackgroundColor();
    }

    public final void setDisabledBoxBackgroundColor(int i) {
        if (getDropDownStyle().getDisabledBoxBackgroundColor() == i) {
            return;
        }
        getDropDownStyle().setDisabledBoxBackgroundColor(i);
        onColorSettingsChanged();
    }

    public final int getBorderColor() {
        return getDropDownStyle().getBorderColor();
    }

    public final void setBorderColor(int i) {
        if (getDropDownStyle().getBorderColor() == i) {
            return;
        }
        getDropDownStyle().setBorderColor(i);
        onColorSettingsChanged();
    }

    public final int getFocusedBorderColor() {
        return getDropDownStyle().getFocusedBorderColor();
    }

    public final void setFocusedBorderColor(int i) {
        if (getDropDownStyle().getFocusedBorderColor() == i) {
            return;
        }
        getDropDownStyle().setFocusedBorderColor(i);
        onColorSettingsChanged();
    }

    public final int getDisabledBorderColor() {
        return getDropDownStyle().getDisabledBorderColor();
    }

    public final void setDisabledBorderColor(int i) {
        if (getDropDownStyle().getDisabledBorderColor() == i) {
            return;
        }
        getDropDownStyle().setDisabledBorderColor(i);
        onColorSettingsChanged();
    }

    public final int getBorderThickness() {
        return getDropDownStyle().getBorderThickness();
    }

    public final void setBorderThickness(int i) {
        if (getDropDownStyle().getBorderThickness() == i) {
            return;
        }
        getDropDownStyle().setBorderThickness(i);
        onColorSettingsChanged();
    }

    public final int getFocusedBorderThickness() {
        return getDropDownStyle().getFocusedBorderThickness();
    }

    public final void setFocusedBorderThickness(int i) {
        if (getDropDownStyle().getFocusedBorderThickness() == i) {
            return;
        }
        getDropDownStyle().setFocusedBorderThickness(i);
        onColorSettingsChanged();
    }

    public final int getDisabledBorderThickness() {
        return getDropDownStyle().getDisabledBorderThickness();
    }

    public final void setDisabledBorderThickness(int i) {
        if (getDropDownStyle().getDisabledBorderThickness() == i) {
            return;
        }
        getDropDownStyle().setDisabledBorderThickness(i);
        onColorSettingsChanged();
    }

    public final int getTextColor() {
        return getDropDownStyle().getTextColor();
    }

    public final void setTextColor(int i) {
        if (getDropDownStyle().getTextColor() == i) {
            return;
        }
        getDropDownStyle().setTextColor(i);
        onTextColorChanged();
    }

    public final int getDisabledTextColor() {
        return getDropDownStyle().getDisabledTextColor();
    }

    public final void setDisabledTextColor(int i) {
        if (getDropDownStyle().getDisabledTextColor() == i) {
            return;
        }
        getDropDownStyle().setDisabledTextColor(i);
        onTextColorChanged();
    }

    public final int getLabelColor() {
        return getDropDownStyle().getLabelColor();
    }

    public final void setLabelColor(int i) {
        if (getDropDownStyle().getLabelColor() == i) {
            return;
        }
        getDropDownStyle().setLabelColor(i);
        onColorSettingsChanged();
    }

    public final int getFocusedLabelColor() {
        return getDropDownStyle().getFocusedLabelColor();
    }

    public final void setFocusedLabelColor(int i) {
        if (getDropDownStyle().getFocusedLabelColor() == i) {
            return;
        }
        getDropDownStyle().setFocusedLabelColor(i);
        onColorSettingsChanged();
    }

    public final int getDisabledLabelColor() {
        return getDropDownStyle().getDisabledLabelColor();
    }

    public final void setDisabledLabelColor(int i) {
        if (getDropDownStyle().getDisabledLabelColor() == i) {
            return;
        }
        getDropDownStyle().setDisabledLabelColor(i);
        onColorSettingsChanged();
    }

    public final int getPlaceholderColor() {
        return getDropDownStyle().getPlaceholderTextColor();
    }

    public final void setPlaceholderColor(int i) {
        if (getDropDownStyle().getPlaceholderTextColor() == i) {
            return;
        }
        getDropDownStyle().setPlaceholderTextColor(i);
        onPlaceholderColorChanged();
    }

    public final int getHelpTextColor() {
        return getDropDownStyle().getHelpTextColor();
    }

    public final void setHelpTextColor(int i) {
        if (getDropDownStyle().getHelpTextColor() == i) {
            return;
        }
        getDropDownStyle().setHelpTextColor(i);
        onHelpTextColorChanged();
    }

    public final int getDisabledHelpTextColor() {
        return getDropDownStyle().getDisabledHelpTextColor();
    }

    public final void setDisabledHelpTextColor(int i) {
        if (getDropDownStyle().getDisabledHelpTextColor() == i) {
            return;
        }
        getDropDownStyle().setDisabledHelpTextColor(i);
        onHelpTextColorChanged();
        onErrorColorChanged();
    }

    public final int getErrorColor() {
        return getDropDownStyle().getErrorColor();
    }

    public final void setErrorColor(int i) {
        if (getDropDownStyle().getErrorColor() == i) {
            return;
        }
        getDropDownStyle().setErrorColor(i);
        onErrorColorChanged();
        onColorSettingsChanged();
    }

    public final Typeface getTextTypeface() {
        return this.textTypeface;
    }

    public final void setTextTypeface(Typeface typeface) {
        if (Intrinsics.areEqual(typeface, this.textTypeface)) {
            return;
        }
        this.textTypeface = typeface;
        getInternalEditor().setTypeface(typeface);
    }

    public final Typeface getBottomTextTypeface() {
        return this.helpTextView.getTypeface();
    }

    public final void setBottomTextTypeface(Typeface typeface) {
        if (Intrinsics.areEqual(this.helpTextView.getTypeface(), typeface)) {
            return;
        }
        onBottomTextTypefaceChanged(typeface);
    }

    public final Typeface getLabelTypeface() {
        return this.labelTextView.getTypeface();
    }

    public final void setLabelTypeface(Typeface typeface) {
        if (Intrinsics.areEqual(this.labelTextView.getTypeface(), typeface)) {
            return;
        }
        this.labelTextView.setTypeface(typeface);
    }

    public final Typeface getAffixTypeface() {
        return this.prefixView.getTypeface();
    }

    public final void setAffixTypeface(Typeface typeface) {
        if (Intrinsics.areEqual(this.prefixView.getTypeface(), typeface)) {
            return;
        }
        this.suffixView.setTypeface(typeface);
        this.prefixView.setTypeface(typeface);
    }

    public final float getTextSize() {
        return getInternalEditor().getTextSize();
    }

    public final void setTextSize(float f) {
        setTextSize(2, f);
    }

    public final float getBottomTextSize() {
        return this.helpTextView.getTextSize();
    }

    public final void setBottomTextSize(float f) {
        setBottomTextSize(2, f);
    }

    public final float getLabelTextSize() {
        return this.labelTextView.getTextSize();
    }

    public final void setLabelTextSize(float f) {
        setLabelTextSize(2, f);
    }

    public final float getAffixTextSize() {
        return this.suffixView.getTextSize();
    }

    public final void setAffixTextSize(float f) {
        setAffixTextSize(2, f);
    }

    /* renamed from: isStartIconVisible, reason: from getter */
    public final boolean getIsStartIconVisible() {
        return this.isStartIconVisible;
    }

    public final void setStartIconVisible(boolean z) {
        if (this.isStartIconVisible == z) {
            return;
        }
        this.isStartIconVisible = z;
        updateIconVisibility(this.startImage, z);
    }

    /* renamed from: isEndIconVisible, reason: from getter */
    public final boolean getIsEndIconVisible() {
        return this.isEndIconVisible;
    }

    public final void setEndIconVisible(boolean z) {
        if (this.isEndIconVisible == z) {
            return;
        }
        this.isEndIconVisible = z;
        updateIconVisibility(this.endImage, z);
    }

    /* renamed from: isErrorIconVisible, reason: from getter */
    public final boolean getIsErrorIconVisible() {
        return this.isErrorIconVisible;
    }

    public final void setErrorIconVisible(boolean z) {
        if (this.isErrorIconVisible == z) {
            return;
        }
        this.isErrorIconVisible = z;
        updateIconVisibility(this.errorImage, z && this.hasError);
    }

    public final DXIconVisibility getClearIconVisibility() {
        return this.clearIconVisibility;
    }

    public final void setClearIconVisibility(DXIconVisibility value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.clearIconVisibility == value) {
            return;
        }
        this.clearIconVisibility = value;
        updateClearImageVisibility();
        requestLayout();
    }

    public final DXBorderMode getBorderMode() {
        return getDropDownStyle().getBorderMode();
    }

    public final void setBorderMode(DXBorderMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (getDropDownStyle().getBorderMode() == value) {
            return;
        }
        getDropDownStyle().setBorderMode(value);
        this.drawableManager = DrawableManagerFactory.createDrawableManager(getDropDownStyle());
        this.contentLayout = createLayout(value);
        onBorderModeChanged();
    }

    public final DXCornerMode getCornerMode() {
        return getDropDownStyle().getCornerMode();
    }

    public final void setCornerMode(DXCornerMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (getDropDownStyle().getCornerMode() == value) {
            return;
        }
        getDropDownStyle().setCornerMode(value);
        onCornerModeChanged();
    }

    public final int getAffixColor() {
        return getDropDownStyle().getAffixColor();
    }

    public final void setAffixColor(int i) {
        if (getDropDownStyle().getAffixColor() == i) {
            return;
        }
        getDropDownStyle().setAffixColor(i);
        onAffixColorChanged();
    }

    public final int getDisabledAffixColor() {
        return getDropDownStyle().getDisabledAffixColor();
    }

    public final void setDisabledAffixColor(int i) {
        if (getDropDownStyle().getDisabledAffixColor() == i) {
            return;
        }
        getDropDownStyle().setDisabledAffixColor(i);
        onAffixColorChanged();
    }

    public final int getCursorColor() {
        return getDropDownStyle().getCursorColor();
    }

    public final void setCursorColor(int i) {
        if (getDropDownStyle().getCursorColor() == i) {
            return;
        }
        getDropDownStyle().setCursorColor(i);
        onCursorColorChanged();
    }

    private final void onCursorColorChanged() {
        Drawable cursorDrawable = getCursorDrawable();
        if (cursorDrawable != null) {
            cursorDrawable.setTint(getCursorColor());
        }
    }

    public final Drawable getCursorDrawable() {
        if (Build.VERSION.SDK_INT >= 29) {
            return getInternalEditor().getTextCursorDrawable();
        }
        return null;
    }

    public final int getImeActionId() {
        return getInternalEditor().getImeActionId();
    }

    public final CharSequence getImeActionLabel() {
        CharSequence imeActionLabel = getInternalEditor().getImeActionLabel();
        Intrinsics.checkNotNullExpressionValue(imeActionLabel, "getImeActionLabel(...)");
        return imeActionLabel;
    }

    public final int getImeActionOptions() {
        return getInternalEditor().getImeOptions();
    }

    public final void setImeActionOptions(int i) {
        getInternalEditor().setImeOptions(i);
    }

    public final boolean getContainsFocus() {
        return this.containsFocus;
    }

    public final void setContainsFocus$dxeditors_release(boolean z) {
        if (this.containsFocus == z) {
            return;
        }
        this.containsFocus = z;
        onContainsFocusChange();
        View.OnFocusChangeListener onFocusChangeListener = this.containsFocusChangeListener;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(this, z);
        }
    }

    public final List<Element> getLeadingIconElements$dxeditors_release() {
        return this.leadingIconElements;
    }

    public final void setLeadingIconElements$dxeditors_release(List<? extends Element> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.leadingIconElements = list;
    }

    public final List<Element> getTrailingIconElements$dxeditors_release() {
        return this.trailingIconElements;
    }

    public final void setTrailingIconElements$dxeditors_release(List<? extends Element> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.trailingIconElements = list;
    }

    public final EditorGestureListener getEditorGestureListener() {
        return this.editorGestureListener;
    }

    public final void setEditorGestureListener(EditorGestureListener editorGestureListener) {
        this.editorGestureListener = editorGestureListener;
    }

    public final OnEditActionListener getOnEditActionListener() {
        return this.onEditActionListener;
    }

    public final void setOnEditActionListener(OnEditActionListener onEditActionListener) {
        if (Intrinsics.areEqual(this.onEditActionListener, onEditActionListener)) {
            return;
        }
        this.onEditActionListener = onEditActionListener;
        getInternalEditor().setOnEditorActionListener(onEditActionListener != null ? new OnEditorActionListener(this) : null);
    }

    public final View.OnFocusChangeListener getContainsFocusChangeListener() {
        return this.containsFocusChangeListener;
    }

    public final void setContainsFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.containsFocusChangeListener = onFocusChangeListener;
    }

    public static /* synthetic */ void finishInitialization$default(EditBase editBase, AttributeSet attributeSet, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishInitialization");
        }
        if ((i2 & 1) != 0) {
            attributeSet = null;
        }
        editBase.finishInitialization(attributeSet, i);
    }

    protected void finishInitialization(AttributeSet attrs, int defStyleAttr) {
        addView(this.labelTextView);
        addView(this.helpTextView);
        addView(this.errorTextView);
        addView(getActualInternalEditorView());
        addView(this.startImage);
        addView(this.endImage);
        addView(this.clearImage);
        addView(this.errorImage);
        addView(this.suffixView);
        addView(this.prefixView);
        LayoutElementsFactory createLayoutElementsFactory = createLayoutElementsFactory();
        this.leadingIconElements = createLayoutElementsFactory.getStartImageElements();
        this.trailingIconElements = createLayoutElementsFactory.getEndImageElements();
        if (attrs == null) {
            initDefaultStyle();
        } else {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.EditBase, defStyleAttr, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
            initStyle();
            obtainStyledAttributes.recycle();
        }
        setupInternalEditor();
        setupImages();
        setupClearIcon();
        setupLabel();
        setupHelpAndError();
        setupAffix();
        setWillNotDraw(false);
        LabelAnimator.setState$default(getLabelAnimator(), null, Boolean.valueOf(this.containsFocus), Boolean.valueOf(this.hasError), Boolean.valueOf(isEnabled()), false, 17, null);
        updateEditorTextSettings();
        setTextTypeface(getInternalEditor().getTypeface());
    }

    protected Layout createLayout(DXBorderMode borderMode) {
        Intrinsics.checkNotNullParameter(borderMode, "borderMode");
        if (borderMode == DXBorderMode.Filled) {
            return new FilledLayout(this);
        }
        return new OutlinedLayout(this);
    }

    @Override // android.view.View
    public void setTextAlignment(int textAlignment) {
        super.setTextAlignment(textAlignment);
        getInternalEditor().setTextAlignment(textAlignment);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        Layout layout = this.contentLayout;
        if (layout != null) {
            layout.invalidate();
        }
        super.requestLayout();
    }

    @Override // android.view.View
    public void forceLayout() {
        Layout layout = this.contentLayout;
        if (layout != null) {
            layout.invalidate();
        }
        super.forceLayout();
    }

    @Override // com.devexpress.dxcore.DXNativeView
    protected Size onMeasureCore(int widthMeasureSpec, int heightMeasureSpec) {
        Layout createLayout = createLayout(getBorderMode());
        createLayout.calculate(widthMeasureSpec, heightMeasureSpec);
        getActualInternalEditorView().forceLayout();
        this.labelTextView.forceLayout();
        this.helpTextView.forceLayout();
        this.errorTextView.forceLayout();
        this.prefixView.forceLayout();
        this.suffixView.forceLayout();
        getActualInternalEditorView().measure(View.MeasureSpec.makeMeasureSpec(createLayout.getInternalEditorFrame().getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(createLayout.getInternalEditorFrame().getHeight(), BasicMeasure.EXACTLY));
        this.labelTextView.measure(View.MeasureSpec.makeMeasureSpec(createLayout.getLabelFrame().getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(createLayout.getLabelFrame().getHeight(), BasicMeasure.EXACTLY));
        this.helpTextView.measure(View.MeasureSpec.makeMeasureSpec(createLayout.getBottomTextAreaFrame().getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(createLayout.getBottomTextAreaFrame().getHeight(), BasicMeasure.EXACTLY));
        this.errorTextView.measure(View.MeasureSpec.makeMeasureSpec(createLayout.getBottomTextAreaFrame().getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(createLayout.getBottomTextAreaFrame().getHeight(), BasicMeasure.EXACTLY));
        this.prefixView.measure(View.MeasureSpec.makeMeasureSpec(createLayout.getPrefixFrame().getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(createLayout.getPrefixFrame().getHeight(), BasicMeasure.EXACTLY));
        this.suffixView.measure(View.MeasureSpec.makeMeasureSpec(createLayout.getSuffixFrame().getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(createLayout.getSuffixFrame().getHeight(), BasicMeasure.EXACTLY));
        return new Size(createLayout.getFullBounds().getWidth(), createLayout.getFullBounds().getHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.contentLayout.calculate(View.MeasureSpec.makeMeasureSpec(r - l, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(b - t, BasicMeasure.EXACTLY));
        getLabelAnimator().setCanAnimate(true);
        getActualInternalEditorView().layout(this.contentLayout.getInternalEditorFrame().getLeft(), this.contentLayout.getInternalEditorFrame().getTop(), this.contentLayout.getInternalEditorFrame().right(), this.contentLayout.getInternalEditorFrame().bottom());
        this.labelTextView.layout(this.contentLayout.getLabelFrame().getLeft(), this.contentLayout.getLabelFrame().getTop(), this.contentLayout.getLabelFrame().right(), this.contentLayout.getLabelFrame().bottom());
        this.helpTextView.layout(this.contentLayout.getBottomTextAreaFrame().getLeft(), this.contentLayout.getBottomTextAreaFrame().getTop(), this.contentLayout.getBottomTextAreaFrame().right(), this.contentLayout.getBottomTextAreaFrame().bottom());
        this.errorTextView.layout(this.contentLayout.getBottomTextAreaFrame().getLeft(), this.contentLayout.getBottomTextAreaFrame().getTop(), this.contentLayout.getBottomTextAreaFrame().right(), this.contentLayout.getBottomTextAreaFrame().bottom());
        layoutIcons(this.leadingIconElements, this.contentLayout.getLeadingIconFrame().getLeft(), this.contentLayout.getLeadingIconFrame().getTop(), this.contentLayout.getLeadingIconFrame().right(), this.contentLayout.getLeadingIconFrame().bottom());
        layoutIcons(this.trailingIconElements, this.contentLayout.getTrailingIconFrame().getLeft(), this.contentLayout.getTrailingIconFrame().getTop(), this.contentLayout.getTrailingIconFrame().right(), this.contentLayout.getTrailingIconFrame().bottom());
        this.prefixView.layout(this.contentLayout.getPrefixFrame().getLeft(), this.contentLayout.getPrefixFrame().getTop(), this.contentLayout.getPrefixFrame().right(), this.contentLayout.getPrefixFrame().bottom());
        this.suffixView.layout(this.contentLayout.getSuffixFrame().getLeft(), this.contentLayout.getSuffixFrame().getTop(), this.contentLayout.getSuffixFrame().right(), this.contentLayout.getSuffixFrame().bottom());
        float textSize = getInternalEditor().getTextSize() / this.labelTextView.getTextSize();
        float top = this.contentLayout.getPlaceholderFrame().getTop() - this.contentLayout.getLabelFrame().getTop();
        float left = this.contentLayout.getPlaceholderFrame().getLeft() - this.contentLayout.getLabelFrame().getLeft();
        getLabelAnimator().setExpandedLabelScaleX(textSize);
        getLabelAnimator().setExpandedLabelScaleY(textSize);
        getLabelAnimator().setExpandedLabelTranslateX(left);
        getLabelAnimator().setExpandedLabelTranslateY(top);
        getLabelAnimator().setExpandedLabelMaxWidth((int) ((this.contentLayout.getPlaceholderFrame().getWidth() / textSize) + 0.5f));
        getLabelAnimator().setUseOnlyAlphaCollapseAnimationForLabel(false);
        getLabelAnimator().onStateChanged(getLabelAnimator().isAnimationInProcess());
        Rect rect = this.contentLayout.getLabelFrame().toRect();
        rect.inset(-getDropDownStyle().getLabelTextBorderIndent(), 0);
        BackgroundDrawableManager backgroundDrawableManager = this.drawableManager;
        if (backgroundDrawableManager != null) {
            backgroundDrawableManager.applyLabelCutOut(rect);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Rect rect = this.contentLayout.getBoxFrame().toRect();
        Drawable drawable = this.boxBackgroundDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
            drawable.draw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalFocusChangeListener(this.globalFocusChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        setContainsFocus$dxeditors_release(false);
        getViewTreeObserver().removeOnGlobalFocusChangeListener(this.globalFocusChangeListener);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        setChildrenEnabled(enabled);
        updateClearImageVisibility();
        getLabelAnimator().setEnabled(enabled, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int extraSpace) {
        int[] onCreateDrawableState = super.onCreateDrawableState(extraSpace + Constants.LABEL_MOVED_STATE.length + Constants.ERROR_STATE.length);
        if (this.containsFocus) {
            onCreateDrawableState = View.mergeDrawableStates(onCreateDrawableState, Constants.FOCUSED_STATE);
        } else if (getLabelAnimator().getLabelPosition() == LabelPosition.ON_TOP) {
            onCreateDrawableState = View.mergeDrawableStates(onCreateDrawableState, Constants.LABEL_MOVED_STATE);
        }
        if (this.hasError) {
            onCreateDrawableState = View.mergeDrawableStates(onCreateDrawableState, Constants.ERROR_STATE);
        }
        Intrinsics.checkNotNull(onCreateDrawableState);
        return onCreateDrawableState;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.boxBackgroundDrawable;
        if (drawable == null) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable who) {
        Intrinsics.checkNotNullParameter(who, "who");
        return super.verifyDrawable(who) || Intrinsics.areEqual(who, this.boxBackgroundDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        int[] drawableState = getDrawableState();
        Intrinsics.checkNotNullExpressionValue(drawableState, "getDrawableState(...)");
        updateDrawablesTintMode(drawableState);
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        int[] drawableState = getDrawableState();
        Intrinsics.checkNotNullExpressionValue(drawableState, "getDrawableState(...)");
        updateDrawablesTintMode(drawableState);
    }

    @Override // android.view.View
    public void setAutofillHints(String... autofillHints) {
        Intrinsics.checkNotNullParameter(autofillHints, "autofillHints");
        getInternalEditor().setAutofillHints((String[]) Arrays.copyOf(autofillHints, autofillHints.length));
    }

    public final void setStartIconClickedListener(View.OnClickListener value) {
        this.startImage.setOnClickListener(value);
        this.startImage.setClickable(value != null);
    }

    public final void setEndIconClickedListener(View.OnClickListener value) {
        this.endImage.setOnClickListener(value);
        this.endImage.setClickable(value != null);
    }

    public final void setErrorIconClickedListener(View.OnClickListener value) {
        this.errorImage.setOnClickListener(value);
        this.errorImage.setClickable(value != null);
    }

    public final void setTextSize(int unit, float value) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (getTextSize() == companion.applyDimension(context, value, unit)) {
            return;
        }
        getInternalEditor().setTextSize(unit, value);
    }

    public final void setLabelTextSize(int unit, float value) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (getLabelTextSize() == companion.applyDimension(context, value, unit)) {
            return;
        }
        this.labelTextView.setTextSize(unit, value);
    }

    public final void setBottomTextSize(int unit, float value) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (getBottomTextSize() == companion.applyDimension(context, value, unit)) {
            return;
        }
        onBottomTextSizeChanged(unit, value);
    }

    public final void setAffixTextSize(int unit, float value) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (getAffixTextSize() == companion.applyDimension(context, value, unit)) {
            return;
        }
        this.suffixView.setTextSize(unit, value);
        this.prefixView.setTextSize(unit, value);
    }

    public final void setAffixColors(ColorStateList value) {
        if (value == null) {
            throw new IllegalArgumentException("The specified value cannot be null.".toString());
        }
        int defaultColor = value.getDefaultColor();
        int colorForState = value.isStateful() ? value.getColorForState(Constants.DISABLED_STATE, defaultColor) : defaultColor;
        getDropDownStyle().setAffixColor(defaultColor);
        getDropDownStyle().setDisabledAffixColor(colorForState);
        onAffixColorChanged();
    }

    public final void setTextColors(ColorStateList value) {
        if (value == null) {
            throw new IllegalArgumentException("The specified value cannot be null.".toString());
        }
        int defaultColor = value.getDefaultColor();
        int colorForState = value.isStateful() ? value.getColorForState(Constants.DISABLED_STATE, defaultColor) : defaultColor;
        getDropDownStyle().setTextColor(defaultColor);
        getDropDownStyle().setDisabledTextColor(colorForState);
        onTextColorChanged();
    }

    public final void setLabelColors(ColorStateList value) {
        if (value == null) {
            throw new IllegalArgumentException("The specified value cannot be null.".toString());
        }
        int defaultColor = value.getDefaultColor();
        int colorForState = value.isStateful() ? value.getColorForState(Constants.FOCUSED_STATE, defaultColor) : defaultColor;
        int colorForState2 = value.isStateful() ? value.getColorForState(Constants.DISABLED_STATE, defaultColor) : defaultColor;
        setLabelColor(defaultColor);
        setFocusedLabelColor(colorForState);
        setDisabledLabelColor(colorForState2);
    }

    public final void setHelpTextColors(ColorStateList value) {
        if (value == null) {
            throw new IllegalArgumentException("The specified value cannot be null.".toString());
        }
        int defaultColor = value.getDefaultColor();
        int colorForState = value.isStateful() ? value.getColorForState(Constants.DISABLED_STATE, defaultColor) : defaultColor;
        getDropDownStyle().setHelpTextColor(defaultColor);
        getDropDownStyle().setDisabledHelpTextColor(colorForState);
        onHelpTextColorChanged();
        onErrorColorChanged();
    }

    public final void setFocusedBorderThickness(float value, int unit) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setFocusedBorderThickness(companion.applyDimensionToInt(context, value, unit));
    }

    public final void setDisabledBorderThickness(float value, int unit) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setDisabledBorderThickness(companion.applyDimensionToInt(context, value, unit));
    }

    public final void setBottomRightCornerRadius(float value, int unit) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setBottomRightCornerRadius(companion.applyDimension(context, value, unit));
    }

    public final void setCornerRadius(float value) {
        suspendRender();
        setTopLeftCornerRadius(value);
        setTopRightCornerRadius(value);
        setBottomLeftCornerRadius(value);
        setBottomRightCornerRadius(value);
        resumeRender();
    }

    public final void setCornerRadius(float value, int unit) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setCornerRadius(companion.applyDimension(context, value, unit));
    }

    public final void setBoxBackgroundColors(ColorStateList value) {
        if (value == null) {
            throw new IllegalArgumentException("The specified value cannot be null.".toString());
        }
        int defaultColor = value.getDefaultColor();
        int colorForState = value.isStateful() ? value.getColorForState(Constants.DISABLED_STATE, defaultColor) : defaultColor;
        setBoxBackgroundColor(defaultColor);
        setDisabledBoxBackgroundColor(colorForState);
    }

    public final void setBorderColors(ColorStateList value) {
        if (value == null) {
            throw new IllegalArgumentException("The specified value cannot be null.".toString());
        }
        int defaultColor = value.getDefaultColor();
        int colorForState = value.isStateful() ? value.getColorForState(Constants.FOCUSED_STATE, defaultColor) : defaultColor;
        int colorForState2 = value.isStateful() ? value.getColorForState(Constants.DISABLED_STATE, defaultColor) : defaultColor;
        setBorderColor(defaultColor);
        setFocusedBorderColor(colorForState);
        setDisabledBorderColor(colorForState2);
    }

    public final void setBorderThickness(float value, int unit) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setBorderThickness(companion.applyDimensionToInt(context, value, unit));
    }

    public final void setBottomTextTopIndent(float value, int unit) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setBottomTextTopIndent(companion.applyDimensionToInt(context, value, unit));
    }

    public final void setCharacterCounterStartIndent(float value, int unit) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setCharacterCounterStartIndent(companion.applyDimensionToInt(context, value, unit));
    }

    public final void setMinBoxHeight(float value, int unit) {
        if (value < 0.0f) {
            setMinBoxHeight(-1);
            return;
        }
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setMinBoxHeight(companion.applyDimensionToInt(context, value, unit));
    }

    public final void setMinBoxWidth(float value, int unit) {
        if (value < 0.0f) {
            setMinBoxWidth(-1);
            return;
        }
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setMinBoxWidth(companion.applyDimensionToInt(context, value, unit));
    }

    public final void setBoxHeight(float value, int unit) {
        if (value < 0.0f) {
            setBoxHeight(-1);
            return;
        }
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setBoxHeight(companion.applyDimensionToInt(context, value, unit));
    }

    public final void setTopLeftCornerRadius(float value, int unit) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setTopLeftCornerRadius(companion.applyDimension(context, value, unit));
    }

    public final void setTopRightCornerRadius(float value, int unit) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setTopRightCornerRadius(companion.applyDimension(context, value, unit));
    }

    public final void setBottomLeftCornerRadius(float value, int unit) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setBottomLeftCornerRadius(companion.applyDimension(context, value, unit));
    }

    public final void setBoxPaddingTop(float value, int unit) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setBoxPaddingTop(companion.applyDimensionToInt(context, value, unit));
    }

    public final void setBoxPaddingStart(float value, int unit) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setBoxPaddingStart(companion.applyDimensionToInt(context, value, unit));
    }

    public final void setBoxPaddingBottom(float value, int unit) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setBoxPaddingBottom(companion.applyDimensionToInt(context, value, unit));
    }

    public final void setBoxPaddingEnd(float value, int unit) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setBoxPaddingEnd(companion.applyDimensionToInt(context, value, unit));
    }

    public final void setBoxPadding(int start, int top, int end, int bottom) {
        if (getDropDownStyle().getBoxPadding().equals(start, top, end, bottom) && getDropDownStyle().getNoLabelBoxPadding().equals(start, top, end, bottom)) {
            return;
        }
        getDropDownStyle().getBoxPadding().set(start, top, end, bottom);
        getDropDownStyle().getNoLabelBoxPadding().set(start, top, end, bottom);
        onLayoutSettingsChanged();
    }

    public final void setBoxPadding(int unit, float start, float top, float end, float bottom) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int applyDimensionToInt = companion.applyDimensionToInt(context, top, unit);
        MathHelper.Companion companion2 = MathHelper.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        int applyDimensionToInt2 = companion2.applyDimensionToInt(context2, start, unit);
        MathHelper.Companion companion3 = MathHelper.INSTANCE;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        int applyDimensionToInt3 = companion3.applyDimensionToInt(context3, bottom, unit);
        MathHelper.Companion companion4 = MathHelper.INSTANCE;
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
        setBoxPadding(applyDimensionToInt2, applyDimensionToInt, companion4.applyDimensionToInt(context4, end, unit), applyDimensionToInt3);
    }

    public final void resetBoxPadding() {
        setBoxPaddingStart(Integer.MIN_VALUE);
        setBoxPaddingEnd(Integer.MIN_VALUE);
        setBoxPaddingTop(Integer.MIN_VALUE);
        setBoxPaddingBottom(Integer.MIN_VALUE);
        onLayoutSettingsChanged();
    }

    public final void setIconIndent(float value, int unit) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setIconIndent(companion.applyDimensionToInt(context, value, unit));
    }

    public final void setIconSpacing(float value, int unit) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setIconSpacing(companion.applyDimensionToInt(context, value, unit));
    }

    public final void setAffixIndent(float value, int unit) {
        MathHelper.Companion companion = MathHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setAffixIndent(companion.applyDimensionToInt(context, value, unit));
    }

    public final void setOutlinedStyle() {
        getDropDownStyle().setBorderMode(DXBorderMode.Outlined);
        getDropDownStyle().setCornerMode(DXCornerMode.Round);
        setupCommonStyleSizes();
        setupOutlinedStyleSizes();
        setupCommonStyleColors();
        setupOutlinedStyleColors();
        updateAll();
    }

    public final void setOutlinedCutStyle() {
        getDropDownStyle().setBorderMode(DXBorderMode.Outlined);
        getDropDownStyle().setCornerMode(DXCornerMode.Cut);
        setupCommonStyleSizes();
        setupOutlinedStyleSizes();
        setupCommonStyleColors();
        setupOutlinedStyleColors();
        updateAll();
    }

    public final void setFilledStyle() {
        getDropDownStyle().setBorderMode(DXBorderMode.Filled);
        getDropDownStyle().setCornerMode(DXCornerMode.Round);
        setupCommonStyleSizes();
        setupFilledStyleSizes();
        setupCommonStyleColors();
        setupFilledStyleColors();
        updateAll();
    }

    public final void setFilledCutStyle() {
        getDropDownStyle().setBorderMode(DXBorderMode.Filled);
        getDropDownStyle().setCornerMode(DXCornerMode.Cut);
        setupCommonStyleSizes();
        setupFilledStyleSizes();
        setupCommonStyleColors();
        setupFilledStyleColors();
        updateAll();
    }

    public final void suspendRender() {
        this.isRefreshSuspended = true;
    }

    public final void resumeRender() {
        this.isRefreshSuspended = false;
        updateAll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.contentLayout.getBoxFrame().isEmpty()) {
            return super.dispatchTouchEvent(ev);
        }
        HitTestType calcHitTest = calcHitTest((int) (ev.getX() + 0.5f), (int) (ev.getY() + 0.5f));
        boolean dispatchTouchEvent = super.dispatchTouchEvent(ev);
        if (ev.getActionMasked() == 1 && onDispatchActionUp(ev, calcHitTest)) {
            return true;
        }
        if (calcHitTest != HitTestType.BoxEmptySpace) {
            return dispatchTouchEvent;
        }
        float x = ev.getX();
        float y = ev.getY();
        float x2 = ev.getX() - getActualInternalEditorView().getLeft();
        if (ev.getX() < getActualInternalEditorView().getLeft()) {
            x2 = 0.0f;
        } else if (ev.getX() > getActualInternalEditorView().getRight()) {
            x2 = getActualInternalEditorView().getWidth();
        }
        ev.setLocation(x2, 0.0f);
        boolean dispatchTouchEvent2 = getActualInternalEditorView().dispatchTouchEvent(ev);
        ev.setLocation(x, y);
        return dispatchTouchEvent2;
    }

    protected final boolean onDispatchActionUp(MotionEvent ev, HitTestType hitTest) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        Intrinsics.checkNotNullParameter(hitTest, "hitTest");
        if (!this.containsFocus || hitTest == HitTestType.TextInput) {
            return false;
        }
        this.forceXamarinKeepFocus = true;
        Activity activityFromContext = Utils.getActivityFromContext(getContext());
        this.currentFocus = activityFromContext != null ? activityFromContext.getCurrentFocus() : null;
        clearFocus();
        post(new Runnable() { // from class: com.devexpress.editors.EditBase$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                EditBase.onDispatchActionUp$lambda$7(EditBase.this);
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDispatchActionUp$lambda$7(EditBase this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.forceXamarinKeepFocus = false;
        View view = this$0.currentFocus;
        if (view != null) {
            view.requestFocus();
        }
    }

    protected void updateDrawablesTintMode(int[] state) {
        Intrinsics.checkNotNullParameter(state, "state");
        updateDrawableTintMode(this.startImage, state);
        updateDrawableTintMode(this.endImage, state);
        updateDrawableTintMode(this.clearImage, state);
        updateDrawableTintMode(this.errorImage, state);
    }

    protected boolean onSingleTapUp() {
        EditorGestureListener editorGestureListener = this.editorGestureListener;
        if (editorGestureListener == null) {
            return false;
        }
        return editorGestureListener.onSingleTapUp();
    }

    protected boolean onDoubleTap() {
        EditorGestureListener editorGestureListener = this.editorGestureListener;
        if (editorGestureListener == null) {
            return false;
        }
        return editorGestureListener.onDoubleTap();
    }

    protected boolean onLongPress() {
        EditorGestureListener editorGestureListener = this.editorGestureListener;
        if (editorGestureListener == null) {
            return false;
        }
        return editorGestureListener.onLongPress();
    }

    protected final void updateDrawableTintMode(ImageView iconView, int[] state) {
        PorterDuff.Mode mode;
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        Intrinsics.checkNotNullParameter(state, "state");
        Drawable drawable = iconView.getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList imageTintList = ImageViewCompat.getImageTintList(iconView);
        if (imageTintList != null && imageTintList.getColorForState(state, Constants.getEMPTY_COLOR()) != Constants.getEMPTY_COLOR()) {
            mode = PorterDuff.Mode.SRC_IN;
        } else {
            mode = PorterDuff.Mode.DST;
        }
        DrawableCompat.setTintMode(drawable, mode);
    }

    private final void setupInternalEditor() {
        getInternalEditor().setPadding(0, 0, 0, 0);
        getInternalEditor().setBackgroundColor(0);
        getInternalEditor().getLayoutParams().width = -1;
        getInternalEditor().getLayoutParams().height = -2;
        getInternalEditor().setScrollBarSize(0);
        getInternalEditor().setSingleLine(true);
    }

    private final void setupImages() {
        boolean z = false;
        this.startImage.setClickable(false);
        this.startImage.setPadding(0, 0, 0, 0);
        this.startImage.setBackgroundColor(0);
        this.startImage.setVisibility(8);
        this.endImage.setClickable(false);
        this.endImage.setBackgroundColor(0);
        this.endImage.setPadding(0, 0, 0, 0);
        this.endImage.setVisibility(8);
        this.errorImage.setClickable(false);
        this.errorImage.setBackgroundColor(0);
        this.errorImage.setPadding(0, 0, 0, 0);
        setErrorIcon(null);
        AppCompatImageButton appCompatImageButton = this.errorImage;
        if (this.isErrorIconVisible && this.hasError) {
            z = true;
        }
        updateIconVisibility(appCompatImageButton, z);
    }

    private final void setupClearIcon() {
        this.clearImage.setBackgroundColor(0);
        this.clearImage.setPadding(0, 0, 0, 0);
        this.clearImage.setClickable(true);
        setClearIcon(null);
        setClearIconClickedListener(null);
        updateClearImageVisibility();
    }

    private final void setupLabel() {
        this.labelTextView.setSingleLine();
        this.labelTextView.setPadding(0, 0, 0, 0);
        this.labelTextView.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.editor_collapsedLabelFontSize));
        this.labelTextView.setPivotX(0.0f);
        this.labelTextView.setPivotY(0.0f);
    }

    private final void setupHelpAndError() {
        float dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.editor_helperTextFontSize);
        this.errorTextView.setVisibility(8);
        this.errorTextView.setTextSize(0, dimensionPixelSize);
        this.errorTextView.setGravity(80);
        this.helpTextView.setVisibility(8);
        this.helpTextView.setTextSize(0, dimensionPixelSize);
        this.helpTextView.setGravity(80);
    }

    private final void setupAffix() {
        float dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.editor_textFontSize);
        this.suffixView.setVisibility(8);
        this.suffixView.setTextSize(0, dimensionPixelSize);
        this.prefixView.setVisibility(8);
        this.prefixView.setTextSize(0, dimensionPixelSize);
    }

    private final void layoutIcons(List<? extends Element> icons, int l, int t, int r, int b) {
        int i = 0;
        for (Element element : icons) {
            ViewHolder viewHolder = element instanceof ViewHolder ? (ViewHolder) element : null;
            if (viewHolder != null && viewHolder.isVisible()) {
                if (i > 0) {
                    l += getIconSpacing();
                }
                viewHolder.getView().layout(l, t, viewHolder.getView().getMeasuredWidth() + l, b);
                l += viewHolder.getView().getMeasuredWidth();
                i++;
            }
        }
    }

    private final void initDefaultStyle() {
        setOutlinedStyle();
    }

    private final void initStyle() {
        initDefaultStyle();
    }

    protected final void onLayoutSettingsChanged() {
        if (this.isRefreshSuspended) {
            return;
        }
        updateLabelState(false);
        updateBottomTextState(false);
        requestLayout();
        jumpDrawablesToCurrentState();
    }

    protected final void onColorSettingsChanged() {
        if (this.isRefreshSuspended) {
            return;
        }
        updateAppearance();
    }

    protected void setupCommonStyleSizes() {
        Resources resources = getContext().getResources();
        getDropDownStyle().setBorderThickness(resources.getDimensionPixelSize(R.dimen.editor_border_thickness));
        getDropDownStyle().setFocusedBorderThickness(resources.getDimensionPixelSize(R.dimen.editor_border_thickness_focused));
        getDropDownStyle().setLabelTextBorderIndent(resources.getDimensionPixelSize(R.dimen.editor_label_text_border_indent));
        getDropDownStyle().setBorderRounds(new BorderRounds(resources.getDimensionPixelSize(R.dimen.editor_border_rounds)));
        getDropDownStyle().setIconIndent(resources.getDimensionPixelSize(R.dimen.editor_icon_indent));
        getDropDownStyle().setIconSpacing(resources.getDimensionPixelSize(R.dimen.editor_icon_spacing));
        getDropDownStyle().setAffixIndent(resources.getDimensionPixelSize(R.dimen.editor_affix_indent));
        getDropDownStyle().setCharacterCounterStartIndent(resources.getDimensionPixelSize(R.dimen.editor_character_counter_indent_start));
        getDropDownStyle().setMinBoxHeight(-1);
        getDropDownStyle().setMinBoxWidth(-1);
        getDropDownStyle().setBoxHeight(-1);
        getDropDownStyle().setLabelShakeAmplitude(resources.getDimensionPixelSize(R.dimen.editor_labelShakeAmplitude));
    }

    private final void setupFilledStyleSizes() {
        getDropDownStyle().setDisabledBorderThickness(getContext().getResources().getDimensionPixelSize(R.dimen.editor_border_thickness_disabled_filled));
        resetBoxPadding();
    }

    private final void setupOutlinedStyleSizes() {
        getDropDownStyle().setDisabledBorderThickness(getContext().getResources().getDimensionPixelSize(R.dimen.editor_border_thickness_disabled_outlined));
        resetBoxPadding();
    }

    protected void onBorderModeChanged() {
        BackgroundDrawableManager createDrawableManager = DrawableManagerFactory.createDrawableManager(getDropDownStyle());
        this.drawableManager = createDrawableManager;
        Drawable drawable = this.boxBackgroundDrawable;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        Drawable drawable2 = createDrawableManager.getDrawable();
        drawable2.setState(getDrawableState());
        drawable2.jumpToCurrentState();
        drawable2.setCallback(this);
        this.boxBackgroundDrawable = drawable2;
        onLayoutSettingsChanged();
        onColorSettingsChanged();
    }

    protected void onCornerModeChanged() {
        BackgroundDrawableManager backgroundDrawableManager = this.drawableManager;
        if (backgroundDrawableManager != null) {
            backgroundDrawableManager.updateCornerTreatment();
        }
        onColorSettingsChanged();
    }

    protected void onCornerRadiusChanged() {
        BackgroundDrawableManager backgroundDrawableManager = this.drawableManager;
        if (backgroundDrawableManager != null) {
            backgroundDrawableManager.updateCornerSize();
        }
        onColorSettingsChanged();
    }

    protected void setupCommonStyleColors() {
        Context context = getContext();
        getDropDownStyle().setLabelColor(ContextCompat.getColor(context, R.color.editor_label_color));
        getDropDownStyle().setFocusedLabelColor(ContextCompat.getColor(context, R.color.editor_label_color_focused));
        getDropDownStyle().setDisabledLabelColor(ContextCompat.getColor(context, R.color.editor_label_color_disabled));
        getDropDownStyle().setBorderColor(ContextCompat.getColor(context, R.color.editor_border_color));
        getDropDownStyle().setFocusedBorderColor(ContextCompat.getColor(context, R.color.editor_border_color_focused));
        getDropDownStyle().setDisabledBorderColor(ContextCompat.getColor(context, R.color.editor_border_color_disabled));
        getDropDownStyle().setTextColor(ContextCompat.getColor(context, R.color.editor_text_color));
        getDropDownStyle().setDisabledTextColor(ContextCompat.getColor(context, R.color.editor_text_color_disabled));
        getDropDownStyle().setPlaceholderTextColor(ContextCompat.getColor(context, R.color.editor_placeholder_text_color));
        getDropDownStyle().setHelpTextColor(ContextCompat.getColor(context, R.color.editor_help_text_color));
        getDropDownStyle().setDisabledHelpTextColor(ContextCompat.getColor(context, R.color.editor_help_text_color_disabled));
        getDropDownStyle().setErrorColor(ContextCompat.getColor(context, R.color.editor_error_color));
        getDropDownStyle().setAffixColor(ContextCompat.getColor(context, R.color.editor_affix_color));
        getDropDownStyle().setDisabledAffixColor(ContextCompat.getColor(context, R.color.editor_affix_color_disabled));
        getDropDownStyle().setStartIconColor(ContextCompat.getColor(context, R.color.editor_start_icon_color));
        getDropDownStyle().setDisabledStartIconColor(ContextCompat.getColor(context, R.color.editor_start_icon_color_disabled));
        getDropDownStyle().setEndIconColor(ContextCompat.getColor(context, R.color.editor_end_icon_color));
        getDropDownStyle().setDisabledEndIconColor(ContextCompat.getColor(context, R.color.editor_end_icon_color_disabled));
    }

    private final void setupFilledStyleColors() {
        Context context = getContext();
        getDropDownStyle().setBoxBackgroundColor(ContextCompat.getColor(context, R.color.editor_box_background_color_filled));
        getDropDownStyle().setDisabledBoxBackgroundColor(ContextCompat.getColor(context, R.color.editor_box_background_color_disabled_filled));
    }

    private final void setupOutlinedStyleColors() {
        Context context = getContext();
        getDropDownStyle().setBoxBackgroundColor(ContextCompat.getColor(context, R.color.editor_box_background_color_outlined));
        getDropDownStyle().setDisabledBoxBackgroundColor(ContextCompat.getColor(context, R.color.editor_box_background_color_disabled_outlined));
    }

    protected final void updateIconVisibility(ImageView image, boolean isVisible) {
        Intrinsics.checkNotNullParameter(image, "image");
        int i = (image.getDrawable() == null || !isVisible) ? 8 : 0;
        if (image.getVisibility() == i) {
            return;
        }
        image.setVisibility(i);
        requestLayout();
    }

    private final void updateAppearance() {
        Drawable drawable = this.boxBackgroundDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        getLabelAnimator().jumpToCurrentState();
    }

    protected void updateAll() {
        onTextColorChanged();
        onErrorColorChanged();
        onHelpTextColorChanged();
        onAffixColorChanged();
        onLayoutSettingsChanged();
        onBorderModeChanged();
        onStartIconColorsChanged();
        onEndIconColorsChanged();
        onClearIconColorsChanged();
        onErrorIconColorsChanged();
    }

    protected void setChildrenEnabled(boolean enabled) {
        getInternalEditor().setEnabled(enabled);
        this.labelTextView.setEnabled(enabled);
        this.helpTextView.setEnabled(enabled);
        this.errorTextView.setEnabled(enabled);
        this.suffixView.setEnabled(enabled);
        this.prefixView.setEnabled(enabled);
        this.startImage.setEnabled(enabled);
        this.endImage.setEnabled(enabled);
        this.errorImage.setEnabled(enabled && !this.isReadOnly);
        this.clearImage.setEnabled(enabled && !this.isReadOnly);
    }

    private final void onTextColorChanged() {
        if (this.isRefreshSuspended) {
            return;
        }
        getLabelAnimator().jumpToCurrentState();
        getInternalEditor().setTextColor(new ColorStateList(new int[][]{Constants.DISABLED_STATE, Constants.DEFAULT_STATE}, new int[]{getDropDownStyle().getDisabledTextColor(), getDropDownStyle().getTextColor()}));
    }

    protected void onHelpTextColorChanged() {
        if (this.isRefreshSuspended) {
            return;
        }
        this.helpTextView.setTextColor(new ColorStateList(new int[][]{Constants.DISABLED_STATE, Constants.DEFAULT_STATE}, new int[]{getDropDownStyle().getDisabledHelpTextColor(), getDropDownStyle().getHelpTextColor()}));
    }

    protected void onErrorColorChanged() {
        updateErrorTextTextColor();
        updateIconTintList(this.errorImage, getDropDownStyle().getErrorColor(), getDropDownStyle().getDisabledErrorIconColor());
    }

    private final void onAffixColorChanged() {
        if (this.isRefreshSuspended) {
            return;
        }
        ColorStateList colorStateList = new ColorStateList(new int[][]{Constants.DISABLED_STATE, Constants.DEFAULT_STATE}, new int[]{getDropDownStyle().getDisabledAffixColor(), getDropDownStyle().getAffixColor()});
        this.prefixView.setTextColor(colorStateList);
        this.suffixView.setTextColor(colorStateList);
    }

    private final void onStartIconColorsChanged() {
        updateIconTintList(this.startImage, getDropDownStyle().getStartIconColor(), getDropDownStyle().getDisabledStartIconColor());
    }

    private final void onEndIconColorsChanged() {
        updateIconTintList(this.endImage, getDropDownStyle().getEndIconColor(), getDropDownStyle().getDisabledEndIconColor());
    }

    private final void onClearIconColorsChanged() {
        updateIconTintList(this.clearImage, getDropDownStyle().getClearIconColor(), getDropDownStyle().getDisabledClearIconColor());
    }

    private final void onErrorIconColorsChanged() {
        updateIconTintList(this.errorImage, getDropDownStyle().getErrorIconColor(), getDropDownStyle().getDisabledErrorIconColor());
    }

    protected final void updateIconTintList(AppCompatImageButton iconView, int color, int disabledColor) {
        ColorStateList valueOf;
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        if (this.isRefreshSuspended) {
            return;
        }
        if (color == Constants.getEMPTY_COLOR() && disabledColor == Constants.getEMPTY_COLOR()) {
            valueOf = null;
        } else {
            valueOf = disabledColor == Constants.getEMPTY_COLOR() ? ColorStateList.valueOf(color) : new ColorStateList(new int[][]{Constants.DISABLED_STATE, Constants.DEFAULT_STATE}, new int[]{disabledColor, color});
        }
        ImageViewCompat.setImageTintList(iconView, valueOf);
    }

    private final void updateErrorTextTextColor() {
        if (this.isRefreshSuspended) {
            return;
        }
        this.errorTextView.setTextColor(new ColorStateList(new int[][]{Constants.DISABLED_STATE, Constants.DEFAULT_STATE}, new int[]{getDropDownStyle().getDisabledHelpTextColor(), getDropDownStyle().getErrorColor()}));
    }

    protected void onContainsFocusChange() {
        updateLabelState(this.allowAnimations);
        refreshDrawableState();
        if (this.isReadOnly) {
            hideSoftKeyboard();
        }
    }

    protected void onReadOnlyChanged() {
        updateClearImageVisibility();
        setChildrenEnabled(isEnabled());
        setInternalEditorTextSelectable(this.isReadOnly);
        setInternalEditorEditable(!this.isReadOnly);
        getInternalEditor().setCustomSelectionActionModeCallback(this.isReadOnly ? new ContextMenuDelegate(this) : null);
    }

    protected final void updateLabelState(boolean animated) {
        LabelPosition labelPosition;
        CharSequence labelText = getLabelText();
        if (labelText == null || labelText.length() == 0) {
            labelPosition = LabelPosition.NONE;
        } else if (this.isLabelFloating) {
            labelPosition = (this.containsFocus || getHasValue()) ? LabelPosition.ON_TOP : LabelPosition.DEFAULT;
        } else {
            labelPosition = LabelPosition.ON_TOP;
        }
        LabelPosition labelPosition2 = labelPosition;
        this.labelTextView.setVisibility(labelPosition2 == LabelPosition.NONE ? 8 : 0);
        getLabelAnimator().setState(labelPosition2, Boolean.valueOf(this.containsFocus), Boolean.valueOf(this.hasError), Boolean.valueOf(isEnabled()), animated);
    }

    private final void updateBottomTextState(boolean animated) {
        CharSequence errorText;
        if (animated) {
            beginBottomTextTransition();
        }
        if (this.hasError && (errorText = getErrorText()) != null && errorText.length() != 0) {
            this.helpTextView.setVisibility(8);
            this.errorTextView.setVisibility(0);
            return;
        }
        CharSequence helpText = getHelpText();
        if ((helpText != null && helpText.length() != 0) || this.reserveBottomTextLine) {
            this.helpTextView.setVisibility(0);
            this.errorTextView.setVisibility(8);
        } else {
            this.helpTextView.setVisibility(8);
            this.errorTextView.setVisibility(8);
        }
    }

    protected final void setInternalEditorTextSelectable(boolean isSelectable) {
        DXLocker dXLocker = this.locker;
        try {
            dXLocker.lock();
            getInternalEditor().setTextIsSelectable(isSelectable);
            if (isSelectable) {
                return;
            }
            getInternalEditor().setMovementMethod(ArrowKeyMovementMethod.getInstance());
            getInternalEditor().setFocusableInTouchMode(true);
            getInternalEditor().setLongClickable(true);
            getInternalEditor().setClickable(true);
        } finally {
            dXLocker.unlock();
        }
    }

    protected void setInternalEditorEditable(boolean isEditable) {
        onEditorInputTypeChange();
        if (!isEditable) {
            hideSoftKeyboard();
        } else {
            setInternalEditorTextSelectable(false);
        }
    }

    protected void onPlaceholderColorChanged() {
        getInternalEditor().setHintTextColor(getDropDownStyle().getPlaceholderTextColor());
    }

    protected void onBottomTextTypefaceChanged(Typeface typeface) {
        this.errorTextView.setTypeface(typeface);
        this.helpTextView.setTypeface(typeface);
    }

    protected void onBottomTextSizeChanged(int unit, float value) {
        this.helpTextView.setTextSize(unit, value);
        this.errorTextView.setTextSize(unit, value);
    }

    protected void onValueChanged() {
        updateLabelState(this.allowAnimations);
        requestLayout();
    }

    protected boolean onEditorAction(int actionId) {
        OnEditActionListener onEditActionListener = this.onEditActionListener;
        boolean onEditorAction = onEditActionListener != null ? onEditActionListener.onEditorAction(actionId) : false;
        if (onEditorAction) {
            return onEditorAction;
        }
        if (actionId != 2 && actionId != 3 && actionId != 6) {
            return false;
        }
        clearFocus();
        return true;
    }

    private final void beginBottomTextTransition() {
        TransitionSet addTransition = new TransitionSet().setOrdering(1).addTransition(new BottomTextVisibility(2, 0).setDuration(Constants.ANIMATION_DURATION)).addTransition(new ChangeBounds().setDuration(0L)).addTransition(new BottomTextVisibility(1, -getDropDownStyle().getBottomTextTopIndent()).setDuration(Constants.ANIMATION_DURATION));
        Intrinsics.checkNotNullExpressionValue(addTransition, "addTransition(...)");
        TransitionSet transitionSet = addTransition;
        transitionSet.addTarget((View) this.helpTextView);
        transitionSet.addTarget((View) this.errorTextView);
        TransitionManager.beginDelayedTransition(this, transitionSet);
    }

    private final HitTestType calcHitTest(int x, int y) {
        if (!this.contentLayout.getBoxFrame().contains(x, y)) {
            return HitTestType.None;
        }
        if (this.contentLayout.getInternalEditorFrame().contains(x, y)) {
            return HitTestType.TextInput;
        }
        if (this.contentLayout.getLeadingIconFrame().contains(x, y)) {
            return HitTestType.LeadingIcons;
        }
        if (this.contentLayout.getTrailingIconFrame().contains(x, y)) {
            return HitTestType.TrailingIcons;
        }
        return HitTestType.BoxEmptySpace;
    }

    protected final void hideSoftKeyboard() {
        Object systemService = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(getWindowToken(), 0);
    }

    protected final void showSoftKeyboard() {
        Object systemService = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(getInternalEditor(), 0);
    }

    protected final void updatePlaceholderText() {
        getInternalEditor().setHint(getPlaceholder());
    }

    /* compiled from: EditBase.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/devexpress/editors/EditBase$GlobalFocusChangedListener;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "(Lcom/devexpress/editors/EditBase;)V", "checkViewInHierarchy", "", "view", "Landroid/view/View;", "onGlobalFocusChanged", "", "oldFocus", "newFocus", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class GlobalFocusChangedListener implements ViewTreeObserver.OnGlobalFocusChangeListener {
        public GlobalFocusChangedListener() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(View oldFocus, View newFocus) {
            if (newFocus == null) {
                if (!EditBase.this.getContainsFocus() || EditBase.this.forceXamarinKeepFocus) {
                    return;
                }
                EditBase.this.setContainsFocus$dxeditors_release(false);
                return;
            }
            EditBase.this.setContainsFocus$dxeditors_release(checkViewInHierarchy(newFocus));
        }

        private final boolean checkViewInHierarchy(View view) {
            if (Intrinsics.areEqual(view, EditBase.this)) {
                return true;
            }
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                if (Intrinsics.areEqual(parent, EditBase.this)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: EditBase.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/devexpress/editors/EditBase$OnEditorActionListener;", "Lcom/devexpress/editors/WeakHolder;", "Lcom/devexpress/editors/EditBase;", "Landroid/widget/TextView$OnEditorActionListener;", "edit", "(Lcom/devexpress/editors/EditBase;Lcom/devexpress/editors/EditBase;)V", "onEditorAction", "", "v", "Landroid/widget/TextView;", "actionId", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class OnEditorActionListener extends WeakHolder<EditBase> implements TextView.OnEditorActionListener {
        public OnEditorActionListener(EditBase editBase) {
            super(editBase);
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            Intrinsics.checkNotNullParameter(v, "v");
            EditBase edit = getEdit();
            if (edit == null) {
                return false;
            }
            if (event == null) {
                return edit.onEditorAction(actionId);
            }
            if (event.getAction() == 0 && event.getKeyCode() == 66) {
                return edit.onEditorAction(edit.getImeActionOptions());
            }
            return false;
        }
    }

    /* compiled from: EditBase.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t²\u0006\f\u0010\n\u001a\u0004\u0018\u00010\bX\u008a\u0084\u0002"}, d2 = {"Lcom/devexpress/editors/EditBase$Companion;", "", "()V", "createLabelStateChangedCallback", "Lkotlin/Function1;", "Lcom/devexpress/editors/utils/LabelPosition;", "", "textEdit", "Lcom/devexpress/editors/EditBase;", "dxeditors_release", "weakEdit"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(Companion.class, "weakEdit", "<v#0>", 0))};

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final EditBase createLabelStateChangedCallback$lambda$0(WeakProperty<EditBase> weakProperty) {
            return weakProperty.getValue(null, $$delegatedProperties[0]);
        }

        @JvmStatic
        public final Function1<LabelPosition, Unit> createLabelStateChangedCallback(EditBase textEdit) {
            final WeakProperty weak = WeakPropertyKt.weak(textEdit);
            return new Function1<LabelPosition, Unit>() { // from class: com.devexpress.editors.EditBase$Companion$createLabelStateChangedCallback$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LabelPosition labelPosition) {
                    invoke2(labelPosition);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LabelPosition labelPosition) {
                    EditBase createLabelStateChangedCallback$lambda$0;
                    Intrinsics.checkNotNullParameter(labelPosition, "<anonymous parameter 0>");
                    createLabelStateChangedCallback$lambda$0 = EditBase.Companion.createLabelStateChangedCallback$lambda$0(weak);
                    if (createLabelStateChangedCallback$lambda$0 != null) {
                        createLabelStateChangedCallback$lambda$0.refreshDrawableState();
                    }
                }
            };
        }
    }

    public final int getDp(int i) {
        return (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }
}
