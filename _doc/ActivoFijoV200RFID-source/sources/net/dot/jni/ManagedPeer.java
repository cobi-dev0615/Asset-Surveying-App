package net.dot.jni;

/* loaded from: classes3.dex */
public final class ManagedPeer {
    public static native void construct(Object obj, String str, Object... objArr);

    public static native void registerNativeMembers(Class<?> cls, String str);

    private ManagedPeer() {
    }
}
