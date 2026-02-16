package com.devexpress.editors.utils;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TimePicker;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimePickerDialogFragment.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0003\u0011\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/devexpress/editors/utils/TimePickerDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "delegate", "Lcom/devexpress/editors/utils/TimePickerDialogFragment$TimePickerDelegate;", "getDelegate", "()Lcom/devexpress/editors/utils/TimePickerDialogFragment$TimePickerDelegate;", "setDelegate", "(Lcom/devexpress/editors/utils/TimePickerDialogFragment$TimePickerDelegate;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "", "dialog", "Landroid/content/DialogInterface;", "Companion", "DefaultTimePickerDelegate", "TimePickerDelegate", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TimePickerDialogFragment extends DialogFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private TimePickerDelegate delegate = TimePickerDelegate.INSTANCE.getDefault();

    /* compiled from: TimePickerDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/utils/TimePickerDialogFragment$Companion;", "", "()V", "create", "Lcom/devexpress/editors/utils/TimePickerDialogFragment;", "delegate", "Lcom/devexpress/editors/utils/TimePickerDialogFragment$TimePickerDelegate;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TimePickerDialogFragment create(TimePickerDelegate delegate) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            TimePickerDialogFragment timePickerDialogFragment = new TimePickerDialogFragment();
            timePickerDialogFragment.setDelegate(delegate);
            return timePickerDialogFragment;
        }
    }

    public final TimePickerDelegate getDelegate() {
        return this.delegate;
    }

    public final void setDelegate(TimePickerDelegate timePickerDelegate) {
        Intrinsics.checkNotNullParameter(timePickerDelegate, "<set-?>");
        this.delegate = timePickerDelegate;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        TimePickerDialog timePickerDialog = new TimePickerDialog(requireContext(), this.delegate.getThemeResId(), this.delegate.getListener(), calendar.get(11), calendar.get(12), this.delegate.is24HourView());
        this.delegate.configure(timePickerDialog);
        return timePickerDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        this.delegate.onDismiss();
    }

    /* compiled from: TimePickerDialogFragment.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u000eH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/devexpress/editors/utils/TimePickerDialogFragment$TimePickerDelegate;", "", "is24HourView", "", "()Z", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/app/TimePickerDialog$OnTimeSetListener;", "getListener", "()Landroid/app/TimePickerDialog$OnTimeSetListener;", "themeResId", "", "getThemeResId", "()I", "configure", "", "dialog", "Landroid/app/TimePickerDialog;", "onDismiss", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface TimePickerDelegate {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        void configure(TimePickerDialog dialog);

        TimePickerDialog.OnTimeSetListener getListener();

        int getThemeResId();

        boolean is24HourView();

        void onDismiss();

        /* compiled from: TimePickerDialogFragment.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/utils/TimePickerDialogFragment$TimePickerDelegate$Companion;", "", "()V", "default", "Lcom/devexpress/editors/utils/TimePickerDialogFragment$TimePickerDelegate;", "getDefault", "()Lcom/devexpress/editors/utils/TimePickerDialogFragment$TimePickerDelegate;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final TimePickerDelegate getDefault() {
                return DefaultTimePickerDelegate.INSTANCE;
            }
        }
    }

    /* compiled from: TimePickerDialogFragment.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J \u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/devexpress/editors/utils/TimePickerDialogFragment$DefaultTimePickerDelegate;", "Lcom/devexpress/editors/utils/TimePickerDialogFragment$TimePickerDelegate;", "Landroid/app/TimePickerDialog$OnTimeSetListener;", "()V", "is24HourView", "", "()Z", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getListener", "()Landroid/app/TimePickerDialog$OnTimeSetListener;", "themeResId", "", "getThemeResId", "()I", "configure", "", "dialog", "Landroid/app/TimePickerDialog;", "onDismiss", "onTimeSet", "view", "Landroid/widget/TimePicker;", "hourOfDay", "minute", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultTimePickerDelegate implements TimePickerDelegate, TimePickerDialog.OnTimeSetListener {
        public static final DefaultTimePickerDelegate INSTANCE = new DefaultTimePickerDelegate();
        private static final boolean is24HourView = true;
        private static final int themeResId = 0;

        @Override // com.devexpress.editors.utils.TimePickerDialogFragment.TimePickerDelegate
        public void configure(TimePickerDialog dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
        }

        @Override // com.devexpress.editors.utils.TimePickerDialogFragment.TimePickerDelegate
        public void onDismiss() {
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        private DefaultTimePickerDelegate() {
        }

        @Override // com.devexpress.editors.utils.TimePickerDialogFragment.TimePickerDelegate
        public int getThemeResId() {
            return themeResId;
        }

        @Override // com.devexpress.editors.utils.TimePickerDialogFragment.TimePickerDelegate
        public boolean is24HourView() {
            return is24HourView;
        }

        @Override // com.devexpress.editors.utils.TimePickerDialogFragment.TimePickerDelegate
        public TimePickerDialog.OnTimeSetListener getListener() {
            return this;
        }
    }
}
