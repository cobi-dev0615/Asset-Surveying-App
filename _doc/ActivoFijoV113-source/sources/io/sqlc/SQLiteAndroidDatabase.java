package io.sqlc;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import android.util.Log;
import barcodescanner.xservices.nl.barcodescanner.BuildConfig;
import java.io.File;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class SQLiteAndroidDatabase {
    private static final boolean isPostHoneycomb;
    File dbFile;
    boolean isTransactionActive = false;
    SQLiteDatabase mydb;
    private static final Pattern FIRST_WORD = Pattern.compile("^[\\s;]*([^\\s;]+)", 2);
    private static final Pattern WHERE_CLAUSE = Pattern.compile("\\s+WHERE\\s+(.+)$", 2);
    private static final Pattern UPDATE_TABLE_NAME = Pattern.compile("^\\s*UPDATE\\s+(\\S+)", 2);
    private static final Pattern DELETE_TABLE_NAME = Pattern.compile("^\\s*DELETE\\s+FROM\\s+(\\S+)", 2);

    enum QueryType {
        update,
        insert,
        delete,
        select,
        begin,
        commit,
        rollback,
        other
    }

    SQLiteAndroidDatabase() {
    }

    static {
        isPostHoneycomb = Build.VERSION.SDK_INT >= 11;
    }

    void open(File dbfile) throws Exception {
        if (!isPostHoneycomb) {
            Log.v("SQLiteAndroidDatabase.open", "INTERNAL PLUGIN ERROR: deprecated android.os.Build.VERSION not supported: " + Build.VERSION.SDK_INT);
            throw new RuntimeException("INTERNAL PLUGIN ERROR: deprecated android.os.Build.VERSION not supported: " + Build.VERSION.SDK_INT);
        }
        this.dbFile = dbfile;
        this.mydb = SQLiteDatabase.openOrCreateDatabase(dbfile, (SQLiteDatabase.CursorFactory) null);
    }

    void closeDatabaseNow() {
        SQLiteDatabase sQLiteDatabase = this.mydb;
        if (sQLiteDatabase != null) {
            if (this.isTransactionActive) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e) {
                    Log.v("closeDatabaseNow", "INTERNAL PLUGIN ERROR IGNORED: Not able to end active transaction before closing database: " + e.getMessage());
                    e.printStackTrace();
                }
                this.isTransactionActive = false;
            }
            this.mydb.close();
            this.mydb = null;
        }
    }

    void bugWorkaround() throws Exception {
        closeDatabaseNow();
        open(this.dbFile);
    }

    void executeSqlBatch(String[] queryarr, JSONArray[] jsonparamsArr, CallbackContext cbc) {
        if (this.mydb == null) {
            cbc.error("INTERNAL PLUGIN ERROR: database not open");
            return;
        }
        int length = queryarr.length;
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < length; i++) {
            executeSqlBatchStatement(queryarr[i], jsonparamsArr[i], jSONArray);
        }
        cbc.success(jSONArray);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:(5:(3:180|181|(17:183|24|25|26|(1:149)(12:29|30|31|32|33|34|35|36|37|(2:39|40)(1:127)|41|42)|43|(7:111|112|113|114|115|116|117)(1:45)|46|(6:99|100|101|102|103|104)|48|(8:79|80|81|82|83|85|86|87)|(5:62|63|64|65|66)|51|52|(1:54)(1:58)|55|56))|52|(0)(0)|55|56)|14|15|16|17|18|(3:20|21|22)(1:157)|23|24|25|26|(0)|149|43|(0)(0)|46|(0)|48|(0)|(0)|51) */
    /* JADX WARN: Can't wrap try/catch for region: R(25:(3:180|181|(17:183|24|25|26|(1:149)(12:29|30|31|32|33|34|35|36|37|(2:39|40)(1:127)|41|42)|43|(7:111|112|113|114|115|116|117)(1:45)|46|(6:99|100|101|102|103|104)|48|(8:79|80|81|82|83|85|86|87)|(5:62|63|64|65|66)|51|52|(1:54)(1:58)|55|56))|14|15|16|17|18|(3:20|21|22)(1:157)|23|24|25|26|(0)|149|43|(0)(0)|46|(0)|48|(0)|(0)|51|52|(0)(0)|55|56) */
    /* JADX WARN: Can't wrap try/catch for region: R(32:5|6|7|8|(3:180|181|(17:183|24|25|26|(1:149)(12:29|30|31|32|33|34|35|36|37|(2:39|40)(1:127)|41|42)|43|(7:111|112|113|114|115|116|117)(1:45)|46|(6:99|100|101|102|103|104)|48|(8:79|80|81|82|83|85|86|87)|(5:62|63|64|65|66)|51|52|(1:54)(1:58)|55|56))|10|(1:12)|13|14|15|16|17|18|(3:20|21|22)(1:157)|23|24|25|26|(0)|149|43|(0)(0)|46|(0)|48|(0)|(0)|51|52|(0)(0)|55|56) */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0273, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0275, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x027a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x027b, code lost:
    
        r11 = r10;
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0082, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0084, code lost:
    
        r0.printStackTrace();
        r0 = "constraint failure: " + r0.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x009a, code lost:
    
        android.util.Log.v("executeSqlBatch", "SQLiteStatement.executeUpdateDelete(): Error=" + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x00ac, code lost:
    
        r7 = -1;
        r10 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x027e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x027f, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0064, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0065, code lost:
    
        r0.printStackTrace();
        r0 = r0.getMessage();
        android.util.Log.v("executeSqlBatch", "SQLiteStatement.executeUpdateDelete(): Error=" + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0080, code lost:
    
        r7 = -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02a6 A[Catch: JSONException -> 0x02db, TRY_ENTER, TryCatch #11 {JSONException -> 0x02db, blocks: (B:54:0x02a6, B:58:0x02b9), top: B:52:0x02a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02b9 A[Catch: JSONException -> 0x02db, TRY_LEAVE, TryCatch #11 {JSONException -> 0x02db, blocks: (B:54:0x02a6, B:58:0x02b9), top: B:52:0x02a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0221 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void executeSqlBatchStatement(java.lang.String r22, org.json.JSONArray r23, org.json.JSONArray r24) {
        /*
            Method dump skipped, instructions count: 758
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sqlc.SQLiteAndroidDatabase.executeSqlBatchStatement(java.lang.String, org.json.JSONArray, org.json.JSONArray):void");
    }

    private final int countRowsAffectedCompat(QueryType queryType, String query, JSONArray json_params, SQLiteDatabase mydb) throws JSONException {
        Matcher matcher = WHERE_CLAUSE.matcher(query);
        String str = BuildConfig.FLAVOR;
        for (int i = 0; matcher.find(i); i = matcher.start(1)) {
            str = " WHERE " + matcher.group(1);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == '?') {
                i2++;
            }
        }
        JSONArray jSONArray = null;
        if (json_params != null) {
            jSONArray = new JSONArray();
            int length = json_params.length() - i2;
            for (int i4 = length; i4 < json_params.length(); i4++) {
                jSONArray.put(i4 - length, json_params.get(i4));
            }
        }
        if (queryType == QueryType.update) {
            Matcher matcher2 = UPDATE_TABLE_NAME.matcher(query);
            if (matcher2.find()) {
                try {
                    SQLiteStatement compileStatement = mydb.compileStatement("SELECT count(*) FROM " + matcher2.group(1) + str);
                    if (jSONArray != null) {
                        bindArgsToStatement(compileStatement, jSONArray);
                    }
                    return (int) compileStatement.simpleQueryForLong();
                } catch (Exception e) {
                    Log.e(SQLiteAndroidDatabase.class.getSimpleName(), "uncaught", e);
                }
            }
        } else {
            Matcher matcher3 = DELETE_TABLE_NAME.matcher(query);
            if (matcher3.find()) {
                try {
                    SQLiteStatement compileStatement2 = mydb.compileStatement("SELECT count(*) FROM " + matcher3.group(1) + str);
                    bindArgsToStatement(compileStatement2, jSONArray);
                    return (int) compileStatement2.simpleQueryForLong();
                } catch (Exception e2) {
                    Log.e(SQLiteAndroidDatabase.class.getSimpleName(), "uncaught", e2);
                }
            }
        }
        return 0;
    }

    private void bindArgsToStatement(SQLiteStatement myStatement, JSONArray sqlArgs) throws JSONException {
        for (int i = 0; i < sqlArgs.length(); i++) {
            if ((sqlArgs.get(i) instanceof Float) || (sqlArgs.get(i) instanceof Double)) {
                myStatement.bindDouble(i + 1, sqlArgs.getDouble(i));
            } else if (sqlArgs.get(i) instanceof Number) {
                myStatement.bindLong(i + 1, sqlArgs.getLong(i));
            } else if (sqlArgs.isNull(i)) {
                myStatement.bindNull(i + 1);
            } else {
                myStatement.bindString(i + 1, sqlArgs.getString(i));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00af, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b0, code lost:
    
        r10.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.json.JSONObject executeSqlStatementQuery(android.database.sqlite.SQLiteDatabase r9, java.lang.String r10, org.json.JSONArray r11) throws java.lang.Exception {
        /*
            r8 = this;
            java.lang.String r0 = "INTERNAL PLUGIN ERROR: deprecated android.os.Build.VERSION not supported: "
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            int r2 = r11.length()     // Catch: java.lang.Exception -> Lb9
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Exception -> Lb9
            r3 = 0
            r4 = 0
        Lf:
            int r5 = r11.length()     // Catch: java.lang.Exception -> Lb9
            if (r4 >= r5) goto L29
            boolean r5 = r11.isNull(r4)     // Catch: java.lang.Exception -> Lb9
            if (r5 == 0) goto L20
            java.lang.String r5 = ""
            r2[r4] = r5     // Catch: java.lang.Exception -> Lb9
            goto L26
        L20:
            java.lang.String r5 = r11.getString(r4)     // Catch: java.lang.Exception -> Lb9
            r2[r4] = r5     // Catch: java.lang.Exception -> Lb9
        L26:
            int r4 = r4 + 1
            goto Lf
        L29:
            android.database.Cursor r9 = r9.rawQuery(r10, r2)     // Catch: java.lang.Exception -> Lb9
            if (r9 == 0) goto Lb3
            boolean r10 = r9.moveToFirst()
            if (r10 == 0) goto Lb3
            org.json.JSONArray r10 = new org.json.JSONArray
            r10.<init>()
            int r11 = r9.getColumnCount()
        L3e:
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r4 = 0
        L44:
            if (r4 >= r11) goto L9b
            java.lang.String r5 = r9.getColumnName(r4)     // Catch: org.json.JSONException -> L9f
            boolean r6 = io.sqlc.SQLiteAndroidDatabase.isPostHoneycomb     // Catch: org.json.JSONException -> L9f
            java.lang.String r7 = "SQLiteAndroidDatabase.executeSqlStatementQuery"
            if (r6 == 0) goto L70
            r8.bindPostHoneycomb(r2, r5, r9, r4)     // Catch: java.lang.Exception -> L56 org.json.JSONException -> L9f
            int r4 = r4 + 1
            goto L44
        L56:
            r2 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> L9f
            r4.<init>()     // Catch: org.json.JSONException -> L9f
            java.lang.String r5 = "INTERNAL PLUGIN ERROR: could not bindPostHoneycomb: "
            r4.append(r5)     // Catch: org.json.JSONException -> L9f
            java.lang.String r5 = r2.getMessage()     // Catch: org.json.JSONException -> L9f
            r4.append(r5)     // Catch: org.json.JSONException -> L9f
            java.lang.String r4 = r4.toString()     // Catch: org.json.JSONException -> L9f
            android.util.Log.v(r7, r4)     // Catch: org.json.JSONException -> L9f
            throw r2     // Catch: org.json.JSONException -> L9f
        L70:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> L9f
            r2.<init>()     // Catch: org.json.JSONException -> L9f
            r2.append(r0)     // Catch: org.json.JSONException -> L9f
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: org.json.JSONException -> L9f
            r2.append(r4)     // Catch: org.json.JSONException -> L9f
            java.lang.String r2 = r2.toString()     // Catch: org.json.JSONException -> L9f
            android.util.Log.v(r7, r2)     // Catch: org.json.JSONException -> L9f
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch: org.json.JSONException -> L9f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> L9f
            r4.<init>()     // Catch: org.json.JSONException -> L9f
            r4.append(r0)     // Catch: org.json.JSONException -> L9f
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch: org.json.JSONException -> L9f
            r4.append(r5)     // Catch: org.json.JSONException -> L9f
            java.lang.String r4 = r4.toString()     // Catch: org.json.JSONException -> L9f
            r2.<init>(r4)     // Catch: org.json.JSONException -> L9f
            throw r2     // Catch: org.json.JSONException -> L9f
        L9b:
            r10.put(r2)     // Catch: org.json.JSONException -> L9f
            goto La3
        L9f:
            r2 = move-exception
            r2.printStackTrace()
        La3:
            boolean r2 = r9.moveToNext()
            if (r2 != 0) goto L3e
            java.lang.String r11 = "rows"
            r1.put(r11, r10)     // Catch: org.json.JSONException -> Laf
            goto Lb3
        Laf:
            r10 = move-exception
            r10.printStackTrace()
        Lb3:
            if (r9 == 0) goto Lb8
            r9.close()
        Lb8:
            return r1
        Lb9:
            r9 = move-exception
            r9.printStackTrace()
            java.lang.String r10 = r9.getMessage()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "SQLiteAndroidDatabase.executeSql[Batch](): Error="
            r11.append(r0)
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            java.lang.String r11 = "executeSqlBatch"
            android.util.Log.v(r11, r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sqlc.SQLiteAndroidDatabase.executeSqlStatementQuery(android.database.sqlite.SQLiteDatabase, java.lang.String, org.json.JSONArray):org.json.JSONObject");
    }

    private void bindPostHoneycomb(JSONObject row, String key, Cursor cur, int i) throws JSONException {
        int type = cur.getType(i);
        if (type == 0) {
            row.put(key, JSONObject.NULL);
            return;
        }
        if (type == 1) {
            row.put(key, cur.getLong(i));
        } else if (type == 2) {
            row.put(key, cur.getDouble(i));
        } else {
            row.put(key, cur.getString(i));
        }
    }

    static QueryType getQueryType(String query) {
        Matcher matcher = FIRST_WORD.matcher(query);
        if (matcher.find()) {
            try {
                String group = matcher.group(1);
                if (group.length() == 0) {
                    throw new RuntimeException("query not found");
                }
                return QueryType.valueOf(group.toLowerCase(Locale.ENGLISH));
            } catch (IllegalArgumentException unused) {
                return QueryType.other;
            }
        }
        throw new RuntimeException("query not found");
    }
}
