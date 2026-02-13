package crc647a19118a24842bb1;

import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class PlatformFilePrinter_PdfAdapter extends PrintDocumentAdapter implements IGCUserPeer {
    public static final String __md_methods = "n_onLayout:(Landroid/print/PrintAttributes;Landroid/print/PrintAttributes;Landroid/os/CancellationSignal;Landroid/print/PrintDocumentAdapter$LayoutResultCallback;Landroid/os/Bundle;)V:GetOnLayout_Landroid_print_PrintAttributes_Landroid_print_PrintAttributes_Landroid_os_CancellationSignal_Landroid_print_PrintDocumentAdapter_LayoutResultCallback_Landroid_os_Bundle_Handler\nn_onFinish:()V:GetOnFinishHandler\nn_onWrite:([Landroid/print/PageRange;Landroid/os/ParcelFileDescriptor;Landroid/os/CancellationSignal;Landroid/print/PrintDocumentAdapter$WriteResultCallback;)V:GetOnWrite_arrayLandroid_print_PageRange_Landroid_os_ParcelFileDescriptor_Landroid_os_CancellationSignal_Landroid_print_PrintDocumentAdapter_WriteResultCallback_Handler\n";
    private ArrayList refList;

    private native void n_onFinish();

    private native void n_onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle);

    private native void n_onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback);

    static {
        Runtime.register("DevExpress.Maui.Core.Internal.PlatformFilePrinter+PdfAdapter, DevExpress.Maui.Core", PlatformFilePrinter_PdfAdapter.class, __md_methods);
    }

    public PlatformFilePrinter_PdfAdapter() {
        if (getClass() == PlatformFilePrinter_PdfAdapter.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Internal.PlatformFilePrinter+PdfAdapter, DevExpress.Maui.Core", "", this, new Object[0]);
        }
    }

    public PlatformFilePrinter_PdfAdapter(byte[] bArr) {
        if (getClass() == PlatformFilePrinter_PdfAdapter.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Internal.PlatformFilePrinter+PdfAdapter, DevExpress.Maui.Core", "System.Byte[], System.Private.CoreLib", this, new Object[]{bArr});
        }
    }

    @Override // android.print.PrintDocumentAdapter
    public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
        n_onLayout(printAttributes, printAttributes2, cancellationSignal, layoutResultCallback, bundle);
    }

    @Override // android.print.PrintDocumentAdapter
    public void onFinish() {
        n_onFinish();
    }

    @Override // android.print.PrintDocumentAdapter
    public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        n_onWrite(pageRangeArr, parcelFileDescriptor, cancellationSignal, writeResultCallback);
    }

    @Override // mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
