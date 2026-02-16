package com.devexpress.editors;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GestureDetectorCompat;
import com.devexpress.dxcore.DXNativeView;
import com.devexpress.editors.model.BorderRounds;
import com.devexpress.editors.model.Thickness;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001(\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0090\u0002B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0002J\n\u0010Ú\u0001\u001a\u00030Û\u0001H\u0002J\n\u0010Ü\u0001\u001a\u00030Û\u0001H\u0002J\n\u0010Ý\u0001\u001a\u00030Ù\u0001H\u0014J\u0013\u0010Þ\u0001\u001a\u00030Ù\u00012\u0007\u0010ß\u0001\u001a\u00020\u001bH\u0016J\u001b\u0010à\u0001\u001a\u00020=2\u0007\u0010á\u0001\u001a\u00020\u00102\u0007\u0010â\u0001\u001a\u00020\u0010H\u0002J\u0013\u0010ã\u0001\u001a\u00030Ù\u00012\u0007\u0010ä\u0001\u001a\u00020\tH\u0016J\t\u0010å\u0001\u001a\u00020=H\u0002J\n\u0010æ\u0001\u001a\u00030Ù\u0001H\u0002J\u0015\u0010ç\u0001\u001a\u0005\u0018\u00010Û\u00012\u0007\u0010è\u0001\u001a\u00020\tH\u0014J\t\u0010é\u0001\u001a\u00020=H\u0002J\u0014\u0010ê\u0001\u001a\u00030Ù\u00012\b\u0010ë\u0001\u001a\u00030ì\u0001H\u0014J7\u0010í\u0001\u001a\u00030Ù\u00012\u0007\u0010î\u0001\u001a\u00020=2\u0007\u0010ï\u0001\u001a\u00020\t2\u0007\u0010ð\u0001\u001a\u00020\t2\u0007\u0010ñ\u0001\u001a\u00020\t2\u0007\u0010ò\u0001\u001a\u00020\tH\u0014J\t\u0010ó\u0001\u001a\u00020=H\u0002J\u001b\u0010ô\u0001\u001a\u00020t2\u0007\u0010õ\u0001\u001a\u00020\t2\u0007\u0010ö\u0001\u001a\u00020\tH\u0014J\n\u0010÷\u0001\u001a\u00030Ù\u0001H\u0002J\t\u0010ø\u0001\u001a\u00020=H\u0002J\t\u0010ù\u0001\u001a\u00020=H\u0002J \u0010ú\u0001\u001a\u00020=2\t\u0010û\u0001\u001a\u0004\u0018\u00010\f2\n\u0010ü\u0001\u001a\u0005\u0018\u00010ý\u0001H\u0016J\n\u0010þ\u0001\u001a\u00030Ù\u0001H\u0016J\u0013\u0010ÿ\u0001\u001a\u00030Ù\u00012\u0007\u0010\u0080\u0002\u001a\u00020\u001bH\u0016J\u0013\u0010\u0081\u0002\u001a\u00030Ù\u00012\u0007\u0010\u0082\u0002\u001a\u00020=H\u0002J,\u0010\u0083\u0002\u001a\u00030Ù\u00012\u0007\u0010\u0084\u0002\u001a\u00020\u00102\u0007\u0010\u0085\u0002\u001a\u00020\u00102\u0007\u0010\u0086\u0002\u001a\u00020\u00102\u0007\u0010\u0087\u0002\u001a\u00020\u0010J.\u0010\u0088\u0002\u001a\u00030Ù\u00012\u0007\u0010ï\u0001\u001a\u00020\t2\u0007\u0010ð\u0001\u001a\u00020\t2\u0007\u0010ñ\u0001\u001a\u00020\t2\u0007\u0010ò\u0001\u001a\u00020\tH\u0016J\u0019\u0010È\u0001\u001a\u00030Ù\u00012\u0007\u0010\u0089\u0002\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\n\u0010\u008a\u0002\u001a\u00030Ù\u0001H\u0002J\n\u0010\u008b\u0002\u001a\u00030Ù\u0001H\u0002J\u001a\u0010\u008c\u0002\u001a\u00030Ù\u00012\u0007\u0010\u008d\u0002\u001a\u00020\t2\u0007\u0010\u008e\u0002\u001a\u00020\tJ\u0014\u0010\u008f\u0002\u001a\u00030Ù\u00012\b\u0010ü\u0001\u001a\u00030ý\u0001H\u0002R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)R\u000e\u0010*\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R(\u00101\u001a\u0004\u0018\u00010\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001e\"\u0004\b3\u0010 R(\u00104\u001a\u0004\u0018\u00010\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001e\"\u0004\b6\u0010 R\u0014\u00107\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0018R$\u00109\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b:\u0010\u0013\"\u0004\b;\u0010\u0015R\u000e\u0010<\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0018R(\u0010@\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010CR$\u0010D\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010\u0018\"\u0004\bF\u0010GR$\u0010H\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010\u0018\"\u0004\bJ\u0010GR$\u0010K\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u0010\u0018\"\u0004\bM\u0010GR$\u0010N\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bO\u0010\u0018\"\u0004\bP\u0010GR$\u0010Q\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bR\u0010\u0018\"\u0004\bS\u0010GR$\u0010T\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bU\u0010\u0018\"\u0004\bV\u0010GR$\u0010W\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bX\u0010\u0018\"\u0004\bY\u0010GR$\u0010Z\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u0010\u0018\"\u0004\b\\\u0010GR$\u0010]\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010\u0018\"\u0004\b_\u0010GR$\u0010`\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010\u0018\"\u0004\bb\u0010GR$\u0010c\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010\u0018\"\u0004\be\u0010GR$\u0010f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bg\u0010\u0018\"\u0004\bh\u0010GR\u0014\u0010i\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bj\u0010\u0018R\u001a\u0010k\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u0018\"\u0004\bm\u0010GR\u0014\u0010n\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bo\u0010\u0018R$\u0010p\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bq\u0010\u0013\"\u0004\br\u0010\u0015R\u0014\u0010s\u001a\u00020t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bu\u0010vR\u0014\u0010w\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bx\u0010\u0018R\u0014\u0010y\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bz\u0010\u0018R\u0014\u0010{\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b|\u0010\u0018R%\u0010}\u001a\u00020=2\u0006\u0010\u000f\u001a\u00020=@FX\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R(\u0010\u0081\u0001\u001a\u00020=2\u0006\u0010\u000f\u001a\u00020=8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b\u0081\u0001\u0010~\"\u0006\b\u0082\u0001\u0010\u0080\u0001R(\u0010\u0083\u0001\u001a\u00020=2\u0006\u0010\u000f\u001a\u00020=8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b\u0083\u0001\u0010~\"\u0006\b\u0084\u0001\u0010\u0080\u0001R(\u0010\u0085\u0001\u001a\u00020=2\u0006\u0010\u000f\u001a\u00020=8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b\u0085\u0001\u0010~\"\u0006\b\u0086\u0001\u0010\u0080\u0001R\u0016\u0010\u0087\u0001\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010\u0018R\u0010\u0010\u0089\u0001\u001a\u00030\u008a\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010\u008b\u0001\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008c\u0001\u0010\u0018\"\u0005\b\u008d\u0001\u0010GR'\u0010\u008e\u0001\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008f\u0001\u0010\u0018\"\u0005\b\u0090\u0001\u0010GR'\u0010\u0091\u0001\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0092\u0001\u0010\u0018\"\u0005\b\u0093\u0001\u0010GR'\u0010\u0094\u0001\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0095\u0001\u0010\u0018\"\u0005\b\u0096\u0001\u0010GR'\u0010\u0097\u0001\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0098\u0001\u0010\u0018\"\u0005\b\u0099\u0001\u0010GR'\u0010\u009a\u0001\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009b\u0001\u0010\u0018\"\u0005\b\u009c\u0001\u0010GR\u0016\u0010\u009d\u0001\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u009e\u0001\u0010\u0018R(\u0010\u009f\u0001\u001a\u00020=2\u0006\u0010\u000f\u001a\u00020=8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b \u0001\u0010~\"\u0006\b¡\u0001\u0010\u0080\u0001R'\u0010¢\u0001\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b£\u0001\u0010\u0018\"\u0005\b¤\u0001\u0010GR'\u0010¥\u0001\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¦\u0001\u0010\u0018\"\u0005\b§\u0001\u0010GR'\u0010¨\u0001\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b©\u0001\u0010\u0018\"\u0005\bª\u0001\u0010GR'\u0010«\u0001\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¬\u0001\u0010\u0018\"\u0005\b\u00ad\u0001\u0010GR'\u0010®\u0001\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¯\u0001\u0010\u0018\"\u0005\b°\u0001\u0010GR'\u0010±\u0001\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b²\u0001\u0010\u0018\"\u0005\b³\u0001\u0010GR'\u0010´\u0001\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bµ\u0001\u0010\u0018\"\u0005\b¶\u0001\u0010GR'\u0010·\u0001\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¸\u0001\u0010\u0018\"\u0005\b¹\u0001\u0010GR'\u0010º\u0001\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b»\u0001\u0010\u0018\"\u0005\b¼\u0001\u0010GR'\u0010½\u0001\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¾\u0001\u0010\u0018\"\u0005\b¿\u0001\u0010GR/\u0010Á\u0001\u001a\u0005\u0018\u00010À\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010À\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÂ\u0001\u0010Ã\u0001\"\u0006\bÄ\u0001\u0010Å\u0001R'\u0010Æ\u0001\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÇ\u0001\u0010\u0013\"\u0005\bÈ\u0001\u0010\u0015R\u0010\u0010É\u0001\u001a\u00030Ê\u0001X\u0082.¢\u0006\u0002\n\u0000R/\u0010Ì\u0001\u001a\u0005\u0018\u00010Ë\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010Ë\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R(\u0010Ñ\u0001\u001a\u00020=2\u0006\u0010\u000f\u001a\u00020=8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\bÒ\u0001\u0010~\"\u0006\bÓ\u0001\u0010\u0080\u0001R\u000f\u0010Ô\u0001\u001a\u00020tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010Õ\u0001\u001a\u00020\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÖ\u0001\u0010\u0018\"\u0005\b×\u0001\u0010G¨\u0006\u0091\u0002"}, d2 = {"Lcom/devexpress/editors/Chip;", "Lcom/devexpress/dxcore/DXNativeView;", "Lcom/devexpress/editors/ChipDrawableDelegate;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actualContentView", "Landroid/view/View;", "getActualContentView", "()Landroid/view/View;", "value", "", "borderThickness", "getBorderThickness", "()F", "setBorderThickness", "(F)V", "checkIconHeight", "getCheckIconHeight", "()I", "checkIconWidth", "getCheckIconWidth", "Landroid/graphics/drawable/Drawable;", "checkedIcon", "getCheckedIcon", "()Landroid/graphics/drawable/Drawable;", "setCheckedIcon", "(Landroid/graphics/drawable/Drawable;)V", "chipAction", "Lcom/devexpress/editors/ChipAction;", "getChipAction", "()Lcom/devexpress/editors/ChipAction;", "setChipAction", "(Lcom/devexpress/editors/ChipAction;)V", "chipAnimator", "com/devexpress/editors/Chip$chipAnimator$1", "Lcom/devexpress/editors/Chip$chipAnimator$1;", "chipBackgroundDrawable", "chipDrawable", "Lcom/devexpress/editors/CustomChipDrawable;", "getChipDrawable$dxeditors_release", "()Lcom/devexpress/editors/CustomChipDrawable;", "setChipDrawable$dxeditors_release", "(Lcom/devexpress/editors/CustomChipDrawable;)V", "chipIcon", "getChipIcon", "setChipIcon", "closeIcon", "getCloseIcon", "setCloseIcon", "closeIconHeight", "getCloseIconHeight", "closeIconIndent", "getCloseIconIndent", "setCloseIconIndent", "closeIconPressed", "", "closeIconWidth", "getCloseIconWidth", "contentView", "getContentView", "setContentView", "(Landroid/view/View;)V", "disabledBackgroundColor", "getDisabledBackgroundColor", "setDisabledBackgroundColor", "(I)V", "disabledBorderColor", "getDisabledBorderColor", "setDisabledBorderColor", "disabledCheckIconColor", "getDisabledCheckIconColor", "setDisabledCheckIconColor", "disabledCloseIconColor", "getDisabledCloseIconColor", "setDisabledCloseIconColor", "disabledIconColor", "getDisabledIconColor", "setDisabledIconColor", "disabledTextColor", "getDisabledTextColor", "setDisabledTextColor", "enabledBackgroundColor", "getEnabledBackgroundColor", "setEnabledBackgroundColor", "enabledBorderColor", "getEnabledBorderColor", "setEnabledBorderColor", "enabledCheckIconColor", "getEnabledCheckIconColor", "setEnabledCheckIconColor", "enabledCloseIconColor", "getEnabledCloseIconColor", "setEnabledCloseIconColor", "enabledIconColor", "getEnabledIconColor", "setEnabledIconColor", "enabledTextColor", "getEnabledTextColor", "setEnabledTextColor", "extraSpaceForIcons", "getExtraSpaceForIcons", "horizontalContentAlignment", "getHorizontalContentAlignment", "setHorizontalContentAlignment", "iconHeight", "getIconHeight", "iconIndent", "getIconIndent", "setIconIndent", "iconSize", "Landroid/util/Size;", "getIconSize", "()Landroid/util/Size;", "iconWidth", "getIconWidth", "iconsHeight", "getIconsHeight", "iconsWidth", "getIconsWidth", "isChecked", "()Z", "setChecked", "(Z)V", "isCheckedIconVisible", "setCheckedIconVisible", "isChipIconVisible", "setChipIconVisible", "isCloseIconVisible", "setCloseIconVisible", "leftIndent", "getLeftIndent", "mDetector", "Landroidx/core/view/GestureDetectorCompat;", "pressedBackgroundColor", "getPressedBackgroundColor", "setPressedBackgroundColor", "pressedBorderColor", "getPressedBorderColor", "setPressedBorderColor", "pressedCheckIconColor", "getPressedCheckIconColor", "setPressedCheckIconColor", "pressedCloseIconColor", "getPressedCloseIconColor", "setPressedCloseIconColor", "pressedIconColor", "getPressedIconColor", "setPressedIconColor", "pressedTextColor", "getPressedTextColor", "setPressedTextColor", "rightIndent", "getRightIndent", "roundedIcon", "getRoundedIcon", "setRoundedIcon", "selectedBackgroundColor", "getSelectedBackgroundColor", "setSelectedBackgroundColor", "selectedBorderColor", "getSelectedBorderColor", "setSelectedBorderColor", "selectedCloseIconColor", "getSelectedCloseIconColor", "setSelectedCloseIconColor", "selectedDisabledBackgroundColor", "getSelectedDisabledBackgroundColor", "setSelectedDisabledBackgroundColor", "selectedDisabledBorderColor", "getSelectedDisabledBorderColor", "setSelectedDisabledBorderColor", "selectedDisabledCloseIconColor", "getSelectedDisabledCloseIconColor", "setSelectedDisabledCloseIconColor", "selectedDisabledIconColor", "getSelectedDisabledIconColor", "setSelectedDisabledIconColor", "selectedDisabledTextColor", "getSelectedDisabledTextColor", "setSelectedDisabledTextColor", "selectedIconColor", "getSelectedIconColor", "setSelectedIconColor", "selectedTextColor", "getSelectedTextColor", "setSelectedTextColor", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textSize", "getTextSize", "setTextSize", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/graphics/Typeface;", "typeface", "getTypeface", "()Landroid/graphics/Typeface;", "setTypeface", "(Landroid/graphics/Typeface;)V", "useRippleEffect", "getUseRippleEffect", "setUseRippleEffect", "userIconSize", "verticalContentAlignment", "getVerticalContentAlignment", "setVerticalContentAlignment", "applyTextStyle", "", "createCloseIconDrawableState", "", "createDrawableState", "drawableStateChanged", "invalidateDrawable", "who", "isPointInCloseIcon", "x", "y", "onChipTextColorChange", TypedValues.Custom.S_COLOR, "onCloseIconTap", "onContentViewChanged", "onCreateDrawableState", "extraSpace", "onDoubleTap", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "left", "top", "right", "bottom", "onLongPress", "onMeasureCore", "widthMeasureSpec", "heightMeasureSpec", "onRippleColorChanged", "onSingleTapConfirmed", "onSingleTapUp", "onTouch", "v", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "requestLayout", "setBackground", "background", "setCloseIconPressed", "pressed", "setCornerRadii", "topLeft", "topRight", "bottomLeft", "bottomRight", "setPadding", "unit", "updateBackground", "updateChip", "updateIconSize", "width", "height", "updateRippleHotSpot", "ChipGestureListener", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Chip extends DXNativeView implements ChipDrawableDelegate, View.OnTouchListener {
    private Drawable checkedIcon;
    private ChipAction chipAction;
    private final Chip$chipAnimator$1 chipAnimator;
    private Drawable chipBackgroundDrawable;
    private CustomChipDrawable chipDrawable;
    private Drawable chipIcon;
    private Drawable closeIcon;
    private boolean closeIconPressed;
    private View contentView;
    private int horizontalContentAlignment;
    private boolean isChecked;
    private GestureDetectorCompat mDetector;
    private AppCompatTextView textView;
    private Size userIconSize;
    private int verticalContentAlignment;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Chip(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
        Intrinsics.checkNotNullParameter(background, "background");
    }

    public /* synthetic */ Chip(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Chip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        CustomChipDrawable customChipDrawable = new CustomChipDrawable(context);
        this.chipDrawable = customChipDrawable;
        Thickness padding = customChipDrawable.getStyle().getPadding();
        setPadding(padding.getStart(), padding.getTop(), padding.getEnd(), padding.getBottom());
        applyTextStyle();
        updateBackground();
        setClickable(true);
        setClipChildren(false);
        setClipToPadding(false);
        setWillNotDraw(false);
        onContentViewChanged();
        this.mDetector = new GestureDetectorCompat(getContext(), new ChipGestureListener());
        setOnTouchListener(this);
        createCloseIconDrawableState();
        this.chipDrawable.setDelegate(this);
        this.verticalContentAlignment = 16;
        this.horizontalContentAlignment = 1;
        this.userIconSize = new Size(getResources().getDimensionPixelSize(R.dimen.chip_icon_size), getResources().getDimensionPixelSize(R.dimen.chip_icon_size));
        final Chip$chipAnimator$1 chip$chipAnimator$1 = new Chip$chipAnimator$1();
        chip$chipAnimator$1.setFloatValues(0.0f, 1.0f);
        chip$chipAnimator$1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.devexpress.editors.Chip$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Chip.chipAnimator$lambda$3$lambda$2(Chip.this, chip$chipAnimator$1, valueAnimator);
            }
        });
        this.chipAnimator = chip$chipAnimator$1;
    }

    /* renamed from: getChipDrawable$dxeditors_release, reason: from getter */
    public final CustomChipDrawable getChipDrawable() {
        return this.chipDrawable;
    }

    public final void setChipDrawable$dxeditors_release(CustomChipDrawable customChipDrawable) {
        Intrinsics.checkNotNullParameter(customChipDrawable, "<set-?>");
        this.chipDrawable = customChipDrawable;
    }

    public final ChipAction getChipAction() {
        return this.chipAction;
    }

    public final void setChipAction(ChipAction chipAction) {
        this.chipAction = chipAction;
    }

    private final int[] createCloseIconDrawableState() {
        ArrayList arrayList = new ArrayList();
        if (isEnabled()) {
            arrayList.add(Integer.valueOf(android.R.attr.state_enabled));
        } else {
            arrayList.add(-16842910);
        }
        if (this.closeIconPressed) {
            arrayList.add(Integer.valueOf(android.R.attr.state_pressed));
        }
        if (this.isChecked) {
            arrayList.add(Integer.valueOf(android.R.attr.state_checked));
        }
        return CollectionsKt.toIntArray(arrayList);
    }

    private final int[] createDrawableState() {
        ArrayList arrayList = new ArrayList();
        if (isEnabled()) {
            arrayList.add(Integer.valueOf(android.R.attr.state_enabled));
        } else {
            arrayList.add(-16842910);
        }
        if (isPressed()) {
            arrayList.add(Integer.valueOf(android.R.attr.state_pressed));
        }
        if (this.isChecked) {
            arrayList.add(Integer.valueOf(android.R.attr.state_checked));
        }
        return CollectionsKt.toIntArray(arrayList);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Drawable drawable = this.chipBackgroundDrawable;
        if (drawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chipBackgroundDrawable");
            drawable = null;
        }
        drawable.draw(canvas);
    }

    private final void updateBackground() {
        CustomChipDrawable customChipDrawable;
        Drawable drawable = null;
        if (this.chipDrawable.getStyle().getUseRippleEffect()) {
            ColorStateList rippleColor$dxeditors_release = this.chipDrawable.getStyle().getRippleColor$dxeditors_release();
            Intrinsics.checkNotNull(rippleColor$dxeditors_release);
            customChipDrawable = new RippleDrawable(rippleColor$dxeditors_release, this.chipDrawable, null);
        } else {
            customChipDrawable = this.chipDrawable;
        }
        this.chipBackgroundDrawable = customChipDrawable;
        if (customChipDrawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chipBackgroundDrawable");
        } else {
            drawable = customChipDrawable;
        }
        drawable.setCallback(this);
        requestLayout();
    }

    private final void applyTextStyle() {
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.textView = appCompatTextView;
        appCompatTextView.setBackgroundColor(0);
        AppCompatTextView appCompatTextView2 = this.textView;
        AppCompatTextView appCompatTextView3 = null;
        if (appCompatTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            appCompatTextView2 = null;
        }
        appCompatTextView2.setTextSize(this.chipDrawable.getStyle().getTextSize());
        AppCompatTextView appCompatTextView4 = this.textView;
        if (appCompatTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            appCompatTextView4 = null;
        }
        appCompatTextView4.setSingleLine(true);
        AppCompatTextView appCompatTextView5 = this.textView;
        if (appCompatTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            appCompatTextView5 = null;
        }
        appCompatTextView5.setEllipsize(TextUtils.TruncateAt.END);
        AppCompatTextView appCompatTextView6 = this.textView;
        if (appCompatTextView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            appCompatTextView6 = null;
        }
        appCompatTextView6.setTextAlignment(1);
        AppCompatTextView appCompatTextView7 = this.textView;
        if (appCompatTextView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        } else {
            appCompatTextView3 = appCompatTextView7;
        }
        appCompatTextView3.setGravity(17);
    }

    public final float getBorderThickness() {
        return this.chipDrawable.getStyle().getBorderThickness();
    }

    public final void setBorderThickness(float f) {
        if (this.chipDrawable.getStyle().getBorderThickness() == f) {
            return;
        }
        this.chipDrawable.getStyle().setBorderThickness(f);
        invalidate();
    }

    public final int getEnabledBackgroundColor() {
        return this.chipDrawable.getStyle().getEnabledBackgroundColor();
    }

    public final void setEnabledBackgroundColor(int i) {
        if (this.chipDrawable.getStyle().getEnabledBackgroundColor() != i) {
            this.chipDrawable.getStyle().setEnabledBackgroundColor(i);
            this.chipDrawable.onColorChanged();
        }
    }

    public final int getDisabledBackgroundColor() {
        return this.chipDrawable.getStyle().getDisabledBackgroundColor();
    }

    public final void setDisabledBackgroundColor(int i) {
        if (this.chipDrawable.getStyle().getDisabledBackgroundColor() != i) {
            this.chipDrawable.getStyle().setDisabledBackgroundColor(i);
            this.chipDrawable.onColorChanged();
        }
    }

    public final int getPressedBackgroundColor() {
        return this.chipDrawable.getStyle().getPressedBackgroundColor();
    }

    public final void setPressedBackgroundColor(int i) {
        if (this.chipDrawable.getStyle().getPressedBackgroundColor() != i) {
            this.chipDrawable.getStyle().setPressedBackgroundColor(i);
            this.chipDrawable.onColorChanged();
        }
    }

    public final int getSelectedBackgroundColor() {
        return this.chipDrawable.getStyle().getSelectedBackgroundColor();
    }

    public final void setSelectedBackgroundColor(int i) {
        if (this.chipDrawable.getStyle().getSelectedBackgroundColor() != i) {
            this.chipDrawable.getStyle().setSelectedBackgroundColor(i);
            onRippleColorChanged();
            this.chipDrawable.onColorChanged();
        }
    }

    public final int getSelectedDisabledBackgroundColor() {
        return this.chipDrawable.getStyle().getSelectedDisabledBackgroundColor();
    }

    public final void setSelectedDisabledBackgroundColor(int i) {
        if (this.chipDrawable.getStyle().getSelectedDisabledBackgroundColor() != i) {
            this.chipDrawable.getStyle().setSelectedDisabledBackgroundColor(i);
            this.chipDrawable.onColorChanged();
        }
    }

    public final int getEnabledTextColor() {
        return this.chipDrawable.getStyle().getEnabledTextColor();
    }

    public final void setEnabledTextColor(int i) {
        if (this.chipDrawable.getStyle().getEnabledTextColor() != i) {
            this.chipDrawable.getStyle().setEnabledTextColor(i);
            this.chipDrawable.onColorChanged();
        }
    }

    public final int getDisabledTextColor() {
        return this.chipDrawable.getStyle().getDisabledTextColor();
    }

    public final void setDisabledTextColor(int i) {
        if (this.chipDrawable.getStyle().getDisabledTextColor() != i) {
            this.chipDrawable.getStyle().setDisabledTextColor(i);
            this.chipDrawable.onColorChanged();
        }
    }

    public final int getPressedTextColor() {
        return this.chipDrawable.getStyle().getPressedTextColor();
    }

    public final void setPressedTextColor(int i) {
        if (this.chipDrawable.getStyle().getPressedTextColor() != i) {
            this.chipDrawable.getStyle().setPressedTextColor(i);
            this.chipDrawable.onColorChanged();
        }
    }

    public final int getSelectedTextColor() {
        return this.chipDrawable.getStyle().getSelectedTextColor();
    }

    public final void setSelectedTextColor(int i) {
        if (this.chipDrawable.getStyle().getSelectedTextColor() != i) {
            this.chipDrawable.getStyle().setSelectedTextColor(i);
            this.chipDrawable.onColorChanged();
        }
    }

    public final int getSelectedDisabledTextColor() {
        return this.chipDrawable.getStyle().getSelectedDisabledTextColor();
    }

    public final void setSelectedDisabledTextColor(int i) {
        if (this.chipDrawable.getStyle().getSelectedDisabledTextColor() != i) {
            this.chipDrawable.getStyle().setSelectedDisabledTextColor(i);
            this.chipDrawable.onColorChanged();
        }
    }

    public final int getEnabledBorderColor() {
        return this.chipDrawable.getStyle().getEnabledBorderColor();
    }

    public final void setEnabledBorderColor(int i) {
        if (this.chipDrawable.getStyle().getEnabledBorderColor() != i) {
            this.chipDrawable.getStyle().setEnabledBorderColor(i);
            this.chipDrawable.onColorChanged();
        }
    }

    public final int getDisabledBorderColor() {
        return this.chipDrawable.getStyle().getDisabledBorderColor();
    }

    public final void setDisabledBorderColor(int i) {
        if (this.chipDrawable.getStyle().getDisabledBorderColor() != i) {
            this.chipDrawable.getStyle().setDisabledBorderColor(i);
            this.chipDrawable.onColorChanged();
        }
    }

    public final int getPressedBorderColor() {
        return this.chipDrawable.getStyle().getPressedBorderColor();
    }

    public final void setPressedBorderColor(int i) {
        if (this.chipDrawable.getStyle().getPressedBorderColor() != i) {
            this.chipDrawable.getStyle().setPressedBorderColor(i);
            this.chipDrawable.onColorChanged();
        }
    }

    public final int getSelectedBorderColor() {
        return this.chipDrawable.getStyle().getSelectedBorderColor();
    }

    public final void setSelectedBorderColor(int i) {
        if (this.chipDrawable.getStyle().getSelectedBorderColor() != i) {
            this.chipDrawable.getStyle().setSelectedBorderColor(i);
            this.chipDrawable.onColorChanged();
        }
    }

    public final int getSelectedDisabledBorderColor() {
        return this.chipDrawable.getStyle().getSelectedDisabledBorderColor();
    }

    public final void setSelectedDisabledBorderColor(int i) {
        if (this.chipDrawable.getStyle().getSelectedDisabledBorderColor() != i) {
            this.chipDrawable.getStyle().setSelectedDisabledBorderColor(i);
            this.chipDrawable.onColorChanged();
        }
    }

    public final int getEnabledCheckIconColor() {
        return this.chipDrawable.getStyle().getEnabledCheckIconColor();
    }

    public final void setEnabledCheckIconColor(int i) {
        if (this.chipDrawable.getStyle().getEnabledCheckIconColor() != i) {
            this.chipDrawable.getStyle().setEnabledCheckIconColor(i);
            this.chipDrawable.updateCheckIconColorStateList();
        }
    }

    public final int getDisabledCheckIconColor() {
        return this.chipDrawable.getStyle().getDisabledCheckIconColor();
    }

    public final void setDisabledCheckIconColor(int i) {
        if (this.chipDrawable.getStyle().getDisabledCheckIconColor() != i) {
            this.chipDrawable.getStyle().setDisabledCheckIconColor(i);
            this.chipDrawable.updateCheckIconColorStateList();
        }
    }

    public final int getPressedCheckIconColor() {
        return this.chipDrawable.getStyle().getPressedCheckIconColor();
    }

    public final void setPressedCheckIconColor(int i) {
        if (this.chipDrawable.getStyle().getPressedCheckIconColor() != i) {
            this.chipDrawable.getStyle().setPressedCheckIconColor(i);
            this.chipDrawable.updateCheckIconColorStateList();
        }
    }

    public final int getEnabledCloseIconColor() {
        return this.chipDrawable.getStyle().getEnabledCloseIconColor();
    }

    public final void setEnabledCloseIconColor(int i) {
        if (this.chipDrawable.getStyle().getEnabledCloseIconColor() != i) {
            this.chipDrawable.getStyle().setEnabledCloseIconColor(i);
            this.chipDrawable.updateCloseIconColorStateList();
        }
    }

    public final int getDisabledCloseIconColor() {
        return this.chipDrawable.getStyle().getDisabledCloseIconColor();
    }

    public final void setDisabledCloseIconColor(int i) {
        if (this.chipDrawable.getStyle().getDisabledCloseIconColor() != i) {
            this.chipDrawable.getStyle().setDisabledCloseIconColor(i);
            this.chipDrawable.updateCloseIconColorStateList();
        }
    }

    public final int getPressedCloseIconColor() {
        return this.chipDrawable.getStyle().getPressedCloseIconColor();
    }

    public final void setPressedCloseIconColor(int i) {
        if (this.chipDrawable.getStyle().getPressedCloseIconColor() != i) {
            this.chipDrawable.getStyle().setPressedCloseIconColor(i);
            this.chipDrawable.updateCloseIconColorStateList();
        }
    }

    public final int getSelectedCloseIconColor() {
        return this.chipDrawable.getStyle().getSelectedCloseIconColor();
    }

    public final void setSelectedCloseIconColor(int i) {
        if (this.chipDrawable.getStyle().getSelectedCloseIconColor() != i) {
            this.chipDrawable.getStyle().setSelectedCloseIconColor(i);
            this.chipDrawable.updateCloseIconColorStateList();
        }
    }

    public final int getSelectedDisabledCloseIconColor() {
        return this.chipDrawable.getStyle().getSelectedDisabledCloseIconColor();
    }

    public final void setSelectedDisabledCloseIconColor(int i) {
        if (this.chipDrawable.getStyle().getSelectedDisabledCloseIconColor() != i) {
            this.chipDrawable.getStyle().setSelectedDisabledCloseIconColor(i);
            this.chipDrawable.updateCloseIconColorStateList();
        }
    }

    public final int getEnabledIconColor() {
        return this.chipDrawable.getStyle().getEnabledIconColor();
    }

    public final void setEnabledIconColor(int i) {
        if (this.chipDrawable.getStyle().getEnabledIconColor() != i) {
            this.chipDrawable.getStyle().setEnabledIconColor(i);
            this.chipDrawable.updateIconColorStateList();
        }
    }

    public final int getDisabledIconColor() {
        return this.chipDrawable.getStyle().getDisabledIconColor();
    }

    public final void setDisabledIconColor(int i) {
        if (this.chipDrawable.getStyle().getDisabledIconColor() != i) {
            this.chipDrawable.getStyle().setDisabledIconColor(i);
            this.chipDrawable.updateIconColorStateList();
        }
    }

    public final int getPressedIconColor() {
        return this.chipDrawable.getStyle().getPressedIconColor();
    }

    public final void setPressedIconColor(int i) {
        if (this.chipDrawable.getStyle().getPressedIconColor() != i) {
            this.chipDrawable.getStyle().setPressedIconColor(i);
            this.chipDrawable.updateIconColorStateList();
        }
    }

    public final int getSelectedIconColor() {
        return this.chipDrawable.getStyle().getSelectedIconColor();
    }

    public final void setSelectedIconColor(int i) {
        if (this.chipDrawable.getStyle().getSelectedIconColor() != i) {
            this.chipDrawable.getStyle().setSelectedIconColor(i);
            this.chipDrawable.updateIconColorStateList();
        }
    }

    public final int getSelectedDisabledIconColor() {
        return this.chipDrawable.getStyle().getSelectedDisabledIconColor();
    }

    public final void setSelectedDisabledIconColor(int i) {
        if (this.chipDrawable.getStyle().getSelectedDisabledIconColor() != i) {
            this.chipDrawable.getStyle().setSelectedDisabledIconColor(i);
            this.chipDrawable.updateIconColorStateList();
        }
    }

    public final CharSequence getText() {
        AppCompatTextView appCompatTextView = this.textView;
        if (appCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            appCompatTextView = null;
        }
        return appCompatTextView.getText();
    }

    public final void setText(CharSequence charSequence) {
        AppCompatTextView appCompatTextView = this.textView;
        if (appCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            appCompatTextView = null;
        }
        appCompatTextView.setText(charSequence, TextView.BufferType.NORMAL);
    }

    public final float getTextSize() {
        AppCompatTextView appCompatTextView = this.textView;
        if (appCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            appCompatTextView = null;
        }
        return appCompatTextView.getTextSize();
    }

    public final void setTextSize(float f) {
        setTextSize(2, f);
    }

    public final Typeface getTypeface() {
        AppCompatTextView appCompatTextView = this.textView;
        if (appCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            appCompatTextView = null;
        }
        return appCompatTextView.getTypeface();
    }

    public final void setTypeface(Typeface typeface) {
        AppCompatTextView appCompatTextView = this.textView;
        if (appCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            appCompatTextView = null;
        }
        appCompatTextView.setTypeface(typeface);
    }

    public final boolean getUseRippleEffect() {
        return this.chipDrawable.getStyle().getUseRippleEffect();
    }

    public final void setUseRippleEffect(boolean z) {
        if (this.chipDrawable.getStyle().getUseRippleEffect() != z) {
            this.chipDrawable.getStyle().setUseRippleEffect(z);
            updateBackground();
            this.chipDrawable.invalidateSelf();
        }
    }

    @Override // android.view.View
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, bottom);
        this.chipDrawable.getStyle().setPadding(new Thickness(left, top, right, bottom));
    }

    public final void setTextSize(int unit, float value) {
        AppCompatTextView appCompatTextView = this.textView;
        if (appCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            appCompatTextView = null;
        }
        appCompatTextView.setTextSize(unit, value);
    }

    public final float getIconIndent() {
        return this.chipDrawable.getStyle().getIconIndent();
    }

    public final void setIconIndent(float f) {
        if (this.chipDrawable.getStyle().getIconIndent() == f) {
            return;
        }
        this.chipDrawable.getStyle().setIconIndent(f);
        updateChip();
    }

    public final float getCloseIconIndent() {
        return this.chipDrawable.getStyle().getCloseIconIndent();
    }

    public final void setCloseIconIndent(float f) {
        if (this.chipDrawable.getStyle().getCloseIconIndent() == f) {
            return;
        }
        this.chipDrawable.getStyle().setCloseIconIndent(f);
        updateChip();
    }

    public final Drawable getChipIcon() {
        return this.chipIcon;
    }

    public final void setChipIcon(Drawable drawable) {
        if (Intrinsics.areEqual(this.chipIcon, drawable)) {
            return;
        }
        this.chipIcon = drawable;
        this.chipDrawable.setChipIconDrawable$dxeditors_release(drawable);
        updateChip();
    }

    public final Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    public final void setCheckedIcon(Drawable drawable) {
        if (Intrinsics.areEqual(this.checkedIcon, drawable)) {
            return;
        }
        this.checkedIcon = drawable;
        this.chipDrawable.setCheckIconDrawable$dxeditors_release(drawable);
        updateChip();
    }

    public final Drawable getCloseIcon() {
        return this.closeIcon;
    }

    public final void setCloseIcon(Drawable drawable) {
        if (Intrinsics.areEqual(this.closeIcon, drawable)) {
            return;
        }
        this.closeIcon = drawable;
        this.chipDrawable.setCloseIconDrawable$dxeditors_release(drawable);
        updateChip();
    }

    public final boolean isChipIconVisible() {
        return this.chipDrawable.isChipIconVisible$dxeditors_release();
    }

    public final void setChipIconVisible(boolean z) {
        if (this.chipDrawable.isChipIconVisible$dxeditors_release() != z) {
            boolean isChipIconVisible$dxeditors_release = this.chipDrawable.isChipIconVisible$dxeditors_release();
            this.chipDrawable.setChipIconVisible$dxeditors_release(z);
            if (isChipIconVisible$dxeditors_release != this.chipDrawable.isChipIconVisible$dxeditors_release()) {
                updateChip();
            }
        }
    }

    public final boolean isCloseIconVisible() {
        return this.chipDrawable.getIsCloseIconVisible();
    }

    public final void setCloseIconVisible(boolean z) {
        if (this.chipDrawable.getIsCloseIconVisible() != z) {
            this.chipDrawable.setCloseIconVisible$dxeditors_release(z);
            updateChip();
        }
    }

    public final boolean isCheckedIconVisible() {
        return this.chipDrawable.getIsCheckIconVisible();
    }

    public final void setCheckedIconVisible(boolean z) {
        if (this.chipDrawable.getIsCheckIconVisible() != z) {
            this.chipDrawable.setCheckIconVisible$dxeditors_release(z);
            updateChip();
        }
    }

    public final int getVerticalContentAlignment() {
        return this.verticalContentAlignment;
    }

    public final void setVerticalContentAlignment(int i) {
        this.verticalContentAlignment = i;
    }

    public final int getHorizontalContentAlignment() {
        return this.horizontalContentAlignment;
    }

    public final void setHorizontalContentAlignment(int i) {
        this.horizontalContentAlignment = i;
    }

    public final boolean getRoundedIcon() {
        return this.chipDrawable.getRoundedIcon();
    }

    public final void setRoundedIcon(boolean z) {
        if (this.chipDrawable.getRoundedIcon() != z) {
            this.chipDrawable.setRoundedIcon$dxeditors_release(z);
            updateChip();
        }
    }

    /* renamed from: isChecked, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean z) {
        if (this.isChecked != z) {
            this.isChecked = z;
            refreshDrawableState();
            requestLayout();
        }
    }

    public final View getContentView() {
        return this.contentView;
    }

    public final void setContentView(View view) {
        if (Intrinsics.areEqual(this.contentView, view)) {
            return;
        }
        this.contentView = view;
        onContentViewChanged();
    }

    public final void updateIconSize(int width, int height) {
        this.userIconSize = new Size(width, height);
        updateChip();
    }

    public final void setCornerRadii(float topLeft, float topRight, float bottomLeft, float bottomRight) {
        this.chipDrawable.getStyle().setCornerRadii(new BorderRounds(topLeft, topRight, bottomLeft, bottomRight));
        this.chipDrawable.invalidateSelf();
    }

    private final void onRippleColorChanged() {
        if (this.chipDrawable.getStyle().getUseRippleEffect()) {
            Drawable drawable = this.chipBackgroundDrawable;
            if (drawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipBackgroundDrawable");
                drawable = null;
            }
            ColorStateList rippleColor$dxeditors_release = this.chipDrawable.getStyle().getRippleColor$dxeditors_release();
            Intrinsics.checkNotNull(rippleColor$dxeditors_release);
            ((RippleDrawable) drawable).setColor(rippleColor$dxeditors_release);
        }
        this.chipDrawable.updateCloseIconRippleColor$dxeditors_release();
    }

    private final void updateChip() {
        requestLayout();
        this.chipDrawable.invalidateSelf();
    }

    @Override // com.devexpress.editors.ChipDrawableDelegate
    public void onChipTextColorChange(int color) {
        AppCompatTextView appCompatTextView = this.textView;
        AppCompatTextView appCompatTextView2 = null;
        if (appCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            appCompatTextView = null;
        }
        if (appCompatTextView.getCurrentTextColor() != color) {
            AppCompatTextView appCompatTextView3 = this.textView;
            if (appCompatTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
            } else {
                appCompatTextView2 = appCompatTextView3;
            }
            appCompatTextView2.setTextColor(color);
        }
    }

    private final void setCloseIconPressed(boolean pressed) {
        if (this.closeIconPressed != pressed) {
            this.closeIconPressed = pressed;
            refreshDrawableState();
        }
    }

    private final boolean onCloseIconTap() {
        ChipAction chipAction = this.chipAction;
        if (chipAction == null) {
            return false;
        }
        return chipAction.onCloseIconTap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onSingleTapUp() {
        ChipAction chipAction = this.chipAction;
        if (chipAction == null) {
            return false;
        }
        return chipAction.onSingleTapUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onSingleTapConfirmed() {
        ChipAction chipAction = this.chipAction;
        if (chipAction == null) {
            return false;
        }
        return chipAction.onSingleTapConfirmed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onDoubleTap() {
        ChipAction chipAction = this.chipAction;
        if (chipAction == null) {
            return false;
        }
        return chipAction.onDoubleTap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onLongPress() {
        ChipAction chipAction = this.chipAction;
        if (chipAction == null) {
            return false;
        }
        return chipAction.onLongPress();
    }

    private final boolean isPointInCloseIcon(float x, float y) {
        if (!isCloseIconVisible()) {
            return false;
        }
        float width = ((getWidth() - getPaddingEnd()) - (this.chipDrawable.getCloseIconSize().getWidth() / 2.0f)) - x;
        float height = (getHeight() / 2.0f) - y;
        Size closeIconSize = this.chipDrawable.getCloseIconSize();
        return (width * width) + (height * height) < ((float) (((closeIconSize.getWidth() * closeIconSize.getWidth()) + (closeIconSize.getHeight() * closeIconSize.getHeight())) / 4));
    }

    private final void updateRippleHotSpot(MotionEvent event) {
        if (this.chipDrawable.getStyle().getUseRippleEffect()) {
            Drawable drawable = this.chipBackgroundDrawable;
            Drawable drawable2 = null;
            if (drawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipBackgroundDrawable");
                drawable = null;
            }
            if (drawable instanceof RippleDrawable) {
                Drawable drawable3 = this.chipBackgroundDrawable;
                if (drawable3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipBackgroundDrawable");
                } else {
                    drawable2 = drawable3;
                }
                drawable2.setHotspot(event.getX(), event.getY());
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        boolean z;
        Intrinsics.checkNotNull(event);
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            updateRippleHotSpot(event);
        }
        boolean isPointInCloseIcon = isPointInCloseIcon(event.getX(), event.getY());
        boolean z2 = this.closeIconPressed;
        if (!z2 && !isPointInCloseIcon) {
            super.onTouchEvent(event);
            return this.mDetector.onTouchEvent(event);
        }
        if (actionMasked == 0) {
            if (isPointInCloseIcon) {
                setCloseIconPressed(true);
                z = true;
            }
            z = false;
        } else if (actionMasked != 1) {
            if (actionMasked != 2) {
                if (actionMasked == 3) {
                    setCloseIconPressed(false);
                }
            } else if (z2) {
                if (!isPointInCloseIcon) {
                    setCloseIconPressed(false);
                }
                z = true;
            }
            z = false;
        } else {
            if (z2) {
                onCloseIconTap();
                z = true;
            } else {
                z = false;
            }
            setCloseIconPressed(false);
        }
        return z || super.onTouchEvent(event);
    }

    /* compiled from: Chip.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"Lcom/devexpress/editors/Chip$ChipGestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "(Lcom/devexpress/editors/Chip;)V", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onDown", NotificationCompat.CATEGORY_EVENT, "onLongPress", "", "onSingleTapConfirmed", "onSingleTapUp", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ChipGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return false;
        }

        public ChipGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            return Chip.this.onSingleTapUp();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            return Chip.this.onSingleTapConfirmed();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            Chip.this.onLongPress();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            return Chip.this.onDoubleTap();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int extraSpace) {
        int[] onCreateDrawableState = super.onCreateDrawableState(extraSpace + 1);
        if (this.isChecked) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, Constants.CHECKED_STATE);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.chipBackgroundDrawable;
        if (drawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chipBackgroundDrawable");
            drawable = null;
        }
        drawable.setState(createDrawableState());
        this.chipDrawable.setCloseIconState(createCloseIconDrawableState());
        invalidate();
    }

    private final void onContentViewChanged() {
        removeAllViewsInLayout();
        addView(getActualContentView(), new FrameLayout.LayoutParams(-2, -2, this.contentView != null ? 119 : 17));
        requestLayout();
        invalidate();
    }

    private final Size getIconSize() {
        if (this.userIconSize.getWidth() < 0 || this.userIconSize.getHeight() < 0) {
            return this.chipDrawable.getChipIconSize();
        }
        return this.userIconSize;
    }

    private final int getIconWidth() {
        if (isChipIconVisible()) {
            return getIconSize().getWidth();
        }
        return 0;
    }

    private final int getIconHeight() {
        if (isChipIconVisible()) {
            return getIconSize().getHeight();
        }
        return 0;
    }

    private final int getCheckIconWidth() {
        if (isCheckedIconVisible() && this.isChecked) {
            return this.chipDrawable.getCheckIconSize().getWidth();
        }
        return 0;
    }

    private final int getCheckIconHeight() {
        if (isCheckedIconVisible()) {
            return this.chipDrawable.getCheckIconSize().getHeight();
        }
        return 0;
    }

    private final int getCloseIconWidth() {
        if (isCloseIconVisible()) {
            return this.chipDrawable.getCloseIconSize().getWidth();
        }
        return 0;
    }

    private final int getCloseIconHeight() {
        if (isCloseIconVisible()) {
            return this.chipDrawable.getCloseIconSize().getHeight();
        }
        return 0;
    }

    private final int getIconsWidth() {
        return Math.max(getIconWidth(), getCheckIconWidth());
    }

    private final int getIconsHeight() {
        return Math.max(Math.max(getIconHeight(), getCheckIconHeight()), getCloseIconHeight());
    }

    private final View getActualContentView() {
        View view = this.contentView;
        if (view != null) {
            return view;
        }
        AppCompatTextView appCompatTextView = this.textView;
        if (appCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            appCompatTextView = null;
        }
        return appCompatTextView;
    }

    private final int getLeftIndent() {
        if (getIconsWidth() <= 0 || getActualContentView().getMeasuredWidth() <= 0) {
            return 0;
        }
        return (int) getIconIndent();
    }

    private final int getRightIndent() {
        if (getCloseIconWidth() <= 0 || getActualContentView().getMeasuredWidth() <= 0) {
            return 0;
        }
        return (int) getCloseIconIndent();
    }

    private final int getExtraSpaceForIcons() {
        return Math.max(getIconSize().getWidth(), this.chipDrawable.getCheckIconSize().getWidth()) + ((int) getIconIndent()) + ((int) getIconIndent()) + this.chipDrawable.getCloseIconSize().getWidth();
    }

    @Override // com.devexpress.dxcore.DXNativeView
    protected Size onMeasureCore(int widthMeasureSpec, int heightMeasureSpec) {
        View childAt = getChildAt(0);
        childAt.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int paddingLeft = getPaddingLeft() + getIconsWidth() + getLeftIndent();
        int paddingRight = getPaddingRight() + getCloseIconWidth() + getRightIndent();
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        childAt.measure(ViewGroup.getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, layoutParams.width), ViewGroup.getChildMeasureSpec(heightMeasureSpec, getPaddingTop() + getPaddingBottom(), layoutParams.height));
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int measuredWidth = paddingLeft + childAt.getMeasuredWidth() + paddingRight;
        int paddingTop = getPaddingTop() + Math.max(childAt.getMeasuredHeight(), getIconsHeight()) + getPaddingBottom();
        if (mode != 0) {
            if (mode == 1073741824) {
                measuredWidth = View.MeasureSpec.getSize(widthMeasureSpec);
            } else {
                measuredWidth = Math.min(measuredWidth, View.MeasureSpec.getSize(widthMeasureSpec));
            }
        }
        if (mode2 != 0) {
            if (mode2 == 1073741824) {
                paddingTop = View.MeasureSpec.getSize(heightMeasureSpec);
            } else {
                paddingTop = Math.min(paddingTop, View.MeasureSpec.getSize(heightMeasureSpec));
            }
        }
        return new Size(measuredWidth, paddingTop);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.chipAnimator.isRunning()) {
            this.chipAnimator.end();
        }
        int i = right - left;
        int i2 = bottom - top;
        Drawable drawable = this.chipBackgroundDrawable;
        Drawable drawable2 = null;
        if (drawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chipBackgroundDrawable");
            drawable = null;
        }
        drawable.setBounds(0, 0, getExtraSpaceForIcons() + i, i2);
        CustomChipDrawable customChipDrawable = this.chipDrawable;
        Drawable drawable3 = this.chipBackgroundDrawable;
        if (drawable3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chipBackgroundDrawable");
        } else {
            drawable2 = drawable3;
        }
        customChipDrawable.setBounds(drawable2.getBounds());
        View childAt = getChildAt(0);
        int paddingLeft = getPaddingLeft() + getIconsWidth() + getLeftIndent();
        int paddingTop = getPaddingTop();
        int paddingRight = ((i - getPaddingRight()) - getCloseIconWidth()) - getRightIndent();
        int paddingBottom = (paddingTop + (i2 - getPaddingBottom())) / 2;
        int measuredWidth = ((paddingLeft + paddingRight) / 2) - (childAt.getMeasuredWidth() / 2);
        int measuredHeight = paddingBottom - (childAt.getMeasuredHeight() / 2);
        float paddingLeft2 = getPaddingLeft() + (getIconsWidth() / 2.0f);
        float f = i2 / 2.0f;
        if (childAt.getWidth() > 0 && childAt.getHeight() > 0) {
            this.chipAnimator.getContentViewTranslationDelta().set(measuredWidth - childAt.getLeft(), measuredHeight - childAt.getTop());
            this.chipAnimator.setCheckIconAlphaFrom(this.chipDrawable.getCheckIconAlpha());
            this.chipAnimator.setCheckIconAlphaTo(this.isChecked ? 1.0f : 0.0f);
            this.chipAnimator.setRightBoundFrom(this.chipDrawable.getRightBound());
            this.chipAnimator.setRightBoundTo(i);
            this.chipAnimator.setChipIconTranslationDelta(this.chipDrawable.getChipIconBounds().isEmpty() ? 0.0f : paddingLeft2 - this.chipDrawable.getChipIconBounds().exactCenterX());
            this.chipAnimator.start();
        } else {
            this.chipDrawable.setCheckIconAlpha$dxeditors_release(this.isChecked ? 1.0f : 0.0f);
            this.chipDrawable.setRightBound$dxeditors_release(i);
        }
        if (isChipIconVisible()) {
            this.chipDrawable.setChipIconBounds$dxeditors_release((int) ((paddingLeft2 - (getIconWidth() / 2.0f)) + 0.5f), (int) ((f - (getIconHeight() / 2.0f)) + 0.5f), (int) ((getIconWidth() / 2.0f) + paddingLeft2 + 0.5f), (int) ((getIconHeight() / 2.0f) + f + 0.5f));
        }
        if (isCheckedIconVisible() && this.isChecked) {
            this.chipDrawable.setCheckIconBounds$dxeditors_release((int) ((paddingLeft2 - (getCheckIconWidth() / 2.0f)) + 0.5f), (int) ((f - (getCheckIconHeight() / 2.0f)) + 0.5f), (int) (paddingLeft2 + (getCheckIconWidth() / 2.0f) + 0.5f), (int) (f + (getCheckIconHeight() / 2.0f) + 0.5f));
        }
        childAt.layout(measuredWidth, measuredHeight, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + measuredHeight);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        ChipAction chipAction = this.chipAction;
        if (chipAction != null) {
            chipAction.onLayoutChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void chipAnimator$lambda$3$lambda$2(Chip this$0, Chip$chipAnimator$1 this_apply, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        float f = 1.0f - floatValue;
        this$0.getChildAt(0).setTranslationX((-f) * this_apply.getContentViewTranslationDelta().x);
        this$0.chipDrawable.setCheckIconAlpha$dxeditors_release(this_apply.getCheckIconAlphaFrom() + ((this_apply.getCheckIconAlphaTo() - this_apply.getCheckIconAlphaFrom()) * floatValue));
        this$0.chipDrawable.setRightBound$dxeditors_release(this_apply.getRightBoundFrom() + ((int) (floatValue * (this_apply.getRightBoundTo() - this_apply.getRightBoundFrom()))));
        this$0.chipDrawable.setChipIconTranslation$dxeditors_release(f * this_apply.getChipIconTranslationDelta());
        this$0.chipDrawable.invalidateSelf();
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable who) {
        Intrinsics.checkNotNullParameter(who, "who");
        invalidate();
    }
}
