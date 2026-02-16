package com.devexpress.editors.utils;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DatePickerDialogFragment.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0003\u0011\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/devexpress/editors/utils/DatePickerDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "delegate", "Lcom/devexpress/editors/utils/DatePickerDialogFragment$DatePickerDelegate;", "getDelegate", "()Lcom/devexpress/editors/utils/DatePickerDialogFragment$DatePickerDelegate;", "setDelegate", "(Lcom/devexpress/editors/utils/DatePickerDialogFragment$DatePickerDelegate;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "", "dialog", "Landroid/content/DialogInterface;", "Companion", "DatePickerDelegate", "DefaultDatePickerDelegate", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DatePickerDialogFragment extends DialogFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DatePickerDelegate delegate = DatePickerDelegate.INSTANCE.getDefault();

    /* compiled from: DatePickerDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/utils/DatePickerDialogFragment$Companion;", "", "()V", "create", "Lcom/devexpress/editors/utils/DatePickerDialogFragment;", "delegate", "Lcom/devexpress/editors/utils/DatePickerDialogFragment$DatePickerDelegate;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DatePickerDialogFragment create(DatePickerDelegate delegate) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            DatePickerDialogFragment datePickerDialogFragment = new DatePickerDialogFragment();
            datePickerDialogFragment.setDelegate(delegate);
            return datePickerDialogFragment;
        }
    }

    public final DatePickerDelegate getDelegate() {
        return this.delegate;
    }

    public final void setDelegate(DatePickerDelegate datePickerDelegate) {
        Intrinsics.checkNotNullParameter(datePickerDelegate, "<set-?>");
        this.delegate = datePickerDelegate;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(), this.delegate.getThemeResId(), this.delegate.getListener(), calendar.get(1), calendar.get(2), calendar.get(5));
        this.delegate.configure(datePickerDialog);
        return datePickerDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        this.delegate.onDismiss();
    }

    /* compiled from: DatePickerDialogFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/devexpress/editors/utils/DatePickerDialogFragment$DatePickerDelegate;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/app/DatePickerDialog$OnDateSetListener;", "getListener", "()Landroid/app/DatePickerDialog$OnDateSetListener;", "themeResId", "", "getThemeResId", "()I", "configure", "", "dialog", "Landroid/app/DatePickerDialog;", "onDismiss", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface DatePickerDelegate {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        void configure(DatePickerDialog dialog);

        DatePickerDialog.OnDateSetListener getListener();

        int getThemeResId();

        void onDismiss();

        /* compiled from: DatePickerDialogFragment.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/utils/DatePickerDialogFragment$DatePickerDelegate$Companion;", "", "()V", "default", "Lcom/devexpress/editors/utils/DatePickerDialogFragment$DatePickerDelegate;", "getDefault", "()Lcom/devexpress/editors/utils/DatePickerDialogFragment$DatePickerDelegate;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final DatePickerDelegate getDefault() {
                return DefaultDatePickerDelegate.INSTANCE;
            }
        }
    }

    /* compiled from: DatePickerDialogFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J*\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/devexpress/editors/utils/DatePickerDialogFragment$DefaultDatePickerDelegate;", "Lcom/devexpress/editors/utils/DatePickerDialogFragment$DatePickerDelegate;", "Landroid/app/DatePickerDialog$OnDateSetListener;", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getListener", "()Landroid/app/DatePickerDialog$OnDateSetListener;", "themeResId", "", "getThemeResId", "()I", "configure", "", "dialog", "Landroid/app/DatePickerDialog;", "onDateSet", "view", "Landroid/widget/DatePicker;", "year", "month", "dayOfMonth", "onDismiss", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultDatePickerDelegate implements DatePickerDelegate, DatePickerDialog.OnDateSetListener {
        public static final DefaultDatePickerDelegate INSTANCE = new DefaultDatePickerDelegate();
        private static final int themeResId = 0;

        @Override // com.devexpress.editors.utils.DatePickerDialogFragment.DatePickerDelegate
        public void configure(DatePickerDialog dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        }

        @Override // com.devexpress.editors.utils.DatePickerDialogFragment.DatePickerDelegate
        public void onDismiss() {
        }

        private DefaultDatePickerDelegate() {
        }

        @Override // com.devexpress.editors.utils.DatePickerDialogFragment.DatePickerDelegate
        public int getThemeResId() {
            return themeResId;
        }

        @Override // com.devexpress.editors.utils.DatePickerDialogFragment.DatePickerDelegate
        public DatePickerDialog.OnDateSetListener getListener() {
            return this;
        }
    }
}
