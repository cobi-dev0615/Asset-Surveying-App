package io.liteglue;

/* loaded from: classes.dex */
public class SQLiteNativeResponse {
    private long handle;
    private int result;

    public SQLiteNativeResponse(int i, long j) {
        this.result = i;
        this.handle = j;
    }

    public int getResult() {
        return this.result;
    }

    public long getHandle() {
        return this.handle;
    }
}
