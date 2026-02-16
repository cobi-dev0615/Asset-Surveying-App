package com.devexpress.editors.dataForm;

import android.content.Context;
import android.widget.Switch;
import com.devexpress.editors.ComboBoxEdit;
import com.devexpress.editors.DateEdit;
import com.devexpress.editors.MultilineEdit;
import com.devexpress.editors.PasswordEdit;
import com.devexpress.editors.TextEdit;
import com.devexpress.editors.TimeEdit;
import com.devexpress.editors.dataForm.protocols.DXDataFormEditorItem;
import com.devexpress.editors.dataForm.protocols.DataFormEditorFactory;
import com.devexpress.editors.dataForm.protocols.EditorType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataFormEditorFactoryImpl.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/devexpress/editors/dataForm/DataFormEditorFactoryImpl;", "Lcom/devexpress/editors/dataForm/protocols/DataFormEditorFactory;", "()V", "create", "Lcom/devexpress/editors/dataForm/protocols/DXDataFormEditorItem;", "context", "Landroid/content/Context;", "kind", "Lcom/devexpress/editors/dataForm/protocols/EditorType;", "groupId", "", "editorIndex", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DataFormEditorFactoryImpl extends DataFormEditorFactory {

    /* compiled from: DataFormEditorFactoryImpl.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EditorType.values().length];
            try {
                iArr[EditorType.Password.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EditorType.MultilineText.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EditorType.Custom.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EditorType.Switch.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EditorType.Date.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EditorType.Time.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EditorType.Picker.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.devexpress.editors.dataForm.protocols.DataFormEditorFactory
    public DXDataFormEditorItem create(Context context, EditorType kind, int groupId, int editorIndex) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(kind, "kind");
        switch (WhenMappings.$EnumSwitchMapping$0[kind.ordinal()]) {
            case 1:
                return new DXDataFormEditorItem(new PasswordEdit(context, null, 0, 6, null), null, 2, null);
            case 2:
                return new DXDataFormEditorItem(new MultilineEdit(context, null, 0, 6, null), null, 2, null);
            case 3:
                return new DXDataFormEditorItem(null, null, 2, null);
            case 4:
                return new DXDataFormEditorItem(new Switch(context), null, 2, null);
            case 5:
                return new DXDataFormEditorItem(new DateEdit(context, null, 0, 6, null), null, 2, null);
            case 6:
                return new DXDataFormEditorItem(new TimeEdit(context, null, 0, 6, null), null, 2, null);
            case 7:
                return new DXDataFormEditorItem(new ComboBoxEdit(context, null, 0, 6, null), null, 2, null);
            default:
                return new DXDataFormEditorItem(new TextEdit(context, null, 0, 6, null), null, 2, null);
        }
    }
}
