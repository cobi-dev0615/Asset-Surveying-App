package io.liteglue;

import java.sql.SQLException;

/* loaded from: classes.dex */
public class SQLiteConnector implements SQLiteConnectionFactory {
    static boolean isLibLoaded = false;

    public SQLiteConnector() {
        if (isLibLoaded) {
            return;
        }
        System.loadLibrary("sqlc-ndk-native-driver");
        if (SQLiteNDKNativeDriver.sqlc_api_version_check(4) != 0) {
            throw new RuntimeException("native library version mismatch");
        }
        isLibLoaded = true;
    }

    @Override // io.liteglue.SQLiteConnectionFactory
    public SQLiteConnection newSQLiteConnection(String str, int i) throws SQLException {
        return new SQLiteGlueConnection(str, i);
    }
}
