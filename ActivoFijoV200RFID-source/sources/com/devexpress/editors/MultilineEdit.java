package com.devexpress.editors;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import com.devexpress.editors.layout2.Layout;
import com.devexpress.editors.layout2.MultilineFilledLayout;
import com.devexpress.editors.layout2.MultilineOutlinedLayout;
import com.devexpress.editors.style.TextEditStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultilineEdit.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020!H\u0014J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u000fH\u0014R\u0014\u0010\t\u001a\u00020\u00078TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010R$\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006'"}, d2 = {"Lcom/devexpress/editors/MultilineEdit;", "Lcom/devexpress/editors/TextEditBase;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actualEditorInputType", "getActualEditorInputType", "()I", "internalStyle", "Lcom/devexpress/editors/style/TextEditStyle;", "isMultilineEdit", "", "()Z", "lineCount", "maxLineCount", "getMaxLineCount", "setMaxLineCount", "(I)V", "minLineCount", "getMinLineCount", "setMinLineCount", "style", "getStyle", "()Lcom/devexpress/editors/style/TextEditStyle;", "createLayout", "Lcom/devexpress/editors/layout2/Layout;", "borderMode", "Lcom/devexpress/editors/DXBorderMode;", "onEditorInputTypeChange", "", "onInterceptTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "setInternalEditorEditable", "isEditable", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class MultilineEdit extends TextEditBase {
    private final TextEditStyle internalStyle;
    private final boolean isMultilineEdit;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultilineEdit(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultilineEdit(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultilineEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isMultilineEdit = true;
        this.internalStyle = new TextEditStyle();
        setInputType(180225);
        getInternalEditor().setSingleLine(false);
        finishInitialization(attributeSet, i);
    }

    public /* synthetic */ MultilineEdit(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final int getMaxLineCount() {
        return getInternalEditor().getMaxLines();
    }

    public final void setMaxLineCount(int i) {
        if (getMinLineCount() > i) {
            setMinLineCount(i);
        }
        getInternalEditor().setMaxLines(i);
    }

    public final int getMinLineCount() {
        return getInternalEditor().getMinLines();
    }

    public final void setMinLineCount(int i) {
        if (getMaxLineCount() < i) {
            setMaxLineCount(i);
        }
        getInternalEditor().setMinLines(i);
    }

    @Override // com.devexpress.editors.EditBase
    /* renamed from: isMultilineEdit, reason: from getter */
    protected boolean getIsMultilineEdit() {
        return this.isMultilineEdit;
    }

    @Override // com.devexpress.editors.EditBase
    protected int getActualEditorInputType() {
        return getIsReadOnly() ? super.getActualEditorInputType() : super.getActualEditorInputType() | 131072;
    }

    @Override // com.devexpress.editors.EditBase
    /* renamed from: getStyle, reason: from getter */
    public TextEditStyle getInternalStyle() {
        return this.internalStyle;
    }

    @Override // com.devexpress.editors.EditBase
    protected Layout createLayout(DXBorderMode borderMode) {
        Intrinsics.checkNotNullParameter(borderMode, "borderMode");
        if (borderMode == DXBorderMode.Filled) {
            return new MultilineFilledLayout(this);
        }
        return new MultilineOutlinedLayout(this);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (getInternalEditor().canScrollVertically(1) || getInternalEditor().canScrollVertically(-1)) {
            getInternalEditor().getParent().requestDisallowInterceptTouchEvent(true);
            if ((event.getAction() & 255) == 8) {
                getInternalEditor().getParent().requestDisallowInterceptTouchEvent(false);
                return true;
            }
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    protected void setInternalEditorEditable(boolean isEditable) {
        super.setInternalEditorEditable(isEditable);
        getInternalEditor().setSingleLine(false);
    }

    @Override // com.devexpress.editors.EditBase
    protected void onEditorInputTypeChange() {
        super.onEditorInputTypeChange();
        getInternalEditor().setSingleLine(false);
    }
}
