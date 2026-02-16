package crc64467b05f37239e7a6;

import android.media.MediaDataSource;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class StreamMediaDataSource extends MediaDataSource implements IGCUserPeer {
    public static final String __md_methods = "n_getSize:()J:GetGetSizeHandler\nn_readAt:(J[BII)I:GetReadAt_JarrayBIIHandler\nn_close:()V:GetCloseHandler\n";
    private ArrayList refList;

    private native void n_close();

    private native long n_getSize();

    private native int n_readAt(long j, byte[] bArr, int i, int i2);

    static {
        Runtime.register("Plugin.Maui.Audio.StreamMediaDataSource, Plugin.Maui.Audio", StreamMediaDataSource.class, __md_methods);
    }

    public StreamMediaDataSource() {
        if (getClass() == StreamMediaDataSource.class) {
            TypeManager.Activate("Plugin.Maui.Audio.StreamMediaDataSource, Plugin.Maui.Audio", "", this, new Object[0]);
        }
    }

    @Override // android.media.MediaDataSource
    public long getSize() {
        return n_getSize();
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) {
        return n_readAt(j, bArr, i, i2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        n_close();
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
