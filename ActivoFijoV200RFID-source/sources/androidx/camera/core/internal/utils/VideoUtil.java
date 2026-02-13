package androidx.camera.core.internal.utils;

/* loaded from: classes.dex */
public final class VideoUtil {
    private static final String TAG = "VideoUtil";

    private VideoUtil() {
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getAbsolutePathFromUri(android.content.ContentResolver r8, android.net.Uri r9) {
        /*
            java.lang.String r0 = "_data"
            r1 = 0
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch: java.lang.RuntimeException -> L2d java.lang.Throwable -> L56
            r6 = 0
            r7 = 0
            r5 = 0
            r2 = r8
            r3 = r9
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.RuntimeException -> L2d java.lang.Throwable -> L56
            java.lang.Object r8 = androidx.core.util.Preconditions.checkNotNull(r1)     // Catch: java.lang.RuntimeException -> L2d java.lang.Throwable -> L56
            android.database.Cursor r8 = (android.database.Cursor) r8     // Catch: java.lang.RuntimeException -> L2d java.lang.Throwable -> L56
            int r0 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            r8.moveToFirst()     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            java.lang.String r9 = r8.getString(r0)     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            if (r8 == 0) goto L26
            r8.close()
        L26:
            return r9
        L27:
            r9 = move-exception
            r1 = r8
            goto L57
        L2a:
            r0 = move-exception
            r1 = r8
            goto L2e
        L2d:
            r0 = move-exception
        L2e:
            java.lang.String r8 = "VideoUtil"
            java.lang.String r2 = "Failed in getting absolute path for Uri %s with Exception %s"
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L56
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L56
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L54
            r4 = 0
            r3[r4] = r9     // Catch: java.lang.Throwable -> L54
            r9 = 1
            r3[r9] = r0     // Catch: java.lang.Throwable -> L54
            java.lang.String r9 = java.lang.String.format(r2, r3)     // Catch: java.lang.Throwable -> L56
            androidx.camera.core.Logger.e(r8, r9)     // Catch: java.lang.Throwable -> L56
            java.lang.String r8 = ""
            if (r1 == 0) goto L51
            r1.close()
        L51:
            return r8
        L52:
            r9 = r8
            goto L57
        L54:
            r8 = move-exception
            goto L52
        L56:
            r9 = move-exception
        L57:
            if (r1 == 0) goto L5c
            r1.close()
        L5c:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.utils.VideoUtil.getAbsolutePathFromUri(android.content.ContentResolver, android.net.Uri):java.lang.String");
    }
}
