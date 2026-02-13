package io.sqlc;

import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import io.liteglue.SQLiteConnection;
import io.liteglue.SQLiteConnector;
import java.io.File;
import java.sql.SQLException;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class SQLiteConnectorDatabase extends SQLiteAndroidDatabase {
    static SQLiteConnector connector = new SQLiteConnector();
    SQLiteConnection mydb;

    @Override // io.sqlc.SQLiteAndroidDatabase
    void bugWorkaround() {
    }

    SQLiteConnectorDatabase() {
    }

    @Override // io.sqlc.SQLiteAndroidDatabase
    void open(File dbFile) throws Exception {
        this.mydb = connector.newSQLiteConnection(dbFile.getAbsolutePath(), 6);
    }

    @Override // io.sqlc.SQLiteAndroidDatabase
    void closeDatabaseNow() {
        try {
            SQLiteConnection sQLiteConnection = this.mydb;
            if (sQLiteConnection != null) {
                sQLiteConnection.dispose();
            }
        } catch (Exception e) {
            Log.e(SQLitePlugin.class.getSimpleName(), "couldn't close database, ignoring", e);
        }
    }

    @Override // io.sqlc.SQLiteAndroidDatabase
    void executeSqlBatch(String[] queryarr, JSONArray[] jsonparams, CallbackContext cbc) {
        String message;
        int i;
        if (this.mydb == null) {
            cbc.error("database has been closed");
            return;
        }
        int length = queryarr.length;
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject = null;
            try {
                String str = queryarr[i2];
                long totalChanges = this.mydb.getTotalChanges();
                jSONObject = executeSQLiteStatement(str, jsonparams[i2], cbc);
                long totalChanges2 = this.mydb.getTotalChanges() - totalChanges;
                jSONObject.put("rowsAffected", totalChanges2);
                if (totalChanges2 > 0) {
                    long lastInsertRowid = this.mydb.getLastInsertRowid();
                    if (lastInsertRowid > 0) {
                        jSONObject.put("insertId", lastInsertRowid);
                    }
                }
                message = EnvironmentCompat.MEDIA_UNKNOWN;
            } catch (SQLException e) {
                e.printStackTrace();
                int errorCode = e.getErrorCode();
                message = e.getMessage();
                Log.v("executeSqlBatch", "SQLitePlugin.executeSql[Batch](): SQL Error code = " + errorCode + " message = " + message);
                if (errorCode == 1) {
                    i = 5;
                } else if (errorCode == 13) {
                    i = 4;
                } else if (errorCode == 19) {
                    i = 6;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                message = e2.getMessage();
                Log.e("executeSqlBatch", "SQLitePlugin.executeSql[Batch](): UNEXPECTED JSON Error=" + message);
            }
            i = 0;
            if (jSONObject != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("type", "success");
                    jSONObject2.put("result", jSONObject);
                    jSONArray.put(jSONObject2);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    Log.e("executeSqlBatch", "SQLitePlugin.executeSql[Batch](): Error=" + e3.getMessage());
                }
            } else {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("type", "error");
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("message", message);
                jSONObject4.put("code", i);
                jSONObject3.put("result", jSONObject4);
                jSONArray.put(jSONObject3);
            }
        }
        cbc.success(jSONArray);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b6, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b7, code lost:
    
        r9.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.json.JSONObject executeSQLiteStatement(java.lang.String r8, org.json.JSONArray r9, org.apache.cordova.CallbackContext r10) throws org.json.JSONException, java.sql.SQLException {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sqlc.SQLiteConnectorDatabase.executeSQLiteStatement(java.lang.String, org.json.JSONArray, org.apache.cordova.CallbackContext):org.json.JSONObject");
    }
}
