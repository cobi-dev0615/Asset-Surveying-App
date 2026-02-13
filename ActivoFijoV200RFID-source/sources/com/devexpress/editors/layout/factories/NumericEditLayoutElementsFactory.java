package com.devexpress.editors.layout.factories;

import android.view.View;
import android.widget.TextView;
import com.devexpress.editors.DXNumericEditIconPosition;
import com.devexpress.editors.layout.Element;
import com.devexpress.editors.layout.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NumericEditLayoutElementsFactory.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0011R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR$\u0010\u0010\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u0018X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001a¨\u0006+"}, d2 = {"Lcom/devexpress/editors/layout/factories/NumericEditLayoutElementsFactory;", "Lcom/devexpress/editors/layout/factories/AbstractEditLayoutElementsFactory;", "editorView", "Landroid/widget/TextView;", "labelView", "leadingImage", "Landroid/view/View;", "trailingImage", "clearImage", "errorImage", "errorView", "helperView", "suffixView", "prefixView", "upImage", "downImage", "upDownIconPosition", "Lcom/devexpress/editors/DXNumericEditIconPosition;", "(Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;Landroid/view/View;Lcom/devexpress/editors/DXNumericEditIconPosition;)V", "actualEndImageElements", "", "Lcom/devexpress/editors/layout/Element;", "actualStartImageElements", "downImageElement", "Lcom/devexpress/editors/layout/ViewHolder;", "getDownImageElement", "()Lcom/devexpress/editors/layout/ViewHolder;", "endImageElements", "", "getEndImageElements", "()Ljava/util/List;", "startImageElements", "getStartImageElements", "value", "getUpDownIconPosition", "()Lcom/devexpress/editors/DXNumericEditIconPosition;", "setUpDownIconPosition", "(Lcom/devexpress/editors/DXNumericEditIconPosition;)V", "upImageElement", "getUpImageElement", "updateUpDownIconPosition", "", "iconPosition", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class NumericEditLayoutElementsFactory extends AbstractEditLayoutElementsFactory {
    private final List<Element> actualEndImageElements;
    private final List<Element> actualStartImageElements;
    private final ViewHolder downImageElement;
    private DXNumericEditIconPosition upDownIconPosition;
    private final ViewHolder upImageElement;

    /* compiled from: NumericEditLayoutElementsFactory.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DXNumericEditIconPosition.values().length];
            try {
                iArr[DXNumericEditIconPosition.DownStartUpStart.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DXNumericEditIconPosition.DownStartUpEnd.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DXNumericEditIconPosition.DownEndUpEnd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumericEditLayoutElementsFactory(TextView editorView, TextView labelView, View leadingImage, View trailingImage, View clearImage, View errorImage, View errorView, View helperView, TextView suffixView, TextView prefixView, View upImage, View downImage, DXNumericEditIconPosition upDownIconPosition) {
        super(editorView, labelView, leadingImage, trailingImage, clearImage, errorImage, errorView, helperView, suffixView, prefixView);
        Intrinsics.checkNotNullParameter(editorView, "editorView");
        Intrinsics.checkNotNullParameter(labelView, "labelView");
        Intrinsics.checkNotNullParameter(leadingImage, "leadingImage");
        Intrinsics.checkNotNullParameter(trailingImage, "trailingImage");
        Intrinsics.checkNotNullParameter(clearImage, "clearImage");
        Intrinsics.checkNotNullParameter(errorImage, "errorImage");
        Intrinsics.checkNotNullParameter(errorView, "errorView");
        Intrinsics.checkNotNullParameter(helperView, "helperView");
        Intrinsics.checkNotNullParameter(suffixView, "suffixView");
        Intrinsics.checkNotNullParameter(prefixView, "prefixView");
        Intrinsics.checkNotNullParameter(upImage, "upImage");
        Intrinsics.checkNotNullParameter(downImage, "downImage");
        Intrinsics.checkNotNullParameter(upDownIconPosition, "upDownIconPosition");
        this.actualStartImageElements = new ArrayList();
        this.actualEndImageElements = new ArrayList();
        ViewHolder viewHolder = new ViewHolder("up_icon", upImage, null, null, false, 28, null);
        this.upImageElement = viewHolder;
        ViewHolder viewHolder2 = new ViewHolder("down_icon", downImage, null, null, false, 28, null);
        this.downImageElement = viewHolder2;
        this.upDownIconPosition = DXNumericEditIconPosition.DownStartUpEnd;
        setUpDownIconPosition(upDownIconPosition);
        updateUpDownIconPosition(this.upDownIconPosition);
        viewHolder.setGravity(113);
        viewHolder2.setGravity(113);
    }

    protected final ViewHolder getUpImageElement() {
        return this.upImageElement;
    }

    protected final ViewHolder getDownImageElement() {
        return this.downImageElement;
    }

    public final DXNumericEditIconPosition getUpDownIconPosition() {
        return this.upDownIconPosition;
    }

    public final void setUpDownIconPosition(DXNumericEditIconPosition value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value == this.upDownIconPosition) {
            return;
        }
        this.upDownIconPosition = value;
        updateUpDownIconPosition(value);
    }

    @Override // com.devexpress.editors.layout.factories.AbstractEditLayoutElementsFactory, com.devexpress.editors.LayoutElementsFactory
    public List<Element> getStartImageElements() {
        return this.actualStartImageElements;
    }

    @Override // com.devexpress.editors.layout.factories.AbstractEditLayoutElementsFactory, com.devexpress.editors.LayoutElementsFactory
    public List<Element> getEndImageElements() {
        return this.actualEndImageElements;
    }

    public final void updateUpDownIconPosition(DXNumericEditIconPosition iconPosition) {
        Intrinsics.checkNotNullParameter(iconPosition, "iconPosition");
        int i = WhenMappings.$EnumSwitchMapping$0[iconPosition.ordinal()];
        if (i == 1) {
            this.actualStartImageElements.clear();
            this.actualStartImageElements.add(getStartImageElement());
            this.actualStartImageElements.add(this.downImageElement);
            this.actualStartImageElements.add(this.upImageElement);
            this.actualEndImageElements.clear();
            this.actualEndImageElements.add(getClearImageElement());
            this.actualEndImageElements.add(getEndImageElement());
            this.actualEndImageElements.add(getErrorImageElement());
            return;
        }
        if (i == 2) {
            this.actualStartImageElements.clear();
            this.actualStartImageElements.add(getStartImageElement());
            this.actualStartImageElements.add(this.downImageElement);
            this.actualEndImageElements.clear();
            this.actualEndImageElements.add(getClearImageElement());
            this.actualEndImageElements.add(this.upImageElement);
            this.actualEndImageElements.add(getEndImageElement());
            this.actualEndImageElements.add(getErrorImageElement());
            return;
        }
        if (i != 3) {
            return;
        }
        this.actualStartImageElements.clear();
        this.actualStartImageElements.add(getStartImageElement());
        this.actualEndImageElements.clear();
        this.actualEndImageElements.add(getClearImageElement());
        this.actualEndImageElements.add(this.downImageElement);
        this.actualEndImageElements.add(this.upImageElement);
        this.actualEndImageElements.add(getEndImageElement());
        this.actualEndImageElements.add(getErrorImageElement());
    }
}
