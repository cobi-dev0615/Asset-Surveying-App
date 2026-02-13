package io.sqlc;

import android.util.Log;
import java.io.File;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SQLitePlugin extends CordovaPlugin {
    private Map<String, DBRunner> dbrmap = new ConcurrentHashMap();

    private enum Action {
        echoStringValue,
        open,
        close,
        delete,
        executeSqlBatch,
        backgroundExecuteSqlBatch
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String actionAsString, JSONArray args, CallbackContext cbc) {
        try {
            try {
                return executeAndPossiblyThrow(Action.valueOf(actionAsString), args, cbc);
            } catch (JSONException e) {
                Log.e(SQLitePlugin.class.getSimpleName(), "unexpected error", e);
                return false;
            }
        } catch (IllegalArgumentException e2) {
            Log.e(SQLitePlugin.class.getSimpleName(), "unexpected error", e2);
            return false;
        }
    }

    /* renamed from: io.sqlc.SQLitePlugin$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$sqlc$SQLitePlugin$Action;

        static {
            int[] iArr = new int[Action.values().length];
            $SwitchMap$io$sqlc$SQLitePlugin$Action = iArr;
            try {
                iArr[Action.echoStringValue.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$sqlc$SQLitePlugin$Action[Action.open.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$sqlc$SQLitePlugin$Action[Action.close.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$sqlc$SQLitePlugin$Action[Action.delete.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$sqlc$SQLitePlugin$Action[Action.executeSqlBatch.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$sqlc$SQLitePlugin$Action[Action.backgroundExecuteSqlBatch.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private boolean executeAndPossiblyThrow(Action action, JSONArray args, CallbackContext cbc) throws JSONException {
        switch (AnonymousClass1.$SwitchMap$io$sqlc$SQLitePlugin$Action[action.ordinal()]) {
            case 1:
                cbc.success(args.getJSONObject(0).getString("value"));
                break;
            case 2:
                JSONObject jSONObject = args.getJSONObject(0);
                startDatabase(jSONObject.getString("name"), jSONObject, cbc);
                break;
            case 3:
                closeDatabase(args.getJSONObject(0).getString("path"), cbc);
                break;
            case 4:
                deleteDatabase(args.getJSONObject(0).getString("path"), cbc);
                break;
            case 5:
            case 6:
                JSONObject jSONObject2 = args.getJSONObject(0);
                String string = jSONObject2.getJSONObject("dbargs").getString("dbname");
                JSONArray jSONArray = jSONObject2.getJSONArray("executes");
                if (jSONArray.isNull(0)) {
                    cbc.error("INTERNAL PLUGIN ERROR: missing executes list");
                    break;
                } else {
                    int length = jSONArray.length();
                    String[] strArr = new String[length];
                    JSONArray[] jSONArrayArr = new JSONArray[length];
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                        strArr[i] = jSONObject3.getString("sql");
                        jSONArrayArr[i] = jSONObject3.getJSONArray("params");
                    }
                    DBQuery dBQuery = new DBQuery(strArr, jSONArrayArr, cbc);
                    DBRunner dBRunner = this.dbrmap.get(string);
                    if (dBRunner != null) {
                        try {
                            dBRunner.q.put(dBQuery);
                            break;
                        } catch (Exception e) {
                            Log.e(SQLitePlugin.class.getSimpleName(), "couldn't add to queue", e);
                            cbc.error("INTERNAL PLUGIN ERROR: couldn't add to queue");
                            return true;
                        }
                    } else {
                        cbc.error("INTERNAL PLUGIN ERROR: database not open");
                        break;
                    }
                }
        }
        return true;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onDestroy() {
        while (!this.dbrmap.isEmpty()) {
            String next = this.dbrmap.keySet().iterator().next();
            closeDatabaseNow(next);
            try {
                this.dbrmap.get(next).q.put(new DBQuery());
            } catch (Exception e) {
                Log.e(SQLitePlugin.class.getSimpleName(), "INTERNAL PLUGIN CLEANUP ERROR: could not stop db thread due to exception", e);
            }
            this.dbrmap.remove(next);
        }
    }

    private void startDatabase(String dbname, JSONObject options, CallbackContext cbc) {
        if (this.dbrmap.get(dbname) != null) {
            cbc.error("INTERNAL ERROR: database already open for db name: " + dbname);
            return;
        }
        DBRunner dBRunner = new DBRunner(dbname, options, cbc);
        this.dbrmap.put(dbname, dBRunner);
        this.cordova.getThreadPool().execute(dBRunner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SQLiteAndroidDatabase openDatabase(String dbname, CallbackContext cbc, boolean old_impl) throws Exception {
        try {
            File databasePath = this.cordova.getActivity().getDatabasePath(dbname);
            if (!databasePath.exists()) {
                databasePath.getParentFile().mkdirs();
            }
            Log.v("info", "Open sqlite db: " + databasePath.getAbsolutePath());
            SQLiteAndroidDatabase sQLiteAndroidDatabase = old_impl ? new SQLiteAndroidDatabase() : new SQLiteConnectorDatabase();
            sQLiteAndroidDatabase.open(databasePath);
            if (cbc != null) {
                cbc.success();
            }
            return sQLiteAndroidDatabase;
        } catch (Exception e) {
            if (cbc != null) {
                cbc.error("can't open database " + e);
            }
            throw e;
        }
    }

    private void closeDatabase(String dbname, CallbackContext cbc) {
        DBRunner dBRunner = this.dbrmap.get(dbname);
        if (dBRunner == null) {
            if (cbc != null) {
                cbc.success();
                return;
            }
            return;
        }
        try {
            dBRunner.q.put(new DBQuery(false, cbc));
        } catch (Exception e) {
            if (cbc != null) {
                cbc.error("couldn't close database" + e);
            }
            Log.e(SQLitePlugin.class.getSimpleName(), "couldn't close database", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeDatabaseNow(String dbname) {
        SQLiteAndroidDatabase sQLiteAndroidDatabase;
        DBRunner dBRunner = this.dbrmap.get(dbname);
        if (dBRunner == null || (sQLiteAndroidDatabase = dBRunner.mydb) == null) {
            return;
        }
        sQLiteAndroidDatabase.closeDatabaseNow();
    }

    private void deleteDatabase(String dbname, CallbackContext cbc) {
        DBRunner dBRunner = this.dbrmap.get(dbname);
        if (dBRunner != null) {
            try {
                dBRunner.q.put(new DBQuery(true, cbc));
                return;
            } catch (Exception e) {
                if (cbc != null) {
                    cbc.error("couldn't close database" + e);
                }
                Log.e(SQLitePlugin.class.getSimpleName(), "couldn't close database", e);
                return;
            }
        }
        if (deleteDatabaseNow(dbname)) {
            cbc.success();
        } else {
            cbc.error("couldn't delete database");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean deleteDatabaseNow(String dbname) {
        try {
            return this.cordova.getActivity().deleteDatabase(this.cordova.getActivity().getDatabasePath(dbname).getAbsolutePath());
        } catch (Exception e) {
            Log.e(SQLitePlugin.class.getSimpleName(), "couldn't delete database", e);
            return false;
        }
    }

    private class DBRunner implements Runnable {
        private boolean bugWorkaround;
        final String dbname;
        SQLiteAndroidDatabase mydb;
        private boolean oldImpl;
        final CallbackContext openCbc;
        final BlockingQueue<DBQuery> q;

        DBRunner(final String dbname, JSONObject options, CallbackContext cbc) {
            this.dbname = dbname;
            this.oldImpl = options.has("androidOldDatabaseImplementation");
            Log.v(SQLitePlugin.class.getSimpleName(), "Android db implementation: built-in android.database.sqlite package");
            boolean z = this.oldImpl && options.has("androidBugWorkaround");
            this.bugWorkaround = z;
            if (z) {
                Log.v(SQLitePlugin.class.getSimpleName(), "Android db closing/locking workaround applied");
            }
            this.q = new LinkedBlockingQueue();
            this.openCbc = cbc;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008f -> B:24:0x00d5). Please report as a decompilation issue!!! */
        @Override // java.lang.Runnable
        public void run() {
            String str = "couldn't delete database";
            try {
                this.mydb = SQLitePlugin.this.openDatabase(this.dbname, this.openCbc, this.oldImpl);
                DBQuery dBQuery = null;
                try {
                    DBQuery take = this.q.take();
                    while (true) {
                        dBQuery = take;
                        if (dBQuery.stop) {
                            break;
                        }
                        this.mydb.executeSqlBatch(dBQuery.queries, dBQuery.jsonparams, dBQuery.cbc);
                        if (this.bugWorkaround && dBQuery.queries.length == 1 && dBQuery.queries[0] == "COMMIT") {
                            this.mydb.bugWorkaround();
                        }
                        take = this.q.take();
                    }
                } catch (Exception e) {
                    Log.e(SQLitePlugin.class.getSimpleName(), "unexpected error", e);
                }
                if (dBQuery == null || !dBQuery.close) {
                    return;
                }
                try {
                    SQLitePlugin.this.closeDatabaseNow(this.dbname);
                    SQLitePlugin.this.dbrmap.remove(this.dbname);
                    if (dBQuery.delete) {
                        try {
                            if (SQLitePlugin.this.deleteDatabaseNow(this.dbname)) {
                                dBQuery.cbc.success();
                                str = str;
                            } else {
                                dBQuery.cbc.error("couldn't delete database");
                                str = str;
                            }
                        } catch (Exception e2) {
                            Log.e(SQLitePlugin.class.getSimpleName(), str, e2);
                            CallbackContext callbackContext = dBQuery.cbc;
                            callbackContext.error("couldn't delete database: " + e2);
                            str = callbackContext;
                        }
                    } else {
                        CallbackContext callbackContext2 = dBQuery.cbc;
                        callbackContext2.success();
                        str = callbackContext2;
                    }
                } catch (Exception e3) {
                    Log.e(SQLitePlugin.class.getSimpleName(), "couldn't close database", e3);
                    if (dBQuery.cbc != null) {
                        dBQuery.cbc.error("couldn't close database: " + e3);
                    }
                }
            } catch (Exception e4) {
                Log.e(SQLitePlugin.class.getSimpleName(), "unexpected error, stopping db thread", e4);
                SQLitePlugin.this.dbrmap.remove(this.dbname);
            }
        }
    }

    private final class DBQuery {
        final CallbackContext cbc;
        final boolean close;
        final boolean delete;
        final JSONArray[] jsonparams;
        final String[] queries;
        final boolean stop;

        DBQuery(String[] myqueries, JSONArray[] params, CallbackContext c) {
            this.stop = false;
            this.close = false;
            this.delete = false;
            this.queries = myqueries;
            this.jsonparams = params;
            this.cbc = c;
        }

        DBQuery(boolean delete, CallbackContext cbc) {
            this.stop = true;
            this.close = true;
            this.delete = delete;
            this.queries = null;
            this.jsonparams = null;
            this.cbc = cbc;
        }

        DBQuery() {
            this.stop = true;
            this.close = false;
            this.delete = false;
            this.queries = null;
            this.jsonparams = null;
            this.cbc = null;
        }
    }
}
