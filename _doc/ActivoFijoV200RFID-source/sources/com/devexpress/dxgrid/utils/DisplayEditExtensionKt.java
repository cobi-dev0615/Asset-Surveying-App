package com.devexpress.dxgrid.utils;

import android.text.TextUtils;
import com.devexpress.dxgrid.models.LineBreakMode;
import com.devexpress.editors.DisplayEdit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: DisplayEditExtension.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"setLineBreakMode", "", "Lcom/devexpress/editors/DisplayEdit;", "lineBreakMode", "Lcom/devexpress/dxgrid/models/LineBreakMode;", "dxgrid_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DisplayEditExtensionKt {

    /* compiled from: DisplayEditExtension.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LineBreakMode.values().length];
            try {
                iArr[LineBreakMode.NoWrap.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LineBreakMode.WordWrap.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LineBreakMode.CharacterWrap.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LineBreakMode.HeadTruncation.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LineBreakMode.MiddleTruncation.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LineBreakMode.TailTruncation.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, android.text.TextUtils$TruncateAt] */
    /* JADX WARN: Type inference failed for: r5v10, types: [T, android.text.TextUtils$TruncateAt] */
    /* JADX WARN: Type inference failed for: r5v8, types: [T, android.text.TextUtils$TruncateAt] */
    /* JADX WARN: Type inference failed for: r5v9, types: [T, android.text.TextUtils$TruncateAt] */
    public static final void setLineBreakMode(final DisplayEdit displayEdit, LineBreakMode lineBreakMode) {
        Intrinsics.checkNotNullParameter(displayEdit, "<this>");
        Intrinsics.checkNotNullParameter(lineBreakMode, "lineBreakMode");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = displayEdit.getEllipsize();
        switch (WhenMappings.$EnumSwitchMapping$0[lineBreakMode.ordinal()]) {
            case 1:
                booleanRef.element = true;
                objectRef.element = null;
                break;
            case 2:
            case 3:
                booleanRef.element = false;
                objectRef.element = null;
                break;
            case 4:
                booleanRef.element = true;
                objectRef.element = TextUtils.TruncateAt.START;
                break;
            case 5:
                booleanRef.element = true;
                objectRef.element = TextUtils.TruncateAt.MIDDLE;
                break;
            case 6:
                booleanRef.element = true;
                objectRef.element = TextUtils.TruncateAt.END;
                break;
        }
        if (displayEdit.isSingleLine() != booleanRef.element) {
            displayEdit.post(new Runnable() { // from class: com.devexpress.dxgrid.utils.DisplayEditExtensionKt$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DisplayEditExtensionKt.setLineBreakMode$lambda$0(DisplayEdit.this, booleanRef);
                }
            });
        }
        if (displayEdit.getEllipsize() != objectRef.element) {
            displayEdit.post(new Runnable() { // from class: com.devexpress.dxgrid.utils.DisplayEditExtensionKt$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    DisplayEditExtensionKt.setLineBreakMode$lambda$1(DisplayEdit.this, objectRef);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLineBreakMode$lambda$0(DisplayEdit this_setLineBreakMode, Ref.BooleanRef isSingleLine) {
        Intrinsics.checkNotNullParameter(this_setLineBreakMode, "$this_setLineBreakMode");
        Intrinsics.checkNotNullParameter(isSingleLine, "$isSingleLine");
        this_setLineBreakMode.setSingleLine(isSingleLine.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void setLineBreakMode$lambda$1(DisplayEdit this_setLineBreakMode, Ref.ObjectRef ellipsize) {
        Intrinsics.checkNotNullParameter(this_setLineBreakMode, "$this_setLineBreakMode");
        Intrinsics.checkNotNullParameter(ellipsize, "$ellipsize");
        this_setLineBreakMode.setEllipsize((TextUtils.TruncateAt) ellipsize.element);
    }
}
