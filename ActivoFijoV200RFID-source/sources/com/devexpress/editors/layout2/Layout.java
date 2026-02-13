package com.devexpress.editors.layout2;

import android.graphics.Rect;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Size;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.editors.DXVerticalAlignment;
import com.devexpress.editors.EditBase;
import com.devexpress.editors.TextEditBase;
import com.devexpress.editors.dropdown.utils.Rectangle;
import com.devexpress.editors.layout.Element;
import com.devexpress.editors.layout.ViewHolder;
import com.devexpress.editors.utils.UtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Layout.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b \b&\u0018\u0000 \u0093\u00012\u00020\u0001:\u0002\u0093\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010b\u001a\u00020cH\u0002J\b\u0010d\u001a\u00020cH\u0002J\b\u0010e\u001a\u00020cH\u0002J\b\u0010f\u001a\u00020cH\u0002J\u0010\u0010g\u001a\u00020c2\u0006\u0010h\u001a\u000203H\u0002J\b\u0010i\u001a\u00020cH$J\b\u0010j\u001a\u00020cH\u0002J\b\u0010k\u001a\u00020cH\u0002J\b\u0010l\u001a\u00020cH\u0002J\b\u0010m\u001a\u00020cH\u0002J\b\u0010n\u001a\u00020cH$J\b\u0010o\u001a\u00020cH\u0002J\b\u0010p\u001a\u00020cH$J\u0016\u0010q\u001a\u00020#2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020t0sH\u0002J\b\u0010u\u001a\u00020cH\u0002J\b\u0010v\u001a\u00020cH\u0014J\b\u0010w\u001a\u00020cH\u0002J\b\u0010x\u001a\u00020cH$J\b\u0010y\u001a\u00020cH\u0014J\b\u0010z\u001a\u00020cH\u0014J\b\u0010{\u001a\u00020cH$J\b\u0010|\u001a\u00020cH\u0002J\b\u0010}\u001a\u00020cH\u0014J\b\u0010~\u001a\u00020cH\u0002J#\u0010\u007f\u001a\u0002032\u0007\u0010\u0080\u0001\u001a\u0002032\u0007\u0010\u0081\u0001\u001a\u0002032\u0007\u0010\u0082\u0001\u001a\u000203H\u0004J\t\u0010\u0083\u0001\u001a\u000203H$J$\u0010\u0084\u0001\u001a\u0002032\u0007\u0010\u0085\u0001\u001a\u0002032\u0007\u0010\u0086\u0001\u001a\u0002032\u0007\u0010\u0087\u0001\u001a\u000203H\u0002J$\u0010\u0088\u0001\u001a\u0002032\u0007\u0010\u0089\u0001\u001a\u0002032\u0007\u0010\u0086\u0001\u001a\u0002032\u0007\u0010\u0087\u0001\u001a\u000203H\u0004J\u0019\u0010\u008a\u0001\u001a\u00020c2\u0007\u0010\u008b\u0001\u001a\u0002032\u0007\u0010\u008c\u0001\u001a\u000203J\u001b\u0010\u008d\u0001\u001a\u00020c2\u0007\u0010\u008b\u0001\u001a\u0002032\u0007\u0010\u008c\u0001\u001a\u000203H\u0002J\t\u0010\u008e\u0001\u001a\u000203H&J\u0007\u0010\u008f\u0001\u001a\u00020cJ\u0012\u0010\u0090\u0001\u001a\u00020!2\u0007\u0010\u0091\u0001\u001a\u000203H\u0002J\t\u0010\u0092\u0001\u001a\u00020cH\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u0014\u0010\u001a\u001a\u00020\u001bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000e\"\u0004\b*\u0010\u0010R\u001a\u0010+\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u000e\"\u0004\b-\u0010\u0010R\u001a\u0010.\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010%\"\u0004\b0\u0010'R\u000e\u00101\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000203X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u000203X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\u001a\u0010;\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000e\"\u0004\b=\u0010\u0010R\u001a\u0010>\u001a\u000203X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00105\"\u0004\b@\u00107R\u001a\u0010A\u001a\u00020#X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010%\"\u0004\bC\u0010'R\u001a\u0010D\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u000e\"\u0004\bF\u0010\u0010R\u001a\u0010G\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u000e\"\u0004\bI\u0010\u0010R\u001a\u0010J\u001a\u000203X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u00105\"\u0004\bL\u00107R\u000e\u0010M\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010P\u001a\u000203X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u00105R\u001a\u0010R\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u000e\"\u0004\bT\u0010\u0010R\u001a\u0010U\u001a\u000203X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00105\"\u0004\bW\u00107R\u0014\u0010X\u001a\u00020YX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u001a\u0010\\\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u000e\"\u0004\b^\u0010\u0010R\u001a\u0010_\u001a\u000203X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u00105\"\u0004\ba\u00107¨\u0006\u0094\u0001"}, d2 = {"Lcom/devexpress/editors/layout2/Layout;", "", "edit", "Lcom/devexpress/editors/EditBase;", "(Lcom/devexpress/editors/EditBase;)V", "actualBoxPaddings", "Landroid/graphics/Rect;", "getActualBoxPaddings", "()Landroid/graphics/Rect;", "setActualBoxPaddings", "(Landroid/graphics/Rect;)V", "bottomTextAreaFrame", "Lcom/devexpress/editors/dropdown/utils/Rectangle;", "getBottomTextAreaFrame", "()Lcom/devexpress/editors/dropdown/utils/Rectangle;", "setBottomTextAreaFrame", "(Lcom/devexpress/editors/dropdown/utils/Rectangle;)V", "boxFrame", "getBoxFrame", "setBoxFrame", "charCounterAreaFrame", "getCharCounterAreaFrame", "setCharCounterAreaFrame", "contentFrame", "getContentFrame", "setContentFrame", "density", "", "getDensity", "()F", "getEdit", "()Lcom/devexpress/editors/EditBase;", "forceCalculate", "", "fullBounds", "Landroid/util/Size;", "getFullBounds", "()Landroid/util/Size;", "setFullBounds", "(Landroid/util/Size;)V", "internalEditorFrame", "getInternalEditorFrame", "setInternalEditorFrame", "labelFrame", "getLabelFrame", "setLabelFrame", "labelTextSize", "getLabelTextSize", "setLabelTextSize", "lastCalculationSize", "layoutHeightMode", "", "getLayoutHeightMode", "()I", "setLayoutHeightMode", "(I)V", "layoutWidthMode", "getLayoutWidthMode", "setLayoutWidthMode", "leadingIconFrame", "getLeadingIconFrame", "setLeadingIconFrame", "leadingIconOffset", "getLeadingIconOffset", "setLeadingIconOffset", "maxSize", "getMaxSize", "setMaxSize", "placeholderFrame", "getPlaceholderFrame", "setPlaceholderFrame", "prefixFrame", "getPrefixFrame", "setPrefixFrame", "prefixOffset", "getPrefixOffset", "setPrefixOffset", "specBoxWidth", "specHeight", "specHorzPadding", "specMinTextFieldHeight", "getSpecMinTextFieldHeight", "suffixFrame", "getSuffixFrame", "setSuffixFrame", "suffixOffset", "getSuffixOffset", "setSuffixOffset", "textPaint", "Landroid/text/TextPaint;", "getTextPaint", "()Landroid/text/TextPaint;", "trailingIconFrame", "getTrailingIconFrame", "setTrailingIconFrame", "trailingIconOffset", "getTrailingIconOffset", "setTrailingIconOffset", "calcAffixFrames", "", "calcAffixOffsets", "calcAffixSize", "calcBottomTextAreaFrame", "calcBottomTextAreaSizeForWidth", "maxWidth", "calcBoxFrame", "calcBoxWidthDesired", "calcBoxWidthExact", "calcCharCounterAreaFrame", "calcCharCounterAreaSize", "calcContentFrame", "calcContentFrameWidth", "calcFullBounds", "calcIconContainerSize", "icons", "", "Lcom/devexpress/editors/layout/Element;", "calcIconContainersFrames", "calcIconContainersSize", "calcIconOffsets", "calcInternalEditorFrame", "calcInternalEditorSizeDesired", "calcInternalEditorSizeExact", "calcLabelFrame", "calcLabelTextSize", "calcPlaceholderFrame", "calcPlaceholderTextSize", "calcTargetBoxHeightAndPaddings", "contentHeight", "contentTopOffset", "specVerticalPadding", "calcTopPadding", "calcTopPositionForVerticalAlignment", "alignment", "elementHeight", TypedValues.CycleType.S_WAVE_OFFSET, "calcTopPositionForVerticalGravity", "gravity", "calculate", "widthMeasureSpec", "heightMeasureSpec", "calculateFor", "getLabelOffset", "invalidate", "needsCorrectionOfTextFiledHeight", "height", "resetMeasure", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class Layout {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final float SPEC_BOX_WIDTH_DIP = 280.0f;
    public static final float SPEC_FILLED_VERT_PADDING_DP = 8.0f;
    public static final float SPEC_HEIGHT_DIP = 56.0f;
    public static final float SPEC_HORZ_PADDING_DIP = 12.0f;
    public static final float SPEC_MIN_TEXT_FIELD_HEIGHT_DP = 24.0f;
    public static final float SPEC_OUTLINED_VERT_PADDING_DP = 16.0f;
    private Rect actualBoxPaddings;
    private Rectangle bottomTextAreaFrame;
    private Rectangle boxFrame;
    private Rectangle charCounterAreaFrame;
    private Rectangle contentFrame;
    private final float density;
    private final EditBase edit;
    private boolean forceCalculate;
    private Size fullBounds;
    private Rectangle internalEditorFrame;
    private Rectangle labelFrame;
    private Size labelTextSize;
    private Size lastCalculationSize;
    private int layoutHeightMode;
    private int layoutWidthMode;
    private Rectangle leadingIconFrame;
    private int leadingIconOffset;
    private Size maxSize;
    private Rectangle placeholderFrame;
    private Rectangle prefixFrame;
    private int prefixOffset;
    private final int specBoxWidth;
    private final int specHeight;
    private final int specHorzPadding;
    private final int specMinTextFieldHeight;
    private Rectangle suffixFrame;
    private int suffixOffset;
    private final TextPaint textPaint;
    private Rectangle trailingIconFrame;
    private int trailingIconOffset;

    protected abstract void calcBoxFrame();

    protected abstract void calcContentFrame();

    protected abstract void calcFullBounds();

    protected abstract void calcInternalEditorFrame();

    protected abstract void calcLabelFrame();

    protected abstract int calcTopPadding();

    /* renamed from: getLabelOffset */
    public abstract int getSpecZeroLengthLabelOffset();

    /* compiled from: Layout.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00122\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/devexpress/editors/layout2/Layout$Companion;", "", "()V", "SPEC_BOX_WIDTH_DIP", "", "SPEC_FILLED_VERT_PADDING_DP", "SPEC_HEIGHT_DIP", "SPEC_HORZ_PADDING_DIP", "SPEC_MIN_TEXT_FIELD_HEIGHT_DP", "SPEC_OUTLINED_VERT_PADDING_DP", "calcTextSize", "Lcom/devexpress/editors/layout2/TextSizeInfo;", "textPaint", "Landroid/text/TextPaint;", "text", "", "fitWidth", "", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TextSizeInfo calcTextSize(TextPaint textPaint) {
            Intrinsics.checkNotNullParameter(textPaint, "textPaint");
            return calcTextSize$default(this, textPaint, "", 0, 4, (Object) null);
        }

        public static /* synthetic */ TextSizeInfo calcTextSize$default(Companion companion, TextPaint textPaint, CharSequence charSequence, int i, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                i = -1;
            }
            return companion.calcTextSize(textPaint, charSequence, i);
        }

        public final TextSizeInfo calcTextSize(TextPaint textPaint, CharSequence text, int fitWidth) {
            String str;
            Intrinsics.checkNotNullParameter(textPaint, "textPaint");
            if (text == null || (str = text.toString()) == null) {
                str = "";
            }
            return calcTextSize(textPaint, str, fitWidth);
        }

        public static /* synthetic */ TextSizeInfo calcTextSize$default(Companion companion, TextPaint textPaint, String str, int i, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                i = -1;
            }
            return companion.calcTextSize(textPaint, str, i);
        }

        public final TextSizeInfo calcTextSize(TextPaint textPaint, String text, int fitWidth) {
            Intrinsics.checkNotNullParameter(textPaint, "textPaint");
            Intrinsics.checkNotNullParameter(text, "text");
            String str = text;
            if (str.length() == 0) {
                int i = -textPaint.getFontMetricsInt().ascent;
                int i2 = textPaint.getFontMetricsInt().descent;
                return new TextSizeInfo(new Size(0, i + i2), (-textPaint.getFontMetricsInt().top) - i, textPaint.getFontMetricsInt().bottom - i2);
            }
            if (fitWidth == -1) {
                fitWidth = Integer.MAX_VALUE;
            }
            StaticLayout build = StaticLayout.Builder.obtain(str, 0, text.length(), textPaint, fitWidth).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            int lineCount = build.getLineCount();
            float f = 0.0f;
            for (int i3 = 0; i3 < lineCount; i3++) {
                f = Math.max(f, build.getLineWidth(i3));
            }
            return new TextSizeInfo(new Size((int) Math.ceil(f), build.getHeight()), 0, 0);
        }
    }

    protected Layout(EditBase edit) {
        Intrinsics.checkNotNullParameter(edit, "edit");
        this.edit = edit;
        this.fullBounds = new Size(0, 0);
        this.boxFrame = new Rectangle();
        this.contentFrame = new Rectangle();
        this.labelTextSize = new Size(0, 0);
        this.labelFrame = new Rectangle();
        this.placeholderFrame = new Rectangle();
        this.charCounterAreaFrame = new Rectangle();
        this.internalEditorFrame = new Rectangle();
        this.bottomTextAreaFrame = new Rectangle();
        this.leadingIconFrame = new Rectangle();
        this.trailingIconFrame = new Rectangle();
        this.prefixFrame = new Rectangle();
        this.suffixFrame = new Rectangle();
        float f = edit.getResources().getDisplayMetrics().density;
        this.density = f;
        this.maxSize = new Size(0, 0);
        this.actualBoxPaddings = new Rect();
        this.textPaint = new TextPaint(1);
        this.specMinTextFieldHeight = (int) ((24.0f * f) + 0.5f);
        this.specHorzPadding = (int) ((12.0f * f) + 0.5f);
        this.specHeight = (int) ((56.0f * f) + 0.5f);
        this.specBoxWidth = (int) ((f * 280.0f) + 0.5f);
        this.forceCalculate = true;
        this.lastCalculationSize = new Size(0, 0);
    }

    public final EditBase getEdit() {
        return this.edit;
    }

    public final Size getFullBounds() {
        return this.fullBounds;
    }

    public final void setFullBounds(Size size) {
        Intrinsics.checkNotNullParameter(size, "<set-?>");
        this.fullBounds = size;
    }

    public final Rectangle getBoxFrame() {
        return this.boxFrame;
    }

    public final void setBoxFrame(Rectangle rectangle) {
        Intrinsics.checkNotNullParameter(rectangle, "<set-?>");
        this.boxFrame = rectangle;
    }

    public final Rectangle getContentFrame() {
        return this.contentFrame;
    }

    public final void setContentFrame(Rectangle rectangle) {
        Intrinsics.checkNotNullParameter(rectangle, "<set-?>");
        this.contentFrame = rectangle;
    }

    public final Size getLabelTextSize() {
        return this.labelTextSize;
    }

    public final void setLabelTextSize(Size size) {
        Intrinsics.checkNotNullParameter(size, "<set-?>");
        this.labelTextSize = size;
    }

    public final Rectangle getLabelFrame() {
        return this.labelFrame;
    }

    public final void setLabelFrame(Rectangle rectangle) {
        Intrinsics.checkNotNullParameter(rectangle, "<set-?>");
        this.labelFrame = rectangle;
    }

    public final Rectangle getPlaceholderFrame() {
        return this.placeholderFrame;
    }

    public final void setPlaceholderFrame(Rectangle rectangle) {
        Intrinsics.checkNotNullParameter(rectangle, "<set-?>");
        this.placeholderFrame = rectangle;
    }

    public final Rectangle getCharCounterAreaFrame() {
        return this.charCounterAreaFrame;
    }

    public final void setCharCounterAreaFrame(Rectangle rectangle) {
        Intrinsics.checkNotNullParameter(rectangle, "<set-?>");
        this.charCounterAreaFrame = rectangle;
    }

    public final Rectangle getInternalEditorFrame() {
        return this.internalEditorFrame;
    }

    public final void setInternalEditorFrame(Rectangle rectangle) {
        Intrinsics.checkNotNullParameter(rectangle, "<set-?>");
        this.internalEditorFrame = rectangle;
    }

    public final Rectangle getBottomTextAreaFrame() {
        return this.bottomTextAreaFrame;
    }

    public final void setBottomTextAreaFrame(Rectangle rectangle) {
        Intrinsics.checkNotNullParameter(rectangle, "<set-?>");
        this.bottomTextAreaFrame = rectangle;
    }

    public final Rectangle getLeadingIconFrame() {
        return this.leadingIconFrame;
    }

    public final void setLeadingIconFrame(Rectangle rectangle) {
        Intrinsics.checkNotNullParameter(rectangle, "<set-?>");
        this.leadingIconFrame = rectangle;
    }

    public final Rectangle getTrailingIconFrame() {
        return this.trailingIconFrame;
    }

    public final void setTrailingIconFrame(Rectangle rectangle) {
        Intrinsics.checkNotNullParameter(rectangle, "<set-?>");
        this.trailingIconFrame = rectangle;
    }

    public final Rectangle getPrefixFrame() {
        return this.prefixFrame;
    }

    public final void setPrefixFrame(Rectangle rectangle) {
        Intrinsics.checkNotNullParameter(rectangle, "<set-?>");
        this.prefixFrame = rectangle;
    }

    public final Rectangle getSuffixFrame() {
        return this.suffixFrame;
    }

    public final void setSuffixFrame(Rectangle rectangle) {
        Intrinsics.checkNotNullParameter(rectangle, "<set-?>");
        this.suffixFrame = rectangle;
    }

    protected final float getDensity() {
        return this.density;
    }

    protected final int getLayoutWidthMode() {
        return this.layoutWidthMode;
    }

    protected final void setLayoutWidthMode(int i) {
        this.layoutWidthMode = i;
    }

    protected final int getLayoutHeightMode() {
        return this.layoutHeightMode;
    }

    protected final void setLayoutHeightMode(int i) {
        this.layoutHeightMode = i;
    }

    protected final Size getMaxSize() {
        return this.maxSize;
    }

    protected final void setMaxSize(Size size) {
        Intrinsics.checkNotNullParameter(size, "<set-?>");
        this.maxSize = size;
    }

    protected final Rect getActualBoxPaddings() {
        return this.actualBoxPaddings;
    }

    protected final void setActualBoxPaddings(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<set-?>");
        this.actualBoxPaddings = rect;
    }

    protected final int getLeadingIconOffset() {
        return this.leadingIconOffset;
    }

    protected final void setLeadingIconOffset(int i) {
        this.leadingIconOffset = i;
    }

    protected final int getTrailingIconOffset() {
        return this.trailingIconOffset;
    }

    protected final void setTrailingIconOffset(int i) {
        this.trailingIconOffset = i;
    }

    protected final int getPrefixOffset() {
        return this.prefixOffset;
    }

    protected final void setPrefixOffset(int i) {
        this.prefixOffset = i;
    }

    protected final int getSuffixOffset() {
        return this.suffixOffset;
    }

    protected final void setSuffixOffset(int i) {
        this.suffixOffset = i;
    }

    protected final TextPaint getTextPaint() {
        return this.textPaint;
    }

    protected final int getSpecMinTextFieldHeight() {
        return this.specMinTextFieldHeight;
    }

    public final void invalidate() {
        this.lastCalculationSize = new Size(0, 0);
        this.forceCalculate = true;
        resetMeasure();
    }

    public final void calculate(int widthMeasureSpec, int heightMeasureSpec) {
        calculateFor(widthMeasureSpec, heightMeasureSpec);
    }

    protected void calcInternalEditorSizeDesired() {
        this.edit.getActualInternalEditorView().forceLayout();
        int width = this.maxSize.getWidth() == Integer.MAX_VALUE ? Integer.MAX_VALUE : (((((this.maxSize.getWidth() - this.actualBoxPaddings.left) - this.actualBoxPaddings.right) - this.leadingIconOffset) - this.trailingIconOffset) - this.prefixOffset) - this.suffixOffset;
        this.edit.getActualInternalEditorView().measure(width == Integer.MAX_VALUE ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(width, this.layoutWidthMode), this.maxSize.getHeight() == Integer.MAX_VALUE ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(this.maxSize.getHeight(), this.layoutHeightMode));
        this.internalEditorFrame.setWidth(Math.max(this.edit.getActualInternalEditorView().getMeasuredWidth(), this.placeholderFrame.getWidth()));
        this.internalEditorFrame.setHeight(this.edit.getActualInternalEditorView().getMeasuredHeight());
        if (this.actualBoxPaddings.top != Integer.MIN_VALUE && this.actualBoxPaddings.bottom != Integer.MIN_VALUE && this.internalEditorFrame.getHeight() + this.actualBoxPaddings.top + this.actualBoxPaddings.bottom > this.maxSize.getHeight()) {
            this.internalEditorFrame.setHeight(Math.max((this.maxSize.getHeight() - this.actualBoxPaddings.top) - this.actualBoxPaddings.bottom, 0));
        }
        if (needsCorrectionOfTextFiledHeight(this.internalEditorFrame.getHeight())) {
            this.internalEditorFrame.setHeight(this.specMinTextFieldHeight);
        }
    }

    protected void calcInternalEditorSizeExact() {
        int width = (((this.contentFrame.getWidth() - this.leadingIconOffset) - this.trailingIconOffset) - this.prefixOffset) - this.suffixOffset;
        this.edit.getActualInternalEditorView().forceLayout();
        this.edit.getActualInternalEditorView().measure(View.MeasureSpec.makeMeasureSpec(width, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(this.maxSize.getHeight(), Integer.MIN_VALUE));
        int measuredHeight = this.edit.getActualInternalEditorView().getMeasuredHeight();
        if (this.actualBoxPaddings.top != Integer.MIN_VALUE && this.actualBoxPaddings.bottom != Integer.MIN_VALUE && this.actualBoxPaddings.top + measuredHeight + this.actualBoxPaddings.bottom > this.maxSize.getHeight()) {
            measuredHeight = Math.max((this.maxSize.getHeight() - this.actualBoxPaddings.top) - this.actualBoxPaddings.bottom, 0);
        }
        if (needsCorrectionOfTextFiledHeight(measuredHeight)) {
            measuredHeight = this.specMinTextFieldHeight;
        }
        this.internalEditorFrame.setSize(new Size(width, measuredHeight));
    }

    protected void calcPlaceholderFrame() {
        if (this.contentFrame.getWidth() == 0 || this.contentFrame.getHeight() == 0) {
            this.placeholderFrame = new Rectangle();
            return;
        }
        int min = Math.min(this.internalEditorFrame.getHeight(), this.placeholderFrame.getHeight());
        CharSequence labelText = this.edit.getLabelText();
        this.placeholderFrame = new Rectangle(this.contentFrame.getLeft() + this.leadingIconOffset, calcTopPositionForVerticalGravity(this.edit.getTextGravity(), min, (labelText == null || labelText.length() == 0) ? 0 : getSpecZeroLengthLabelOffset()), Math.min(this.placeholderFrame.getWidth(), this.internalEditorFrame.getWidth()), min);
    }

    private final boolean needsCorrectionOfTextFiledHeight(int height) {
        if (this.actualBoxPaddings.top == Integer.MIN_VALUE || this.actualBoxPaddings.bottom == Integer.MIN_VALUE) {
            return height < this.specMinTextFieldHeight;
        }
        int i = this.specMinTextFieldHeight;
        return height < i && (i + this.actualBoxPaddings.top) + this.actualBoxPaddings.bottom <= this.maxSize.getHeight();
    }

    protected void calcIconContainersSize() {
        Size calcIconContainerSize = calcIconContainerSize(this.edit.getLeadingIconElements$dxeditors_release());
        Size calcIconContainerSize2 = calcIconContainerSize(this.edit.getTrailingIconElements$dxeditors_release());
        int height = calcIconContainerSize.getHeight();
        int height2 = calcIconContainerSize2.getHeight();
        if (this.layoutHeightMode == 1073741824 && this.actualBoxPaddings.top != Integer.MIN_VALUE && this.actualBoxPaddings.bottom != Integer.MIN_VALUE) {
            if (this.actualBoxPaddings.top + height + this.actualBoxPaddings.bottom > this.maxSize.getHeight()) {
                height = Math.max((this.maxSize.getHeight() - this.actualBoxPaddings.top) - this.actualBoxPaddings.bottom, 0);
            }
            if (this.actualBoxPaddings.top + height2 + this.actualBoxPaddings.bottom > this.maxSize.getHeight()) {
                height2 = Math.max((this.maxSize.getHeight() - this.actualBoxPaddings.top) - this.actualBoxPaddings.bottom, 0);
            }
        }
        int min = Math.min(calcIconContainerSize.getWidth(), this.maxSize.getWidth());
        int min2 = Math.min(height, this.maxSize.getHeight());
        int min3 = Math.min(calcIconContainerSize2.getWidth(), this.maxSize.getWidth());
        int min4 = Math.min(height2, this.maxSize.getHeight());
        this.leadingIconFrame.setSize(new Size(min, min2));
        this.trailingIconFrame.setSize(new Size(min3, min4));
    }

    private final void resetMeasure() {
        this.fullBounds = new Size(0, 0);
        this.boxFrame = new Rectangle();
        this.contentFrame = new Rectangle();
        this.labelTextSize = new Size(0, 0);
        this.labelFrame = new Rectangle();
        this.placeholderFrame = new Rectangle();
        this.charCounterAreaFrame = new Rectangle();
        this.internalEditorFrame = new Rectangle();
        this.bottomTextAreaFrame = new Rectangle();
        this.leadingIconFrame = new Rectangle();
        this.trailingIconFrame = new Rectangle();
    }

    private final void calculateFor(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        Size size3 = new Size(size, size2);
        if (this.forceCalculate || !((Intrinsics.areEqual(this.lastCalculationSize, size3) || Intrinsics.areEqual(this.fullBounds, size3)) && this.layoutWidthMode == mode && this.layoutHeightMode == mode2)) {
            Rect rect = new Rect(this.edit.getBoxPaddingStart(), this.edit.getBoxPaddingTop(), this.edit.getBoxPaddingEnd(), this.edit.getBoxPaddingBottom());
            this.actualBoxPaddings = rect;
            if (rect.left == Integer.MIN_VALUE) {
                this.actualBoxPaddings.left = this.specHorzPadding;
            }
            if (this.actualBoxPaddings.right == Integer.MIN_VALUE) {
                this.actualBoxPaddings.right = this.specHorzPadding;
            }
            this.layoutWidthMode = mode;
            this.layoutHeightMode = mode2;
            if (this.layoutWidthMode == 0 && size == 0) {
                size = Integer.MAX_VALUE;
            }
            if (this.layoutHeightMode == 0 && size2 == 0) {
                size2 = Integer.MAX_VALUE;
            }
            this.maxSize = new Size(size, size2);
            this.lastCalculationSize = size3;
            calcCharCounterAreaSize();
            calcIconContainersSize();
            calcIconOffsets();
            calcAffixSize();
            calcAffixOffsets();
            calcLabelTextSize();
            calcPlaceholderTextSize();
            if (this.layoutWidthMode == 1073741824) {
                calcBoxWidthExact();
                calcContentFrameWidth();
                calcBottomTextAreaSizeForWidth(this.contentFrame.getWidth());
                calcInternalEditorSizeExact();
            } else {
                calcInternalEditorSizeDesired();
                calcBottomTextAreaSizeForWidth(Math.max((this.maxSize.getWidth() - this.actualBoxPaddings.left) - this.actualBoxPaddings.right, this.internalEditorFrame.getWidth()));
                calcBoxWidthDesired();
                calcContentFrameWidth();
            }
            calcBoxFrame();
            calcFullBounds();
            calcContentFrame();
            calcIconContainersFrames();
            calcInternalEditorFrame();
            calcAffixFrames();
            calcPlaceholderFrame();
            calcLabelFrame();
            calcBottomTextAreaFrame();
            calcCharCounterAreaFrame();
            this.forceCalculate = false;
        }
    }

    private final void calcAffixSize() {
        int i;
        int width = this.maxSize.getWidth() == Integer.MAX_VALUE ? Integer.MAX_VALUE : (((this.maxSize.getWidth() - this.actualBoxPaddings.left) - this.actualBoxPaddings.right) - this.leadingIconOffset) - this.trailingIconOffset;
        this.textPaint.setTypeface(this.edit.getAffixTypeface());
        this.textPaint.setTextSize(this.edit.getAffixTextSize());
        Companion companion = INSTANCE;
        Size sizeWithMargins = Companion.calcTextSize$default(companion, this.textPaint, this.edit.getActualPrefix(), 0, 4, (Object) null).sizeWithMargins();
        Size sizeWithMargins2 = Companion.calcTextSize$default(companion, this.textPaint, this.edit.getActualSuffix(), 0, 4, (Object) null).sizeWithMargins();
        int width2 = sizeWithMargins.getWidth();
        int width3 = sizeWithMargins2.getWidth();
        if (width != Integer.MAX_VALUE && (i = width - (width2 + width3)) < 0) {
            int i2 = i / 2;
            width2 = Math.max(width2 + i2, 0);
            width3 = Math.max(width3 + i2, 0);
        }
        this.prefixFrame.setSize(new Size(width2, sizeWithMargins.getHeight()));
        this.suffixFrame.setSize(new Size(width3, sizeWithMargins2.getHeight()));
    }

    private final void calcAffixOffsets() {
        this.prefixOffset = this.prefixFrame.getWidth() == 0 ? 0 : this.prefixFrame.getWidth() + this.edit.getAffixIndent();
        this.suffixOffset = this.suffixFrame.getWidth() != 0 ? this.edit.getAffixIndent() + this.suffixFrame.getWidth() : 0;
    }

    private final void calcAffixFrames() {
        this.prefixFrame.setLeft(this.contentFrame.getLeft() + this.leadingIconOffset);
        this.prefixFrame.setTop(this.internalEditorFrame.getTop());
        this.suffixFrame.setLeft((this.contentFrame.right() - this.trailingIconOffset) - this.suffixFrame.getWidth());
        this.suffixFrame.setTop(this.internalEditorFrame.getTop());
        this.prefixOffset = this.prefixFrame.getWidth() == 0 ? 0 : this.prefixFrame.getWidth() + this.edit.getAffixIndent();
        this.suffixOffset = this.suffixFrame.getWidth() != 0 ? this.edit.getAffixIndent() + this.suffixFrame.getWidth() : 0;
    }

    private final void calcBoxWidthDesired() {
        int max4 = UtilsKt.max4(this.internalEditorFrame.getWidth(), this.bottomTextAreaFrame.getWidth() + this.charCounterAreaFrame.getWidth(), this.placeholderFrame.getWidth(), this.labelTextSize.getWidth());
        int width = this.leadingIconFrame.getWidth() != 0 ? this.leadingIconFrame.getWidth() + this.edit.getIconIndent() : 0;
        if (this.trailingIconFrame.getWidth() != 0) {
            width += this.trailingIconFrame.getWidth() + this.edit.getIconIndent();
        }
        this.boxFrame.setWidth(Math.max(max4 + width + this.actualBoxPaddings.left + this.actualBoxPaddings.right, this.edit.getMinBoxWidth()));
    }

    private final void calcBoxWidthExact() {
        this.boxFrame.setWidth(this.maxSize.getWidth());
        if (this.boxFrame.getWidth() == Integer.MAX_VALUE) {
            this.boxFrame.setWidth(Math.max(this.edit.getMinBoxWidth(), this.specBoxWidth));
        } else if (this.boxFrame.getWidth() < this.edit.getMinBoxWidth()) {
            this.boxFrame.setWidth(this.edit.getMinBoxWidth());
        }
    }

    private final void calcContentFrameWidth() {
        this.contentFrame.setWidth(Math.max((this.boxFrame.getWidth() - this.actualBoxPaddings.left) - this.actualBoxPaddings.right, 0));
    }

    private final Size calcIconContainerSize(List<? extends Element> icons) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (Element element : icons) {
            ViewHolder viewHolder = element instanceof ViewHolder ? (ViewHolder) element : null;
            if (viewHolder != null && viewHolder.isVisible()) {
                viewHolder.getView().forceLayout();
                viewHolder.getView().measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                i++;
                i3 = Math.max(viewHolder.getView().getMeasuredHeight(), i3);
                i2 += viewHolder.getView().getMeasuredWidth();
            }
        }
        if (i > 1) {
            i2 += this.edit.getIconSpacing() * (i - 1);
        }
        return new Size(i2, i3);
    }

    private final void calcIconOffsets() {
        this.leadingIconOffset = this.leadingIconFrame.getWidth() == 0 ? 0 : this.leadingIconFrame.getWidth() + this.edit.getIconIndent();
        this.trailingIconOffset = this.trailingIconFrame.getWidth() != 0 ? this.edit.getIconIndent() + this.trailingIconFrame.getWidth() : 0;
    }

    private final void calcIconContainersFrames() {
        this.leadingIconFrame.setLeft(this.contentFrame.getLeft());
        CharSequence labelText = this.edit.getLabelText();
        int specZeroLengthLabelOffset = (labelText == null || labelText.length() <= 0) ? 0 : getSpecZeroLengthLabelOffset();
        if (this.leadingIconFrame.getWidth() != 0 && this.leadingIconFrame.getHeight() != 0) {
            this.leadingIconFrame.setTop(calcTopPositionForVerticalAlignment(this.edit.getStartIconVerticalGravity(), this.leadingIconFrame.getHeight(), specZeroLengthLabelOffset));
        }
        this.trailingIconFrame.setLeft(this.contentFrame.right() - this.trailingIconFrame.getWidth());
        if (this.trailingIconFrame.getWidth() == 0 || this.trailingIconFrame.getHeight() == 0) {
            return;
        }
        this.trailingIconFrame.setTop(calcTopPositionForVerticalAlignment(this.edit.getEndIconVerticalGravity(), this.trailingIconFrame.getHeight(), specZeroLengthLabelOffset));
    }

    private final int calcTopPositionForVerticalAlignment(int alignment, int elementHeight, int offset) {
        int max;
        int top = this.contentFrame.getTop();
        if (alignment == DXVerticalAlignment.Top.getValue()) {
            return top + offset;
        }
        if (alignment == DXVerticalAlignment.Center.getValue()) {
            max = Math.max((this.contentFrame.getHeight() - elementHeight) / 2, offset);
        } else {
            if (alignment != DXVerticalAlignment.Bottom.getValue()) {
                return top;
            }
            max = Math.max(this.contentFrame.getHeight() - elementHeight, offset);
        }
        return top + max;
    }

    protected final int calcTopPositionForVerticalGravity(int gravity, int elementHeight, int offset) {
        int i = gravity & 112;
        if (i == 16) {
            return calcTopPositionForVerticalAlignment(DXVerticalAlignment.Center.getValue(), elementHeight, offset);
        }
        if (i == 48) {
            return calcTopPositionForVerticalAlignment(DXVerticalAlignment.Top.getValue(), elementHeight, offset);
        }
        if (i != 80) {
            return 0;
        }
        return calcTopPositionForVerticalAlignment(DXVerticalAlignment.Bottom.getValue(), elementHeight, offset);
    }

    private final void calcLabelTextSize() {
        CharSequence labelText = this.edit.getLabelText();
        if (labelText == null || labelText.length() == 0) {
            this.labelTextSize = new Size(0, 0);
            return;
        }
        this.edit.labelTextView.forceLayout();
        this.edit.labelTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.labelTextSize = new Size(this.edit.labelTextView.getMeasuredWidth(), this.edit.labelTextView.getMeasuredHeight());
    }

    private final void calcPlaceholderTextSize() {
        CharSequence placeholder = this.edit.getPlaceholder();
        if (placeholder == null || placeholder.length() == 0 || this.edit.getIsLabelFloating()) {
            placeholder = this.edit.getLabelText();
        }
        CharSequence charSequence = placeholder;
        if (charSequence == null || charSequence.length() == 0) {
            this.placeholderFrame = new Rectangle();
            return;
        }
        this.textPaint.setTypeface(this.edit.getTextTypeface());
        this.textPaint.setTextSize(this.edit.getTextSize());
        Size sizeWithMargins = Companion.calcTextSize$default(INSTANCE, this.textPaint, charSequence, 0, 4, (Object) null).sizeWithMargins();
        if (needsCorrectionOfTextFiledHeight(sizeWithMargins.getHeight())) {
            sizeWithMargins = new Size(sizeWithMargins.getWidth(), this.specMinTextFieldHeight);
        }
        this.placeholderFrame.setSize(sizeWithMargins);
    }

    private final void calcCharCounterAreaSize() {
        EditBase editBase = this.edit;
        TextEditBase textEditBase = editBase instanceof TextEditBase ? (TextEditBase) editBase : null;
        if (textEditBase == null || !textEditBase.getActualIsCharactersCounterVisible$dxeditors_release()) {
            this.charCounterAreaFrame = new Rectangle();
            return;
        }
        String valueOf = String.valueOf(textEditBase != null ? textEditBase.getCharactersCount() : 0);
        this.textPaint.setTypeface(this.edit.getBottomTextTypeface());
        this.textPaint.setTextSize(this.edit.getBottomTextSize());
        Companion companion = INSTANCE;
        Size sizeWithMargins = Companion.calcTextSize$default(companion, this.textPaint, valueOf, 0, 4, (Object) null).sizeWithMargins();
        this.charCounterAreaFrame.setWidth((sizeWithMargins.getWidth() * 2) + Companion.calcTextSize$default(companion, this.textPaint, "  /  ", 0, 4, (Object) null).sizeWithMargins().getWidth());
        this.charCounterAreaFrame.setHeight(sizeWithMargins.getHeight());
    }

    private final void calcBottomTextAreaSizeForWidth(int maxWidth) {
        CharSequence errorText;
        CharSequence helpText;
        Size size = new Size(0, 0);
        int max = Math.max((maxWidth - this.charCounterAreaFrame.getWidth()) - this.edit.getCharacterCounterStartIndent(), 0);
        this.textPaint.setTypeface(this.edit.getBottomTextTypeface());
        this.textPaint.setTextSize(this.edit.getBottomTextSize());
        if (!this.edit.getHasError() && (helpText = this.edit.getHelpText()) != null && helpText.length() != 0) {
            size = INSTANCE.calcTextSize(this.textPaint, this.edit.getHelpText(), max).sizeWithMargins();
        }
        if (this.edit.getHasError() && (errorText = this.edit.getErrorText()) != null && errorText.length() != 0) {
            size = INSTANCE.calcTextSize(this.textPaint, this.edit.getErrorText(), max).sizeWithMargins();
        }
        if (this.edit.getReserveBottomTextLine() && size.getHeight() == 0) {
            size = new Size(size.getWidth(), INSTANCE.calcTextSize(this.textPaint).sizeWithMargins().getHeight());
        }
        this.bottomTextAreaFrame.setSize(size);
    }

    private final void calcBottomTextAreaFrame() {
        this.bottomTextAreaFrame.setLeft(this.contentFrame.getLeft());
        this.bottomTextAreaFrame.setTop(this.boxFrame.getTop() + this.boxFrame.getHeight() + this.edit.getBottomTextTopIndent());
    }

    private final void calcCharCounterAreaFrame() {
        this.charCounterAreaFrame.setLeft(this.contentFrame.right() - this.charCounterAreaFrame.getWidth());
        this.charCounterAreaFrame.setTop(this.bottomTextAreaFrame.getTop());
    }

    protected final int calcTargetBoxHeightAndPaddings(int contentHeight, int contentTopOffset, int specVerticalPadding) {
        boolean z = this.actualBoxPaddings.top == Integer.MIN_VALUE || this.actualBoxPaddings.bottom == Integer.MIN_VALUE;
        if (z) {
            this.actualBoxPaddings.top = specVerticalPadding;
            this.actualBoxPaddings.bottom = specVerticalPadding;
        }
        int height = this.maxSize.getHeight() == Integer.MAX_VALUE ? Integer.MAX_VALUE : (this.maxSize.getHeight() - Math.max(this.bottomTextAreaFrame.getHeight(), this.charCounterAreaFrame.getHeight())) - contentTopOffset;
        int calcTopPadding = ((calcTopPadding() + contentHeight) + this.actualBoxPaddings.bottom) - contentTopOffset;
        if (z && this.layoutHeightMode == 1073741824) {
            if (calcTopPadding > height) {
                double max = Math.max((height - contentHeight) / 2.0f, 0.0f);
                this.actualBoxPaddings.top = (int) Math.floor(max);
                this.actualBoxPaddings.bottom = (int) Math.ceil(max);
                calcTopPadding = this.actualBoxPaddings.bottom + contentHeight + this.actualBoxPaddings.top;
            } else if (height != Integer.MAX_VALUE && calcTopPadding < height) {
                double max2 = Math.max((height - contentHeight) / 2.0f, 0.0f);
                this.actualBoxPaddings.top = (int) Math.floor(max2);
                this.actualBoxPaddings.bottom = (int) Math.ceil(max2);
                calcTopPadding = height;
            }
        }
        if (this.edit.getMinBoxHeight() != -1 && calcTopPadding < this.edit.getMinBoxHeight()) {
            if (z) {
                Rect rect = this.actualBoxPaddings;
                double minBoxHeight = (this.edit.getMinBoxHeight() - calcTopPadding) / 2.0f;
                rect.top = Math.max(rect.top + ((int) Math.floor(minBoxHeight)), 0);
                Rect rect2 = this.actualBoxPaddings;
                rect2.bottom = Math.max(rect2.bottom + ((int) Math.ceil(minBoxHeight)), 0);
            }
            return this.layoutHeightMode == 1073741824 ? height : Math.max(calcTopPadding, this.edit.getMinBoxHeight());
        }
        if (this.edit.getBoxHeight() == -1 || calcTopPadding == this.edit.getBoxHeight()) {
            int i = this.layoutHeightMode;
            return i == 1073741824 ? height : i == Integer.MIN_VALUE ? Math.min(calcTopPadding, height) : calcTopPadding;
        }
        if (z) {
            Rect rect3 = this.actualBoxPaddings;
            double boxHeight = (this.edit.getBoxHeight() - calcTopPadding) / 2.0f;
            rect3.top = Math.max(rect3.top + ((int) Math.floor(boxHeight)), 0);
            Rect rect4 = this.actualBoxPaddings;
            rect4.bottom = Math.max(rect4.bottom + ((int) Math.ceil(boxHeight)), 0);
        }
        return this.layoutHeightMode == 1073741824 ? height : this.edit.getBoxHeight();
    }
}
